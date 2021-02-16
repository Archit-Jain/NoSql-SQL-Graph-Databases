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

public class SimpleJavaConnect{
   
      
   public static void main(String[] args) {
      new SimpleJavaConnect().connections();
   } //main
   
   public void connections() {
// If these varlable are to be used across multiple methods that they need to declared as attributes.
//    You will see this in later examples also. (Remember the scope issue in Java)
      MongoDatabase sampleDB = null;
      MongoClient client = null;
	   MongoCollection<Document> collection = null;
	   MongoCursor<Document> cursor = null;
      MongoIterable<String> dbList = null;
      MongoIterable<String> collList = null;
      
// Connect to the Mongo Database
      //client = MongoClients.create(); //note client is a MongoClient (no s) but create() in the MongoClients class
      client = MongoClients.create("mongodb://localhost:27017"); 
         
	   System.out.println("\nConnection to server completed\n");
		try { // Use try/catch so that you will always close the database (finally)
      
//Get a List of databases on the server connection
         
         dbList = client.listDatabaseNames();
         System.out.println("\nLIST OF DATABASES\n");
     
         for (String s : dbList) {
            System.out.println(s);
         }
//Does Database Exist?
         String dbName = "SampleSocial";
         if (objectExists(dbList, dbName)) {  //returns true or false
           System.out.println("\nDatabase found\n");
           sampleDB = client.getDatabase(dbName); //connect to the database
           System.out.println("\nConnection to database completed\n");
         }
         else {  //db not found
           System.out.println("\nDATABASE NOT FOUND\n");
           sampleDB = null; //DB not found
         }
            		
//Get a List of collections in the database
         collList = sampleDB.listCollectionNames();
         System.out.println("\nLIST OF COLLECTIONS\n");
     
         for (String s : collList) {
            System.out.println(s); 
         }
 				
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
         }  
      } catch (Exception e) {
         e.printStackTrace();
      }     
      finally { //always close the db
         client.close();
      }
        
   }//connections
   
   private boolean objectExists(MongoIterable <String> objectList,  String objectName) {
      //ArrayList<String> objectNames = objectCursor;//getCollectionNames();
      for (String name : objectList) {
         if (name.equals(objectName)) {
            return true;
         }
      } 
    return false;
   }//objectExists
 
}//class
