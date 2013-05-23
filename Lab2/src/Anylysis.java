import java.io.*;

public class Anylysis {
	error wrong;
	BufferedReader in;
	FileReader read;
	PrintWriter outputstream = null;
	//GetSym getSym;
	String mys="";
	Ci currentWord;
	Biao table = new Biao();
	tabDefine define;
	int LEV, ADR = 0;

	public Anylysis() {
		try {
			outputstream = new PrintWriter(
					new FileOutputStream("E:\\table.txt"), true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("��ȡ�ļ�����");
		}
	}

	public void read() throws IOException {
		File file = new File("E:\\test.txt");
		try {
			read = new FileReader(file);
			in = new BufferedReader(read);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			in.close();
			read.close();

		}
	}

	public void show(tabDefine def) {
		outputstream.append("NAME    " + def.NAME + ":     KIND= " + def.KIND
				+ "     VAL=" + def.VAL + "     " + "LEVEL=" + def.LEV
				+ "     ADR=��DX���ݣ�" + def.ADR);
	}


	
	//�﷨����
	//����˵������
	public void changLiangShuoMing(){
		do{//����Ƕ��ţ�˵���ǳ����Ķ��� 
			currentWord=GetSym.getSym(mys);
			changliangdingyi();
		}
		while(currentWord.SYM.equals(","));
		if(currentWord.SYM.equals(";"))//�����ֺţ�˵��������������һ��
		{ 
			currentWord=GetSym.getSym(mys);
			System.out.println("����˵������");
		}
	}
	
	//����˵������
	public void bianLiangShuoMing(){
		do{//����Ƕ��ţ�˵���ǳ����Ķ��� 
			currentWord=GetSym.getSym(mys);
			if(currentWord.SYM.equals("IDENT"))
			{
				define=new tabDefine(currentWord.NAME, "VARIABLE", -1, LEV, ADR++);
				show(define);
				table.add(define);
			
			currentWord=GetSym.getSym(mys);//����һ��
			}
			else
			{
				wrong=new error(4);
				wrong.show();
			}
			//bianliangdingyi();
		}
		while(currentWord.SYM.equals(","));
		if(currentWord.SYM.equals(";"))//�����ֺţ�˵��������������һ��
		{ 
			currentWord=GetSym.getSym(mys);
			System.out.println("����˵������");
		}
		else
		{
			wrong=new error(1);
			wrong.show();
		}
	}
	/*private void bianliangdingyi() {
		
		
	}*/

	private void changliangdingyi() {//��������
		if(currentWord.SYM.equals("IDENT"))//��ʾ��
		{
			String helpName=currentWord.NAME;//define��NAME
			currentWord=GetSym.getSym(mys);//����һ��
				if(currentWord.SYM.equals("=")){
					currentWord=GetSym.getSym(mys);//����һ��
				}
				else
				{
					wrong=new error(6);
					wrong.show();
				}
				if(currentWord.SYM.equals("NUMBER")){
					define=new tabDefine(currentWord.NAME, "CONSTANT", currentWord.NUM, -1, -1);
					show(define);
					table.add(define);
					currentWord=GetSym.getSym(mys);//����һ��
				}
				else
				{
					wrong=new error(3);
					wrong.show();
				}
		}
		
	}
	
	public void processShuoming()//����˵�������¶�
	{
		currentWord=GetSym.getSym(mys);
		if(currentWord.SYM.equals("IDENT"))
		{
			ADR=3;
			define=new tabDefine(currentWord.NAME, "PROCEDURE", -1, LEV++, ADR);//����Ϊ3
			show(define);
			table.add(define);
			table.LevAdd();
			
		currentWord=GetSym.getSym(mys);
		if(currentWord.SYM.equals(";"))//˵������������һ��
		{
			currentWord=GetSym.getSym(mys);
			System.out.println("������һ�������ײ�");
			fenchengxu();
				if(currentWord.SYM.equals(";"))
				{
					LEV=0;
					currentWord=GetSym.getSym(mys);//���̽���������һ������
					while(currentWord.SYM.equalsIgnoreCase("procedure"+"SYM")){
						processShuoming();
					}
					System.out.println("������һ�����̵�˵������");
				}
				else
				{
					currentWord.show(currentWord.SYM);
					error err=new error(8);
					err.show();
				}
		}
		else
		{
			currentWord.show(currentWord.SYM);
			error err=new error(7);
			err.show();
		}
		}
		else
		{
			currentWord.show(currentWord.SYM);
			
			error err=new error(6);
			err.show();
		}
	}
	
	
	public void yuju(){//���
		if(currentWord.SYM.equals("IDENT")){
			currentWord=GetSym.getSym(mys);
			fuzhisentence();
			System.out.println("������һ����ֵ���");
			
		}
		else if(currentWord.SYM.equals("if"+"SYM")){//����if��ת���������
			currentWord=GetSym.getSym(mys);
			tiaojiansentence();//ִ���������
		}
		else if(currentWord.SYM.equals("if"+"SYM")){//����while��ת��ѭ�����
			currentWord=GetSym.getSym(mys);
			cycleSentence();
		}
		else if(currentWord.SYM.equals("read"+"SYM")){//����read��ת�������
			readsentence();
		}
		else if(currentWord.SYM.equals("write"+"SYM")){//����write��ת��д���
			writesentence();
		}
		else if(currentWord.SYM.equals("begin"+"SYM")){//����begin��ת��д���
			beginsentence();
		}
		else if(currentWord.SYM.equals(".")||currentWord.SYM.equals(";")||currentWord.NAME.equals("end"))
		{
			//˵������,����һ��
			System.out.println("������һ���յ����");
		}
		else{
		currentWord.show(currentWord.SYM);
		error err=new error(13);
		err.show();}
	}
	


	public void beginsentence() {
		
	}

	public void writesentence() {
		// TODO Auto-generated method stub
				currentWord=GetSym.getSym(mys);//����һ��
				if(currentWord.SYM.equals("(")){
					do{
						if(currentWord.SYM.equals("IDENT")){
							currentWord=GetSym.getSym(mys);
						}
						else{
							error err=new error(21);
							err.show();
						}
					}while(currentWord.SYM.equals(","));
						if(currentWord.SYM.equals("(")){
							currentWord=GetSym.getSym(mys);
							System.out.println("������һ��д���");
						}
						else{
							error err=new error(22);
							err.show();
						}
				}
				else
				{
					error err=new error(23);
					err.show();
				}
				
		
	}

	public void readsentence() {
		// TODO Auto-generated method stub
				currentWord=GetSym.getSym(mys);//����һ��
				if(currentWord.SYM.equals("(")){
					do{
						if(currentWord.SYM.equals("IDENT")){
							currentWord=GetSym.getSym(mys);
						}
						else{
							error err=new error(14);
							err.show();
						}
					}while(currentWord.SYM.equals(","));
						if(currentWord.SYM.equals("(")){
							currentWord=GetSym.getSym(mys);//˵������������һ�����
							System.out.println("������һ��д���");
						}
						else{
							error err=new error(19);
							err.show();
						}
				}
				else
				{
					error err=new error(20);
					err.show();
				}
				
		
	}

	public void cycleSentence() {
		tiaojiansentence();
		if(currentWord.SYM.equals("do"+"SYM")){
			currentWord=GetSym.getSym(mys);//����һ��
			yuju();
			currentWord=GetSym.getSym(mys);//˵������������һ��
			System.out.println("������һ���������");	
		}
		else
		{
			currentWord.show(currentWord.SYM);
			error err=new error(12);
			err.show();
		}
	}

	public void tiaojiansentence() {
		if(currentWord.SYM.equals("odd"+"SYM")){
			currentWord=GetSym.getSym(mys);//����һ��
			biaodaSentence();
			System.out.println("������һ������");
		}
		else
		{
			biaodaSentence();
			if(currentWord.SYM.equals("=")||currentWord.SYM.equals(">")||currentWord.SYM.equals("<")||
			currentWord.SYM.equals(">=")||currentWord.SYM.equals("<=")||currentWord.SYM.equals("#")){
				currentWord=GetSym.getSym(mys);//����һ��
				biaodaSentence();
				System.out.println("������һ������");
			}
			else
			{
				currentWord.show(currentWord.SYM);
				error err=new error(17);
				err.show();
			}
		}
		
	}

	public void fuzhisentence() {//��ֵ���
		if(currentWord.SYM.equals(":")){
			currentWord=GetSym.getSym(mys);//����һ��
		}
		else
		{
			currentWord.show(currentWord.SYM);
			error err=new error(10);
			err.show();
		}
		
		if(currentWord.SYM.equals("=")){
			currentWord=GetSym.getSym(mys);//����һ��
		}
		else
		{
			currentWord.show(currentWord.SYM);
			error err=new error(10);
			err.show();
		}
		biaodaSentence();
	}

	public void biaodaSentence() {
		//���Ǳ��ʽ��������+��-����
		if(currentWord.SYM.equals("+")||currentWord.SYM.equals("-")){
			currentWord=GetSym.getSym(mys);
		}
		detail();
		while(currentWord.SYM.equals("+")||currentWord.SYM.equals("-"))
		{
			currentWord=GetSym.getSym(mys);//����һ��
			detail();
		}
		System.out.println("������һ���﷨���ʽ");
	}

	public void detail() {
		factor();
		while(currentWord.SYM.equals("*")||currentWord.SYM.equals("/"))
		{
			currentWord=GetSym.getSym(mys);//����һ��
			factor();
		}
		System.out.println("������һ����");
	}

	public void factor() {
		if(currentWord.SYM.equals("IDENT")){//��ʾ��
			currentWord=GetSym.getSym(mys);
			System.out.println("������һ����ʶ��������");
		}
		else if(currentWord.SYM.equals("NUMBER")){//�޷�������
			currentWord=GetSym.getSym(mys);
			System.out.println("������һ���޷��ŵ���������");
		}
		else if(currentWord.SYM.equals("(")){//�����˱��ʽ
			currentWord=GetSym.getSym(mys);
			biaodaSentence();
			  if(currentWord.SYM.equals(")")){
				  currentWord=GetSym.getSym(mys);//���˵���������ý�����һ��
				  System.out.println("������һ�����ʽ����");
			  }
			  else{
				  //currentWord.show(currentWord.SYM);
					error err=new error(15);
					err.show();
			  }
		}
		else
		{
			error err=new error(16);
			err.show();
		}
	}

	public void fenchengxu() {
		
		
	}

	public static void main(String[] args) {

	}

}
