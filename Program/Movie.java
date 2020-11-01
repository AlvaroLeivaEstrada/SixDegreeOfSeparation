package Program;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class Movie implements Comparable<Movie>{
	private String id;
	private String navn;
	private String rating;
	private String antallStemer;
	private HashMap<String, Actor> actorsPlayedAtThisMovie;
	
	public Movie(String id) {
		this.id=id;
	}
	
	public Movie(String id,String navn,String rating,String aS) {
		this.id=id;
		this.navn=navn;
		this.rating=rating;
		aS=antallStemer;
		actorsPlayedAtThisMovie=new HashMap<String, Actor>();
	}
	public void setActorToFilm(Actor actor) {
		actorsPlayedAtThisMovie.put(actor.getName(),actor);
	}
	
	public String seekDeeperIntoTheGraph(String seekingActor,String connectedActor) {
		Set<String> actorsInTheMovie = actorsPlayedAtThisMovie.keySet();
		Actor currentActor=null;
		String sixDegreeofSeparation="";
		for (String actorName : actorsInTheMovie) {
			currentActor=actorsPlayedAtThisMovie.get(actorName);
			if (!currentActor.getVisited()) {
				sixDegreeofSeparation=currentActor.bFSImplementation(seekingActor,connectedActor);		
			}
			if(!sixDegreeofSeparation.equals("There is no relation between those actors")) break;
				
		}
		return sixDegreeofSeparation;
	}

	@Override
	public int compareTo(Movie o) {
		if(Double.parseDouble(this.rating) > Double.parseDouble(o.getRating())) {
			return -1;
		}else if(Double.parseDouble(this.rating) < Double.parseDouble(o.getRating())) {
			return 1;
		}
		return 0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAntallStemer() {
		return antallStemer;
	}
	public void setAntallStemer(String antallStemer) {
		this.antallStemer = antallStemer;
	}
	@Override
	public String toString() {
		return "=== " + navn + " (" + rating + ") ====>";
	}
	public Actor getActor(String name) {
		Optional<Actor> optional = Optional.of(actorsPlayedAtThisMovie.get(name));
		if (optional.isPresent()) return optional.get();
		return null;
	
	}

	
	

}
