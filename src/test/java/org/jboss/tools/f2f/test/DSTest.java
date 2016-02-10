package org.jboss.tools.f2f.test;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;

public class DSTest {
	 
	 @Test
	 public void testDS() throws Exception {
		 
		 MongoClientURI uri = new MongoClientURI("mongodb://redteam:redpassword@ds061415.mongolab.com:61415/buzzword");
		 MongoClient mg = null;
		 mg =  new MongoClient(uri);
		 
		 
		 DBCollection coll = mg.getDB("buzzword").getCollection("raw");
		 DBCursor cur = coll.find();
		 List<String> jsonWords = new ArrayList<String>();
		 while (cur.hasNext()) {  
			 String jsonWord = JSON.serialize(cur.next());
			 jsonWords.add(jsonWord);
			 System.out.println(jsonWord);
	      }
		 mg.close();
		//System.out.println(jsonWords);
		 
		 
		 /*
		 MongoClientURI uri = new MongoClientURI("mongodb://redteam:redpassword@ds061415.mongolab.com:61415/buzzword");
		 MongoClient mg = null;
		 mg =  new MongoClient(uri);
		 
		 
		 DBCollection coll = mg.getDB("buzzword").getCollection("raw");
		 DBCursor cur = coll.find();
		 while (cur.hasNext()) {  
	            System.out.println(cur.next()); 
	         }
		 
		 /*
		 MongoCollection<Document> col =  mg.getDatabase("buzzword").getCollection("raw");
		 FindIterable<Document> iter = col.find();
		 while(iter.iterator().hasNext()){
			 System.out.println(iter.iterator().next());
		 }
		 System.out.println(mg.listDatabases());
		 */
		 mg.close();
	 }

}
