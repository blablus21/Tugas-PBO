public class mahasiswa extends elemen {
    public int jamSibuk;
    private int sks;

   public mahasiswa(String nama, int sks) {
        super(nama);
        jamSibuk = sks*3;
        
    }
    public int sks(){
        return sks;
       }
 
    @Override// Menggunakan method dari parent class yaitu class Elemen 
   public void send(){
      System.out.println(this.nama+" Adalah seorang mahasiswa dengan jam sibuk "+getjamSibuk());
    }

    @Override// Menggunakan method dari kelas induk 
     public int getjamSibuk(){
        return jamSibuk;
     }
}
