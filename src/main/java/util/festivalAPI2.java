package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import data.Festival.busanFestival;
import data.Festival.busanFestivalResult;
import data.Festival.festivalitem;




public class festivalAPI2 {
	
	
	public synchronized static busanFestival getFestivals(String pageNo) {
		try {
			String target = "http://apis.data.go.kr/6260000/FestivalService/getFestivalKr";
			String queryString = "serviceKey=P%2FhL5EXdd%2FUh3HtYbHBtZI9PnkTMtbqImGmluwFnOgM%2FsLoypgqVKpFQ17t8zpHrnqoTMIh2ZJCJ2XOx7QFDnw%3D%3D&numOfRows=2&resultType=json&pageNo="+ pageNo;
			
			URI uri = new URI(target + "?" + queryString);
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			Gson gson = new Gson();
			busanFestivalResult responseResult = gson.fromJson(response.body(), busanFestivalResult.class);
			
			for(festivalitem one : responseResult.getFestivalKr().getItem()) {
				
			}
			
			return responseResult.getFestivalKr();
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
