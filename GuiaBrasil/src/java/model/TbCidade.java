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
@Table(name = "tb_cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCidade.findAll", query = "SELECT t FROM TbCidade t"),
    @NamedQuery(name = "TbCidade.findByIdCidade", query = "SELECT t FROM TbCidade t WHERE t.idCidade = :idCidade"),
    @NamedQuery(name = "TbCidade.findByNmCidade", query = "SELECT t FROM TbCidade t WHERE t.nmCidade = :nmCidade"),
    @NamedQuery(name = "TbCidade.findByPopulacao", query = "SELECT t FROM TbCidade t WHERE t.populacao = :populacao"),
    @NamedQuery(name = "TbCidade.findByArea", query = "SELECT t FROM TbCidade t WHERE t.area = :area"),
    @NamedQuery(name = "TbCidade.findByPib", query = "SELECT t FROM TbCidade t WHERE t.pib = :pib"),
    @NamedQuery(name = "TbCidade.findByDescricao", query = "SELECT t FROM TbCidade t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbCidade.findByImagem", query = "SELECT t FROM TbCidade t WHERE t.imagem = :imagem")})
public class TbCidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cidade")
    private Integer idCidade;
    @Column(name = "nm_cidade")
    private String nmCidade;
    @Column(name = "populacao")
    private String populacao;
    @Column(name = "area")
    private String area;
    @Column(name = "pib")
    private String pib;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "imagem")
    private String imagem;
    @OneToMany(mappedBy = "idCidade")
    private Collection<TbEndereco> tbEnderecoCollection;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private TbEstado idEstado;

    public TbCidade() {
    }

    public TbCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
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
    public Collection<TbEndereco> getTbEnderecoCollection() {
        return tbEnderecoCollection;
    }

    public void setTbEnderecoCollection(Collection<TbEndereco> tbEnderecoCollection) {
        this.tbEnderecoCollection = tbEnderecoCollection;
    }

    public TbEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TbEstado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidade)) {
            return false;
        }
        TbCidade other = (TbCidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCidade[ idCidade=" + idCidade + " ]";
    }
    
}
