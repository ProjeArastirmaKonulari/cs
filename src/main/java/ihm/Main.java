/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modele.Machine;
import modele.Client;
import modele.DryingMachine;
import modele.IroningMachine;
import modele.LoundryMachine;
import service.UserService;
import util.JpaUtil;

/**
 *
 * @author Atadam
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        JpaUtil.init();
  
        UserService userService = new UserService();
        SimpleDateFormat sf= new SimpleDateFormat ("dd/MM/YYYY");
        sf.parse("28/07/1996");
        Date date = new Date("28/07/1996"); 
        Client client = new Client("Mustafa","COREKCI",new Date(),"Bagcilar","5347909837","a","1");
        
        userService.inscriptionClient(client);
        
        LoundryMachine lmachine=new LoundryMachine("camasirMakinem","arcelik","2015 model",5);
        lmachine.addProperty("pamuk",45,1200);
        lmachine.addProperty("on_yikama",20,1000);
        userService.addMachineToClient(lmachine,client.getId());

        DryingMachine dmachine=new DryingMachine("kurutmaMakinem","arcelik","2014 model",5);
        dmachine.addProperty("genel",35,1700);
        userService.addMachineToClient(dmachine,client.getId());

        IroningMachine imachine=new IroningMachine("utuMakinem","beko","2018 model");
        imachine.addProperty("pamuk",10,400);
        userService.addMachineToClient(imachine,client.getId());
        

        JpaUtil.destroy();
   

        /*
        myClient client = new myClient("Mustafa","COREKCI",new Date(),"Esenler","5347909837","a","1");
         
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("cspun") ;
        EntityManager em= emf.createEntityManager();
        EntityTransaction trx=em.getTransaction();
        
        trx.begin();
        em.persist(client);
        trx.commit();
        
        em.close();
        emf.close();
        */
    }

}
