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

import com.google.api.core.ApiClock;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GdchCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.common.annotations.VisibleForTesting;
import io.opentelemetry.context.Context;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Package-private {@link GoogleCredentials} decorator that records {@code
 * gcp.storage.client.auth.credential_refresh.duration} for blocking token acquisitions and
 * refreshes while preserving {@code instanceof GoogleCredentials} (for gRPC {@code
 * PRIVACY_AND_INTEGRITY}) and {@code QuotaProjectIdProvider}. Cached and non-blocking {@code STALE}
 * async lookups are skipped; concurrent coalesced successful refreshes are deduplicated while
 * failures are recorded per waiter.
 */
@NullMarked
final class MetricsRecordingCredentials extends GoogleCredentials {

  private static final long serialVersionUID = 1L;
  private static final int MAX_CAUSE_DEPTH = 20;
  private static final String APP_ENGINE_CREDENTIALS_CLASS =
      "com.google.auth.appengine.AppEngineCredentials";
  private static final String LEGACY_APP_ENGINE_CREDENTIALS_CLASS =
      "com.google.auth.oauth2.AppEngineCredentials";

  private final GoogleCredentials delegate;
  private final transient @Nullable StorageClientMetrics metrics;
  private final transient @Nullable ApiClock clock;
  private transient AtomicReference<@Nullable AccessToken> lastObservedToken;

  private MetricsRecordingCredentials(
      GoogleCredentials delegate, StorageClientMetrics metrics, ApiClock clock) {
    this.delegate = requireNonNull(delegate, "delegate cannot be null");
    this.metrics = requireNonNull(metrics, "metrics cannot be null");
    this.clock = requireNonNull(clock, "clock cannot be null");
    this.lastObservedToken = new AtomicReference<>(delegate.getAccessToken());
  }

  static @Nullable Credentials wrap(
      @Nullable Credentials credentials, @Nullable StorageClientMetrics metrics, ApiClock clock) {
    if (!(credentials instanceof GoogleCredentials)
        || credentials instanceof GdchCredentials
        || (credentials instanceof ServiceAccountCredentials
            && ((ServiceAccountCredentials) credentials).createScopedRequired())
        || credentials instanceof MetricsRecordingCredentials
        || metrics == null
        || metrics.getCredentialRefreshDuration() == null) {
      return credentials;
    }
    String className = credentials.getClass().getName();
    if (APP_ENGINE_CREDENTIALS_CLASS.equals(className)
        || LEGACY_APP_ENGINE_CREDENTIALS_CLASS.equals(className)) {
      return credentials;
    }
    return new MetricsRecordingCredentials((GoogleCredentials) credentials, metrics, clock);
  }

  @VisibleForTesting
  static String mapAuthErrorType(@Nullable Throwable t) {
    Throwable current = t;
    int depth = 0;
    while (current != null && depth < MAX_CAUSE_DEPTH) {
      // Check SocketTimeoutException before InterruptedIOException since it is a subclass.
      if (current instanceof SocketTimeoutException || current instanceof TimeoutException) {
        return StorageErrorTypeMapper.STATUS_TIMEOUT;
      }
      if (current instanceof CancellationException
          || current instanceof InterruptedException
          || current instanceof InterruptedIOException) {
        return StorageErrorTypeMapper.STATUS_CANCELLED;
      }
      Throwable next = current.getCause();
      if (next == current) {
        break;
      }
      current = next;
      depth++;
    }
    return StorageErrorTypeMapper.STATUS_AUTHENTICATION_ERROR;
  }

  @Override
  public String getAuthenticationType() {
    return delegate.getAuthenticationType();
  }

  @Override
  public String getUniverseDomain() throws IOException {
    return delegate.getUniverseDomain();
  }

  @Override
  public CredentialTypeForMetrics getMetricsCredentialType() {
    return delegate.getMetricsCredentialType();
  }

  @Override
  public boolean hasRequestMetadata() {
    return delegate.hasRequestMetadata();
  }

  @Override
  public boolean hasRequestMetadataOnly() {
    return delegate.hasRequestMetadataOnly();
  }

  @Override
  public @Nullable String getQuotaProjectId() {
    return delegate.getQuotaProjectId();
  }

  @Override
  public @Nullable String getProjectId() {
    return delegate.getProjectId();
  }

  @Override
  public boolean createScopedRequired() {
    return delegate.createScopedRequired();
  }

  @Override
  public GoogleCredentials createScoped(Collection<String> scopes) {
    return rewrap(delegate.createScoped(scopes));
  }

  @Override
  public GoogleCredentials createScoped(
      Collection<String> scopes, Collection<String> defaultScopes) {
    return rewrap(delegate.createScoped(scopes, defaultScopes));
  }

  @Override
  public Map<String, List<String>> getRequestMetadata(@Nullable URI uri) throws IOException {
    StorageClientMetrics m = this.metrics;
    ApiClock c = this.clock;
    if (m == null || c == null) {
      return delegate.getRequestMetadata(uri);
    }
    Context otelContext = Context.current();
    AccessToken before = delegate.getAccessToken();
    long startNanos = c.nanoTime();
    try {
      Map<String, List<String>> metadata = delegate.getRequestMetadata(uri);
      maybeRecordTokenChange(m, c, otelContext, startNanos, before);
      return metadata;
    } catch (IOException e) {
      record(m, c, otelContext, startNanos, mapAuthErrorType(e));
      throw e;
    }
  }

  @Override
  public void getRequestMetadata(
      @Nullable URI uri, Executor executor, RequestMetadataCallback callback) {
    StorageClientMetrics m = this.metrics;
    ApiClock c = this.clock;
    if (m == null || c == null) {
      delegate.getRequestMetadata(uri, executor, callback);
      return;
    }
    Context otelContext = Context.current();
    AccessToken before = delegate.getAccessToken();
    long startNanos = c.nanoTime();
    delegate.getRequestMetadata(
        uri,
        executor,
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            maybeRecordTokenChange(m, c, otelContext, startNanos, before);
            callback.onSuccess(metadata);
          }

          @Override
          public void onFailure(Throwable exception) {
            record(m, c, otelContext, startNanos, mapAuthErrorType(exception));
            callback.onFailure(exception);
          }
        });
  }

  @Override
  public void refresh() throws IOException {
    runRecorded(delegate::refresh);
  }

  @Override
  public void refreshIfExpired() throws IOException {
    runRecorded(delegate::refreshIfExpired);
  }

  private void runRecorded(IoAction action) throws IOException {
    StorageClientMetrics m = this.metrics;
    ApiClock c = this.clock;
    if (m == null || c == null) {
      action.run();
      return;
    }
    Context otelContext = Context.current();
    AccessToken before = delegate.getAccessToken();
    long startNanos = c.nanoTime();
    try {
      action.run();
      maybeRecordTokenChange(m, c, otelContext, startNanos, before);
    } catch (IOException e) {
      record(m, c, otelContext, startNanos, mapAuthErrorType(e));
      throw e;
    }
  }

  @FunctionalInterface
  private interface IoAction {
    void run() throws IOException;
  }

  private GoogleCredentials rewrap(GoogleCredentials scoped) {
    if (scoped == delegate) {
      return this;
    }
    StorageClientMetrics m = this.metrics;
    ApiClock c = this.clock;
    if (m == null || c == null) {
      return scoped;
    }
    return (GoogleCredentials) requireNonNull(wrap(scoped, m, c));
  }

  private void maybeRecordTokenChange(
      StorageClientMetrics m,
      ApiClock c,
      Context otelContext,
      long startNanos,
      @Nullable AccessToken before) {
    AccessToken after = delegate.getAccessToken();
    if (after == null || Objects.equals(before, after)) {
      return;
    }
    while (true) {
      AccessToken prev = lastObservedToken.get();
      if (Objects.equals(prev, after) || !Objects.equals(delegate.getAccessToken(), after)) {
        return;
      }
      if (lastObservedToken.compareAndSet(prev, after)) {
        record(m, c, otelContext, startNanos, StorageErrorTypeMapper.STATUS_OK);
        return;
      }
    }
  }

  private static void record(
      StorageClientMetrics m, ApiClock c, Context otelContext, long startNanos, String errorType) {
    double durationSeconds = (c.nanoTime() - startNanos) / 1_000_000_000.0;
    m.recordCredentialRefreshDuration(otelContext, durationSeconds, errorType);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.lastObservedToken = new AtomicReference<>(delegate.getAccessToken());
  }
}
