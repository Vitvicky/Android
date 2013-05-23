public class RiverHorse extends Animal{
	public static double mouth;
	public static double weight;
	public static String name; 
	public RiverHorse(double weight, String name,double mouth) {
		super(weight, name);
		}
	public double getMouth() {
		return mouth;
	}
	public void setMouth(double mouth) {
		this.mouth = mouth;
	}

	public String toString(){
		return toString();		
	}
	
	
	@Override
	public int fight(Object o) {
		if(!((Animal) o).getName().equals("RiverHorse"))
		return 1;
		else
			return RiverHorseFight(o);
	}
	public int RiverHorseFight(Object o1){
		RiverHorse r=new RiverHorse(weight,name,mouth);
		if(((RiverHorse) o1).getMouth()==(r.getMouth())){
			return 0;
		}
		else
			if(((RiverHorse) o1).getMouth()>(r.getMouth()))
				return -1;
			else
				return 1;
	}
		
}
