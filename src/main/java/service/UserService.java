/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AnnouncementDao;
import dao.MachineDao;
import dao.ClientDao;
import java.util.List;
import modele.Announcement;
import modele.Machine;
import modele.Client;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class UserService {
    private ClientDao clientDao;
    private MachineDao machineDao;
    private AnnouncementDao announcementDao;
    
    public UserService() {
        clientDao = new ClientDao();
        machineDao = new MachineDao();
        announcementDao =  new AnnouncementDao();
    }
    
    public void inscriptionClient(Client c){
        //Persister le nouveau client
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        clientDao.create(c);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        
    }
    public void publishAnnouncement(Announcement a){
        //Persister le nouveau client
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        a.setVisibility(true);
        announcementDao.create(a);
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
        
        Client c= clientDao.findById(clientId);
        c.addMachine(m);
        clientDao.persist(c);
        
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        
    }
    public Machine getMachineByDescription(Long clientId, String description){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();

        System.out.println("XXX "+clientId);
        Client c= clientDao.findById(clientId);
        List<Machine> lm = c.getMachineList();
        for(int i=0;i<lm.size();i++){
            if( lm.get(i).getDescription().equals(description) ){
                return lm.get(i);
            }
        }   
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return null;

    }

    public void addMachineToAnnouncement(Machine m, Long announcementId){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();

        
        Announcement a= announcementDao.findById(announcementId);
        a.addMachine(m);
        announcementDao.persist(a);
        
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        
    }
}