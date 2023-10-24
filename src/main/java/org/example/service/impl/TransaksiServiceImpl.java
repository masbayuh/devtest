package org.example.service.impl;

import org.example.Model.Transaksi;
import org.example.config.DatabaseConnection;
import org.example.service.TransaksiService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiServiceImpl implements TransaksiService {
    DatabaseConnection databaseConnection = new DatabaseConnection();
//    private final Connection connection = databaseConnection.getConnection();
//    private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;
    private StringBuilder statementBuilder;
    private List<Transaksi> transaksiList;
    private Transaksi transaksi;
    private String query;

    @Override
    public List<Transaksi> select(int id) throws SQLException {
        statementBuilder = new StringBuilder();
        transaksiList = new ArrayList<>();
        query = "select * from report_transaksi rt where 1=1 ";
        statementBuilder.append(query);
        try(Connection connection = databaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                transaksi = new Transaksi();
                transaksi.setIdReport(resultSet.getInt("report_id"));
                transaksi.setCodeClientReport(resultSet.getString("report_kode_client"));
                transaksi.setCodeReport(resultSet.getString("report_kode"));
                transaksi.setTanggalReport(resultSet.getDate("report_tanggal"));
                transaksi.setStatusReport(resultSet.getString("report_status"));
                transaksi.setTagihanReport(resultSet.getInt("report_tagihan"));
                transaksi.setAdminFeeReport(resultSet.getInt("report_admin_fee"));
                transaksiList.add(transaksi);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return transaksiList;
//        return null;
    }
}
