<?php
	//mengatur zona waktu agar sesuai dengan waktu lokal
	date_default_timezone_set("Asia/Jakarta");

	//memanggil file koneksi yang ada di dalam folder config
		include "koneksi.php";
?>
<!DOCTYPE html>
<html>
<head>
	<title>Laporan Data Transaksi</title>
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
	<td width="25" align="center"><img src="hh.png" width="50%"></td>
	<td width="100" align="center"><h2>Toko Sandy Bambang</h2>
	<h3>JL.Tanah Abang Blok SLG Lantai Dasar<br>
	Jakarta Pusat<br>
	08772553317</h3></td>
	<td width="25" align="center"></td>

	
	</tr>
</table>
	<hr>
	<p class="judul">LAPORAN DATA TRANSAKSI</p>
	<table border="1" align="center">
			<tr>
				<th>ID Transaksi</th>
				<th>ID Pembeli</th>
				<th>NAMA Pembeli</th>
				<th>Alamat</th>
				<th>Tanggal</th>
				<th>ID Barang</th>
				<th>Nama Barang</th>
				<th>Jenis Barang</th>
				<th>Type Barang</th>
				<th>Harga</th>
				<th>Kuantitas</th>
				<th>Total</th>
				<th>Cash</th>
				<th>Kembalian</th>
				
			</tr>
			
			<?php 
			//perintah sql tampil data
				$sql = "SELECT * FROM transaksi WHERE tanggal LIKE '%$_GET[id]%'";
			//mengeksekusi perintah sql di atas
				$query = mysqli_query($koneksi, $sql);
			//ini untuk menampung data
				while($data = mysqli_fetch_array($query)){
			 ?>

			<tr>
				<td><?php echo $data['id_trans']; ?></td>
				<td><?php echo $data['id_pembeli'] ?></td>
				<td><?php echo $data['nama_pembeli'] ?></td>
				<td><?php echo $data['alamat_pembeli'] ?></td>
				<td><?php echo $data['tanggal'] ?></td>
				<td><?php echo $data['id_barang'] ?></td>
				<td><?php echo $data['nama_barang'] ?></td>
				<td><?php echo $data['jenis_barang'] ?></td>
				<td><?php echo $data['type_barang'] ?></td>
				<td align="right"><?php echo $data['harga_barang'] ?></td>
				<td align="right"><?php echo $data['kuantitas'] ?></td>
				<td align="right"><?php echo $data['total'] ?></td>
				<td align="right">Rp. <?php echo $data['cash'] ?></td>
				<td align="right">Rp. <?php echo $data['kembalian'] ?></td>
					</tr>
			<?php }?>
		</table>
</body>
</html>
<script>
	window.print();
</script>