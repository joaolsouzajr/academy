package labs.academy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class StreamTest {

	int index = 0;

	@Test
	public void generateRandomInttest() {

		// var total = IntStream.generate(() -> (int) (Math.random() *
		// 10)).limit(5).sum();
		// Given
		index = 0;

		// When
		var list = IntStream.generate(() -> index++).takeWhile(n -> n < 5).boxed().collect(Collectors.toList());

		// Then
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4 }, list.toArray());
	}

	@Test
	public void collectTest() {

		// When
		var list = IntStream.range(0, 10).boxed().collect((Supplier<List<Integer>>) ArrayList::new, 
				(r, v) -> { ((List<Integer>) r).add(v*2);
		}, (left, rigth) -> {
			((List<Integer>) left).addAll((List<Integer>) rigth);
		});
		//System.out.println(list);

		// Then
		assertArrayEquals(new Integer[] {0, 2, 4, 6, 8, 10, 12, 14, 16, 18}, list.toArray());
	}

}
