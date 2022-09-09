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
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NodeGroupsStubSettings.Builder nodeGroupsSettingsBuilder = NodeGroupsStubSettings.newBuilder();
 * nodeGroupsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         nodeGroupsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
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
  private final OperationCallSettings<AddNodesNodeGroupRequest, Operation, Operation>
      addNodesOperationSettings;
  private final PagedCallSettings<
          AggregatedListNodeGroupsRequest, NodeGroupAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteNodeGroupRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteNodeGroupRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<DeleteNodesNodeGroupRequest, Operation> deleteNodesSettings;
  private final OperationCallSettings<DeleteNodesNodeGroupRequest, Operation, Operation>
      deleteNodesOperationSettings;
  private final UnaryCallSettings<GetNodeGroupRequest, NodeGroup> getSettings;
  private final UnaryCallSettings<GetIamPolicyNodeGroupRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<InsertNodeGroupRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertNodeGroupRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListNodeGroupsRequest, NodeGroupList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>
      listNodesSettings;
  private final UnaryCallSettings<PatchNodeGroupRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchNodeGroupRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<SetIamPolicyNodeGroupRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetNodeTemplateNodeGroupRequest, Operation>
      setNodeTemplateSettings;
  private final OperationCallSettings<SetNodeTemplateNodeGroupRequest, Operation, Operation>
      setNodeTemplateOperationSettings;
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

  /** Returns the object with the settings used for calls to addNodes. */
  public OperationCallSettings<AddNodesNodeGroupRequest, Operation, Operation>
      addNodesOperationSettings() {
    return addNodesOperationSettings;
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

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteNodeGroupRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodes. */
  public UnaryCallSettings<DeleteNodesNodeGroupRequest, Operation> deleteNodesSettings() {
    return deleteNodesSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodes. */
  public OperationCallSettings<DeleteNodesNodeGroupRequest, Operation, Operation>
      deleteNodesOperationSettings() {
    return deleteNodesOperationSettings;
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

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertNodeGroupRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
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

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchNodeGroupRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyNodeGroupRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setNodeTemplate. */
  public UnaryCallSettings<SetNodeTemplateNodeGroupRequest, Operation> setNodeTemplateSettings() {
    return setNodeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to setNodeTemplate. */
  public OperationCallSettings<SetNodeTemplateNodeGroupRequest, Operation, Operation>
      setNodeTemplateOperationSettings() {
    return setNodeTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

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
    addNodesOperationSettings = settingsBuilder.addNodesOperationSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    deleteNodesSettings = settingsBuilder.deleteNodesSettings().build();
    deleteNodesOperationSettings = settingsBuilder.deleteNodesOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listNodesSettings = settingsBuilder.listNodesSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setNodeTemplateSettings = settingsBuilder.setNodeTemplateSettings().build();
    setNodeTemplateOperationSettings = settingsBuilder.setNodeTemplateOperationSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for NodeGroupsStubSettings. */
  public static class Builder extends StubSettings.Builder<NodeGroupsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddNodesNodeGroupRequest, Operation> addNodesSettings;
    private final OperationCallSettings.Builder<AddNodesNodeGroupRequest, Operation, Operation>
        addNodesOperationSettings;
    private final PagedCallSettings.Builder<
            AggregatedListNodeGroupsRequest, NodeGroupAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteNodeGroupRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteNodeGroupRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNodesNodeGroupRequest, Operation>
        deleteNodesSettings;
    private final OperationCallSettings.Builder<DeleteNodesNodeGroupRequest, Operation, Operation>
        deleteNodesOperationSettings;
    private final UnaryCallSettings.Builder<GetNodeGroupRequest, NodeGroup> getSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyNodeGroupRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<InsertNodeGroupRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertNodeGroupRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<ListNodeGroupsRequest, NodeGroupList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListNodesNodeGroupsRequest, NodeGroupsListNodes, ListNodesPagedResponse>
        listNodesSettings;
    private final UnaryCallSettings.Builder<PatchNodeGroupRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchNodeGroupRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyNodeGroupRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetNodeTemplateNodeGroupRequest, Operation>
        setNodeTemplateSettings;
    private final OperationCallSettings.Builder<
            SetNodeTemplateNodeGroupRequest, Operation, Operation>
        setNodeTemplateOperationSettings;
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
      addNodesOperationSettings = OperationCallSettings.newBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      deleteNodesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNodesOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listNodesSettings = PagedCallSettings.newBuilder(LIST_NODES_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setNodeTemplateOperationSettings = OperationCallSettings.newBuilder();
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
      addNodesOperationSettings = settings.addNodesOperationSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      deleteNodesSettings = settings.deleteNodesSettings.toBuilder();
      deleteNodesOperationSettings = settings.deleteNodesOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listNodesSettings = settings.listNodesSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setNodeTemplateSettings = settings.setNodeTemplateSettings.toBuilder();
      setNodeTemplateOperationSettings = settings.setNodeTemplateOperationSettings.toBuilder();
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

      builder
          .addNodesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddNodesNodeGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                  .<DeleteNodeGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .deleteNodesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNodesNodeGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                  .<InsertNodeGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchNodeGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .setNodeTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetNodeTemplateNodeGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to addNodes. */
    public UnaryCallSettings.Builder<AddNodesNodeGroupRequest, Operation> addNodesSettings() {
      return addNodesSettings;
    }

    /** Returns the builder for the settings used for calls to addNodes. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AddNodesNodeGroupRequest, Operation, Operation>
        addNodesOperationSettings() {
      return addNodesOperationSettings;
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

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteNodeGroupRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodes. */
    public UnaryCallSettings.Builder<DeleteNodesNodeGroupRequest, Operation> deleteNodesSettings() {
      return deleteNodesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodes. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteNodesNodeGroupRequest, Operation, Operation>
        deleteNodesOperationSettings() {
      return deleteNodesOperationSettings;
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

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertNodeGroupRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
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

    /** Returns the builder for the settings used for calls to patch. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<PatchNodeGroupRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
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

    /** Returns the builder for the settings used for calls to setNodeTemplate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetNodeTemplateNodeGroupRequest, Operation, Operation>
        setNodeTemplateOperationSettings() {
      return setNodeTemplateOperationSettings;
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
