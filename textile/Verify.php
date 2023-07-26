<?php
require "connection.php";
    if(isset($_GET['vkey'])){
        $vkey = $_GET['vkey'];
        $sql = "Select * from `wholeselerdetails` where vkey = '$vkey' AND verified = '0'";
        $result = mysqli_query($conn , $sql);
        $num = mysqli_num_rows($result);
        if ($num == 1){
            $update = "UPDATE `wholeselerdetails` SET verified = '1' WHERE vkey = '$vkey'";
            $result1 = mysqli_query($conn , $update);
            if($result1){
                echo "Your Account has Bee Verified! You May Now Login";
            }else{
                echo $mysqli->error;
            }
        }else{
            echo "Account is invalid or alredy Verified!";
        }
    }else{
        die("Something went Wrong!");
    }
