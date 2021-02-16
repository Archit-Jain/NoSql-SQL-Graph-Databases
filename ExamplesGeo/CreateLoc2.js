conn = new Mongo("localhost:27017");
db = conn.getDB("SampleSocial");
//cursor = db.Tweets.find();
//while ( cursor.hasNext() ) {
   
//}
// This statement will loop through the code for every document in the database
db.Tweets.find().forEach(
   function (e) {
     // update document, using its own properties
     // for test printjson(e.text)
     //if(e.hasOwnProperty('latitude'))
     //if(e.hasOwnProperty('latitude'))
	 // Check to see if latitude is in the document
	 //Sloppy coding alert - I hould have check longitude also, but it works here
     if ('latitude' in e && e.latitude !== "")
     {
		 //create a doc tha has latitude and longitude
     var ll = {longitude : e.longitude, latitude: e.latitude};
     var lla =[]; //an array
     //fills the array with longitude and latitude
     Object.keys(ll).forEach(function(key) {
     	//	printjson(key)
     	var val = ll[key];
     	//	printjson(val)
     	lla.push(val);
    
     })
     var p = "Point";
     // Create location variable in document - see how this compares with the slides
     e.loc = {type: p, coordinates: lla};     	
     	
     // remove old properties - decided not to do this
     //delete e.latitude;
     //delete e.longitude;
     
     // save the updated document
     db.Tweets.save(e);
     //printjson(ll)
     //printjson(lla)
     //printjson(e.loc)
   	}
   }
 )