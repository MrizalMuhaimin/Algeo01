public class MainProgram {
    public static void main(String[] args) {
        Menu menu = new Menu();
        InputData Input = new InputData();

        while (true){
            if(menu.menu == 100){
                menu.MenuUtama(); //menu utama
            }else if(menu.menu == 101){
                menu.MenuSPL();// menu SPL
            }else if(menu.menu == 102){
                menu.MenuSplMEG();// eliminasi gaus
            }else if(menu.menu == 103){
                menu.MenuSplMEGJ();// eliminasi gaus jordan
            }else if(menu.menu == 104){
                menu.MenuSplMMB(); // eliminasi matrik balikan
            }else if(menu.menu == 105){
                menu.MenuSplKC(); //kaidah cramer
            }else if(menu.menu == 106){
                menu.MenuSplMEGik(); //eliminasi gaus Keybroad
            }else if(menu.menu == 107){
                menu.MenuSplMEGJik(); //eliminasi gaus jordan Keybroad
            }else if(menu.menu == 108){
                menu.MenuSplMMBik(); //eliminasi matrik balikan Keybroad
            }else if(menu.menu == 109){
                menu.MenuSplKCik(); //kaidah cramer  Keybroad
            }else if(menu.menu == 110){
                menu.MenuSplMEGif(); //eliminasi gaus File
            }else if(menu.menu == 111){
                menu.MenuSplMEGJif(); //eliminasi gaus jordan File
            }else if(menu.menu == 112){
                menu.MenuSplMMBif(); //liminasi matrik balikan File
            }else if(menu.menu == 113){
                menu.MenuSplKCif(); //kaidah cramer
            }else if(menu.menu == 200){
                menu.MenuDet();//menu determinan
            }else if(menu.menu == 201){
                menu.MenuDetRB();// det reduksi baris
            }else if(menu.menu == 202){
                menu.MenuDetEK();// det e kofaktor
            }else if(menu.menu == 203){
                menu.MenuDetRBik();// det reduksi baris Keybroad
            }else if(menu.menu == 204){
                menu.MenuDetEKik();// det e kofaktor Keybroad
            }else if(menu.menu == 205){
                menu.MenuDetRBif();// det reduksi baris FIle
            }else if(menu.menu == 206){
                menu.MenuDetEKif();// det e kofaktor File
            }else if(menu.menu == 300){
                menu.MenuMB();// matrik balikan
            }else if(menu.menu == 301){
                menu.MenuMBik();// matrik balikan Keybroad
            }else if(menu.menu == 302){
                menu.MenuMBif();// matrik balikan File
            }else if(menu.menu == 400){
                menu.MenuIP();// iterpolasi
            }else if(menu.menu == 401){
                menu.MenuIPik();// iterpolasi Keybroad
            }else if(menu.menu == 402){
                menu.MenuIPif();// iterpolasi File
            }else if(menu.menu == 500){
                menu.MenuIRB();// regresi berganda
            }else if(menu.menu == 501){
                menu.MenuIRBik();// regresi berganda Keybroad
            }else if(menu.menu == 502){
                menu.MenuIRBif();// regresi berganda File
            }else if(menu.menu == 0) {
                menu.MenuSave();// menu save
            }
        }

        
    }
}
