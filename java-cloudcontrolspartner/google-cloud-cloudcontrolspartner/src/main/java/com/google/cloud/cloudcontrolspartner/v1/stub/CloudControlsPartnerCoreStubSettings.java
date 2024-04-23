/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1.stub;

import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListAccessApprovalRequestsPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListCustomersPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListWorkloadsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.cloudcontrolspartner.v1.AccessApprovalRequest;
import com.google.cloud.cloudcontrolspartner.v1.Customer;
import com.google.cloud.cloudcontrolspartner.v1.EkmConnections;
import com.google.cloud.cloudcontrolspartner.v1.GetCustomerRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetEkmConnectionsRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetPartnerPermissionsRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetPartnerRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetWorkloadRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListAccessApprovalRequestsRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListAccessApprovalRequestsResponse;
import com.google.cloud.cloudcontrolspartner.v1.ListCustomersRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListCustomersResponse;
import com.google.cloud.cloudcontrolspartner.v1.ListWorkloadsRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListWorkloadsResponse;
import com.google.cloud.cloudcontrolspartner.v1.Partner;
import com.google.cloud.cloudcontrolspartner.v1.PartnerPermissions;
import com.google.cloud.cloudcontrolspartner.v1.Workload;
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
 * Settings class to configure an instance of {@link CloudControlsPartnerCoreStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudcontrolspartner.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getWorkload to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudControlsPartnerCoreStubSettings.Builder cloudControlsPartnerCoreSettingsBuilder =
 *     CloudControlsPartnerCoreStubSettings.newBuilder();
 * cloudControlsPartnerCoreSettingsBuilder
 *     .getWorkloadSettings()
 *     .setRetrySettings(
 *         cloudControlsPartnerCoreSettingsBuilder
 *             .getWorkloadSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudControlsPartnerCoreStubSettings cloudControlsPartnerCoreSettings =
 *     cloudControlsPartnerCoreSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudControlsPartnerCoreStubSettings
    extends StubSettings<CloudControlsPartnerCoreStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings;
  private final PagedCallSettings<
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings;
  private final UnaryCallSettings<GetCustomerRequest, Customer> getCustomerSettings;
  private final PagedCallSettings<
          ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
      listCustomersSettings;
  private final UnaryCallSettings<GetEkmConnectionsRequest, EkmConnections>
      getEkmConnectionsSettings;
  private final UnaryCallSettings<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsSettings;
  private final PagedCallSettings<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsSettings;
  private final UnaryCallSettings<GetPartnerRequest, Partner> getPartnerSettings;

  private static final PagedListDescriptor<ListWorkloadsRequest, ListWorkloadsResponse, Workload>
      LIST_WORKLOADS_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkloadsRequest, ListWorkloadsResponse, Workload>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkloadsRequest injectToken(ListWorkloadsRequest payload, String token) {
              return ListWorkloadsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkloadsRequest injectPageSize(ListWorkloadsRequest payload, int pageSize) {
              return ListWorkloadsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkloadsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkloadsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workload> extractResources(ListWorkloadsResponse payload) {
              return payload.getWorkloadsList() == null
                  ? ImmutableList.<Workload>of()
                  : payload.getWorkloadsList();
            }
          };

  private static final PagedListDescriptor<ListCustomersRequest, ListCustomersResponse, Customer>
      LIST_CUSTOMERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCustomersRequest, ListCustomersResponse, Customer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomersRequest injectToken(ListCustomersRequest payload, String token) {
              return ListCustomersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomersRequest injectPageSize(ListCustomersRequest payload, int pageSize) {
              return ListCustomersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Customer> extractResources(ListCustomersResponse payload) {
              return payload.getCustomersList() == null
                  ? ImmutableList.<Customer>of()
                  : payload.getCustomersList();
            }
          };

  private static final PagedListDescriptor<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          AccessApprovalRequest>
      LIST_ACCESS_APPROVAL_REQUESTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccessApprovalRequestsRequest,
              ListAccessApprovalRequestsResponse,
              AccessApprovalRequest>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccessApprovalRequestsRequest injectToken(
                ListAccessApprovalRequestsRequest payload, String token) {
              return ListAccessApprovalRequestsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAccessApprovalRequestsRequest injectPageSize(
                ListAccessApprovalRequestsRequest payload, int pageSize) {
              return ListAccessApprovalRequestsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAccessApprovalRequestsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccessApprovalRequestsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AccessApprovalRequest> extractResources(
                ListAccessApprovalRequestsResponse payload) {
              return payload.getAccessApprovalRequestsList() == null
                  ? ImmutableList.<AccessApprovalRequest>of()
                  : payload.getAccessApprovalRequestsList();
            }
          };

  private static final PagedListResponseFactory<
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      LIST_WORKLOADS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkloadsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> callable,
                ListWorkloadsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkloadsResponse> futureResponse) {
              PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> pageContext =
                  PageContext.create(callable, LIST_WORKLOADS_PAGE_STR_DESC, request, context);
              return ListWorkloadsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
      LIST_CUSTOMERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>() {
            @Override
            public ApiFuture<ListCustomersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomersRequest, ListCustomersResponse> callable,
                ListCustomersRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomersResponse> futureResponse) {
              PageContext<ListCustomersRequest, ListCustomersResponse, Customer> pageContext =
                  PageContext.create(callable, LIST_CUSTOMERS_PAGE_STR_DESC, request, context);
              return ListCustomersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          ListAccessApprovalRequestsPagedResponse>
      LIST_ACCESS_APPROVAL_REQUESTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccessApprovalRequestsRequest,
              ListAccessApprovalRequestsResponse,
              ListAccessApprovalRequestsPagedResponse>() {
            @Override
            public ApiFuture<ListAccessApprovalRequestsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
                    callable,
                ListAccessApprovalRequestsRequest request,
                ApiCallContext context,
                ApiFuture<ListAccessApprovalRequestsResponse> futureResponse) {
              PageContext<
                      ListAccessApprovalRequestsRequest,
                      ListAccessApprovalRequestsResponse,
                      AccessApprovalRequest>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCESS_APPROVAL_REQUESTS_PAGE_STR_DESC, request, context);
              return ListAccessApprovalRequestsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getWorkload. */
  public UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings() {
    return getWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to listWorkloads. */
  public PagedCallSettings<ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings() {
    return listWorkloadsSettings;
  }

  /** Returns the object with the settings used for calls to getCustomer. */
  public UnaryCallSettings<GetCustomerRequest, Customer> getCustomerSettings() {
    return getCustomerSettings;
  }

  /** Returns the object with the settings used for calls to listCustomers. */
  public PagedCallSettings<ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
      listCustomersSettings() {
    return listCustomersSettings;
  }

  /** Returns the object with the settings used for calls to getEkmConnections. */
  public UnaryCallSettings<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsSettings() {
    return getEkmConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to getPartnerPermissions. */
  public UnaryCallSettings<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsSettings() {
    return getPartnerPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to listAccessApprovalRequests. */
  public PagedCallSettings<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsSettings() {
    return listAccessApprovalRequestsSettings;
  }

  /** Returns the object with the settings used for calls to getPartner. */
  public UnaryCallSettings<GetPartnerRequest, Partner> getPartnerSettings() {
    return getPartnerSettings;
  }

  public CloudControlsPartnerCoreStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudControlsPartnerCoreStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudControlsPartnerCoreStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudcontrolspartner";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudcontrolspartner.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudcontrolspartner.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CloudControlsPartnerCoreStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudControlsPartnerCoreStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudControlsPartnerCoreStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CloudControlsPartnerCoreStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getWorkloadSettings = settingsBuilder.getWorkloadSettings().build();
    listWorkloadsSettings = settingsBuilder.listWorkloadsSettings().build();
    getCustomerSettings = settingsBuilder.getCustomerSettings().build();
    listCustomersSettings = settingsBuilder.listCustomersSettings().build();
    getEkmConnectionsSettings = settingsBuilder.getEkmConnectionsSettings().build();
    getPartnerPermissionsSettings = settingsBuilder.getPartnerPermissionsSettings().build();
    listAccessApprovalRequestsSettings =
        settingsBuilder.listAccessApprovalRequestsSettings().build();
    getPartnerSettings = settingsBuilder.getPartnerSettings().build();
  }

  /** Builder for CloudControlsPartnerCoreStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CloudControlsPartnerCoreStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings;
    private final PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings;
    private final UnaryCallSettings.Builder<GetCustomerRequest, Customer> getCustomerSettings;
    private final PagedCallSettings.Builder<
            ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
        listCustomersSettings;
    private final UnaryCallSettings.Builder<GetEkmConnectionsRequest, EkmConnections>
        getEkmConnectionsSettings;
    private final UnaryCallSettings.Builder<GetPartnerPermissionsRequest, PartnerPermissions>
        getPartnerPermissionsSettings;
    private final PagedCallSettings.Builder<
            ListAccessApprovalRequestsRequest,
            ListAccessApprovalRequestsResponse,
            ListAccessApprovalRequestsPagedResponse>
        listAccessApprovalRequestsSettings;
    private final UnaryCallSettings.Builder<GetPartnerRequest, Partner> getPartnerSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkloadsSettings = PagedCallSettings.newBuilder(LIST_WORKLOADS_PAGE_STR_FACT);
      getCustomerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCustomersSettings = PagedCallSettings.newBuilder(LIST_CUSTOMERS_PAGE_STR_FACT);
      getEkmConnectionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPartnerPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAccessApprovalRequestsSettings =
          PagedCallSettings.newBuilder(LIST_ACCESS_APPROVAL_REQUESTS_PAGE_STR_FACT);
      getPartnerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getWorkloadSettings,
              listWorkloadsSettings,
              getCustomerSettings,
              listCustomersSettings,
              getEkmConnectionsSettings,
              getPartnerPermissionsSettings,
              listAccessApprovalRequestsSettings,
              getPartnerSettings);
      initDefaults(this);
    }

    protected Builder(CloudControlsPartnerCoreStubSettings settings) {
      super(settings);

      getWorkloadSettings = settings.getWorkloadSettings.toBuilder();
      listWorkloadsSettings = settings.listWorkloadsSettings.toBuilder();
      getCustomerSettings = settings.getCustomerSettings.toBuilder();
      listCustomersSettings = settings.listCustomersSettings.toBuilder();
      getEkmConnectionsSettings = settings.getEkmConnectionsSettings.toBuilder();
      getPartnerPermissionsSettings = settings.getPartnerPermissionsSettings.toBuilder();
      listAccessApprovalRequestsSettings = settings.listAccessApprovalRequestsSettings.toBuilder();
      getPartnerSettings = settings.getPartnerSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getWorkloadSettings,
              listWorkloadsSettings,
              getCustomerSettings,
              listCustomersSettings,
              getEkmConnectionsSettings,
              getPartnerPermissionsSettings,
              listAccessApprovalRequestsSettings,
              getPartnerSettings);
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
          .getWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listWorkloadsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCustomerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCustomersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEkmConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPartnerPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAccessApprovalRequestsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPartnerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to getWorkload. */
    public UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings() {
      return getWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkloads. */
    public PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings() {
      return listWorkloadsSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomer. */
    public UnaryCallSettings.Builder<GetCustomerRequest, Customer> getCustomerSettings() {
      return getCustomerSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomers. */
    public PagedCallSettings.Builder<
            ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
        listCustomersSettings() {
      return listCustomersSettings;
    }

    /** Returns the builder for the settings used for calls to getEkmConnections. */
    public UnaryCallSettings.Builder<GetEkmConnectionsRequest, EkmConnections>
        getEkmConnectionsSettings() {
      return getEkmConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to getPartnerPermissions. */
    public UnaryCallSettings.Builder<GetPartnerPermissionsRequest, PartnerPermissions>
        getPartnerPermissionsSettings() {
      return getPartnerPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to listAccessApprovalRequests. */
    public PagedCallSettings.Builder<
            ListAccessApprovalRequestsRequest,
            ListAccessApprovalRequestsResponse,
            ListAccessApprovalRequestsPagedResponse>
        listAccessApprovalRequestsSettings() {
      return listAccessApprovalRequestsSettings;
    }

    /** Returns the builder for the settings used for calls to getPartner. */
    public UnaryCallSettings.Builder<GetPartnerRequest, Partner> getPartnerSettings() {
      return getPartnerSettings;
    }

    @Override
    public CloudControlsPartnerCoreStubSettings build() throws IOException {
      return new CloudControlsPartnerCoreStubSettings(this);
    }
  }
}
