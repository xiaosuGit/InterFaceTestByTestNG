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
	// get����
	@Test
	public void f1() throws ClientProtocolException, IOException {
		// ����httpClient ����
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ����httpGet���󣬴���url
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		// �������󣬲��ҽ�����Ӧ
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// ��ȡ������Ӧͷ����
		Header[] headers = response.getAllHeaders();
		for (Header header : headers) {
			System.out.print(header.getName()+"\t"+header.getValue());
			System.out.println();
		}
		// ��ȡ��Ӧʵ�����ݲ�����ת��
		HttpEntity entity = response.getEntity();
		String entityString = EntityUtils.toString(entity, "utf-8");
		System.out.println(entityString);
		// �ر�����
		httpClient.close();
	}
}
