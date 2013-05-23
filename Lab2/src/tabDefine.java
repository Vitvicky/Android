
public class tabDefine {
	public String NAME,KIND;
	public int VAL,LEV,ADR;
	
	public tabDefine(){
		NAME=null;
		KIND=null;
		VAL=0;
		LEV=0;
		ADR=0;
	}
	
	public tabDefine(String name,String kind,int val,int lev,int adr)
	{
		NAME=name;
		KIND=kind;
		VAL=val;
		LEV=lev;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getKIND() {
		return KIND;
	}
	public void setKIND(String kIND) {
		KIND = kIND;
	}
	public int getVAL() {
		return VAL;
	}
	public void setVAL(int vAL) {
		VAL = vAL;
	}
	public int getLEV() {
		return LEV;
	}
	public void setLEV(int lEV) {
		LEV = lEV;
	}
	public int getADR() {
		return ADR;
	}
	public void setADR(int aDR) {
		ADR = aDR;
	}
	
}
