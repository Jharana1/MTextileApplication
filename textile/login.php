<?php

require "connection.php";
$email =  $_POST["email"];
$password =md5($_POST["password"]);
$query = "SELECT * FROM `wholeselerdetails` where Email = '$email' AND Password = '$password'";

$result = mysqli_query($conn,$query);
$num = mysqli_num_rows($result);

if ($num == 1) {
    $row = $result->fetch_assoc();
    $verified = $row['verified'];
    $email = $row['Email'];
    if ($verified == 1) {
        echo "Login Successfull";
    } else {
        echo "This Account Has Not Been Verified. Verification Email Was Sent to you on $email";
    }
}else{

    echo "Invalid Cradential";
}

?>