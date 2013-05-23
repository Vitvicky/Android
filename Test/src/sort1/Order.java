package sort1;

public class Order 
{
    int whichOrder=0;
    public Order(int wo)
    {
    	whichOrder=wo;
    }
    public boolean compare(Object a,Object b)
    {
    	boolean bool=false;
	    switch(whichOrder)
	    {
	        case 1:  if((Integer)a>(Integer)b)//ÉýÐò
				         bool=true;
	    	         else bool=false;
		             break;
		    case 2:  if(a.toString().compareTo(b.toString())<0)//×ÖµäÅÅÐò
				         bool=true;
			         else bool=false;
		             break;
		    case 3:  if((Integer)a<(Integer)b)//½µÐò
				         bool=true;
			         else bool=false;
		             break;
		};
	    return bool;
    }
}
