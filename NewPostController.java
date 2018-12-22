package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.FileChooser;
import sweproject.PostController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class NewPostController
{
    @FXML
    TextField id, brand, category, color, image;
    @FXML
    TextArea description;
    @FXML
    Label username;
    @FXML
    Button upd , creat;
    @FXML
    Hyperlink userlink;
    
    public void initialize()
    {
    	username.setText(Main.pubName);
    	username.setVisible(false);
    	userlink.setText(Main.pubName);
    	if(Main.changeView == 0)
    	{
    		id.setVisible(true);
    		creat.setVisible(true);
    		upd.setVisible(false);
    		
    	}
    	else
    	{
    		id.setText(Integer.toString(Main.holdPost.getPostid()));
    		id.setEditable(false);
    		creat.setVisible(false);
    		brand.setText(Main.holdPost.getItem().getBrand());
        	category.setText(Main.holdPost.getItem().getCategory());
        	color.setText(Main.holdPost.getItem().getColor());
        	image.setText(Main.holdPost.getItem().getImage());
    	}
    }

    @FXML
    void selectFile()
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files or Vector Quantized Files", "*.jpg", "*.png", "*.vq"));
        Path temp = Paths.get(fc.showOpenDialog(null).getAbsolutePath());
        if (Files.exists(temp))
        {
            image.setText(temp.toUri().toString());
        }
    }

    public void createPost() throws IOException, ClassNotFoundException
    {
        PostController.createPost(username.getText(), Integer.parseInt(id.getText()),
                description.getText(), brand.getText(), category.getText(), color.getText(), image.getText());
        
        
        Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setContentText("item added successfully");

    }
    public void updateprofile() throws IOException
    {
    	Main.changeView = 1;
    	Main.setRoot("Sample.fxml");
    }
    public void update() throws NumberFormatException, ClassNotFoundException, IOException
    {
    	
    	PostController.updatePost(Main.pubName, Main.holdPost.getPostid(),
                description.getText(), brand.getText(), category.getText(), color.getText(), image.getText());
    }
    public void back() throws IOException
    {
    	Main.setRoot("posts_main.fxml");
    }
}
