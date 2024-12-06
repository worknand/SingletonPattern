package singletonpatternCloneable;

import java.io.Serializable;

public class Browser implements Serializable, Cloneable {
	
	//Purpose of Singleton class?
	// Achieve only one Object/instance creation OR instantiation of object once 
	
	//1.private static instance of class
	
	private volatile static Browser browser; // null in beginning
	
	//2.private constructor to avoid/prevent initiation
	private Browser() {
		if(browser != null) {
			// for BrowserTest example
			// handling reflection attack
			throw new IllegalArgumentException("Another object is created");
		}
	}
	
	//3.public static method to provide access to the instantiation/object and also method level synchronization for thread safety
	
/*	public  synchronized static  Browser getInstance() {
		if (browser == null) {
			browser =new Browser();
		}
		return browser;
	}*/
	
	// second type
	public  synchronized static  Browser getInstance() {
		if (browser == null) {
			synchronized(Browser.class) {
				if (browser == null) {	
			browser =new Browser();
		}
		}
		}
		return browser;
	}
	
	
	
	//Individual method of class
	
	public void displaymessage() {
		System.out.println("Browser Info");
	}
	
	// for Browser read resolve example
	// Add readResolve()  ---- which will be called during De-Serialization process  --- this will return class instance
	
	protected Object readResolve() {
		return getInstance(); 
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton instance cannot be cloned");
	}

}
