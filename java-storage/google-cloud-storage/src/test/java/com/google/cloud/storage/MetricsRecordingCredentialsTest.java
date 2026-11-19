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

import static com.google.cloud.storage.StorageClientMetrics.ARTIFACT_STORAGE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_ERROR_TYPE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_CLIENT_SERVICE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_CLIENT_VERSION;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION;
import static com.google.cloud.storage.StorageClientMetrics.SERVICE_STORAGE;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_AUTHENTICATION_ERROR;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_CANCELLED;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_OK;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_TIMEOUT;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiClock;
import com.google.api.gax.rpc.internal.QuotaProjectIdHidingCredentials;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.auth.oauth2.GdchCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.auth.oauth2.QuotaProjectIdProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.NoCredentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.jspecify.annotations.Nullable;
import org.junit.Before;
import org.junit.Test;

public final class MetricsRecordingCredentialsTest {

  private static final URI STORAGE_URI = URI.create("https://storage.googleapis.com");

  private InMemoryMetricReader reader;
  private SdkMeterProvider provider;
  private StorageClientMetrics debugMetrics;
  private AtomicLong clockNanos;
  private ApiClock fakeClock;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    clockNanos = new AtomicLong(1_000_000_000L);
    fakeClock =
        new ApiClock() {
          @Override
          public long nanoTime() {
            return clockNanos.get();
          }

          @Override
          public long millisTime() {
            return clockNanos.get() / 1_000_000L;
          }
        };
    debugMetrics = createMetrics(/* debug= */ true);
  }

  @Test
  public void wrap_guardsDelegationAndDeserialization() throws Exception {
    TestGoogleCredentials delegate = new TestGoogleCredentials();
    Credentials nonGoogle = OAuth2Credentials.create(null);
    GdchCredentials gdch = mock(GdchCredentials.class);
    ServiceAccountCredentials unscopedSa = mock(ServiceAccountCredentials.class);
    when(unscopedSa.createScopedRequired()).thenReturn(true);

    assertThat(MetricsRecordingCredentials.wrap(null, debugMetrics, fakeClock)).isNull();
    assertThat(
            MetricsRecordingCredentials.wrap(NoCredentials.getInstance(), debugMetrics, fakeClock))
        .isSameInstanceAs(NoCredentials.getInstance());
    assertThat(MetricsRecordingCredentials.wrap(nonGoogle, debugMetrics, fakeClock))
        .isSameInstanceAs(nonGoogle);
    assertThat(MetricsRecordingCredentials.wrap(gdch, debugMetrics, fakeClock))
        .isSameInstanceAs(gdch);
    assertThat(MetricsRecordingCredentials.wrap(unscopedSa, debugMetrics, fakeClock))
        .isSameInstanceAs(unscopedSa);
    assertThat(MetricsRecordingCredentials.wrap(delegate, null, fakeClock))
        .isSameInstanceAs(delegate);
    assertThat(
            MetricsRecordingCredentials.wrap(
                delegate, createMetrics(/* debug= */ false), fakeClock))
        .isSameInstanceAs(delegate);

    GoogleCredentials wrapped =
        (GoogleCredentials) MetricsRecordingCredentials.wrap(delegate, debugMetrics, fakeClock);
    assertThat(wrapped).isInstanceOf(MetricsRecordingCredentials.class);
    assertThat(wrapped).isInstanceOf(QuotaProjectIdProvider.class);
    assertThat(MetricsRecordingCredentials.wrap(wrapped, debugMetrics, fakeClock))
        .isSameInstanceAs(wrapped);
    assertThat(wrapped.getAuthenticationType()).isEqualTo("OAuth2");
    assertThat(wrapped.getUniverseDomain()).isEqualTo("custom.universe.test");
    assertThat(wrapped.getMetricsCredentialType())
        .isEqualTo(CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT);
    assertThat(wrapped.getQuotaProjectId()).isEqualTo("quota-proj");
    assertThat(wrapped.hasRequestMetadata()).isTrue();
    assertThat(wrapped.hasRequestMetadataOnly()).isTrue();
    assertThat(wrapped.createScopedRequired()).isFalse();
    assertThat(wrapped.createScoped(Collections.singletonList("scope"))).isSameInstanceAs(wrapped);

    // Deserialized wrapper has null transient metrics/clock and passes through without NPE.
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(wrapped);
    }
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      GoogleCredentials deserialized = (GoogleCredentials) ois.readObject();
      assertThat(deserialized.getRequestMetadata(STORAGE_URI)).containsKey("Authorization");
      AtomicInteger asyncSuccess = new AtomicInteger();
      deserialized.getRequestMetadata(
          STORAGE_URI,
          MoreExecutors.directExecutor(),
          new RequestMetadataCallback() {
            @Override
            public void onSuccess(Map<String, List<String>> metadata) {
              asyncSuccess.incrementAndGet();
            }

            @Override
            public void onFailure(Throwable exception) {
              throw new AssertionError(exception);
            }
          });
      assertThat(asyncSuccess.get()).isEqualTo(1);
      deserialized.refresh();
      deserialized.refreshIfExpired();
    }
    assertThat(findRefreshMetric()).isNull();
  }

  @Test
  public void syncAndForcedRefresh_recordsOnlyActualRefreshesAndMapsErrors() throws Exception {
    TestGoogleCredentials delegate = new TestGoogleCredentials();
    delegate.onRefresh = () -> clockNanos.addAndGet(200_000_000L);
    GoogleCredentials wrapped =
        (GoogleCredentials) MetricsRecordingCredentials.wrap(delegate, debugMetrics, fakeClock);

    // Initial fetch refreshes (0.2s, OK); cached getRequestMetadata & refreshIfExpired skip.
    assertThat(wrapped.getRequestMetadata(STORAGE_URI)).containsKey("Authorization");
    clockNanos.addAndGet(50_000_000L);
    assertThat(wrapped.getRequestMetadata(STORAGE_URI)).containsKey("Authorization");
    wrapped.refreshIfExpired();
    // Explicit refresh() records once (0.2s, OK); following getRequestMetadata does not double.
    wrapped.refresh();
    assertThat(wrapped.getRequestMetadata(STORAGE_URI)).containsKey("Authorization");

    HistogramPointData okPoint = findPointByError(STATUS_OK);
    assertThat(okPoint.getCount()).isEqualTo(2L);
    assertThat(okPoint.getSum()).isWithin(0.0001).of(0.4);
    assertThat(okPoint.getAttributes())
        .isEqualTo(
            Attributes.builder()
                .put(KEY_GCP_CLIENT_SERVICE, SERVICE_STORAGE)
                .put(KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                .put(KEY_GCP_CLIENT_ARTIFACT, ARTIFACT_STORAGE)
                .put(KEY_ERROR_TYPE, STATUS_OK)
                .build());

    // Sync getRequestMetadata() and refresh() failures map TIMEOUT, CANCELLED, and AUTH_ERROR.
    TestGoogleCredentials syncFail = new TestGoogleCredentials();
    syncFail.failureToThrow = new SocketTimeoutException("token endpoint timed out");
    assertThrows(
        IOException.class,
        () ->
            MetricsRecordingCredentials.wrap(syncFail, debugMetrics, fakeClock)
                .getRequestMetadata(STORAGE_URI));
    assertThat(findPointByError(STATUS_TIMEOUT).getCount()).isEqualTo(1L);

    delegate.failureToThrow = new InterruptedIOException("cancelled");
    assertThrows(IOException.class, wrapped::refresh);
    assertThat(findPointByError(STATUS_CANCELLED).getCount()).isEqualTo(1L);

    delegate.failureToThrow = new IOException("invalid_grant");
    assertThrows(IOException.class, wrapped::refresh);
    assertThat(findPointByError(STATUS_AUTHENTICATION_ERROR).getCount()).isEqualTo(1L);

    // mapAuthErrorType edge cases: TimeoutException, CancellationException, wrapped interrupt,
    // depth bound, and cyclic cause chain.
    assertThat(MetricsRecordingCredentials.mapAuthErrorType(new TimeoutException("t")))
        .isEqualTo(STATUS_TIMEOUT);
    assertThat(MetricsRecordingCredentials.mapAuthErrorType(new CancellationException("c")))
        .isEqualTo(STATUS_CANCELLED);
    assertThat(
            MetricsRecordingCredentials.mapAuthErrorType(
                new IOException("interrupted", new InterruptedException())))
        .isEqualTo(STATUS_CANCELLED);
    Throwable deep = new SocketTimeoutException("deep");
    for (int i = 0; i < 25; i++) {
      deep = new IOException("wrap " + i, deep);
    }
    assertThat(MetricsRecordingCredentials.mapAuthErrorType(deep))
        .isEqualTo(STATUS_AUTHENTICATION_ERROR);
    RuntimeException cycleA = new RuntimeException("a");
    RuntimeException cycleB = new RuntimeException("b", cycleA);
    cycleA.initCause(cycleB);
    assertThat(MetricsRecordingCredentials.mapAuthErrorType(cycleA))
        .isEqualTo(STATUS_AUTHENTICATION_ERROR);
  }

  @Test
  public void asyncAndConcurrentRefresh_deduplicatesCoalescedRefreshesDeterministically()
      throws Exception {
    // 1) Deterministic capturing Executor: two async calls coalesce onto 1 RefreshTask.
    TestGoogleCredentials delegate = new TestGoogleCredentials();
    Credentials wrapped = MetricsRecordingCredentials.wrap(delegate, debugMetrics, fakeClock);
    List<Runnable> pendingTasks = new ArrayList<>();
    AtomicInteger completions = new AtomicInteger();
    AtomicReference<Throwable> callbackError = new AtomicReference<>();
    RequestMetadataCallback cb =
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            completions.incrementAndGet();
          }

          @Override
          public void onFailure(Throwable exception) {
            callbackError.set(exception);
          }
        };

    wrapped.getRequestMetadata(STORAGE_URI, pendingTasks::add, cb);
    wrapped.getRequestMetadata(STORAGE_URI, pendingTasks::add, cb);
    assertThat(pendingTasks).hasSize(1);
    clockNanos.addAndGet(300_000_000L);
    pendingTasks.get(0).run();
    assertThat(completions.get()).isEqualTo(2);
    assertThat(callbackError.get()).isNull();

    HistogramPointData okPoint = findPointByError(STATUS_OK);
    assertThat(okPoint.getCount()).isEqualTo(1L);
    assertThat(okPoint.getSum()).isWithin(0.0001).of(0.3);

    // Cached async call completes immediately without queuing or recording.
    pendingTasks.clear();
    wrapped.getRequestMetadata(STORAGE_URI, pendingTasks::add, cb);
    assertThat(pendingTasks).isEmpty();
    assertThat(completions.get()).isEqualTo(3);
    assertThat(findPointByError(STATUS_OK).getCount()).isEqualTo(1L);

    // 2) Concurrent refresh() + async getRequestMetadata() on fresh EXPIRED creds records once.
    TestGoogleCredentials coalescedDelegate = new TestGoogleCredentials();
    Credentials coalescedWrapped =
        MetricsRecordingCredentials.wrap(coalescedDelegate, debugMetrics, fakeClock);
    CountDownLatch entered = new CountDownLatch(1);
    CountDownLatch release = new CountDownLatch(1);
    coalescedDelegate.onRefresh =
        () -> {
          entered.countDown();
          try {
            release.await(5, TimeUnit.SECONDS);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          clockNanos.addAndGet(100_000_000L);
        };
    AtomicInteger coalescedCompletions = new AtomicInteger();
    RequestMetadataCallback coalescedCb =
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            coalescedCompletions.incrementAndGet();
          }

          @Override
          public void onFailure(Throwable exception) {
            callbackError.set(exception);
          }
        };
    ExecutorService pool = Executors.newSingleThreadExecutor();
    try {
      Future<?> refreshFuture =
          pool.submit(
              () -> {
                try {
                  coalescedWrapped.refresh();
                } catch (IOException e) {
                  throw new RuntimeException(e);
                }
              });
      assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue();
      coalescedWrapped.getRequestMetadata(STORAGE_URI, pendingTasks::add, coalescedCb);
      assertThat(pendingTasks).isEmpty();
      assertThat(coalescedCompletions.get()).isEqualTo(0);
      release.countDown();
      refreshFuture.get(5, TimeUnit.SECONDS);
    } finally {
      pool.shutdownNow();
    }
    assertThat(coalescedCompletions.get()).isEqualTo(1);
    assertThat(callbackError.get()).isNull();
    assertThat(findPointByError(STATUS_OK).getCount()).isEqualTo(2L);

    // 3) Async failure records AUTHENTICATION_ERROR.
    TestGoogleCredentials failing = new TestGoogleCredentials();
    failing.failureToThrow = new IOException("async auth error");
    MetricsRecordingCredentials.wrap(failing, debugMetrics, fakeClock)
        .getRequestMetadata(STORAGE_URI, MoreExecutors.directExecutor(), cb);
    assertThat(callbackError.get()).isInstanceOf(IOException.class);
    assertThat(findPointByError(STATUS_AUTHENTICATION_ERROR).getCount()).isEqualTo(1L);
  }

  @Test
  public void httpStorageOptions_wiresScopedCredentialsWithoutMutating() throws Exception {
    SigningTestCredentials signingCreds = new SigningTestCredentials();
    HttpStorageOptions httpDebugOptions =
        StorageOptions.http()
            .setProjectId("test-project")
            .setCredentials(signingCreds)
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(provider)
            .build();
    HttpStorageOptions httpDebugOptionsCopy = httpDebugOptions.toBuilder().build();

    // getCredentials() stays untouched (ServiceAccountSigner, equals, hashCode, Serializable).
    assertThat(httpDebugOptions.getCredentials()).isSameInstanceAs(signingCreds);
    assertThat(httpDebugOptions.getCredentials()).isInstanceOf(ServiceAccountSigner.class);
    assertThat(httpDebugOptions).isEqualTo(httpDebugOptionsCopy);
    assertThat(httpDebugOptions.hashCode()).isEqualTo(httpDebugOptionsCopy.hashCode());
    assertThat(httpDebugOptions.getScopedCredentials())
        .isInstanceOf(MetricsRecordingCredentials.class);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(httpDebugOptions);
    }
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      HttpStorageOptions deserializedOptions = (HttpStorageOptions) ois.readObject();
      assertThat(deserializedOptions.getCredentials()).isInstanceOf(ServiceAccountSigner.class);
    }

    // HTTP safely wraps ComputeEngineCredentials when debug metrics are enabled.
    ComputeEngineCredentials computeCreds = ComputeEngineCredentials.create();
    HttpStorageOptions httpComputeOptions =
        StorageOptions.http()
            .setProjectId("test-project")
            .setCredentials(computeCreds)
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(provider)
            .build();
    assertThat(httpComputeOptions.getScopedCredentials())
        .isInstanceOf(MetricsRecordingCredentials.class);

    // Toggling debug off via toBuilder() yields unwrapped credentials without leaking a wrapper.
    HttpStorageOptions httpStdOptions =
        httpDebugOptions.toBuilder().setEnableOtelDebugMetrics(false).build();
    assertThat(httpStdOptions.getScopedCredentials()).isSameInstanceAs(signingCreds);
  }

  @Test
  public void grpcStorageOptions_wiresCredentialsWithoutMutating() throws Exception {
    // 1) GoogleCredentials.create(null) is wrapped by MetricsRecordingCredentials and throws
    // IllegalStateException during the quota-project probe; must not emit a spurious error.
    GrpcStorageOptions nullTokenOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(GoogleCredentials.create(/* accessToken= */ null))
            .setClock(fakeClock)
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(provider)
            .build();
    assertThat(nullTokenOptions.getStorageSettings().getCredentialsProvider().getCredentials())
        .isInstanceOf(MetricsRecordingCredentials.class);
    assertThat(findRefreshMetric()).isNull();

    // 2) With x-goog-user-project: probe records refresh, preserves getCredentials(), and wraps
    // QuotaProjectIdHidingCredentials around MetricsRecordingCredentials.
    TestGoogleCredentials grpcCreds = new TestGoogleCredentials();
    grpcCreds.extraHeaders = ImmutableMap.of("x-goog-user-project", ImmutableList.of("quota-proj"));
    grpcCreds.onRefresh = () -> clockNanos.addAndGet(150_000_000L);
    GrpcStorageOptions grpcDebugOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(grpcCreds)
            .setClock(fakeClock)
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(provider)
            .build();
    assertThat(grpcDebugOptions.getCredentials()).isSameInstanceAs(grpcCreds);
    Credentials providerCreds =
        grpcDebugOptions.getStorageSettings().getCredentialsProvider().getCredentials();
    assertThat(providerCreds).isInstanceOf(QuotaProjectIdHidingCredentials.class);
    assertThat(providerCreds.getRequestMetadata(STORAGE_URI))
        .doesNotContainKey("x-goog-user-project");
    HistogramPointData okPoint = findPointByError(STATUS_OK);
    assertThat(okPoint.getCount()).isEqualTo(1L);
    assertThat(okPoint.getSum()).isWithin(0.0001).of(0.15);
    providerCreds.refresh();
    assertThat(findPointByError(STATUS_OK).getCount()).isEqualTo(2L);

    // 3) Without x-goog-user-project: direct MetricsRecordingCredentials when debug enabled, and
    // unwrapped passthrough when debug toggled off via toBuilder().
    TestGoogleCredentials noQuotaCreds = new TestGoogleCredentials();
    GrpcStorageOptions grpcNoQuotaDebug =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(noQuotaCreds)
            .setClock(fakeClock)
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(provider)
            .build();
    assertThat(grpcNoQuotaDebug.getStorageSettings().getCredentialsProvider().getCredentials())
        .isInstanceOf(MetricsRecordingCredentials.class);
    GrpcStorageOptions grpcNoQuotaStd =
        grpcNoQuotaDebug.toBuilder().setEnableOtelDebugMetrics(false).build();
    assertThat(grpcNoQuotaStd.getStorageSettings().getCredentialsProvider().getCredentials())
        .isSameInstanceAs(noQuotaCreds);

    // 4) gRPC keeps ComputeEngineCredentials unwrapped for DirectPath ALTS hard-bound tokens.
    ComputeEngineCredentials mockCompute = mock(ComputeEngineCredentials.class);
    GrpcStorageOptions grpcComputeOptions =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(mockCompute)
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(provider)
            .build();
    assertThat(grpcComputeOptions.getStorageSettings().getCredentialsProvider().getCredentials())
        .isSameInstanceAs(mockCompute);
  }

  private StorageClientMetrics createMetrics(boolean debug) {
    return StorageOptions.http()
        .setProjectId("test-project")
        .setCredentials(NoCredentials.getInstance())
        .setEnableOtelMetrics(true)
        .setEnableOtelDebugMetrics(debug)
        .setMeterProvider(provider)
        .build()
        .getStorageClientMetrics();
  }

  private @Nullable MetricData findRefreshMetric() {
    return reader.collectAllMetrics().stream()
        .filter(m -> m.getName().equals(METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION))
        .findFirst()
        .orElse(null);
  }

  private HistogramPointData findPointByError(String errorType) {
    MetricData metric = findRefreshMetric();
    assertThat(metric).isNotNull();
    assertThat(metric.getUnit()).isEqualTo("s");
    return metric.getHistogramData().getPoints().stream()
        .filter(p -> errorType.equals(p.getAttributes().get(KEY_ERROR_TYPE)))
        .findFirst()
        .orElseThrow(() -> new AssertionError("Missing point for error.type=" + errorType));
  }

  private static class TestGoogleCredentials extends GoogleCredentials {
    private static final long serialVersionUID = 1L;
    private final AtomicInteger counter = new AtomicInteger();
    transient @Nullable Runnable onRefresh;
    transient @Nullable IOException failureToThrow;
    transient @Nullable Map<String, List<String>> extraHeaders;

    @Override
    public AccessToken refreshAccessToken() throws IOException {
      if (onRefresh != null) {
        onRefresh.run();
      }
      if (failureToThrow != null) {
        throw failureToThrow;
      }
      return new AccessToken(
          "gtoken-" + counter.incrementAndGet(),
          new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)));
    }

    @Override
    protected Map<String, List<String>> getAdditionalHeaders() {
      return extraHeaders != null ? extraHeaders : ImmutableMap.of();
    }

    @Override
    public String getUniverseDomain() {
      return "custom.universe.test";
    }

    @Override
    public CredentialTypeForMetrics getMetricsCredentialType() {
      return CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT;
    }

    @Override
    public String getQuotaProjectId() {
      return "quota-proj";
    }
  }

  private static final class SigningTestCredentials extends TestGoogleCredentials
      implements ServiceAccountSigner {
    private static final long serialVersionUID = 1L;

    @Override
    public String getAccount() {
      return "sa@test-project.iam.gserviceaccount.com";
    }

    @Override
    public byte[] sign(byte[] toSign) {
      return toSign;
    }
  }
}
