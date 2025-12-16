/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.gkerecommender.v1.stub;

import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServerVersionsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServersPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchProfilesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServersRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServersResponse;
import com.google.cloud.gkerecommender.v1.FetchModelsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelsResponse;
import com.google.cloud.gkerecommender.v1.FetchProfilesRequest;
import com.google.cloud.gkerecommender.v1.FetchProfilesResponse;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse;
import com.google.cloud.gkerecommender.v1.Profile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GkeInferenceQuickstartStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkerecommender.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of generateOptimizedManifest:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeInferenceQuickstartStubSettings.Builder gkeInferenceQuickstartSettingsBuilder =
 *     GkeInferenceQuickstartStubSettings.newBuilder();
 * gkeInferenceQuickstartSettingsBuilder
 *     .generateOptimizedManifestSettings()
 *     .setRetrySettings(
 *         gkeInferenceQuickstartSettingsBuilder
 *             .generateOptimizedManifestSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * GkeInferenceQuickstartStubSettings gkeInferenceQuickstartSettings =
 *     gkeInferenceQuickstartSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class GkeInferenceQuickstartStubSettings
    extends StubSettings<GkeInferenceQuickstartStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>
      fetchModelsSettings;
  private final PagedCallSettings<
          FetchModelServersRequest, FetchModelServersResponse, FetchModelServersPagedResponse>
      fetchModelServersSettings;
  private final PagedCallSettings<
          FetchModelServerVersionsRequest,
          FetchModelServerVersionsResponse,
          FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsSettings;
  private final PagedCallSettings<
          FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>
      fetchProfilesSettings;
  private final UnaryCallSettings<
          GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestSettings;
  private final UnaryCallSettings<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataSettings;

  private static final PagedListDescriptor<FetchModelsRequest, FetchModelsResponse, String>
      FETCH_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<FetchModelsRequest, FetchModelsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchModelsRequest injectToken(FetchModelsRequest payload, String token) {
              return FetchModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchModelsRequest injectPageSize(FetchModelsRequest payload, int pageSize) {
              return FetchModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(FetchModelsResponse payload) {
              return payload.getModelsList();
            }
          };

  private static final PagedListDescriptor<
          FetchModelServersRequest, FetchModelServersResponse, String>
      FETCH_MODEL_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<FetchModelServersRequest, FetchModelServersResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchModelServersRequest injectToken(
                FetchModelServersRequest payload, String token) {
              return FetchModelServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchModelServersRequest injectPageSize(
                FetchModelServersRequest payload, int pageSize) {
              return FetchModelServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchModelServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchModelServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(FetchModelServersResponse payload) {
              return payload.getModelServersList();
            }
          };

  private static final PagedListDescriptor<
          FetchModelServerVersionsRequest, FetchModelServerVersionsResponse, String>
      FETCH_MODEL_SERVER_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchModelServerVersionsRequest, FetchModelServerVersionsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchModelServerVersionsRequest injectToken(
                FetchModelServerVersionsRequest payload, String token) {
              return FetchModelServerVersionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public FetchModelServerVersionsRequest injectPageSize(
                FetchModelServerVersionsRequest payload, int pageSize) {
              return FetchModelServerVersionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchModelServerVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchModelServerVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(FetchModelServerVersionsResponse payload) {
              return payload.getModelServerVersionsList();
            }
          };

  private static final PagedListDescriptor<FetchProfilesRequest, FetchProfilesResponse, Profile>
      FETCH_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<FetchProfilesRequest, FetchProfilesResponse, Profile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchProfilesRequest injectToken(FetchProfilesRequest payload, String token) {
              return FetchProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchProfilesRequest injectPageSize(FetchProfilesRequest payload, int pageSize) {
              return FetchProfilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Profile> extractResources(FetchProfilesResponse payload) {
              return payload.getProfileList();
            }
          };

  private static final PagedListResponseFactory<
          FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>
      FETCH_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>() {
            @Override
            public ApiFuture<FetchModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchModelsRequest, FetchModelsResponse> callable,
                FetchModelsRequest request,
                ApiCallContext context,
                ApiFuture<FetchModelsResponse> futureResponse) {
              PageContext<FetchModelsRequest, FetchModelsResponse, String> pageContext =
                  PageContext.create(callable, FETCH_MODELS_PAGE_STR_DESC, request, context);
              return FetchModelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchModelServersRequest, FetchModelServersResponse, FetchModelServersPagedResponse>
      FETCH_MODEL_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchModelServersRequest,
              FetchModelServersResponse,
              FetchModelServersPagedResponse>() {
            @Override
            public ApiFuture<FetchModelServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchModelServersRequest, FetchModelServersResponse> callable,
                FetchModelServersRequest request,
                ApiCallContext context,
                ApiFuture<FetchModelServersResponse> futureResponse) {
              PageContext<FetchModelServersRequest, FetchModelServersResponse, String> pageContext =
                  PageContext.create(callable, FETCH_MODEL_SERVERS_PAGE_STR_DESC, request, context);
              return FetchModelServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchModelServerVersionsRequest,
          FetchModelServerVersionsResponse,
          FetchModelServerVersionsPagedResponse>
      FETCH_MODEL_SERVER_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchModelServerVersionsRequest,
              FetchModelServerVersionsResponse,
              FetchModelServerVersionsPagedResponse>() {
            @Override
            public ApiFuture<FetchModelServerVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
                    callable,
                FetchModelServerVersionsRequest request,
                ApiCallContext context,
                ApiFuture<FetchModelServerVersionsResponse> futureResponse) {
              PageContext<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse, String>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_MODEL_SERVER_VERSIONS_PAGE_STR_DESC, request, context);
              return FetchModelServerVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>
      FETCH_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>() {
            @Override
            public ApiFuture<FetchProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchProfilesRequest, FetchProfilesResponse> callable,
                FetchProfilesRequest request,
                ApiCallContext context,
                ApiFuture<FetchProfilesResponse> futureResponse) {
              PageContext<FetchProfilesRequest, FetchProfilesResponse, Profile> pageContext =
                  PageContext.create(callable, FETCH_PROFILES_PAGE_STR_DESC, request, context);
              return FetchProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to fetchModels. */
  public PagedCallSettings<FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>
      fetchModelsSettings() {
    return fetchModelsSettings;
  }

  /** Returns the object with the settings used for calls to fetchModelServers. */
  public PagedCallSettings<
          FetchModelServersRequest, FetchModelServersResponse, FetchModelServersPagedResponse>
      fetchModelServersSettings() {
    return fetchModelServersSettings;
  }

  /** Returns the object with the settings used for calls to fetchModelServerVersions. */
  public PagedCallSettings<
          FetchModelServerVersionsRequest,
          FetchModelServerVersionsResponse,
          FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsSettings() {
    return fetchModelServerVersionsSettings;
  }

  /** Returns the object with the settings used for calls to fetchProfiles. */
  public PagedCallSettings<FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>
      fetchProfilesSettings() {
    return fetchProfilesSettings;
  }

  /** Returns the object with the settings used for calls to generateOptimizedManifest. */
  public UnaryCallSettings<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestSettings() {
    return generateOptimizedManifestSettings;
  }

  /** Returns the object with the settings used for calls to fetchBenchmarkingData. */
  public UnaryCallSettings<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataSettings() {
    return fetchBenchmarkingDataSettings;
  }

  public GkeInferenceQuickstartStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGkeInferenceQuickstartStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGkeInferenceQuickstartStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "gkerecommender";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "gkerecommender.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkerecommender.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GkeInferenceQuickstartStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GkeInferenceQuickstartStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeInferenceQuickstartStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected GkeInferenceQuickstartStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    fetchModelsSettings = settingsBuilder.fetchModelsSettings().build();
    fetchModelServersSettings = settingsBuilder.fetchModelServersSettings().build();
    fetchModelServerVersionsSettings = settingsBuilder.fetchModelServerVersionsSettings().build();
    fetchProfilesSettings = settingsBuilder.fetchProfilesSettings().build();
    generateOptimizedManifestSettings = settingsBuilder.generateOptimizedManifestSettings().build();
    fetchBenchmarkingDataSettings = settingsBuilder.fetchBenchmarkingDataSettings().build();
  }

  /** Builder for GkeInferenceQuickstartStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GkeInferenceQuickstartStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>
        fetchModelsSettings;
    private final PagedCallSettings.Builder<
            FetchModelServersRequest, FetchModelServersResponse, FetchModelServersPagedResponse>
        fetchModelServersSettings;
    private final PagedCallSettings.Builder<
            FetchModelServerVersionsRequest,
            FetchModelServerVersionsResponse,
            FetchModelServerVersionsPagedResponse>
        fetchModelServerVersionsSettings;
    private final PagedCallSettings.Builder<
            FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>
        fetchProfilesSettings;
    private final UnaryCallSettings.Builder<
            GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
        generateOptimizedManifestSettings;
    private final UnaryCallSettings.Builder<
            FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
        fetchBenchmarkingDataSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      fetchModelsSettings = PagedCallSettings.newBuilder(FETCH_MODELS_PAGE_STR_FACT);
      fetchModelServersSettings = PagedCallSettings.newBuilder(FETCH_MODEL_SERVERS_PAGE_STR_FACT);
      fetchModelServerVersionsSettings =
          PagedCallSettings.newBuilder(FETCH_MODEL_SERVER_VERSIONS_PAGE_STR_FACT);
      fetchProfilesSettings = PagedCallSettings.newBuilder(FETCH_PROFILES_PAGE_STR_FACT);
      generateOptimizedManifestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchBenchmarkingDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              fetchModelsSettings,
              fetchModelServersSettings,
              fetchModelServerVersionsSettings,
              fetchProfilesSettings,
              generateOptimizedManifestSettings,
              fetchBenchmarkingDataSettings);
      initDefaults(this);
    }

    protected Builder(GkeInferenceQuickstartStubSettings settings) {
      super(settings);

      fetchModelsSettings = settings.fetchModelsSettings.toBuilder();
      fetchModelServersSettings = settings.fetchModelServersSettings.toBuilder();
      fetchModelServerVersionsSettings = settings.fetchModelServerVersionsSettings.toBuilder();
      fetchProfilesSettings = settings.fetchProfilesSettings.toBuilder();
      generateOptimizedManifestSettings = settings.generateOptimizedManifestSettings.toBuilder();
      fetchBenchmarkingDataSettings = settings.fetchBenchmarkingDataSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              fetchModelsSettings,
              fetchModelServersSettings,
              fetchModelServerVersionsSettings,
              fetchProfilesSettings,
              generateOptimizedManifestSettings,
              fetchBenchmarkingDataSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .fetchModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .fetchModelServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .fetchModelServerVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .fetchProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .generateOptimizedManifestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .fetchBenchmarkingDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to fetchModels. */
    public PagedCallSettings.Builder<
            FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>
        fetchModelsSettings() {
      return fetchModelsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchModelServers. */
    public PagedCallSettings.Builder<
            FetchModelServersRequest, FetchModelServersResponse, FetchModelServersPagedResponse>
        fetchModelServersSettings() {
      return fetchModelServersSettings;
    }

    /** Returns the builder for the settings used for calls to fetchModelServerVersions. */
    public PagedCallSettings.Builder<
            FetchModelServerVersionsRequest,
            FetchModelServerVersionsResponse,
            FetchModelServerVersionsPagedResponse>
        fetchModelServerVersionsSettings() {
      return fetchModelServerVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchProfiles. */
    public PagedCallSettings.Builder<
            FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>
        fetchProfilesSettings() {
      return fetchProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to generateOptimizedManifest. */
    public UnaryCallSettings.Builder<
            GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
        generateOptimizedManifestSettings() {
      return generateOptimizedManifestSettings;
    }

    /** Returns the builder for the settings used for calls to fetchBenchmarkingData. */
    public UnaryCallSettings.Builder<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
        fetchBenchmarkingDataSettings() {
      return fetchBenchmarkingDataSettings;
    }

    @Override
    public GkeInferenceQuickstartStubSettings build() throws IOException {
      return new GkeInferenceQuickstartStubSettings(this);
    }
  }
}
