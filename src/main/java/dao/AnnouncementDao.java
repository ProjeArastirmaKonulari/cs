/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import modele.Announcement;
import modele.Client;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class AnnouncementDao {
    public void create(Announcement a){
        EntityManager em= JpaUtil.obtenirEntityManager();
        em.persist(a);  
    }    
    public Announcement findById(Long id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        return em.find(Announcement.class, id);
    }
    public void persist(Announcement a){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(a);
    }

}
