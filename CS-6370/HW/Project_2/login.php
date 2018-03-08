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
    <title>Project 2 - Login</title>
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
            <li class="nav-item active">
              <a class="nav-link" href="login.php">Login<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="registration.php">Registration</a>
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
                    ***REMOVED***
                    ***REMOVED***

                    
                    $msg = "";

                    // Create connection
                    $conn = new mysqli($servername, $username, $password, $db);

                    // Check connection
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    } 

                    if ($_POST['submit']) {

                            $username = mysqli_real_escape_string($conn, $_POST['inputUsername']);
                            $password = mysqli_real_escape_string($conn, $_POST['inputPassword']);
    
                            $query = "SELECT username,password,isSuper FROM Users WHERE username='$username' and password='$password'";
                            $result = mysqli_query($conn, $query);
                            
                            $row = mysql_fetch_row($result);
                            $isSuper = $row[4];

                            if (mysqli_num_rows($result) > 0) {
                                $_SESSION['logged_in'] = true;
                                $_SESSION['username'] = $username;
                                $_SESSION['isSuper'] = $isSuper;
                                
                                header("location: index.php");
                            } else {
                                $msg = "Wrong username or password";
                            }

                        mysqli_close($conn);
                    }     
                ?>
            
                <form class="form-signin" action="login.php" method="POST">
                    <h1 class="h3">Please sign in</h1>

                    <label for="inputUsername" class="sr-only">Username</label>
                    <input type="text" id="inputUsername" name="inputUsername" class="form-control" placeholder="Username" required autofocus>

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