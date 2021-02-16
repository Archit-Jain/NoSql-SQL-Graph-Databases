import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class AccessMongoStart extends JFrame {

	JTextField input;
	JTextArea output;
	
	MongoDatabase sampleDB = null;
   MongoClient client = null;
	MongoCollection<Document> collection = null;
	MongoCursor<Document> cursor = null;
   MongoCursor<String> dbList = null;
   MongoCursor<String> collList =null;
   WindowListener exitListener = null;
	
	public AccessMongoStart() {
		setSize(600, 200);
		setLocation(400, 500);
		setTitle("Access MongoDB");
		
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout() );
		
		JButton search = new JButton("Search");
		JButton connect = new JButton("Connect");
		JButton clear = new JButton("Clear");
		
		input = new JTextField(20);
		
		output = new JTextArea(10, 30);
		JScrollPane spOutput = new JScrollPane(output);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		northPanel.add(connect);
		northPanel.add(input);
		northPanel.add(search);
		northPanel.add(clear);
		
		cont.add(northPanel, BorderLayout.NORTH);
				
		cont.add(spOutput, BorderLayout.CENTER);
		
		connect.addActionListener(new ConnectMongo());
		search.addActionListener(new GetMongo());
		clear.addActionListener(new ClearMongo());
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      
      exitListener = new WindowAdapter() {

         @Override
         public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(
               null, "Are You Sure to Close Application?", 
               "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
               JOptionPane.QUESTION_MESSAGE, null, null, null);
            
            if (confirm == 0) {
               // Close the Mongo Client
               client.close();
               
               System.exit(0);
            }
         }
      };
      
      addWindowListener(exitListener);



		setVisible(true);
		
	
	} //AccessMongo
	
	public static void main (String [] args) {
		
   // The following statements are used to eliminate MongoDB Logging
   //   information suche as INFO messages that the user should not see.
   // It requires the import of Logger and Level classes.
      //Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
      //mongoLogger.setLevel(Level.INFO); 
      
      
      AccessMongoStart runIt = new AccessMongoStart();
	
	}//main
	
	class ConnectMongo implements ActionListener {
		public void actionPerformed (ActionEvent event) {
		//in this section open the connection to MongoDB. 
		//You should enter the code to connect to the database here
		//Remember to connect to MongoDB, connect to the database and connect to the 
		//    desired collection
      
//Access the server 

        
	   output.append("Connection to server completed\n");
		         	
//access the database
     
           
		output.append("Connection to database completed\n");
 				
//get the collection
		
             
		output.append("Collection obtained\n");
				
		}//actionPerformed
	
	
	}//class ConnectMongo
	
	class GetMongo implements ActionListener {
		public void actionPerformed (ActionEvent event) {
		// In this section you should retrieve the data from the collection
		// and use a cursor to list the data in the output JTextArea
       

//Normal Find regex                 
     
//Set counter and print results (process the cursor)
         int cnt = 0; 
         
          
         output.append("\nhe count is " + cnt + "\n");      
         
         	
	     	}//actionPerformed
	}//class GetMongo
	
	class ClearMongo implements ActionListener {
		public void actionPerformed (ActionEvent event) {
		//in this section open the connection. Should be able to see if it is not null
		// to see if ti is already open
			output.setText("");
		
		}//actionPerformed
	
	
	}//class ClearMongo


} //class