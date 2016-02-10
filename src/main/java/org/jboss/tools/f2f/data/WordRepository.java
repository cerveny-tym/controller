package org.jboss.tools.f2f.data;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bson.Document;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;

import org.json.JSONObject;

@ApplicationScoped
public class WordRepository {
	
	private String username = System.getProperty("MONGODB_USERNAME", "redteam");
	private String password = System.getProperty("MONGODB_PASSWORD", "redpassword");
	private String mongoUrl = System.getProperty("MONGODB_URL", "ds061415.mongolab.com:61415");
	
	public List<String> getWords(){
		//return mockupData();
		
		MongoClient mg = null;
		try {
		 MongoClientURI uri = new MongoClientURI("mongodb://"+username+":"+password+"@"+mongoUrl+"/buzzword");
		 mg =  new MongoClient(uri);
		 
		 
		 DBCollection coll = mg.getDB("buzzword").getCollection("stats");
		 DBCursor cur = coll.find();
		 List<String> jsonWords = new ArrayList<String>();
		 int i = 0;
		 while (cur.hasNext() && i<1000) {  
			 DBObject obj = cur.next();
			 Object word = obj.get("word");
			 Object count = obj.get("count");
			 Object density1 = obj.get("density");
			 Object freq1 = obj.get("frequency");
			 Object density =  ((Double) density1).intValue();
			 
			 Object frequency =  ((Double) freq1).intValue();
			 
			 JSONObject jo = new JSONObject();
			 Map<String,Object> values = new HashMap<String,Object>();
			 values.put("word", word);
			 values.put("count", count);
			 values.put("density", density);
			 values.put("frequency", frequency);
			 jo.put("words", values);
			 
			 //String jsonWord = JSON.serialize(cur.next());
			 jsonWords.add(jo.toString());
			 i++;
	      }
		 return jsonWords;
		} finally {
			if (mg != null) {
				mg.close();;
			}
		}
		
		 
		 
	}
	
	public List<String> mockupData(){
		List<String> mData = new ArrayList<String>();
		JSONObject jo = new JSONObject();
		Map<String,String> values = new HashMap<String,String>();
		values.put("word", "my_word1");
		values.put("count", "1");
		values.put("frequency", "2");
		values.put("density", "3");
		jo.put("words", values);
		mData.add(jo.toString());
		return mData;
		
	}

}
