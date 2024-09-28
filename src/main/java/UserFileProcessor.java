import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileProcessor {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                users.add(new User(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
