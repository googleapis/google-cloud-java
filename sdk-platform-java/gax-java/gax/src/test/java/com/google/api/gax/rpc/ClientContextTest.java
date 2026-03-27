/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiClock;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeClientSettings;
import com.google.api.gax.rpc.testing.FakeStubSettings;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.SpanTracerFactory;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.auth.oauth2.GdchCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientContextTest {
  private static final String DEFAULT_UNIVERSE_DOMAIN = "googleapis.com";
  private static final String DEFAULT_ENDPOINT = "https://foo.googleapis.com";
  private static final String DEFAULT_MTLS_ENDPOINT = "https://foo.mtls.googleapis.com";

  private static class InterceptingExecutor extends ScheduledThreadPoolExecutor {
    boolean shutdownCalled = false;

    public InterceptingExecutor(int corePoolSize) {
      super(corePoolSize);
    }

    public void shutdown() {
      shutdownCalled = true;
    }
  }

  private static class FakeExecutorProvider implements ExecutorProvider {
    ScheduledExecutorService executor;
    boolean shouldAutoClose;

    FakeExecutorProvider(ScheduledExecutorService executor, boolean shouldAutoClose) {
      this.executor = executor;
      this.shouldAutoClose = shouldAutoClose;
    }

    @Override
    public boolean shouldAutoClose() {
      return shouldAutoClose;
    }

    @Override
    public ScheduledExecutorService getExecutor() {
      return executor;
    }
  }

  private static class FakeTransportProvider implements TransportChannelProvider {
    final Executor executor;
    final FakeTransportChannel transport;
    final boolean shouldAutoClose;
    final Map<String, String> headers;
    final Credentials credentials;
    final String endpoint;
    final String mtlsEndpoint;

    FakeTransportProvider(
        FakeTransportChannel transport,
        Executor executor,
        boolean shouldAutoClose,
        Map<String, String> headers,
        Credentials credentials,
        String endpoint,
        String mtlsEndpoint) {
      this.transport = transport;
      this.executor = executor;
      this.shouldAutoClose = shouldAutoClose;
      this.headers = headers;
      this.transport.setHeaders(headers);
      this.credentials = credentials;
      this.endpoint = endpoint;
      this.mtlsEndpoint = mtlsEndpoint;
    }

    @Override
    public boolean shouldAutoClose() {
      return shouldAutoClose;
    }

    @Override
    public boolean needsExecutor() {
      return executor == null;
    }

    @Override
    public TransportChannelProvider withExecutor(ScheduledExecutorService executor) {
      return withExecutor((Executor) executor);
    }

    @Override
    public TransportChannelProvider withExecutor(Executor executor) {
      return new FakeTransportProvider(
          this.transport,
          executor,
          this.shouldAutoClose,
          this.headers,
          this.credentials,
          this.endpoint,
          this.mtlsEndpoint);
    }

    @Override
    public boolean needsHeaders() {
      return headers == null;
    }

    @Override
    public TransportChannelProvider withHeaders(Map<String, String> headers) {
      return new FakeTransportProvider(
          this.transport,
          this.executor,
          this.shouldAutoClose,
          headers,
          this.credentials,
          this.endpoint,
          this.mtlsEndpoint);
    }

    @Override
    public boolean needsEndpoint() {
      return true;
    }

    @Override
    public String getEndpoint() {
      return endpoint;
    }

    @Override
    public TransportChannelProvider withEndpoint(String endpoint) {
      return new FakeTransportProvider(
          this.transport,
          this.executor,
          this.shouldAutoClose,
          this.headers,
          this.credentials,
          endpoint,
          this.mtlsEndpoint);
    }

    @Override
    public boolean acceptsPoolSize() {
      return false;
    }

    @Override
    public TransportChannelProvider withPoolSize(int size) {
      throw new UnsupportedOperationException(
          "FakeTransportProvider doesn't allow pool size customization");
    }

    @Override
    public TransportChannel getTransportChannel() throws IOException {
      transport.setExecutor(executor);
      return transport;
    }

    @Override
    public String getTransportName() {
      return "FakeTransport";
    }

    @Override
    public boolean needsCredentials() {
      return credentials == null;
    }

    @Override
    public TransportChannelProvider withCredentials(Credentials credentials) {
      return new FakeTransportProvider(
          this.transport,
          this.executor,
          this.shouldAutoClose,
          this.headers,
          credentials,
          this.endpoint,
          this.mtlsEndpoint);
    }

    @Override
    public boolean needsMtlsEndpoint() {
      return this.mtlsEndpoint == null;
    }

    @Override
    public TransportChannelProvider withMtlsEndpoint(String mtlsEndpoint) {
      // Throws an exception if this is passed with a null value. This should never
      // happen as GAPICs should always have a default mtlsEndpoint value
      if (mtlsEndpoint == null) {
        throw new IllegalArgumentException("mtlsEndpoint is null");
      }
      return new FakeTransportProvider(
          this.transport,
          this.executor,
          this.shouldAutoClose,
          this.headers,
          this.credentials,
          this.endpoint,
          mtlsEndpoint);
    }
  }

  @Test
  void testNoAutoCloseContextNeedsNoExecutor() throws Exception {
    runTest(false, false, false, false);
  }

  @Test
  void testWithAutoCloseContextNeedsNoExecutor() throws Exception {
    runTest(true, false, false, false);
  }

  @Test
  void testWithAutoCloseContextNeedsExecutor() throws Exception {
    runTest(true, true, false, false);
  }

  @Test
  void testNeedsHeaders() throws Exception {
    runTest(false, false, true, false);
  }

  @Test
  void testNeedsHeadersCollision() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> runTest(false, false, true, true));
  }

  private void runTest(
      boolean shouldAutoClose,
      boolean contextNeedsExecutor,
      boolean needHeaders,
      boolean headersCollision)
      throws Exception {
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    InterceptingExecutor executor = new InterceptingExecutor(1);
    ExecutorProvider executorProvider = new FakeExecutorProvider(executor, shouldAutoClose);
    Map<String, String> headers = ImmutableMap.of("k1", "v1", "k2", "v2");
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel,
            contextNeedsExecutor ? null : executor,
            shouldAutoClose,
            needHeaders ? null : headers,
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);
    Credentials credentials = Mockito.mock(Credentials.class);
    ApiClock clock = Mockito.mock(ApiClock.class);
    Watchdog watchdog =
        Watchdog.createDuration(
            Mockito.mock(ApiClock.class),
            java.time.Duration.ZERO,
            Mockito.mock(ScheduledExecutorService.class));
    java.time.Duration watchdogCheckInterval = java.time.Duration.ofSeconds(11);

    builder.setExecutorProvider(executorProvider);
    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(FixedCredentialsProvider.create(credentials));
    builder.setWatchdogProvider(FixedWatchdogProvider.create(watchdog));
    builder.setWatchdogCheckIntervalDuration(watchdogCheckInterval);
    builder.setClock(clock);

    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(headerProvider.getHeaders()).thenReturn(ImmutableMap.of("k1", "v1"));
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);
    if (headersCollision) {
      Mockito.when(internalHeaderProvider.getHeaders()).thenReturn(ImmutableMap.of("k1", "v1"));
    } else {
      Mockito.when(internalHeaderProvider.getHeaders()).thenReturn(ImmutableMap.of("k2", "v2"));
    }

    builder.setHeaderProvider(headerProvider);
    builder.setInternalHeaderProvider(internalHeaderProvider);

    FakeClientSettings settings = builder.build();
    ClientContext clientContext = ClientContext.create(settings);

    Truth.assertThat(clientContext.getExecutor()).isSameInstanceAs(executor);
    Truth.assertThat(clientContext.getTransportChannel()).isSameInstanceAs(transportChannel);

    FakeTransportChannel actualChannel = (FakeTransportChannel) clientContext.getTransportChannel();
    assert actualChannel != null;
    Truth.assertThat(actualChannel.getHeaders()).isEqualTo(headers);
    Truth.assertThat(clientContext.getCredentials()).isSameInstanceAs(credentials);
    Truth.assertThat(clientContext.getClock()).isSameInstanceAs(clock);
    Truth.assertThat(clientContext.getStreamWatchdog()).isSameInstanceAs(watchdog);
    Truth.assertThat(clientContext.getStreamWatchdogCheckIntervalDuration())
        .isEqualTo(watchdogCheckInterval);

    Truth.assertThat(clientContext.getHeaders()).isEqualTo(ImmutableMap.of("k1", "v1"));
    Truth.assertThat(clientContext.getInternalHeaders()).isEqualTo(ImmutableMap.of("k2", "v2"));

    Truth.assertThat(executor.shutdownCalled).isFalse();
    Truth.assertThat(transportChannel.isShutdown()).isFalse();

    List<BackgroundResource> resources = clientContext.getBackgroundResources();

    if (!resources.isEmpty()) {
      // This is slightly too implementation-specific, but we need to ensure that executor is shut
      // down after the transportChannel: https://github.com/googleapis/gax-java/issues/785
      Truth.assertThat(resources.size()).isEqualTo(2);
      Truth.assertThat(transportChannel.isShutdown()).isNotEqualTo(shouldAutoClose);
      Truth.assertThat(executor.shutdownCalled).isNotEqualTo(shouldAutoClose);
      resources.get(0).shutdown();
      Truth.assertThat(transportChannel.isShutdown()).isEqualTo(shouldAutoClose);
      Truth.assertThat(executor.shutdownCalled).isNotEqualTo(shouldAutoClose);
      resources.get(1).shutdown();
      Truth.assertThat(transportChannel.isShutdown()).isEqualTo(shouldAutoClose);
      Truth.assertThat(executor.shutdownCalled).isEqualTo(shouldAutoClose);
    }
  }

  @Test
  void testWatchdogProvider() throws IOException {
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel, executor, true, null, null, DEFAULT_ENDPOINT, DEFAULT_MTLS_ENDPOINT);
    ApiClock clock = Mockito.mock(ApiClock.class);

    builder.setClock(clock);
    builder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    builder.setExecutorProvider(new FakeExecutorProvider(executor, true));
    builder.setTransportChannelProvider(transportProvider);

    java.time.Duration watchdogCheckInterval = java.time.Duration.ofSeconds(11);
    builder.setWatchdogProvider(
        InstantiatingWatchdogProvider.create()
            .withClock(clock)
            .withCheckIntervalDuration(watchdogCheckInterval)
            .withExecutor(executor));
    builder.setWatchdogCheckIntervalDuration(watchdogCheckInterval);

    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(headerProvider.getHeaders()).thenReturn(ImmutableMap.of("k1", "v1"));
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);

    Mockito.when(internalHeaderProvider.getHeaders()).thenReturn(ImmutableMap.of("k2", "v2"));
    builder.setHeaderProvider(headerProvider);
    builder.setInternalHeaderProvider(internalHeaderProvider);

    ClientContext context = ClientContext.create(builder.build());
    List<BackgroundResource> resources = context.getBackgroundResources();
    assertThat(resources.get(2)).isInstanceOf(Watchdog.class);
  }

  @Test
  void testMergeHeaders_getQuotaProjectIdFromHeadersProvider() throws IOException {
    final String QUOTA_PROJECT_ID_KEY = "x-goog-user-project";
    final String QUOTA_PROJECT_ID_FROM_SETTINGS = "quota_project_id_from_settings";
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel, executor, true, null, null, DEFAULT_ENDPOINT, DEFAULT_MTLS_ENDPOINT);

    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(headerProvider.getHeaders()).thenReturn(ImmutableMap.of("header_k1", "v1"));
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(internalHeaderProvider.getHeaders())
        .thenReturn(ImmutableMap.of("internal_header_k1", "v1"));

    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    builder.setHeaderProvider(headerProvider);
    builder.setInternalHeaderProvider(internalHeaderProvider);
    builder.setQuotaProjectId(QUOTA_PROJECT_ID_FROM_SETTINGS);

    ClientContext context = ClientContext.create(builder.build());
    List<BackgroundResource> resources = context.getBackgroundResources();
    FakeTransportChannel fakeTransportChannel = (FakeTransportChannel) resources.get(0);
    assertThat(fakeTransportChannel.getHeaders().size())
        .isEqualTo(
            headerProvider.getHeaders().size() + internalHeaderProvider.getHeaders().size() + 1);
    assertThat(fakeTransportChannel.getHeaders().get(QUOTA_PROJECT_ID_KEY))
        .isEqualTo(QUOTA_PROJECT_ID_FROM_SETTINGS);
  }

  @Test
  void testMergeHeaders_getQuotaProjectIdFromSettings() throws IOException {
    final String QUOTA_PROJECT_ID_KEY = "x-goog-user-project";
    final String QUOTA_PROJECT_ID_FROM_HEADERS = "quota_project_id_from_headers";
    final String QUOTA_PROJECT_ID_FROM_INTERNAL_HEADERS = "quota_project_id_from_internal_headers";
    final String QUOTA_PROJECT_ID_FROM_SETTINGS = "quota_project_id_from_settings";
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel, executor, true, null, null, DEFAULT_ENDPOINT, DEFAULT_MTLS_ENDPOINT);

    HeaderProvider headerProvider =
        new HeaderProvider() {
          @Override
          public Map<String, String> getHeaders() {
            return ImmutableMap.of(QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_HEADERS, "k2", "v2");
          }
        };
    HeaderProvider internalHeaderProvider =
        new HeaderProvider() {
          @Override
          public Map<String, String> getHeaders() {
            return ImmutableMap.of(
                QUOTA_PROJECT_ID_KEY,
                QUOTA_PROJECT_ID_FROM_INTERNAL_HEADERS,
                "internal_header_k1",
                "v1");
          }
        };

    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    builder.setHeaderProvider(headerProvider);
    builder.setInternalHeaderProvider(internalHeaderProvider);
    builder.setQuotaProjectId(QUOTA_PROJECT_ID_FROM_SETTINGS);

    ClientContext context = ClientContext.create(builder.build());
    List<BackgroundResource> resources = context.getBackgroundResources();
    FakeTransportChannel fakeTransportChannel = (FakeTransportChannel) resources.get(0);
    assertThat(fakeTransportChannel.getHeaders().size())
        .isEqualTo(
            headerProvider.getHeaders().size() + internalHeaderProvider.getHeaders().size() - 1);
    assertThat(fakeTransportChannel.getHeaders().get(QUOTA_PROJECT_ID_KEY))
        .isEqualTo(QUOTA_PROJECT_ID_FROM_SETTINGS);
  }

  @Test
  void testMergeHeaders_noQuotaProjectIdSet() throws IOException {
    final String QUOTA_PROJECT_ID_KEY = "x-goog-user-project";
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel, executor, true, null, null, DEFAULT_ENDPOINT, DEFAULT_MTLS_ENDPOINT);

    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(headerProvider.getHeaders()).thenReturn(ImmutableMap.of("header_k1", "v1"));
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(internalHeaderProvider.getHeaders())
        .thenReturn(ImmutableMap.of("internal_header_k1", "v1"));

    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    builder.setHeaderProvider(headerProvider);
    builder.setInternalHeaderProvider(internalHeaderProvider);

    ClientContext context = ClientContext.create(builder.build());
    List<BackgroundResource> resources = context.getBackgroundResources();
    FakeTransportChannel fakeTransportChannel = (FakeTransportChannel) resources.get(0);
    assertThat(fakeTransportChannel.getHeaders().size())
        .isEqualTo(headerProvider.getHeaders().size() + internalHeaderProvider.getHeaders().size());
    assertThat(fakeTransportChannel.getHeaders().containsKey(QUOTA_PROJECT_ID_KEY)).isFalse();
  }

  @Test
  void testHidingQuotaProjectId_quotaSetFromSetting() throws IOException {
    final String QUOTA_PROJECT_ID_KEY = "x-goog-user-project";
    final String QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE = "quota_project_id_from_credentials";
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel, executor, true, null, null, DEFAULT_ENDPOINT, DEFAULT_MTLS_ENDPOINT);
    Map<String, List<String>> metaDataWithQuota =
        ImmutableMap.of(
            "k1",
            Collections.singletonList("v1"),
            QUOTA_PROJECT_ID_KEY,
            Collections.singletonList(QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE));
    final Credentials credentialsWithQuotaProjectId = Mockito.mock(GoogleCredentials.class);
    Mockito.when(credentialsWithQuotaProjectId.getRequestMetadata(null))
        .thenReturn(metaDataWithQuota);
    HeaderProvider headerProviderWithQuota = Mockito.mock(HeaderProvider.class);
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);

    builder.setExecutorProvider(new FakeExecutorProvider(executor, true));
    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(
        new CredentialsProvider() {
          @Override
          public Credentials getCredentials() throws IOException {
            return credentialsWithQuotaProjectId;
          }
        });
    builder.setHeaderProvider(headerProviderWithQuota);
    builder.setInternalHeaderProvider(internalHeaderProvider);
    builder.setQuotaProjectId(QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE);

    ClientContext clientContext = ClientContext.create(builder.build());
    assertThat(clientContext.getCredentials().getRequestMetadata().size())
        .isEqualTo(metaDataWithQuota.size() - 1);
    assertThat(
            clientContext.getCredentials().getRequestMetadata().containsKey(QUOTA_PROJECT_ID_KEY))
        .isFalse();
  }

  @Test
  void testHidingQuotaProjectId_noQuotaSetFromSetting() throws IOException {
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel, executor, true, null, null, DEFAULT_ENDPOINT, DEFAULT_MTLS_ENDPOINT);
    Map<String, List<String>> metaData = ImmutableMap.of("k1", Collections.singletonList("v1"));
    final Credentials credentialsWithoutQuotaProjectId = Mockito.mock(GoogleCredentials.class);
    Mockito.when(credentialsWithoutQuotaProjectId.getRequestMetadata(null)).thenReturn(metaData);
    HeaderProvider headerProviderWithQuota = Mockito.mock(HeaderProvider.class);
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);

    builder.setExecutorProvider(new FakeExecutorProvider(executor, true));
    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(
        new CredentialsProvider() {
          @Override
          public Credentials getCredentials() throws IOException {
            return credentialsWithoutQuotaProjectId;
          }
        });
    builder.setHeaderProvider(headerProviderWithQuota);
    builder.setInternalHeaderProvider(internalHeaderProvider);

    ClientContext clientContext = ClientContext.create(builder.build());
    assertThat(clientContext.getCredentials().getRequestMetadata(null)).isEqualTo(metaData);
  }

  @Test
  void testQuotaProjectId_worksWithNullCredentials() throws IOException {
    final String QUOTA_PROJECT_ID = "quota_project_id";

    final InterceptingExecutor executor = new InterceptingExecutor(1);
    final FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    final FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel,
            executor,
            true,
            null,
            Mockito.mock(Credentials.class),
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);

    final FakeClientSettings.Builder settingsBuilder = new FakeClientSettings.Builder();

    settingsBuilder
        .setTransportChannelProvider(transportProvider)
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setQuotaProjectId(QUOTA_PROJECT_ID);

    assertThat(ClientContext.create(settingsBuilder.build()).getCredentials()).isNull();
  }

  @Test
  void testUserAgentInternalOnly() throws Exception {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);

    ClientSettings.Builder builder =
        new FakeClientSettings.Builder()
            .setExecutorProvider(
                FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class)))
            .setTransportChannelProvider(transportChannelProvider)
            .setCredentialsProvider(
                FixedCredentialsProvider.create(Mockito.mock(GoogleCredentials.class)));

    builder.setInternalHeaderProvider(FixedHeaderProvider.create("user-agent", "internal-agent"));

    ClientContext clientContext = ClientContext.create(builder.build());
    FakeTransportChannel transportChannel =
        (FakeTransportChannel) clientContext.getTransportChannel();

    assertThat(transportChannel.getHeaders()).containsEntry("user-agent", "internal-agent");
  }

  @Test
  void testUserAgentExternalOnly() throws Exception {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);

    ClientSettings.Builder builder =
        new FakeClientSettings.Builder()
            .setExecutorProvider(
                FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class)))
            .setTransportChannelProvider(transportChannelProvider)
            .setCredentialsProvider(
                FixedCredentialsProvider.create(Mockito.mock(GoogleCredentials.class)));

    builder.setHeaderProvider(FixedHeaderProvider.create("user-agent", "user-supplied-agent"));

    ClientContext clientContext = ClientContext.create(builder.build());
    FakeTransportChannel transportChannel =
        (FakeTransportChannel) clientContext.getTransportChannel();

    assertThat(transportChannel.getHeaders()).containsEntry("user-agent", "user-supplied-agent");
  }

  @Test
  void testUserAgentConcat() throws Exception {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);

    ClientSettings.Builder builder =
        new FakeClientSettings.Builder()
            .setExecutorProvider(
                FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class)))
            .setTransportChannelProvider(transportChannelProvider)
            .setCredentialsProvider(
                FixedCredentialsProvider.create(Mockito.mock(GoogleCredentials.class)));

    builder.setHeaderProvider(FixedHeaderProvider.create("user-agent", "user-supplied-agent"));
    builder.setInternalHeaderProvider(FixedHeaderProvider.create("user-agent", "internal-agent"));

    ClientContext clientContext = ClientContext.create(builder.build());
    FakeTransportChannel transportChannel =
        (FakeTransportChannel) clientContext.getTransportChannel();

    assertThat(transportChannel.getHeaders())
        .containsEntry("user-agent", "user-supplied-agent internal-agent");
  }

  @Test
  void testApiClientHeaderAppendsCredType() throws Exception {
    GoogleCredentials googleCredentials = Mockito.mock(GoogleCredentials.class);
    when(googleCredentials.getMetricsCredentialType())
        .thenReturn(CredentialTypeForMetrics.USER_CREDENTIALS);

    Map<String, String> headers =
        setupTestForCredentialTokenUsageMetricsAndGetTransportChannelHeaders(
            FixedCredentialsProvider.create(googleCredentials),
            FixedHeaderProvider.create("x-goog-api-client", "internal-agent"));

    assertThat(headers).containsEntry("x-goog-api-client", "internal-agent cred-type/u");
  }

  @Test
  void testApiClientHeaderDoNotAppendsCredType_whenNoApiClientHeader() throws Exception {
    GoogleCredentials googleCredentials = Mockito.mock(GoogleCredentials.class);
    when(googleCredentials.getMetricsCredentialType())
        .thenReturn(CredentialTypeForMetrics.USER_CREDENTIALS);

    Map<String, String> headers =
        setupTestForCredentialTokenUsageMetricsAndGetTransportChannelHeaders(
            FixedCredentialsProvider.create(googleCredentials),
            FixedHeaderProvider.create("some-other-header", "internal-agent"));

    assertThat(headers).doesNotContainKey("x-goog-api-client");
    assertThat(headers).containsEntry("some-other-header", "internal-agent");
  }

  @Test
  void testApiClientHeaderDoNotAppendsCredType_whenNullCredentials() throws IOException {
    Map<String, String> headers =
        setupTestForCredentialTokenUsageMetricsAndGetTransportChannelHeaders(
            NoCredentialsProvider.create(),
            FixedHeaderProvider.create("x-goog-api-client", "internal-agent"));

    assertThat(headers).containsKey("x-goog-api-client");
    assertThat(headers.get("x-goog-api-client")).doesNotContain("cred-type/");
  }

  @Test
  void testApiClientHeaderDoNotAppendsCredType_whenCredTypeDoNotSend() throws Exception {
    GoogleCredentials googleCredentials = Mockito.mock(GoogleCredentials.class);
    when(googleCredentials.getMetricsCredentialType())
        .thenReturn(CredentialTypeForMetrics.DO_NOT_SEND);

    Map<String, String> headers =
        setupTestForCredentialTokenUsageMetricsAndGetTransportChannelHeaders(
            FixedCredentialsProvider.create(googleCredentials),
            FixedHeaderProvider.create("x-goog-api-client", "internal-agent"));

    assertThat(headers).containsKey("x-goog-api-client");
    assertThat(headers.get("x-goog-api-client")).doesNotContain("cred-type/");
  }

  private Map<String, String> setupTestForCredentialTokenUsageMetricsAndGetTransportChannelHeaders(
      CredentialsProvider credentialsProvider, HeaderProvider headerProvider) throws IOException {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);

    ClientSettings.Builder builder =
        new FakeClientSettings.Builder()
            .setExecutorProvider(
                FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class)))
            .setTransportChannelProvider(transportChannelProvider)
            .setCredentialsProvider(credentialsProvider)
            .setInternalHeaderProvider(headerProvider);

    ClientContext clientContext = ClientContext.create(builder.build());
    FakeTransportChannel transportChannel =
        (FakeTransportChannel) clientContext.getTransportChannel();
    return transportChannel.getHeaders();
  }

  @Test
  void testSwitchToMtlsEndpointAllowed() throws IOException {
    StubSettings settings = new FakeStubSettings.Builder().setEndpoint(DEFAULT_ENDPOINT).build();
    assertFalse(settings.getSwitchToMtlsEndpointAllowed());
    assertEquals(DEFAULT_ENDPOINT, settings.getEndpoint());

    settings =
        new FakeStubSettings.Builder()
            .setEndpoint(DEFAULT_ENDPOINT)
            .setSwitchToMtlsEndpointAllowed(true)
            .build();
    assertTrue(settings.getSwitchToMtlsEndpointAllowed());
    assertEquals(DEFAULT_ENDPOINT, settings.getEndpoint());

    // Test setEndpoint sets the switchToMtlsEndpointAllowed value to false.
    settings =
        new FakeStubSettings.Builder()
            .setSwitchToMtlsEndpointAllowed(true)
            .setEndpoint(DEFAULT_ENDPOINT)
            .build();
    assertFalse(settings.getSwitchToMtlsEndpointAllowed());
    assertEquals(DEFAULT_ENDPOINT, settings.getEndpoint());
  }

  @Test
  void testExecutorSettings() throws Exception {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);

    ClientSettings.Builder builder =
        new FakeClientSettings.Builder()
            .setTransportChannelProvider(transportChannelProvider)
            .setCredentialsProvider(
                FixedCredentialsProvider.create(Mockito.mock(GoogleCredentials.class)));

    // By default, if executor is not set, channel provider should not have an executor set
    ClientContext context = ClientContext.create(builder.build());
    FakeTransportChannel transportChannel = (FakeTransportChannel) context.getTransportChannel();
    assertThat(transportChannel.getExecutor()).isNull();

    ExecutorProvider channelExecutorProvider =
        FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class));
    builder.setTransportChannelProvider(
        transportChannelProvider.withExecutor((Executor) channelExecutorProvider.getExecutor()));
    context = ClientContext.create(builder.build());
    transportChannel = (FakeTransportChannel) context.getTransportChannel();
    assertThat(transportChannel.getExecutor())
        .isSameInstanceAs(channelExecutorProvider.getExecutor());

    ExecutorProvider executorProvider =
        FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class));
    assertThat(channelExecutorProvider.getExecutor())
        .isNotSameInstanceAs(executorProvider.getExecutor());

    // For backward compatibility, if executor is set from stubSettings.setExecutor, and transport
    // channel already has an executor, the ExecutorProvider set in stubSettings won't override
    // transport channel's executor
    builder.setExecutorProvider(executorProvider);
    context = ClientContext.create(builder.build());
    transportChannel = (FakeTransportChannel) context.getTransportChannel();
    assertThat(transportChannel.getExecutor())
        .isSameInstanceAs(channelExecutorProvider.getExecutor());

    // For backward compatibility, if executor is set from stubSettings.setExecutor, and transport
    // channel doesn't have an executor, transport channel will get the executor from
    // stubSettings.setExecutor
    builder.setExecutorProvider(executorProvider);
    builder.setTransportChannelProvider(
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT));
    context = ClientContext.create(builder.build());
    transportChannel = (FakeTransportChannel) context.getTransportChannel();
    assertThat(transportChannel.getExecutor()).isSameInstanceAs(executorProvider.getExecutor());
  }

  private GdchCredentials getMockGdchCredentials() throws IOException {
    GdchCredentials creds = Mockito.mock(GdchCredentials.class);

    // GdchCredentials builder is mocked to accept a well-formed uri
    GdchCredentials.Builder gdchCredsBuilder = Mockito.mock(GdchCredentials.Builder.class);
    Mockito.when(gdchCredsBuilder.setGdchAudience(Mockito.any(URI.class)))
        .thenReturn(gdchCredsBuilder);
    Mockito.when(gdchCredsBuilder.build()).thenReturn(creds);
    Mockito.when(creds.toBuilder()).thenReturn(gdchCredsBuilder);
    Mockito.when(creds.createWithGdchAudience(Mockito.any()))
        .thenAnswer((uri) -> getMockGdchCredentials());
    return creds;
  }

  private TransportChannelProvider getFakeTransportChannelProvider() {
    return new FakeTransportProvider(
        FakeTransportChannel.create(new FakeChannel()),
        null,
        true,
        null,
        null,
        DEFAULT_ENDPOINT,
        DEFAULT_MTLS_ENDPOINT);
  }

  // EndpointContext will construct a valid endpoint if nothing is provided
  @Test
  void testCreateClientContext_withGdchCredentialNoAudienceNoEndpoint() throws IOException {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()), null, true, null, null, null, null);
    Credentials creds = getMockGdchCredentials();

    CredentialsProvider provider = FixedCredentialsProvider.create(creds);
    StubSettings settings = new FakeStubSettings.Builder().setGdchApiAudience(null).build();
    FakeClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setCredentialsProvider(provider);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);

    ClientContext context = ClientContext.create(clientSettingsBuilder.build());

    Credentials fromContext = context.getCredentials();
    Credentials fromProvider = provider.getCredentials();
    assertNotNull(fromProvider);
    assertNotNull(fromContext);
    assertThat(fromContext).isInstanceOf(GdchCredentials.class);
    assertThat(fromProvider).isInstanceOf(GdchCredentials.class);
    assertNotSame(fromContext, fromProvider);
    verify((GdchCredentials) fromProvider, times(1))
        .createWithGdchAudience(URI.create("test.googleapis.com:443"));
  }

  @Test
  void testCreateClientContext_withGdchCredentialNoAudienceEmptyEndpoint_throws()
      throws IOException {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()), null, true, null, null, null, null);
    Credentials creds = getMockGdchCredentials();

    CredentialsProvider provider = FixedCredentialsProvider.create(creds);
    StubSettings settings =
        new FakeStubSettings.Builder().setGdchApiAudience(null).setEndpoint("").build();
    FakeClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setCredentialsProvider(provider);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);

    // should throw
    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            () -> ClientContext.create(clientSettingsBuilder.build()));
    assertEquals("Could not infer GDCH api audience from settings", ex.getMessage());
  }

  @Test
  void testCreateClientContext_withGdchCredentialWithoutAudienceWithEndpoint_correct()
      throws IOException {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()), null, true, null, null, null, null);
    Credentials creds = getMockGdchCredentials();

    // it should correctly create a client context with gdch creds and null audience
    CredentialsProvider provider = FixedCredentialsProvider.create(creds);
    StubSettings settings =
        new FakeStubSettings.Builder()
            .setGdchApiAudience(null)
            .setEndpoint("test-endpoint")
            .build();
    FakeClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setCredentialsProvider(provider);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);

    // should not throw
    ClientContext context = ClientContext.create(clientSettingsBuilder.build());

    Credentials fromContext = context.getCredentials();
    Credentials fromProvider = provider.getCredentials();
    assertNotNull(fromProvider);
    assertNotNull(fromContext);
    assertThat(fromContext).isInstanceOf(GdchCredentials.class);
    assertThat(fromProvider).isInstanceOf(GdchCredentials.class);
    assertNotSame(fromContext, fromProvider);
    verify((GdchCredentials) fromProvider, times(1))
        .createWithGdchAudience(URI.create("test-endpoint"));
  }

  @Test
  void testCreateClientContext_withGdchCredentialAndValidAudience() throws IOException {
    Credentials creds = getMockGdchCredentials();
    CredentialsProvider provider = FixedCredentialsProvider.create(creds);
    TransportChannelProvider transportChannelProvider = getFakeTransportChannelProvider();

    // it should throw if both apiAudience and GDC-H creds are set but apiAudience is not a valid
    // uri
    StubSettings settings =
        new FakeStubSettings.Builder()
            .setEndpoint("test-endpoint")
            .setGdchApiAudience("valid-uri")
            .build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setCredentialsProvider(provider);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    ClientContext context = ClientContext.create(clientSettingsBuilder.build());
    Credentials fromContext = context.getCredentials();
    Credentials fromProvider = provider.getCredentials();
    assertNotNull(fromProvider);
    assertNotNull(fromContext);
    // using an audience should have made the context to recreate the credentials
    assertNotSame(fromContext, fromProvider);
    verify((GdchCredentials) fromProvider, times(1))
        .createWithGdchAudience(URI.create("valid-uri"));
    verify((GdchCredentials) fromProvider, times(0))
        .createWithGdchAudience(URI.create("test-endpoint"));
  }

  @Test
  void testCreateClientContext_withGdchCredentialAndInvalidAudience_throws() throws IOException {
    TransportChannelProvider transportChannelProvider = getFakeTransportChannelProvider();
    Credentials creds = getMockGdchCredentials();
    CredentialsProvider provider = FixedCredentialsProvider.create(creds);

    // it should throw if both apiAudience and GDC-H creds are set but apiAudience is not a valid
    // uri
    StubSettings settings =
        new FakeStubSettings.Builder()
            .setGdchApiAudience("$invalid-uri:")
            .setEndpoint("test-endpoint")
            .build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setCredentialsProvider(provider);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    final ClientSettings withGdchCredentialsAndMalformedApiAudience = clientSettingsBuilder.build();
    // should throw
    String exMessage =
        assertThrows(
                IllegalArgumentException.class,
                () -> ClientContext.create(withGdchCredentialsAndMalformedApiAudience))
            .getMessage();
    assertThat(exMessage).contains("The GDC-H API audience string is not a valid URI");

    Credentials fromProvider = provider.getCredentials();
    verify((GdchCredentials) fromProvider, times(0))
        .createWithGdchAudience(URI.create("test-endpoint"));
  }

  @Test
  void testCreateClientContext_withNonGdchCredentialAndAnyAudience_throws() throws IOException {
    TransportChannelProvider transportChannelProvider = getFakeTransportChannelProvider();

    // it should throw if apiAudience is set but not using GDC-H creds
    StubSettings settings =
        new FakeStubSettings.Builder().setGdchApiAudience("audience:test").build();
    Credentials creds = Mockito.mock(ComputeEngineCredentials.class);
    CredentialsProvider provider = FixedCredentialsProvider.create(creds);
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setCredentialsProvider(provider);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    final ClientSettings withComputeCredentials = clientSettingsBuilder.build();
    // should throw
    String exMessage =
        assertThrows(
                IllegalArgumentException.class, () -> ClientContext.create(withComputeCredentials))
            .getMessage();
    assertThat(exMessage).contains("GDC-H API audience can only be set when using GdchCredentials");
  }

  @Test
  void testCreateClientContext_SetEndpointViaClientSettings() throws IOException {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()), null, true, null, null, null, null);
    StubSettings settings =
        new FakeStubSettings.Builder()
            .setEndpoint(DEFAULT_ENDPOINT)
            .setUniverseDomain(DEFAULT_UNIVERSE_DOMAIN)
            .build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    clientSettingsBuilder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    ClientSettings clientSettings = clientSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(clientSettings);
    assertThat(clientContext.getEndpoint()).isEqualTo(DEFAULT_ENDPOINT);
    assertThat(clientContext.getUniverseDomain()).isEqualTo(DEFAULT_UNIVERSE_DOMAIN);
  }

  @Test
  void testCreateClientContext_SetEndpointViaTransportChannelProvider() throws IOException {
    String transportChannelProviderEndpoint = "transport.endpoint.com";
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            transportChannelProviderEndpoint,
            DEFAULT_MTLS_ENDPOINT);
    StubSettings settings =
        new FakeStubSettings.Builder()
            .setEndpoint(null)
            .setUniverseDomain(DEFAULT_UNIVERSE_DOMAIN)
            .build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    clientSettingsBuilder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    ClientSettings clientSettings = clientSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(clientSettings);
    assertThat(clientContext.getEndpoint()).isEqualTo(transportChannelProviderEndpoint);
    assertThat(clientContext.getUniverseDomain()).isEqualTo(DEFAULT_UNIVERSE_DOMAIN);
  }

  @Test
  void testCreateClientContext_SetEndpointViaClientSettingsAndTransportChannelProvider()
      throws IOException {
    String clientSettingsEndpoint = "clientSettingsEndpoint.com";
    String transportChannelProviderEndpoint = "transportChannelProviderEndpoint.com";
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()),
            null,
            true,
            null,
            null,
            transportChannelProviderEndpoint,
            DEFAULT_MTLS_ENDPOINT);
    StubSettings settings =
        new FakeStubSettings.Builder()
            .setEndpoint(clientSettingsEndpoint)
            .setUniverseDomain(DEFAULT_UNIVERSE_DOMAIN)
            .build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    clientSettingsBuilder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    ClientSettings clientSettings = clientSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(clientSettings);
    // ClientContext.getEndpoint() is the resolved endpoint. If both the client settings
    // and transport channel provider's endpoints are set, the resolved endpoint will be
    // the transport channel provider's endpoint.
    assertThat(clientContext.getEndpoint()).isEqualTo(transportChannelProviderEndpoint);
    assertThat(clientContext.getUniverseDomain()).isEqualTo(DEFAULT_UNIVERSE_DOMAIN);
  }

  @Test
  void testCreateClientContext_doNotSetUniverseDomain() throws IOException {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()), null, true, null, null, null, null);
    StubSettings settings =
        new FakeStubSettings.Builder()
            .setEndpoint(null)
            .setUniverseDomain(DEFAULT_UNIVERSE_DOMAIN)
            .build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    clientSettingsBuilder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    ClientSettings clientSettings = clientSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(clientSettings);
    assertThat(clientContext.getUniverseDomain()).isEqualTo(DEFAULT_UNIVERSE_DOMAIN);
  }

  @Test
  void testCreateClientContext_setUniverseDomain() throws IOException {
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()), null, true, null, null, null, null);
    String universeDomain = "testdomain.com";
    StubSettings settings =
        new FakeStubSettings.Builder().setEndpoint(null).setUniverseDomain(universeDomain).build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    clientSettingsBuilder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));
    ClientSettings clientSettings = clientSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(clientSettings);
    assertThat(clientContext.getUniverseDomain()).isEqualTo(universeDomain);
  }

  @Test
  public void testStreamWatchdogInterval_backportMethodsBehaveCorrectly() {
    final ClientContext.Builder builder =
        ClientContext.newBuilder().setDefaultCallContext(FakeCallContext.createDefault());
    testDurationMethod(
        123L,
        jt -> builder.setStreamWatchdogCheckIntervalDuration(jt).build(),
        tt -> builder.setStreamWatchdogCheckInterval(tt).build(),
        ct -> ct.getStreamWatchdogCheckIntervalDuration(),
        ct -> ct.getStreamWatchdogCheckInterval());
  }

  @Test
  void testSetApiKey_createsApiCredentials() throws IOException {
    String apiKey = "key";
    FakeStubSettings.Builder builder = new FakeStubSettings.Builder();
    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel,
            executor,
            true,
            ImmutableMap.of(),
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);
    builder.setTransportChannelProvider(transportProvider);
    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(headerProvider.getHeaders()).thenReturn(ImmutableMap.of());
    builder.setHeaderProvider(headerProvider);
    builder.setApiKey(apiKey);

    ClientContext context = ClientContext.create(builder.build());

    FakeCallContext fakeCallContext = (FakeCallContext) context.getDefaultCallContext();
    assertThat(fakeCallContext.getCredentials()).isInstanceOf(ApiKeyCredentials.class);
  }

  @Test
  void testSetApiKey_withDefaultCredentials_overridesCredentials() throws IOException {
    String apiKey = "key";
    FakeStubSettings.Builder builder = FakeStubSettings.newBuilder();
    InterceptingExecutor executor = new InterceptingExecutor(1);
    FakeTransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FakeTransportProvider transportProvider =
        new FakeTransportProvider(
            transportChannel,
            executor,
            true,
            ImmutableMap.of(),
            null,
            DEFAULT_ENDPOINT,
            DEFAULT_MTLS_ENDPOINT);
    builder.setTransportChannelProvider(transportProvider);
    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    Mockito.when(headerProvider.getHeaders()).thenReturn(ImmutableMap.of());
    builder.setHeaderProvider(headerProvider);
    builder.setApiKey(apiKey);

    ClientContext context = ClientContext.create(builder.build());

    FakeCallContext fakeCallContext = (FakeCallContext) context.getDefaultCallContext();
    assertThat(fakeCallContext.getCredentials()).isInstanceOf(ApiKeyCredentials.class);
  }

  // This test case is added to cover a special case with BigTable. BigTable's EnhancedStubSettings
  // wrappers do not directly inherit from the generated StubSettings. The wrappers must directly
  // set the endpoint values since they are set in the generated StubSettings. This test case mimics
  // the old behavior where BigTable doesn't set an mtlsEndpoint value.
  @Test
  void test_nullMtlsEndpointIsNotPassedToTransportChannel() throws IOException {
    // Set the mtlsEndpoint in the TransportChannelProvider as null. This configures the
    // ClientContext to attempt to pass the mtlsEndpoint over.
    TransportChannelProvider transportChannelProvider =
        new FakeTransportProvider(
            FakeTransportChannel.create(new FakeChannel()), null, true, null, null, null, null);
    // TransportChannelProvider would try to get the resolved mtlsEndpoint
    Truth.assertThat(transportChannelProvider.needsMtlsEndpoint()).isTrue();

    StubSettings settings =
        new FakeStubSettings.Builder()
            .setEndpoint(DEFAULT_ENDPOINT)
            // Set this to be null so that the resolved mtls endpoint is null
            // This resolved value should not be passed to the TransportChannelProvider
            .setMtlsEndpoint(null)
            .build();
    ClientSettings.Builder clientSettingsBuilder = new FakeClientSettings.Builder(settings);
    clientSettingsBuilder.setTransportChannelProvider(transportChannelProvider);
    ClientSettings clientSettings = clientSettingsBuilder.build();

    // This call should not result in an exception being thrown as a null resolved mtlsEndpoint
    // is not passed to the TransportChannelProvider
    ClientContext.create(clientSettings);
  }

  @Test
  void testCreate_withTracerFactoryReturningNullWithContext() throws IOException {
    FakeStubSettings.Builder builder = FakeStubSettings.newBuilder();
    builder.setTransportChannelProvider(getFakeTransportChannelProvider());
    builder.setCredentialsProvider(
        FixedCredentialsProvider.create(Mockito.mock(Credentials.class)));

    ApiTracerFactory apiTracerFactory = Mockito.mock(SpanTracerFactory.class);
    Mockito.doReturn(apiTracerFactory).when(apiTracerFactory).withContext(Mockito.any());

    FakeStubSettings settings = Mockito.spy(builder.build());
    Mockito.doReturn(apiTracerFactory).when(settings).getTracerFactory();

    ClientContext context = ClientContext.create(settings);
    assertThat(context.getTracerFactory()).isSameInstanceAs(apiTracerFactory);
    verify(apiTracerFactory, times(1)).withContext(Mockito.any());
  }
}
