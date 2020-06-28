package tvUsers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterTvUsers {
    private static Gson gson = new Gson();

    //The applications file writer and http client
    private final MyHttpClient httpClient;
    private final MyFileWriter fileWriter;

    public FilterTvUsers(MyHttpClient httpClient, MyFileWriter fileWriter) {
        this.httpClient = httpClient;
        this.fileWriter = fileWriter;
    }

    public void outputTvUsers() throws IOException, InterruptedException {
        String responseBody = httpClient.getResponseBody("https://jsonplaceholder.typicode.com/comments");
        List<Comment> comments = deserialize(responseBody);
        Set<String> tvUsers = getTvUsers(comments);
        fileWriter.writeUsersToFile(tvUsers, "output.txt");
    }

    private List<Comment> deserialize(String body){
        JsonArray jsonComments = gson.fromJson(body, JsonArray.class);

        List<Comment> comments = new ArrayList<>();
        for (JsonElement jsonComment : jsonComments) {
            Comment comment = gson.fromJson(jsonComment, Comment.class);
            comments.add(comment);
        }
        return comments;
    }

    private Set<String> getTvUsers(List<Comment> comments) {
        Set<String> names = new HashSet<>();
        for (Comment comment : comments){
            if(comment.getEmail().endsWith(".tv") && comment.getBody().length() > 150){
                names.add(comment.getName());
            }
        }
        return names;
    }

}

