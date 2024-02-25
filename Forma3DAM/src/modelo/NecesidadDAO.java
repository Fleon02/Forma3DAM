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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
}
