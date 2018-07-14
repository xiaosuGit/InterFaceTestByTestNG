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
		System.out.println("before Suite����");
	}

	@AfterSuite
	public void as() {
		System.out.println("after Suite����");
	}

	@BeforeClass
	public void bc() {
		System.out.println("before Class ����");
	}

	@AfterClass
	public void ac() {
		System.out.println("after Class����");
	}

	@Test
	public void testCase1() {
		System.out.println("Test1 ����");
	}

	@Test
	public void testCase2() {
		System.out.println("Test2 ����");
	}

	@BeforeMethod
	public void f1() {
		System.out.println("before Method����");
	}

	@AfterMethod
	public void f2() {
		System.out.println("after Method ����");
	}
}
