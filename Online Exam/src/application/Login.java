package application;



import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Login{
	Instruct q = new Instruct();
	Text t = new Text();
	private Label head = new Label("Student Login ");
	
	private Label l1 = new Label("Reg.no   :");
	private Label l2 = new Label("Password:");
	Instruct ins = new Instruct();
	TextField tf = new TextField();
	PasswordField pf = new PasswordField();
	Hyperlink hl = new Hyperlink("forgot password?");
	Button submit = new Button("Login");
	private AnchorPane root = new AnchorPane();
	
	Scene scene = new Scene(root,1004,709);
	private void layoutXY() {
		head.setLayoutX(471);
		head.setLayoutY(260);
		t.setLayoutX(471);
		t.setLayoutY(300);
		submit.setLayoutX(456.0); 
		submit.setLayoutY(417.0);
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
			root.getChildren().addAll(head,t,l1,tf,pf,l2,hl,submit);
			scene.getStylesheets().add("/application/Login.css");
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		}
	
	
	
}
