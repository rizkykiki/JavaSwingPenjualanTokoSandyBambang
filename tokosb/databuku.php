<?php
	//mengatur zona waktu agar sesuai dengan waktu lokal
	date_default_timezone_set("Asia/Jakarta");

	//memanggil file koneksi yang ada di dalam folder config
		include "koneksi.php";
?>
<!DOCTYPE html>
<html>
<head>
	<title>Read More</title>
	<style type="text/css">
	

	.judul{
		font-size: 22px;
		text-align: center;
	}


	table{
		font-size: 15px;
	}

	</style>
</head>
<body>
	<p class="judul">READ MORE - Ayo Beli Buku!<br>
	Jl. Tenjoayu No.123<br>
	Telepon: 08771233317<br></p>
	<hr>
	<p class="judul">LAPORAN DATA BUKU</p>
	<table border="1">
			<tr>
				<th>KODE BUKU</th>
				<th>JUDUL BUKU</th>
				<th>NO ISBN</th>
				<th>PENGARANG</th>
				<th>PENERBIT</th>
				<th>TAHUN</th>
				<th>JENIS</th>
				<th>SINOPSIS</th>
				<th>STOK</th>
				<th>HARGA</th>
			</tr>
			
			<?php 
			//perintah sql tampil data
				$sql = "SELECT * FROM data_buku";
			//mengeksekusi perintah sql di atas
				$query = mysqli_query($koneksi, $sql);
			//ini untuk menampung data
				while($data = mysqli_fetch_array($query)){
			 ?>

			<tr>
				<td><?php echo $data['Kodebuku']; ?></td>
				<td><?php echo $data['Judul'] ?></td>
				<td><?php echo $data['ISBN'] ?></td>
				<td><?php echo $data['Pengarang'] ?></td>
				<td><?php echo $data['Penerbit'] ?></td>
				<td><?php echo $data['Tahun'] ?></td>
				<td><?php echo $data['Jenis'] ?></td>
				<td><?php echo $data['Sinopsis'] ?></td>
				<td><?php echo $data['Jumlah'] ?></td>
				<td align="right"><?php echo $data['Harga'] ?></td>
			</tr>
			<?php }?>
		</table>
</body>
</html>
<script>
	window.print();
</script>