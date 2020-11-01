package Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public final class ReadData {

	private static final HashMap<String, Movie> repoMovies=new HashMap<String, Movie>();
	public static final HashMap<String, Movie> readMovies() {
		
		try {
			BufferedReader movies= new BufferedReader(new FileReader("movies.txt"));		
			for (String line=movies.readLine();line!=null;line=movies.readLine()) {
				String buffer[] =line.split("\t");
				repoMovies.put(buffer[0], new Movie(buffer[0],
						buffer[1],buffer[2],buffer[3]));	
			}		
			
			movies.close();
			return repoMovies;
		}  catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static final HashMap<String, Actor> readActors() {
		HashMap<String, Actor> repoActors=new HashMap<String, Actor>();
		try {
			BufferedReader actors= new BufferedReader(new FileReader("actors.txt"));		
			for (String line=actors.readLine();line!=null;line=actors.readLine()) {
				String buffer[] =line.split("\t");
				Actor actor = new Actor(buffer[0], buffer[1]); 
				
				for(int i =2;i<buffer.length;i++) {
					if(repoMovies.containsKey(buffer[i])) {
						actor.setMovie(repoMovies.get(buffer[i]));				
					}
				}
				repoActors.put(buffer[1],actor);
			}		
			actors.close();
			return repoActors;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
