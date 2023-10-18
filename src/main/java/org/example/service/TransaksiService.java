package org.example.service;

import org.example.Model.Transaksi;

import java.sql.SQLException;
import java.util.List;

public interface TransaksiService {
    List<Transaksi> select(int id) throws SQLException;
}
