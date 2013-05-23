import java.util.Scanner;
import java.io.*;

import Myfilter1.*;

import com.mathworks.extern.java.MWArray;
import com.mathworks.toolbox.javabuilder.*;

public class filter {
	public static void main(String args[]){
		Myfilter1.Class1 filter=null;
//		char[] result=null;
		MWCharArray x=null;
		System.out.println("请输入你的wav文件名:");
		String file=null;
		try{
			
			Scanner scan=new Scanner(System.in);
			file=scan.nextLine();
			x=new MWCharArray(file);
			filter=new Myfilter1.Class1();
			Object s[] = null;
			s = filter.Myfilter(1, x);
			FileOutputStream f = new FileOutputStream("2");
			BufferedOutputStream g = new BufferedOutputStream(f);
			
			
//			System.out.println(s[0]);
//			String j = s[0].toString();
//		System.out.println(j);
//			Scanner scan1 = new Scanner(s[0].toString());
//			for (int h = 0;h < 50;h++)
//				{scan1.nextDouble();
//			System.out.println(scan1.nextDouble());}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
