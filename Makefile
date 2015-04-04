all: LinearTimeSelection
LinearTimeSelection: io/github/thehappybug/Algorithms/LinearTimeSelection.java
	javac io/github/thehappybug/Algorithms/LinearTimeSelection.java
docs: io/github/thehappybug/Algorithms/LinearTimeSelection.java
	javadoc -d docs/ io/github/thehappybug/Algorithms/LinearTimeSelection.java
clean:
	rm io/github/thehappybug/Algorithms/LinearTimeSelection.class