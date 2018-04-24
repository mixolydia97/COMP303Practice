package Strategy;

/**
 * This is the abstract sorting algorithm strategy. Comparable is 
 * and interface but we still write that T extends it. In this case 
 * the interface Comparable also has T's type, I guess? 
 * @author sarah
 *
 */
public abstract class SortingAlgorithm {
	public abstract <T extends Comparable<T>> T[] sort(T[] list);
	
	public <T> void swap(Comparable<T>[] list, int index1, int index2) {
		Comparable<T> temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}

}
