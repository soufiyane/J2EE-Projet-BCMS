/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.BcmsSession;
import entity.BcmsSessionFireTruck;
import entity.BcmsSessionPoliceVehicle;
import entity.Event;
import entity.FireTruck;
import entity.PoliceVehicle;
import entity.Route;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author sofiane
 */
@Local
public interface BCMSManaged {
    public Long countRoute();
    public void createRoutePolice(String name);
    public void createRouteFire(String name) ;
    public boolean countRoute0();
    public boolean countRoute1();
    public String afficher (String s, String ss);
    public boolean countroutefire();
    public boolean countroutepolice();
    public Long countFireTruck();
    public Long countPoliceVehicle();
    
    public EntityManager getEntity_manager();
    public BcmsSession getSession();
    public void createEvent(String nam, String trac, String caller);
    public void createSession();
    public List<FireTruck> getFireTruck();
    public List<FireTruck> getFireTruckBySession();
    public List<PoliceVehicle> getPoliceVehicle();
    public List<PoliceVehicle> getPoliceVehicleBySession();
    public List<Event> getEvent();
    public List<Event> getEventBySession();
    public void createSessionFireTruck(String ft, int id);
    public void createSessionPoliceVehicle(String ft, int id);
    public void setNbFireTruck(int nb);
    public void setNbPoliceVehicule(int nb);
    public void setFireTruckStatus(BcmsSessionFireTruck bcmsft, String status);
    public void setPoliceVehicleStatus(BcmsSessionPoliceVehicle bcmspv, String status);
    public void EndOfSession();
    public Route getRoute(String name);
    public List<Route> getRoutes();
    public FireTruck getFireTruck(String name);
    public PoliceVehicle getPoliceVehicule(String name);
    public List<String> getNameRoutes();
    public List<BcmsSessionFireTruck> getBcmsSessionFireTruck();
    public BcmsSessionFireTruck getBcmsSessionFireTruckByFireTruckName(String firetruckname);
    public BcmsSessionPoliceVehicle getBcmsSessionPoliceVehicleByPoliceVehicleName(String policevehiclename);

}