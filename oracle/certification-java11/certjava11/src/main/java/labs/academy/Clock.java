package labs.academy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Clock {
	private AtomicLong bigHand = new AtomicLong(0);

	void incrementBy10() {
		bigHand.getAndSet(bigHand.get() + 10);
	}

	public static void main(String[] c) throws Exception {
		var smartWatch = new Clock();
		ExecutorService s = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			s.submit(() -> smartWatch.incrementBy10()).get();
		}
		s.shutdown();
		s.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println(smartWatch.bigHand.get());
	}
}
