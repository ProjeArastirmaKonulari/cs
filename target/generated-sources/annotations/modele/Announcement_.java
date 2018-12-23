package modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Machine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-21T18:20:16")
@StaticMetamodel(Announcement.class)
public class Announcement_ { 

    public static volatile SingularAttribute<Announcement, Long> clientID;
    public static volatile SingularAttribute<Announcement, Boolean> visibility;
    public static volatile SingularAttribute<Announcement, Integer> price;
    public static volatile SingularAttribute<Announcement, String> header;
    public static volatile SingularAttribute<Announcement, String> description;
    public static volatile SingularAttribute<Announcement, String> location;
    public static volatile SingularAttribute<Announcement, String> adress;
    public static volatile SingularAttribute<Announcement, Long> id;
    public static volatile ListAttribute<Announcement, Machine> machineList;

}