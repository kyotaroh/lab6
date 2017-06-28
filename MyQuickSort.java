
public class MyQuickSort {
	private double array[];
    private int length;
 
    public void sort(double[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        double pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
         int n = 10000000;
        MyQuickSort sorter = new MyQuickSort();
        double[] input = new double[n];
        for (int i = 0; i < n; ++i)
        {
            input[i] = Math.random();                   // taking radom values and storing them
        }                                // creating instance for Merge class
		long time1 = System.nanoTime();
        sorter.sort(input);                        // passing input array as parameter.
		long elapsed = System.nanoTime() - time1;

		System.out.println(elapsed);for (int i = 0; i < n  - 1; ++i) {
//			System.out.println(input[i]);
			if (input[i] >= input[i+1]) {
				System.out.println("Array out of order.");
				 break;
			}
		}
    }
}