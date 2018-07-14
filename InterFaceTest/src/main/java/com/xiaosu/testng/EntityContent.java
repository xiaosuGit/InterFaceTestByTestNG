package com.xiaosu.testng;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

public class EntityContent {
	// get请求
	@Test
	public void f1() throws ClientProtocolException, IOException {
		// 创建httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet对象，传入url
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		// 设置头部信息
		httpGet.setHeader("Accept-Encoding", "gzip, deflate");
		// 发送请求，并且接收响应
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 提取返回响应头内容:获取cookie
		Header header = response.getFirstHeader("Set-Cookie");
		System.out.println(header);
		// 获取响应实体内容并保存到文本中
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			BufferedInputStream bis = new BufferedInputStream(entity.getContent());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("baidu.txt"));
			int n;
			while ((n = bis.read()) != -1) {
				bos.write(n);
			}
			bos.close();
			bis.close();
		}
		// 关闭连接
		httpClient.close();
	}
}
