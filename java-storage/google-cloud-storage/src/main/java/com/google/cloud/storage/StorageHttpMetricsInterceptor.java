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
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * HTTP request initializer that records HTTP client metrics such as http.client.request.duration.
 */
final class StorageHttpMetricsInterceptor implements HttpRequestInitializer {

  @Nullable private final HttpRequestInitializer delegate;
  private final StorageClientMetrics metrics;
  private final ApiClock clock;
  @Nullable private final String defaultServerAddress;

  StorageHttpMetricsInterceptor(
      @Nullable HttpRequestInitializer delegate,
      StorageClientMetrics metrics,
      ApiClock clock,
      @Nullable String host) {
    this.delegate = delegate;
    this.metrics = metrics;
    this.clock = clock;
    this.defaultServerAddress = StorageOptions.extractServerAddress(host);
  }

  @Override
  public void initialize(HttpRequest request) throws java.io.IOException {
    if (delegate != null) {
      delegate.initialize(request);
    }
    if (metrics == null || metrics.getHttpClientRequestDuration() == null) {
      return;
    }

    HttpExecuteInterceptor existingExec = request.getInterceptor();
    HttpResponseInterceptor existingResp = request.getResponseInterceptor();
    HttpIOExceptionHandler existingIoHandler = request.getIOExceptionHandler();

    AtomicLong startTimeNanos = new AtomicLong(clock.nanoTime());
    AtomicBoolean recorded = new AtomicBoolean(false);

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
          if (recorded.compareAndSet(false, true)
              && metrics.getHttpClientRequestDuration() != null) {
            double durationSeconds =
                Math.max(0.0, (clock.nanoTime() - startTimeNanos.get()) / 1_000_000_000.0);
            int statusCode = response.getStatusCode();
            String method =
                request.getRequestMethod() != null ? request.getRequestMethod() : "UNKNOWN";
            String urlTemplate = extractUrlTemplate(request.getUrl());
            String serverAddress = resolveServerAddress(request.getUrl(), defaultServerAddress);

            AttributesBuilder attrBuilder =
                metrics
                    .clientAttributesBuilder()
                    .put(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD, method)
                    .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, (long) statusCode)
                    .put(
                        StorageClientMetrics.KEY_NETWORK_PATH,
                        StorageClientMetrics.NETWORK_PATH_CLOUDPATH)
                    .put(StorageClientMetrics.KEY_URL_TEMPLATE, urlTemplate)
                    .put(
                        StorageClientMetrics.KEY_SERVER_ADDRESS,
                        serverAddress != null ? serverAddress : "")
                    .put(
                        StorageClientMetrics.KEY_ERROR_TYPE,
                        statusCode >= 400
                            ? StorageErrorTypeMapper.mapHttpResponseCode(statusCode)
                            : StorageErrorTypeMapper.STATUS_OK);

            metrics
                .getHttpClientRequestDuration()
                .record(durationSeconds, attrBuilder.build(), Context.current());
          }
        });

    request.setIOExceptionHandler(
        (req, supportsRetry) -> {
          if (recorded.compareAndSet(false, true)
              && metrics.getHttpClientRequestDuration() != null) {
            double durationSeconds =
                Math.max(0.0, (clock.nanoTime() - startTimeNanos.get()) / 1_000_000_000.0);
            String method = req.getRequestMethod() != null ? req.getRequestMethod() : "UNKNOWN";
            String urlTemplate = extractUrlTemplate(req.getUrl());
            String serverAddress = resolveServerAddress(req.getUrl(), defaultServerAddress);

            AttributesBuilder attrBuilder =
                metrics
                    .clientAttributesBuilder()
                    .put(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD, method)
                    .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 0L)
                    .put(
                        StorageClientMetrics.KEY_NETWORK_PATH,
                        StorageClientMetrics.NETWORK_PATH_CLOUDPATH)
                    .put(StorageClientMetrics.KEY_URL_TEMPLATE, urlTemplate)
                    .put(
                        StorageClientMetrics.KEY_SERVER_ADDRESS,
                        serverAddress != null ? serverAddress : "")
                    .put(
                        StorageClientMetrics.KEY_ERROR_TYPE,
                        StorageErrorTypeMapper.STATUS_CONNECTIVITY);

            metrics
                .getHttpClientRequestDuration()
                .record(durationSeconds, attrBuilder.build(), Context.current());
          }
          return existingIoHandler != null
              && existingIoHandler.handleIOException(req, supportsRetry);
        });
  }

  static String resolveServerAddress(
      @Nullable GenericUrl url, @Nullable String defaultServerAddress) {
    String host = url != null ? url.getHost() : null;
    return (host != null && !host.isEmpty()) ? host : defaultServerAddress;
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
      String rest = path.substring("/storage/v1/".length());
      String[] segments = rest.split("/");
      if (segments.length >= 2 && "b".equals(segments[0])) {
        segments[1] = "{bucket}";
        if (segments.length >= 4 && "o".equals(segments[2])) {
          segments[3] = "{object}";
          if (segments.length >= 6) {
            if ("acl".equals(segments[4])) {
              segments[5] = "{entity}";
            } else if ("copyTo".equals(segments[4]) || "rewriteTo".equals(segments[4])) {
              if (segments.length >= 7 && "b".equals(segments[5])) {
                segments[6] = "{destinationBucket}";
              }
              if (segments.length >= 9 && "o".equals(segments[7])) {
                segments[8] = "{destinationObject}";
              }
            } else if ("moveTo".equals(segments[4])
                && "o".equals(segments[5])
                && segments.length >= 7) {
              segments[6] = "{destinationObject}";
            }
          }
        } else if (segments.length >= 4) {
          if ("acl".equals(segments[2]) || "defaultObjectAcl".equals(segments[2])) {
            segments[3] = "{entity}";
          } else if ("notifications".equals(segments[2])) {
            segments[3] = "{notification}";
          }
        }
      } else if (segments.length >= 2 && "projects".equals(segments[0])) {
        segments[1] = "{project}";
        if (segments.length >= 4 && "hmacKeys".equals(segments[2])) {
          segments[3] = "{accessId}";
        }
      }
      return "/storage/v1/" + String.join("/", segments);
    }
    String trimmed = path.startsWith("/") ? path.substring(1) : path;
    if (trimmed.isEmpty()) {
      return "/";
    }
    String[] parts = trimmed.split("/", 2);
    return parts.length == 1 ? "/{bucket}" : "/{bucket}/{object}";
  }
}
