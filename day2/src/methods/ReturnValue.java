package methods;

public class ReturnValue {
	
	public static void main(String[]args){
		
		System.out.println(merge ("My ","Name ","XYZ."));
		System.out.println(merge ("My ","Name ","Krishna."));
		
	}
	
	
	public static String merge(String a, String b, String c){
		String var = a;
		String var1 = b;
		String var2 = c;
		String var3= a+b+c;
		
		return var3;
	}

}
