/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Alumnos;
import pojos.Bolsa;

/**
 *
 * @author Usuario
 */
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
            String hql = "SELECT DISTINCT a FROM pojos.Alumnos a\n" +
                        "JOIN a.practicases p\n" +
                        "WHERE p.informeFinal IS NOT NULL";
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
        try
        {
            iniciaOperacion();
            sesion.save(b);
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

    public void eliminaBolsa(String idBolsa) {
        try
        {
            int bolsaId = Integer.parseInt(idBolsa);
            iniciaOperacion();
            String hql = "UPDATE Bolsa SET idBolsa = -idBolsa WHERE idBolsa = :idBolsa";
            int valor = sesion.createQuery(hql).setParameter("idBolsa", bolsaId).executeUpdate();
            if (valor == 1)
            {
                //JOptionPane.showMessageDialog(parentComponent, "Alumno Marcado como Borrado", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else
            {
                //JOptionPane.showMessageDialog(parentComponent, "Alumno No Marcado como Borrado", "Error", JOptionPane.ERROR_MESSAGE);
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

    public void actualizaBolsa(Bolsa bolsa) {
        try {
        iniciaOperacion();
        sesion.update(bolsa);
        tx.commit();
    } catch (HibernateException he) {
        manejaExcepcion(he);
        throw he;
    } finally {
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
            e.printStackTrace(); // Handle or log the exception as needed
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    
}
