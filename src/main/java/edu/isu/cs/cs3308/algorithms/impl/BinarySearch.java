package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 3: IterativeBinarySearch(A, t)
 *
 * @author Aaron Harvey
 */
public class BinarySearch implements ArraySearch {
	/**
	 * Search through the array using a binary path
	 * It starts at the middle and shrinks the search size
	 * depending on if the item is larger or smaller than the
	 * current search index value, and keeps searching until
	 * the only item index is left, or else returns -1
	 *
	 * I reviewed this page again to see how to do the compare on generics
	 * https://www.javatpoint.com/java-string-compareto
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @return The index of the item in the array, or -1 if not found or
	 * the array/item is null or the array is empty
	 */
	@Override
	public <E extends Comparable> int search(E[] array, E item) {
		if (item != null && array != null && array.length > 0) {
			int low = 0;
			int high = array.length - 1;

			while (low <= high) {
				int index = (low + high) / 2;
				if (array[index] == item) {
					return index;
				} else if (array[index].compareTo(item) > 0) {
					high = index - 1;
				} else {
					low = index + 1;
				}
			}
		}
		return -1;
	}
}
