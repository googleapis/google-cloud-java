/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.monitoring.dashboard.v1.stub;

import static com.google.cloud.monitoring.dashboard.v1.DashboardsServiceClient.ListDashboardsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.monitoring.dashboard.v1.CreateDashboardRequest;
import com.google.monitoring.dashboard.v1.Dashboard;
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DashboardsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createDashboard:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DashboardsServiceStubSettings.Builder dashboardsServiceSettingsBuilder =
 *     DashboardsServiceStubSettings.newBuilder();
 * dashboardsServiceSettingsBuilder
 *     .createDashboardSettings()
 *     .setRetrySettings(
 *         dashboardsServiceSettingsBuilder
 *             .createDashboardSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * DashboardsServiceStubSettings dashboardsServiceSettings =
 *     dashboardsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class DashboardsServiceStubSettings extends StubSettings<DashboardsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .add("https://www.googleapis.com/auth/monitoring.write")
          .build();

  private final UnaryCallSettings<CreateDashboardRequest, Dashboard> createDashboardSettings;
  private final PagedCallSettings<
          ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>
      listDashboardsSettings;
  private final UnaryCallSettings<GetDashboardRequest, Dashboard> getDashboardSettings;
  private final UnaryCallSettings<DeleteDashboardRequest, Empty> deleteDashboardSettings;
  private final UnaryCallSettings<UpdateDashboardRequest, Dashboard> updateDashboardSettings;

  private static final PagedListDescriptor<ListDashboardsRequest, ListDashboardsResponse, Dashboard>
      LIST_DASHBOARDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDashboardsRequest, ListDashboardsResponse, Dashboard>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDashboardsRequest injectToken(ListDashboardsRequest payload, String token) {
              return ListDashboardsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDashboardsRequest injectPageSize(
                ListDashboardsRequest payload, int pageSize) {
              return ListDashboardsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDashboardsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDashboardsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Dashboard> extractResources(ListDashboardsResponse payload) {
              return payload.getDashboardsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>
      LIST_DASHBOARDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>() {
            @Override
            public ApiFuture<ListDashboardsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDashboardsRequest, ListDashboardsResponse> callable,
                ListDashboardsRequest request,
                ApiCallContext context,
                ApiFuture<ListDashboardsResponse> futureResponse) {
              PageContext<ListDashboardsRequest, ListDashboardsResponse, Dashboard> pageContext =
                  PageContext.create(callable, LIST_DASHBOARDS_PAGE_STR_DESC, request, context);
              return ListDashboardsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDashboard. */
  public UnaryCallSettings<CreateDashboardRequest, Dashboard> createDashboardSettings() {
    return createDashboardSettings;
  }

  /** Returns the object with the settings used for calls to listDashboards. */
  public PagedCallSettings<
          ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>
      listDashboardsSettings() {
    return listDashboardsSettings;
  }

  /** Returns the object with the settings used for calls to getDashboard. */
  public UnaryCallSettings<GetDashboardRequest, Dashboard> getDashboardSettings() {
    return getDashboardSettings;
  }

  /** Returns the object with the settings used for calls to deleteDashboard. */
  public UnaryCallSettings<DeleteDashboardRequest, Empty> deleteDashboardSettings() {
    return deleteDashboardSettings;
  }

  /** Returns the object with the settings used for calls to updateDashboard. */
  public UnaryCallSettings<UpdateDashboardRequest, Dashboard> updateDashboardSettings() {
    return updateDashboardSettings;
  }

  public DashboardsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDashboardsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDashboardsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "monitoring";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "monitoring.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "monitoring.mtls.googleapis.com:443";
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DashboardsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DashboardsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DashboardsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected DashboardsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDashboardSettings = settingsBuilder.createDashboardSettings().build();
    listDashboardsSettings = settingsBuilder.listDashboardsSettings().build();
    getDashboardSettings = settingsBuilder.getDashboardSettings().build();
    deleteDashboardSettings = settingsBuilder.deleteDashboardSettings().build();
    updateDashboardSettings = settingsBuilder.updateDashboardSettings().build();
  }

  /** Builder for DashboardsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DashboardsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDashboardRequest, Dashboard>
        createDashboardSettings;
    private final PagedCallSettings.Builder<
            ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>
        listDashboardsSettings;
    private final UnaryCallSettings.Builder<GetDashboardRequest, Dashboard> getDashboardSettings;
    private final UnaryCallSettings.Builder<DeleteDashboardRequest, Empty> deleteDashboardSettings;
    private final UnaryCallSettings.Builder<UpdateDashboardRequest, Dashboard>
        updateDashboardSettings;
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
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNKNOWN)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDashboardsSettings = PagedCallSettings.newBuilder(LIST_DASHBOARDS_PAGE_STR_FACT);
      getDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDashboardSettings,
              listDashboardsSettings,
              getDashboardSettings,
              deleteDashboardSettings,
              updateDashboardSettings);
      initDefaults(this);
    }

    protected Builder(DashboardsServiceStubSettings settings) {
      super(settings);

      createDashboardSettings = settings.createDashboardSettings.toBuilder();
      listDashboardsSettings = settings.listDashboardsSettings.toBuilder();
      getDashboardSettings = settings.getDashboardSettings.toBuilder();
      deleteDashboardSettings = settings.deleteDashboardSettings.toBuilder();
      updateDashboardSettings = settings.updateDashboardSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDashboardSettings,
              listDashboardsSettings,
              getDashboardSettings,
              deleteDashboardSettings,
              updateDashboardSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDashboardsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to createDashboard. */
    public UnaryCallSettings.Builder<CreateDashboardRequest, Dashboard> createDashboardSettings() {
      return createDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to listDashboards. */
    public PagedCallSettings.Builder<
            ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>
        listDashboardsSettings() {
      return listDashboardsSettings;
    }

    /** Returns the builder for the settings used for calls to getDashboard. */
    public UnaryCallSettings.Builder<GetDashboardRequest, Dashboard> getDashboardSettings() {
      return getDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDashboard. */
    public UnaryCallSettings.Builder<DeleteDashboardRequest, Empty> deleteDashboardSettings() {
      return deleteDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to updateDashboard. */
    public UnaryCallSettings.Builder<UpdateDashboardRequest, Dashboard> updateDashboardSettings() {
      return updateDashboardSettings;
    }

    @Override
    public DashboardsServiceStubSettings build() throws IOException {
      return new DashboardsServiceStubSettings(this);
    }
  }
}
