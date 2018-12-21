package modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-21T18:20:16")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, Integer> cost;
    public static volatile SingularAttribute<Task, Boolean> visibility;
    public static volatile SingularAttribute<Task, Long> announcementId;
    public static volatile SingularAttribute<Task, Long> hostId;
    public static volatile SingularAttribute<Task, Date> startTime;
    public static volatile SingularAttribute<Task, Long> id;
    public static volatile SingularAttribute<Task, Date> endTime;
    public static volatile SingularAttribute<Task, Long> guestId;

}