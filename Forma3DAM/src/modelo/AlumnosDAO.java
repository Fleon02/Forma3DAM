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

    public void guardaAlumnos(String dniAlumno, String nombreAlumno, String yearCurso, String segSocialAlumno, int validez, String cicloAlumno, byte[] cv) {
        try {
            iniciaOperacion();
            String hql = "INSERT INTO alumnos(dniAlumno, nombreAlumno, yearCurso, segSocialAlumno, validez, cicloAlumno, CV)"
                    + " VALUES (:dniAlumno,:nombreAlumno,:yearCurso,:segSocialAlumno,:validez,:cicloAlumno,:cv)";
            int valor = 0;
            if (cv != null) {
                valor = sesion.createSQLQuery(hql)
                        .setParameter("dniAlumno", dniAlumno)
                        .setParameter("nombreAlumno", nombreAlumno)
                        .setParameter("yearCurso", yearCurso)
                        .setParameter("segSocialAlumno", segSocialAlumno)
                        .setParameter("validez", validez)
                        .setParameter("cicloAlumno", cicloAlumno)
                        .setParameter("cv", cv)
                        .executeUpdate();
            } else {
                valor = sesion.createSQLQuery(hql)
                        .setParameter("dniAlumno", dniAlumno)
                        .setParameter("nombreAlumno", nombreAlumno)
                        .setParameter("yearCurso", yearCurso)
                        .setParameter("segSocialAlumno", segSocialAlumno)
                        .setParameter("validez", validez)
                        .setParameter("cicloAlumno", cicloAlumno)
                        .executeUpdate();
            }
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

    public void actualizaAlumnos(String dniAlumno, String nombreAlumno, String yearCurso, String segSocialAlumno, int validez, String cicloAlumno, byte[] cv) {
        try {
            iniciaOperacion();
            String hql = "UPDATE alumnos dniAlumno=:dniAlumno, nombreAlumno=:nombreAlumno, yearCurso=:yearCurso, "
                    + "segSocialAlumno=:segSocialAlumno, validez=:validez, cicloAlumno=:cicloAlumno, cv=:cv WHERE dniAlumno=:dniAlumno";
            int valor = 0;
            if (cv != null) {
                valor = sesion.createSQLQuery(hql)
                        .setParameter("dniAlumno", dniAlumno)
                        .setParameter("nombreAlumno", nombreAlumno)
                        .setParameter("yearCurso", yearCurso)
                        .setParameter("segSocialAlumno", segSocialAlumno)
                        .setParameter("validez", validez)
                        .setParameter("cicloAlumno", cicloAlumno)
                        .setParameter("cv", cv)
                        .executeUpdate();
            } else {
                valor = sesion.createSQLQuery(hql)
                        .setParameter("dniAlumno", dniAlumno)
                        .setParameter("nombreAlumno", nombreAlumno)
                        .setParameter("yearCurso", yearCurso)
                        .setParameter("segSocialAlumno", segSocialAlumno)
                        .setParameter("validez", validez)
                        .setParameter("cicloAlumno", cicloAlumno)
                        .executeUpdate();
            }
            if (valor == 1) {
                JOptionPane.showMessageDialog(parentComponent, "Alumno Actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Alumno No Actualizado", "Error", JOptionPane.ERROR_MESSAGE);
            }
            tx.commit();
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
            String hql = "DELETE FROM alumnos WHERE dniAlumno=:dniAlumno";
            int valor = sesion.createSQLQuery(hql).setParameter("dniAlumno", dniAlumno).executeUpdate();
            if (valor == 1) {
                JOptionPane.showMessageDialog(parentComponent, "Alumno Borrado", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Alumno No Borrado", "Error", JOptionPane.ERROR_MESSAGE);
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
