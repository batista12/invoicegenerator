package com.capgemini.invoicegenerator;
public class Ride {

	public double distance;
	public int time;
	public CabRide cabRide;

	public Ride(CabRide cabRide, double distance, int time) {

		this.cabRide = cabRide;
		this.distance = distance;
		this.time = time;

	}
}