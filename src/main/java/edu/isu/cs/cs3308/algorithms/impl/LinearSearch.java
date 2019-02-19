package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 1: IterativeLinearSearch(A, t)
 *
 * @author Aaron Harvey
 */
public class LinearSearch implements ArraySearch {
	/**
	 * Search through the array using a linear path
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @return The index of the item in the array, or -1 if not found or
	 * the array/item is null or the array is empty
	 */
	@Override
	public <E extends Comparable> int search(E[] array, E item) {
		if (item != null && array != null && array.length > 0) {
			int arrSize = array.length;
			for (int i = 0; i < arrSize; i++) {
				if (array[i] == item) {
					return i;
				}
			}
		}
		return -1;
	}
}
