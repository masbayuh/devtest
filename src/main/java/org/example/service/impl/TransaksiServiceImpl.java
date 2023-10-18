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
    private ResultSet resultSet = null;
    private StringBuilder statementBuilder;
    private List<Transaksi> transaksiList;
    private Transaksi transaksi;
    private String query;

    @Override
    public List<Transaksi> select(int id) throws SQLException {
        statementBuilder = new StringBuilder();
        transaksiList = new ArrayList<>();
        query = "select * from report_transaksi rt where 1=1 ";
        Connection connection = databaseConnection.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            statementBuilder.append(query);
            if(id > 0){
                preparedStatement.setInt(0, id);
            }
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    transaksi = new Transaksi();
                    transaksi.setIdReport(resultSet.getInt(0));
                    transaksi.setCodeClientReport(resultSet.getString(1));
                    transaksi.setCodeReport(resultSet.getString(2));
                    transaksi.setTanggalReport(resultSet.getDate(3));
                    transaksi.setStatusReport(resultSet.getString(4));
                    transaksi.setTagihanReport(resultSet.getInt(5));
                    transaksi.setAdminFeeReport(resultSet.getInt(6));
                    transaksiList.add(transaksi);
                }
            }

            return transaksiList;
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
//                if(preparedStatement != null) preparedStatement.close();
                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
