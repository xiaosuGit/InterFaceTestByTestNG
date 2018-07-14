package com.xiaosu.testng;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class PostWithStringEntityOfJson {
	// post���������
	@Test
	public void f1() throws ClientProtocolException, IOException {
		// ����httpClient ����
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ���ô���
		HttpHost proxy = new HttpHost("127.0.0.1", 8888);
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		// ����httpPost���󣬴���url
		String url = "http://127.0.0.1:9999/postWithJson";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(config);
		httpPost.setHeader("content-type", "application/json");
		// �����������name=zhangsan&age=14
		String jsonString = "{\"name\":\"xixi\",\"age\":\"20\"}";
		StringEntity stringEntity = new StringEntity(jsonString, "utf-8");
		httpPost.setEntity(stringEntity);
		// �������󣬲��ҽ�����Ӧ
		CloseableHttpResponse response = httpClient.execute(httpPost);
		// ��ȡ������Ӧͷ����
		Header[] headers = response.getAllHeaders();
		// ��ȡ��Ӧʵ�����ݲ�����ת��
		HttpEntity entity = response.getEntity();
		String entityString = EntityUtils.toString(entity, "utf-8");
		System.out.println(entityString);
		// �ر�����
		httpClient.close();
	}
}