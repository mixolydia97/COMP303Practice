package Strategy;

public class BubbleSort extends SortingAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] list) {
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list.length - 1; j++) {
				if(list[j].compareTo(list[j+1]) > 0) {
					swap(list, j, j+1);
				}
			}
		}
		
		return list;
	}

}
