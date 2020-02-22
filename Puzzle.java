import java.util.*;
public class Puzzle
{
    static int[][] match = {{1,2,3},{4,5,6},{7,8,0}}; 
    static void printMatrix(int[][] A)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print("| "+A[i][j]+" |");
            }
            System.out.println();
        }
	findMatch(A);
    }
    static void findMatch(int[][] A)
    {
	for(int i=0;i<3;i++)
	{
	    for(int j=0;j<3;j++)
	    {
		if(A[i][j] != match[i][j])
		    return;
	    }
	}
	System.out.println("******* You Won The Game *******");
	System.exit(0);
    }
    static void findZeroIndexPosition(int[][] A)
    {
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(A[i][j] == 0)
                {
                   findAdjecent(A,i,j);
                   return;
                }
            }
        }
    }
    static boolean swap1(int[][] A,int[] arr,int a,int b,int move)
    {
	boolean flag = false;
	for(int i=0;i<4;i++)
	{
	    if(arr[i] == move)
	       flag = true;
	}
	if(flag == false)
	    return true;
        for(int i=0;i<3;i++)
	{
	    for(int j=0;j<3;j++)
            {
               if(A[i][j] == move)
               {
                      int temp = A[i][j];
                      A[i][j] = A[a][b];
                      A[a][b] =temp;
                      printMatrix(A);
		      return false;
 		}
            }
	}
	return false;
    }
    static void findAdjecent(int[][] A,int i,int j)
    {
	int[] arr = new int[4];
        if(i-1 >=0)
	    arr[0] = A[i-1][j];
        if(i < 2)
	    arr[1] = A[i+1][j];
	if(j-1 >=0)
	    arr[2] = A[i][j-1];
	if(j < 2)
	    arr[3] = A[i][j+1];
        Scanner scan = new Scanner(System.in);
	boolean flag;
	do{
            System.out.print("\nEnter your move:");
            int move = scan.nextInt();
            flag = swap1(A,arr,i,j,move);
	  }while(flag);
    }
    public static void main(String[] args) 
    {	
	int[][] A ={ { 1,2,3 },{ 4,5,6 },{ 0,7,8 } };
	printMatrix(A);
	boolean flag = true;
	while(flag)
	{
            findZeroIndexPosition(A);
	}
    }
}
