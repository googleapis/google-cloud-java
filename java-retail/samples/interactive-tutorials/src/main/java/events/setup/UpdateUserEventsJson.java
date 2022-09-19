/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package events.setup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class UpdateUserEventsJson {

  public static void main(String[] args) throws IOException {
    String filePath = "src/main/resources/user_events.json";
    String invalidFilePath = "src/main/resources/user_events_some_invalid.json";
    updateEventsTimestamp(filePath);
    updateEventsTimestamp(invalidFilePath);
  }

  public static void updateEventsTimestamp(String jsonFile) throws IOException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Timestamp yesterdayDate = Timestamp.from(Instant.now().minus(1, ChronoUnit.DAYS));

    String json = new String(Files.readAllBytes(Paths.get(jsonFile)));
    json =
        json.replaceAll(
            "(\"eventTime\"\\s*:\\s*\"(\\d{4}-\\d{2}-\\d{2}(T.*Z)?))",
            "\"eventTime\":\"" + dateFormat.format(yesterdayDate) + "");

    BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
    writer.write(json);
    System.out.printf("User events file '%s' updated.%n", jsonFile);
    writer.close();
  }
}
