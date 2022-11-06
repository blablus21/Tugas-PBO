public class demo {
    public static void main(String[] args) {
        gaji s = new gaji ("Wahyu", "KUBAR", 3, 5000);
        pegawai e = new gaji("ini nama ", "Samarinda", 2, 2500);
        System.out.println( "memanggil mailCheck berdasarkan referensi gaji ");
        
        s.mailCheck();
        System.out.println("\nMemanggil mailCheck berdasarkan referensi Pegawai");
        e.mailCheck();
    }
}
