/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nurul.dao;

import com.nurul.model.Mahasiswa;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/*
 *
 * @author nurul apriyani
 */
public class mhsDaoImpl implements mhsDao{
    private Session session; 
   
    public mhsDaoImpl(){
        try{
            session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();  
        }catch (Throwable ex) { 
           ex.printStackTrace();
        }
    }
    public void insert(Mahasiswa mhs){
        Transaction tx=null;
        try{
           tx = session.beginTransaction();
           session.save(mhs);
           tx.commit();
        }catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
    }
    
    public void update(Mahasiswa mhs){
         Transaction tx=null;
        try{
           tx = session.beginTransaction();
           session.saveOrUpdate(mhs);
           tx.commit();
        }catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        } 
    }
    
    public void delete(int id){
        Transaction tx=null;
        try{
           tx = session.beginTransaction();
           Mahasiswa mhs = (Mahasiswa) session.get(Mahasiswa.class, id);
           session.delete(mhs);
           tx.commit();
        }catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        } 
     }
    
    public Mahasiswa getMhsById(int id){
        Mahasiswa mhs=null;
        Transaction tx=null;
        try{
           tx = session.beginTransaction();
           mhs = (Mahasiswa) session.get(Mahasiswa.class, id);
           tx.commit();
        }catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
        return mhs;
     }
    
    public ArrayList<Mahasiswa> getListmhs(){
        ArrayList<Mahasiswa> listmhs=null;
        Transaction tx =null;
         try{
           listmhs= new ArrayList<Mahasiswa>();
           tx = session.beginTransaction();
           listmhs=  (ArrayList<Mahasiswa>) session.createQuery("from Mahasiswa").list();
           tx.commit();
        }catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
        return listmhs;
    }
   
    
}
