package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 4: RecursiveBinarySearch(A, t)
 *
 * function BinarySearch(A, t)
 *    return recBinarySearch(A, t, 0, n-1)
 * end function
 *
 * function recBinarySearch(A, t, low, high)
 *     index = (low + high) / 2
 *     if low >= high then
 *         return -1
 *     end if
 *     if t = A[index] then
 *         return index
 *     end if
 *     if t < A[index] then
 *         return recBinarySearch(A, t, low, index - 1)
 *     else
 *         return recBinarySearch(A, t, index + 1, high)
 *     end if
 * end function
 */
public class RecursiveBinarySearch implements ArraySearch {
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
