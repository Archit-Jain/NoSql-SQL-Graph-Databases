conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
cursor = db.Tweets.find().limit(6);
while ( cursor.hasNext() ) {
   //printjson( cursor.next() );
   doc = cursor.next();
   if(doc.latitude && doc.longitude){
	   	print(doc.id, doc.latitude, doc.longitude);

   }
}
