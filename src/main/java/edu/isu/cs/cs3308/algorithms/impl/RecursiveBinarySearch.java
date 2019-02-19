package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 4: RecursiveBinarySearch(A, t)
 *
 * @author Aaron Harvey
 */
public class RecursiveBinarySearch implements ArraySearch {
	/**
	 * Calls the recursive search and starts at index 0
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @return The index of the item in the array, or -1 if not found or
	 * the array/item is null or the array is empty
	 */
	@Override
	public <E extends Comparable> int search(E[] array, E item) {
		if (item != null && array != null && array.length > 0) {
			return recSearch(array, item, 0, array.length-1);
		}
		return -1;
	}

	/**
	 * Search through the array recursively using a binary path
	 * It starts at the middle and shrinks the search size
	 * depending on if the item is larger or smaller than the
	 * current search index value, and keeps searching until
	 * the only item index is left, or else returns -1
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @param low The lower bound index of the array to search
	 * @param high The upper bound index of the array to search
	 * @return The index of the item in the array, or -1 if not found
	 */
	private <E extends Comparable> int recSearch(E[] array, E item, int low, int high) {
		int index = (low + high) / 2;
		if (low >= high) {
			return -1;
		}
		if (array[index].compareTo(item) == 0) {
			return index;
		}
		if (array[index].compareTo(item) > 0) {
			return recSearch(array, item, low, index - 1);
		}
		else {
			return recSearch(array, item, index + 1, high);
		}
	}
}
