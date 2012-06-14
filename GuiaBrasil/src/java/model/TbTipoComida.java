/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kamylla
 */
@Entity
@Table(name = "tb_tipo_comida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoComida.findAll", query = "SELECT t FROM TbTipoComida t"),
    @NamedQuery(name = "TbTipoComida.findByIdTipoComida", query = "SELECT t FROM TbTipoComida t WHERE t.idTipoComida = :idTipoComida"),
    @NamedQuery(name = "TbTipoComida.findByNmTipoComida", query = "SELECT t FROM TbTipoComida t WHERE t.nmTipoComida = :nmTipoComida")})
public class TbTipoComida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_comida")
    private Integer idTipoComida;
    @Column(name = "nm_tipo_comida")
    private String nmTipoComida;
    @OneToMany(mappedBy = "idTipoComida")
    private Collection<TbRestaurante> tbRestauranteCollection;

    public TbTipoComida() {
    }

    public TbTipoComida(Integer idTipoComida) {
        this.idTipoComida = idTipoComida;
    }

    public Integer getIdTipoComida() {
        return idTipoComida;
    }

    public void setIdTipoComida(Integer idTipoComida) {
        this.idTipoComida = idTipoComida;
    }

    public String getNmTipoComida() {
        return nmTipoComida;
    }

    public void setNmTipoComida(String nmTipoComida) {
        this.nmTipoComida = nmTipoComida;
    }

    @XmlTransient
    public Collection<TbRestaurante> getTbRestauranteCollection() {
        return tbRestauranteCollection;
    }

    public void setTbRestauranteCollection(Collection<TbRestaurante> tbRestauranteCollection) {
        this.tbRestauranteCollection = tbRestauranteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoComida != null ? idTipoComida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoComida)) {
            return false;
        }
        TbTipoComida other = (TbTipoComida) object;
        if ((this.idTipoComida == null && other.idTipoComida != null) || (this.idTipoComida != null && !this.idTipoComida.equals(other.idTipoComida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbTipoComida[ idTipoComida=" + idTipoComida + " ]";
    }
    
}
