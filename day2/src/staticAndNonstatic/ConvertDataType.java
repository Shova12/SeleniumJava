package staticAndNonstatic;

public class ConvertDataType {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		String b ="10";
		
		System.out.println(b.equals(String.valueOf(a)));//converting Integer datatype to String
		System.out.println(a== Integer.parseInt(b));
		

	}

}
