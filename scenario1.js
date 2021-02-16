conn = new Mongo("localhost:27017");
db = conn.getDB("College1");
coll = db.getCollection("section");

//Add first Section

doc = ({sectionID: "ISTE12301", title: "My Database Course", creditHours:"3",room:"GOL-2650",
	Student: [{"uid" : "123456789", "firstName" : "Ivona", "lastName":"Bok","year":"3","mySection":"ISTE12301"},{"uid" : "234567890", "firstName" : "Ivan", "lastName":"Smith","year":"4","mySection":"ISTE12301"}]})

coll.insert(doc)

// Add second Section

doc = ({sectionID: "ISTE23401", title: "My Other Database Course", creditHours:"4",room:"GOL-2620", Student:[{"uid" : "234567890", "firstName" : "Ivan", "lastName":"Smith","year":"4","mySection":"ISTE23401"},{"uid" : "345678901", "firstName" : "Sally", "lastName":"Struthers","year":"3","mySection":"ISTE23401"}]})

coll.insert(doc)

//cursor = coll.find();

print("\nThis is the original document\n\n");
cursor = coll.find()
while (cursor.hasNext()) {
	doc = cursor.next();
	printjson(doc);
}
print("\nThis is the document unwound\n\n");
cursor = coll.aggregate( [ { $unwind: "$Student"}])
while (cursor.hasNext()) {
	doc = cursor.next();
	printjson(doc);
}	



