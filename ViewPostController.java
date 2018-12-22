package application;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sweproject.PostController;
import sweproject.UserController;

public class ViewPostController 
{
	@FXML
	private TextField brnd,clr, cat;
	
	@FXML
	private javafx.scene.control.TextArea desc;
	
	@FXML
	private AnchorPane big;
	
	@FXML
	private Button upd , delt ,ver;
	
	
	public void initialize() throws ClassNotFoundException, IOException
	{
		ImageView img = new ImageView();
		System.out.println("-----------------" + Main.holdPost.getItem().getImage());
		img.setImage(new Image(Main.holdPost.getItem().getImage()));
		big.getChildren().add(img);
		img.setLayoutX(14);
		img.setLayoutY(14);
		img.setFitWidth(349);
		img.setFitHeight(227);
		
		brnd.setText(Main.holdPost.getItem().getBrand());
		clr.setText(Main.holdPost.getItem().getColor());
		cat.setText(Main.holdPost.getItem().getColor());
		desc.setText(Main.holdPost.getDescription());
		ver.setVisible(false);
		
		//System.out.println(UserController.getPostOwner(Main.holdPost.getPostid()).getUsername());
		
		if(!Main.pubName.equals(UserController.getPostOwner(Main.holdPost.getPostid()).getUsername()))
		{
			upd.setVisible(false);
			delt.setVisible(false);
			ver.setVisible(true);
		}
	}
	public void delete() throws ClassNotFoundException, IOException 
	{
		PostController.deletePost(Main.pubName, Main.holdPost.getPostid());
		Main.setRoot("ViewPost.fxml");
	}
	
	public void verify() throws ClassNotFoundException, IOException
	{
		UserController.verifyitem(Main.holdPost.getPostid(), Main.pubName);
	}
	
	public void update() throws IOException
	{
		Main.changeView = 1;
		Main.setRoot("newPost.fxml");
	}
}
