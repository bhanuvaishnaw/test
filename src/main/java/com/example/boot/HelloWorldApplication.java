package com.example.boot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {

	@SuppressWarnings("unused")
	private static ConfigurableApplicationContext app;
	
	public static void main(String[] args) {
		app = SpringApplication.run(HelloWorldApplication.class, args);
		
		System.out.println("Welcome to Ooty, nice to meet you");
		String mvnversion = executeCommand("mvn --version");
		String javaversion = executeCommand("java --version");
		String gitversion = executeCommand("git --version");
		
		System.out.println("mvn version: "+mvnversion);
		System.out.println("java version: "+javaversion);
		System.out.println("git version: "+gitversion);
		
		SimpleDateFormat formattr = new SimpleDateFormat("dd-MMM-yy");
		String tdaysDt = formattr.format(new Date());
		Date systemDt;
		try {
			systemDt = formattr.parse(tdaysDt);
			System.out.println(tdaysDt);
			System.out.println(systemDt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
