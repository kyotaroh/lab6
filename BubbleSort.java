import java.util.ArrayList;

public class BubbleSort {
	static void bubbleSort(ArrayList<Double> arrayToBeSorted) {
		int n = arrayToBeSorted.size();
		Double temp = 0.0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arrayToBeSorted.get(j - 1) > arrayToBeSorted.get(j)) {
					// swap elements
					temp = arrayToBeSorted.get(j - 1);
					arrayToBeSorted.set(j - 1, arrayToBeSorted.get(j));
					arrayToBeSorted.set(j, temp);
				}

			}
		}

	}

	public static void main(String[] args) {
		ArrayList<Double> ArrayToBeSorted = new ArrayList<Double>();
		int n = 10000000;
		for (int i = 0; i < n; ++i) {
			ArrayToBeSorted.add(i, Math.random());
		}
		long time1 = System.nanoTime();
		bubbleSort(ArrayToBeSorted);// sorting array elements using bubble sort
		long elapsed = System.nanoTime() - time1;
		System.out.println("Bubble Sort");
		System.out.println("time: "+elapsed);
		for (int i = 0; i < n - 1; ++i) {
//			System.out.println(ArrayToBeSorted.get(i));
			if (ArrayToBeSorted.get(i) >= ArrayToBeSorted.get(i + 1)) {
				System.out.println("Array out of order.");
				 break;
			}
		}

	}
}