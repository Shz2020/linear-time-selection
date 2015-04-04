# Linear Time Selection

Implements the Selection algorithm as described by Blum, Floyd, Pratt, Rivest, and Tarjan. It runs in O(n) time complexity with the best case being O(1) in case of a sorted array. Implementation is provided as `LinearTimeSelection` class contained in the package `io.gitbub.thehappybug.Algorithms`.

> See [http://en.wikipedia.org/wiki/Selection_algorithm](Wikipedia) for more information on Selection algorithm.

## Compiling

The project can be compiled using `make` tool:

```
$ make
javac io/github/thehappybug/Algorithms/LinearTimeSelection.java
```

Optionally, documentation can be generated from the source files using Javadoc:

```
$ make docs
Loading source file io/github/thehappybug/Algorithms/LinearTimeSelection.java...
Constructing Javadoc information...
Standard Doclet version 1.7.0_75
Building tree for all the packages and classes...
Generating docs\io\github\thehappybug\Algorithms\LinearTimeSelection.html...
Generating docs\io\github\thehappybug\Algorithms\package-frame.html...
Generating docs\io\github\thehappybug\Algorithms\package-summary.html...
Generating docs\io\github\thehappybug\Algorithms\package-tree.html...
Generating docs\constant-values.html...
Building index for all the packages and classes...
Generating docs\overview-tree.html...
Generating docs\index-all.html...
Generating docs\deprecated-list.html...
Building index for all classes...
Generating docs\allclasses-frame.html...
Generating docs\allclasses-noframe.html...
Generating docs\index.html...
Generating docs\help-doc.html...
```

## Running

Run the class `LinearTimeSelection`'s `main` method using:

```
$ java io.github.thehappybug.Algorithms.LinearTimeSelection 5 sample_input.txt
5
```

The program requires two arguments: the position, `n` and a file containing a space-separated integer list.


## Documentation of Public Interface of the Class

### `public class LinearTimeSelection`

Algorithm to select n-th element from a list

### `public static void main(String[] args)`

Main program to select n-th element in an array Input file should contain space separated integer numbers.

 * **Parameters:** `args` — "Position" and "input filename" required as arguments to program

### `public LinearTimeSelection(List<Integer> list)`

Create a selection algorithm bound to a list

 * **Parameters:** `list` — List


## Documentation for Private Members of the Class

### `private static List<Integer> readFromFile(String path) throws IOException`

Read a space-separated integer list from file.

 * **Parameters:** `path` — Path of file
 * **Returns:** Integer list
 * **Exceptions:** `IOException` — Thrown when unable to open or read file

### `public int run(int order) throws IllegalArgumentException`

Run the selection algorithm

 * **Parameters:** `order` — The position of element to find
 * **Returns:** Element found
 * **Exceptions:** `IllegalArgumentException` — If the position is out-of-bounds

### `private int run(List<Integer> list, int order)`

Run the selection algorithm on the given list

 * **Parameters:**
   * `list` — List
   * `order` — The position of element to be found
 * **Returns:** Element

### `private int choosePivot(List<Integer> list)`

Choose a pivot from list using the median-of-medians method

 * **Parameters:** `list` — List
 * **Returns:** Pivot selected

### `private void swap(List<Integer> list, int a, int b)`

Swap two integers in an array

 * **Parameters:**
   * `list` — List
   * `a` — position1
   * `b` — position2

### `private int partition(List<Integer> arr, int x)`

Partition array based on a pibot

 * **Parameters:**
   * `arr` — Array to be partitioned
   * `x` — Pivot
 * **Returns:** New position of pivot