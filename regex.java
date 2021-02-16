//Mongo Imports	
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.*;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Filters;

//Log message control imports
import java.util.logging.Logger;
import java.util.logging.Level;

//Java imports
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class SimpleJavaFind{
// Attribute used by Mongo in several methods
   MongoDatabase sampleDB = null;
   MongoClient client = null;
   MongoCollection<Document> collection = null;
	MongoCursor<Document> cursor = null;
   MongoIterable<String> dbList = null;
   MongoIterable<String> collList = null;

      
   public static void main(String[] args) {
      SimpleJavaFind app = new SimpleJavaFind();
// Make the connection
      boolean success = app.connections();
      //System.out.println("HERE " + success);

      if(success) {
      // find
         app.mongoFind();
         app.closeMongo();
      }   
   } //main
   
   public boolean connections() { //boolean returns true if connections are successful
      
      //boolean to return is connections are success or not
      boolean connSuccess = false;
      
// Connect to the Mongo Database
      //client = MongoClients.create(); //note client is a MongoClient (no s) but create() in the MongoClients class
      client = MongoClients.create("mongodb://localhost:27017"); 
         
	   System.out.println("\nConnection to server completed\n");
		try { // Use try/catch so that you will always close the database (finally)
      
//Get a List of databases on the server connection
         
         dbList = client.listDatabaseNames();
//Does Database Exist?
         String dbName = "SampleSocial";      
         if (objectExists(dbList, dbName)) {  //returns true or false
           System.out.println("\nDatabase found\n");
           sampleDB = client.getDatabase(dbName); //connect to the database
           System.out.println("\nConnection to database completed\n");
           connSuccess = true;
         }
         else {  //db not found
           System.out.println("\nDATABASE NOT FOUND\n");
           sampleDB = null; //DB not found
           connSuccess = false;
           client.close();
           return connSuccess;
         }
            		
//Get a List of collections in the database
         
         collList = sampleDB.listCollectionNames();
          				
//get the collection
         String colName = "Tweets";		
         if (objectExists(collList, colName)) {  //returns true or false
            System.out.println("\nCollection found\n");
            collection = sampleDB.getCollection(colName); 
            System.out.println("\nCollection connection completed\n");
         }
         else {  //collection not found
            System.out.println("\nCOLLECTION NOT FOUND\n");
            collection = null;
            connSuccess = false;
            client.close();
            return connSuccess;
         } 
      } catch (Exception e) {
         e.printStackTrace();
      }     
      return connSuccess;  
   }//connections
   
   private void mongoFind() {
   
 //Find a string
      
      //FIND AND 
      String regexPattern1 = "\\b" + "dish" + "\\b.*";
      String regexPattern2 = "\\b" + "good" + "\\b.*";

      cursor = collection.find(and(regex("text", regexPattern1, "i"),regex("text", regexPattern2, "i"))).iterator();
      //traverse cursor
      int cnt = 0; 
         
      while(cursor.hasNext()) {
         Document d = cursor.next();
         //System.out.println(d.toJson() + "\n");
         System.out.println(d.getInteger("id") + " " +d.getString("fromUser") + " " + d.getString("text"));
         cnt = cnt+1;
      }  
         
      System.out.println("\nThe count is for AND : " + cnt + "\n");
      
     } //findMongo
   
   private boolean objectExists(MongoIterable <String> objectList,  String objectName) {
      //ArrayList<String> objectNames = objectCursor;//getCollectionNames();
      for (String name : objectList) {
         if (name.equals(objectName)) {
            return true;
         }
      } 
    return false;
   }//objectExists
   
   private void closeMongo() {
      client.close();
   } //closeMongo
}//class
