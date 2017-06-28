public class Merge {                                        // Merge class with take care of whole things
   
    double[] array;                                         // array to store the values global to class to be accessful to every method
    double[] tempArray;                                     // tempArray to store values and compare
    int length;                                             // length will be usefull in setting length for tempArray
    public void sort(double ArrayToBeSorted[]) {            // every thing starts here....in sort method
        this.array = ArrayToBeSorted;                       // defining arrays globally
        this.length = ArrayToBeSorted.length;
        this.tempArray = new double[length];
        MergeSort(0, length - 1);                           // calling mergeSort method
    }
    public static void check(double [] ArrayToBeSorted){    // check function will be useful in checking whether the array is sorted or not
        for(int i=0;i<10000-1;i++){
            if(ArrayToBeSorted[i]>ArrayToBeSorted[i+1]){    // you call understand every thing in this function
                System.out.println("not sorted.");
                return;
            }
        }
        System.out.println("sorted");
        return;
    }
    public void MergeSort(int first_index, int last_index) {    //mersort function
       
        if (first_index < last_index) {                             //if array has more than one element
            int mid = first_index + (last_index - first_index) / 2; // calculate mid
              
            MergeSort(first_index, mid);                            // divide and sort left part of array
          
            MergeSort(mid + 1, last_index);                         // divide and sort right part of array
          
            mergeParts(first_index, mid, last_index);               // merge two parts
        }
    }

    public void mergeParts(int first_index, int mid, int last_index) { // mergeParts method merge the left and right parts
                                                                        // logic of merge sort will be here
        for (int i = first_index; i <= last_index; i++) {               // first store the array in temp array
            tempArray[i] = array[i];
        }                                                               //take the required variables
        int i = first_index;
        int j = mid + 1;
        int k = first_index;
        while (i <= mid && j <= last_index) {                          // if left and right arrays are still left with same number of elements
            if (tempArray[i] <= tempArray[j]) {                        // left array element is smaller than right array element
                array[k] = tempArray[i];                               // keep that as array element
                i++;                                                    //increase left array index.
            } else {                                                    // else right array element is smaller than left array element
                array[k] = tempArray[j];                                // keep that as array element
                j++;                                                   //increase right array index.
            }
            k++;                                                       // increase the array index after every comparison.
        }
        while (i <= mid) {                                             // elements are still left
            array[k] = tempArray[i];
            k++;
            i++;                                                        // store them in array
        }
    }

    public static void main(String args[]){                               
       
    	
    	int n = 10000000;
        double [] ArrayToBeSorted=new double [n];                   // declaring array with 10000 double values
        for (int i = 0; i < n; ++i)
        {
            ArrayToBeSorted[i] = Math.random();                   // taking radom values and storing them
        }
//        check(ArrayToBeSorted);                                         // checking them whether they are sorted or not

        Merge mms = new Merge();                                        // creating instance for Merge class
		long time1 = System.nanoTime();
        mms.sort(ArrayToBeSorted);                                      // passing input array as parameter.
		long elapsed = System.nanoTime() - time1;
//        for(double i:ArrayToBeSorted){                                  // printing elements in array after sorting
//            System.out.println(i);
//        }
//        check(ArrayToBeSorted);
		System.out.println(elapsed);
		
		for (int i = 0; i < n  - 1; ++i) {
//			System.out.println(ArrayToBeSorted.get(i));
			if (ArrayToBeSorted[i] >= ArrayToBeSorted[i+1]) {
				System.out.println("Array out of order.");
				 break;
			}
		}
    }
}