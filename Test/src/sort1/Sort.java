package sort1;

public class Sort 
{
	Object[] object;
	int order;
	int method;
	public Sort(Object[] ob,int a,int b) 
	{
        this.object=ob;
        this.order=a;
        this.method=b;
	}
	public void handleSort()
	{
		Method me=new Method(object,new Order(order),method);
		me.useMethod();
		switch(order)
		{
		case 1:
		{
			switch(method)
			{
			case 1:System.out.println("����+ֱ�Ӳ�����������");
			       print();
			       break;
			case 2:System.out.println("����+ð����������");
		           print();
		           break;
			case 3:System.out.println("����+������������");
		           print();
		           break;
			}
			break;
		}
		case 2:
		{
			switch(method)
			{
			case 1:System.out.println("�ֵ�����+ֱ�Ӳ�����������");
			       print();
			       break;
			case 2:System.out.println("�ֵ�����+ð����������");
		           print();
		           break;
			case 3:System.out.println("�ֵ�����+������������");
		           print();
		           break;
			}
			break;
		}
		case 3:
		{
			switch(method)
			{
			case 1:System.out.println("����+ֱ�Ӳ�����������");
			       print();
			       break;
			case 2:System.out.println("����+ð����������");
		           print();
		           break;
			case 3:System.out.println("����+������������");
		           print();
		           break;
			}
			break;
		}
		}
	}
	public void print()
	{
		for (int i = 0; i < this.object.length; i++) 
		{
			System.out.print(this.object[i]+" ");
		}
	}
}
