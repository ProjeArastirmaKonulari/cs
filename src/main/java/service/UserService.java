/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MachineDao;
import dao.myClientDao;
import modele.Machine;
import modele.myClient;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class UserService {
    private myClientDao myClientDao;
    private MachineDao machineDao;
    public UserService() {
        myClientDao = new myClientDao();
        machineDao = new MachineDao();
    }
    public void inscriptionClient(myClient c){
        //Persister le nouveau client
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        myClientDao.create(c);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        
    }
    public void newMachine(Machine m){
        //Persister le nouveau client
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        machineDao.create(m);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        
    }
}