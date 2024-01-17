<?php

require("db.php");

try {


    $stmt = $conn->prepare("INSERT into users (username, pass) VALUES (? , ?)");
    $pwOK = hash("sha256",$_POST['pw']);
    $stmt->execute([$_POST['user'],$pwOK]);
    
    $result = $stmt->fetchAll();

    header("Location: login.php");  

  } catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
  }
  $conn = null;



?>