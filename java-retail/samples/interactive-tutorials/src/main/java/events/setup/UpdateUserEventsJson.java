package events.setup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class UpdateUserEventsJson {

  public static void main(String[] args) {
    try {
      String timestamp = LocalDateTime.now().minusDays(1).toString();
      String filename = "src/main/resources/user_events.json";
      updateFields(timestamp, filename);
      filename = "src/main/resources/user_events_some_invalid.json";
      updateFields(timestamp, filename);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void updateFields(String timestamp, String filename) throws IOException {
    List<String> newLines = new ArrayList<>();
    try (BufferedReader file = new BufferedReader(new FileReader(filename))) {
      String line = file.readLine();
      String field = "eventTime";
      while (line != null) {
        JSONObject object = new JSONObject(line);
        object.put(field, timestamp);
        newLines.add(object.toString());
        line = file.readLine();
      }
    }
    try (FileWriter file = new FileWriter(filename)) {
      for (String event : newLines) {
        file.write(event);
        file.write("\n");
      }
      System.out.println("Successfully updated json file!");
    }
  }
}
