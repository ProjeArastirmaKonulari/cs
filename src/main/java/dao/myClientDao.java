/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import modele.myClient;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class myClientDao {
    public void create(myClient c){
        EntityManager em= JpaUtil.obtenirEntityManager();
        em.persist(c);
       
    }
}
