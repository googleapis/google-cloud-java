/*
 * Copyright 2016 Google Inc.
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

// [START logging_quickstart]
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Severity;
import java.util.Collections;

/**
 * This sample demonstrates writing logs using the Stackdriver Logging API. The library also offers
 * a java.util.logging Handler `com.google.cloud.logging.LoggingHandler` Logback integration is also
 * available :
 * https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-clients/google-cloud-contrib/google-cloud-logging-logback
 * Using the java.util.logging handler / Logback appender should be preferred to using the API
 * directly.
 */
public class QuickstartSample {

  /** Expects a new or existing Stackdriver log name as the first argument. */
  public static void main(String... args) throws Exception {

    // Instantiates a client
    Logging logging = LoggingOptions.getDefaultInstance().getService();

    // The name of the log to write to
    String logName = args[0]; // "my-log";

    // The data to write to the log
    String text = "Hello, world!";

    LogEntry entry =
        LogEntry.newBuilder(StringPayload.of(text))
            .setSeverity(Severity.ERROR)
            .setLogName(logName)
            .setResource(MonitoredResource.newBuilder("global").build())
            .build();

    // Writes the log entry asynchronously
    logging.write(Collections.singleton(entry));

    System.out.printf("Logged: %s%n", text);
  }
}
// [END logging_quickstart]
