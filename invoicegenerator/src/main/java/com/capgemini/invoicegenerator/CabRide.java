package com.capgemini.invoicegenerator;
public enum CabRide {
	NORMAL(10.0,1.0,5.0),PREMIUM(15.0,2.0,20.0);

	private final double costPerKm;
	private final double costPerMin;
	private final double minFarePerRide;
	
	private CabRide(double costPerKm, double costPerMin, double minFarePerRide) {
		this.costPerKm = costPerKm;
		this.costPerMin = costPerMin;
		this.minFarePerRide = minFarePerRide;
	}
	
	public double calculateRideCost(Ride ride) {
		double totalFare = ride.distance*costPerKm + ride.time*costPerMin;
		return Math.max(totalFare, minFarePerRide);
	}

}
