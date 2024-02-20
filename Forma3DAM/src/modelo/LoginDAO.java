package modelo;

import controlador.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Beep;
import pojos.Login;

public class LoginDAO {

    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
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

    public void registrarUsuario(Login usuario, String contrasena) {
        try {
            iniciaOperacion();
            // Crear el objeto Beep con la contraseña y guardarlo
            Beep beep = new Beep();
            beep.setContrasena(contrasena);
            sesion.save(beep);
            // Asociar el Beep al usuario y guardar el usuario
            usuario.setBeep(beep);
            sesion.save(usuario);
            tx.commit();
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            manejaExcepcion(he);
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(null, "Error al registrar usuario", "Error de Registro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sesion.close();
        }
    }
}
