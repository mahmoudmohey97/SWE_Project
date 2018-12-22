package sweproject;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import static sweproject.UserController.*;

public class PostController
{
    public static void createPost(String username, int id, String description,
                                  String category, String brand, String color,
                                  String image) throws ClassNotFoundException, IOException
    {
        User user = getUser(username);
        Post post = new Post();
        post.postid = id;
        post.description = description;
        post.item.category = category;
        post.item.brand = brand;
        post.item.color = color;
        post.item.image = image;
        user.posts.add(post);
        DbHolder.update(1, user);
        System.out.println("added succesfully");
        System.out.println(user.posts.get(0).postid + "  " + user.posts.get(0).description);
    
    }

    public static void deletePost(String username, int id) throws ClassNotFoundException, IOException
    {
        User user = getUser(username);
        for(Post post : user.posts)
        {
            if(post.postid == id)
            {
                user.posts.remove(post);
                break;
            }
        }
        DbHolder.update(1, user);
    }

    public static void updatePost(String username, int id ,String category, 
    								String brand, String color, 
    								String description,String image) throws ClassNotFoundException, IOException
    {
        User user = getUser(username);
        Post post = null;
        for(Post temp : user.posts)
        {
            if(temp.postid == id)
            {
                post = temp;
                user.posts.remove(temp);
                break;
            }
        }
        if(post == null)
        {
            return;
        }
        post.postid = id;
        post.description = description;
        post.item.category = category;
        post.item.brand = brand;
        post.item.color = color;
        post.item.image = image;
        user.posts.add(post);
        DbHolder.update(1, user);
    }

    public static Vector<Post> getPosts(String keyword) throws IOException, ClassNotFoundException
    {
        Vector<User> allUser = DbHolder.retrieveAll(1);
        Vector<Post> matched = new Vector<>();
        for(User user : allUser)
        {
            for(Post post : user.getPosts())
            {
            	if(keyword.length() > 0)
            	{
	                if(post.item.category.contains(keyword))
	                {
	                    matched.add(post);
	                }
            	}
	            else
	            	matched.add(post);
            }
        }
        return matched;
    }
    
   
   public static Post getPost(int postid) throws IOException, ClassNotFoundException
    {
        Vector<User> allUser = DbHolder.retrieveAll(1);
        for(User user : allUser)
        {
            for(Post post : user.getPosts())
            {
                if(post.postid == postid)
                {
                    return post;
                }
            }
        }
        return null;
    }
    
}
