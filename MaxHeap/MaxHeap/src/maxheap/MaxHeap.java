package maxheap;

/**
 *
 * @author sam brighton
 * 
 * Implementation of heaps in java.
 * IMPORTANT **** All heaps and functions associated with heaeps are ONE INDEXED.
 * 
 */
public class MaxHeap {

    private static int[] heap;
    private static int heapSize;

    // Constructor
    public MaxHeap(int[] init) {

        heapSize = init.length;
        heap = java.util.Arrays.copyOfRange(init, 0, heapSize - 1);
    }

    // Returns the ONE INDEXED location of the parent to the 'val' leaf
    private int parentOf(int val) {

        int par = val;
        if (par > (heapSize-1) || par <= 1) {
            return -1;
        } else {
            return (par / 2);
        }
    }

    // Returns the ONE INDEXED location of the left child of the 'val' leaf
    private int leftChildOf(int val) {

        int lef = val;
        if (2 * lef > (heapSize-1) || lef < 1) {
            return -1;
        } else {
            return (2 * lef);
        }
    }

    // Returns the ONE INDEXED location of the right child of the 'val' leaf
    private int rightChildOf(int val) {

        int right = val++;
        if (right < 1 || (2 * right) + 1 > (heapSize-1)) {
            return -1;
        } else {
            return (2 * right) + 1;
        }
    }

    // Prints the current heap
    public void printMaxHeap() {
        System.out.println(java.util.Arrays.toString(heap));
    }

    // MaxHeapify subroutine, fixes the heap at the location i
    private void maxHeapify(int i) {

        int largest;
        int hold;
        int left = leftChildOf(i);
        int right = rightChildOf(i);
        if (left != -1 && right != -1) {
            if ((left < (heapSize-1)) && (heap[left] > heap[i])) {
                largest = left;
            } else {
                largest = i;
            }
            if ((right < (heapSize-1)) && (heap[right] > heap[largest])) {
                largest = right;
            }
            if (largest != i) {
                hold = heap[i];                 // swap
                heap[i] = heap[largest];
                heap[largest] = hold;
                maxHeapify(largest);
            }
        }
    }
    
    // invokation of the maxHeapify from the bottom up to build the heap
    private void buildMaxHeap(){
        
        for(int i = heapSize-1; i > 0; i--)
            maxHeapify(i);
    }
    
    // heapSort
    public void heapSort(){
        
        int hold;
        System.out.println("Sorting...");
        buildMaxHeap();
        
        int backup = heapSize;
        for(int i = heapSize-2; i > 1; i--){
            hold = heap[1];                     // swap
            heap[1] = heap[i];
            heap[i] = hold;
            heapSize--;
            maxHeapify(1);
        }
    }
}
