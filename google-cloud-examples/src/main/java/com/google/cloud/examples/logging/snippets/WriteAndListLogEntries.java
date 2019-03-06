/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.logging.snippets;

import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.StringPayload;
import java.util.Collections;

/**
 * A snippet for Stackdriver Logging showing how to write a log entry. The snippet also shows how to
 * list all log entries with a given log name.
 *
 * @see <a href="https://cloud.google.com/logging/docs/api/#sinks">Sinks</a>
 */
public class WriteAndListLogEntries {

  public static void main(String... args) throws Exception {
    // Create a service object
    // Credentials are inferred from the environment
    LoggingOptions options = LoggingOptions.getDefaultInstance();
    try (Logging logging = options.getService()) {

      // Create a log entry
      LogEntry firstEntry =
          LogEntry.newBuilder(StringPayload.of("message"))
              .setLogName("test-log")
              .setResource(
                  MonitoredResource.newBuilder("global")
                      .addLabel("project_id", options.getProjectId())
                      .build())
              .build();
      logging.write(Collections.singleton(firstEntry));

      // List log entries
      Page<LogEntry> entries =
          logging.listLogEntries(
              EntryListOption.filter(
                  "logName=projects/" + options.getProjectId() + "/logs/test-log"));
      for (LogEntry logEntry : entries.iterateAll()) {
        System.out.println(logEntry);
      }
    }
  }
}
