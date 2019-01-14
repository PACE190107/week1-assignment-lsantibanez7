package com.revature.eval.java.core;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		ArrayList<Character> acro = new ArrayList<Character>();
		
		acro.add(phrase.charAt(0));
		
		for(int i = 0; i <= phrase.length()-1; i++  )
		{
			if(Character.isWhitespace(phrase.charAt(i)) || phrase.charAt(i) == '-') {
				if(i != phrase.length()-1)
				{
					acro.add(phrase.charAt(i+1));
				}
			}
		}
		StringBuilder newString = new StringBuilder(acro.size());
		for(Character ch: acro)
	    {
	        newString.append(ch);
	    }
		return newString.toString().toUpperCase();
		
		
	}//Completed all tests passed
	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne == sideTwo)
			{
				if(sideTwo == sideThree) {
					return true;
				}
				else
					return false;
			}
			else
				return false;
		}

		public boolean isIsosceles() {
			if(sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree)
			{
				return true;
			}
			else
				return false;
		}

		public boolean isScalene() {
			if(isEquilateral() || isIsosceles())
			{
				return false;
			}
			else
				return true;
		}

	}//completed passed all tests

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int total = 0;
		for(int i = 0; i <= string.length()-1; i++) {
			char c = string.toUpperCase().charAt(i);
			if( c == 'Q' || c == 'Z' ) {
				total = total + 10;
			}
			else if(c == 'J' || c == 'X') {
				total = total + 8;
			}
			else if(c == 'K') {
				total = total + 5;
			}
			else if(c == 'F' || c == 'H' || c == 'V' || c == 'W' || c == 'Y') {
				total = total + 4;
			}
			else if(c == 'B' || c == 'C' || c == 'M' || c == 'P') {
				total = total + 3;
			}
			else if(c == 'D' || c == 'G') {
				total = total + 2;
			}
			else total = total +1;
		}
		return total;
	}//completed passed all tests

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		char[] number = new char[20];
		int j = 0;
			for(int i = 0; i <= string.length()-1; i++) {
				
				if(Character.isDigit(string.charAt(i))){
					number[j] = string.charAt(i);
					j++;
				}
		}
		
			char[] array2 = Arrays.copyOfRange(number, 0, 10);
			String b =  new String(array2);
			if(j >= 11 || j < 10) {
				throw new IllegalArgumentException();
			}
			else {
				return b;
			}
		}	//completed passed all tests. 
	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> t = new HashMap<String, Integer>();
		String split[] = string.split("[, ?.@\n]+");
		
		for(int i = 0; i <= split.length-1; i++) {
			if(t.get(split[i]) == null)
			{
				t.put(split[i], 1);
			}else {
				int a = t.get(split[i]);
				t.put(split[i], a+1);
			}
			
		}
		
		return t;
	}//completed passed all tests. 

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int a = sortedList.size();
			int c = a/2;
			
			if(a%2 == 0) {
				
				int twoNumMean = ((int)sortedList.get(c) + (int)sortedList.get(c-1))/2;
				
				if((int)t < twoNumMean) {
					for(int i = 0; i <= c-1; i++) {
						if(sortedList.get(i).equals(t)) {
							return i;
						}
					}
					
				}else {
					for(int i = c; i <= a-1; i++) {
						if(sortedList.get(i).equals(t)) {
							return i;
						}
					}
				}
				
				
			}else {
					
				if(t.hashCode() < sortedList.get(c).hashCode()) {
					for(int i = 0; i <= c; i++) {
						if(sortedList.get(i).equals(t)) {
							return i;
						}
					}
						
				}
				else {
					for(int i = c; i <= a-1; i++) {
						if(sortedList.get(i).equals(t)) {
							return i;
							}
					}
				}
			}
			
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String split[] = string.split(" ");
		ArrayList<String> k = new ArrayList<String>();
		
		for(int i = 0; i <= split.length-1; i++) {
			String a = split[i];
			StringBuilder b = new StringBuilder();
			ArrayList<Character> t = new ArrayList<Character>();
			
			for(int j = 0; j <= a.length()-1; j++) {
				t.add(a.charAt(j));
			}
			
			if(t.get(0) == 'a'|| t.get(0) == 'e'||t.get(0) == 'i'
					|| t.get(0) =='o'|| t.get(0) == 'u') {
					t.add('a');
					t.add('y');	
			}else if(t.get(0) == 'b'||t.get(0) == 'c'||t.get(0) == 'd'
					||t.get(0) == 'f'||t.get(0) == 'g'||t.get(0) == 'h'
					||t.get(0) == 'j'||t.get(0) == 'k'||t.get(0) == 'l'
					||t.get(0) == 'm'||t.get(0) == 'n'||t.get(0) == 'p'
					||t.get(0) == 'r'||t.get(0) == 's'
					||t.get(0) == 't'||t.get(0) == 'v'||t.get(0) == 'x'
					||t.get(0) == 'z'||t.get(0) == 'w'||t.get(0) == 'y') {
				
				while(t.get(0) != 'a'&& t.get(0) != 'e'&& t.get(0) != 'i'
					&& t.get(0) !='o'&& t.get(0) != 'u') {
					t.add(t.get(0));
					t.remove(0);	
				}
				t.add('a');
				t.add('y');
			}else if(t.get(0) == 'q') {
				t.add(t.get(0));
				t.remove(0);
				t.add(t.get(0));
				t.remove(0);
				t.add('a');
				t.add('y');
			}
			for(Character ch: t) {
				b.append(ch);
			}
			k.add(b.toString());
			
			
		}
		StringBuilder result = new StringBuilder(k.size());
		for(int i = 0; i <= k.size()-1; i++) {
			result.append(k.get(i));
			if(i < k.size()-1) {
				result.append(" ");
			}
		}
		
		return result.toString();
	}//completed passed all tests.

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		 String number = Integer.toString(input);
		 double total = 0;
		 int length = number.length();
		 for(int i = 0; i < length; i ++) {
			 int a = Integer.parseInt(String.valueOf(number.charAt(i)));
			 total = total + Math.pow(a,length);
		 }
		 if(total == (double)input)
		 {
			 return true;
		 }
		 else {
			 return false;
		 }//completed passed all tests. 
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		long p = l;
		List<Long> result = new ArrayList<Long>();
		 for(int i = 2; i<= p; i++) {
	         while(p%i == 0) {
	        	p = p/i;
	            result.add(Long.valueOf(i));
	            
	         }
	      }
		return result;
	}//Completed passed all tests.

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			Character[] a = new Character[] {'a','b','c','d','e','f','g','h','i','j','k','l','m',
					'n','o','p','q','r','s','t','u','v','w','x','y','z'};
			ArrayList<Character> t = new ArrayList<Character>();
			
			for(int i = 0 ; i <= string.length()-1; i++) {
				t.add(string.charAt(i));
			}
			
	
			for(int i = 0; i <= t.size()-1; i++) {
				int k = Arrays.asList(a).indexOf(Character.toLowerCase(t.get(i)));
				if(Character.isLetter(t.get(i))){
					if(Character.isUpperCase(t.get(i))) {
						t.set(i, Character.toUpperCase(a[(k + key)%26]));
					}else {
						t.set(i, Character.toLowerCase(a[(k + key)%26]));
					}
					
				}
			}//completed passed all tests.
			
			StringBuilder newString = new StringBuilder(t.size());
			for(Character ch: t)
		    {
		        newString.append(ch);
		    }
			
		
			return newString.toString();
			
		}
	}//completed passed all tests. 

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int number = 2;
		int count = 1;
		boolean bool = true;
		
		if(i != 0) {
			while(i > count)
			{
				number++;
				bool = true;
				for(int a=2; a<number; a++){
					if(number%a == 0){
						bool = false;
					}
				}
				if(bool == true) {
					count++;
				}
			}
			
		}else {
			throw new IllegalArgumentException();
		}
		return number;
	}//completed passed all tests.

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			Character[] a = new Character[] {'a','b','c','d','e','f','g','h','i','j','k','l','m',
					'n','o','p','q','r','s','t','u','v','w','x','y','z'};
			Character[] b = new Character[] {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l',
					'k','j','i','h','g','f','e','d','c','b','a'};
			String s = string.toLowerCase();
			ArrayList<Character> t = new ArrayList<Character>();
			int counter = 0;
			for(int i = 0; i <= s.length()-1; i++) {
				if(counter < 5) {
					if(Character.isLetter(s.charAt(i))) {
						t.add(s.charAt(i));
						counter++;
					}
					else if(Character.isDigit(s.charAt(i))) {
						t.add(s.charAt(i));
						counter++;
					}
				}else {
					counter = 0;
					if(i != s.length()-1) {
						t.add(' ');
					}
					if(Character.isLetter(s.charAt(i))) {
						t.add(s.charAt(i));
						counter++;
					}
					else if(Character.isDigit(s.charAt(i))) {
						t.add(s.charAt(i));
						counter++;
					}
				}
				
			}
			
			for(int i = 0; i <= t.size()-1; i++) {
				if(Character.isLetter(t.get(i))) {
					int k = Arrays.asList(a).indexOf(t.get(i));
					t.set(i, b[k]);
				}
			}
			
			StringBuilder newString = new StringBuilder(t.size());
			for(Character ch: t)
		    {
		        newString.append(ch);
		    }
			
		
			return newString.toString();
		}//completed all tests passed.

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			Character[] a = new Character[] {'a','b','c','d','e','f','g','h','i','j','k','l','m',
					'n','o','p','q','r','s','t','u','v','w','x','y','z'};
			Character[] b = new Character[] {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l',
					'k','j','i','h','g','f','e','d','c','b','a'};
			String s = string.replaceAll("\\s+","");
			ArrayList<Character> t = new ArrayList<Character>();
			
			for(int i = 0; i <= s.length()-1; i++) {
					if(Character.isLetter(s.charAt(i))) {
						t.add(s.charAt(i));
					}
					else if(Character.isDigit(s.charAt(i))) {
						t.add(s.charAt(i));
						
					}
			}
			
			for(int i = 0; i <= t.size()-1; i++) {
				if(Character.isLetter(t.get(i))) {
					int k = Arrays.asList(a).indexOf(t.get(i));
					t.set(i, b[k]);
				}
			}
			
			StringBuilder newString = new StringBuilder(t.size());
			for(Character ch: t)
		    {
		        newString.append(ch);
		    }
			return newString.toString();
		}
	}//completed all test passed.

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		char[] isbn = new char[10];
		int j = 0;
		for(int i = 0; i <= string.length()-1; i++) {
			if(Character.isDigit(string.charAt(i))) {
				isbn[j] =string.charAt(i);
				j++;
			}
		}
		if(j == 10)
		{
			int p = j;
			int total = 0;
			for(int i = 0; i <= 9; i++) {
				total = total + Character.getNumericValue(isbn[i])*(p);
				p--;
			}
			if(total%11 == 0) {
				return true;
			}
			else {
				return false;
			}
			
		}
		else if(j < 10) {
			if(string.charAt(string.length()-1) == 'X') {
				int p = j;
				int total = 0;
				for(int i = 0; i < 10; i++) {
					total = total + Character.getNumericValue(isbn[i])*(p+1);
					p--;
				}
				
				if(total%11 == 0) {
					return true;
				}
				else {
					return false;
				}
				
			}
			else {
				return false;
			}
		}
		return false;
	}//Completed passed all tests

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		String s = string.replaceAll("[^a-z]", ""); 
	    s = s.toLowerCase();
	    s = s.replaceAll("(.)(?=.*\\1)", "");
	    if(s.length() == 26) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	
	}//completed passed all tests

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		final long gigasecond = 1000000000;
		
		try {
        LocalDate b = LocalDate.from(given);
        LocalTime k = LocalTime.from(given);
        LocalDateTime c = k.atDate(b);
        return c.plusSeconds(gigasecond);
		}catch(DateTimeException e) {
			
		}
        LocalDate b = LocalDate.from(given);
       
        LocalDateTime c = b.atStartOfDay();
        
          return c.plusSeconds(gigasecond);
	}//completed all tests passed.

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		ArrayList<Integer> b = new ArrayList<Integer>();
		int total = 0;
		
		for(int a = 0; a <= set.length-1; a ++) {
			int x = set[a];
			int subtotal = x;
			while(subtotal < i) {
				b.add(subtotal);
				subtotal = subtotal + x;
			}
		}
		for(int k = 0; k < b.size(); k++) {
			for(int j = 0; j < b.size(); j++) {
				if(b.get(k).equals(b.get(j)) && k != j) {
					b.remove(j);
				}
			}
		}
		for(int k = 0; k < b.size(); k++) {
			total = total + b.get(k);
		}
		
		
		return total;
	}//completed passed all tests.

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int total = 0;
		for(int i = 0; i < string.length(); i++) {
			if(Character.isLetter(string.charAt(i))) {
				return false;
			}
			if(Character.isDigit(string.charAt(i)) && string.charAt(i) != '-'){
				a.add(Character.getNumericValue(string.charAt(i)));
				
			}
		}
		for(int i = a.size()-2; i >= 0; i -= 2) {
			int b = a.get(i);
			b = b*2;
			if(b > 9) {
				b = b-9;
				a.add(b);
			}
			else {
				a.add(b);
			}
		}
		
		for(int i = 0; i <= a.size()-1; i ++) {
			total = total + a.get(i);
		}
		if(total%10 == 0) {
			return true;
		}
		else {
			return false;
		}
		
		
	}//Completed passed all tests.

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
			StringBuilder sb = new StringBuilder(string);
			sb.deleteCharAt(sb.length()-1);
			String resultString = sb.toString();
			String split[] = resultString.split(" ");
			int num[] = new int[2];
			int n = 0;
			int total = 0;
			int length = split.length;
			for(int i = 0; i <= length-1; i++) {
				if(split[i].matches("-?\\d+(\\.\\d+)?")) {
					num[n] = Integer.parseInt(split[i]);
					n++;
				}
			}
			
			
			if(split[3].contentEquals("plus")) {
				total = num[0] + num[1];
			}
			else if(split[3].contentEquals("minus")) {
				total = num[0] - num[1];
			}
			else if(split[3].contentEquals("multiplied")) {
				total = num[0] * num[1];
			}
			else if(split[3].contentEquals("divided")) {
				total = num[0]/num[1];
			}
				return total;
	}//Completed passed all tests

}
