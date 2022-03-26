<?php

include("db_info.php");

$crn = $_POST["crn"];
$name = $_POST["name"];
$semester = $_POST["semester"];

$query = $mysqli->prepare("INSERT INTO courses (crn, name, semester) VALUES (?, ?, ?)");
$query->bind_param("sss", $crn, $name, $semester);
$query->execute();

$response = [];
$response["status"] = "Mabrouk!";

$json_response = json_encode($response);
echo $json_response;


?>