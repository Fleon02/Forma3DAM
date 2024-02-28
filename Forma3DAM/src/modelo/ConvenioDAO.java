package modelo;

import controlador.HibernateUtil;
import java.awt.Component;
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
import pojos.Convenio;
import pojos.Empresas;
import raven.toast.Notifications;

public class ConvenioDAO {

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

    public List<Convenio> obtenListaConvenios() {
        List<Convenio> listaConvenios = null;
        try {
            iniciaOperacion();
            listaConvenios = sesion.createQuery("from Convenio").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            // Cerrar la sesión aquí solo si no se produce una excepción
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaConvenios;
    }

    public void guardaConvenio(Convenio convenio) {
        try {
            iniciaOperacion();
            sesion.save(convenio);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminarConvenio(Convenio convenio, JFrame jframe) {
        try {
            iniciaOperacion();

            // Obtener el idConvenio y convertirlo a negativo
            int idConvenio = convenio.getIdConvenio();
            int idConvenioNegativo = -idConvenio;

            Query query = sesion.createQuery("UPDATE Convenio SET idConvenio = :idNegativo WHERE idConvenio = :id");
            query.setParameter("idNegativo", idConvenioNegativo);
            query.setParameter("id", idConvenio);
            int result = query.executeUpdate();
            tx.commit();

            if (result > 0) {
                Notifications.getInstance().setJFrame(jframe);
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Convenio marcado como borrado");
            } else {
                JOptionPane.showMessageDialog(jframe, "El convenio no se encontró", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void actualizarConvenio(Convenio convenio, JFrame jframe) {
        try {
            iniciaOperacion();

            // Verificar si se proporciona un nuevo anexo
            if (convenio.getAnexoUnoConvenio() == null || convenio.getAnexoUnoConvenio().length == 0) {
                // Si no se proporciona un nuevo anexo, cargar el convenio existente desde la base de datos
                Convenio convenioExistente = (Convenio) sesion.load(Convenio.class, convenio.getIdConvenio());

                // Copiar los valores relevantes del nuevo convenio al convenio existente
                convenioExistente.setNumConvenio(convenio.getNumConvenio());
                convenioExistente.setNombreEmpresa(convenio.getNombreEmpresa());
                convenioExistente.setResponsableFirma(convenio.getResponsableFirma());
                convenioExistente.setCantAnexos(convenio.getCantAnexos());

                // Actualizar el convenio en la base de datos
                sesion.update(convenioExistente);
            } else {
                // Si se proporciona un nuevo anexo, simplemente actualizar el convenio en la base de datos
                sesion.update(convenio);
            }

            tx.commit();

            Notifications.getInstance().setJFrame(jframe);
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, 2500, "Convenio actualizado con éxito");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public int obtenerCantidadPracticasPorEmpresa(Empresas empresa) {
        try {
            iniciaOperacion();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM Practicas p WHERE p.empresas.idEmpresa = :idEmpresa");

            query.setParameter("idEmpresa", empresa.getIdEmpresa());
            Long count = (Long) query.uniqueResult();
            return count != null ? count.intValue() : 0;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

}
