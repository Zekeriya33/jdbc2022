package jdbc;

import java.sql.*;

public class PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","berra33");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        // 1 . Adim: Prepared statement Query olustur.
        String sql1= "UPDATE companies set number_of_employees = ? where company = ?";

        // 2. Adım : PreparedStatement  objesini olustur
        PreparedStatement pst1 = con.prepareStatement(sql1);

        // 3. Adim : set...() methodlari ile soru isaretleri icin deger girin
        pst1.setInt(1,999);
        pst1.setString(2,"IBM");

        // 4. Adim ExecuteQuery

       int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi+ " satir guncellendi");

       String sql2 = "SELECT * FROM companies";
       st.executeQuery(sql2);
       ResultSet result1 = st.executeQuery(sql2);

       while (result1.next()){
           System.out.println(result1.getInt(1) + "-->" + result1.getString(2)+"-->"+ result1.getInt(3));

       }


       // google icin degisiklik
        pst1.setInt(1,15000);
        pst1.setString(2,"GOOGLE");


        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi+ " satir guncellendi");

        String sql3 = "SELECT * FROM companies";
        st.executeQuery(sql2);
        ResultSet result2 = st.executeQuery(sql3);

        while (result2.next()){
            System.out.println(result2.getInt(1) + "-->" + result2.getString(2)+"-->"+ result2.getInt(3));

        }

      //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

         read_data(con,"companies");
       }

    //Bir tablonun istenilen datasını prepared statement ile çağırmak için kullanılan method.
    public static void read_data(Connection con, String tableName ) throws ClassNotFoundException {

        try {

            String query = String.format("SELECT * FROM %s",tableName);//Format() methodu dinamik String oluşturmak için kullanılır.
            //SQL query'yi çalıştır.
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);//Datayı çağırıp ResultSet konteynırına koyuyoruz.

            while (rs.next()){//Tüm datayı çağıralım.

                System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getInt(3));

            }


        }catch (Exception e){
            System.out.println(e);
        }






    }
}
