package modelo;

import controlador.HibernateUtil;
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

    private void iniciaOperacion() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }

    public void guardaEmpresas(Empresas p) {
        try {
            iniciaOperacion();
            sesion.save(p);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Empresas obtenEmpresas(int id) {
        Empresas p = null;
        try {
            iniciaOperacion();
            p = (Empresas) sesion.get(Empresas.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return p;
    }

    public void actualizaEmpresas(Empresas a) {
        try {
            iniciaOperacion();
            sesion.update(a);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Empresa Actualizada");
            sesion.close();
        }
    }

    public void eliminaEmpresas(String cifEmpresa) {
        try {
            iniciaOperacion();
            String hql = "UPDATE Empresas SET idEmpresa = -1 WHERE cifEmpresa = :cifEmpresa";
            int valor = sesion.createQuery(hql).setParameter("cifEmpresa", cifEmpresa).executeUpdate();
            if (valor == 1) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Empresa Marcada como Borrada");
            } else {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Empresa Marcada como Borrada");
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

    public String obtenCIF(Empresas empresas) {
        String cif = null;
        try {
            iniciaOperacion();
            // Obtenemos el CIF de la empresa
            cif = empresas.getCifEmpresa();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return cif;
    }

    public String obtenerNombreEmpresaPorCIF(String cif) {
        String nombreEmpresa = null;
        try {
            iniciaOperacion();
            // Consulta para obtener el nombre de la empresa dado un CIF
            nombreEmpresa = (String) sesion.createQuery("select nombreEmpresa from Empresas where cifEmpresa = :cif")
                    .setParameter("cif", cif)
                    .uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return nombreEmpresa;
    }

    public Empresas obtenerEmpresaPorNombre(String nombreEmpresa) {
        Empresas empresa = null;
        try {
            iniciaOperacion();
            empresa = (Empresas) sesion.createQuery("FROM Empresas WHERE nombreEmpresa = :nombre")
                    .setParameter("nombre", nombreEmpresa)
                    .uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return empresa;
    }

    public Empresas obtenEmpresaPorID(String text) {
        Empresas e = null;
        //int idEmpresa = Integer.parseInt(text);
        try {
            iniciaOperacion();
            // Consulta para obtener el nombre de la empresa dado un CIF
            e = (Empresas) sesion.createQuery("from Empresas where cifEmpresa = :cifEmpresa")
                    .setParameter("cifEmpresa", text)
                    .uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return e;
    }

    public Empresas obtenEmpresaPorID2(String text) {
        Empresas e = null;
        int idEmpresa = Integer.parseInt(text);
        try {
            iniciaOperacion();
            // Consulta para obtener el nombre de la empresa dado un CIF
            e = (Empresas) sesion.createQuery("from Empresas where idEmpresa = :cifEmpresa")
                    .setParameter("cifEmpresa", idEmpresa)
                    .uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return e;
    }

    public Empresas obtenEmpresaPorTutor(String tutor) {
        Empresas e = null;
        try {
            iniciaOperacion();
            // Consulta para obtener el nombre de la empresa dado un CIF
            e = (Empresas) sesion.createQuery("from Empresas where tutorPracticas = :cifEmpresa")
                    .setParameter("cifEmpresa", tutor)
                    .uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return e;
    }

}
