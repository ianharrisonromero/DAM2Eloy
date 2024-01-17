<?php
session_start();
//var_dump($_SESSION);
if($_SESSION["login"]!="ok"){
    header("Location: login.php");
    die();
}
?>