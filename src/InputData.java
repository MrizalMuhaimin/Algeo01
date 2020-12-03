import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class InputData {
    float[][] MatrikFile;
    int NBrsEff;
    int NKolEff;
   

    Scanner Input = new Scanner(System.in);

    public  void InputFile(){
    	System.out.print("\nLokasi File: ");
        String dirName = Input.nextLine();
       
        File file = null;
        String[] paths;

        try {
            // Instansiasi objek File
            file = new File(dirName);
            // Ambil list files dan masukkan ke string paths
            paths = file.list();
            // Tampilkan semua path yang ada
            System.out.println("\nDaftar File:");
            for (String path : paths) {
                System.out.println(path);
            }
            
        	//posedure menerima masukan file
        	System.out.print("\nNama File: ");
        	String fileNam = Input.nextLine();
        	dirName += '/';
        	String fileName = dirName + fileNam;
        	String fileName2 = fileName;
        
            // membaca file
            File myFile = new File(fileName);
            Scanner fileReader = new Scanner(myFile);

            //menghitung baris dan kolom
            String data = fileReader.nextLine();

            String[] kata = data.split(" ");
            NKolEff = kata.length;           //Nilai Kolom didapatkan


            int IdxBrs = 0;
            while(fileReader.hasNextLine()){
                data = fileReader.nextLine();
                IdxBrs ++;

            }NBrsEff = IdxBrs+1;              //Banyaknya baris Didapatkan


            File myFile2 = new File(fileName2);
            Scanner fileReader2 = new Scanner(myFile2);

            IdxBrs = 0;

            MatrikFile = new float[NBrsEff][NKolEff]; //Membuat ukuran matrik baris kolom

            while(fileReader2.hasNextLine()){ //menyalin file
                String data2 = fileReader2.nextLine();
                
                String[] kata2 = data2.split(" ");
                for (int i =0; i < NKolEff; i++){
                    MatrikFile[IdxBrs][i] =  Float.parseFloat(kata2[i]);
                }
                IdxBrs ++;
            }

        } catch (FileNotFoundException e) {
            // kasus error
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void InputMNspl(){
        // menerima input m n (baris kolom) matriks
        System.out.print("Masukkan jumlah baris matriks: ");
        NBrsEff = Input.nextInt();
        System.out.print("Masukkan jumlah kolom matriks: ");
        NKolEff = Input.nextInt();
        NKolEff += 1;
    }
    public void InputNDetMB(){
        // menerima input m n (baris kolom) matriks
        System.out.print("Masukkan ukuran matrik bujursangkar: ");
        NBrsEff = Input.nextInt();
        NKolEff = NBrsEff;
    }
    public void InputIP(){
        System.out.print("Masukkan jumlah titik: "); // Input banyaknya titik yang diinginkan
        NBrsEff = Input.nextInt(); 
        NKolEff = 2;
                               
    }
    public void InputRe(){
        System.out.print("Masukkan jumlah variabel x: ");
        NKolEff = Input.nextInt(); 
        NKolEff ++;                                         // Input banyaknya variabel
        System.out.print("Masukkan jumlah data: ");
        NBrsEff = Input.nextInt();     
    }

    public int NB(){
        // mengembalikan bayaknya baris
        return NBrsEff;
    }
    public  int NR(){
        //mengembalikan banyaknya kolom
        return  NKolEff;
    }
}
