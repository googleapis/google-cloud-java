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

import static com.google.cloud.compute.v1.InstanceGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupsRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupRequest;
import com.google.cloud.compute.v1.GetInstanceGroupRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupList;
import com.google.cloud.compute.v1.InstanceGroupsListInstances;
import com.google.cloud.compute.v1.InstanceGroupsScopedList;
import com.google.cloud.compute.v1.InstanceWithNamedPorts;
import com.google.cloud.compute.v1.ListInstanceGroupsRequest;
import com.google.cloud.compute.v1.ListInstancesInstanceGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.SetNamedPortsInstanceGroupRequest;
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
 * Settings class to configure an instance of {@link InstanceGroupsStub}.
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
 * <p>For example, to set the total timeout of addInstances to 30 seconds:
 *
 * <pre>{@code
 * InstanceGroupsStubSettings.Builder instanceGroupsSettingsBuilder =
 *     InstanceGroupsStubSettings.newBuilder();
 * instanceGroupsSettingsBuilder
 *     .addInstancesSettings()
 *     .setRetrySettings(
 *         instanceGroupsSettingsBuilder
 *             .addInstancesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstanceGroupsStubSettings instanceGroupsSettings = instanceGroupsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstanceGroupsStubSettings extends StubSettings<InstanceGroupsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddInstancesInstanceGroupRequest, Operation> addInstancesSettings;
  private final PagedCallSettings<
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteInstanceGroupRequest, Operation> deleteSettings;
  private final UnaryCallSettings<GetInstanceGroupRequest, InstanceGroup> getSettings;
  private final UnaryCallSettings<InsertInstanceGroupRequest, Operation> insertSettings;
  private final PagedCallSettings<ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListInstancesInstanceGroupsRequest,
          InstanceGroupsListInstances,
          ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesSettings;
  private final UnaryCallSettings<SetNamedPortsInstanceGroupRequest, Operation>
      setNamedPortsSettings;

  private static final PagedListDescriptor<
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          Map.Entry<String, InstanceGroupsScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListInstanceGroupsRequest,
              InstanceGroupAggregatedList,
              Map.Entry<String, InstanceGroupsScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListInstanceGroupsRequest injectToken(
                AggregatedListInstanceGroupsRequest payload, String token) {
              return AggregatedListInstanceGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListInstanceGroupsRequest injectPageSize(
                AggregatedListInstanceGroupsRequest payload, int pageSize) {
              return AggregatedListInstanceGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListInstanceGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceGroupAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, InstanceGroupsScopedList>> extractResources(
                InstanceGroupAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, InstanceGroupsScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstanceGroupsRequest injectToken(
                ListInstanceGroupsRequest payload, String token) {
              return ListInstanceGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstanceGroupsRequest injectPageSize(
                ListInstanceGroupsRequest payload, int pageSize) {
              return ListInstanceGroupsRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstanceGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceGroup> extractResources(InstanceGroupList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<InstanceGroup>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances, InstanceWithNamedPorts>
      LIST_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstancesInstanceGroupsRequest,
              InstanceGroupsListInstances,
              InstanceWithNamedPorts>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesInstanceGroupsRequest injectToken(
                ListInstancesInstanceGroupsRequest payload, String token) {
              return ListInstancesInstanceGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInstancesInstanceGroupsRequest injectPageSize(
                ListInstancesInstanceGroupsRequest payload, int pageSize) {
              return ListInstancesInstanceGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstancesInstanceGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceGroupsListInstances payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceWithNamedPorts> extractResources(
                InstanceGroupsListInstances payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<InstanceWithNamedPorts>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListInstanceGroupsRequest,
              InstanceGroupAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
                    callable,
                AggregatedListInstanceGroupsRequest request,
                ApiCallContext context,
                ApiFuture<InstanceGroupAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListInstanceGroupsRequest,
                      InstanceGroupAggregatedList,
                      Map.Entry<String, InstanceGroupsScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstanceGroupsRequest, InstanceGroupList> callable,
                ListInstanceGroupsRequest request,
                ApiCallContext context,
                ApiFuture<InstanceGroupList> futureResponse) {
              PageContext<ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesInstanceGroupsRequest,
          InstanceGroupsListInstances,
          ListInstancesPagedResponse>
      LIST_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesInstanceGroupsRequest,
              InstanceGroupsListInstances,
              ListInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
                    callable,
                ListInstancesInstanceGroupsRequest request,
                ApiCallContext context,
                ApiFuture<InstanceGroupsListInstances> futureResponse) {
              PageContext<
                      ListInstancesInstanceGroupsRequest,
                      InstanceGroupsListInstances,
                      InstanceWithNamedPorts>
                  pageContext =
                      PageContext.create(callable, LIST_INSTANCES_PAGE_STR_DESC, request, context);
              return ListInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addInstances. */
  public UnaryCallSettings<AddInstancesInstanceGroupRequest, Operation> addInstancesSettings() {
    return addInstancesSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceGroupRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetInstanceGroupRequest, InstanceGroup> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInstanceGroupRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<
          ListInstancesInstanceGroupsRequest,
          InstanceGroupsListInstances,
          ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to removeInstances. */
  public UnaryCallSettings<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesSettings() {
    return removeInstancesSettings;
  }

  /** Returns the object with the settings used for calls to setNamedPorts. */
  public UnaryCallSettings<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsSettings() {
    return setNamedPortsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceGroupsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInstanceGroupsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(InstanceGroupsStubSettings.class))
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

  protected InstanceGroupsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addInstancesSettings = settingsBuilder.addInstancesSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    removeInstancesSettings = settingsBuilder.removeInstancesSettings().build();
    setNamedPortsSettings = settingsBuilder.setNamedPortsSettings().build();
  }

  /** Builder for InstanceGroupsStubSettings. */
  public static class Builder extends StubSettings.Builder<InstanceGroupsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddInstancesInstanceGroupRequest, Operation>
        addInstancesSettings;
    private final PagedCallSettings.Builder<
            AggregatedListInstanceGroupsRequest,
            InstanceGroupAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceGroupRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<GetInstanceGroupRequest, InstanceGroup> getSettings;
    private final UnaryCallSettings.Builder<InsertInstanceGroupRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<
            ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListInstancesInstanceGroupsRequest,
            InstanceGroupsListInstances,
            ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<RemoveInstancesInstanceGroupRequest, Operation>
        removeInstancesSettings;
    private final UnaryCallSettings.Builder<SetNamedPortsInstanceGroupRequest, Operation>
        setNamedPortsSettings;
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

      addInstancesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      removeInstancesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setNamedPortsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addInstancesSettings,
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              listInstancesSettings,
              removeInstancesSettings,
              setNamedPortsSettings);
      initDefaults(this);
    }

    protected Builder(InstanceGroupsStubSettings settings) {
      super(settings);

      addInstancesSettings = settings.addInstancesSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      removeInstancesSettings = settings.removeInstancesSettings.toBuilder();
      setNamedPortsSettings = settings.setNamedPortsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addInstancesSettings,
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              listInstancesSettings,
              removeInstancesSettings,
              setNamedPortsSettings);
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
          .addInstancesSettings()
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
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removeInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setNamedPortsSettings()
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

    /** Returns the builder for the settings used for calls to addInstances. */
    public UnaryCallSettings.Builder<AddInstancesInstanceGroupRequest, Operation>
        addInstancesSettings() {
      return addInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListInstanceGroupsRequest,
            InstanceGroupAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceGroupRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetInstanceGroupRequest, InstanceGroup> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInstanceGroupRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesInstanceGroupsRequest,
            InstanceGroupsListInstances,
            ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to removeInstances. */
    public UnaryCallSettings.Builder<RemoveInstancesInstanceGroupRequest, Operation>
        removeInstancesSettings() {
      return removeInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to setNamedPorts. */
    public UnaryCallSettings.Builder<SetNamedPortsInstanceGroupRequest, Operation>
        setNamedPortsSettings() {
      return setNamedPortsSettings;
    }

    @Override
    public InstanceGroupsStubSettings build() throws IOException {
      return new InstanceGroupsStubSettings(this);
    }
  }
}
