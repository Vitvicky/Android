
public class GetSym {
	
	static String mys="";
	
   
	public static int Guanjianzi(String s){//�ؼ���ʶ�𣡣�����
		
		if(s.equals("const")){
			return 1;
		}
		else if(s.equals("var")){
			return 2;
		}
		else if(s.equals("procedure")){
			return 3;
		}
		else if(s.equals("begin")){
			return 4;
		}
		else if(s.equals("end")){
			return 5;
		}
		else if(s.equals("read")){
			return 6;
		}
		else if(s.equals("write")){
			return 7;
		}
		else if(s.equals("call")){
			return 8;
		}
		else if(s.equals("while")){
			return 9;
		}		
		else if(s.equals("do")){
			return 10;
		}
		else if(s.equals("if")){
			return 11;
		}
		else if(s.equals("then")){
			return 12;
		}
		else if(s.equals("odd")){
			return 13;
		}
		return 0;
	}
	
	
	public static Ci getSym(String s){
		
		if(s.length()==0){
			System.out.println("������ϣ�");
			Ci word=new Ci("acc","acc",null,-1);//sym,name=acc			
			return word;			
		}
		else{
			Ci word=new Ci();
			char[] a=s.toCharArray();
			char[] b=new char[30];
			char[] c;
			int index=1;//index��¼�ѷ����˼����ַ���a[0]��a[index-1]�ѷ���
			//display(a);
			if(Character.isLetter(a[0])){//���ַ�Ϊ��ĸ
				b[0]=a[0];
				int i;
				for(i=1;i<a.length;i++){
					if(Character.isLetter(a[i])||Character.isDigit(a[i])){//concat
						b[index++]=a[i];					
					}
					else
						break;
				}
				///��øõ��ʷ���name
				char[]d =new char[index];
				for(int j=0;j<index;j++){
					d[j]=a[j];
				}
				String name=new String (d);
				
				word.setNAME(name);
				//��char����b�ж����Ԫ��ȥ��
				c=new char[index];
				for(int j=0;j<index;j++){
					c[j]=b[j];
				}
				
				//display(c);
				
				String help=new String(c);
				int code=Guanjianzi(help);
				if(code==0){
					//System.out.println("����һ����ʶ��");
					//field1.setText();
					word.ID=help;
					word.SYM="IDENT";
				}
				else{
					//System.out.println("����һ���ؼ���");
					word.SYM=help+"SYM";
				}
				//word.show("word1");
				word.show(word.NAME);
				 //count��һ��ͬʱ���浽����				
				//return index;					
			}
			else if(Character.isDigit(a[0])){
				b[0]=a[0];
				int i;
				for(i=1;i<a.length;i++){
					if(Character.isDigit(a[i])){//concat
						b[index++]=a[i];					
					}
					else
						break;
				}
	            ///��øõ��ʷ���name
				char[]d =new char[index];
				for(int j=0;j<index;j++){
					d[j]=a[j];
				}
				String name=new String (d);
				word.setNAME(name);
				
	            //��char����b�ж����Ԫ��ȥ������c
				c=new char[index];
				for(int j=0;j<index;j++){
					c[j]=b[j];
				}
				
				//display(c);	
				
				//System.out.println(c.length);
				//System.out.println(index);
				
				String help=new String(c);
				//int code=Guanjianzi(help);
				//System.out.println("����һ������");
				word.SYM="NUMBER";
				word.NUM=Integer.parseInt(help);
				//word.show("word1");			
					
				word.show(word.NAME);
				 //count��һ��ͬʱ���浽����
				//return index;
			}
			else if(a[0]=='>'){
				
				if(a[1]=='='){
					index=2;
					word.SYM=">=";
					word.setNAME(">=");
					//System.out.println("���� >=");
				}
				else{
					index=1;
					word.SYM=">";
					word.setNAME(">");
					//System.out.println("���� >");
				}	
				
				
				word.show(word.NAME);
				 //count��һ��ͬʱ���浽����
				//return index;
				//return null;
			}
			else if(a[0]=='<'){
				
				if(a[1]=='='){
					index=2;
					word.SYM="<=";
					word.setNAME("<=");
					//System.out.println("���� <=");
				}
				else{
					index=1;
					word.SYM="<";
					word.setNAME("<");
					//System.out.println("���� <");
				}	
				word.show(word.NAME);
				 //count��һ��ͬʱ���浽����
				
			}
			else if(a[0]=='*'){
				
				if(a[1]=='*'){
					index=2;
					word.SYM="**";
					word.setNAME("**");
					//System.out.println("���� **");
				}
				else{
					index=1;
					word.SYM="*";
					word.setNAME("*");
					//System.out.println("���� *");
				}	
				word.show(word.NAME);
				 //count��һ��ͬʱ���浽����
				//return index;
				//return null;
			}
			else if(a[0]=='+'||a[0]=='-'||a[0]=='/'||a[0]=='='||a[0]=='#'){
				index=1;
				String help=new String(a,0,1);//new String(char [] a,int startindex,int count)
				word.SYM=help;
				word.setNAME(help);
				
				word.show(word.NAME);
				 //count��һ��ͬʱ���浽����
				//return index;
			}
			else if(a[0]=='\n'||a[0]==';'||a[0]==')'||a[0]=='('||a[0]=='{'||a[0]=='}'||a[0]==','
				||a[0]==':'||a[0]=='.'){
				index=1;			
				String help=new String(a,0,1);//new String(char [] a,int startindex,int count)
				word.SYM=help;
				word.setNAME(help);
				//System.out.println("���� "+help);
				word.show(word.NAME);
				// //count��һ��ͬʱ���浽����
				//return index;
			}
			
			else{
			
				System.out.println("�������˷Ƿ��ַ���������");
				return null;
				//field.setText("�������˷Ƿ��ַ���������");
				//return 0;
			}		
			
	   char[] help2=new char[a.length-index];
	   for(int ii=index,j=0;ii<a.length;ii++,j++){
	      help2[j]=a[ii];
	   }
			mys=new String(help2).trim();
			
			return word;
			
	}
		
	}

}
