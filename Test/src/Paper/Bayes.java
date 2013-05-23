/* Description����Ҷ˹�㷨�ж������ʼ�
 * * author:Tony
 * * date: 2007/10/23
 */

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.cn.*;
import java.util.*;
import java.io.*;

public class Bayes 
{
	 private Hashtable badHash;
	 private Hashtable goodHash;
	 private Hashtable probabilityHash;
	 //��ʼ��
	 public void init()throws Exception
	 {
		 badHash = new Hashtable();
		 goodHash = new Hashtable();
		 buildEmailHash("D:\\JavaWorkSpace\\Bayes\\src\\data\\badEmail",badHash);
		 buildEmailHash("D:\\JavaWorkSpace\\Bayes\\src\\data\\goodEmail",goodHash);
		 buildNewHashTable();
		
	 }
	 //���������ʼ���ϣ��
	 public void buildEmailHash(String path, Hashtable table) throws Exception
	 {
		 String badInput = readFile(path);
	     ChineseTokenizer tokenizer = new ChineseTokenizer(
	    		                       new StringReader(badInput));
	     Token token;
	     Hashtable tempHash = new Hashtable();
	     double rate = 0.0;
	     int total = 0;
         while ((token = tokenizer.next()) != null)
         {
        	 total++;
        	 String temp = token.termText();
        	 if(table.containsKey(temp))
        	 {
        		 int counter = (Integer)tempHash.get(temp);
        		 counter++;
        		 tempHash.remove(temp);
        		 tempHash.put(temp, counter);
        	 }
        	 else
        	 {
        		 tempHash.put(temp, 1);
        	 }
         }
         //�������ʼ����ַ�������ʷ���badhash��
         for(Iterator it = tempHash.keySet().iterator(); it.hasNext();) 
         {   
        	 String key = (String)it.next();
        	 rate = (Integer)tempHash.get(key)/total;  
        	 table.put(key, rate);     
         }
	 }
	 /*�����µ�probability Hash�����еĸ��ʱ�ʾ
	 ���ʼ��г��� TOKEN �� ti ʱ�����ʼ�Ϊ�����ʼ��ĸ���
	 */
	 public void buildNewHashTable()
	 {
        for(Iterator it = badHash.keySet().iterator(); it.hasNext();) 
         {   
        	 String key = (String)it.next();
        	 // P �� A|ti �� =P2 �� ti �� /[ �� P1 �� ti �� +P2 �� ti �� ] 
        	 double badRate = (Double)badHash.get(key);
        	 double allRate = badRate;
        	 if(goodHash.containsKey(key))
        	 {
        		 allRate  += (Double)goodHash.get(key); 
        	 }
        	 probabilityHash.put(key, (badRate/allRate));
         }
	 }

	 //���ļ�
	 public String readFile(String path)throws Exception
	 {
		 BufferedReader br = new BufferedReader(
				 new FileReader(path));
		 String str = "";
		 while(true)
		 {
			 if(br.readLine() == null) break;
			 str += br.readLine();
		 }
		 br.close();
		 return str;
	 }
	 //�ж��Ƿ�Ϊ�����ʼ� ����true��ʾ�������ʼ� ����false��ʾ�������ʼ�
	 public boolean judgeEmail(String email, double weight) throws Exception
	 {
		 //P(A|t1 ,t2, t3����tn)=��P1*P2*����PN��/[P1*P2*����PN+��1-P1��*��1-P2��*������1-PN��] 
		 ChineseTokenizer tokenizer = new ChineseTokenizer(
				                       new StringReader(email));
	     Token token;
	     boolean flag = true;
	     double rate = 1.0;
	     double tempRate = 1.0;
	     double finalRate = 0.0;
         while ((token = tokenizer.next()) != null)
         {
        	 String key = token.termText();
        	 if(!probabilityHash.containsKey(key))
        	 {
        		 break;
        	 }
        	 else
        	 {
        		 double temp = (Double)probabilityHash.get(key);
        		 tempRate *= 1 - temp;
        		 rate *= temp;
        	 }
         }
         finalRate = rate/(rate + tempRate);
         if(finalRate > weight) flag = false;
         return flag;
	 }
	 public static void main(String args[]) throws Exception
	 {
		 Bayes bayes = new Bayes();
		 bayes.init();
		 String email ="";
		 double weight = 0.5;
		 if(bayes.judgeEmail(email, weight))
		 {
			 System.out.println("It is OK!");
		 }
		 else
		 {
			 System.out.println("It is wrong!");
		 }
	 }

}
