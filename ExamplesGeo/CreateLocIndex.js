conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
collection = db.getCollection("Tweets");
// by default 2dsphere indexes are sparse - PASTE COMMAND BELOW
// sparse means that some values will be missing, if they do not exist in the data. 
collection.createIndex( { loc : "2dsphere" });
//SHOW INDEXES
docs = collection.getIndexes();
printjson(docs);