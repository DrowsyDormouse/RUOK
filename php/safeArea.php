<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $area = $_POST['u_area'];
 $safeArea = $id."_sArea";
 $mId = rand(000000, 999999);

 $sql = "SHOW TABLES LIKE '$safeArea';";
 $result = mysqli_query($connect, $sql);
 if($result)
 {
  $row = mysqli_fetch_array($result);
  if(is_null($row)){
    $sql_1 = "CREATE TABLE $safeArea(no INT(12) NOT NULL, area VARCHAR(255) NOT NULL, PRIMARY KEY(no));";
    $result_1 = mysqli_query($connect, $sql_1);
    if($result_1){
      $sql_2 = "INSERT INTO $safeArea VALUES ('$mId','$area');";
      $result_2 = mysqli_query($connect, $sql_2);
      if($result_2)
         echo "�Է� ����1";
      else
         echo "�Է� ����1";
    }else{ echo "���̺� ���� ����"; }
  }else{
    $sql_3 = "INSERT INTO $safeArea VALUES ('$mId','$area');";
    $result_3 = mysqli_query($connect, $sql_3);
    if($result_3){ echo "�Է� ����2";}
    else{ echo "�Է� ����2";}}
 }else{ echo "���̺� �˻� ����"; }
?>
