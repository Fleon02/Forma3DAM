package modelo;

import controlador.HibernateUtil;
import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Alumnos;
import raven.toast.Notifications;

public class AlumnosDAO {

    private Session sesion;
    private Transaction tx;
    Component parentComponent = null;

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
            sesion.close();
        }
        return id;
    }

    public void guardaAlumno(String dniAlumno, String nombreAlumno, String yearCurso, String segSocialAlumno, int validez, String cicloAlumno, byte[] cv) {
        try {
            iniciaOperacion();
            String hql = "INSERT INTO alumnos(dniAlumno, nombreAlumno, yearCurso, segSocialAlumno, validez, cicloAlumno, CV)"
                    + " VALUES (:dniAlumno,:nombreAlumno,:yearCurso,:segSocialAlumno,:validez,:cicloAlumno,:cv)";
            int valor = sesion.createSQLQuery(hql)
                    .setParameter("dniAlumno", dniAlumno)
                    .setParameter("nombreAlumno", nombreAlumno)
                    .setParameter("yearCurso", yearCurso)
                    .setParameter("segSocialAlumno", segSocialAlumno)
                    .setParameter("validez", validez)
                    .setParameter("cicloAlumno", cicloAlumno)
                    .setParameter("cv", cv)
                    .executeUpdate();
            if (valor == 1) {
                JOptionPane.showMessageDialog(parentComponent, "Alumno Insertado", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Alumno No Insertado", "Error", JOptionPane.ERROR_MESSAGE);
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
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
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Alumno Actualizado con exito");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminaAlumnos(String dniAlumno) {
        try {
            iniciaOperacion();
            String hql = "UPDATE Alumnos SET idAlumno = -idAlumno WHERE dniAlumno = :dniAlumno";
            int valor = sesion.createQuery(hql).setParameter("dniAlumno", dniAlumno).executeUpdate();
            if (valor == 1) {
                JOptionPane.showMessageDialog(parentComponent, "Alumno Marcado como Borrado", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Alumno No Marcado como Borrado", "Error", JOptionPane.ERROR_MESSAGE);
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
