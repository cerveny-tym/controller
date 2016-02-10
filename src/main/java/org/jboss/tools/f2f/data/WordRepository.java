package org.jboss.tools.f2f.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.f2f.model.Word;

@ApplicationScoped
public class WordRepository {
	
	@Inject
    private EntityManager em;
	
	public List<Word> getWords(){
		List<Word> words = em.createQuery("SELECT w FROM Words w").getResultList();
		return words;
	}

}
