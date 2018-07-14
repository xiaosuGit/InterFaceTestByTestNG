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
	// get����
	@Test
	public void f1() throws ClientProtocolException, IOException {
		// ����httpClient ����
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ����httpGet���󣬴���url
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		// ����ͷ����Ϣ
		httpGet.setHeader("Accept-Encoding", "gzip, deflate");
		// �������󣬲��ҽ�����Ӧ
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// ��ȡ������Ӧͷ����:��ȡcookie
		Header header = response.getFirstHeader("Set-Cookie");
		System.out.println(header);
		// ��ȡ��Ӧʵ�����ݲ����浽�ı���
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
		// �ر�����
		httpClient.close();
	}
}
