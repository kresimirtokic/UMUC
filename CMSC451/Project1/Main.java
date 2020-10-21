import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		BenchmarkSorts bench = new BenchmarkSorts();
		int n = 0;
		
		for (int i = 0; i < 10; i++) {
			n += 100;
			for (int j = 0; j < 50; j++) {
				bench.generateRandomDataSets(n);
			}
			bench.firstLineIterative = true;
			bench.firstLineRecursive = true;
		}
		try {
			bench.iterativeFile.close();
			bench.recursiveFile.close();
			bench.dataFile.close();
			bench.sortedDataFile.close();
		} catch (IOException e) {
			System.out.println("Failed To Close File Stream");
		}
	}

}
