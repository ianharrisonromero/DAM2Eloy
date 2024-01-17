<?php

//var_dump($_POST);

require("db.php");

try {
    session_start();
    $stmt = $conn->prepare("SELECT id, username, pass FROM users where username = ? and pass = ?");

    $stmt->execute([$_POST['user'],hash("sha256",$_POST['pw'])]);
    $result = $stmt->fetchAll();


    print_r($result);
    echo "el tamaño del array es ". count($result);

    if (count($result)>0){
        $_SESSION["name"]=$_POST['user'];
        $_SESSION["login"]=true;
        header("Location: home.php");
        setcookie("idioma", "es", time()+3600);
        die();
    }else{
        header("Location: login.php");
          die();
    }
  } catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
  }
  $conn = null;

?>

