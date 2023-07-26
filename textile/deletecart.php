<?php

require "connection.php";
$id = $_POST["id"];

$query = "DELETE FROM `cart` WHERE ID = '$id'";

$result = mysqli_query($conn,$query);


if ($result) 
{
 echo "Cart is deleted";
}
else
{
    echo "Something went wrong";
}
?>
