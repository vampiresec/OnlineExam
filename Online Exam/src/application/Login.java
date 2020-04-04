package application;



import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Login{
	Instruct q = new Instruct();
	Text t = new Text();
	private Label head = new Label("Student Login ");
	Rectangle rect = new Rectangle(400,300,430,320);
	private StackPane sp = new StackPane();
	private Label l1 = new Label("LoginId   :");
	private Label l2 = new Label("Password :");
	Instruct ins = new Instruct();
	TextField tf = new TextField();
	PasswordField pf = new PasswordField();
	Hyperlink hl = new Hyperlink("forgot password?");
	Button submit = new Button("Login");
	private AnchorPane root = new AnchorPane();
	
	Scene scene = new Scene(sp,1004,709);
	private void layoutXY() {
		head.setLayoutX(380);
		head.setLayoutY(210);
		t.setLayoutX(396);
		t.setLayoutY(300);
		submit.setLayoutX(456.0); 
		submit.setLayoutY(440.0);
		l1.setLayoutX(367.0); 
		l1.setLayoutY(313.0);
		l2.setLayoutX(367);
		l2.setLayoutY(362);
		tf.setLayoutX(456);
		tf.setLayoutY(314);
		pf.setLayoutX(456);
		pf.setLayoutY(357);
		hl.setLayoutX(510.0);
		hl.setLayoutY(388.0);
		

	}
	private void style() {
		head.setId("head");
		
	}
	Login(){
		try {
			style();
			layoutXY();
			rect.setFill(Color.WHITE);
			rect.setArcHeight(100);
			rect.setArcWidth(100);
			t.setId("lstaus");
			sp.getChildren().addAll(rect,root);
			root.getChildren().addAll(head,t,l1,tf,pf,l2,hl,submit);
			scene.getStylesheets().add("/application/Login.css");
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		}
	
	
	
}
