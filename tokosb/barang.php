<?php
	//mengatur zona waktu agar sesuai dengan waktu lokal
	date_default_timezone_set("Asia/Jakarta");

	//memanggil file koneksi yang ada di dalam folder config
		include "koneksi.php";
?>
<!DOCTYPE html>
<html>
<head>
	<title>Laporan Data Barang</title>
	<style type="text/css">
	
	.judul{
		font-size: 22px;
		text-align: center;

	}
	
	table{
		font-size: 18px;
	}

	</style>
</head>
<body>
		<table width="100%">
<tr>
	<td width="25" align="center"></td>
	<td width="100" align="center"><h2>Toko Sandy Bambang</h2>
	<h3>JL.Tanah Abang Blok SLG Lantai Dasar<br>
	Jakarta Pusat<br>
	08772553317</h3></td>
	<td width="25" align="center"><img src="logb.jpg" width="80%"></td>

	
	</tr>
</table>
	<hr>
	<p class="judul">LAPORAN DATA BARANG</p>
	<table border="1" align="center">
			<tr>
			
				<th>ID Barang</th>
				<th>Model</th>
				<th>Jenis</th>
				<th>Type</th>
                <th>Ukuran</th>
				<th>Merek</th>
				<th>Harga</th>
				
				
			</tr>
			
			<?php 
			//perintah sql tampil data
       // $id = mysql_real_escape_string();
				$sql = "SELECT * FROM barang where id_barang like '%".$_GET['id']."%' or nama_barang like '%".$_GET['id']."%' or jenis_barang like '%".$_GET['id']."%'";
			//mengeksekusi perintah sql di atas
        
				$query = mysqli_query($koneksi, $sql);
			//ini untuk menampung data
				while($data = mysqli_fetch_array($query)){
			 ?>

			<tr>
			
				<td><?php echo $data['id_barang'] ?></td>
				<td><?php echo $data['nama_barang'] ?></td>
				<td><?php echo $data['jenis_barang'] ?></td>
				<td><?php echo $data['tipe_barang'] ?></td>
                	<td><?php echo $data['ukuran'] ?></td>
				<td><?php echo $data['merek'] ?></td>
				<td ><?php echo $data['harga_barang'] ?></td>
			
					</tr>
			<?php }?>
		</table>
    <br><br><br><br>
    <?php
	//mengatur zona waktu agar sesuai dengan waktu lokal
	date_default_timezone_set("Asia/Jakarta");

	//memanggil file koneksi yang ada di dalam folder config
		include "koneksi.php";

function tgl_indo($tanggal){
	$bulan = array (
		1 =>   'Januari',
		'Februari',
		'Maret',
		'April',
		'Mei',
		'Juni',
		'Juli',
		'Agustus',
		'September',
		'Oktober',
		'November',
		'Desember'
	);
	$pecahkan = explode('-', $tanggal);
	
	// variabel pecahkan 0 = tanggal
	// variabel pecahkan 1 = bulan
	// variabel pecahkan 2 = tahun

	return $pecahkan[2] . ' ' . $bulan[ (int)$pecahkan[1] ] . ' ' . $pecahkan[0];
}

 // 21 Oktober 2017
 // 15 Februari 1994
?>
    <h4 align="right"> Jakarta, <?php echo tgl_indo(date('Y-m-d'));
        ?>
    </h4>
</body>
</html>
<script>
	window.print();
</script>