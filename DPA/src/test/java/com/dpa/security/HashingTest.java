/**
 * 
 */
package com.dpa.security;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class HashingTest {
	/**
	 * Test method for {@link com.dpa.security.Hashing#hashString(java.lang.String, java.lang.String)}.
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testHashString() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Hashing hashTest = new Hashing();
		String hashedValue = hashTest.hashString("Test@432", "MD5");
		assertEquals("d232704062b0fea5c8d5b869cddef2a5", hashedValue);
	}

	/**
	 * Test method for {@link com.dpa.security.Hashing#convertByteArrayToHexString(byte[])}.
	 */
	@Test
	public void testConvertByteArrayToHexString() {
		Hashing hashTest = new Hashing();
		byte[] hashedbytes = {43, -122, 76, -83, 14, -34, -103, 44, 47, -79, 57, 84, -48, 99, -116, -87};
		String hashedValue = hashTest.convertByteArrayToHexString(hashedbytes);
		assertEquals("2b864cad0ede992c2fb13954d0638ca9", hashedValue);
	}

	/**
	 * Test return type of convertByteArrayToHexString() method.
	 */
	@Test
	public void testGetClass() {
		Hashing hashTest = new Hashing();
		byte[] hashedbytes = {43, -122, 76, -83, 14, -34, -103, 44, 47, -79, 57, 84, -48, 99, -116, -87};
		Class c = (hashTest.convertByteArrayToHexString(hashedbytes)).getClass();
		assertEquals("java.lang.String", (hashTest.convertByteArrayToHexString(hashedbytes)).getClass().getName());
	}

	@Test
	public void testReturnType() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Hashing hashTest = new Hashing();
		assertEquals("java.lang.String", (hashTest.hashString("Test@432", "MD5")).getClass().getName());
	}
	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testHashCodeLength() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Hashing hashTest = new Hashing();
		String hashedValue = hashTest.hashString("Test@432", "MD5");
		int length = hashedValue.length();
		assertEquals(32, length);
	}


}
