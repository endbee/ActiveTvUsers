package tvUsers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Wrapper class for data retrieval
public class MyHttpClient {

    //HttpClient as private static to request data from server
    private static HttpClient httpClient = HttpClient.newHttpClient();

    // Call the api and get data
    public String getResponseBody(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();

    }

}
