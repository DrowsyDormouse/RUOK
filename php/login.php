<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $pw = $_POST['u_pw'];

 $sql = "SELECT IF(strcmp(pw, '$pw'),0,1) pw_chk FROM guardian WHERE login_id = '$id'";
 $result = mysqli_query($connect, $sql);

 if($result)
 {
  $row = mysqli_fetch_array($result);
  if(is_null($row['pw_chk'])){
   echo "Can not find ID"."/"."$id";
  }else{
   echo "$row[pw_chk]";
  }
 }else{
  echo mysqli_errno($connect);
 }
 mysqli_close($connect);
?>

