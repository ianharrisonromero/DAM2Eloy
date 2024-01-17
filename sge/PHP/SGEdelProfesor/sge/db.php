<?php
$servername = "localhost";
$username = "root";
$password = "";

session_start();

try {
  $conn = new PDO("mysql:host=$servername;dbname=tesla", $username, $password);
  // set the PDO error mode to exception
  $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  echo "Connected successfully";
} catch(PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
}
?> 