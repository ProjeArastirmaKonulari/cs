/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.Client;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class ClientDao {
    public void create(Client c){
        EntityManager em= JpaUtil.obtenirEntityManager();
        em.persist(c);  
    }    
    public Client findById(Long id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        System.out.println("YYYYY "+id);
        return em.find(Client.class, id);
    }
    public Client findByMail(String mail){
        EntityManager em = JpaUtil.obtenirEntityManager();
        
        Query q = em.createQuery("select c from Client c where c.mail=:new_mail", Client.class);
        q.setParameter("new_mail", mail);
        
        List results = q.getResultList();
        if(!results.isEmpty()){
            return (Client) results.get(0);
        }
        return null;
    }
    public void persist(Client cl){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(cl);
    }
    public void merge(Client cl){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.merge(cl);
    }
    public void refresh(Client cl){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.refresh(cl);
    }
    public void remove(Client cl){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.remove(cl);
    }
    
}
