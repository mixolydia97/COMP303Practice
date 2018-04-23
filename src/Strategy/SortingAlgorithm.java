package Strategy;

/**
 * This is the abstract sorting algorithm strategy. 
 * I'm not sure what to make as Comparable's generic type,
 * I was just trying to do this quickly.
 * @author sarah
 *
 */
public abstract class SortingAlgorithm {
	public abstract Comparable[] sort(Comparable[] list);
	
	public void swap(Comparable[] list, int index1, int index2) {
		Comparable temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}

}
