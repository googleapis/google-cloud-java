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

import static com.google.cloud.compute.v1.InstanceGroupClient.AggregatedListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstancesInstanceGroupsPagedResponse;

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
import com.google.cloud.compute.v1.AddInstancesInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.GetInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupList;
import com.google.cloud.compute.v1.InstanceGroupsListInstances;
import com.google.cloud.compute.v1.InstanceGroupsScopedList;
import com.google.cloud.compute.v1.InstanceWithNamedPorts;
import com.google.cloud.compute.v1.ListInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.ListInstancesInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveInstancesInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.SetNamedPortsInstanceGroupHttpRequest;
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
 * Settings class to configure an instance of {@link InstanceGroupStub}.
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
 * example, to set the total timeout of addInstancesInstanceGroup to 30 seconds:
 *
 * <pre>
 * <code>
 * InstanceGroupStubSettings.Builder instanceGroupSettingsBuilder =
 *     InstanceGroupStubSettings.newBuilder();
 * instanceGroupSettingsBuilder.addInstancesInstanceGroupSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * InstanceGroupStubSettings instanceGroupSettings = instanceGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupStubSettings extends StubSettings<InstanceGroupStubSettings> {
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

  private final UnaryCallSettings<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupSettings;
  private final PagedCallSettings<
          AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
          AggregatedListInstanceGroupsPagedResponse>
      aggregatedListInstanceGroupsSettings;
  private final UnaryCallSettings<DeleteInstanceGroupHttpRequest, Operation>
      deleteInstanceGroupSettings;
  private final UnaryCallSettings<GetInstanceGroupHttpRequest, InstanceGroup>
      getInstanceGroupSettings;
  private final UnaryCallSettings<InsertInstanceGroupHttpRequest, Operation>
      insertInstanceGroupSettings;
  private final PagedCallSettings<
          ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>
      listInstanceGroupsSettings;
  private final PagedCallSettings<
          ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
          ListInstancesInstanceGroupsPagedResponse>
      listInstancesInstanceGroupsSettings;
  private final UnaryCallSettings<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupSettings;
  private final UnaryCallSettings<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupSettings;

  /** Returns the object with the settings used for calls to addInstancesInstanceGroup. */
  public UnaryCallSettings<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupSettings() {
    return addInstancesInstanceGroupSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedListInstanceGroups. */
  public PagedCallSettings<
          AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
          AggregatedListInstanceGroupsPagedResponse>
      aggregatedListInstanceGroupsSettings() {
    return aggregatedListInstanceGroupsSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstanceGroup. */
  public UnaryCallSettings<DeleteInstanceGroupHttpRequest, Operation>
      deleteInstanceGroupSettings() {
    return deleteInstanceGroupSettings;
  }

  /** Returns the object with the settings used for calls to getInstanceGroup. */
  public UnaryCallSettings<GetInstanceGroupHttpRequest, InstanceGroup> getInstanceGroupSettings() {
    return getInstanceGroupSettings;
  }

  /** Returns the object with the settings used for calls to insertInstanceGroup. */
  public UnaryCallSettings<InsertInstanceGroupHttpRequest, Operation>
      insertInstanceGroupSettings() {
    return insertInstanceGroupSettings;
  }

  /** Returns the object with the settings used for calls to listInstanceGroups. */
  public PagedCallSettings<
          ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>
      listInstanceGroupsSettings() {
    return listInstanceGroupsSettings;
  }

  /** Returns the object with the settings used for calls to listInstancesInstanceGroups. */
  public PagedCallSettings<
          ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
          ListInstancesInstanceGroupsPagedResponse>
      listInstancesInstanceGroupsSettings() {
    return listInstancesInstanceGroupsSettings;
  }

  /** Returns the object with the settings used for calls to removeInstancesInstanceGroup. */
  public UnaryCallSettings<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupSettings() {
    return removeInstancesInstanceGroupSettings;
  }

  /** Returns the object with the settings used for calls to setNamedPortsInstanceGroup. */
  public UnaryCallSettings<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupSettings() {
    return setNamedPortsInstanceGroupSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceGroupStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInstanceGroupStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(InstanceGroupStubSettings.class))
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

  protected InstanceGroupStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addInstancesInstanceGroupSettings = settingsBuilder.addInstancesInstanceGroupSettings().build();
    aggregatedListInstanceGroupsSettings =
        settingsBuilder.aggregatedListInstanceGroupsSettings().build();
    deleteInstanceGroupSettings = settingsBuilder.deleteInstanceGroupSettings().build();
    getInstanceGroupSettings = settingsBuilder.getInstanceGroupSettings().build();
    insertInstanceGroupSettings = settingsBuilder.insertInstanceGroupSettings().build();
    listInstanceGroupsSettings = settingsBuilder.listInstanceGroupsSettings().build();
    listInstancesInstanceGroupsSettings =
        settingsBuilder.listInstancesInstanceGroupsSettings().build();
    removeInstancesInstanceGroupSettings =
        settingsBuilder.removeInstancesInstanceGroupSettings().build();
    setNamedPortsInstanceGroupSettings =
        settingsBuilder.setNamedPortsInstanceGroupSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
          InstanceGroupsScopedList>
      AGGREGATED_LIST_INSTANCE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
              InstanceGroupsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListInstanceGroupsHttpRequest injectToken(
                AggregatedListInstanceGroupsHttpRequest payload, String token) {
              return AggregatedListInstanceGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListInstanceGroupsHttpRequest injectPageSize(
                AggregatedListInstanceGroupsHttpRequest payload, int pageSize) {
              return AggregatedListInstanceGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListInstanceGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceGroupAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceGroupsScopedList> extractResources(
                InstanceGroupAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<InstanceGroupsScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup>
      LIST_INSTANCE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstanceGroupsHttpRequest injectToken(
                ListInstanceGroupsHttpRequest payload, String token) {
              return ListInstanceGroupsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstanceGroupsHttpRequest injectPageSize(
                ListInstanceGroupsHttpRequest payload, int pageSize) {
              return ListInstanceGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstanceGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceGroup> extractResources(InstanceGroupList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<InstanceGroup>of();
            }
          };

  private static final PagedListDescriptor<
          ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
          InstanceWithNamedPorts>
      LIST_INSTANCES_INSTANCE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
              InstanceWithNamedPorts>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesInstanceGroupsHttpRequest injectToken(
                ListInstancesInstanceGroupsHttpRequest payload, String token) {
              return ListInstancesInstanceGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInstancesInstanceGroupsHttpRequest injectPageSize(
                ListInstancesInstanceGroupsHttpRequest payload, int pageSize) {
              return ListInstancesInstanceGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstancesInstanceGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceGroupsListInstances payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceWithNamedPorts> extractResources(
                InstanceGroupsListInstances payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<InstanceWithNamedPorts>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
          AggregatedListInstanceGroupsPagedResponse>
      AGGREGATED_LIST_INSTANCE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
              AggregatedListInstanceGroupsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListInstanceGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>
                    callable,
                AggregatedListInstanceGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<InstanceGroupAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
                      InstanceGroupsScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_INSTANCE_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListInstanceGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>
      LIST_INSTANCE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListInstanceGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstanceGroupsHttpRequest, InstanceGroupList> callable,
                ListInstanceGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<InstanceGroupList> futureResponse) {
              PageContext<ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSTANCE_GROUPS_PAGE_STR_DESC, request, context);
              return ListInstanceGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
          ListInstancesInstanceGroupsPagedResponse>
      LIST_INSTANCES_INSTANCE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
              ListInstancesInstanceGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesInstanceGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>
                    callable,
                ListInstancesInstanceGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<InstanceGroupsListInstances> futureResponse) {
              PageContext<
                      ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
                      InstanceWithNamedPorts>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSTANCES_INSTANCE_GROUPS_PAGE_STR_DESC, request, context);
              return ListInstancesInstanceGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for InstanceGroupStubSettings. */
  public static class Builder extends StubSettings.Builder<InstanceGroupStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<AddInstancesInstanceGroupHttpRequest, Operation>
        addInstancesInstanceGroupSettings;
    private final PagedCallSettings.Builder<
            AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
            AggregatedListInstanceGroupsPagedResponse>
        aggregatedListInstanceGroupsSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceGroupHttpRequest, Operation>
        deleteInstanceGroupSettings;
    private final UnaryCallSettings.Builder<GetInstanceGroupHttpRequest, InstanceGroup>
        getInstanceGroupSettings;
    private final UnaryCallSettings.Builder<InsertInstanceGroupHttpRequest, Operation>
        insertInstanceGroupSettings;
    private final PagedCallSettings.Builder<
            ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>
        listInstanceGroupsSettings;
    private final PagedCallSettings.Builder<
            ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
            ListInstancesInstanceGroupsPagedResponse>
        listInstancesInstanceGroupsSettings;
    private final UnaryCallSettings.Builder<RemoveInstancesInstanceGroupHttpRequest, Operation>
        removeInstancesInstanceGroupSettings;
    private final UnaryCallSettings.Builder<SetNamedPortsInstanceGroupHttpRequest, Operation>
        setNamedPortsInstanceGroupSettings;

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

      addInstancesInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      aggregatedListInstanceGroupsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_INSTANCE_GROUPS_PAGE_STR_FACT);

      deleteInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listInstanceGroupsSettings = PagedCallSettings.newBuilder(LIST_INSTANCE_GROUPS_PAGE_STR_FACT);

      listInstancesInstanceGroupsSettings =
          PagedCallSettings.newBuilder(LIST_INSTANCES_INSTANCE_GROUPS_PAGE_STR_FACT);

      removeInstancesInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setNamedPortsInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addInstancesInstanceGroupSettings,
              aggregatedListInstanceGroupsSettings,
              deleteInstanceGroupSettings,
              getInstanceGroupSettings,
              insertInstanceGroupSettings,
              listInstanceGroupsSettings,
              listInstancesInstanceGroupsSettings,
              removeInstancesInstanceGroupSettings,
              setNamedPortsInstanceGroupSettings);

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
          .addInstancesInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .aggregatedListInstanceGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInstanceGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInstancesInstanceGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .removeInstancesInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setNamedPortsInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(InstanceGroupStubSettings settings) {
      super(settings);

      addInstancesInstanceGroupSettings = settings.addInstancesInstanceGroupSettings.toBuilder();
      aggregatedListInstanceGroupsSettings =
          settings.aggregatedListInstanceGroupsSettings.toBuilder();
      deleteInstanceGroupSettings = settings.deleteInstanceGroupSettings.toBuilder();
      getInstanceGroupSettings = settings.getInstanceGroupSettings.toBuilder();
      insertInstanceGroupSettings = settings.insertInstanceGroupSettings.toBuilder();
      listInstanceGroupsSettings = settings.listInstanceGroupsSettings.toBuilder();
      listInstancesInstanceGroupsSettings =
          settings.listInstancesInstanceGroupsSettings.toBuilder();
      removeInstancesInstanceGroupSettings =
          settings.removeInstancesInstanceGroupSettings.toBuilder();
      setNamedPortsInstanceGroupSettings = settings.setNamedPortsInstanceGroupSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addInstancesInstanceGroupSettings,
              aggregatedListInstanceGroupsSettings,
              deleteInstanceGroupSettings,
              getInstanceGroupSettings,
              insertInstanceGroupSettings,
              listInstanceGroupsSettings,
              listInstancesInstanceGroupsSettings,
              removeInstancesInstanceGroupSettings,
              setNamedPortsInstanceGroupSettings);
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

    /** Returns the builder for the settings used for calls to addInstancesInstanceGroup. */
    public UnaryCallSettings.Builder<AddInstancesInstanceGroupHttpRequest, Operation>
        addInstancesInstanceGroupSettings() {
      return addInstancesInstanceGroupSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedListInstanceGroups. */
    public PagedCallSettings.Builder<
            AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList,
            AggregatedListInstanceGroupsPagedResponse>
        aggregatedListInstanceGroupsSettings() {
      return aggregatedListInstanceGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstanceGroup. */
    public UnaryCallSettings.Builder<DeleteInstanceGroupHttpRequest, Operation>
        deleteInstanceGroupSettings() {
      return deleteInstanceGroupSettings;
    }

    /** Returns the builder for the settings used for calls to getInstanceGroup. */
    public UnaryCallSettings.Builder<GetInstanceGroupHttpRequest, InstanceGroup>
        getInstanceGroupSettings() {
      return getInstanceGroupSettings;
    }

    /** Returns the builder for the settings used for calls to insertInstanceGroup. */
    public UnaryCallSettings.Builder<InsertInstanceGroupHttpRequest, Operation>
        insertInstanceGroupSettings() {
      return insertInstanceGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listInstanceGroups. */
    public PagedCallSettings.Builder<
            ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>
        listInstanceGroupsSettings() {
      return listInstanceGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to listInstancesInstanceGroups. */
    public PagedCallSettings.Builder<
            ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances,
            ListInstancesInstanceGroupsPagedResponse>
        listInstancesInstanceGroupsSettings() {
      return listInstancesInstanceGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to removeInstancesInstanceGroup. */
    public UnaryCallSettings.Builder<RemoveInstancesInstanceGroupHttpRequest, Operation>
        removeInstancesInstanceGroupSettings() {
      return removeInstancesInstanceGroupSettings;
    }

    /** Returns the builder for the settings used for calls to setNamedPortsInstanceGroup. */
    public UnaryCallSettings.Builder<SetNamedPortsInstanceGroupHttpRequest, Operation>
        setNamedPortsInstanceGroupSettings() {
      return setNamedPortsInstanceGroupSettings;
    }

    @Override
    public InstanceGroupStubSettings build() throws IOException {
      return new InstanceGroupStubSettings(this);
    }
  }
}
