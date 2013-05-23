package sort1;

public class Method 
{
	Order order;
	int length;
	Object[] object;
	int whichMethod;
    public Method(Object[] ob,Order or,int wm)
    {
    	this.object=ob;
    	this.order=or;
        this.whichMethod=wm;
        this.length=this.object.length;
    }
    public void useMethod()
    {
	    switch(whichMethod)
	    {
	        case 1:  InsertSort();
		             break;
		    case 2:  BubbleSort();
		             break;
		    case 3:  QuickSort();
		             break;
		};
    }
	public void InsertSort()//÷±Ω”≤Â»Î≈≈–Ú
	{
		for(int i=1;i<length;i++)
		{
			Object temp=object[i];
			for(int j=0;j<i;j++)
			{
				if(order.compare(temp,object[j]))
				{
					for(int x=i;x>j;x--)
						object[x]=object[x-1];
					object[j]=temp;
					break;
				}
			}
		}
	}
	public void BubbleSort()//√∞≈›≈≈–Ú
	{
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length-i-1;j++)
			{
				if(order.compare(object[j], object[j+1]))
				{
					Object temp=object[j];
					object[j]=object[j+1];
					object[j+1]=temp;
				}
			}
		}
	}
	public void QuickSort()//øÏÀŸ≈≈–Ú
	{
		QSort(0,length-1);
	}
	private void QSort(int left, int right) 
	{
		if (left == right)
			return;
		int index = left;
		int a = left;
		int b = right;
		while (a < b) 
		{
			if (order.compare(object[index], object[b])) 
			{
				Object temp = object[index];
				object[index] = object[b];
				object[b] = temp;
				index = b;
			}
		}
	}
}
