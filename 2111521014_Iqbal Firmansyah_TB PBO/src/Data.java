
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.TreeMap;

//Kelas anak dari 
public class Data implements Program
{
    //Method yang diwariskan kelas induk
    @Override
    //Date (String & Date)
    public void date()
    {   
            Date date = new Date();
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            System.out.print("Tanggal         : " +d.format(date)); 
    }

    //Collection Framework (Set)
    public void set() 
    {
        //LinkedHashSet
        LinkedHashSet<String> x = new LinkedHashSet <String>();
        x.add("Senin");
        x.add("Selasa");
        x.add("Rabu");
        x.add("Kamis");
        x.add("Jumat");
        x.add("Sabtu");
        x.add("Minggu");

        System.out.println("Jadwal          : "+x);

        x.remove("Rabu");
        x.remove("Sabtu");

        System.out.println("Jadwal Terbaru  : "+x);
        System.out.println();
        
    }
    
    //String (String & Date)
    public void string() 
    {
            //StringTrim()
            System.out.println();
            String NamaToko = "     Ebal Laundry ";
            String AlamatToko = "        Jln.Kapalo Koto, Pauh, Kota Padang    ";
            String NoHp = "     082122212221     ";

            System.out.println(NamaToko.trim());
            System.out.println(AlamatToko.trim());
            System.out.println(NoHp.trim());
            System.out.println();

           
    }
    
    //Collestion Framework (Map)
    public void map() 
    {
        //TreeMap
        TreeMap<String, String> x = new TreeMap<String, String>();

        x.put("08.00 - 18.00", "Senin - Jumat");
        x.put("08.00 - 20.00", "Sabtu - Minggu");

        System.out.println("Jadwal          : "+x.entrySet());
        

        
    }


}
