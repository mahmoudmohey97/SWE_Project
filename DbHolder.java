package sweproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class DbHolder 
{
	public static Object retrieve(int choose, String primary) throws IOException, ClassNotFoundException
	{
		if(choose == 1)
		{
			File F = new File("users.txt");
			if(F.exists() == false)
			{
				F.createNewFile();
				FileOutputStream out = new FileOutputStream(F);
				ObjectOutputStream outFile = new ObjectOutputStream(out);
				outFile.writeObject(new Vector<User>());
				outFile.close();
			}
			FileInputStream output = new FileInputStream("users.txt");
			ObjectInputStream file = new ObjectInputStream(output);
			@SuppressWarnings("unchecked")
			Vector<User> allUser = (Vector<User>)file.readObject();
			file.close();
			for(int i = 0; i < allUser.size(); ++i)
			{
				if(allUser.get(i).getUsername().equals(primary))
				{
					return(allUser.get(i));
				}
			}
		}
		return null;
	}
	public static Vector<User> retrieveAll(int choose) throws IOException, ClassNotFoundException
	{
		if(choose == 1)
		{
			File F = new File("users.txt");
			if(F.exists() == false)
			{
				F.createNewFile();
				FileOutputStream out = new FileOutputStream(F);
				ObjectOutputStream outFile = new ObjectOutputStream(out);
				outFile.writeObject(new Vector<User>());
				outFile.close();
			}
			FileInputStream output = new FileInputStream("users.txt");
			ObjectInputStream file = new ObjectInputStream(output);
			@SuppressWarnings("unchecked")
			Vector<User> allUser = (Vector<User>)file.readObject();
			for(int i = 0 ; i < allUser.size() ; i++)
			{
				for(int j = 0 ; j < allUser.get(i).posts.size() ; j++)
				{
					System.out.println(allUser.get(i).posts.get(j).postid + " " + allUser.get(i).posts.get(j).item.image);
				}
			}
			file.close();
			return allUser;
		}
		return null;
	}
	public static void add(int choose, Object x) throws IOException, ClassNotFoundException
	{
		if(choose == 1)
		{
			User xUser = (User) x;
			FileInputStream input = new FileInputStream("users.txt");
			ObjectInputStream InFile = new ObjectInputStream(input);
			@SuppressWarnings("unchecked")
			Vector<User> allUser = (Vector<User>)InFile.readObject();
			InFile.close();
			allUser.addElement(xUser);
			FileOutputStream out = new FileOutputStream("users.txt");
			ObjectOutputStream outFile = new ObjectOutputStream(out);
			outFile.writeObject(allUser);
			System.out.println(allUser);
			outFile.close();
		}
	}

	public static void delete(int choose, String primary) throws IOException, ClassNotFoundException
	{
		if(choose == 1)
		{
			FileInputStream input = new FileInputStream("users.txt");
			ObjectInputStream InFile = new ObjectInputStream(input);
			@SuppressWarnings("unchecked")
			Vector<User> allUser = (Vector<User>)InFile.readObject();
			InFile.close();
			for(int i = 0 ; i < allUser.size() ; i++)
			{
				if(allUser.get(i).getUsername().equals(primary))
				{
					allUser.remove(i);
					break;
				}
			}
			FileOutputStream out = new FileOutputStream("users.txt");
			ObjectOutputStream outFile = new ObjectOutputStream(out);
			outFile.writeObject(allUser);
			System.out.println(allUser);
			outFile.close();			
		}
		
	}

	public static Object update(int choose, Object obj) throws IOException, ClassNotFoundException
	{
		if(choose == 1)
		{
			User toBemodified = (User) obj;
			FileInputStream input = new FileInputStream("users.txt");
			ObjectInputStream InFile = new ObjectInputStream(input);
			@SuppressWarnings("unchecked")
			Vector<User> allUser = (Vector<User>)InFile.readObject();
			InFile.close();
			int i = 0;
			for(; i < allUser.size() ; i++)
			{
				if(allUser.get(i).getUsername().equals(toBemodified.getUsername()))
				{
					allUser.get(i).setEmail(toBemodified.getEmail());
					allUser.get(i).setPhone(toBemodified.getPhone());
					allUser.get(i).setPassword(toBemodified.getPassword());
					allUser.get(i).setPosts(toBemodified.getPosts());
					break;
				}
			}
			FileOutputStream out = new FileOutputStream("users.txt");
			ObjectOutputStream outFile = new ObjectOutputStream(out);
			outFile.writeObject(allUser);
			outFile.close();
			return allUser.get(i);
		}
		return null;
	}



}

