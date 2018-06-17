<?php
 include("connect.php");
 $id = $_POST['u_id'];
 $d = date('Y_m_d');
 $areaTable = $id."_sArea";

 $sql_1 = "SELECT patient_id FROM guardian WHERE login_id = '$id';";
 $result_1 =  mysqli_query($connect, $sql_1);
 if($result_1){
  $row = mysqli_fetch_array($result_1);
  if(!is_null($row)){
   $p_id = $row['patient_id'];
   $gpsTable = "gps_".$p_id;
   $info = $p_id."_".$d;

   $sql_2 = "SELECT lat, lon, speed FROM $gpsTable WHERE '$info';";
   $result_2 = mysqli_query($connect, $sql_2);
   $result_array = array();

   $row_2 = mysqli_fetch_array($result_2);
   $row_array = array(
      "lat" => $row_2['lat'],
      "lon" => $row_2['lon'],
      "speed" => $row_2['speed']
   );
   array_push($result_array, $row_array);

  $sql_3 = "SELECT area FROM $areaTable";
  $result_3 = mysqli_query($connect, $sql_3);
  $add_array = array();


  $arr = array(
     "status" => "OK",
     "address" => $add_array,
     "results" => $result_array
  );
  $json_array = json_encode($arr);
  print_r($json_array);
  mysqli_close($connect);
  }else{echo "error!"; }
 }
?>
