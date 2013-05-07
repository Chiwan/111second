package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Others.Outils;

import devintAPI.FenetreAbstraite;

public class IHMJeuInfini extends FenetreAbstraite implements ActionListener{

	private JTextArea lb1;
	private JTextArea lb2;
//	private JTextArea lb3;
	private JLabel jl2;
	private Outils o = new Outils();
	private int alea = o.getIntListAlea();
	private String question = o.question(alea);
	private ImageIcon image = o.getImageAlea(alea);
	private JLabel panel;
	String mot="";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IHMJeuInfini(String title)  {
		// TODO Auto-generated constructor stub
		super(title);
	}

	/*
	 * Initialisation du frame.
	 */
	protected void init() {
		//Genère une question :
		//setLayout(new FlowLayout());
		lb1 = new JTextArea ("Appuyez sur Entree pour debuter");
		lb1.setLineWrap(true);
		lb1.setEditable(false);
		lb1.setFont(new Font("Georgia",1,80));
		this.add(lb1,BorderLayout.NORTH);
		
		CompteRebours chrono = new CompteRebours(111);
		this.add(chrono,BorderLayout.CENTER);
		
		ImageIcon icon = new ImageIcon("../ressources/images/france.jpg");
		String texte = ("");
		jl2 = new JLabel(texte,icon,JLabel.CENTER);
		jl2.setFont(new Font("Georgia",1,50));
		this.add(jl2);
		

		lb2 = new JTextArea ("");
		lb2.setLineWrap(true);
		lb2.setEditable(true);
		lb2.setFont(new Font("Georgia",1,150));
		this.add(lb2,BorderLayout.SOUTH);
		this.lb2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {

				switch(arg0.getKeyCode()) {
				case KeyEvent.VK_ENTER:

					int aleaTmp = alea;
					String questionTmp = question;
					ImageIcon imageTmp = image;
					char charTmp= o.getCharChoisi();
					
					alea = o.getIntListAlea();
					question = o.question(alea);
					image = o.getImageAlea(alea);
					
					lb1.setText(question);
					voix.playText(question);

					String answer = lb2.getText().trim();
					jl2.setIcon(image);
					System.out.println("Answer : "+answer.toUpperCase());
					System.out.println("o.getListeAlea(aleaTmp)"+o.getListeAlea(aleaTmp));

					if(o.findWord(o.getListeAlea(aleaTmp),answer.toUpperCase(), charTmp)){
						//String text =  questionTmp + "\n" + 	"  Réponse vraie : "+ answer;
						String text = "<html>"+ questionTmp + "<br> Réponse correcte : " + o.getCorrectAnswer() +"</html>";
						jl2.setText(text);
					}
					else{
						String text = "<html>"+ questionTmp + "<br> Réponse fausse <br> Une réponse possible était : " + o.correctAnswerAlea(o.getListeAlea(aleaTmp), charTmp) +"</html>";
						jl2.setText(text);
					}
					
					lb2.setText(null);	
					break;
					
				case KeyEvent.VK_ALPHANUMERIC:	
					System.out.println(arg0.getKeyChar());
					voix.playText(arg0.paramString());
					break;
					

				}
			}
		});
		this.requestFocusInWindow();

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		question = o.question();
		voix.stop();	// toujours stopper la voix avant de parler
		//Object source = ae.getSource(); // on récupère la source de l'évènement

		voix.playText(question); // le contenu des questions est variable donc on les lit avec SI_VOX								

	}

	//Keyboard event listener: détecte les éléments clavier.
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);	// appel à la méthode mère qui gère les évènements ESC, F1, F3, F4
		switch(e.getKeyCode()) {

		case KeyEvent.VK_ENTER:
			int aleaTmp = alea;
			String questionTmp = question;
			char charTmp= o.getCharChoisi();
			
			alea = o.getIntListAlea();
			question=o.question(alea);
			image = o.getImageAlea(alea);
			lb1.setText(question);
			voix.playText(question);
			String answer = lb2.getText().trim();
			jl2.setIcon(image);
			System.out.println("Answer"+answer.toUpperCase());
			System.out.println("o.getListeAlea(aleaTmp)"+o.getListeAlea(aleaTmp));

			
			if(o.findWord(o.getListeAlea(aleaTmp),answer.toUpperCase(), charTmp)){
				//String text =  questionTmp + "\n" + 	"  Réponse vraie : "+ answer;
				String text = "<html>"+ questionTmp + "<br> Réponse correcte :" + answer +"</html>";
				jl2.setText(text);
			}
			else{
				String text = "<html>"+ questionTmp + "<br> Réponse fausse <br> Une réponse possible était" + o.correctAnswerAlea(o.getListeAlea(aleaTmp), charTmp) +"</html>";
				jl2.setText(text);
			}
			
			lb2.setText(null);
			break;				

		

		
		
		}
	}	

//	protected ImageIcon picture(int i){
//		return "../ressources/images/france.jpg";
//	}
	@Override
	protected String wavAide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeColor() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String wavAccueil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String wavRegleJeu() {
		// TODO Auto-generated method stub
		return null;
	}

}
