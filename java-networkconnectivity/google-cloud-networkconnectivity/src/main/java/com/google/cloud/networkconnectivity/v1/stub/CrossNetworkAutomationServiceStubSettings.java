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

import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceClassesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionMapsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionPoliciesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionTokensPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.ServiceClass;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionMap;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionToken;
import com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest;
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
 * Settings class to configure an instance of {@link CrossNetworkAutomationServiceStub}.
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
 * of getServiceConnectionMap:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CrossNetworkAutomationServiceStubSettings.Builder crossNetworkAutomationServiceSettingsBuilder =
 *     CrossNetworkAutomationServiceStubSettings.newBuilder();
 * crossNetworkAutomationServiceSettingsBuilder
 *     .getServiceConnectionMapSettings()
 *     .setRetrySettings(
 *         crossNetworkAutomationServiceSettingsBuilder
 *             .getServiceConnectionMapSettings()
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
 * CrossNetworkAutomationServiceStubSettings crossNetworkAutomationServiceSettings =
 *     crossNetworkAutomationServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createServiceConnectionMap:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CrossNetworkAutomationServiceStubSettings.Builder crossNetworkAutomationServiceSettingsBuilder =
 *     CrossNetworkAutomationServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * crossNetworkAutomationServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CrossNetworkAutomationServiceStubSettings
    extends StubSettings<CrossNetworkAutomationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListServiceConnectionMapsRequest,
          ListServiceConnectionMapsResponse,
          ListServiceConnectionMapsPagedResponse>
      listServiceConnectionMapsSettings;
  private final UnaryCallSettings<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapSettings;
  private final UnaryCallSettings<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapSettings;
  private final OperationCallSettings<
          CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapOperationSettings;
  private final UnaryCallSettings<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapSettings;
  private final OperationCallSettings<
          UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapOperationSettings;
  private final UnaryCallSettings<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapSettings;
  private final OperationCallSettings<DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
      deleteServiceConnectionMapOperationSettings;
  private final PagedCallSettings<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ListServiceConnectionPoliciesPagedResponse>
      listServiceConnectionPoliciesSettings;
  private final UnaryCallSettings<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicySettings;
  private final UnaryCallSettings<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicySettings;
  private final OperationCallSettings<
          CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyOperationSettings;
  private final UnaryCallSettings<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicySettings;
  private final OperationCallSettings<
          UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyOperationSettings;
  private final UnaryCallSettings<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicySettings;
  private final OperationCallSettings<
          DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
      deleteServiceConnectionPolicyOperationSettings;
  private final PagedCallSettings<
          ListServiceClassesRequest, ListServiceClassesResponse, ListServiceClassesPagedResponse>
      listServiceClassesSettings;
  private final UnaryCallSettings<GetServiceClassRequest, ServiceClass> getServiceClassSettings;
  private final UnaryCallSettings<UpdateServiceClassRequest, Operation> updateServiceClassSettings;
  private final OperationCallSettings<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
      updateServiceClassOperationSettings;
  private final UnaryCallSettings<DeleteServiceClassRequest, Operation> deleteServiceClassSettings;
  private final OperationCallSettings<DeleteServiceClassRequest, Empty, OperationMetadata>
      deleteServiceClassOperationSettings;
  private final UnaryCallSettings<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenSettings;
  private final PagedCallSettings<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ListServiceConnectionTokensPagedResponse>
      listServiceConnectionTokensSettings;
  private final UnaryCallSettings<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenSettings;
  private final OperationCallSettings<
          CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenOperationSettings;
  private final UnaryCallSettings<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenSettings;
  private final OperationCallSettings<DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
      deleteServiceConnectionTokenOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse, ServiceConnectionMap>
      LIST_SERVICE_CONNECTION_MAPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServiceConnectionMapsRequest,
              ListServiceConnectionMapsResponse,
              ServiceConnectionMap>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServiceConnectionMapsRequest injectToken(
                ListServiceConnectionMapsRequest payload, String token) {
              return ListServiceConnectionMapsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListServiceConnectionMapsRequest injectPageSize(
                ListServiceConnectionMapsRequest payload, int pageSize) {
              return ListServiceConnectionMapsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListServiceConnectionMapsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServiceConnectionMapsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServiceConnectionMap> extractResources(
                ListServiceConnectionMapsResponse payload) {
              return payload.getServiceConnectionMapsList();
            }
          };

  private static final PagedListDescriptor<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ServiceConnectionPolicy>
      LIST_SERVICE_CONNECTION_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServiceConnectionPoliciesRequest,
              ListServiceConnectionPoliciesResponse,
              ServiceConnectionPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServiceConnectionPoliciesRequest injectToken(
                ListServiceConnectionPoliciesRequest payload, String token) {
              return ListServiceConnectionPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListServiceConnectionPoliciesRequest injectPageSize(
                ListServiceConnectionPoliciesRequest payload, int pageSize) {
              return ListServiceConnectionPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListServiceConnectionPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServiceConnectionPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServiceConnectionPolicy> extractResources(
                ListServiceConnectionPoliciesResponse payload) {
              return payload.getServiceConnectionPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListServiceClassesRequest, ListServiceClassesResponse, ServiceClass>
      LIST_SERVICE_CLASSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServiceClassesRequest, ListServiceClassesResponse, ServiceClass>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServiceClassesRequest injectToken(
                ListServiceClassesRequest payload, String token) {
              return ListServiceClassesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServiceClassesRequest injectPageSize(
                ListServiceClassesRequest payload, int pageSize) {
              return ListServiceClassesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServiceClassesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServiceClassesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServiceClass> extractResources(ListServiceClassesResponse payload) {
              return payload.getServiceClassesList();
            }
          };

  private static final PagedListDescriptor<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ServiceConnectionToken>
      LIST_SERVICE_CONNECTION_TOKENS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServiceConnectionTokensRequest,
              ListServiceConnectionTokensResponse,
              ServiceConnectionToken>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServiceConnectionTokensRequest injectToken(
                ListServiceConnectionTokensRequest payload, String token) {
              return ListServiceConnectionTokensRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListServiceConnectionTokensRequest injectPageSize(
                ListServiceConnectionTokensRequest payload, int pageSize) {
              return ListServiceConnectionTokensRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListServiceConnectionTokensRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServiceConnectionTokensResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServiceConnectionToken> extractResources(
                ListServiceConnectionTokensResponse payload) {
              return payload.getServiceConnectionTokensList();
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
          ListServiceConnectionMapsRequest,
          ListServiceConnectionMapsResponse,
          ListServiceConnectionMapsPagedResponse>
      LIST_SERVICE_CONNECTION_MAPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServiceConnectionMapsRequest,
              ListServiceConnectionMapsResponse,
              ListServiceConnectionMapsPagedResponse>() {
            @Override
            public ApiFuture<ListServiceConnectionMapsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>
                    callable,
                ListServiceConnectionMapsRequest request,
                ApiCallContext context,
                ApiFuture<ListServiceConnectionMapsResponse> futureResponse) {
              PageContext<
                      ListServiceConnectionMapsRequest,
                      ListServiceConnectionMapsResponse,
                      ServiceConnectionMap>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SERVICE_CONNECTION_MAPS_PAGE_STR_DESC, request, context);
              return ListServiceConnectionMapsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ListServiceConnectionPoliciesPagedResponse>
      LIST_SERVICE_CONNECTION_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServiceConnectionPoliciesRequest,
              ListServiceConnectionPoliciesResponse,
              ListServiceConnectionPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListServiceConnectionPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
                    callable,
                ListServiceConnectionPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListServiceConnectionPoliciesResponse> futureResponse) {
              PageContext<
                      ListServiceConnectionPoliciesRequest,
                      ListServiceConnectionPoliciesResponse,
                      ServiceConnectionPolicy>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_SERVICE_CONNECTION_POLICIES_PAGE_STR_DESC,
                          request,
                          context);
              return ListServiceConnectionPoliciesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServiceClassesRequest, ListServiceClassesResponse, ListServiceClassesPagedResponse>
      LIST_SERVICE_CLASSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServiceClassesRequest,
              ListServiceClassesResponse,
              ListServiceClassesPagedResponse>() {
            @Override
            public ApiFuture<ListServiceClassesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServiceClassesRequest, ListServiceClassesResponse> callable,
                ListServiceClassesRequest request,
                ApiCallContext context,
                ApiFuture<ListServiceClassesResponse> futureResponse) {
              PageContext<ListServiceClassesRequest, ListServiceClassesResponse, ServiceClass>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SERVICE_CLASSES_PAGE_STR_DESC, request, context);
              return ListServiceClassesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ListServiceConnectionTokensPagedResponse>
      LIST_SERVICE_CONNECTION_TOKENS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServiceConnectionTokensRequest,
              ListServiceConnectionTokensResponse,
              ListServiceConnectionTokensPagedResponse>() {
            @Override
            public ApiFuture<ListServiceConnectionTokensPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
                    callable,
                ListServiceConnectionTokensRequest request,
                ApiCallContext context,
                ApiFuture<ListServiceConnectionTokensResponse> futureResponse) {
              PageContext<
                      ListServiceConnectionTokensRequest,
                      ListServiceConnectionTokensResponse,
                      ServiceConnectionToken>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SERVICE_CONNECTION_TOKENS_PAGE_STR_DESC, request, context);
              return ListServiceConnectionTokensPagedResponse.createAsync(
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

  /** Returns the object with the settings used for calls to listServiceConnectionMaps. */
  public PagedCallSettings<
          ListServiceConnectionMapsRequest,
          ListServiceConnectionMapsResponse,
          ListServiceConnectionMapsPagedResponse>
      listServiceConnectionMapsSettings() {
    return listServiceConnectionMapsSettings;
  }

  /** Returns the object with the settings used for calls to getServiceConnectionMap. */
  public UnaryCallSettings<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapSettings() {
    return getServiceConnectionMapSettings;
  }

  /** Returns the object with the settings used for calls to createServiceConnectionMap. */
  public UnaryCallSettings<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapSettings() {
    return createServiceConnectionMapSettings;
  }

  /** Returns the object with the settings used for calls to createServiceConnectionMap. */
  public OperationCallSettings<
          CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapOperationSettings() {
    return createServiceConnectionMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionMap. */
  public UnaryCallSettings<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapSettings() {
    return updateServiceConnectionMapSettings;
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionMap. */
  public OperationCallSettings<
          UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapOperationSettings() {
    return updateServiceConnectionMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionMap. */
  public UnaryCallSettings<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapSettings() {
    return deleteServiceConnectionMapSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionMap. */
  public OperationCallSettings<DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
      deleteServiceConnectionMapOperationSettings() {
    return deleteServiceConnectionMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to listServiceConnectionPolicies. */
  public PagedCallSettings<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ListServiceConnectionPoliciesPagedResponse>
      listServiceConnectionPoliciesSettings() {
    return listServiceConnectionPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getServiceConnectionPolicy. */
  public UnaryCallSettings<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicySettings() {
    return getServiceConnectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to createServiceConnectionPolicy. */
  public UnaryCallSettings<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicySettings() {
    return createServiceConnectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to createServiceConnectionPolicy. */
  public OperationCallSettings<
          CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyOperationSettings() {
    return createServiceConnectionPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionPolicy. */
  public UnaryCallSettings<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicySettings() {
    return updateServiceConnectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionPolicy. */
  public OperationCallSettings<
          UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyOperationSettings() {
    return updateServiceConnectionPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionPolicy. */
  public UnaryCallSettings<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicySettings() {
    return deleteServiceConnectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionPolicy. */
  public OperationCallSettings<DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
      deleteServiceConnectionPolicyOperationSettings() {
    return deleteServiceConnectionPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listServiceClasses. */
  public PagedCallSettings<
          ListServiceClassesRequest, ListServiceClassesResponse, ListServiceClassesPagedResponse>
      listServiceClassesSettings() {
    return listServiceClassesSettings;
  }

  /** Returns the object with the settings used for calls to getServiceClass. */
  public UnaryCallSettings<GetServiceClassRequest, ServiceClass> getServiceClassSettings() {
    return getServiceClassSettings;
  }

  /** Returns the object with the settings used for calls to updateServiceClass. */
  public UnaryCallSettings<UpdateServiceClassRequest, Operation> updateServiceClassSettings() {
    return updateServiceClassSettings;
  }

  /** Returns the object with the settings used for calls to updateServiceClass. */
  public OperationCallSettings<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
      updateServiceClassOperationSettings() {
    return updateServiceClassOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceClass. */
  public UnaryCallSettings<DeleteServiceClassRequest, Operation> deleteServiceClassSettings() {
    return deleteServiceClassSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceClass. */
  public OperationCallSettings<DeleteServiceClassRequest, Empty, OperationMetadata>
      deleteServiceClassOperationSettings() {
    return deleteServiceClassOperationSettings;
  }

  /** Returns the object with the settings used for calls to getServiceConnectionToken. */
  public UnaryCallSettings<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenSettings() {
    return getServiceConnectionTokenSettings;
  }

  /** Returns the object with the settings used for calls to listServiceConnectionTokens. */
  public PagedCallSettings<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ListServiceConnectionTokensPagedResponse>
      listServiceConnectionTokensSettings() {
    return listServiceConnectionTokensSettings;
  }

  /** Returns the object with the settings used for calls to createServiceConnectionToken. */
  public UnaryCallSettings<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenSettings() {
    return createServiceConnectionTokenSettings;
  }

  /** Returns the object with the settings used for calls to createServiceConnectionToken. */
  public OperationCallSettings<
          CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenOperationSettings() {
    return createServiceConnectionTokenOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionToken. */
  public UnaryCallSettings<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenSettings() {
    return deleteServiceConnectionTokenSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionToken. */
  public OperationCallSettings<DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
      deleteServiceConnectionTokenOperationSettings() {
    return deleteServiceConnectionTokenOperationSettings;
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

  public CrossNetworkAutomationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCrossNetworkAutomationServiceStub.create(this);
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
            "gapic",
            GaxProperties.getLibraryVersion(CrossNetworkAutomationServiceStubSettings.class))
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

  protected CrossNetworkAutomationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listServiceConnectionMapsSettings = settingsBuilder.listServiceConnectionMapsSettings().build();
    getServiceConnectionMapSettings = settingsBuilder.getServiceConnectionMapSettings().build();
    createServiceConnectionMapSettings =
        settingsBuilder.createServiceConnectionMapSettings().build();
    createServiceConnectionMapOperationSettings =
        settingsBuilder.createServiceConnectionMapOperationSettings().build();
    updateServiceConnectionMapSettings =
        settingsBuilder.updateServiceConnectionMapSettings().build();
    updateServiceConnectionMapOperationSettings =
        settingsBuilder.updateServiceConnectionMapOperationSettings().build();
    deleteServiceConnectionMapSettings =
        settingsBuilder.deleteServiceConnectionMapSettings().build();
    deleteServiceConnectionMapOperationSettings =
        settingsBuilder.deleteServiceConnectionMapOperationSettings().build();
    listServiceConnectionPoliciesSettings =
        settingsBuilder.listServiceConnectionPoliciesSettings().build();
    getServiceConnectionPolicySettings =
        settingsBuilder.getServiceConnectionPolicySettings().build();
    createServiceConnectionPolicySettings =
        settingsBuilder.createServiceConnectionPolicySettings().build();
    createServiceConnectionPolicyOperationSettings =
        settingsBuilder.createServiceConnectionPolicyOperationSettings().build();
    updateServiceConnectionPolicySettings =
        settingsBuilder.updateServiceConnectionPolicySettings().build();
    updateServiceConnectionPolicyOperationSettings =
        settingsBuilder.updateServiceConnectionPolicyOperationSettings().build();
    deleteServiceConnectionPolicySettings =
        settingsBuilder.deleteServiceConnectionPolicySettings().build();
    deleteServiceConnectionPolicyOperationSettings =
        settingsBuilder.deleteServiceConnectionPolicyOperationSettings().build();
    listServiceClassesSettings = settingsBuilder.listServiceClassesSettings().build();
    getServiceClassSettings = settingsBuilder.getServiceClassSettings().build();
    updateServiceClassSettings = settingsBuilder.updateServiceClassSettings().build();
    updateServiceClassOperationSettings =
        settingsBuilder.updateServiceClassOperationSettings().build();
    deleteServiceClassSettings = settingsBuilder.deleteServiceClassSettings().build();
    deleteServiceClassOperationSettings =
        settingsBuilder.deleteServiceClassOperationSettings().build();
    getServiceConnectionTokenSettings = settingsBuilder.getServiceConnectionTokenSettings().build();
    listServiceConnectionTokensSettings =
        settingsBuilder.listServiceConnectionTokensSettings().build();
    createServiceConnectionTokenSettings =
        settingsBuilder.createServiceConnectionTokenSettings().build();
    createServiceConnectionTokenOperationSettings =
        settingsBuilder.createServiceConnectionTokenOperationSettings().build();
    deleteServiceConnectionTokenSettings =
        settingsBuilder.deleteServiceConnectionTokenSettings().build();
    deleteServiceConnectionTokenOperationSettings =
        settingsBuilder.deleteServiceConnectionTokenOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for CrossNetworkAutomationServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CrossNetworkAutomationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListServiceConnectionMapsRequest,
            ListServiceConnectionMapsResponse,
            ListServiceConnectionMapsPagedResponse>
        listServiceConnectionMapsSettings;
    private final UnaryCallSettings.Builder<GetServiceConnectionMapRequest, ServiceConnectionMap>
        getServiceConnectionMapSettings;
    private final UnaryCallSettings.Builder<CreateServiceConnectionMapRequest, Operation>
        createServiceConnectionMapSettings;
    private final OperationCallSettings.Builder<
            CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
        createServiceConnectionMapOperationSettings;
    private final UnaryCallSettings.Builder<UpdateServiceConnectionMapRequest, Operation>
        updateServiceConnectionMapSettings;
    private final OperationCallSettings.Builder<
            UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
        updateServiceConnectionMapOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceConnectionMapRequest, Operation>
        deleteServiceConnectionMapSettings;
    private final OperationCallSettings.Builder<
            DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
        deleteServiceConnectionMapOperationSettings;
    private final PagedCallSettings.Builder<
            ListServiceConnectionPoliciesRequest,
            ListServiceConnectionPoliciesResponse,
            ListServiceConnectionPoliciesPagedResponse>
        listServiceConnectionPoliciesSettings;
    private final UnaryCallSettings.Builder<
            GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
        getServiceConnectionPolicySettings;
    private final UnaryCallSettings.Builder<CreateServiceConnectionPolicyRequest, Operation>
        createServiceConnectionPolicySettings;
    private final OperationCallSettings.Builder<
            CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
        createServiceConnectionPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateServiceConnectionPolicyRequest, Operation>
        updateServiceConnectionPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
        updateServiceConnectionPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceConnectionPolicyRequest, Operation>
        deleteServiceConnectionPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
        deleteServiceConnectionPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListServiceClassesRequest, ListServiceClassesResponse, ListServiceClassesPagedResponse>
        listServiceClassesSettings;
    private final UnaryCallSettings.Builder<GetServiceClassRequest, ServiceClass>
        getServiceClassSettings;
    private final UnaryCallSettings.Builder<UpdateServiceClassRequest, Operation>
        updateServiceClassSettings;
    private final OperationCallSettings.Builder<
            UpdateServiceClassRequest, ServiceClass, OperationMetadata>
        updateServiceClassOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceClassRequest, Operation>
        deleteServiceClassSettings;
    private final OperationCallSettings.Builder<DeleteServiceClassRequest, Empty, OperationMetadata>
        deleteServiceClassOperationSettings;
    private final UnaryCallSettings.Builder<
            GetServiceConnectionTokenRequest, ServiceConnectionToken>
        getServiceConnectionTokenSettings;
    private final PagedCallSettings.Builder<
            ListServiceConnectionTokensRequest,
            ListServiceConnectionTokensResponse,
            ListServiceConnectionTokensPagedResponse>
        listServiceConnectionTokensSettings;
    private final UnaryCallSettings.Builder<CreateServiceConnectionTokenRequest, Operation>
        createServiceConnectionTokenSettings;
    private final OperationCallSettings.Builder<
            CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
        createServiceConnectionTokenOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceConnectionTokenRequest, Operation>
        deleteServiceConnectionTokenSettings;
    private final OperationCallSettings.Builder<
            DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
        deleteServiceConnectionTokenOperationSettings;
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

      listServiceConnectionMapsSettings =
          PagedCallSettings.newBuilder(LIST_SERVICE_CONNECTION_MAPS_PAGE_STR_FACT);
      getServiceConnectionMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceConnectionMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceConnectionMapOperationSettings = OperationCallSettings.newBuilder();
      updateServiceConnectionMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceConnectionMapOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceConnectionMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceConnectionMapOperationSettings = OperationCallSettings.newBuilder();
      listServiceConnectionPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_SERVICE_CONNECTION_POLICIES_PAGE_STR_FACT);
      getServiceConnectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceConnectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceConnectionPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateServiceConnectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceConnectionPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceConnectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceConnectionPolicyOperationSettings = OperationCallSettings.newBuilder();
      listServiceClassesSettings = PagedCallSettings.newBuilder(LIST_SERVICE_CLASSES_PAGE_STR_FACT);
      getServiceClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceClassOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceClassOperationSettings = OperationCallSettings.newBuilder();
      getServiceConnectionTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServiceConnectionTokensSettings =
          PagedCallSettings.newBuilder(LIST_SERVICE_CONNECTION_TOKENS_PAGE_STR_FACT);
      createServiceConnectionTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceConnectionTokenOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceConnectionTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceConnectionTokenOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServiceConnectionMapsSettings,
              getServiceConnectionMapSettings,
              createServiceConnectionMapSettings,
              updateServiceConnectionMapSettings,
              deleteServiceConnectionMapSettings,
              listServiceConnectionPoliciesSettings,
              getServiceConnectionPolicySettings,
              createServiceConnectionPolicySettings,
              updateServiceConnectionPolicySettings,
              deleteServiceConnectionPolicySettings,
              listServiceClassesSettings,
              getServiceClassSettings,
              updateServiceClassSettings,
              deleteServiceClassSettings,
              getServiceConnectionTokenSettings,
              listServiceConnectionTokensSettings,
              createServiceConnectionTokenSettings,
              deleteServiceConnectionTokenSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(CrossNetworkAutomationServiceStubSettings settings) {
      super(settings);

      listServiceConnectionMapsSettings = settings.listServiceConnectionMapsSettings.toBuilder();
      getServiceConnectionMapSettings = settings.getServiceConnectionMapSettings.toBuilder();
      createServiceConnectionMapSettings = settings.createServiceConnectionMapSettings.toBuilder();
      createServiceConnectionMapOperationSettings =
          settings.createServiceConnectionMapOperationSettings.toBuilder();
      updateServiceConnectionMapSettings = settings.updateServiceConnectionMapSettings.toBuilder();
      updateServiceConnectionMapOperationSettings =
          settings.updateServiceConnectionMapOperationSettings.toBuilder();
      deleteServiceConnectionMapSettings = settings.deleteServiceConnectionMapSettings.toBuilder();
      deleteServiceConnectionMapOperationSettings =
          settings.deleteServiceConnectionMapOperationSettings.toBuilder();
      listServiceConnectionPoliciesSettings =
          settings.listServiceConnectionPoliciesSettings.toBuilder();
      getServiceConnectionPolicySettings = settings.getServiceConnectionPolicySettings.toBuilder();
      createServiceConnectionPolicySettings =
          settings.createServiceConnectionPolicySettings.toBuilder();
      createServiceConnectionPolicyOperationSettings =
          settings.createServiceConnectionPolicyOperationSettings.toBuilder();
      updateServiceConnectionPolicySettings =
          settings.updateServiceConnectionPolicySettings.toBuilder();
      updateServiceConnectionPolicyOperationSettings =
          settings.updateServiceConnectionPolicyOperationSettings.toBuilder();
      deleteServiceConnectionPolicySettings =
          settings.deleteServiceConnectionPolicySettings.toBuilder();
      deleteServiceConnectionPolicyOperationSettings =
          settings.deleteServiceConnectionPolicyOperationSettings.toBuilder();
      listServiceClassesSettings = settings.listServiceClassesSettings.toBuilder();
      getServiceClassSettings = settings.getServiceClassSettings.toBuilder();
      updateServiceClassSettings = settings.updateServiceClassSettings.toBuilder();
      updateServiceClassOperationSettings =
          settings.updateServiceClassOperationSettings.toBuilder();
      deleteServiceClassSettings = settings.deleteServiceClassSettings.toBuilder();
      deleteServiceClassOperationSettings =
          settings.deleteServiceClassOperationSettings.toBuilder();
      getServiceConnectionTokenSettings = settings.getServiceConnectionTokenSettings.toBuilder();
      listServiceConnectionTokensSettings =
          settings.listServiceConnectionTokensSettings.toBuilder();
      createServiceConnectionTokenSettings =
          settings.createServiceConnectionTokenSettings.toBuilder();
      createServiceConnectionTokenOperationSettings =
          settings.createServiceConnectionTokenOperationSettings.toBuilder();
      deleteServiceConnectionTokenSettings =
          settings.deleteServiceConnectionTokenSettings.toBuilder();
      deleteServiceConnectionTokenOperationSettings =
          settings.deleteServiceConnectionTokenOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServiceConnectionMapsSettings,
              getServiceConnectionMapSettings,
              createServiceConnectionMapSettings,
              updateServiceConnectionMapSettings,
              deleteServiceConnectionMapSettings,
              listServiceConnectionPoliciesSettings,
              getServiceConnectionPolicySettings,
              createServiceConnectionPolicySettings,
              updateServiceConnectionPolicySettings,
              deleteServiceConnectionPolicySettings,
              listServiceClassesSettings,
              getServiceClassSettings,
              updateServiceClassSettings,
              deleteServiceClassSettings,
              getServiceConnectionTokenSettings,
              listServiceConnectionTokensSettings,
              createServiceConnectionTokenSettings,
              deleteServiceConnectionTokenSettings,
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
          .listServiceConnectionMapsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getServiceConnectionMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createServiceConnectionMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateServiceConnectionMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteServiceConnectionMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listServiceConnectionPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getServiceConnectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createServiceConnectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateServiceConnectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteServiceConnectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listServiceClassesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getServiceClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateServiceClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteServiceClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getServiceConnectionTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listServiceConnectionTokensSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createServiceConnectionTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteServiceConnectionTokenSettings()
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
          .createServiceConnectionMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceConnectionMapRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceConnectionMap.class))
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
          .updateServiceConnectionMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServiceConnectionMapRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceConnectionMap.class))
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
          .deleteServiceConnectionMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceConnectionMapRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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

      builder
          .createServiceConnectionPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceConnectionPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceConnectionPolicy.class))
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
          .updateServiceConnectionPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServiceConnectionPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceConnectionPolicy.class))
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
          .deleteServiceConnectionPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceConnectionPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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

      builder
          .updateServiceClassOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServiceClassRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceClass.class))
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
          .deleteServiceClassOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceClassRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

      builder
          .createServiceConnectionTokenOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceConnectionTokenRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceConnectionToken.class))
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
          .deleteServiceConnectionTokenOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceConnectionTokenRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listServiceConnectionMaps. */
    public PagedCallSettings.Builder<
            ListServiceConnectionMapsRequest,
            ListServiceConnectionMapsResponse,
            ListServiceConnectionMapsPagedResponse>
        listServiceConnectionMapsSettings() {
      return listServiceConnectionMapsSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceConnectionMap. */
    public UnaryCallSettings.Builder<GetServiceConnectionMapRequest, ServiceConnectionMap>
        getServiceConnectionMapSettings() {
      return getServiceConnectionMapSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionMap. */
    public UnaryCallSettings.Builder<CreateServiceConnectionMapRequest, Operation>
        createServiceConnectionMapSettings() {
      return createServiceConnectionMapSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionMap. */
    public OperationCallSettings.Builder<
            CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
        createServiceConnectionMapOperationSettings() {
      return createServiceConnectionMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionMap. */
    public UnaryCallSettings.Builder<UpdateServiceConnectionMapRequest, Operation>
        updateServiceConnectionMapSettings() {
      return updateServiceConnectionMapSettings;
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionMap. */
    public OperationCallSettings.Builder<
            UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
        updateServiceConnectionMapOperationSettings() {
      return updateServiceConnectionMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionMap. */
    public UnaryCallSettings.Builder<DeleteServiceConnectionMapRequest, Operation>
        deleteServiceConnectionMapSettings() {
      return deleteServiceConnectionMapSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionMap. */
    public OperationCallSettings.Builder<
            DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
        deleteServiceConnectionMapOperationSettings() {
      return deleteServiceConnectionMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listServiceConnectionPolicies. */
    public PagedCallSettings.Builder<
            ListServiceConnectionPoliciesRequest,
            ListServiceConnectionPoliciesResponse,
            ListServiceConnectionPoliciesPagedResponse>
        listServiceConnectionPoliciesSettings() {
      return listServiceConnectionPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
        getServiceConnectionPolicySettings() {
      return getServiceConnectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<CreateServiceConnectionPolicyRequest, Operation>
        createServiceConnectionPolicySettings() {
      return createServiceConnectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionPolicy. */
    public OperationCallSettings.Builder<
            CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
        createServiceConnectionPolicyOperationSettings() {
      return createServiceConnectionPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<UpdateServiceConnectionPolicyRequest, Operation>
        updateServiceConnectionPolicySettings() {
      return updateServiceConnectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionPolicy. */
    public OperationCallSettings.Builder<
            UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
        updateServiceConnectionPolicyOperationSettings() {
      return updateServiceConnectionPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<DeleteServiceConnectionPolicyRequest, Operation>
        deleteServiceConnectionPolicySettings() {
      return deleteServiceConnectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionPolicy. */
    public OperationCallSettings.Builder<
            DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
        deleteServiceConnectionPolicyOperationSettings() {
      return deleteServiceConnectionPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listServiceClasses. */
    public PagedCallSettings.Builder<
            ListServiceClassesRequest, ListServiceClassesResponse, ListServiceClassesPagedResponse>
        listServiceClassesSettings() {
      return listServiceClassesSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceClass. */
    public UnaryCallSettings.Builder<GetServiceClassRequest, ServiceClass>
        getServiceClassSettings() {
      return getServiceClassSettings;
    }

    /** Returns the builder for the settings used for calls to updateServiceClass. */
    public UnaryCallSettings.Builder<UpdateServiceClassRequest, Operation>
        updateServiceClassSettings() {
      return updateServiceClassSettings;
    }

    /** Returns the builder for the settings used for calls to updateServiceClass. */
    public OperationCallSettings.Builder<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
        updateServiceClassOperationSettings() {
      return updateServiceClassOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceClass. */
    public UnaryCallSettings.Builder<DeleteServiceClassRequest, Operation>
        deleteServiceClassSettings() {
      return deleteServiceClassSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceClass. */
    public OperationCallSettings.Builder<DeleteServiceClassRequest, Empty, OperationMetadata>
        deleteServiceClassOperationSettings() {
      return deleteServiceClassOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceConnectionToken. */
    public UnaryCallSettings.Builder<GetServiceConnectionTokenRequest, ServiceConnectionToken>
        getServiceConnectionTokenSettings() {
      return getServiceConnectionTokenSettings;
    }

    /** Returns the builder for the settings used for calls to listServiceConnectionTokens. */
    public PagedCallSettings.Builder<
            ListServiceConnectionTokensRequest,
            ListServiceConnectionTokensResponse,
            ListServiceConnectionTokensPagedResponse>
        listServiceConnectionTokensSettings() {
      return listServiceConnectionTokensSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionToken. */
    public UnaryCallSettings.Builder<CreateServiceConnectionTokenRequest, Operation>
        createServiceConnectionTokenSettings() {
      return createServiceConnectionTokenSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionToken. */
    public OperationCallSettings.Builder<
            CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
        createServiceConnectionTokenOperationSettings() {
      return createServiceConnectionTokenOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionToken. */
    public UnaryCallSettings.Builder<DeleteServiceConnectionTokenRequest, Operation>
        deleteServiceConnectionTokenSettings() {
      return deleteServiceConnectionTokenSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionToken. */
    public OperationCallSettings.Builder<
            DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
        deleteServiceConnectionTokenOperationSettings() {
      return deleteServiceConnectionTokenOperationSettings;
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
    public CrossNetworkAutomationServiceStubSettings build() throws IOException {
      return new CrossNetworkAutomationServiceStubSettings(this);
    }
  }
}
