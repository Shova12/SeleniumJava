package staticAndNonstatic;

public class BasicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String var = "name hello";
	System.out.println(var.length());
	System.out.println("SubString: "+var.substring(2,6));
		
		for(int i=0; i<var.length(); i++){
			
			char d = var.charAt(i);
			
			System.out.println("D:"+d);
			
		}
		
			String var2 ="name";
			String var3 ="name";
			System.out.println(var2.equals(var3));
			
	}

}
