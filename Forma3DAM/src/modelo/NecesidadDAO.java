/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.HibernateUtil;
import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Empresas;
import pojos.Necesidad;

/**
 *
 * @author Usuario
 */
public class NecesidadDAO {

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

    public List<Necesidad> obtenListaNecesidad() {
        List<Necesidad> listaNecesidades = null;
        Query query;
        try
        {
            iniciaOperacion();
            query = sesion.createQuery("FROM Necesidad n LEFT JOIN FETCH n.empresas");
            listaNecesidades = query.list();
        } catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        } finally
        {
            sesion.close();
        }
        return listaNecesidades;
    }

    public void actualizarNecesidad(Necesidad n) {
        try
        {
            iniciaOperacion();
            sesion.update(n);
            tx.commit();
        } catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        } finally
        {
            sesion.close();
        }
    }

    public void eliminaNecesidad(String cifempresa) {
        Empresas empresas = new Empresas(cifempresa);
        try
        {
            iniciaOperacion();
            String hql = "UPDATE Necesidad SET idNecesidad = -1 WHERE empresas = :empresas";
            int valor = sesion.createQuery(hql).setParameter("empresas", empresas).executeUpdate();
            if (valor == 1)
            {
                JOptionPane.showMessageDialog(parentComponent, "Necesidad Marcada como Borrada", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else
            {
                JOptionPane.showMessageDialog(parentComponent, "Necesidad No Marcada como Borrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
            tx.commit();
        } catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        } finally
        {
            sesion.close();
        }
    }

    public void guardaNecesidad(Necesidad n) {
        try
        {
            iniciaOperacion();
            sesion.save(n);
            tx.commit();
        } catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        } finally
        {
            sesion.close();
        }
    }

    public Necesidad obtenerNecesidadPorId(int id) {
        Necesidad n = null;
        Query query;
        try
        {
            iniciaOperacion();
            query = sesion.createQuery("FROM Necesidad where idNecesidad = :necesidad").setParameter("necesidad", id);
            n = (Necesidad) query.uniqueResult();
        } catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        } finally
        {
            if (sesion != null && sesion.isOpen())
            {
                sesion.close();
            }
        }
        return n;
    }

    public List<Object[]> obtenNecesidadesDeEmpresa(Empresas empresa) {
        List<Object[]> listaNecesidades = null;
        Query query;
        int idEmpresa = empresa.getIdEmpresa();
        try{
            iniciaOperacion();
            String hql = "SELECT n.dam, n.daw, n.asir, n.mark, n.fin FROM Necesidad n WHERE n.empresas.idEmpresa = :idEmpresa";
            query = sesion.createQuery(hql);
            query.setParameter("idEmpresa", idEmpresa);

            List<Object[]> necesidads = query.list();
            for (Object[] necesidad : listaNecesidades)
            {
                Integer dam = (Integer) necesidad[0];
                Integer daw = (Integer) necesidad[1];
                Integer asir = (Integer) necesidad[2];
                Integer mark = (Integer) necesidad[3];
                Integer fin = (Integer) necesidad[4];
            }
            }catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }finally {
            sesion.close();
        }
            return listaNecesidades;

        }

    }
