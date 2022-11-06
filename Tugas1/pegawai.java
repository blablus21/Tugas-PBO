public class pegawai {
    private String name;
    private String address;
    private int number;

    public pegawai(String name2, String address2, int number2) {
    }
    public void Pegawai (String name, String address, int number){
        System.out.println(" Menyusun Pegawai");
        this.name = name;
        this.address = address;
        this.number = number;

    }
    public void mailCheck(){
        System.out.println("memeriksa surat untuk " + this.name + " " + this.address);
    
    }
    public String toString (){
        return name + " " + address + " " + number;
        
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;

    }
    public void setAddress(String newAddress){
        address = newAddress;

    }
    public int getNumber(){
        return number;
    }
}