package de.morten.model;

public abstract class  AbstractGCEvent implements GCEvent{

	/** time statistics of this gc event (timestamp, duration, ...) */
	private GCTimeStats timeStats;
	/** the name of the garbage collector (e.g. PSYoungGen, OldGC, ...) */
	private final String name;

	public AbstractGCEvent(final String name, final GCTimeStats timeStats) {
		this.name = name;
		this.timeStats = timeStats;
	}
	
	public GCTimeStats getTimeStats() {
		return this.timeStats;
	}
	
	public String getName() {
		return this.name;
	}
	
}
