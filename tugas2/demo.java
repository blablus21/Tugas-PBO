public class demo {
    public static void main(String[] args) {
       //Downcasting
        elemen asdos = new asdos ("Fairuzikum" ,24, 1); 
        asdos asdos1 = (asdos) asdos;

        //polymorphism
        dosen dosen1 = new dosen("Raja OP Damanik", 5); 

        //upcasting
        elemen asdos2 = new asdos ("Angel-chan",21, 1); 
        
        //polymorphisme
        mahasiswa mahasiswa1 = new mahasiswa ("Firman", 20); 
        
        //Downcasting
        elemen mahasiswa = new mahasiswa ("Nid to pass this sem", 23); 
        mahasiswa mahasiswa2 = (mahasiswa) mahasiswa;

        //upcasting
        elemen dosen2 = (elemen) new dosen("Nivotko",3); 
        
        asdos1.send();
        asdos2.send();
        dosen1.send();
        dosen2.send();
        mahasiswa1.send();
        mahasiswa2.send();

        int total = asdos1.jamSibuk 
                    + dosen1.getjamSibuk() 
                    + asdos2.getjamSibuk() 
                    + mahasiswa1.getjamSibuk() 
                    + ((mahasiswa) mahasiswa).getjamSibuk() 
                    + ((dosen) dosen2).getjamSibuk();

        System.out.println(" Total jam sibuk Fasilkom adalah " + total);
}
    
}
