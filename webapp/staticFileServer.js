var express = require('express');
var config = require('./config.server');
var app = express();

app.use(function(req, res, next) {
 res.header("Access-Control-Allow-Origin", "*");
 res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
 next();
 });
var http = require('http').Server(app);


app.use(express.static(__dirname + config.clientPath));

app.get("*", function(req,res){
  res.sendFile(__dirname + config.viewPath);
});

http.listen(config.port, function(err){
  if(err){
    console.log(err);
  }else{
    console.log("Listening on port " + config.port);
  }
});