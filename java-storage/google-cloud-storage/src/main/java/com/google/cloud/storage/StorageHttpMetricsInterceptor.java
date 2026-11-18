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

import static java.util.Objects.requireNonNull;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
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
 *
 * <p>Note: {@code google-http-client} invokes {@link HttpResponseInterceptor#interceptResponse}
 * inside {@link HttpRequest#execute()} when the HTTP response headers arrive, so download durations
 * recorded here end at response headers and exclude streaming body transfer (a follow-up is tracked
 * for recording when the response body is closed). End-to-end download duration including body
 * transfer is captured by {@code gcp.client.request.duration}.
 */
@NullMarked
final class StorageHttpMetricsInterceptor implements HttpRequestInitializer {

  private static final ImmutableSet<String> OBJECT_SUB_RESOURCES =
      ImmutableSet.of("acl", "compose", "restore");

  @Nullable private final HttpRequestInitializer delegate;
  private final StorageClientMetrics metrics;
  private final ApiClock clock;

  StorageHttpMetricsInterceptor(
      @Nullable HttpRequestInitializer delegate, StorageClientMetrics metrics, ApiClock clock) {
    this.delegate = delegate;
    this.metrics = requireNonNull(metrics, "metrics cannot be null");
    this.clock = requireNonNull(clock, "clock cannot be null");
  }

  @Override
  public void initialize(HttpRequest request) throws IOException {
    if (delegate != null) {
      delegate.initialize(request);
    }

    HttpExecuteInterceptor existingExec = request.getInterceptor();
    HttpResponseInterceptor existingResp = request.getResponseInterceptor();
    HttpUnsuccessfulResponseHandler existingUnsuccessfulHandler =
        request.getUnsuccessfulResponseHandler();
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

    if (existingUnsuccessfulHandler != null) {
      request.setUnsuccessfulResponseHandler(
          (req, response, supportsRetry) -> {
            long endNanos = clock.nanoTime();
            boolean handled =
                existingUnsuccessfulHandler.handleResponse(req, response, supportsRetry);
            if (handled && response.getRequest() == req && recorded.compareAndSet(false, true)) {
              recordResponse(req, startTimeNanos.get(), endNanos, response.getStatusCode());
            }
            return handled;
          });
    }

    request.setResponseInterceptor(
        response -> {
          long endNanos = clock.nanoTime();
          if (existingResp != null) {
            existingResp.interceptResponse(response);
          }
          if (recorded.compareAndSet(false, true)) {
            recordResponse(request, startTimeNanos.get(), endNanos, response.getStatusCode());
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
                clock.nanoTime(),
                0L,
                StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);
          }
          return existingIoHandler != null
              && existingIoHandler.handleIOException(req, supportsRetry);
        });
  }

  private void recordResponse(HttpRequest request, long startNanos, long endNanos, int statusCode) {
    String errorType =
        statusCode >= 400
            ? StorageErrorTypeMapper.mapHttpResponseCode(statusCode)
            : StorageErrorTypeMapper.STATUS_OK;
    recordDuration(request, startNanos, endNanos, statusCode, errorType);
  }

  private void recordDuration(
      HttpRequest request, long startNanos, long endNanos, long statusCode, String errorType) {
    double durationSeconds = (endNanos - startNanos) / 1_000_000_000.0;
    metrics.recordHttpRequestDuration(
        durationSeconds,
        request.getRequestMethod(),
        statusCode,
        extractUrlTemplate(request.getUrl()),
        errorType);
  }

  static String extractUrlTemplate(GenericUrl url) {
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
      if (segments.length == 2) {
        return "/storage/v1/b/{bucket}";
      }
      if ("o".equals(segments[2])) {
        return extractObjectUrlTemplate(segments);
      }
      if ("iam".equals(segments[2]) && segments.length > 3) {
        return "/storage/v1/b/{bucket}/iam/" + segments[3];
      }
      if (segments.length >= 4) {
        if ("acl".equals(segments[2]) || "defaultObjectAcl".equals(segments[2])) {
          return "/storage/v1/b/{bucket}/" + segments[2] + "/{entity}";
        }
        if ("notificationConfigs".equals(segments[2])) {
          return "/storage/v1/b/{bucket}/notificationConfigs/{notification}";
        }
      }
      return "/storage/v1/b/{bucket}/" + segments[2];
    }
    if (segments.length >= 2 && "projects".equals(segments[0])) {
      segments[1] = "{project}";
      if (segments.length >= 4 && "hmacKeys".equals(segments[2])) {
        segments[3] = "{access_id}";
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
    if ("rewriteTo".equals(action)
        && segments.length >= 8
        && "b".equals(segments[5])
        && "o".equals(segments[7])) {
      return "/storage/v1/b/{bucket}/o/{object}/rewriteTo/b/{bucket}/o/{object}";
    }
    if ("moveTo".equals(action) && segments.length >= 7 && "o".equals(segments[5])) {
      return "/storage/v1/b/{bucket}/o/{object}/moveTo/o/{object}";
    }
    if ("acl".equals(action) && segments.length >= 6) {
      return "/storage/v1/b/{bucket}/o/{object}/acl/{entity}";
    }
    if (OBJECT_SUB_RESOURCES.contains(action)) {
      return "/storage/v1/b/{bucket}/o/{object}/" + action;
    }
    return "/storage/v1/b/{bucket}/o/{object}";
  }
}
