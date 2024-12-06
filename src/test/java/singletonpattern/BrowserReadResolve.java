package singletonpattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BrowserReadResolve {

	public static void main(String[] args) {
		
		//POJO ----------->JSON/XML/ByteStream   is called serialization
		//JSON/XML/ByteStream  ---->JAVA(POJO)  ---- Browser ---creating a new Browser instance
		
	
		
		
		
		try {
			Browser instance1=Browser.getInstance();
			// serialize the browser instance
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("broweser.json"));
			out.writeObject(instance1);
			out.close();
			
			// Deserialize the browser instance
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("broweser.json"));
			Browser instance2=  (Browser) in.readObject();
			in.close();
			System.out.println("Hashcode of instance1: "+instance1.hashCode());
			System.out.println("Hashcode of instance1: "+instance2.hashCode());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		

	}

}
