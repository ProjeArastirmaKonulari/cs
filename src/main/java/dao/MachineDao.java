/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import modele.Machine;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class MachineDao {
    public void create(Machine m){
        EntityManager em= JpaUtil.obtenirEntityManager();
//        while(m.getPropertyList()!=null){
            em.persist(m.getPropertyList().get(0));
  //      }
        em.persist(m);
    }

}
