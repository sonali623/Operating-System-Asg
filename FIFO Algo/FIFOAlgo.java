import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class FIFOAlgo
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		System.out.println("IMPLEMENTATION OF FIFO PAGE REPLACEMENT POLICY");
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList();
		
		System.out.println("Enter the size of queue");
		int size_of_page_slot = sc.nextInt();
		
		//int[] arr = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		//int[] arr = {1,2,3,4,1,2,5,1,2,3,4,5};
		System.out.println("Enter the size of the string.");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the string");
		for(int i =0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		
		int count =0 ;
		
		for(int i=0;i<arr.length;i++){
			
			if((q.size() == size_of_page_slot) && (!q.contains(arr[i]))){
				q.remove();
				q.offer(arr[i]);
				//System.out.println("arr ele: "+arr[i]);
				count++;
			}
			if(q.isEmpty()){
				q.offer(arr[i]);
				//System.out.println("arr ele: "+arr[i]);
				count++;
			}
			
			if(!q.contains(arr[i])){
				q.offer(arr[i]);
				//System.out.println("arr ele: "+arr[i]);
				count++;
			}
		}
		System.out.println("Total number of page faults: "+count);
 	}
}