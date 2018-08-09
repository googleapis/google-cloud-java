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

import static com.google.cloud.compute.v1.NodeTypeClient.AggregatedListNodeTypesPagedResponse;
import static com.google.cloud.compute.v1.NodeTypeClient.ListNodeTypesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListNodeTypesHttpRequest;
import com.google.cloud.compute.v1.GetNodeTypeHttpRequest;
import com.google.cloud.compute.v1.ListNodeTypesHttpRequest;
import com.google.cloud.compute.v1.NodeType;
import com.google.cloud.compute.v1.NodeTypeAggregatedList;
import com.google.cloud.compute.v1.NodeTypeList;
import com.google.cloud.compute.v1.NodeTypesScopedList;
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
 * Settings class to configure an instance of {@link NodeTypeStub}.
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
 * example, to set the total timeout of getNodeType to 30 seconds:
 *
 * <pre>
 * <code>
 * NodeTypeStubSettings.Builder nodeTypeSettingsBuilder =
 *     NodeTypeStubSettings.newBuilder();
 * nodeTypeSettingsBuilder.getNodeTypeSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NodeTypeStubSettings nodeTypeSettings = nodeTypeSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeTypeStubSettings extends StubSettings<NodeTypeStubSettings> {
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
          AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList,
          AggregatedListNodeTypesPagedResponse>
      aggregatedListNodeTypesSettings;
  private final UnaryCallSettings<GetNodeTypeHttpRequest, NodeType> getNodeTypeSettings;
  private final PagedCallSettings<
          ListNodeTypesHttpRequest, NodeTypeList, ListNodeTypesPagedResponse>
      listNodeTypesSettings;

  /** Returns the object with the settings used for calls to aggregatedListNodeTypes. */
  public PagedCallSettings<
          AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList,
          AggregatedListNodeTypesPagedResponse>
      aggregatedListNodeTypesSettings() {
    return aggregatedListNodeTypesSettings;
  }

  /** Returns the object with the settings used for calls to getNodeType. */
  public UnaryCallSettings<GetNodeTypeHttpRequest, NodeType> getNodeTypeSettings() {
    return getNodeTypeSettings;
  }

  /** Returns the object with the settings used for calls to listNodeTypes. */
  public PagedCallSettings<ListNodeTypesHttpRequest, NodeTypeList, ListNodeTypesPagedResponse>
      listNodeTypesSettings() {
    return listNodeTypesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeTypeStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNodeTypeStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(NodeTypeStubSettings.class))
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

  protected NodeTypeStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListNodeTypesSettings = settingsBuilder.aggregatedListNodeTypesSettings().build();
    getNodeTypeSettings = settingsBuilder.getNodeTypeSettings().build();
    listNodeTypesSettings = settingsBuilder.listNodeTypesSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList, NodeTypesScopedList>
      AGGREGATED_LIST_NODE_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList, NodeTypesScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListNodeTypesHttpRequest injectToken(
                AggregatedListNodeTypesHttpRequest payload, String token) {
              return AggregatedListNodeTypesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListNodeTypesHttpRequest injectPageSize(
                AggregatedListNodeTypesHttpRequest payload, int pageSize) {
              return AggregatedListNodeTypesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListNodeTypesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeTypeAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeTypesScopedList> extractResources(NodeTypeAggregatedList payload) {
              return payload.getItemsMap().values();
            }
          };

  private static final PagedListDescriptor<ListNodeTypesHttpRequest, NodeTypeList, NodeType>
      LIST_NODE_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodeTypesHttpRequest, NodeTypeList, NodeType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodeTypesHttpRequest injectToken(
                ListNodeTypesHttpRequest payload, String token) {
              return ListNodeTypesHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodeTypesHttpRequest injectPageSize(
                ListNodeTypesHttpRequest payload, int pageSize) {
              return ListNodeTypesHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodeTypesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NodeTypeList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeType> extractResources(NodeTypeList payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList,
          AggregatedListNodeTypesPagedResponse>
      AGGREGATED_LIST_NODE_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList,
              AggregatedListNodeTypesPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListNodeTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList> callable,
                AggregatedListNodeTypesHttpRequest request,
                ApiCallContext context,
                ApiFuture<NodeTypeAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList,
                      NodeTypesScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_NODE_TYPES_PAGE_STR_DESC, request, context);
              return AggregatedListNodeTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodeTypesHttpRequest, NodeTypeList, ListNodeTypesPagedResponse>
      LIST_NODE_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodeTypesHttpRequest, NodeTypeList, ListNodeTypesPagedResponse>() {
            @Override
            public ApiFuture<ListNodeTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodeTypesHttpRequest, NodeTypeList> callable,
                ListNodeTypesHttpRequest request,
                ApiCallContext context,
                ApiFuture<NodeTypeList> futureResponse) {
              PageContext<ListNodeTypesHttpRequest, NodeTypeList, NodeType> pageContext =
                  PageContext.create(callable, LIST_NODE_TYPES_PAGE_STR_DESC, request, context);
              return ListNodeTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for NodeTypeStubSettings. */
  public static class Builder extends StubSettings.Builder<NodeTypeStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList,
            AggregatedListNodeTypesPagedResponse>
        aggregatedListNodeTypesSettings;
    private final UnaryCallSettings.Builder<GetNodeTypeHttpRequest, NodeType> getNodeTypeSettings;
    private final PagedCallSettings.Builder<
            ListNodeTypesHttpRequest, NodeTypeList, ListNodeTypesPagedResponse>
        listNodeTypesSettings;

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

      aggregatedListNodeTypesSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_NODE_TYPES_PAGE_STR_FACT);

      getNodeTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listNodeTypesSettings = PagedCallSettings.newBuilder(LIST_NODE_TYPES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListNodeTypesSettings, getNodeTypeSettings, listNodeTypesSettings);

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
          .aggregatedListNodeTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getNodeTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNodeTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(NodeTypeStubSettings settings) {
      super(settings);

      aggregatedListNodeTypesSettings = settings.aggregatedListNodeTypesSettings.toBuilder();
      getNodeTypeSettings = settings.getNodeTypeSettings.toBuilder();
      listNodeTypesSettings = settings.listNodeTypesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListNodeTypesSettings, getNodeTypeSettings, listNodeTypesSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListNodeTypes. */
    public PagedCallSettings.Builder<
            AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList,
            AggregatedListNodeTypesPagedResponse>
        aggregatedListNodeTypesSettings() {
      return aggregatedListNodeTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getNodeType. */
    public UnaryCallSettings.Builder<GetNodeTypeHttpRequest, NodeType> getNodeTypeSettings() {
      return getNodeTypeSettings;
    }

    /** Returns the builder for the settings used for calls to listNodeTypes. */
    public PagedCallSettings.Builder<
            ListNodeTypesHttpRequest, NodeTypeList, ListNodeTypesPagedResponse>
        listNodeTypesSettings() {
      return listNodeTypesSettings;
    }

    @Override
    public NodeTypeStubSettings build() throws IOException {
      return new NodeTypeStubSettings(this);
    }
  }
}
