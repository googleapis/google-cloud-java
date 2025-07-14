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

package com.google.cloud.licensemanager.v1.stub;

import static com.google.cloud.licensemanager.v1.LicenseManagerClient.AggregateUsagePagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListConfigurationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListProductsPagedResponse;

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
import com.google.cloud.licensemanager.v1.AggregateUsageRequest;
import com.google.cloud.licensemanager.v1.AggregateUsageResponse;
import com.google.cloud.licensemanager.v1.Configuration;
import com.google.cloud.licensemanager.v1.CreateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeleteConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetInstanceRequest;
import com.google.cloud.licensemanager.v1.GetProductRequest;
import com.google.cloud.licensemanager.v1.Instance;
import com.google.cloud.licensemanager.v1.ListConfigurationsRequest;
import com.google.cloud.licensemanager.v1.ListConfigurationsResponse;
import com.google.cloud.licensemanager.v1.ListInstancesRequest;
import com.google.cloud.licensemanager.v1.ListInstancesResponse;
import com.google.cloud.licensemanager.v1.ListProductsRequest;
import com.google.cloud.licensemanager.v1.ListProductsResponse;
import com.google.cloud.licensemanager.v1.OperationMetadata;
import com.google.cloud.licensemanager.v1.Product;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse;
import com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.UpdateConfigurationRequest;
import com.google.cloud.licensemanager.v1.Usage;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LicenseManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (licensemanager.googleapis.com) and default port (443) are
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
 * of getConfiguration:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseManagerStubSettings.Builder licenseManagerSettingsBuilder =
 *     LicenseManagerStubSettings.newBuilder();
 * licenseManagerSettingsBuilder
 *     .getConfigurationSettings()
 *     .setRetrySettings(
 *         licenseManagerSettingsBuilder
 *             .getConfigurationSettings()
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
 * LicenseManagerStubSettings licenseManagerSettings = licenseManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createConfiguration:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseManagerStubSettings.Builder licenseManagerSettingsBuilder =
 *     LicenseManagerStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * licenseManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LicenseManagerStubSettings extends StubSettings<LicenseManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListConfigurationsRequest, ListConfigurationsResponse, ListConfigurationsPagedResponse>
      listConfigurationsSettings;
  private final UnaryCallSettings<GetConfigurationRequest, Configuration> getConfigurationSettings;
  private final UnaryCallSettings<CreateConfigurationRequest, Operation>
      createConfigurationSettings;
  private final OperationCallSettings<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationSettings;
  private final UnaryCallSettings<UpdateConfigurationRequest, Operation>
      updateConfigurationSettings;
  private final OperationCallSettings<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationSettings;
  private final UnaryCallSettings<DeleteConfigurationRequest, Operation>
      deleteConfigurationSettings;
  private final OperationCallSettings<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationSettings;
  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationSettings;
  private final OperationCallSettings<
          DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationSettings;
  private final UnaryCallSettings<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationSettings;
  private final OperationCallSettings<
          ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationSettings;
  private final UnaryCallSettings<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageSettings;
  private final PagedCallSettings<
          AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>
      aggregateUsageSettings;
  private final PagedCallSettings<
          ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings;
  private final UnaryCallSettings<GetProductRequest, Product> getProductSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListConfigurationsRequest, ListConfigurationsResponse, Configuration>
      LIST_CONFIGURATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConfigurationsRequest, ListConfigurationsResponse, Configuration>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConfigurationsRequest injectToken(
                ListConfigurationsRequest payload, String token) {
              return ListConfigurationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConfigurationsRequest injectPageSize(
                ListConfigurationsRequest payload, int pageSize) {
              return ListConfigurationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConfigurationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConfigurationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Configuration> extractResources(ListConfigurationsResponse payload) {
              return payload.getConfigurationsList();
            }
          };

  private static final PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>
      LIST_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesRequest injectToken(ListInstancesRequest payload, String token) {
              return ListInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstancesRequest injectPageSize(ListInstancesRequest payload, int pageSize) {
              return ListInstancesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstancesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Instance> extractResources(ListInstancesResponse payload) {
              return payload.getInstancesList();
            }
          };

  private static final PagedListDescriptor<AggregateUsageRequest, AggregateUsageResponse, Usage>
      AGGREGATE_USAGE_PAGE_STR_DESC =
          new PagedListDescriptor<AggregateUsageRequest, AggregateUsageResponse, Usage>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregateUsageRequest injectToken(AggregateUsageRequest payload, String token) {
              return AggregateUsageRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregateUsageRequest injectPageSize(
                AggregateUsageRequest payload, int pageSize) {
              return AggregateUsageRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(AggregateUsageRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(AggregateUsageResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Usage> extractResources(AggregateUsageResponse payload) {
              return payload.getUsagesList();
            }
          };

  private static final PagedListDescriptor<ListProductsRequest, ListProductsResponse, Product>
      LIST_PRODUCTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProductsRequest, ListProductsResponse, Product>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProductsRequest injectToken(ListProductsRequest payload, String token) {
              return ListProductsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProductsRequest injectPageSize(ListProductsRequest payload, int pageSize) {
              return ListProductsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProductsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProductsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Product> extractResources(ListProductsResponse payload) {
              return payload.getProductsList();
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
          ListConfigurationsRequest, ListConfigurationsResponse, ListConfigurationsPagedResponse>
      LIST_CONFIGURATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConfigurationsRequest,
              ListConfigurationsResponse,
              ListConfigurationsPagedResponse>() {
            @Override
            public ApiFuture<ListConfigurationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConfigurationsRequest, ListConfigurationsResponse> callable,
                ListConfigurationsRequest request,
                ApiCallContext context,
                ApiFuture<ListConfigurationsResponse> futureResponse) {
              PageContext<ListConfigurationsRequest, ListConfigurationsResponse, Configuration>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONFIGURATIONS_PAGE_STR_DESC, request, context);
              return ListConfigurationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      LIST_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesRequest, ListInstancesResponse> callable,
                ListInstancesRequest request,
                ApiCallContext context,
                ApiFuture<ListInstancesResponse> futureResponse) {
              PageContext<ListInstancesRequest, ListInstancesResponse, Instance> pageContext =
                  PageContext.create(callable, LIST_INSTANCES_PAGE_STR_DESC, request, context);
              return ListInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>
      AGGREGATE_USAGE_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>() {
            @Override
            public ApiFuture<AggregateUsagePagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregateUsageRequest, AggregateUsageResponse> callable,
                AggregateUsageRequest request,
                ApiCallContext context,
                ApiFuture<AggregateUsageResponse> futureResponse) {
              PageContext<AggregateUsageRequest, AggregateUsageResponse, Usage> pageContext =
                  PageContext.create(callable, AGGREGATE_USAGE_PAGE_STR_DESC, request, context);
              return AggregateUsagePagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      LIST_PRODUCTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>() {
            @Override
            public ApiFuture<ListProductsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProductsRequest, ListProductsResponse> callable,
                ListProductsRequest request,
                ApiCallContext context,
                ApiFuture<ListProductsResponse> futureResponse) {
              PageContext<ListProductsRequest, ListProductsResponse, Product> pageContext =
                  PageContext.create(callable, LIST_PRODUCTS_PAGE_STR_DESC, request, context);
              return ListProductsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listConfigurations. */
  public PagedCallSettings<
          ListConfigurationsRequest, ListConfigurationsResponse, ListConfigurationsPagedResponse>
      listConfigurationsSettings() {
    return listConfigurationsSettings;
  }

  /** Returns the object with the settings used for calls to getConfiguration. */
  public UnaryCallSettings<GetConfigurationRequest, Configuration> getConfigurationSettings() {
    return getConfigurationSettings;
  }

  /** Returns the object with the settings used for calls to createConfiguration. */
  public UnaryCallSettings<CreateConfigurationRequest, Operation> createConfigurationSettings() {
    return createConfigurationSettings;
  }

  /** Returns the object with the settings used for calls to createConfiguration. */
  public OperationCallSettings<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationSettings() {
    return createConfigurationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConfiguration. */
  public UnaryCallSettings<UpdateConfigurationRequest, Operation> updateConfigurationSettings() {
    return updateConfigurationSettings;
  }

  /** Returns the object with the settings used for calls to updateConfiguration. */
  public OperationCallSettings<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationSettings() {
    return updateConfigurationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConfiguration. */
  public UnaryCallSettings<DeleteConfigurationRequest, Operation> deleteConfigurationSettings() {
    return deleteConfigurationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConfiguration. */
  public OperationCallSettings<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationSettings() {
    return deleteConfigurationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to deactivateConfiguration. */
  public UnaryCallSettings<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationSettings() {
    return deactivateConfigurationSettings;
  }

  /** Returns the object with the settings used for calls to deactivateConfiguration. */
  public OperationCallSettings<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationSettings() {
    return deactivateConfigurationOperationSettings;
  }

  /** Returns the object with the settings used for calls to reactivateConfiguration. */
  public UnaryCallSettings<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationSettings() {
    return reactivateConfigurationSettings;
  }

  /** Returns the object with the settings used for calls to reactivateConfiguration. */
  public OperationCallSettings<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationSettings() {
    return reactivateConfigurationOperationSettings;
  }

  /** Returns the object with the settings used for calls to queryConfigurationLicenseUsage. */
  public UnaryCallSettings<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageSettings() {
    return queryConfigurationLicenseUsageSettings;
  }

  /** Returns the object with the settings used for calls to aggregateUsage. */
  public PagedCallSettings<
          AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>
      aggregateUsageSettings() {
    return aggregateUsageSettings;
  }

  /** Returns the object with the settings used for calls to listProducts. */
  public PagedCallSettings<ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings() {
    return listProductsSettings;
  }

  /** Returns the object with the settings used for calls to getProduct. */
  public UnaryCallSettings<GetProductRequest, Product> getProductSettings() {
    return getProductSettings;
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

  public LicenseManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLicenseManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLicenseManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "licensemanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "licensemanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "licensemanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(LicenseManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(LicenseManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LicenseManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected LicenseManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listConfigurationsSettings = settingsBuilder.listConfigurationsSettings().build();
    getConfigurationSettings = settingsBuilder.getConfigurationSettings().build();
    createConfigurationSettings = settingsBuilder.createConfigurationSettings().build();
    createConfigurationOperationSettings =
        settingsBuilder.createConfigurationOperationSettings().build();
    updateConfigurationSettings = settingsBuilder.updateConfigurationSettings().build();
    updateConfigurationOperationSettings =
        settingsBuilder.updateConfigurationOperationSettings().build();
    deleteConfigurationSettings = settingsBuilder.deleteConfigurationSettings().build();
    deleteConfigurationOperationSettings =
        settingsBuilder.deleteConfigurationOperationSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    deactivateConfigurationSettings = settingsBuilder.deactivateConfigurationSettings().build();
    deactivateConfigurationOperationSettings =
        settingsBuilder.deactivateConfigurationOperationSettings().build();
    reactivateConfigurationSettings = settingsBuilder.reactivateConfigurationSettings().build();
    reactivateConfigurationOperationSettings =
        settingsBuilder.reactivateConfigurationOperationSettings().build();
    queryConfigurationLicenseUsageSettings =
        settingsBuilder.queryConfigurationLicenseUsageSettings().build();
    aggregateUsageSettings = settingsBuilder.aggregateUsageSettings().build();
    listProductsSettings = settingsBuilder.listProductsSettings().build();
    getProductSettings = settingsBuilder.getProductSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for LicenseManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<LicenseManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListConfigurationsRequest, ListConfigurationsResponse, ListConfigurationsPagedResponse>
        listConfigurationsSettings;
    private final UnaryCallSettings.Builder<GetConfigurationRequest, Configuration>
        getConfigurationSettings;
    private final UnaryCallSettings.Builder<CreateConfigurationRequest, Operation>
        createConfigurationSettings;
    private final OperationCallSettings.Builder<
            CreateConfigurationRequest, Configuration, OperationMetadata>
        createConfigurationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConfigurationRequest, Operation>
        updateConfigurationSettings;
    private final OperationCallSettings.Builder<
            UpdateConfigurationRequest, Configuration, OperationMetadata>
        updateConfigurationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConfigurationRequest, Operation>
        deleteConfigurationSettings;
    private final OperationCallSettings.Builder<
            DeleteConfigurationRequest, Empty, OperationMetadata>
        deleteConfigurationOperationSettings;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<DeactivateConfigurationRequest, Operation>
        deactivateConfigurationSettings;
    private final OperationCallSettings.Builder<
            DeactivateConfigurationRequest, Configuration, OperationMetadata>
        deactivateConfigurationOperationSettings;
    private final UnaryCallSettings.Builder<ReactivateConfigurationRequest, Operation>
        reactivateConfigurationSettings;
    private final OperationCallSettings.Builder<
            ReactivateConfigurationRequest, Configuration, OperationMetadata>
        reactivateConfigurationOperationSettings;
    private final UnaryCallSettings.Builder<
            QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
        queryConfigurationLicenseUsageSettings;
    private final PagedCallSettings.Builder<
            AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>
        aggregateUsageSettings;
    private final PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings;
    private final UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listConfigurationsSettings = PagedCallSettings.newBuilder(LIST_CONFIGURATIONS_PAGE_STR_FACT);
      getConfigurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConfigurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConfigurationOperationSettings = OperationCallSettings.newBuilder();
      updateConfigurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConfigurationOperationSettings = OperationCallSettings.newBuilder();
      deleteConfigurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConfigurationOperationSettings = OperationCallSettings.newBuilder();
      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deactivateConfigurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deactivateConfigurationOperationSettings = OperationCallSettings.newBuilder();
      reactivateConfigurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reactivateConfigurationOperationSettings = OperationCallSettings.newBuilder();
      queryConfigurationLicenseUsageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      aggregateUsageSettings = PagedCallSettings.newBuilder(AGGREGATE_USAGE_PAGE_STR_FACT);
      listProductsSettings = PagedCallSettings.newBuilder(LIST_PRODUCTS_PAGE_STR_FACT);
      getProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConfigurationsSettings,
              getConfigurationSettings,
              createConfigurationSettings,
              updateConfigurationSettings,
              deleteConfigurationSettings,
              listInstancesSettings,
              getInstanceSettings,
              deactivateConfigurationSettings,
              reactivateConfigurationSettings,
              queryConfigurationLicenseUsageSettings,
              aggregateUsageSettings,
              listProductsSettings,
              getProductSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(LicenseManagerStubSettings settings) {
      super(settings);

      listConfigurationsSettings = settings.listConfigurationsSettings.toBuilder();
      getConfigurationSettings = settings.getConfigurationSettings.toBuilder();
      createConfigurationSettings = settings.createConfigurationSettings.toBuilder();
      createConfigurationOperationSettings =
          settings.createConfigurationOperationSettings.toBuilder();
      updateConfigurationSettings = settings.updateConfigurationSettings.toBuilder();
      updateConfigurationOperationSettings =
          settings.updateConfigurationOperationSettings.toBuilder();
      deleteConfigurationSettings = settings.deleteConfigurationSettings.toBuilder();
      deleteConfigurationOperationSettings =
          settings.deleteConfigurationOperationSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      deactivateConfigurationSettings = settings.deactivateConfigurationSettings.toBuilder();
      deactivateConfigurationOperationSettings =
          settings.deactivateConfigurationOperationSettings.toBuilder();
      reactivateConfigurationSettings = settings.reactivateConfigurationSettings.toBuilder();
      reactivateConfigurationOperationSettings =
          settings.reactivateConfigurationOperationSettings.toBuilder();
      queryConfigurationLicenseUsageSettings =
          settings.queryConfigurationLicenseUsageSettings.toBuilder();
      aggregateUsageSettings = settings.aggregateUsageSettings.toBuilder();
      listProductsSettings = settings.listProductsSettings.toBuilder();
      getProductSettings = settings.getProductSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConfigurationsSettings,
              getConfigurationSettings,
              createConfigurationSettings,
              updateConfigurationSettings,
              deleteConfigurationSettings,
              listInstancesSettings,
              getInstanceSettings,
              deactivateConfigurationSettings,
              reactivateConfigurationSettings,
              queryConfigurationLicenseUsageSettings,
              aggregateUsageSettings,
              listProductsSettings,
              getProductSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listConfigurationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConfigurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConfigurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateConfigurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConfigurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deactivateConfigurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .reactivateConfigurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryConfigurationLicenseUsageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .aggregateUsageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listProductsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createConfigurationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConfigurationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Configuration.class))
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
          .updateConfigurationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateConfigurationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Configuration.class))
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
          .deleteConfigurationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConfigurationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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

      builder
          .deactivateConfigurationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeactivateConfigurationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Configuration.class))
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
          .reactivateConfigurationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReactivateConfigurationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Configuration.class))
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

    /** Returns the builder for the settings used for calls to listConfigurations. */
    public PagedCallSettings.Builder<
            ListConfigurationsRequest, ListConfigurationsResponse, ListConfigurationsPagedResponse>
        listConfigurationsSettings() {
      return listConfigurationsSettings;
    }

    /** Returns the builder for the settings used for calls to getConfiguration. */
    public UnaryCallSettings.Builder<GetConfigurationRequest, Configuration>
        getConfigurationSettings() {
      return getConfigurationSettings;
    }

    /** Returns the builder for the settings used for calls to createConfiguration. */
    public UnaryCallSettings.Builder<CreateConfigurationRequest, Operation>
        createConfigurationSettings() {
      return createConfigurationSettings;
    }

    /** Returns the builder for the settings used for calls to createConfiguration. */
    public OperationCallSettings.Builder<
            CreateConfigurationRequest, Configuration, OperationMetadata>
        createConfigurationOperationSettings() {
      return createConfigurationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConfiguration. */
    public UnaryCallSettings.Builder<UpdateConfigurationRequest, Operation>
        updateConfigurationSettings() {
      return updateConfigurationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConfiguration. */
    public OperationCallSettings.Builder<
            UpdateConfigurationRequest, Configuration, OperationMetadata>
        updateConfigurationOperationSettings() {
      return updateConfigurationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConfiguration. */
    public UnaryCallSettings.Builder<DeleteConfigurationRequest, Operation>
        deleteConfigurationSettings() {
      return deleteConfigurationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConfiguration. */
    public OperationCallSettings.Builder<DeleteConfigurationRequest, Empty, OperationMetadata>
        deleteConfigurationOperationSettings() {
      return deleteConfigurationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to deactivateConfiguration. */
    public UnaryCallSettings.Builder<DeactivateConfigurationRequest, Operation>
        deactivateConfigurationSettings() {
      return deactivateConfigurationSettings;
    }

    /** Returns the builder for the settings used for calls to deactivateConfiguration. */
    public OperationCallSettings.Builder<
            DeactivateConfigurationRequest, Configuration, OperationMetadata>
        deactivateConfigurationOperationSettings() {
      return deactivateConfigurationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reactivateConfiguration. */
    public UnaryCallSettings.Builder<ReactivateConfigurationRequest, Operation>
        reactivateConfigurationSettings() {
      return reactivateConfigurationSettings;
    }

    /** Returns the builder for the settings used for calls to reactivateConfiguration. */
    public OperationCallSettings.Builder<
            ReactivateConfigurationRequest, Configuration, OperationMetadata>
        reactivateConfigurationOperationSettings() {
      return reactivateConfigurationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to queryConfigurationLicenseUsage. */
    public UnaryCallSettings.Builder<
            QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
        queryConfigurationLicenseUsageSettings() {
      return queryConfigurationLicenseUsageSettings;
    }

    /** Returns the builder for the settings used for calls to aggregateUsage. */
    public PagedCallSettings.Builder<
            AggregateUsageRequest, AggregateUsageResponse, AggregateUsagePagedResponse>
        aggregateUsageSettings() {
      return aggregateUsageSettings;
    }

    /** Returns the builder for the settings used for calls to listProducts. */
    public PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings() {
      return listProductsSettings;
    }

    /** Returns the builder for the settings used for calls to getProduct. */
    public UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings() {
      return getProductSettings;
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

    @Override
    public LicenseManagerStubSettings build() throws IOException {
      return new LicenseManagerStubSettings(this);
    }
  }
}
