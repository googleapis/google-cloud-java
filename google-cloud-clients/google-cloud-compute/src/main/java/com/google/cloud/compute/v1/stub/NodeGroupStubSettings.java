/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.NodeGroupClient.AggregatedListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodesNodeGroupsPagedResponse;

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
import com.google.cloud.compute.v1.AddNodesNodeGroupHttpRequest;
import com.google.cloud.compute.v1.AggregatedListNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.DeleteNodeGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteNodesNodeGroupHttpRequest;
import com.google.cloud.compute.v1.GetNodeGroupHttpRequest;
import com.google.cloud.compute.v1.InsertNodeGroupHttpRequest;
import com.google.cloud.compute.v1.ListNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNodesNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.NodeGroup;
import com.google.cloud.compute.v1.NodeGroupAggregatedList;
import com.google.cloud.compute.v1.NodeGroupList;
import com.google.cloud.compute.v1.NodeGroupNode;
import com.google.cloud.compute.v1.NodeGroupsListNodes;
import com.google.cloud.compute.v1.NodeGroupsScopedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetNodeTemplateNodeGroupHttpRequest;
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
 * Settings class to configure an instance of {@link NodeGroupStub}.
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
 * example, to set the total timeout of addNodesNodeGroup to 30 seconds:
 *
 * <pre>
 * <code>
 * NodeGroupStubSettings.Builder nodeGroupSettingsBuilder =
 *     NodeGroupStubSettings.newBuilder();
 * nodeGroupSettingsBuilder.addNodesNodeGroupSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NodeGroupStubSettings nodeGroupSettings = nodeGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeGroupStubSettings extends StubSettings<NodeGroupStubSettings> {
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

  private final UnaryCallSettings<AddNodesNodeGroupHttpRequest, Operation>
      addNodesNodeGroupSettings;
  private final PagedCallSettings<
          AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
          AggregatedListNodeGroupsPagedResponse>
      aggregatedListNodeGroupsSettings;
  private final UnaryCallSettings<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupSettings;
  private final UnaryCallSettings<DeleteNodesNodeGroupHttpRequest, Operation>
      deleteNodesNodeGroupSettings;
  private final UnaryCallSettings<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupSettings;
  private final UnaryCallSettings<InsertNodeGroupHttpRequest, Operation> insertNodeGroupSettings;
  private final PagedCallSettings<
          ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>
      listNodeGroupsSettings;
  private final PagedCallSettings<
          ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, ListNodesNodeGroupsPagedResponse>
      listNodesNodeGroupsSettings;
  private final UnaryCallSettings<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupSettings;

  /** Returns the object with the settings used for calls to addNodesNodeGroup. */
  public UnaryCallSettings<AddNodesNodeGroupHttpRequest, Operation> addNodesNodeGroupSettings() {
    return addNodesNodeGroupSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedListNodeGroups. */
  public PagedCallSettings<
          AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
          AggregatedListNodeGroupsPagedResponse>
      aggregatedListNodeGroupsSettings() {
    return aggregatedListNodeGroupsSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodeGroup. */
  public UnaryCallSettings<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupSettings() {
    return deleteNodeGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodesNodeGroup. */
  public UnaryCallSettings<DeleteNodesNodeGroupHttpRequest, Operation>
      deleteNodesNodeGroupSettings() {
    return deleteNodesNodeGroupSettings;
  }

  /** Returns the object with the settings used for calls to getNodeGroup. */
  public UnaryCallSettings<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupSettings() {
    return getNodeGroupSettings;
  }

  /** Returns the object with the settings used for calls to insertNodeGroup. */
  public UnaryCallSettings<InsertNodeGroupHttpRequest, Operation> insertNodeGroupSettings() {
    return insertNodeGroupSettings;
  }

  /** Returns the object with the settings used for calls to listNodeGroups. */
  public PagedCallSettings<ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>
      listNodeGroupsSettings() {
    return listNodeGroupsSettings;
  }

  /** Returns the object with the settings used for calls to listNodesNodeGroups. */
  public PagedCallSettings<
          ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, ListNodesNodeGroupsPagedResponse>
      listNodesNodeGroupsSettings() {
    return listNodesNodeGroupsSettings;
  }

  /** Returns the object with the settings used for calls to setNodeTemplateNodeGroup. */
  public UnaryCallSettings<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupSettings() {
    return setNodeTemplateNodeGroupSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeGroupStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNodeGroupStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(NodeGroupStubSettings.class))
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

  protected NodeGroupStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addNodesNodeGroupSettings = settingsBuilder.addNodesNodeGroupSettings().build();
    aggregatedListNodeGroupsSettings = settingsBuilder.aggregatedListNodeGroupsSettings().build();
    deleteNodeGroupSettings = settingsBuilder.deleteNodeGroupSettings().build();
    deleteNodesNodeGroupSettings = settingsBuilder.deleteNodesNodeGroupSettings().build();
    getNodeGroupSettings = settingsBuilder.getNodeGroupSettings().build();
    insertNodeGroupSettings = settingsBuilder.insertNodeGroupSettings().build();
    listNodeGroupsSettings = settingsBuilder.listNodeGroupsSettings().build();
    listNodesNodeGroupsSettings = settingsBuilder.listNodesNodeGroupsSettings().build();
    setNodeTemplateNodeGroupSettings = settingsBuilder.setNodeTemplateNodeGroupSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList, NodeGroupsScopedList>
      AGGREGATED_LIST_NODE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
              NodeGroupsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListNodeGroupsHttpRequest injectToken(
                AggregatedListNodeGroupsHttpRequest payload, String token) {
              return AggregatedListNodeGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListNodeGroupsHttpRequest injectPageSize(
                AggregatedListNodeGroupsHttpRequest payload, int pageSize) {
              return AggregatedListNodeGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListNodeGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeGroupAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeGroupsScopedList> extractResources(
                NodeGroupAggregatedList payload) {
              return payload.getItemsMap().values();
            }
          };

  private static final PagedListDescriptor<ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup>
      LIST_NODE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodeGroupsHttpRequest injectToken(
                ListNodeGroupsHttpRequest payload, String token) {
              return ListNodeGroupsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodeGroupsHttpRequest injectPageSize(
                ListNodeGroupsHttpRequest payload, int pageSize) {
              return ListNodeGroupsHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodeGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeGroup> extractResources(NodeGroupList payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, NodeGroupNode>
      LIST_NODES_NODE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, NodeGroupNode>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodesNodeGroupsHttpRequest injectToken(
                ListNodesNodeGroupsHttpRequest payload, String token) {
              return ListNodesNodeGroupsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodesNodeGroupsHttpRequest injectPageSize(
                ListNodesNodeGroupsHttpRequest payload, int pageSize) {
              return ListNodesNodeGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNodesNodeGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeGroupsListNodes payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeGroupNode> extractResources(NodeGroupsListNodes payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
          AggregatedListNodeGroupsPagedResponse>
      AGGREGATED_LIST_NODE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
              AggregatedListNodeGroupsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListNodeGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>
                    callable,
                AggregatedListNodeGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<NodeGroupAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
                      NodeGroupsScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_NODE_GROUPS_PAGE_STR_DESC, request, context);
              return AggregatedListNodeGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>
      LIST_NODE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListNodeGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodeGroupsHttpRequest, NodeGroupList> callable,
                ListNodeGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<NodeGroupList> futureResponse) {
              PageContext<ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup> pageContext =
                  PageContext.create(callable, LIST_NODE_GROUPS_PAGE_STR_DESC, request, context);
              return ListNodeGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, ListNodesNodeGroupsPagedResponse>
      LIST_NODES_NODE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes,
              ListNodesNodeGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListNodesNodeGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes> callable,
                ListNodesNodeGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<NodeGroupsListNodes> futureResponse) {
              PageContext<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, NodeGroupNode>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NODES_NODE_GROUPS_PAGE_STR_DESC, request, context);
              return ListNodesNodeGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for NodeGroupStubSettings. */
  public static class Builder extends StubSettings.Builder<NodeGroupStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<AddNodesNodeGroupHttpRequest, Operation>
        addNodesNodeGroupSettings;
    private final PagedCallSettings.Builder<
            AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
            AggregatedListNodeGroupsPagedResponse>
        aggregatedListNodeGroupsSettings;
    private final UnaryCallSettings.Builder<DeleteNodeGroupHttpRequest, Operation>
        deleteNodeGroupSettings;
    private final UnaryCallSettings.Builder<DeleteNodesNodeGroupHttpRequest, Operation>
        deleteNodesNodeGroupSettings;
    private final UnaryCallSettings.Builder<GetNodeGroupHttpRequest, NodeGroup>
        getNodeGroupSettings;
    private final UnaryCallSettings.Builder<InsertNodeGroupHttpRequest, Operation>
        insertNodeGroupSettings;
    private final PagedCallSettings.Builder<
            ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>
        listNodeGroupsSettings;
    private final PagedCallSettings.Builder<
            ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, ListNodesNodeGroupsPagedResponse>
        listNodesNodeGroupsSettings;
    private final UnaryCallSettings.Builder<SetNodeTemplateNodeGroupHttpRequest, Operation>
        setNodeTemplateNodeGroupSettings;

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

      addNodesNodeGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      aggregatedListNodeGroupsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_NODE_GROUPS_PAGE_STR_FACT);

      deleteNodeGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteNodesNodeGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getNodeGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertNodeGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listNodeGroupsSettings = PagedCallSettings.newBuilder(LIST_NODE_GROUPS_PAGE_STR_FACT);

      listNodesNodeGroupsSettings =
          PagedCallSettings.newBuilder(LIST_NODES_NODE_GROUPS_PAGE_STR_FACT);

      setNodeTemplateNodeGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addNodesNodeGroupSettings,
              aggregatedListNodeGroupsSettings,
              deleteNodeGroupSettings,
              deleteNodesNodeGroupSettings,
              getNodeGroupSettings,
              insertNodeGroupSettings,
              listNodeGroupsSettings,
              listNodesNodeGroupsSettings,
              setNodeTemplateNodeGroupSettings);

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
          .addNodesNodeGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .aggregatedListNodeGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteNodeGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteNodesNodeGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getNodeGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertNodeGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNodeGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNodesNodeGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setNodeTemplateNodeGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(NodeGroupStubSettings settings) {
      super(settings);

      addNodesNodeGroupSettings = settings.addNodesNodeGroupSettings.toBuilder();
      aggregatedListNodeGroupsSettings = settings.aggregatedListNodeGroupsSettings.toBuilder();
      deleteNodeGroupSettings = settings.deleteNodeGroupSettings.toBuilder();
      deleteNodesNodeGroupSettings = settings.deleteNodesNodeGroupSettings.toBuilder();
      getNodeGroupSettings = settings.getNodeGroupSettings.toBuilder();
      insertNodeGroupSettings = settings.insertNodeGroupSettings.toBuilder();
      listNodeGroupsSettings = settings.listNodeGroupsSettings.toBuilder();
      listNodesNodeGroupsSettings = settings.listNodesNodeGroupsSettings.toBuilder();
      setNodeTemplateNodeGroupSettings = settings.setNodeTemplateNodeGroupSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addNodesNodeGroupSettings,
              aggregatedListNodeGroupsSettings,
              deleteNodeGroupSettings,
              deleteNodesNodeGroupSettings,
              getNodeGroupSettings,
              insertNodeGroupSettings,
              listNodeGroupsSettings,
              listNodesNodeGroupsSettings,
              setNodeTemplateNodeGroupSettings);
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

    /** Returns the builder for the settings used for calls to addNodesNodeGroup. */
    public UnaryCallSettings.Builder<AddNodesNodeGroupHttpRequest, Operation>
        addNodesNodeGroupSettings() {
      return addNodesNodeGroupSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedListNodeGroups. */
    public PagedCallSettings.Builder<
            AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList,
            AggregatedListNodeGroupsPagedResponse>
        aggregatedListNodeGroupsSettings() {
      return aggregatedListNodeGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodeGroup. */
    public UnaryCallSettings.Builder<DeleteNodeGroupHttpRequest, Operation>
        deleteNodeGroupSettings() {
      return deleteNodeGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodesNodeGroup. */
    public UnaryCallSettings.Builder<DeleteNodesNodeGroupHttpRequest, Operation>
        deleteNodesNodeGroupSettings() {
      return deleteNodesNodeGroupSettings;
    }

    /** Returns the builder for the settings used for calls to getNodeGroup. */
    public UnaryCallSettings.Builder<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupSettings() {
      return getNodeGroupSettings;
    }

    /** Returns the builder for the settings used for calls to insertNodeGroup. */
    public UnaryCallSettings.Builder<InsertNodeGroupHttpRequest, Operation>
        insertNodeGroupSettings() {
      return insertNodeGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listNodeGroups. */
    public PagedCallSettings.Builder<
            ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>
        listNodeGroupsSettings() {
      return listNodeGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to listNodesNodeGroups. */
    public PagedCallSettings.Builder<
            ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, ListNodesNodeGroupsPagedResponse>
        listNodesNodeGroupsSettings() {
      return listNodesNodeGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to setNodeTemplateNodeGroup. */
    public UnaryCallSettings.Builder<SetNodeTemplateNodeGroupHttpRequest, Operation>
        setNodeTemplateNodeGroupSettings() {
      return setNodeTemplateNodeGroupSettings;
    }

    @Override
    public NodeGroupStubSettings build() throws IOException {
      return new NodeGroupStubSettings(this);
    }
  }
}
