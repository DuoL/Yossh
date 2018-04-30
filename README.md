# Yossh

## Sorry, I was in an hurry to have an interview for now, so I just wrote down some of my initial ideas about the proj.

## This is what I thought in the first hour:
Local server: Tomcat;
Database: MySQL could be switched to MongoDB;

## Dataflow
User 1:
1. Front-end: a interactive form to gather the 3 key infos: reason, value, date send them to back-end via ajax in method 'post'
2. Back-end: Use JSON to parse it firstly, then put them into the database.

User 2:
1. Front-end: a button for the user to check the expenses is used by sending a 'get' request to back-end;
2. Back-end: pull all the expenses data from database(should include filter which can disgard the unvalid expenses)

## packages:
### db:
create a db factory to switch database

### entity
match the propertities with the provided info, here I used builder pattern in order that there will be more fields come into account.

### rpc
all the servlets should be within there, but sorry I don't have enough time to write it down.
This should have a JSONArray ==> JSON Object helper class.
A handler with 'post' and then put all the data into database;
A handler with 'get' to gather the data from database and send it to front-end via JSON file.

Thanks for watching my introduction.
