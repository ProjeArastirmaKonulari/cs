/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MachineDao;
import dao.ClientDao;
import modele.Machine;
import modele.Client;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class UserService {
    private ClientDao myClientDao;
    private MachineDao machineDao;
    public UserService() {
        myClientDao = new ClientDao();
        machineDao = new MachineDao();
    }
    public void inscriptionClient(Client c){
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
    public void addMachineToClient(Machine m, Long clientId){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();

        machineDao.create(m);
        
        Client c= myClientDao.findById(clientId);
        c.addMachine(m);
        myClientDao.persist(c);
        
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        
    }
}