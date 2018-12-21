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
import java.util.Scanner;
import modele.Announcement;
import modele.Machine;
import modele.Client;
import modele.DryingMachine;
import modele.IroningMachine;
import modele.LoundryMachine;
import modele.Task;
import service.UserService;
import util.JpaUtil;
/**
 *
 * @author Atadam
 */
public class Main {
    public static final int DEFAULT_COST = 50;

    public static void main(String[] args) throws ParseException {
        JpaUtil.init();
  
        UserService userService = new UserService();
        SimpleDateFormat sf= new SimpleDateFormat ("dd/MM/YYYY");
        sf.parse("28/07/1996");
        Date date = new Date("28/07/1996"); 

        Scanner reader = new Scanner(System.in);
        boolean endOfExecution=false;
        while(!endOfExecution){
            System.out.println("1. Connexion\n2. Inscription");
            int menu = Integer.parseInt(reader.nextLine());
            String  password,mail;
            switch(menu){
                case 1:
                    System.out.println("Enter your mail: ");        
                    mail=reader.nextLine();
                    System.out.println("Enter your password: ");        
                    password=reader.nextLine();
                    Client c=userService.connectionClient(mail, password);
                    if(c==null){
                        System.out.println("Connection refused. Mail or password incorrect..!");
                    }else{
                        System.out.println("Welcome "+c);
                        clientPage();
                    }
                    break;
                case 2:
                    System.out.println("Enter your name: ");        
                    String  name=reader.nextLine();
                    System.out.println("Enter your surname: ");
                    String  surname=reader.nextLine();
                    System.out.println("Enter your birthday[DD/MM/YYYY]: ");        
                    Date  birthday=sf.parse(reader.nextLine());
                    System.out.println("Enter your address: ");        
                    String  address=reader.nextLine();
                    System.out.println("Enter your tel number: ");        
                    String  telNumber=reader.nextLine();
                    System.out.println("Enter your mail: ");        
                    mail=reader.nextLine();
                    System.out.println("Enter your password: ");        
                    password=reader.nextLine();
                    Client tempc= new Client(name,surname,birthday,address,telNumber,mail,password);
                    userService.inscriptionClient(tempc);
                    break;
                case 0:
                    endOfExecution=true;
            }
        }

        
        
        
        
/*
        Client client = new Client("Mustafa","COREKCI",new Date(),"Bagcilar","5347909837","a","1");       
        userService.inscriptionClient(client);
        Client client2 = new Client("Harun","DAG",new Date(),"Ortakoy","534790211","b","2");
        userService.inscriptionClient(client2);
         
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
                " 50 mandal değerine arçelik çamaşır+yıkama(her özellik mevcuttur.)",DEFAULT_COST) ;
        Machine mtemp=userService.getMachineByDescription(client.getId(),"camasirMakinem");        
        a.addMachine(mtemp);
        userService.publishAnnouncement(a);
        
        userService.startTask(a,client2.getId());
        
//        userService.addMachineToAnnouncement(mtemp, a.getId());

*/


        JpaUtil.destroy();

    }
    public static void clientPage(){
        UserService userService=new UserService();
        Scanner reader = new Scanner(System.in);
        System.out.println(""
                + "1. Add Machine\n"
                + "2. Publish Announcement\n"
                + "3. See Published Announcement\n"
                + "4. See My Precedent Services\n"
                + "5. See My Machines\n"
                + "6. See My Mandals \n"
                + "7. See My Machines\n"
                + "7. Exit");
        int menu = Integer.parseInt(reader.nextLine());
        switch(menu){
            case 1:
                System.out.println(""
                        + "1. Loundry Machine\n"
                        + "2. Drying Machine\n"
                        + "3. Ironing Machine\n"
                        + "0. Exit");
                int machineType = Integer.parseInt(reader.nextLine());  
                switch(machineType){
                    case 1:
                        
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        break;
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 0:
                break;
        }
        
    }
    
}
