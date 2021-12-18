package labs.academy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class ArraysLoopTest {

	
	@Test
	public void arrayCopyTest() {
		// Given
		String [] source = {"a", "b", "c", "d", "e", "f"};
		String [] destination = new String[7]; 
		
		// When
		System.arraycopy(source, 0, destination, 0, 4);
		
		// Then
		assertArrayEquals(new String[]{"a", "b", "c", "d", null, null, null}, destination);
	}
	
	@Test
	public void arraysCopyOfTest() {
		// Given
		//String [] source = {"a", "b", "c", "d", "e", "f"};
		// doesn't work: var source = {"a", "b", "c", "d", "e", "f"};
		var source = new String[]{"a", "b", "c", "d", "e", "f"};
		
		
		// When
		var destination = Arrays.copyOf(source, 4);
		
		// Then
		assertArrayEquals(new String[]{"a", "b", "c", "d"}, destination);
	}
	
	@Test
	public void arraysCopyOfRangeTest() {
		// Given
		String [] source = {"a", "b", "c", "d", "e", "f"};
		
		// When
		String [] destination = Arrays.copyOfRange(source, 0, 3);
		
		// Then
		assertArrayEquals(new String[]{"a", "b", "c"}, destination);
	}
	
	@Test
	public void arraysSearchTest() {
		// Given
		String [] source = {"a", "b", "c", "dd", "e", "f"};
		
		// When
		int index = Arrays.binarySearch(source,"dd");
		
		// Then
		assertEquals(source[index], "dd");
	}
	
	
	@Test
	public void comparatorTest() {
		// Given
		String [] names = {"João", "Heitor", "Roselena", "Moisés"};
		
	    var comparator =  new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
//				if(o2.length() > o1.length()) {
//					return 1;
//				}
//				if(o2.length() < o1.length()) {
//					return -1;
//				}
//				return 0;
				return o2.length() - o1.length();
			}
		
	    };
	    
		// When
	    Arrays.sort(names, comparator);
		
		// Then
	    assertArrayEquals(new String[] {"Roselena", "Heitor", "Moisés", "João"}, names);
	}
	
	@Test
	public void comparatorNaturalTest() {
		// Given
		String [] names = {"João", "Heitor", "Roselena", "Moisés"};
		
		// When
	    Arrays.sort(names); //natural order
		
		// Then
	    assertArrayEquals(new String[] {"Heitor", "João", "Moisés", "Roselena"}, names);
	}
	
	
	
	
	
	
}
