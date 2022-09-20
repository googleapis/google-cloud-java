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

import static com.google.cloud.compute.v1.VpnTunnelsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.VpnTunnelsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListVpnTunnelsRequest;
import com.google.cloud.compute.v1.DeleteVpnTunnelRequest;
import com.google.cloud.compute.v1.GetVpnTunnelRequest;
import com.google.cloud.compute.v1.InsertVpnTunnelRequest;
import com.google.cloud.compute.v1.ListVpnTunnelsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsVpnTunnelRequest;
import com.google.cloud.compute.v1.VpnTunnel;
import com.google.cloud.compute.v1.VpnTunnelAggregatedList;
import com.google.cloud.compute.v1.VpnTunnelList;
import com.google.cloud.compute.v1.VpnTunnelsScopedList;
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
 * Settings class to configure an instance of {@link VpnTunnelsStub}.
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
 * VpnTunnelsStubSettings.Builder vpnTunnelsSettingsBuilder = VpnTunnelsStubSettings.newBuilder();
 * vpnTunnelsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         vpnTunnelsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VpnTunnelsStubSettings vpnTunnelsSettings = vpnTunnelsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VpnTunnelsStubSettings extends StubSettings<VpnTunnelsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteVpnTunnelRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteVpnTunnelRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetVpnTunnelRequest, VpnTunnel> getSettings;
  private final UnaryCallSettings<InsertVpnTunnelRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertVpnTunnelRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListVpnTunnelsRequest, VpnTunnelList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<SetLabelsVpnTunnelRequest, Operation> setLabelsSettings;
  private final OperationCallSettings<SetLabelsVpnTunnelRequest, Operation, Operation>
      setLabelsOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListVpnTunnelsRequest,
          VpnTunnelAggregatedList,
          Map.Entry<String, VpnTunnelsScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListVpnTunnelsRequest,
              VpnTunnelAggregatedList,
              Map.Entry<String, VpnTunnelsScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListVpnTunnelsRequest injectToken(
                AggregatedListVpnTunnelsRequest payload, String token) {
              return AggregatedListVpnTunnelsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListVpnTunnelsRequest injectPageSize(
                AggregatedListVpnTunnelsRequest payload, int pageSize) {
              return AggregatedListVpnTunnelsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListVpnTunnelsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VpnTunnelAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, VpnTunnelsScopedList>> extractResources(
                VpnTunnelAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, VpnTunnelsScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVpnTunnelsRequest injectToken(ListVpnTunnelsRequest payload, String token) {
              return ListVpnTunnelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVpnTunnelsRequest injectPageSize(
                ListVpnTunnelsRequest payload, int pageSize) {
              return ListVpnTunnelsRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVpnTunnelsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VpnTunnelList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpnTunnel> extractResources(VpnTunnelList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<VpnTunnel>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListVpnTunnelsRequest,
              VpnTunnelAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList> callable,
                AggregatedListVpnTunnelsRequest request,
                ApiCallContext context,
                ApiFuture<VpnTunnelAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListVpnTunnelsRequest,
                      VpnTunnelAggregatedList,
                      Map.Entry<String, VpnTunnelsScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVpnTunnelsRequest, VpnTunnelList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListVpnTunnelsRequest, VpnTunnelList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVpnTunnelsRequest, VpnTunnelList> callable,
                ListVpnTunnelsRequest request,
                ApiCallContext context,
                ApiFuture<VpnTunnelList> futureResponse) {
              PageContext<ListVpnTunnelsRequest, VpnTunnelList, VpnTunnel> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteVpnTunnelRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteVpnTunnelRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetVpnTunnelRequest, VpnTunnel> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertVpnTunnelRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertVpnTunnelRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListVpnTunnelsRequest, VpnTunnelList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsVpnTunnelRequest, Operation> setLabelsSettings() {
    return setLabelsSettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsVpnTunnelRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return setLabelsOperationSettings;
  }

  public VpnTunnelsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVpnTunnelsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(VpnTunnelsStubSettings.class))
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

  protected VpnTunnelsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    setLabelsSettings = settingsBuilder.setLabelsSettings().build();
    setLabelsOperationSettings = settingsBuilder.setLabelsOperationSettings().build();
  }

  /** Builder for VpnTunnelsStubSettings. */
  public static class Builder extends StubSettings.Builder<VpnTunnelsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteVpnTunnelRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteVpnTunnelRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetVpnTunnelRequest, VpnTunnel> getSettings;
    private final UnaryCallSettings.Builder<InsertVpnTunnelRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertVpnTunnelRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<ListVpnTunnelsRequest, VpnTunnelList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<SetLabelsVpnTunnelRequest, Operation> setLabelsSettings;
    private final OperationCallSettings.Builder<SetLabelsVpnTunnelRequest, Operation, Operation>
        setLabelsOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      setLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setLabelsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              setLabelsSettings);
      initDefaults(this);
    }

    protected Builder(VpnTunnelsStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      setLabelsSettings = settings.setLabelsSettings.toBuilder();
      setLabelsOperationSettings = settings.setLabelsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              setLabelsSettings);
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
          .setLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVpnTunnelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                  .<InsertVpnTunnelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .setLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetLabelsVpnTunnelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteVpnTunnelRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteVpnTunnelRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetVpnTunnelRequest, VpnTunnel> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertVpnTunnelRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertVpnTunnelRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListVpnTunnelsRequest, VpnTunnelList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsVpnTunnelRequest, Operation> setLabelsSettings() {
      return setLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetLabelsVpnTunnelRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return setLabelsOperationSettings;
    }

    @Override
    public VpnTunnelsStubSettings build() throws IOException {
      return new VpnTunnelsStubSettings(this);
    }
  }
}
