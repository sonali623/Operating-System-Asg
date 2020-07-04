
import java.util.*;

public class LRUAlgo
{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of string");
        int n = sc.nextInt();
        System.out.println("Enter the string");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the size of page slots");
        int size_of_page_slots = sc.nextInt();
        int count = 0;
        LinkedList<Integer> ll = new LinkedList<Integer>();
        
        for(int i=0;i<arr.length;i++){
            if((ll.size() < size_of_page_slots) && (!ll.contains(arr[i]))){
                ll.add(arr[i]);
                count++;
            }
            else if((ll.size() == size_of_page_slots) && (!ll.contains(arr[i]))){
                ll.add(arr[i]);
                ll.remove();
                count++;
                
            }
            else if(ll.contains(arr[i])){
                Integer obj = new Integer(arr[i]);
                ll.remove(obj);
                ll.add(arr[i]);
            }
        }
        System.out.println("No. of page faults: "+count);
        
    }

}
