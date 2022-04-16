<?php

include("db_info.php");

$id = $_GET["course_id"]; //would let me retreive the code from the URL i.e: ?course_id=4

$query = $mysqli->prepare("SELECT * FROM courses WHERE id = ?");
$query->bind_param("i", $id);
$query->execute();

$array = $query->get_result();

$response = [];

while($course = $array->fetch_assoc()){
    $response[] = $course;
}

$json_response = json_encode($response);
echo $json_response;

?>