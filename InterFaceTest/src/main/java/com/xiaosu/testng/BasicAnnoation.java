package com.xiaosu.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAnnoation {

	@BeforeSuite
	public void bs() {
		System.out.println("before Suite运行");
	}

	@AfterSuite
	public void as() {
		System.out.println("after Suite运行");
	}

	@BeforeClass
	public void bc() {
		System.out.println("before Class 运行");
	}

	@AfterClass
	public void ac() {
		System.out.println("after Class运行");
	}

	@Test
	public void testCase1() {
		System.out.println("Test1 运行");
	}

	@Test
	public void testCase2() {
		System.out.println("Test2 运行");
	}

	@BeforeMethod
	public void f1() {
		System.out.println("before Method运行");
	}

	@AfterMethod
	public void f2() {
		System.out.println("after Method 运行");
	}
}
