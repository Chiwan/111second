package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Others.Outils;

import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;

public class IHMJeu111 extends FenetreAbstraite implements ActionListener{

	/**
	 * 
	 */
	//private JTextArea lb1;
	private JTextArea lb2;
	private JLabel jl2;
	private JScrollPane Js1;
	private static int seconde=111;
	private Outils o = new Outils();
	private int alea = o.getIntListAlea();
	private String question = o.question(alea);
	private ImageIcon image = o.getImageAlea(alea);
	private ImageIcon icon;
	public IHMJeu111(String title)  {
		// TODO Auto-generated constructor stub
		super(title);
	}

	/*
	 * Initialisation du frame.
	 */
	protected void init() {		

		setLayout(new BorderLayout());
//		Preferences pref = Preferences.getData();
//		Color foregroundColor = pref.getCurrentForegroundColor();
//		Color backgroundColor = pref.getCurrentBackgroundColor();
//		lb2.setBackground(backgroundColor);
//		lb2.setForeground(foregroundColor);
//		jl2.setBackground(backgroundColor);
//		jl2.setForeground(foregroundColor);
		/* Le timer */
		int delais=1000;
		ActionListener tache_timer;
		/* création des composants */
		final JLabel Label1 = new JLabel(""+seconde); /* déclarer final car une classe interne va acceder à ce composant */

		/* Action réalisé par le timer */
		tache_timer= new ActionListener()
		{
			public void actionPerformed(ActionEvent e1)
			{
				if(seconde>0){
					seconde--;
					Label1.setText(""+seconde);/* rafraichir le label */
				}
				else if(seconde==0){
					jl2.setText("Le jeu est terminé");
					lb2.setEditable(false);
					//icon = new ImageIcon("../ressources/images/fin.jpg");
					jl2.setIcon(icon);
					o.affichage();
					for(int i = 0; i<o.getNbReponse();i++){
					String textTmp = o.getQuestion111(i)+"   "+ o.getReponse111(i);
					JTextArea JTtmp= new JTextArea(textTmp);
					JTtmp.setLineWrap(true);
					JTtmp.setEditable(true);
					JTtmp.setFont(new Font("Georgia",1,150));
					Js1.add(JTtmp);
					}
					
					jl2.setText("");
				}
				else{
					
				}
			}

		};
		/* instanciation du timer */
		final Timer timer1= new Timer(delais,tache_timer);
		/* Ajout des composants aux conteneurs avec formatage */
		Label1.setBorder(new EmptyBorder(400,135,10,10));
		Label1.setFont(new Font("Arial",1,100));
		this.add(Label1,"Center");;

		/* Action provoqué par l'utilisateur */
		/* Lors du clic sur le bouton debut */
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){		
					timer1.start();
				}

				alea = o.getIntListAlea();
				question = o.question(alea);
				image = o.getImageAlea(alea);
				jl2.setText(question);
						//lb1.setText(question);
						voix.playText(question);
						jl2.setIcon(image);

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		/* Afficher l'ihm */
		this.pack();
		//this.setLocation(350,200); /* Déplacer la fenetre à ce nouvel emplacement */
		//this.setSize(300,100); /* dimension de la fenetre */
		this.show(); 

		//		lb1 = new JTextArea ("");
		//		lb1.setLineWrap(true);
		//		lb1.setEditable(false);
		//		lb1.setFont(new Font("Georgia",1,80));
		//		this.add(lb1,BorderLayout.NORTH);

		icon = new ImageIcon("../ressources/images/depart.jpg");
		String texte = ("Appuyez sur Entree pour debuter");
		jl2 = new JLabel(texte,icon,JLabel.CENTER);
		jl2.setFont(new Font("Georgia",1,50));
		this.add(jl2);
		//this.add(Js1,BorderLayout.CENTER);

		lb2 = new JTextArea ("");
		lb2.setLineWrap(true);
		lb2.setEditable(true);
		lb2.setFont(new Font("Georgia",1,150));
		this.add(lb2,BorderLayout.SOUTH);
		lb2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {

				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){	
					String answer = lb2.getText().trim();
					int aleaTmp = alea;
					String questionTmp = question;
					ImageIcon imageTmp = image;
					char charTmp= o.getCharChoisi();

					if(o.findWord(o.getListeAlea(aleaTmp),answer.toUpperCase(), charTmp)){
						//String text =  questionTmp + "\n" + 	"  Réponse vraie : "+ answer;
						String text = "<html>"+ questionTmp + "<br> Réponse vraie :" + o.getCorrectAnswer() +"</html>";
						o.addReponse111(text);
						o.addQuestion111(question);
					}
					else{
						String text = "<html>"+ questionTmp + "<br> Réponse fausse <br> Une réponse possible était" + o.correctAnswerAlea(o.getListeAlea(aleaTmp), charTmp) +"</html>";
						o.addReponse111(text);
						o.addQuestion111(question);
					}

					alea = o.getIntListAlea();
					question = o.question(alea);
					image = o.getImageAlea(alea);

					jl2.setText(question);
					voix.playText(question);
					jl2.setIcon(image);



					lb2.setText("");	

				}
			}
		});
		this.requestFocusInWindow();
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		//lb1.setText("Temps Restant " + chrono.getTime());
		// TODO Auto-generated method stub
		voix.stop();	// toujours stopper la voix avant de parler							

	}

	//Keyboard event listener: détecte les éléments clavier.
	@Override
	public void keyPressed(KeyEvent e) {
	}
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
