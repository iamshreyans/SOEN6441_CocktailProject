import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.JsonResponse;
import data.SqlManager;
import data.Drinks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Application {

    public static final String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";

    public static void main(String[] args) throws IOException, InterruptedException {
        fetchJson(url);
    }

    private static void fetchJson(String url) throws IOException, InterruptedException {
        // We are creating client object
        HttpClient client = HttpClient.newHttpClient();
        // We are creating request object
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // We will parse JSON in this step
        // For The Above We Need To Create Mapper Object
        ObjectMapper mapperForResponse = new ObjectMapper();

        //Store the value in an object of type list of type posted Requests
        JsonResponse jsonResponse= mapperForResponse.readValue(response.body(), new TypeReference<JsonResponse>() {});
        List<Drinks> drinksList = jsonResponse.getDrinks();

        SqlManager sqlManager = new SqlManager();

        sqlManager.createTableIfNotExists();
        //Insert only first 50 records of each type
        for (int i = 0; i< drinksList.size(); i++) {
            if(i == 50)
                break;
            sqlManager.insertRecord(drinksList.get(i));
        }
        drinksList.forEach(System.out::println);
    }
}
