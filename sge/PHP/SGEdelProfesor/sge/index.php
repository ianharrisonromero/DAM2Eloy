
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario que nos salude</title>
</head>
<body>
    <form action="" method="post">
    user <input type="text" name="user">
    password <input type="text" name="pass" >

    <input type="submit" value="Enviar">
    </form>    

</body>
</html>

<?php
session_start();

var_dump($_POST);
if(isset($_POST["user"]))
{
if($_POST["user"]=="david" && $_POST["pass"]==1234){
    $_SESSION["nombre"]=$_POST["user"];
    $_SESSION["login"]=true;
    header("Location: home.php");
}
}
?>
