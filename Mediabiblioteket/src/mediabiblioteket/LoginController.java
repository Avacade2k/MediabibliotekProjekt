package mediabiblioteket;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	
	LibraryController theController;
	
	@FXML
	public TextField user;
	
	public void login() {
		if(isSuccessful()) {
			new Main().changeScene();
		}else {
			System.out.println("Failed to log in");
		}
	}
	
	public boolean isSuccessful() {
		System.out.println("Log in request");
		String userName = user.getText();
		theController = new LibraryController();
		if(theController.checkUserInput(userName))
		{
			if(!theController.checkIfBorrowerExist(userName))
			{
				JOptionPane.showMessageDialog(null, "Incorrect SSN");
				user.setText("");
				return false;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Login successful");
				return true;
			}
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Incorrect characters");
			user.setText("");
			return false;
		}
	}
	
	public void cancel() {
		System.out.println("Window close request");
		Main.alertOnExit();
		System.exit(0);
	}

}