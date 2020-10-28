package com.capgemini.invoicegenerator;
public class IvoiceGenerator {

	private RideRepository rideRepository;
	public IvoiceGenerator() {
		this.rideRepository = new RideRepository();
	}


	public InvoiceGenerator calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += ride.cabRide.calculateRideCost(ride);
		}
		return new InvoiceGenerator(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRide(userId, rides);

	}

	public InvoiceGenerator getInvoiceGenerator(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

}