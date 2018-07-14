package com.xiaosu.testng;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class EntityUtilsToString {
	// get请求
	@Test
	public void f1() throws ClientProtocolException, IOException {
		// 创建httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet对象，传入url
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		// 发送请求，并且接收响应
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 提取返回响应头内容
		Header[] headers = response.getAllHeaders();
		for (Header header : headers) {
			System.out.print(header.getName()+"\t"+header.getValue());
			System.out.println();
		}
		// 获取响应实体内容并编码转换
		HttpEntity entity = response.getEntity();
		String entityString = EntityUtils.toString(entity, "utf-8");
		System.out.println(entityString);
		// 关闭连接
		httpClient.close();
	}
}
