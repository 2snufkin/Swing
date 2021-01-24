package dAO;

 import connection.Datasource;
 import entities.Details;
 import entities.Items;
 import iDAO.IdetailsDAO;
 import javax.swing.*;
 import java.sql.*;
 import java.util.Vector;


public class DetailsDAO implements IdetailsDAO {

 public static final String TABLE_DETAILS = "details";
 public static final String COLUMN_DETAILS_ID = "_id";
 public static final String COLUMN_DETAILS_ID_ITEM = "_idItem";
 public static final String COLUMN_DETAILS_QUANTITY = "quantity";
 public static final String COLUMN_DETAILS_ID_COMMANDE = "_idOrder";
 public static final int INDEX_DETAILS_ID = 1;
 public static final int INDEX_DETAILS_ID_ITEM = 2;
 public static final int INDEX_DETAILSQUANTITY = 3;
 public static final int INDEX_DETAILS_ID_COMMANDE = 4;
 
 static Connection conn;
 public static final String QDELETE = "DELETE FROM " + TABLE_DETAILS + " WHERE " + COLUMN_DETAILS_ID_ITEM + " = ";

 PreparedStatement  PSfindDetails;
 public static final String QINSERTItem = "Insert into " + TABLE_DETAILS + "(" + COLUMN_DETAILS_ID_ITEM + " ," +
         COLUMN_DETAILS_QUANTITY + " ," +COLUMN_DETAILS_ID_COMMANDE  +   " ) VALUES(   ?  ,   ?  ,   ?  );";
  PreparedStatement PSinsertDetail;
 public static final String QSELELCTALL = "SELECT * from " + TABLE_DETAILS + ";";

 public DetailsDAO() {

  conn = Datasource.getInstance();

 }

 @Override
 public void commit(Details details)    {
  try {
    PSinsertDetail = conn.prepareStatement(QINSERTItem);
   System.out.println(QINSERTItem);
    PSinsertDetail.setString(1, details.getIdItem());
    PSinsertDetail.setString(2, details.getQuantity());
    PSinsertDetail.setString(3, details.getIdOrder());

    //excute and verify that it has been done
    int affectedRow = PSinsertDetail.executeUpdate();
    if (affectedRow != 1) JOptionPane.showMessageDialog(null, "An item hasn't been added");

  } catch (SQLException e) {
   System.out.println(e.getMessage());
   e.printStackTrace();
  }
 }


 @Override
 public Vector<Details> afficherdETAils()   {
   ItemsDAO itemDao = new ItemsDAO();
   Vector<Details> usersVector = new Vector<>();
   try (Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(QSELELCTALL)) {
    while (res.next()) {
     Details detailObj = new Details();
     detailObj.setId(res.getInt(INDEX_DETAILS_ID));
     //getting the Item obj by ID
     String id = res.getString(INDEX_DETAILS_ID_ITEM);
     //get the obj naleItem
     Items itmId = itemDao.getItemByID(id);
     String name =  itmId.getName();

     //set it to detailObj
     detailObj.setIdItem(name);

     detailObj.setQuantity(res.getString(INDEX_DETAILSQUANTITY));

     detailObj.setIdOrder(res.getString(INDEX_DETAILS_ID_COMMANDE));
     usersVector.add(detailObj);
    }

   } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "problem with display users");
   }
   return usersVector;
  }









 
 


}

