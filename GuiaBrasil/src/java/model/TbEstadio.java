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
@Table(name = "tb_estadio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEstadio.findAll", query = "SELECT t FROM TbEstadio t"),
    @NamedQuery(name = "TbEstadio.findByIdEstabelecimento", query = "SELECT t FROM TbEstadio t WHERE t.idEstabelecimento = :idEstabelecimento"),
    @NamedQuery(name = "TbEstadio.findByLotacao", query = "SELECT t FROM TbEstadio t WHERE t.lotacao = :lotacao")})
public class TbEstadio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estabelecimento")
    private Integer idEstabelecimento;
    @Column(name = "lotacao")
    private Integer lotacao;
    @JoinColumn(name = "id_estabelecimento", referencedColumnName = "id_estabelecimento", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbEstabelecimento tbEstabelecimento;

    public TbEstadio() {
    }

    public TbEstadio(Integer idEstabelecimento) {
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
        if (!(object instanceof TbEstadio)) {
            return false;
        }
        TbEstadio other = (TbEstadio) object;
        if ((this.idEstabelecimento == null && other.idEstabelecimento != null) || (this.idEstabelecimento != null && !this.idEstabelecimento.equals(other.idEstabelecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbEstadio[ idEstabelecimento=" + idEstabelecimento + " ]";
    }
    
}
