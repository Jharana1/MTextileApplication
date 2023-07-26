<?php

require "connection.php";
$catalogue =  $_POST["catalogue"];
$design = $_POST["design"];
$image = $_POST["image"];
$email = $_POST["email"];
$query = "INSERT INTO `cart`(`ID`, `catalogue`, `design`,`image`,`email`) VALUES (null,'$catalogue','$design','$image','$email')";

$result = mysqli_query($conn,$query);

if($result){
    echo "Added to cart";
}else{

    echo "Try again";
}

?>