
import java.util.Scanner;
import java.util.zip.Adler32;
import java.util.Date;

public class Menu {
    TulisFile Kata = new TulisFile();
    int menu;
    Scanner input = new Scanner(System.in);
    InputData Input = new InputData();
    Date date = new Date();


    public Menu(){
        this.menu = 100;
    }

    public void MenuUtama(){
        //menu = 100;
        System.out.println("=========== MEMU ~ UTAMA ============");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Sistem Persamaan Linier");
        System.out.println("[2] Determinan");
        System.out.println("[3] Matrik Balikan");
        System.out.println("[4] Interpolasi Polinom");
        System.out.println("[5] Regresi Linier Berganda");
        System.out.println("[0] Keluar");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=1;
        } else if (selectedMenu.equals("2")) {
            menu +=100;
        } else if (selectedMenu.equals("3")) {
            menu +=200;
        } else if (selectedMenu.equals("4")) {
            menu +=300;
        } else if (selectedMenu.equals("5")) {
            menu +=400;
        } else if (selectedMenu.equals("0")) {
            if (Kata.nData == 0) {
                System.exit(0);   
            }else{
                menu = 0;
            }
            
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }
        clearScreen();

    }
    public void MenuSPL(){
        //menu = 101;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Metode Eliminasi Gauss");
        System.out.println("[2] Metode Eliminasi Gauss-Jordan");
        System.out.println("[3] Metode Matriks Balikan");
        System.out.println("[4] Kaidah Cramer");
        System.out.println("[0] Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=1;
        } else if (selectedMenu.equals("2")) {
            menu +=2;
        } else if (selectedMenu.equals("3")) {
            menu +=3;
        } else if (selectedMenu.equals("4")) {
            menu +=4;
        }  else if (selectedMenu.equals("0")) {
            menu = 100;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();

    }
    public void MenuSplMEG(){
        //menu =102;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("====== Metode Eliminasi Gauss =======");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu SPL");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=4;
        } else if (selectedMenu.equals("2")) {
            menu +=8;
        }  else if (selectedMenu.equals("0")) {
            menu = 101;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();
    }
    public void MenuSplMEGJ(){
        //menu = 103;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("=== Metode Eliminasi Gauss-Jordan ===");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu SPL");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=4;
        } else if (selectedMenu.equals("2")) {
            menu +=8;
        }  else if (selectedMenu.equals("0")) {
            menu = 101;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }
        clearScreen();
    }
    public void MenuSplMMB(){
        //menu = 104;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("====== Metode Matriks Balikan =======");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu SPL");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=4;
        } else if (selectedMenu.equals("2")) {
            menu +=8;
        }  else if (selectedMenu.equals("0")) {
            menu = 101;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }
        clearScreen();
    }
    public void MenuSplKC(){
        //menu = 105;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("=========== Kaidah Cramer ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu SPL");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=4;
        } else if (selectedMenu.equals("2")) {
            menu +=8;
        }  else if (selectedMenu.equals("0")) {
            menu = 101;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }
        clearScreen();
    }
    public void MenuSplMEGik(){
        //menu =106;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("====== Metode Eliminasi Gauss =======");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputMNspl();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriks();
        M1.TulisMatrik();
        M1.TulisMatrikGauss();
        M1.TulisSPLGaus();
        Kata.ADDkata(M1.FileToSave);

        menu =101;
    }
    public void MenuSplMEGJik(){
        //menu = 107;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("=== Metode Eliminasi Gauss-Jordan ===");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputMNspl();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriks();
        M1.TulisMatrik();
        M1.TulisMatrikGausJordan();
        M1.TulisSPLGausJordan();
        Kata.ADDkata(M1.FileToSave);

        menu =101;

    }
    public void MenuSplMMBik(){
        //menu = 108;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("====== Metode Matriks Balikan =======");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputMNspl();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriks();
        M1.TulisMatrik();
        M1.TulisSPLmatrikBalikan();
        Kata.ADDkata(M1.FileToSave);

        menu =101;
    }
    public void MenuSplKCik(){
        //menu = 109;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("=========== Kaidah Cramer ===========");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputMNspl();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriks();
        M1.TulisMatrik();
        M1.DeterminenXYZCramer();
        Kata.ADDkata(M1.FileToSave);

        menu =101;
    }
    public void MenuSplMEGif(){
        //menu =110;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("====== Metode Eliminasi Gauss =======");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem = Input.MatrikFile;
        M1.TulisMatrik();
        M1.TulisMatrikGauss();
        M1.TulisSPLGaus();
        Kata.ADDkata(M1.FileToSave);


        menu =101;
    }
    public void MenuSplMEGJif(){
        //menu = 111;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("=== Metode Eliminasi Gauss-Jordan ===");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem = Input.MatrikFile;
        M1.TulisMatrik();
        M1.TulisMatrikGausJordan();
        M1.TulisSPLGausJordan();
        Kata.ADDkata(M1.FileToSave);


        menu =101;
    }
    public void MenuSplMMBif(){
        //menu = 112;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("====== Metode Matriks Balikan =======");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem = Input.MatrikFile;
        M1.TulisMatrik();
        M1.TulisSPLmatrikBalikan();
        Kata.ADDkata(M1.FileToSave);
        menu =101;
    }
    public void MenuSplKCif(){
        //menu = 113;
        System.out.println("====== Sistem Persamaan Linier ======");
        System.out.println("=========== Kaidah Cramer ===========");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem =Input.MatrikFile;
        M1.TulisMatrik();
        M1.DeterminenXYZCramer();
        Kata.ADDkata(M1.FileToSave);

        menu =101;
    }

    public void MenuDet() {
        //menu = 200;
        System.out.println("============ Determinan =============");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Reduksi Baris");
        System.out.println("[2] Ekspansi Kofaktor");
        System.out.println("[0] Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=1;
        } else if (selectedMenu.equals("2")) {
            menu +=2;
        } else if (selectedMenu.equals("0")) {
            menu = 100;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();
    }
    public  void MenuDetRB(){
        //menu = 201;
        System.out.println("============ Determinan =============");
        System.out.println("=========== Reduksi Baris ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu Determinan");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=2;
        } else if (selectedMenu.equals("2")) {
            menu +=4;
        } else if (selectedMenu.equals("0")) {
            menu = 200;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();
    }
    public  void MenuDetEK(){
        //menu = 202;
        System.out.println("============ Determinan =============");
        System.out.println("========= Ekspansi Kofaktor =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu Determinan");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=2;
        } else if (selectedMenu.equals("2")) {
            menu +=4;
        } else if (selectedMenu.equals("0")) {
            menu = 200;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();
    }
    public  void MenuDetRBik(){
        //menu = 203;
        System.out.println("============ Determinan =============");
        System.out.println("=========== Reduksi Baris ===========");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputNDetMB();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriks();
        M1.TulisMatrik();
        M1.TulisDeterminanReduksi();
        Kata.ADDkata(M1.FileToSave);


        menu = 200;
    }
    public  void MenuDetEKik(){
        //menu = 204;
        System.out.println("============ Determinan =============");
        System.out.println("========= Ekspansi Kofaktor =========");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputNDetMB();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriks();
        M1.TulisMatrik();
        M1.TulisDeterminanKofaktor();
        Kata.ADDkata(M1.FileToSave);

        menu = 200;
    }
    public  void MenuDetRBif(){
        //menu = 205;
        System.out.println("============ Determinan =============");
        System.out.println("=========== Reduksi Baris ===========");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem =Input.MatrikFile;
        M1.TulisMatrik();
        M1.TulisDeterminanReduksi();
        Kata.ADDkata(M1.FileToSave);

        menu = 200;
    }
    public  void MenuDetEKif(){
        //menu = 206;
        System.out.println("============ Determinan =============");
        System.out.println("========= Ekspansi Kofaktor =========");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem =Input.MatrikFile;
        M1.TulisMatrik();
        M1.TulisDeterminanKofaktor();
        Kata.ADDkata(M1.FileToSave);

        menu = 200;
    }
    public void MenuMB(){
        //menu = 300;
        System.out.println("========== Matrik Balikan ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=1;
        } else if (selectedMenu.equals("2")) {
            menu +=2;
        } else if (selectedMenu.equals("0")) {
            menu = 100;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();
    }
    public void MenuMBik(){
        //menu = 301;
        System.out.println("========== Matrik Balikan ===========");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputNDetMB();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriks();
        M1.TulisMatrik();
        M1.ProgramTulisMatrikBalikan();
        Kata.ADDkata(M1.FileToSave);

        menu = 300;
    }
    public void MenuMBif(){
        //menu = 302;
        System.out.println("========== Matrik Balikan ===========");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem =Input.MatrikFile;
        M1.TulisMatrik();
        M1.ProgramTulisMatrikBalikan();
        Kata.ADDkata(M1.FileToSave);

        menu = 300;
    }
    public void MenuIP(){
        //menu = 400;
        System.out.println("======= Interpolasi Polinom =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=1;
        } else if (selectedMenu.equals("2")) {
            menu +=2;
        } else if (selectedMenu.equals("0")) {
            menu = 100;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();
    }
    public void MenuIPik(){
        //menu = 401;
        System.out.println("======= Interpolasi Polinom =========");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputIP();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriksIP();
        M1.TulisMatrik();
        M1.BacaEstimasiIP();
        M1.BacaTulisInterpolasi();
        Kata.ADDkata(M1.FileToSave);

        menu = 400;
    }
    public void MenuIPif(){
        //menu = 402;
        System.out.println("======= Interpolasi Polinom =========");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem =Input.MatrikFile;
        M1.TulisMatrik();
        M1.BacaEstimasiIP();
        M1.BacaTulisInterpolasi();
        Kata.ADDkata(M1.FileToSave);

        menu = 400;
    }
    public void MenuIRB(){
        //menu = 500;
        System.out.println("===== Regresi Linier Berganda =======");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("[1] Input dari Keyboard");
        System.out.println("[2] Input dari File");
        System.out.println("[0] Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            menu +=1;
        } else if (selectedMenu.equals("2")) {
            menu +=2;
        } else if (selectedMenu.equals("0")) {
            menu = 100;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();
    }
    public void MenuIRBik(){
        //menu = 501;
        System.out.println("===== Regresi Linier Berganda =======");
        System.out.println("======= Input dari Keyboard =========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        Input.InputRe();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.BacaMatriksRe();
        M1.BacaTaksiranXre();
        M1.TulisMatrik();
        M1.TulisTaksiranRe();
        M1.BacaTulisSolusiRe();
        Kata.ADDkata(M1.FileToSave);

        menu = 500;
    }
    public void MenuIRBif(){
        //menu = 502;
        System.out.println("===== Regresi Linier Berganda =======");
        System.out.println("========= Input dari File ===========");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");

        Input.InputFile();
        ADTMatriks M1 = new ADTMatriks(Input.NB(), Input.NR());
        M1.Mem =Input.MatrikFile;
        M1.TulisMatrik();
        
        M1.BacaTaksiranXre();
        M1.BacaTulisSolusiRe();
        Kata.ADDkata(M1.FileToSave);

        menu = 500;
    }
    public void MenuSave(){
        System.out.println("=====        SIMPAN DATA      =======");
        System.out.println("     " + date.toString());
        System.out.println("-------------------------------------");
        System.out.println("Terdapat "+ Kata.nData +"data yang telah diolah");
        System.out.println("[0] Tidak  [1] Simpan  [2] Menu Utama");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("0")) {
            System.exit(0);
        } else if (selectedMenu.equals("1")) {
            Kata.Save();
            System.exit(0);

        } else if (selectedMenu.equals("2")) {
            menu = 100;
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }clearScreen();

    }

    public void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // clear screen untuk Linux, Unix, Mac
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }

    public void backToMenu() {
        System.out.println("");
        System.out.print("Tekan [Enter] untuk kembali..");
        input.nextLine();
        clearScreen();
    }


}
