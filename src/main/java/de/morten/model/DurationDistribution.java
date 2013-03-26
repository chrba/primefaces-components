package de.morten.model;

import java.util.List;
import java.util.Map;

/**
 * A distribution of GC durations to the number of occurences of GCs with the same
 * duration.
 *  
 * @author Christian Bannes
 */
public class DurationDistribution {
	/** duration of GC -> number of GCs with same duration */
	 private Map<Integer, Integer> distribution;
	 /** any name for this distribution, will be used in the front end */
	 private String name;

	/**
	 * @param name the name for this distribution, will show up in the front end.
	 * @param events a list of garbage collection events, must all be of the same type
	 */
	public  DurationDistribution(final String name, final List<? extends GCEvent> events) {
		for(final GCEvent gcEvent : events)
		{
			final GCTimeStats timeStats = gcEvent.getTimeStats();
			final int duration = (int) Math.round(timeStats.getDuration()*100);
			this.distribution.put(duration, incValueFor(duration));
		}
		this.name = name;
	}

	/**
	 * @return a map describing the distribution. The key is the duration of a garbage collection event and the value
	 * 			is the number of garbage collection events with the same duration
	 */
	public Map<Integer, Integer> getDistribution() {
		return this.distribution;
	}
	
	/**
	 * @return the name of this distribution, e.g. "FULL GC" or "PSYoungGen"
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * We return an Integer instead of int to avoid boxing/unboxing because we store the value
	 * in a map after it is returned from this method anyway.
	 * 
	 * @param duration
	 * @return never null
	 */
	private Integer incValueFor(int duration) {
		final Integer number = this.distribution.get(duration);
		if(number == null)
			return Integer.valueOf(1);
		else 
			return number + 1; 
	}
}
