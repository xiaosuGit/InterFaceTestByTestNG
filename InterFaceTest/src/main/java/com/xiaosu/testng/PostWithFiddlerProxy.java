package com.xiaosu.testng;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class PostWithFiddlerProxy {
	@Test
	public void f1() throws ClientProtocolException, IOException {
		// 创建httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 设置代理
		HttpHost proxy = new HttpHost("127.0.0.1", 8888);
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		// 创建httpPost对象，传入url
		String url = "http://127.0.0.1:9999/postwithParam";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(config);
		httpPost.setHeader("content-type", "application/x-www-form-urlencoded");
		// 添加请求参数name=xixi&sex=man
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		StringEntity stringEntity = new StringEntity("name=xixi&sex=man", "utf-8");
		httpPost.setEntity(stringEntity);
		// 发送请求，并且接收响应
		CloseableHttpResponse response = httpClient.execute(httpPost);
		// 提取返回响应头内容
		Header[] headers = response.getAllHeaders();
		// 获取响应实体内容并编码转换
		HttpEntity entity = response.getEntity();
		String entityString = EntityUtils.toString(entity, "utf-8");
		System.out.println(entityString);
		// 关闭连接
		httpClient.close();

	}
}
