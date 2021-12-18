package labs.academy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Accountant {
	public static void completePaperwork() {
		System.out.print("[Filing]");
	}

	public static double getPi() {
		return 3.14159;
	}

	public static void main(String[] args) throws Exception {
		ExecutorService x = Executors.newSingleThreadExecutor();
		Future<Object> f2 = x.submit(() -> getPi());
		Future<?> f1 = x.submit(() -> completePaperwork());
		System.out.print(f1.get() + " " + f2.get());
		x.shutdown();
	}
}
