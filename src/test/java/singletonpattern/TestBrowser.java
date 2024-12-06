package singletonpattern;

public class TestBrowser {

	public static void main(String[] args) {
		//Private constructor prevent object creation from other class
	//	Browser br=new Browser();
		
/*		//using class name
		Browser.getInstance().displaymessage();
		
		//get return as instance then calling non static method from other class
		Browser br=	Browser.getInstance();
		br.displaymessage(); */
		
		Runnable task=() ->{
			Browser.getInstance().displaymessage();
		};
		
		Thread thread1=new Thread(task);
		Thread thread2=new Thread(task);
		Thread thread3=new Thread(task);
		Thread thread4=new Thread(task);
		Thread thread5=new Thread(task);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		//wait for all threads to complete
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
