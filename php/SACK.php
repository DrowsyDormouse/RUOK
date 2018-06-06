<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $chk = $_POST['u_chk'];

 $sql = "UPDATE guardian SET safe_area = $chk WHERE login_id = '$id';";
 $result = mysqli_query($connect, $sql);

 if($result)
 {
  echo "¼º°ø";
 }else{
  echo mysqli_errno($connect);
 }
 mysqli_close($connect);
?>
