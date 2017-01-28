# Answers of the questions
##What is the purpose of .gitignore?  

* All the files in .gitignore do not show up in git status. (git doesn't track them)  

##Explain what a route is  

## What is the purpose of umm3601.Server class?  

It receives HTTP requests from the client and responds to the client with processed data.  

##What is the purpose of the umm3601.user.UserController
It provides various kinds of data processing methods that are called in umm3601.Server class.

##Explain what happens when a user accesses each of the following URLs: 
* The page users    
The webpage is redirected to 'users.html.'  
* The page api/  
* The page api/users?age=25  
* The page api/users/588935f5de613130e931ffd5  

##What happens when the user accesses the page "kittens"? Modify the server code so accessing the page "kittens" results in the text "Meow". Describe what you did and how it worked.