package sweproject;

import java.io.Serializable;

public class Post implements Serializable
{
	private static final long serialVersionUID = 1L; 
	String description;
	int postid;
	Item item ;
	public Post() {
		item = new Item();
	}
	public Post(String description, int postid, Item item) {
		super();
		this.description = description;
		this.postid = postid;
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
