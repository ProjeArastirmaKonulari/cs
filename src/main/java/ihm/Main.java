/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import dao.ClientDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modele.Announcement;
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
        
        
        
        Announcement a = new Announcement(client.getId(),"Üsküdarda ucuza yikama",
                " 50 mandal değerine arçelik çamaşır+yıkama(her özellik mevcuttur.)",50) ;
        Machine mtemp=userService.getMachineByDescription(client.getId(),"camasirMakinem");        
        a.addMachine(mtemp);
        
        userService.publishAnnouncement(a);
        
//        userService.addMachineToAnnouncement(mtemp, a.getId());
        JpaUtil.destroy();
   

       
    }

}
