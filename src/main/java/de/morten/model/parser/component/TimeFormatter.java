package de.morten.model.parser.component;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class TimeFormatter {

	/**
	 * 
	 * @param time ss.ms
	 * @return
	 */
	public DateTime toLocalTime(final String time)
	{
		final int idx = time.indexOf(',');
		final int secs = Integer.valueOf(time.substring(0, idx));
		final int ms = Integer.valueOf(time.substring(idx+1));
		
		//split secs into hours, minutes and secs
		int h = secs /3600;
		int m = (secs - h*3600)/ 60;
		int s = secs - h*3600 - m*60;
		
		return null;//new LocalTime(h, m, s, ms);
	}
}
