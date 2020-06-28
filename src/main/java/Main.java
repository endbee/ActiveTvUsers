import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //STEP 1: call the api and get data
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/comments")).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();

        JsonArray jsonComments = gson.fromJson(response.body(), JsonArray.class);

        List<Comment> comments = new ArrayList<>();
        for (JsonElement jsonComment : jsonComments) {
            Comment comment = gson.fromJson(jsonComment, Comment.class);
            comments.add(comment);
        }

        //STEP 2: Business logic. All unique names, where emails end in .tv and has at least a comment over 150 characters
        Set<String> names = new HashSet<>();
        for (Comment comment : comments){
            if(comment.getEmail().endsWith(".tv") && comment.getBody().length() > 150){
                names.add(comment.getName());
            }
        }

        //STEP 3: output results to a text file
        String fileOutput = names.stream().reduce((x,y) -> x + '\n' + y).orElseThrow(RuntimeException::new);

        Files.writeString(Path.of("output.txt"), fileOutput);



    }
}
