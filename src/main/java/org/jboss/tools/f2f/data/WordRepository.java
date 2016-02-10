package org.jboss.tools.f2f.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.json.JSONObject;

@ApplicationScoped
public class WordRepository {
	
	@Inject
	DBManager dbManager;
	
	
	
	public String getWords(){
		//return mockupData();
		 DBCollection coll = dbManager.getDB().getCollection("stats");
		 DBCursor cur = coll.find();
		 List<String> jsonWords = new ArrayList<String>();
		 int i = 0;
		 List<Word> words = new ArrayList<Word>();
		 while (cur.hasNext()) {  
			 
			 DBObject obj = cur.next();
			 
			 
			 
			 Object word = obj.get("word");
			 Object count = obj.get("count");
			 Object density1 = obj.get("density");
			 Object freq1 = obj.get("frequency");
			 
			 words.add(new Word((String)word, (Integer)count, (Double)freq1, (Double)density1));
			 
			 /*
			 JSONObject jo = new JSONObject();
			 Map<String,Object> values = new HashMap<String,Object>();
			 values.put("word", word);
			 values.put("count", count);
			 values.put("density", density1);
			 values.put("frequency", freq1);
			 jo.put("words", values);
			 
			 //String jsonWord = JSON.serialize(cur.next());
			 jsonWords.add(jo.toString());
			 i++;
			 */
	      }
		 Collections.sort(words);
		 JSONObject jo = new JSONObject();
		 //Map<String,Object> mapValues = new HashMap<String,Object>();
		 List<Map<String,Object>> values = new ArrayList<Map<String,Object>>();
		 for(int y=0;y<words.size() && y<100000;y++){
			 Word myWord = words.get(y);
			 Map<String,Object> mapValues = new HashMap<String,Object>();
			 mapValues.put("word", myWord.getWord());
			 mapValues.put("count", myWord.getCount());
			 mapValues.put("density", myWord.getDensity());
			 mapValues.put("frequency", myWord.getFrequency());
			 values.add(mapValues);
			 //String jsonWord = JSON.serialize(cur.next());
			
		 }
		 jo.put("words", values);
		 return jo.toString();
		
		 
		 
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
