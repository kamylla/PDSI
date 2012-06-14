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
@Table(name = "tb_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEstado.findAll", query = "SELECT t FROM TbEstado t"),
    @NamedQuery(name = "TbEstado.findByIdEstado", query = "SELECT t FROM TbEstado t WHERE t.idEstado = :idEstado"),
    @NamedQuery(name = "TbEstado.findByNmEstado", query = "SELECT t FROM TbEstado t WHERE t.nmEstado = :nmEstado")})
public class TbEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Integer idEstado;
    @Column(name = "nm_estado")
    private String nmEstado;
    @OneToMany(mappedBy = "idEstado")
    private Collection<TbCidade> tbCidadeCollection;

    public TbEstado() {
    }

    public TbEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    @XmlTransient
    public Collection<TbCidade> getTbCidadeCollection() {
        return tbCidadeCollection;
    }

    public void setTbCidadeCollection(Collection<TbCidade> tbCidadeCollection) {
        this.tbCidadeCollection = tbCidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstado)) {
            return false;
        }
        TbEstado other = (TbEstado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbEstado[ idEstado=" + idEstado + " ]";
    }
    
}
