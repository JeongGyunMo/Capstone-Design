<?php

$con=mysqli_connect("localhost","root","","mydb");

if(mysqli_connect_errno($con)){
   echo "Failed to connect to MySql :".mysqli_connect_error();
}

mysqli_query($con,"set names utf8");
$res= mysqli_query($con,"select * from CLUB_MEMBER");

$result = array();

while($row = mysqli_fetch_array($res)){
   array_push($result,array('CLUB_ID'=>$row[0],'STUDENT_ID'=>$row[1],'NM'=>$row[2],'MAJOR'=>$row[3],'GRADE'=>$row[4],'GENDER_CD'=>$row[5],'STAFF_CD'=>$row[6],'PHONE_NO'=>$row[7],'POST_NO'=>$row[8],'ADDRESS'=>$row[9],'PER_INFO_AGG_YN'=>$row[10],'EMAIL'=>$row[11],'JOIN_DT'=>$row[12],'BIRTH_DT'=>$row[13],'ING_CD'=>$row[14],'JOIN_CD'=>$row[15],'INPUT_ID'=>$row[16],'INPUT_IP'=>$row[17],'INPUT_DATE'=>$row[18],'UPDATE_ID'=>$row[19],'UPDATE_IP'=>$row[20],'UPDATE_DATE'=>$row[21]));
}
echo json_encode(array("result"=>$result),JSON_UNESCAPED_UNICODE);

mysqli_close($con);

?>