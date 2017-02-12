import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

//TO-DO: Determine if you need to send access token--probably do

public class ImgurComment {
	private String ID;
	
	public ImgurComment(String clientID){
		ID=clientID;
	}
	
	public String getComment(String commentID) throws ClientProtocolException, IOException{
		String commentInfo=null;
		String commentLink="https://api.imgur.com/3/comment/"+commentID;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(commentLink);
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

	    commentInfo=response.toString();
		
		httpClient.close();
		
		
		
		return commentInfo;
	}
	
	public void createComment(String imageID, String comment) throws ClientProtocolException, IOException{
		String createComment= "https://api.imgur.com/3/comment";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String toJSON=null;
		
		HttpPost post=new HttpPost(createComment);
		post.setHeader("Authorization","client-id "+ID);
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("image_id",imageID));
		urlParameters.add(new BasicNameValuePair("comment",comment));
	
	
		CloseableHttpResponse httpResponse;
		
			httpResponse = httpClient.execute(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));
		
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			toJSON=response.toString();
		
			
		
		
		System.out.println(toJSON);
		
	}
	//definitely will need to logged in to do this one
	public void deleteComment(String commentID,String accessToken ) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete("https://api.imgur.com/3/comment/"+commentID);
		httpDelete.setHeader("Authorization","Bearer "+accessToken);
		CloseableHttpResponse httpResponse=null;
		
		httpResponse = httpClient.execute(httpDelete);
		
		
		BufferedReader reader=null;
			reader = new BufferedReader(new InputStreamReader(
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
	
	public String getRepliesComment(String commentID) throws ClientProtocolException, IOException{
		String comment=null;
		String parentComment="https://api.imgur.com/3/comment/"+commentID+"/replies";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(parentComment);
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

	    comment=response.toString();
		
		httpClient.close();
		
		
		return comment;
	}
	
	public void createReply(String imageID, String comment, String commentID) throws ClientProtocolException, IOException{
		String voteLink="https://api.imgur.com/3/comment/" +commentID;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String toJSON=null;
		
		HttpPost post=new HttpPost(voteLink);
		post.setHeader("Authorization","client-id "+ID);
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("image_id",imageID));
		urlParameters.add(new BasicNameValuePair("comment",comment));
	
	
		CloseableHttpResponse httpResponse;
		
			httpResponse = httpClient.execute(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));
		
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			toJSON=response.toString();
		
			
		System.out.println(toJSON);
		
	}
	
	public void commentVote(String commentID, String vote) throws ClientProtocolException, IOException{
		String voteLink="https://api.imgur.com/3/comment/" +commentID+  "/vote/"+vote;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String toJSON=null;
		
		HttpPost post=new HttpPost(voteLink);
		post.setHeader("Authorization","client-id "+ID);
	
	
		CloseableHttpResponse httpResponse;
		
			httpResponse = httpClient.execute(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));
		
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			toJSON=response.toString();
		
			System.out.println("An error occurred during the Post Phase.");
			
	
			System.out.println("Response from server could no be translated to JSON Format");
		
		System.out.println(toJSON);
	}
	
	public void reportComment(String commentID, int reason){
		
	}
	

}
