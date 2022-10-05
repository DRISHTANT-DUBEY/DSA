import java.lang.*;
import java.util.Arrays;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
public class quick_sort_demo {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testNull() {
        Quicksort sorter = new Quicksort();
        sorter.sort(null);
    }

    @Test
    public void testEmpty() {
        Quicksort sorter = new Quicksort();
        sorter.sort(new int[0]);
    }

    @Test
    public void testSimpleElement() {
        Quicksort sorter = new Quicksort();
        int[] test = new int[1];
        test[0] = 5;
        sorter.sort(test);
    }

    @Test
    public void testSpecial() {
        Quicksort sorter = new Quicksort();
        int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        sorter.sort(test);
        if (!validate(test)) {
            fail("Should not happen");
        }
        printResult(test);
    }

    @Test
    public void testQuickSort() {
        for (Integer i : numbers) {
            System.out.println(i + " ");
        }
        long startTime = System.currentTimeMillis();

        Quicksort sorter = new Quicksort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }

    private boolean validate(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] unsorted = {3, 0, 9, 8};
        System.out.println("Unsorted array :" + Arrays.toString(unsorted));

        Quicksort algorithm = new Quicksort();

        // sorting integer array using quicksort algorithm
        algorithm.sort(unsorted);

        // printing sorted array
        System.out.println("Sorted array :" + Arrays.toString(unsorted));
    }
}
class Quicksort {
    private int input[];
    private int length;
    public void sort (int[] numbers){
        if(numbers == null || numbers.length==0){
            return;
        }
        this.input = numbers;
        length = numbers.length;
        quickSort(0, length-1);
    }
    private void quickSort(int low, int high){
        int i = low;
        int j = high;

        int pivot = input[low + (high-low)/2];
        while (input[i]<pivot){
            i++;
        }
        while(input[i]>pivot){
            j--;
        }
        if (i <= j) {
            swap(i, j);
            // move index to next position on both sides
            i++;
            j--;
        }
        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }

    }
    private void swap(int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}