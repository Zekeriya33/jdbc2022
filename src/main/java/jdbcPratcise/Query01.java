package jdbcPratcise;

import java.sql.*;


public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) driver yukle

        Class.forName("org.postgresql.Driver");

        // 2) Baglanti olustur

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","berra33");

        // 3) Statement
        Statement st = con.createStatement();

        // Resultset

        ResultSet veri = st.executeQuery("select * from ogrenciler");

        // sonuclari al

        while (veri.next()){
            System.out.println(veri.getInt(1)+ " "+ veri.getString(2)+" "+ veri.getString(3)+" "+ veri.getString(4));
      // 6) Kapama

            con.close();
            st.close();
            veri.close();


        }
    }
}
