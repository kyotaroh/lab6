
public class Insert {
    public static void main(String a[]){
    	int n = 10000000;
        double [] ArrayToBeSorted=new double [n];                   // declaring array with 10000 double values
        for (int i = 0; i < n; ++i)
        {
            ArrayToBeSorted[i] = Math.random();                   // taking radom values and storing them
        }                                     // creating instance for Merge class
		long time1 = System.nanoTime();
        double[] arr2 = doInsertionSort(ArrayToBeSorted);                                 // passing input array as parameter.
		long elapsed = System.nanoTime() - time1;
		System.out.println(elapsed);
		for (int i = 0; i < n  - 1; ++i) {
//			System.out.println(ArrayToBeSorted[i]);
			if (ArrayToBeSorted[i] >= ArrayToBeSorted[i+1]) {
				System.out.println("Array out of order.");
				 break;
			}
		}
    }
     
    public static double[] doInsertionSort(double[] arrayToBeSorted){
         
        double temp;
        for (int i = 1; i < arrayToBeSorted.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arrayToBeSorted[j] < arrayToBeSorted[j-1]){
                    temp = arrayToBeSorted[j];
                    arrayToBeSorted[j] = arrayToBeSorted[j-1];
                    arrayToBeSorted[j-1] = temp;
                }
            }
        }
        return arrayToBeSorted;
    }
}