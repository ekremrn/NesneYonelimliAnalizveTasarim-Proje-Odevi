
public class Kullanici
{

    private String kullaniciAdi;
    private String sifre;
    

    public Kullanici(Kullanici builder)
    {
        this.kullaniciAdi = builder.kullaniciAdi;
        this.sifre = builder.sifre;   
    }




    public String getKullaniciAdi()
    { return kullaniciAdi; }


    public String getSifre()
    { return sifre; }


    public static class Builder
    {
        private String kullaniciAdi;
        private String sifre;

        public Builder(){}

        public Builder set(String _kullaniciAdi, String _sifre)
        {
            this.kullaniciAdi = _kullaniciAdi;
            this.sifre = _sifre;
            return this;
        }


        public Kullanici build()
        {
            return new Kullanici(this);
        }

    }
 

    Kullanici(Builder builder)
    {
        this.kullaniciAdi = builder.kullaniciAdi;
        this.sifre = builder.sifre;   
    }

    

}