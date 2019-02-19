package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 1: IterativeLinearSearch(A, t)
 *
 * @author Aaron Harvey
 */
public class LinearSearch implements ArraySearch {
	/**
	 * Generic array search method.
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @return The index of the provided item in the array. Returns -1 if any of
	 * the following conditions are met:
	 * <ul>
	 * <li>The provided array is null</li>
	 * <li>The provided array is empty</li>
	 * <li>The provided item is null</li>
	 * <li>The provided array does not contain the item</li>
	 * </ul>
	 */
	@Override
	public <E extends Comparable> int search(E[] array, E item) {
		if (item != null && array != null && array.length != 0) {
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
