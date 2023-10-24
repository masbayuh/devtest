package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.config.DatabaseConnection;
import org.example.service.TransaksiService;
import org.example.service.impl.TransaksiServiceImpl;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    private static Properties progProp = PropertiesUtil.getInstance().getProgProp();
    private static final Logger log = LogUtil.getLogger(ExtractData.class);
    private DateUtil dateUtil = new DateUtil();
    private TransaksiService transaksiService = new TransaksiServiceImpl();

    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }



    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        try {
            // jawaban no 3.
            getTransaksi();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static int CombinatoricsChallenge(int num) {
        // code goes here
        return num;
    }

    public void databaseTest() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        assertNotNull("Koneksi database seharusnya tidak null", connection);

        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * 1. Java Programming: karena saya sudah lebih dari 3 tahun menggunakan bahasa pemrograman java
	dan sudah banyak proyek yang sudah saya kerjakan, termasuk integrasi java ke berbagai framework (zkoss, angularjs, spring, maven, hybernet, mybatis)
	dan berbagai konsep pemrograman (MVC, MVVM, monolite, maupun microservices)
    *
    *
    *
    * 2. Untuk mengerjakan kondisi alert yang diberikan, langkah-langkahnya adalah sebagai berikut:
        a. Persiapan Data: Pertama-tama, data transaksional harus tersedia dalam tabel dengan 300 juta catatan. Tabel ini
        * harus mencakup informasi seperti waktu transaksi dan status 	transaksi (sukses, gagal, ditolak, atau mencurigakan).
        b. Pemantauan Data: Sistem perlu memantau tabel transaksi ini secara teratur. Misalnya, setiap 5 menit, sistem harus
        * memeriksa data untuk jangka waktu lima menit sebelumnya.
        c. Perhitungan Transaksi Gagal: Sistem perlu menghitung jumlah transaksi yang gagal selama jangka waktu lima menit
        * tersebut. Ini dapat dicapai dengan menjalankan kueri pada tabel 	yang memfilter transaksi yang gagal dan memiliki
        * waktu dalam jangka waktu yang sesuai.
        d. Kondisi Alert: Sistem harus memeriksa apakah jumlah transaksi yang gagal selama lima menit terakhir lebih dari 100.
        * Jika ya, maka sistem harus memicu pemberitahuan alert.
        e. Pemberitahuan Alert: Sistem harus mengirim pemberitahuan alert kepada petugas yang sedang bertugas. Misalnya,
        * sistem dapat mengirim pesan otomatis melalui Telegram yang memberi tahu petugas bahwa telah terjadi lebih dari
        * 100 transaksi gagal dalam lima menit terakhir.
        f. Jadwal Pemantauan: Pemantauan harus dijadwalkan untuk berjalan dengan interval yang lebih sering daripada
        * tingkat insert transaksi, yaitu 40 transaksi per detik, untuk memastikan 	deteksi tepat waktu.
        g. Logging dan Riwayat: Penting untuk mencatat setiap pemberitahuan alert yang dikirimkan dan detailnya.
        * Informasi ini akan berguna untuk analisis lebih lanjut atau pelacakan masalah jika diperlukan.
        Dengan mengikuti langkah-langkah ini, sistem dapat secara otomatis memberikan pemberitahuan kepada petugas
        * saat jumlah transaksi gagal melebihi 100 dalam lima menit terakhir.
    *
    *
    * */

    public void mainDate(String[] args){
        try{
            log.info("Start");
            String sDate = null;
            if(args.length == 1 && !args.toString().trim().equalsIgnoreCase("")){
                sDate = args[0];
            } else if (progProp.getProperty("rDate") != null) {
                sDate = progProp.getProperty("rDate");
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE, -1);
                Date date = calendar.getTime();
                sDate = dateUtil.convertDateToString(date, "yyyy-MM-dd");
            }
        }catch (Exception e){
            log.error("Error" + e.getMessage());
        }
    }

    // jawaban nomer 6
    /*
    *
    * Kode tersebut adalah bagian dari metode `mainDate`. Di bawah ini penjelasan singkat mengenai bagaimana kode ini bekerja:

    1. `log.info("Start")` - Pesan log informasi dicetak untuk menandakan awal eksekusi metode.

    2. `String sDate = null` - Variabel `sDate` dideklarasikan untuk menyimpan tanggal.

    3. `if (args.length == 1 && !args.toString().trim().equalsIgnoreCase(""))` - Kode ini memeriksa apakah ada argumen yang disediakan saat menjalankan program (dalam `args`) dan apakah argumen tersebut tidak kosong. Jika iya, nilai `sDate` akan diisi dengan nilai argumen tersebut.

    4. `else if (progProp.getProperty("rDate") != null)` - Ini adalah percabangan kedua yang memeriksa apakah ada properti bernama "rDate" dalam objek `progProp`. Jika ada, nilai `sDate` akan diisi dengan nilai dari properti "rDate".

    5. `else` - Blok ini akan dijalankan jika kedua kondisi sebelumnya tidak terpenuhi. Ini akan terjadi jika tidak ada argumen baris perintah yang disertakan dan properti "rDate" juga tidak ada.

    6. `Calendar calendar = Calendar.getInstance()` - Objek `Calendar` dibuat untuk mengelola tanggal dan waktu.

    7. `calendar.setTime(new Date())` - Waktu objek `calendar` diatur menjadi waktu saat ini.

    8. `calendar.add(Calendar.DATE, -1)` - Ini mengurangkan satu hari dari tanggal saat ini, menghasilkan tanggal yang tepat satu hari sebelumnya.

    9. `Date date = calendar.getTime()` - Objek `calendar` dikonversi ke objek `Date` yang mewakili tanggal yang tepat satu hari sebelumnya.

    10. `sDate = dateUtil.convertDateToString(date, "yyyy-MM-dd")` - Objek `date` dikonversi menjadi string dalam format "yyyy-MM-dd" dan nilainya ditetapkan ke variabel `sDate`.

    11. `catch (Exception e)` - Blok penanganan pengecualian digunakan untuk menangani pengecualian yang mungkin terjadi selama eksekusi. Jika ada pengecualian, pesan kesalahan yang mencakup pesan dari pengecualian `e` dicetak.

    Kode ini secara umum bertujuan untuk menentukan nilai `sDate`, yang mungkin digunakan sebagai tanggal referensi dalam program lebih lanjut. Nilai `sDate` diambil dari argumen baris perintah jika disertakan, properti "rDate" jika ada, atau tanggal satu hari sebelumnya jika tidak ada argumen atau properti yang tersedia.
    *
    * */

    public void getTransaksi() throws SQLException {
        transaksiService.select(1);
    }

}
