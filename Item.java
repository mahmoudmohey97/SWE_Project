package sweproject;

import java.io.Serializable;

public class Item implements Serializable
{
	private static final long serialVersionUID = 1L;
	String brand;
	String category;
	String color;
	String image;
	public Item() {};
	public Item(String brand, String category, String color, String image) 
	{
		this.brand = brand;
		this.category = category;
		this.color = color;
		this.image = image;
	}
	public String getBrand() 
	{
		return brand;
	}
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	public String getCategory() 
	{
		return category;
	}
	public void setCategory(String category) 
	{
		this.category = category;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
