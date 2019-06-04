/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.AggregatedListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointsNetworkEndpointGroupsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.cloud.compute.v1.AggregatedListNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.AttachNetworkEndpointsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupAggregatedList;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.NetworkEndpointGroupsScopedList;
import com.google.cloud.compute.v1.NetworkEndpointWithHealthStatus;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NetworkEndpointGroupStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of attachNetworkEndpointsNetworkEndpointGroup to 30 seconds:
 *
 * <pre>
 * <code>
 * NetworkEndpointGroupStubSettings.Builder networkEndpointGroupSettingsBuilder =
 *     NetworkEndpointGroupStubSettings.newBuilder();
 * networkEndpointGroupSettingsBuilder.attachNetworkEndpointsNetworkEndpointGroupSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NetworkEndpointGroupStubSettings networkEndpointGroupSettings = networkEndpointGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworkEndpointGroupStubSettings
    extends StubSettings<NetworkEndpointGroupStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final PagedCallSettings<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      aggregatedListNetworkEndpointGroupsSettings;
  private final UnaryCallSettings<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupSettings;
  private final UnaryCallSettings<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupSettings;
  private final UnaryCallSettings<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupSettings;
  private final UnaryCallSettings<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupSettings;
  private final UnaryCallSettings<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupSettings;
  private final PagedCallSettings<
          ListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointGroupsSettings;
  private final PagedCallSettings<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsNetworkEndpointGroupsSettings;
  private final UnaryCallSettings<
          TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupSettings;

  /** Returns the object with the settings used for calls to aggregatedListNetworkEndpointGroups. */
  public PagedCallSettings<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      aggregatedListNetworkEndpointGroupsSettings() {
    return aggregatedListNetworkEndpointGroupsSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * attachNetworkEndpointsNetworkEndpointGroup.
   */
  public UnaryCallSettings<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupSettings() {
    return attachNetworkEndpointsNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteNetworkEndpointGroup. */
  public UnaryCallSettings<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupSettings() {
    return deleteNetworkEndpointGroupSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * detachNetworkEndpointsNetworkEndpointGroup.
   */
  public UnaryCallSettings<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupSettings() {
    return detachNetworkEndpointsNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to getNetworkEndpointGroup. */
  public UnaryCallSettings<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupSettings() {
    return getNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to insertNetworkEndpointGroup. */
  public UnaryCallSettings<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupSettings() {
    return insertNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to listNetworkEndpointGroups. */
  public PagedCallSettings<
          ListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointGroupsSettings() {
    return listNetworkEndpointGroupsSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * listNetworkEndpointsNetworkEndpointGroups.
   */
  public PagedCallSettings<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsNetworkEndpointGroupsSettings() {
    return listNetworkEndpointsNetworkEndpointGroupsSettings;
  }

  /**
   * Returns the object with the settings used for calls to testIamPermissionsNetworkEndpointGroup.
   */
  public UnaryCallSettings<
          TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupSettings() {
    return testIamPermissionsNetworkEndpointGroupSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NetworkEndpointGroupStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNetworkEndpointGroupStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "https://www.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
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
            "gapic", GaxProperties.getLibraryVersion(NetworkEndpointGroupStubSettings.class))
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

  protected NetworkEndpointGroupStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListNetworkEndpointGroupsSettings =
        settingsBuilder.aggregatedListNetworkEndpointGroupsSettings().build();
    attachNetworkEndpointsNetworkEndpointGroupSettings =
        settingsBuilder.attachNetworkEndpointsNetworkEndpointGroupSettings().build();
    deleteNetworkEndpointGroupSettings =
        settingsBuilder.deleteNetworkEndpointGroupSettings().build();
    detachNetworkEndpointsNetworkEndpointGroupSettings =
        settingsBuilder.detachNetworkEndpointsNetworkEndpointGroupSettings().build();
    getNetworkEndpointGroupSettings = settingsBuilder.getNetworkEndpointGroupSettings().build();
    insertNetworkEndpointGroupSettings =
        settingsBuilder.insertNetworkEndpointGroupSettings().build();
    listNetworkEndpointGroupsSettings = settingsBuilder.listNetworkEndpointGroupsSettings().build();
    listNetworkEndpointsNetworkEndpointGroupsSettings =
        settingsBuilder.listNetworkEndpointsNetworkEndpointGroupsSettings().build();
    testIamPermissionsNetworkEndpointGroupSettings =
        settingsBuilder.testIamPermissionsNetworkEndpointGroupSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          NetworkEndpointGroupsScopedList>
      AGGREGATED_LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupAggregatedList,
              NetworkEndpointGroupsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListNetworkEndpointGroupsHttpRequest injectToken(
                AggregatedListNetworkEndpointGroupsHttpRequest payload, String token) {
              return AggregatedListNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListNetworkEndpointGroupsHttpRequest injectPageSize(
                AggregatedListNetworkEndpointGroupsHttpRequest payload, int pageSize) {
              return AggregatedListNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListNetworkEndpointGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NetworkEndpointGroupAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkEndpointGroupsScopedList> extractResources(
                NetworkEndpointGroupAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<NetworkEndpointGroupsScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList, NetworkEndpointGroup>
      LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupList,
              NetworkEndpointGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkEndpointGroupsHttpRequest injectToken(
                ListNetworkEndpointGroupsHttpRequest payload, String token) {
              return ListNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNetworkEndpointGroupsHttpRequest injectPageSize(
                ListNetworkEndpointGroupsHttpRequest payload, int pageSize) {
              return ListNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNetworkEndpointGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NetworkEndpointGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkEndpointGroup> extractResources(
                NetworkEndpointGroupList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<NetworkEndpointGroup>of();
            }
          };

  private static final PagedListDescriptor<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus>
      LIST_NETWORK_ENDPOINTS_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupsListNetworkEndpoints,
              NetworkEndpointWithHealthStatus>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkEndpointsNetworkEndpointGroupsHttpRequest injectToken(
                ListNetworkEndpointsNetworkEndpointGroupsHttpRequest payload, String token) {
              return ListNetworkEndpointsNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNetworkEndpointsNetworkEndpointGroupsHttpRequest injectPageSize(
                ListNetworkEndpointsNetworkEndpointGroupsHttpRequest payload, int pageSize) {
              return ListNetworkEndpointsNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListNetworkEndpointsNetworkEndpointGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NetworkEndpointGroupsListNetworkEndpoints payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkEndpointWithHealthStatus> extractResources(
                NetworkEndpointGroupsListNetworkEndpoints payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<NetworkEndpointWithHealthStatus>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      AGGREGATED_LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupAggregatedList,
              AggregatedListNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListNetworkEndpointGroupsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            AggregatedListNetworkEndpointGroupsHttpRequest,
                            NetworkEndpointGroupAggregatedList>
                        callable,
                    AggregatedListNetworkEndpointGroupsHttpRequest request,
                    ApiCallContext context,
                    ApiFuture<NetworkEndpointGroupAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListNetworkEndpointGroupsHttpRequest,
                      NetworkEndpointGroupAggregatedList,
                      NetworkEndpointGroupsScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListNetworkEndpointGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListNetworkEndpointGroupsPagedResponse>
      LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupList,
              ListNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListNetworkEndpointGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
                    callable,
                ListNetworkEndpointGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<NetworkEndpointGroupList> futureResponse) {
              PageContext<
                      ListNetworkEndpointGroupsHttpRequest,
                      NetworkEndpointGroupList,
                      NetworkEndpointGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC, request, context);
              return ListNetworkEndpointGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      LIST_NETWORK_ENDPOINTS_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupsListNetworkEndpoints,
              ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                            NetworkEndpointGroupsListNetworkEndpoints>
                        callable,
                    ListNetworkEndpointsNetworkEndpointGroupsHttpRequest request,
                    ApiCallContext context,
                    ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
              PageContext<
                      ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                      NetworkEndpointGroupsListNetworkEndpoints,
                      NetworkEndpointWithHealthStatus>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_NETWORK_ENDPOINTS_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListNetworkEndpointsNetworkEndpointGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for NetworkEndpointGroupStubSettings. */
  public static class Builder
      extends StubSettings.Builder<NetworkEndpointGroupStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupAggregatedList,
            AggregatedListNetworkEndpointGroupsPagedResponse>
        aggregatedListNetworkEndpointGroupsSettings;
    private final UnaryCallSettings.Builder<
            AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkEndpointGroupHttpRequest, Operation>
        deleteNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<
            DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<
            GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<InsertNetworkEndpointGroupHttpRequest, Operation>
        insertNetworkEndpointGroupSettings;
    private final PagedCallSettings.Builder<
            ListNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupList,
            ListNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointGroupsSettings;
    private final PagedCallSettings.Builder<
            ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointsNetworkEndpointGroupsSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
        testIamPermissionsNetworkEndpointGroupSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListNetworkEndpointGroupsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT);

      attachNetworkEndpointsNetworkEndpointGroupSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteNetworkEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      detachNetworkEndpointsNetworkEndpointGroupSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      getNetworkEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertNetworkEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listNetworkEndpointGroupsSettings =
          PagedCallSettings.newBuilder(LIST_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT);

      listNetworkEndpointsNetworkEndpointGroupsSettings =
          PagedCallSettings.newBuilder(
              LIST_NETWORK_ENDPOINTS_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT);

      testIamPermissionsNetworkEndpointGroupSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListNetworkEndpointGroupsSettings,
              attachNetworkEndpointsNetworkEndpointGroupSettings,
              deleteNetworkEndpointGroupSettings,
              detachNetworkEndpointsNetworkEndpointGroupSettings,
              getNetworkEndpointGroupSettings,
              insertNetworkEndpointGroupSettings,
              listNetworkEndpointGroupsSettings,
              listNetworkEndpointsNetworkEndpointGroupsSettings,
              testIamPermissionsNetworkEndpointGroupSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .aggregatedListNetworkEndpointGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .attachNetworkEndpointsNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .detachNetworkEndpointsNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNetworkEndpointGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNetworkEndpointsNetworkEndpointGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(NetworkEndpointGroupStubSettings settings) {
      super(settings);

      aggregatedListNetworkEndpointGroupsSettings =
          settings.aggregatedListNetworkEndpointGroupsSettings.toBuilder();
      attachNetworkEndpointsNetworkEndpointGroupSettings =
          settings.attachNetworkEndpointsNetworkEndpointGroupSettings.toBuilder();
      deleteNetworkEndpointGroupSettings = settings.deleteNetworkEndpointGroupSettings.toBuilder();
      detachNetworkEndpointsNetworkEndpointGroupSettings =
          settings.detachNetworkEndpointsNetworkEndpointGroupSettings.toBuilder();
      getNetworkEndpointGroupSettings = settings.getNetworkEndpointGroupSettings.toBuilder();
      insertNetworkEndpointGroupSettings = settings.insertNetworkEndpointGroupSettings.toBuilder();
      listNetworkEndpointGroupsSettings = settings.listNetworkEndpointGroupsSettings.toBuilder();
      listNetworkEndpointsNetworkEndpointGroupsSettings =
          settings.listNetworkEndpointsNetworkEndpointGroupsSettings.toBuilder();
      testIamPermissionsNetworkEndpointGroupSettings =
          settings.testIamPermissionsNetworkEndpointGroupSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListNetworkEndpointGroupsSettings,
              attachNetworkEndpointsNetworkEndpointGroupSettings,
              deleteNetworkEndpointGroupSettings,
              detachNetworkEndpointsNetworkEndpointGroupSettings,
              getNetworkEndpointGroupSettings,
              insertNetworkEndpointGroupSettings,
              listNetworkEndpointGroupsSettings,
              listNetworkEndpointsNetworkEndpointGroupsSettings,
              testIamPermissionsNetworkEndpointGroupSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /**
     * Returns the builder for the settings used for calls to aggregatedListNetworkEndpointGroups.
     */
    public PagedCallSettings.Builder<
            AggregatedListNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupAggregatedList,
            AggregatedListNetworkEndpointGroupsPagedResponse>
        aggregatedListNetworkEndpointGroupsSettings() {
      return aggregatedListNetworkEndpointGroupsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * attachNetworkEndpointsNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsNetworkEndpointGroupSettings() {
      return attachNetworkEndpointsNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteNetworkEndpointGroupHttpRequest, Operation>
        deleteNetworkEndpointGroupSettings() {
      return deleteNetworkEndpointGroupSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * detachNetworkEndpointsNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsNetworkEndpointGroupSettings() {
      return detachNetworkEndpointsNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to getNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getNetworkEndpointGroupSettings() {
      return getNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to insertNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<InsertNetworkEndpointGroupHttpRequest, Operation>
        insertNetworkEndpointGroupSettings() {
      return insertNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworkEndpointGroups. */
    public PagedCallSettings.Builder<
            ListNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupList,
            ListNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointGroupsSettings() {
      return listNetworkEndpointGroupsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listNetworkEndpointsNetworkEndpointGroups.
     */
    public PagedCallSettings.Builder<
            ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointsNetworkEndpointGroupsSettings() {
      return listNetworkEndpointsNetworkEndpointGroupsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * testIamPermissionsNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
        testIamPermissionsNetworkEndpointGroupSettings() {
      return testIamPermissionsNetworkEndpointGroupSettings;
    }

    @Override
    public NetworkEndpointGroupStubSettings build() throws IOException {
      return new NetworkEndpointGroupStubSettings(this);
    }
  }
}
