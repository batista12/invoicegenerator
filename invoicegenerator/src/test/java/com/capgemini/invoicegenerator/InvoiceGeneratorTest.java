package com.capgemini.invoicegenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceGeneratorTest {

	InvoiceService invoiceService;
	private RideRepository rideRepository = null;
	InvoiceSummary expectedInvoiceSummary = null;
	Ride[] rides = null;

	@Before
	public void setUp() throws Exception {
		this.invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
		rides = new Ride[] { new Ride(CabRide.NORMAL, 2.0, 5), new Ride(CabRide.PREMIUM, 0.1, 1) };
		expectedInvoiceSummary = new InvoiceSummary(2, 45.0);

	}

	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		Ride[] rides = {new Ride(CabRide.NORMAL,distance,time)};
		double fare = invoiceService.calculateFare(rides).getTotalFare();
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {

		double distance = 0.1;
		int time = 1;
		Ride[] rides = {new Ride(CabRide.NORMAL,distance,time)};
		double fare = invoiceService.calculateFare(rides).getTotalFare();
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenUserIdRidesShouldReturnInvoiceSummary() {
		String userId = "m@ana.com";
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

}
