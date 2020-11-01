package Program;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;



public class Graph {

	private static HashMap<String, Actor> repoActors;
	private static List<Movie> listOfMoviesSeen;
	private static List<Actor> visitedVertex;

	private static final boolean buildGraph() {
		ReadData.readMovies();
		repoActors = ReadData.readActors();
		return true;

	}

	private static final void dijkstra(String initialActorString, String destinationActor) {
		Comparator<Actor> distance = new MyComparator();
		PriorityQueue<Actor> priorityQueue = new PriorityQueue<Actor>(distance);
		Actor initialActor = repoActors.get(initialActorString);
		Actor outpuActor = null;
		initialActor.setDistance(0.0);
		priorityQueue.offer(initialActor);
		initialActor.setPath(initialActor.toString());
		while (!priorityQueue.isEmpty()) {
			Actor actor = priorityQueue.poll();
			for (Movie movie : actor.getMovies()) {

				for (Actor endPoint : movie.getActorsPlayedAtThisMovie()) {
					if ((actor.getDistance() + movie.getRating()) < endPoint.getDistance()) {
						if (destinationActor.equalsIgnoreCase(endPoint.getName())) {
							if (endPoint.getPath().length() > 0) {
								endPoint.getPath().delete(0, endPoint.getPath().length());
							}
							outpuActor = endPoint;
						}
						endPoint.setDistance(actor.getDistance() + movie.getRating());
						endPoint.setPath(actor.getPath().toString() + "\n");
						endPoint.setPath(movie.toString());
						endPoint.setPath(endPoint.toString() + "\n");
						priorityQueue.offer(endPoint);

					}
				}
			}
		}
		System.out.println(outpuActor.getPath());

	}

	private static int dfs(Actor actor, int count) {
		
		//System.out.println("visited");
		int numberOfNodesInComponent = count;
		
		for (Movie movie : actor.getMovies()) {
			//if (!listOfMoviesSeen.contains(movie)) {
			//	listOfMoviesSeen.add(movie);
				//System.out.println("movie");
				for (Actor endPoint : movie.getActorsPlayedAtThisMovie()) {
					if (!visitedVertex.contains(endPoint)) {
						//System.out.println(endPoint);
						visitedVertex.add(actor);
						dfs(endPoint, ++numberOfNodesInComponent);
						
					}
				}
			//}
		}
		//System.out.println("backtracking");
		//System.out.println(numberOfNodesInComponent);
		return numberOfNodesInComponent;
	}

	private static final void dfsFull() {
		int numberOfComponents = 0;
		List<Integer> componentsInGraph = new LinkedList<Integer>();

		for (String vertex : repoActors.keySet()) {
			Actor actor = repoActors.get(vertex);
			if (!visitedVertex.contains(actor)) {
				System.out.println(actor);
				System.out.println(dfs(actor, 0));
			}
		}
		/*
		 * Map<Integer, Long> counting = componentsInGraph.stream().collect(
		 * Collectors.groupingBy(items->items,Collectors.counting()));
		 * 
		 * System.out.println(counting);
		 */

	}

	private static final void breadthFirstSearch(String initialActorString, String destinationActor) {
		Actor initialActor = repoActors.get(initialActorString);
		initialActor.setPath(initialActor.toString());

		Actor output = null;
		Queue<Actor> degreOfSeparation = new LinkedList<Actor>();
		boolean optimalisering = false;
		degreOfSeparation.add(initialActor);
		visitedVertex.add(initialActor);

		while (!degreOfSeparation.isEmpty()) {
			Actor actor = degreOfSeparation.poll();
			for (Movie movie : actor.getMovies()) {
				if (!listOfMoviesSeen.contains(movie)) {
					listOfMoviesSeen.add(movie);
					if (movie.getMapOfActors().containsKey(destinationActor)) {
						output = movie.getMapOfActors().get(destinationActor);
						output.setPath(actor.getPath().toString());
						output.setPath(movie.toString());
						output.setPath(output.toString());
						optimalisering = true;
						continue;
					}
					for (Actor endPoint : movie.getActorsPlayedAtThisMovie()) {

						if (!visitedVertex.contains(endPoint)) {
							visitedVertex.add(endPoint);
							endPoint.setPath(actor.getPath().toString() + "\n");
							endPoint.setPath(movie.toString());
							endPoint.setPath(endPoint.toString() + "\n");
							degreOfSeparation.add(endPoint);
						}
					}
				}
				if (optimalisering)
					break;
			}
			if (optimalisering)
				break;
		}
		System.out.println(output.getPath());

	}

	public static void main(String[] args) {
		visitedVertex = new LinkedList<Actor>();
		listOfMoviesSeen = new LinkedList<Movie>();
		buildGraph();
		//dfsFull();
		// breadthFirstSearch("Will Smith", "Jaden Smith");
		// breadthFirstSearch("Atle Antonsen", "Robert De Niro");
		// breadthFirstSearch("Diane Keaton", "Roger Cross");
		// breadthFirstSearch("Angelina Jolie","Charlize Theron");
		 dijkstra("Atle Antonsen", "Robert De Niro");
		// dijkstra("Margot Robbie", "Scarlett Johansson");
		// dijkstra("Angelina Jolie","Charlize Theron");
		// breadthFirstSearch("Margot Robbie", "Scarlett Johansson");

	}

}
