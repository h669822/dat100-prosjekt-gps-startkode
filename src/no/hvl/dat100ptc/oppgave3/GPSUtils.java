package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
	}

		// TODO - SLUT

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double[gpspoints.length];
		
		for (int n=0; n<gpspoints.length; n++) {
			
		GPSPoint point = gpspoints[n];
		double latitude = point.getLatitude();
		latitudes[n] = latitude;
			
		}
		
		return latitudes;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

        double[] longitudes = new double[gpspoints.length];
		
		for (int n=0; n<gpspoints.length; n++) {
			
		GPSPoint point = gpspoints[n];
		double longitude = point.getLongitude();
		longitudes[n] = longitude;
			
		}

        return longitudes;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();
		
		double a = pow(sin((toRadians(latitude2)-toRadians(latitude1))/2),2) + (cos(toRadians(latitude1)) * cos(toRadians(latitude2)) * pow(sin((toRadians(longitude2)-toRadians(longitude1))/2),2));
		System.out.println(a);
		double c = 2*(atan2(sqrt(a), sqrt(1-a)));
		System.out.println(c);
		d = R*c;
		return d;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		secs = (gpspoint2.getTime()) - (gpspoint1.getTime());

		double MeterPerSekund = (distance(gpspoint1, gpspoint2) / secs);
         
		speed = MeterPerSekund * 3.6;
		
		return speed;	

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int timer, minutter, sekunder;

		timer = secs / 3600;
		    
		minutter = (secs % 3600) / 60;
		    
		sekunder = secs - minutter*60 - timer * 3600;
		
		timestr = String.format("  %02d%s%02d%s%02d", timer, TIMESEP, minutter, TIMESEP, sekunder);
		
		return timestr;

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

	      int n = (int) ((d+0.005) * 100);   
		  double dAv = (double)n / 100;	
		
		str = String.format("%" + TEXTWIDTH + ".2f", dAv);
		
	return str;
		
	}
}
