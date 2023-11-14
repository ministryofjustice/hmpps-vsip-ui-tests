package pages.util;

import java.util.HashMap;
import java.util.Map;

import static java.lang.ThreadLocal.withInitial;


public class TestRunContext {

	private static final ThreadLocal<Map<Context, Object>> testContexts = withInitial(HashMap::new);

	private static <T> T get(Context key) {
		return (T) testContexts.get()
				.get(key);
	}

	public static <T> T set(Context key, T object) {
		System.out.println("TestRunContext Key :"+ key + " Value :" + object.toString());
		testContexts.get().put(key, object);
		return object;
	}

	public static String getBookingReference() {
		return get(Context.BOOKING_REFERENCE);
	}

}