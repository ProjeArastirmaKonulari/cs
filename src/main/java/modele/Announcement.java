/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.ClientDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Atadam
 */
@Entity
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String header;
    private String description;
    private int price;
    private String location;//NEEDS TO BE GPS BUT HOW?
    private String adress;
    private boolean visibility;
    private Long clientID;
    private List<Machine> machineList;
    
    public Announcement(Long clientID,String header, String description, int price) {
        this.clientID=clientID;
        this.header = header;
        this.description = description;
        this.price = price;
        
/*        ClientDao clientDao = new ClientDao();
        Client c = clientDao.findById( new Long(1) );
        if(c==null) System.out.println("XXXXXXXXXXXXXXXXXXXXxx null Client");
        else
            this.location = (c).getAdress();
/*        this.adress = cd.findById(clientID).getAdress();*/
        this.visibility = true;
        this.machineList = new ArrayList<>();

    }

    public Announcement() {}
    
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public List<Machine> getMachineIDList() {
        return machineList;
    }

    public void setMachineIDList(List<Machine> machineIDList) {
        this.machineList = machineIDList;
    }
    
    
    
    

    
}
