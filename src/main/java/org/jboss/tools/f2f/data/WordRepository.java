package org.jboss.tools.f2f.data;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bson.Document;
import org.jboss.tools.f2f.model.Word;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;

@ApplicationScoped
public class WordRepository {
	
	public List<String> getWords(){
		 MongoClientURI uri = new MongoClientURI("mongodb://redteam:redpassword@ds061415.mongolab.com:61415/buzzword");
		 MongoClient mg = null;
		 mg =  new MongoClient(uri);
		 
		 
		 DBCollection coll = mg.getDB("buzzword").getCollection("raw");
		 DBCursor cur = coll.find();
		 List<String> jsonWords = new ArrayList<String>();
		 while (cur.hasNext()) {  
			 String jsonWord = JSON.serialize(cur);
			 jsonWords.add(jsonWord);
	      }
		 mg.close();
		 return jsonWords;
	}

}
