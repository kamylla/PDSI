/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamylla
 */
@Entity
@Table(name = "tb_programacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProgramacao.findAll", query = "SELECT t FROM TbProgramacao t"),
    @NamedQuery(name = "TbProgramacao.findByIdProgramacao", query = "SELECT t FROM TbProgramacao t WHERE t.idProgramacao = :idProgramacao"),
    @NamedQuery(name = "TbProgramacao.findByDtEvento", query = "SELECT t FROM TbProgramacao t WHERE t.dtEvento = :dtEvento"),
    @NamedQuery(name = "TbProgramacao.findByHorario", query = "SELECT t FROM TbProgramacao t WHERE t.horario = :horario")})
public class TbProgramacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_programacao")
    private Integer idProgramacao;
    @Column(name = "dt_evento")
    @Temporal(TemporalType.DATE)
    private Date dtEvento;
    @Column(name = "horario")
    private String horario;
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
    @ManyToOne(optional = false)
    private TbEvento idEvento;
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    @ManyToOne(optional = false)
    private TbEndereco idEndereco;

    public TbProgramacao() {
    }

    public TbProgramacao(Integer idProgramacao) {
        this.idProgramacao = idProgramacao;
    }

    public Integer getIdProgramacao() {
        return idProgramacao;
    }

    public void setIdProgramacao(Integer idProgramacao) {
        this.idProgramacao = idProgramacao;
    }

    public Date getDtEvento() {
        return dtEvento;
    }

    public void setDtEvento(Date dtEvento) {
        this.dtEvento = dtEvento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public TbEvento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(TbEvento idEvento) {
        this.idEvento = idEvento;
    }

    public TbEndereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(TbEndereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgramacao != null ? idProgramacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProgramacao)) {
            return false;
        }
        TbProgramacao other = (TbProgramacao) object;
        if ((this.idProgramacao == null && other.idProgramacao != null) || (this.idProgramacao != null && !this.idProgramacao.equals(other.idProgramacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbProgramacao[ idProgramacao=" + idProgramacao + " ]";
    }
    
}
