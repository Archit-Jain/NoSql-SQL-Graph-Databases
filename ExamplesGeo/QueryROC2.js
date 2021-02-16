conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
cursor = db.Tweets.find(
// this looks for all documents that have a location (loc) near (with 5 k) Rochester.
//Notice how the query is formed.
{ loc:
   { $near: 
   	{
     $geometry: {
        type: "Point" ,
        coordinates: [ -77.6114, 43.1656 ]
     },
     $maxDistance: 5000
  }}}, 
  {_id : 0, id: 1, fromUserName: 1, loc: 1})
  
while ( cursor.hasNext() ) {
   printjson( cursor.next() );
}