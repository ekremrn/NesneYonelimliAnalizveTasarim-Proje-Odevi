public class Sogutma 
{
	
    //
    private IEkran ekran;
    private ITus tus;
	private IVeritabani veritabani;
	private IEyleyici eyleyici;
	private ISicaklikAlgilayici sicaklik;
	private boolean sogutucu_durum;

    //
    private static final int SICAKLIK_GORUNTULE = 1;
	private static final int SOGUTUCUYU_AC = 2;
	private static final int SOGUTUCUYU_KAPAT = 3;
	private static final int CIKIS = 4;

    //
    public Sogutma()
    {

        ekran = new Ekran();
        tus = new Tus();
		veritabani = new Veritabani();
		sicaklik = new SicaklikAlgilayici();
		sogutucu_durum = false;

    }


    //
    public void calistir()
    {
        ekran.temizle();
		ekran.yazdirL("HOSGELDINIZ");
        Araclar.bekle();

		ekran.yazdir("Kullanici Adinizi Giriniz: ");
        String kullaniciAdi = tus.oku();
        Araclar.bekle();

        ekran.yazdir("Sifrenizi Giriniz: ");
        String sifre = tus.oku();
        Araclar.bekle();

		Kullanici kullanici = veritabani.kullaniciDogrula(kullaniciAdi, sifre);

		if(kullanici == null)
			ekran.yazdirL("Kullanici adi veya sifre yanlis");
		else
        	arayuz();
			
    }


	//
	private void arayuz()
	{
        ekran.temizle();
		int secim;

		do
        {
			secim = menu();

			switch(secim) 
			{
				case SICAKLIK_GORUNTULE:
					sicaklikOku(sicaklik);
					break;
				case SOGUTUCUYU_AC:
					if(!sogutucu_durum)
					{

						ekran.yazdir("Sogutucu kacinci kademede acilsin? 1-2: ");
						int sec = tus.sayiOku();
						if(sec == 1)
							eyleyici = new Motor1();
						else 
							eyleyici = new Motor2();
					
						eyleyici.sogutucuAc(sicaklik);
						sogutucu_durum = true;

					}
					else
					{
						ekran.yazdir("Sogutucu zaten acik");
					}
					
					break;
				case SOGUTUCUYU_KAPAT:

					if(sogutucu_durum)
					{
						eyleyici.sogutucuKapat(sicaklik);
						sogutucu_durum = false;
					}
					else 
						ekran.yazdir("Sogutucu zaten kapali");
					break;
					
				case CIKIS:
					ekran.yazdir("Cikis yapiliyor.");
					break;
				default:
					ekran.yazdir("1-4 arasında bir sayı girmelisiniz");
			}
            Araclar.bekle(1500);
			ekran.temizle();
		   
	   }while(secim!=4);

	}


    //
	private int menu()
	{

		ekran.yazdirL("**********************************************");
		ekran.yazdirL("*** MENU");
		ekran.yazdirL("*** 1 - Sicaklik Goruntule ");
		ekran.yazdirL("*** 2 - Sogutucuyu ac");
		ekran.yazdirL("*** 3 - Sogutucuyu kapat");
		ekran.yazdirL("*** 4 - Cikis yap");
		ekran.yazdir("*** Seciminiz: ");
		return tus.sayiOku();
	
	}


	//
	private void sicaklikOku(ISicaklikAlgilayici sicaklik)
	{

		ekran.yazdirL("*****");
		ekran.yazdirL("Sogutucu Sicakligi: ");
		ekran.yazdir(sicaklik.getSicaklik());
		ekran.yazdirL("°C");
		ekran.yazdirL("*****");

	}

}
