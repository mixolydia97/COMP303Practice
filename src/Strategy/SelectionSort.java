package Strategy;

public class SelectionSort extends SortingAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] list) {
		int minIndex;
		
		for(int i = 0; i < list.length; i++) {
			minIndex = i;
			
			for(int j = i+1; j < list.length; j++) {
				
				/**
				 * compareTo return a negative number if list[j] is 
				 * less than list[minIndex]
				 */
				if(list[j].compareTo(list[minIndex]) < 0) {
					minIndex = j;
				}
			}
			swap(list, minIndex, i);
		}
		
		return list;
	}
}
