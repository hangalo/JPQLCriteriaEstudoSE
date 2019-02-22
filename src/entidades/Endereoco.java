/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "endereoco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereoco.findAll", query = "SELECT e FROM Endereoco e")
    , @NamedQuery(name = "Endereoco.findByIdEndereoco", query = "SELECT e FROM Endereoco e WHERE e.idEndereoco = :idEndereoco")
    , @NamedQuery(name = "Endereoco.findByRua", query = "SELECT e FROM Endereoco e WHERE e.rua = :rua")
    , @NamedQuery(name = "Endereoco.findByCaixapostal", query = "SELECT e FROM Endereoco e WHERE e.caixapostal = :caixapostal")
    , @NamedQuery(name = "Endereoco.findByCidade", query = "SELECT e FROM Endereoco e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Endereoco.findByMunicipio", query = "SELECT e FROM Endereoco e WHERE e.municipio = :municipio")})
public class Endereoco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_endereoco")
    private Integer idEndereoco;
    @Column(name = "rua")
    private String rua;
    @Column(name = "caixapostal")
    private String caixapostal;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "municipio")
    private String municipio;
    @OneToMany(mappedBy = "idEndereoco")
    private Collection<Funcionario> funcionarioCollection;

    public Endereoco() {
    }

    public Endereoco(Integer idEndereoco) {
        this.idEndereoco = idEndereoco;
    }

    public Integer getIdEndereoco() {
        return idEndereoco;
    }

    public void setIdEndereoco(Integer idEndereoco) {
        this.idEndereoco = idEndereoco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCaixapostal() {
        return caixapostal;
    }

    public void setCaixapostal(String caixapostal) {
        this.caixapostal = caixapostal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereoco != null ? idEndereoco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereoco)) {
            return false;
        }
        Endereoco other = (Endereoco) object;
        if ((this.idEndereoco == null && other.idEndereoco != null) || (this.idEndereoco != null && !this.idEndereoco.equals(other.idEndereoco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpqlcriteriaestudose.Endereoco[ idEndereoco=" + idEndereoco + " ]";
    }
    
}
