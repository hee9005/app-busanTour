package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import data.Attraction.attractionitem;
import data.Attraction.busanAttraction;
import data.Attraction.busanAttractionResult;



public class AttractionAPI2 {
	private static Map<Integer,attractionitem>cache
	;static{cache=new HashMap<>();
	}
	

	public synchronized static busanAttraction getAttractions(String pageNo) {
		try {
			String target = "http://apis.data.go.kr/6260000/AttractionService/getAttractionKr";

			String queryString = "serviceKey=P%2FhL5EXdd%2FUh3HtYbHBtZI9PnkTMtbqImGmluwFnOgM%2FsLoypgqVKpFQ17t8zpHrnqoTMIh2ZJCJ2XOx7QFDnw%3D%3D&resultType=json&numOfRows=4&pageNo="+ pageNo;

			URI uri = new URI(target + "?" + queryString);

			// HttpClient 객체를 활용하는 방식
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			Gson gson = new Gson();
			busanAttractionResult responseResult = gson.fromJson(response.body(), busanAttractionResult.class);
			for( attractionitem one :responseResult.getAttraction().getItem()){
				cache.put(one.getUC_SEQ(), one);
			}
			return responseResult.getAttraction();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

}
