/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome")
    , @NamedQuery(name = "Funcionario.findBySobrenome", query = "SELECT f FROM Funcionario f WHERE f.sobrenome = :sobrenome")
    , @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario")
    , @NamedQuery(name = "Funcionario.findByDataContato", query = "SELECT f FROM Funcionario f WHERE f.dataContato = :dataContato")
    , @NamedQuery(name = "Funcionario.findByDataFimContrato", query = "SELECT f FROM Funcionario f WHERE f.dataFimContrato = :dataFimContrato")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Double salario;
    @Column(name = "data_contato")
    @Temporal(TemporalType.DATE)
    private Date dataContato;
    @Column(name = "data_fim_contrato")
    @Temporal(TemporalType.DATE)
    private Date dataFimContrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private Collection<Telefome> telefomeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private Collection<ProjectoFuncionario> projectoFuncionarioCollection;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @JoinColumn(name = "id_endereoco", referencedColumnName = "id_endereoco")
    @ManyToOne
    private Endereoco idEndereoco;
    @OneToMany(mappedBy = "idChefe")
    private Collection<Funcionario> funcionarioCollection;
    @JoinColumn(name = "id_chefe", referencedColumnName = "id_funcionario")
    @ManyToOne
    private Funcionario idChefe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLider")
    private Collection<Projecto> projectoCollection;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataContato() {
        return dataContato;
    }

    public void setDataContato(Date dataContato) {
        this.dataContato = dataContato;
    }

    public Date getDataFimContrato() {
        return dataFimContrato;
    }

    public void setDataFimContrato(Date dataFimContrato) {
        this.dataFimContrato = dataFimContrato;
    }

    @XmlTransient
    public Collection<Telefome> getTelefomeCollection() {
        return telefomeCollection;
    }

    public void setTelefomeCollection(Collection<Telefome> telefomeCollection) {
        this.telefomeCollection = telefomeCollection;
    }

    @XmlTransient
    public Collection<ProjectoFuncionario> getProjectoFuncionarioCollection() {
        return projectoFuncionarioCollection;
    }

    public void setProjectoFuncionarioCollection(Collection<ProjectoFuncionario> projectoFuncionarioCollection) {
        this.projectoFuncionarioCollection = projectoFuncionarioCollection;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Endereoco getIdEndereoco() {
        return idEndereoco;
    }

    public void setIdEndereoco(Endereoco idEndereoco) {
        this.idEndereoco = idEndereoco;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public Funcionario getIdChefe() {
        return idChefe;
    }

    public void setIdChefe(Funcionario idChefe) {
        this.idChefe = idChefe;
    }

    @XmlTransient
    public Collection<Projecto> getProjectoCollection() {
        return projectoCollection;
    }

    public void setProjectoCollection(Collection<Projecto> projectoCollection) {
        this.projectoCollection = projectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpqlcriteriaestudose.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
