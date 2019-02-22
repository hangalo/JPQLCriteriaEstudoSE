/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpqlcriteriaestudose;

import entidades.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metodos.Metodos;
import util.PersistenceManager;

/**
 *
 * @author informatica
 */
public class JPQLCriteriaEstudoSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        metodos.listaFuncionarios();
        
    }

}
