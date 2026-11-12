/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.core.ApiClock;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * {@link HttpRequestInitializer} that instruments outgoing HTTP requests to record OpenTelemetry
 * client metrics.
 */
@NullMarked
final class StorageHttpMetricsInterceptor implements HttpRequestInitializer {

  private static final ImmutableSet<String> OBJECT_SUB_RESOURCES =
      ImmutableSet.of("acl", "compose", "restore", "watchAll");

  @Nullable private final HttpRequestInitializer delegate;
  @Nullable private final StorageClientMetrics metrics;
  private final ApiClock clock;
  @Nullable private final String defaultServerAddress;

  StorageHttpMetricsInterceptor(
      @Nullable HttpRequestInitializer delegate,
      @Nullable StorageClientMetrics metrics,
      ApiClock clock,
      @Nullable String host) {
    this.delegate = delegate;
    this.metrics = metrics;
    this.clock = clock;
    this.defaultServerAddress = OpenTelemetryBootstrappingUtils.extractServerAddress(host);
  }

  @Override
  public void initialize(HttpRequest request) throws IOException {
    if (delegate != null) {
      delegate.initialize(request);
    }
    if (metrics == null || metrics.getHttpClientRequestDuration() == null) {
      return;
    }

    HttpExecuteInterceptor existingExec = request.getInterceptor();
    HttpResponseInterceptor existingResp = request.getResponseInterceptor();
    HttpIOExceptionHandler existingIoHandler = request.getIOExceptionHandler();

    AtomicLong startTimeNanos = new AtomicLong();
    AtomicBoolean recorded = new AtomicBoolean(true);

    request.setInterceptor(
        req -> {
          if (existingExec != null) {
            existingExec.intercept(req);
          }
          startTimeNanos.set(clock.nanoTime());
          recorded.set(false);
        });

    request.setResponseInterceptor(
        response -> {
          if (existingResp != null) {
            existingResp.interceptResponse(response);
          }
          if (recorded.compareAndSet(false, true)) {
            int statusCode = response.getStatusCode();
            String errorType =
                statusCode >= 400
                    ? StorageErrorTypeMapper.mapHttpResponseCode(statusCode)
                    : StorageErrorTypeMapper.STATUS_OK;
            recordDuration(request, startTimeNanos.get(), (long) statusCode, errorType);
          }
        });

    // HttpIOExceptionHandler does not receive the thrown IOException instance from
    // google-http-client, so transport-level IOExceptions default to STATUS_CONNECTION_ERROR here
    // (specific subtypes like TIMEOUT, DNS_FAILURE, and TLS_FAILURE are mapped in Retrying).
    request.setIOExceptionHandler(
        (req, supportsRetry) -> {
          if (recorded.compareAndSet(false, true)) {
            recordDuration(
                req,
                startTimeNanos.get(),
                StorageMetricsContext.HTTP_STATUS_UNSET,
                StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);
          }
          return existingIoHandler != null
              && existingIoHandler.handleIOException(req, supportsRetry);
        });
  }

  private void recordDuration(
      HttpRequest request, long startNanos, long statusCode, String errorType) {
    if (metrics == null) {
      return;
    }
    double durationSeconds = Math.max(0.0, (clock.nanoTime() - startNanos) / 1_000_000_000.0);
    String method = request.getRequestMethod() != null ? request.getRequestMethod() : "UNKNOWN";
    String urlTemplate = extractUrlTemplate(request.getUrl());
    String serverAddress = resolveServerAddress(request.getUrl(), defaultServerAddress);

    StorageMetricsContext.recordHttpRequestDuration(
        metrics, durationSeconds, method, statusCode, urlTemplate, serverAddress, errorType);
  }

  @Nullable
  static String resolveServerAddress(
      @Nullable GenericUrl url, @Nullable String defaultServerAddress) {
    String host = url != null ? url.getHost() : null;
    if (host == null || host.isEmpty()) {
      return defaultServerAddress;
    }
    if (host.endsWith(".storage.googleapis.com") && !host.equals("storage.googleapis.com")) {
      return "storage.googleapis.com";
    }
    if (defaultServerAddress != null
        && !defaultServerAddress.isEmpty()
        && host.endsWith("." + defaultServerAddress)) {
      return defaultServerAddress;
    }
    return host;
  }

  static String extractUrlTemplate(@Nullable GenericUrl url) {
    if (url == null) {
      return "/";
    }
    if (url.getFirst("upload_id") != null) {
      return "/upload/storage/v1/b/{bucket}/o";
    }
    String path = url.getRawPath();
    if (path == null || path.isEmpty()) {
      return "/";
    }
    String host = url.getHost();
    if (host != null
        && host.endsWith(".storage.googleapis.com")
        && !host.equals("storage.googleapis.com")) {
      return "/".equals(path) ? "/" : "/{object}";
    }
    if (path.length() > 1 && path.endsWith("/")) {
      path = path.substring(0, path.length() - 1);
    }
    if (path.startsWith("/upload/storage/v1/b/")) {
      return "/upload/storage/v1/b/{bucket}/o";
    }
    if (path.startsWith("/download/storage/v1/b/")) {
      return "/download/storage/v1/b/{bucket}/o/{object}";
    }
    if (path.startsWith("/batch/storage/v1")) {
      return "/batch/storage/v1";
    }
    if (path.startsWith("/storage/v1/")) {
      return extractV1UrlTemplate(path.substring("/storage/v1/".length()));
    }
    String trimmed = path.startsWith("/") ? path.substring(1) : path;
    if (trimmed.isEmpty()) {
      return "/";
    }
    String[] parts = trimmed.split("/", 2);
    return parts.length == 1 ? "/{bucket}" : "/{bucket}/{object}";
  }

  private static String extractV1UrlTemplate(String rest) {
    if ("b".equals(rest)) {
      return "/storage/v1/b";
    }
    String[] segments = rest.split("/");
    if (segments.length >= 2 && "b".equals(segments[0])) {
      segments[1] = "{bucket}";
      if (segments.length >= 3 && "o".equals(segments[2])) {
        return extractObjectUrlTemplate(segments);
      }
      if (segments.length >= 4) {
        if ("acl".equals(segments[2]) || "defaultObjectAcl".equals(segments[2])) {
          segments[3] = "{entity}";
        } else if ("notifications".equals(segments[2])
            || "notificationConfigs".equals(segments[2])) {
          segments[3] = "{notification}";
        }
      }
      return "/storage/v1/" + String.join("/", segments);
    }
    if (segments.length >= 2 && "projects".equals(segments[0])) {
      segments[1] = "{project}";
      if (segments.length >= 4 && "hmacKeys".equals(segments[2])) {
        segments[3] = "{accessId}";
      }
      return "/storage/v1/" + String.join("/", segments);
    }
    return "/storage/v1";
  }

  private static String extractObjectUrlTemplate(String[] segments) {
    if (segments.length == 3) {
      return "/storage/v1/b/{bucket}/o";
    }
    if (segments.length == 4) {
      return "/storage/v1/b/{bucket}/o/{object}";
    }
    String action = segments[4];
    if (segments.length == 5 && OBJECT_SUB_RESOURCES.contains(action)) {
      return "/storage/v1/b/{bucket}/o/{object}/" + action;
    }
    if ("acl".equals(action)) {
      return "/storage/v1/b/{bucket}/o/{object}/acl/{entity}";
    }
    if (("copyTo".equals(action) || "rewriteTo".equals(action))
        && segments.length >= 8
        && "b".equals(segments[5])
        && "o".equals(segments[7])) {
      return "/storage/v1/b/{bucket}/o/{object}/"
          + action
          + "/b/{destinationBucket}/o/{destinationObject}";
    }
    if ("moveTo".equals(action) && segments.length >= 7 && "o".equals(segments[5])) {
      return "/storage/v1/b/{bucket}/o/{object}/moveTo/o/{destinationObject}";
    }
    return "/storage/v1/b/{bucket}/o/{object}";
  }
}
