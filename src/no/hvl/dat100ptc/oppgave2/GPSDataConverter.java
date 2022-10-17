package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs = 0;
		int hr = 0, min = 0, sec = 0;
		
		// OPPGAVE - START	
		hr = Integer.parseInt(timestr.substring(11,13)) ;
		min = Integer.parseInt(timestr.substring(14,16));
		sec = Integer.parseInt(timestr.substring(17,19));
		
		secs = hr * 60 * 60 + min * 60 + sec;
		
		return secs;
		// OPPGAVE - SLUTT
		
	}


	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {


		
		int time = toSeconds(timeStr);	
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
			
	    GPSPoint gpspoint = new GPSPoint(time, latitude, longitude, elevation);

		return gpspoint;	

	    
	}
	
}
