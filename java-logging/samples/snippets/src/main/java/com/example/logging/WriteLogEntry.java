/*
 * Copyright 2021 Google LLC
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

package com.example.logging;

// [START logging_write_log_entry]
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Severity;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.Map;

public class WriteLogEntry {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Optionally provide the logname as an argument
    String logName = args.length > 0 ? args[0] : "test-log";

    // Instantiates a client
    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {
      Map<String, String> payload =
          ImmutableMap.of(
              "name", "King Arthur", "quest", "Find the Holy Grail", "favorite_color", "Blue");
      LogEntry entry =
          LogEntry.newBuilder(JsonPayload.of(payload))
              .setSeverity(Severity.INFO)
              .setLogName(logName)
              .setResource(MonitoredResource.newBuilder("global").build())
              .build();

      // Writes the log entry asynchronously
      logging.write(Collections.singleton(entry));

      // Optional - flush any pending log entries just before Logging is closed
      logging.flush();
    }
    System.out.printf("Wrote to %s\n", logName);
  }
}
// [END logging_write_log_entry]
