import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Date;

public class TulisFile {
    String fileinput ="\n";
    int nData = 0;
    Scanner Input = new Scanner(System.in);


    public void ADDkata(String kata){
        fileinput += kata;
        nData ++;
    }

    public void Save(){

        System.out.print("\nLokasi File: ");
        String dirName = Input.nextLine();
        Date date = new Date();


        File file = null;
        String[] paths;


        try {
            // Instansiasi objek File
            file = new File(dirName);
            // Ambil list files dan masukkan ke string paths
            paths = file.list();
            // Tampilkan semua path yang ada
            System.out.println("\nDaftar Files:");
            for (String path : paths) {
                System.out.println(path);
            }

            System.out.print("\nNama File: ");
            String fileName = Input.nextLine();
            dirName += '/';
            dirName +=fileName;
            

            String fileContent;
            fileContent = "*******Terimakasih Telah Menggunakan Program Algeo01-19009*******\n";
            fileContent +="================= " + date.toString() + "  =================\n";
            fileContent +="-----------------------------------------------------------------\n";
            fileContent += fileinput;

            FileWriter fileWriter = new FileWriter(dirName);
            fileWriter.write(fileContent);
            fileWriter.close();

            System.out.println("File Tersimpan!");


        } catch (Exception e) {
            e.printStackTrace();


        }
    }

}
