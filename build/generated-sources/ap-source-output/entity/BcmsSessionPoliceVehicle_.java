package entity;

import entity.BcmsSession;
import entity.PoliceVehicle;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-10T20:26:39")
@StaticMetamodel(BcmsSessionPoliceVehicle.class)
public class BcmsSessionPoliceVehicle_ { 

    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, String> bspvId;
    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, Date> policeVehicleStatusTime;
    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, BcmsSession> sessionId;
    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, String> policeVehicleStatus;
    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, PoliceVehicle> policeVehicleName;

}