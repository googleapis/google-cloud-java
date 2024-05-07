/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.PredictionServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CountTokensRequest;
import com.google.cloud.aiplatform.v1beta1.CountTokensResponse;
import com.google.cloud.aiplatform.v1beta1.DirectPredictRequest;
import com.google.cloud.aiplatform.v1beta1.DirectPredictResponse;
import com.google.cloud.aiplatform.v1beta1.DirectRawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.DirectRawPredictResponse;
import com.google.cloud.aiplatform.v1beta1.ExplainRequest;
import com.google.cloud.aiplatform.v1beta1.ExplainResponse;
import com.google.cloud.aiplatform.v1beta1.GenerateContentRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateContentResponse;
import com.google.cloud.aiplatform.v1beta1.PredictRequest;
import com.google.cloud.aiplatform.v1beta1.PredictResponse;
import com.google.cloud.aiplatform.v1beta1.RawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamDirectPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamDirectPredictResponse;
import com.google.cloud.aiplatform.v1beta1.StreamDirectRawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamDirectRawPredictResponse;
import com.google.cloud.aiplatform.v1beta1.StreamingPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamingPredictResponse;
import com.google.cloud.aiplatform.v1beta1.StreamingRawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamingRawPredictResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PredictionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of predict to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PredictionServiceStubSettings.Builder predictionServiceSettingsBuilder =
 *     PredictionServiceStubSettings.newBuilder();
 * predictionServiceSettingsBuilder
 *     .predictSettings()
 *     .setRetrySettings(
 *         predictionServiceSettingsBuilder
 *             .predictSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PredictionServiceStubSettings predictionServiceSettings =
 *     predictionServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PredictionServiceStubSettings extends StubSettings<PredictionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<PredictRequest, PredictResponse> predictSettings;
  private final UnaryCallSettings<RawPredictRequest, HttpBody> rawPredictSettings;
  private final UnaryCallSettings<DirectPredictRequest, DirectPredictResponse>
      directPredictSettings;
  private final UnaryCallSettings<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictSettings;
  private final StreamingCallSettings<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictSettings;
  private final StreamingCallSettings<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictSettings;
  private final StreamingCallSettings<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictSettings;
  private final ServerStreamingCallSettings<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictSettings;
  private final StreamingCallSettings<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictSettings;
  private final UnaryCallSettings<ExplainRequest, ExplainResponse> explainSettings;
  private final UnaryCallSettings<CountTokensRequest, CountTokensResponse> countTokensSettings;
  private final UnaryCallSettings<GenerateContentRequest, GenerateContentResponse>
      generateContentSettings;
  private final ServerStreamingCallSettings<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to predict. */
  public UnaryCallSettings<PredictRequest, PredictResponse> predictSettings() {
    return predictSettings;
  }

  /** Returns the object with the settings used for calls to rawPredict. */
  public UnaryCallSettings<RawPredictRequest, HttpBody> rawPredictSettings() {
    return rawPredictSettings;
  }

  /** Returns the object with the settings used for calls to directPredict. */
  public UnaryCallSettings<DirectPredictRequest, DirectPredictResponse> directPredictSettings() {
    return directPredictSettings;
  }

  /** Returns the object with the settings used for calls to directRawPredict. */
  public UnaryCallSettings<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictSettings() {
    return directRawPredictSettings;
  }

  /** Returns the object with the settings used for calls to streamDirectPredict. */
  public StreamingCallSettings<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictSettings() {
    return streamDirectPredictSettings;
  }

  /** Returns the object with the settings used for calls to streamDirectRawPredict. */
  public StreamingCallSettings<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictSettings() {
    return streamDirectRawPredictSettings;
  }

  /** Returns the object with the settings used for calls to streamingPredict. */
  public StreamingCallSettings<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictSettings() {
    return streamingPredictSettings;
  }

  /** Returns the object with the settings used for calls to serverStreamingPredict. */
  public ServerStreamingCallSettings<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictSettings() {
    return serverStreamingPredictSettings;
  }

  /** Returns the object with the settings used for calls to streamingRawPredict. */
  public StreamingCallSettings<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictSettings() {
    return streamingRawPredictSettings;
  }

  /** Returns the object with the settings used for calls to explain. */
  public UnaryCallSettings<ExplainRequest, ExplainResponse> explainSettings() {
    return explainSettings;
  }

  /** Returns the object with the settings used for calls to countTokens. */
  public UnaryCallSettings<CountTokensRequest, CountTokensResponse> countTokensSettings() {
    return countTokensSettings;
  }

  /** Returns the object with the settings used for calls to generateContent. */
  public UnaryCallSettings<GenerateContentRequest, GenerateContentResponse>
      generateContentSettings() {
    return generateContentSettings;
  }

  /** Returns the object with the settings used for calls to streamGenerateContent. */
  public ServerStreamingCallSettings<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentSettings() {
    return streamGenerateContentSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public PredictionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPredictionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PredictionServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected PredictionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    predictSettings = settingsBuilder.predictSettings().build();
    rawPredictSettings = settingsBuilder.rawPredictSettings().build();
    directPredictSettings = settingsBuilder.directPredictSettings().build();
    directRawPredictSettings = settingsBuilder.directRawPredictSettings().build();
    streamDirectPredictSettings = settingsBuilder.streamDirectPredictSettings().build();
    streamDirectRawPredictSettings = settingsBuilder.streamDirectRawPredictSettings().build();
    streamingPredictSettings = settingsBuilder.streamingPredictSettings().build();
    serverStreamingPredictSettings = settingsBuilder.serverStreamingPredictSettings().build();
    streamingRawPredictSettings = settingsBuilder.streamingRawPredictSettings().build();
    explainSettings = settingsBuilder.explainSettings().build();
    countTokensSettings = settingsBuilder.countTokensSettings().build();
    generateContentSettings = settingsBuilder.generateContentSettings().build();
    streamGenerateContentSettings = settingsBuilder.streamGenerateContentSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for PredictionServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<PredictionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<PredictRequest, PredictResponse> predictSettings;
    private final UnaryCallSettings.Builder<RawPredictRequest, HttpBody> rawPredictSettings;
    private final UnaryCallSettings.Builder<DirectPredictRequest, DirectPredictResponse>
        directPredictSettings;
    private final UnaryCallSettings.Builder<DirectRawPredictRequest, DirectRawPredictResponse>
        directRawPredictSettings;
    private final StreamingCallSettings.Builder<
            StreamDirectPredictRequest, StreamDirectPredictResponse>
        streamDirectPredictSettings;
    private final StreamingCallSettings.Builder<
            StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
        streamDirectRawPredictSettings;
    private final StreamingCallSettings.Builder<StreamingPredictRequest, StreamingPredictResponse>
        streamingPredictSettings;
    private final ServerStreamingCallSettings.Builder<
            StreamingPredictRequest, StreamingPredictResponse>
        serverStreamingPredictSettings;
    private final StreamingCallSettings.Builder<
            StreamingRawPredictRequest, StreamingRawPredictResponse>
        streamingRawPredictSettings;
    private final UnaryCallSettings.Builder<ExplainRequest, ExplainResponse> explainSettings;
    private final UnaryCallSettings.Builder<CountTokensRequest, CountTokensResponse>
        countTokensSettings;
    private final UnaryCallSettings.Builder<GenerateContentRequest, GenerateContentResponse>
        generateContentSettings;
    private final ServerStreamingCallSettings.Builder<
            GenerateContentRequest, GenerateContentResponse>
        streamGenerateContentSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_9_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000L))
              .setTotalTimeout(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_9_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      predictSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rawPredictSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      directPredictSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      directRawPredictSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      streamDirectPredictSettings = StreamingCallSettings.newBuilder();
      streamDirectRawPredictSettings = StreamingCallSettings.newBuilder();
      streamingPredictSettings = StreamingCallSettings.newBuilder();
      serverStreamingPredictSettings = ServerStreamingCallSettings.newBuilder();
      streamingRawPredictSettings = StreamingCallSettings.newBuilder();
      explainSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      countTokensSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      streamGenerateContentSettings = ServerStreamingCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              predictSettings,
              rawPredictSettings,
              directPredictSettings,
              directRawPredictSettings,
              explainSettings,
              countTokensSettings,
              generateContentSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(PredictionServiceStubSettings settings) {
      super(settings);

      predictSettings = settings.predictSettings.toBuilder();
      rawPredictSettings = settings.rawPredictSettings.toBuilder();
      directPredictSettings = settings.directPredictSettings.toBuilder();
      directRawPredictSettings = settings.directRawPredictSettings.toBuilder();
      streamDirectPredictSettings = settings.streamDirectPredictSettings.toBuilder();
      streamDirectRawPredictSettings = settings.streamDirectRawPredictSettings.toBuilder();
      streamingPredictSettings = settings.streamingPredictSettings.toBuilder();
      serverStreamingPredictSettings = settings.serverStreamingPredictSettings.toBuilder();
      streamingRawPredictSettings = settings.streamingRawPredictSettings.toBuilder();
      explainSettings = settings.explainSettings.toBuilder();
      countTokensSettings = settings.countTokensSettings.toBuilder();
      generateContentSettings = settings.generateContentSettings.toBuilder();
      streamGenerateContentSettings = settings.streamGenerateContentSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              predictSettings,
              rawPredictSettings,
              directPredictSettings,
              directRawPredictSettings,
              explainSettings,
              countTokensSettings,
              generateContentSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .predictSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_9_params"));

      builder
          .rawPredictSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .directPredictSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .directRawPredictSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .serverStreamingPredictSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .explainSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_9_params"));

      builder
          .countTokensSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .streamGenerateContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to predict. */
    public UnaryCallSettings.Builder<PredictRequest, PredictResponse> predictSettings() {
      return predictSettings;
    }

    /** Returns the builder for the settings used for calls to rawPredict. */
    public UnaryCallSettings.Builder<RawPredictRequest, HttpBody> rawPredictSettings() {
      return rawPredictSettings;
    }

    /** Returns the builder for the settings used for calls to directPredict. */
    public UnaryCallSettings.Builder<DirectPredictRequest, DirectPredictResponse>
        directPredictSettings() {
      return directPredictSettings;
    }

    /** Returns the builder for the settings used for calls to directRawPredict. */
    public UnaryCallSettings.Builder<DirectRawPredictRequest, DirectRawPredictResponse>
        directRawPredictSettings() {
      return directRawPredictSettings;
    }

    /** Returns the builder for the settings used for calls to streamDirectPredict. */
    public StreamingCallSettings.Builder<StreamDirectPredictRequest, StreamDirectPredictResponse>
        streamDirectPredictSettings() {
      return streamDirectPredictSettings;
    }

    /** Returns the builder for the settings used for calls to streamDirectRawPredict. */
    public StreamingCallSettings.Builder<
            StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
        streamDirectRawPredictSettings() {
      return streamDirectRawPredictSettings;
    }

    /** Returns the builder for the settings used for calls to streamingPredict. */
    public StreamingCallSettings.Builder<StreamingPredictRequest, StreamingPredictResponse>
        streamingPredictSettings() {
      return streamingPredictSettings;
    }

    /** Returns the builder for the settings used for calls to serverStreamingPredict. */
    public ServerStreamingCallSettings.Builder<StreamingPredictRequest, StreamingPredictResponse>
        serverStreamingPredictSettings() {
      return serverStreamingPredictSettings;
    }

    /** Returns the builder for the settings used for calls to streamingRawPredict. */
    public StreamingCallSettings.Builder<StreamingRawPredictRequest, StreamingRawPredictResponse>
        streamingRawPredictSettings() {
      return streamingRawPredictSettings;
    }

    /** Returns the builder for the settings used for calls to explain. */
    public UnaryCallSettings.Builder<ExplainRequest, ExplainResponse> explainSettings() {
      return explainSettings;
    }

    /** Returns the builder for the settings used for calls to countTokens. */
    public UnaryCallSettings.Builder<CountTokensRequest, CountTokensResponse>
        countTokensSettings() {
      return countTokensSettings;
    }

    /** Returns the builder for the settings used for calls to generateContent. */
    public UnaryCallSettings.Builder<GenerateContentRequest, GenerateContentResponse>
        generateContentSettings() {
      return generateContentSettings;
    }

    /** Returns the builder for the settings used for calls to streamGenerateContent. */
    public ServerStreamingCallSettings.Builder<GenerateContentRequest, GenerateContentResponse>
        streamGenerateContentSettings() {
      return streamGenerateContentSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public PredictionServiceStubSettings build() throws IOException {
      return new PredictionServiceStubSettings(this);
    }
  }
}
