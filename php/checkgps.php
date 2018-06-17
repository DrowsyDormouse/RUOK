
<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $d = date("Y_m_d");
 $row = 1;

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
   if($result_2){
    $row_2 = mysqli_fetch_array($result_2);
    $dist = $row_2['dist'];
   }else {
    $dist = "error";
   }
   $fp = fopen("/var/www/html/gps/".$info.".txt", "r");
   if(!$fp){
    echo "error_file";
   }else{
      $result_array = array();
      while(($data = fgetcsv($fp, 1000, ", ")) !== FALSE){
         $num = count($data);
         $row++;
         $row_array = array(
               "lat" => $data[0],
               "lon" => $data[1]
         );
         array_push($result_array, $row_array);
      }
      $arr = array(
         "status" => "OK",
         "num_result" => $row,
         "dist" => $dist,
         "results" => $result_array
      );
      $json_array = json_encode($arr);
      print_r($json_array);
   }
  }
   fclose($fp);
 }else{
  echo "error!!";
 }
 fclose($fp);
?>

