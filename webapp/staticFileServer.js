var express = require('express');
var config = require('./config.server');
var app = express();

app.use(function(req, res, next) {
  /**
   * Response settings
   * @type {Object}
   */
  var responseSettings = {
    "AccessControlAllowOrigin": req.headers.origin,
    "AccessControlAllowHeaders": "Content-Type,X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5,  Date, X-Api-Version, X-File-Name",
    "AccessControlAllowMethods": "POST, GET, PUT, DELETE, OPTIONS",
    "AccessControlAllowCredentials": true
  };
 
  /**
   * Headers
   */
  res.header("Access-Control-Allow-Credentials", responseSettings.AccessControlAllowCredentials);
  res.header("Access-Control-Allow-Origin",  responseSettings.AccessControlAllowOrigin);
  res.header("Access-Control-Allow-Headers", (req.headers['access-control-request-headers']) ? req.headers['access-control-request-headers'] : "x-requested-with");
  res.header("Access-Control-Allow-Methods", (req.headers['access-control-request-method']) ? req.headers['access-control-request-method'] : responseSettings.AccessControlAllowMethods);
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