// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		// System.out.println("plus");
		// System.out.println(plus(2, 3)); // 2 + 3
		// System.out.println(plus(-5, -3)); // -5 + (-3)= -8
		// System.out.println(plus(-2, 3)); // -2 + 3
		// System.out.println(plus(2, -4));// 2 + (-4)
		// System.out.println("minus");
		// System.out.println(minus(7, 2)); // 7 - 2
		// System.out.println(minus(2, 7)); // 2 - 7
		// System.out.println(minus(-5, -3)); // -5 - (-3)= -2
		// System.out.println(minus(-3, -6)); // -3 - (-6)=3
		// System.out.println("times");
		// System.out.println(times(3, 4)); // 3 * 4
		// System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		// System.out.println(times(-3, 5));
		// System.out.println(times(-3, -5));
		// System.out.println(times(3, -5));
		// System.out.println("pow");
		// System.out.println(pow(5, 3)); // 5^3
		// System.out.println(pow(3, 5)); // 3^5
		// System.out.println(pow(-2, 3));
		// System.out.println(pow(1, 10));

		// System.out.println("div");
		 //System.out.println(div(5, 5)); // 5 / 5
		 //System.out.println(div(25, 7)); // 25 / 7
		  //System.out.println(div(-15, -3));
		 //System.out.println(div(12, 4));
		 // System.out.println(div(15, -3));

		// System.out.println("mod");
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(div(120, 6));
		System.out.println(mod(12, 6)); // 120 % 6

		// System.out.println("sqrt");
		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
		// System.out.println(sqrt(76123));
		// System.out.println(sqrt(0));
		// System.out.println(sqrt(144));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		// 2 numbers are positive
		if (x1 > 0 && x2 > 0) {
			for (int i = 1; i <= x2; i++) {
				sum++;
			}
		}

		// if one of the equals to 0
		else if (x1 == 0 || x2 == 0) {
			if (x1 == 0) {
				sum = x2;
			} else {
				sum = x1;
			}
		}

		// if both negative
		else if (x1 < 0 && x2 < 0) {
			for (int i = -1; i >= x2; i--) {
				sum--;
			}
		}
		// if x1 positive and x2 negative
		else if (x1 > 0 && x2 < 0) {
			sum = x2;
			for (int i = 1; i <= x1; i++) {
				sum++;
			}
		}
		// if x2 positive and x1 negative
		else if (x1 < 0 && x2 > 0) {
			sum = x1;
			for (int i = 1; i <= x2; i++) {
				sum++;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		// 2 numbers are positive
		if (x1 > 0 && x2 > 0) {
			for (int i = 1; i <= x2; i++) {
				sum--;
			}
		}

		// check if the second number =0 and return x1
		if (x2 == 0) {
			return x1;
		}

		// the 2 numbers are negative
		else if (x1 < 0 && x2 < 0) {
			sum = x1;
			for (int i = -1; i >= x2; i--) {
				sum++;
			}
		}
		return sum;

	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int quotient = 0;
		// one of the numbers are =0
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		// 2 numbers are positive
		else if (x1 > 0 && x2 > 0) {
			quotient = x1;
			for (int i = 1; i < x2; i++) {
				quotient = plus(quotient, x1); // == quotient += x1;
			}
		}
		// 2 numbers are negative
		else if (x1 < 0 && x2 < 0) {
			quotient = x1; // i=1, q=x1*1
			for (int i = -2; i >= x2; i--) { // the count staring from the second place
				quotient = plus(quotient, x1); // == quotient -= x1
			}
			quotient *= -1;

		}
		// x1 negative x2 positive
		else if (x1 < 0 && x2 > 0) {
			quotient = x1;
			for (int i = 2; i <= x2; i++) {
				quotient = plus(quotient, x1);
			}
		}
		// x1 positive x2 negative
		else if (x1 > 0 && x2 < 0) {
			quotient = x1;
			for (int i = -2; i >= x2; i--) {
				quotient = plus(quotient, x1);
			}
			quotient *= -1;
		}
		return quotient;
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
			quotient = times(x, x); // quotient= x^2
			sumQ = quotient;
			for (int i = 3; i <= n; i++) {
				quotient = times(quotient, x);
				sumQ = quotient;
			}
		}
		// if base negative, n positive and bigger 2
		else if (x < 0 && n >= 2) {
			// if n even sumQ positive
			if (n % 2 == 0) {
				quotient = times(x, x); // quotient= x^2
				sumQ = quotient;
				for (int i = 3; i <= n; i++) {
					quotient = times(quotient, x);
					sumQ = quotient;
				}
			}
			// else sumQ negative
			else {
				quotient = times(x, x); // quotient= x^2
				sumQ = quotient;
				for (int i = 3; i <= n; i++) {
					quotient = times(quotient, x);
					sumQ = quotient;
				}
				sumQ *= -1;
			}
		}
		return sumQ;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int sum = 0;
		if (x2 == 1) {
			return x1;
		} else if (x1 == 0) {
			return 0;
		} else if (x2 == 0) {
			return -1;
		} else if (x1 == x2) {
			return 1;
		}
		// 2 numbers positive
		else if (x1 > 0 && x2 > 0 && x1 > x2) {
			int x = x2;
			sum++;
			if (minus(x1, x) >= x2) {
				sum++;
				x1 = minus(x1, x);
				while (minus(x1, x) >= x2) {
				x1 = minus(x1, x);
						sum++;
				 }	
			}
		}
		// 2 numbers negative
		else if (x1 < 0 && x2 < 0) {
			if (x1 > x2) {
				sum = 0;
			} else if (x1 < x2) {
				sum++;
				while (minus(x1, x2) != 0) {
					if (minus(x1, x2) <= 0) {
						sum++;
						x1 = minus(x1, x2);
					}
				}
			}
		}
		// if one of the numbers is negative
		else if ((x1 > 0 && x2 < 0) || (x1 < 0 && x2 > 0)) {
			if (x1 < 0) {
				x1 = times(x1, -1);
			}
			else if (x2 < 0) {
				x2 = times(x2, -1);
			}
			if (x1 > x2) {
				sum++;
				int x = x2;
				while ((plus(x2, x) <= x1)) {
					x2 = plus(x2, x);
					sum++;
				}
			}
			sum = times(sum, -1);
		}

		return sum;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int sum = 0;
		sum = minus(x1, times(div(x1, x2), x2));
		 if (minus(x1, times(div(x1, x2), x2)) == 0) {
		 	return 0;
		 } else {
		 	sum = minus(x1, times(div(x1, x2), x2));
		 }
		return sum;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
		// if sqrtX^2== x
		int sqrtX = 1;
		double epsilon = 0.01;
		int increment = 1;
		while (minus(x, times(sqrtX, sqrtX)) >= epsilon) {
			sqrtX = plus(sqrtX, increment);
		}
		if (pow(sqrtX, 2) > x) {
			sqrtX--;
		}
		return sqrtX;
	}
}