/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AnnouncementDao;
import dao.MachineDao;
import dao.ClientDao;
import dao.TaskDao;
import java.util.Date;
import java.util.List;
import modele.Announcement;
import modele.Machine;
import modele.Client;
import modele.Task;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class UserService {
    private ClientDao clientDao;
    private MachineDao machineDao;
    private AnnouncementDao announcementDao;
    private TaskDao taskDao;
    
    public UserService() {
        clientDao = new ClientDao();
        machineDao = new MachineDao();
        announcementDao =  new AnnouncementDao();
        taskDao = new TaskDao(); 
    }
    
    public void inscriptionClient(Client c){
        //Persister le nouveau client
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        clientDao.create(c);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        
    }
    
    public Client connectionClient(String mail,String password){
        JpaUtil.creerEntityManager();
        Client client = clientDao.findByMail(mail);
        JpaUtil.fermerEntityManager();
        if(client==null){
            return null;
        }
        else {
            if(client.getPassword().equals(password)){
                return client;
            }
            else{
                return null;
            }
        }
    }
    
    public void publishAnnouncement(Announcement a){
        //Persister le nouveau client
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        a.setVisibility(true);
        announcementDao.create(a);
        
        //add annoucement to client by getting clientID from annoucement itself.
        Long cid= a.getClientID();
        Client c = clientDao.findById(cid);
        c.addAnnoucement(a);
        clientDao.persist(c);
        
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
    public void startTask(Announcement a, Long guestId){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        
        Task t = new Task(a.getPrice(),new Date(),a.getClientID(),guestId,a.getId(),true);
        taskDao.create(t);
        Client c = clientDao.findById(t.getGuestId());
        c.addTask(t);
        clientDao.persist(c);
        c=clientDao.findById(t.getHostId());
        c.addTask(t);
        clientDao.persist(c);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
    }
}