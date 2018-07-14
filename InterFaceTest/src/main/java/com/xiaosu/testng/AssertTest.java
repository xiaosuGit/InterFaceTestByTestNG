package com.xiaosu.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {

	@Test
	public void f1() {
		try {
			Assert.assertTrue(1 == 1);
		} catch (AssertionError e) {
			Assert.fail("¹þ¹þ");
		}
	}
}
