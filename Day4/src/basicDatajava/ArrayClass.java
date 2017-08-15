package basicDatajava;

import java.util.ArrayList;
import java.util.List;

// Array is basic mean for data handling

public class ArrayClass {

	public static void main(String[] args) {
	/*	String []a = new String[6];
		a[0]="mark";
		a[1]="Mike";
		a[2]="Allen";
		a[3]="Helen";
		a[4]="Siko";
		
		for(int i =0; i<a.length; i++){
			System.out.println("Student name "+ a[i]);
		}*/
		
		ArrayList lst = new ArrayList();
		lst.add("Mike");
		lst.add("A");
		System.out.println("Size: "+lst.size());
		
		lst.add("Mike");
		lst.add("A");
		System.out.println("Size2: "+lst.size());
		
		for(int i =0; i<lst.size(); i++){
			System.out.println("value "+ lst.get(i));//to read value in array list
		}
		System.out.println("value before "+ lst.get(2));
		lst.set(2, "selenium"); //update data in position
		//lst.remove(2);
		System.out.println("value  after"+ lst.get(2));
	}
	
	public void arrayInt(){
		ArrayList<String> lst1 = new ArrayList<String>();
		lst1.add("name");
		ArrayList<Integer> lst2 = new ArrayList<Integer>();
		lst2.add(123);
		
		ArrayList<Object> lst3 = new ArrayList<Object>(); //Object (default data type)is parent data over other data type
		lst3.add(123);
		lst3.add("abcd");
	
	}
	
	public void listClass(){
//Interface(basic feature) List //Class: ArrayList
		List<String> list = new ArrayList<>();
		// arraylist is class of List interface
		
		//basically arraylist can use all basic feature in list.
	
	}


}
