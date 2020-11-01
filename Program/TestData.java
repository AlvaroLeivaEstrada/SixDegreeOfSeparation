package Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestData {
	
	

	public static void main(String[] args) throws IOException {
//		HashMap<String, Movie> moviesRepository=new HashMap<String, Movie>();
//		try {
//			BufferedReader br= new BufferedReader(new FileReader("test2.text"));
//			for (String line=br.readLine();line!=null;line=br.readLine()) {
//				String buffer[] =line.split("  ");
//				for (String string : buffer) {
//					System.out.println(string);
//				}
//				//moviesRepository.put(buffer[0], new Movie(buffer[0]));
//			}
//			
//		} catch (FileNotFoundException e) {
//		
//			e.printStackTrace();
//		}

		
/*
 * String str = "esto es un ejemplo de como funciona split"; String [] cadenas =
 * str.split("\\w ");//str.split("(e[s|m])|(pl)"); for(int i = 0;
 * i<cadenas.length; i++){ System.out.println(cadenas[i]); }
 */
		
		PriorityQueue<Movie>movies=new PriorityQueue<Movie>();
		Movie movie=new Movie("dd","hola1","4.2","dd");
		Movie movie2=new Movie("dd","hola2","5.2","dd");
		Movie movie3=new Movie("dd","hola3","9.2","dd");
		Movie movie4=new Movie("dd","hola4","6.2","dd");
		
		movies.offer(movie);
		movies.offer(movie2);
		movies.offer(movie3);
		movies.offer(movie4);

		System.out.println(movies.poll().toString());
//	    
//	    String regex = "(\\d+) de (\\w+) de (\\d+)";
//		Pattern patron = Pattern.compile(regex);
//
//		String texto = "30 de Enero de 2015";
//		Matcher emparejador = patron.matcher(texto);
//
//		emparejador.find();
//
//		String el1 = emparejador.group(1);
//		String el2 = emparejador.group(2);
//		String el3 = emparejador.group(3);
//
//	System.out.println("Contenido en la variable $1: \'" + el1 + "\', en la variable $2: \'" + el2 + "\', en la variable $3: \'" + el3 + "\'");

	}

}
