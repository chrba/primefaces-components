package de.morten.mode.parser;

import junit.framework.Assert;

import org.junit.Test;

import de.morten.model.GCTimeStats;
import de.morten.model.PSYoungGenGCEvent;
import de.morten.model.parser.MinorGCParser;


public class MinorGCParserTest {

	@Test
	public void test() {
		final String line = "2013-03-23T15:06:05.424+0100: 1,147: " +
				"[GC [PSYoungGen: 19843K->2558K(38208K)] "
				+ "19843K->2558K(125632K), 0,0121400 secs] [Times: user=0,03 sys=0,00, real=0,01 secs] ";
		
		final MinorGCParser parser = new MinorGCParser(line);
		final PSYoungGenGCEvent event = parser.parse();
		
		final GCTimeStats timeStats = event.getTimeStats();
		Assert.assertEquals(0.01, timeStats.getDuration());
		Assert.assertEquals(1.147, timeStats.getElappsedTime());
		
		//date
		Assert.assertEquals(2013, timeStats.getTimestamp().getYear());
		Assert.assertEquals(3, timeStats.getTimestamp().getMonthOfYear());
		Assert.assertEquals(23, timeStats.getTimestamp().getDayOfMonth());

		//time
		Assert.assertEquals(15, timeStats.getTimestamp().getHourOfDay());
		Assert.assertEquals(6, timeStats.getTimestamp().getMinuteOfHour());
		Assert.assertEquals(5, timeStats.getTimestamp().getSecondOfMinute());
		
		
		//PSYoungGen
		Assert.assertEquals(19843, event.getYoungGenChange().occupancyBeforeGc());
		Assert.assertEquals(2558, event.getYoungGenChange().occupancyAfterGc());
		Assert.assertEquals(38208, event.getYoungGenChange().totalSize());


		//OldGen
		Assert.assertEquals(19843, event.getOldGenChange().occupancyBeforeGc());
		Assert.assertEquals(2558, event.getOldGenChange().occupancyAfterGc());
		Assert.assertEquals(125632, event.getOldGenChange().totalSize());
		
	}
}
