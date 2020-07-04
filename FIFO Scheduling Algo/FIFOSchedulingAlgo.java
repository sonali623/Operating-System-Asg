import java.util.*;

public class FIFOSchedulingAlgo
{
    public static void main(String args[]){
        
        Scanner sc= new Scanner(System.in);
        System.out.println("FIFO CPU SCHEDULING");
        System.out.println("Enter no of process");
        int n= sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        System.out.println("Enter the burst time of each process");
        for(int i=0;i<n;i++){
            int s = 1+i;
            System.out.println("Burst time of process " + s + ": "); 
            arr[i] = sc.nextInt();
            
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                sum = sum + arr[j];
            }
        }
        System.out.println("Waiting time: " + sum);
        double avg = sum/n;
        System.out.println("Average waiting time: " + avg);
    }
    
    
}
