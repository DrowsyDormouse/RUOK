<?php
 include("connect.php");

 $id = $_POST['u_id'];
 $year = $_POST['u_y'];
 $month = $_POST['u_m'];
 $day = $_POST['u_d'];
 $hour = $_POST['u_h'];
 $minute = $_POST['u_mn'];
 $body = $_POST['u_body'];
 $memoTable = $id."_memo";
 $mId = rand(000000, 999999);

 $sql = "SHOW TABLES LIKE '$memoTable';";
 $result = mysqli_query($connect, $sql);
 if($result)
 {
  $row = mysqli_fetch_array($result);
  if(is_null($row)){
    $sql_1 = "CREATE TABLE $memoTable(no INT(12) NOT NULL, info DATETIME NOT NULL, body VARCHAR(255) NOT NULL, PRIMARY KEY(no));";
    $result_1 = mysqli_query($connect, $sql_1);
    if($result_1){
      $sql_2 = "INSERT INTO $memoTable VALUES ('$mId','$year-$month-$day $hour:$minute:00', '$body');";
      $result_2 = mysqli_query($connect, $sql_2);
      if($result_2)
         echo "�Է� ����1";
      else
         echo "�Է� ����1";
    }else{ echo "���̺� ���� ����"; }
  }else{
    $sql_3 = "INSERT INTO $memoTable VALUES ('$mId','$year-$month-$day $hour:$minute:00','$body');";
    $result_3 = mysqli_query($connect, $sql_3);
    if($result_3){ echo "�Է� ����2/"."$year-$month-$day $hour:$minute:00"."$memoTable";}
    else{ echo "�Է� ����2";}}
 }else{ echo "���̺� �˻� ����"; }
?>
