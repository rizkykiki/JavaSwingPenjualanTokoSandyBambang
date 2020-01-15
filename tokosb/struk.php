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

//	return $pecahkan[2] . ' ' . $bulan[ (int)$pecahkan[1] ] . ' ' . $pecahkan[0];
}

//echo tgl_indo(date('Y-m-d')); // 21 Oktober 2017
 // 15 Februari 1994
?>
<!DOCTYPE html>
<html>
<head>
	<title>Toko Sandy Bambang</title>
	<style type="text/css">
	.str{
		border: 1px solid black;
		width: 320px;
		padding-left: 20px;
		padding-right: 20px;
		padding-bottom: 10px;
	}

	.judul{
		font-size: 19px;
		text-align: center;
	}

	p{
		font-size: 16px;
	}
	table{
		font-size: 16px;
	}

	</style>
</head>
<body>
	<div class="str">
	<center><img src="logb.jpg" width="45%"></center>
	<p class="judul">Toko Sandy Bambang<br>
	JL.Tanah Abang Blok SLG Lantai Dasar<br>
	Jakarta Pusat<br>
	08772553317</p>
	<hr>
		<?php 
			$tanggal = date('Y-m-d');
		//perintah sql tampil data
			$sql = "SELECT * FROM transaksi WHERE id_trans='$_GET[id]'";
		//mengeksekusi perintah sql di atas
			$query = mysqli_query($koneksi, $sql);
		//ini untuk menampung data
			while($data = mysqli_fetch_array($query)){
                $coba=$data['tanggal'];
                $tahun=substr($coba,0, 4);
                $tan=substr($coba,8, 10);
                $bl=substr($coba,5, 7);
              //  $hh=intval($bl);
                $jj=$tahun.'-'.$bl.'-'.$tan;
                $inidia=tgl_indo(($jj));
                
		 ?>
		<table>
			<tr>
		 		<td>ID Transaksi</td>
		 		<td>:</td>
		 		<td><?php echo $data['id_trans']; ?></td>
		 	</tr>
		 	<tr>
		 		<td>Nama Pembeli</td>
		 		<td>:</td>
		 		<td><?php echo $data['nama_pembeli']; ?></td>
		 	</tr>
		 	<tr>
		 		<td>Tanggal</td>
		 		<td>:</td>
		 		<td>
				
				<?php //echo $inidia;
echo $data['tanggal'];
 ?>
                 
				</td>
		 	</tr>
		 </table>
		 <hr>
		 <table>
		 	<tr>
				<td >ID Barang</td>
		 		<td>:</td>
		 		<td><?php echo $data['id_barang']; ?></td>
		 		
		 	</tr>
		 	<tr>
		 		<td>Nama Barang</td>
		 		<td>:</td>
		 		<td><?php echo $data['nama_barang']; ?></td>
		 	</tr>
		 	<tr>
		 		<td>Jenis Barang</td>
		 		<td>:</td>
		 		<td><?php echo $data['jenis_barang']; ?></td>
		 	</tr>
		 	<tr>
		 		<td>Type Barang</td>
		 		<td>:</td>
		 		<td><?php echo $data['type_barang']; ?></td>
		 	</tr>
             <tr>
		 		<td>Ukuran Barang</td>
		 		<td>:</td>
		 		<td><?php echo $data['ukuran']; ?></td>
		 	</tr>
             <tr>
		 		<td>Merek Barang</td>
		 		<td>:</td>
		 		<td><?php echo $data['merek']; ?></td>
		 	</tr>
		 	<tr>
		 		<td>Harga Barang</td>
		 		<td>:</td>
		 		<td><?php echo $data['harga_barang']; ?></td>
		 	</tr>
			<tr>
		 		<td>Kuantitas</td>
		 		<td>:</td>
		 		<td><?php echo $data['kuantitas']; ?></td>
				
		 	</tr>
			
			
		</table>
		<hr>
		<table>
			
		 	<tr>
		 		<td>Total Harga</td>
		 		<td>:</td>
		 		<td><?php echo $data['total']; ?></td>
		 	</tr>
		 	<tr>
		 		<td>Cash</td>
		 		<td>:</td>
		 		<td>Rp. <?php echo $data['cash']; ?></td>
		 	</tr>
		</table>
		<hr>
		<table>
			<tr>
		 		<td>Kembalian  </td>
		 		<td>  : </td>
		 		<td>  Rp. <?php echo $data['kembalian']; ?></td>
		 	</tr>
		</table>
		<?php }?>
		<hr>
		<center>Terima Kasih Atas Kunjungan Anda<br>
			Periksa Barang Sebelum Dibeli<br>
		Barang yang Sudah Dibeli Tidak Bisa Ditukar atau Dikembalikan</center>
		<hr>
	</div>
</body>
</html>
<script>
	window.print();
</script>