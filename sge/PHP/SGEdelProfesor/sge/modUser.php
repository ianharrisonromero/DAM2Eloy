<?php

var_dump($_POST);

require("db.php");

try {
    


    $stmt = $conn->prepare("UPDATE users SET pass = ? WHERE username = ? and pass = ?");
    $pwNEW = hash("sha256",$_POST['pwNEW']);
    $pwOLD = hash("sha256",$_POST['pwOLD']);
    $stmt->execute([$pwNEW,$_POST['user'],$pwOLD]);
    
    $result = $stmt->fetchAll();




    print_r($result);
    echo "el tamaño del array es ". $stmt->rowCount();


  } catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
  }
  $conn = null;

?>