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

import static com.google.cloud.compute.v1.VpnGatewayClient.AggregatedListVpnGatewaysPagedResponse;
import static com.google.cloud.compute.v1.VpnGatewayClient.ListVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.DeleteVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.GetStatusVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.GetVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.InsertVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ListVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.VpnGateway;
import com.google.cloud.compute.v1.VpnGatewayAggregatedList;
import com.google.cloud.compute.v1.VpnGatewayList;
import com.google.cloud.compute.v1.VpnGatewaysGetStatusResponse;
import com.google.cloud.compute.v1.VpnGatewaysScopedList;
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
 * Settings class to configure an instance of {@link VpnGatewayStub}.
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
 * <p>For example, to set the total timeout of deleteVpnGateway to 30 seconds:
 *
 * <pre>
 * <code>
 * VpnGatewayStubSettings.Builder vpnGatewaySettingsBuilder =
 *     VpnGatewayStubSettings.newBuilder();
 * vpnGatewaySettingsBuilder.deleteVpnGatewaySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * VpnGatewayStubSettings vpnGatewaySettings = vpnGatewaySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnGatewayStubSettings extends StubSettings<VpnGatewayStubSettings> {
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
          AggregatedListVpnGatewaysHttpRequest,
          VpnGatewayAggregatedList,
          AggregatedListVpnGatewaysPagedResponse>
      aggregatedListVpnGatewaysSettings;
  private final UnaryCallSettings<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewaySettings;
  private final UnaryCallSettings<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewaySettings;
  private final UnaryCallSettings<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewaySettings;
  private final UnaryCallSettings<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewaySettings;
  private final PagedCallSettings<
          ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>
      listVpnGatewaysSettings;
  private final UnaryCallSettings<SetLabelsVpnGatewayHttpRequest, Operation>
      setLabelsVpnGatewaySettings;
  private final UnaryCallSettings<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewaySettings;

  /** Returns the object with the settings used for calls to aggregatedListVpnGateways. */
  public PagedCallSettings<
          AggregatedListVpnGatewaysHttpRequest,
          VpnGatewayAggregatedList,
          AggregatedListVpnGatewaysPagedResponse>
      aggregatedListVpnGatewaysSettings() {
    return aggregatedListVpnGatewaysSettings;
  }

  /** Returns the object with the settings used for calls to deleteVpnGateway. */
  public UnaryCallSettings<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewaySettings() {
    return deleteVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to getVpnGateway. */
  public UnaryCallSettings<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewaySettings() {
    return getVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to getStatusVpnGateway. */
  public UnaryCallSettings<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewaySettings() {
    return getStatusVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to insertVpnGateway. */
  public UnaryCallSettings<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewaySettings() {
    return insertVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to listVpnGateways. */
  public PagedCallSettings<ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>
      listVpnGatewaysSettings() {
    return listVpnGatewaysSettings;
  }

  /** Returns the object with the settings used for calls to setLabelsVpnGateway. */
  public UnaryCallSettings<SetLabelsVpnGatewayHttpRequest, Operation>
      setLabelsVpnGatewaySettings() {
    return setLabelsVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsVpnGateway. */
  public UnaryCallSettings<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewaySettings() {
    return testIamPermissionsVpnGatewaySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpnGatewayStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVpnGatewayStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(VpnGatewayStubSettings.class))
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

  protected VpnGatewayStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListVpnGatewaysSettings = settingsBuilder.aggregatedListVpnGatewaysSettings().build();
    deleteVpnGatewaySettings = settingsBuilder.deleteVpnGatewaySettings().build();
    getVpnGatewaySettings = settingsBuilder.getVpnGatewaySettings().build();
    getStatusVpnGatewaySettings = settingsBuilder.getStatusVpnGatewaySettings().build();
    insertVpnGatewaySettings = settingsBuilder.insertVpnGatewaySettings().build();
    listVpnGatewaysSettings = settingsBuilder.listVpnGatewaysSettings().build();
    setLabelsVpnGatewaySettings = settingsBuilder.setLabelsVpnGatewaySettings().build();
    testIamPermissionsVpnGatewaySettings =
        settingsBuilder.testIamPermissionsVpnGatewaySettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList, VpnGatewaysScopedList>
      AGGREGATED_LIST_VPN_GATEWAYS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListVpnGatewaysHttpRequest,
              VpnGatewayAggregatedList,
              VpnGatewaysScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListVpnGatewaysHttpRequest injectToken(
                AggregatedListVpnGatewaysHttpRequest payload, String token) {
              return AggregatedListVpnGatewaysHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListVpnGatewaysHttpRequest injectPageSize(
                AggregatedListVpnGatewaysHttpRequest payload, int pageSize) {
              return AggregatedListVpnGatewaysHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListVpnGatewaysHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VpnGatewayAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpnGatewaysScopedList> extractResources(
                VpnGatewayAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<VpnGatewaysScopedList>of();
            }
          };

  private static final PagedListDescriptor<ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway>
      LIST_VPN_GATEWAYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVpnGatewaysHttpRequest injectToken(
                ListVpnGatewaysHttpRequest payload, String token) {
              return ListVpnGatewaysHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVpnGatewaysHttpRequest injectPageSize(
                ListVpnGatewaysHttpRequest payload, int pageSize) {
              return ListVpnGatewaysHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVpnGatewaysHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VpnGatewayList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpnGateway> extractResources(VpnGatewayList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<VpnGateway>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListVpnGatewaysHttpRequest,
          VpnGatewayAggregatedList,
          AggregatedListVpnGatewaysPagedResponse>
      AGGREGATED_LIST_VPN_GATEWAYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListVpnGatewaysHttpRequest,
              VpnGatewayAggregatedList,
              AggregatedListVpnGatewaysPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListVpnGatewaysPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>
                    callable,
                AggregatedListVpnGatewaysHttpRequest request,
                ApiCallContext context,
                ApiFuture<VpnGatewayAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListVpnGatewaysHttpRequest,
                      VpnGatewayAggregatedList,
                      VpnGatewaysScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_VPN_GATEWAYS_PAGE_STR_DESC, request, context);
              return AggregatedListVpnGatewaysPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>
      LIST_VPN_GATEWAYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>() {
            @Override
            public ApiFuture<ListVpnGatewaysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVpnGatewaysHttpRequest, VpnGatewayList> callable,
                ListVpnGatewaysHttpRequest request,
                ApiCallContext context,
                ApiFuture<VpnGatewayList> futureResponse) {
              PageContext<ListVpnGatewaysHttpRequest, VpnGatewayList, VpnGateway> pageContext =
                  PageContext.create(callable, LIST_VPN_GATEWAYS_PAGE_STR_DESC, request, context);
              return ListVpnGatewaysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for VpnGatewayStubSettings. */
  public static class Builder extends StubSettings.Builder<VpnGatewayStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListVpnGatewaysHttpRequest,
            VpnGatewayAggregatedList,
            AggregatedListVpnGatewaysPagedResponse>
        aggregatedListVpnGatewaysSettings;
    private final UnaryCallSettings.Builder<DeleteVpnGatewayHttpRequest, Operation>
        deleteVpnGatewaySettings;
    private final UnaryCallSettings.Builder<GetVpnGatewayHttpRequest, VpnGateway>
        getVpnGatewaySettings;
    private final UnaryCallSettings.Builder<
            GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
        getStatusVpnGatewaySettings;
    private final UnaryCallSettings.Builder<InsertVpnGatewayHttpRequest, Operation>
        insertVpnGatewaySettings;
    private final PagedCallSettings.Builder<
            ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>
        listVpnGatewaysSettings;
    private final UnaryCallSettings.Builder<SetLabelsVpnGatewayHttpRequest, Operation>
        setLabelsVpnGatewaySettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsVpnGatewaySettings;

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

      aggregatedListVpnGatewaysSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_VPN_GATEWAYS_PAGE_STR_FACT);

      deleteVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getStatusVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listVpnGatewaysSettings = PagedCallSettings.newBuilder(LIST_VPN_GATEWAYS_PAGE_STR_FACT);

      setLabelsVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListVpnGatewaysSettings,
              deleteVpnGatewaySettings,
              getVpnGatewaySettings,
              getStatusVpnGatewaySettings,
              insertVpnGatewaySettings,
              listVpnGatewaysSettings,
              setLabelsVpnGatewaySettings,
              testIamPermissionsVpnGatewaySettings);

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
          .aggregatedListVpnGatewaysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getStatusVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listVpnGatewaysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(VpnGatewayStubSettings settings) {
      super(settings);

      aggregatedListVpnGatewaysSettings = settings.aggregatedListVpnGatewaysSettings.toBuilder();
      deleteVpnGatewaySettings = settings.deleteVpnGatewaySettings.toBuilder();
      getVpnGatewaySettings = settings.getVpnGatewaySettings.toBuilder();
      getStatusVpnGatewaySettings = settings.getStatusVpnGatewaySettings.toBuilder();
      insertVpnGatewaySettings = settings.insertVpnGatewaySettings.toBuilder();
      listVpnGatewaysSettings = settings.listVpnGatewaysSettings.toBuilder();
      setLabelsVpnGatewaySettings = settings.setLabelsVpnGatewaySettings.toBuilder();
      testIamPermissionsVpnGatewaySettings =
          settings.testIamPermissionsVpnGatewaySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListVpnGatewaysSettings,
              deleteVpnGatewaySettings,
              getVpnGatewaySettings,
              getStatusVpnGatewaySettings,
              insertVpnGatewaySettings,
              listVpnGatewaysSettings,
              setLabelsVpnGatewaySettings,
              testIamPermissionsVpnGatewaySettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListVpnGateways. */
    public PagedCallSettings.Builder<
            AggregatedListVpnGatewaysHttpRequest,
            VpnGatewayAggregatedList,
            AggregatedListVpnGatewaysPagedResponse>
        aggregatedListVpnGatewaysSettings() {
      return aggregatedListVpnGatewaysSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVpnGateway. */
    public UnaryCallSettings.Builder<DeleteVpnGatewayHttpRequest, Operation>
        deleteVpnGatewaySettings() {
      return deleteVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to getVpnGateway. */
    public UnaryCallSettings.Builder<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewaySettings() {
      return getVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to getStatusVpnGateway. */
    public UnaryCallSettings.Builder<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
        getStatusVpnGatewaySettings() {
      return getStatusVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to insertVpnGateway. */
    public UnaryCallSettings.Builder<InsertVpnGatewayHttpRequest, Operation>
        insertVpnGatewaySettings() {
      return insertVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to listVpnGateways. */
    public PagedCallSettings.Builder<
            ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>
        listVpnGatewaysSettings() {
      return listVpnGatewaysSettings;
    }

    /** Returns the builder for the settings used for calls to setLabelsVpnGateway. */
    public UnaryCallSettings.Builder<SetLabelsVpnGatewayHttpRequest, Operation>
        setLabelsVpnGatewaySettings() {
      return setLabelsVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsVpnGateway. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsVpnGatewaySettings() {
      return testIamPermissionsVpnGatewaySettings;
    }

    @Override
    public VpnGatewayStubSettings build() throws IOException {
      return new VpnGatewayStubSettings(this);
    }
  }
}
