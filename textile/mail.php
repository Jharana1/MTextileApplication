<?php

$to = "srishtigupta552@gmail.com";

$subject = "Email Verification";

$message = "Hello there'> Register Account";

$from = "noreply250102@gmail.com";

$headers = "From: $from";



if (mail($to, $subject, $message, $headers)) {

   echo "registration successful";

} else {

    echo $mysqli->error;

}