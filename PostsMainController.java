package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sweproject.DbHolder;
import sweproject.Item;
import sweproject.Post;
import sweproject.PostController;
import sweproject.User;

import java.io.IOException;
import java.util.Vector;

public class PostsMainController
{
    @FXML
    TextField keyword;
    @FXML
    Label username;
    @FXML
    AnchorPane postsView;
    
   public void initialize() throws IOException, ClassNotFoundException
    {
	   	username.setText(Main.pubName);
        Vector<User> all = DbHolder.retrieveAll(1);
        Vector<Post> posts = new Vector<>();
        for(int i = 0 ; i < all.size() ; i++)
        {
        	for(int j = 0 ; j < all.get(i).getPosts().size() ; j++)
        	{
        		
        		String brand = all.get(i).getPosts().get(j).getItem().getBrand();
        		String category = all.get(i).getPosts().get(j).getItem().getCategory();
        		String color = all.get(i).getPosts().get(j).getItem().getColor();
        		String image = all.get(i).getPosts().get(j).getItem().getImage();
        		Item item = new Item(brand, category, color, image);
        		String description = all.get(i).getPosts().get(j).getDescription();
        		int postid = all.get(i).getPosts().get(j).getPostid();
        		Post post = new Post(description, postid, item);
        		posts.add(post);
        	}
        	
        }
       loadPosts(posts);
    }

    public void loadPosts(Vector<Post> posts) 
    {
    	System.out.println(posts.size());
    	postsView.getChildren().clear();

        postsView.setPrefHeight(posts.size() * 200);
        int y = 0;
        for(Post post : posts)
        {
            Pane postView = new Pane();
            postView.setPrefHeight(200);
            postView.setPrefWidth(587);
            postsView.getChildren().add(postView);
            postView.setLayoutY(y);
            y += 200;

            ImageView image = new ImageView();
            image.setImage(new Image(post.getItem().getImage()));
            postView.getChildren().add(image);
            image.setLayoutX(38);
            image.setLayoutY(36);
            image.setFitWidth(200);
            image.setFitHeight(150);
            image.setPreserveRatio(true);

            Label brand = new Label(), category = new Label(), color = new Label();
            brand.setText(post.getItem().getBrand());
            category.setText(post.getItem().getCategory());
            color.setText(post.getItem().getColor());
            postView.getChildren().addAll(brand, category, color);
            brand.setLayoutX(270);
            category.setLayoutX(270);
            color.setLayoutX(270);
            brand.setLayoutY(60);
            category.setLayoutY(90);
            color.setLayoutY(120);

            Button verify = new Button();
            verify.setLayoutX(445);
            verify.setLayoutY(115);
            verify.setText("Verify");
            Button view = new Button();
            view.setLayoutX(450);
            view.setLayoutY(80);
            view.setText("View");
            postView.getChildren().addAll(verify, view);
            	
            view.setOnAction((event) -> {
    			try {
					view(post.getPostid());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		});
            
            // VERIFY
        }
    }

    public void search() throws IOException, ClassNotFoundException
    {
        loadPosts(PostController.getPosts(keyword.getText()));
    }

    public void newPost() throws IOException
    {
    	Main.setRoot("newPost.fxml");
    }
    
    public void view(int id) throws IOException, ClassNotFoundException
    {

    	Main.holdPost = PostController.getPost(id);
    	Main.holdPost.getItem().setImage(PostController.getPost(id).getItem().getImage());
    	System.out.println(Main.holdPost.getItem().getImage());
    	Main.setRoot("ViewPost.fxml");
    }

    public void logout() throws IOException
    {
    	Main.pubName = "";
    	Main.setRoot("sign_in.fxml");
    	
    }

}
