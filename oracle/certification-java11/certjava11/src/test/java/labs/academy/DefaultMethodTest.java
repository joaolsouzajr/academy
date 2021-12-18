package labs.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DefaultMethodTest {

	@Test
	public void test() {
		
		Color color = new Color();
		
		assertEquals("pink", color.getColor());
		
	}
	
	interface Black {
		double s = 2.2;
		default String getColor() {
			return "black";
		}
	}
	
	interface Red extends Black {
		default String getColor() {
			return "red";
		}
	}
	
	interface Pink extends Black {
		default String getColor() {
			return "pink";
		}
	}
	
	interface Gold {
		static String getColor() {
			return "pink";
		}
	}
	
	class Color implements Black, Red, Pink, Gold {

		@Override
		public String getColor() {
			double ss = s;
			return Pink.super.getColor();
		}
	}
	
	
	
	
	
}
