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

package com.google.api.apikeys.v2.stub;

import static com.google.api.apikeys.v2.ApiKeysClient.ListKeysPagedResponse;

import com.google.api.apikeys.v2.CreateKeyRequest;
import com.google.api.apikeys.v2.DeleteKeyRequest;
import com.google.api.apikeys.v2.GetKeyRequest;
import com.google.api.apikeys.v2.GetKeyStringRequest;
import com.google.api.apikeys.v2.GetKeyStringResponse;
import com.google.api.apikeys.v2.Key;
import com.google.api.apikeys.v2.ListKeysRequest;
import com.google.api.apikeys.v2.ListKeysResponse;
import com.google.api.apikeys.v2.LookupKeyRequest;
import com.google.api.apikeys.v2.LookupKeyResponse;
import com.google.api.apikeys.v2.UndeleteKeyRequest;
import com.google.api.apikeys.v2.UpdateKeyRequest;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiKeysStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apikeys.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getKey to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiKeysStubSettings.Builder apiKeysSettingsBuilder = ApiKeysStubSettings.newBuilder();
 * apiKeysSettingsBuilder
 *     .getKeySettings()
 *     .setRetrySettings(
 *         apiKeysSettingsBuilder.getKeySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApiKeysStubSettings apiKeysSettings = apiKeysSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiKeysStubSettings extends StubSettings<ApiKeysStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<CreateKeyRequest, Operation> createKeySettings;
  private final OperationCallSettings<CreateKeyRequest, Key, Empty> createKeyOperationSettings;
  private final PagedCallSettings<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      listKeysSettings;
  private final UnaryCallSettings<GetKeyRequest, Key> getKeySettings;
  private final UnaryCallSettings<GetKeyStringRequest, GetKeyStringResponse> getKeyStringSettings;
  private final UnaryCallSettings<UpdateKeyRequest, Operation> updateKeySettings;
  private final OperationCallSettings<UpdateKeyRequest, Key, Empty> updateKeyOperationSettings;
  private final UnaryCallSettings<DeleteKeyRequest, Operation> deleteKeySettings;
  private final OperationCallSettings<DeleteKeyRequest, Key, Empty> deleteKeyOperationSettings;
  private final UnaryCallSettings<UndeleteKeyRequest, Operation> undeleteKeySettings;
  private final OperationCallSettings<UndeleteKeyRequest, Key, Empty> undeleteKeyOperationSettings;
  private final UnaryCallSettings<LookupKeyRequest, LookupKeyResponse> lookupKeySettings;

  private static final PagedListDescriptor<ListKeysRequest, ListKeysResponse, Key>
      LIST_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListKeysRequest, ListKeysResponse, Key>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListKeysRequest injectToken(ListKeysRequest payload, String token) {
              return ListKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListKeysRequest injectPageSize(ListKeysRequest payload, int pageSize) {
              return ListKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Key> extractResources(ListKeysResponse payload) {
              return payload.getKeysList() == null
                  ? ImmutableList.<Key>of()
                  : payload.getKeysList();
            }
          };

  private static final PagedListResponseFactory<
          ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      LIST_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>() {
            @Override
            public ApiFuture<ListKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListKeysRequest, ListKeysResponse> callable,
                ListKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListKeysResponse> futureResponse) {
              PageContext<ListKeysRequest, ListKeysResponse, Key> pageContext =
                  PageContext.create(callable, LIST_KEYS_PAGE_STR_DESC, request, context);
              return ListKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createKey. */
  public UnaryCallSettings<CreateKeyRequest, Operation> createKeySettings() {
    return createKeySettings;
  }

  /** Returns the object with the settings used for calls to createKey. */
  public OperationCallSettings<CreateKeyRequest, Key, Empty> createKeyOperationSettings() {
    return createKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listKeys. */
  public PagedCallSettings<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      listKeysSettings() {
    return listKeysSettings;
  }

  /** Returns the object with the settings used for calls to getKey. */
  public UnaryCallSettings<GetKeyRequest, Key> getKeySettings() {
    return getKeySettings;
  }

  /** Returns the object with the settings used for calls to getKeyString. */
  public UnaryCallSettings<GetKeyStringRequest, GetKeyStringResponse> getKeyStringSettings() {
    return getKeyStringSettings;
  }

  /** Returns the object with the settings used for calls to updateKey. */
  public UnaryCallSettings<UpdateKeyRequest, Operation> updateKeySettings() {
    return updateKeySettings;
  }

  /** Returns the object with the settings used for calls to updateKey. */
  public OperationCallSettings<UpdateKeyRequest, Key, Empty> updateKeyOperationSettings() {
    return updateKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteKey. */
  public UnaryCallSettings<DeleteKeyRequest, Operation> deleteKeySettings() {
    return deleteKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteKey. */
  public OperationCallSettings<DeleteKeyRequest, Key, Empty> deleteKeyOperationSettings() {
    return deleteKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeleteKey. */
  public UnaryCallSettings<UndeleteKeyRequest, Operation> undeleteKeySettings() {
    return undeleteKeySettings;
  }

  /** Returns the object with the settings used for calls to undeleteKey. */
  public OperationCallSettings<UndeleteKeyRequest, Key, Empty> undeleteKeyOperationSettings() {
    return undeleteKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to lookupKey. */
  public UnaryCallSettings<LookupKeyRequest, LookupKeyResponse> lookupKeySettings() {
    return lookupKeySettings;
  }

  public ApiKeysStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcApiKeysStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonApiKeysStub.create(this);
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
    return "apikeys.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apikeys.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ApiKeysStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ApiKeysStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiKeysStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ApiKeysStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createKeySettings = settingsBuilder.createKeySettings().build();
    createKeyOperationSettings = settingsBuilder.createKeyOperationSettings().build();
    listKeysSettings = settingsBuilder.listKeysSettings().build();
    getKeySettings = settingsBuilder.getKeySettings().build();
    getKeyStringSettings = settingsBuilder.getKeyStringSettings().build();
    updateKeySettings = settingsBuilder.updateKeySettings().build();
    updateKeyOperationSettings = settingsBuilder.updateKeyOperationSettings().build();
    deleteKeySettings = settingsBuilder.deleteKeySettings().build();
    deleteKeyOperationSettings = settingsBuilder.deleteKeyOperationSettings().build();
    undeleteKeySettings = settingsBuilder.undeleteKeySettings().build();
    undeleteKeyOperationSettings = settingsBuilder.undeleteKeyOperationSettings().build();
    lookupKeySettings = settingsBuilder.lookupKeySettings().build();
  }

  /** Builder for ApiKeysStubSettings. */
  public static class Builder extends StubSettings.Builder<ApiKeysStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateKeyRequest, Operation> createKeySettings;
    private final OperationCallSettings.Builder<CreateKeyRequest, Key, Empty>
        createKeyOperationSettings;
    private final PagedCallSettings.Builder<
            ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
        listKeysSettings;
    private final UnaryCallSettings.Builder<GetKeyRequest, Key> getKeySettings;
    private final UnaryCallSettings.Builder<GetKeyStringRequest, GetKeyStringResponse>
        getKeyStringSettings;
    private final UnaryCallSettings.Builder<UpdateKeyRequest, Operation> updateKeySettings;
    private final OperationCallSettings.Builder<UpdateKeyRequest, Key, Empty>
        updateKeyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteKeyRequest, Operation> deleteKeySettings;
    private final OperationCallSettings.Builder<DeleteKeyRequest, Key, Empty>
        deleteKeyOperationSettings;
    private final UnaryCallSettings.Builder<UndeleteKeyRequest, Operation> undeleteKeySettings;
    private final OperationCallSettings.Builder<UndeleteKeyRequest, Key, Empty>
        undeleteKeyOperationSettings;
    private final UnaryCallSettings.Builder<LookupKeyRequest, LookupKeyResponse> lookupKeySettings;
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
              .setInitialRpcTimeout(Duration.ofMillis(10000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(10000L))
              .setTotalTimeout(Duration.ofMillis(10000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createKeyOperationSettings = OperationCallSettings.newBuilder();
      listKeysSettings = PagedCallSettings.newBuilder(LIST_KEYS_PAGE_STR_FACT);
      getKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getKeyStringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateKeyOperationSettings = OperationCallSettings.newBuilder();
      deleteKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteKeyOperationSettings = OperationCallSettings.newBuilder();
      undeleteKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteKeyOperationSettings = OperationCallSettings.newBuilder();
      lookupKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createKeySettings,
              listKeysSettings,
              getKeySettings,
              getKeyStringSettings,
              updateKeySettings,
              deleteKeySettings,
              undeleteKeySettings,
              lookupKeySettings);
      initDefaults(this);
    }

    protected Builder(ApiKeysStubSettings settings) {
      super(settings);

      createKeySettings = settings.createKeySettings.toBuilder();
      createKeyOperationSettings = settings.createKeyOperationSettings.toBuilder();
      listKeysSettings = settings.listKeysSettings.toBuilder();
      getKeySettings = settings.getKeySettings.toBuilder();
      getKeyStringSettings = settings.getKeyStringSettings.toBuilder();
      updateKeySettings = settings.updateKeySettings.toBuilder();
      updateKeyOperationSettings = settings.updateKeyOperationSettings.toBuilder();
      deleteKeySettings = settings.deleteKeySettings.toBuilder();
      deleteKeyOperationSettings = settings.deleteKeyOperationSettings.toBuilder();
      undeleteKeySettings = settings.undeleteKeySettings.toBuilder();
      undeleteKeyOperationSettings = settings.undeleteKeyOperationSettings.toBuilder();
      lookupKeySettings = settings.lookupKeySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createKeySettings,
              listKeysSettings,
              getKeySettings,
              getKeyStringSettings,
              updateKeySettings,
              deleteKeySettings,
              undeleteKeySettings,
              lookupKeySettings);
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
          .createKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getKeyStringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .undeleteKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .lookupKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Key.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
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
          .updateKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Key.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
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
          .deleteKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Key.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
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
          .undeleteKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UndeleteKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Key.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
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

    /** Returns the builder for the settings used for calls to createKey. */
    public UnaryCallSettings.Builder<CreateKeyRequest, Operation> createKeySettings() {
      return createKeySettings;
    }

    /** Returns the builder for the settings used for calls to createKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateKeyRequest, Key, Empty>
        createKeyOperationSettings() {
      return createKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listKeys. */
    public PagedCallSettings.Builder<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
        listKeysSettings() {
      return listKeysSettings;
    }

    /** Returns the builder for the settings used for calls to getKey. */
    public UnaryCallSettings.Builder<GetKeyRequest, Key> getKeySettings() {
      return getKeySettings;
    }

    /** Returns the builder for the settings used for calls to getKeyString. */
    public UnaryCallSettings.Builder<GetKeyStringRequest, GetKeyStringResponse>
        getKeyStringSettings() {
      return getKeyStringSettings;
    }

    /** Returns the builder for the settings used for calls to updateKey. */
    public UnaryCallSettings.Builder<UpdateKeyRequest, Operation> updateKeySettings() {
      return updateKeySettings;
    }

    /** Returns the builder for the settings used for calls to updateKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateKeyRequest, Key, Empty>
        updateKeyOperationSettings() {
      return updateKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteKey. */
    public UnaryCallSettings.Builder<DeleteKeyRequest, Operation> deleteKeySettings() {
      return deleteKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteKeyRequest, Key, Empty>
        deleteKeyOperationSettings() {
      return deleteKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteKey. */
    public UnaryCallSettings.Builder<UndeleteKeyRequest, Operation> undeleteKeySettings() {
      return undeleteKeySettings;
    }

    /** Returns the builder for the settings used for calls to undeleteKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UndeleteKeyRequest, Key, Empty>
        undeleteKeyOperationSettings() {
      return undeleteKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to lookupKey. */
    public UnaryCallSettings.Builder<LookupKeyRequest, LookupKeyResponse> lookupKeySettings() {
      return lookupKeySettings;
    }

    @Override
    public ApiKeysStubSettings build() throws IOException {
      return new ApiKeysStubSettings(this);
    }
  }
}
