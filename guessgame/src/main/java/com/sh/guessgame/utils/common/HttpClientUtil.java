package com.sh.guessgame.utils.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpClientUtil {
//	private HttpURLConnection connection;
	
	public HttpClientUtil(){
	}
	
	public String doPost(String url, Map<String, String> param){
		StringBuilder builder = new StringBuilder();
		String message = paramForm("post", param);
		
		BufferedWriter writer = null;
		BufferedReader reader = null;
		HttpURLConnection connection = null;
		try {
			URL url2 = new URL(url);
			
			connection = (HttpURLConnection) url2.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.setRequestProperty("Content-type", "application/json");
			connection.setRequestMethod("POST");
			// 创建连接
			connection.connect();
			if(message != null){
				writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
				writer.write(message);
				writer.flush();
			}

			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			while((line = reader.readLine()) != null){
				builder.append(line);
				line = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null){
				connection.disconnect();
			}
		}
		
		return builder.toString();
	}
	
	public String doGet(String url, Map<String, String> param){
		StringBuilder builder = new StringBuilder();
		String message = paramForm("get", param);
		
		BufferedReader reader = null;
		HttpURLConnection connection = null;
		try {
			if(StringUtil.isNotEmpty(message)){
				url = url+ "?"+message;
			}
			URL url2 = new URL(url);
//			url2.set
			connection = (HttpURLConnection) url2.openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			connection.setRequestMethod("GET");
			// 创建连接
			connection.connect();
			if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = null;
				while((line = reader.readLine()) != null){
					builder.append(line);
					line = null;
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return builder.toString();
	}
	
	
	// 获取connection
//	private HttpURLConnection getConnection(){}
	
	//参数组装
	private String paramForm(String method, Map<String, String> map){
		if(map == null){
			return null;
		}
		
		if("POST".equalsIgnoreCase(method)){
			return GsonUtil.ObjectToString(map);
		}
		
		if("GET".equalsIgnoreCase(method)){
			StringBuilder builder = new StringBuilder();
			for(String key : map.keySet()){
				builder.append(key).append("=").append(map.get(key)).append("&");
			}
			String tString = builder.toString();
			return tString.substring(0, tString.length()-1);
		}
		
		return null;
	}
}
