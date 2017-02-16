import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//TO-DO: Should these all be static?

public class ImgurComment {
	
	public static String getComment(String commentID,String clientID) throws ClientProtocolException, IOException{
		String commentInfo=null;
		String commentLink="https://api.imgur.com/3/comment/"+commentID;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(commentLink);
		httpGet.setHeader("Authorization","client-id "+clientID);
		
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
		
		System.out.println(httpResponse.getStatusLine());
		
		return commentInfo;
	}
	
	public static String createComment(String imageID, String comment,String accessToken) throws IOException, ParseException{
		JSONParser parser = new JSONParser();
		String createComment= "https://api.imgur.com/3/comment";
		String commentID=null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String toJSON=null;
		
		HttpPost post=new HttpPost(createComment);
		post.setHeader("Authorization","Bearer "+accessToken);
		
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("image_id",imageID));
		urlParameters.add(new BasicNameValuePair("comment",comment));
	
		HttpEntity postParams=null;
		
		postParams = new UrlEncodedFormEntity(urlParameters);
		post.setEntity(postParams);
	
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
			
			JSONObject jsonResponse=null;
		
			jsonResponse = (JSONObject) parser.parse(toJSON);
			toJSON=jsonResponse.get("data").toString();
			jsonResponse= (JSONObject) parser.parse(toJSON);
			commentID=jsonResponse.get("id").toString();
			System.out.println(httpResponse.getStatusLine());
			return commentID;
		
		
	}
	
	public static void deleteComment(String commentID,String accessToken ) throws ClientProtocolException, IOException{
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
		

			System.out.println(httpResponse.getStatusLine());
	
			httpClient.close();
		
	}
	
	public static String getRepliesComment(String commentID,String clientID) throws ClientProtocolException, IOException{
		String comment=null;
		String parentComment="https://api.imgur.com/3/comment/"+commentID+"/replies";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(parentComment);
		httpGet.setHeader("Authorization","client-id "+clientID);
		
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
		System.out.println(httpResponse.getStatusLine());
		
		return comment;
	}
	
	public static void createReply(String imageID, String comment, String commentID,String accessToken) throws ClientProtocolException, IOException{
		String voteLink="https://api.imgur.com/3/comment/" +commentID;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String toJSON=null;
		
		HttpPost post=new HttpPost(voteLink);
		post.setHeader("Authorization","Bearer "+accessToken);
		
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
	
	public static void commentVote(String commentID, String vote,String accessToken) throws ClientProtocolException, IOException{
		String voteLink="https://api.imgur.com/3/comment/" +commentID+  "/vote/"+vote;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost post=new HttpPost(voteLink);
		post.setHeader("Authorization","Bearer "+accessToken);
	
	
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
			
			System.out.println(httpResponse.getStatusLine());
			
	}
	
	public static void reportComment(String commentID,String accessToken, int reason) throws IOException{
		String reportLink="https://api.imgur.com/3/comment/" +commentID+  "/report";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost post=new HttpPost(reportLink);
		post.setHeader("Authorization","Bearer "+accessToken);
	
	
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
			
			System.out.println(httpResponse.getStatusLine());
		
	}
	

}
