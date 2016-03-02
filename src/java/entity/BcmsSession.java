/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sofiane
 */
@Entity
@Table(name = "BCMS_SESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSession.findAll", query = "SELECT b FROM BcmsSession b"),
    @NamedQuery(name = "BcmsSession.findBySessionId", query = "SELECT b FROM BcmsSession b WHERE b.sessionId = :sessionId"),
    @NamedQuery(name = "BcmsSession.findByNbtruckf", query = "SELECT b FROM BcmsSession b WHERE b.nbtruckf = :nbtruckf"),
    @NamedQuery(name = "BcmsSession.findByNbtruckp", query = "SELECT b FROM BcmsSession b WHERE b.nbtruckp = :nbtruckp")})
public class BcmsSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Column(name = "NBTRUCKF")
    private Integer nbtruckf;
    @Column(name = "NBTRUCKP")
    private Integer nbtruckp;
    @OneToMany(mappedBy = "sessionId")
    private Collection<BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicleCollection;
    @OneToMany(mappedBy = "sessionId")
    private Collection<BcmsSessionFireTruck> bcmsSessionFireTruckCollection;
    @OneToMany(mappedBy = "sessionId")
    private Collection<Event> eventCollection;

    public BcmsSession() {
    }

    public BcmsSession(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getNbtruckf() {
        return nbtruckf;
    }

    public void setNbtruckf(Integer nbtruckf) {
        this.nbtruckf = nbtruckf;
    }

    public Integer getNbtruckp() {
        return nbtruckp;
    }

    public void setNbtruckp(Integer nbtruckp) {
        this.nbtruckp = nbtruckp;
    }

    @XmlTransient
    public Collection<BcmsSessionPoliceVehicle> getBcmsSessionPoliceVehicleCollection() {
        return bcmsSessionPoliceVehicleCollection;
    }

    public void setBcmsSessionPoliceVehicleCollection(Collection<BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicleCollection) {
        this.bcmsSessionPoliceVehicleCollection = bcmsSessionPoliceVehicleCollection;
    }

    @XmlTransient
    public Collection<BcmsSessionFireTruck> getBcmsSessionFireTruckCollection() {
        return bcmsSessionFireTruckCollection;
    }

    public void setBcmsSessionFireTruckCollection(Collection<BcmsSessionFireTruck> bcmsSessionFireTruckCollection) {
        this.bcmsSessionFireTruckCollection = bcmsSessionFireTruckCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSession)) {
            return false;
        }
        BcmsSession other = (BcmsSession) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BcmsSession[ sessionId=" + sessionId + " ]";
    }
    
}
