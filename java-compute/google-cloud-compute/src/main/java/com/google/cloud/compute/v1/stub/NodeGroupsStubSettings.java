/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.compute.v1.NodeGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupsClient.ListNodesPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddNodesNodeGroupRequest;
import com.google.cloud.compute.v1.AggregatedListNodeGroupsRequest;
import com.google.cloud.compute.v1.DeleteNodeGroupRequest;
import com.google.cloud.compute.v1.DeleteNodesNodeGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeGroupRequest;
import com.google.cloud.compute.v1.GetNodeGroupRequest;
import com.google.cloud.compute.v1.InsertNodeGroupRequest;
import com.google.cloud.compute.v1.ListNodeGroupsRequest;
import com.google.cloud.compute.v1.ListNodesNodeGroupsRequest;
import com.google.cloud.compute.v1.NodeGroup;
import com.google.cloud.compute.v1.NodeGroupAggregatedList;
import com.google.cloud.compute.v1.NodeGroupList;
import com.google.cloud.compute.v1.NodeGroupNode;
import com.google.cloud.compute.v1.NodeGroupsListNodes;
import com.google.cloud.compute.v1.NodeGroupsScopedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNodeGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyNodeGroupRequest;
import com.google.cloud.compute.v1.SetNodeTemplateNodeGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeGroupRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NodeGroupsStub}.
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
 * <p>For example, to set the total timeout of addNodes to 30 seconds:
 *
 * <pre>{@code
 * NodeGroupsStubSettings.Builder nodeGroupsSettingsBuilder = NodeGroupsStubSettings.newBuilder();
 * nodeGroupsSettingsBuilder
 *     .addNodesSettings()
 *     .setRetrySettings(
 *         nodeGroupsSettingsBuilder
 *             .addNodesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NodeGroupsStubSettings nodeGroupsSettings = nodeGroupsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NodeGroupsStubSettings extends StubSettings<NodeGroupsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddNodesNodeGroupRequest, Operation> addNodesSettings;
  private final PagedCallSettings<
          AggregatedListNodeGroupsRequest, NodeGroupAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteNodeGroupRequest, Operation> deleteSettings;
  private final UnaryCallSettings<DeleteNodesNodeGroupRequest, Operation> deleteNodesSettings;
  private final UnaryCallSettings<GetNodeGroupRequest, NodeGroup> getSettings;
  private final UnaryCallSettings<GetIamPolicyNodeGroupRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<InsertNodeGroupRequest, Operation> insertSettings;
  private final PagedCallSettings<ListNodeGroupsRequest, NodeGroupList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>
      listNodesSettings;
  private final UnaryCallSettings<PatchNodeGroupRequest, Operation> patchSettings;
  private final UnaryCallSettings<SetIamPolicyNodeGroupRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetNodeTemplateNodeGroupRequest, Operation>
      setNodeTemplateSettings;
  private final UnaryCallSettings<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          AggregatedListNodeGroupsRequest,
          NodeGroupAggregatedList,
          Map.Entry<String, NodeGroupsScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListNodeGroupsRequest,
              NodeGroupAggregatedList,
              Map.Entry<String, NodeGroupsScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListNodeGroupsRequest injectToken(
                AggregatedListNodeGroupsRequest payload, String token) {
              return AggregatedListNodeGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListNodeGroupsRequest injectPageSize(
                AggregatedListNodeGroupsRequest payload, int pageSize) {
              return AggregatedListNodeGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListNodeGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeGroupAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, NodeGroupsScopedList>> extractResources(
                NodeGroupAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, NodeGroupsScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<ListNodeGroupsRequest, NodeGroupList, NodeGroup>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodeGroupsRequest, NodeGroupList, NodeGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodeGroupsRequest injectToken(ListNodeGroupsRequest payload, String token) {
              return ListNodeGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodeGroupsRequest injectPageSize(
                ListNodeGroupsRequest payload, int pageSize) {
              return ListNodeGroupsRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodeGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeGroup> extractResources(NodeGroupList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<NodeGroup>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode>
      LIST_NODES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodesNodeGroupsRequest injectToken(
                ListNodesNodeGroupsRequest payload, String token) {
              return ListNodesNodeGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodesNodeGroupsRequest injectPageSize(
                ListNodesNodeGroupsRequest payload, int pageSize) {
              return ListNodesNodeGroupsRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodesNodeGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeGroupsListNodes payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeGroupNode> extractResources(NodeGroupsListNodes payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<NodeGroupNode>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListNodeGroupsRequest, NodeGroupAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListNodeGroupsRequest,
              NodeGroupAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList> callable,
                AggregatedListNodeGroupsRequest request,
                ApiCallContext context,
                ApiFuture<NodeGroupAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListNodeGroupsRequest,
                      NodeGroupAggregatedList,
                      Map.Entry<String, NodeGroupsScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodeGroupsRequest, NodeGroupList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListNodeGroupsRequest, NodeGroupList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodeGroupsRequest, NodeGroupList> callable,
                ListNodeGroupsRequest request,
                ApiCallContext context,
                ApiFuture<NodeGroupList> futureResponse) {
              PageContext<ListNodeGroupsRequest, NodeGroupList, NodeGroup> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>
      LIST_NODES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>() {
            @Override
            public ApiFuture<ListNodesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodesNodeGroupsRequest, NodeGroupsListNodes> callable,
                ListNodesNodeGroupsRequest request,
                ApiCallContext context,
                ApiFuture<NodeGroupsListNodes> futureResponse) {
              PageContext<ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode>
                  pageContext =
                      PageContext.create(callable, LIST_NODES_PAGE_STR_DESC, request, context);
              return ListNodesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addNodes. */
  public UnaryCallSettings<AddNodesNodeGroupRequest, Operation> addNodesSettings() {
    return addNodesSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListNodeGroupsRequest, NodeGroupAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNodeGroupRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodes. */
  public UnaryCallSettings<DeleteNodesNodeGroupRequest, Operation> deleteNodesSettings() {
    return deleteNodesSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNodeGroupRequest, NodeGroup> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyNodeGroupRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNodeGroupRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListNodeGroupsRequest, NodeGroupList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listNodes. */
  public PagedCallSettings<ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>
      listNodesSettings() {
    return listNodesSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchNodeGroupRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyNodeGroupRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setNodeTemplate. */
  public UnaryCallSettings<SetNodeTemplateNodeGroupRequest, Operation> setNodeTemplateSettings() {
    return setNodeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeGroupsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNodeGroupsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(NodeGroupsStubSettings.class))
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

  protected NodeGroupsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addNodesSettings = settingsBuilder.addNodesSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteNodesSettings = settingsBuilder.deleteNodesSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listNodesSettings = settingsBuilder.listNodesSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setNodeTemplateSettings = settingsBuilder.setNodeTemplateSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for NodeGroupsStubSettings. */
  public static class Builder extends StubSettings.Builder<NodeGroupsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddNodesNodeGroupRequest, Operation> addNodesSettings;
    private final PagedCallSettings.Builder<
            AggregatedListNodeGroupsRequest, NodeGroupAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteNodeGroupRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<DeleteNodesNodeGroupRequest, Operation>
        deleteNodesSettings;
    private final UnaryCallSettings.Builder<GetNodeGroupRequest, NodeGroup> getSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyNodeGroupRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<InsertNodeGroupRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<ListNodeGroupsRequest, NodeGroupList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>
        listNodesSettings;
    private final UnaryCallSettings.Builder<PatchNodeGroupRequest, Operation> patchSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyNodeGroupRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetNodeTemplateNodeGroupRequest, Operation>
        setNodeTemplateSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
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

      addNodesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNodesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listNodesSettings = PagedCallSettings.newBuilder(LIST_NODES_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addNodesSettings,
              aggregatedListSettings,
              deleteSettings,
              deleteNodesSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listNodesSettings,
              patchSettings,
              setIamPolicySettings,
              setNodeTemplateSettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(NodeGroupsStubSettings settings) {
      super(settings);

      addNodesSettings = settings.addNodesSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteNodesSettings = settings.deleteNodesSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listNodesSettings = settings.listNodesSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setNodeTemplateSettings = settings.setNodeTemplateSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addNodesSettings,
              aggregatedListSettings,
              deleteSettings,
              deleteNodesSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listNodesSettings,
              patchSettings,
              setIamPolicySettings,
              setNodeTemplateSettings,
              testIamPermissionsSettings);
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
          .addNodesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteNodesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
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
          .listNodesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setNodeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to addNodes. */
    public UnaryCallSettings.Builder<AddNodesNodeGroupRequest, Operation> addNodesSettings() {
      return addNodesSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListNodeGroupsRequest, NodeGroupAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNodeGroupRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodes. */
    public UnaryCallSettings.Builder<DeleteNodesNodeGroupRequest, Operation> deleteNodesSettings() {
      return deleteNodesSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetNodeGroupRequest, NodeGroup> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyNodeGroupRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNodeGroupRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListNodeGroupsRequest, NodeGroupList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listNodes. */
    public PagedCallSettings.Builder<
            ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>
        listNodesSettings() {
      return listNodesSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchNodeGroupRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyNodeGroupRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setNodeTemplate. */
    public UnaryCallSettings.Builder<SetNodeTemplateNodeGroupRequest, Operation>
        setNodeTemplateSettings() {
      return setNodeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public NodeGroupsStubSettings build() throws IOException {
      return new NodeGroupsStubSettings(this);
    }
  }
}
