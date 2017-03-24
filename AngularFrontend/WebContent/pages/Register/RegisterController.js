
console.log("Entered Register controller");
//$scope gets the things from form
app.controller('RegisterController', ['$scope', 'fileUpload', function($scope,fileUpload){
	console.log(" inside register controller");
    $scope.register = function(){
    	console.log("Inside Register Controller");
       var file = $scope.myFile;
       var name=$scope.name;
       var password=$scope.password;
       var mobile=$scope.mobile;
       
       console.log("name",name);
       console.log('file is ' );
       console.dir(file);
       var uploadUrl = "http://localhost:8087/Backend/fileUpload";
       fileUpload.uploadFileToUrl(file,uploadUrl,name,password,mobile);
       $scope.message="You are sucessfully registered!!!!";
    };
 }]);

app.directive('fileModel', ['$parse', function ($parse) { // triggerd when choose file is clicked . This is a custom directive
    return {
       restrict: 'A', //for attributes
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);

app.service('fileUpload', ['$http','$location', function ($http,$scope,$location) { //$http means it is a webservice
    this.uploadFileToUrl = function(file,uploadUrl,name,password,mobile){ // the job of service is to interact with http
       var fd = new FormData(); // formdata is class to serialize and send 
       fd.append('file', file);
       fd.append('name',name);
       fd.append('password',password);
       fd.append('mobile',mobile);
       
    console.log("fd:"+fd)
       $http.post(uploadUrl, fd, { //line 47
          transformRequest: angular.identity, //does serialization
          headers: {'Content-Type': undefined} //shouldnt take as json
       })
    
       .success(function(){ //is executed as soon as line 47 is executed
    	   $scope.message="registered! you can login now!!";
    	    $scope.name="";
    	    $scope.password="";  
       })
       .error(function(){
       });
    }
 }]);