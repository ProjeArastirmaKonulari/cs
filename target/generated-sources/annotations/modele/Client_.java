package modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Machine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T19:16:51")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, String> telNumber;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, String> surname;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, String> adress;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, Date> birhtday;
    public static volatile ListAttribute<Client, Machine> machineList;
    public static volatile SingularAttribute<Client, Integer> mandal;

}