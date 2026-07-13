/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClearcutTransport {
  private static final Logger logger = Logger.getLogger(ClearcutTransport.class.getName());
  private static final String CONTENT_TYPE_PROTOBUF = "application/x-protobuf";

  private final HttpTransport httpTransport;
  private final TelemetryConfiguration config;
  private final HttpRequestFactory requestFactory;

  ClearcutTransport(TelemetryConfiguration config) {
    this(new NetHttpTransport(), config);
  }

  // Package-private constructor for testing overrides
  ClearcutTransport(HttpTransport httpTransport, TelemetryConfiguration config) {
    this.httpTransport = httpTransport;
    this.config = config;
    this.requestFactory = this.httpTransport.createRequestFactory();
  }

  boolean send(TelemetryPayload payload) {
    if (!config.isEnabled()) {
      return false;
    }

    long now = System.currentTimeMillis();
    LogRequest logRequest =
        LogRequest.newBuilder()
            .setLogSource(config.getLogSource())
            .setRequestTimeMs(now)
            .addLogEvents(
                LogEvent.newBuilder()
                    .setEventTimeMs(now)
                    .setSourceExtension(payload.toByteString())
                    .build())
            .build();

    byte[] requestBytes = logRequest.toByteArray();
    HttpContent content = new ByteArrayContent(CONTENT_TYPE_PROTOBUF, requestBytes);
    GenericUrl url = new GenericUrl(config.getEndpointUrl());

    int attempt = 0;
    int maxAttempts = 3;
    long backoffMs = 1000;

    while (attempt < maxAttempts) {
      attempt++;
      try {
        HttpRequest request = requestFactory.buildPostRequest(url, content);
        HttpResponse response = request.execute();

        try {
          int statusCode = response.getStatusCode();
          if (statusCode >= 200 && statusCode < 300) {
            logger.log(Level.FINE, "Successfully uploaded telemetry payload to Clearcut");
            return true;
          } else {
            logger.log(Level.WARNING, "Clearcut upload returned status code: " + statusCode);
          }
        } finally {
          response.disconnect();
        }
      } catch (IOException e) {
        logger.log(Level.WARNING, "Error sending telemetry payload on attempt " + attempt, e);
        if (attempt >= maxAttempts) {
          break;
        }
        try {
          Thread.sleep(backoffMs);
          backoffMs *= 2;
        } catch (InterruptedException ie) {
          Thread.currentThread().interrupt();
          logger.log(Level.WARNING, "Backoff thread interrupted", ie);
          break;
        }
      }
    }
    logger.log(
        Level.SEVERE,
        "Failed to upload telemetry payload to Clearcut after " + maxAttempts + " attempts");
    return false;
  }
}
