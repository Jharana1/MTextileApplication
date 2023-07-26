<?php
require 'connection.php';
$success = false;
$showError = false;
if (isset($_POST['submit'])) {
    $password = ($_POST["password"]);
    $cpassword = ($_POST["cpassword"]);
    $exists = false;

    if (empty($password) || empty($cpassword)) {
        $showError = "Please Fill Out The Form!";
        $exists = true;
    }
    $password = md5($_POST["password"]);
    $cpassword = md5($_POST["cpassword"]);
    if (!($password == $cpassword)) {
        $showError = "Password And Confirm Password Are Not Same";
        $exists = true;
    }
    if ($exists == false) {
        if (isset($_GET['email'])) {
            $email = $_GET['email'];
            $sql = "Select * from `wholeselerdetails` where email = '$email' ";
            $result = mysqli_query($conn, $sql);
            $num = mysqli_num_rows($result);
            if ($num == 1) {
                $update = "UPDATE `wholeselerdetails` SET password = '$password' WHERE email = '$email'";
                $result1 = mysqli_query($conn, $update);
                if ($result1) {
                     die("Your Password has Bee Updated! You May Now Login");
                } else {
                    echo $mysqli->error;
                }
            } else {
                echo "Email Is Invalid";
            }
        } else {
            die("Something went Wrong!");
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <?php
    if ($success) {
        echo ' <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Success!</strong> You are logged in
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">×</span>
        </button>
    </div> ';
    }
    if ($showError) {
        echo ' <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Error!</strong> ' . $showError . '
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">×</span>
        </button>
    </div> ';
    }
    ?>
    <div class="conteiner">
        <div class="row">
            <div class="col-md-6 mx-auto">
                <div class="card">
                    <div class="card-header bg-dark text-white">
                        <h4 class="text-center">Generate New Password</h4>
                    </div>
                    <div class="card-body">
                        <form autocomplete="off" action="" method="post">
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" name="password" id="password" class="form-control" placeholder="Enter Your new password">
                            </div>
                            <div class="form-group">
                                <label for="cpassword">Confirm Password:</label>
                                <input type="password" name="cpassword" id="cpassword" class="form-control" placeholder="Enter Your Confirm Password">
                            </div>
                            <div class="form-group mt-2">
                                <button type="submit" class="btn btn-dark btn-block" id="save" name="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>

</html>