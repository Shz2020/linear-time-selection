package io.github.thehappybug.Algorithms;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

/**
 * Algorithm to select n-th element from a list
 */
public class LinearTimeSelection {

	// The list to which this class's object is bound to
	private List<Integer> _list;

	/**
	 * Main program to select n-th element in an array
	 * @param args "Position" and "input filename" required as arguments to program
	 *             Input file should contain space separated integer numbers.
	 */
	public static void main(String[] args) {
		LinearTimeSelection selection;
		if(args.length < 2) {
			System.out.println("Usage: ./select <position> <filename>");
			return;
		}
		try {
			selection = new LinearTimeSelection(readFromFile(args[1]));
			System.out.println(selection.run(Integer.parseInt(args[0])));
		} catch (IOException e) {
			System.out.println("Failed to read from file.");
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid position passed as argument.");
		}
	}

	/**
	 * Create a selection algorithm bound to a list
	 * @param  list  List
	 */
	public LinearTimeSelection(List<Integer> list)
	{
		_list = list;
	}

	/**
	 * Read a space-separated integer list from file.
	 * @param  path        Path of file
	 * @return             Integer list
	 * @throws IOException Thrown when unable to open or read file
	 */
	private static List<Integer> readFromFile(String path) throws IOException
	{
		List<Integer> intList = new ArrayList<>();
		for (String line : Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8)) {
		    for (String part : line.split("\\s+")) {
		        Integer i = Integer.valueOf(part);
		        intList.add(i);
		    }
		}		
		return intList;	
	}

	/**
	 * Run the selection algorithm
	 * @param  order 					The position of element to find
	 * @return       					Element found
	 * @throws IllegalArgumentException If the position is out-of-bounds
	 */
	public int run(int order) throws IllegalArgumentException
	{
		if(order < 1 || order > _list.size())
			throw new IllegalArgumentException();
		return run(_list, order-1);
	}

	/**
	 * Run the selection algorithm on the given list
	 * @param  list  List
	 * @param  order The position of element to be found
	 * @return       Element
	 */
	private int run(List<Integer> list, int order)
	{
		if(list.size() == 1)
			return list.get(0);
		int pivot = choosePivot(list);
		int newPosition = partition(list, pivot);
		if(newPosition == order)
			return pivot;
		else if(order < newPosition)
			return run(list.subList(0, newPosition), order);
		else 
			return run(list.subList(newPosition+1, list.size()), order - newPosition - 1);
	}

	/**
	 * Choose a pivot from list using the median-of-medians method
	 * @param  list List
	 * @return      Pivot selected
	 */
	private int choosePivot(List<Integer> list)
	{
		ArrayList<Integer> llist = new ArrayList<Integer>(list.size());
		for (Integer a : list) {
			llist.add(a);
		}
		double size = Math.ceil((double)llist.size()/5.0);
		ArrayList<Integer> medians = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			List<Integer> newList;
			if((i+1) * 5 > llist.size()) {
				newList = llist.subList(i * 5, llist.size());
			} else {
				newList = llist.subList(i * 5, (i+1) * 5);
			}
			Collections.sort(newList);
			medians.add(newList.get(newList.size()/2));
		}
		return run(medians, medians.size()/2);
	}

	/**
	 * Swap two integers in an array
	 * @param list List
	 * @param a    position1
	 * @param b    position2
	 */
	private void swap(List<Integer> list, int a, int b)
	{
	    int temp = list.get(a);
	    list.set(a, list.get(b));
	    list.set(b, temp);
	}
	 
	/**
	 * Partition array based on a pibot
	 * @param  arr Array to be partitioned
	 * @param  x   Pivot
	 * @return     New position of pivot
	 */
	private int partition(List<Integer> arr, int x)
	{
	    int l = 0;
	    int r = arr.size()-1;
	    int i;
	    for (i=l; i<r; i++)
	        if (arr.get(i) == x)
	           break;
	    swap(arr, i, r);
	 
	    i = l;
	    for (int j = l; j <= r - 1; j++)
	    {
	        if (arr.get(j) <= x)
	        {
	            swap(arr, i, j);
	            i++;
	        }
	    }
	    swap(arr, i, r);
	    return i;
	}

}