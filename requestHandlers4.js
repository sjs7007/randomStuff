function start()
{
	console.log("Request handler 'start' was called.");
	//return "Hello, this is the start page!";
	return "falafel :P";
}

function upload()
{
	console.log("Request handler 'upload' was called.");
	return "Hello, this is the uploads page!";
}

exports.start = start;
exports.upload = upload;
