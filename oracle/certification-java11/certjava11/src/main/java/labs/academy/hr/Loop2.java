package labs.academy.hr;

import java.io.*;
import java.util.*;

public class Loop2 {
	
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
        int a = 0;
        int b = 2;
        int n = 10;
		Loop2.printSeries(a, b, n);
	}

	static void printSeries(int a, int b, int n) {
		// System.out.printf("a=%d, b=%d, n=%d\n",a, b, n);
		for (int i = 0; i < n; i++) {
			int s = a;
			for (int j = 0; j <= i; j++) {
				s += (int) (Math.pow(2, j) * b);
			}
			if (i == n - 1) {
				System.out.printf("%d\n", s);
			} else {
				System.out.printf("%d ", s);
			}
		}
	}
}
