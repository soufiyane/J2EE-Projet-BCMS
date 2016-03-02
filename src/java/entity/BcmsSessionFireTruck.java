/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sofiane
 */
@Entity
@Table(name = "BCMS_SESSION_FIRE_TRUCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSessionFireTruck.findAll", query = "SELECT b FROM BcmsSessionFireTruck b"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByBsftId", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.bsftId = :bsftId"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByFireTruckStatus", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.fireTruckStatus = :fireTruckStatus"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByFireTruckStatusTime", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.fireTruckStatusTime = :fireTruckStatusTime"),
    })
public class BcmsSessionFireTruck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BSFT_ID")
    private String bsftId;
    @Size(max = 10)
    @Column(name = "FIRE_TRUCK_STATUS")
    private String fireTruckStatus;
    @Column(name = "FIRE_TRUCK_STATUS_TIME")
    @Temporal(TemporalType.TIME)
    private Date fireTruckStatusTime;
    @JoinColumn(name = "FIRE_TRUCK_NAME", referencedColumnName = "FIRE_TRUCK_NAME")
    @ManyToOne
    private FireTruck fireTruckName;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID")
    @ManyToOne
    private BcmsSession sessionId;

    public BcmsSessionFireTruck() {
    }

    public BcmsSessionFireTruck(String bsftId) {
        this.bsftId = bsftId;
    }

    public String getBsftId() {
        return bsftId;
    }

    public void setBsftId(String bsftId) {
        this.bsftId = bsftId;
    }

    public String getFireTruckStatus() {
        return fireTruckStatus;
    }

    public void setFireTruckStatus(String fireTruckStatus) {
        this.fireTruckStatus = fireTruckStatus;
    }

    public Date getFireTruckStatusTime() {
        return fireTruckStatusTime;
    }

    public void setFireTruckStatusTime(Date fireTruckStatusTime) {
        this.fireTruckStatusTime = fireTruckStatusTime;
    }

    public FireTruck getFireTruckName() {
        return fireTruckName;
    }

    public void setFireTruckName(FireTruck fireTruckName) {
        this.fireTruckName = fireTruckName;
    }

    public BcmsSession getSessionId() {
        return sessionId;
    }

    public void setSessionId(BcmsSession sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bsftId != null ? bsftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionFireTruck)) {
            return false;
        }
        BcmsSessionFireTruck other = (BcmsSessionFireTruck) object;
        if ((this.bsftId == null && other.bsftId != null) || (this.bsftId != null && !this.bsftId.equals(other.bsftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BcmsSessionFireTruck[ bsftId=" + bsftId + " ]";
    }
    
}
