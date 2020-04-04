package application;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.text.Text;
public class CountDownTimer {
	
	Text countDown = new Text();
	int interval=600;
	Timer timer= new Timer();
    int delay = 1000;
    int period = 1000;
    
	public int setInterval() {	    
    	if (interval == 1)
	        timer.cancel();
    	return --interval;
	}
	Integer i=setInterval();
	CountDownTimer(){
		timer.scheduleAtFixedRate(new TimerTask() {
		    public void run() {
			       	countDown.setText(i.toString());
			        }
			    }, delay, period);
	}
}

