package Program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Actor {

	private String id;
	private Double distance;
	private String name;
	private List<Movie> moviesPlayedIn;
	private HashMap<String, Movie>mapOfMovies;
	private StringBuffer builStringBuffer;
	private static final Double MAX=99999999.9;

	public Actor(String id, String name) {
		this.id = id;
		this.name = name;
		builStringBuffer=new StringBuffer();
		mapOfMovies=new HashMap<String, Movie>();
		moviesPlayedIn = new LinkedList<Movie>();
		distance=MAX;
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public void setMovie(Movie movie) {
		moviesPlayedIn.add(movie);
		movie.setActorToFilm(this);
		mapOfMovies.put(movie.getNavn(), movie);
	}
	public void setPath(String path) {
		builStringBuffer.append(path);
	}
	public StringBuffer getPath() {
		return builStringBuffer;
	}
	
	public List<Movie> getMoviesPlayedIn() {
		return moviesPlayedIn;
	}

	public void setMoviesPlayedIn(List<Movie> moviesPlayedIn) {
		this.moviesPlayedIn = moviesPlayedIn;
	}

	public HashMap<String, Movie> getMapOfMovies() {
		return mapOfMovies;
	}

	public void setMapOfMovies(HashMap<String, Movie> mapOfMovies) {
		this.mapOfMovies = mapOfMovies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return moviesPlayedIn;
	}

	@Override
	public String toString() {
		return name;
	}


}
