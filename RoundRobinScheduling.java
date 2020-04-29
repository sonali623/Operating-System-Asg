import java.util.*;

public class RoundRobinScheduling
{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("ROUND-ROBIN CPU SCHEDLUING");
        
        System.out.println("Enter the no. of processes");
        int n = sc.nextInt();
        
        System.out.println("Enter the burst time of each process in millisecondes");
        //Queue<Integer> q = new Queue<Integer>();
        int[] burst_time = new int[n];
        int[] waiting_time = new int[n];

        for(int i=0;i<n;i++){
            burst_time[i] = sc.nextInt();
            waiting_time[i] = 0;
        }
        
        System.out.println("Enter the time quantum");
        int time_q = sc.nextInt();
        
        boolean flag = true;
        while(flag){
            //System.out.println(flag);
            for(int i=0;i<n;i++){
                if(burst_time[i] > time_q){
                    burst_time[i] = burst_time[i] - time_q;
                    //System.out.println(flag);
                    //System.out.println(burst_time);
                    for(int j=0;j<n;j++){
                        //if(burst_time[j]!=0){
                        //  waiting_time[j] += time_q;
                        //}
                        //System.out.println(burst_time[j]);
                        if(j!=i && burst_time[j] != 0){
                            waiting_time[j] += time_q;
                        }
                    }
                }else{
                    
                    //burst_time[i] = 0;
                    for(int j=0;j<n;j++){
                        if(j!=i && burst_time[j] != 0){
                            waiting_time[j] += burst_time[i];
                        }
                    }
                    burst_time[i] = 0;
                } 
            }
            //for(int a=0;a<n;a++){
            //  if(burst_time!=0){
            //      flag= flase;
            //  }    
            //}
            int check = 0;
            for(int a=0;a<n;a++){
                check = check + burst_time[a];
            }
            if(check == 0){ 
                flag = false;
            }
        }
        
        double avg_wt=0;
        for(int i=0;i<n;i++){
            avg_wt += waiting_time[i];
        }
        avg_wt = avg_wt/n;
        System.out.println(avg_wt);
        
    }
}
