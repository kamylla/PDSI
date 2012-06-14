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
@Table(name = "tb_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAdmin.findAll", query = "SELECT t FROM TbAdmin t"),
    @NamedQuery(name = "TbAdmin.findByIdAdmin", query = "SELECT t FROM TbAdmin t WHERE t.idAdmin = :idAdmin"),
    @NamedQuery(name = "TbAdmin.findByNmAdmin", query = "SELECT t FROM TbAdmin t WHERE t.nmAdmin = :nmAdmin"),
    @NamedQuery(name = "TbAdmin.findByNrCpf", query = "SELECT t FROM TbAdmin t WHERE t.nrCpf = :nrCpf"),
    @NamedQuery(name = "TbAdmin.findByNrRg", query = "SELECT t FROM TbAdmin t WHERE t.nrRg = :nrRg"),
    @NamedQuery(name = "TbAdmin.findByLogin", query = "SELECT t FROM TbAdmin t WHERE t.login = :login"),
    @NamedQuery(name = "TbAdmin.findBySenha", query = "SELECT t FROM TbAdmin t WHERE t.senha = :senha"),
    @NamedQuery(name = "TbAdmin.findByTelefone", query = "SELECT t FROM TbAdmin t WHERE t.telefone = :telefone"),
    @NamedQuery(name = "TbAdmin.findByEmail", query = "SELECT t FROM TbAdmin t WHERE t.email = :email")})
public class TbAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_admin")
    private Integer idAdmin;
    @Column(name = "nm_admin")
    private String nmAdmin;
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Column(name = "nr_rg")
    private String nrRg;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;

    public TbAdmin() {
    }

    public TbAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNmAdmin() {
        return nmAdmin;
    }

    public void setNmAdmin(String nmAdmin) {
        this.nmAdmin = nmAdmin;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public String getNrRg() {
        return nrRg;
    }

    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdmin != null ? idAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAdmin)) {
            return false;
        }
        TbAdmin other = (TbAdmin) object;
        if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbAdmin[ idAdmin=" + idAdmin + " ]";
    }
    
}
