<?php require_once('db.php');?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar password</title>
    <script src="./js/main.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>

    <h1>Formulario modificar contraseñas </h1> <br>
    <form action="modUser.php" method="post">
    username <input type="text" name="user"value="<?php echo $_SESSION["name"] ?>" > <br>
    password antiguo <input type="text" name="pwOLD" id="old"><br>
    password nuevo <input type="text" name="pwNEW" id="new"><br>
    repetir password nuevo <input type="text" name="pwNEW" id="new"><br>
    <div id="error"></div>
    <input type="submit" id="botonCambiarPass" value="Modificar Usuario" class="btn btn-warning">
    </form>

</body>
</html>
