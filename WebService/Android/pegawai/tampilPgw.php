<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];

	//Importing database
	require_once('koneksi.php');

	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM names WHERE id=$id";

	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);

	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"subject_tasks"=>$row['subject_tasks'],
			"status_tasks"=>$row['status_tasks'],
			"tanggal_tasks"=>$row['tanggal_tasks'],	
			"waktu_tasks"=>$row['waktu_tasks'],
			"outcome_tasks"=>$row['outcome_tasks'],
			"customers_tasks"=>$row['customers_tasks'],
			"type_tasks"=>$row['type_tasks'],
			"description_tasks"=>$row['description_tasks']
		));

	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));

	mysqli_close($con);
?>
