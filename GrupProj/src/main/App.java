package main;

import main.Tools.ReadFolder;

import java.time.Instant;

/**
 * Ciało głównej aplikacji
 *
 * @TODO - otwórz iteracyjnie wszystkie pliki grupując kanałami
 * - odszum
 * - poszukaj pików / oznacz
 * - piki zapisz do pliku
 * - sprawdź, czy piki pojawiają się na wszystkich kanałach
 * - wywal do pliku trafienia
 */
public class App {

    public static void main(String[] args) throws Exception {

        /*
         * 	private final static String INPUT_FOLDER = "H:\\OFFLINE\\Offline\\electron\\ch1_org_filtered";
         * 	/** DLA WINDOWSA **
         *  private final static String INPUT_FOLDER = "electron\\ch1_org_filtered";
         *  /** DLA LINUXA **
         *private final static String INPUT_FOLDER = "GrupProj/electron/ch1_org_filtered";
         */
        System.out.println("Start: "+ Instant.now().toString());
        ReadFolder readFolder = new ReadFolder("electron/ch1_org_filtered");
        readFolder.readFiles();
        System.out.println("Stop: "+ Instant.now().toString());
    }


}
