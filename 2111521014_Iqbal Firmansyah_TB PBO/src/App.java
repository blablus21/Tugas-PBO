import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;


//Subkelas Dari Kelas Laundry
public class App extends Laundry

{
    //Deklarasi Scanner
    static Scanner input = new Scanner(System.in);
    static Connection conn;
    
    public static void main(String[] args) throws Exception 
    {
        
        
            String pilihan;
            boolean next = true;
            
            //Koneksi Database
            String url = "jdbc:mysql://localhost:3306/ebal_laundry";
            
            //Exception
            try
            {
                //Koneksi Database
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, "root", "");

                
                Data d = new Data();
                
                //Perulangan
                while(next)
                {
                    d.string();
                    d.set();
                    d.map();
                    d.date();
                    System.out.println("\n\n           ===============  ");
                    System.out.println("               Laundry      ");
                    System.out.println("           ===============  ");
                    System.out.println("1. Lihat Data ");
            		System.out.println("2. Tambah Data ");
            		System.out.println("3. Ubah Data ");
            		System.out.println("4. Hapus Data ");
            		System.out.println("5. Cari Data ");


                    System.out.print("Inputkan Pilihan : ");
                    pilihan = input.next();

                    //Percabangan
                    switch(pilihan)
                    {
                        case "1":    
                            lihatdata();
                        break;

                        case "2":
                            tambahdata();
                        break;

                        case "3":
                            updatedata();
                        break;

                        case "4":
                            hapusdata();
                        break;

                        case "5":
                            caridata();
                        break;

                        default: System.out.println("Input tidak sesuai");
                    }

                    System.out.println("Lanjutkan [y/n] ???");
                    pilihan = input.next();
                    next = pilihan.equalsIgnoreCase("y");

                }
                System.out.println("Program Selesai");

            }
            catch(SQLException ex)
            {
                System.err.println("Tidak berhasil terkoneksi");
            }
            catch(InputMismatchException n)
            {
                System.out.println("Inputan Salah!!!");
            }
            
    }
    

    //Method yang di extend
    public static void lihatdata() throws SQLException
    {
        //Syntax untuk lihatdata() dari database
        String sql ="SELECT * FROM data_transaksi";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

        //Perulangan
        while(result.next())
        {
            System.out.println();
            System.out.print("No.ID             : ");
            System.out.println(result.getInt("no_id")); 
            System.out.print("Nama              : ");
            System.out.println(result.getString("nama"));
            System.out.print("Jenis Pakaian     : ");
            System.out.println(result.getString("jenis_pakaian"));
            System.out.print("Berat             : ");
            System.out.println(result.getDouble("berat"));
            System.out.print("Harga             : ");
            System.out.println(result.getInt("harga"));
            System.out.print("Total Harga       : ");
            System.out.println(result.getDouble("total_harga"));

        }
        
    }


    //Method yang di extend
    public static void tambahdata() throws SQLException
    {
        System.out.println("--------------");
		System.out.println("  Input Data  ");
        System.out.println("--------------");

        //Exception
        try
        {
            System.out.print("No.ID         : ");
            noid = input.nextInt();
            System.out.print("\nNama          : ");
            nama = input.next();
            System.out.print("Jenis Pakaian : ");
            jenis = input.next();
            System.out.print("Berat         : ");
            berat = input.nextInt();
            System.out.print("Harga         : ");
            harga = input.nextInt();
            //Proses Matematika
            totalharga = berat * harga;
            System.out.print("Total Harga   : "+totalharga);
            System.out.println();
            
            //Syntax untuk tambahdata() pada database
            String sql = "INSERT INTO data_transaksi(no_id, nama, jenis_pakaian, berat, harga, total_harga) VALUES ('"+noid+"','"+nama+"','"+jenis+"','"+berat+"','"+harga+"','"+totalharga+"')";
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Data Ditambahkan");
                   
                
        }
        catch(SQLException e)
        {
            System.out.println("Data Tidak Berhasil Ditambahkan!!!");
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Error!!!");
        }
        catch(NullPointerException n)
        {
            System.out.println("Data Tidak Berhasil Ditambahkan!!!");
        }
                
        
    }


    //Method yang di extend
    public static void updatedata() throws SQLException
    {
        Scanner input = new Scanner (System.in);
        //Exception     
        try
            {
                lihatdata();
                System.out.println("\n\nPilih No.ID  : ");
                Integer noid = Integer.parseInt(input.nextLine());

                //Syntax untuk memilih data yang akan diubah
                String sql = "SELECT * FROM data_transaksi WHERE no_id = " +noid;

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Percabangan
                if(result.next())
                {
                   
                    System.out.print("\nNama ["+result.getString("nama")+"]\t : ");
                    String nama = input.next();

                    System.out.print("\nJenis Pakaian["+result.getString("jenis_pakaian")+"]\t : ");
                    String jenis = input.next();

                    System.out.print("\nBerat["+result.getDouble("berat")+"]\t : ");
                    Double berat = input.nextDouble();

                    System.out.print("\nHarga["+result.getDouble("harga")+"]\t : ");
                    Integer harga = input.nextInt();

                    System.out.print("\nTotal Harga["+result.getInt("total_harga")+"]\t :");
                    Double totalharga = input.nextDouble();

                    //Syntax untuk menyimpan update data
                    sql = "UPDATE data_transaksi SET nama='"+nama+"', jenis_pakaian='"+jenis+"', berat='"+berat+"', harga='"+harga+"', total_harga='"+totalharga+"' WHERE no_id='"+noid+"'";
                    if(statement.executeUpdate(sql) > 0)
                    {
                        System.out.println("\n\nData Diperbarui (No.ID "+noid+")");
                    }
                }
               

            }
            catch (SQLException e)
            {
                System.err.println("Terjadi kesalahan dalam mengedit data");
                System.err.println(e.getMessage());
              
            }
        

        
    }


    //Method yang di extend
    public static void hapusdata() throws SQLException
    {
        Scanner input = new Scanner(System.in);
        
        //Exception    
        try
            {
                lihatdata();
                System.out.println("\n\nNo.ID    :");
                Integer noid = Integer.parseInt(input.nextLine());

                //Syntax untuk menghapus data
                String sql = "DELETE FROM data_transaksi WHERE no_id = "+ noid;

                Statement statement = conn.createStatement();
                if(statement.executeUpdate(sql) > 0)
                    {
                        System.out.println("\nData Terhapus(no_id"+noid+")");
                    }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Terjadi Kesalahan!!!");
            }
            catch(SQLException e)
            {
                System.out.println("Terjadi kesalahan dalam menghapus data barang");
            }
        
        
    }


    //Method yang di extend
    public static void caridata() throws SQLException
    {
        Scanner input = new Scanner (System.in);
        
            //Exception
            try
            {
                System.out.print("\n\nMasukkan Nama    :");
        
                //Synytax untuk mencari data yang sesuai dengan input
                String keyword = input.nextLine();
                Statement statement = conn.createStatement();
                String sql = "SELECT * FROM data_transaksi WHERE nama LIKE '%"+keyword+"%'";
                ResultSet result = statement.executeQuery(sql); 

                //Perulangan
                while(result.next())
                {
                    System.out.println();
                    System.out.print("No.ID             : ");
                    System.out.println(result.getInt("no_id")); 
                    System.out.print("Nama              : ");
                    System.out.println(result.getString("nama"));
                    System.out.print("Jenis Pakaian     : ");
                    System.out.println(result.getString("jenis_pakaian"));
                    System.out.print("Berat             : ");
                    System.out.println(result.getDouble("berat"));
                    System.out.print("Harga             : ");
                    System.out.println(result.getInt("harga"));
                    System.out.print("Total Harga       : ");
                    System.out.println(result.getDouble("total_harga"));
        
                }
            }
            catch(InputMismatchException i)
            {
                System.out.println("Inputan Salah");
            }            
            
        

    }
    


}

