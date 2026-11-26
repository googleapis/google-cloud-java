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
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.core.ApiClock;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.context.Context;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
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
 *
 * <p>{@code gcp.storage.client.ttfb} is recorded here across all HTTP operations and response
 * status codes when response headers arrive, resolving {@code gcp.storage.operation} from {@link
 * StorageMetricsContext#current()} when active or falling back to route-based resolution.
 */
@NullMarked
final class StorageHttpMetricsInterceptor implements HttpRequestInitializer {

  static final String HEADER_UPLOADER_UPLOAD_ID = "X-GUploader-UploadID";
  static final String HEADER_GFE_SERVICE_TIME = "X-Goog-Gfe-Service-Time";

  private static final ImmutableSet<String> OBJECT_SUB_RESOURCES =
      ImmutableSet.of("acl", "compose", "restore");

  private static final ImmutableMap<String, String> ROUTE_OPERATIONS =
      ImmutableMap.<String, String>builder()
          .put("POST /batch/storage/v1", "Batch")
          .put("POST /storage/v1/b", "CreateBucket")
          .put("GET /storage/v1/b", "ListBuckets")
          .put("GET /storage/v1/b/{bucket}", "GetBucket")
          .put("PATCH /storage/v1/b/{bucket}", "UpdateBucket")
          .put("DELETE /storage/v1/b/{bucket}", "DeleteBucket")
          .put("POST /storage/v1/b/{bucket}/lockRetentionPolicy", "LockBucketRetentionPolicy")
          .put("GET /storage/v1/b/{bucket}/iam", "GetIamPolicy")
          .put("PUT /storage/v1/b/{bucket}/iam", "SetIamPolicy")
          .put("GET /storage/v1/b/{bucket}/iam/testPermissions", "TestIamPermissions")
          .put("POST /storage/v1/b/{bucket}/acl", "CreateBucketACL")
          .put("GET /storage/v1/b/{bucket}/acl", "ListBucketACLs")
          .put("GET /storage/v1/b/{bucket}/acl/{entity}", "GetBucketACL")
          .put("PATCH /storage/v1/b/{bucket}/acl/{entity}", "UpdateBucketACL")
          .put("DELETE /storage/v1/b/{bucket}/acl/{entity}", "DeleteBucketACL")
          .put("POST /storage/v1/b/{bucket}/defaultObjectAcl", "CreateDefaultObjectACL")
          .put("GET /storage/v1/b/{bucket}/defaultObjectAcl", "ListDefaultObjectACLs")
          .put("GET /storage/v1/b/{bucket}/defaultObjectAcl/{entity}", "GetDefaultObjectACL")
          .put("PATCH /storage/v1/b/{bucket}/defaultObjectAcl/{entity}", "UpdateDefaultObjectACL")
          .put("DELETE /storage/v1/b/{bucket}/defaultObjectAcl/{entity}", "DeleteDefaultObjectACL")
          .put("POST /storage/v1/b/{bucket}/notificationConfigs", "CreateNotification")
          .put("GET /storage/v1/b/{bucket}/notificationConfigs", "ListNotifications")
          .put("GET /storage/v1/b/{bucket}/notificationConfigs/{notification}", "GetNotification")
          .put(
              "DELETE /storage/v1/b/{bucket}/notificationConfigs/{notification}",
              "DeleteNotification")
          .put("POST /storage/v1/b/{bucket}/o", "WriteObject")
          .put("GET /storage/v1/b/{bucket}/o", "ListObjects")
          .put("GET /storage/v1/b/{bucket}/o/{object}", "GetObject")
          .put("PATCH /storage/v1/b/{bucket}/o/{object}", "UpdateObject")
          .put("DELETE /storage/v1/b/{bucket}/o/{object}", "DeleteObject")
          .put("POST /storage/v1/b/{bucket}/o/{object}/compose", "ComposeObject")
          .put("POST /storage/v1/b/{bucket}/o/{object}/restore", "RestoreObject")
          .put(
              "POST /storage/v1/b/{bucket}/o/{object}/rewriteTo/b/{bucket}/o/{object}",
              "RewriteObject")
          .put("POST /storage/v1/b/{bucket}/o/{object}/moveTo/o/{object}", "MoveObject")
          .put("POST /storage/v1/b/{bucket}/o/{object}/acl", "CreateObjectACL")
          .put("GET /storage/v1/b/{bucket}/o/{object}/acl", "ListObjectACLs")
          .put("GET /storage/v1/b/{bucket}/o/{object}/acl/{entity}", "GetObjectACL")
          .put("PATCH /storage/v1/b/{bucket}/o/{object}/acl/{entity}", "UpdateObjectACL")
          .put("DELETE /storage/v1/b/{bucket}/o/{object}/acl/{entity}", "DeleteObjectACL")
          .put("POST /storage/v1/projects/{project}/hmacKeys", "CreateHMACKey")
          .put("GET /storage/v1/projects/{project}/hmacKeys", "ListHMACKeys")
          .put("GET /storage/v1/projects/{project}/hmacKeys/{access_id}", "GetHMACKey")
          .put("PUT /storage/v1/projects/{project}/hmacKeys/{access_id}", "UpdateHMACKey")
          .put("DELETE /storage/v1/projects/{project}/hmacKeys/{access_id}", "DeleteHMACKey")
          .put("GET /storage/v1/projects/{project}/serviceAccount", "GetServiceAccount")
          .build();

  private static final int NO_PENDING_RETRY = -1;
  private static final int NO_RESPONSE = 0;

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
    AtomicReference<Context> activeOtelContext = new AtomicReference<>(Context.root());
    AtomicReference<String> activeOperationName = new AtomicReference<>("");
    // HTTP status of a failed attempt that google-http-client is about to retry (NO_RESPONSE for
    // an IOException), recorded once the next attempt starts.
    AtomicInteger pendingRetryStatusCode = new AtomicInteger(NO_PENDING_RETRY);

    request.setInterceptor(
        req -> {
          int priorStatusCode = pendingRetryStatusCode.getAndSet(NO_PENDING_RETRY);
          if (priorStatusCode != NO_PENDING_RETRY) {
            recordInternalRetry(req, priorStatusCode);
          }
          if (existingExec != null) {
            existingExec.intercept(req);
          }
          startTimeNanos.set(clock.nanoTime());
          boolean started = recorded.compareAndSet(true, false);
          if (started && metrics.getRequestActive() != null) {
            StorageMetricsContext ctx = StorageMetricsContext.current();
            Context otelContext = ctx != null ? ctx.getOtelContext() : Context.current();
            String operationName = resolveOperationName(req, extractUrlTemplate(req.getUrl()));
            activeOtelContext.set(otelContext);
            activeOperationName.set(operationName);
            metrics.recordRequestActive(otelContext, operationName, 1L);
          }
        });

    if (existingUnsuccessfulHandler != null) {
      request.setUnsuccessfulResponseHandler(
          (req, response, supportsRetry) -> {
            long endNanos = clock.nanoTime();
            boolean handled = false;
            boolean completedNormally = false;
            try {
              handled = existingUnsuccessfulHandler.handleResponse(req, response, supportsRetry);
              completedNormally = true;
            } finally {
              if ((handled || !completedNormally)
                  && response.getRequest() == req
                  && recorded.compareAndSet(false, true)) {
                metrics.recordRequestActive(
                    activeOtelContext.get(), activeOperationName.get(), -1L);
                recordResponse(req, response, startTimeNanos.get(), endNanos);
              }
            }
            if (handled
                && supportsRetry
                && response.getRequest() == req
                && response.getStatusCode() >= 400) {
              pendingRetryStatusCode.set(response.getStatusCode());
            }
            return handled;
          });
    }

    request.setResponseInterceptor(
        response -> {
          long endNanos = clock.nanoTime();
          try {
            if (existingResp != null) {
              existingResp.interceptResponse(response);
            }
          } finally {
            if (response.getRequest() == request && recorded.compareAndSet(false, true)) {
              metrics.recordRequestActive(activeOtelContext.get(), activeOperationName.get(), -1L);
              recordResponse(request, response, startTimeNanos.get(), endNanos);
            }
          }
        });

    // HttpIOExceptionHandler does not receive the thrown IOException instance from
    // google-http-client, so transport-level IOExceptions default to STATUS_CONNECTION_ERROR here
    // (specific subtypes like TIMEOUT, DNS_FAILURE, and TLS_FAILURE are mapped in Retrying).
    request.setIOExceptionHandler(
        (req, supportsRetry) -> {
          if (recorded.compareAndSet(false, true)) {
            metrics.recordRequestActive(activeOtelContext.get(), activeOperationName.get(), -1L);
            double durationSeconds = (clock.nanoTime() - startTimeNanos.get()) / 1_000_000_000.0;
            String urlTemplate = extractUrlTemplate(req.getUrl());
            recordDuration(
                req,
                durationSeconds,
                0L,
                urlTemplate,
                StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);
            StorageMetricsContext ctx = StorageMetricsContext.current();
            metrics.recordServerUnreached(
                ctx != null ? ctx.getOtelContext() : Context.current(),
                resolveOperationName(req, urlTemplate),
                StorageClientMetrics.NETWORK_PATH_CLOUDPATH,
                StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);
          }
          boolean handled =
              existingIoHandler != null && existingIoHandler.handleIOException(req, supportsRetry);
          if (handled && supportsRetry) {
            pendingRetryStatusCode.set(NO_RESPONSE);
          }
          return handled;
        });
  }

  private void recordInternalRetry(HttpRequest request, int priorStatusCode) {
    String errorType =
        priorStatusCode == NO_RESPONSE
            ? StorageErrorTypeMapper.STATUS_CONNECTION_ERROR
            : StorageErrorTypeMapper.mapHttpResponseCode(priorStatusCode);
    StorageMetricsContext ctx = StorageMetricsContext.current();
    Context otelContext = Context.current();
    if (ctx != null) {
      // Retrying only sees the final outcome of HttpRequest.execute(), so the failed attempt that
      // google-http-client retried internally is recorded here.
      ctx.recordAttemptFailure(errorType, priorStatusCode);
      otelContext = ctx.getOtelContext();
    }
    metrics.recordRetry(
        otelContext,
        resolveOperationName(request, extractUrlTemplate(request.getUrl())),
        StorageClientMetrics.NETWORK_PATH_CLOUDPATH,
        errorType);
  }

  private void recordResponse(
      HttpRequest request, HttpResponse response, long startNanos, long endNanos) {
    int statusCode = response.getStatusCode();
    double durationSeconds = (endNanos - startNanos) / 1_000_000_000.0;
    String urlTemplate = extractUrlTemplate(request.getUrl());
    String errorType =
        statusCode >= 400
            ? StorageErrorTypeMapper.mapHttpResponseCode(statusCode)
            : StorageErrorTypeMapper.STATUS_OK;
    recordDuration(request, durationSeconds, statusCode, urlTemplate, errorType);
    // Evaluate request URL and query parameters at response time rather than in
    // initialize(HttpRequest), because callers such as MediaHttpDownloader or MediaHttpUploader
    // may append query parameters (e.g. alt=media, uploadType) after buildRequest().
    StorageMetricsContext ctx = StorageMetricsContext.current();
    Context otelContext = ctx != null ? ctx.getOtelContext() : Context.current();
    String operationName = resolveOperationName(request, urlTemplate);
    metrics.recordTtfb(
        otelContext, operationName, durationSeconds, StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
    boolean reached =
        hasNonEmptyHeader(response, HEADER_UPLOADER_UPLOAD_ID)
            || hasNonEmptyHeader(response, HEADER_GFE_SERVICE_TIME);
    if (!reached) {
      metrics.recordServerUnreached(
          otelContext, operationName, StorageClientMetrics.NETWORK_PATH_CLOUDPATH, errorType);
    }
  }

  private void recordDuration(
      HttpRequest request,
      double durationSeconds,
      long statusCode,
      String urlTemplate,
      String errorType) {
    metrics.recordHttpRequestDuration(
        durationSeconds, request.getRequestMethod(), statusCode, urlTemplate, errorType);
  }

  static String resolveOperationName(HttpRequest request, String urlTemplate) {
    StorageMetricsContext ctx = StorageMetricsContext.current();
    return ctx != null ? ctx.getOperationName() : defaultOperationName(request, urlTemplate);
  }

  static boolean isMediaDownloadRequest(HttpRequest request) {
    if (!"GET".equalsIgnoreCase(effectiveMethod(request))) {
      return false;
    }
    GenericUrl url = request.getUrl();
    String path = url.getRawPath();
    return (path != null && path.startsWith("/download/storage/v1/"))
        || "media".equals(url.getFirst("alt"));
  }

  static boolean isMediaUploadRequest(HttpRequest request) {
    String method = effectiveMethod(request);
    if (!"POST".equalsIgnoreCase(method) && !"PUT".equalsIgnoreCase(method)) {
      return false;
    }
    GenericUrl url = request.getUrl();
    String path = url.getRawPath();
    return (path != null && path.startsWith("/upload/storage/v1/"))
        || url.getFirst("uploadType") != null
        || url.getFirst("upload_id") != null;
  }

  static String extractUrlTemplate(GenericUrl url) {
    String path = url.getRawPath();
    if (path == null || path.isEmpty()) {
      return "/";
    }
    while (path.length() > 1 && path.startsWith("//")) {
      path = path.substring(1);
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

  private static String defaultOperationName(HttpRequest request, String urlTemplate) {
    if (isMediaDownloadRequest(request)) {
      return "ReadObject";
    }
    if (isMediaUploadRequest(request)) {
      return "WriteObject";
    }
    return ROUTE_OPERATIONS.getOrDefault(
        effectiveMethod(request).toUpperCase(Locale.ROOT) + " " + urlTemplate,
        StorageErrorTypeMapper.STATUS_UNKNOWN);
  }

  private static String effectiveMethod(HttpRequest request) {
    String override = request.getHeaders().getFirstHeaderStringValue("X-HTTP-Method-Override");
    return override != null ? override : request.getRequestMethod();
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

  private static boolean hasNonEmptyHeader(HttpResponse response, String headerName) {
    String value = response.getHeaders().getFirstHeaderStringValue(headerName);
    return value != null && !value.isEmpty();
  }
}
