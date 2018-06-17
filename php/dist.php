<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $d = date("Y_m_d");

 $sql_1 = "SELECT patient_id FROM guardian WHERE login_id = '$id';";
 $result_1 = mysqli_query($connect, $sql_1);

 if(result_1){
  $row = mysqli_fetch_array($result_1);
  if(is_null($row)){
   echo "error!!_1";
  }else{
   $p_id = $row['patient_id'];
   $info = $p_id."_".$d;
   $gpsTable = "gps_".$p_id;

   $sql_2 = "SELECT dist FROM $gpsTable WHERE info = '$info';";
   $result_2 = mysqli_query($connect, $sql_2);
   if(result_2){
    $row_2 = mysqli_fetch_array($result_2);
    echo $row_2['dist'];
   }else{
    echo "error";
   }
  }
 }
?>
