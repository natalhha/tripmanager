package pl.edu.agh.mwo;
import java.util.*;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}
	
	public Boolean search(String key) {
		if (key == null) {
			return true;
		}
		
		for (Map.Entry<String, Trip> trip : tripList.entrySet()) {
			if (trip.getValue().getName() == key || trip.getValue().getDescription() == key) {
				return true;
			}
			for (Photo photo : trip.getValue().getPhoto()) {
				if (photo.getComment() == key) {
					return true;
				}
			}
		}
		return false;
	}
	
}
