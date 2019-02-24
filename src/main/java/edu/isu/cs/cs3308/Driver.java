package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.algorithms.ArraySearch;
import edu.isu.cs.cs3308.algorithms.impl.BinarySearch;
import edu.isu.cs.cs3308.algorithms.impl.LinearSearch;
import edu.isu.cs.cs3308.algorithms.impl.RecursiveBinarySearch;
import edu.isu.cs.cs3308.algorithms.impl.RecursiveLinearSearch;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;

/**
 * Driver class for the experimental simulator.
 * @author Isaac Griffith
 * @author Aaron Harvey
 */
public class Driver {

	/**
	 * Tests each of the 4 algorithms with a random int array
	 * Saves the avg time it takes to complete the search
	 * Then reports the tally of all the average times for
	 * each of the algorithms into a csv.
	 *
	 * @param args string of arguments
	 */
	public static void main(String args[]) {
		// do the simulation using generateRandomArray()
        int numRange = 2000;
        ArraySearch[] searchAlgo = {
                new LinearSearch()
                ,new RecursiveLinearSearch()
                ,new BinarySearch()
                ,new RecursiveBinarySearch()
        };
        int numAlgos = searchAlgo.length;
        long[][] timeTaken = new long[numAlgos][];
        for (int i = 0; i < numAlgos; i++) {
            timeTaken[i] = new long[numRange];
        }
		long[] avgTime;

        for (int set = 0; set < numRange; set++) {
            Integer[] randNumList = generateRandomArray(numRange);
            Random numFind = new Random();
			avgTime = new long[numAlgos];

            for (int rep = 0; rep < numRange; rep++) {
                int searchFor = numFind.nextInt(numRange);
                for (int type = 0; type < numAlgos; type++) {
                    avgTime[type] = timedSearch(searchAlgo[type],avgTime[type],randNumList,searchFor);
                }
            }

            for (int type = 0; type < numAlgos; type++) {
                timeTaken[type][set] = avgTime[type] / numRange;
            }
        }

		// report the results using report;
        report(timeTaken[0],timeTaken[1],timeTaken[2],timeTaken[3],0,1);
	}

	/**
	 * Runs the search action on the assigned algorithm, while
	 * keeping track of how long that search took in nanoseconds
	 *
	 * @param searchAlgo The search algorithm to use
	 * @param avgTime The average time taken so far
	 * @param randList A random list of integers
	 * @param numFind Which number to find
	 * @return The average time taken + the avgtime so far
	 */
	private static long timedSearch(ArraySearch searchAlgo, long avgTime, Integer[] randList, int numFind) {
	    long timeStart = System.nanoTime();
	    searchAlgo.search(randList,numFind);
	    long timeEnd = System.nanoTime();
	    return (avgTime + (timeEnd - timeStart));
    }

	/**
	 * Generates a random ordered array of integers of the provided size
	 *
	 * @param size Size of the random array
	 * @return An array of the provided size of random numbers in ascending
	 * order.
	 */
	public static Integer[] generateRandomArray(int size) {
		Random rand = new Random();

		Integer[] array = new Integer[size];

		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(2000);
		}

		Arrays.sort(array);
		return array;
	}

	/**
	 * Generates the output to both a Comma Separated Values file called
	 * "results.csv" and to the screen.
	 *
	 * @param iterLinTimes Array of average values for the Iterative Linear
	 * Search
	 * @param recLinTimes Array of average values for the Recursive Linear
	 * Search
	 * @param iterBinTimes Array of average values for the Iterative Binary
	 * Search
	 * @param recBinTimes Array of average values for the Recursive Binary
	 * Search
	 * @param startIncrement Start increment for array sizes
	 * @param increment Increment of array sizes.
	 */
	private static void report(long[] iterLinTimes, long[] recLinTimes, long[] iterBinTimes, long[] recBinTimes, int startIncrement, int increment) {
		StringBuilder file = new StringBuilder();
		StringBuilder screen = new StringBuilder();

		screen.append(String.format("N    IterLin\tRecLin\tIterBin\tRecBin%s", System.lineSeparator()));
		file.append(String.format("N,IterLin,RecLin,IterBin,RecBin%s", System.lineSeparator()));

		for (int i = 0; i < iterLinTimes.length; i++) {
			screen.append(String.format("%d %d\t%d\t%d\t%d%s", startIncrement + (i * increment), iterLinTimes[i], recLinTimes[i], iterBinTimes[i], recBinTimes[i], System.lineSeparator()
			));
			file.append(String.format("%d,%d,%d,%d,%d%s", startIncrement + (i * increment), iterLinTimes[i], recLinTimes[i], iterBinTimes[i], recBinTimes[i], System.lineSeparator()
			));
		}

		System.out.println(screen.toString());

		Path p = Paths.get("results.csv");
		try {
			Files.deleteIfExists(p);
		} catch (IOException e) {

		}

		try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(p, StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {
			pw.println(file.toString());
		} catch (IOException e) {

		}
	}
}
