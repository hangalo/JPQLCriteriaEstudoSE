/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "telefome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefome.findAll", query = "SELECT t FROM Telefome t")
    , @NamedQuery(name = "Telefome.findByIdTelefome", query = "SELECT t FROM Telefome t WHERE t.idTelefome = :idTelefome")
    , @NamedQuery(name = "Telefome.findByTipo", query = "SELECT t FROM Telefome t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Telefome.findByNumero", query = "SELECT t FROM Telefome t WHERE t.numero = :numero")
    , @NamedQuery(name = "Telefome.findByCodigoArea", query = "SELECT t FROM Telefome t WHERE t.codigoArea = :codigoArea")})
public class Telefome implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_telefome")
    private Integer idTelefome;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "numero")
    private String numero;
    @Column(name = "codigo_area")
    private String codigoArea;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public Telefome() {
    }

    public Telefome(Integer idTelefome) {
        this.idTelefome = idTelefome;
    }

    public Integer getIdTelefome() {
        return idTelefome;
    }

    public void setIdTelefome(Integer idTelefome) {
        this.idTelefome = idTelefome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefome != null ? idTelefome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefome)) {
            return false;
        }
        Telefome other = (Telefome) object;
        if ((this.idTelefome == null && other.idTelefome != null) || (this.idTelefome != null && !this.idTelefome.equals(other.idTelefome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpqlcriteriaestudose.Telefome[ idTelefome=" + idTelefome + " ]";
    }
    
}
