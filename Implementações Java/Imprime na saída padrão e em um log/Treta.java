//package br;

import java.io.File;
import java.io.PrintStream;

public class Treta {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		PrintStream padrao = System.out;
		PrintStream fileLog = new PrintStream(new File ("log.txt"));
		System.setOut(fileLog);
		System.out.println("Esse vai pro arquivo!!");
		System.setOut(padrao);		
		System.out.println("Esse vai pro padrao");
		System.setOut(fileLog);
		System.out.println("Esse vai pro arquivo 2 ");
	}
}
