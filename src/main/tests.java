package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class tests {

	@Test
	void test1() {
		Datagram datagram1 = new Datagram(4000,1500);
		assertEquals(3, datagram1.getNumberOfFragments());
	}
	
	@Test
	void test2() {
		Datagram datagram1 = new Datagram(7500,1500);
		assertEquals(5, datagram1.getNumberOfFragments());
	}
	@Test
	void test3() {
		Datagram datagram1 = new Datagram(8000,500);
		assertEquals(16, datagram1.getNumberOfFragments());
	}
	@Test
	void test4() {
		Datagram datagram1 = new Datagram(200,500);
		assertEquals(1, datagram1.getNumberOfFragments());
	}

}
