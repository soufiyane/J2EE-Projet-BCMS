package entity;

import entity.BcmsSessionFireTruck;
import entity.BcmsSessionPoliceVehicle;
import entity.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-10T20:26:39")
@StaticMetamodel(BcmsSession.class)
public class BcmsSession_ { 

    public static volatile SingularAttribute<BcmsSession, Integer> nbtruckp;
    public static volatile SingularAttribute<BcmsSession, String> sessionId;
    public static volatile CollectionAttribute<BcmsSession, BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicleCollection;
    public static volatile SingularAttribute<BcmsSession, Integer> nbtruckf;
    public static volatile CollectionAttribute<BcmsSession, Event> eventCollection;
    public static volatile CollectionAttribute<BcmsSession, BcmsSessionFireTruck> bcmsSessionFireTruckCollection;

}