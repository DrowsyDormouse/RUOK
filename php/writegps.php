<?php

 include("connect.php");

 $id = $_POST['u_id'];
 $latitude = $_POST['u_lat'];
 $longitude = $_POST['u_long'];
 $speed = (double)$_POST['u_speed'];
 $time = $_POST['u_time'];
 $dist = $_POST['u_dist'];
 $d = date("Y_m_d");

 if(strcmp($latitude, "36.8257462")&&strcmp($longtitude, "127.1153205")){
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
    $sql_2 = "UPDATE $gpsTable SET lat = '$latitude', lon = '$longitude', speed = '$speed', dist = '$dist' WHERE info = '$info';";
    $result_2 = mysqli_query($connect, $sql_2);
    if($result_2){ echo "정상작동: ".$latitude.", ".$longitude; }
    else { echo "오류 발생"; }
    $fp = fopen("/var/www/html/gps/".$info.".txt", "a");
    if(!$fp){
     echo "error_file";
    }else{
      if(speed < 30.00){
        $txt = $latitude.", ".$longitude.", ".$time."\n";
        fwrite($fp, $txt);
      }
    }
    fclose($fp);
   }
  }else{
   echo "error!!";
  }
 }

?>
