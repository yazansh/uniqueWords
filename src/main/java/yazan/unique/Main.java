package yazan.unique;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Instant start = Instant.now(); // in order to compute elapsed time in milliseconds
		

		if(StringUtils.isBlank(args[0])){
			System.err.println("You must pass the folder path. It cannot be empty");
			System.exit(1);			
		}
		
		DocumentsCrawler dc = new DocumentsCrawler(args[0]);		
		dc.crawl();		
		dc.printNumberOfUniqueWords(); // prints all unique words
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
	}

}
