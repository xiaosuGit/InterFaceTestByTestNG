package com.xiaosu.testng;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

public class Str {
	@Test
	public void f1() {
		String str = "name=zhangsan&age=14";
		String[] splitArr = str.split("&");
		for (String string : splitArr) {
			System.out.println(string);
		}
		// 创建httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("");
		StringEntity stringEntity = new StringEntity("", "utf-8");
		httpPost.setEntity(stringEntity);
	}
}
