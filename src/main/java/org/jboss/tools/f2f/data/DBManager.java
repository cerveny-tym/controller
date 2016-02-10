package org.jboss.tools.f2f.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Named
@ApplicationScoped
public class DBManager { 
	
	private String username = System.getProperty("MONGODB_USERNAME", "redteam");
	private String password = System.getProperty("MONGODB_PASSWORD", "redpassword");
	private String mongoUrl = System.getProperty("MONGODB_URL", "ds061415.mongolab.com:61415");
 
  private DB mongoDB;
 
  @PostConstruct
  public void afterCreate() {
	  MongoClient mg = null;
	  MongoClientURI uri = new MongoClientURI("mongodb://"+username+":"+password+"@"+mongoUrl+"/buzzword");
	  mg =  new MongoClient(uri);
		 
		 
	  mongoDB = mg.getDB("buzzword");
  }
  
  public DB getDB(){
	  return mongoDB;
  }
 
}
