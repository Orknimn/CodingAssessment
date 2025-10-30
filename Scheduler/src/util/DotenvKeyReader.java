package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DotenvKeyReader {
	File dotenv;
	public DotenvKeyReader() {
		this(".env");
	}
	public DotenvKeyReader(String filePath) {
		this.dotenv = new File(filePath);
		System.out.println(dotenv.getAbsolutePath());
	}
	public String getAPIKey() {
		return loadEnvKey("API_KEY");
	}
	
	private String loadEnvKey(String keyName) {
		String key = null;
		try (Scanner scan = new Scanner(this.dotenv)) {
			while(scan.hasNextLine()) {
		
				String line = scan.nextLine();
				int keyIndex = line.indexOf(keyName);
				
				if(keyIndex >= 0) {
					//Get the start index in line of the key, ignoring characters like '=' or ':'
					int keyStart = 0;
					for(int i = keyName.length(); i < line.length() - 1; ++i) {
						if (Character.isLetterOrDigit(line.charAt(i))) {
							keyStart = i;
							break;
						}
					}
					
					key = line.substring(keyStart, line.length());
					return key;
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error occured reading .env file");
			e.printStackTrace();
			return null;
		}
		return key;
	}
}
