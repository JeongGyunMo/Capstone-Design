<?php

$con=mysqli_connect("localhost","root","","mydb");

if(mysqli_connect_errno($con)){
   echo "Failed to connect to MySql :".mysqli_connect_error();
}

mysqli_query($con,"set names utf8");
$res= mysqli_query($con,"select * from student");

$result = array();

while($row = mysqli_fetch_array($res)){
   array_push($result,array('STUDENT_ID'=>$row[0],'PASSWORD'=>$row[1]'INPUT_ID'=>$row[2],'INPUT_IP'=>$row[3],'INPUT_DATE'=>$row[4],'UPDATE_ID'=>$row[5],'UPDATE_IP'=>$row[6],'UPDATE_DATE'=>$row[7]));
}
echo json_encode(array("result"=>$result),JSON_UNESCAPED_UNICODE);

mysqli_close($con);
?>