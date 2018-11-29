/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modele.Machine;
import modele.Propertyy;
import modele.myClient;
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
        myClient client = new myClient("Mustafa","COREKCI",new Date(),"Bagcilar","5347909837","a","1");
        userService.inscriptionClient(client);
        
        
        Machine machine=new Machine("camasirMakinem","arcelik","2015 model");
//        Propertyy p= new Property();
        if(        machine.addProperty("pamuk",45,1200)){
            System.out.println("Adding property is OK");
        }else{
            System.out.println("Adding property is NOT OK");
        }
        userService.newMachine(machine);
        
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
