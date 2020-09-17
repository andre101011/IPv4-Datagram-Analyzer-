package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Datagram;

class tests {

	@Test
	void numberOfFragmentsTest1() {
		Datagram datagram = new Datagram(4000, 1500);
		assertEquals(3, datagram.getNumberOfFragments());
	}

	@Test
	void numberOfFragmentsTest2() {
		Datagram datagram = new Datagram(7500, 1500);
		assertEquals(5, datagram.getNumberOfFragments());
	}

	@Test
	void numberOfFragmentsTest3() {
		Datagram datagram = new Datagram(8000, 500);
		assertEquals(16, datagram.getNumberOfFragments());
	}

	@Test
	void numberOfFragmentsTest4() {
		Datagram datagram = new Datagram(200, 500);
		assertEquals(1, datagram.getNumberOfFragments());
	}

	@Test
	void fragmentContentTest1() {
		Datagram datagram = new Datagram(4000, 1500);
		assertEquals("1500/001/0000000000000/0/2000", datagram.getFragments().get(0));
	}

	@Test
	void fragmentContentTest2() {
		Datagram datagram = new Datagram(5000, 1200);
		assertEquals("1200/001/0000000000000/0/2000", datagram.getFragments().get(0));
	}

	@Test
	void fragmentContentTest3() {
		Datagram datagram = new Datagram(8000, 1000);
		assertEquals("1000/001/0000000000000/0/2000", datagram.getFragments().get(0));
	}

	@Test
	void fragmentContentTest4() {
		Datagram datagram = new Datagram(15000, 1500);
		assertEquals("1500/001/0000000000000/0/2000", datagram.getFragments().get(0));
	}

	@Test
	void fragmentContentTest5() {
		Datagram datagram = new Datagram(1000, 900);
		assertEquals("900/001/0000000000000/0/2000", datagram.getFragments().get(0));
	}

	@Test
	void fragmentContent2Test1() {
		Datagram datagram = new Datagram(4000, 1500);
		assertEquals("1500/001/0010111001000/185/25c8", datagram.getFragments().get(1));
	}

	@Test
	void fragmentContent2Test2() {
		Datagram datagram = new Datagram(5000, 1200);
		assertEquals("1200/001/0100100111000/295/2938", datagram.getFragments().get(2));
	}

	@Test
	void fragmentContent2Test3() {
		Datagram datagram = new Datagram(8000, 1000);
		assertEquals("1000/001/0011110101000/245/27a8", datagram.getFragments().get(2));
	}

	@Test
	void fragmentContent2Test4() {
		Datagram datagram = new Datagram(15000, 1500);
		assertEquals("1500/001/0010111001000/185/25c8", datagram.getFragments().get(1));
	}

	@Test
	void fragmentContent2Test5() {

		try {
			Datagram datagram = new Datagram(1000, 900);
			datagram.getFragments().get(2);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	@Test
	void printTest() {
		Datagram datagram = new Datagram(4000, 1500);
		datagram.print();
	}

}
