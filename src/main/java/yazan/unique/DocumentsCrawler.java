package yazan.unique;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DocumentsCrawler {
	public static Map<String, Integer> words; // hashMap to contain all words as
												// keys and the number of
												// occurances as values
	File[] listOfFiles;

	public DocumentsCrawler(String path) { // constructor
		File dir = new File(path); // the folder that contains all text files .
		words = new HashMap<String, Integer>();
		listOfFiles = dir.listFiles();
	} // end of DocumentsCrawler the constructor

	// this method process each document passed to it
	private void processDocument(Scanner sc) {
		sc.useDelimiter("[^A-Za-z]"); // Scanner method that eleminates any
										// character other than a small/capital
										// alphabetical letter
		String word;
		while (sc.hasNext()) { // reads text file word by word, then add it to
								// the hashmap as a key with value based on
								// whether it exists or not.
			word = sc.next();
			if (words.containsKey(word)) {
				words.put(word, 2); // it means not unique
			} else {
				words.put(word, 1);
			}
		}
	}

	// prints the hashmap size ( number of all words within all text files .
	public void printHmapSize() {
		System.out.println("HashMap size is " + words.size());
	}
	
public void crawl(){

	for (int i = 0; i < listOfFiles.length; i++) {
		if (listOfFiles[i].isFile()) {
			try (Scanner sc = new Scanner(new FileReader(listOfFiles[i]))) {
				System.out.println(i); // indicates progress
				processDocument(sc);
			} // end of the if condition
			catch (FileNotFoundException e) {
				System.err.println("File not found " + listOfFiles[i]);
				e.printStackTrace();
			}

		} // end of the for loop that reads the list of files
	}

}

	// this method iterates over the HashMap (words) and counts the unique
	// words(keys that have the value of 1)
	public void printNumberOfUniqueWords() {
		int counter = 0;
		for (Entry<String, Integer> entry : words.entrySet()) {
			int value = entry.getValue();
			if (value == 1) {
				counter++;
			}
		}
		System.out.println("Number of unique words is " + counter); // number of
																	// unique
																	// words
	}
}
