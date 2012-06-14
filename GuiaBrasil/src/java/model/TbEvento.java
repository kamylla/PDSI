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
@Table(name = "tb_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEvento.findAll", query = "SELECT t FROM TbEvento t"),
    @NamedQuery(name = "TbEvento.findByIdEvento", query = "SELECT t FROM TbEvento t WHERE t.idEvento = :idEvento"),
    @NamedQuery(name = "TbEvento.findByNmEvento", query = "SELECT t FROM TbEvento t WHERE t.nmEvento = :nmEvento"),
    @NamedQuery(name = "TbEvento.findByDescricao", query = "SELECT t FROM TbEvento t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbEvento.findByImagem", query = "SELECT t FROM TbEvento t WHERE t.imagem = :imagem")})
public class TbEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_evento")
    private Integer idEvento;
    @Column(name = "nm_evento")
    private String nmEvento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "imagem")
    private String imagem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private Collection<TbProgramacao> tbProgramacaoCollection;

    public TbEvento() {
    }

    public TbEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNmEvento() {
        return nmEvento;
    }

    public void setNmEvento(String nmEvento) {
        this.nmEvento = nmEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @XmlTransient
    public Collection<TbProgramacao> getTbProgramacaoCollection() {
        return tbProgramacaoCollection;
    }

    public void setTbProgramacaoCollection(Collection<TbProgramacao> tbProgramacaoCollection) {
        this.tbProgramacaoCollection = tbProgramacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEvento)) {
            return false;
        }
        TbEvento other = (TbEvento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbEvento[ idEvento=" + idEvento + " ]";
    }
    
}
