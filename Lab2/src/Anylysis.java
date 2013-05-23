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
			System.out.println("读取文件错误");
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
				+ "     ADR=（DX内容）" + def.ADR);
	}


	
	//语法分析
	//常量说明部分
	public void changLiangShuoMing(){
		do{//如果是逗号，说明是常量的定义 
			currentWord=GetSym.getSym(mys);
			changliangdingyi();
		}
		while(currentWord.SYM.equals(","));
		if(currentWord.SYM.equals(";"))//遇见分号，说明结束，进行下一个
		{ 
			currentWord=GetSym.getSym(mys);
			System.out.println("常量说明部分");
		}
	}
	
	//变量说明部分
	public void bianLiangShuoMing(){
		do{//如果是逗号，说明是常量的定义 
			currentWord=GetSym.getSym(mys);
			if(currentWord.SYM.equals("IDENT"))
			{
				define=new tabDefine(currentWord.NAME, "VARIABLE", -1, LEV, ADR++);
				show(define);
				table.add(define);
			
			currentWord=GetSym.getSym(mys);//读下一个
			}
			else
			{
				wrong=new error(4);
				wrong.show();
			}
			//bianliangdingyi();
		}
		while(currentWord.SYM.equals(","));
		if(currentWord.SYM.equals(";"))//遇见分号，说明结束，进行下一个
		{ 
			currentWord=GetSym.getSym(mys);
			System.out.println("变量说明部分");
		}
		else
		{
			wrong=new error(1);
			wrong.show();
		}
	}
	/*private void bianliangdingyi() {
		
		
	}*/

	private void changliangdingyi() {//常量定义
		if(currentWord.SYM.equals("IDENT"))//标示符
		{
			String helpName=currentWord.NAME;//define的NAME
			currentWord=GetSym.getSym(mys);//读下一个
				if(currentWord.SYM.equals("=")){
					currentWord=GetSym.getSym(mys);//读下一个
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
					currentWord=GetSym.getSym(mys);//读下一个
				}
				else
				{
					wrong=new error(3);
					wrong.show();
				}
		}
		
	}
	
	public void processShuoming()//过程说明，往下读
	{
		currentWord=GetSym.getSym(mys);
		if(currentWord.SYM.equals("IDENT"))
		{
			ADR=3;
			define=new tabDefine(currentWord.NAME, "PROCEDURE", -1, LEV++, ADR);//过程为3
			show(define);
			table.add(define);
			table.LevAdd();
			
		currentWord=GetSym.getSym(mys);
		if(currentWord.SYM.equals(";"))//说明结束，读下一个
		{
			currentWord=GetSym.getSym(mys);
			System.out.println("分析了一个过程首部");
			fenchengxu();
				if(currentWord.SYM.equals(";"))
				{
					LEV=0;
					currentWord=GetSym.getSym(mys);//过程结束，读下一个过程
					while(currentWord.SYM.equalsIgnoreCase("procedure"+"SYM")){
						processShuoming();
					}
					System.out.println("分析了一个过程的说明部分");
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
	
	
	public void yuju(){//语句
		if(currentWord.SYM.equals("IDENT")){
			currentWord=GetSym.getSym(mys);
			fuzhisentence();
			System.out.println("分析了一个赋值语句");
			
		}
		else if(currentWord.SYM.equals("if"+"SYM")){//遇到if跳转到条件语句
			currentWord=GetSym.getSym(mys);
			tiaojiansentence();//执行条件语句
		}
		else if(currentWord.SYM.equals("if"+"SYM")){//遇到while跳转到循环语句
			currentWord=GetSym.getSym(mys);
			cycleSentence();
		}
		else if(currentWord.SYM.equals("read"+"SYM")){//遇到read跳转到读语句
			readsentence();
		}
		else if(currentWord.SYM.equals("write"+"SYM")){//遇到write跳转到写语句
			writesentence();
		}
		else if(currentWord.SYM.equals("begin"+"SYM")){//遇到begin跳转到写语句
			beginsentence();
		}
		else if(currentWord.SYM.equals(".")||currentWord.SYM.equals(";")||currentWord.NAME.equals("end"))
		{
			//说明结束,读下一个
			System.out.println("分析了一个空的语句");
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
				currentWord=GetSym.getSym(mys);//读下一个
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
							System.out.println("分析了一个写语句");
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
				currentWord=GetSym.getSym(mys);//读下一个
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
							currentWord=GetSym.getSym(mys);//说明结束，读下一个语句
							System.out.println("分析了一个写语句");
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
			currentWord=GetSym.getSym(mys);//读下一个
			yuju();
			currentWord=GetSym.getSym(mys);//说明结束，读下一个
			System.out.println("分析了一个条件语句");	
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
			currentWord=GetSym.getSym(mys);//读下一个
			biaodaSentence();
			System.out.println("分析了一个条件");
		}
		else
		{
			biaodaSentence();
			if(currentWord.SYM.equals("=")||currentWord.SYM.equals(">")||currentWord.SYM.equals("<")||
			currentWord.SYM.equals(">=")||currentWord.SYM.equals("<=")||currentWord.SYM.equals("#")){
				currentWord=GetSym.getSym(mys);//读下一个
				biaodaSentence();
				System.out.println("分析了一个条件");
			}
			else
			{
				currentWord.show(currentWord.SYM);
				error err=new error(17);
				err.show();
			}
		}
		
	}

	public void fuzhisentence() {//赋值语句
		if(currentWord.SYM.equals(":")){
			currentWord=GetSym.getSym(mys);//读下一个
		}
		else
		{
			currentWord.show(currentWord.SYM);
			error err=new error(10);
			err.show();
		}
		
		if(currentWord.SYM.equals("=")){
			currentWord=GetSym.getSym(mys);//读下一个
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
		//考虑表达式里面遇到+，-符号
		if(currentWord.SYM.equals("+")||currentWord.SYM.equals("-")){
			currentWord=GetSym.getSym(mys);
		}
		detail();
		while(currentWord.SYM.equals("+")||currentWord.SYM.equals("-"))
		{
			currentWord=GetSym.getSym(mys);//读下一个
			detail();
		}
		System.out.println("分析了一个语法表达式");
	}

	public void detail() {
		factor();
		while(currentWord.SYM.equals("*")||currentWord.SYM.equals("/"))
		{
			currentWord=GetSym.getSym(mys);//读下一个
			factor();
		}
		System.out.println("分析了一个项");
	}

	public void factor() {
		if(currentWord.SYM.equals("IDENT")){//标示符
			currentWord=GetSym.getSym(mys);
			System.out.println("分析了一个标识符因子项");
		}
		else if(currentWord.SYM.equals("NUMBER")){//无符号整数
			currentWord=GetSym.getSym(mys);
			System.out.println("分析了一个无符号的整数因子");
		}
		else if(currentWord.SYM.equals("(")){//遇到了表达式
			currentWord=GetSym.getSym(mys);
			biaodaSentence();
			  if(currentWord.SYM.equals(")")){
				  currentWord=GetSym.getSym(mys);//这个说明结束，该进行下一个
				  System.out.println("分析了一个表达式因子");
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
