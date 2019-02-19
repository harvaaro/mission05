package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 2: RecursiveLinearSearch(A, t)
 *
 * @author Aaron Harvey
 */
public class RecursiveLinearSearch implements ArraySearch {
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
			return recSearch(array, item, 0);
		}
		return -1;
	}

	/**
	 * Search through the array recursively using a linear path
	 * It starts at the beginning of the array and
	 * searches until it reaches the end
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @param index Where to start the search in the array
	 * @return The index of the item in the array, or -1 if not found
	 */
	private <E extends Comparable> int recSearch(E[] array, E item, int index) {
		if (index >= array.length) {
			return -1;
		}
		else if (array[index] == item) {
			return index;
		}
		else {
			return recSearch(array, item, index+1);
		}
	}
}
