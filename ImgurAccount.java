import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ImgurAccount {
	//remove static keyword and have it return a String representation of the info
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
		System.out.println("Getting Account Info");
		
		String toJSON=response.toString();
		
		System.out.println(toJSON);
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

		//add it a check to see which response is sent back, the display text for success or failure
		String toJSON=response.toString();
		System.out.println(toJSON);
		httpClient.close();
		
	}
	
	public static void checkVeriEmail(String accessToken) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		String toJSON=response.toString();
		
		System.out.println(toJSON);
		
	}
	
	public String getReplies(String accessToken) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		replies=response.toString();
		
		System.out.println(replies);
		
		
		
		return replies;
	}

	public String accImageCount(String accessToken) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		imageCount=response.toString();
		
		System.out.println(imageCount);
		
		
		
		return imageCount;
	}

	public String accImageIDs(String accessToken, String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		imageArray=response.toString();
		
		System.out.println(imageArray);
		
		
		
		return imageArray;
	}

	public String imageInfo(String accessToken, String imageID) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		imageInfo=response.toString();
		
		System.out.println(imageInfo);
		
		
		
		return imageInfo;
}

	public String accImages(String accessToken, String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		images=response.toString();
		
		System.out.println(images);
		
		
		
		return images;
	}

	public String accCommentCount(String accessToken) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		commentCount=response.toString();
		
		System.out.println(commentCount);
		
		
		
		return commentCount;
	}

	public String accCommentIDs(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		commentIDs=response.toString();
		
		System.out.println(commentIDs);
		
		
		
		return commentIDs;
	}

	public String accComment(String accessToken, String commentID) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		commentInfo=response.toString();
		
		System.out.println(commentInfo);
		
		
		
		return commentInfo;
	}

	public String accComments(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		comments=response.toString();
		
		System.out.println(comments);
		
		
		
		return comments;
	}

	public String accAlbumCount(String accessToken) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		albumCount=response.toString();
		
		System.out.println(albumCount);
		
		
		
		return albumCount;
	}

	public String accAlbumIDs(String accessToken, String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		albumIDs=response.toString();
		
		System.out.println(albumIDs);
		
		
		
		return albumIDs;
	}

	public String accAlbumInfo(String accessToken, String albumID) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		albumInfo=response.toString();
		
		System.out.println(albumInfo);
		
		
		
		return albumInfo;
	}

	public String accAlbums(String accessToken,String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		albums=response.toString();
		
		System.out.println(albums);
		
		
		
		return albums;
	}

	public String accGalleryProfile(String accessToken) throws ClientProtocolException, IOException{
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

	public String accountSettingsInfo(String accessToken) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		accountSettings=response.toString();
		
		System.out.println(accountSettings);
		
		
		
		return accountSettings;
	}

	public String accountSubmissions(String accessToken,String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		accountSubs=response.toString();
		
		System.out.println(accountSubs);
		
		
		
		return accountSubs;
	}

	public String accountFavorites(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		accountFaves=response.toString();
		
		System.out.println(accountFaves);
		
		
		
		return accountFaves;
	}

	public String accGalleryFavorites(String accessToken, String sort, String page) throws ClientProtocolException, IOException{
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
		System.out.println("Getting Account Info");
		
		galleryFavorites=response.toString();
		
		System.out.println(galleryFavorites);
		
		
		
		return galleryFavorites;
	}

}