/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Atadam
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birhtday;
    private String adress;
    private String telNumber;
    private String mail;
    private String password; 
    private int mandal;
    @OneToMany
    private List<Machine> machineList;
    private List<Announcement> announcementList;
    private List<Task> taskList;

    public Client (String name, String surname, Date birhtday, String adress, String telNumber, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.birhtday = birhtday;
        this.adress = adress;
        this.telNumber = telNumber;
        this.mail = mail;
        this.password = password;
        this.machineList = new ArrayList<>();
        this.announcementList = new ArrayList<>();
        this.taskList = new ArrayList<>();
        this.mandal=50;
    }
    public Client(){       }
    
    public boolean addMachine(Machine m){
        try{
            this.machineList.add(m);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public boolean addAnnoucement(Announcement a){
        try{
            this.announcementList.add(a);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean addTask(Task t){
        try{
            this.taskList.add(t);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirhtday() {
        return birhtday;
    }

    public void setBirhtday(Date birhtday) {
        this.birhtday = birhtday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
    }

    public int getMandal() {
        return mandal;
    }

    public void addMandal(int mandal) {
        this.mandal += mandal;
    }

    public void removeMandal(int mandal) {
        this.mandal -= mandal;
    }
    
    
    
}
