<?php
header('Access-Control-Allow-Origin: *');

include("db_info.php");

$query = $mysqli->prepare("SELECT * FROM courses;");
$query->execute();

$array = $query->get_result();

$response = [];

while($course = $array->fetch_assoc()){
    $response[] = $course;
}

$json_response = json_encode($response);
echo $json_response;

?>