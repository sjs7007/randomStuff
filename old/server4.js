/*var express = require('express');
var app = express();
app.use(express.logger());

app.get('/', function(request, response) {
  response.send('Hello World!');
});

var port = process.env.PORT || 5000;
app.listen(port, function() {
  console.log("Listening on " + port);
});

*/

var http = require("http");
var url = require("url");
var express = require('express');
var app = express();

function start(route,handle)
{
	function onRequest(request,response)
	{
		var pathname = url.parse(request.url).pathname;
		console.log("Request for "+ pathname + " received.");

		route(handle,pathname);

		/*response.writeHead(200,{"Content-Type" : "text/plain"});
		
		var content=route(handle,pathname);*/

		response.writeHead(200,{"Content-Type" : "text/html"});

		//var content="<h1> This is h1 text </h1>";
		
		var content=route(handle,pathname);
		var content2='<br><a href="http://sheltered-wave-7494.herokuapp.com/upload"> Uploads Page </a> <br> <a href="http://sheltered-wave-7494.herokuapp.com/start"> Start Page </a><br>';
		response.write(content);
		response.write(content2);
		
		var content3='<b> If you try to go to any other url other than /start or /upload, you will get a 404 error.</b>';
		response.write(content3);
		response.end();
	}

	
	var port = process.env.PORT || 5000;
	http.createServer(onRequest).listen(port);
	console.log("Server has started.");
}

exports.start=start;

