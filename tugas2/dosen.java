public class dosen extends elemen { 
    private int jumlahHariKerja;
    public int jamSibuk;
    

    public dosen(String nama,int jumlahHariKerja){
        super(nama);
        jamSibuk = jumlahHariKerja *8;   
    }
    public int jumlahHariKerja(){
        return jumlahHariKerja;
    }
    
    @Override// Menggunakan method dari kelas induk 
    public void send(){
        System.out.println(this.nama + " Adalah seorang dosen dengan jam sibuk "+ getjamSibuk());
    }

    @Override// Menggunakan method dari kelas induk 
    public int getjamSibuk(){
        return jamSibuk;
        
    }
}
