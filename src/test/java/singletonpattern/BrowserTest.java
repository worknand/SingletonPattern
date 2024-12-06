package singletonpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BrowserTest {
	
	// This is an example of reflection attack by broking singleton pattern and creating one or more instance/Objects
	// this is termed as violation of singleton class

	public static void main(String[] args) {
		
		Browser  instance1=	Browser.getInstance();
		Browser instance2=null;
		
		try {
			
			Constructor<Browser> contructor=Browser.class.getDeclaredConstructor();
			
			contructor.setAccessible(true);
			instance2=contructor.newInstance();
			System.out.println("Hashcode of instance1: "+instance1.hashCode());
			System.out.println("Hashcode of instance1: "+instance2.hashCode());
			
			}
			 catch (InstantiationException e) {
			
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			}
			
			
		catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		}

}

}
