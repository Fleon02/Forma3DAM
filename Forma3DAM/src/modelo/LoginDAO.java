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

    public Login iniciarSesion(String correoUsuario) throws HibernateException {
        Login usuario = null;
        try {
            iniciaOperacion();
            Query query = sesion.createQuery("FROM Login l JOIN FETCH l.beep b WHERE l.correoUsuario = :correoUsuario");
            query.setParameter("correoUsuario", correoUsuario);
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

    public Boolean registrarUsuario(Login usuario, String hashcontrasena, String salt) {
        boolean registroExitoso;
        try {
            iniciaOperacion();
            Beep beep = new Beep();
            beep.setHashContrasena(hashcontrasena);
            beep.setSalt(salt);
            beep.setLogin(usuario);
            sesion.save(beep);
            usuario.setBeep(beep);
            sesion.save(usuario);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            registroExitoso = true;
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
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
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Usuario Actualizado");
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
            Login loginEnDB = (Login) sesion.get(Login.class, usuario.getIdUsuario());
            if (loginEnDB != null) {
                Beep beep = loginEnDB.getBeep();
                if (beep != null) {
                    sesion.delete(beep);
                }
                sesion.delete(loginEnDB);
            }
            tx.commit();
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Usuario Borrado");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
}
