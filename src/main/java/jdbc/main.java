package jdbc;

import java.sql.Connection;

public class main {

    public static void main(String[] args) {

        // DBWork obje olusralim

        DBWork db = new DBWork();

        // Connection fonksiyonunu cagir
        Connection con = db.connet_to_db("techproed","postgres","berra33");

        // Yeni table olusturma methodu

        db.createTable(con,"employees");
    }

}
