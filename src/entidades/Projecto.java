/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "projecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projecto.findAll", query = "SELECT p FROM Projecto p")
    , @NamedQuery(name = "Projecto.findByIdProjecto", query = "SELECT p FROM Projecto p WHERE p.idProjecto = :idProjecto")
    , @NamedQuery(name = "Projecto.findByNome", query = "SELECT p FROM Projecto p WHERE p.nome = :nome")
    , @NamedQuery(name = "Projecto.findByTipo", query = "SELECT p FROM Projecto p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Projecto.findByOrcamento", query = "SELECT p FROM Projecto p WHERE p.orcamento = :orcamento")})
public class Projecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_projecto")
    private Integer idProjecto;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orcamento")
    private Double orcamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projecto")
    private Collection<ProjectoFuncionario> projectoFuncionarioCollection;
    @JoinColumn(name = "id_lider", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario idLider;

    public Projecto() {
    }

    public Projecto(Integer idProjecto) {
        this.idProjecto = idProjecto;
    }

    public Integer getIdProjecto() {
        return idProjecto;
    }

    public void setIdProjecto(Integer idProjecto) {
        this.idProjecto = idProjecto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    @XmlTransient
    public Collection<ProjectoFuncionario> getProjectoFuncionarioCollection() {
        return projectoFuncionarioCollection;
    }

    public void setProjectoFuncionarioCollection(Collection<ProjectoFuncionario> projectoFuncionarioCollection) {
        this.projectoFuncionarioCollection = projectoFuncionarioCollection;
    }

    public Funcionario getIdLider() {
        return idLider;
    }

    public void setIdLider(Funcionario idLider) {
        this.idLider = idLider;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProjecto != null ? idProjecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projecto)) {
            return false;
        }
        Projecto other = (Projecto) object;
        if ((this.idProjecto == null && other.idProjecto != null) || (this.idProjecto != null && !this.idProjecto.equals(other.idProjecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpqlcriteriaestudose.Projecto[ idProjecto=" + idProjecto + " ]";
    }
    
}
