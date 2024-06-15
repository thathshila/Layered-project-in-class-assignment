package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class OrderDetailDAOImpl implements OrderDetailDAO{
@Override
    public void saveOrderDetail(String orderId,OrderDetailDTO orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
       pstm.setString(1, orderId);
        pstm.setString(2, orderDetails.getItemCode());
        pstm.setBigDecimal(3, orderDetails.getUnitPrice());
        pstm.setInt(4, orderDetails.getQty());
        pstm.executeUpdate();
    }
}
