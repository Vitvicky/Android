package sort1;

public class Main 
{
	public static void main(String arg[])
	{
		String[] test={"s","w","z","r"};
		Sort sort=new Sort(test,2,1);
		sort.handleSort();
		
		System.out.println();
		
		Object[] test2={12,34,67,11,55,03,99};
    	Sort sort2=new Sort(test2,3,2);
    	sort2.handleSort();
	}
}
