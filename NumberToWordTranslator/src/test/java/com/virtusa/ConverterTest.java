package com.virtusa;

import org.junit.Test;

import com.virtusa.NumberToWord;

import static org.junit.Assert.*;
public class ConverterTest {
	NumberToWord numberToWordConverter = new NumberToWord();

	@Test 
	public void shouldTakeANumberAndGiveTheEquivalentNumberInBritishEnglishWords() {
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", numberToWordConverter.translate(56945781));
	}

	@Test 
	public void shouldTranslateTheMaximumValue() {
		assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", numberToWordConverter.translate(999999999));
	}

}
