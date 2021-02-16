conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
db.Tweets.find().snapshot().forEach(
   function (e) {    	
     	
     // remove loc
     delete e.loc;
     
     // save the updated document
     db.Tweets.save(e);

   }
 )