<?php

require "connection.php";

$firmname = $_POST["firmname"];
$gst = $_POST["gst"];
$firstname = $_POST["firstname"];
$lastname = $_POST["lastname"];
$email = $_POST["email"];
$phonenumber = $_POST["phonenumber"];
$password = md5($_POST["password"]);
$cpassword =md5($_POST["cpassword"]);
$pancard = $_POST["pancard"];
$address = $_POST["address"];
$pincode = $_POST["pincode"];

$dob = date('Y-m-d',strtotime($_POST["dob"]));
$doa = date('Y-m-d', strtotime($_POST["doa"]));
$vkey = md5(time().$firmname);


$exist = false;

if(empty($firmname))
{
    echo " Firmname cannot be empty.";
    $exist = true;
}
if(empty($gst))
{
    echo " GST cannot be empty.";
    $exist = true;
}
if(empty($firstname))
{
    echo " First Name cannot be empty.";
    $exist = true;
}
if(empty($lastname))
{
    echo " Last Name cannot be empty.";
    $exist = true;
}
if(empty($email))
{
    echo " Email cannot be empty";
    $exist = true;
}
if(empty($phonenumber))
{
    echo " PhoneNumber cannot be empty.";
    $exist = true;
}
if(empty($password))
{
    echo " Password cannot be empty.";
    $exist = true;
}
if(empty($cpassword))
{
    echo " Confirm Password cannot be empty.";
    $exist = true;
}
if(empty($pancard))
{
    echo " Pancard cannot be empty.";
    $exist = true;
}
if(empty($address))
{
    echo " Address cannot be empty.";
    $exist = true;
}
if(empty($pincode))
{
    echo " Pincode cannot be empty.";
    $exist = true;
}
if(empty($dob))
{
    echo " DOB cannot be empty.";
    $exist = true;
}
if(empty($doa))
{
    echo " DOA cannot be empty.";
    $exist = true;
}

// //checking the availability of the field

$firmname1 = mysqli_query($conn, "SELECT * FROM `wholeselerdetails` where FirmName = '$firmname'");
if(mysqli_num_rows($firmname1)>0)
{
    echo " The firmname has already taken.";
    $exist = true;
}

$gst1 = mysqli_query($conn, "SELECT * FROM `wholeselerdetails` where GST = '$gst'");
if(mysqli_num_rows($gst1)>0)
{
    echo " The gst has already taken.";
    $exist = true;
}

$user = mysqli_query($conn, "SELECT * FROM `wholeselerdetails` where Email = '$email' ");
if(mysqli_num_rows($user)>0)
{
    echo " The email has already taken.";
    $exist = true;
}

$phonenumber1 = mysqli_query($conn, "SELECT * FROM `wholeselerdetails` where PhoneNumber = '$phonenumber' ");
if(mysqli_num_rows($phonenumber1)>0)
{
    echo " The phonenumber has already taken.";
    $exist = true;
}


$pancard1 = mysqli_query($conn, "SELECT * FROM `wholeselerdetails` where PanCard= '$pancard' ");
if(mysqli_num_rows($pancard1)>0)
{
    echo " The pancard has already taken.";
    $exist = true;
}



if($exist == false)
{

    if($password == $cpassword)
    {
        $query = "INSERT INTO `wholeselerdetails`(`ID`, `FirmName`, `GST`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, `Password`, `PanCard`, `Address`, `PinCode`, `DateOfBirth`, `DateOfAnniversary`, `Status`,`vkey`, `verified`) 
        VALUES (null,'$firmname','$gst','$firstname','$lastname','$email','$phonenumber','$password','$pancard','$address','$pincode','$dob','$doa','1','$vkey' , '0')";
        $result = mysqli_query($conn,$query);
         if($result)
         {
            $to = "$email";

                $subject = "Email Verification";

                $message = "<a href='http://192.168.254.5/textile/Verify.php?vkey=$vkey'> Register Account";

                $from = "noreply250102@gmail.com";

                $headers = "From: $from";



                if (mail($to, $subject, $message, $headers)) {

                   echo "registration successful";

                } else {

                    echo $mysqli->error;

                }
         }
    }
    else
    {
         echo "Password mismatched";
     }
}

?>
