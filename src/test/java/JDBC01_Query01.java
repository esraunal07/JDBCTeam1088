import java.sql.*;

public class JDBC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1- ilgili driveri yuklemeliyiz.mysql kullandigimizi bildiriyoruz.
        // Driver'i bulamama ihtimaline karsi bizden forName methodu icin ClassNotFoundException
        // method signature 'miza exception olarak firlatmamizi istiyor.

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2- baglantiyi olusturmak icin username ve password girmeliyiz.
        // Burada da bu username ve password'un yanlis olma ihtimaline karsi
        // SQLException firlatmamizi istiyor.

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3- SQL queryler icin bir statement objesi olusturup ,
        // java da sql sorgularimiz icin bir alan acacagiz.


        Statement st = con.createStatement();

        //4- SQL querylerimizi yazip calistirabiliriz.

       ResultSet veri =st.executeQuery("SELECT* FROM personel");

        //5 - sonuclari gormek icin iteration ile set icerisindeki elemanlarla
        // while dongusu ile yazdiriyoruz.

        while (veri.next()) {
            System.out.println(veri.getString(1)+ " " + veri.getString(2)
                    + " " + veri.getString(3)
                     + " " + veri.getString(4) + " " + veri.getString(5));
        }
        // 6- Olusturulan baglantilari kapatiyoruz.

        con.close();
        st.close();
        veri.close();
    }
}
