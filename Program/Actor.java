package Program;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Actor {

	private String id;
	private String name;
	private List<Movie> moviesPlayedIn;
	private boolean visited;
	private Actor secondActor;
	private Movie connectionMovie;
	private PriorityQueue<Movie> priorityQueue;

	public Actor(String id, String name) {
		this.id = id;
		this.name = name;
		visited = false;
		secondActor = null;
		connectionMovie = null;
		priorityQueue = new PriorityQueue<Movie>();
		moviesPlayedIn = new LinkedList<Movie>();
	}

	public void setMovie(Movie movie) {
		moviesPlayedIn.add(movie);
		movie.setActorToFilm(this);
		setRecommendedFilm(movie);
	}

	private void setRecommendedFilm(Movie movie) {
		priorityQueue.offer(movie);
	}

	public void chillesteVei(String secondActor, String connectedActor) {
		this.setVisited();
		String sixDegree = "There is no relation between those actors";
		while (!priorityQueue.isEmpty()) {
			Movie film = priorityQueue.poll();
			sixDegree = film.seekDeeperIntoTheGraph(secondActor, this.toString() + "\n" + film.toString());
			if (!sixDegree.equals("There is no relation between those actors")) {
				break;
			}
		}
	}

	public String bFSImplementation(String secondActor, String connectedActor) {
		this.setVisited();
		String sixDegree = "There is no relation between those actors";
		for (Movie movie : moviesPlayedIn) {
			if ((this.secondActor = movie.getActor(secondActor)) != null) {
				connectionMovie = movie;
				break;
			}
		}
		if (this.secondActor != null) {
			sixDegree = connectedActor + "\n" + connectionMovie.toString() + " " + secondActor.toString();
			return sixDegree;
		}

		for (Movie movie : moviesPlayedIn) {
			sixDegree = movie.seekDeeperIntoTheGraph(secondActor, this.toString() + "\n" + movie.toString());
			if (!sixDegree.equals("There is no relation between those actors")) {
				break;
			}
		}

		return sixDegree;

	}

	public void setVisited() {
		visited = true;
	}

	public boolean getVisited() {
		return visited;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
