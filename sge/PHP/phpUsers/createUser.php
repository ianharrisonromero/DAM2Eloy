<?php

//var_dump($_POST) ;

require("db.php");

try {


    $stmt = $conn->prepare("INSERT INTO id , user , pass VALUES (?, ?)");

    $pwOK = hash("sha256", $_POST['pw']);
    $stmt->execute([$_POST['user']]);

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
