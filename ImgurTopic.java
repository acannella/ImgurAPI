import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ImgurTopic {
	private String ID;
	
	public ImgurTopic(String id){
		ID=id;
	}
	
	public String getDefaultTopics() throws ClientProtocolException, IOException{
		String topicList = null;
		String topicURL=new String("https://api.imgur.com/3/topics/defaults");
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(topicURL);
		httpGet.setHeader("Authorization","client-id "+ID);
		
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		System.out.println("Getting Default Topics.");
		
		topicList=response.toString();
		
		System.out.println(topicList);
		
		
		
		return topicList;
	}
	
	public String galleryTopic(String topicID) throws ClientProtocolException, IOException{
		String galleryItems=null;
		String galleryTopicURL="https://api.imgur.com/3/topics/"+topicID;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(galleryTopicURL);
		httpGet.setHeader("Authorization","client-id "+ID);
		
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		System.out.println("Getting Default Topics.");
		
		galleryItems=response.toString();
		
		System.out.println(galleryItems);
		
		
		
		return galleryItems;
	}

}
