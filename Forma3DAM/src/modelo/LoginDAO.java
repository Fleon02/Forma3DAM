package modelo;

import controlador.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Beep;
import pojos.Login;
import raven.toast.Notifications;

public class LoginDAO {

    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }

    public List<Login> obtenListaUsuarios() {
        List<Login> listaUsuarios = null;
        try {
            iniciaOperacion();
            listaUsuarios = sesion.createQuery("from Login").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaUsuarios;
    }

    public Login iniciarSesion(String correoUsuario, String contrasena) throws HibernateException {
        Login usuario = null;
        try {
            iniciaOperacion();
            // Modificar la consulta HQL para unir la tabla Login con la tabla Beep y filtrar por la contraseña
            String hql = "FROM Login l JOIN FETCH l.beep b WHERE l.correoUsuario = :correoUsuario AND b.contrasena = :contrasena";
            Query query = sesion.createQuery(hql);
            query.setParameter("correoUsuario", correoUsuario);
            query.setParameter("contrasena", contrasena);
            usuario = (Login) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return usuario;
    }

    public Boolean registrarUsuario(Login usuario, String contrasena) {
        boolean registroExitoso;
        try {
            // Iniciamos la transacción
            iniciaOperacion();

            // Creamos el objeto Beep con la contraseña y lo guardamos
            Beep beep = new Beep();
            beep.setContrasena(contrasena);
            beep.setLogin(usuario);
            sesion.save(beep);

            // Asociamos el Beep al usuario y lo guardamos
            usuario.setBeep(beep);
            sesion.save(usuario);

            // Confirmamos la transacción
            tx.commit();

            // Mostramos un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            registroExitoso = true;
        } catch (HibernateException he) {
            // En caso de error, revertimos la transacción
            if (tx != null) {
                tx.rollback();
            }
            // Mostramos un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al registrar usuario", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            registroExitoso = false;
            he.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return registroExitoso;
    }

    public void actualizaUsuario(Login l) {
        try {
            iniciaOperacion();
            sesion.update(l);
            tx.commit();
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Usuario Actualizado con exito");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminarUsuario(Login usuario) {
        try {
            iniciaOperacion();

            // Buscamos el Login en la base de datos para obtener su identificador y luego obtener su Beep asociado
            Login loginEnDB = (Login) sesion.get(Login.class, usuario.getIdUsuario());
            if (loginEnDB != null) {
                Beep beep = loginEnDB.getBeep();
                if (beep != null) {
                    // Eliminamos el Beep asociado al Login
                    sesion.delete(beep);
                }
                // Eliminamos el Login
                sesion.delete(loginEnDB);
            }

            tx.commit();
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Usuario eliminado con éxito");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

}
