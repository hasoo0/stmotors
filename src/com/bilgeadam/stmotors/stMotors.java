package com.bilgeadam.stmotors;

import java.sql.*;
import java.sql.DriverManager;

public class stMotors {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {


            //Veritabanı sürücüsü için gerekli olan dosyalar yüklendikten sonra veritabanı bağlantı sınıfı projeye dahil edilir.
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stmotors", "postgres", "123456");

            Statement st = conn.createStatement();

            //Veri ekleme, veri güncelleme ve veri silme işlemi sonrası eklenen,
            //güncellenen veya silinen kayıt sayısı bilgisi için executeUpdate metodu kullanılabilir.
            ResultSet rs = st.executeQuery("select no, ad, soyad, maas from stmotors order by no");

            while (rs.next()) {
                System.out.println("No:" + rs.getInt("no"));
                System.out.println("Ad:" + rs.getString("ad"));
                System.out.println("Soyad:" + rs.getString("soyad"));
                System.out.println("Maas:" + rs.getDouble("maas"));
                System.out.println();

            }

            rs.close();
            st.close();
            conn.close();


        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Hata; Duzgun calismadi.");
        }

        catch (Exception e)
        {
            System.err.println("Hata:" + e.getMessage());
        }







    }
}
