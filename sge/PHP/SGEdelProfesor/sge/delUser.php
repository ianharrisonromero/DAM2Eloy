<?php

//var_dump($_POST);

require("db.php");

try {
    

    $stmt = $conn->prepare("DELETE from users WHERE username = ? ");
    $stmt->execute([$_POST['user']]);
    


   if($stmt->rowCount()>0){
    $_SESSION["delMSG"]="se ha borrado correctamente el usuario";
   }
  else {
  $_SESSION["delMSG"]="ha habido un fallo a la hora de borrar el usuario";
  }
  header("Location:borrarUser.php");
  die();

  } catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
  }
  $conn = null;

?>