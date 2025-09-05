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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListDestinationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferConfigsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferSupportedServicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.cloud.networkconnectivity.v1.CreateDestinationRequest;
import com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest;
import com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.Destination;
import com.google.cloud.networkconnectivity.v1.GetDestinationRequest;
import com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest;
import com.google.cloud.networkconnectivity.v1.ListDestinationsRequest;
import com.google.cloud.networkconnectivity.v1.ListDestinationsResponse;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesRequest;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesResponse;
import com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig;
import com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest;
import com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest;
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
 * Settings class to configure an instance of {@link DataTransferServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
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
 * of getMulticloudDataTransferConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTransferServiceStubSettings.Builder dataTransferServiceSettingsBuilder =
 *     DataTransferServiceStubSettings.newBuilder();
 * dataTransferServiceSettingsBuilder
 *     .getMulticloudDataTransferConfigSettings()
 *     .setRetrySettings(
 *         dataTransferServiceSettingsBuilder
 *             .getMulticloudDataTransferConfigSettings()
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
 * DataTransferServiceStubSettings dataTransferServiceSettings =
 *     dataTransferServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMulticloudDataTransferConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTransferServiceStubSettings.Builder dataTransferServiceSettingsBuilder =
 *     DataTransferServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataTransferServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataTransferServiceStubSettings extends StubSettings<DataTransferServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          ListMulticloudDataTransferConfigsPagedResponse>
      listMulticloudDataTransferConfigsSettings;
  private final UnaryCallSettings<
          GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigSettings;
  private final UnaryCallSettings<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigSettings;
  private final OperationCallSettings<
          CreateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      createMulticloudDataTransferConfigOperationSettings;
  private final UnaryCallSettings<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigSettings;
  private final OperationCallSettings<
          UpdateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      updateMulticloudDataTransferConfigOperationSettings;
  private final UnaryCallSettings<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigSettings;
  private final OperationCallSettings<
          DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
      deleteMulticloudDataTransferConfigOperationSettings;
  private final PagedCallSettings<
          ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>
      listDestinationsSettings;
  private final UnaryCallSettings<GetDestinationRequest, Destination> getDestinationSettings;
  private final UnaryCallSettings<CreateDestinationRequest, Operation> createDestinationSettings;
  private final OperationCallSettings<CreateDestinationRequest, Destination, OperationMetadata>
      createDestinationOperationSettings;
  private final UnaryCallSettings<UpdateDestinationRequest, Operation> updateDestinationSettings;
  private final OperationCallSettings<UpdateDestinationRequest, Destination, OperationMetadata>
      updateDestinationOperationSettings;
  private final UnaryCallSettings<DeleteDestinationRequest, Operation> deleteDestinationSettings;
  private final OperationCallSettings<DeleteDestinationRequest, Empty, OperationMetadata>
      deleteDestinationOperationSettings;
  private final UnaryCallSettings<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceSettings;
  private final PagedCallSettings<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      listMulticloudDataTransferSupportedServicesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          MulticloudDataTransferConfig>
      LIST_MULTICLOUD_DATA_TRANSFER_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMulticloudDataTransferConfigsRequest,
              ListMulticloudDataTransferConfigsResponse,
              MulticloudDataTransferConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMulticloudDataTransferConfigsRequest injectToken(
                ListMulticloudDataTransferConfigsRequest payload, String token) {
              return ListMulticloudDataTransferConfigsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMulticloudDataTransferConfigsRequest injectPageSize(
                ListMulticloudDataTransferConfigsRequest payload, int pageSize) {
              return ListMulticloudDataTransferConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMulticloudDataTransferConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMulticloudDataTransferConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MulticloudDataTransferConfig> extractResources(
                ListMulticloudDataTransferConfigsResponse payload) {
              return payload.getMulticloudDataTransferConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListDestinationsRequest, ListDestinationsResponse, Destination>
      LIST_DESTINATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDestinationsRequest, ListDestinationsResponse, Destination>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDestinationsRequest injectToken(
                ListDestinationsRequest payload, String token) {
              return ListDestinationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDestinationsRequest injectPageSize(
                ListDestinationsRequest payload, int pageSize) {
              return ListDestinationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDestinationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDestinationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Destination> extractResources(ListDestinationsResponse payload) {
              return payload.getDestinationsList();
            }
          };

  private static final PagedListDescriptor<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          MulticloudDataTransferSupportedService>
      LIST_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMulticloudDataTransferSupportedServicesRequest,
              ListMulticloudDataTransferSupportedServicesResponse,
              MulticloudDataTransferSupportedService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMulticloudDataTransferSupportedServicesRequest injectToken(
                ListMulticloudDataTransferSupportedServicesRequest payload, String token) {
              return ListMulticloudDataTransferSupportedServicesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMulticloudDataTransferSupportedServicesRequest injectPageSize(
                ListMulticloudDataTransferSupportedServicesRequest payload, int pageSize) {
              return ListMulticloudDataTransferSupportedServicesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListMulticloudDataTransferSupportedServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                ListMulticloudDataTransferSupportedServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MulticloudDataTransferSupportedService> extractResources(
                ListMulticloudDataTransferSupportedServicesResponse payload) {
              return payload.getMulticloudDataTransferSupportedServicesList();
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
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          ListMulticloudDataTransferConfigsPagedResponse>
      LIST_MULTICLOUD_DATA_TRANSFER_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMulticloudDataTransferConfigsRequest,
              ListMulticloudDataTransferConfigsResponse,
              ListMulticloudDataTransferConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListMulticloudDataTransferConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListMulticloudDataTransferConfigsRequest,
                        ListMulticloudDataTransferConfigsResponse>
                    callable,
                ListMulticloudDataTransferConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListMulticloudDataTransferConfigsResponse> futureResponse) {
              PageContext<
                      ListMulticloudDataTransferConfigsRequest,
                      ListMulticloudDataTransferConfigsResponse,
                      MulticloudDataTransferConfig>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MULTICLOUD_DATA_TRANSFER_CONFIGS_PAGE_STR_DESC,
                          request,
                          context);
              return ListMulticloudDataTransferConfigsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>
      LIST_DESTINATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>() {
            @Override
            public ApiFuture<ListDestinationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDestinationsRequest, ListDestinationsResponse> callable,
                ListDestinationsRequest request,
                ApiCallContext context,
                ApiFuture<ListDestinationsResponse> futureResponse) {
              PageContext<ListDestinationsRequest, ListDestinationsResponse, Destination>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DESTINATIONS_PAGE_STR_DESC, request, context);
              return ListDestinationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      LIST_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMulticloudDataTransferSupportedServicesRequest,
              ListMulticloudDataTransferSupportedServicesResponse,
              ListMulticloudDataTransferSupportedServicesPagedResponse>() {
            @Override
            public ApiFuture<ListMulticloudDataTransferSupportedServicesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListMulticloudDataTransferSupportedServicesRequest,
                            ListMulticloudDataTransferSupportedServicesResponse>
                        callable,
                    ListMulticloudDataTransferSupportedServicesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListMulticloudDataTransferSupportedServicesResponse> futureResponse) {
              PageContext<
                      ListMulticloudDataTransferSupportedServicesRequest,
                      ListMulticloudDataTransferSupportedServicesResponse,
                      MulticloudDataTransferSupportedService>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICES_PAGE_STR_DESC,
                          request,
                          context);
              return ListMulticloudDataTransferSupportedServicesPagedResponse.createAsync(
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

  /** Returns the object with the settings used for calls to listMulticloudDataTransferConfigs. */
  public PagedCallSettings<
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          ListMulticloudDataTransferConfigsPagedResponse>
      listMulticloudDataTransferConfigsSettings() {
    return listMulticloudDataTransferConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getMulticloudDataTransferConfig. */
  public UnaryCallSettings<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigSettings() {
    return getMulticloudDataTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to createMulticloudDataTransferConfig. */
  public UnaryCallSettings<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigSettings() {
    return createMulticloudDataTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to createMulticloudDataTransferConfig. */
  public OperationCallSettings<
          CreateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      createMulticloudDataTransferConfigOperationSettings() {
    return createMulticloudDataTransferConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMulticloudDataTransferConfig. */
  public UnaryCallSettings<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigSettings() {
    return updateMulticloudDataTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateMulticloudDataTransferConfig. */
  public OperationCallSettings<
          UpdateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      updateMulticloudDataTransferConfigOperationSettings() {
    return updateMulticloudDataTransferConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMulticloudDataTransferConfig. */
  public UnaryCallSettings<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigSettings() {
    return deleteMulticloudDataTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteMulticloudDataTransferConfig. */
  public OperationCallSettings<DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
      deleteMulticloudDataTransferConfigOperationSettings() {
    return deleteMulticloudDataTransferConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDestinations. */
  public PagedCallSettings<
          ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>
      listDestinationsSettings() {
    return listDestinationsSettings;
  }

  /** Returns the object with the settings used for calls to getDestination. */
  public UnaryCallSettings<GetDestinationRequest, Destination> getDestinationSettings() {
    return getDestinationSettings;
  }

  /** Returns the object with the settings used for calls to createDestination. */
  public UnaryCallSettings<CreateDestinationRequest, Operation> createDestinationSettings() {
    return createDestinationSettings;
  }

  /** Returns the object with the settings used for calls to createDestination. */
  public OperationCallSettings<CreateDestinationRequest, Destination, OperationMetadata>
      createDestinationOperationSettings() {
    return createDestinationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDestination. */
  public UnaryCallSettings<UpdateDestinationRequest, Operation> updateDestinationSettings() {
    return updateDestinationSettings;
  }

  /** Returns the object with the settings used for calls to updateDestination. */
  public OperationCallSettings<UpdateDestinationRequest, Destination, OperationMetadata>
      updateDestinationOperationSettings() {
    return updateDestinationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDestination. */
  public UnaryCallSettings<DeleteDestinationRequest, Operation> deleteDestinationSettings() {
    return deleteDestinationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDestination. */
  public OperationCallSettings<DeleteDestinationRequest, Empty, OperationMetadata>
      deleteDestinationOperationSettings() {
    return deleteDestinationOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * getMulticloudDataTransferSupportedService.
   */
  public UnaryCallSettings<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceSettings() {
    return getMulticloudDataTransferSupportedServiceSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * listMulticloudDataTransferSupportedServices.
   */
  public PagedCallSettings<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      listMulticloudDataTransferSupportedServicesSettings() {
    return listMulticloudDataTransferSupportedServicesSettings;
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

  public DataTransferServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataTransferServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networkconnectivity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networkconnectivity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkconnectivity.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataTransferServiceStubSettings.class))
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

  protected DataTransferServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listMulticloudDataTransferConfigsSettings =
        settingsBuilder.listMulticloudDataTransferConfigsSettings().build();
    getMulticloudDataTransferConfigSettings =
        settingsBuilder.getMulticloudDataTransferConfigSettings().build();
    createMulticloudDataTransferConfigSettings =
        settingsBuilder.createMulticloudDataTransferConfigSettings().build();
    createMulticloudDataTransferConfigOperationSettings =
        settingsBuilder.createMulticloudDataTransferConfigOperationSettings().build();
    updateMulticloudDataTransferConfigSettings =
        settingsBuilder.updateMulticloudDataTransferConfigSettings().build();
    updateMulticloudDataTransferConfigOperationSettings =
        settingsBuilder.updateMulticloudDataTransferConfigOperationSettings().build();
    deleteMulticloudDataTransferConfigSettings =
        settingsBuilder.deleteMulticloudDataTransferConfigSettings().build();
    deleteMulticloudDataTransferConfigOperationSettings =
        settingsBuilder.deleteMulticloudDataTransferConfigOperationSettings().build();
    listDestinationsSettings = settingsBuilder.listDestinationsSettings().build();
    getDestinationSettings = settingsBuilder.getDestinationSettings().build();
    createDestinationSettings = settingsBuilder.createDestinationSettings().build();
    createDestinationOperationSettings =
        settingsBuilder.createDestinationOperationSettings().build();
    updateDestinationSettings = settingsBuilder.updateDestinationSettings().build();
    updateDestinationOperationSettings =
        settingsBuilder.updateDestinationOperationSettings().build();
    deleteDestinationSettings = settingsBuilder.deleteDestinationSettings().build();
    deleteDestinationOperationSettings =
        settingsBuilder.deleteDestinationOperationSettings().build();
    getMulticloudDataTransferSupportedServiceSettings =
        settingsBuilder.getMulticloudDataTransferSupportedServiceSettings().build();
    listMulticloudDataTransferSupportedServicesSettings =
        settingsBuilder.listMulticloudDataTransferSupportedServicesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DataTransferServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataTransferServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListMulticloudDataTransferConfigsRequest,
            ListMulticloudDataTransferConfigsResponse,
            ListMulticloudDataTransferConfigsPagedResponse>
        listMulticloudDataTransferConfigsSettings;
    private final UnaryCallSettings.Builder<
            GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
        getMulticloudDataTransferConfigSettings;
    private final UnaryCallSettings.Builder<CreateMulticloudDataTransferConfigRequest, Operation>
        createMulticloudDataTransferConfigSettings;
    private final OperationCallSettings.Builder<
            CreateMulticloudDataTransferConfigRequest,
            MulticloudDataTransferConfig,
            OperationMetadata>
        createMulticloudDataTransferConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMulticloudDataTransferConfigRequest, Operation>
        updateMulticloudDataTransferConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateMulticloudDataTransferConfigRequest,
            MulticloudDataTransferConfig,
            OperationMetadata>
        updateMulticloudDataTransferConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMulticloudDataTransferConfigRequest, Operation>
        deleteMulticloudDataTransferConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
        deleteMulticloudDataTransferConfigOperationSettings;
    private final PagedCallSettings.Builder<
            ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>
        listDestinationsSettings;
    private final UnaryCallSettings.Builder<GetDestinationRequest, Destination>
        getDestinationSettings;
    private final UnaryCallSettings.Builder<CreateDestinationRequest, Operation>
        createDestinationSettings;
    private final OperationCallSettings.Builder<
            CreateDestinationRequest, Destination, OperationMetadata>
        createDestinationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDestinationRequest, Operation>
        updateDestinationSettings;
    private final OperationCallSettings.Builder<
            UpdateDestinationRequest, Destination, OperationMetadata>
        updateDestinationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDestinationRequest, Operation>
        deleteDestinationSettings;
    private final OperationCallSettings.Builder<DeleteDestinationRequest, Empty, OperationMetadata>
        deleteDestinationOperationSettings;
    private final UnaryCallSettings.Builder<
            GetMulticloudDataTransferSupportedServiceRequest,
            MulticloudDataTransferSupportedService>
        getMulticloudDataTransferSupportedServiceSettings;
    private final PagedCallSettings.Builder<
            ListMulticloudDataTransferSupportedServicesRequest,
            ListMulticloudDataTransferSupportedServicesResponse,
            ListMulticloudDataTransferSupportedServicesPagedResponse>
        listMulticloudDataTransferSupportedServicesSettings;
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
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listMulticloudDataTransferConfigsSettings =
          PagedCallSettings.newBuilder(LIST_MULTICLOUD_DATA_TRANSFER_CONFIGS_PAGE_STR_FACT);
      getMulticloudDataTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMulticloudDataTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMulticloudDataTransferConfigOperationSettings = OperationCallSettings.newBuilder();
      updateMulticloudDataTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMulticloudDataTransferConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteMulticloudDataTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMulticloudDataTransferConfigOperationSettings = OperationCallSettings.newBuilder();
      listDestinationsSettings = PagedCallSettings.newBuilder(LIST_DESTINATIONS_PAGE_STR_FACT);
      getDestinationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDestinationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDestinationOperationSettings = OperationCallSettings.newBuilder();
      updateDestinationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDestinationOperationSettings = OperationCallSettings.newBuilder();
      deleteDestinationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDestinationOperationSettings = OperationCallSettings.newBuilder();
      getMulticloudDataTransferSupportedServiceSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMulticloudDataTransferSupportedServicesSettings =
          PagedCallSettings.newBuilder(
              LIST_MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICES_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMulticloudDataTransferConfigsSettings,
              getMulticloudDataTransferConfigSettings,
              createMulticloudDataTransferConfigSettings,
              updateMulticloudDataTransferConfigSettings,
              deleteMulticloudDataTransferConfigSettings,
              listDestinationsSettings,
              getDestinationSettings,
              createDestinationSettings,
              updateDestinationSettings,
              deleteDestinationSettings,
              getMulticloudDataTransferSupportedServiceSettings,
              listMulticloudDataTransferSupportedServicesSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DataTransferServiceStubSettings settings) {
      super(settings);

      listMulticloudDataTransferConfigsSettings =
          settings.listMulticloudDataTransferConfigsSettings.toBuilder();
      getMulticloudDataTransferConfigSettings =
          settings.getMulticloudDataTransferConfigSettings.toBuilder();
      createMulticloudDataTransferConfigSettings =
          settings.createMulticloudDataTransferConfigSettings.toBuilder();
      createMulticloudDataTransferConfigOperationSettings =
          settings.createMulticloudDataTransferConfigOperationSettings.toBuilder();
      updateMulticloudDataTransferConfigSettings =
          settings.updateMulticloudDataTransferConfigSettings.toBuilder();
      updateMulticloudDataTransferConfigOperationSettings =
          settings.updateMulticloudDataTransferConfigOperationSettings.toBuilder();
      deleteMulticloudDataTransferConfigSettings =
          settings.deleteMulticloudDataTransferConfigSettings.toBuilder();
      deleteMulticloudDataTransferConfigOperationSettings =
          settings.deleteMulticloudDataTransferConfigOperationSettings.toBuilder();
      listDestinationsSettings = settings.listDestinationsSettings.toBuilder();
      getDestinationSettings = settings.getDestinationSettings.toBuilder();
      createDestinationSettings = settings.createDestinationSettings.toBuilder();
      createDestinationOperationSettings = settings.createDestinationOperationSettings.toBuilder();
      updateDestinationSettings = settings.updateDestinationSettings.toBuilder();
      updateDestinationOperationSettings = settings.updateDestinationOperationSettings.toBuilder();
      deleteDestinationSettings = settings.deleteDestinationSettings.toBuilder();
      deleteDestinationOperationSettings = settings.deleteDestinationOperationSettings.toBuilder();
      getMulticloudDataTransferSupportedServiceSettings =
          settings.getMulticloudDataTransferSupportedServiceSettings.toBuilder();
      listMulticloudDataTransferSupportedServicesSettings =
          settings.listMulticloudDataTransferSupportedServicesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMulticloudDataTransferConfigsSettings,
              getMulticloudDataTransferConfigSettings,
              createMulticloudDataTransferConfigSettings,
              updateMulticloudDataTransferConfigSettings,
              deleteMulticloudDataTransferConfigSettings,
              listDestinationsSettings,
              getDestinationSettings,
              createDestinationSettings,
              updateDestinationSettings,
              deleteDestinationSettings,
              getMulticloudDataTransferSupportedServiceSettings,
              listMulticloudDataTransferSupportedServicesSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listMulticloudDataTransferConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getMulticloudDataTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createMulticloudDataTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateMulticloudDataTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteMulticloudDataTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDestinationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getDestinationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createDestinationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDestinationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteDestinationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getMulticloudDataTransferSupportedServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listMulticloudDataTransferSupportedServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMulticloudDataTransferConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMulticloudDataTransferConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  MulticloudDataTransferConfig.class))
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
          .updateMulticloudDataTransferConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMulticloudDataTransferConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  MulticloudDataTransferConfig.class))
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
          .deleteMulticloudDataTransferConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMulticloudDataTransferConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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
          .createDestinationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDestinationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Destination.class))
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
          .updateDestinationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDestinationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Destination.class))
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
          .deleteDestinationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDestinationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listMulticloudDataTransferConfigs. */
    public PagedCallSettings.Builder<
            ListMulticloudDataTransferConfigsRequest,
            ListMulticloudDataTransferConfigsResponse,
            ListMulticloudDataTransferConfigsPagedResponse>
        listMulticloudDataTransferConfigsSettings() {
      return listMulticloudDataTransferConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getMulticloudDataTransferConfig. */
    public UnaryCallSettings.Builder<
            GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
        getMulticloudDataTransferConfigSettings() {
      return getMulticloudDataTransferConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createMulticloudDataTransferConfig.
     */
    public UnaryCallSettings.Builder<CreateMulticloudDataTransferConfigRequest, Operation>
        createMulticloudDataTransferConfigSettings() {
      return createMulticloudDataTransferConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createMulticloudDataTransferConfig.
     */
    public OperationCallSettings.Builder<
            CreateMulticloudDataTransferConfigRequest,
            MulticloudDataTransferConfig,
            OperationMetadata>
        createMulticloudDataTransferConfigOperationSettings() {
      return createMulticloudDataTransferConfigOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateMulticloudDataTransferConfig.
     */
    public UnaryCallSettings.Builder<UpdateMulticloudDataTransferConfigRequest, Operation>
        updateMulticloudDataTransferConfigSettings() {
      return updateMulticloudDataTransferConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateMulticloudDataTransferConfig.
     */
    public OperationCallSettings.Builder<
            UpdateMulticloudDataTransferConfigRequest,
            MulticloudDataTransferConfig,
            OperationMetadata>
        updateMulticloudDataTransferConfigOperationSettings() {
      return updateMulticloudDataTransferConfigOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteMulticloudDataTransferConfig.
     */
    public UnaryCallSettings.Builder<DeleteMulticloudDataTransferConfigRequest, Operation>
        deleteMulticloudDataTransferConfigSettings() {
      return deleteMulticloudDataTransferConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteMulticloudDataTransferConfig.
     */
    public OperationCallSettings.Builder<
            DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
        deleteMulticloudDataTransferConfigOperationSettings() {
      return deleteMulticloudDataTransferConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDestinations. */
    public PagedCallSettings.Builder<
            ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>
        listDestinationsSettings() {
      return listDestinationsSettings;
    }

    /** Returns the builder for the settings used for calls to getDestination. */
    public UnaryCallSettings.Builder<GetDestinationRequest, Destination> getDestinationSettings() {
      return getDestinationSettings;
    }

    /** Returns the builder for the settings used for calls to createDestination. */
    public UnaryCallSettings.Builder<CreateDestinationRequest, Operation>
        createDestinationSettings() {
      return createDestinationSettings;
    }

    /** Returns the builder for the settings used for calls to createDestination. */
    public OperationCallSettings.Builder<CreateDestinationRequest, Destination, OperationMetadata>
        createDestinationOperationSettings() {
      return createDestinationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDestination. */
    public UnaryCallSettings.Builder<UpdateDestinationRequest, Operation>
        updateDestinationSettings() {
      return updateDestinationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDestination. */
    public OperationCallSettings.Builder<UpdateDestinationRequest, Destination, OperationMetadata>
        updateDestinationOperationSettings() {
      return updateDestinationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDestination. */
    public UnaryCallSettings.Builder<DeleteDestinationRequest, Operation>
        deleteDestinationSettings() {
      return deleteDestinationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDestination. */
    public OperationCallSettings.Builder<DeleteDestinationRequest, Empty, OperationMetadata>
        deleteDestinationOperationSettings() {
      return deleteDestinationOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * getMulticloudDataTransferSupportedService.
     */
    public UnaryCallSettings.Builder<
            GetMulticloudDataTransferSupportedServiceRequest,
            MulticloudDataTransferSupportedService>
        getMulticloudDataTransferSupportedServiceSettings() {
      return getMulticloudDataTransferSupportedServiceSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listMulticloudDataTransferSupportedServices.
     */
    public PagedCallSettings.Builder<
            ListMulticloudDataTransferSupportedServicesRequest,
            ListMulticloudDataTransferSupportedServicesResponse,
            ListMulticloudDataTransferSupportedServicesPagedResponse>
        listMulticloudDataTransferSupportedServicesSettings() {
      return listMulticloudDataTransferSupportedServicesSettings;
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
    public DataTransferServiceStubSettings build() throws IOException {
      return new DataTransferServiceStubSettings(this);
    }
  }
}
