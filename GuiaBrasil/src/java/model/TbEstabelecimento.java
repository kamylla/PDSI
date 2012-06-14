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
@Table(name = "tb_estabelecimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEstabelecimento.findAll", query = "SELECT t FROM TbEstabelecimento t"),
    @NamedQuery(name = "TbEstabelecimento.findByIdEstabelecimento", query = "SELECT t FROM TbEstabelecimento t WHERE t.idEstabelecimento = :idEstabelecimento"),
    @NamedQuery(name = "TbEstabelecimento.findByNmEstabelecimento", query = "SELECT t FROM TbEstabelecimento t WHERE t.nmEstabelecimento = :nmEstabelecimento"),
    @NamedQuery(name = "TbEstabelecimento.findByDescricao", query = "SELECT t FROM TbEstabelecimento t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbEstabelecimento.findByImagem", query = "SELECT t FROM TbEstabelecimento t WHERE t.imagem = :imagem")})
public class TbEstabelecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estabelecimento")
    private Integer idEstabelecimento;
    @Column(name = "nm_estabelecimento")
    private String nmEstabelecimento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "imagem")
    private String imagem;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbEstabelecimento")
    private TbEstadio tbEstadio;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbEstabelecimento")
    private TbPontoTuristico tbPontoTuristico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbEstabelecimento")
    private TbRestaurante tbRestaurante;
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    @ManyToOne
    private TbEndereco idEndereco;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbEstabelecimento")
    private TbHotel tbHotel;

    public TbEstabelecimento() {
    }

    public TbEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public String getNmEstabelecimento() {
        return nmEstabelecimento;
    }

    public void setNmEstabelecimento(String nmEstabelecimento) {
        this.nmEstabelecimento = nmEstabelecimento;
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

    public TbEstadio getTbEstadio() {
        return tbEstadio;
    }

    public void setTbEstadio(TbEstadio tbEstadio) {
        this.tbEstadio = tbEstadio;
    }

    public TbPontoTuristico getTbPontoTuristico() {
        return tbPontoTuristico;
    }

    public void setTbPontoTuristico(TbPontoTuristico tbPontoTuristico) {
        this.tbPontoTuristico = tbPontoTuristico;
    }

    public TbRestaurante getTbRestaurante() {
        return tbRestaurante;
    }

    public void setTbRestaurante(TbRestaurante tbRestaurante) {
        this.tbRestaurante = tbRestaurante;
    }

    public TbEndereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(TbEndereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    public TbHotel getTbHotel() {
        return tbHotel;
    }

    public void setTbHotel(TbHotel tbHotel) {
        this.tbHotel = tbHotel;
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
        if (!(object instanceof TbEstabelecimento)) {
            return false;
        }
        TbEstabelecimento other = (TbEstabelecimento) object;
        if ((this.idEstabelecimento == null && other.idEstabelecimento != null) || (this.idEstabelecimento != null && !this.idEstabelecimento.equals(other.idEstabelecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbEstabelecimento[ idEstabelecimento=" + idEstabelecimento + " ]";
    }
    
}
