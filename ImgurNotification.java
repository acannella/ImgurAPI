import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

//TO-DO: This entire class needs to be tested 


public class ImgurNotification {
	
	private String accessToken;
	
	public ImgurNotification(String token){
		accessToken=token;
	}
	
	public String getNotifications() throws IOException{
		
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
		System.out.println("Getting Notifications.");
		
		String notifications=response.toString();
		
		
		
		
		
		return notifications;
	}
	
	public String notificationInfo(String notifID) throws ClientProtocolException, IOException{
		
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
		System.out.println("Getting Notification Info.");
		
		String notifiInfo=response.toString();
		
		
		
		return notifiInfo;
	}
	
	public void markViewed(String notifID) throws ClientProtocolException, IOException{
		String markURL="https://api.imgur.com/3/notification/"+notifID;
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

		//add it a check to see which response is sent back, the display text for success or failure
		String toJSON=response.toString();
		System.out.println(toJSON);
		httpClient.close();
	}
	

}
