package org.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class smaple {
	
	@BeforeClass
	public static void bcclass() {
		System.out.println("bc class");

	}
	@AfterClass
	public static void acclass() {
		System.out.println("ac class");
		
	}
	@Before
	public void be() {
		System.out.println("bc--1");

	}
	@After
	public void af() {
		System.out.println("ac--1");

	}
	@Test
	public void text1() {
		System.out.println("test--1");

	}
	@Test
	public void text2() {
		System.out.println("text--2");

	}

}
