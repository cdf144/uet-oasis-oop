/******************************************************************************
 *  Compilation:  javac BinarySearch.java
 *  Execution:    java BinarySearch allowlist.txt < input.txt
 *  Dependencies: In.java StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/11model/tinyAllowlist.txt
 *                https://algs4.cs.princeton.edu/11model/tinyText.txt
 *                https://algs4.cs.princeton.edu/11model/largeAllowlist.txt
 *                https://algs4.cs.princeton.edu/11model/largeText.txt
 * <p>
 *  % java BinarySearch tinyAllowlist.txt < tinyText.txt
 *  50
 *  99
 *  13
 * <p>
 *  % java BinarySearch largeAllowlist.txt < largeText.txt | more
 *  499569
 *  984875
 *  295754
 *  207807
 *  140925
 *  161828
 *  [367,966 total values]
 *
 ******************************************************************************/

package edu.princeton.cs.algs4;

import java.util.Arrays;

/**
 *  The {@code BinarySearch} class provides a static method for binary
 *  searching for an integer in a sorted array of integers.
 *  <p>
 *  The <em>indexOf</em> operations takes logarithmic time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class BinarySearch {

  /**
   * This class should not be instantiated.
   */
  private BinarySearch() {
  }

  /**
   * Returns the index of the specified key in the specified array.
   *
   * @param a   the array of integers, must be sorted in ascending order
   * @param key the search key
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   */
  public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      // Key is in a[lo...hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  /**
   * Returns the index of the specified key in the specified array.
   * This function is poorly named because it does not give the <em>rank</em>
   * if the array has duplicate keys or if the key is not in the array.
   *
   * @param key the search key
   * @param a   the array of integers, must be sorted in ascending order
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   * @deprecated Replaced by {@link #indexOf(int[], int)}.
   */
  @Deprecated
  public static int rank(int key, int[] a) {
    return indexOf(a, key);
  }
}