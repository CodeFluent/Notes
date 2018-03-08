<?php session_start();?>

<!doctype html>
<html lang="en">

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <title>Project 2 - Registration</title>
  </head>

  <body>

      <header>
      <!-- Fixed navbar -->
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="index.php">Wasfi's Blog</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.php">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="blog.php">Blog</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.php">Login</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="registration.php">Registration<span class="sr-only">(current)</span></a>
            </li>
          </ul>
        </div>
      </nav>
    </header>

    <main role="main" class="container">
        <div class="container">
                <div class="row">
                
                <?php
                    ***REMOVED***
                    ***REMOVED***
                    $password = "wmomen1";
                    ***REMOVED***

                    if (isset($_SESSION['logged_in']) && $_SESSION['logged_in' == true]) {
                        header("Location: index.php");
                    }
                    
                    $msg = "";

                    // Create connection
                    $conn = new mysqli($servername, $username, $password, $db);

                    // Check connection
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    } 

                    if ($_POST['submit']) {

                            $email = mysqli_real_escape_string($conn, $_POST['inputEmail']);
                            $username = mysqli_real_escape_string($conn, $_POST['inputUsername']);
                            $password = mysqli_real_escape_string($conn, $_POST['inputPassword']);
    
                            $query = "INSERT INTO Users (username, password, email, isSuper) VALUES ('$username', '$password', '$email', 0)";
                            $result = mysqli_query($conn, $query);
    
                            if ($conn->query($query) === TRUE) {
                                $_SESSION['logged_in'] = true;
                                $_SESSION['username'] = $username;
                                header("Location: index.php");
                            } else {
                                $msg ="Error: " . $sql . "<br>" . $conn->error;
                            }

                        mysqli_close($conn);

                    }     
                ?>
            
                <form class="form-signin" action="registration.php" method="POST">
                    <h1 class="h3">Please sign up</h1>

                    <label for="inputEmail" class="sr-only">Email</label>
                    <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email" required autofocus>

                    <label for="inputUsername" class="sr-only">Username</label>
                    <input type="text" id="inputUsername" name="inputUsername" class="form-control" placeholder="Username" required>

                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required>

                    
                    <input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Submit"></button>
                    <?php 
                        if(!empty($msg)) {
                            echo '
                                <div class="alert alert-danger" role="alert">
                                    '. $msg .'
                                 </div>
                                ';
                        }
                    ?>
                </form>

               
            </div>
        </div>
    </main>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="./assets/js/jquery-3.2.1.slim.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
  </body>
</html>