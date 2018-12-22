package application;
	
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import sweproject.Post;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Stage roto;
	public static String pubName="" ;
	public static Post holdPost = null; 
	public static  int changeView = 0;
	@Override
	public void start(Stage primaryStage) {
		try {
			roto = primaryStage;
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("sign_in.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			roto.setScene(scene);
			roto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void setRoot(String newFxml) throws IOException
	{
		roto.hide();
		roto = new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource(newFxml));
		Scene scene = new Scene(root,600,600);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		roto.setScene(scene);
		roto.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
