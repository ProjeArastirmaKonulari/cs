package modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Announcement;
import modele.Machine;
import modele.Task;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-21T18:20:16")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, String> telNumber;
    public static volatile ListAttribute<Client, Announcement> announcementList;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, String> surname;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile ListAttribute<Client, Task> taskList;
    public static volatile SingularAttribute<Client, String> adress;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, Date> birhtday;
    public static volatile ListAttribute<Client, Machine> machineList;
    public static volatile SingularAttribute<Client, Integer> mandal;

}