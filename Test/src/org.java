
public class org {
	static int A;
	public static void main(String args[]){
		boolean x;
		if((x=(++A==0)?false:true))
			//System.out.println("x1="+x);
			//System.out.println("A1="+A);
			if((x=(++A==0)?true:false)){
				//System.out.println("x2="+x);
				//System.out.println("A2="+A);
				System.out.println(++A);}
			else
			{	//System.out.println("x2="+x);
				//System.out.println("A2="+A);
				System.out.println(A+10);}
		else
			System.out.println(A+20);
	}
}
