package entity;

import entity.BcmsSession;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-10T20:26:39")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, String> caller;
    public static volatile SingularAttribute<Event, String> executionTrace;
    public static volatile SingularAttribute<Event, BcmsSession> sessionId;
    public static volatile SingularAttribute<Event, String> eventName;

}