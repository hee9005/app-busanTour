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



public class AttractionAPI {
	private static Map<Integer,attractionitem>cache
	;static{cache=new HashMap<>();
	}
	

	public synchronized static busanAttraction getAttractions(String pageNo) {
		try {
			String target = "http://apis.data.go.kr/6260000/AttractionService/getAttractionKr";

			String queryString = "serviceKey=vKxS%2BRKhMt4WrigiKbMl7VOjnr0Bh%2BaRZrQ12fKZro1qXwCjsxMDO9v3tI59gaCOXETcO9Ltmzqdhei2xoqoyA%3D%3D&resultType=json&numOfRows=10&pageNo="+ pageNo;

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
