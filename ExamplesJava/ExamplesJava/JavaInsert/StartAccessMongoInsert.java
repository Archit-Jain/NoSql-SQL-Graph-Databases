import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//Mongo Imports	
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
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

public class AccessMongoInsert extends JFrame {

	JTextField msg;
   JTextField ipId;
   JTextField ipFromUser;
   JTextField ipFromUserName;
   JTextField ipText;
   JTextField ipTweetCnt;
	//JTextArea output;
	
	MongoDatabase sampleDB = null;
   MongoClient client = null;
	MongoCollection<Document> collection = null;
	MongoCursor<Document> cursor = null;
   WindowListener exitListener = null;
	
	public AccessMongoInsert() {
		setSize(600, 200);
		setLocation(400, 500);
		setTitle("Access MongoDB");
		
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout() );
      		
		JButton insert = new JButton("Insert");
		JButton connect = new JButton("Connect");
		JButton clear = new JButton("Clear");
		
		ipId = new JTextField(20);
      ipFromUser = new JTextField(20);
      ipFromUserName = new JTextField(20);
      ipText = new JTextField(20);
      ipTweetCnt = new JTextField(20);
      msg = new JTextField(20);
      
      JLabel lblId = new JLabel("id:", JLabel.RIGHT);
      JLabel lblFromUser = new JLabel("fromUser:", JLabel.RIGHT);
      JLabel lblFromUserName = new JLabel("fromUserName:", JLabel.RIGHT);
      JLabel lblText = new JLabel("text:", JLabel.RIGHT);
      JLabel lblTweetCnt = new JLabel("tweetCnt:", JLabel.RIGHT);
      
		
		//output = new JTextArea(10, 30);
		//JScrollPane spOutput = new JScrollPane(output);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		northPanel.add(connect);
      northPanel.add(msg);
		northPanel.add(insert);
		northPanel.add(clear);
      
      JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 2));
      centerPanel.add(lblId);
      centerPanel.add(ipId);
      centerPanel.add(lblFromUser);
      centerPanel.add(ipFromUser);
      centerPanel.add(lblFromUserName);
      centerPanel.add(ipFromUserName);
      centerPanel.add(lblText);
      centerPanel.add(ipText);
      centerPanel.add(lblTweetCnt);
      centerPanel.add(ipTweetCnt);
		
		cont.add(northPanel, BorderLayout.NORTH);
      cont.add(centerPanel, BorderLayout.CENTER);
      			
		//cont.add(spOutput, BorderLayout.CENTER);
		
		connect.addActionListener(new ConnectMongo());
		insert.addActionListener(new InsertMongo());
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
      
      
      AccessMongoInsert runIt = new AccessMongoInsert();
	
	}//main
	
	class ConnectMongo implements ActionListener {
		public void actionPerformed (ActionEvent event) {
		//in this section open the connection to MongoDB. 
		//You should enter the code to connect to the database here
		//Remember to connect to MongoDB, connect to the database and connect to the 
		//    desired collection
		
		//INSERT CONNECTION CODE HERE
		
		//connect to server
		
		
		//access the database
      
				
		//get the collection
		
		
		}//actionPerformed
	
	
	}//class ConnectMongo
	
	class InsertMongo implements ActionListener {
		public void actionPerformed (ActionEvent event) {
		// In this section you should insert data into the collection
		
         //System.out.println("\n\nHERE\n\n");
         //BasicDBObject
         
         

           
	
	    }//actionPerformed
	}//class InsertMongo
	
	class ClearMongo implements ActionListener {
		public void actionPerformed (ActionEvent event) {
		//in this section open the connection. Should be able to see if it is not null
		// to see if ti is already open
			msg.setText("");
         ipId.setText("");
         ipFromUser.setText("");
         ipFromUserName.setText("");
         ipText.setText("");
         ipTweetCnt.setText("");


		
		}//actionPerformed
	
	
	}//class ClearMongo


} //class