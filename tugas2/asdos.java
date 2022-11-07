public class asdos extends mahasiswa {
    private int jamNgasdos;

   
    public asdos(String nama, int sks, int jamNgasdos){
        super(nama, sks);
        jamSibuk = jamSibuk + jamNgasdos; 
    }
    public int jamNgasdos(){
        return jamNgasdos;
    }

    @Override// Menggunakan method dari kelas induk abstrak
    public int getjamSibuk(){
        return jamSibuk;
    }
    
    @Override// Menggunakan method dari kelas induk abstrak
    public void send(){
        System.out.println(this.nama+ " Adalah seorang asdos dengan jam sibuk "+getjamSibuk());
    }

}
