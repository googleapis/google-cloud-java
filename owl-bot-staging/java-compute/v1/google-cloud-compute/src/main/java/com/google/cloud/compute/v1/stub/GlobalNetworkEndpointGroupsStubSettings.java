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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DeleteGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListGlobalNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.NetworkEndpointWithHealthStatus;
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
 * Settings class to configure an instance of {@link GlobalNetworkEndpointGroupsStub}.
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
 * GlobalNetworkEndpointGroupsStubSettings.Builder globalNetworkEndpointGroupsSettingsBuilder =
 *     GlobalNetworkEndpointGroupsStubSettings.newBuilder();
 * globalNetworkEndpointGroupsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         globalNetworkEndpointGroupsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GlobalNetworkEndpointGroupsStubSettings globalNetworkEndpointGroupsSettings =
 *     globalNetworkEndpointGroupsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GlobalNetworkEndpointGroupsStubSettings
    extends StubSettings<GlobalNetworkEndpointGroupsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsSettings;
  private final OperationCallSettings<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationSettings;
  private final UnaryCallSettings<DeleteGlobalNetworkEndpointGroupRequest, Operation>
      deleteSettings;
  private final OperationCallSettings<DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsSettings;
  private final OperationCallSettings<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationSettings;
  private final UnaryCallSettings<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getSettings;
  private final UnaryCallSettings<InsertGlobalNetworkEndpointGroupRequest, Operation>
      insertSettings;
  private final OperationCallSettings<InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsSettings;

  private static final PagedListDescriptor<
          ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList, NetworkEndpointGroup>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGlobalNetworkEndpointGroupsRequest,
              NetworkEndpointGroupList,
              NetworkEndpointGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlobalNetworkEndpointGroupsRequest injectToken(
                ListGlobalNetworkEndpointGroupsRequest payload, String token) {
              return ListGlobalNetworkEndpointGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListGlobalNetworkEndpointGroupsRequest injectPageSize(
                ListGlobalNetworkEndpointGroupsRequest payload, int pageSize) {
              return ListGlobalNetworkEndpointGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGlobalNetworkEndpointGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NetworkEndpointGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkEndpointGroup> extractResources(
                NetworkEndpointGroupList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<NetworkEndpointGroup>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus>
      LIST_NETWORK_ENDPOINTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
              NetworkEndpointGroupsListNetworkEndpoints,
              NetworkEndpointWithHealthStatus>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest injectToken(
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest payload, String token) {
              return ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest injectPageSize(
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest payload, int pageSize) {
              return ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NetworkEndpointGroupsListNetworkEndpoints payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkEndpointWithHealthStatus> extractResources(
                NetworkEndpointGroupsListNetworkEndpoints payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<NetworkEndpointWithHealthStatus>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlobalNetworkEndpointGroupsRequest,
              NetworkEndpointGroupList,
              ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
                    callable,
                ListGlobalNetworkEndpointGroupsRequest request,
                ApiCallContext context,
                ApiFuture<NetworkEndpointGroupList> futureResponse) {
              PageContext<
                      ListGlobalNetworkEndpointGroupsRequest,
                      NetworkEndpointGroupList,
                      NetworkEndpointGroup>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsPagedResponse>
      LIST_NETWORK_ENDPOINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
              NetworkEndpointGroupsListNetworkEndpoints,
              ListNetworkEndpointsPagedResponse>() {
            @Override
            public ApiFuture<ListNetworkEndpointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                        NetworkEndpointGroupsListNetworkEndpoints>
                    callable,
                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request,
                ApiCallContext context,
                ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
              PageContext<
                      ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                      NetworkEndpointGroupsListNetworkEndpoints,
                      NetworkEndpointWithHealthStatus>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NETWORK_ENDPOINTS_PAGE_STR_DESC, request, context);
              return ListNetworkEndpointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to attachNetworkEndpoints. */
  public UnaryCallSettings<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsSettings() {
    return attachNetworkEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to attachNetworkEndpoints. */
  public OperationCallSettings<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationSettings() {
    return attachNetworkEndpointsOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteGlobalNetworkEndpointGroupRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to detachNetworkEndpoints. */
  public UnaryCallSettings<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsSettings() {
    return detachNetworkEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to detachNetworkEndpoints. */
  public OperationCallSettings<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationSettings() {
    return detachNetworkEndpointsOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertGlobalNetworkEndpointGroupRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listNetworkEndpoints. */
  public PagedCallSettings<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsSettings() {
    return listNetworkEndpointsSettings;
  }

  public GlobalNetworkEndpointGroupsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGlobalNetworkEndpointGroupsStub.create(this);
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GlobalNetworkEndpointGroupsStubSettings.class))
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

  protected GlobalNetworkEndpointGroupsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    attachNetworkEndpointsSettings = settingsBuilder.attachNetworkEndpointsSettings().build();
    attachNetworkEndpointsOperationSettings =
        settingsBuilder.attachNetworkEndpointsOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    detachNetworkEndpointsSettings = settingsBuilder.detachNetworkEndpointsSettings().build();
    detachNetworkEndpointsOperationSettings =
        settingsBuilder.detachNetworkEndpointsOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listNetworkEndpointsSettings = settingsBuilder.listNetworkEndpointsSettings().build();
  }

  /** Builder for GlobalNetworkEndpointGroupsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GlobalNetworkEndpointGroupsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        attachNetworkEndpointsSettings;
    private final OperationCallSettings.Builder<
            AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
        attachNetworkEndpointsOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGlobalNetworkEndpointGroupRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<
            DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        detachNetworkEndpointsSettings;
    private final OperationCallSettings.Builder<
            DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
        detachNetworkEndpointsOperationSettings;
    private final UnaryCallSettings.Builder<
            GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
        getSettings;
    private final UnaryCallSettings.Builder<InsertGlobalNetworkEndpointGroupRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsPagedResponse>
        listNetworkEndpointsSettings;
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

      attachNetworkEndpointsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      attachNetworkEndpointsOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      detachNetworkEndpointsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      detachNetworkEndpointsOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listNetworkEndpointsSettings =
          PagedCallSettings.newBuilder(LIST_NETWORK_ENDPOINTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              attachNetworkEndpointsSettings,
              deleteSettings,
              detachNetworkEndpointsSettings,
              getSettings,
              insertSettings,
              listSettings,
              listNetworkEndpointsSettings);
      initDefaults(this);
    }

    protected Builder(GlobalNetworkEndpointGroupsStubSettings settings) {
      super(settings);

      attachNetworkEndpointsSettings = settings.attachNetworkEndpointsSettings.toBuilder();
      attachNetworkEndpointsOperationSettings =
          settings.attachNetworkEndpointsOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      detachNetworkEndpointsSettings = settings.detachNetworkEndpointsSettings.toBuilder();
      detachNetworkEndpointsOperationSettings =
          settings.detachNetworkEndpointsOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listNetworkEndpointsSettings = settings.listNetworkEndpointsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              attachNetworkEndpointsSettings,
              deleteSettings,
              detachNetworkEndpointsSettings,
              getSettings,
              insertSettings,
              listSettings,
              listNetworkEndpointsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .attachNetworkEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .detachNetworkEndpointsSettings()
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
          .listNetworkEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .attachNetworkEndpointsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, OperationSnapshot>
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
                  .<DeleteGlobalNetworkEndpointGroupRequest, OperationSnapshot>
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
          .detachNetworkEndpointsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, OperationSnapshot>
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
                  .<InsertGlobalNetworkEndpointGroupRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to attachNetworkEndpoints. */
    public UnaryCallSettings.Builder<
            AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        attachNetworkEndpointsSettings() {
      return attachNetworkEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to attachNetworkEndpoints. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
        attachNetworkEndpointsOperationSettings() {
      return attachNetworkEndpointsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteGlobalNetworkEndpointGroupRequest, Operation>
        deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to detachNetworkEndpoints. */
    public UnaryCallSettings.Builder<
            DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        detachNetworkEndpointsSettings() {
      return detachNetworkEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to detachNetworkEndpoints. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
        detachNetworkEndpointsOperationSettings() {
      return detachNetworkEndpointsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
        getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertGlobalNetworkEndpointGroupRequest, Operation>
        insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworkEndpoints. */
    public PagedCallSettings.Builder<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsPagedResponse>
        listNetworkEndpointsSettings() {
      return listNetworkEndpointsSettings;
    }

    @Override
    public GlobalNetworkEndpointGroupsStubSettings build() throws IOException {
      return new GlobalNetworkEndpointGroupsStubSettings(this);
    }
  }
}
