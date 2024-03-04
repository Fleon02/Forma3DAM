package modelo;

import controlador.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Practicas;
import raven.toast.Notifications;

public class PracticasDAO {

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

    public int guardaPracticas(Practicas p) {
        int id;
        try {
            iniciaOperacion();
            id = (int) sesion.save(p);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            JOptionPane.showMessageDialog(null, "Practica Insertada", "Practica Insertada", JOptionPane.INFORMATION_MESSAGE);
            sesion.close();
        }
        return id;
    }

    public Practicas obtenPracticas(int id) {
        Practicas p = null;
        try {
            iniciaOperacion();
            p = (Practicas) sesion.get(Practicas.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return p;
    }

    public void actualizaPracticas(Practicas a, JFrame jframe) {
        try {
            iniciaOperacion();
            if (a.getInformeSeguimiento() == null || a.getInformeSeguimiento().length == 0
                    || a.getInformeFinal() == null || a.getInformeFinal().length == 0) {
                Practicas pExistente = (Practicas) sesion.load(Practicas.class, a.getIdPractica());
                pExistente.setAlumnos(a.getAlumnos());
                pExistente.setEmpresas(a.getEmpresas());
                pExistente.setAnexos(a.getAnexos());
                pExistente.setInformeSeguimiento(a.getInformeSeguimiento());
                pExistente.setInformeFinal(a.getInformeFinal());
                pExistente.setHorarioEntrada(a.getHorarioEntrada());
                pExistente.setHorarioSalida(a.getHorarioSalida());
                sesion.update(pExistente);
            } else {
                sesion.update(a);
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            Notifications.getInstance().setJFrame(jframe);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 2500, "Practica Actualizada");
            sesion.close();
        }
    }

    public void eliminaPracticas(int idPractica, JFrame jframe) {
        try {
            iniciaOperacion();
            String hql = "UPDATE Practicas SET idPractica = -idPractica WHERE idPractica = :idPractica";
            int valor = sesion.createQuery(hql).setParameter("idPractica", idPractica).executeUpdate();
            if (valor == 1) {
                Notifications.getInstance().setJFrame(jframe);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 2500, "Practica Marcada como Borrada");
            } else {
                Notifications.getInstance().setJFrame(jframe);
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 2500, "Practica No Marcada como Borrada");
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public List<Practicas> obtenListaPracticas() {
        List<Practicas> listaPracticas = null;
        try {
            iniciaOperacion();
            listaPracticas = sesion.createQuery("from Practicas").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaPracticas;
    }
}
