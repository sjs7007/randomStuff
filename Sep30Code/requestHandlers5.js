var exec = require("child_process").exec;

function start(response)
{
	console.log("Request handler 'start' was called.");
	//var content = "empty";

	exec("ls",function(error,stdout,stderr)
	{
		//content=stdout;
		response.writeHead(200,{"Content-Type": "text/plain"});
		response.write(stdout);
		response.end();
	});

	//return content;
}

function upload(response)
{
	console.log("Request handler 'upload' was called.");
	//return "Hello Upload!";
	response.writeHead(200,{"Content-Type": "text/plain"});
	response.write("Hello upload");
	response.end();
}

exports.start = start;
exports.upload = upload;
