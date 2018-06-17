<?php
 $connect = mysqli_connect("localhost", "root", "tjsans244014", "ruok");

 if(mysqli_connect_errno($connect)){
  echo "Failed to connect to MySQL : " . mysqli_connect_errno();
 }

 mysqli_set_charset($connect, "utf8");
?>
