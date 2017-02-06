# Answers to the questions
##What is the purpose of .gitignore?  

All the files in .gitignore do not show up in git status. (git doesn't track them)  

##Explain what a route is  

A route is a way of handling HTTP request consisting of the name of the request
, where the request comes from or goes to, and the processing callback function.  

##What is the purpose of umm3601.Server class?  

It is where the server code lives. It receives HTTP requests from the client and responds to the client with processed data.  

##What is the purpose of the umm3601.user.UserController

It provides various kinds of data processing methods that are called in umm3601.Server class.

##Explain what happens when a user accesses each of the following URLs: 
### The page `users`  
 The webpage is redirected to `users.html.` By default, `users.html` has a buttom that once pressed displays all the users in a raw json object. 

### The page `api/users` . 
It gives us all the users as a json object.  

### The page `api/users?age=25` 
It gives us users whose age field is 25 as a json object. 

### The page `api/users/588935f5de613130e931ffd5`  
It gives us the user with the given id as a json object.  


##What happens when the user accesses the page "kittens"? Modify the server code so accessing the page "kittens" results in the text "Meow". Describe what you did and how it worked.  
Simple HTML with a text 'Meow' is returned. 
We use a route for GET request for `/kittens` path and return the string 'Meow'.

## What are the contents of the `public` folder? What is the purpose of each HTML files there?
HTMLs, a folder for CSS, a folder for javaScript, and assets.
`index.html` is the homepage. `about.html` has information about this web application. `users.html` is a page with a button that displays user data when pressed.

## Describe what happens when you filter users by age in the client? What is read from the web page, and what request is sent to the server? What is received, and how/where is it displayed? 
The web page will display the raw, filtered json object. The URL reads as *http://localhost:4567/api/users?age=25*.
The client then sends a get request to the server, and the web page gets back a filtered json object and displays it without formatting.   

## Where is the client-side JavaScript defined? Name the file(s) in which it is used.  
The java script client side code is stored in `public/javascript/users.js`.
The java script client side test code is stored in `test/javascript/clientJavascipt.spec.js`.  



   
