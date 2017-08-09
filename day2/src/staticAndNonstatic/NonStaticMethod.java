package staticAndNonstatic;

public class NonStaticMethod {
	//public int a=1;
	public static int a;
	
	public NonStaticMethod(int number){
		a= number +a;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonStaticMethod obj = new NonStaticMethod(10);
		System.out.println(obj.a);
		
		NonStaticMethod obj1 = new NonStaticMethod(10);
		System.out.println(obj1.a);
		
		NonStaticMethod obj2 = new NonStaticMethod(10);
		System.out.println(obj2.a);
		
		
	}

}
