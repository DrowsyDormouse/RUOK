<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $pw = $_POST['u_pw'];
 $gName = $_POST['u_name'];
 $phNum = $_POST['u_phNum'];
 $pk_gId = rand(000000, 999999);

 $pName = $_POST['u_pName'];
 $age = $_POST['u_pAge'];
 $add = $_POST['u_pAddress'];
 $rate = $_POST['u_pRate'];
 $pk_pId = rand(000000, 999999);

 $sql_p = "INSERT INTO patient (id, name, age, address, rating) VALUES ('$pk_pId', '$pName', '$age', '$add', '$rate')";
 $sql_g = "INSERT INTO guardian(id, login_id, pw, name, phone_num, patient_id) VALUES ('$pk_gId', '$id', '$pw', '$gName', '$phNum', '$pk_pId')";

 $result_p = mysqli_query($connect, $sql_p);
 $result_g = mysqli_query($connect, $sql_g);

 if($result_p) {
  echo "DB 입력 성공_p";
  if($result_g) {
   echo "DB 입력 성공_g";
  }else {
   $sql = "DELETE  FROM patient WHERE id = '$pk_pId'";
   $result = mysqli_query($connect, $sql);
   die("mysql error!!_g");
  }
 }else{
  die("mysql error!!_p");
 }
?>
