import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

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

public class ImgurImage {
	private String ID;
	
	public ImgurImage(String cID){
		ID=cID;
		
	}
public void accDeleteImage(String accessToken, String imageID) throws ClientProtocolException, IOException{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpDelete httpDelete = new HttpDelete("https://api.imgur.com/3/image/"+imageID);
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
	String toJSON=response.toString();
	System.out.println(toJSON);
	
		httpClient.close();
	
}

public void anonDeleteImage(String imageID) throws ClientProtocolException, IOException{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpDelete httpDelete = new HttpDelete("https://api.imgur.com/3/image/"+imageID);
	httpDelete.setHeader("Authorization","client-id "+ID);
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
	String toJSON=response.toString();
	System.out.println(toJSON);
	
		httpClient.close();
	
}
	
	

public String sendImageGET(String imageID) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/image/"+imageID);
		httpGet.setHeader("Authorization","client-id "+ID);
		
		
		CloseableHttpResponse httpResponse=null;
		
			httpResponse = httpClient.execute(httpGet);
		
	

		BufferedReader reader=null;
		
			reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));
		

		String inputLine;
		StringBuffer response = new StringBuffer();

		
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
		
		
			reader.close();
		

		String imageInfo=response.toString();
		
	
			httpClient.close();
		
		System.out.println(httpResponse.getStatusLine());
		return imageInfo;
		

}
public void accUploadImage(String accessToken, String aPath) throws IOException{
	String filePath=aPath;
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost httpPost = new HttpPost("https://api.imgur.com/3/upload");
	httpPost.setHeader("Authorization","Bearer "+accessToken);
	BufferedImage toEncode;
	String encodedImage=null;
	ByteArrayOutputStream bos=new ByteArrayOutputStream();
	filePath=filePath.replace("\\", "\\\\");
	
	toEncode=ImageIO.read(new File(filePath));
	ImageIO.write(toEncode,"jpg",bos);
			
	byte[] imageBytes = bos.toByteArray();
	encodedImage=Base64.getEncoder().encodeToString(imageBytes);
	System.out.println("End Encode");
	
	
	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	urlParameters.add(new BasicNameValuePair("image",encodedImage));
	urlParameters.add(new BasicNameValuePair("type","base64"));
	
	HttpEntity postParams=null;
	
	postParams = new UrlEncodedFormEntity(urlParameters);
	httpPost.setEntity(postParams);
	
	

	
	CloseableHttpResponse httpResponse=null;
	
	httpResponse = httpClient.execute(httpPost);
	
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
		
}


public void anonUploadImage(String aPath) throws IOException{
	
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost httpPost = new HttpPost("https://api.imgur.com/3/upload");
	httpPost.setHeader("Authorization","client-id "+ID);
	BufferedImage toEncode;
	String encodedImage=null;
	ByteArrayOutputStream bos=new ByteArrayOutputStream();
	String filePath=aPath;
	
	filePath=filePath.replace("\\", "\\\\");
	
	toEncode=ImageIO.read(new File(filePath));
	ImageIO.write(toEncode,"jpg",bos);
			
	
	byte[] imageBytes = bos.toByteArray();
	encodedImage=Base64.getEncoder().encodeToString(imageBytes);
	
	
	
	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	urlParameters.add(new BasicNameValuePair("image",encodedImage));
	urlParameters.add(new BasicNameValuePair("type","base64"));

	
	HttpEntity postParams=null;
	
		postParams = new UrlEncodedFormEntity(urlParameters);
		httpPost.setEntity(postParams);
	
	

	
	CloseableHttpResponse httpResponse=null;
		httpResponse = httpClient.execute(httpPost);
	
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
	
}

public void accUpdateImageInfo(String accessToken,String imageID,String title, String description) throws IOException{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost httpPost = new HttpPost("https://api.imgur.com/3/image/"+imageID);
	httpPost.setHeader("Authorization","Bearer "+accessToken);
	
	
	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	urlParameters.add(new BasicNameValuePair("description",description));
	urlParameters.add(new BasicNameValuePair("title",title));
	
	HttpEntity postParams=null;
	
		postParams = new UrlEncodedFormEntity(urlParameters);
		httpPost.setEntity(postParams);
	
		CloseableHttpResponse httpResponse=null;
	
		httpResponse = httpClient.execute(httpPost);
	
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

public void anonUpdateImageInfo(String deleteHash,String imageID,String title, String description) throws ClientProtocolException, IOException{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost httpPost = new HttpPost("https://api.imgur.com/3/image/"+imageID);
	httpPost.setHeader("Authorization","client-id "+ID);
	
	
	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	urlParameters.add(new BasicNameValuePair("description",description));
	urlParameters.add(new BasicNameValuePair("title",title));
	
	HttpEntity postParams=null;
	
	postParams = new UrlEncodedFormEntity(urlParameters);
	httpPost.setEntity(postParams);
	
	CloseableHttpResponse httpResponse=null;
	
	httpResponse = httpClient.execute(httpPost);
	
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

public void favoriteImage(String accessToken, String imageID) throws ClientProtocolException, IOException{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost httpPost = new HttpPost("https://api.imgur.com/3/image/"+imageID+"/favorite");
	httpPost.setHeader("Authorization","Bearer "+accessToken);
	CloseableHttpResponse httpResponse=null;
		httpResponse = httpClient.execute(httpPost);
	
	
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

}
