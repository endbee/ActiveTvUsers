package tvUsers;

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
        FilterTvUsers filterTvUsers = new FilterTvUsers(new MyHttpClient(), new MyFileWriter());
        filterTvUsers.outputTvUsers();

    }
}
