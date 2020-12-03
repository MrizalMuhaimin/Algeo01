
import java.util.Scanner;

public class ADTMatriks {
    private static String Hasil;
    /* ##### KONSTUKTOR definisi MATRIK ##### */
    int BrsEff;
    int KolEff;
    float[][] Mem; // matrik utama/ matik inputan
    float[][] MemS; // matrik segitiga atas dan kasus determinan
    float[][] MemA; // matrik kasus matrik augmented
    float[] Cramer; // jika AX = b maka cramer adalah b
    int NMemS; //ukuran matrik persegi dari matrik MemS
    int Kdet; //faktor pangkat di determinen
    float Det; // peyimpanan nilai determinan matrik
    int  x, y;
    boolean balikan = true;

    float estimasi; // kasus interpolasi

    float[] taksiran;//kasus taksiran regresi  

    //String Hasil;
    String FileToSave;




    /** input.next.... untuk memint masukan keybord **/
    Scanner input = new Scanner(System.in);


    /* ##### KONSTUKTOR membuat MATRIK ##### */
    public ADTMatriks(int NB, int NR){
        // Membuat matrik dengan ukuran banyaknya baris = NB
        // banyaknya kolom = NR, dan ukuran kontener selalu berbentuk persegi dari nilai NB, NB > NR atau NR, NR > NB
        //  dengan nilai efektif masing masing baris dan kolom adalah NBrsEff dan NKolEff
        int N;
        if(NB > NR){
            N = NB;
        }else{
            N = NR;
        }
        this.Mem = new float[N][N];
        this.BrsEff = NB;
        this.KolEff = NR;
        this.Det=0; // inisiasi awal determinan = 0. akan fataj jika di akses sbl proses pencarian Deretminan
        this.Kdet= 0;

    }


    /* ##### SELEKTOR  MATRIK ##### */

    public float Elmt(int i, int j){
        /* Mengirimkan elemen matrik[i][j] */
        return Mem[i][j];
    }
    public int NBrsEff(){
        /* Mengirimkan banyaknya/ukuran baris yg terdefinisi */
        return BrsEff;
    }
    public int NKolEff(){
        /* Mengirimkan banyaknya/ukuran kolom yg terdefinisi */
        return KolEff;
    }
    public int GetFirstIdxBrs(){
        /* Mengirimkan indeks baris terkecil Matrik */
        return 0;
    }
    public int GetFirstIdxKol(){
        /* Mengirimkan indeks kolom terkecil Matrik */
        return 0;
    }
    public int GetLastIdxBrs(){
        /* Mengirimkan indeks kolom terkecil Matrik */
        return NBrsEff() -1;
    }
    public int GetLastIdxKol(){
        /* Mengirimkan indeks kolom terkecil Matrik */
        return NKolEff()- 1;
    }
    public boolean IsIdxValid(int i, int j){
        return (( GetFirstIdxBrs () <= i && i <= GetLastIdxBrs ()) && (GetFirstIdxKol () <= j && j <= GetLastIdxKol()));
    }

    /* ##### Baca/Tulis  MATRIK  matrik INPUTAN ##### */
    public void BacaMatriks(){
        /* I.S. IsIdxValid(NB,NK) */
        /* F.S. M terdefinisi nilai elemen efektifnya, berukuran NB x NK */
        /* Deangan membaca elemin kiri kekanan baru kebawah dengan input kebawah*/
        System.out.println("\nInput Data:");
        for (int i = 0; i < NBrsEff() ;i++ ) {
            for (int j = 0;j < NKolEff() ;j++ ) {
            	if(NKolEff() != NBrsEff()){
            		if(j == GetLastIdxKol()){
            			System.out.print("konstanta Persamaan ke-" + (i + 1) + ": ");
            			Mem[i][j] = input.nextFloat();

            		}else{
            			System.out.print("Koefisien X_" + (j + 1) + " Persamaan ke-" + (i + 1) + ": ");
            			Mem[i][j] = input.nextFloat();
            		}

            	}else{
            		System.out.print("Koefisien X_" + (j + 1) + " Persamaan ke-" + (i + 1) + ": ");
            		Mem[i][j] = input.nextFloat();
            	}
               
            }
        }
    }
    public void BacaMatriksIP(){
        for (int i = 0; i < NBrsEff() ;i++ ) {
        	for (int j = 0;j < NKolEff() ;j++ ) {
        		if(j == GetLastIdxKol()){
            		System.out.print("Masukkan titik y ke-" + (i + 1) +  ": ");
            		Mem[i][j] = input.nextFloat();

            	}else{
            		System.out.print("Masukkan titik x ke-" + (i + 1) +  ": ");
            		Mem[i][j] = input.nextFloat();
            	}

            }
        }     

    }

    public void BacaEstimasiIP(){
        System.out.print("\nMasukkan nilai estimasi x = ");
        estimasi = input.nextFloat(); // Input nilai x sebagai estimasi

    }
    public void BacaMatriksRe(){
        for (int i = 0; i < NBrsEff() ;i++ ) {
            for (int j = 0;j < NKolEff() ;j++ ) {
                if(j == GetLastIdxKol()){
                    System.out.print("Masukkan y data ke-" + (i + 1) + ": ");
                    Mem[i][j] = input.nextFloat();

                }else{
                    System.out.print("Masukkan x" + (j + 1) + " data ke-" + (i + 1) + ": ");
                    Mem[i][j] = input.nextFloat();
                }

            }
        }     

    }

    public void BacaTaksiranXre(){
        int variabel, i;
        variabel = NKolEff();
        taksiran = new float[variabel-1];
        // Input semua nilai taksiran dari user
        System.out.println(" ");
        for (i = 0; i < variabel - 1; i++){
            System.out.print("Masukkan nilai taksiran X" + (i+1) + ": ");
            taksiran[i] = input.nextFloat();
        }
    }

    public void TulisMatrik(){
        /* I.S. M terdefinisi */
        /* F.S. Nilai M(i,j) ditulis ke layar per baris per kolom, masing-masing elemen per baris dipisahkan sebuah spasi */
        /* Proses: Menulis nilai setiap elemen Matrik ke layar dengan traversal per baris dan per kolom */
	/* Contoh: menulis matriks 3x3 (ingat di akhir tiap baris, tidak ada spasi)
	1 2 3
	4 5 6
	8 9 10
	*/
        System.out.println("\nMatrik Inputan:");
        for (int i = 0; i < NBrsEff() ;i++ ) {
            for (int j = 0;j < NKolEff() ;j++ ) {
                if (j == GetLastIdxKol()){
                    System.out.printf("%.4f\n",Mem[i][j]);

                }else{
                    System.out.printf("%.4f,",Mem[i][j]);
                }

            }

        }
    }
    public void TulisTaksiranRe(){
        System.out.println("\nNilai Taksiran X:");
        int variabel,i;
        variabel = NKolEff();
        //Tulis semua nilai taksiran dari user
        for (i = 0; i < variabel - 1; i++){
            System.out.print("X_" + (i+1) + ": ");
            System.out.println(taksiran[i]);
        }
        System.out.print("\n");

    }



    /* ********** KELOMPOK TEST TERHADAP MATRIKS ********** */
    public boolean IsBujurSangkar(){
        /* Mengirimkan true jika M adalah matriks dg ukuran baris dan kolom sama */
        return NBrsEff()== NKolEff();
    }
    public  boolean IsAllSatu(float[][] M){
        int idxbrs = 0;
        int idcklol =0;
        while (M[idxbrs][idcklol]==1 && idxbrs != NBrsEff() -1) {
            while ((M[idxbrs][idcklol]==1 && idcklol < NKolEff()-1)){
                idcklol ++;
            }
            if(idcklol == NKolEff() -1 && M[idxbrs][idcklol]==1){
                idcklol = 0;
                idxbrs++;
            }
        }
        while ((M[idxbrs][idcklol]==1 && idcklol < NKolEff()-1)){
            idcklol ++;
        }
        return (M[idxbrs][idcklol]==1);
    }

    /* ********** KELOMPOK 'MAKE' MATRIKS ********** */
    public void MakeMatrikSBujursangkar(){
        if(IsBujurSangkar()){// kasus matrik Determinan
            MemS = new float[NBrsEff()][NKolEff()];
        }else{// kasus matrik spl metode cramer
            MemS = new float[NBrsEff()][NKolEff()-1];

        }
        NMemS = NBrsEff();
    }
    public void MakeMatrikS(){
        MakeMatrikSBujursangkar();
        /* Membuta salinan matrik Mem[N][N] ke MemS[N][N] sebagai persiapan matrik segitiga **/
        if(IsBujurSangkar()){ // kasus matrik mencari determinan
            for(int i = GetFirstIdxBrs(); i <= GetLastIdxBrs(); i++){
                for (int j = GetFirstIdxKol(); j <= GetLastIdxKol(); j++){
                    MemS[i][j] = Mem[i][j];
                }
            }
        }else{ // kasus mecari spl dengan metode cramer
            Cramer = new float[NBrsEff()];
            for(int i = GetFirstIdxBrs(); i <= GetLastIdxBrs(); i++){
                for (int j = GetFirstIdxKol(); j <= GetLastIdxKol(); j++){
                    if ( j == GetLastIdxKol()){
                        Cramer[i] = Mem[i][j];
                    }else{
                        MemS[i][j] = Mem[i][j];
                    }

                }
            }

        }
    }

    public void MakeSegitigaAtas(){
        /* Membuaat matrik MemS menjadi mattrik segitiga atas **/
        Kdet = 0;
        for (int i=0; i < NMemS -1 ;i++ ) {
            // mencari apakan di diaonal matrik ada nilai 0 jika ada ditukarkan keculai no terletak di diagonal akhir
            if(MemS[i][i] == 0 ){
                int idx = i+1; // indek baris bernilai nol
                while(MemS[idx][i]==0 && idx < NMemS -1){
                    idx ++;
                }
                if(MemS[idx][i] != 0 ){
                    for (int j=0;j < NMemS ;j++ ) {
                        float temp;
                        temp = MemS[i][j];
                        MemS[i][j] = MemS[idx][j];
                        MemS[idx][j] = temp;
                    }
                }
                Kdet ++;
            }
            float pengkali;
            for (int j = i + 1; j < NMemS ; j++) {
                pengkali =MemS[j][i]/MemS[i][i];
                for (int k= i ;k < NMemS ;k++ ) {
                    MemS[j][k] = MemS[j][k] - (pengkali*MemS[i][k]);
                }
            }
        }


    }

    public void TulisMatrikSegitigaAtas(){
        MakeMatrikS(); // salnin matrik Men ke MenS
        MakeSegitigaAtas();
        System.out.println("\nMatrik Reduksi Segitiga Atas:");
        FileToSave += ("\nMatrik Reduksi Segitiga Atas:\n");
        for (int i = 0; i < NBrsEff() ;i++ ) {
            for (int j = 0;j < NKolEff() ;j++ ) {
                if (j == GetLastIdxKol()){
                    System.out.printf("%.4f\n",MemS[i][j]);
                    FileToSave += (MemS[i][j]+"\n");

                }else{
                    System.out.printf("%.4f,",MemS[i][j]);
                    FileToSave += (MemS[i][j]+" ");
                }

            }

        }
    }
    public float DeterminanCramer(){
    /* mengemhitung nilai determinan dari matri reduksi segitig atas
    kemuadian menirimkan nilai ke variabel kontruktor diatas danmengembalikan nilai dari Det */

        MakeSegitigaAtas();
        float detReduksi = 1;
        if(Kdet%2 == 1 ){
            detReduksi = -1*detReduksi;
        }
        Hasil = ("(");
        Hasil += String.valueOf(detReduksi);
        Hasil += (")");
        for (int i = 0; i< NBrsEff() ; i++ ) {
            Hasil += ("*(");
            Hasil += String.valueOf(MemS[i][i]);
            Hasil += (")");
            detReduksi = detReduksi*MemS[i][i];
        }
        Hasil += ("\n= ");
        Hasil += String.valueOf(detReduksi);

        Det = detReduksi;
        return detReduksi;
    }

    public float DeterminanReduksi(){
        MakeMatrikS(); // salnin matrik Men ke MenS
        return DeterminanCramer();


    }
    public void TulisDeterminanReduksi(){
        FileToSave = "//Determinan Reduksi//\n";
        SimpanInputan();

        if(IsBujurSangkar()) {
            if (IsAllSatu(Mem) && NBrsEff() != 1) {
                Hasil = ("= Tidak Dapat diselesaikan,\n terdapat pembagian dengan nol menghasilkan NaN");
            } else {
                TulisMatrikSegitigaAtas();
                DeterminanCramer();

            }
            System.out.println("\nDeterminan Reduksi: ");
            System.out.println(Hasil + "\n");
        }else {
            Hasil = ("Matrik imputan bukan matrik bujur sangkar\n Determinan tidak dapat dihitung!!");
            System.out.println(Hasil + "\n");
        }

        FileToSave += Hasil;
    }


    public void DeterminanEkspansiKofaktor(){
        float detMinor  ;
        float detKofaktor=0;
        float[][] Mminor; //matrik minor
        int N;
        Hasil = ("(");
        N = NBrsEff()-1; //ukuran matrikminor
        Mminor = new float[N][N];
        for ( int i = 0; i < NKolEff() ;i++ ) {
            if (Mem[0][i] != 0){
                //int IdxBrs = 0;

                for (int j = 1; j < NBrsEff() ; j++ ) {
                    int IdxKol = 0;
                    for (int k =0; k < NKolEff() ; k++) {
                        if( k != i && IdxKol< N){
                            // membuat matrik minor kofaktor
                            Mminor[j-1][IdxKol] = Mem[j][k];
                            IdxKol ++;
                        }
                    }
                }
                // pencarianan nilai determinan matrik minor
                int Kdetminor = 0;
                for (int l=0; l < N-1 ;l++ ) {
                    // mencari apakan di diaonal matrik ada nilai 0 jika ada ditukarkan keculai no terletak di diagonal akhir
                    if(Mminor[l][l] == 0 ){
                        int idx = l+1; // indek baris bernilai nol
                        while(Mminor[idx][l]==0 && idx < N-1){
                            idx ++;
                        }
                        if(Mminor[idx][l] != 0 ){
                            for (int m=0;m < N ;m++ ) {
                                float temp;
                                temp = Mminor[l][m];
                                Mminor[l][m] = Mminor[idx][m];
                                Mminor[idx][m] = temp;
                            }
                        }
                        Kdetminor ++;
                    }
                    float pengkali;
                    for (int m = l + 1; m < N; m++) {
                        pengkali =Mminor[m][l]/Mminor[l][l];
                        for (int n= l ;n < N ;n++ ) {
                            Mminor[m][n] = Mminor[m][n] - (pengkali*Mminor[l][n]);
                        }
                    }
                }
                float temp = 1;
                for (int l = 0; l< N ; l++ ) {
                    temp = temp*Mminor[l][l];
                }
                if(Kdetminor%2 ==0 ){
                    detMinor = temp;
                }else{
                    detMinor = -1*temp;
                }// didapatkan determiner matrik minor

                // pengkalian dan menghitung total determinan
                if(i == 0){
                    Hasil += ("(") + String.valueOf(Mem[0][i]) + (")*(") + String.valueOf(detMinor) + (")");
                    detKofaktor += Mem[0][i]*detMinor;
                }else if(i % 2 == 0){
                    Hasil += ("+(") + String.valueOf(Mem[0][i]) + (")*(") + String.valueOf(detMinor) + (")");
                    detKofaktor += Mem[0][i]*detMinor;
                }
                else{
                    Hasil += ("-(") + String.valueOf(Mem[0][i]) + (")*(") + String.valueOf(detMinor) + (")");
                    detKofaktor -=  Mem[0][i]*detMinor;
                }


            }

        }
        Hasil += (")\n = ")+ String.valueOf(detKofaktor);
        Det = detKofaktor;
        FileToSave = "//Determinan Reduksi//\n";
        SimpanInputan();
        FileToSave += Hasil;
    }
    public void TulisDeterminanKofaktor(){
        if(IsBujurSangkar()) {
            DeterminanEkspansiKofaktor();
            System.out.println("\nDeterminan Ekpansi Kofaktor: ");
            System.out.println(Hasil+"\n");
        }else {
            Hasil = ("Matrik imputan bukan matrik bujur sangkar\n Determinan tidak dapat dihitung!!");
            System.out.println(Hasil + "\n");
        }


    }

    public void DeterminenXYZCramer(){
        FileToSave = "//Sistem Perssaman Kaidah Carmer//\n";
        SimpanInputan();
        
        float DetTotal;
        DetTotal = DeterminanReduksi();
        if(DetTotal != 0){

            float [] DetXyz = new float [NMemS]; //kontener sementara det XYZ.....
            for (int i = 0; i < NMemS ;i++ ) {
                MakeMatrikS(); // salnin matrik Men ke MenS
                // *** metode cramer dijalankan. *****
                for (int j = 0; j < NMemS ;j++ ) {
                    MemS[j][i] = Cramer[j];
                }
                DetXyz[i] = DeterminanCramer();

            }
            for (int i = 0; i < NMemS ;i++ ) {
                Cramer[i] = DetXyz[i] / DetTotal;
            }
            System.out.print("\n Solusi Penyelesaian:\n");
            Hasil = ("\n Solusi Penyelesaian:\n");

            for (int i = 0; i < NMemS ;i++ ) {
                // misal keluaran x1 = 1, x2 = 3, dst
                System.out.print("X_");
                System.out.print(i+1);
                System.out.print(" = ");
                System.out.print(Cramer[i]);
                if(i == NMemS - 1) {
                    System.out.print(".\n");
                    Hasil += ("X_" + (i+1) + " = " + Cramer[i]+ ".\n");
                }
                else{
                    System.out.print(", ");
                    Hasil += ("X_" + (i+1) + " = " + Cramer[i]+ ",");
                }

            }

        }else{
            System.out.println("Tidak memiliki solusi\nDeterminan Matrik inputan = 0\n");
            Hasil = ("Tidak memiliki solusi\nDeterminan Matrik inputan = 0\n");
        }FileToSave += Hasil;

    }

    public  void TulisDeterminan(){
        /* menulikan nilai determinan dilayar */
        int temp;
        temp = (int) Det;
        if(temp == Det ){
            System.out.println(temp);
        }else{
            System.out.println(Det);
        }

    }
    /* MATRIK BALIKAN ******************/
    static void TulisMatriksBalikan(int N, float[][] M){
        // program menuliskan matrik balikan program ini dipanggil di MakeMatrikBalikan
        for (int i = 0; i < N ;i++ ) {
            for (int j = 0;j < N ;j++ ) {
                float temp;
                temp = M[i][j];
                if (j == N-1){

                    if(temp == M[i][j] ){
                        Hasil += String.valueOf(temp) +"\n";
                        System.out.printf("%.4f\n",temp);

                    }else{
                        System.out.printf("%.4f",M[i][j]);
                        Hasil += (String.valueOf(M[i][j]) +"\n");
                    }


                }else{
                    if(temp == M[i][j] ){
                        System.out.printf("%.4f ",temp);
                        Hasil += String.valueOf(temp) +"\n";
                    }else{
                        System.out.printf("%.4f ",M[i][j]);
                        Hasil += String.valueOf(M[i][j]) +"\n";
                    }

                }

            }

        }
    }
    public void TulisMatriksAugMB(int N,float[][]K){
        for(int i = 0;i<N;i++){
            for(int j = 0;j<2*N;j++){
                if(j<(2*N)-1){
                    System.out.printf("%.4f ",K[i][j]);
                    Hasil += (String.valueOf(K[i][j]) +" ");
                }else{
                    System.out.printf("%.4f\n",K[i][j]);
                    Hasil += (String.valueOf(K[i][j]) +"\n");
                }
            }
        }
    }

    // membuat dan menuliksan matrik balikan
    public void MakeMatrikBalikan(int N,float[][]M){
        // deklarasi variable balikan
        
        float [][] MInverse = new float [N][N];
        int Baris = N;
        int Kolom = N;
        int BarisAugmented = Baris;
        int KolomAugmented = 2*Baris;

        // create MatriksAugmented ukuran N x 2*N
        float [][] MatriksAugmented = new float[BarisAugmented][KolomAugmented];
        for(int i =0;i<BarisAugmented;i++){
            for(int j=0;j<KolomAugmented;j++){
                if(j<=N-1){
                    // untuk bagian yang bukan matriks identitas
                    MatriksAugmented[i][j] = M[i][j];
                }else{
                    // bagian matriks identitas
                    // untuk menyelaraskan indeks
                    int indeksDiagonal = j-N;
                    if( indeksDiagonal ==i){
                        MatriksAugmented[i][j] = 1;
                    }else{
                        MatriksAugmented[i][j] = 0;
                    }
                }
            }
        }
        System.out.println("\nMatriks Augmented yang digunakan  :");
        Hasil = ("\nMatriks Augmented yang digunakan  :\n");
        TulisMatriksAugMB(BarisAugmented,MatriksAugmented);
        // check apakah elemen awal '0'
        if(MatriksAugmented[0][0] == 0){
            balikan = false;
        }
        // Melakukan OBE Gauss-Jordan untuk mencari Matriks Balikan
        // inisialisasi indeks untuk penanda dilakukannya pengurangan saat OBE "pivot"
        int pivot = 0;
        // deklarasi faktor pengali untuk kalkulasi OBE Gauss-Jordan
        float Pengali;
        while((pivot<BarisAugmented) && balikan){
            // cek apakah masih memungkinkan satu utama
            if(MatriksAugmented[pivot][pivot] != 0){
                // pembuat satu utama
                float Pembagi = MatriksAugmented[pivot][pivot];
                for(int i = pivot;i < KolomAugmented;i++){
                    MatriksAugmented[pivot][i] /= Pembagi;
                }

                // Eliminasi untuk setiap kolom pada baris pivot
                for(int i=0;i<BarisAugmented;i++){
                    if(i != pivot){
                        Pengali = MatriksAugmented[i][pivot] / MatriksAugmented[pivot][pivot];

                        for(int j=0;j<KolomAugmented;j++){
                            MatriksAugmented[i][j] -= (MatriksAugmented[pivot][j] * Pengali);
                        }
                    }
                }
                pivot +=1;

            }else{
                balikan = false;
                break;
            }
        }

        if(balikan){
            // copy matriks
            for(int i=0;i<Baris;i++){
                for(int j=0;j<Kolom;j++){
                    int BarisInverse = i;
                    int KolomInverse = j+N;
                    MInverse[i][j]=MatriksAugmented[BarisInverse][KolomInverse];
                }
            }
            // Tulis Matriks Inverse
            System.out.println("\nMatriks Inverse:");
            Hasil += ("\nMatriks Inverse:\n");
            TulisMatriksBalikan(N,MInverse);

            // copy matriks
            for(int i=0;i<Baris;i++){
                for(int j=0;j<Kolom;j++){
                    M[i][j] = MInverse[i][j];
                }
            }


        }else{
            System.out.println("Matriks tersebut Matriks Singular");
            Hasil += ("Matriks tersebut Matriks Singular\n");
        }

    }

    public void ProgramTulisMatrikBalikan(){
        MakeMatrikS();
        MakeMatrikBalikan(NBrsEff(),MemS);
        FileToSave = "//Matrik Balikan//\n";
        SimpanInputan();
        FileToSave += Hasil;

    }
    public void TulisSPLmatrikBalikan(){
        FileToSave = "//Sistem Perssaman Linier Matrik Balikan//\n";
        SimpanInputan();
         // Mencari balikan dari matriks_augmented
        int baris, kolom;

        baris =NBrsEff();
        kolom = NKolEff() -1;
        float[] result = new float[baris];

        MakeMatrikS();
        MakeMatrikA();


        if(baris==kolom && balikan){
            MakeMatrikBalikan(baris,MemA);

            // perkalian matriks
            for(int i=0;i<baris;i++){
                float sum = 0;
                for(int k=0;k<baris;k++){
                    sum += MemA[i][k]*Cramer[k];
                }
                result[i] = sum;
                
            }

            // Melakukan print solusi spl
            System.out.println("\nSolusi Penyelesaian :");
            Hasil += ("\nSolusi Penyelesaian :\n");
            for(int i=0;i<baris;i++){
                for(int j=0;j<1;j++){
                    if(i==(baris-1)) {
                        System.out.printf("X_%d = %.4f\n",(i+1),result[i]);
                        Hasil += ("X_%d = "+ (i+1)+ result[i]+"\n");
                    }else{
                        System.out.printf("X_%d = %.4f, ",(i+1),result[i]);
                        Hasil += ("X_%d = "+ (i+1)+ result[i]+" ");
                    }
                }
            }

        }else{
            System.out.println("SPL tidak dapat diselesaikan dengan Metode Matriks Balikan ");
            Hasil += ("SPL tidak dapat diselesaikan dengan Metode Matriks Balikan\n ");
        }

        FileToSave += Hasil;

    }





    /* SPL MATRIK GAUSS DAN GAUSS JORDAN */
    public void MakeMatrikA(){
    	//Membuat matrik augmented
    	MemA = new float[NBrsEff()][NKolEff()];
    	for(int i = GetFirstIdxBrs(); i <= GetLastIdxBrs(); i++){
            for (int j = GetFirstIdxKol(); j <= GetLastIdxKol(); j++){
                MemA[i][j] = Mem[i][j];
            }
        }
    }
    public void MakeMatrikAIP(){
    	int titik;
        int i, j;
    	titik = NBrsEff();
    	MemA = new float[titik][titik+1];
    	// Assign matriks MemA dengan angka 1 (agar kolom pertama/paling kiri bernilai 1 semua dan yang lain nanti diganti)
        for (i = 0; i < titik; i++) {
            for (j = 0; j < titik+1; j++) {
                MemA[i][0] = 1;
            }
        }

        // Menyalin semua titik x di array titik_x ke dalam matriks MemA kolom ke-dua
        for (i = 0; i < titik; i++) {
            for (j = 0; j < titik+1; j++) {
                MemA[i][1] = Mem[i][0];
            }
        }

        // Menyalin semua titik y di array titik_y ke dalam matriks MemA kolom paling kanan
        for (i = 0; i < titik; i++) {
            for (j = 0; j < titik+1; j++) {
                MemA[i][titik] = Mem[i][1];
            }
        }

        // Proses mengisi matriks MemA dari kolom ketiga sampai akhir
        for (j = 2; j < titik; j++){
            for (i = 0; i < titik; i++){
                MemA[i][j] = (float) Math.pow(Mem[i][0], j);       // Mengisi MemA kolom ke-j dengan hasil x^j
            }                                                           // dengan j adalah indeks kolom
        }

    }

    public void MakeMatrikARe(){
        int i, j,k;
        int variabel;
        int ndata;
        ndata = NBrsEff();
        variabel = NKolEff();
        MemA = new float[NKolEff()][NKolEff()+1];
         // Mengisi elemen kolom ke-0 dan baris ke-0 dengan banyak data
        MemA[0][0] = ndata;

        // Mengisi semua elemen pada baris paling atas dan kolom paling kiri dengan jumlah X (sebanyak n data)
        // dan kolom paling kanan baris pertama dengan jumlah semua y (sebanyak ndata)
        for (j = 1; j < variabel; j++){
            float sumx = 0;
            float sumy = 0;
            for (i = 0; i < ndata; i++){
                sumx += Mem[i][j-1];                         // Menjumlah semua nilai variabel Xi
                sumy += Mem[i][NKolEff()-1];                              // Menjumlah semua nilai variabel y
            }
            MemA[0][j] = sumx;                                  // Memasukkan nilai ke matriks MemA
            MemA[j][0] = sumx;                                  // Memasukkan nilai ke matriks MemA
            MemA[0][variabel] = sumy;                           // Memasukkan nilai ke matriks MemA
        }

        for (i = 1; i < variabel; i++) {
            for (j = 1; j < variabel; j++) {
                float sumx = 0;
                float sumy = 0;
                for (k = 0; k < ndata; k++){
                    sumx += Mem[k][j-1]*Mem[k][i-1];  // data x
                    sumy += Mem[k][NKolEff()-1]*Mem[k][i-1]; // data y = Mem[k][NKolEff()-1]
                }
                MemA[i][j] = sumx;
                MemA[i][variabel] = sumy;
            }
        }
    }


    public void MakeMatrikGauss(){
    	MakeMatrikA();
    	// make matrik augmanted Gaus
    	int i, j, k, l;
        float temp, pembagi, pembagi2;
        pembagi = 0;
       ;
        for (i = 0; i < NBrsEff(); i++) {
            search:
            {
                for (j = i; j < NKolEff() ; j++) {
                    for (k = i; k < NBrsEff(); k++) {
                        if (MemA[k][j] != 0) {
                            x = k;
                            y = j;
                            break search;
                        }
                    }
                }
            }
            if (x != i && x > i) {
                tukar:
                {
                    for (k = i; k < NBrsEff(); k++) {
                        if (k != x) {
                            for (j = 0; j < NKolEff(); j++) {
                                temp = MemA[k][j];
                                MemA[k][j] = MemA[x][j];
                                MemA[x][j] = temp;
                            }
                        }
                    }
                }
            }

            if (y != NKolEff()-1) {
                pembagi = MemA[i][y];
                for (j = 0; j < NKolEff() ; j++) {
                    if (pembagi != 0 && MemA[i][j] != 0) {
                        MemA[i][j] = MemA[i][j] / pembagi;
                    }
                }
            }
            for (j = i+1; j < NBrsEff(); j++){
                if (MemA[j][y] != 0 && y != NKolEff()-1){
                    pembagi2 = MemA[j][y];
                    for (k = y; k < NKolEff(); k++){
                        MemA[j][k] = MemA[j][k] - MemA[i][k]*pembagi2;
                    }
                }
            }
        }


    }
    public void TulisMatrikA(String M){
        int i, j, k, l;
    	System.out.println(M);
        for (i = 0; i < NBrsEff(); i++) {
            System.out.print("[");
            for (j = 0; j < NKolEff(); j++) {
                System.out.printf("%.4f ",MemA[i][j]);
                if (j < NKolEff()-1) {
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }

    }


    public void TulisMatrikGauss(){
        MakeMatrikGauss();
    	TulisMatrikA("\nMatriks Gauss:");
    }

    public void SPLGaus(){
        int kolom = NKolEff()-1;
        int baris = NBrsEff();
        int i, j, k, l, c;
        float temp, pembagi, pembagi2;
        pembagi = 0;
        // Proses Output SPL Gauss
        boolean diagonal = true;
        if (baris <= kolom) {
            c = baris;
        } else {
            c = kolom;
        }
        i = 0;
        while (i < c && diagonal) {                          // Proses mencari apakah semua diagonal utama bernilai 1
            if (MemA[i][i] == 0) {                  // utama atau terdapat nol
                diagonal = false;                               // Jika ditemukan nol mengembalikan false dan berhenti
            } else {
                i++;
            }
        }

        float[][] salin = new float[baris][kolom + 1];
        for (i = 0; i < baris; i++) {
            for (j = 0; j < kolom + 1; j++) {
                salin[i][j] = MemA[i][j];
            }
        }
        float[] Solusi = new float[c];
        if ((diagonal) && (kolom <= baris)) {                // Jika semua diagonal utama bernilai 1
            for (i = c - 1; i >= 0; i--) {
                float sum = salin[i][kolom];                // Proses substitusi dari belakang
                for (k = i+1; k < c; k++) {                 // untuk emenntukan hasil solusi dari gauss
                    sum = sum - salin[i][k];
                }
                Solusi[i] = sum;
                for (j = 0; j < i; j++) {
                    salin[j][i] = salin[j][i] * Solusi[i];
                }
            }
            System.out.println("\nMatriks bersolusi tunggal/unik dengan solusi sebagai berikut:");
            Hasil = "\nMatriks bersolusi tunggal/unik dengan solusi sebagai berikut:\n";
            for (i = 0; i < c; i++) {
                System.out.println("X_" + (i + 1) + " = " + Solusi[i]);
                Hasil += ("X_" + (i + 1) + " = " + Solusi[i]+"\n");
            }
        }
        else{
            tanda:
            {
                for (l = baris - 1; l >= 0; l--) {              // Proses mencari apa terdapat baris yang isinya nol
                    for (y = 0; y < kolom+1; y++){              // semua namun konstantanya bukan nol
                        if (MemA[l][y] !=  0){
                            break tanda;
                        }
                    }
                }
            }
            if (y == kolom) {                                    // Jika ditemukan satu baris nol semua kecuali konstanta
                System.out.println("\nMatriks tidak memiliki solusi");
                Hasil = "\nMatriks tidak memiliki solusi.";
            }
            else {
                for (i = baris-1; i > 0; i--){                              // Pencarian terbalik dari baris bawah
                    j = 0;
                    while (j < kolom && MemA[i][j]==0){        // Mencari 1 utama yang pertama kali dari bawah
                        j = j+1;
                    }
                    if (j == kolom){                                        // Jika sampai ujung kanan kolom belum ditemukan
                        continue;                                           // Maka langsung ke baris di atasnya dan
                    }                                                       // tidak diproses
                    if (j < kolom){                                         // Jika ditemukan 1 utama pada kolom ke j maka
                        for (l = 0; l < i; l++) {                           // dilakukan proses eliminasi agar semua elemen
                            pembagi2 = MemA[l][j];             // di atas 1 utama juga bernilai nol
                            for (k = 0; k < kolom+1; k++) {
                                if (MemA[i][k] != 0) {
                                    MemA[l][k] = MemA[l][k] - MemA[i][k] * pembagi2;
                                }
                            }
                        }
                    }
                }

                tanda:
                {
                    for (l = baris - 1; l >= 0; l--) {              // Proses mencari apa terdapat baris yang isinya nol
                        for (y = 0; y < kolom+1; y++){              // semua namun konstantanya bukan nol
                            if (MemA[l][y] !=  0){
                                break tanda;
                            }
                        }
                    }
                }
                if (y == kolom){                                    // Jika ditemukan satu baris nol semua kecuali konstanta
                    System.out.println("\nMatriks tidak memiliki solusi");
                    Hasil = "\nMatriks tidak memiliki solusi.";
                } else {                                            // Jika tidak ada yang semuanya nol kecuali konstanta
                    float[][] subInt = new float[kolom][kolom + 1]; // Deklarasi matriks untuk salinan matriks augmented
                    for (i = 0; i < kolom; i++) {                   // namun posisinya sesuai dengan posisi 1 utama, misalnya
                        for (j = 0; j < kolom + 1; j++) {           // diagonal utama ditemukan di 0,3 maka disalin ke 3,3
                            subInt[i][j] = 0;                       // Assign semua elemen yang tersisa dengan 0
                        }
                    }
                    for (i = 0; i < baris; i++) {
                        boolean cari_0 = false;
                        for (j = 0; j < kolom + 1; j++) {
                            if (MemA[i][j] != 0) {     // Proses mencari posisi 1 utama
                                y = i;
                                x = j;
                                break;
                            }
                        }
                        for (k = 0; k < kolom; k++) {
                            for (j = 0; j < kolom + 1; j++) {
                                subInt[x][j] = MemA[y][j]; // Proses menyalin matriks seperti keterangan di atas
                            }
                        }
                    }

                    String[][] substitusi = new String[kolom][kolom + 1]; // Deklarasi matriks salinan subInt namun bertype string
                    for (i = 0; i < kolom; i++) {
                        for (j = 0; j < kolom + 1; j++) {
                            substitusi[i][j] = "0";
                        }
                    }
                    for (i = 0; i < kolom; i++) {
                        for (j = 0; j < kolom + 1; j++) {
                            if (subInt[i][j] != 0) {
                                substitusi[i][j] = String.valueOf(subInt[i][j]);    // Casting dari float ke string
                            }
                        }
                    }

                    String[] parameter = {"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"};
                    for (k = 0; k < 25; k++) {
                        for (i = 0; i < kolom; i++) {
                            if (substitusi[i][i] == "0") {
                                substitusi[i][i] = parameter[k];    // Jika matriks diagonal bernilai 0 maka diganti dengan parameter
                                k++;
                            }
                        }
                        if (i == kolom) {
                            break;
                        }
                    }

                    String[] result = new String[kolom];            // Deklarasi array yang akan menampung semua solusi x
                    for (i = 0; i < kolom; i++) {
                        result[i] = "";                             // Assign dengan string kosong
                    }
                    for (i = 0; i < kolom; i++) {
                        if (subInt[i][i] == 1) {                    // Jika terdapat 1 utama/bukan nol
                            for (j = i + 1; j < kolom; j++) {
                                if (substitusi[i][j] != "0") {
                                    result[i] += "-(" + substitusi[i][j] + substitusi[j][j] + ")";
                                }
                            }
                        } else {                                    // Jika diagonal utamanya nol
                            result[i] = substitusi[i][i];           // menyalin hasil parameter ke array hasil
                        }
                    }
                    System.out.println(("\nMatriks mempunyai solusi banyak/tak berhingga\n ditulis dalam parameter sebagai berikut:"));
                    Hasil = "\nMatriks mempunyai solusi banyak/tak berhingga\n ditulis dalam parameter sebagai berikut:\n";
                    for (i = 0; i < kolom; i++) {
                        if (subInt[i][i] != 0) {
                            if (subInt[i][kolom] == 0){
                                if (result[i] == ""){
                                    System.out.println("X_" + (i + 1) + " = 0");
                                    Hasil += ("X_" + (i + 1) + " = 0\n");
                                }else {
                                    System.out.println("X_" + (i + 1) + " = " + result[i]);
                                    Hasil += ("X_" + (i + 1) + " = " + result[i] +"\n");
                                }
                            } else{
                                System.out.println("X_" + (i + 1) + " = " + substitusi[i][kolom] + result[i]);
                                Hasil += ("X_" + (i + 1) + " = " + substitusi[i][kolom] + result[i] +"\n");
                            }
                        } else {
                            System.out.println("X_" + (i + 1) + " = " + result[i]);
                            Hasil += ("X_" + (i + 1) + " = " + result[i] +"\n");
                        }
                    }
                }
            }
        }
    }

    public void MakeMatrikGausJordan(){
        int i, j, k, l;
        float temp, pembagi, pembagi2;
        pembagi = 0;
    	MakeMatrikGauss();
    	for (i = NBrsEff()-1; i > 0; i--){
            j = 0;
            while (j < NKolEff()-1 && MemA[i][j]==0){
                j = j+1;
            }
            if (j == NKolEff()-1){
                continue;
            }
            if (j < NKolEff()-1){
                for (l = 0; l < i; l++) {
                    pembagi2 = MemA[l][j];
                    for (k = 0; k < NKolEff(); k++) {
                        if (MemA[i][k] != 0) {
                            MemA[l][k] = MemA[l][k] - MemA[i][k] * pembagi2;
                        }
                    }
                }
            }
        }

    }
    public void TulisMatrikGausJordan(){
        MakeMatrikGausJordan();
    	TulisMatrikA("\nMatriks Gauss Jordan: ");

    }

    public void SPLGausJordan(){
    	// Proses Output SPL Gauss Jordan
        int i, j, k, l, c;
        boolean diagonal = true;
        if (NBrsEff() <= NKolEff()-1){
            c = NBrsEff();
        } else{
            c = NKolEff()-1;
        }
        i = 0;
        while (i < c && diagonal){                          // Proses mencari apakah semua diagonal utama bernilai 1
            if (MemA[i][i] == 0){                  // utama atau terdapat nol
                diagonal = false;                               // Jika ditemukan nol mengembalikan false dan berhenti
            } else{
                i++;
            }
        }

        if ((diagonal) && (NKolEff()-1 <= NBrsEff())){                    // Jika semua diagonal utama bernilai 1
            System.out.println("\nMatriks bersolusi tunggal/unik dengan solusi sebagai berikut:");
            Hasil = ("\nMatriks bersolusi tunggal/unik dengan solusi sebagai berikut:\n");
            for (i = 0; i < c; i++) {
                System.out.println("X_" + (i + 1) + " = " + MemA[i][NKolEff()-1]);
                Hasil += ("X_" + (i + 1) + " = " + MemA[i][NKolEff()-1]+"\n");
            }

        } else {                                                // Jika diagonal utama ada yang nol
            tanda:
            {
                for (l = NBrsEff() - 1; l >= 0; l--) {              // Proses mencari apa terdapat baris yang isinya nol
                    for (y = 0; y < NKolEff(); y++){              // semua namun konstantanya bukan nol
                        if (MemA[l][y] !=  0){
                            break tanda;
                        }
                    }
                }
            }

            if (y == NKolEff()-1){                                    // Jika ditemukan satu baris nol semua kecuali konstanta
                System.out.println("\nMatriks tidak memiliki solusi");
                Hasil = ("\nMatriks tidak memiliki solusi.");

            } else {                                            // Jika tidak ada yang semuanya nol kecuali konstanta
                float[][] subInt = new float[NKolEff()-1][NKolEff()]; // Deklarasi matriks untuk salinan matriks augmented
                for (i = 0; i < NKolEff()-1; i++) {                   // namun posisinya sesuai dengan posisi 1 utama, misalnya
                    for (j = 0; j < NKolEff() ; j++) {           // diagonal utama ditemukan di 0,3 maka disalin ke 3,3
                        subInt[i][j] = 0;                       // Assign semua elemen yang tersisa dengan 0
                    }
                }
                for (i = 0; i < NBrsEff(); i++) {
                    boolean cari_0 = false;
                    for (j = 0; j < NKolEff(); j++) {
                        if (MemA[i][j] != 0) {     // Proses mencari posisi 1 utama
                            y = i;
                            x = j;
                            break;
                        }
                    }
                    for (k = 0; k < NKolEff()-1; k++) {
                        for (j = 0; j < NKolEff() ; j++) {
                            subInt[x][j] = MemA[y][j]; // Proses menyalin matriks seperti keternyan di atas
                        }
                    }
                }

                String[][] substitusi = new String[NKolEff()-1][NKolEff()]; // Deklarasi matriks salinan subInt namun bertype string
                for (i = 0; i < NKolEff()-1; i++) {
                    for (j = 0; j < NKolEff(); j++) {
                        substitusi[i][j] = "0";
                    }
                }
                for (i = 0; i < NKolEff()-1; i++) {
                    for (j = 0; j < NKolEff() ; j++) {
                        if (subInt[i][j] != 0) {
                            substitusi[i][j] = String.valueOf(subInt[i][j]);    // Casting dari float ke string
                        }
                    }
                }

                String[] parameter = {"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"};
                for (k = 0; k < 8; k++) {
                    for (i = 0; i < NKolEff()-1; i++) {
                        if (substitusi[i][i] == "0") {
                            substitusi[i][i] = parameter[k];    // Jika matriks diagonal bernilai 0 maka diganti dengan parameter
                            k++;
                        }
                    }
                    if (i == NKolEff()-1) {
                        break;
                    }
                }

                String[] result = new String[NKolEff()-1];            // Deklarasi array yang akan menampung semua solusi x
                for (i = 0; i < NKolEff()-1; i++) {
                    result[i] = "";                             // Assign dengan string kosong
                }
                for (i = 0; i < NKolEff()-1; i++) {
                    if (subInt[i][i] == 1) {                    // Jika terdapat 1 utama/bukan nol
                        for (j = i + 1; j < NKolEff()-1; j++) {
                            if (substitusi[i][j] != "0") {
                                result[i] += "-(" + substitusi[i][j] + substitusi[j][j] + ")";
                            }
                        }
                    } else {                                    // Jika diagonal utamanya nol
                        result[i] = substitusi[i][i];           // menyalin hasil parameter ke array hasil
                    }
                }
                System.out.println(("\nMatriks mempunyai solusi banyak/tak berhingga ditulis dalam parameter sebagai berikut:"));
                Hasil = ("\nMatriks mempunyai solusi banyak/tak berhingga ditulis dalam parameter sebagai berikut:\n");
                for (i = 0; i < NKolEff()-1; i++) {
                    if (subInt[i][i] != 0) {
                        if (subInt[i][NKolEff()-1] == 0){
                            if (result[i] == ""){
                                System.out.println("X_" + (i + 1) + " = 0");
                                Hasil += ("X_" + (i + 1) + " = 0\n");
                            }else {
                                System.out.println("X_" + (i + 1) + " = " + result[i]);
                                Hasil += ("X_" + (i + 1) + " = " + result[i]+"\n");
                            }
                        } else{
                            System.out.println("X_" + (i + 1) + " = " + substitusi[i][NKolEff()-1] + result[i]);
                            Hasil += ("X_" + (i + 1) + " = " + substitusi[i][NKolEff()-1] + result[i]+"\n");
                        }
                    } else {
                        System.out.println("X_" + (i + 1) + " = " + result[i]);
                        Hasil += ("X_" + (i + 1) + " = " + result[i]+"\n");
                    }
                }
            }
            
        }
    }
    public void SimpanInputan(){
        FileToSave += "Matrik Inputan:\n";
        for (int i =0;i <NBrsEff() ;i++ ) {
            for (int j = 0; j < NKolEff() ;j++ ) {
                if(j == NKolEff()-1){
                    FileToSave += String.valueOf(Mem[i][j]);
                    FileToSave += "\n";
                }else{
                    FileToSave += String.valueOf(Mem[i][j]);
                    FileToSave += " ";
                }
                
            }
            
        }

    }
    public void SimpanMatrikA(){
        for (int i =0;i <NBrsEff() ;i++ ) {
            for (int j = 0; j < NKolEff() ;j++ ) {
                if(j == NKolEff()-1){
                    FileToSave += String.valueOf(MemA[i][j]);
                    FileToSave += "\n";
                }else{
                    FileToSave += String.valueOf(MemA[i][j]);
                    FileToSave += " ";
                }
                
            }
            
        }
    }

    public void TulisSPLGaus(){
    	FileToSave = "//Sistem Perssaman Linier Gauss//\n";
    	SimpanInputan();
    	FileToSave += "\nMatrik Gauss:\n";
    	SimpanMatrikA();
        SPLGaus();
        FileToSave +=  Hasil;
        System.out.println("\n");
    }
    public void TulisSPLGausJordan(){
        FileToSave = "//Sistem Perssaman Linier Gauss Jordan//\n";
        SimpanInputan();
        FileToSave += "\nMatrik Gauss Jordan:\n";
        SimpanMatrikA();
        SPLGausJordan();
        FileToSave +=  Hasil;
        System.out.println("\n");
    }

    public void BacaTulisInterpolasi(){
        FileToSave = "//Interpolasi Polinom//\n";
        SimpanInputan();
        
        float  temp, pembagi, pembagi2;
        int titik;
        titik = NBrsEff();
        int i, j,l,k;

    	MakeMatrikAIP();
        // PROSES ELIMINASI GAUSS

        for (i = 0; i < titik; i++) {
            search:                                                     // Proses mencari dari baris pertama kolom
            {                                                           // pertama elemen matriks yang bernilai
                for (j = i; j < titik + 1; j++) {                       // bukan nol (pencarian dilakukan perkolom/
                    for (k = i; k < titik; k++) {                       // ke bawah terlebih dahulu)
                        if (MemA[k][j] != 0) {
                            x = k;
                            y = j;
                            break search;                               // Jika terdapat elemen diagonal yang berniali
                        }                                               // nol maka pencarian berhenti dan akan
                    }                                                   // menimpan indeks baris dan kolom yang bernilai
                }                                                       // bukan nol muncul pertama kali
            }
            if (x != i && x > i) {                                      // Jika indeks baris elemen bukan sama dengan i
                tukar:
                {
                    for (k = i; k < titik; k++) {
                        if (k != x) {
                            for (j = 0; j < titik + 1; j++) {           // Dilakukan penukaran baris
                                temp = MemA[k][j];
                                MemA[k][j] = MemA[x][j];
                                MemA[x][j] = temp;
                            }
                        }
                    }
                }
            }

            // Proses untuk memperoleh 1 utama dengan melakukan pembagian dengan elemen 1 utama
            if (y != titik) {
                pembagi = MemA[i][y];
                for (j = 0; j < titik + 1; j++) {
                    if (pembagi != 0 && MemA[i][j] != 0) {
                        MemA[i][j] = MemA[i][j] / pembagi;
                    }
                }
            }

            // Proses eliminasi agar elemen di bawah 1 utama bernilai nol semua
            for (j = i+1; j < titik; j++){
                if (MemA[j][y] != 0 && y != titik){
                    pembagi2 =MemA[j][y];
                    for (k = y; k < titik+1; k++){
                        MemA[j][k] = MemA[j][k] - MemA[i][k]*pembagi2;
                    }
                }
            }
        }


        // PROSES ELIMINASI GAUSS JORDAN

        for (i = titik-1; i > 0; i--){                                  // Pencarian terbalik dari baris bawah
            j = 0;
            while (j < titik && MemA[i][j]==0){                     // Mencari 1 utama yang pertama kali dari bawah
                j = j+1;
            }
            if (j == titik){                                            // Jika sampai ujung kanan kolom belum ditemukan
                continue;                                               // Maka langsung ke baris di atasnya dan
            }                                                           // tidak diproses
            if (j < titik){                                             // Jika ditemukan 1 utama pada kolom ke j maka
                for (l = 0; l < i; l++) {                               // dilakukan proses eliminasi agar semua elemen
                    pembagi2 = MemA[l][j];                          // di atas 1 utama juga bernilai nol
                    for (k = 0; k < titik+1; k++) {
                        if (MemA[i][k] != 0) {
                            MemA[l][k] = MemA[l][k] - MemA[i][k] * pembagi2;
                        }
                    }
                }
            }
        }

    	float[] ArraySolusi = new float[titik];                         // Deklarasi array baru untuk menampung hasil
        for (i = 0; i < titik; i++){                                    // atau solusi dari eliminasi gauss jordan
            ArraySolusi[i] = MemA[i][titik];
        }

        String[] StrSolusi = new String[titik];                         // Deklarasi array baru yang isinya sama dengan
        for (i = 0; i < titik; i++){                                    // ArraySolusi namun bertype string
            StrSolusi[i] = String.valueOf(ArraySolusi[i]);              // Casting float ke string
        }

        // Proses Output
        // Output Persamaan polinom interpolasi
        System.out.println("\nPersamaan polinom interpolasi:");
        FileToSave += ("\nPersamaan polinom interpolasi:\n");
        
        System.out.print("P(x) = ");
        FileToSave += ("P(x) = ");
        if (ArraySolusi[0] != 0){                                       // Input konstanta atau angka paling depan
            System.out.print(StrSolusi[0] + " ");                       // yang tidak diikuti x
            FileToSave += (StrSolusi[0] + " ");  
        }
        for (i = 1; i < titik; i++){                                    // Output koefisien beserta variabel (x)
            if (ArraySolusi[i] > 0){
                System.out.print("+ " + StrSolusi[i] + "x^" + i + " ");
                FileToSave += ("+ " + StrSolusi[i] + "x^" + i + " ");
            } else if (ArraySolusi[i] < 0){
                System.out.print(StrSolusi[i] + "x^" + i + " ");
                FileToSave += (StrSolusi[i] + "x^" + i + " ");
            }
        }
        System.out.println("\n");
        FileToSave += ("\n");


        // Output Nilai
        System.out.print("Hasil dari interpolasi polinom di titik x = " + estimasi + " adalah ");
        FileToSave += ("Hasil dari interpolasi polinom di titik x = " + estimasi + " adalah ");
        float jumlah = 0;
        for (i = 0; i < titik; i++){
            jumlah += ArraySolusi[i]*(Math.pow(estimasi, i));           // Proses menghitung nilai dengan substitusi
        }                                                               // x atau angka estimasi yang diinginkan
        System.out.printf("%.4f",jumlah);
        System.out.println("\n");
        FileToSave += (jumlah + "\n");
    }

    public void BacaTulisSolusiRe(){
        FileToSave = "//Regresi Linier Berganda//\n";
        SimpanInputan();
        int i, j, k, l, variabel, ndata;
        float regresi, temp, pembagi, pembagi2;


        ndata = NBrsEff();
        variabel = NKolEff();

        MakeMatrikARe();

        // PROSES ELIMINASI GAUSS

        for (i = 0; i < variabel; i++) {
            search:                                                         // Proses mencari dari baris pertama kolom
            {                                                               // pertama elemen matriks yang bernilai
                for (j = i; j < variabel + 1; j++) {                        // bukan nol (pencarian dilakukan perkolom
                    for (k = i; k < variabel; k++) {                        // ke bawah terlebih dahulu)
                        if (MemA[k][j] != 0) {
                            x = k;
                            y = j;
                            break search;                                   // Jika terdapat elemen diagonal yang bernilai
                        }                                                   // nol maka pencarian berhenti dan akan
                    }                                                       // menimpan indeks baris dan kolom yang bernilai
                }                                                           // bukan nol muncul pertama kali
            }
            if (x != i && x > i) {
                tukar:
                {
                    for (k = i; k < variabel; k++) {
                        if (k != x) {
                            for (j = 0; j < variabel + 1; j++) {            // Melakukan penukaran baris
                                temp = MemA[k][j];
                                MemA[k][j] = MemA[x][j];
                                MemA[x][j] = temp;
                            }
                        }
                    }
                }
            }

            // Proses untuk memperoleh 1 utama dengan melakukan pembagian dengan elemen 1 utama
            if (y != variabel) {
                pembagi = MemA[i][y];
                for (j = 0; j < variabel + 1; j++) {
                    if (pembagi != 0 && MemA[i][j] != 0) {
                        MemA[i][j] = MemA[i][j] / pembagi;
                    }
                }
            }

            // Proses eliminasi agar elemen di bawah 1 utama bernilai nol semua
            for (j = i+1; j < variabel; j++){
                if (MemA[j][y] != 0 && y != variabel){
                    pembagi2 =MemA[j][y];
                    for (k = y; k < variabel+1; k++){
                        MemA[j][k] = MemA[j][k] - MemA[i][k]*pembagi2;
                    }
                }
            }
        }


        // PROSES ELIMINASI GAUSS JORDAN

        for (i = variabel-1; i > 0; i--){                                   // Pencarian terbalik dari baris bawah
            j = 0;
            while (j < variabel && MemA[i][j]==0){                          // Mencari 1 utama yang pertama kali dari bawah
                j = j+1;
            }
            if (j == variabel){                                             // Jika sampai ujung kanan kolom belum ditemukan
                continue;                                                   // Maka langsung ke baris di atasnya dan
            }                                                               // tidak diproses
            if (j < variabel){                                              // Jika ditemukan 1 utama pada kolom ke j maka
                for (l = 0; l < i; l++) {                                   // dilakukan proses eliminasi agar semua elemen
                    pembagi2 = MemA[l][j];                                  // di atas 1 utama juga bernilai nol
                    for (k = 0; k < variabel+1; k++) {
                        if (MemA[i][k] != 0) {
                            MemA[l][k] = MemA[l][k] - MemA[i][k] * pembagi2;
                        }
                    }
                }
            }
        }

        float[] Solusi_regresi = new float[variabel];                       // Deklarasi array baru untuk menampung hasil
        for (i = 0; i < variabel; i++){                                     // atau solusi dari eliminasi gauss jordan
            Solusi_regresi[i] = MemA[i][variabel];
        }

        String[] StrSolusi = new String[variabel];                          // Deklarasi array baru yang isinya sama dengan
        for (i = 0; i < variabel; i++){                                     // ArraySolusi namun bertype string
            StrSolusi[i] = String.valueOf(Solusi_regresi[i]);               // Casting float ke string
        }

        // Proses Output
        // Output persamaan regresi
        System.out.println("\nPersamaan regresi:");
        FileToSave += ("\nPersamaan regresi:\n");
        System.out.print("Y = ");
        FileToSave += ("Y = ");
        if (Solusi_regresi[0] != 0){
            System.out.print(StrSolusi[0] + " ");                           // Print konstanta atau angka paling depan
            FileToSave += (StrSolusi[0] + " ");  
        }
        for (i = 1; i < variabel; i++){                                     // Output koefisien dan variabel X
            if (Solusi_regresi[i] > 0){
                System.out.print("+ " + StrSolusi[i] + "X_" + i + " ");
                FileToSave += ("+ " + StrSolusi[i] + "X_" + i + " ");
            } else if (Solusi_regresi[i] < 0){
                System.out.print(StrSolusi[i] + "X_" + i + " ");
                FileToSave += (StrSolusi[i] + "X_" + i + " ");
            }
        }
        System.out.println("\n");
        FileToSave += ("\n");


        // Output hasil regresi yang ditaksir di suatu titik
        System.out.print("Hasil regresi yang di taksir dengan\n ");
        FileToSave += ("Hasil regresi yang di taksir dengan\n ");
        for (i = 0; i < variabel-1; i++){
            System.out.print("X" + (i + 1) + " = " + taksiran[i]);
            FileToSave +=("X" + (i + 1) + " = " + taksiran[i]);
            if (i < variabel - 2){
                System.out.print(", ");
                FileToSave += (", ");
            } else {
                System.out.print(" ");
                FileToSave += (" ");
            }
        }
        System.out.print("\n adalah ");
        FileToSave += ("\n adalah ");


        float jumlah = 0;
        for (i = 1; i < variabel; i++){
            jumlah += Solusi_regresi[i]*(taksiran[i-1]);                // Substitusi agar diperoleh hasil
        }
        regresi = Solusi_regresi[0]+jumlah;                             // Menjumlahkan dengan konstanta atau angka pertama
        System.out.println(regresi);
        System.out.println("");
        FileToSave += (regresi + " ");

    }
    
          

}// add class


