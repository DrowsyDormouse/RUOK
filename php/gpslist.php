<?php
 include("connect.php");

 $mId = rand(000000, 999999);
 $sql_1 = "SELECT patient_id FROM guardian WHERE login_id = 'asx';";
 $result_1 = mysqli_query($connect, $sql_1);

 if($result_1){
  $row_1 = mysqli_fetch_array($result_1);
  if(!is_null($row_1)){
   $p_id = $row_1['patient_id'];
   $d = date('Y_m_d');
   $gpsTable = "gps_".$p_id;
   $info = $p_id."_".$d;

   $sql_2 = "SHOW TABLES LIKE '$gpsTable';";
   $result_2 = mysqli_query($connect, $sql_2);
   if($result_2){
    $row_2 = mysqli_fetch_array($result_2);
    if(is_null($row_2)){
     $sql_3 = "CREATE TABLE $gpsTable(no INT(12) NOT NULL, info VARCHAR(255), $
     $result_3 = mysqli_query($connect, $sql_3);
     if($result_3){
      $sql_4 = "INSERT INTO $gpsTable(no, info) VALUES ('$mId', '$info');";
      $result_4 = mysqli_query($connect, $sql_4);
      if($result_4) { echo "입력 성공 1"; }
      else { echo " 입력 실패 1"; }
     }else{ echo "테이블 생성 실패"; }
    }else{
     $sql_5 = "SELECT * FROM $gpsTable WHERE info = '$info';";
     $result_5 = mysqli_query($connect, $sql_5);
     if($result_5){
      $row_2 = mysqli_fetch_array($result_5);
      if(is_null($row_2)){
       $sql_6 = "INSERT INTO $gpsTable(no, info) VALUES ('$mId', '$info');";
       $result_6 = mysqli_query($connect, $sql_6);
       if($result_6){ echo "입력 성공2"; }
       else{ echo "입력 실패 2"; }
      }else { echo "이미 존재함"; }
     }
    }
   echo $gpsTable."/";
   echo $info;
   }else{ echo "테이블 검색 실패"; }
  }else{ echo "error!!"; }
 }else{ echo "error!!"; }
?>

