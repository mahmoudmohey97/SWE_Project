package sweproject;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	String username;
	String email;
	String phone;
	String password;
	Vector<Notification> notifications;
	Vector<Post> posts ;
	
	public User() 
	{
		username = email = password =  "";
		notifications = new Vector<>();
		posts = new Vector<>();
		phone = ""; 
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", phone=" + phone + ", password=" + password + ", posts" + posts + "notifications" + notifications+ "]";
	}
	public User(String username, String email, String phone, String password) 
	{
		posts = new Vector<>();
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		notifications = new Vector<>();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Vector<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Vector<Notification> notifications) {
		this.notifications = notifications;
	}
	public Vector<Post> getPosts() {
		return posts;
	}
	public void setPosts(Vector<Post> posts) {
		this.posts = posts;
	}
	
}
