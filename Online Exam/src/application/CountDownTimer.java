package application;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.util.Duration;
public class CountDownTimer{
	 	private static final Integer STARTTIME = 600;
	    private Timeline timeline;
	    Label timerLabel = new Label();
	    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
	    private String secs;
	    private String mins;
	    public void startTimer() {
	    	  if (timeline != null) {
                  timeline.stop();
              }
              timeSeconds.set(STARTTIME);
              timeline = new Timeline();
              timeline.getKeyFrames().add(
                      new KeyFrame(Duration.seconds(STARTTIME+1),
                      new KeyValue(timeSeconds, 0)));
              timeline.playFromStart();
	    }
	    CountDownTimer(){
	    	Integer a= (int) timeSeconds.intValue()/60;
	    	Integer b= (int) timeSeconds.intValue()%60;
	    	secs= b.toString();
	    	mins=a.toString();
	    	timerLabel.setText(mins+":"+secs);
	    }
}