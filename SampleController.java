package application;

import java.io.IOException;

import javax.xml.ws.Holder;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import sweproject.User;
import sweproject.UserController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class SampleController
{
	@FXML
	private AnchorPane root;
	@FXML
	private TextField username;
	@FXML
	private TextField email;
	@FXML
	private TextField phone;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField confirmpass;
	@FXML
	private Button register , updateProfile;
	@FXML
	private Label labelpass;
	@FXML
	public Label  labeluser;
	@FXML
	public Label registerLabel;
	@FXML
	private Hyperlink notifications;
	
	public void initialize() throws ClassNotFoundException, IOException
	{
//		if(UserController.getUser(UserController.getPostOwner(Main.holdPost.getPostid()).toString()).getNotifications().size() == 0)
//		{
//			notifications.setVisible(false);
//		}
		
		if(Main.changeView == 1)
		{
			User current = UserController.getUser(Main.pubName);
			registerLabel.setVisible(false);
			updateProfile.setVisible(true);
			register.setVisible(false);
			username.setText(Main.pubName);
			username.setEditable(false);
			email.setText(current.getEmail());
			phone.setText(current.getPhone());
		}
		
		else
		{
			registerLabel.setVisible(true);
			updateProfile.setVisible(false);
			register.setVisible(true);
			username.setEditable(true);
		}
	}
	
	
	
	public boolean check() throws ClassNotFoundException, IOException 
	{
		if( username.getText().length() == 0 || confirmpass.getText().length() == 0 || password.getText().length() == 0  )
		{
			return false;
		}
		if(UserController.getUser(username.getText()) != null)
		{
			labeluser.setVisible(true);
			return false;
		}
		if(!(password.getText().equals(confirmpass.getText())))
		{
			labelpass.setVisible(true);
			return false;
		}
		labeluser.setVisible(false);
		labelpass.setVisible(false);
		return true;
	}
	public void registeration() throws ClassNotFoundException, IOException
	{
		if(check()) 
		{
			String user = username.getText();
			String mail = email.getText();
			String num = phone.getText();
			String pass = password.getText();
			UserController.VerifyRegister(user, pass, num, mail);
			Main.setRoot("posts_main.fxml");
		}
		
	}
	public void viewnotification()
	{
		
	}
	public void update() throws ClassNotFoundException, IOException
	{
		if(check() || username.getText().length()!=0) 
		{
			String mail = email.getText();
			String num = phone.getText();
			String pass = password.getText();
			UserController.update(Main.pubName,mail,num,pass);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setContentText("Data updated");
			alert.show();
			Main.setRoot("posts_main.fxml");
		}
		
	}
		
	
}
