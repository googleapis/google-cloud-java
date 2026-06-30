/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.InterceptDeployment;
import com.google.cloud.networksecurity.v1.InterceptDeploymentGroup;
import com.google.cloud.networksecurity.v1.InterceptEndpointGroup;
import com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest;
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
 * Settings class to configure an instance of {@link InterceptStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
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
 * of getInterceptEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterceptStubSettings.Builder interceptSettingsBuilder = InterceptStubSettings.newBuilder();
 * interceptSettingsBuilder
 *     .getInterceptEndpointGroupSettings()
 *     .setRetrySettings(
 *         interceptSettingsBuilder
 *             .getInterceptEndpointGroupSettings()
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
 * InterceptStubSettings interceptSettings = interceptSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInterceptEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterceptStubSettings.Builder interceptSettingsBuilder = InterceptStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * interceptSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class InterceptStubSettings extends StubSettings<InterceptStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          ListInterceptEndpointGroupsPagedResponse>
      listInterceptEndpointGroupsSettings;
  private final UnaryCallSettings<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupSettings;
  private final UnaryCallSettings<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupSettings;
  private final OperationCallSettings<
          CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupOperationSettings;
  private final UnaryCallSettings<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupSettings;
  private final OperationCallSettings<
          UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupOperationSettings;
  private final UnaryCallSettings<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupSettings;
  private final OperationCallSettings<DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupOperationSettings;
  private final PagedCallSettings<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      listInterceptEndpointGroupAssociationsSettings;
  private final UnaryCallSettings<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationSettings;
  private final UnaryCallSettings<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationSettings;
  private final OperationCallSettings<
          CreateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      createInterceptEndpointGroupAssociationOperationSettings;
  private final UnaryCallSettings<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationSettings;
  private final OperationCallSettings<
          UpdateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      updateInterceptEndpointGroupAssociationOperationSettings;
  private final UnaryCallSettings<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationSettings;
  private final OperationCallSettings<
          DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationOperationSettings;
  private final PagedCallSettings<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          ListInterceptDeploymentGroupsPagedResponse>
      listInterceptDeploymentGroupsSettings;
  private final UnaryCallSettings<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupSettings;
  private final UnaryCallSettings<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupSettings;
  private final OperationCallSettings<
          CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupOperationSettings;
  private final UnaryCallSettings<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupSettings;
  private final OperationCallSettings<
          UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupOperationSettings;
  private final UnaryCallSettings<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupSettings;
  private final OperationCallSettings<
          DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentGroupOperationSettings;
  private final PagedCallSettings<
          ListInterceptDeploymentsRequest,
          ListInterceptDeploymentsResponse,
          ListInterceptDeploymentsPagedResponse>
      listInterceptDeploymentsSettings;
  private final UnaryCallSettings<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentSettings;
  private final UnaryCallSettings<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentSettings;
  private final OperationCallSettings<
          CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      createInterceptDeploymentOperationSettings;
  private final UnaryCallSettings<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentSettings;
  private final OperationCallSettings<
          UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentOperationSettings;
  private final UnaryCallSettings<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentSettings;
  private final OperationCallSettings<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          InterceptEndpointGroup>
      LIST_INTERCEPT_ENDPOINT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterceptEndpointGroupsRequest,
              ListInterceptEndpointGroupsResponse,
              InterceptEndpointGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterceptEndpointGroupsRequest injectToken(
                ListInterceptEndpointGroupsRequest payload, String token) {
              return ListInterceptEndpointGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInterceptEndpointGroupsRequest injectPageSize(
                ListInterceptEndpointGroupsRequest payload, int pageSize) {
              return ListInterceptEndpointGroupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterceptEndpointGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInterceptEndpointGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterceptEndpointGroup> extractResources(
                ListInterceptEndpointGroupsResponse payload) {
              return payload.getInterceptEndpointGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          InterceptEndpointGroupAssociation>
      LIST_INTERCEPT_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterceptEndpointGroupAssociationsRequest,
              ListInterceptEndpointGroupAssociationsResponse,
              InterceptEndpointGroupAssociation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterceptEndpointGroupAssociationsRequest injectToken(
                ListInterceptEndpointGroupAssociationsRequest payload, String token) {
              return ListInterceptEndpointGroupAssociationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInterceptEndpointGroupAssociationsRequest injectPageSize(
                ListInterceptEndpointGroupAssociationsRequest payload, int pageSize) {
              return ListInterceptEndpointGroupAssociationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterceptEndpointGroupAssociationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInterceptEndpointGroupAssociationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterceptEndpointGroupAssociation> extractResources(
                ListInterceptEndpointGroupAssociationsResponse payload) {
              return payload.getInterceptEndpointGroupAssociationsList();
            }
          };

  private static final PagedListDescriptor<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          InterceptDeploymentGroup>
      LIST_INTERCEPT_DEPLOYMENT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterceptDeploymentGroupsRequest,
              ListInterceptDeploymentGroupsResponse,
              InterceptDeploymentGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterceptDeploymentGroupsRequest injectToken(
                ListInterceptDeploymentGroupsRequest payload, String token) {
              return ListInterceptDeploymentGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInterceptDeploymentGroupsRequest injectPageSize(
                ListInterceptDeploymentGroupsRequest payload, int pageSize) {
              return ListInterceptDeploymentGroupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterceptDeploymentGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInterceptDeploymentGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterceptDeploymentGroup> extractResources(
                ListInterceptDeploymentGroupsResponse payload) {
              return payload.getInterceptDeploymentGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse, InterceptDeployment>
      LIST_INTERCEPT_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterceptDeploymentsRequest,
              ListInterceptDeploymentsResponse,
              InterceptDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterceptDeploymentsRequest injectToken(
                ListInterceptDeploymentsRequest payload, String token) {
              return ListInterceptDeploymentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInterceptDeploymentsRequest injectPageSize(
                ListInterceptDeploymentsRequest payload, int pageSize) {
              return ListInterceptDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterceptDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInterceptDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterceptDeployment> extractResources(
                ListInterceptDeploymentsResponse payload) {
              return payload.getInterceptDeploymentsList();
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
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          ListInterceptEndpointGroupsPagedResponse>
      LIST_INTERCEPT_ENDPOINT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterceptEndpointGroupsRequest,
              ListInterceptEndpointGroupsResponse,
              ListInterceptEndpointGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListInterceptEndpointGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
                    callable,
                ListInterceptEndpointGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListInterceptEndpointGroupsResponse> futureResponse) {
              PageContext<
                      ListInterceptEndpointGroupsRequest,
                      ListInterceptEndpointGroupsResponse,
                      InterceptEndpointGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INTERCEPT_ENDPOINT_GROUPS_PAGE_STR_DESC, request, context);
              return ListInterceptEndpointGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      LIST_INTERCEPT_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterceptEndpointGroupAssociationsRequest,
              ListInterceptEndpointGroupAssociationsResponse,
              ListInterceptEndpointGroupAssociationsPagedResponse>() {
            @Override
            public ApiFuture<ListInterceptEndpointGroupAssociationsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListInterceptEndpointGroupAssociationsRequest,
                            ListInterceptEndpointGroupAssociationsResponse>
                        callable,
                    ListInterceptEndpointGroupAssociationsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListInterceptEndpointGroupAssociationsResponse> futureResponse) {
              PageContext<
                      ListInterceptEndpointGroupAssociationsRequest,
                      ListInterceptEndpointGroupAssociationsResponse,
                      InterceptEndpointGroupAssociation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_INTERCEPT_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListInterceptEndpointGroupAssociationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          ListInterceptDeploymentGroupsPagedResponse>
      LIST_INTERCEPT_DEPLOYMENT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterceptDeploymentGroupsRequest,
              ListInterceptDeploymentGroupsResponse,
              ListInterceptDeploymentGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListInterceptDeploymentGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
                    callable,
                ListInterceptDeploymentGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListInterceptDeploymentGroupsResponse> futureResponse) {
              PageContext<
                      ListInterceptDeploymentGroupsRequest,
                      ListInterceptDeploymentGroupsResponse,
                      InterceptDeploymentGroup>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_INTERCEPT_DEPLOYMENT_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListInterceptDeploymentGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInterceptDeploymentsRequest,
          ListInterceptDeploymentsResponse,
          ListInterceptDeploymentsPagedResponse>
      LIST_INTERCEPT_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterceptDeploymentsRequest,
              ListInterceptDeploymentsResponse,
              ListInterceptDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListInterceptDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>
                    callable,
                ListInterceptDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListInterceptDeploymentsResponse> futureResponse) {
              PageContext<
                      ListInterceptDeploymentsRequest,
                      ListInterceptDeploymentsResponse,
                      InterceptDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INTERCEPT_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListInterceptDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listInterceptEndpointGroups. */
  public PagedCallSettings<
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          ListInterceptEndpointGroupsPagedResponse>
      listInterceptEndpointGroupsSettings() {
    return listInterceptEndpointGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getInterceptEndpointGroup. */
  public UnaryCallSettings<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupSettings() {
    return getInterceptEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to createInterceptEndpointGroup. */
  public UnaryCallSettings<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupSettings() {
    return createInterceptEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to createInterceptEndpointGroup. */
  public OperationCallSettings<
          CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupOperationSettings() {
    return createInterceptEndpointGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInterceptEndpointGroup. */
  public UnaryCallSettings<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupSettings() {
    return updateInterceptEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateInterceptEndpointGroup. */
  public OperationCallSettings<
          UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupOperationSettings() {
    return updateInterceptEndpointGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterceptEndpointGroup. */
  public UnaryCallSettings<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupSettings() {
    return deleteInterceptEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterceptEndpointGroup. */
  public OperationCallSettings<DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupOperationSettings() {
    return deleteInterceptEndpointGroupOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to listInterceptEndpointGroupAssociations.
   */
  public PagedCallSettings<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      listInterceptEndpointGroupAssociationsSettings() {
    return listInterceptEndpointGroupAssociationsSettings;
  }

  /**
   * Returns the object with the settings used for calls to getInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationSettings() {
    return getInterceptEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to createInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationSettings() {
    return createInterceptEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to createInterceptEndpointGroupAssociation.
   */
  public OperationCallSettings<
          CreateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      createInterceptEndpointGroupAssociationOperationSettings() {
    return createInterceptEndpointGroupAssociationOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationSettings() {
    return updateInterceptEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateInterceptEndpointGroupAssociation.
   */
  public OperationCallSettings<
          UpdateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      updateInterceptEndpointGroupAssociationOperationSettings() {
    return updateInterceptEndpointGroupAssociationOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationSettings() {
    return deleteInterceptEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteInterceptEndpointGroupAssociation.
   */
  public OperationCallSettings<
          DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationOperationSettings() {
    return deleteInterceptEndpointGroupAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInterceptDeploymentGroups. */
  public PagedCallSettings<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          ListInterceptDeploymentGroupsPagedResponse>
      listInterceptDeploymentGroupsSettings() {
    return listInterceptDeploymentGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getInterceptDeploymentGroup. */
  public UnaryCallSettings<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupSettings() {
    return getInterceptDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to createInterceptDeploymentGroup. */
  public UnaryCallSettings<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupSettings() {
    return createInterceptDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to createInterceptDeploymentGroup. */
  public OperationCallSettings<
          CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupOperationSettings() {
    return createInterceptDeploymentGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInterceptDeploymentGroup. */
  public UnaryCallSettings<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupSettings() {
    return updateInterceptDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateInterceptDeploymentGroup. */
  public OperationCallSettings<
          UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupOperationSettings() {
    return updateInterceptDeploymentGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeploymentGroup. */
  public UnaryCallSettings<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupSettings() {
    return deleteInterceptDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeploymentGroup. */
  public OperationCallSettings<DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentGroupOperationSettings() {
    return deleteInterceptDeploymentGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInterceptDeployments. */
  public PagedCallSettings<
          ListInterceptDeploymentsRequest,
          ListInterceptDeploymentsResponse,
          ListInterceptDeploymentsPagedResponse>
      listInterceptDeploymentsSettings() {
    return listInterceptDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getInterceptDeployment. */
  public UnaryCallSettings<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentSettings() {
    return getInterceptDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createInterceptDeployment. */
  public UnaryCallSettings<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentSettings() {
    return createInterceptDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createInterceptDeployment. */
  public OperationCallSettings<
          CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      createInterceptDeploymentOperationSettings() {
    return createInterceptDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInterceptDeployment. */
  public UnaryCallSettings<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentSettings() {
    return updateInterceptDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateInterceptDeployment. */
  public OperationCallSettings<
          UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentOperationSettings() {
    return updateInterceptDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeployment. */
  public UnaryCallSettings<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentSettings() {
    return deleteInterceptDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeployment. */
  public OperationCallSettings<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentOperationSettings() {
    return deleteInterceptDeploymentOperationSettings;
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

  public InterceptStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcInterceptStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networksecurity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networksecurity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networksecurity.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(InterceptStubSettings.class))
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

  protected InterceptStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInterceptEndpointGroupsSettings =
        settingsBuilder.listInterceptEndpointGroupsSettings().build();
    getInterceptEndpointGroupSettings = settingsBuilder.getInterceptEndpointGroupSettings().build();
    createInterceptEndpointGroupSettings =
        settingsBuilder.createInterceptEndpointGroupSettings().build();
    createInterceptEndpointGroupOperationSettings =
        settingsBuilder.createInterceptEndpointGroupOperationSettings().build();
    updateInterceptEndpointGroupSettings =
        settingsBuilder.updateInterceptEndpointGroupSettings().build();
    updateInterceptEndpointGroupOperationSettings =
        settingsBuilder.updateInterceptEndpointGroupOperationSettings().build();
    deleteInterceptEndpointGroupSettings =
        settingsBuilder.deleteInterceptEndpointGroupSettings().build();
    deleteInterceptEndpointGroupOperationSettings =
        settingsBuilder.deleteInterceptEndpointGroupOperationSettings().build();
    listInterceptEndpointGroupAssociationsSettings =
        settingsBuilder.listInterceptEndpointGroupAssociationsSettings().build();
    getInterceptEndpointGroupAssociationSettings =
        settingsBuilder.getInterceptEndpointGroupAssociationSettings().build();
    createInterceptEndpointGroupAssociationSettings =
        settingsBuilder.createInterceptEndpointGroupAssociationSettings().build();
    createInterceptEndpointGroupAssociationOperationSettings =
        settingsBuilder.createInterceptEndpointGroupAssociationOperationSettings().build();
    updateInterceptEndpointGroupAssociationSettings =
        settingsBuilder.updateInterceptEndpointGroupAssociationSettings().build();
    updateInterceptEndpointGroupAssociationOperationSettings =
        settingsBuilder.updateInterceptEndpointGroupAssociationOperationSettings().build();
    deleteInterceptEndpointGroupAssociationSettings =
        settingsBuilder.deleteInterceptEndpointGroupAssociationSettings().build();
    deleteInterceptEndpointGroupAssociationOperationSettings =
        settingsBuilder.deleteInterceptEndpointGroupAssociationOperationSettings().build();
    listInterceptDeploymentGroupsSettings =
        settingsBuilder.listInterceptDeploymentGroupsSettings().build();
    getInterceptDeploymentGroupSettings =
        settingsBuilder.getInterceptDeploymentGroupSettings().build();
    createInterceptDeploymentGroupSettings =
        settingsBuilder.createInterceptDeploymentGroupSettings().build();
    createInterceptDeploymentGroupOperationSettings =
        settingsBuilder.createInterceptDeploymentGroupOperationSettings().build();
    updateInterceptDeploymentGroupSettings =
        settingsBuilder.updateInterceptDeploymentGroupSettings().build();
    updateInterceptDeploymentGroupOperationSettings =
        settingsBuilder.updateInterceptDeploymentGroupOperationSettings().build();
    deleteInterceptDeploymentGroupSettings =
        settingsBuilder.deleteInterceptDeploymentGroupSettings().build();
    deleteInterceptDeploymentGroupOperationSettings =
        settingsBuilder.deleteInterceptDeploymentGroupOperationSettings().build();
    listInterceptDeploymentsSettings = settingsBuilder.listInterceptDeploymentsSettings().build();
    getInterceptDeploymentSettings = settingsBuilder.getInterceptDeploymentSettings().build();
    createInterceptDeploymentSettings = settingsBuilder.createInterceptDeploymentSettings().build();
    createInterceptDeploymentOperationSettings =
        settingsBuilder.createInterceptDeploymentOperationSettings().build();
    updateInterceptDeploymentSettings = settingsBuilder.updateInterceptDeploymentSettings().build();
    updateInterceptDeploymentOperationSettings =
        settingsBuilder.updateInterceptDeploymentOperationSettings().build();
    deleteInterceptDeploymentSettings = settingsBuilder.deleteInterceptDeploymentSettings().build();
    deleteInterceptDeploymentOperationSettings =
        settingsBuilder.deleteInterceptDeploymentOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-network-security")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for InterceptStubSettings. */
  public static class Builder extends StubSettings.Builder<InterceptStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInterceptEndpointGroupsRequest,
            ListInterceptEndpointGroupsResponse,
            ListInterceptEndpointGroupsPagedResponse>
        listInterceptEndpointGroupsSettings;
    private final UnaryCallSettings.Builder<
            GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
        getInterceptEndpointGroupSettings;
    private final UnaryCallSettings.Builder<CreateInterceptEndpointGroupRequest, Operation>
        createInterceptEndpointGroupSettings;
    private final OperationCallSettings.Builder<
            CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
        createInterceptEndpointGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInterceptEndpointGroupRequest, Operation>
        updateInterceptEndpointGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
        updateInterceptEndpointGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInterceptEndpointGroupRequest, Operation>
        deleteInterceptEndpointGroupSettings;
    private final OperationCallSettings.Builder<
            DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
        deleteInterceptEndpointGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListInterceptEndpointGroupAssociationsRequest,
            ListInterceptEndpointGroupAssociationsResponse,
            ListInterceptEndpointGroupAssociationsPagedResponse>
        listInterceptEndpointGroupAssociationsSettings;
    private final UnaryCallSettings.Builder<
            GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
        getInterceptEndpointGroupAssociationSettings;
    private final UnaryCallSettings.Builder<
            CreateInterceptEndpointGroupAssociationRequest, Operation>
        createInterceptEndpointGroupAssociationSettings;
    private final OperationCallSettings.Builder<
            CreateInterceptEndpointGroupAssociationRequest,
            InterceptEndpointGroupAssociation,
            OperationMetadata>
        createInterceptEndpointGroupAssociationOperationSettings;
    private final UnaryCallSettings.Builder<
            UpdateInterceptEndpointGroupAssociationRequest, Operation>
        updateInterceptEndpointGroupAssociationSettings;
    private final OperationCallSettings.Builder<
            UpdateInterceptEndpointGroupAssociationRequest,
            InterceptEndpointGroupAssociation,
            OperationMetadata>
        updateInterceptEndpointGroupAssociationOperationSettings;
    private final UnaryCallSettings.Builder<
            DeleteInterceptEndpointGroupAssociationRequest, Operation>
        deleteInterceptEndpointGroupAssociationSettings;
    private final OperationCallSettings.Builder<
            DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
        deleteInterceptEndpointGroupAssociationOperationSettings;
    private final PagedCallSettings.Builder<
            ListInterceptDeploymentGroupsRequest,
            ListInterceptDeploymentGroupsResponse,
            ListInterceptDeploymentGroupsPagedResponse>
        listInterceptDeploymentGroupsSettings;
    private final UnaryCallSettings.Builder<
            GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
        getInterceptDeploymentGroupSettings;
    private final UnaryCallSettings.Builder<CreateInterceptDeploymentGroupRequest, Operation>
        createInterceptDeploymentGroupSettings;
    private final OperationCallSettings.Builder<
            CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
        createInterceptDeploymentGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInterceptDeploymentGroupRequest, Operation>
        updateInterceptDeploymentGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
        updateInterceptDeploymentGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInterceptDeploymentGroupRequest, Operation>
        deleteInterceptDeploymentGroupSettings;
    private final OperationCallSettings.Builder<
            DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
        deleteInterceptDeploymentGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListInterceptDeploymentsRequest,
            ListInterceptDeploymentsResponse,
            ListInterceptDeploymentsPagedResponse>
        listInterceptDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetInterceptDeploymentRequest, InterceptDeployment>
        getInterceptDeploymentSettings;
    private final UnaryCallSettings.Builder<CreateInterceptDeploymentRequest, Operation>
        createInterceptDeploymentSettings;
    private final OperationCallSettings.Builder<
            CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
        createInterceptDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInterceptDeploymentRequest, Operation>
        updateInterceptDeploymentSettings;
    private final OperationCallSettings.Builder<
            UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
        updateInterceptDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInterceptDeploymentRequest, Operation>
        deleteInterceptDeploymentSettings;
    private final OperationCallSettings.Builder<
            DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
        deleteInterceptDeploymentOperationSettings;
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

      listInterceptEndpointGroupsSettings =
          PagedCallSettings.newBuilder(LIST_INTERCEPT_ENDPOINT_GROUPS_PAGE_STR_FACT);
      getInterceptEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptEndpointGroupOperationSettings = OperationCallSettings.newBuilder();
      updateInterceptEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInterceptEndpointGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteInterceptEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInterceptEndpointGroupOperationSettings = OperationCallSettings.newBuilder();
      listInterceptEndpointGroupAssociationsSettings =
          PagedCallSettings.newBuilder(LIST_INTERCEPT_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_FACT);
      getInterceptEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptEndpointGroupAssociationOperationSettings = OperationCallSettings.newBuilder();
      updateInterceptEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInterceptEndpointGroupAssociationOperationSettings = OperationCallSettings.newBuilder();
      deleteInterceptEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInterceptEndpointGroupAssociationOperationSettings = OperationCallSettings.newBuilder();
      listInterceptDeploymentGroupsSettings =
          PagedCallSettings.newBuilder(LIST_INTERCEPT_DEPLOYMENT_GROUPS_PAGE_STR_FACT);
      getInterceptDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptDeploymentGroupOperationSettings = OperationCallSettings.newBuilder();
      updateInterceptDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInterceptDeploymentGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteInterceptDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInterceptDeploymentGroupOperationSettings = OperationCallSettings.newBuilder();
      listInterceptDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_INTERCEPT_DEPLOYMENTS_PAGE_STR_FACT);
      getInterceptDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterceptDeploymentOperationSettings = OperationCallSettings.newBuilder();
      updateInterceptDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInterceptDeploymentOperationSettings = OperationCallSettings.newBuilder();
      deleteInterceptDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInterceptDeploymentOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInterceptEndpointGroupsSettings,
              getInterceptEndpointGroupSettings,
              createInterceptEndpointGroupSettings,
              updateInterceptEndpointGroupSettings,
              deleteInterceptEndpointGroupSettings,
              listInterceptEndpointGroupAssociationsSettings,
              getInterceptEndpointGroupAssociationSettings,
              createInterceptEndpointGroupAssociationSettings,
              updateInterceptEndpointGroupAssociationSettings,
              deleteInterceptEndpointGroupAssociationSettings,
              listInterceptDeploymentGroupsSettings,
              getInterceptDeploymentGroupSettings,
              createInterceptDeploymentGroupSettings,
              updateInterceptDeploymentGroupSettings,
              deleteInterceptDeploymentGroupSettings,
              listInterceptDeploymentsSettings,
              getInterceptDeploymentSettings,
              createInterceptDeploymentSettings,
              updateInterceptDeploymentSettings,
              deleteInterceptDeploymentSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(InterceptStubSettings settings) {
      super(settings);

      listInterceptEndpointGroupsSettings =
          settings.listInterceptEndpointGroupsSettings.toBuilder();
      getInterceptEndpointGroupSettings = settings.getInterceptEndpointGroupSettings.toBuilder();
      createInterceptEndpointGroupSettings =
          settings.createInterceptEndpointGroupSettings.toBuilder();
      createInterceptEndpointGroupOperationSettings =
          settings.createInterceptEndpointGroupOperationSettings.toBuilder();
      updateInterceptEndpointGroupSettings =
          settings.updateInterceptEndpointGroupSettings.toBuilder();
      updateInterceptEndpointGroupOperationSettings =
          settings.updateInterceptEndpointGroupOperationSettings.toBuilder();
      deleteInterceptEndpointGroupSettings =
          settings.deleteInterceptEndpointGroupSettings.toBuilder();
      deleteInterceptEndpointGroupOperationSettings =
          settings.deleteInterceptEndpointGroupOperationSettings.toBuilder();
      listInterceptEndpointGroupAssociationsSettings =
          settings.listInterceptEndpointGroupAssociationsSettings.toBuilder();
      getInterceptEndpointGroupAssociationSettings =
          settings.getInterceptEndpointGroupAssociationSettings.toBuilder();
      createInterceptEndpointGroupAssociationSettings =
          settings.createInterceptEndpointGroupAssociationSettings.toBuilder();
      createInterceptEndpointGroupAssociationOperationSettings =
          settings.createInterceptEndpointGroupAssociationOperationSettings.toBuilder();
      updateInterceptEndpointGroupAssociationSettings =
          settings.updateInterceptEndpointGroupAssociationSettings.toBuilder();
      updateInterceptEndpointGroupAssociationOperationSettings =
          settings.updateInterceptEndpointGroupAssociationOperationSettings.toBuilder();
      deleteInterceptEndpointGroupAssociationSettings =
          settings.deleteInterceptEndpointGroupAssociationSettings.toBuilder();
      deleteInterceptEndpointGroupAssociationOperationSettings =
          settings.deleteInterceptEndpointGroupAssociationOperationSettings.toBuilder();
      listInterceptDeploymentGroupsSettings =
          settings.listInterceptDeploymentGroupsSettings.toBuilder();
      getInterceptDeploymentGroupSettings =
          settings.getInterceptDeploymentGroupSettings.toBuilder();
      createInterceptDeploymentGroupSettings =
          settings.createInterceptDeploymentGroupSettings.toBuilder();
      createInterceptDeploymentGroupOperationSettings =
          settings.createInterceptDeploymentGroupOperationSettings.toBuilder();
      updateInterceptDeploymentGroupSettings =
          settings.updateInterceptDeploymentGroupSettings.toBuilder();
      updateInterceptDeploymentGroupOperationSettings =
          settings.updateInterceptDeploymentGroupOperationSettings.toBuilder();
      deleteInterceptDeploymentGroupSettings =
          settings.deleteInterceptDeploymentGroupSettings.toBuilder();
      deleteInterceptDeploymentGroupOperationSettings =
          settings.deleteInterceptDeploymentGroupOperationSettings.toBuilder();
      listInterceptDeploymentsSettings = settings.listInterceptDeploymentsSettings.toBuilder();
      getInterceptDeploymentSettings = settings.getInterceptDeploymentSettings.toBuilder();
      createInterceptDeploymentSettings = settings.createInterceptDeploymentSettings.toBuilder();
      createInterceptDeploymentOperationSettings =
          settings.createInterceptDeploymentOperationSettings.toBuilder();
      updateInterceptDeploymentSettings = settings.updateInterceptDeploymentSettings.toBuilder();
      updateInterceptDeploymentOperationSettings =
          settings.updateInterceptDeploymentOperationSettings.toBuilder();
      deleteInterceptDeploymentSettings = settings.deleteInterceptDeploymentSettings.toBuilder();
      deleteInterceptDeploymentOperationSettings =
          settings.deleteInterceptDeploymentOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInterceptEndpointGroupsSettings,
              getInterceptEndpointGroupSettings,
              createInterceptEndpointGroupSettings,
              updateInterceptEndpointGroupSettings,
              deleteInterceptEndpointGroupSettings,
              listInterceptEndpointGroupAssociationsSettings,
              getInterceptEndpointGroupAssociationSettings,
              createInterceptEndpointGroupAssociationSettings,
              updateInterceptEndpointGroupAssociationSettings,
              deleteInterceptEndpointGroupAssociationSettings,
              listInterceptDeploymentGroupsSettings,
              getInterceptDeploymentGroupSettings,
              createInterceptDeploymentGroupSettings,
              updateInterceptDeploymentGroupSettings,
              deleteInterceptDeploymentGroupSettings,
              listInterceptDeploymentsSettings,
              getInterceptDeploymentSettings,
              createInterceptDeploymentSettings,
              updateInterceptDeploymentSettings,
              deleteInterceptDeploymentSettings,
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
          .listInterceptEndpointGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getInterceptEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInterceptEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateInterceptEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInterceptEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listInterceptEndpointGroupAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getInterceptEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInterceptEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateInterceptEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInterceptEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listInterceptDeploymentGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getInterceptDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInterceptDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateInterceptDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInterceptDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listInterceptDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getInterceptDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInterceptDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateInterceptDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInterceptDeploymentSettings()
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
          .createInterceptEndpointGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInterceptEndpointGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InterceptEndpointGroup.class))
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
          .updateInterceptEndpointGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInterceptEndpointGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InterceptEndpointGroup.class))
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
          .deleteInterceptEndpointGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInterceptEndpointGroupRequest, OperationSnapshot>
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
          .createInterceptEndpointGroupAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInterceptEndpointGroupAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  InterceptEndpointGroupAssociation.class))
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
          .updateInterceptEndpointGroupAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInterceptEndpointGroupAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  InterceptEndpointGroupAssociation.class))
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
          .deleteInterceptEndpointGroupAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInterceptEndpointGroupAssociationRequest, OperationSnapshot>
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
          .createInterceptDeploymentGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInterceptDeploymentGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InterceptDeploymentGroup.class))
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
          .updateInterceptDeploymentGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInterceptDeploymentGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InterceptDeploymentGroup.class))
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
          .deleteInterceptDeploymentGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInterceptDeploymentGroupRequest, OperationSnapshot>
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
          .createInterceptDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInterceptDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InterceptDeployment.class))
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
          .updateInterceptDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInterceptDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InterceptDeployment.class))
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
          .deleteInterceptDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInterceptDeploymentRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to listInterceptEndpointGroups. */
    public PagedCallSettings.Builder<
            ListInterceptEndpointGroupsRequest,
            ListInterceptEndpointGroupsResponse,
            ListInterceptEndpointGroupsPagedResponse>
        listInterceptEndpointGroupsSettings() {
      return listInterceptEndpointGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
        getInterceptEndpointGroupSettings() {
      return getInterceptEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<CreateInterceptEndpointGroupRequest, Operation>
        createInterceptEndpointGroupSettings() {
      return createInterceptEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createInterceptEndpointGroup. */
    public OperationCallSettings.Builder<
            CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
        createInterceptEndpointGroupOperationSettings() {
      return createInterceptEndpointGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<UpdateInterceptEndpointGroupRequest, Operation>
        updateInterceptEndpointGroupSettings() {
      return updateInterceptEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateInterceptEndpointGroup. */
    public OperationCallSettings.Builder<
            UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
        updateInterceptEndpointGroupOperationSettings() {
      return updateInterceptEndpointGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteInterceptEndpointGroupRequest, Operation>
        deleteInterceptEndpointGroupSettings() {
      return deleteInterceptEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterceptEndpointGroup. */
    public OperationCallSettings.Builder<
            DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
        deleteInterceptEndpointGroupOperationSettings() {
      return deleteInterceptEndpointGroupOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listInterceptEndpointGroupAssociations.
     */
    public PagedCallSettings.Builder<
            ListInterceptEndpointGroupAssociationsRequest,
            ListInterceptEndpointGroupAssociationsResponse,
            ListInterceptEndpointGroupAssociationsPagedResponse>
        listInterceptEndpointGroupAssociationsSettings() {
      return listInterceptEndpointGroupAssociationsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<
            GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
        getInterceptEndpointGroupAssociationSettings() {
      return getInterceptEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * createInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<CreateInterceptEndpointGroupAssociationRequest, Operation>
        createInterceptEndpointGroupAssociationSettings() {
      return createInterceptEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * createInterceptEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            CreateInterceptEndpointGroupAssociationRequest,
            InterceptEndpointGroupAssociation,
            OperationMetadata>
        createInterceptEndpointGroupAssociationOperationSettings() {
      return createInterceptEndpointGroupAssociationOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<UpdateInterceptEndpointGroupAssociationRequest, Operation>
        updateInterceptEndpointGroupAssociationSettings() {
      return updateInterceptEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateInterceptEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            UpdateInterceptEndpointGroupAssociationRequest,
            InterceptEndpointGroupAssociation,
            OperationMetadata>
        updateInterceptEndpointGroupAssociationOperationSettings() {
      return updateInterceptEndpointGroupAssociationOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<DeleteInterceptEndpointGroupAssociationRequest, Operation>
        deleteInterceptEndpointGroupAssociationSettings() {
      return deleteInterceptEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteInterceptEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
        deleteInterceptEndpointGroupAssociationOperationSettings() {
      return deleteInterceptEndpointGroupAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInterceptDeploymentGroups. */
    public PagedCallSettings.Builder<
            ListInterceptDeploymentGroupsRequest,
            ListInterceptDeploymentGroupsResponse,
            ListInterceptDeploymentGroupsPagedResponse>
        listInterceptDeploymentGroupsSettings() {
      return listInterceptDeploymentGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
        getInterceptDeploymentGroupSettings() {
      return getInterceptDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<CreateInterceptDeploymentGroupRequest, Operation>
        createInterceptDeploymentGroupSettings() {
      return createInterceptDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createInterceptDeploymentGroup. */
    public OperationCallSettings.Builder<
            CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
        createInterceptDeploymentGroupOperationSettings() {
      return createInterceptDeploymentGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<UpdateInterceptDeploymentGroupRequest, Operation>
        updateInterceptDeploymentGroupSettings() {
      return updateInterceptDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeploymentGroup. */
    public OperationCallSettings.Builder<
            UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
        updateInterceptDeploymentGroupOperationSettings() {
      return updateInterceptDeploymentGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<DeleteInterceptDeploymentGroupRequest, Operation>
        deleteInterceptDeploymentGroupSettings() {
      return deleteInterceptDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeploymentGroup. */
    public OperationCallSettings.Builder<
            DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
        deleteInterceptDeploymentGroupOperationSettings() {
      return deleteInterceptDeploymentGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInterceptDeployments. */
    public PagedCallSettings.Builder<
            ListInterceptDeploymentsRequest,
            ListInterceptDeploymentsResponse,
            ListInterceptDeploymentsPagedResponse>
        listInterceptDeploymentsSettings() {
      return listInterceptDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getInterceptDeployment. */
    public UnaryCallSettings.Builder<GetInterceptDeploymentRequest, InterceptDeployment>
        getInterceptDeploymentSettings() {
      return getInterceptDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createInterceptDeployment. */
    public UnaryCallSettings.Builder<CreateInterceptDeploymentRequest, Operation>
        createInterceptDeploymentSettings() {
      return createInterceptDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createInterceptDeployment. */
    public OperationCallSettings.Builder<
            CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
        createInterceptDeploymentOperationSettings() {
      return createInterceptDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeployment. */
    public UnaryCallSettings.Builder<UpdateInterceptDeploymentRequest, Operation>
        updateInterceptDeploymentSettings() {
      return updateInterceptDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeployment. */
    public OperationCallSettings.Builder<
            UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
        updateInterceptDeploymentOperationSettings() {
      return updateInterceptDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeployment. */
    public UnaryCallSettings.Builder<DeleteInterceptDeploymentRequest, Operation>
        deleteInterceptDeploymentSettings() {
      return deleteInterceptDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeployment. */
    public OperationCallSettings.Builder<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
        deleteInterceptDeploymentOperationSettings() {
      return deleteInterceptDeploymentOperationSettings;
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
    public InterceptStubSettings build() throws IOException {
      return new InterceptStubSettings(this);
    }
  }
}
