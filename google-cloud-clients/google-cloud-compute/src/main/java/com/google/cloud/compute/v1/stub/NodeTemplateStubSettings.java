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

import static com.google.cloud.compute.v1.NodeTemplateClient.AggregatedListNodeTemplatesPagedResponse;
import static com.google.cloud.compute.v1.NodeTemplateClient.ListNodeTemplatesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListNodeTemplatesHttpRequest;
import com.google.cloud.compute.v1.DeleteNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.GetNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.InsertNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.ListNodeTemplatesHttpRequest;
import com.google.cloud.compute.v1.NodeTemplate;
import com.google.cloud.compute.v1.NodeTemplateAggregatedList;
import com.google.cloud.compute.v1.NodeTemplateList;
import com.google.cloud.compute.v1.NodeTemplatesScopedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeTemplateHttpRequest;
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
 * Settings class to configure an instance of {@link NodeTemplateStub}.
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
 * <p>For example, to set the total timeout of deleteNodeTemplate to 30 seconds:
 *
 * <pre>
 * <code>
 * NodeTemplateStubSettings.Builder nodeTemplateSettingsBuilder =
 *     NodeTemplateStubSettings.newBuilder();
 * nodeTemplateSettingsBuilder.deleteNodeTemplateSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NodeTemplateStubSettings nodeTemplateSettings = nodeTemplateSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeTemplateStubSettings extends StubSettings<NodeTemplateStubSettings> {
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
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          AggregatedListNodeTemplatesPagedResponse>
      aggregatedListNodeTemplatesSettings;
  private final UnaryCallSettings<DeleteNodeTemplateHttpRequest, Operation>
      deleteNodeTemplateSettings;
  private final UnaryCallSettings<GetNodeTemplateHttpRequest, NodeTemplate> getNodeTemplateSettings;
  private final UnaryCallSettings<GetIamPolicyNodeTemplateHttpRequest, Policy>
      getIamPolicyNodeTemplateSettings;
  private final UnaryCallSettings<InsertNodeTemplateHttpRequest, Operation>
      insertNodeTemplateSettings;
  private final PagedCallSettings<
          ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>
      listNodeTemplatesSettings;
  private final UnaryCallSettings<SetIamPolicyNodeTemplateHttpRequest, Policy>
      setIamPolicyNodeTemplateSettings;
  private final UnaryCallSettings<
          TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeTemplateSettings;

  /** Returns the object with the settings used for calls to aggregatedListNodeTemplates. */
  public PagedCallSettings<
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          AggregatedListNodeTemplatesPagedResponse>
      aggregatedListNodeTemplatesSettings() {
    return aggregatedListNodeTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodeTemplate. */
  public UnaryCallSettings<DeleteNodeTemplateHttpRequest, Operation> deleteNodeTemplateSettings() {
    return deleteNodeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getNodeTemplate. */
  public UnaryCallSettings<GetNodeTemplateHttpRequest, NodeTemplate> getNodeTemplateSettings() {
    return getNodeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicyNodeTemplate. */
  public UnaryCallSettings<GetIamPolicyNodeTemplateHttpRequest, Policy>
      getIamPolicyNodeTemplateSettings() {
    return getIamPolicyNodeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to insertNodeTemplate. */
  public UnaryCallSettings<InsertNodeTemplateHttpRequest, Operation> insertNodeTemplateSettings() {
    return insertNodeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listNodeTemplates. */
  public PagedCallSettings<
          ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>
      listNodeTemplatesSettings() {
    return listNodeTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicyNodeTemplate. */
  public UnaryCallSettings<SetIamPolicyNodeTemplateHttpRequest, Policy>
      setIamPolicyNodeTemplateSettings() {
    return setIamPolicyNodeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsNodeTemplate. */
  public UnaryCallSettings<TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeTemplateSettings() {
    return testIamPermissionsNodeTemplateSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeTemplateStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNodeTemplateStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(NodeTemplateStubSettings.class))
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

  protected NodeTemplateStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListNodeTemplatesSettings =
        settingsBuilder.aggregatedListNodeTemplatesSettings().build();
    deleteNodeTemplateSettings = settingsBuilder.deleteNodeTemplateSettings().build();
    getNodeTemplateSettings = settingsBuilder.getNodeTemplateSettings().build();
    getIamPolicyNodeTemplateSettings = settingsBuilder.getIamPolicyNodeTemplateSettings().build();
    insertNodeTemplateSettings = settingsBuilder.insertNodeTemplateSettings().build();
    listNodeTemplatesSettings = settingsBuilder.listNodeTemplatesSettings().build();
    setIamPolicyNodeTemplateSettings = settingsBuilder.setIamPolicyNodeTemplateSettings().build();
    testIamPermissionsNodeTemplateSettings =
        settingsBuilder.testIamPermissionsNodeTemplateSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          NodeTemplatesScopedList>
      AGGREGATED_LIST_NODE_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListNodeTemplatesHttpRequest,
              NodeTemplateAggregatedList,
              NodeTemplatesScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListNodeTemplatesHttpRequest injectToken(
                AggregatedListNodeTemplatesHttpRequest payload, String token) {
              return AggregatedListNodeTemplatesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListNodeTemplatesHttpRequest injectPageSize(
                AggregatedListNodeTemplatesHttpRequest payload, int pageSize) {
              return AggregatedListNodeTemplatesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListNodeTemplatesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeTemplateAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeTemplatesScopedList> extractResources(
                NodeTemplateAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<NodeTemplatesScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate>
      LIST_NODE_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodeTemplatesHttpRequest injectToken(
                ListNodeTemplatesHttpRequest payload, String token) {
              return ListNodeTemplatesHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodeTemplatesHttpRequest injectPageSize(
                ListNodeTemplatesHttpRequest payload, int pageSize) {
              return ListNodeTemplatesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNodeTemplatesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeTemplateList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeTemplate> extractResources(NodeTemplateList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<NodeTemplate>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          AggregatedListNodeTemplatesPagedResponse>
      AGGREGATED_LIST_NODE_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListNodeTemplatesHttpRequest,
              NodeTemplateAggregatedList,
              AggregatedListNodeTemplatesPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListNodeTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>
                    callable,
                AggregatedListNodeTemplatesHttpRequest request,
                ApiCallContext context,
                ApiFuture<NodeTemplateAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListNodeTemplatesHttpRequest,
                      NodeTemplateAggregatedList,
                      NodeTemplatesScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_NODE_TEMPLATES_PAGE_STR_DESC, request, context);
              return AggregatedListNodeTemplatesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>
      LIST_NODE_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListNodeTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodeTemplatesHttpRequest, NodeTemplateList> callable,
                ListNodeTemplatesHttpRequest request,
                ApiCallContext context,
                ApiFuture<NodeTemplateList> futureResponse) {
              PageContext<ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NODE_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListNodeTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for NodeTemplateStubSettings. */
  public static class Builder extends StubSettings.Builder<NodeTemplateStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListNodeTemplatesHttpRequest,
            NodeTemplateAggregatedList,
            AggregatedListNodeTemplatesPagedResponse>
        aggregatedListNodeTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteNodeTemplateHttpRequest, Operation>
        deleteNodeTemplateSettings;
    private final UnaryCallSettings.Builder<GetNodeTemplateHttpRequest, NodeTemplate>
        getNodeTemplateSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyNodeTemplateHttpRequest, Policy>
        getIamPolicyNodeTemplateSettings;
    private final UnaryCallSettings.Builder<InsertNodeTemplateHttpRequest, Operation>
        insertNodeTemplateSettings;
    private final PagedCallSettings.Builder<
            ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>
        listNodeTemplatesSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyNodeTemplateHttpRequest, Policy>
        setIamPolicyNodeTemplateSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
        testIamPermissionsNodeTemplateSettings;

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

      aggregatedListNodeTemplatesSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_NODE_TEMPLATES_PAGE_STR_FACT);

      deleteNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicyNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listNodeTemplatesSettings = PagedCallSettings.newBuilder(LIST_NODE_TEMPLATES_PAGE_STR_FACT);

      setIamPolicyNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsNodeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListNodeTemplatesSettings,
              deleteNodeTemplateSettings,
              getNodeTemplateSettings,
              getIamPolicyNodeTemplateSettings,
              insertNodeTemplateSettings,
              listNodeTemplatesSettings,
              setIamPolicyNodeTemplateSettings,
              testIamPermissionsNodeTemplateSettings);

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
          .aggregatedListNodeTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteNodeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getNodeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicyNodeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertNodeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNodeTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicyNodeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsNodeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(NodeTemplateStubSettings settings) {
      super(settings);

      aggregatedListNodeTemplatesSettings =
          settings.aggregatedListNodeTemplatesSettings.toBuilder();
      deleteNodeTemplateSettings = settings.deleteNodeTemplateSettings.toBuilder();
      getNodeTemplateSettings = settings.getNodeTemplateSettings.toBuilder();
      getIamPolicyNodeTemplateSettings = settings.getIamPolicyNodeTemplateSettings.toBuilder();
      insertNodeTemplateSettings = settings.insertNodeTemplateSettings.toBuilder();
      listNodeTemplatesSettings = settings.listNodeTemplatesSettings.toBuilder();
      setIamPolicyNodeTemplateSettings = settings.setIamPolicyNodeTemplateSettings.toBuilder();
      testIamPermissionsNodeTemplateSettings =
          settings.testIamPermissionsNodeTemplateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListNodeTemplatesSettings,
              deleteNodeTemplateSettings,
              getNodeTemplateSettings,
              getIamPolicyNodeTemplateSettings,
              insertNodeTemplateSettings,
              listNodeTemplatesSettings,
              setIamPolicyNodeTemplateSettings,
              testIamPermissionsNodeTemplateSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListNodeTemplates. */
    public PagedCallSettings.Builder<
            AggregatedListNodeTemplatesHttpRequest,
            NodeTemplateAggregatedList,
            AggregatedListNodeTemplatesPagedResponse>
        aggregatedListNodeTemplatesSettings() {
      return aggregatedListNodeTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodeTemplate. */
    public UnaryCallSettings.Builder<DeleteNodeTemplateHttpRequest, Operation>
        deleteNodeTemplateSettings() {
      return deleteNodeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getNodeTemplate. */
    public UnaryCallSettings.Builder<GetNodeTemplateHttpRequest, NodeTemplate>
        getNodeTemplateSettings() {
      return getNodeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicyNodeTemplate. */
    public UnaryCallSettings.Builder<GetIamPolicyNodeTemplateHttpRequest, Policy>
        getIamPolicyNodeTemplateSettings() {
      return getIamPolicyNodeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to insertNodeTemplate. */
    public UnaryCallSettings.Builder<InsertNodeTemplateHttpRequest, Operation>
        insertNodeTemplateSettings() {
      return insertNodeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listNodeTemplates. */
    public PagedCallSettings.Builder<
            ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>
        listNodeTemplatesSettings() {
      return listNodeTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicyNodeTemplate. */
    public UnaryCallSettings.Builder<SetIamPolicyNodeTemplateHttpRequest, Policy>
        setIamPolicyNodeTemplateSettings() {
      return setIamPolicyNodeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsNodeTemplate. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
        testIamPermissionsNodeTemplateSettings() {
      return testIamPermissionsNodeTemplateSettings;
    }

    @Override
    public NodeTemplateStubSettings build() throws IOException {
      return new NodeTemplateStubSettings(this);
    }
  }
}
