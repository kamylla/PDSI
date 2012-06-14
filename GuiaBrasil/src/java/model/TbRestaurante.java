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
@Table(name = "tb_restaurante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRestaurante.findAll", query = "SELECT t FROM TbRestaurante t"),
    @NamedQuery(name = "TbRestaurante.findByIdEstabelecimento", query = "SELECT t FROM TbRestaurante t WHERE t.idEstabelecimento = :idEstabelecimento"),
    @NamedQuery(name = "TbRestaurante.findByLotacao", query = "SELECT t FROM TbRestaurante t WHERE t.lotacao = :lotacao")})
public class TbRestaurante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estabelecimento")
    private Integer idEstabelecimento;
    @Column(name = "lotacao")
    private Integer lotacao;
    @JoinColumn(name = "id_tipo_comida", referencedColumnName = "id_tipo_comida")
    @ManyToOne
    private TbTipoComida idTipoComida;
    @JoinColumn(name = "id_estabelecimento", referencedColumnName = "id_estabelecimento", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbEstabelecimento tbEstabelecimento;

    public TbRestaurante() {
    }

    public TbRestaurante(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    public TbTipoComida getIdTipoComida() {
        return idTipoComida;
    }

    public void setIdTipoComida(TbTipoComida idTipoComida) {
        this.idTipoComida = idTipoComida;
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
        if (!(object instanceof TbRestaurante)) {
            return false;
        }
        TbRestaurante other = (TbRestaurante) object;
        if ((this.idEstabelecimento == null && other.idEstabelecimento != null) || (this.idEstabelecimento != null && !this.idEstabelecimento.equals(other.idEstabelecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbRestaurante[ idEstabelecimento=" + idEstabelecimento + " ]";
    }
    
}
