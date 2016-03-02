/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sofiane
 */
@Entity
@Table(name = "ROUTE")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
@NamedQuery(name = "Route.findByRouteName", query = "SELECT r FROM Route r WHERE r.routeName = :routeName"),
@NamedQuery(name = "Route.countRoute", query = "SELECT count(r) from Route r"),
@NamedQuery(name = "Route.typeroutefire", query = "SELECT count(r) FROM Route r where r.typeroute='fire'"),
@NamedQuery(name = "Route.typeroutepolice", query = "SELECT count(r) FROM Route r where r.typeroute='police'")
})
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ROUTE_NAME")
    private String routeName;
    @Column(name = "TYPE_ROUTE")
    private String typeroute;

    public Route() {
    }

    public Route(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    
        public String getRouteType() {
        return typeroute ;
    }

    public void setRouteType(String typeroute) {
        this.typeroute = typeroute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeName != null ? routeName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeName == null && other.routeName != null) || (this.routeName != null && !this.routeName.equals(other.routeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Route[ routeName=" + routeName + " ]";
    }
    
}
