package Program;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Movie{
	private String id;
	private String navn;
	private String rating;
	private String antallStemer;
	private List<Actor> actorsPlayedAtThisMovie;
	private HashMap<String,Actor>mapOfActors;
	
	
	
	public Movie(String id,String navn,String rating,String aS) {
		this.id=id;
		this.navn=navn;
		this.rating=rating;
		aS=antallStemer;
		actorsPlayedAtThisMovie=new LinkedList<Actor>();
		mapOfActors=new HashMap<String, Actor>();
	}
	public void setActorToFilm(Actor actor) {
		actorsPlayedAtThisMovie.add(actor);
		mapOfActors.put(actor.getName(), actor);
	}
	
	
	public HashMap<String, Actor> getMapOfActors() {
		return mapOfActors;
	}

	public void setMapOfActors(HashMap<String, Actor> mapOfActors) {
		this.mapOfActors = mapOfActors;
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
	public Double getRating() {
		return 10.0-Double.parseDouble(rating);
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

	public List<Actor> getActorsPlayedAtThisMovie() {
		return actorsPlayedAtThisMovie;
	}

	@Override
	public String toString() {
		return "=== " + navn + " (" + rating + ") ====> ";
	}
}
