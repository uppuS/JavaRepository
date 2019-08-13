package com.virtusa;

/**
 * NumberToWord Converter *
 */
public class NumberToWord 
{
	private static final int TEN = 10;
	private static final int ONE_HUNDRED = 100;
	private static final int ONE_THOUSAND = 1000;
	private static final int ONE_MILLION = 1000000;
	private static final int ONE_BILLION = 1000000000;
	private static final int MAX_VALUE = ONE_BILLION;

	private static final String[] DIGITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static final String[] TENS = {"NaN", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static final String[] TEENS = {"NaN", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static final String EMPTY_STRING = "";
	private static final String SPACE = " ";

	public static String translate(final int i) {
		if (i < TEN)
			return translateSingleDigit(i);
		else if (i < ONE_HUNDRED)
			return translateTens(i);
		else if (i < ONE_THOUSAND)
			return translate(i, ONE_HUNDRED, "hundred");
		else if (i < ONE_MILLION)
			return translate(i, ONE_THOUSAND, "thousand");
		else if (i < ONE_BILLION)
			return translate(i, ONE_MILLION, "million");
		else
			throw new IllegalArgumentException("I don't understand numbers bigger than " + MAX_VALUE);
	}

	private static String translateSingleDigit(final int i) {
		return DIGITS[i];
	}

	private static String translateTens(final int i) {
		int scaledDown = scaledDown(i, TEN);
		int remainder = remainder(i, TEN);
		if (remainder == 0)
			return TENS[scaledDown];
		else if (i > 20)
			return translate(i - remainder) + SPACE + translate(remainder);
		else
			return TEENS[i - TEN];
	}

	private static String translate(final int i, final int scale, final String separator) {
		int scaledDown = scaledDown(i, scale);
		int remainder = remainder(i, scale);
		return translate(scaledDown) + SPACE + separator + translateRemainder(remainder);
	}

	private static String translateRemainder(final int remainder) {
		if (remainder > 0)
			return lessThanOneHundredSpecialCase(remainder) + SPACE + translate(remainder);
		else
			return EMPTY_STRING;
	}

	private static String lessThanOneHundredSpecialCase(final int remainder) {
		if (remainder < ONE_HUNDRED)
			return " and";
		else
			return EMPTY_STRING;
	}

	private static int scaledDown(final int i, final int scale) { return i/scale; }
	private static int remainder(final int i, final int scale) { return i%scale; }

	public static void main(String[] args) { 

		String word = ""; 
		try { 

			// word = NumberToWord.translate(21); 
			// word = NumberToWord.translate(105); 
			 word = NumberToWord.translate(56945781); 
			// word = NumberToWord.translate(999999999); 			

		} catch (Exception e) { 
			System.out.println("error: "+e.getMessage()); 
		} 
		System.out.println(word); 
	}

}

