conn = new Mongo("localhost:27017");
db = conn.getDB("college2");
coll = db.getCollection("section");

//Add first section
var oid1 = new ObjectId()

doc = ({_id: oid1, sectionID: "ISTE12301", title: "My Database Course", creditHours:"3",room:"GOL-2650"})

coll.insert(doc)

//coll.find()

// Add second section
oid2 = new ObjectId()

doc = ({_id: oid2, sectionID: "ISTE23401", title: "My Other Database Course", creditHours:"4",room:"GOL-2620"})

coll.insert(doc)

db.section.find()
// set up student for the section
// $ref is Name of collection / $id is oid / $db is name of database

coll = db.getCollection("Student")

doc = {"section":  {$ref: "section", $id: oid1, $db: "college2"}, "uid" : "123456789", "firstName" : "Ivona", "lastName":"Bok","year":"3","mySection":"ISTE12301"}
coll.insert(doc)

doc = {"section":  {$ref: "section", $id: oid1, $db: "college2"}, "uid" : "234567890", "firstName" : "Ivan", "lastName":"Smith","year":"4","mySection":"ISTE12301" }
coll.insert(doc)

doc = {"section":  {$ref: "section", $id: oid2, $db: "college2"}, "uid" : "234567890", "firstName" : "Ivan", "lastName":"Smith","year":"4","mySection":"ISTE23401" }
coll.insert(doc)

doc = {"section":  {$ref: "section", $id: oid2, $db: "college2"}, "uid" : "345678901", "firstName" : "Sally", "lastName":"Struthers","year":"3","mySection":"ISTE23401" }
coll.insert(doc)

//Student = db.Email.findOne({"uid":/123456789/}) 

//dbRef = Student.section 

//db[dbRef.$ref].findOne({"_id":(dbRef.$id)})

coll = db.getCollection("section");
cursor = coll.find();
while (cursor.hasNext()) {
	doc = cursor.next();
	printjson(doc);
}

coll = db.getCollection("Student");
cursor = coll.find();
while (cursor.hasNext()) {
	doc = cursor.next();
	dbRef = doc.section;
	
	doc2 = db[dbRef.$ref].findOne({_id: dbRef.$id});
	printjson(doc.uid + " "+ doc.firstName+" "+doc.lastName+" " + doc2.sectionID + " " + doc2.title);
}


	