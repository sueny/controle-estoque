var express = require('express');
var config = require('./config.server');
var app = express();


var http = require('http').Server(app);

app.use(express.static(__dirname + config.clientPath));

app.get("*", function(req,res){
  res.sendFile(__dirname + config.viewPath);
});
app.use(function(req, res, next) {
  //CSRF
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  
  //res.setHeader('Access-Control-Request-Method', '*');
  //res.setHeader('Access-Control-Allow-Methods', 'OPTIONS, GET');
  if ( req.method === 'OPTIONS' ) {
    res.writeHead(200);
    res.end();
    return;
  }
});
http.listen(config.port, function(err){
  if(err){
    console.log(err);
  }else{
    console.log("Listening on port " + config.port);
  }
});