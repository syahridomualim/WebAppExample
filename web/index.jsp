<%-- 
    Document   : index
    Created on : Jan 16, 2021, 5:33:57 PM
    Author     : toshiba
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Menghitung Harga</title>
    </head>
    <body>
        <h2>Form Memasukkan Nilai</h2>
        <form action="HitungHarga" method="post">
            <table>
                <tr>
                    <td>Nama Barang</td>
                    <td><input type="text" name="namaBarang"></td>
                </tr>
                <tr>
                    <td>Harga Satuan</td>
                    <td> <input type="text" name="hargaSatuan"></td>
                </tr>
                
                <tr>
                    <td>Jumlah</td>
                    <td><input type="text" name="jumlah"></td>
                </tr>
                <tr>
                    <td colspan="2">Diskon diberikan sebesar 5% jika jumlah >= 100</td>
                </tr>
                <tr>
                    <td colspan="2">dan total harga sebelum diskon >=  1000000</td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Hitung"></td>
                </tr>
            </table>            
        </form>
    </body>
</html>
