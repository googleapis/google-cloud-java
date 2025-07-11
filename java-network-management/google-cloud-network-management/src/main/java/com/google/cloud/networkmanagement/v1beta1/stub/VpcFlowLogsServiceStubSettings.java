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

package com.google.cloud.networkmanagement.v1beta1.stub;

import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListVpcFlowLogsConfigsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.QueryOrgVpcFlowLogsConfigsPagedResponse;

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
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest;
import com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse;
import com.google.cloud.networkmanagement.v1beta1.OperationMetadata;
import com.google.cloud.networkmanagement.v1beta1.QueryOrgVpcFlowLogsConfigsRequest;
import com.google.cloud.networkmanagement.v1beta1.QueryOrgVpcFlowLogsConfigsResponse;
import com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VpcFlowLogsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkmanagement.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getVpcFlowLogsConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VpcFlowLogsServiceStubSettings.Builder vpcFlowLogsServiceSettingsBuilder =
 *     VpcFlowLogsServiceStubSettings.newBuilder();
 * vpcFlowLogsServiceSettingsBuilder
 *     .getVpcFlowLogsConfigSettings()
 *     .setRetrySettings(
 *         vpcFlowLogsServiceSettingsBuilder
 *             .getVpcFlowLogsConfigSettings()
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
 * VpcFlowLogsServiceStubSettings vpcFlowLogsServiceSettings =
 *     vpcFlowLogsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createVpcFlowLogsConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VpcFlowLogsServiceStubSettings.Builder vpcFlowLogsServiceSettingsBuilder =
 *     VpcFlowLogsServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * vpcFlowLogsServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VpcFlowLogsServiceStubSettings extends StubSettings<VpcFlowLogsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsSettings;
  private final UnaryCallSettings<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigSettings;
  private final UnaryCallSettings<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigSettings;
  private final OperationCallSettings<
          CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationSettings;
  private final UnaryCallSettings<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigSettings;
  private final OperationCallSettings<
          UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationSettings;
  private final UnaryCallSettings<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigSettings;
  private final OperationCallSettings<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationSettings;
  private final PagedCallSettings<
          QueryOrgVpcFlowLogsConfigsRequest,
          QueryOrgVpcFlowLogsConfigsResponse,
          QueryOrgVpcFlowLogsConfigsPagedResponse>
      queryOrgVpcFlowLogsConfigsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse, VpcFlowLogsConfig>
      LIST_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse, VpcFlowLogsConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVpcFlowLogsConfigsRequest injectToken(
                ListVpcFlowLogsConfigsRequest payload, String token) {
              return ListVpcFlowLogsConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVpcFlowLogsConfigsRequest injectPageSize(
                ListVpcFlowLogsConfigsRequest payload, int pageSize) {
              return ListVpcFlowLogsConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListVpcFlowLogsConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVpcFlowLogsConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpcFlowLogsConfig> extractResources(
                ListVpcFlowLogsConfigsResponse payload) {
              return payload.getVpcFlowLogsConfigsList();
            }
          };

  private static final PagedListDescriptor<
          QueryOrgVpcFlowLogsConfigsRequest, QueryOrgVpcFlowLogsConfigsResponse, VpcFlowLogsConfig>
      QUERY_ORG_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryOrgVpcFlowLogsConfigsRequest,
              QueryOrgVpcFlowLogsConfigsResponse,
              VpcFlowLogsConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryOrgVpcFlowLogsConfigsRequest injectToken(
                QueryOrgVpcFlowLogsConfigsRequest payload, String token) {
              return QueryOrgVpcFlowLogsConfigsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public QueryOrgVpcFlowLogsConfigsRequest injectPageSize(
                QueryOrgVpcFlowLogsConfigsRequest payload, int pageSize) {
              return QueryOrgVpcFlowLogsConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(QueryOrgVpcFlowLogsConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryOrgVpcFlowLogsConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpcFlowLogsConfig> extractResources(
                QueryOrgVpcFlowLogsConfigsResponse payload) {
              return payload.getVpcFlowLogsConfigsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          ListVpcFlowLogsConfigsPagedResponse>
      LIST_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVpcFlowLogsConfigsRequest,
              ListVpcFlowLogsConfigsResponse,
              ListVpcFlowLogsConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListVpcFlowLogsConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>
                    callable,
                ListVpcFlowLogsConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListVpcFlowLogsConfigsResponse> futureResponse) {
              PageContext<
                      ListVpcFlowLogsConfigsRequest,
                      ListVpcFlowLogsConfigsResponse,
                      VpcFlowLogsConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_DESC, request, context);
              return ListVpcFlowLogsConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryOrgVpcFlowLogsConfigsRequest,
          QueryOrgVpcFlowLogsConfigsResponse,
          QueryOrgVpcFlowLogsConfigsPagedResponse>
      QUERY_ORG_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryOrgVpcFlowLogsConfigsRequest,
              QueryOrgVpcFlowLogsConfigsResponse,
              QueryOrgVpcFlowLogsConfigsPagedResponse>() {
            @Override
            public ApiFuture<QueryOrgVpcFlowLogsConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryOrgVpcFlowLogsConfigsRequest, QueryOrgVpcFlowLogsConfigsResponse>
                    callable,
                QueryOrgVpcFlowLogsConfigsRequest request,
                ApiCallContext context,
                ApiFuture<QueryOrgVpcFlowLogsConfigsResponse> futureResponse) {
              PageContext<
                      QueryOrgVpcFlowLogsConfigsRequest,
                      QueryOrgVpcFlowLogsConfigsResponse,
                      VpcFlowLogsConfig>
                  pageContext =
                      PageContext.create(
                          callable,
                          QUERY_ORG_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_DESC,
                          request,
                          context);
              return QueryOrgVpcFlowLogsConfigsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listVpcFlowLogsConfigs. */
  public PagedCallSettings<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsSettings() {
    return listVpcFlowLogsConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getVpcFlowLogsConfig. */
  public UnaryCallSettings<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigSettings() {
    return getVpcFlowLogsConfigSettings;
  }

  /** Returns the object with the settings used for calls to createVpcFlowLogsConfig. */
  public UnaryCallSettings<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigSettings() {
    return createVpcFlowLogsConfigSettings;
  }

  /** Returns the object with the settings used for calls to createVpcFlowLogsConfig. */
  public OperationCallSettings<CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationSettings() {
    return createVpcFlowLogsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateVpcFlowLogsConfig. */
  public UnaryCallSettings<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigSettings() {
    return updateVpcFlowLogsConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateVpcFlowLogsConfig. */
  public OperationCallSettings<UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationSettings() {
    return updateVpcFlowLogsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVpcFlowLogsConfig. */
  public UnaryCallSettings<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigSettings() {
    return deleteVpcFlowLogsConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteVpcFlowLogsConfig. */
  public OperationCallSettings<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationSettings() {
    return deleteVpcFlowLogsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to queryOrgVpcFlowLogsConfigs. */
  public PagedCallSettings<
          QueryOrgVpcFlowLogsConfigsRequest,
          QueryOrgVpcFlowLogsConfigsResponse,
          QueryOrgVpcFlowLogsConfigsPagedResponse>
      queryOrgVpcFlowLogsConfigsSettings() {
    return queryOrgVpcFlowLogsConfigsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public VpcFlowLogsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVpcFlowLogsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVpcFlowLogsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networkmanagement";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networkmanagement.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkmanagement.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(VpcFlowLogsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VpcFlowLogsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VpcFlowLogsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected VpcFlowLogsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listVpcFlowLogsConfigsSettings = settingsBuilder.listVpcFlowLogsConfigsSettings().build();
    getVpcFlowLogsConfigSettings = settingsBuilder.getVpcFlowLogsConfigSettings().build();
    createVpcFlowLogsConfigSettings = settingsBuilder.createVpcFlowLogsConfigSettings().build();
    createVpcFlowLogsConfigOperationSettings =
        settingsBuilder.createVpcFlowLogsConfigOperationSettings().build();
    updateVpcFlowLogsConfigSettings = settingsBuilder.updateVpcFlowLogsConfigSettings().build();
    updateVpcFlowLogsConfigOperationSettings =
        settingsBuilder.updateVpcFlowLogsConfigOperationSettings().build();
    deleteVpcFlowLogsConfigSettings = settingsBuilder.deleteVpcFlowLogsConfigSettings().build();
    deleteVpcFlowLogsConfigOperationSettings =
        settingsBuilder.deleteVpcFlowLogsConfigOperationSettings().build();
    queryOrgVpcFlowLogsConfigsSettings =
        settingsBuilder.queryOrgVpcFlowLogsConfigsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for VpcFlowLogsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<VpcFlowLogsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListVpcFlowLogsConfigsRequest,
            ListVpcFlowLogsConfigsResponse,
            ListVpcFlowLogsConfigsPagedResponse>
        listVpcFlowLogsConfigsSettings;
    private final UnaryCallSettings.Builder<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
        getVpcFlowLogsConfigSettings;
    private final UnaryCallSettings.Builder<CreateVpcFlowLogsConfigRequest, Operation>
        createVpcFlowLogsConfigSettings;
    private final OperationCallSettings.Builder<
            CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
        createVpcFlowLogsConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateVpcFlowLogsConfigRequest, Operation>
        updateVpcFlowLogsConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
        updateVpcFlowLogsConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVpcFlowLogsConfigRequest, Operation>
        deleteVpcFlowLogsConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
        deleteVpcFlowLogsConfigOperationSettings;
    private final PagedCallSettings.Builder<
            QueryOrgVpcFlowLogsConfigsRequest,
            QueryOrgVpcFlowLogsConfigsResponse,
            QueryOrgVpcFlowLogsConfigsPagedResponse>
        queryOrgVpcFlowLogsConfigsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listVpcFlowLogsConfigsSettings =
          PagedCallSettings.newBuilder(LIST_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_FACT);
      getVpcFlowLogsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVpcFlowLogsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVpcFlowLogsConfigOperationSettings = OperationCallSettings.newBuilder();
      updateVpcFlowLogsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVpcFlowLogsConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteVpcFlowLogsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVpcFlowLogsConfigOperationSettings = OperationCallSettings.newBuilder();
      queryOrgVpcFlowLogsConfigsSettings =
          PagedCallSettings.newBuilder(QUERY_ORG_VPC_FLOW_LOGS_CONFIGS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listVpcFlowLogsConfigsSettings,
              getVpcFlowLogsConfigSettings,
              createVpcFlowLogsConfigSettings,
              updateVpcFlowLogsConfigSettings,
              deleteVpcFlowLogsConfigSettings,
              queryOrgVpcFlowLogsConfigsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(VpcFlowLogsServiceStubSettings settings) {
      super(settings);

      listVpcFlowLogsConfigsSettings = settings.listVpcFlowLogsConfigsSettings.toBuilder();
      getVpcFlowLogsConfigSettings = settings.getVpcFlowLogsConfigSettings.toBuilder();
      createVpcFlowLogsConfigSettings = settings.createVpcFlowLogsConfigSettings.toBuilder();
      createVpcFlowLogsConfigOperationSettings =
          settings.createVpcFlowLogsConfigOperationSettings.toBuilder();
      updateVpcFlowLogsConfigSettings = settings.updateVpcFlowLogsConfigSettings.toBuilder();
      updateVpcFlowLogsConfigOperationSettings =
          settings.updateVpcFlowLogsConfigOperationSettings.toBuilder();
      deleteVpcFlowLogsConfigSettings = settings.deleteVpcFlowLogsConfigSettings.toBuilder();
      deleteVpcFlowLogsConfigOperationSettings =
          settings.deleteVpcFlowLogsConfigOperationSettings.toBuilder();
      queryOrgVpcFlowLogsConfigsSettings = settings.queryOrgVpcFlowLogsConfigsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listVpcFlowLogsConfigsSettings,
              getVpcFlowLogsConfigSettings,
              createVpcFlowLogsConfigSettings,
              updateVpcFlowLogsConfigSettings,
              deleteVpcFlowLogsConfigSettings,
              queryOrgVpcFlowLogsConfigsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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
          .listVpcFlowLogsConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getVpcFlowLogsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createVpcFlowLogsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateVpcFlowLogsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteVpcFlowLogsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryOrgVpcFlowLogsConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createVpcFlowLogsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateVpcFlowLogsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VpcFlowLogsConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateVpcFlowLogsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateVpcFlowLogsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VpcFlowLogsConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteVpcFlowLogsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVpcFlowLogsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listVpcFlowLogsConfigs. */
    public PagedCallSettings.Builder<
            ListVpcFlowLogsConfigsRequest,
            ListVpcFlowLogsConfigsResponse,
            ListVpcFlowLogsConfigsPagedResponse>
        listVpcFlowLogsConfigsSettings() {
      return listVpcFlowLogsConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
        getVpcFlowLogsConfigSettings() {
      return getVpcFlowLogsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<CreateVpcFlowLogsConfigRequest, Operation>
        createVpcFlowLogsConfigSettings() {
      return createVpcFlowLogsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createVpcFlowLogsConfig. */
    public OperationCallSettings.Builder<
            CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
        createVpcFlowLogsConfigOperationSettings() {
      return createVpcFlowLogsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<UpdateVpcFlowLogsConfigRequest, Operation>
        updateVpcFlowLogsConfigSettings() {
      return updateVpcFlowLogsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateVpcFlowLogsConfig. */
    public OperationCallSettings.Builder<
            UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
        updateVpcFlowLogsConfigOperationSettings() {
      return updateVpcFlowLogsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<DeleteVpcFlowLogsConfigRequest, Operation>
        deleteVpcFlowLogsConfigSettings() {
      return deleteVpcFlowLogsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVpcFlowLogsConfig. */
    public OperationCallSettings.Builder<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
        deleteVpcFlowLogsConfigOperationSettings() {
      return deleteVpcFlowLogsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to queryOrgVpcFlowLogsConfigs. */
    public PagedCallSettings.Builder<
            QueryOrgVpcFlowLogsConfigsRequest,
            QueryOrgVpcFlowLogsConfigsResponse,
            QueryOrgVpcFlowLogsConfigsPagedResponse>
        queryOrgVpcFlowLogsConfigsSettings() {
      return queryOrgVpcFlowLogsConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public VpcFlowLogsServiceStubSettings build() throws IOException {
      return new VpcFlowLogsServiceStubSettings(this);
    }
  }
}
