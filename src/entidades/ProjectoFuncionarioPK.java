/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author informatica
 */
@Embeddable
public class ProjectoFuncionarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_projecto")
    private int idProjecto;
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private int idFuncionario;

    public ProjectoFuncionarioPK() {
    }

    public ProjectoFuncionarioPK(int idProjecto, int idFuncionario) {
        this.idProjecto = idProjecto;
        this.idFuncionario = idFuncionario;
    }

    public int getIdProjecto() {
        return idProjecto;
    }

    public void setIdProjecto(int idProjecto) {
        this.idProjecto = idProjecto;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProjecto;
        hash += (int) idFuncionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectoFuncionarioPK)) {
            return false;
        }
        ProjectoFuncionarioPK other = (ProjectoFuncionarioPK) object;
        if (this.idProjecto != other.idProjecto) {
            return false;
        }
        if (this.idFuncionario != other.idFuncionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpqlcriteriaestudose.ProjectoFuncionarioPK[ idProjecto=" + idProjecto + ", idFuncionario=" + idFuncionario + " ]";
    }
    
}
