conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");

cursor = db.Tweets.find(
{ loc:
   { $near: 
   	{
     $geometry: {
        type: "Point" ,
        coordinates: [ -76.1474, 43.0481 ] //syracuse NY
     },
     $maxDistance: 5000
  }}}, 
  {_id : 0, id: 1, fromUserName: 1, loc: 1 , text: 1})
while ( cursor.hasNext() ) {
   printjson( cursor.next() );
}