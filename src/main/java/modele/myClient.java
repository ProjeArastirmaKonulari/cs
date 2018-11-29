/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Atadam
 */
@Entity
public class myClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birhtday;
    private String adress;
    private String telNumber;
    private String mail;
    private String password; 

    public myClient (String name, String surname, Date birhtday, String adress, String telNumber, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.birhtday = birhtday;
        this.adress = adress;
        this.telNumber = telNumber;
        this.mail = mail;
        this.password = password;
    }
    public myClient(){
        
    }
    
}
