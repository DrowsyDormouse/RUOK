<?php
 include("connect.php");

 $mId = rand(000000, 999999);
 $d = date('Y-m-d');
 $p_id = "123444";
 $gpsTable = $p_id."_gps";
 $info = $p_id.$d;

 $sql_2 = "SHOW TABLES LIKE '$gpsTable';";
 $result_2 = mysqli_query($connect, $sql_2);
 if($result_2){
  $row_2 = mysqli_fetch_array($result_2);
  if(is_null($row_2)){
    $sql_3 = "CREATE TABLE $gpsTable(no INT(12) NOT NULL, info VARCHAR(255), P$
    $result_3 = mysqli_query($connect, $sql_3);
    if($result_3){
     $sql_4 = "INSERT INTO $gpsTable VALUES ('$mId', '$info');"
     $result_4 = mysqli_query($connect, $sql_4);
     if($result_4)
      echo "입력 성공 1";
     else
      echo "입력 실패 1";
    }else{ echo "테이블 생성 실패"; }
  }else{
    $sql = "SELECT * FROM $gpsTable WHERE info = '$info';";
    $result = mysqli_query($connect, $sql);
    if($result){
     $row_1 = mysqli_fetch_array($result);
     if(is_null($row_1){
      $sql_5 = "INSERT INTO $gpsTable VALUES ('$mId', '$info');"
      $result_5 = mysqli_query($connect, $sql_5);
      if($result_5)
       echo "입력 성공 2";
      else
       echo "입력 실패 2";
     }else{ echo "이미 존재함";}
    }
  }
 }else{ echo "테이블 검색 실패"; }
?>

