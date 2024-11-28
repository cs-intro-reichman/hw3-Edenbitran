

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.

		//  System.out.println(isAnagram("silent", "listen")); // true
		//  System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		//  System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		//  System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true


		// Tests the preProcess function.
		//System.out.println(preProcess("What? No way!!!"));
		//  String str1 = preProcess("");
		//  //System.out.println(str1);
		//  String str2 = preProcess("");
		//  //System.out.println(str2);
		// System.out.println(isAnagram(str1, str2));


		// System.out.println("********************");
		//// Tests the randomAnagram function.
		//System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		System.out.println(randomAnagram("hello"));
		 
		// // Performs a stress test of randomAnagram
		// String str = "1234567";
		// Boolean pass = true;
		// //// 10 can be changed to much larger values, like 1000
		// for (int i = 0; i < 10; i++) {
		// String randomAnagram = randomAnagram(str);
		// System.out.println(randomAnagram);
		// pass = pass && isAnagram(str, randomAnagram);
		// if (!pass)
		// break;
		// }
		// System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean bool = false;
		String cStr1 = preProcess(str1);
		String cStr2 = preProcess(str2);
		String abcS1 = (abc(preProcess(cStr1)));
		String abcS2 = (abc(preProcess(cStr2)));
		//check the length of the strings
		for (int i = 0; i < cStr1.length(); i++) {
			if (cStr1.length() == cStr2.length()) {
				bool = true;
			} else {
				return false;
			}
		}
		//System.out.println(cStr1 + "-> " + abcS1 + "\n" + cStr2 + "-> " + abcS2);
		if (abcS1.equals(abcS2)) {
			bool = true;
		}
		else {
			return false;
		}
		return bool;
	}
	
	//abc order
	public static String abc(String str) {
		String abcS = "";
		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < str.length(); i++) {
				if (ch==str.charAt(i)) {
					abcS += ch;
				}
			}
		}
		return abcS;	
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String inString = "";
		str = str.toLowerCase();
		// adding the empty string only the abc
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				inString += str.charAt(i);
			}
		}
		return inString;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		System.out.println(str);
		return str;
	}
}
