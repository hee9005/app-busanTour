package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import data.Food.busanFood;
import data.Food.busanFoodResult;
import data.Food.foodItem;

public class foodAPI {

	public synchronized static busanFood getFoods() {
		try {
			String target = "http://apis.data.go.kr/6260000/FoodService/getFoodKr";
			String queryString = "serviceKey=P%2FhL5EXdd%2FUh3HtYbHBtZI9PnkTMtbqImGmluwFnOgM%2FsLoypgqVKpFQ17t8zpHrnqoTMIh2ZJCJ2XOx7QFDnw%3D%3D&numOfRows=10&pageNo=1&resultType=json";
			URI uri = new URI(target + "?" + queryString);
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			Gson gson = new Gson();
			busanFoodResult responseResult = gson.fromJson(response.body(), busanFoodResult.class);
			for(foodItem one : responseResult.getFood().getItem()) {
				
			}
			
			return responseResult.getFood();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
