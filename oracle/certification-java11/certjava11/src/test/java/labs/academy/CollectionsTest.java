package labs.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CollectionsTest {

	@Test
	public void fixedListTest() {
		// Given
		List<String> names = Arrays.asList("b", "c", "a"); // fixed-size list

		// When
		assertThrows(UnsupportedOperationException.class, () -> {
			names.add("e");
		});

		names.set(0, "z");

		assertEquals("z", names.get(0));
	}

	@Test
	public void readOnlyListTest() {
		// Given
		List<String> names = List.of("b", "c", "a"); // fixed-size and read-only list

		// When
		assertThrows(UnsupportedOperationException.class, () -> {
			names.add("e");
		});

		assertThrows(UnsupportedOperationException.class, () -> {
			names.set(0, "z");
		});
	}

	@Test
	public void createConllectionFromOtherTest() {
		// Given
		var namesSet = new ArrayList<Product>();
		namesSet.add(new Product("b"));
		namesSet.add(new Product("a"));
		namesSet.add(new Product("c"));

		// When
		var namesList = new ArrayList<Product>(namesSet);
		namesList.get(2).name = "dd";

		// Then
		assertTrue(namesSet.contains(new Product("dd")));
		assertTrue(namesList.contains(new Product("dd")));
		assertFalse(namesSet.contains(new Product("c")));
		assertFalse(namesList.contains(new Product("c")));
		assertTrue(namesList.get(0) == namesSet.get(0));
	}
	
	@Test
	public void predicateRemoveIfTest() {
		// Given
		var names = new ArrayList<Product>();
		names.add(new Product("b"));
		names.add(new Product("ac"));
		names.add(new Product("cc"));
		String[] arr = {"Tea","Cake"};
		arr[0] = "Co";
		List<String> texts = Arrays.asList(arr);
		texts.set(0, "cc");
		
		// When
		names.removeIf((Product p) -> { return p.name.length() > 1; });
	
		// Then
		assertEquals(1, names.size());
	}

	private class Product {
		Product(String name) {
			this.name = name;
		}

		String name;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

	}

}
