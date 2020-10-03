package Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DataBaseProgram {
	private static HashMap<String, Movie> moviesRepository;
	private static Actor[] actors=new Actor[1000000];
	private static int calculatedRatingFunction(Movie movie) {
		return 10-Integer.parseInt(movie.getRating());
	}
	
	/* Oppgave 4; er det basically aa bruke dfs-full paa grafen.
	 * private static void dfs(Actor actor) { actor.setVisited(); for(Movie
	 * movie:actor.getMovies()) {
	 * 
	 * } } private static void findComponents() { int counter=0; for(int i
	 * =0;i<actors.length;i++) { if(!actors[i].getVisited()) dfs(actors[i]); } }
	 */
	
	public static void loadDataBase() {
		moviesRepository=new HashMap<String, Movie>();
		try {
			BufferedReader br= new BufferedReader(new FileReader("test2.text"));
			for (String line=br.readLine();line!=null;line=br.readLine()) {
				String buffer[] =line.split("  ");
				for (String string : buffer) {
					System.out.println(string);
				}
				moviesRepository.put(buffer[0], new Movie(buffer[0]));	
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
	}

}
