package sweproject;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import org.omg.CORBA.PUBLIC_MEMBER;

import application.Main;
import application.SampleController;
import javafx.fxml.FXML;

public class UserController {
	/** hash password **/
	public static User VerifySign_in(String username, String password) throws ClassNotFoundException, IOException {
		User check = (User) DbHolder.retrieve(1, username);
		if (check == null) {
			System.out.println("wrong username");
			return null;
		} else {
			if (check.password.equals(password)) {
				System.out.println("+++++++++++++++" + check.getNotifications());
				return check;
			}

			else {
				System.out.println("invalid signin information");
				return null;
			}
		}
	}

	public static User VerifyRegister(String username, String password, String phone, String email)
			throws ClassNotFoundException, IOException {
		User xUser = new User(username, email, phone, password);
		User checkIfExists = (User) DbHolder.retrieve(1, username);

		if (checkIfExists != null) {
			return null;
		} else {
			DbHolder.add(1, xUser);
			System.out.println("added");
		}
		return xUser;
	}
	public static User getUser(String username) throws ClassNotFoundException, IOException
	{
		return (User)DbHolder.retrieve(1, username);
	}
	
	public static User getPostOwner(int postid) throws ClassNotFoundException, IOException
	{
		 Vector<User> allUser = DbHolder.retrieveAll(1);
	        for(User user : allUser)
	        {
	            for(Post post : user.getPosts())
	            {
	                if(post.postid == postid)
	                {
	                    return user;
	                }
	            }
	        }
	        return null;
	}
	
 	public static void Delete(String username) throws ClassNotFoundException, IOException {
		/// lesa na2s delete el posts bta3et el user mn file posts & termination to home
		/// screen
		User check = (User) DbHolder.retrieve(1, username);
		Scanner in = new Scanner(System.in);
		System.out.println("enter your password");
		String pass = in.next();
		if (check.getPassword().equals(pass)) {
			DbHolder.delete(1, username);
		}

		else {
			System.out.println("invalid password");
		}
	}

	public static void update(String username , String mail , String phone , String password) throws ClassNotFoundException, IOException {
		User check = (User) DbHolder.retrieve(1, username);
		check.setEmail(mail);
		check.setPhone(phone);
		check.setPassword(password);
		DbHolder.update(1, check);
		System.out.println("done");
	}

	
	public static void verifyitem(int postid,String username) throws ClassNotFoundException, IOException
	{
		
		User postCreator = getPostOwner(postid);
		//System.out.println(postCreator.getNotifications().size());
		Vector<Notification>all_notifications  = postCreator.getNotifications();
		Notification holder =new Notification(username ,postid);
		all_notifications.addElement(holder);
		postCreator.setNotifications(all_notifications);
	}
}
