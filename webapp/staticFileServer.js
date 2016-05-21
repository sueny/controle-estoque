var express = require('express');
var config = require('./config.server');
var app = express();

app.use(function(req, res, next) {
  // Website you wish to allow to connect
  res.setHeader('Access-Control-Allow-Origin', 'http://localhost:3000');

  // Request methods you wish to allow
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');

  // Request headers you wish to allow
  res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');

  // Set to true if you need the website to include cookies in the requests sent
  // to the API (e.g. in case you use sessions)
  res.setHeader('Access-Control-Allow-Credentials', true);

  // Pass to next layer of middleware
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