var id = $_POST['ID'];    
var name = $_POST['Name'];  
var type = $_POST['Type']; 
var brand = $_POST['Brand'];    

import { writeFile } from 'fs';
const fileName = 'resources.json';
const file = require(fileName);

var data = { "ID":id,"Name":name,"Type":type,"Brand":brand  };      
var stringData = JSON.stringify(data); 
file.key = data;

writeFile(fileName, JSON.stringify(data), function writeJSON(err) {
if (err) return console.log(err);
console.log(JSON.stringify(file));
console.log('writing to ' + fileName);
});