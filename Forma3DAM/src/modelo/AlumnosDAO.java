package modelo;

import controlador.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Alumnos;

public class AlumnosDAO {

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

    public Alumnos guardaAlumnos(String dniAlumno, String nombreAlumno, String yearCurso, String segSocialAlumno, int validez, String cicloAlumno, String CV) {
        Alumnos alumnos = null;
        try {
            iniciaOperacion();
            String hql = "INSERT INTO `alumnos`(`dniAlumno`, `nombreAlumno`, `yearCurso`, `segSocialAlumno`, `validez`, `cicloAlumno`, `CV`) "
                    + "VALUES (" + dniAlumno + "," + nombreAlumno + "," + yearCurso + "," + segSocialAlumno
                    + "," + validez + "," + cicloAlumno + "," + CV + ")";
            Query query = sesion.createQuery(hql);
            alumnos = (Alumnos) query.uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return alumnos;
    }

    public void actualizaAlumnos(Alumnos p) {
        try {
            iniciaOperacion();
            sesion.update(p);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminaAlumnos(Alumnos p) {
        try {
            iniciaOperacion();
            sesion.delete(p);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Alumnos obtenAlumnos(int pid) {
        Alumnos p = null;
        try {
            iniciaOperacion();
            p = (Alumnos) sesion.get(Alumnos.class, pid);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return p;
    }

    public List<Alumnos> obtenListaAlumnos() {
        List<Alumnos> listaAlumnos = null;
        try {
            iniciaOperacion();
            listaAlumnos = sesion.createQuery("from Alumnos").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaAlumnos;
    }
}
