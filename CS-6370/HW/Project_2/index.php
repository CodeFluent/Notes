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
    <title>Project 2 - Home</title>
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
            <li class="nav-item active">
              <a class="nav-link" href="index.php">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="blog.php">Blog</a>
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
        <h1>Welcome to Wasfi's Blog!</h1>
        <p>Hope you enjoy this project demo of a blog website written in PHP. Feel free to explore.</p>
        <?php
          if (isset($_SESSION['logged_in']) && $_SESSION['logged_in'] == true) {
            echo '<div class="alert alert-success" role="alert">
                      Hi there! You are logged in as: '. $_SESSION['username'] .'
                      '.(($_SESSION['isSuper'] == 1) ? 'You are root': '') .'
                  </div>';
            echo '<a href="logout.php">Logout</a>';
          } else {
            echo '<div class="alert alert-success" role="alert">
                        Hi there! You are logged in as: Guest.
                    </div>
                  ';
          }
        ?>
      </div>
    </main>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="./assets/js/jquery-3.2.1.slim.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
  </body>
</html>