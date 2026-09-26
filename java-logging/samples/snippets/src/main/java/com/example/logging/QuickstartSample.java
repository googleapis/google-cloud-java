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
 * This sample demonstrates writing logs directly with the Cloud Logging API.
 *
 * <p>Authenticate by running {@code gcloud auth application-default login}, by setting the
 * {@code GOOGLE_APPLICATION_CREDENTIALS} environment variable to a service account key path, or by
 * running this sample on Google Cloud where Application Default Credentials are available
 * automatically.
 *
 * <p>For production applications, prefer using a standard logging framework with Cloud Logging
 * integration, such as Logback with <a
 * href="https://github.com/googleapis/java-logging-logback">https://github.com/googleapis/java-logging-logback</a>.
 * If you need more customizable {@code LogEntry} fields, see the {@code WriteLogEntry} sample.
 */
public class QuickstartSample {

  /** Expects a new or existing Cloud log name as the first argument. */
  public static void main(String... args) throws Exception {
    // The name of the log to write to
    String logName = args.length > 0 ? args[0] : "my-log";
    String textPayload = "Hello, world!";

    // Instantiates a client
    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {

      LogEntry entry =
          LogEntry.newBuilder(StringPayload.of(textPayload))
              .setSeverity(Severity.ERROR)
              .setLogName(logName)
              .setResource(MonitoredResource.newBuilder("global").build())
              .build();

      // Writes the log entry asynchronously
      logging.write(Collections.singleton(entry));

      // Optional - flush any pending log entries just before Logging is closed
      logging.flush();
    }
    System.out.printf("Logged: %s%n", textPayload);
  }
}
// [END logging_quickstart]
