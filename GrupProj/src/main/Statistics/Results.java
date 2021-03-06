package main.Statistics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author Agnieszka Ceran, Mateusz Marchelewicz, Łukasz Janus, Łukasz Gwozdowski
 *  @2018
 * 
 * Klasa - kontener pomocniczy do przechowywania i zliczania wartosci false/true dla poszczegolnych peak'ow.
 */
public class Results {
	
	//listy do danych oryginalnych i filtr�w
	private List<Boolean> hitOrg;
	private List<Boolean> hit60;
	private List<Boolean> hit80;

	/**
	 * Konstruktor
	 */
	public Results() {
		hitOrg = new ArrayList<Boolean>();
		hit60 = new ArrayList<Boolean>();
		hit80 = new ArrayList<Boolean>();
	}

	/**
	 * Metoda dodajaca trafienia
	 * @param hOrg
	 * @param h60
	 * @param h80
	 */
	public void addData(Boolean hOrg, Boolean h60, Boolean h80) {
		hitOrg.add(hOrg);
		hit60.add(h60);
		hit80.add(h80);
	}

	/**
	 * Metoda do zliczania trafien - wartosci True w danej liscie
	 * @param list
	 * @return
	 */
	public Integer trueCounter(List<Boolean> list) {
		int temp=0;
		for (int i=0;i<list.size();i++){
			if (list.get(i)==true)	{
				temp++;
			}
		}
		return temp;
	}


	/**
	 *
	 * @return
	 */
	public List<Boolean> getHitOrg() {
		return hitOrg;
	}

	/**
	 *
	 * @param hitOrg
	 */
	public void setHitOrg(List<Boolean> hitOrg) {
		this.hitOrg = hitOrg;
	}

	/**
	 *
	 * @return
	 */
	public List<Boolean> getHit60() {
		return hit60;
	}

	/**
	 *
	 * @param hit60
	 */
	public void setHit60(List<Boolean> hit60) {
		this.hit60 = hit60;
	}

	/**
	 *
	 * @return
	 */
	public List<Boolean> getHit80() {
		return hit80;
	}

	/**
	 *
	 * @param hit80
	 */
	public void setHit80(List<Boolean> hit80) {
		this.hit80 = hit80;
	}
	
	/**
     * Metoda do analizowania peakow - wywolywana tylko raz w klasie ReadFolder
     * @param picks
     */
    public void peakAnalysis(Results picks){

    	Integer OrgSize = picks.trueCounter(picks.getHitOrg()); //ilosc wszystkich pickow
    	Integer h60TrueCount = picks.trueCounter(picks.getHit60()); //ilosc trafien filtr-60
    	Integer h80TrueCount = picks.trueCounter(picks.getHit80()); //ilosc trafien filtr-80

    	Float lostPercent60;// = 2.0f;
    	Float lostPercent80;

    	if (h60TrueCount>0)	{
    		lostPercent60 = 100-(((float)h60TrueCount*100)/(float)OrgSize); //wersja pokazujaca, ile procent utracono
    		//lostPercent60 = 100*((float)OrgSize/((float)h60TrueCount)); //wersja procentow z zapisem
    	} else {
    		lostPercent60 = (float) 0.0;
    	}

    	if (h80TrueCount>0)	{
		lostPercent80 = 100-(((float)h80TrueCount*100)/(float)OrgSize); //analogicznie, j.w.
    		//lostPercent80 = 100*((float)OrgSize/((float)h80TrueCount));

    	} else {
    		lostPercent80 = (float) 0.0;
    	}

    	String endScore = "";
    	//endScore +="Zbiorczy wynik koncowy dla wszystkich pick'ow:\nDane oryginalne: "+OrgSize+", filtr 60: "+h60TrueCount+", filtr 80: "+h80TrueCount;
    	//endScore +="\nProcent utraconych pik'ow: filtr 60: "+lostPercent60+", filtr 80: "+lostPercent80;

    	endScore +="Sumaryczna_liczba_peakow:\n";
    	endScore +="Peak_prawdziwy:"+" filtr60:"+" filtr80:\n";
    	endScore += OrgSize+" "+h60TrueCount+" "+h80TrueCount;
    	endScore +="\nProcent_utraconych_pik'ow:\n";
    	endScore +="filtr60:"+" filtr_80:\n";
    	endScore +=lostPercent60+" "+lostPercent80;
    	//System.out.println(endScore); //finished score
 
        try {
        	FileWriter fileWriter = new FileWriter("GrupProj/electron/Result.csv");
			fileWriter.write(endScore);
			fileWriter.flush();
	        fileWriter.close();
		} catch (IOException e) {
			System.out.println("Error save");
			e.printStackTrace();
		}

    }

}
