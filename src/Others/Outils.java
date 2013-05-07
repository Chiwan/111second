package Others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.ImageIcon;

public class Outils {

	private static final String String = null;
	private BufferedReader br;
	private String correctAnswer;
	private int intAlea;
	private char charChoisi;
	
	//private String[] listes;
	private ArrayList<ArrayList<String>> liste = new ArrayList<ArrayList<String>>();
	private ArrayList<String> nomListe = new ArrayList<String>();
	private ArrayList<ImageIcon> imageListe= new ArrayList<ImageIcon>();
	
	private ArrayList<String> pays = new ArrayList<String>();
	private ArrayList<String> mammifere = new ArrayList<String>();
	private ArrayList<String> metier = new ArrayList<String>();
	//private ArrayList<String> prenom = new ArrayList<String>();
	private ArrayList<String> planete = new ArrayList<String>();
	private ArrayList<String> sport = new ArrayList<String>();
	private ArrayList<String> villeDeFrance = new ArrayList<String>();
	private ArrayList<String> fruit = new ArrayList<String>();
	
	private ArrayList<String> question = new ArrayList<String>();
	private ArrayList<String> reponse = new ArrayList<String>();

	public Outils() {
//		try {
//			InputStream ips = new FileInputStream("Liste.txt");
//			InputStreamReader ipsr = new InputStreamReader(ips);
//			br = new BufferedReader(ipsr);
//			String ligne;
//			while ((ligne = br.readLine()) != null) {
//				String nom = ligne.substring(5,ligne.length()-4);
//				System.out.println(nom);
//				System.out.println(ligne);
//				nomListe.add(nom);
//				System.out.println(nomListe.size());
//				TreeSet<String> TreeListe = new TreeSet<String>(); //Creer un TreeSet pour mettre les mots dans l'ordre
//				addList(TreeListe,ligne); // Importation des mots du fichier txt dans le TreeSet
//				ArrayList<String> array = new ArrayList<String>(TreeListe); // Exporte les String du TreeSet dans un ArrayList pour utiliser des get
//				liste.add(array);
//			}
//			br.close();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
		
		// Peut être creer une fonction a part serait plus propre mais peut être pas plus simple...
		
		addList(pays,"..\\ressources\\Liste\\ListePays.txt");
		liste.add(pays);
		nomListe.add("Pays");
		imageListe.add(new ImageIcon("..\\ressources\\images\\pays.jpg"));
		
		addList(mammifere,"..\\ressources\\Liste\\ListeMammifère.txt");
		liste.add(mammifere);
		nomListe.add("Mammifère");
		imageListe.add(new ImageIcon("..\\ressources\\images\\mammifere.jpg"));
		
		addList(metier,"..\\ressources\\Liste\\ListeMétier.txt");
		liste.add(metier);
		nomListe.add("Métier");
		imageListe.add(new ImageIcon("..\\ressources\\images\\metier.jpg"));
		
		//Il y a un probléme avec la liste des prénoms le programme perçoit 8413 mot alors qu'il y en a 4207 ( la moitié).
//		addList(prenom,"..\\ressources\\Liste\\ListePrénom.txt");
//		liste.add(prenom);
//		nomListe.add("Prénom");
		
		addList(planete,"..\\ressources\\Liste\\ListePlanète.txt");
		liste.add(planete);
		nomListe.add("Planète");
		imageListe.add(new ImageIcon("..\\ressources\\images\\planete.jpg"));
		
		addList(sport,"..\\ressources\\Liste\\ListeSport.txt");
		liste.add(sport);
		nomListe.add("Sport");
		imageListe.add(new ImageIcon("..\\ressources\\images\\sport.jpg"));
		
		addList(villeDeFrance,"..\\ressources\\Liste\\ListeVilleDeFrance.txt");
		liste.add(villeDeFrance);
		nomListe.add("Ville de France");
		imageListe.add(new ImageIcon("..\\ressources\\images\\france.jpg"));
		
		addList(fruit,"..\\ressources\\Liste\\ListeFruit.txt");
		liste.add(fruit);
		nomListe.add("Fruit");
		imageListe.add(new ImageIcon("..\\ressources\\images\\fruit.jpg"));


	}

	// Lire un fichier txt 
	public void readTxt(){
		try {
			InputStream ips = new FileInputStream("Liste.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				System.out.println(ligne);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	//Permet d'obtenir la taille de la liste
	public int getListSize(int i){
		return liste.get(i).size();
	}
	
	//Nombre Aleatoire pour choisir une liste
	public int getIntListAlea(){
		intAlea = (int)(Math.random()*(liste.size()));
		return intAlea;
	}

	//Permet de choisir une liste
	public ArrayList<String> getListeAlea(){
		int alea = getIntListAlea();
		//System.out.println(alea);
		return liste.get(alea);
	}
	public ArrayList<String> getListeAlea(int i){
		return liste.get(i);
	}
	
	//Permet d'avoir le nom de liste ( Peut être faire un HashMap)
	public String getNomListeAlea(){
		int alea = getIntListAlea();
		return nomListe.get(alea);
	}
	public String getNomListeAlea(int i){
		return nomListe.get(i);
	}
	
	//PErmet d'avoir l'adresse de l'image
	public ImageIcon getImageAlea(int i){
		return imageListe.get(i);
	}
	
	//Choix d'une lettre
	public char getCharAlea(ArrayList<String> array){
		int nbLigne = array.size(); // On récupére le nombre de ligne qu'il y a dans la liste		
		int ligneAlea = (int)(Math.random()*nbLigne); //Choix d'une ligne aleatoire
		System.out.println("Nombre de Ligne = "+ nbLigne);
		System.out.println("Ligne choisi :"+ ligneAlea);
		charChoisi = array.get(ligneAlea).charAt(0); // renvoie la 1er lettre de la ligne : comme ça on est certain que la lettre existe !
		return charChoisi;
	}
	
	// Recherche si le mot existe dans la liste demandé !
	public boolean findWord(ArrayList<String> array, String mot, char lettre){
		if (Character.toUpperCase(mot.charAt(0)) != Character.toUpperCase(lettre)|| mot.length() == 1 ) {
			return false;
		}
		for(int i =0; i< array.size();i++){		
			if(motMalTape(mot.toUpperCase(),array.get(i).toUpperCase())){
				System.out.println(array.get(i).toUpperCase());
				System.out.println(mot.toUpperCase());
				return true;
			}
		}
		return false;
	}
	
	//Recherche d'un mot en fonction de la lettre et d'un mot
	public String correctAnswerAlea(ArrayList<String> array, char lettre){
		//int nbLignes = array.size();
		int premLigne=0;

		// Une premiere boucle pour trouver la premiere ligne de l'occurrence de la lettre
		while(array.get(premLigne).charAt(0)!= lettre){
			premLigne++;
		}
		
		int derLigne = premLigne;
		// Une seconde boucle pour trouver la derniere ligne de l'occurrence de la lettre
		while(array.get(derLigne).charAt(0)== lettre){
			derLigne++;
		}
		
		// Le nombre de mot commencant par la lettre donnee
		int nbMotCommencantParLettre = derLigne - (premLigne+1);

		// Ligne aleatoire entre la premiere et derniere occurrence de la lettre
		int nbLigneMot = (int)( Math.random()*( nbMotCommencantParLettre ) ) + premLigne;
		return array.get(nbLigneMot);
		
	}
	/*
	 * Quelque changement possible :
	 * -> la fonction prend en compte les mots comme : caca ou cacaofzejrgbksdn
	 * => Solution : limité la longueur du mot tapé ? genre cacaoee 
	 * 
	 * -> Renvoie la premiére réponse juste genre on tape kiwi et le mot trouvé est : kiwano
	 * -> Demande un lettre : G, on tape Gambo => reponse juste : Sambo..
	 */
	// Gere la possibilité que la personne ait mal tapé
	public boolean motMalTape(String motTapeTmp, String motReferenceTmp) {
		
		String motTape = motTapeTmp.toUpperCase();
		String motReference= motReferenceTmp.toUpperCase();
		
		
		
		
		if(motTape.equals(motReference)){
			correctAnswer = motTape;
			return true;
		}
		
		
		
		
		//Prends en compte le mot le plus long
		int nbReference;
		if (motReference.length() > motTape.length()) {
			nbReference = motTape.length();
		} else {
			nbReference = motReference.length();
		}
		
		int nbCharJuste = 0;
		for (int i = 0; i < nbReference; i++) {
			if (String.valueOf(motTape.charAt(i)).compareTo(String.valueOf(motReference.charAt(i))) == 0) {
				nbCharJuste++;
			}
		}
		int nbTemp = nbReference - nbCharJuste;
		if	(nbTemp == 1) {
			correctAnswer = " Orthographe juste : "+motReference.toUpperCase() +"<br>\n Mot que tu as tapé " + motTapeTmp;
			System.out.println( " Mot de reference" + motReference);
			return true;
		} 
		else {
			return false;
		}
		
	}
		
	
	//Question à poser
	public String question(int i){
		return getNomListeAlea(i) +" en "+ Character.toUpperCase(getCharAlea(getListeAlea(i)));
	}
	public String question(){
		int alea = getIntListAlea();
		return getNomListeAlea(alea) +" en "+ Character.toUpperCase(getCharAlea(getListeAlea(alea)));
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public int getIntAlea(){
		return this.intAlea;
	}
	public void setIntListAlea(int intListAlea) {
		this.intAlea = intListAlea;
	}

	public char getCharChoisi() {
		return charChoisi;
	}

	public void setCharChoisi(char charChoisi) {
		this.charChoisi = charChoisi;
	}

	
	
	//Fonction utilisé au constructeur.
	//Permet de mettre chaque mots d'un fichier txt dans un TreeSet
	public void addList(ArrayList<String> liste, String ListeTxt){
		try {
			InputStream ips = new FileInputStream(ListeTxt);
			InputStreamReader ipsr = new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				liste.add(ligne.trim().toUpperCase());

			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
public void addQuestion111(String mot){
	question.add(mot);
}

public void addReponse111(String mot){
	reponse.add(mot);
}

public String getQuestion111(int i){
	return question.get(i);
}

public String getReponse111(int i){
	return reponse.get(i);
}
public int getNbReponse(){
	return reponse.size();
}

public void affichage(){
	for(int i = 0; i<getNbReponse(); i++ ){
		System.out.println( question.get(i)+"   "+reponse.get(i));
	}
}




}

