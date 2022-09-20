/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.IntentsClient.ListIntentsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.IntentsClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsResponse;
import com.google.cloud.dialogflow.v2beta1.CreateIntentRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest;
import com.google.cloud.dialogflow.v2beta1.GetIntentRequest;
import com.google.cloud.dialogflow.v2beta1.Intent;
import com.google.cloud.dialogflow.v2beta1.ListIntentsRequest;
import com.google.cloud.dialogflow.v2beta1.ListIntentsResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IntentsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getIntent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IntentsStubSettings.Builder intentsSettingsBuilder = IntentsStubSettings.newBuilder();
 * intentsSettingsBuilder
 *     .getIntentSettings()
 *     .setRetrySettings(
 *         intentsSettingsBuilder.getIntentSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IntentsStubSettings intentsSettings = intentsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IntentsStubSettings extends StubSettings<IntentsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>
      listIntentsSettings;
  private final UnaryCallSettings<GetIntentRequest, Intent> getIntentSettings;
  private final UnaryCallSettings<CreateIntentRequest, Intent> createIntentSettings;
  private final UnaryCallSettings<UpdateIntentRequest, Intent> updateIntentSettings;
  private final UnaryCallSettings<DeleteIntentRequest, Empty> deleteIntentSettings;
  private final UnaryCallSettings<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsSettings;
  private final OperationCallSettings<BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
      batchUpdateIntentsOperationSettings;
  private final UnaryCallSettings<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsSettings;
  private final OperationCallSettings<BatchDeleteIntentsRequest, Empty, Struct>
      batchDeleteIntentsOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListIntentsRequest, ListIntentsResponse, Intent>
      LIST_INTENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListIntentsRequest, ListIntentsResponse, Intent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIntentsRequest injectToken(ListIntentsRequest payload, String token) {
              return ListIntentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIntentsRequest injectPageSize(ListIntentsRequest payload, int pageSize) {
              return ListIntentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIntentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIntentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Intent> extractResources(ListIntentsResponse payload) {
              return payload.getIntentsList() == null
                  ? ImmutableList.<Intent>of()
                  : payload.getIntentsList();
            }
          };

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
          ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>
      LIST_INTENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>() {
            @Override
            public ApiFuture<ListIntentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIntentsRequest, ListIntentsResponse> callable,
                ListIntentsRequest request,
                ApiCallContext context,
                ApiFuture<ListIntentsResponse> futureResponse) {
              PageContext<ListIntentsRequest, ListIntentsResponse, Intent> pageContext =
                  PageContext.create(callable, LIST_INTENTS_PAGE_STR_DESC, request, context);
              return ListIntentsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listIntents. */
  public PagedCallSettings<ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>
      listIntentsSettings() {
    return listIntentsSettings;
  }

  /** Returns the object with the settings used for calls to getIntent. */
  public UnaryCallSettings<GetIntentRequest, Intent> getIntentSettings() {
    return getIntentSettings;
  }

  /** Returns the object with the settings used for calls to createIntent. */
  public UnaryCallSettings<CreateIntentRequest, Intent> createIntentSettings() {
    return createIntentSettings;
  }

  /** Returns the object with the settings used for calls to updateIntent. */
  public UnaryCallSettings<UpdateIntentRequest, Intent> updateIntentSettings() {
    return updateIntentSettings;
  }

  /** Returns the object with the settings used for calls to deleteIntent. */
  public UnaryCallSettings<DeleteIntentRequest, Empty> deleteIntentSettings() {
    return deleteIntentSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateIntents. */
  public UnaryCallSettings<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsSettings() {
    return batchUpdateIntentsSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateIntents. */
  public OperationCallSettings<BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
      batchUpdateIntentsOperationSettings() {
    return batchUpdateIntentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteIntents. */
  public UnaryCallSettings<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsSettings() {
    return batchDeleteIntentsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteIntents. */
  public OperationCallSettings<BatchDeleteIntentsRequest, Empty, Struct>
      batchDeleteIntentsOperationSettings() {
    return batchDeleteIntentsOperationSettings;
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

  public IntentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIntentsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonIntentsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dialogflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dialogflow.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(IntentsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(IntentsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IntentsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected IntentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listIntentsSettings = settingsBuilder.listIntentsSettings().build();
    getIntentSettings = settingsBuilder.getIntentSettings().build();
    createIntentSettings = settingsBuilder.createIntentSettings().build();
    updateIntentSettings = settingsBuilder.updateIntentSettings().build();
    deleteIntentSettings = settingsBuilder.deleteIntentSettings().build();
    batchUpdateIntentsSettings = settingsBuilder.batchUpdateIntentsSettings().build();
    batchUpdateIntentsOperationSettings =
        settingsBuilder.batchUpdateIntentsOperationSettings().build();
    batchDeleteIntentsSettings = settingsBuilder.batchDeleteIntentsSettings().build();
    batchDeleteIntentsOperationSettings =
        settingsBuilder.batchDeleteIntentsOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for IntentsStubSettings. */
  public static class Builder extends StubSettings.Builder<IntentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>
        listIntentsSettings;
    private final UnaryCallSettings.Builder<GetIntentRequest, Intent> getIntentSettings;
    private final UnaryCallSettings.Builder<CreateIntentRequest, Intent> createIntentSettings;
    private final UnaryCallSettings.Builder<UpdateIntentRequest, Intent> updateIntentSettings;
    private final UnaryCallSettings.Builder<DeleteIntentRequest, Empty> deleteIntentSettings;
    private final UnaryCallSettings.Builder<BatchUpdateIntentsRequest, Operation>
        batchUpdateIntentsSettings;
    private final OperationCallSettings.Builder<
            BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
        batchUpdateIntentsOperationSettings;
    private final UnaryCallSettings.Builder<BatchDeleteIntentsRequest, Operation>
        batchDeleteIntentsSettings;
    private final OperationCallSettings.Builder<BatchDeleteIntentsRequest, Empty, Struct>
        batchDeleteIntentsOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listIntentsSettings = PagedCallSettings.newBuilder(LIST_INTENTS_PAGE_STR_FACT);
      getIntentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIntentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIntentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIntentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateIntentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateIntentsOperationSettings = OperationCallSettings.newBuilder();
      batchDeleteIntentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteIntentsOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listIntentsSettings,
              getIntentSettings,
              createIntentSettings,
              updateIntentSettings,
              deleteIntentSettings,
              batchUpdateIntentsSettings,
              batchDeleteIntentsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(IntentsStubSettings settings) {
      super(settings);

      listIntentsSettings = settings.listIntentsSettings.toBuilder();
      getIntentSettings = settings.getIntentSettings.toBuilder();
      createIntentSettings = settings.createIntentSettings.toBuilder();
      updateIntentSettings = settings.updateIntentSettings.toBuilder();
      deleteIntentSettings = settings.deleteIntentSettings.toBuilder();
      batchUpdateIntentsSettings = settings.batchUpdateIntentsSettings.toBuilder();
      batchUpdateIntentsOperationSettings =
          settings.batchUpdateIntentsOperationSettings.toBuilder();
      batchDeleteIntentsSettings = settings.batchDeleteIntentsSettings.toBuilder();
      batchDeleteIntentsOperationSettings =
          settings.batchDeleteIntentsOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listIntentsSettings,
              getIntentSettings,
              createIntentSettings,
              updateIntentSettings,
              deleteIntentSettings,
              batchUpdateIntentsSettings,
              batchDeleteIntentsSettings,
              listLocationsSettings,
              getLocationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listIntentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIntentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createIntentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateIntentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteIntentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdateIntentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeleteIntentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdateIntentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchUpdateIntentsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchUpdateIntentsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .batchDeleteIntentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchDeleteIntentsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to listIntents. */
    public PagedCallSettings.Builder<
            ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>
        listIntentsSettings() {
      return listIntentsSettings;
    }

    /** Returns the builder for the settings used for calls to getIntent. */
    public UnaryCallSettings.Builder<GetIntentRequest, Intent> getIntentSettings() {
      return getIntentSettings;
    }

    /** Returns the builder for the settings used for calls to createIntent. */
    public UnaryCallSettings.Builder<CreateIntentRequest, Intent> createIntentSettings() {
      return createIntentSettings;
    }

    /** Returns the builder for the settings used for calls to updateIntent. */
    public UnaryCallSettings.Builder<UpdateIntentRequest, Intent> updateIntentSettings() {
      return updateIntentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIntent. */
    public UnaryCallSettings.Builder<DeleteIntentRequest, Empty> deleteIntentSettings() {
      return deleteIntentSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateIntents. */
    public UnaryCallSettings.Builder<BatchUpdateIntentsRequest, Operation>
        batchUpdateIntentsSettings() {
      return batchUpdateIntentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateIntents. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
        batchUpdateIntentsOperationSettings() {
      return batchUpdateIntentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteIntents. */
    public UnaryCallSettings.Builder<BatchDeleteIntentsRequest, Operation>
        batchDeleteIntentsSettings() {
      return batchDeleteIntentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteIntents. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<BatchDeleteIntentsRequest, Empty, Struct>
        batchDeleteIntentsOperationSettings() {
      return batchDeleteIntentsOperationSettings;
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

    @Override
    public IntentsStubSettings build() throws IOException {
      return new IntentsStubSettings(this);
    }
  }
}
