<?php

/*
* Database Constants
* Make sure you are putting the values according to your database here 
*/
define('DB_HOST','localhost');
define('DB_USERNAME','root');
define('DB_PASSWORD','');
define('DB_NAME', 'db_android');
 
//Connecting to the database
$conn = new mysqli(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);
 
//checking the successful connection
if($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
 
//making an array to store the response
$response = array(); 
 
//if there is a post request move ahead 
if($_SERVER['REQUEST_METHOD']=='POST'){
 
//getting the name from request 
$subject_tasks = $_POST['subject_tasks']; 
$status_tasks = $_POST['status_tasks']; 
$tanggal_tasks = $_POST['tanggal_tasks']; 
$waktu_tasks = $_POST['waktu_tasks']; 
$outcome_tasks = $_POST['outcome_tasks']; 
$customers_tasks = $_POST['customers_tasks']; 
$type_tasks = $_POST['type_tasks']; 
$description_tasks = $_POST['description_tasks']; 
 
//creating a statement to insert to database 
$stmt = $conn->prepare("INSERT INTO names (subject_tasks,status_tasks,tanggal_tasks,waktu_tasks,outcome_tasks,customers_tasks,type_tasks,description_tasks) VALUES (?,?,?,?,?,?,?,?)");
 
//binding the parameter to statement 
$stmt->bind_param("ssssssss",$subject_tasks,$status_tasks,$tanggal_tasks,$waktu_tasks,$outcome_tasks,$customers_tasks,$type_tasks,$description_tasks);
 
//if data inserts successfully
if($stmt->execute()){
//making success response 
$response['error'] = false; 
$response['message'] = 'Name saved successfully'; 
}else{
//if not making failure response 
$response['error'] = true; 
$response['message'] = 'Please try later';
}
 
}else{
 $response['error'] = true; 
 $response['message'] = "Invalid request"; 
}
 
//displaying the data in json format 
echo json_encode($response);