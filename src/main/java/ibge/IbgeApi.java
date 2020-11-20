package ibge;
import java.io.*;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;




public class IbgeApi {


	  
	
    public JSONArray get() {
		String uri= "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
		URI url= URI.create(uri);
		
		HttpClient client=  HttpClient.newHttpClient();
		
		HttpRequest req= HttpRequest.newBuilder()
				.uri(url)
				.build();
		
		
		HttpResponse<String> res = client.sendAsync(req, BodyHandlers.ofString()).join();
		
		JSONArray json= new JSONArray(res.body());
		
		
		
		return json;
	}
    public JSONObject get(int id) {
 		String uri= "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+id;
 		URI url= URI.create(uri);
 		HttpClient client=  HttpClient.newHttpClient();
 		
 		HttpRequest req= HttpRequest.newBuilder()
 				.uri(url)
 				.build();
 		
 		
 		HttpResponse<String> res = client.sendAsync(req, BodyHandlers.ofString()).join();
 		
 		JSONObject json= new JSONObject(res.body());
 		
 		
 		
 		
 		
 		return json;
 	}
	
    public JSONArray getCidades(int id) {
    	
    	
    	
    	
 		String uri= "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+id+"/municipios";
 		URI url= URI.create(uri);
 		HttpClient client=  HttpClient.newHttpClient();
 		
 		HttpRequest req= HttpRequest.newBuilder()
 				.uri(url)
 				.build();
 		
 		
 		HttpResponse<String> res = client.sendAsync(req, BodyHandlers.ofString()).join();
 		
 		JSONArray json= new JSONArray(res.body());

 		
 		return json;
 		
 		
 	}
    public JSONObject getCidade(int id,int index) {
    	JSONArray arr=getCidades(id);
    	
    	for(int i=0; i<arr.length();) {
    		JSONObject obj=arr.getJSONObject(i);
    	if(obj.getInt("id")==index) {
    		return obj;
    	}
    	
    	
    		i++;
    	}
    	
    	return null;
    	
    }
	
}
