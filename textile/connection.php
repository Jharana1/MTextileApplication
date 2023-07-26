<?php

$server = "localhost";
$username = "root";
$password = "";

$database = "textile";

$conn = mysqli_connect($server, $username, $password, $database);

if(!$conn)
{
    echo "Connection Unsuccessful";
}

?>