<?php

$con=mysqli_connect("localhost","root","","mydb");

if(mysqli_connect_errno($con)){
   echo "Failed to connect to MySql :".mysqli_connect_error();
}

mysqli_query($con,"set names utf8");
$res= mysqli_query($con,"select * from CLUB");

$result = array();

while($row = mysqli_fetch_array($res)){
   array_push($result,array('CLUB_ID'=>$row[0],'CLUB_NM'=>$row[1],'CLUB_GB_CD'=>$row[2],'CLUB_AT_CD'=>$row[3],'CLUB_CNT'=>$row[4],'CLUB_AIM'=>$row[5],'CLUB_ACTIVE'=>$row[6],'CLUB_ROOM'=>$row[7],'OPEN_DT'=>$row[8],'INTRO_CONT'=>$row[9],'INTRO_FILE_NM'=>$row[10],'INTRO_FILE_PATH'=>$row[11],'INTRO_SAVE_FILE_NM'=>$row[12],'INPUT_ID'=>$row[13],'INPUT_IP'=>$row[14],'INPUT_DATE'=>$row[15],'UPDATE_ID'=>$row[16],'UPDATE_IP'=>$row[17],'UPDATE_DATE'=>$row[18]));
}
echo json_encode(array("result"=>$result),JSON_UNESCAPED_UNICODE);

mysqli_close($con);
?>