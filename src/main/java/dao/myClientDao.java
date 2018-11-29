/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import modele.Client;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class myClientDao {
    public void create(Client c){
        EntityManager em= JpaUtil.obtenirEntityManager();
        em.persist(c);
       
    }
    
    public Client findById(Long id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        return em.find(Client.class, id);
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
