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
    
    public List<Necesidad> obtenListaNecesidad(){
        List<Necesidad> listaNecesidades = null;
        Query query;
        try{
            iniciaOperacion();
            query = sesion.createQuery("FROM Necesidad");
            listaNecesidades = query.list();
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return listaNecesidades;
    }

    public void actualizarNecesidad(Necesidad n) {        
        try{
            iniciaOperacion();
            sesion.update(n);
            tx.commit();
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }        
    }

    public void eliminaNecesidad(String cifempresa) {
        Empresas empresas = new Empresas(cifempresa);
        try {
            iniciaOperacion();            
            String hql = "UPDATE Necesidad SET idNecesidad = -1 WHERE empresas = :empresas";
            int valor = sesion.createQuery(hql).setParameter("empresas", empresas).executeUpdate();
            if (valor == 1) {
                JOptionPane.showMessageDialog(parentComponent, "Necesidad Marcada como Borrada", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Necesidad No Marcada como Borrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void guardaNecesidad(Necesidad n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
