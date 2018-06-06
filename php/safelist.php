<?php
  include("connect.php");
  $id = $_POST['u_id'];
  $area = $id."_sArea";

  $sql = "SELECT area FROM $area;";

  $result = mysqli_query($connect, $sql);
  $total_record = mysqli_num_rows($result);

  $result_array = array();

  for($i = $total_record-1; $i >= 0; $i--){
     mysqli_data_seek($result, $i);

     $row = mysqli_fetch_array($result);

     $row_array = array(
        "address" => $row['area']
     );
     array_push($result_array, $row_array);
  }

  $arr = array(
     "status" => "OK",
     "num_result" => "$total_record",
     "results" => $result_array
  );

  $json_array = json_encode($arr);

  print_r($json_array);

  mysqli_close($connect);
?>
