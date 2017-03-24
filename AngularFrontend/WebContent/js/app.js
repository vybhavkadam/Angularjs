var app = angular.module('myApp', ['ngRoute','ngCookies']); //ngRoute and ngCookie like java jar files 
console.log(" i am inside app.js")                          // cookie is used to get the name of user i.e when logging in from the browser  
app.config(function($routeProvider) {                       // cookies instead of interacting with backend just for the sake of getting name.
  $routeProvider

  .when('/home', {
		templateUrl : 'pages/Home/home.html',
		controller : 'UserHomeController'

  })

  .when('/blog', {
    templateUrl : 'pages/Blog/blog.html',
    controller  : 'BlogController'
  })
  
  .when("/allblogs", {
	templateUrl : "pages/AllBlogs/allblogs.html",
	controller : "AllBlogsController"
  })
  
  .when('/adminblog', {
		templateUrl : 'pages/Blog_Admin/adminblog.html',
		controller : 'AdminBlogController'
  })

  .when('/about', {
    templateUrl : 'pages/About/about.html'
  })
  
  .when('/contact', {
    templateUrl : 'pages/Contract/contact.html'
  })
  
  .when('/chat', {
    templateUrl : 'pages/Chat/chat.html'
  })
  
  .when("/userjobs", {
		templateUrl : "pages/Jobs_User/userjobs.html",
		controller : "UserJobsController"
  })
	
  .when("/job", {
		templateUrl : "pages/Jobs_Admin/jobs.html",
		controller : "AdminJobsController"
  })
  
  .when("/userforum", {
		templateUrl : "pages/Forum_User/userforum.html",
		controller : "UserForumController"
  })
  
  .when("/adminforum", {
		templateUrl : "pages/Forum_Admin/adminforum.html",
		controller : "AdminForumController"
  })
  
  .when("/friendslist", {
		templateUrl : "pages/Friend/friendslist.html",
		controller : 'FriendsListController'

  })

  
  .when('/login', {
    templateUrl : 'pages/UserLogin/login.html',
    controller  : 'LoginController'
  })
  
	.when('/logout', {
		templateUrl : 'pages/UserLogin/logout.html',
		controller : 'LogoutController'

	})
  
  .when('/register', {
    templateUrl : 'pages/Register/register.html',
    controller  : 'RegisterController'
  })
  
  .otherwise({redirectTo: '/'});
});

