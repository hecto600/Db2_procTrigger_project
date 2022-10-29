package app.controller;

import java.sql.SQLException;

import app.model.Order;

public interface InterfaceOrderController {
    public void visualizeOrder(Order o) throws ClassNotFoundException, SQLException;
    public void visualizeAllOrders() throws ClassNotFoundException, SQLException;
    public void visualizeOrder(Order o,String type) throws ClassNotFoundException, SQLException;
    public void insertOrder(Order o) throws ClassNotFoundException, SQLException;


}
