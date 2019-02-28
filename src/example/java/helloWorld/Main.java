package example.java.helloWorld;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Hello world");
		String mvnversion = executeCommand("mvn --version");
		String javaversion = executeCommand("java --version");
		String gitversion = executeCommand("git --version");
		
		System.out.println("mvn version: "+mvnversion);
		System.out.println("java version: "+javaversion);
		System.out.println("git version: "+gitversion);
		
	}
	
	public static String executeCommand(String command) {
		StringBuilder output = new StringBuilder();
		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor(30, TimeUnit.SECONDS);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			System.out.println("Runtime error : {}"+ e);
		}

		return output.toString();
	}
}
