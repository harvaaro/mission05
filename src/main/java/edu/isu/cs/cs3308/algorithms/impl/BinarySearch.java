package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 3: IterativeBinarySearch(A, t)
 *
 * low = 0
 * high = n - 1
 * while low <= high do
 *    index = (low + high) / 2
 *    if t = A[index] then return index
 *    else if t < A[index] then
 *        high = index - 1
 *    else
 *        low = index + 1
 *    end if
 * end while
 * return -1
 */
public class BinarySearch implements ArraySearch {
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
		return 0;
	}
}
