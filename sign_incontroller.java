package application;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.security.cert.CertPathChecker;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sweproject.UserController;

public class sign_incontroller
{
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Label userfield;
	
	@FXML
	private Label passwordfield;
	
	@FXML
	private Button logInButton;
	
	public void checkusernamefield()
	{
		if(username.getText().length()==0)
		{
			userfield.setVisible(true);
		}
		else
		{
			userfield.setVisible(false);
		}
	}
	
	public void checkpasswordfield()
	{
		if(password.getText().length() == 0)
		{
			passwordfield.setVisible(true);
		}
		else
		{
			passwordfield.setVisible(false);
		}
	}
	
	public void LogIn() throws ClassNotFoundException, IOException
	{
		String name = username.getText();
		String pass = password.getText();
		if(UserController.VerifySign_in(name, pass) != null)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setContentText("login-succesful");
			Main.pubName = username.getText();
			Main.setRoot("newPost.fxml");
			alert.show();
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setContentText("Invalid Log-in information");
			alert.showAndWait();
		}
		
	}
	
	
}
