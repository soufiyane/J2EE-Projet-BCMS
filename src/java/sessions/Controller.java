/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;
import com.pauware.pauware_engine._Core.AbstractStatechart;
import com.pauware.pauware_engine._Core.AbstractStatechart_monitor;
import com.pauware.pauware_engine._Exception.Statechart_exception;
import entity.BcmsSessionFireTruck;
import entity.BcmsSessionPoliceVehicle;
import entity.FireTruck;
import entity.PoliceVehicle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;





/**
 *
 * @author sofiane
*/
//@ManagedBean(name="ctr")
@ApplicationScoped
@ManagedBean(name = "ctr")
//@Singleton
//@javax.ejb.Stateless(mappedName = "ctr", name = "_ctr") 

public class Controller { 
   
   
   @EJB
   FSC fire;
   @EJB
   PSC police;
   @EJB
   BCMSManaged managed;

    public FSC getFire() {
        return fire;
    }

    public void setFire(FSC fire) {
        this.fire = fire;
    }

    public PSC getPolice() {
        return police;
    }

    public void setPolice(PSC police) {
        this.police = police;
    }
    
    private String[] stringList;
    private String[] stringListf;
    
       public void Init(){       
        try {
      
           fire.FSC_connection_request();
            
           police.PSC_connection_request();
            } catch (Throwable t) {
            t.printStackTrace();
        }        
    }
       
           private Integer pvn;
           private Integer ftn;
   
public Integer tointeger(Object a){
    return  Integer.parseInt(new String((String) a));
    
}
    public Integer getPvn() {
        return pvn;
    }
        public Integer getFtn() {
        return ftn;
    }
       
       
    public void set_Pvn(Integer pvn) throws Statechart_exception {
        this.pvn=pvn;
        stringList = new String[pvn];
       // managed.setNbPoliceVehicule(pvn);
        police.state_police_vehicle_number(pvn);
    }
    
      
    public void set_Ftn(Integer ftn) throws Statechart_exception {
        this.ftn=ftn;
        stringListf = new String[ftn];       
        //managed.setNbFireTruck(pft);
        fire.state_fire_truck_number(ftn);
    }

    public String getRoutep() {
        return routep;
    }

    public void setRoutep(String routep) {
        this.routep = routep;
    }
    
    

    public String getRoutef() {
        return routef;
    }

    public void setRoutef(String routef) {
        this.routef = routef;
    }
    private String routep=null;
    private String routef=null;

    public void emptyRoutef() {
        this.routef = null;
    }
    public void emptyRoutep() {
        this.routep = null;
    }
    public String[] getStringList() {
        return stringList;
    }

   public void setStringList(String[] stringList) {
        this.stringList = stringList;
    }
       public String[] getStringListf() {
        return stringListf;
    }

   public void setStringListf(String[] stringListf) {
        this.stringListf = stringListf;
    }



    public BCMSManaged getManaged() {
        return managed;
    }

}
