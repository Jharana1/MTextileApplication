<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    include 'connection.php';
    $email = $_POST["email"];

    $sql = "Select * from `wholeselerdetails` where email='$email'";
    $result = mysqli_query($conn, $sql);
    $num = mysqli_num_rows($result);
    if ($num == 1) {
        $to = "$email";
        $subject = "Email Verification";
        $message = "<a href='http://192.168.254.5/textile/NewPassword.php?email=$email'> Change Password";
        $from = "noreply250102@gmail.com";
        $headers = "From: $from";
        if (mail($to, $subject, $message, $headers)) {
            echo "Reset Password Link Has Been Sent To $email ";
        } else {
            echo $mysqli->error;
        }
    }else{
        
        echo "Invalid Email Id!";
    }
}

?>