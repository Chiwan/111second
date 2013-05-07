package IHM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 
 * @classe CompteRebours
 * 
 * @extends JPanel
 * 
 * @description Classe qui définit un Compte a Rebours
 *
 */

public class CompteRebours extends JPanel implements Runnable{

	/** serialVersionUID : numero de serie */
	private static final long serialVersionUID = 1L;
	/** f : Font appliqué au texte */
	private static Font f = new Font("Book Antiqua", Font.BOLD, 40);
	/** couleur : couleur de fond du chronometre */
	private Color couleur=Color.orange;
	/** tempsRestant : temps restant */
	private int tempsRestant;
	/** temps : temps initial */
	private int temps;
	/** fonctionne : booleen vrai si le compte a rebours est en marche*/
	private boolean fonctionne=true;


	/**
	 * Construction du chronometre
	 * @param N : le nombre de secondes initial
	 */
	public CompteRebours(int N){
		this(N, Color.orange);
	}

	public CompteRebours(int N, Color couleur){
		this.couleur=couleur;
		setOpaque(false);
		setPreferredSize(new Dimension(75, 75));
		this.setTempsRestant(N);
		this.setTemps(N);
		start();
		
	}


	public boolean getFonctionne() {
		return fonctionne;
	}
	/**
	 * Permet de démarrer le chronometre
	 */
	public void start(){
		fonctionne=true;
	}

	/**
	 * Permet d'arreter le chronometre
	 */
	public void stop(){
		fonctionne=false;
	}
	
	public void run() {
		while(fonctionne){
			if(tempsRestant>0){
				tempsRestant--;
				repaint();
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else{
				stop();
			}
		}
	}


	/**
	 * Redéfinition de la méthode paintCompnent
	 */
	public void paintComponent(Graphics g) {
		this.drawCircle(g, 55, 55, 50); 
	}

	/**
	 * Fonction qui permet de dessiner le chronometre
	 * @param cg : element graphique
	 * @param xCenter : abscice du centre du cercle
	 * @param yCenter : ordonnee du centre du cercle
	 * @param r : rayon du cercle
	 */
	private void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
		cg.setColor(Color.white);
		cg.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
		cg.setColor(couleur);
		cg.fillArc(xCenter-r, yCenter-r, 2*r, 2*r, 90, -(360-tempsRestant*360/temps));
		cg.setColor(Color.black);
		cg.setFont(f);
		if(tempsRestant>9){
			cg.drawString(""+this.tempsRestant, 35, 65);
		}
		else{
			cg.drawString("0"+this.tempsRestant, 35, 65);
		}
	}

	public int getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(int tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}



	public static void main(String[] args){
		JFrame f = new JFrame("Test du compte à rebours");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CompteRebours c = new CompteRebours(112);
		f.add(c);
		f.pack();
		f.setVisible(true);
		c.run();
	}
	
}