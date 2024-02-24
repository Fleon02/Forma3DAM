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
import pojos.Empresas;
import raven.toast.Notifications;

public class EmpresasDAO {

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

    public int guardaEmpresas(Empresas p) {
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

    public void actualizaEmpresas(Empresas a) {
        try {
            iniciaOperacion();
            sesion.update(a);
            tx.commit();
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Alumno Actualizado con exito");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminaEmpresas(String cifEmpresa) {
        try {
            iniciaOperacion();
            String hql = "UPDATE Empresas SET idAlumno = -1 WHERE cifEmpresa = :cifEmpresa";
            int valor = sesion.createQuery(hql).setParameter("cifEmpresa", cifEmpresa).executeUpdate();
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

    public List<Empresas> obtenListaEmpresas() {
        List<Empresas> listaEmpresas = null;
        try {
            iniciaOperacion();
            listaEmpresas = sesion.createQuery("from Empresas").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaEmpresas;
    }
}