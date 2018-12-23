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
import java.util.List;
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

        initialize(userService);
        
        karsilamaSayfasi(userService);

        JpaUtil.destroy();
    }
    public static void clientPage(UserService userService, Long clientId){
        Client client=userService.getClientById(clientId);
        Scanner reader = new Scanner(System.in);
        System.out.println(""
                + "1. İlanlarımı Görüntüle\n"
                + "2. Makinelerimi Görüntüle\n"
                + "3. İsteklerimi Görüntüle\n"
                + "4. Mandal Al\n"
                + "5. Hizmet Geçmişimi Görüntüle\n"
                + "6. Bize Yorum Bırak\n"
                + "0. Çıkış Yap");
        int menu = Integer.parseInt(reader.nextLine());
        switch(menu){
            case 1:
                System.out.println("XXXXX1..");
//                List<Announcement> la = userService.getClientAnnouncements(clientId);
                List<Announcement> la = client.getAnnouncementList();
                if(la.size()>=1){
                    System.out.println(la.size()+" adet ilanınız listelenmiştir..");
                    for (int i=0;i<la.size();i++){
                        System.out.println(la.get(i));
                    }                    
                }else{
                    System.out.println("Herhangi bir ilanınız bulunmamaktadır");                    
                }
                break;
            case 2:
                List<Machine> ma = client.getMachineList();
                if(ma.size()>=1){
                    System.out.println(ma.size()+" adet makineniz listelenmiştir..");
                    for (int i=0;i<ma.size();i++){
                        System.out.println(ma.get(i));
                    }
                }else{
                    System.out.println("Herhangi bir makineniz bulunmamaktadır");                    
                }
                System.out.println("Ne yapmak istersiniz?\n");
                System.out.println("\n"
                        + "1. Makine Ekle\n"
                        + "2. Makineye Özellik Ekle\n"
                        + "0. Geri Dön\n");
                int makinesecim=Integer.parseInt(reader.nextLine());
                switch(makinesecim){
                    case 1:
                        System.out.println(""
                        + "1. Çamaşır Makinesi\n"
                        + "2. Kurutma Makinesi\n"
                        + "3. Ütü Makinesi\n"
                        + "0. Geri Dön\n");
                        int machineType = Integer.parseInt(reader.nextLine());  
                        switch(machineType){
                            case 1:
                                System.out.println("Makine açıklamasını Giriniz: ");        
                                String  description=reader.nextLine();
                                System.out.println("Makine Markasını Giriniz: ");
                                String  mark=reader.nextLine();
                                System.out.println("Makine Modelini Giriniz: ");        
                                String model=reader.nextLine();
                                System.out.println("Makine kapasitesini Giriniz: ");
                                int capacity=Integer.parseInt(reader.nextLine());
                                Machine lm=new LoundryMachine(description,mark,model,capacity);
                                System.out.println("Makineye Özellik Eklemek ister misiniz?\n"
                                        + "1. Evet"
                                        + "0. Hayır");
                                int yesno = Integer.parseInt(reader.nextLine());
                                switch(yesno){
                                    case 1:
                                        System.out.println("Programı Giriniz: ");        
                                        String  type=reader.nextLine();
                                        System.out.println("Kaç Dakika Sürüyor: ");
                                        int  minute=Integer.parseInt(reader.nextLine());
                                        System.out.println("Voltajı nedir: ");        
                                        int voltage=Integer.parseInt(reader.nextLine());
                                        lm.addProperty(type, minute, voltage);
                                        break;
                                    case 0:
                                        break;
                                }
                                userService.addMachineToClient(lm, clientId);
                                client=userService.getClientById(clientId);
                                
                                break;
                            case 2:
                                System.out.println("Makine açıklamasını Giriniz: ");        
                                description=reader.nextLine();
                                System.out.println("Makine Markasını Giriniz: ");
                                mark=reader.nextLine();
                                System.out.println("Makine Modelini Giriniz: ");        
                                model=reader.nextLine();
                                System.out.println("Makine kapasitesini Giriniz: ");
                                capacity=Integer.parseInt(reader.nextLine());
                                Machine dm=new DryingMachine(description,mark,model,capacity);
                                System.out.println("Makineye Özellik Eklemek ister misiniz?\n"
                                        + "1. Evet"
                                        + "0. Hayır");
                                yesno = Integer.parseInt(reader.nextLine());
                                switch(yesno){
                                    case 1:
                                        System.out.println("Programı Giriniz: ");        
                                        String  type=reader.nextLine();
                                        System.out.println("Kaç Dakika Sürüyor: ");
                                        int  minute=Integer.parseInt(reader.nextLine());
                                        System.out.println("Voltajı nedir: ");        
                                        int voltage=Integer.parseInt(reader.nextLine());
                                        dm.addProperty(type, minute, voltage);
                                        break;
                                    case 0:
                                        break;
                                }
                                userService.addMachineToClient(dm, clientId);
                                client=userService.getClientById(clientId);
                                break;
                            case 3:
                                System.out.println("Makine açıklamasını Giriniz: ");        
                                description=reader.nextLine();
                                System.out.println("Makine Markasını Giriniz: ");
                                mark=reader.nextLine();
                                System.out.println("Makine Modelini Giriniz: ");        
                                model=reader.nextLine();
                                Machine im=new IroningMachine(description,mark,model);
                                System.out.println("Makineye Özellik Eklemek ister misiniz?\n"
                                        + "1. Evet"
                                        + "0. Hayır");
                                yesno = Integer.parseInt(reader.nextLine());
                                switch(yesno){
                                    case 1:
                                        System.out.println("Programı Giriniz: ");        
                                        String  type=reader.nextLine();
                                        System.out.println("Kaç Dakika Sürüyor: ");
                                        int  minute=Integer.parseInt(reader.nextLine());
                                        System.out.println("Voltajı nedir: ");        
                                        int voltage=Integer.parseInt(reader.nextLine());
                                        im.addProperty(type, minute, voltage);
                                        break;
                                    case 0:
                                        break;
                                }
                                userService.addMachineToClient(im, clientId);
                                client=userService.getClientById(clientId);

                                break;
                            case 0:
                                break;
                        }
                        break;
                    case 0:
                        break;
                }
                break;
            case 3:
                break;
            case 4:
                System.out.println(client.getMandal()+" adet mandalınız bulunmaktadır.\n"
                        + "Ne kadar daha mandal almak istersiniz?\n");
                int mandal=Integer.parseInt(reader.nextLine());
                int yeniMandal=userService.addMandalToClient(mandal, clientId);
                System.out.println("Artık "+yeniMandal+" adet mandalınız bulunmaktadır. Hayırlı olsun :)\n");
                break;
            case 5:
                System.out.println("XXXXX4..");
//                List<Announcement> la = userService.getClientAnnouncements(clientId);
                List<Task> lt = client.getTaskList();
                if(lt.size()>=1){
                    System.out.println(lt.size()+" adet Hizmetiniz listelenmiştir..");
                    for (int i=0;i<lt.size();i++){
                        System.out.println(lt.get(i));
                    }                    
                }else{
                    System.out.println("Herhangi bir hizmetiniz bulunmamaktadır");                    
                }
                break;
            case 6:
                System.out.println("Bize ne yorum bırakmak isterdiniz? Hemen yazın merak ediyoruz..");
                String yorum=reader.nextLine();
                System.out.println("Yorumunuzu dikkate alacağız. Çok teşekkür ederiz..");
                break;
            case 0:
                return;
        }
        clientPage(userService,clientId); 
        
    }
    public static void karsilamaSayfasi(UserService userService) throws ParseException{
        SimpleDateFormat sf= new SimpleDateFormat ("dd/MM/YYYY");
        Scanner reader = new Scanner(System.in);
        System.out.println("1. Giriş Yap\n2. Kayıt Ol");
        int menu = Integer.parseInt(reader.nextLine());
        String  password,mail;
        switch(menu){
            case 1:
                System.out.println("Mailinizi Giriniz: ");        
                mail=reader.nextLine();
                System.out.println("Şifrenizi Giriniz: ");        
                password=reader.nextLine();
                Client c=userService.connectionClient(mail, password);
                if(c==null){
                    System.out.println("Giriş işlemi reddedildi. Mail ya da şifre yanlış..!");
                    karsilamaSayfasi(userService);
                }else{
                    System.out.println("Hoşgeldin "+c+" :)");
                    clientPage(userService,c.getId());
                }
                break;
            case 2:
                System.out.println("Adınızı Giriniz: ");        
                String  name=reader.nextLine();
                System.out.println("Soyadınızı Giriniz: ");
                String  surname=reader.nextLine();
                System.out.println("Doğum Tarihinizi Şu Formatta Giriniz[DD/MM/YYYY]: ");        
                Date  birthday=sf.parse(reader.nextLine());
                System.out.println("Adresinizi Giriniz: ");        
                String  address=reader.nextLine();
                System.out.println("Telefon Numaranızı Giriniz: ");        
                String  telNumber=reader.nextLine();
                System.out.println("Mailinizi Giriniz: ");        
                mail=reader.nextLine();
                System.out.println("Şifrenizi Giriniz: ");        
                password=reader.nextLine();
                Client tempc= new Client(name,surname,birthday,address,telNumber,mail,password);
                userService.inscriptionClient(tempc);
                karsilamaSayfasi(userService);
                break;
            case 0:
                karsilamaSayfasi(userService);
                break;
        }
    }
    public static void initialize(UserService userService){

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
        
//        userService.startTask(a,client2.getId());
        
//        userService.addMachineToAnnouncement(mtemp, a.getId());
        
    }
}
