/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import modele.Task;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class TaskDao {
    public TaskDao(){}
    public void create(Task t){
        EntityManager em= JpaUtil.obtenirEntityManager();
        em.persist(t);  
    }    
    public Task findById(Long id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        return em.find(Task.class, id);
    }
    public void persist(Task t){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(t);
    }

}
