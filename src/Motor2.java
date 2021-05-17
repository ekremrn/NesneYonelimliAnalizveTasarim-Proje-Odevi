
public class Motor2 implements IEyleyici
{
    @Override
    public void sogutucuAc(ISicaklikAlgilayici sicaklik)
    {
        sicaklik.update(-10);
        System.out.println("Sogutucu acildi");

    }


    @Override
    public void sogutucuKapat(ISicaklikAlgilayici sicaklik)
    {

        sicaklik.update(5);
        System.out.println("Sogutucu kapatildi");
    
    }
}
