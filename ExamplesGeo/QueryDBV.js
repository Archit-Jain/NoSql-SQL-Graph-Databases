conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
// coordinates: [ -77.6114, 43.1656 ] Rochester can use 5000
//         coordinates: [ 18.09, 42.65 ] Dubrovnik can use 400000 (up near Zagreb probably)
cursor = db.Tweets.find(
{ loc:
   { $near: 
   	{
     $geometry: {
        type: "Point" ,
        coordinates: [ 18.09, 42.65 ]
     },
     $maxDistance: 400000
  }}}, 
  {_id : 0, id: 1, fromUserName: 1, loc: 1})
while ( cursor.hasNext() ) {
   printjson( cursor.next() );
}