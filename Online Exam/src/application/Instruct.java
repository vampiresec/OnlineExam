package application;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Instruct  {
	
	Button strt = new Button("Start Exam");
	
	private AnchorPane root= new AnchorPane();
	private Label Head = new Label("TEST INSTRUCTIONS");
	
	Text Is = new Text("1. Please read and understand the Test instructions so that you will be able to easily navigate through the Test\r\n" + 
			"2. Once you click on the 'Start exam ' button the actual test time will begin.\r\n" + 
			"3. In the Center on the top you will see your personal details\r\n" + 
			"4. On the Upper right-hand side you will see the count-down timer for the Test\r\n" + 
			"5. The Question Paper consists of multiple Test Sections each having multiple objective type questions.\r\n" + 
			"6. Only one Question will be displayed on the computer screen at a time. To move to the next/ previous question, click on \"Next\"/ \"Previous\" button.\r\n" + 
			"7. In order to answer a question, you have to 'mouse click' the option you think is appropriate/ correct. The alternative which has been clicked on will be highlighted \n   and shall be treated as the answer given by you for the question.\r\n" + 
			"8. In case you are not sure of the Answer option of the question that you have attempted you can choose to Bookmark the question as a reminder to yourself to\n   review the question before submitting the Test.\r\n" + 
			"9. On the Left-hand side you will see the summary of number of questions that you have attempted, Not attempted , Attempted and bookmarked , Not Attempted and bookmarked\r\n" + 
			"10. You can move between the Test sections to attempt the test section of your choice.\r\n" + 
			"11. The questions can be answered in any order. Each question carries 1 mark.\r\n" + 
			"12. Each question will have 4 alternatives, out of which only one will be the correct answer.\r\n" + 
			"13. There is no negative marking.\r\n" + 
			"14. Once you have answered all the questions please click on the 'Finish Exam' button\r\n" + 
			"\r\n" + 
			"About Submission:\r\n" + 
			"\r\n" + 
			"1. Your answers are saved whenever you navigate between questions.\r\n" + 
			"2. After all questions are attempted to your satisfaction; you have to click on the 'Submit' button. You should be careful and ensure you are ready to submit the paper before the required test time - once the exam duration expires\n   you will not be able to attempt any questions or check the answers and the Test will be auto-submitted basis the options you had selected upto the Time expiry\r\n" + 
			"3. You can make changes in your choice of answer only before clicking the \"Submit\" button.\r\n" + 
			"4. Your answers would be saved automatically by the computer system even if you have not clicked the \"Submit\" button.\r\n" + 
			"5. You will see 3 warnings before the final submission- before the 3rd warning you may go back to the Test in case you want to re-check your answer\r\n" + 
			"ALL THE BEST !");
	
	private void layoutXY(){
		Head.setLayoutX(400);
		Head.setLayoutY(60);
		Is.setLayoutX(20);
		Is.setLayoutY(100);
		strt.setLayoutX(470);
		strt.setLayoutY(550);
		
	}
	public Scene ins = new Scene(root,1004,709);

	Instruct(){
		try {
			layoutXY();
			root.getChildren().addAll(Head,Is,strt);
			ins.getStylesheets().add("/application/Instruct.css");
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
	
	
	
	
	
	
}
