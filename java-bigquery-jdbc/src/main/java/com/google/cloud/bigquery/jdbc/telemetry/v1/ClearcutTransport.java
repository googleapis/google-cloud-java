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
import com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ClearcutTransport {
  private static final Logger logger =
      new BigQueryJdbcCustomLogger(ClearcutTransport.class.getName());
  private static final String CONTENT_TYPE_PROTOBUF = "application/x-protobuf";
  private static final int DEFAULT_CONNECT_TIMEOUT_MS = 10_000;
  private static final int DEFAULT_READ_TIMEOUT_MS = 10_000;

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

  TransportResult send(TelemetryPayload payload) {
    if (!config.isEnabled()) {
      return TransportResult.disabled();
    }
    if (payload == null) {
      logger.log(Level.WARNING, "Cannot send null telemetry payload to Clearcut");
      return TransportResult.disabled();
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

    long nextRequestWaitMillis = -1;

    try {
      HttpRequest request = requestFactory.buildPostRequest(url, content);
      request.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT_MS);
      request.setReadTimeout(DEFAULT_READ_TIMEOUT_MS);
      request.setThrowExceptionOnExecuteError(false);

      HttpResponse response = null;
      try {
        response = request.execute();
        int statusCode = response.getStatusCode();

        if (response.getContent() != null) {
          try (InputStream is = response.getContent()) {
            LogResponse logResponse = LogResponse.parseFrom(is);
            if (logResponse.getNextRequestWaitMillis() > 0) {
              nextRequestWaitMillis = logResponse.getNextRequestWaitMillis();
            }
          } catch (IOException ignored) {
            // Ignore non-protobuf content from error bodies
          }
        }

        boolean success = statusCode >= 200 && statusCode < 300;
        if (success) {
          logger.log(Level.FINE, "Successfully uploaded telemetry payload to Clearcut");
        } else {
          logger.log(
              Level.WARNING,
              String.format("Clearcut upload failed with status code: %d", statusCode));
        }
        return new TransportResult(success, nextRequestWaitMillis);
      } finally {
        if (response != null) {
          response.disconnect();
        }
      }
    } catch (IOException e) {
      logger.log(Level.WARNING, "IOException sending telemetry payload to Clearcut", e);
      return new TransportResult(false, nextRequestWaitMillis);
    } catch (Throwable t) {
      logger.log(Level.WARNING, "Unexpected error sending telemetry payload to Clearcut", t);
      return new TransportResult(false, nextRequestWaitMillis);
    }
  }
}
