package main;

import main.Tools.OpenFile;
/**
 * Ciało głównej aplikacji
 *
 * @TODO
 * - otwórz iteracyjnie wszystkie pliki grupując kanałami
 * - odszum
 * - poszukaj pików / oznacz
 * - piki zapisz do pliku
 * - sprawdź, czy piki pojawiają się na wszystkich kanałach
 * - wywal do pliku trafienia
 *
 */
public class App {
    
    public static void main(String[] args) throws Exception
    {
    	OpenFile of = new OpenFile();
    	of.readFiles();		// wczytanie plikow	
    }
}
