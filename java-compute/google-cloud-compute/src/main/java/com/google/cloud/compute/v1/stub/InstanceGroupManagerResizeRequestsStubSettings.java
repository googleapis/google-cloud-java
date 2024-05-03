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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InstanceGroupManagerResizeRequestsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
import com.google.cloud.compute.v1.CancelInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.GetInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InstanceGroupManagerResizeRequest;
import com.google.cloud.compute.v1.InstanceGroupManagerResizeRequestsListResponse;
import com.google.cloud.compute.v1.ListInstanceGroupManagerResizeRequestsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InstanceGroupManagerResizeRequestsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstanceGroupManagerResizeRequestsStubSettings.Builder
 *     instanceGroupManagerResizeRequestsSettingsBuilder =
 *         InstanceGroupManagerResizeRequestsStubSettings.newBuilder();
 * instanceGroupManagerResizeRequestsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         instanceGroupManagerResizeRequestsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstanceGroupManagerResizeRequestsStubSettings instanceGroupManagerResizeRequestsSettings =
 *     instanceGroupManagerResizeRequestsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstanceGroupManagerResizeRequestsStubSettings
    extends StubSettings<InstanceGroupManagerResizeRequestsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CancelInstanceGroupManagerResizeRequestRequest, Operation>
      cancelSettings;
  private final OperationCallSettings<
          CancelInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationSettings;
  private final UnaryCallSettings<DeleteInstanceGroupManagerResizeRequestRequest, Operation>
      deleteSettings;
  private final OperationCallSettings<
          DeleteInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<
          GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getSettings;
  private final UnaryCallSettings<InsertInstanceGroupManagerResizeRequestRequest, Operation>
      insertSettings;
  private final OperationCallSettings<
          InsertInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse,
          ListPagedResponse>
      listSettings;

  private static final PagedListDescriptor<
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse,
          InstanceGroupManagerResizeRequest>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstanceGroupManagerResizeRequestsRequest,
              InstanceGroupManagerResizeRequestsListResponse,
              InstanceGroupManagerResizeRequest>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstanceGroupManagerResizeRequestsRequest injectToken(
                ListInstanceGroupManagerResizeRequestsRequest payload, String token) {
              return ListInstanceGroupManagerResizeRequestsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInstanceGroupManagerResizeRequestsRequest injectPageSize(
                ListInstanceGroupManagerResizeRequestsRequest payload, int pageSize) {
              return ListInstanceGroupManagerResizeRequestsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstanceGroupManagerResizeRequestsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceGroupManagerResizeRequestsListResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceGroupManagerResizeRequest> extractResources(
                InstanceGroupManagerResizeRequestsListResponse payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<InstanceGroupManagerResizeRequest>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse,
          ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstanceGroupManagerResizeRequestsRequest,
              InstanceGroupManagerResizeRequestsListResponse,
              ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInstanceGroupManagerResizeRequestsRequest,
                        InstanceGroupManagerResizeRequestsListResponse>
                    callable,
                ListInstanceGroupManagerResizeRequestsRequest request,
                ApiCallContext context,
                ApiFuture<InstanceGroupManagerResizeRequestsListResponse> futureResponse) {
              PageContext<
                      ListInstanceGroupManagerResizeRequestsRequest,
                      InstanceGroupManagerResizeRequestsListResponse,
                      InstanceGroupManagerResizeRequest>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to cancel. */
  public UnaryCallSettings<CancelInstanceGroupManagerResizeRequestRequest, Operation>
      cancelSettings() {
    return cancelSettings;
  }

  /** Returns the object with the settings used for calls to cancel. */
  public OperationCallSettings<CancelInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationSettings() {
    return cancelOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceGroupManagerResizeRequestRequest, Operation>
      deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<
          GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInstanceGroupManagerResizeRequestRequest, Operation>
      insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse,
          ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  public InstanceGroupManagerResizeRequestsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInstanceGroupManagerResizeRequestsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(InstanceGroupManagerResizeRequestsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected InstanceGroupManagerResizeRequestsStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    cancelSettings = settingsBuilder.cancelSettings().build();
    cancelOperationSettings = settingsBuilder.cancelOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
  }

  /** Builder for InstanceGroupManagerResizeRequestsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<InstanceGroupManagerResizeRequestsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CancelInstanceGroupManagerResizeRequestRequest, Operation>
        cancelSettings;
    private final OperationCallSettings.Builder<
            CancelInstanceGroupManagerResizeRequestRequest, Operation, Operation>
        cancelOperationSettings;
    private final UnaryCallSettings.Builder<
            DeleteInstanceGroupManagerResizeRequestRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteInstanceGroupManagerResizeRequestRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<
            GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
        getSettings;
    private final UnaryCallSettings.Builder<
            InsertInstanceGroupManagerResizeRequestRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertInstanceGroupManagerResizeRequestRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListInstanceGroupManagerResizeRequestsRequest,
            InstanceGroupManagerResizeRequestsListResponse,
            ListPagedResponse>
        listSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      cancelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              cancelSettings, deleteSettings, getSettings, insertSettings, listSettings);
      initDefaults(this);
    }

    protected Builder(InstanceGroupManagerResizeRequestsStubSettings settings) {
      super(settings);

      cancelSettings = settings.cancelSettings.toBuilder();
      cancelOperationSettings = settings.cancelOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              cancelSettings, deleteSettings, getSettings, insertSettings, listSettings);
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
          .cancelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CancelInstanceGroupManagerResizeRequestRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInstanceGroupManagerResizeRequestRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertInstanceGroupManagerResizeRequestRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to cancel. */
    public UnaryCallSettings.Builder<CancelInstanceGroupManagerResizeRequestRequest, Operation>
        cancelSettings() {
      return cancelSettings;
    }

    /** Returns the builder for the settings used for calls to cancel. */
    public OperationCallSettings.Builder<
            CancelInstanceGroupManagerResizeRequestRequest, Operation, Operation>
        cancelOperationSettings() {
      return cancelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceGroupManagerResizeRequestRequest, Operation>
        deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<
            DeleteInstanceGroupManagerResizeRequestRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<
            GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
        getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInstanceGroupManagerResizeRequestRequest, Operation>
        insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<
            InsertInstanceGroupManagerResizeRequestRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListInstanceGroupManagerResizeRequestsRequest,
            InstanceGroupManagerResizeRequestsListResponse,
            ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    @Override
    public InstanceGroupManagerResizeRequestsStubSettings build() throws IOException {
      return new InstanceGroupManagerResizeRequestsStubSettings(this);
    }
  }
}
