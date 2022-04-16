<?php
header('Access-Control-Allow-Origin: *');
include("db_info.php");

$data = json_decode(file_get_contents("php://input"));

$crn = $data->crn;
$name = $data->name;
$semester = $data->semester;

$query = $mysqli->prepare("INSERT INTO courses (crn, name, semester) VALUES (?, ?, ?)");
$query->bind_param("sss", $crn, $name, $semester);
$query->execute();

$response = [];
$response["status"] = "Mabrouk!";

$json_response = json_encode($response);
echo $json_response;


?>