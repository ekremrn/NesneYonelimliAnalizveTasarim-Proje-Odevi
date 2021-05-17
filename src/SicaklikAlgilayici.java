import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici
{

    private Random rand;
    public int sicaklik;

    public SicaklikAlgilayici()
    {
        rand = new Random();
        if(rand.nextBoolean())
            sicaklik = rand.nextInt(20);
        else
            sicaklik = rand.nextInt(5) * (-1);


    }


    public int getSicaklik()
    { return sicaklik; } 



    public void update(int der)
    { sicaklik += der; }


}
