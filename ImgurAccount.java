import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ImgurAccount {
	public static String accountInfo(String accessToken) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		String toJSON=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		return toJSON;
	}
	public static void sendVeriEmail(String accessToken) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://api.imgur.com/3/account/me/verifyemail");
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
	
	public static String checkVeriEmail(String accessToken) throws IOException, ParseException{
		String result=null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/verifyemail");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		result=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		return result;
		
	}
	
	public static String getReplies(String accessToken) throws ClientProtocolException, IOException{
		String replies="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/notifications/replies");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		replies=response.toString();
		System.out.println(httpResponse.getStatusLine());
		
		return replies;
	}

	public static String ImageCount(String accessToken) throws ClientProtocolException, IOException{
		String imageCount="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/images/count");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		imageCount=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		return imageCount;
	}

	public static String ImageIDs(String accessToken, String page) throws ClientProtocolException, IOException{
		String imageArray="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/images/ids/"+page);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		imageArray=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		

		return imageArray;
	}

	public static String imageInfo(String accessToken, String imageID) throws ClientProtocolException, IOException{
		String imageInfo="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/image/"+imageID);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		imageInfo=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		return imageInfo;
}

	public static String Images(String accessToken, String page) throws ClientProtocolException, IOException{
		String images="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/images/"+page);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		images=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return images;
	}

	public static String CommentCount(String accessToken) throws ClientProtocolException, IOException{
		String commentCount="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/comments/count");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		commentCount=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return commentCount;
	}

	public static String CommentIDs(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
		String commentIDs="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/comments/ids/"+sort+"/"+page);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		commentIDs=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return commentIDs;
	}

	public static String Comment(String accessToken, String commentID) throws ClientProtocolException, IOException{
		String commentInfo="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/comment/"+commentID);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		commentInfo=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		return commentInfo;
	}

	public static String Comments(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
		String comments="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/comments/"+sort+"/"+page);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		comments=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return comments;
	}

	public static String AlbumCount(String accessToken) throws ClientProtocolException, IOException{
		String albumCount="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/albums/count");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		albumCount=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return albumCount;
	}

	public static String AlbumIDs(String accessToken, String page) throws ClientProtocolException, IOException{
		String albumIDs="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/albums/ids/"+page);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		albumIDs=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return albumIDs;
	}

	public static String AlbumInfo(String accessToken, String albumID) throws ClientProtocolException, IOException{
		String albumInfo="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/album/"+albumID);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		albumInfo=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return albumInfo;
	}

	public static String Albums(String accessToken,String page) throws ClientProtocolException, IOException{
		String albums="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/albums/"+page);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		albums=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return albums;
	}

	public static String GalleryProfile(String accessToken) throws ClientProtocolException, IOException{
		String galleryProfile="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/gallery_profile");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		System.out.println("Getting Account Info");
		
		galleryProfile=response.toString();
		
		System.out.println(galleryProfile);
		
		
		
		return galleryProfile;
	}

	public static String accountSettingsInfo(String accessToken) throws ClientProtocolException, IOException{
		String accountSettings="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/settings");
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		accountSettings=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return accountSettings;
	}

	public static String accountSubmissions(String accessToken,String page) throws ClientProtocolException, IOException{
		String accountSubs="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/submissions/"+page);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		accountSubs=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return accountSubs;
	}

	public static String accountFavorites(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
		String accountFaves="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/favorites/"+page+"/"+sort);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		accountFaves=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return accountFaves;
	}

	public static String GalleryFavorites(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
		String galleryFavorites="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.imgur.com/3/account/me/gallery_favorites/"+page+"/"+sort);
		httpGet.setHeader("Authorization","Bearer "+accessToken);
		
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
		
		
		galleryFavorites=response.toString();
		
		System.out.println(httpResponse.getStatusLine());
		
		
		
		return galleryFavorites;
	}

}