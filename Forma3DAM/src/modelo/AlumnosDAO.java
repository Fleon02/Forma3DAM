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
import raven.toast.Notifications;

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

    public int guardaAlumnos(Alumnos p) {
        int id;
        try {
            iniciaOperacion();
            id = (int) sesion.save(p);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Alumno Insertado");
            sesion.close();
        }
        return id;
    }

    public Alumnos obtenAlumnos(int id) {
        Alumnos p = null;
        try {
            iniciaOperacion();
            p = (Alumnos) sesion.get(Alumnos.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return p;
    }

    public void actualizaAlumnos(Alumnos a) {
        try {
            iniciaOperacion();
            if (a.getCv() == null || a.getCv().length == 0) {
                Alumnos alumnoExistente = (Alumnos) sesion.load(Alumnos.class, a.getIdAlumno());
                alumnoExistente.setDniAlumno(a.getDniAlumno());
                alumnoExistente.setNombreAlumno(a.getNombreAlumno());
                alumnoExistente.setYearCurso(a.getYearCurso());
                alumnoExistente.setSegSocialAlumno(a.getSegSocialAlumno());
                alumnoExistente.setValidez(a.getValidez());
                alumnoExistente.setCicloAlumno(a.getCicloAlumno());
                sesion.update(alumnoExistente);
            } else {
                sesion.update(a);
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Alumno Actualizado");
            sesion.close();
        }
    }

    public void eliminaAlumnos(String dniAlumno) {
        try {
            iniciaOperacion();
            String hql = "UPDATE Alumnos SET idAlumno = -idAlumno WHERE dniAlumno = :dniAlumno";
            int valor = sesion.createQuery(hql).setParameter("dniAlumno", dniAlumno).executeUpdate();
            if (valor == 1) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Alumno Marcado como Borrado");
            } else {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Alumno No Marcado como Borrado");
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public List<Alumnos> obtenListaAlumnos() {
        List<Alumnos> listaAlumnos = null;
        try {
            iniciaOperacion();
            listaAlumnos = sesion.createQuery("from Alumnos where idAlumno > 0").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaAlumnos;
    }

    public Alumnos obtenAlumnosPorID(Integer idAlumno) {
        Alumnos a;
        Query query;
        try {
            iniciaOperacion();
            String hql = "from Alumnos where idAlumno = :idAlumno";
            query = sesion.createQuery(hql).setParameter("idAlumno", idAlumno);
            a = (Alumnos) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return a;
    }

    public Alumnos obtenAlumnosPorDNI(String dniAlumno) {
        Alumnos a;
        Query query;
        try {
            iniciaOperacion();
            String hql = "from Alumnos where dniAlumno = :dniAlumno AND idAlumno > 0";
            query = sesion.createQuery(hql).setParameter("dniAlumno", dniAlumno);
            a = (Alumnos) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return a;
    }
}
