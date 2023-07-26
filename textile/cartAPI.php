<?php

require "connection.php";
$response= array();
$query = "SELECT * FROM `cart`";

$result = mysqli_query($conn,$query);

if($result){
    header("Content-Type: JSON");
    $i=0;
    while($row= mysqli_fetch_assoc($result)){
        $response[$i]["ID"]= $row["ID"];
        $response[$i]["catalogue"]= $row["catalogue"];
        $response[$i]["design"]= $row["design"];
        $response[$i]["image"]= $row["image"];
        $response[$i]["email"]= $row["email"];
        $i++;
    }
    echo json_encode($response,JSON_PRETTY_PRINT);

}

?>