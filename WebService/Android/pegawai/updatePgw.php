<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable
		$id = $_POST['id'];
		$subject_tasks = $_POST['subject_tasks'];
		$status_tasks = $_POST['status_tasks'];
		$tanggal_tasks = $_POST['tanggal_tasks'];

		$waktu_tasks = $_POST['waktu_tasks'];
		$outcome_tasks = $_POST['outcome_tasks'];
		$customers_tasks = $_POST['customers_tasks'];
		$type_tasks = $_POST['type_tasks'];
		$description_tasks = $_POST['description_tasks'];

		
		//import file koneksi database
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE names SET subject_tasks = '$subject_tasks', status_tasks = '$status_tasks', tanggal_tasks = '$tanggal_tasks', waktu_tasks = '$waktu_tasks', outcome_tasks = '$outcome_tasks', customers_tasks = '$customers_tasks', type_tasks = '$type_tasks', description_tasks = '$description_tasks' WHERE id = $id;";

		//Meng-update Database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Pegawai';
		}else{
			echo 'Gagal Update Data Pegawai';
		}

		mysqli_close($con);
	}
?>
