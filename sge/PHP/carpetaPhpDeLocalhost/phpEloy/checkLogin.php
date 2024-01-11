<?php

var_dump($_POST);

require("db.php");

$sql = "SELECT id, firstname, lastname FROM MyGuests";
$result = $conn->query($sql);

var_dump($result);

try {
  $stmt = $conn->prepare("SELECT id, firstname, lastname FROM MyGuests");
  $stmt->execute();

  // set the resulting array to associative
  $result = $stmt->fetchAll();
  print_r($result);

} catch (PDOException $e) {
  echo "Error: " . $e->getMessage();
}
$conn = null;

?>