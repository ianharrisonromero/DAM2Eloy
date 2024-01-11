<?php

//var_dump($_POST) ;

require("db.php");

try {


    $stmt = $conn->prepare("SELECT id , user , pass FROM users WHERE user=? AND pass=?");
    /* 
    //con bind
    $stmt->bindParam(':user', $_POST['user']);
    $stmt->bindParam(':pw', hash("sha256", $POST['pw'])); */

    $stmt->execute([$_POST['name'], $_POST['password']]);
    $result = $stmt->fetchAll();

    print_r($result);
    echo "el tamaño del array es" . count($result);

    if (count($result) > 0) {
        header("Location: home.php");
    } else
        header("Location: login.php");
} catch (PDOException $e) {
    echo "Error: " . $e->getMessage();
}

$conn = null;
