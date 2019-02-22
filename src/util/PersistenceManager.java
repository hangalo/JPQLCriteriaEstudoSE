/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author informatica
 */
public class PersistenceManager {

    private EntityManagerFactory emFactory;

    public PersistenceManager() {
        this.emFactory = Persistence.createEntityManagerFactory("JPQLCriteriaEstudoSEPU");
    }

    public EntityManager getEmFactory() {
        return emFactory.createEntityManager();
    }

    public void close() {
        emFactory.close();
    }

}
