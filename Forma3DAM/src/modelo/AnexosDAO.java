package modelo;

import controlador.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Anexos;
import pojos.Necesidad;
import raven.toast.Notifications;

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

    public Anexos obtenAnexos(int id) {
        Anexos p = null;
        try {
            iniciaOperacion();
            p = (Anexos) sesion.get(Anexos.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return p;
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
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Anexo Insertado");
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
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Anexo Insertado");
            sesion.close();
        }
    }

    public void eliminaAnexo(Anexos a, JFrame jframe) {
        try {
            iniciaOperacion();
            int idAnexo = a.getIdAnexo();
            int idAnexoNegativo = -idAnexo;
            Query query = sesion.createQuery("UPDATE Anexos SET idAnexo = :idNegativo WHERE idAnexo = :id");
            query.setParameter("idNegativo", idAnexoNegativo);
            query.setParameter("id", idAnexo);
            int result = query.executeUpdate();
            tx.commit();
            if (result > 0) {
                Notifications.getInstance().setJFrame(jframe);
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Anexo Marcado como Borrado");
            } else {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Anexo No Marcado como Borrado");
            }
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
            Query query = sesion.createQuery("FROM Anexos a JOIN FETCH a.empresas JOIN FETCH a.necesidad ORDER BY idAnexo ASC");
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

    public Anexos obtenAnexoPorID(int idAnexo) {
        Anexos a = null;
        try {
            iniciaOperacion();
            a = (Anexos) sesion.createQuery("from Anexos where idAnexo = :cifEmpresa").setParameter("cifEmpresa", idAnexo).uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return a;
    }
}
