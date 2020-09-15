package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class tests {

	@Test
	void numberOfFragmentsTest1() {
		Datagram datagram1 = new Datagram(4000, 1500);
		assertEquals(3, datagram1.getNumberOfFragments());
	}

	@Test
	void numberOfFragmentsTest2() {
		Datagram datagram1 = new Datagram(7500, 1500);
		assertEquals(5, datagram1.getNumberOfFragments());
	}

	@Test
	void numberOfFragmentsTest3() {
		Datagram datagram1 = new Datagram(8000, 500);
		assertEquals(16, datagram1.getNumberOfFragments());
	}

	@Test
	void numberOfFragmentsTest4() {
		Datagram datagram1 = new Datagram(200, 500);
		assertEquals(1, datagram1.getNumberOfFragments());
	}

	@Test
	void test5() {
		Datagram datagram1 = new Datagram(4000, 1500);
		// assertEquals(1, datagram1.getNumberOfFragments());
		System.out.println(datagram1.getFragments());
	}

}
