package modelo;

import controlador.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Login;

public class LoginDAO {

    private Session sesion;

    private void iniciaOperacion() throws HibernateException {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        sesion.getTransaction().rollback();
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

}
