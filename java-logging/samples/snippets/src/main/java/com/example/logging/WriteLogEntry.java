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
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Severity;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WriteLogEntry {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Optionally provide the logname as an argument
    String logName = args.length > 0 ? args[0] : "test-log";

    // Instantiates a client
    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {
      List<LogEntry> entries = createLogEntries(logName);

      // Writes one text log entry.
      logging.write(Collections.singleton(entries.get(0)));

      // Writes a batch of text and structured log entries.
      logging.write(entries);

      // Optional - flush any pending log entries just before Logging is closed
      logging.flush();
    }
    System.out.printf("Wrote to %s\n", logName);
  }

  static List<LogEntry> createLogEntries(String logName) {
    MonitoredResource resource = MonitoredResource.newBuilder("global").build();
    Map<String, String> labels = ImmutableMap.of("sample", "write-log-entry");

    LogEntry textEntry =
        LogEntry.newBuilder(StringPayload.of("Text log entry written from Java."))
            .setSeverity(Severity.INFO)
            .setLogName(logName)
            .setResource(resource)
            .setLabels(labels)
            .build();

    Map<String, Object> jsonPayload =
        ImmutableMap.of(
            "message", "Structured log entry written from Java.", "component", "sample");
    LogEntry structEntry =
        LogEntry.newBuilder(JsonPayload.of(jsonPayload))
            .setSeverity(Severity.WARNING)
            .setLogName(logName)
            .setResource(resource)
            .setLabels(labels)
            .build();

    return Arrays.asList(textEntry, structEntry);
  }
}
// [END logging_write_log_entry]
