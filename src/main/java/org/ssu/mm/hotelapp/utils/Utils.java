package org.ssu.mm.hotelapp.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Utils {
	public static void addIfNotEmpty(Consumer<String> supplier, String value) {
		if (!StringUtils.isEmpty(value)) {
			supplier.accept(value);
		}
	}
}
