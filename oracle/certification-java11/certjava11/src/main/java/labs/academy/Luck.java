package labs.academy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Luck {
	private AtomicBoolean coin = new AtomicBoolean(false);

	void flip() {
		coin.getAndSet(!coin.get());

	}

	public static void main(String[] gamble) throws Exception {
		var luck = new Luck();
		ExecutorService s = Executors.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) {
			s.execute(() -> luck.flip());
		}
		s.shutdown();
		Thread.sleep(5000);
		System.out.println(luck.coin.get());
		
		
	}
}
