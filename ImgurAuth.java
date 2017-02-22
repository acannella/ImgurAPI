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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ImgurAuth {	
	private String clientID;	
	private String secret;
	private String accessToken;
	private String refreshToken;
	private String pin;
	
	

	public ImgurAuth(String id,String asecret){
		clientID=id;
		secret=asecret;
		accessToken=null;
		refreshToken=null;
		
	}
	
	public String getClientID(){
		return clientID;
	}
	
	public String getPinURL(){
		return "https://api.imgur.com/oauth2/authorize?client_id="+clientID+"&response_type=pin";
	}
	public String generateAccessToken(String aPin) throws ParseException, ClientProtocolException, IOException{
		pin=aPin;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONParser parser = new JSONParser();
		String toJSON=null;
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("client_id",clientID));
		urlParameters.add(new BasicNameValuePair("client_secret",secret));
		urlParameters.add(new BasicNameValuePair("grant_type","pin"));
		urlParameters.add(new BasicNameValuePair("pin",pin));
		HttpEntity postParams=null;
			
		postParams = new UrlEncodedFormEntity(urlParameters);
		 
		HttpPost post=new HttpPost("https://api.imgur.com/oauth2/token/");
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
		
		System.out.println(httpResponse.getStatusLine());
		
		accessToken=jsonResponse.get("access_token").toString();
		refreshToken=jsonResponse.get("refresh_token").toString();	
		
		httpClient.close();
		
		return httpResponse.getStatusLine().toString();
		
		
	}
	
	public String useRefreshToken(String token) throws IOException, ParseException{
		
		refreshToken=token;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONParser parser = new JSONParser();
		String toJSON=null;
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("refresh_token",refreshToken));
		urlParameters.add(new BasicNameValuePair("client_id",clientID));
		urlParameters.add(new BasicNameValuePair("client_secret",secret));
		urlParameters.add(new BasicNameValuePair("grant_type","refresh_token"));
		HttpEntity postParams=null;
	
		postParams = new UrlEncodedFormEntity(urlParameters);
		
		HttpPost post=new HttpPost("https://api.imgur.com/oauth2/token/");
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
		
		accessToken=jsonResponse.get("access_token").toString();
		
		httpClient.close();
		
		return httpResponse.getStatusLine().toString();
		
	}
	
	
	public String getAccessToken(){
		return accessToken;
	}
	
	public String getRefreshToken(){
		return refreshToken;
	}

}