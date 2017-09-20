<?php
	include('koneksi.php');
	
	$sql = "select * from names";
	$hasil = mysqli_query($konek,$sql);
	
	$value = '{"Name":';	
	while($data = mysqli_fetch_assoc($hasil)){
            $output[] = $data;			
    }
	$value .= json_encode($output);
	$value .= "}";
	
	
		 //Meng-update Database
			
	echo $value;
     
    mysqli_close($konek);
	

?>