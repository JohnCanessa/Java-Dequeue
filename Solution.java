import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * 
 */
public class Solution {

	/*
	 * 
	 */
	static int maxUnique(int n, int m, Deque<Integer> deque) {
		
		int globalMax = 0;
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
//		// ???? ????
//		int first 	= deque.getFirst();
//		int last 	= deque.getLast();
//		System.out.println("first: " + first + " last: " + last);
//		System.out.println("deque.size: " + deque.size());
		
		// **** set deque first iterator ****
		Iterator<Integer> dqfit = deque.iterator();
		
		// **** set deque second iterator ****
		Iterator<Integer> dqsit = deque.iterator();
		
		// **** load the initial hash map with m elements ****
		for (int i = 0; i < m; i++) {
			
			// **** get the next key from the queue ****
			int key = (int)dqfit.next();

			// **** load hash map ****
			if (hm.containsKey(key)) {
				int count = hm.get(key);
				hm.put(key, ++count);
			} else {
				hm.put(key, 1);
			}
		}
//		System.out.println("hm: " + hm.toString());
//		System.out.println();
		
		// **** loop processing the queue ****
		for (int i = 0; i < deque.size() - m + 1; i++) {
			
//			System.out.println("i: " + i);

			// **** get the current max ****
			int max = hm.size();
//			System.out.println("max: " + max);

			// **** update the global max ****
			if (max > globalMax)
				globalMax = max;
//			System.out.println("globalMax: " + globalMax);

			// **** check if we are done ****
			if (i >= deque.size() - m)
				continue;

			// **** get the next key from the queue ****
			int key = (int)dqsit.next();
//			System.out.println("key: " + key);

			// **** remove this key,value entry from the hash map ****
			int value = hm.get(key);
			if (value == 1) {
				hm.remove(key);
			} else {
				hm.put(key, --value);
			}
//			System.out.println("hm: " + hm.toString());

			// **** get the next key from the queue ****
			key = (int)dqfit.next();
//			System.out.println("key: " + key);
			
			// **** add this key to the hash map ****
			if (hm.containsKey(key)) {
				int count = hm.get(key);
				hm.put(key, ++count);
			} else {
				hm.put(key, 1);
			}
//			System.out.println("hm: " + hm.toString() + "\n");
		}

		// **** ****
		return globalMax;
	}
	
	
	/*
	 * 
	 */
	public static void main(String[] args) {

		 Scanner in = new Scanner(System.in);
         Deque<Integer> deque = new ArrayDeque<Integer>();
         
         int n = in.nextInt();
         int m = in.nextInt();

//         System.out.println("n: " + n + " m: " + m);
         
         // **** ****
         for (int i = 0; i < n; i++) {
        	 int num = in.nextInt();
        	 
//        	 System.out.println("num: " + num);
        	 
        	 deque.addLast(num);
         }
         
//         System.out.println("deque: " + deque.toString());
         
         // **** ****
         System.out.println(maxUnique(n, m, deque));
         
         // **** ****
         in.close();
	}

}
