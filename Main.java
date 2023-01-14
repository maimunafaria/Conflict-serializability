package dbms;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws Exception
    {	
		ArrayList<String> input = new ArrayList<String>();
		String serial;
		Scanner sc= new Scanner(System.in);
		serial =sc.nextLine();
		for(int i=0;i<serial.length()-4;i=i+5)
		{
			input.add(serial.substring(i, i+5));
		}
		CycleDetect c = new CycleDetect();
		c.createGraph(input);
		    if (c.DFS())
		    {
		    	System.out.println("Conflict serialization not possible");
		    }
		    else
		    {
		    	System.out.println("Conflict serialization possible");
		    }   
			//R1(A)R2(A)W2(A)R2(B)W1(A)R1(B)W1(B)W2(B)
			//R4(A)R2(A)R3(A)W1(B)W2(A)R3(B)W2(B)
    }
}
