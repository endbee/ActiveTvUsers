package tvUsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

//Wrapper class for the file output
public class MyFileWriter {
    //output results to a text file
    public void writeUsersToFile(Set<String> names, String filename) throws IOException {
        String fileOutput = names.stream().reduce((x,y) -> x + '\n' + y).orElseThrow(RuntimeException::new);
        Files.writeString(Path.of(filename), fileOutput);
    }
}
