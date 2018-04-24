package Strategy;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		Integer[] list = {5, 4, 6, 3, 90, 1};
		Integer[] sortedList;
		ArrayList<SortingAlgorithm> algorithms = new ArrayList<SortingAlgorithm>();
		
		algorithms.add(new SelectionSort());
		algorithms.add(new BubbleSort());
		
		for(SortingAlgorithm algorithm : algorithms) {
			sortedList = algorithm.sort(list.clone());
			System.out.println(Arrays.toString(sortedList));
		}
		
	}

}
