package application;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.Label;
import javafx.scene.text.Text;
public class CountDownTimer {
	
	Label countDown = new Label();
	int interval=600;
	Timer timer= new Timer();
    int delay = 1000;
    int period = 1000;
    
	public int setInterval() {	    
    	if (interval == 1)
	        timer.cancel();
    	return --interval;
	}
	
	CountDownTimer(){
		timer.scheduleAtFixedRate(new TimerTask() {
		    public void run() {
		    		Integer i=setInterval();
			       	countDown.setText(i.toString());
			        }
			    }, delay, period);
	}
}

