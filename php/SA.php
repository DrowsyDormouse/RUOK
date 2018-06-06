<?php
 include("connect.php");

 $id = $_POST['u_id'];

 $sql = "SELECT safe_area FROM guardian WHERE login_id = '$id';";
 $result = mysqli_query($connect, $sql);

 if($result)
 {
  $row = mysqli_fetch_array($result);
  if(is_null($row['safe_area'])){
   echo "Can not find ID";
  }else{
   echo "$row[safe_area]";
  }
 }else{
  echo mysqli_errno($connect);
 }
 mysqli_close($connect);


?>
