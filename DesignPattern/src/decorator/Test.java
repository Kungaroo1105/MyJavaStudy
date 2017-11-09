package decorator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//测试类，看一下你就会发现，跟java的I/O操作有多么相似  
public class Test {  
public static void main(String[] args) {  
    Human person = new Person();  
    Decorator decorator = new Decorator_two(new Decorator_first(  
            new Decorator_zero(person)));  
    decorator.wearClothes();  
    decorator.walkToWhere();  
    
    //Java i/o操作
    try {  
        InputStream in = new FileInputStream(new File("c:\\seanApp\\test.txt"));  
        BufferedInputStream in1 = new BufferedInputStream(in);  
        LineNumberInputStream in2 = new LineNumberInputStream(in1);  

        int result = in2.read();  
        while(result != '\n'){  
            result = in2.read();  
        }  
        System.out.println(in2.getLineNumber());//2  
        in2.close();  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
    
    try {
		FileWriter fw= new FileWriter(new File("c:\\seanApp\\test.txt"));
		BufferedWriter bw= new BufferedWriter(fw);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    
}  
}  