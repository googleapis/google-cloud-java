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

package com.google.cloud.osconfig.v1.stub;

import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.osconfig.v1.GetInventoryRequest;
import com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest;
import com.google.cloud.osconfig.v1.Inventory;
import com.google.cloud.osconfig.v1.ListInventoriesRequest;
import com.google.cloud.osconfig.v1.ListInventoriesResponse;
import com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest;
import com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse;
import com.google.cloud.osconfig.v1.VulnerabilityReport;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OsConfigZonalServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (osconfig.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInventory to 30 seconds:
 *
 * <pre>{@code
 * OsConfigZonalServiceStubSettings.Builder osConfigZonalServiceSettingsBuilder =
 *     OsConfigZonalServiceStubSettings.newBuilder();
 * osConfigZonalServiceSettingsBuilder
 *     .getInventorySettings()
 *     .setRetrySettings(
 *         osConfigZonalServiceSettingsBuilder
 *             .getInventorySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OsConfigZonalServiceStubSettings osConfigZonalServiceSettings =
 *     osConfigZonalServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OsConfigZonalServiceStubSettings
    extends StubSettings<OsConfigZonalServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetInventoryRequest, Inventory> getInventorySettings;
  private final PagedCallSettings<
          ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>
      listInventoriesSettings;
  private final UnaryCallSettings<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportSettings;
  private final PagedCallSettings<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsSettings;

  private static final PagedListDescriptor<
          ListInventoriesRequest, ListInventoriesResponse, Inventory>
      LIST_INVENTORIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListInventoriesRequest, ListInventoriesResponse, Inventory>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInventoriesRequest injectToken(
                ListInventoriesRequest payload, String token) {
              return ListInventoriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInventoriesRequest injectPageSize(
                ListInventoriesRequest payload, int pageSize) {
              return ListInventoriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInventoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInventoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Inventory> extractResources(ListInventoriesResponse payload) {
              return payload.getInventoriesList() == null
                  ? ImmutableList.<Inventory>of()
                  : payload.getInventoriesList();
            }
          };

  private static final PagedListDescriptor<
          ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse, VulnerabilityReport>
      LIST_VULNERABILITY_REPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVulnerabilityReportsRequest,
              ListVulnerabilityReportsResponse,
              VulnerabilityReport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVulnerabilityReportsRequest injectToken(
                ListVulnerabilityReportsRequest payload, String token) {
              return ListVulnerabilityReportsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListVulnerabilityReportsRequest injectPageSize(
                ListVulnerabilityReportsRequest payload, int pageSize) {
              return ListVulnerabilityReportsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListVulnerabilityReportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVulnerabilityReportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VulnerabilityReport> extractResources(
                ListVulnerabilityReportsResponse payload) {
              return payload.getVulnerabilityReportsList() == null
                  ? ImmutableList.<VulnerabilityReport>of()
                  : payload.getVulnerabilityReportsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>
      LIST_INVENTORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>() {
            @Override
            public ApiFuture<ListInventoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInventoriesRequest, ListInventoriesResponse> callable,
                ListInventoriesRequest request,
                ApiCallContext context,
                ApiFuture<ListInventoriesResponse> futureResponse) {
              PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> pageContext =
                  PageContext.create(callable, LIST_INVENTORIES_PAGE_STR_DESC, request, context);
              return ListInventoriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          ListVulnerabilityReportsPagedResponse>
      LIST_VULNERABILITY_REPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVulnerabilityReportsRequest,
              ListVulnerabilityReportsResponse,
              ListVulnerabilityReportsPagedResponse>() {
            @Override
            public ApiFuture<ListVulnerabilityReportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
                    callable,
                ListVulnerabilityReportsRequest request,
                ApiCallContext context,
                ApiFuture<ListVulnerabilityReportsResponse> futureResponse) {
              PageContext<
                      ListVulnerabilityReportsRequest,
                      ListVulnerabilityReportsResponse,
                      VulnerabilityReport>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VULNERABILITY_REPORTS_PAGE_STR_DESC, request, context);
              return ListVulnerabilityReportsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getInventory. */
  public UnaryCallSettings<GetInventoryRequest, Inventory> getInventorySettings() {
    return getInventorySettings;
  }

  /** Returns the object with the settings used for calls to listInventories. */
  public PagedCallSettings<
          ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>
      listInventoriesSettings() {
    return listInventoriesSettings;
  }

  /** Returns the object with the settings used for calls to getVulnerabilityReport. */
  public UnaryCallSettings<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportSettings() {
    return getVulnerabilityReportSettings;
  }

  /** Returns the object with the settings used for calls to listVulnerabilityReports. */
  public PagedCallSettings<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsSettings() {
    return listVulnerabilityReportsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public OsConfigZonalServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOsConfigZonalServiceStub.create(this);
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
    return "osconfig.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "osconfig.mtls.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OsConfigZonalServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected OsConfigZonalServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getInventorySettings = settingsBuilder.getInventorySettings().build();
    listInventoriesSettings = settingsBuilder.listInventoriesSettings().build();
    getVulnerabilityReportSettings = settingsBuilder.getVulnerabilityReportSettings().build();
    listVulnerabilityReportsSettings = settingsBuilder.listVulnerabilityReportsSettings().build();
  }

  /** Builder for OsConfigZonalServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<OsConfigZonalServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetInventoryRequest, Inventory> getInventorySettings;
    private final PagedCallSettings.Builder<
            ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>
        listInventoriesSettings;
    private final UnaryCallSettings.Builder<GetVulnerabilityReportRequest, VulnerabilityReport>
        getVulnerabilityReportSettings;
    private final PagedCallSettings.Builder<
            ListVulnerabilityReportsRequest,
            ListVulnerabilityReportsResponse,
            ListVulnerabilityReportsPagedResponse>
        listVulnerabilityReportsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getInventorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listInventoriesSettings = PagedCallSettings.newBuilder(LIST_INVENTORIES_PAGE_STR_FACT);
      getVulnerabilityReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVulnerabilityReportsSettings =
          PagedCallSettings.newBuilder(LIST_VULNERABILITY_REPORTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getInventorySettings,
              listInventoriesSettings,
              getVulnerabilityReportSettings,
              listVulnerabilityReportsSettings);
      initDefaults(this);
    }

    protected Builder(OsConfigZonalServiceStubSettings settings) {
      super(settings);

      getInventorySettings = settings.getInventorySettings.toBuilder();
      listInventoriesSettings = settings.listInventoriesSettings.toBuilder();
      getVulnerabilityReportSettings = settings.getVulnerabilityReportSettings.toBuilder();
      listVulnerabilityReportsSettings = settings.listVulnerabilityReportsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getInventorySettings,
              listInventoriesSettings,
              getVulnerabilityReportSettings,
              listVulnerabilityReportsSettings);
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
          .getInventorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listInventoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getVulnerabilityReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listVulnerabilityReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to getInventory. */
    public UnaryCallSettings.Builder<GetInventoryRequest, Inventory> getInventorySettings() {
      return getInventorySettings;
    }

    /** Returns the builder for the settings used for calls to listInventories. */
    public PagedCallSettings.Builder<
            ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>
        listInventoriesSettings() {
      return listInventoriesSettings;
    }

    /** Returns the builder for the settings used for calls to getVulnerabilityReport. */
    public UnaryCallSettings.Builder<GetVulnerabilityReportRequest, VulnerabilityReport>
        getVulnerabilityReportSettings() {
      return getVulnerabilityReportSettings;
    }

    /** Returns the builder for the settings used for calls to listVulnerabilityReports. */
    public PagedCallSettings.Builder<
            ListVulnerabilityReportsRequest,
            ListVulnerabilityReportsResponse,
            ListVulnerabilityReportsPagedResponse>
        listVulnerabilityReportsSettings() {
      return listVulnerabilityReportsSettings;
    }

    @Override
    public OsConfigZonalServiceStubSettings build() throws IOException {
      return new OsConfigZonalServiceStubSettings(this);
    }
  }
}
