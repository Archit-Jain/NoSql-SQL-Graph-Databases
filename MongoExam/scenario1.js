connection = new Mongo('localhost:27017');
db = connection.getDB('Cruise1');
collection = db.getCollection('Cruises');

//1.	Insert the documents into a database called Cruise1, collection Cruises.
doc = ({cruiseID: "1", destination: "Dubrovnik", shipName:"Spirit of the Sea",departDate:"20190502",returnDate:"20190513",
	passenger: [{"passengerID" : "10", "name" : "Sue Smith", "address":"123 Sesame Street"},
	{"passengerID" : "20", "name" : "Fran Jones", "address":"205 West Street"}]})

collection.insert(doc)

doc = ({cruiseID: "2", destination: "Dubrovnik", shipName:"Windjammer",departDate:"20190520",returnDate:"20190525",
	passenger: [{"passengerID" : "20", "name" : "Fran Jones", "address":"205 West Street"},
	{"passengerID" : "30", "name" : "George Jungle", "address":"270 North Fifth Street"}]})
	
collection.insert(doc)
	
doc = ({cruiseID: "3", destination: "Alaska", shipName:"Pacific Princess",departDate:"20190610",returnDate:"20190620",
	passenger: [{"passengerID" : "30", "name" : "George Jungle", "address":"270 North Fifth Street"}]})
	
collection.insert(doc)
//"departDate":"20190502","returnDate":"20190513"



//2.	Write a query to list all the json documents (pretty()) in the Cruises collection.
print("\n Print all json documents in Cruise1 DB\n\n");
cursor = collection.find()
while (cursor.hasNext()) {
	doc = cursor.next();
	printjson(doc);
}




