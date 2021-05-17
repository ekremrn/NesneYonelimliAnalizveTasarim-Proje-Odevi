

import java.util.Scanner;


public class Tus implements ITus
{
    private Scanner input; 

    public String oku()
    {
        input = new Scanner(System.in);
        return input.next();
    }
    
    
    public int sayiOku()
    {
        input = new Scanner(System.in);
        return input.nextInt();
    }

}
