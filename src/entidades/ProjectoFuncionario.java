/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "projecto_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectoFuncionario.findAll", query = "SELECT p FROM ProjectoFuncionario p")
    , @NamedQuery(name = "ProjectoFuncionario.findByIdProjecto", query = "SELECT p FROM ProjectoFuncionario p WHERE p.projectoFuncionarioPK.idProjecto = :idProjecto")
    , @NamedQuery(name = "ProjectoFuncionario.findByIdFuncionario", query = "SELECT p FROM ProjectoFuncionario p WHERE p.projectoFuncionarioPK.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "ProjectoFuncionario.findByEntrada", query = "SELECT p FROM ProjectoFuncionario p WHERE p.entrada = :entrada")
    , @NamedQuery(name = "ProjectoFuncionario.findBySaida", query = "SELECT p FROM ProjectoFuncionario p WHERE p.saida = :saida")
    , @NamedQuery(name = "ProjectoFuncionario.findByObservacoes", query = "SELECT p FROM ProjectoFuncionario p WHERE p.observacoes = :observacoes")})
public class ProjectoFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectoFuncionarioPK projectoFuncionarioPK;
    @Column(name = "entrada")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Column(name = "saida")
    @Temporal(TemporalType.DATE)
    private Date saida;
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "id_projecto", referencedColumnName = "id_projecto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projecto projecto;

    public ProjectoFuncionario() {
    }

    public ProjectoFuncionario(ProjectoFuncionarioPK projectoFuncionarioPK) {
        this.projectoFuncionarioPK = projectoFuncionarioPK;
    }

    public ProjectoFuncionario(int idProjecto, int idFuncionario) {
        this.projectoFuncionarioPK = new ProjectoFuncionarioPK(idProjecto, idFuncionario);
    }

    public ProjectoFuncionarioPK getProjectoFuncionarioPK() {
        return projectoFuncionarioPK;
    }

    public void setProjectoFuncionarioPK(ProjectoFuncionarioPK projectoFuncionarioPK) {
        this.projectoFuncionarioPK = projectoFuncionarioPK;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Projecto getProjecto() {
        return projecto;
    }

    public void setProjecto(Projecto projecto) {
        this.projecto = projecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectoFuncionarioPK != null ? projectoFuncionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectoFuncionario)) {
            return false;
        }
        ProjectoFuncionario other = (ProjectoFuncionario) object;
        if ((this.projectoFuncionarioPK == null && other.projectoFuncionarioPK != null) || (this.projectoFuncionarioPK != null && !this.projectoFuncionarioPK.equals(other.projectoFuncionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpqlcriteriaestudose.ProjectoFuncionario[ projectoFuncionarioPK=" + projectoFuncionarioPK + " ]";
    }
    
}
