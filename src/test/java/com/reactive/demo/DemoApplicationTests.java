package com.reactive.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

class HttpTests {
	@Test
	void testReactive() {
	}

	private void run (String text) {
		WebClient client = WebClient.create();
	}

}
