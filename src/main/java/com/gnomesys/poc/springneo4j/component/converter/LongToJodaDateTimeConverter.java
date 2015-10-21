package com.gnomesys.poc.springneo4j.component.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

public class LongToJodaDateTimeConverter implements Converter<Long, DateTime> {

	@Override
	public DateTime convert(Long millis) {
		return new DateTime(millis);
	}

}
