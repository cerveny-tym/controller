package org.jboss.tools.f2f.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {

    @Produces
    @PersistenceContext(unitName = "mongo-ogm")
    private EntityManager em;
    
}