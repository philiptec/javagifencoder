package com.camelcasing.image.gif.test;

import org.junit.Test;

import com.camelcasing.image.gif.GIFUtils;

import static org.junit.Assert.assertEquals;

public class UtilTest {

	@Test
	public void createByteFromStringTest(){
		assertEquals("111", GIFUtils.getBitsFromInt(103, 3));
		assertEquals("000", GIFUtils.getBitsFromInt(0, 3));
		assertEquals("1100111", GIFUtils.getBitsFromInt(103, 7));
		assertEquals("011", GIFUtils.getBitsFromInt(3, 3));
		assertEquals("111", GIFUtils.getBitsFromInt(7, 3));
		assertEquals("101", GIFUtils.getBitsFromInt(5, 3));
	}
	
	@Test
	public void createByteFromStringLarge(){
		assertEquals("000000000011", GIFUtils.getBitsFromInt(3, 12));
	}
	
	@Test 
	public void getPlusLenTest(){
		assertEquals("101", GIFUtils.getBitsFromInt(183, 3, 2));
	}
	
	@Test 
	public void getPlusLenTest2(){
		assertEquals("101", GIFUtils.getBitsFromInt(5, 3, 0));
	}
	
	@Test
	public void getPlusLenTest3(){
		assertEquals("10110110", GIFUtils.getBitsFromInt(46777, 8, 8));
	}
	
	@Test
	public void getPlusLenTest4(){
		assertEquals("00001100", GIFUtils.getBitsFromInt(12, 8, 0));
	}
	
	@Test
	public void bitsRequired(){
		assertEquals(2, GIFUtils.numberOfBitsRequired(1));
	}
	
	@Test
	public void bitsRequired2(){
		assertEquals(3, GIFUtils.numberOfBitsRequired(2));
	}
	
	@Test
	public void bitsRequired3(){
		assertEquals(4, GIFUtils.numberOfBitsRequired(3));
	}
	
	@Test
	public void bitsRequired4(){
		assertEquals(8, GIFUtils.numberOfBitsRequired(7));
	}	
	
	@Test
	public void powerTest(){
		assertEquals(256.0, Math.pow(2, 8), 0.5);
	}
	
	@Test 
	public void twoByteTest1(){
		String s1 = GIFUtils.getBitsFromInt(46777, 8, 0);
		String s2 = GIFUtils.getBitsFromInt(46777, 8, 8);
		int b1 = Integer.valueOf(s1, 2);
		int b2 = Integer.valueOf(s2, 2);
		assertEquals(46777, (b2 << 8) + b1 );
	}
	
	@Test 
	public void twoByteTest2(){
		String s1 = GIFUtils.getBitsFromInt(12, 8, 0);
		String s2 = GIFUtils.getBitsFromInt(12, 8, 8);
		int b1 = Integer.valueOf(s1, 2);
		int b2 = Integer.valueOf(s2, 2);
		assertEquals(12, (b2 << 8) + b1 );
	}
	
	@Test 
	public void twoByteTest3(){
		int num = 12;
		String s1 = GIFUtils.getBitsFromInt(num, 8, 0);
		String s2 = GIFUtils.getBitsFromInt(num, 8, 8);
		int b1 = Integer.valueOf(s1, 2);
		int b2 = Integer.valueOf(s2, 2);
		assertEquals(num, (b2 << 8) + b1 );
	}
}
