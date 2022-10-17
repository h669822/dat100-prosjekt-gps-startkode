package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		
		this.gpspoints = new GPSPoint[n];
		this.antall = 0 ;

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		
		if (this.antall<this.gpspoints.length) {
			
			gpspoints[antall] = gpspoint;
			inserted = true;			
		}
		
		this.antall++;		
	    return inserted;
	    
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		// START
		
	    GPSPoint gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
        
		boolean inserted = insertGPS(gpspoint);
		return inserted;	
		
		}

		// SLUTT

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		//START

		for (int n=0; n<gpspoints.length; n++) {
			
			GPSPoint gpspoint = gpspoints[n];
			System.out.println(gpspoint.toString());
		}

		// SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
