package modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Property;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-21T18:20:16")
@StaticMetamodel(Machine.class)
public class Machine_ { 

    public static volatile ListAttribute<Machine, Property> propertyList;
    public static volatile SingularAttribute<Machine, String> description;
    public static volatile SingularAttribute<Machine, String> model;
    public static volatile SingularAttribute<Machine, Long> id;
    public static volatile SingularAttribute<Machine, String> mark;

}