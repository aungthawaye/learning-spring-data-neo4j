package com.gnomesys.poc.springneo4j.component.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

public class JodaDateTimeToLongConverter implements Converter<DateTime, Long> {

	@Override
	public Long convert(DateTime d) {
		return Long.valueOf(d.getMillis());
	}

}
