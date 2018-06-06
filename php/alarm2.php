<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $h = $_POST['u_hour'];
 $m = $_POST['u_minute'];
 $time = "$h:$m:00";

 $sql = "UPDATE guardian SET alarm_info2 = '$time' WHERE login_id = '$id'";
 $result = mysqli_query($connect, $sql);

  if($result) {
     echo "DB 입력 성공";
  }else {
     die("$sql");
  }
?>
