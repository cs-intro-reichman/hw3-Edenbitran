// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5

		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		for (int i = 1; i <= x2; i++) {
			sum++;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		for (int i = 1; i <= x2; i++) {
			sum--;
		}
		return sum;

	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
			return 0;
		} else {
			int quotient = x1;
			for (int i = 1; i < x2; i++) {
				quotient = plus(quotient, x1); // == quotient += x1;
			}
			return quotient;
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		if (x == 0) {
			return 0;
		}
		int quotient = 1;
		int sumQ = 1;
		if (n >= 2) {
			quotient = times(x, x); // quotien= x^2
			sumQ = quotient;
			for (int i = 3; i <= n; i++) {
				quotient = times(quotient, x);
				sumQ = quotient;
			}
		}
		return sumQ;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		if (x2 == 1) {
			return x1;
		} else if (x1 == 0) {
			return 0;
		} else if (x2 == 0) {
			return -1;
		} else if (x1 == x2) {
			return 1;
		}
		int sum = 0;
		while (minus(x1, x2) >= 0) {
			sum++;
			x1 = minus(x1, x2);
		}
		return sum;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int sum = minus(x1, times(div(x1, x2), x2));
		return sum;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int sqrtX = 1;
		double epsilon = 0.01;
		int increment = 1;
		while (minus(x, times(sqrtX, sqrtX)) >= epsilon) {
			sqrtX = plus(sqrtX, increment);
		}

		return (int) sqrtX;
	}
}