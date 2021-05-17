
public class Ekran implements IEkran
{

    //
    public void yazdirL(String mesaj)
    {
        System.out.println(mesaj);
    }


    //
    public void yazdir(String mesaj)
    {
        System.out.print(mesaj);
    }

    
    //
    public void yazdir(int mesaj)
    {
        System.out.print(mesaj);
    }
    
    
    //
    public void temizle() 
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

}
