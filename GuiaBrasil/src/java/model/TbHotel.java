/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamylla
 */
@Entity
@Table(name = "tb_hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbHotel.findAll", query = "SELECT t FROM TbHotel t"),
    @NamedQuery(name = "TbHotel.findByIdEstabelecimento", query = "SELECT t FROM TbHotel t WHERE t.idEstabelecimento = :idEstabelecimento"),
    @NamedQuery(name = "TbHotel.findByWifi", query = "SELECT t FROM TbHotel t WHERE t.wifi = :wifi"),
    @NamedQuery(name = "TbHotel.findByNrQuartos", query = "SELECT t FROM TbHotel t WHERE t.nrQuartos = :nrQuartos")})
public class TbHotel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estabelecimento")
    private Integer idEstabelecimento;
    @Column(name = "wifi")
    private Boolean wifi;
    @Column(name = "nr_quartos")
    private Integer nrQuartos;
    @JoinColumn(name = "id_estabelecimento", referencedColumnName = "id_estabelecimento", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbEstabelecimento tbEstabelecimento;

    public TbHotel() {
    }

    public TbHotel(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Integer getNrQuartos() {
        return nrQuartos;
    }

    public void setNrQuartos(Integer nrQuartos) {
        this.nrQuartos = nrQuartos;
    }

    public TbEstabelecimento getTbEstabelecimento() {
        return tbEstabelecimento;
    }

    public void setTbEstabelecimento(TbEstabelecimento tbEstabelecimento) {
        this.tbEstabelecimento = tbEstabelecimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstabelecimento != null ? idEstabelecimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbHotel)) {
            return false;
        }
        TbHotel other = (TbHotel) object;
        if ((this.idEstabelecimento == null && other.idEstabelecimento != null) || (this.idEstabelecimento != null && !this.idEstabelecimento.equals(other.idEstabelecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbHotel[ idEstabelecimento=" + idEstabelecimento + " ]";
    }
    
}
