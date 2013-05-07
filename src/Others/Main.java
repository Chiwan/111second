package Others;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		try {
			// cr�ation d'une personne
			Score p = new Score("Dupont", 36);
			System.out.println("creation de : " + p);

			// ouverture d'un flux de sortie vers le fichier "personne.serial"
			FileOutputStream fos = new FileOutputStream("scoree.serial");

			// cr�ation d'un "flux objet" avec le flux fichier
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				// s�rialisation : �criture de l'objet dans le flux de sortie
				oos.writeObject(p); 
				// on vide le tampon
				oos.flush();
			} finally {
				//fermeture des flux
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		*/
		
		/*
		// TODO Auto-generated method stub
		Outils outils = new Outils();
		String texte=outils.choisirListe();
		System.out.println( " Texte : " +texte);
		System.out.println("Le mot est il dans la liste ?"); 
		char lettre = outils.choisirLettre(texte);
		System.out.println("La lettre choisi est "+lettre);
		System.out.println(outils.leMotEstDansLaListe("litchi",texte, lettre));
		System.out.println("test de rechercheDuMotDansLaListe");
		System.out.println("Le nombre de ligne du fichier est de : " + outils.nbLigneTexte(texte));		
		
		
		Chrono chrono = new Chrono(111);
		boolean start = true;
		ActionEvent e = new ActionEvent(start, 1, "go");
		chrono.actionPerformed(e);
		*/
		Outils o = new Outils();
		//System.out.println(o.laQuestionEst());
		//o.getAll(o.getListeAlea());
		//o.readTxt();
//		System.out.println(o.getNomListeAlea(0));
//		System.out.println(o.getNomListeAlea(1));
//		System.out.println(o.getNomListeAlea(2));
//		System.out.println(o.getNomListeAlea(3));
//		System.out.println(o.getNomListeAlea(4));
//		System.out.println(o.getNomListeAlea(5));
		//System.out.println(o.question());
		System.out.println(o.findWord(o.getListeAlea(4), "Venus", 'V'));
		
	}

}
