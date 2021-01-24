package dAO;

import connection.Datasource;
import entities.Orders;
import entities.Users;
import iDAO.IorderDAO;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class OrderDAO implements IorderDAO {
    public static final String TABLE_ORDERS = "orders";
    public static final String COLUMN_ORDERS_ID = "_id";
    public static final String COLUMN_ORDERS_PRICE = "price";
    public static final String COLUMN_ORDERS_DATE = "date";
    public static final String COLUMN_ORDERS_COMMANDE = "id_commande";
    public static final int INDEX_ORDERS_ID = 1;
    public static final int INDEX_ORDERS_PRICE = 2;
    public static final int INDEX_ORDERS_DATE = 3;

    public static final String QINSERT = "Insert into " + TABLE_ORDERS + "(" +  COLUMN_ORDERS_PRICE +") VALUES( ? );";
    private PreparedStatement pInsert;



    public static final String QSELELCTALL = "SELECT * from " + TABLE_ORDERS + ";";
    Connection conn;

    public OrderDAO() {
        conn = Datasource.getInstance();

    }

    @Override
    public Vector<Orders> displayOrders() {
        Vector<Orders> usersVector = new Vector<>();

        try (Statement stm = conn.createStatement();
             ResultSet res = stm.executeQuery(QSELELCTALL)) {

            while (res.next()) {
               Orders orderObj = new Orders();
               orderObj.setId(res.getInt(INDEX_ORDERS_ID));
               orderObj.setPrice(res.getDouble(INDEX_ORDERS_PRICE));
               orderObj.setDate(res.getTimestamp(INDEX_ORDERS_DATE));
               usersVector.add(orderObj);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "problem with display users");
        }
        return usersVector;
    }

    @Override
    public void addOrder(Orders order)   {
        try {
            System.out.println(QINSERT);
            pInsert = conn.prepareStatement(QINSERT);
            pInsert.setDouble(1,  order.getPrice());
             //excute and verify that it has been done
            int affectedRow = pInsert.executeUpdate();
            if (affectedRow != 1)
                System.out.println("A user hasn't been added");


        } catch (SQLException e) {
            System.out.println("The user name and password were not added " + e.getMessage());
            e.printStackTrace();
        }
    }



    public static void main (String[] args){
        OrderDAO test = new OrderDAO();

     }



}

