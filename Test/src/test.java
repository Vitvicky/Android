import java.util.Scanner;

import plotXY.*;
import com.mathworks.toolbox.javabuilder.*;

public class test {
	public static void main(String args[]) {
		plotXY.Class1 xy=null;
		Object[] result;
		MWNumericArray resultX;
		MWNumericArray x = null; /* Array of x values */
		MWNumericArray y = null; /* Array of y values */
		int n = 3;
		Scanner sc = new Scanner(System.in);

		try {
		/* Allocate arrays for x and y values */
		int[] dims = { 1, n };
		x = MWNumericArray.newInstance(dims, MWClassID.DOUBLE,
		MWComplexity.REAL);
		y = MWNumericArray.newInstance(dims, MWClassID.DOUBLE,
		MWComplexity.REAL);
		System.out.println("Please Input X-Y£º ");
		/* Set values */
		for (int i = 1; i <= n; i++) {
		System.out.println("Input X-Y " + i + ": ");
		x.set(i, sc.nextDouble());
		y.set(i, sc.nextDouble());
		}
		xy = new plotXY.Class1();

		result = xy.plotXY(1 ,x , y);
		resultX=(MWNumericArray)result[0];
		System.out.println(result[0]);
		for (int i = 1; i <= n; i++) {
		System.out.println(resultX.getFloat(i));
		}
		xy.waitForFigures();

		xy.dispose();

		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		/* Free native resources */
		MWArray.disposeArray(x);
		MWArray.disposeArray(y);
		if (xy != null)
		xy.dispose();
		}
		}


	}

