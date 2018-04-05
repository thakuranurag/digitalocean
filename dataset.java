package major;

import  java.util.*;
import java.io.*;
import java.io.FileReader;
public class dataset {
	public static void main(String args[]) throws Exception
	{
		FileReader fr=new FileReader("breast_preprocessed.txt");   
		String[][] arr = new String[130][47300];
        int i;    
        String gene="";
        System.out.println("reading");
        while((i=fr.read())!=-1)  
        {
        	gene+=(char)i;
        }
        //System.out.println(gene);
        System.out.println("tokenizing");
        StringTokenizer st = new StringTokenizer(gene,"\n");
        int a=0;
        while (st.hasMoreTokens())
        {
        	StringTokenizer st1 = new StringTokenizer(st.nextToken()," ");
        	int k=0;
        	while (st1.hasMoreTokens())
        	{
        		if (k==0)
        		st1.nextToken();
        		arr[k][a]=st1.nextToken();
        		k++;
        		//System.out.println(st1.nextToken());
        	}
        	a++;
        }
        FileWriter fw=new FileWriter("ddd.txt");        
        for (int m=0;m<128;m++)
        {  
        	for (int n=0;n<47293;n++)
        	{
        		fw.write(arr[m][n]+" ");    
        	}
        	if (arr[m][47293].equals("luminal"))
        		fw.write("1");
        	else
        		fw.write("0");
        	fw.write("\n");    
        }  
        fr.close(); 
        fw.close();
	}

}
