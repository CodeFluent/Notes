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
    <title>Project 2 - Blog</title>
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
            <li class="nav-item active">
              <a class="nav-link" href="blog.php">Blog<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.php">Login</a>
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
                <?php
                  if (isset($_SESSION['logged_in']) && $_SESSION['logged_in'] == true) {
                    echo '<div class="alert alert-success" role="alert">
                              Hi there! You are logged in as: '. $_SESSION['username'] .'
                          </div>
                        ';
                  } else {
                    echo '<div class="alert alert-success" role="alert">
                                Hi there! You are logged in as: Guest.
                            </div>
                          ';
                  }
                ?>
                <div class="row">
   
                    <?php
                        function getPosts() {
                            ***REMOVED***
                            ***REMOVED***
                            ***REMOVED***
                            ***REMOVED***
    
                            // Create connection
                            $conn = new mysqli($servername, $username, $password, $db);
    
                            // Check connection
                            if ($conn->connect_error) {
                                die("Connection failed: " . $conn->connect_error);
                            } 
    
                            // mysqli_select_db("wmomen1", $conn) or die ("<br>Cannot use wmomen1 database: " . mysqli_error());
    
                            $query = "SELECT * FROM Posts";
                            $result = mysqli_query($conn, $query);
    
                            if (mysqli_num_rows($result) > 0) {
                                while($row = mysqli_fetch_assoc($result)) {
    
    
                                    echo '  <div class="col-md-4">
                                                <div class="card border-dark">
                                                <div class="card-header">'. $row["postTitle"] .'</div>
                                                    <div class="card-body">
                                                        <p class="card-text">'. $row["postContent"] .'</p>
                                                    </div>
                                                </div>
                                            </div>   ';
                                }
                            } else {
                                echo "0 results.";
                            }
    
                            mysqli_close($conn);
                        }
                    ?> 

                  <?php  getPosts(); ?>

                  <?php
                      if (isset($_SESSION['logged_in']) && $_SESSION['logged_in'] == true) {
                        echo '  <div class="col-md-4">
                                <div class="card border-secondary">
                                  <form action="blog.php" method="POST">
                                    <div class="card-header"> 
                                      <input type="text" id="postTitle" name="postTitle" class="form-control" placeholder="Add a post title.">
                                    </div>
                                    <div class="card-body">
                                      <input type="text" id="postContent" name="postContent" class="form-control" placeholder="Add some content.">
                                      <input class="btn btn-primary float-right" name="submit" type="submit" value="Submit" style="margin:5%;"></button>
                                    </div>
                                  </form>
                                </div>
                            </div>   ';
                      } 
                  ?>

                  <?php
                    function createPost() {
                          ***REMOVED***
                          ***REMOVED***
                          $password = "wmomen1";
                          ***REMOVED***

                            // Create connection
                          $conn = new mysqli($servername, $username, $password, $db);

                          // Check connection
                          if ($conn->connect_error) {
                              die("Connection failed: " . $conn->connect_error);
                          } 

                    
                          $title = mysqli_real_escape_string($conn, $_POST['postTitle']);
                          $content = mysqli_real_escape_string($conn, $_POST['postContent']);

                          $query = "INSERT INTO Posts (postTitle, postContent) VALUES ('$title', '$content')";
                          $result = mysqli_query($conn, $query);

                          if ($conn->query($query) === TRUE) {
                            getPosts();
                          } else {
                            echo "Error: " . $query . "<br>" . $conn->error;
                          }

                          mysqli_close($conn);
      
                    } 
                  ?>

                  <?php
                    if (isset($_POST['submit'])) {
                        createPost();
                    }
                  ?>
                    
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