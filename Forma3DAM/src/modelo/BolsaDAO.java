package modelo;

import controlador.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Alumnos;
import pojos.Bolsa;
import raven.toast.Notifications;

public class BolsaDAO {

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

    public List<Alumnos> obtenListaAlumnosConInformeFinal() {
        List<Alumnos> listaAlumnos = null;
        Query query;
        try {
            iniciaOperacion();
            String hql = "SELECT DISTINCT a FROM pojos.Alumnos a JOIN a.practicases p WHERE p.informeFinal IS NOT NULL";
            query = sesion.createQuery(hql);
            listaAlumnos = query.list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaAlumnos;
    }

    public void guardaEnBolsa(Bolsa b) {
        try {
            iniciaOperacion();
            sesion.save(b);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            JOptionPane.showMessageDialog(null, "Bolsa Insertada", "Bolsa Insertada", JOptionPane.INFORMATION_MESSAGE);
            sesion.close();
        }
    }

    public List<Bolsa> obtenListaBolsa() {
        List<Bolsa> listaBolsa = null;
        try {
            iniciaOperacion();
            listaBolsa = sesion.createQuery("from Bolsa").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaBolsa;
    }

    public void eliminaBolsa(String idBolsa, JFrame jframe) {
        try {
            int bolsaId = Integer.parseInt(idBolsa);
            iniciaOperacion();
            String hql = "UPDATE Bolsa SET idBolsa = -idBolsa WHERE idBolsa = :idBolsa";
            int valor = sesion.createQuery(hql).setParameter("idBolsa", bolsaId).executeUpdate();
            if (valor == 1) {
                Notifications.getInstance().setJFrame(jframe);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 2500, "Bolsa Eliminada");
            } else {
                Notifications.getInstance().setJFrame(jframe);
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 2500, "Bolsa No Eliminada");
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Bolsa obtenBolsaPorID(int idBolsa) {
        Bolsa b = null;
        try {
            iniciaOperacion();
            b = (Bolsa) sesion.get(Bolsa.class, idBolsa);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return b;
    }

    public void actualizaBolsa(Bolsa bolsa, JFrame jframe) {
        try {
            iniciaOperacion();
            sesion.update(bolsa);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            Notifications.getInstance().setJFrame(jframe);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 2500, "Bolsa Actualizada");
            sesion.close();
        }
    }

    public void refresh(Bolsa bolsa) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.refresh(bolsa);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

}
