import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Veritabani implements IVeritabani
{

    private Kullanici kullanici;

    public Veritabani()
    {}


    public Kullanici kullaniciDogrula(String kullaniciAdi, String sifre)
    {
        
        kullanici = null;

        try
        {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/SogutmaSistemi",
                "postgres", 
                "3397");
            
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Baglanti girisimi basarisiz!");


            String sql = "SELECT \"KullaniciAdi\", \"Sifre\" FROM \"Kullanici\"";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                if (rs.getString("KullaniciAdi").equals(kullaniciAdi) && rs.getString("Sifre").equals(sifre))
                {
                    kullanici = new Kullanici.Builder().set(kullaniciAdi, sifre).build();
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return kullanici;
    }

}
