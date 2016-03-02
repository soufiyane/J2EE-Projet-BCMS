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
@Table(name = "BCMS_SESSION_POLICE_VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findAll", query = "SELECT b FROM BcmsSessionPoliceVehicle b"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByBspvId", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.bspvId = :bspvId"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByPoliceVehicleStatus", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.policeVehicleStatus = :policeVehicleStatus"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByPoliceVehicleStatusTime", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.policeVehicleStatusTime = :policeVehicleStatusTime"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findBySessionId", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.sessionId = :sessionId")})
public class BcmsSessionPoliceVehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BSPV_ID")
    private String bspvId;
    @Size(max = 10)
    @Column(name = "POLICE_VEHICLE_STATUS")
    private String policeVehicleStatus;
    @Column(name = "POLICE_VEHICLE_STATUS_TIME")
    @Temporal(TemporalType.TIME)
    private Date policeVehicleStatusTime;
    @JoinColumn(name = "POLICE_VEHICLE_NAME", referencedColumnName = "POLICE_VEHICLE_NAME")
    @ManyToOne
    private PoliceVehicle policeVehicleName;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID")
    @ManyToOne
    private BcmsSession sessionId;

    public BcmsSessionPoliceVehicle() {
    }

    public BcmsSessionPoliceVehicle(String bspvId) {
        this.bspvId = bspvId;
    }

    public String getBspvId() {
        return bspvId;
    }

    public void setBspvId(String bspvId) {
        this.bspvId = bspvId;
    }

    public String getPoliceVehicleStatus() {
        return policeVehicleStatus;
    }

    public void setPoliceVehicleStatus(String policeVehicleStatus) {
        this.policeVehicleStatus = policeVehicleStatus;
    }

    public Date getPoliceVehicleStatusTime() {
        return policeVehicleStatusTime;
    }

    public void setPoliceVehicleStatusTime(Date policeVehicleStatusTime) {
        this.policeVehicleStatusTime = policeVehicleStatusTime;
    }

    public PoliceVehicle getPoliceVehicleName() {
        return policeVehicleName;
    }

    public void setPoliceVehicleName(PoliceVehicle policeVehicleName) {
        this.policeVehicleName = policeVehicleName;
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
        hash += (bspvId != null ? bspvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionPoliceVehicle)) {
            return false;
        }
        BcmsSessionPoliceVehicle other = (BcmsSessionPoliceVehicle) object;
        if ((this.bspvId == null && other.bspvId != null) || (this.bspvId != null && !this.bspvId.equals(other.bspvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BcmsSessionPoliceVehicle[ bspvId=" + bspvId + " ]";
    }
    
}
