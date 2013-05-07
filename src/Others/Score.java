package Others;

import java.io.Serializable;

public class Score implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom = "";
	private int score;
	
public Score(String nom, int score){
	this.nom = nom;
	this.score = score;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public int getScore() {
	return score;
}



public void setScore(int score) {
	this.score = score;
}

public String toString(){
	return this.nom + "   -->   " + this.score ;
}

}
