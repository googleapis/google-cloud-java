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

import static com.google.cloud.networksecurity.v1.MirroringClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupsPagedResponse;

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
import com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse;
import com.google.cloud.networksecurity.v1.MirroringDeployment;
import com.google.cloud.networksecurity.v1.MirroringDeploymentGroup;
import com.google.cloud.networksecurity.v1.MirroringEndpointGroup;
import com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest;
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
 * Settings class to configure an instance of {@link MirroringStub}.
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
 * of getMirroringEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MirroringStubSettings.Builder mirroringSettingsBuilder = MirroringStubSettings.newBuilder();
 * mirroringSettingsBuilder
 *     .getMirroringEndpointGroupSettings()
 *     .setRetrySettings(
 *         mirroringSettingsBuilder
 *             .getMirroringEndpointGroupSettings()
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
 * MirroringStubSettings mirroringSettings = mirroringSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMirroringEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MirroringStubSettings.Builder mirroringSettingsBuilder = MirroringStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * mirroringSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class MirroringStubSettings extends StubSettings<MirroringStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          ListMirroringEndpointGroupsPagedResponse>
      listMirroringEndpointGroupsSettings;
  private final UnaryCallSettings<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupSettings;
  private final UnaryCallSettings<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupSettings;
  private final OperationCallSettings<
          CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupOperationSettings;
  private final UnaryCallSettings<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupSettings;
  private final OperationCallSettings<
          UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupOperationSettings;
  private final UnaryCallSettings<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupSettings;
  private final OperationCallSettings<DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupOperationSettings;
  private final PagedCallSettings<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      listMirroringEndpointGroupAssociationsSettings;
  private final UnaryCallSettings<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationSettings;
  private final UnaryCallSettings<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationSettings;
  private final OperationCallSettings<
          CreateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      createMirroringEndpointGroupAssociationOperationSettings;
  private final UnaryCallSettings<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationSettings;
  private final OperationCallSettings<
          UpdateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      updateMirroringEndpointGroupAssociationOperationSettings;
  private final UnaryCallSettings<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationSettings;
  private final OperationCallSettings<
          DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationOperationSettings;
  private final PagedCallSettings<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          ListMirroringDeploymentGroupsPagedResponse>
      listMirroringDeploymentGroupsSettings;
  private final UnaryCallSettings<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupSettings;
  private final UnaryCallSettings<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupSettings;
  private final OperationCallSettings<
          CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupOperationSettings;
  private final UnaryCallSettings<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupSettings;
  private final OperationCallSettings<
          UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupOperationSettings;
  private final UnaryCallSettings<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupSettings;
  private final OperationCallSettings<
          DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentGroupOperationSettings;
  private final PagedCallSettings<
          ListMirroringDeploymentsRequest,
          ListMirroringDeploymentsResponse,
          ListMirroringDeploymentsPagedResponse>
      listMirroringDeploymentsSettings;
  private final UnaryCallSettings<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentSettings;
  private final UnaryCallSettings<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentSettings;
  private final OperationCallSettings<
          CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      createMirroringDeploymentOperationSettings;
  private final UnaryCallSettings<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentSettings;
  private final OperationCallSettings<
          UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentOperationSettings;
  private final UnaryCallSettings<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentSettings;
  private final OperationCallSettings<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          MirroringEndpointGroup>
      LIST_MIRRORING_ENDPOINT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMirroringEndpointGroupsRequest,
              ListMirroringEndpointGroupsResponse,
              MirroringEndpointGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMirroringEndpointGroupsRequest injectToken(
                ListMirroringEndpointGroupsRequest payload, String token) {
              return ListMirroringEndpointGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMirroringEndpointGroupsRequest injectPageSize(
                ListMirroringEndpointGroupsRequest payload, int pageSize) {
              return ListMirroringEndpointGroupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMirroringEndpointGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMirroringEndpointGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MirroringEndpointGroup> extractResources(
                ListMirroringEndpointGroupsResponse payload) {
              return payload.getMirroringEndpointGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          MirroringEndpointGroupAssociation>
      LIST_MIRRORING_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMirroringEndpointGroupAssociationsRequest,
              ListMirroringEndpointGroupAssociationsResponse,
              MirroringEndpointGroupAssociation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMirroringEndpointGroupAssociationsRequest injectToken(
                ListMirroringEndpointGroupAssociationsRequest payload, String token) {
              return ListMirroringEndpointGroupAssociationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMirroringEndpointGroupAssociationsRequest injectPageSize(
                ListMirroringEndpointGroupAssociationsRequest payload, int pageSize) {
              return ListMirroringEndpointGroupAssociationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMirroringEndpointGroupAssociationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMirroringEndpointGroupAssociationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MirroringEndpointGroupAssociation> extractResources(
                ListMirroringEndpointGroupAssociationsResponse payload) {
              return payload.getMirroringEndpointGroupAssociationsList();
            }
          };

  private static final PagedListDescriptor<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          MirroringDeploymentGroup>
      LIST_MIRRORING_DEPLOYMENT_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMirroringDeploymentGroupsRequest,
              ListMirroringDeploymentGroupsResponse,
              MirroringDeploymentGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMirroringDeploymentGroupsRequest injectToken(
                ListMirroringDeploymentGroupsRequest payload, String token) {
              return ListMirroringDeploymentGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMirroringDeploymentGroupsRequest injectPageSize(
                ListMirroringDeploymentGroupsRequest payload, int pageSize) {
              return ListMirroringDeploymentGroupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMirroringDeploymentGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMirroringDeploymentGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MirroringDeploymentGroup> extractResources(
                ListMirroringDeploymentGroupsResponse payload) {
              return payload.getMirroringDeploymentGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse, MirroringDeployment>
      LIST_MIRRORING_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMirroringDeploymentsRequest,
              ListMirroringDeploymentsResponse,
              MirroringDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMirroringDeploymentsRequest injectToken(
                ListMirroringDeploymentsRequest payload, String token) {
              return ListMirroringDeploymentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMirroringDeploymentsRequest injectPageSize(
                ListMirroringDeploymentsRequest payload, int pageSize) {
              return ListMirroringDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMirroringDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMirroringDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MirroringDeployment> extractResources(
                ListMirroringDeploymentsResponse payload) {
              return payload.getMirroringDeploymentsList();
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
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          ListMirroringEndpointGroupsPagedResponse>
      LIST_MIRRORING_ENDPOINT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMirroringEndpointGroupsRequest,
              ListMirroringEndpointGroupsResponse,
              ListMirroringEndpointGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListMirroringEndpointGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
                    callable,
                ListMirroringEndpointGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListMirroringEndpointGroupsResponse> futureResponse) {
              PageContext<
                      ListMirroringEndpointGroupsRequest,
                      ListMirroringEndpointGroupsResponse,
                      MirroringEndpointGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MIRRORING_ENDPOINT_GROUPS_PAGE_STR_DESC, request, context);
              return ListMirroringEndpointGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      LIST_MIRRORING_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMirroringEndpointGroupAssociationsRequest,
              ListMirroringEndpointGroupAssociationsResponse,
              ListMirroringEndpointGroupAssociationsPagedResponse>() {
            @Override
            public ApiFuture<ListMirroringEndpointGroupAssociationsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListMirroringEndpointGroupAssociationsRequest,
                            ListMirroringEndpointGroupAssociationsResponse>
                        callable,
                    ListMirroringEndpointGroupAssociationsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListMirroringEndpointGroupAssociationsResponse> futureResponse) {
              PageContext<
                      ListMirroringEndpointGroupAssociationsRequest,
                      ListMirroringEndpointGroupAssociationsResponse,
                      MirroringEndpointGroupAssociation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MIRRORING_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListMirroringEndpointGroupAssociationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          ListMirroringDeploymentGroupsPagedResponse>
      LIST_MIRRORING_DEPLOYMENT_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMirroringDeploymentGroupsRequest,
              ListMirroringDeploymentGroupsResponse,
              ListMirroringDeploymentGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListMirroringDeploymentGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
                    callable,
                ListMirroringDeploymentGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListMirroringDeploymentGroupsResponse> futureResponse) {
              PageContext<
                      ListMirroringDeploymentGroupsRequest,
                      ListMirroringDeploymentGroupsResponse,
                      MirroringDeploymentGroup>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MIRRORING_DEPLOYMENT_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListMirroringDeploymentGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMirroringDeploymentsRequest,
          ListMirroringDeploymentsResponse,
          ListMirroringDeploymentsPagedResponse>
      LIST_MIRRORING_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMirroringDeploymentsRequest,
              ListMirroringDeploymentsResponse,
              ListMirroringDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListMirroringDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>
                    callable,
                ListMirroringDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListMirroringDeploymentsResponse> futureResponse) {
              PageContext<
                      ListMirroringDeploymentsRequest,
                      ListMirroringDeploymentsResponse,
                      MirroringDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MIRRORING_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListMirroringDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listMirroringEndpointGroups. */
  public PagedCallSettings<
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          ListMirroringEndpointGroupsPagedResponse>
      listMirroringEndpointGroupsSettings() {
    return listMirroringEndpointGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getMirroringEndpointGroup. */
  public UnaryCallSettings<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupSettings() {
    return getMirroringEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to createMirroringEndpointGroup. */
  public UnaryCallSettings<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupSettings() {
    return createMirroringEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to createMirroringEndpointGroup. */
  public OperationCallSettings<
          CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupOperationSettings() {
    return createMirroringEndpointGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMirroringEndpointGroup. */
  public UnaryCallSettings<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupSettings() {
    return updateMirroringEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateMirroringEndpointGroup. */
  public OperationCallSettings<
          UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupOperationSettings() {
    return updateMirroringEndpointGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMirroringEndpointGroup. */
  public UnaryCallSettings<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupSettings() {
    return deleteMirroringEndpointGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteMirroringEndpointGroup. */
  public OperationCallSettings<DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupOperationSettings() {
    return deleteMirroringEndpointGroupOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to listMirroringEndpointGroupAssociations.
   */
  public PagedCallSettings<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      listMirroringEndpointGroupAssociationsSettings() {
    return listMirroringEndpointGroupAssociationsSettings;
  }

  /**
   * Returns the object with the settings used for calls to getMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationSettings() {
    return getMirroringEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to createMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationSettings() {
    return createMirroringEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to createMirroringEndpointGroupAssociation.
   */
  public OperationCallSettings<
          CreateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      createMirroringEndpointGroupAssociationOperationSettings() {
    return createMirroringEndpointGroupAssociationOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationSettings() {
    return updateMirroringEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateMirroringEndpointGroupAssociation.
   */
  public OperationCallSettings<
          UpdateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      updateMirroringEndpointGroupAssociationOperationSettings() {
    return updateMirroringEndpointGroupAssociationOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationSettings() {
    return deleteMirroringEndpointGroupAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteMirroringEndpointGroupAssociation.
   */
  public OperationCallSettings<
          DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationOperationSettings() {
    return deleteMirroringEndpointGroupAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMirroringDeploymentGroups. */
  public PagedCallSettings<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          ListMirroringDeploymentGroupsPagedResponse>
      listMirroringDeploymentGroupsSettings() {
    return listMirroringDeploymentGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getMirroringDeploymentGroup. */
  public UnaryCallSettings<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupSettings() {
    return getMirroringDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to createMirroringDeploymentGroup. */
  public UnaryCallSettings<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupSettings() {
    return createMirroringDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to createMirroringDeploymentGroup. */
  public OperationCallSettings<
          CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupOperationSettings() {
    return createMirroringDeploymentGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMirroringDeploymentGroup. */
  public UnaryCallSettings<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupSettings() {
    return updateMirroringDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateMirroringDeploymentGroup. */
  public OperationCallSettings<
          UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupOperationSettings() {
    return updateMirroringDeploymentGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeploymentGroup. */
  public UnaryCallSettings<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupSettings() {
    return deleteMirroringDeploymentGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeploymentGroup. */
  public OperationCallSettings<DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentGroupOperationSettings() {
    return deleteMirroringDeploymentGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMirroringDeployments. */
  public PagedCallSettings<
          ListMirroringDeploymentsRequest,
          ListMirroringDeploymentsResponse,
          ListMirroringDeploymentsPagedResponse>
      listMirroringDeploymentsSettings() {
    return listMirroringDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getMirroringDeployment. */
  public UnaryCallSettings<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentSettings() {
    return getMirroringDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createMirroringDeployment. */
  public UnaryCallSettings<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentSettings() {
    return createMirroringDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createMirroringDeployment. */
  public OperationCallSettings<
          CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      createMirroringDeploymentOperationSettings() {
    return createMirroringDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMirroringDeployment. */
  public UnaryCallSettings<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentSettings() {
    return updateMirroringDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateMirroringDeployment. */
  public OperationCallSettings<
          UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentOperationSettings() {
    return updateMirroringDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeployment. */
  public UnaryCallSettings<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentSettings() {
    return deleteMirroringDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeployment. */
  public OperationCallSettings<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentOperationSettings() {
    return deleteMirroringDeploymentOperationSettings;
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

  public MirroringStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMirroringStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(MirroringStubSettings.class))
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

  protected MirroringStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listMirroringEndpointGroupsSettings =
        settingsBuilder.listMirroringEndpointGroupsSettings().build();
    getMirroringEndpointGroupSettings = settingsBuilder.getMirroringEndpointGroupSettings().build();
    createMirroringEndpointGroupSettings =
        settingsBuilder.createMirroringEndpointGroupSettings().build();
    createMirroringEndpointGroupOperationSettings =
        settingsBuilder.createMirroringEndpointGroupOperationSettings().build();
    updateMirroringEndpointGroupSettings =
        settingsBuilder.updateMirroringEndpointGroupSettings().build();
    updateMirroringEndpointGroupOperationSettings =
        settingsBuilder.updateMirroringEndpointGroupOperationSettings().build();
    deleteMirroringEndpointGroupSettings =
        settingsBuilder.deleteMirroringEndpointGroupSettings().build();
    deleteMirroringEndpointGroupOperationSettings =
        settingsBuilder.deleteMirroringEndpointGroupOperationSettings().build();
    listMirroringEndpointGroupAssociationsSettings =
        settingsBuilder.listMirroringEndpointGroupAssociationsSettings().build();
    getMirroringEndpointGroupAssociationSettings =
        settingsBuilder.getMirroringEndpointGroupAssociationSettings().build();
    createMirroringEndpointGroupAssociationSettings =
        settingsBuilder.createMirroringEndpointGroupAssociationSettings().build();
    createMirroringEndpointGroupAssociationOperationSettings =
        settingsBuilder.createMirroringEndpointGroupAssociationOperationSettings().build();
    updateMirroringEndpointGroupAssociationSettings =
        settingsBuilder.updateMirroringEndpointGroupAssociationSettings().build();
    updateMirroringEndpointGroupAssociationOperationSettings =
        settingsBuilder.updateMirroringEndpointGroupAssociationOperationSettings().build();
    deleteMirroringEndpointGroupAssociationSettings =
        settingsBuilder.deleteMirroringEndpointGroupAssociationSettings().build();
    deleteMirroringEndpointGroupAssociationOperationSettings =
        settingsBuilder.deleteMirroringEndpointGroupAssociationOperationSettings().build();
    listMirroringDeploymentGroupsSettings =
        settingsBuilder.listMirroringDeploymentGroupsSettings().build();
    getMirroringDeploymentGroupSettings =
        settingsBuilder.getMirroringDeploymentGroupSettings().build();
    createMirroringDeploymentGroupSettings =
        settingsBuilder.createMirroringDeploymentGroupSettings().build();
    createMirroringDeploymentGroupOperationSettings =
        settingsBuilder.createMirroringDeploymentGroupOperationSettings().build();
    updateMirroringDeploymentGroupSettings =
        settingsBuilder.updateMirroringDeploymentGroupSettings().build();
    updateMirroringDeploymentGroupOperationSettings =
        settingsBuilder.updateMirroringDeploymentGroupOperationSettings().build();
    deleteMirroringDeploymentGroupSettings =
        settingsBuilder.deleteMirroringDeploymentGroupSettings().build();
    deleteMirroringDeploymentGroupOperationSettings =
        settingsBuilder.deleteMirroringDeploymentGroupOperationSettings().build();
    listMirroringDeploymentsSettings = settingsBuilder.listMirroringDeploymentsSettings().build();
    getMirroringDeploymentSettings = settingsBuilder.getMirroringDeploymentSettings().build();
    createMirroringDeploymentSettings = settingsBuilder.createMirroringDeploymentSettings().build();
    createMirroringDeploymentOperationSettings =
        settingsBuilder.createMirroringDeploymentOperationSettings().build();
    updateMirroringDeploymentSettings = settingsBuilder.updateMirroringDeploymentSettings().build();
    updateMirroringDeploymentOperationSettings =
        settingsBuilder.updateMirroringDeploymentOperationSettings().build();
    deleteMirroringDeploymentSettings = settingsBuilder.deleteMirroringDeploymentSettings().build();
    deleteMirroringDeploymentOperationSettings =
        settingsBuilder.deleteMirroringDeploymentOperationSettings().build();
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

  /** Builder for MirroringStubSettings. */
  public static class Builder extends StubSettings.Builder<MirroringStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListMirroringEndpointGroupsRequest,
            ListMirroringEndpointGroupsResponse,
            ListMirroringEndpointGroupsPagedResponse>
        listMirroringEndpointGroupsSettings;
    private final UnaryCallSettings.Builder<
            GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
        getMirroringEndpointGroupSettings;
    private final UnaryCallSettings.Builder<CreateMirroringEndpointGroupRequest, Operation>
        createMirroringEndpointGroupSettings;
    private final OperationCallSettings.Builder<
            CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
        createMirroringEndpointGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMirroringEndpointGroupRequest, Operation>
        updateMirroringEndpointGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
        updateMirroringEndpointGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMirroringEndpointGroupRequest, Operation>
        deleteMirroringEndpointGroupSettings;
    private final OperationCallSettings.Builder<
            DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
        deleteMirroringEndpointGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListMirroringEndpointGroupAssociationsRequest,
            ListMirroringEndpointGroupAssociationsResponse,
            ListMirroringEndpointGroupAssociationsPagedResponse>
        listMirroringEndpointGroupAssociationsSettings;
    private final UnaryCallSettings.Builder<
            GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
        getMirroringEndpointGroupAssociationSettings;
    private final UnaryCallSettings.Builder<
            CreateMirroringEndpointGroupAssociationRequest, Operation>
        createMirroringEndpointGroupAssociationSettings;
    private final OperationCallSettings.Builder<
            CreateMirroringEndpointGroupAssociationRequest,
            MirroringEndpointGroupAssociation,
            OperationMetadata>
        createMirroringEndpointGroupAssociationOperationSettings;
    private final UnaryCallSettings.Builder<
            UpdateMirroringEndpointGroupAssociationRequest, Operation>
        updateMirroringEndpointGroupAssociationSettings;
    private final OperationCallSettings.Builder<
            UpdateMirroringEndpointGroupAssociationRequest,
            MirroringEndpointGroupAssociation,
            OperationMetadata>
        updateMirroringEndpointGroupAssociationOperationSettings;
    private final UnaryCallSettings.Builder<
            DeleteMirroringEndpointGroupAssociationRequest, Operation>
        deleteMirroringEndpointGroupAssociationSettings;
    private final OperationCallSettings.Builder<
            DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
        deleteMirroringEndpointGroupAssociationOperationSettings;
    private final PagedCallSettings.Builder<
            ListMirroringDeploymentGroupsRequest,
            ListMirroringDeploymentGroupsResponse,
            ListMirroringDeploymentGroupsPagedResponse>
        listMirroringDeploymentGroupsSettings;
    private final UnaryCallSettings.Builder<
            GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
        getMirroringDeploymentGroupSettings;
    private final UnaryCallSettings.Builder<CreateMirroringDeploymentGroupRequest, Operation>
        createMirroringDeploymentGroupSettings;
    private final OperationCallSettings.Builder<
            CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
        createMirroringDeploymentGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMirroringDeploymentGroupRequest, Operation>
        updateMirroringDeploymentGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
        updateMirroringDeploymentGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMirroringDeploymentGroupRequest, Operation>
        deleteMirroringDeploymentGroupSettings;
    private final OperationCallSettings.Builder<
            DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
        deleteMirroringDeploymentGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListMirroringDeploymentsRequest,
            ListMirroringDeploymentsResponse,
            ListMirroringDeploymentsPagedResponse>
        listMirroringDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetMirroringDeploymentRequest, MirroringDeployment>
        getMirroringDeploymentSettings;
    private final UnaryCallSettings.Builder<CreateMirroringDeploymentRequest, Operation>
        createMirroringDeploymentSettings;
    private final OperationCallSettings.Builder<
            CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
        createMirroringDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMirroringDeploymentRequest, Operation>
        updateMirroringDeploymentSettings;
    private final OperationCallSettings.Builder<
            UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
        updateMirroringDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMirroringDeploymentRequest, Operation>
        deleteMirroringDeploymentSettings;
    private final OperationCallSettings.Builder<
            DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
        deleteMirroringDeploymentOperationSettings;
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

      listMirroringEndpointGroupsSettings =
          PagedCallSettings.newBuilder(LIST_MIRRORING_ENDPOINT_GROUPS_PAGE_STR_FACT);
      getMirroringEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringEndpointGroupOperationSettings = OperationCallSettings.newBuilder();
      updateMirroringEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMirroringEndpointGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteMirroringEndpointGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMirroringEndpointGroupOperationSettings = OperationCallSettings.newBuilder();
      listMirroringEndpointGroupAssociationsSettings =
          PagedCallSettings.newBuilder(LIST_MIRRORING_ENDPOINT_GROUP_ASSOCIATIONS_PAGE_STR_FACT);
      getMirroringEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringEndpointGroupAssociationOperationSettings = OperationCallSettings.newBuilder();
      updateMirroringEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMirroringEndpointGroupAssociationOperationSettings = OperationCallSettings.newBuilder();
      deleteMirroringEndpointGroupAssociationSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMirroringEndpointGroupAssociationOperationSettings = OperationCallSettings.newBuilder();
      listMirroringDeploymentGroupsSettings =
          PagedCallSettings.newBuilder(LIST_MIRRORING_DEPLOYMENT_GROUPS_PAGE_STR_FACT);
      getMirroringDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringDeploymentGroupOperationSettings = OperationCallSettings.newBuilder();
      updateMirroringDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMirroringDeploymentGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteMirroringDeploymentGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMirroringDeploymentGroupOperationSettings = OperationCallSettings.newBuilder();
      listMirroringDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_MIRRORING_DEPLOYMENTS_PAGE_STR_FACT);
      getMirroringDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMirroringDeploymentOperationSettings = OperationCallSettings.newBuilder();
      updateMirroringDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMirroringDeploymentOperationSettings = OperationCallSettings.newBuilder();
      deleteMirroringDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMirroringDeploymentOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMirroringEndpointGroupsSettings,
              getMirroringEndpointGroupSettings,
              createMirroringEndpointGroupSettings,
              updateMirroringEndpointGroupSettings,
              deleteMirroringEndpointGroupSettings,
              listMirroringEndpointGroupAssociationsSettings,
              getMirroringEndpointGroupAssociationSettings,
              createMirroringEndpointGroupAssociationSettings,
              updateMirroringEndpointGroupAssociationSettings,
              deleteMirroringEndpointGroupAssociationSettings,
              listMirroringDeploymentGroupsSettings,
              getMirroringDeploymentGroupSettings,
              createMirroringDeploymentGroupSettings,
              updateMirroringDeploymentGroupSettings,
              deleteMirroringDeploymentGroupSettings,
              listMirroringDeploymentsSettings,
              getMirroringDeploymentSettings,
              createMirroringDeploymentSettings,
              updateMirroringDeploymentSettings,
              deleteMirroringDeploymentSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(MirroringStubSettings settings) {
      super(settings);

      listMirroringEndpointGroupsSettings =
          settings.listMirroringEndpointGroupsSettings.toBuilder();
      getMirroringEndpointGroupSettings = settings.getMirroringEndpointGroupSettings.toBuilder();
      createMirroringEndpointGroupSettings =
          settings.createMirroringEndpointGroupSettings.toBuilder();
      createMirroringEndpointGroupOperationSettings =
          settings.createMirroringEndpointGroupOperationSettings.toBuilder();
      updateMirroringEndpointGroupSettings =
          settings.updateMirroringEndpointGroupSettings.toBuilder();
      updateMirroringEndpointGroupOperationSettings =
          settings.updateMirroringEndpointGroupOperationSettings.toBuilder();
      deleteMirroringEndpointGroupSettings =
          settings.deleteMirroringEndpointGroupSettings.toBuilder();
      deleteMirroringEndpointGroupOperationSettings =
          settings.deleteMirroringEndpointGroupOperationSettings.toBuilder();
      listMirroringEndpointGroupAssociationsSettings =
          settings.listMirroringEndpointGroupAssociationsSettings.toBuilder();
      getMirroringEndpointGroupAssociationSettings =
          settings.getMirroringEndpointGroupAssociationSettings.toBuilder();
      createMirroringEndpointGroupAssociationSettings =
          settings.createMirroringEndpointGroupAssociationSettings.toBuilder();
      createMirroringEndpointGroupAssociationOperationSettings =
          settings.createMirroringEndpointGroupAssociationOperationSettings.toBuilder();
      updateMirroringEndpointGroupAssociationSettings =
          settings.updateMirroringEndpointGroupAssociationSettings.toBuilder();
      updateMirroringEndpointGroupAssociationOperationSettings =
          settings.updateMirroringEndpointGroupAssociationOperationSettings.toBuilder();
      deleteMirroringEndpointGroupAssociationSettings =
          settings.deleteMirroringEndpointGroupAssociationSettings.toBuilder();
      deleteMirroringEndpointGroupAssociationOperationSettings =
          settings.deleteMirroringEndpointGroupAssociationOperationSettings.toBuilder();
      listMirroringDeploymentGroupsSettings =
          settings.listMirroringDeploymentGroupsSettings.toBuilder();
      getMirroringDeploymentGroupSettings =
          settings.getMirroringDeploymentGroupSettings.toBuilder();
      createMirroringDeploymentGroupSettings =
          settings.createMirroringDeploymentGroupSettings.toBuilder();
      createMirroringDeploymentGroupOperationSettings =
          settings.createMirroringDeploymentGroupOperationSettings.toBuilder();
      updateMirroringDeploymentGroupSettings =
          settings.updateMirroringDeploymentGroupSettings.toBuilder();
      updateMirroringDeploymentGroupOperationSettings =
          settings.updateMirroringDeploymentGroupOperationSettings.toBuilder();
      deleteMirroringDeploymentGroupSettings =
          settings.deleteMirroringDeploymentGroupSettings.toBuilder();
      deleteMirroringDeploymentGroupOperationSettings =
          settings.deleteMirroringDeploymentGroupOperationSettings.toBuilder();
      listMirroringDeploymentsSettings = settings.listMirroringDeploymentsSettings.toBuilder();
      getMirroringDeploymentSettings = settings.getMirroringDeploymentSettings.toBuilder();
      createMirroringDeploymentSettings = settings.createMirroringDeploymentSettings.toBuilder();
      createMirroringDeploymentOperationSettings =
          settings.createMirroringDeploymentOperationSettings.toBuilder();
      updateMirroringDeploymentSettings = settings.updateMirroringDeploymentSettings.toBuilder();
      updateMirroringDeploymentOperationSettings =
          settings.updateMirroringDeploymentOperationSettings.toBuilder();
      deleteMirroringDeploymentSettings = settings.deleteMirroringDeploymentSettings.toBuilder();
      deleteMirroringDeploymentOperationSettings =
          settings.deleteMirroringDeploymentOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMirroringEndpointGroupsSettings,
              getMirroringEndpointGroupSettings,
              createMirroringEndpointGroupSettings,
              updateMirroringEndpointGroupSettings,
              deleteMirroringEndpointGroupSettings,
              listMirroringEndpointGroupAssociationsSettings,
              getMirroringEndpointGroupAssociationSettings,
              createMirroringEndpointGroupAssociationSettings,
              updateMirroringEndpointGroupAssociationSettings,
              deleteMirroringEndpointGroupAssociationSettings,
              listMirroringDeploymentGroupsSettings,
              getMirroringDeploymentGroupSettings,
              createMirroringDeploymentGroupSettings,
              updateMirroringDeploymentGroupSettings,
              deleteMirroringDeploymentGroupSettings,
              listMirroringDeploymentsSettings,
              getMirroringDeploymentSettings,
              createMirroringDeploymentSettings,
              updateMirroringDeploymentSettings,
              deleteMirroringDeploymentSettings,
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
          .listMirroringEndpointGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMirroringEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMirroringEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMirroringEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMirroringEndpointGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMirroringEndpointGroupAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMirroringEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMirroringEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMirroringEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMirroringEndpointGroupAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMirroringDeploymentGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMirroringDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMirroringDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMirroringDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMirroringDeploymentGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMirroringDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMirroringDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMirroringDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMirroringDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMirroringDeploymentSettings()
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
          .createMirroringEndpointGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMirroringEndpointGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MirroringEndpointGroup.class))
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
          .updateMirroringEndpointGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMirroringEndpointGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MirroringEndpointGroup.class))
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
          .deleteMirroringEndpointGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMirroringEndpointGroupRequest, OperationSnapshot>
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
          .createMirroringEndpointGroupAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMirroringEndpointGroupAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  MirroringEndpointGroupAssociation.class))
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
          .updateMirroringEndpointGroupAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMirroringEndpointGroupAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  MirroringEndpointGroupAssociation.class))
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
          .deleteMirroringEndpointGroupAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMirroringEndpointGroupAssociationRequest, OperationSnapshot>
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
          .createMirroringDeploymentGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMirroringDeploymentGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MirroringDeploymentGroup.class))
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
          .updateMirroringDeploymentGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMirroringDeploymentGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MirroringDeploymentGroup.class))
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
          .deleteMirroringDeploymentGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMirroringDeploymentGroupRequest, OperationSnapshot>
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
          .createMirroringDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMirroringDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MirroringDeployment.class))
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
          .updateMirroringDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMirroringDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MirroringDeployment.class))
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
          .deleteMirroringDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMirroringDeploymentRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to listMirroringEndpointGroups. */
    public PagedCallSettings.Builder<
            ListMirroringEndpointGroupsRequest,
            ListMirroringEndpointGroupsResponse,
            ListMirroringEndpointGroupsPagedResponse>
        listMirroringEndpointGroupsSettings() {
      return listMirroringEndpointGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
        getMirroringEndpointGroupSettings() {
      return getMirroringEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<CreateMirroringEndpointGroupRequest, Operation>
        createMirroringEndpointGroupSettings() {
      return createMirroringEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createMirroringEndpointGroup. */
    public OperationCallSettings.Builder<
            CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
        createMirroringEndpointGroupOperationSettings() {
      return createMirroringEndpointGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<UpdateMirroringEndpointGroupRequest, Operation>
        updateMirroringEndpointGroupSettings() {
      return updateMirroringEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateMirroringEndpointGroup. */
    public OperationCallSettings.Builder<
            UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
        updateMirroringEndpointGroupOperationSettings() {
      return updateMirroringEndpointGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteMirroringEndpointGroupRequest, Operation>
        deleteMirroringEndpointGroupSettings() {
      return deleteMirroringEndpointGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMirroringEndpointGroup. */
    public OperationCallSettings.Builder<
            DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
        deleteMirroringEndpointGroupOperationSettings() {
      return deleteMirroringEndpointGroupOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listMirroringEndpointGroupAssociations.
     */
    public PagedCallSettings.Builder<
            ListMirroringEndpointGroupAssociationsRequest,
            ListMirroringEndpointGroupAssociationsResponse,
            ListMirroringEndpointGroupAssociationsPagedResponse>
        listMirroringEndpointGroupAssociationsSettings() {
      return listMirroringEndpointGroupAssociationsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<
            GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
        getMirroringEndpointGroupAssociationSettings() {
      return getMirroringEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * createMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<CreateMirroringEndpointGroupAssociationRequest, Operation>
        createMirroringEndpointGroupAssociationSettings() {
      return createMirroringEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * createMirroringEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            CreateMirroringEndpointGroupAssociationRequest,
            MirroringEndpointGroupAssociation,
            OperationMetadata>
        createMirroringEndpointGroupAssociationOperationSettings() {
      return createMirroringEndpointGroupAssociationOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<UpdateMirroringEndpointGroupAssociationRequest, Operation>
        updateMirroringEndpointGroupAssociationSettings() {
      return updateMirroringEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateMirroringEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            UpdateMirroringEndpointGroupAssociationRequest,
            MirroringEndpointGroupAssociation,
            OperationMetadata>
        updateMirroringEndpointGroupAssociationOperationSettings() {
      return updateMirroringEndpointGroupAssociationOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<DeleteMirroringEndpointGroupAssociationRequest, Operation>
        deleteMirroringEndpointGroupAssociationSettings() {
      return deleteMirroringEndpointGroupAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteMirroringEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
        deleteMirroringEndpointGroupAssociationOperationSettings() {
      return deleteMirroringEndpointGroupAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMirroringDeploymentGroups. */
    public PagedCallSettings.Builder<
            ListMirroringDeploymentGroupsRequest,
            ListMirroringDeploymentGroupsResponse,
            ListMirroringDeploymentGroupsPagedResponse>
        listMirroringDeploymentGroupsSettings() {
      return listMirroringDeploymentGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
        getMirroringDeploymentGroupSettings() {
      return getMirroringDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<CreateMirroringDeploymentGroupRequest, Operation>
        createMirroringDeploymentGroupSettings() {
      return createMirroringDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createMirroringDeploymentGroup. */
    public OperationCallSettings.Builder<
            CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
        createMirroringDeploymentGroupOperationSettings() {
      return createMirroringDeploymentGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<UpdateMirroringDeploymentGroupRequest, Operation>
        updateMirroringDeploymentGroupSettings() {
      return updateMirroringDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeploymentGroup. */
    public OperationCallSettings.Builder<
            UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
        updateMirroringDeploymentGroupOperationSettings() {
      return updateMirroringDeploymentGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<DeleteMirroringDeploymentGroupRequest, Operation>
        deleteMirroringDeploymentGroupSettings() {
      return deleteMirroringDeploymentGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeploymentGroup. */
    public OperationCallSettings.Builder<
            DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
        deleteMirroringDeploymentGroupOperationSettings() {
      return deleteMirroringDeploymentGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMirroringDeployments. */
    public PagedCallSettings.Builder<
            ListMirroringDeploymentsRequest,
            ListMirroringDeploymentsResponse,
            ListMirroringDeploymentsPagedResponse>
        listMirroringDeploymentsSettings() {
      return listMirroringDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getMirroringDeployment. */
    public UnaryCallSettings.Builder<GetMirroringDeploymentRequest, MirroringDeployment>
        getMirroringDeploymentSettings() {
      return getMirroringDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createMirroringDeployment. */
    public UnaryCallSettings.Builder<CreateMirroringDeploymentRequest, Operation>
        createMirroringDeploymentSettings() {
      return createMirroringDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createMirroringDeployment. */
    public OperationCallSettings.Builder<
            CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
        createMirroringDeploymentOperationSettings() {
      return createMirroringDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeployment. */
    public UnaryCallSettings.Builder<UpdateMirroringDeploymentRequest, Operation>
        updateMirroringDeploymentSettings() {
      return updateMirroringDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeployment. */
    public OperationCallSettings.Builder<
            UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
        updateMirroringDeploymentOperationSettings() {
      return updateMirroringDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeployment. */
    public UnaryCallSettings.Builder<DeleteMirroringDeploymentRequest, Operation>
        deleteMirroringDeploymentSettings() {
      return deleteMirroringDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeployment. */
    public OperationCallSettings.Builder<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
        deleteMirroringDeploymentOperationSettings() {
      return deleteMirroringDeploymentOperationSettings;
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
    public MirroringStubSettings build() throws IOException {
      return new MirroringStubSettings(this);
    }
  }
}
