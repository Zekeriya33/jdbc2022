package jdbcPratcise;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


     Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
            "postgres","berra33");

    // Soru : Ogrenciler tablosundan Erkek ogrencileri listeleyiniz

    Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Sutun sayisi " + rsmd.getColumnCount());

        System.out.println("1. sutunun ismi :"+rsmd.getColumnName(1));
        System.out.println("2. sutunun ismi :"+rsmd.getColumnName(2));
        System.out.println("3. sutunun ismi :"+rsmd.getColumnName(3));
        System.out.println("4. sutunun ismi : "+rsmd.getColumnName(4));

        System.out.println("1. Sutunun data tipi: "+ rsmd.getColumnTypeName(1));
        System.out.println("2. Sutunun data tipi: "+ rsmd.getColumnTypeName(2));
        System.out.println("3. Sutunun data tipi: "+ rsmd.getColumnTypeName(3));
        System.out.println("4. Sutunun data tipi: "+ rsmd.getColumnTypeName(4));


    }
}
