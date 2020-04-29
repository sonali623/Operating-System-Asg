
import java.util.*;

public class OptimalAlgo
{
    public static int addKeyAndValue(int[] arr, int i){
        int next_occ = 0;
        
           for(int j=i+1;j<arr.length;j++){
               if(arr[j] == arr[i]){
                   next_occ = j;
                   break;
                }
            } 
        
        
        return next_occ;
        //v.put(arr[i],next_occ);
        //System.out.println("hello addKeyandValue");
    }
    
    public static int getMaxKey(Map<Integer,Integer> v, int j){
        int maxKey = 0;
        int maxValue = 0;
        
        for(int i : v.keySet())
        {
            if(v.get(i) == 0)   return i;
            if(v.get(i) > maxValue)
            {
                maxKey = i;
                maxValue = v.get(i);
            }
        }
        //System.out.println("get max key " + maxKey);
        
        return maxKey;
    }
    
    public static void main(String args[]){
        System.out.println("OPTIMAL PAGE REPLACEMENT POLICY");
        Scanner sc= new Scanner(System.in);
        //Queue<Integer> q = new LinkedList<Integer>();
        //LinkedList<Integer> ll = new LinkedList<Integer>();

        System.out.println("Enter the size of the page slots");
        int size_of_page_slots = 4;

        int[] arr = {1,2,3,4,1,2,5,1,2,3,4,5};
        //int[] arr = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        Map<Integer,Integer> v = new Hashtable<Integer,Integer>(size_of_page_slots);
        int n = arr.length;
        int count =0 ;

        //size if string

        
        for(int i=0;i<n;i++){
            Integer obj = new Integer(arr[i]);
            //System.out.println("sfgfud");
            
            if(v.size() < size_of_page_slots && !v.containsKey(obj)){
                int next_occ = addKeyAndValue(arr,i);
                v.put(arr[i],next_occ);
                System.out.println("i: "+ i + " arr[i]: "+arr[i]);
                System.out.println(v);
                System.out.println();
                count++;
            }
            else if(v.size() == size_of_page_slots && !v.containsKey(obj)){
                int key = getMaxKey(v,i);
                Integer r = new Integer(key);
                v.remove(r);
                int next_occ = addKeyAndValue(arr,i);
                v.put(arr[i],next_occ);
                System.out.print("i: "+ i + "arr[i]: "+arr[i]);
                System.out.println(v);
                System.out.println();
                count++;
            }else if(v.containsKey(obj)){
                int next_occ = addKeyAndValue(arr,i);
                v.replace(arr[i],next_occ);
            }

        }
        
        System.out.println("No. of page faults: "+count);
    }
}
