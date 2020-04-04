package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class MainController extends Application{

	@Override
	public void start(Stage MainStage) throws Exception {
		Exam exam = new Exam();
		Login l= new Login();
		Instruct ins= new Instruct();
		MainStage.setScene(l.scene);
		MainStage.setTitle("Online Exam");
		MainStage.show();
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					if(e.getSource()==l.submit) {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam","root","");
						PreparedStatement sql = conn.prepareStatement("select pwd  from user where reg=?");
						sql.setString(1,l.tf.getText());
						ResultSet rs = sql.executeQuery();
						if(rs.next()) {
							if(rs.getString(1).equals(l.pf.getText())) {
								l.t.setText("Login Successful.....");
								l.t.setFill(Color.FORESTGREEN);
								MainStage.setScene(ins.ins);
								MainStage.setTitle("Instructions");
								MainStage.show();
								conn.close();
							}
							else {
								l.t.setText("Either Username or Password is wrong!");
								l.t.setFill(Color.DARKRED);
							}
						}
						
						}
					if(e.getSource()==ins.strt) {
						exam.RetriveQuestions();
						MainStage.setScene(exam.exam);
						MainStage.setTitle("Online Exam");
						MainStage.show();
					}
					if(e.getSource()==exam.finish) {
						exam.Evaluate();
						MainStage.setScene(exam.LastScene);
						MainStage.setTitle("Marks");
						MainStage.show();
					}
					if(e.getSource()==exam.exit) {
						Platform.exit();
					}
					if(e.getSource()==l.hl) {
						Stage contact = new Stage();
						Label cc= new Label("Please Contact Admin");
						cc.setAlignment(Pos.CENTER);
						contact.setScene(new Scene(cc,200,100));
						contact.show();
						
					}
					e.consume();
				}
				catch(Exception ex) {
					System.out.print(ex);
				}
			}
		};
		l.submit.setOnAction(handler);
		ins.strt.setOnAction(handler);
		exam.finish.setOnAction(handler);
		exam.exit.setOnAction(handler);
		l.hl.setOnAction(handler);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
