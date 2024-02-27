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
import pojos.Necesidad;

public class AnexosDAO {

    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
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

    public List<Necesidad> obtenListaNecesidad() {

        List<Necesidad> listaNecesidad = null;
        try {
            iniciaOperacion();
            listaNecesidad = sesion.createQuery("from Necesidad").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            // Cerrar la sesión aquí solo si no se produce una excepción
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaNecesidad;

    }

    public void guardaAnexo(Anexos a) {
        try {
            iniciaOperacion();
            sesion.save(a);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public List<Anexos> obtenListaAnexos() {
        List<Anexos> listaAnexos = null;
        try {
            iniciaOperacion();
            Query query = sesion.createQuery("FROM Anexos a JOIN FETCH a.empresas JOIN FETCH a.necesidad");
            listaAnexos = query.list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaAnexos;
    }

}
