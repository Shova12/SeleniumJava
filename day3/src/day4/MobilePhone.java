package day4;

public class MobilePhone extends Phone {
	
	public void Internet(){
		System.out.println("broswering from MobilePhone class");
	}
	
	//Overriding(some changes)
	public void call(){
		//soft keypad
		System.out.println("Call with MobilePhone");
	}
	

}
