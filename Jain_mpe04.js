//connection
conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
coll = db.getCollection("Tweets");

//1
print("#1");
cursor = coll.find({$and: [{text: /\bdish\b/i}, {text:/\bgood\b/i}]});
count =0;
while (cursor.hasNext()) {
	doc = cursor.next();
	printjson(doc.text);
	count = count + 1;
}
print("count query 1 is "+count);
//2
print("#2");
cursor = coll.find({$and: [{text: /\bdish\b/i}, {text: {$not: /\bgood\b/i}}]});
//cnt = collection.count({$and: [{text: /\bThank\b/}, {text: {$not: /\bsandy\b/i}}]})
count2 =0;
while (cursor.hasNext()) {
	doc = cursor.next();
	printjson(doc.text);
	count2 = count2 +1;
}
print("count for second query is "+count2);
print("End of the script");
