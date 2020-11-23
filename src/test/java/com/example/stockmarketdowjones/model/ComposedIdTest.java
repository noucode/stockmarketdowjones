package com.example.stockmarketdowjones.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ComposedIdTest {
	@Test
	public void testSetter() {
		ComposedId composedId = new ComposedId();
		composedId.setStock("AA");
		assertEquals("AA", composedId.getStock());
	}

	@Test
	public void testGetter() {
		ComposedId composedId = new ComposedId("1","BAC","2/4/2011");
		assertEquals("BAC", composedId.getStock());
	}
}
