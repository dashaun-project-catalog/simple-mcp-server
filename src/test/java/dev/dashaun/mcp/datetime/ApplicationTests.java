package dev.dashaun.mcp.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private DateTimeService dateTimeService;

	@Test
	void contextLoads() {
	}

	@Test
	void getCurrentDateTime_shouldReturnValidDateTimeString() {
		String result = dateTimeService.getCurrentDateTime();
		assertNotNull(result, "getCurrentDateTime should not return null");
		assertFalse(result.isEmpty(), "getCurrentDateTime should not return empty string");
		assertDoesNotThrow(() -> {
			ZonedDateTime.parse(result);
		}, "Result should be a valid ISO-8601 zoned datetime string");
	}

	@Test
	void getCurrentDateTime_shouldReturnCurrentTime() {
		String result = dateTimeService.getCurrentDateTime();
		ZonedDateTime returnedTime = ZonedDateTime.parse(result);
		ZonedDateTime now = ZonedDateTime.now();
		long secondsDifference = Math.abs(now.toEpochSecond() - returnedTime.toEpochSecond());
		assertTrue(secondsDifference <= 1,
			"Returned time should be within 1 second of current time");
	}

}
