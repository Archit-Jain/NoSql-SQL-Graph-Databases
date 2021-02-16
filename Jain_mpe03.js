//connection
conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
coll = db.getCollection("Tweets");
print("#1");
//1
result = coll.insert({id:2019091011, fromuser:"archit", text:"This is a test of insert", cnt:1});
printjson(result);
//2
print("#2");
print("The number inserted is: ", result.nInserted); //Prints the fields in the document (# inserted)

cursor = coll.find({id:2019091011});
while(cursor.hasNext()){
	line=cursor.next();
	print(line.fromuser,line.text);
}
//3
print("#3");
result = coll.update({id:2019091011}, {$set:{text:"This is a updated text"}}); //updates one document completely
print(result);
printjson(result);

//4
print("#4");
cursor = coll.find({id:2019091011});

while (cursor.hasNext())
{
	doc = cursor.next();
	print(doc.id, doc.text);
}
//5
print("#5");
result = coll.update({id:2019091011}, {$inc:{cnt:1}}); //increment cnt by 1
print(result);

//6
print("#6");
cursor = coll.find({id:2019091011});
//run through cursor
//print("AFTER");
while (cursor.hasNext())
{
	doc = cursor.next();
	print(doc.id, doc.text);
}

//7
print("#7");
cursor = coll.find({$and: [{id: {$gte: 129745, $lte: 129756}}]});	
while (cursor.hasNext())
{
	doc = cursor.next();
	print(doc.text);
}
//8
print("#8");
doc = coll.findOne({id:2019091011});
printjson(doc);
result = coll.remove({id:2019091011});
print("****After Remove")
doc = coll.findOne({id:2019091011});
printjson(doc);
print("End of data");

//cursor 

//db.Tweets.insert({id:20190910, fromuser:"archit", text:"This is a test of insert", cnt:1}).pretty()
//db.Tweets.insert({id:20190910, fromuser:"archit", text:"This is a test of insert", cnt:1})
//db.Tweets.update({id:20190910},{$set:{text:"this is an update test"}})	