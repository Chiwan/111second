package Others;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Chrono implements ActionListener {
    private int timeSeconde;

    public Chrono(int initSeconde) {
          super();
          this.timeSeconde = initSeconde;
    }

    public void actionPerformed(ActionEvent e) {
    	Thread thread = new Thread();
    	while (this.timeSeconde > 0)
    	{
    			System.out.println("Time: " + this.timeSeconde);
    			try {
					thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                this.timeSeconde--;

    	}
    }

}
