/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.logging;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Severity;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;

/** Basic sample application which writes a log message to Cloud Logging. */
public class NativeImageLoggingSample {

  /** Runs the Logging Sample Application. */
  public static void main(String[] args) throws Exception {
    Instant startTime = Instant.now();
    // Instantiates a client
    Logging client = LoggingOptions.getDefaultInstance().getService();

    // The name of the log to write to
    String logName = "nativeimage_logging_sample.log";

    // The data to write to the log
    String text = "This is a log produced by Native Image.";

    LogEntry entry =
        LogEntry.newBuilder(StringPayload.of(text))
            .setSeverity(Severity.INFO)
            .setLogName(logName)
            .setResource(MonitoredResource.newBuilder("global").build())
            .build();

    client.write(Collections.singleton(entry));
    client.flush();
    client.close();

    System.out.println(String.format("Logged: %s", text));
    System.out.println("Log message written to Cloud Logging.");
    System.out.println(
        "See your logs in the Cloud Console: https://console.cloud.google.com/logs/viewer "
            + "(Might take a few seconds to load.)");
    Instant endTime = Instant.now();
    Duration duration = Duration.between(startTime, endTime);
    System.out.println("Duration: " + duration.toString());
  }
}
