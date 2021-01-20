/*
 * Copyright 2020 Google LLC
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

// [START logging_write_request_entry]
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.HttpRequest;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Severity;
import java.util.Collections;

/** Write LogEntry with HTTP request using the Cloud Logging API. */
public class LogEntryWriteHttpRequest {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String logName = "log-name"; // i.e "my-log"
    String payLoad = "payload"; // i.e "Hello world!"
    HttpRequest httpRequest =
        HttpRequest.newBuilder()
            .setRequestUrl("www.example.com")
            .setRequestMethod(HttpRequest.RequestMethod.GET) // Supported method GET,POST,PUT,HEAD
            .setStatus(200)
            .build();
    createLogEntryRequest(logName, payLoad, httpRequest);
  }

  public static void createLogEntryRequest(String logName, String payLoad, HttpRequest httpRequest)
      throws Exception {
    // Instantiates a logging client
    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {
      // create an instance of LogEntry with HTTP request
      LogEntry logEntry =
          LogEntry.newBuilder(Payload.StringPayload.of(payLoad))
              .setSeverity(Severity.ERROR)
              .setLogName(logName)
              .setHttpRequest(httpRequest)
              .setResource(MonitoredResource.newBuilder("global").build())
              .build();

      // Writes the log entry asynchronously
      logging.write(Collections.singleton(logEntry));
      System.out.printf("Logged: %s%n", payLoad);
    }
  }
}
// [END logging_write_request_entry]
