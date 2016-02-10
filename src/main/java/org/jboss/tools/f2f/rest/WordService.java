package org.jboss.tools.f2f.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.tools.f2f.data.WordRepository;

@Path("/word")
@RequestScoped
public class WordService {
	
	@Inject
	private WordRepository wordRepository;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllWords(){
		return wordRepository.getWords();
	}

}
