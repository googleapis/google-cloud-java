/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListGlobalNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse;

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
import com.google.cloud.compute.v1.AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListGlobalNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link GlobalNetworkEndpointGroupStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of attachNetworkEndpointsGlobalNetworkEndpointGroup to
 * 30 seconds:
 *
 * <pre>
 * <code>
 * GlobalNetworkEndpointGroupStubSettings.Builder globalNetworkEndpointGroupSettingsBuilder =
 *     GlobalNetworkEndpointGroupStubSettings.newBuilder();
 * globalNetworkEndpointGroupSettingsBuilder
 *     .attachNetworkEndpointsGlobalNetworkEndpointGroupSettings()
 *     .setRetrySettings(
 *         globalNetworkEndpointGroupSettingsBuilder.attachNetworkEndpointsGlobalNetworkEndpointGroupSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GlobalNetworkEndpointGroupStubSettings globalNetworkEndpointGroupSettings = globalNetworkEndpointGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalNetworkEndpointGroupStubSettings
    extends StubSettings<GlobalNetworkEndpointGroupStubSettings> {
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

  private final UnaryCallSettings<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
  private final UnaryCallSettings<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupSettings;
  private final UnaryCallSettings<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
  private final UnaryCallSettings<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupSettings;
  private final UnaryCallSettings<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupSettings;
  private final PagedCallSettings<
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListGlobalNetworkEndpointGroupsPagedResponse>
      listGlobalNetworkEndpointGroupsSettings;
  private final PagedCallSettings<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsGlobalNetworkEndpointGroupsSettings;

  /**
   * Returns the object with the settings used for calls to
   * attachNetworkEndpointsGlobalNetworkEndpointGroup.
   */
  public UnaryCallSettings<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
    return attachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteGlobalNetworkEndpointGroup. */
  public UnaryCallSettings<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupSettings() {
    return deleteGlobalNetworkEndpointGroupSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * detachNetworkEndpointsGlobalNetworkEndpointGroup.
   */
  public UnaryCallSettings<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
    return detachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to getGlobalNetworkEndpointGroup. */
  public UnaryCallSettings<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupSettings() {
    return getGlobalNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to insertGlobalNetworkEndpointGroup. */
  public UnaryCallSettings<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupSettings() {
    return insertGlobalNetworkEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to listGlobalNetworkEndpointGroups. */
  public PagedCallSettings<
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListGlobalNetworkEndpointGroupsPagedResponse>
      listGlobalNetworkEndpointGroupsSettings() {
    return listGlobalNetworkEndpointGroupsSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * listNetworkEndpointsGlobalNetworkEndpointGroups.
   */
  public PagedCallSettings<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsGlobalNetworkEndpointGroupsSettings() {
    return listNetworkEndpointsGlobalNetworkEndpointGroupsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalNetworkEndpointGroupStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGlobalNetworkEndpointGroupStub.create(this);
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
    return "https://compute.googleapis.com/compute/v1/projects/";
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
            "gapic", GaxProperties.getLibraryVersion(GlobalNetworkEndpointGroupStubSettings.class))
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

  protected GlobalNetworkEndpointGroupStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    attachNetworkEndpointsGlobalNetworkEndpointGroupSettings =
        settingsBuilder.attachNetworkEndpointsGlobalNetworkEndpointGroupSettings().build();
    deleteGlobalNetworkEndpointGroupSettings =
        settingsBuilder.deleteGlobalNetworkEndpointGroupSettings().build();
    detachNetworkEndpointsGlobalNetworkEndpointGroupSettings =
        settingsBuilder.detachNetworkEndpointsGlobalNetworkEndpointGroupSettings().build();
    getGlobalNetworkEndpointGroupSettings =
        settingsBuilder.getGlobalNetworkEndpointGroupSettings().build();
    insertGlobalNetworkEndpointGroupSettings =
        settingsBuilder.insertGlobalNetworkEndpointGroupSettings().build();
    listGlobalNetworkEndpointGroupsSettings =
        settingsBuilder.listGlobalNetworkEndpointGroupsSettings().build();
    listNetworkEndpointsGlobalNetworkEndpointGroupsSettings =
        settingsBuilder.listNetworkEndpointsGlobalNetworkEndpointGroupsSettings().build();
  }

  private static final PagedListDescriptor<
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup>
      LIST_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGlobalNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupList,
              NetworkEndpointGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlobalNetworkEndpointGroupsHttpRequest injectToken(
                ListGlobalNetworkEndpointGroupsHttpRequest payload, String token) {
              return ListGlobalNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListGlobalNetworkEndpointGroupsHttpRequest injectPageSize(
                ListGlobalNetworkEndpointGroupsHttpRequest payload, int pageSize) {
              return ListGlobalNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGlobalNetworkEndpointGroupsHttpRequest payload) {
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
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          NetworkEndpointWithHealthStatus>
      LIST_NETWORK_ENDPOINTS_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupsListNetworkEndpoints,
              NetworkEndpointWithHealthStatus>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest injectToken(
                ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest payload, String token) {
              return ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest injectPageSize(
                ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest payload, int pageSize) {
              return ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest payload) {
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
          ListGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListGlobalNetworkEndpointGroupsPagedResponse>
      LIST_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlobalNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupList,
              ListGlobalNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListGlobalNetworkEndpointGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
                    callable,
                ListGlobalNetworkEndpointGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<NetworkEndpointGroupList> futureResponse) {
              PageContext<
                      ListGlobalNetworkEndpointGroupsHttpRequest,
                      NetworkEndpointGroupList,
                      NetworkEndpointGroup>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListGlobalNetworkEndpointGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      LIST_NETWORK_ENDPOINTS_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
              NetworkEndpointGroupsListNetworkEndpoints,
              ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                            NetworkEndpointGroupsListNetworkEndpoints>
                        callable,
                    ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest request,
                    ApiCallContext context,
                    ApiFuture<NetworkEndpointGroupsListNetworkEndpoints> futureResponse) {
              PageContext<
                      ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                      NetworkEndpointGroupsListNetworkEndpoints,
                      NetworkEndpointWithHealthStatus>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_NETWORK_ENDPOINTS_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for GlobalNetworkEndpointGroupStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GlobalNetworkEndpointGroupStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<
            AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
        deleteGlobalNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<
            DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<
            GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getGlobalNetworkEndpointGroupSettings;
    private final UnaryCallSettings.Builder<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
        insertGlobalNetworkEndpointGroupSettings;
    private final PagedCallSettings.Builder<
            ListGlobalNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupList,
            ListGlobalNetworkEndpointGroupsPagedResponse>
        listGlobalNetworkEndpointGroupsSettings;
    private final PagedCallSettings.Builder<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointsGlobalNetworkEndpointGroupsSettings;

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

      attachNetworkEndpointsGlobalNetworkEndpointGroupSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteGlobalNetworkEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      detachNetworkEndpointsGlobalNetworkEndpointGroupSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      getGlobalNetworkEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertGlobalNetworkEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listGlobalNetworkEndpointGroupsSettings =
          PagedCallSettings.newBuilder(LIST_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT);

      listNetworkEndpointsGlobalNetworkEndpointGroupsSettings =
          PagedCallSettings.newBuilder(
              LIST_NETWORK_ENDPOINTS_GLOBAL_NETWORK_ENDPOINT_GROUPS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              attachNetworkEndpointsGlobalNetworkEndpointGroupSettings,
              deleteGlobalNetworkEndpointGroupSettings,
              detachNetworkEndpointsGlobalNetworkEndpointGroupSettings,
              getGlobalNetworkEndpointGroupSettings,
              insertGlobalNetworkEndpointGroupSettings,
              listGlobalNetworkEndpointGroupsSettings,
              listNetworkEndpointsGlobalNetworkEndpointGroupsSettings);

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
          .attachNetworkEndpointsGlobalNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteGlobalNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .detachNetworkEndpointsGlobalNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getGlobalNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertGlobalNetworkEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listGlobalNetworkEndpointGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNetworkEndpointsGlobalNetworkEndpointGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(GlobalNetworkEndpointGroupStubSettings settings) {
      super(settings);

      attachNetworkEndpointsGlobalNetworkEndpointGroupSettings =
          settings.attachNetworkEndpointsGlobalNetworkEndpointGroupSettings.toBuilder();
      deleteGlobalNetworkEndpointGroupSettings =
          settings.deleteGlobalNetworkEndpointGroupSettings.toBuilder();
      detachNetworkEndpointsGlobalNetworkEndpointGroupSettings =
          settings.detachNetworkEndpointsGlobalNetworkEndpointGroupSettings.toBuilder();
      getGlobalNetworkEndpointGroupSettings =
          settings.getGlobalNetworkEndpointGroupSettings.toBuilder();
      insertGlobalNetworkEndpointGroupSettings =
          settings.insertGlobalNetworkEndpointGroupSettings.toBuilder();
      listGlobalNetworkEndpointGroupsSettings =
          settings.listGlobalNetworkEndpointGroupsSettings.toBuilder();
      listNetworkEndpointsGlobalNetworkEndpointGroupsSettings =
          settings.listNetworkEndpointsGlobalNetworkEndpointGroupsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              attachNetworkEndpointsGlobalNetworkEndpointGroupSettings,
              deleteGlobalNetworkEndpointGroupSettings,
              detachNetworkEndpointsGlobalNetworkEndpointGroupSettings,
              getGlobalNetworkEndpointGroupSettings,
              insertGlobalNetworkEndpointGroupSettings,
              listGlobalNetworkEndpointGroupsSettings,
              listNetworkEndpointsGlobalNetworkEndpointGroupsSettings);
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
     * Returns the builder for the settings used for calls to
     * attachNetworkEndpointsGlobalNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
      return attachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGlobalNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
        deleteGlobalNetworkEndpointGroupSettings() {
      return deleteGlobalNetworkEndpointGroupSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * detachNetworkEndpointsGlobalNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsGlobalNetworkEndpointGroupSettings() {
      return detachNetworkEndpointsGlobalNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to getGlobalNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getGlobalNetworkEndpointGroupSettings() {
      return getGlobalNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to insertGlobalNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
        insertGlobalNetworkEndpointGroupSettings() {
      return insertGlobalNetworkEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listGlobalNetworkEndpointGroups. */
    public PagedCallSettings.Builder<
            ListGlobalNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupList,
            ListGlobalNetworkEndpointGroupsPagedResponse>
        listGlobalNetworkEndpointGroupsSettings() {
      return listGlobalNetworkEndpointGroupsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listNetworkEndpointsGlobalNetworkEndpointGroups.
     */
    public PagedCallSettings.Builder<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointsGlobalNetworkEndpointGroupsSettings() {
      return listNetworkEndpointsGlobalNetworkEndpointGroupsSettings;
    }

    @Override
    public GlobalNetworkEndpointGroupStubSettings build() throws IOException {
      return new GlobalNetworkEndpointGroupStubSettings(this);
    }
  }
}
