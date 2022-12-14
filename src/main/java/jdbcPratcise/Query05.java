package jdbcPratcise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // ogrenciler tablosuna yeni bir kayit ekleyin (300,'Sena Can', '12', 'K' )


    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
            "postgres","berra33");

    Statement st = con.createStatement();

//  int s1= st.executeUpdate("insert into ogrenciler values (300,'Sena Can', 12, 'K')");

//    System.out.println(s1 + " database'e satir eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

        String [] veri = {"insert into ogrenciler values (400, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (402, 'Sena Can', 12, 'K')"};

        int count=0;
        for(String each:veri){
            count = count + st.executeUpdate(each);
        }
        System.out.println(count + " satır eklendi");
    }
}
