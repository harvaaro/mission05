package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Algorithm 4: RecursiveBinarySearch(A, t)
 *
 * @author Aaron Harvey
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
	 * Calls the recursive search and starts at index 0
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @return The index of the item in the array, or -1 if not found or
	 * the array/item is null or the array is empty
	 */
	@Override
	public <E extends Comparable> int search(E[] array, E item) {
		return recSearch(array, item, 0);
	}

	/**
	 * Search through the array recursively using a binary path
	 *
	 * @param array Array to be search for the provided item
	 * @param item  Item to be found
	 * @param index Where to start the search in the array
	 * @return The index of the item in the array, or -1 if not found or
	 * the array/item is null or the array is empty
	 */
	private <E extends Comparable> int recSearch(E[] array, E item, int index) {
		if (item != null && array != null && array.length > 0) {

		}
		return -1;
	}
}
