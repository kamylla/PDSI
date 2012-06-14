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
@Table(name = "tb_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEndereco.findAll", query = "SELECT t FROM TbEndereco t"),
    @NamedQuery(name = "TbEndereco.findByIdEndereco", query = "SELECT t FROM TbEndereco t WHERE t.idEndereco = :idEndereco"),
    @NamedQuery(name = "TbEndereco.findByNmEndereco", query = "SELECT t FROM TbEndereco t WHERE t.nmEndereco = :nmEndereco"),
    @NamedQuery(name = "TbEndereco.findByNrEndereco", query = "SELECT t FROM TbEndereco t WHERE t.nrEndereco = :nrEndereco"),
    @NamedQuery(name = "TbEndereco.findByNmBairro", query = "SELECT t FROM TbEndereco t WHERE t.nmBairro = :nmBairro"),
    @NamedQuery(name = "TbEndereco.findByNmComplemento", query = "SELECT t FROM TbEndereco t WHERE t.nmComplemento = :nmComplemento"),
    @NamedQuery(name = "TbEndereco.findByNrTelefone", query = "SELECT t FROM TbEndereco t WHERE t.nrTelefone = :nrTelefone")})
public class TbEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_endereco")
    private Integer idEndereco;
    @Column(name = "nm_endereco")
    private String nmEndereco;
    @Column(name = "nr_endereco")
    private String nrEndereco;
    @Column(name = "nm_bairro")
    private String nmBairro;
    @Column(name = "nm_complemento")
    private String nmComplemento;
    @Column(name = "nr_telefone")
    private String nrTelefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEndereco")
    private Collection<TbProgramacao> tbProgramacaoCollection;
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    @ManyToOne
    private TbCidade idCidade;
    @OneToMany(mappedBy = "idEndereco")
    private Collection<TbEstabelecimento> tbEstabelecimentoCollection;

    public TbEndereco() {
    }

    public TbEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNmEndereco() {
        return nmEndereco;
    }

    public void setNmEndereco(String nmEndereco) {
        this.nmEndereco = nmEndereco;
    }

    public String getNrEndereco() {
        return nrEndereco;
    }

    public void setNrEndereco(String nrEndereco) {
        this.nrEndereco = nrEndereco;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getNmComplemento() {
        return nmComplemento;
    }

    public void setNmComplemento(String nmComplemento) {
        this.nmComplemento = nmComplemento;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    @XmlTransient
    public Collection<TbProgramacao> getTbProgramacaoCollection() {
        return tbProgramacaoCollection;
    }

    public void setTbProgramacaoCollection(Collection<TbProgramacao> tbProgramacaoCollection) {
        this.tbProgramacaoCollection = tbProgramacaoCollection;
    }

    public TbCidade getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(TbCidade idCidade) {
        this.idCidade = idCidade;
    }

    @XmlTransient
    public Collection<TbEstabelecimento> getTbEstabelecimentoCollection() {
        return tbEstabelecimentoCollection;
    }

    public void setTbEstabelecimentoCollection(Collection<TbEstabelecimento> tbEstabelecimentoCollection) {
        this.tbEstabelecimentoCollection = tbEstabelecimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEndereco)) {
            return false;
        }
        TbEndereco other = (TbEndereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbEndereco[ idEndereco=" + idEndereco + " ]";
    }
    
}
