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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.parser.ParseException;


public class ImgurGallery {
	private static String galleryLink="https://api.imgur.com/3/gallery/hot/viral/0";
	private String searchLink="";
	private static String section="hot";
	private static String sort="viral";
	private static String page="0";
	private static String window="day";
	private static String showViral="true";
	
	
	public void setSection(String aSection){
		section=aSection;
		
		galleryLink="https://api.imgur.com/3/gallery/"+ 
				section + "/" + sort + "/"+window+"/" + page +"?"+showViral;
	}
	
	public void setSort(String aSort){
		sort=aSort;
		
		galleryLink="https://api.imgur.com/3/gallery/"+ 
				section + "/" + sort + "/"+window+"/" + page +"?"+showViral;
	}
	
	public void setPage(String aPage){
		page=aPage;
		
		galleryLink="https://api.imgur.com/3/gallery/"+ 
				section + "/" + sort + "/"+window+"/" + page +"?"+showViral;
	}
	
	public void setWindow(String timePeriod){
		window = timePeriod;
		
		galleryLink="https://api.imgur.com/3/gallery/"+ 
				section + "/" + sort + "/"+window+"/" + page +"?"+showViral;
		
	}
	
	public void setShowViral(String value){
		showViral=value;
		
		galleryLink="https://api.imgur.com/3/gallery/"+ 
				section + "/" + sort + "/"+window+"/" + page +"?"+showViral;
	}
	//so we know what the link currently consists of
	public String getGalleryLink(){
		return galleryLink;
	}
	
	//return String based on link--Gallery Images
	public String getGallery(String clientID) throws IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(galleryLink);
		httpGet.setHeader("Authorization","client-id "+clientID);
		
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
		

		String galleryImages=response.toString();
		
		
		return galleryImages;
	}
	
	//return String representation of JSON based on search--Gallery Images maybe album images?
	public String searchGallery(String query,String index,String value,String clientID) throws IOException, ParseException{
		 searchLink=searchLink+query+"="+index+":"+value;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(searchLink);
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

		String searchedImages=response.toString();
		
		httpClient.close();
		
		return searchedImages;
	}
	
	public String getRandomGalleryImages(String clientID) throws IOException{
		
		String randomLink="https://api.imgur.com/3/gallery/random/random/";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(randomLink);
		httpGet.setHeader("Authorization","client-id "+clientID);
		
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
		

		String randGalleryImages=response.toString();
		
			httpClient.close();
		
		
		return randGalleryImages;
		
	}
	
	public String getAlbumInfo(String clientID, String albumID) throws ClientProtocolException, IOException, ParseException{
		String albumLink = "https://api.imgur.com/3/gallery/album/" + albumID;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(albumLink);
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

		String albumInfo=response.toString();
		
		httpClient.close();
		
		return albumInfo;
		
	}
	
	public String shareWithComm(String accessToken, String title, String id) throws ClientProtocolException, IOException{
		String uploadLink = "https://api.imgur.com/3/gallery/image/" + id;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uploadLink);
		httpPost.setHeader("Authorization","Bearer "+accessToken);
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("title",title));
		
		
		HttpEntity postParams=null;
		
			postParams = new UrlEncodedFormEntity(urlParameters);
			httpPost.setEntity(postParams);
		
		
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();

		String uploadInfo=response.toString();
		
		System.out.println(uploadInfo);
		
		httpClient.close();
		
		return uploadInfo;
	}
	
	public String getImageInfo (String clientID, String imageID) throws ClientProtocolException, IOException, ParseException{
		
		String imageLink = "https://api.imgur.com/3/gallery/image/" + imageID;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(imageLink);
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

		String imageInfo=response.toString();
		
		
		
		httpClient.close();
		
		return imageInfo;
	}

}
