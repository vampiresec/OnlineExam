package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Exam {
	CountDownTimer cd = new CountDownTimer();
	String[] answers = new String[5];
	int count=0;
	private AnchorPane root = new AnchorPane();
	Text scrollStatus = new Text();
	Text question = new Text();
	ToggleGroup group = new ToggleGroup();  
    RadioButton opt1 = new RadioButton();  
    RadioButton opt2 = new RadioButton();  
    RadioButton opt3 = new RadioButton();  
    RadioButton opt4 = new RadioButton();
    VBox fin = new VBox();	
	Scene LastScene = new Scene(fin,1004,709);
	HBox hmenu = new HBox();
    Button nxt = new Button("next");
    Button prev = new Button("previous");
    Button finish = new Button("finish");
    Button exit = new Button("Exit");
    private Line l1= new Line(200,104.5,800,104.5);
    private Line l2= new Line(800,104.5,800,604.5);
    private Line l3= new Line(200,604.5,800,604.5);
    private Line l4= new Line(200,104.5,200,604.5);
    VBox options=new VBox();
    ResultSet rs;
    public void RetriveQuestions() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam","root","");
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			rs = stmt.executeQuery("select * from questions");
			rs.next();
			String q = rs.getString("id")+". "+rs.getString("question");
			question.setText(q);
			opt1.setText(rs.getString("opt1"));
			opt2.setText(rs.getString("opt2"));
			opt3.setText(rs.getString("opt3"));
			opt4.setText(rs.getString("opt4"));
			opt1.setUserData(rs.getString("opt1"));
			opt2.setUserData(rs.getString("opt2"));
			opt3.setUserData(rs.getString("opt3"));
			opt4.setUserData(rs.getString("opt4"));
			prev.setDisable(true);
			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		        		
		             if (group.getSelectedToggle() != null) {
		            	String k=group.getSelectedToggle().getUserData().toString() ;
		            	answers[count]=k;
		             }

		         } 
		    });
			
    	}
    	catch(Exception e) {
    		System.out.print(e);
    	}
    }  
    private void Next() {
		
    	try {
			if(rs.next()) {
				String q = rs.getString("id")+". "+rs.getString("question");
				question.setText(q);
				opt1.setText(rs.getString("opt1"));
				opt2.setText(rs.getString("opt2"));
				opt3.setText(rs.getString("opt3"));
				opt4.setText(rs.getString("opt4"));
				opt1.setUserData(rs.getString("opt1"));
				opt2.setUserData(rs.getString("opt2"));
				opt3.setUserData(rs.getString("opt3"));
				opt4.setUserData(rs.getString("opt4"));
				count++;
				prev.setDisable(false);
				deselect();
			}
			else {
				nxt.setDisable(true);
				hmenu.getChildren().add(finish);
				scrollStatus.setText("Last Question");
			}
		}
		catch(Exception e) {System.out.print(e);}
    	
	}
    private void deselect() {
    	opt1.setSelected(false);
    	opt2.setSelected(false);
    	opt3.setSelected(false);
    	opt4.setSelected(false);
    }
    private void Prev() {
    	try {
			if(rs.previous()) {
				String q = rs.getString("id")+". "+rs.getString("question");
				question.setText(q);
				opt1.setText(rs.getString("opt1"));
				opt2.setText(rs.getString("opt2"));
				opt3.setText(rs.getString("opt3"));
				opt4.setText(rs.getString("opt4"));
				opt1.setUserData(rs.getString("opt1"));
				opt2.setUserData(rs.getString("opt2"));
				opt3.setUserData(rs.getString("opt3"));
				opt4.setUserData(rs.getString("opt4"));
				count--;
			}
			else {
				scrollStatus.setText("First Qustion");
				prev.setDisable(true);
			}
		}
		catch(Exception e) {System.out.print(e);}
    }
    public void Evaluate()  {
    	final int mark=4;
    	int marks=0;
    	GridPane AnswerSheet = new GridPane();
    	Label head = new Label("Your Ansewers ");
    	Label scored;
    	
    	try{
    		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam","root","");
    		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
    		ResultSet ans = stmt.executeQuery("select id, ans from questions");
    		ans.next();
    		int i=0;
        	for(String m:answers) {
        		AnswerSheet.addRow(i,new Text(ans.getString("id")+". "),new Text(m));
        		if(ans.getString("ans").equals(m)) {
        			marks+=mark;
        		}
        		ans.next();
        		i++;
        	}
        	scored=new Label("You havve scored "+marks+" marks");
        	fin.setAlignment(Pos.CENTER);
        	fin.setSpacing(10);
        	fin.getChildren().addAll(head,AnswerSheet,scored,exit);
        	
        	
    	}
    	catch(Exception e) {
    		System.out.print(e);
    	}
    	
    }
    EventHandler<ActionEvent> handl = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==nxt) {
				Next();
			}
			if(e.getSource()==prev) {
				Prev();
			}
			
			e.consume();
		}
		
	};
	private void layoutXY() {
		question.setLayoutX(240);
		question.setLayoutY(130);
		options.setLayoutX(250);
		options.setLayoutY(160);
		hmenu.setLayoutX(300);
		hmenu.setLayoutY(300);
		
	}
	Scene exam = new Scene(root,1004,709);
	Exam(){
		try {
			layoutXY();
			nxt.setOnAction(handl);
			prev.setOnAction(handl);
			opt1.setToggleGroup(group);  
		    opt2.setToggleGroup(group);  
		    opt3.setToggleGroup(group);  
		    opt4.setToggleGroup(group);
		    options.getChildren().addAll(opt1,opt2,opt3,opt4);
		    options.setSpacing(10);
		    hmenu.setSpacing(5);
		    hmenu.getChildren().addAll(prev,nxt);
		    root.getChildren().addAll(question,options,hmenu,scrollStatus,l1,l2,l3,l4);
		    exam.getStylesheets().add("/application/Exam.css");
		}
		catch(Exception e) {
			System.out.print(e);
		}    
	}
	
}   
