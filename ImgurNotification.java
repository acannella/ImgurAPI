import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ImgurNotification {
	
	public static String getNotifications(String accessToken) throws IOException{
		String notificationURL="https://api.imgur.com/3/notification";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(notificationURL);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		httpClient.close();
		String notifications=response.toString();
		
		return notifications;
	}
	
	public static String notificationInfo(String accessToken, String notifID) throws IOException{
		
		String notificationURL="https://api.imgur.com/3/notification/"+notifID;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(notificationURL);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		httpClient.close();
		
		String notifiInfo=response.toString();
		
		return notifiInfo;
	}
	
	public static String markViewed(String accessToken,String notifID) throws IOException{
		String markURL="https://api.imgur.com/3/notification/"+notifID;
		String result=null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(markURL);
		httpPost.setHeader("Authorization","Bearer "+accessToken);
		CloseableHttpResponse httpResponse =httpClient.execute(httpPost);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		httpClient.close();
		result=response.toString();
		
		return result;
	}
	

}
