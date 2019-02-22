/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import entidades.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import util.PersistenceManager;

/**
 *
 * @author informatica
 */
public class Metodos {

    PersistenceManager manager = new PersistenceManager();
    EntityManager em = manager.getEmFactory();

    public void listaFuncionarios() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
        Root<Funcionario> funcionarioRoot = cq.from(Funcionario.class);
        cq.select(funcionarioRoot);
        TypedQuery<Funcionario> q = em.createQuery(cq);
        List<Funcionario> funcionarios = q.getResultList();

        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Sobrenome: " + funcionario.getSobrenome());
        }

    }
    
    
    
    
    
}
