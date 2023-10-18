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
//        databaseTest();
//        assertTrue(true);

        String[] tanggal = new String[3];
        tanggal[0] = String.valueOf(new Date());
        mainDate(tanggal);
        try {
            getTransaksi();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    * 2.
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

    public void getTransaksi() throws SQLException {
        transaksiService.select(1);
    }

}
