conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
cursor = db.Tweets.find().limit(15);
while ( cursor.hasNext() ) {
   printjson( cursor.next() );
}
