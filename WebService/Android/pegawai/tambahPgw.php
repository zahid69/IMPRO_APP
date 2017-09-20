<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Mendapatkan Nilai Variable
		$subject_tasks = $_POST['subject_tasks'];
		$status_tasks = $_POST['status_tasks'];
		$tanggal_tasks = $_POST['tanggal_tasks'];

		//Pembuatan Syntax SQL
		$sql = "INSERT INTO names (subject_tasks,status_tasks,tanggal_tasks) VALUES ('$subject_tasks','$status_tasks','$tanggal_tasks')";

		//Import File Koneksi database
		require_once('koneksi.php');

		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Pegawai';
		}else{
			echo 'Gagal Menambahkan Pegawai';
		}

		mysqli_close($con);
	}
?>
