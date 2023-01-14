package dbms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleDetect {
	
	
	int N=10;
	int [][] adjMat= new int[N][N];
	int [] color= new int[N+1];
	int [] prev= new int[N+1];
	boolean flag=false;
	public void createGraph(ArrayList<String> input)
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				adjMat[i][j]=0;
			}
		}
		
	    for (int i=0; i<input.size();i++)
	    {
	        for (int j=i+1;j<input.size();j++)
	        {
	            	if(input.get(i).charAt(3)==input.get(j).charAt(3))
	            {
	                if ((input.get(i).charAt(0) == 'R' && input.get(j).charAt(0)== 'W') || (input.get(i).charAt(0) == 'W' && (input.get(j).charAt(0) == 'R' || input.get(j).charAt(0) == 'W')))
	                {
	                    if (input.get(i).charAt(1) != input.get(j).charAt(1))
	                    {
	                    	int s1=Integer.parseInt(String.valueOf(input.get(i).charAt(1)));
	                    	int s2=Integer.parseInt(String.valueOf(input.get(j).charAt(1)));
	                        adjMat[s1][s2] = 1;
	                    }
	                }
	            }
	        }
	    }
	}

	public boolean DFS()
	{
		boolean flag1=false;
		 for (int u=0;u<N;u++)
		    {
		        color[u]=0;
		        prev[u]=-1;
		    }
		    for (int u=0;u<N;u++)
		    {

		        if (color[u]==0)
		        {
		           flag1=visited(adjMat,u);
		        }
		    }
		return flag1;
	}
	public boolean visited(int [][] adjMat,int u)
	{
		color[u]=1;
	    for (int v=0;v<N;v++)
	    {

	        if (adjMat[u][v]==1 && color[v]==1)
	        {
	            flag = true;
	        }

	        else if (adjMat[u][v]==1 && color[v]==2)
	        {
	        }

	        else if (adjMat[u][v]==1 && color[v]==0)
	        {
	            prev[v]=u;
	            visited(adjMat,v);
	        }
	    }
	    color[u]=2;
	    return flag;
	}
	
}
	 


