package jdbc;

import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","berra33");
        Statement st = con.createStatement();

       // 1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.

   String sql1 = "select company, number_of_employees \n" +
           "from companies \n" +
           "ORDER BY number_of_employees desc \n" +
           "OFFSET 1 ROW\n" +
           "FETCH NEXT 1 ROW ONLY";

         ResultSet result1 = st.executeQuery(sql1);

         while (result1.next()) {
             System.out.println(result1.getInt("number_of_employees")+ "--> " + result1.getString("company"));

         // 2. Yol Subquery kullanarak
         String sql2 = "select company, number_of_employees \n" +
                 "from companies \n" +
                 "WHERE  number_of_employees = (SELECT  MAX(number_of_employees) \n" +
                 "                              FROM companies\n" +
                 "                              WHERE number_of_employees < (SELECT MAX(number_of_employees) \n" +
                 " FROM companies))";

         ResultSet result2 = st.executeQuery(sql2);

             while (result2.next()) {
                 System.out.println(result2.getInt("number_of_employees")+ "--> " + result2.getString("company"));
             }
             con.close();
             st.close();
             result1.close();
             result2.close();

         }



    }

}
