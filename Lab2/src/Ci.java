public class Ci {
	public String SYM, ID, NAME;
	public int NUM;

	public Ci() {
		this.ID = null;
		this.SYM = null;
		this.NUM = -1;
	}

	public Ci(String sym, String name, String id, int num) {
		this.ID = id;
		this.SYM = sym;
		this.NUM = num;
		this.NAME = name;
	}

	public void setSYM(String sym) {
		SYM = sym;
	}

	public void setID(String id) {
		ID = id;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	public void setNUM(int num) {
		NUM = num;
	}
	
	public void show(String name){
		 System.out.println("单词鉴别（未定义为-1）：");               
		 System.out.println(name+": ID为"+ID+" SYM为"+SYM+" NUM为"+NUM);        
	}
	
}