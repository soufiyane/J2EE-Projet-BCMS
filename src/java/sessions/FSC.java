
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import javax.ejb.Remote;

/**
 *
 * @author sofiane
 */
@Remote
public interface FSC {

    public void FSC_connection_request() throws Statechart_exception;

    public void state_fire_truck_number(int number_of_fire_truck_required) throws Statechart_exception;

    public void FSC_agrees_about_fire_truck_route() throws Statechart_exception;

    public void FSC_agrees_about_police_vehicle_route() throws Statechart_exception;

    public void FSC_disagrees_about_fire_truck_route() throws Statechart_exception;

    public void FSC_disagrees_about_police_vehicle_route() throws Statechart_exception;

    public void enough_fire_trucks_dispatched() throws Statechart_exception;

    public void fire_truck_dispatched(String fire_truck) throws Statechart_exception;

    public void enough_fire_trucks_arrived() throws Statechart_exception;

    public void fire_truck_arrived(String fire_truck) throws Statechart_exception;

    public void fire_truck_breakdown(String fire_truck,/* may be 'null' */ String replacement_fire_truck) throws Statechart_exception;

    public void fire_truck_blocked(String fire_truck) throws Statechart_exception;

    public void crisis_is_more_severe() throws Statechart_exception;

    public void crisis_is_less_severe() throws Statechart_exception;

    public void route_for_fire_trucks(String route_name) throws Statechart_exception;
}


