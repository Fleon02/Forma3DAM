package modelo;

import controlador.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Anexos;

public class AnexosDAO {

    private Session sesion;

    private void iniciaOperacion() throws HibernateException {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        sesion.getTransaction().rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }

    public List<Anexos> obtenerAnexos() throws HibernateException {
        List<Anexos> listaAnexos = null;
        try {
            iniciaOperacion();
            Query query = sesion.createQuery("FROM Anexos");
            listaAnexos = query.list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return listaAnexos;
    }

    public boolean insertarAnexo(Anexos nuevoAnexo) {
        Transaction tx = null;
        try {
            iniciaOperacion();
            tx = sesion.beginTransaction();
            sesion.save(nuevoAnexo);
            tx.commit();
            return true;
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            manejaExcepcion(he);
            return false;
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
}
