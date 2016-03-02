/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

//import org.apache.commons.lang.math.NumberUtils;
import entity.BcmsSession;
import entity.BcmsSessionFireTruck;
import entity.BcmsSessionPoliceVehicle;
import entity.Event;
import entity.FireTruck;
import entity.PoliceVehicle;
import entity.Route;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sofiane
 */
//@ManagedBean(name = "entree")
//@javax.ejb.Stateless(mappedName = "BCMSManage", name = "bcmsmanage") 
@Stateless
public class BCMSManagedBean implements  BCMSManaged {

    @Override
    public  BcmsSession getSession() {
        return _session;
    }
    
    @Override
    public EntityManager getEntity_manager() {
        return _entity_manager;
    }

 
    @PersistenceContext(name = "PC")
    private EntityManager _entity_manager;



  
    private static BcmsSession _session = null;
 

    private String date() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        return reportDate;
    }
    
    @Override
    public void EndOfSession(){
        _session = null;
    }

    @Override
    public void createEvent(String nam, String trac, String caller) {
        Event event = new Event();
        event.setSessionId(_session);
        String name = nam + date();
        event.setEventName(name);
        event.setExecutionTrace(trac);
        event.setCaller(caller);
        _entity_manager.persist(event);
    }

        @Override
    public void createRouteFire(String name) {
        Route rt=new Route();
        rt.setRouteName(name);
        rt.setRouteType("fire");
        _entity_manager.persist(rt);
    }
        @Override
    public void createRoutePolice(String name) {
        Route rt=new Route();
        rt.setRouteName(name);
        rt.setRouteType("police");
        _entity_manager.persist(rt);
    }

    @Override
    public void createSession() {
         _session = new BcmsSession();

        String namesession = date();
        _session.setSessionId(namesession);
        _entity_manager.persist(_session);
    }
    
    
         @Override
    public boolean countRoute0() {
        return ((Long) _entity_manager.createNamedQuery("Route.countRoute").getSingleResult() % 2 ==0);
    }
    
         @Override
    public Long countRoute() {
        return (Long) _entity_manager.createNamedQuery("Route.countRoute").getSingleResult();
    }
    
         @Override
    public boolean countRoute1() {
        return ((Long) _entity_manager.createNamedQuery("Route.countRoute").getSingleResult()==1);
    }

    
    @Override
    public void createSessionPoliceVehicle(String pv, int id) {
        BcmsSessionPoliceVehicle bcmspv = new BcmsSessionPoliceVehicle();
        bcmspv.setSessionId(_session);
        PoliceVehicle pvh = new PoliceVehicle();
        pvh.setPoliceVehicleName(pv);
        bcmspv.setPoliceVehicleName(pvh);
       _entity_manager.persist(pvh);
        bcmspv.setPoliceVehicleStatus("Idle");
        bcmspv.setBspvId(date() + id);
        _entity_manager.persist(bcmspv); 
    }
    @Override
    public void createSessionFireTruck(String ft, int id) {
        BcmsSessionFireTruck bcmsft = new BcmsSessionFireTruck();
        bcmsft.setSessionId(_session);
        FireTruck ftv=new FireTruck();
        ftv.setFireTruckName(ft);
        bcmsft.setFireTruckName(ftv);
        _entity_manager.persist(ftv);
        bcmsft.setFireTruckStatus("Idle");
        bcmsft.setBsftId(date() + id);
        _entity_manager.persist(bcmsft);
    }

    @Override
    public Long countFireTruck() {
        return (Long) _entity_manager.createNamedQuery("FireTruck.countFireTruck").getSingleResult();
    }
    

    @Override
    public Long countPoliceVehicle() {
        return (Long) _entity_manager.createNamedQuery("PoliceVehicle.countPoliceVehicle").getSingleResult();
    }
    
    @Override
    public boolean countroutefire() {
        return ((Long) _entity_manager.createNamedQuery("Route.typeroutefire").getSingleResult()% 2==0);
    }
    
        @Override
    public boolean countroutepolice() {
        return ((Long) _entity_manager.createNamedQuery("Route.typeroutepolice").getSingleResult() % 2==0);
    }

    @Override
    public List<FireTruck> getFireTruck() {
        return _entity_manager.createNamedQuery("FireTruck.findAll").getResultList();
    }

    @Override
    public List<Event> getEvent() {
        return _entity_manager.createNamedQuery("Event.findAll").getResultList();
    }

    @Override
    public List<Event> getEventBySession() {
        return _entity_manager.createNamedQuery("Event.findBySessionId").setParameter("sessionId", _session).getResultList();
    }
    
    @Override
    public List<FireTruck> getFireTruckBySession(){
    return _entity_manager.createNamedQuery("BcmsSessionFireTruck.findBySessionId").setParameter("sessionId", _session).getResultList();
}
    @Override
    public List<PoliceVehicle> getPoliceVehicleBySession(){
      return _entity_manager.createNamedQuery("BcmsSessionPoliceVehicle.findBySessionId").setParameter("sessionId", _session).getResultList();  
    }

    @Override
    public Route getRoute(String name) {
        return _entity_manager.find(Route.class, name);
    }


    
    @Override
    public FireTruck getFireTruck(String name) {
        return _entity_manager.find(FireTruck.class, name);
    }

    @Override
    public PoliceVehicle getPoliceVehicule(String name) {
        return _entity_manager.find(PoliceVehicle.class, name);
    }


    @Override
    public void setNbFireTruck(int nb) {
        _session.setNbtruckf(nb);
        _entity_manager.merge(_session);
    }

    @Override
    public void setNbPoliceVehicule(int nb) {
        _session.setNbtruckp(nb);
        _entity_manager.merge(_session);
    }



    @Override
    public List<String> getNameRoutes() {
        return _entity_manager.createNamedQuery("Route.findAllName").getResultList();
    }

    @Override
    public List<BcmsSessionFireTruck> getBcmsSessionFireTruck() {
        return _entity_manager.createNamedQuery("BcmsSessionFireTruck.findAll").getResultList();
    }


    @Override
    public void setFireTruckStatus(BcmsSessionFireTruck bcmsft, String status) {
       bcmsft.setFireTruckStatus(status);
       _entity_manager.merge(bcmsft);
    }

    @Override
    public BcmsSessionFireTruck getBcmsSessionFireTruckByFireTruckName(String firetruckname) {
        return (BcmsSessionFireTruck)_entity_manager.createNamedQuery("BcmsSessionFireTruck.findByFireTruckNameAndSessionName").setParameter("fireTruckName", firetruckname).setParameter("sessionId", _session).getSingleResult();
    }

    @Override
    public void setPoliceVehicleStatus(BcmsSessionPoliceVehicle bcmspv, String status) {
       bcmspv.setPoliceVehicleStatus(status);
       _entity_manager.merge(bcmspv);
    }

    @Override
    public BcmsSessionPoliceVehicle getBcmsSessionPoliceVehicleByPoliceVehicleName(String policevehiclename) {
        return (BcmsSessionPoliceVehicle)_entity_manager.createNamedQuery("BcmsSessionPoliceVehicle.findByPoliceVehicleNameAndSessionName").setParameter("policeVehicleName", policevehiclename).setParameter("sessionId", _session).getSingleResult();
    }

    @Override
    public List<PoliceVehicle> getPoliceVehicle() {
        return _entity_manager.createNamedQuery("PoliceVehicle.findAll").getResultList();
    }

    @Override
    public String afficher (String s, String ss){
        return s+" "+ss;
    }


    @Override
    public List<Route> getRoutes(){
        return _entity_manager.createNamedQuery("Route.findAll").getResultList();
    }
     public BcmsSession get_session(){
        return _session;
    }
}

  

