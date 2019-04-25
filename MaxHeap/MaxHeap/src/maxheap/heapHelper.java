package maxheap;

import java.util.Random;

/**
 *
 * @author Sam Brighton
 */
public class heapHelper {
    
        public static void main(String[] args) {

        // Tester method for MaxHeap Class
        int stuff[] = new int[25];
        Random rand = new Random();
        for (int i = 1; i < stuff.length; i++) {
            stuff[i] = rand.nextInt(100) + 1;
        }
        MaxHeap current = new MaxHeap(stuff);
        current.printMaxHeap();
        current.heapSort();
        current.printMaxHeap();
    }
}
