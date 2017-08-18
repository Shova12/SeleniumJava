package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import net.sourceforge.htmlunit.corejs.javascript.ObjToIntMap.Iterator;

public class Hasttble {

	public static void main(String[] args) {
		//List,Hashtable(Hashmap) and Set
		/*ArrayList <String> lst1 = new ArrayList<String>();
		
		lst1.add("name1");
		lst1.add("name2");
		
		for(int i=0; i<lst1.size();i++){
			System.out.print(lst.get(i));
		}*/
		
		//ArrayList: work with index or position, lots of work for complier; takes lots of memory, is used for read and write in WebPage
		//if item is removed then all items need to changed position while in hashtable key value remain same.so process take lots more fast then other.
		//HashTable: works with key value pair, faster in execution than ArrayList;is part of ArrayList, mostly used in framework, can be used for any type of data
		
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("Name1", "Mark");
		table.put("MarkAge", "25");
		
		System.out.println(table.get("Name1"));
	}
	
	public void set(){
		
		//HashSet will remove duplicate value;
		//can't use for loop
		//Interface Iterator is use with set interface
		Set<String> lst= new HashSet<String>();
		lst.add("name");
		lst.add("age");
		lst.add("name");
		
		lst.add("age");
		lst.add("name");
		lst.add("age");
	
		Iterator<> it = lst.iterator();
		
		//result type boolean
		While(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
