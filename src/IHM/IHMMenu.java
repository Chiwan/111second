package IHM;

import jeu.Fichier;
import jeu.Option;
import jeu.UneImage;
import devintAPI.MenuAbstrait;

public class IHMMenu extends MenuAbstrait {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** constructeur
	 * @param title : le nom du jeu 
	 */
	public IHMMenu(String title) {
		super(title);
	}

	/** renvoie le nom des options du menu
	 * vous pouvez d�finir autant d'options que vous voulez
	 **/
	protected String[] nomOptions() {
		String[] noms = {"Jeu 111 Secondes","Jeu apprentisage","Quitter"};
		return noms;
	}

	/** lance l'action associ�e au bouton n�i
	 * la num�rotation est celle du tableau renvoy� par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i){  
		case 0 : new IHMJeu111(nomJeu);break;
		case 1 : new IHMJeuInfini(nomJeu);break;
		case 2 : System.exit(0);
		default: System.err.println("action non d�finie");
		}
	} 

	// renvoie le fichier wave contenant le message d'accueil
	// ces fichiers doivent �tre plac�s dans ressources/sons/
	protected  String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}

	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/accueil.wav";
	}

}
