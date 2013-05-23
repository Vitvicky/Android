
public class Biao {
	public tabDefine [][]tx = new tabDefine[6][8];
	public int LevNumber=0;
	public int size[]=new int[4];
	
	public Biao(){
		for (int i = 0; i < 4; i++) {
			size[i]=0;
		}
	}
	public void add(tabDefine td){
		tx[LevNumber][size[LevNumber]]=td;
		size[LevNumber]++;
	}
	
	public void LevAdd(){
		LevNumber++;
	}
	
}
