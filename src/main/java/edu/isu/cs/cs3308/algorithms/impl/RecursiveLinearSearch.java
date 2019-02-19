package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 2: RecursiveLinearSearch(A, t)
 *
 * function LinearSearch(A, t)
 *     return recLinearSearch(A, t, 0)
 * end function
 *
 * function recLinearSearch(A, t, index)
 *    if index >= n then
 *        return -1
 *    else if A[index] = t then
 *        return index
 *    end if
 *    return recLinearSearch(A, t, index + 1)
 * end function
 */
public class RecursiveLinearSearch implements ArraySearch {
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
		return recSearch(array, item, 0);
	}

	private <E extends Comparable> int recSearch(E[] array, E item, int index) {
		if (item != null && array != null && array.length != 0) {
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
		return -1;
	}
}
