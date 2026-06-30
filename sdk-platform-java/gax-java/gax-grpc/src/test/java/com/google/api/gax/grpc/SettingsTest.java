/*
 * Copyright 2016 Google LLC
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
package com.google.api.gax.grpc;

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.paging.PagedListResponse;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.FixedWatchdogProvider;
import com.google.api.gax.rpc.NoHeaderProvider;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.auth.Credentials;
import com.google.auth.mtls.MtlsProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SettingsTest {

  interface FakePagedListResponse extends PagedListResponse<Integer> {}

  private static class FakeStubSettings extends StubSettings<FakeStubSettings> {

    @SuppressWarnings("unchecked")
    private static final PagedListResponseFactory<Integer, Integer, FakePagedListResponse>
        fakePagedListResponseFactory = Mockito.mock(PagedListResponseFactory.class);

    @SuppressWarnings("unchecked")
    private static final BatchingDescriptor<Integer, Integer> FAKE_BATCHING_DESCRIPTOR =
        Mockito.mock(BatchingDescriptor.class);

    private static final String DEFAULT_GAPIC_NAME = "gapic";
    public static final String DEFAULT_SERVICE_ADDRESS = "pubsub-experimental.googleapis.com";
    public static final int DEFAULT_SERVICE_PORT = 443;
    public static final String DEFAULT_SERVICE_ENDPOINT =
        DEFAULT_SERVICE_ADDRESS + ':' + DEFAULT_SERVICE_PORT;
    public static final MtlsProvider DEFAULT_MTLS_PROVIDER = null;
    public static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
        ImmutableList.<String>builder()
            .add("https://www.googleapis.com/auth/pubsub")
            .add("https://www.googleapis.com/auth/cloud-platform")
            .build();

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.newArrayList(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(java.time.Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1000L))
              .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(2000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(java.time.Duration.ofMillis(45000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private final UnaryCallSettings<Integer, Integer> fakeMethodSimple;
    private final PagedCallSettings<Integer, Integer, FakePagedListResponse> fakePagedMethod;
    private final BatchingCallSettings<Integer, Integer> fakeMethodBatching;

    public UnaryCallSettings<Integer, Integer> fakeMethodSimple() {
      return fakeMethodSimple;
    }

    public PagedCallSettings<Integer, Integer, FakePagedListResponse> fakePagedMethod() {
      return fakePagedMethod;
    }

    public BatchingCallSettings<Integer, Integer> fakeMethodBatching() {
      return fakeMethodBatching;
    }

    public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
      return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
    }

    public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
      return InstantiatingExecutorProvider.newBuilder();
    }

    /** Returns a builder for the default TransportChannelProvider for this service. */
    public static InstantiatingGrpcChannelProvider.Builder defaultGrpcChannelProviderBuilder() {
      return InstantiatingGrpcChannelProvider.newBuilder()
          .setEndpoint(DEFAULT_SERVICE_ENDPOINT)
          .setMtlsProvider(DEFAULT_MTLS_PROVIDER);
    }

    public static ApiClientHeaderProvider.Builder defaultGoogleServiceHeaderProviderBuilder() {
      return ApiClientHeaderProvider.newBuilder()
          .setGeneratedLibToken(DEFAULT_GAPIC_NAME, "0.10.0")
          .setTransportToken(
              GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
    }

    public static TransportChannelProvider defaultTransportChannelProvider() {
      return defaultGrpcChannelProviderBuilder().build();
    }

    public static Builder newBuilder() {
      return Builder.createDefault();
    }

    @Override
    public Builder toBuilder() {
      return new Builder(this);
    }

    private FakeStubSettings(Builder settingsBuilder) {
      super(settingsBuilder);

      fakeMethodSimple = settingsBuilder.fakeMethodSimple().build();
      fakePagedMethod = settingsBuilder.fakePagedMethod().build();
      fakeMethodBatching = settingsBuilder.fakeMethodBatching().build();
    }

    private static class Builder extends StubSettings.Builder<FakeStubSettings, Builder> {

      private UnaryCallSettings.Builder<Integer, Integer> fakeMethodSimple;
      private PagedCallSettings.Builder<Integer, Integer, FakePagedListResponse> fakePagedMethod;
      private BatchingCallSettings.Builder<Integer, Integer> fakeMethodBatching;

      private Builder() {
        super((ClientContext) null);

        fakeMethodSimple = UnaryCallSettings.newUnaryCallSettingsBuilder();
        fakePagedMethod = PagedCallSettings.newBuilder(fakePagedListResponseFactory);
        fakeMethodBatching =
            BatchingCallSettings.newBuilder(FAKE_BATCHING_DESCRIPTOR)
                .setBatchingSettings(BatchingSettings.newBuilder().build());
      }

      private static Builder createDefault() {
        Builder builder = new Builder();
        builder.setTransportChannelProvider(defaultTransportChannelProvider());
        builder.setExecutorProvider(defaultExecutorProviderBuilder().build());
        builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
        builder.setHeaderProvider(new NoHeaderProvider());
        builder.setInternalHeaderProvider(defaultGoogleServiceHeaderProviderBuilder().build());
        builder.setStreamWatchdogProvider(FixedWatchdogProvider.create(null));

        builder
            .fakeMethodSimple()
            .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
            .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

        builder
            .fakePagedMethod()
            .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
            .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

        builder
            .fakeMethodBatching()
            .setBatchingSettings(
                BatchingSettings.newBuilder()
                    .setElementCountThreshold(800L)
                    .setRequestByteThreshold(8388608L)
                    .setDelayThresholdDuration(java.time.Duration.ofMillis(100))
                    .build());
        builder
            .fakeMethodBatching()
            .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
            .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

        return builder;
      }

      private Builder(FakeStubSettings settings) {
        super(settings);

        fakeMethodSimple = settings.fakeMethodSimple().toBuilder();
        fakePagedMethod = settings.fakePagedMethod().toBuilder();
        fakeMethodBatching = settings.fakeMethodBatching().toBuilder();
      }

      @Override
      public FakeStubSettings build() throws IOException {
        return new FakeStubSettings(this);
      }

      public UnaryCallSettings.Builder<Integer, Integer> fakeMethodSimple() {
        return fakeMethodSimple;
      }

      public PagedCallSettings.Builder<Integer, Integer, FakePagedListResponse> fakePagedMethod() {
        return fakePagedMethod;
      }

      public BatchingCallSettings.Builder<Integer, Integer> fakeMethodBatching() {
        return fakeMethodBatching;
      }
    }
  }

  // GrpcTransportProvider
  // ====

  @Test
  void customCredentials() throws IOException {
    Credentials credentials = Mockito.mock(Credentials.class);

    FakeStubSettings settings =
        FakeStubSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .build();

    TransportChannelProvider actualChannelProvider = settings.getTransportChannelProvider();
    Truth.assertThat(actualChannelProvider).isInstanceOf(InstantiatingGrpcChannelProvider.class);
    InstantiatingGrpcChannelProvider actualInstChPr =
        (InstantiatingGrpcChannelProvider) actualChannelProvider;

    Truth.assertThat(actualInstChPr.getEndpoint())
        .isEqualTo(FakeStubSettings.DEFAULT_SERVICE_ENDPOINT);
    // TODO(michaelbausor): create JSON with credentials and define GOOGLE_APPLICATION_CREDENTIALS
    // environment variable to allow travis build to access application default credentials
    Truth.assertThat(settings.getCredentialsProvider().getCredentials())
        .isSameInstanceAs(credentials);
  }

  @Test
  void channelCustomCredentialScopes() throws IOException {
    ImmutableList<String> inputScopes =
        ImmutableList.<String>builder().add("https://www.googleapis.com/auth/fakeservice").build();

    CredentialsProvider credentialsProvider =
        FakeStubSettings.defaultCredentialsProviderBuilder().setScopesToApply(inputScopes).build();
    FakeStubSettings settings =
        FakeStubSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();

    TransportChannelProvider actualChannelProvider = settings.getTransportChannelProvider();
    Truth.assertThat(actualChannelProvider).isInstanceOf(InstantiatingGrpcChannelProvider.class);
    InstantiatingGrpcChannelProvider actualInstChPr =
        (InstantiatingGrpcChannelProvider) actualChannelProvider;

    Truth.assertThat(actualInstChPr.getEndpoint())
        .isEqualTo(FakeStubSettings.DEFAULT_SERVICE_ENDPOINT);

    CredentialsProvider actualCredentialsProvider = settings.getCredentialsProvider();
    Truth.assertThat(actualCredentialsProvider).isInstanceOf(GoogleCredentialsProvider.class);
    GoogleCredentialsProvider googCredProv = (GoogleCredentialsProvider) actualCredentialsProvider;

    Truth.assertThat(googCredProv.getScopesToApply()).isEqualTo(inputScopes);

    // TODO(michaelbausor): create JSON with credentials and define GOOGLE_APPLICATION_CREDENTIALS
    // environment variable to allow travis build to access application default credentials
    // Truth.assertThat(connSettings.getCredentials()).isNotNull();
  }

  // CallSettings
  // ====

  @Test
  void callSettingsToBuilder() {
    UnaryCallSettings.Builder<?, ?> builderA = UnaryCallSettings.newUnaryCallSettingsBuilder();
    UnaryCallSettings<?, ?> settingsA = builderA.build();
    UnaryCallSettings.Builder<?, ?> builderB = settingsA.toBuilder();
    UnaryCallSettings<?, ?> settingsB = builderB.build();

    assertEquals(settingsA, settingsB);
  }

  @Test
  void unaryCallSettingsBuilderBuildDoesNotFailUnsetProperties() {
    UnaryCallSettings.Builder<Integer, Integer> builder =
        UnaryCallSettings.newUnaryCallSettingsBuilder();
    builder.build();
  }

  @Test
  void callSettingsBuildFromTimeoutNoRetries() {
    java.time.Duration timeout = java.time.Duration.ofMillis(60000);

    UnaryCallSettings.Builder<Integer, Integer> builderA =
        UnaryCallSettings.newUnaryCallSettingsBuilder();
    builderA.setSimpleTimeoutNoRetriesDuration(timeout);
    UnaryCallSettings<Integer, Integer> settingsA = builderA.build();

    UnaryCallSettings.Builder<Integer, Integer> builderB =
        UnaryCallSettings.newUnaryCallSettingsBuilder();
    builderB
        .setRetryableCodes()
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setTotalTimeoutDuration(timeout)
                .setInitialRetryDelayDuration(java.time.Duration.ZERO)
                .setRetryDelayMultiplier(1)
                .setMaxRetryDelayDuration(java.time.Duration.ZERO)
                .setInitialRpcTimeoutDuration(timeout)
                .setRpcTimeoutMultiplier(1)
                .setMaxRpcTimeoutDuration(timeout)
                .setMaxAttempts(1)
                .build());
    UnaryCallSettings<Integer, Integer> settingsB = builderB.build();

    assertEquals(settingsA, settingsB, "UnaryCallSettings");
  }

  @Test
  public void testWatchDogCheckInterval_backportMethodsBehaveCorrectly() {
    final Function<Supplier<StubSettings.Builder>, StubSettings> build =
        createBuilder -> {
          try {
            return createBuilder.get().build();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        };
    testDurationMethod(
        123l,
        jt ->
            build.apply(
                () -> FakeStubSettings.newBuilder().setStreamWatchdogCheckIntervalDuration(jt)),
        tt -> build.apply(() -> FakeStubSettings.newBuilder().setStreamWatchdogCheckInterval(tt)),
        ss -> ss.getStreamWatchdogCheckIntervalDuration(),
        ss -> ss.getStreamWatchdogCheckInterval());
  }
}
