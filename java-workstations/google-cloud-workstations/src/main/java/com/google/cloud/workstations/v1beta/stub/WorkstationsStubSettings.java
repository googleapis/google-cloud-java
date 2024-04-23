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

package com.google.cloud.workstations.v1beta.stub;

import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListUsableWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListUsableWorkstationsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationClustersPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.workstations.v1beta.CreateWorkstationClusterRequest;
import com.google.cloud.workstations.v1beta.CreateWorkstationConfigRequest;
import com.google.cloud.workstations.v1beta.CreateWorkstationRequest;
import com.google.cloud.workstations.v1beta.DeleteWorkstationClusterRequest;
import com.google.cloud.workstations.v1beta.DeleteWorkstationConfigRequest;
import com.google.cloud.workstations.v1beta.DeleteWorkstationRequest;
import com.google.cloud.workstations.v1beta.GenerateAccessTokenRequest;
import com.google.cloud.workstations.v1beta.GenerateAccessTokenResponse;
import com.google.cloud.workstations.v1beta.GetWorkstationClusterRequest;
import com.google.cloud.workstations.v1beta.GetWorkstationConfigRequest;
import com.google.cloud.workstations.v1beta.GetWorkstationRequest;
import com.google.cloud.workstations.v1beta.ListUsableWorkstationConfigsRequest;
import com.google.cloud.workstations.v1beta.ListUsableWorkstationConfigsResponse;
import com.google.cloud.workstations.v1beta.ListUsableWorkstationsRequest;
import com.google.cloud.workstations.v1beta.ListUsableWorkstationsResponse;
import com.google.cloud.workstations.v1beta.ListWorkstationClustersRequest;
import com.google.cloud.workstations.v1beta.ListWorkstationClustersResponse;
import com.google.cloud.workstations.v1beta.ListWorkstationConfigsRequest;
import com.google.cloud.workstations.v1beta.ListWorkstationConfigsResponse;
import com.google.cloud.workstations.v1beta.ListWorkstationsRequest;
import com.google.cloud.workstations.v1beta.ListWorkstationsResponse;
import com.google.cloud.workstations.v1beta.OperationMetadata;
import com.google.cloud.workstations.v1beta.StartWorkstationRequest;
import com.google.cloud.workstations.v1beta.StopWorkstationRequest;
import com.google.cloud.workstations.v1beta.UpdateWorkstationClusterRequest;
import com.google.cloud.workstations.v1beta.UpdateWorkstationConfigRequest;
import com.google.cloud.workstations.v1beta.UpdateWorkstationRequest;
import com.google.cloud.workstations.v1beta.Workstation;
import com.google.cloud.workstations.v1beta.WorkstationCluster;
import com.google.cloud.workstations.v1beta.WorkstationConfig;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkstationsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workstations.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getWorkstationCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkstationsStubSettings.Builder workstationsSettingsBuilder =
 *     WorkstationsStubSettings.newBuilder();
 * workstationsSettingsBuilder
 *     .getWorkstationClusterSettings()
 *     .setRetrySettings(
 *         workstationsSettingsBuilder
 *             .getWorkstationClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WorkstationsStubSettings workstationsSettings = workstationsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WorkstationsStubSettings extends StubSettings<WorkstationsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterSettings;
  private final PagedCallSettings<
          ListWorkstationClustersRequest,
          ListWorkstationClustersResponse,
          ListWorkstationClustersPagedResponse>
      listWorkstationClustersSettings;
  private final UnaryCallSettings<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterSettings;
  private final OperationCallSettings<
          CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationSettings;
  private final UnaryCallSettings<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterSettings;
  private final OperationCallSettings<
          UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationSettings;
  private final UnaryCallSettings<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterSettings;
  private final OperationCallSettings<
          DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationSettings;
  private final UnaryCallSettings<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigSettings;
  private final PagedCallSettings<
          ListWorkstationConfigsRequest,
          ListWorkstationConfigsResponse,
          ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsSettings;
  private final PagedCallSettings<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsSettings;
  private final UnaryCallSettings<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigSettings;
  private final OperationCallSettings<
          CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationSettings;
  private final UnaryCallSettings<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigSettings;
  private final OperationCallSettings<
          UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationSettings;
  private final UnaryCallSettings<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigSettings;
  private final OperationCallSettings<
          DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationSettings;
  private final UnaryCallSettings<GetWorkstationRequest, Workstation> getWorkstationSettings;
  private final PagedCallSettings<
          ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>
      listWorkstationsSettings;
  private final PagedCallSettings<
          ListUsableWorkstationsRequest,
          ListUsableWorkstationsResponse,
          ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsSettings;
  private final UnaryCallSettings<CreateWorkstationRequest, Operation> createWorkstationSettings;
  private final OperationCallSettings<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationSettings;
  private final UnaryCallSettings<UpdateWorkstationRequest, Operation> updateWorkstationSettings;
  private final OperationCallSettings<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationSettings;
  private final UnaryCallSettings<DeleteWorkstationRequest, Operation> deleteWorkstationSettings;
  private final OperationCallSettings<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationSettings;
  private final UnaryCallSettings<StartWorkstationRequest, Operation> startWorkstationSettings;
  private final OperationCallSettings<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationSettings;
  private final UnaryCallSettings<StopWorkstationRequest, Operation> stopWorkstationSettings;
  private final OperationCallSettings<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationSettings;
  private final UnaryCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListWorkstationClustersRequest, ListWorkstationClustersResponse, WorkstationCluster>
      LIST_WORKSTATION_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkstationClustersRequest,
              ListWorkstationClustersResponse,
              WorkstationCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkstationClustersRequest injectToken(
                ListWorkstationClustersRequest payload, String token) {
              return ListWorkstationClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkstationClustersRequest injectPageSize(
                ListWorkstationClustersRequest payload, int pageSize) {
              return ListWorkstationClustersRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListWorkstationClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkstationClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkstationCluster> extractResources(
                ListWorkstationClustersResponse payload) {
              return payload.getWorkstationClustersList() == null
                  ? ImmutableList.<WorkstationCluster>of()
                  : payload.getWorkstationClustersList();
            }
          };

  private static final PagedListDescriptor<
          ListWorkstationConfigsRequest, ListWorkstationConfigsResponse, WorkstationConfig>
      LIST_WORKSTATION_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkstationConfigsRequest, ListWorkstationConfigsResponse, WorkstationConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkstationConfigsRequest injectToken(
                ListWorkstationConfigsRequest payload, String token) {
              return ListWorkstationConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkstationConfigsRequest injectPageSize(
                ListWorkstationConfigsRequest payload, int pageSize) {
              return ListWorkstationConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListWorkstationConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkstationConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkstationConfig> extractResources(
                ListWorkstationConfigsResponse payload) {
              return payload.getWorkstationConfigsList() == null
                  ? ImmutableList.<WorkstationConfig>of()
                  : payload.getWorkstationConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          WorkstationConfig>
      LIST_USABLE_WORKSTATION_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUsableWorkstationConfigsRequest,
              ListUsableWorkstationConfigsResponse,
              WorkstationConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUsableWorkstationConfigsRequest injectToken(
                ListUsableWorkstationConfigsRequest payload, String token) {
              return ListUsableWorkstationConfigsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUsableWorkstationConfigsRequest injectPageSize(
                ListUsableWorkstationConfigsRequest payload, int pageSize) {
              return ListUsableWorkstationConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUsableWorkstationConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUsableWorkstationConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkstationConfig> extractResources(
                ListUsableWorkstationConfigsResponse payload) {
              return payload.getWorkstationConfigsList() == null
                  ? ImmutableList.<WorkstationConfig>of()
                  : payload.getWorkstationConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListWorkstationsRequest, ListWorkstationsResponse, Workstation>
      LIST_WORKSTATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkstationsRequest, ListWorkstationsResponse, Workstation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkstationsRequest injectToken(
                ListWorkstationsRequest payload, String token) {
              return ListWorkstationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkstationsRequest injectPageSize(
                ListWorkstationsRequest payload, int pageSize) {
              return ListWorkstationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkstationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkstationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workstation> extractResources(ListWorkstationsResponse payload) {
              return payload.getWorkstationsList() == null
                  ? ImmutableList.<Workstation>of()
                  : payload.getWorkstationsList();
            }
          };

  private static final PagedListDescriptor<
          ListUsableWorkstationsRequest, ListUsableWorkstationsResponse, Workstation>
      LIST_USABLE_WORKSTATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUsableWorkstationsRequest, ListUsableWorkstationsResponse, Workstation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUsableWorkstationsRequest injectToken(
                ListUsableWorkstationsRequest payload, String token) {
              return ListUsableWorkstationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUsableWorkstationsRequest injectPageSize(
                ListUsableWorkstationsRequest payload, int pageSize) {
              return ListUsableWorkstationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUsableWorkstationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUsableWorkstationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workstation> extractResources(ListUsableWorkstationsResponse payload) {
              return payload.getWorkstationsList() == null
                  ? ImmutableList.<Workstation>of()
                  : payload.getWorkstationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListWorkstationClustersRequest,
          ListWorkstationClustersResponse,
          ListWorkstationClustersPagedResponse>
      LIST_WORKSTATION_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkstationClustersRequest,
              ListWorkstationClustersResponse,
              ListWorkstationClustersPagedResponse>() {
            @Override
            public ApiFuture<ListWorkstationClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
                    callable,
                ListWorkstationClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkstationClustersResponse> futureResponse) {
              PageContext<
                      ListWorkstationClustersRequest,
                      ListWorkstationClustersResponse,
                      WorkstationCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKSTATION_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListWorkstationClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkstationConfigsRequest,
          ListWorkstationConfigsResponse,
          ListWorkstationConfigsPagedResponse>
      LIST_WORKSTATION_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkstationConfigsRequest,
              ListWorkstationConfigsResponse,
              ListWorkstationConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkstationConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
                    callable,
                ListWorkstationConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkstationConfigsResponse> futureResponse) {
              PageContext<
                      ListWorkstationConfigsRequest,
                      ListWorkstationConfigsResponse,
                      WorkstationConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKSTATION_CONFIGS_PAGE_STR_DESC, request, context);
              return ListWorkstationConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          ListUsableWorkstationConfigsPagedResponse>
      LIST_USABLE_WORKSTATION_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUsableWorkstationConfigsRequest,
              ListUsableWorkstationConfigsResponse,
              ListUsableWorkstationConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListUsableWorkstationConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
                    callable,
                ListUsableWorkstationConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListUsableWorkstationConfigsResponse> futureResponse) {
              PageContext<
                      ListUsableWorkstationConfigsRequest,
                      ListUsableWorkstationConfigsResponse,
                      WorkstationConfig>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_USABLE_WORKSTATION_CONFIGS_PAGE_STR_DESC,
                          request,
                          context);
              return ListUsableWorkstationConfigsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>
      LIST_WORKSTATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkstationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkstationsRequest, ListWorkstationsResponse> callable,
                ListWorkstationsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkstationsResponse> futureResponse) {
              PageContext<ListWorkstationsRequest, ListWorkstationsResponse, Workstation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKSTATIONS_PAGE_STR_DESC, request, context);
              return ListWorkstationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUsableWorkstationsRequest,
          ListUsableWorkstationsResponse,
          ListUsableWorkstationsPagedResponse>
      LIST_USABLE_WORKSTATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUsableWorkstationsRequest,
              ListUsableWorkstationsResponse,
              ListUsableWorkstationsPagedResponse>() {
            @Override
            public ApiFuture<ListUsableWorkstationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
                    callable,
                ListUsableWorkstationsRequest request,
                ApiCallContext context,
                ApiFuture<ListUsableWorkstationsResponse> futureResponse) {
              PageContext<
                      ListUsableWorkstationsRequest, ListUsableWorkstationsResponse, Workstation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_USABLE_WORKSTATIONS_PAGE_STR_DESC, request, context);
              return ListUsableWorkstationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getWorkstationCluster. */
  public UnaryCallSettings<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterSettings() {
    return getWorkstationClusterSettings;
  }

  /** Returns the object with the settings used for calls to listWorkstationClusters. */
  public PagedCallSettings<
          ListWorkstationClustersRequest,
          ListWorkstationClustersResponse,
          ListWorkstationClustersPagedResponse>
      listWorkstationClustersSettings() {
    return listWorkstationClustersSettings;
  }

  /** Returns the object with the settings used for calls to createWorkstationCluster. */
  public UnaryCallSettings<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterSettings() {
    return createWorkstationClusterSettings;
  }

  /** Returns the object with the settings used for calls to createWorkstationCluster. */
  public OperationCallSettings<
          CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationSettings() {
    return createWorkstationClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkstationCluster. */
  public UnaryCallSettings<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterSettings() {
    return updateWorkstationClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkstationCluster. */
  public OperationCallSettings<
          UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationSettings() {
    return updateWorkstationClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkstationCluster. */
  public UnaryCallSettings<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterSettings() {
    return deleteWorkstationClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkstationCluster. */
  public OperationCallSettings<
          DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationSettings() {
    return deleteWorkstationClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to getWorkstationConfig. */
  public UnaryCallSettings<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigSettings() {
    return getWorkstationConfigSettings;
  }

  /** Returns the object with the settings used for calls to listWorkstationConfigs. */
  public PagedCallSettings<
          ListWorkstationConfigsRequest,
          ListWorkstationConfigsResponse,
          ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsSettings() {
    return listWorkstationConfigsSettings;
  }

  /** Returns the object with the settings used for calls to listUsableWorkstationConfigs. */
  public PagedCallSettings<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsSettings() {
    return listUsableWorkstationConfigsSettings;
  }

  /** Returns the object with the settings used for calls to createWorkstationConfig. */
  public UnaryCallSettings<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigSettings() {
    return createWorkstationConfigSettings;
  }

  /** Returns the object with the settings used for calls to createWorkstationConfig. */
  public OperationCallSettings<CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationSettings() {
    return createWorkstationConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkstationConfig. */
  public UnaryCallSettings<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigSettings() {
    return updateWorkstationConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkstationConfig. */
  public OperationCallSettings<UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationSettings() {
    return updateWorkstationConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkstationConfig. */
  public UnaryCallSettings<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigSettings() {
    return deleteWorkstationConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkstationConfig. */
  public OperationCallSettings<DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationSettings() {
    return deleteWorkstationConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to getWorkstation. */
  public UnaryCallSettings<GetWorkstationRequest, Workstation> getWorkstationSettings() {
    return getWorkstationSettings;
  }

  /** Returns the object with the settings used for calls to listWorkstations. */
  public PagedCallSettings<
          ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>
      listWorkstationsSettings() {
    return listWorkstationsSettings;
  }

  /** Returns the object with the settings used for calls to listUsableWorkstations. */
  public PagedCallSettings<
          ListUsableWorkstationsRequest,
          ListUsableWorkstationsResponse,
          ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsSettings() {
    return listUsableWorkstationsSettings;
  }

  /** Returns the object with the settings used for calls to createWorkstation. */
  public UnaryCallSettings<CreateWorkstationRequest, Operation> createWorkstationSettings() {
    return createWorkstationSettings;
  }

  /** Returns the object with the settings used for calls to createWorkstation. */
  public OperationCallSettings<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationSettings() {
    return createWorkstationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkstation. */
  public UnaryCallSettings<UpdateWorkstationRequest, Operation> updateWorkstationSettings() {
    return updateWorkstationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkstation. */
  public OperationCallSettings<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationSettings() {
    return updateWorkstationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkstation. */
  public UnaryCallSettings<DeleteWorkstationRequest, Operation> deleteWorkstationSettings() {
    return deleteWorkstationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkstation. */
  public OperationCallSettings<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationSettings() {
    return deleteWorkstationOperationSettings;
  }

  /** Returns the object with the settings used for calls to startWorkstation. */
  public UnaryCallSettings<StartWorkstationRequest, Operation> startWorkstationSettings() {
    return startWorkstationSettings;
  }

  /** Returns the object with the settings used for calls to startWorkstation. */
  public OperationCallSettings<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationSettings() {
    return startWorkstationOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopWorkstation. */
  public UnaryCallSettings<StopWorkstationRequest, Operation> stopWorkstationSettings() {
    return stopWorkstationSettings;
  }

  /** Returns the object with the settings used for calls to stopWorkstation. */
  public OperationCallSettings<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationSettings() {
    return stopWorkstationOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateAccessToken. */
  public UnaryCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenSettings() {
    return generateAccessTokenSettings;
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

  public WorkstationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWorkstationsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonWorkstationsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "workstations";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "workstations.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "workstations.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(WorkstationsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(WorkstationsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkstationsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected WorkstationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getWorkstationClusterSettings = settingsBuilder.getWorkstationClusterSettings().build();
    listWorkstationClustersSettings = settingsBuilder.listWorkstationClustersSettings().build();
    createWorkstationClusterSettings = settingsBuilder.createWorkstationClusterSettings().build();
    createWorkstationClusterOperationSettings =
        settingsBuilder.createWorkstationClusterOperationSettings().build();
    updateWorkstationClusterSettings = settingsBuilder.updateWorkstationClusterSettings().build();
    updateWorkstationClusterOperationSettings =
        settingsBuilder.updateWorkstationClusterOperationSettings().build();
    deleteWorkstationClusterSettings = settingsBuilder.deleteWorkstationClusterSettings().build();
    deleteWorkstationClusterOperationSettings =
        settingsBuilder.deleteWorkstationClusterOperationSettings().build();
    getWorkstationConfigSettings = settingsBuilder.getWorkstationConfigSettings().build();
    listWorkstationConfigsSettings = settingsBuilder.listWorkstationConfigsSettings().build();
    listUsableWorkstationConfigsSettings =
        settingsBuilder.listUsableWorkstationConfigsSettings().build();
    createWorkstationConfigSettings = settingsBuilder.createWorkstationConfigSettings().build();
    createWorkstationConfigOperationSettings =
        settingsBuilder.createWorkstationConfigOperationSettings().build();
    updateWorkstationConfigSettings = settingsBuilder.updateWorkstationConfigSettings().build();
    updateWorkstationConfigOperationSettings =
        settingsBuilder.updateWorkstationConfigOperationSettings().build();
    deleteWorkstationConfigSettings = settingsBuilder.deleteWorkstationConfigSettings().build();
    deleteWorkstationConfigOperationSettings =
        settingsBuilder.deleteWorkstationConfigOperationSettings().build();
    getWorkstationSettings = settingsBuilder.getWorkstationSettings().build();
    listWorkstationsSettings = settingsBuilder.listWorkstationsSettings().build();
    listUsableWorkstationsSettings = settingsBuilder.listUsableWorkstationsSettings().build();
    createWorkstationSettings = settingsBuilder.createWorkstationSettings().build();
    createWorkstationOperationSettings =
        settingsBuilder.createWorkstationOperationSettings().build();
    updateWorkstationSettings = settingsBuilder.updateWorkstationSettings().build();
    updateWorkstationOperationSettings =
        settingsBuilder.updateWorkstationOperationSettings().build();
    deleteWorkstationSettings = settingsBuilder.deleteWorkstationSettings().build();
    deleteWorkstationOperationSettings =
        settingsBuilder.deleteWorkstationOperationSettings().build();
    startWorkstationSettings = settingsBuilder.startWorkstationSettings().build();
    startWorkstationOperationSettings = settingsBuilder.startWorkstationOperationSettings().build();
    stopWorkstationSettings = settingsBuilder.stopWorkstationSettings().build();
    stopWorkstationOperationSettings = settingsBuilder.stopWorkstationOperationSettings().build();
    generateAccessTokenSettings = settingsBuilder.generateAccessTokenSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for WorkstationsStubSettings. */
  public static class Builder extends StubSettings.Builder<WorkstationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetWorkstationClusterRequest, WorkstationCluster>
        getWorkstationClusterSettings;
    private final PagedCallSettings.Builder<
            ListWorkstationClustersRequest,
            ListWorkstationClustersResponse,
            ListWorkstationClustersPagedResponse>
        listWorkstationClustersSettings;
    private final UnaryCallSettings.Builder<CreateWorkstationClusterRequest, Operation>
        createWorkstationClusterSettings;
    private final OperationCallSettings.Builder<
            CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        createWorkstationClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkstationClusterRequest, Operation>
        updateWorkstationClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        updateWorkstationClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkstationClusterRequest, Operation>
        deleteWorkstationClusterSettings;
    private final OperationCallSettings.Builder<
            DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        deleteWorkstationClusterOperationSettings;
    private final UnaryCallSettings.Builder<GetWorkstationConfigRequest, WorkstationConfig>
        getWorkstationConfigSettings;
    private final PagedCallSettings.Builder<
            ListWorkstationConfigsRequest,
            ListWorkstationConfigsResponse,
            ListWorkstationConfigsPagedResponse>
        listWorkstationConfigsSettings;
    private final PagedCallSettings.Builder<
            ListUsableWorkstationConfigsRequest,
            ListUsableWorkstationConfigsResponse,
            ListUsableWorkstationConfigsPagedResponse>
        listUsableWorkstationConfigsSettings;
    private final UnaryCallSettings.Builder<CreateWorkstationConfigRequest, Operation>
        createWorkstationConfigSettings;
    private final OperationCallSettings.Builder<
            CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        createWorkstationConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkstationConfigRequest, Operation>
        updateWorkstationConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        updateWorkstationConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkstationConfigRequest, Operation>
        deleteWorkstationConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        deleteWorkstationConfigOperationSettings;
    private final UnaryCallSettings.Builder<GetWorkstationRequest, Workstation>
        getWorkstationSettings;
    private final PagedCallSettings.Builder<
            ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>
        listWorkstationsSettings;
    private final PagedCallSettings.Builder<
            ListUsableWorkstationsRequest,
            ListUsableWorkstationsResponse,
            ListUsableWorkstationsPagedResponse>
        listUsableWorkstationsSettings;
    private final UnaryCallSettings.Builder<CreateWorkstationRequest, Operation>
        createWorkstationSettings;
    private final OperationCallSettings.Builder<
            CreateWorkstationRequest, Workstation, OperationMetadata>
        createWorkstationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkstationRequest, Operation>
        updateWorkstationSettings;
    private final OperationCallSettings.Builder<
            UpdateWorkstationRequest, Workstation, OperationMetadata>
        updateWorkstationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkstationRequest, Operation>
        deleteWorkstationSettings;
    private final OperationCallSettings.Builder<
            DeleteWorkstationRequest, Workstation, OperationMetadata>
        deleteWorkstationOperationSettings;
    private final UnaryCallSettings.Builder<StartWorkstationRequest, Operation>
        startWorkstationSettings;
    private final OperationCallSettings.Builder<
            StartWorkstationRequest, Workstation, OperationMetadata>
        startWorkstationOperationSettings;
    private final UnaryCallSettings.Builder<StopWorkstationRequest, Operation>
        stopWorkstationSettings;
    private final OperationCallSettings.Builder<
            StopWorkstationRequest, Workstation, OperationMetadata>
        stopWorkstationOperationSettings;
    private final UnaryCallSettings.Builder<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
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

      getWorkstationClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkstationClustersSettings =
          PagedCallSettings.newBuilder(LIST_WORKSTATION_CLUSTERS_PAGE_STR_FACT);
      createWorkstationClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkstationClusterOperationSettings = OperationCallSettings.newBuilder();
      updateWorkstationClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkstationClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkstationClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkstationClusterOperationSettings = OperationCallSettings.newBuilder();
      getWorkstationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkstationConfigsSettings =
          PagedCallSettings.newBuilder(LIST_WORKSTATION_CONFIGS_PAGE_STR_FACT);
      listUsableWorkstationConfigsSettings =
          PagedCallSettings.newBuilder(LIST_USABLE_WORKSTATION_CONFIGS_PAGE_STR_FACT);
      createWorkstationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkstationConfigOperationSettings = OperationCallSettings.newBuilder();
      updateWorkstationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkstationConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkstationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkstationConfigOperationSettings = OperationCallSettings.newBuilder();
      getWorkstationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkstationsSettings = PagedCallSettings.newBuilder(LIST_WORKSTATIONS_PAGE_STR_FACT);
      listUsableWorkstationsSettings =
          PagedCallSettings.newBuilder(LIST_USABLE_WORKSTATIONS_PAGE_STR_FACT);
      createWorkstationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkstationOperationSettings = OperationCallSettings.newBuilder();
      updateWorkstationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkstationOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkstationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkstationOperationSettings = OperationCallSettings.newBuilder();
      startWorkstationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startWorkstationOperationSettings = OperationCallSettings.newBuilder();
      stopWorkstationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopWorkstationOperationSettings = OperationCallSettings.newBuilder();
      generateAccessTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getWorkstationClusterSettings,
              listWorkstationClustersSettings,
              createWorkstationClusterSettings,
              updateWorkstationClusterSettings,
              deleteWorkstationClusterSettings,
              getWorkstationConfigSettings,
              listWorkstationConfigsSettings,
              listUsableWorkstationConfigsSettings,
              createWorkstationConfigSettings,
              updateWorkstationConfigSettings,
              deleteWorkstationConfigSettings,
              getWorkstationSettings,
              listWorkstationsSettings,
              listUsableWorkstationsSettings,
              createWorkstationSettings,
              updateWorkstationSettings,
              deleteWorkstationSettings,
              startWorkstationSettings,
              stopWorkstationSettings,
              generateAccessTokenSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(WorkstationsStubSettings settings) {
      super(settings);

      getWorkstationClusterSettings = settings.getWorkstationClusterSettings.toBuilder();
      listWorkstationClustersSettings = settings.listWorkstationClustersSettings.toBuilder();
      createWorkstationClusterSettings = settings.createWorkstationClusterSettings.toBuilder();
      createWorkstationClusterOperationSettings =
          settings.createWorkstationClusterOperationSettings.toBuilder();
      updateWorkstationClusterSettings = settings.updateWorkstationClusterSettings.toBuilder();
      updateWorkstationClusterOperationSettings =
          settings.updateWorkstationClusterOperationSettings.toBuilder();
      deleteWorkstationClusterSettings = settings.deleteWorkstationClusterSettings.toBuilder();
      deleteWorkstationClusterOperationSettings =
          settings.deleteWorkstationClusterOperationSettings.toBuilder();
      getWorkstationConfigSettings = settings.getWorkstationConfigSettings.toBuilder();
      listWorkstationConfigsSettings = settings.listWorkstationConfigsSettings.toBuilder();
      listUsableWorkstationConfigsSettings =
          settings.listUsableWorkstationConfigsSettings.toBuilder();
      createWorkstationConfigSettings = settings.createWorkstationConfigSettings.toBuilder();
      createWorkstationConfigOperationSettings =
          settings.createWorkstationConfigOperationSettings.toBuilder();
      updateWorkstationConfigSettings = settings.updateWorkstationConfigSettings.toBuilder();
      updateWorkstationConfigOperationSettings =
          settings.updateWorkstationConfigOperationSettings.toBuilder();
      deleteWorkstationConfigSettings = settings.deleteWorkstationConfigSettings.toBuilder();
      deleteWorkstationConfigOperationSettings =
          settings.deleteWorkstationConfigOperationSettings.toBuilder();
      getWorkstationSettings = settings.getWorkstationSettings.toBuilder();
      listWorkstationsSettings = settings.listWorkstationsSettings.toBuilder();
      listUsableWorkstationsSettings = settings.listUsableWorkstationsSettings.toBuilder();
      createWorkstationSettings = settings.createWorkstationSettings.toBuilder();
      createWorkstationOperationSettings = settings.createWorkstationOperationSettings.toBuilder();
      updateWorkstationSettings = settings.updateWorkstationSettings.toBuilder();
      updateWorkstationOperationSettings = settings.updateWorkstationOperationSettings.toBuilder();
      deleteWorkstationSettings = settings.deleteWorkstationSettings.toBuilder();
      deleteWorkstationOperationSettings = settings.deleteWorkstationOperationSettings.toBuilder();
      startWorkstationSettings = settings.startWorkstationSettings.toBuilder();
      startWorkstationOperationSettings = settings.startWorkstationOperationSettings.toBuilder();
      stopWorkstationSettings = settings.stopWorkstationSettings.toBuilder();
      stopWorkstationOperationSettings = settings.stopWorkstationOperationSettings.toBuilder();
      generateAccessTokenSettings = settings.generateAccessTokenSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getWorkstationClusterSettings,
              listWorkstationClustersSettings,
              createWorkstationClusterSettings,
              updateWorkstationClusterSettings,
              deleteWorkstationClusterSettings,
              getWorkstationConfigSettings,
              listWorkstationConfigsSettings,
              listUsableWorkstationConfigsSettings,
              createWorkstationConfigSettings,
              updateWorkstationConfigSettings,
              deleteWorkstationConfigSettings,
              getWorkstationSettings,
              listWorkstationsSettings,
              listUsableWorkstationsSettings,
              createWorkstationSettings,
              updateWorkstationSettings,
              deleteWorkstationSettings,
              startWorkstationSettings,
              stopWorkstationSettings,
              generateAccessTokenSettings,
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
          .getWorkstationClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listWorkstationClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createWorkstationClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateWorkstationClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteWorkstationClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getWorkstationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listWorkstationConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUsableWorkstationConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createWorkstationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateWorkstationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteWorkstationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getWorkstationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listWorkstationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUsableWorkstationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createWorkstationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateWorkstationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteWorkstationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startWorkstationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopWorkstationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateAccessTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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
          .createWorkstationClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkstationClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkstationCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateWorkstationClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkstationClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkstationCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteWorkstationClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkstationClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkstationCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createWorkstationConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkstationConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkstationConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateWorkstationConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkstationConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkstationConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteWorkstationConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkstationConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkstationConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createWorkstationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkstationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workstation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateWorkstationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkstationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workstation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteWorkstationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkstationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workstation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .startWorkstationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartWorkstationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workstation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .stopWorkstationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopWorkstationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workstation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to getWorkstationCluster. */
    public UnaryCallSettings.Builder<GetWorkstationClusterRequest, WorkstationCluster>
        getWorkstationClusterSettings() {
      return getWorkstationClusterSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkstationClusters. */
    public PagedCallSettings.Builder<
            ListWorkstationClustersRequest,
            ListWorkstationClustersResponse,
            ListWorkstationClustersPagedResponse>
        listWorkstationClustersSettings() {
      return listWorkstationClustersSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkstationCluster. */
    public UnaryCallSettings.Builder<CreateWorkstationClusterRequest, Operation>
        createWorkstationClusterSettings() {
      return createWorkstationClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkstationCluster. */
    public OperationCallSettings.Builder<
            CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        createWorkstationClusterOperationSettings() {
      return createWorkstationClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkstationCluster. */
    public UnaryCallSettings.Builder<UpdateWorkstationClusterRequest, Operation>
        updateWorkstationClusterSettings() {
      return updateWorkstationClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkstationCluster. */
    public OperationCallSettings.Builder<
            UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        updateWorkstationClusterOperationSettings() {
      return updateWorkstationClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationCluster. */
    public UnaryCallSettings.Builder<DeleteWorkstationClusterRequest, Operation>
        deleteWorkstationClusterSettings() {
      return deleteWorkstationClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationCluster. */
    public OperationCallSettings.Builder<
            DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        deleteWorkstationClusterOperationSettings() {
      return deleteWorkstationClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkstationConfig. */
    public UnaryCallSettings.Builder<GetWorkstationConfigRequest, WorkstationConfig>
        getWorkstationConfigSettings() {
      return getWorkstationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkstationConfigs. */
    public PagedCallSettings.Builder<
            ListWorkstationConfigsRequest,
            ListWorkstationConfigsResponse,
            ListWorkstationConfigsPagedResponse>
        listWorkstationConfigsSettings() {
      return listWorkstationConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to listUsableWorkstationConfigs. */
    public PagedCallSettings.Builder<
            ListUsableWorkstationConfigsRequest,
            ListUsableWorkstationConfigsResponse,
            ListUsableWorkstationConfigsPagedResponse>
        listUsableWorkstationConfigsSettings() {
      return listUsableWorkstationConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkstationConfig. */
    public UnaryCallSettings.Builder<CreateWorkstationConfigRequest, Operation>
        createWorkstationConfigSettings() {
      return createWorkstationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkstationConfig. */
    public OperationCallSettings.Builder<
            CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        createWorkstationConfigOperationSettings() {
      return createWorkstationConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkstationConfig. */
    public UnaryCallSettings.Builder<UpdateWorkstationConfigRequest, Operation>
        updateWorkstationConfigSettings() {
      return updateWorkstationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkstationConfig. */
    public OperationCallSettings.Builder<
            UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        updateWorkstationConfigOperationSettings() {
      return updateWorkstationConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationConfig. */
    public UnaryCallSettings.Builder<DeleteWorkstationConfigRequest, Operation>
        deleteWorkstationConfigSettings() {
      return deleteWorkstationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationConfig. */
    public OperationCallSettings.Builder<
            DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        deleteWorkstationConfigOperationSettings() {
      return deleteWorkstationConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkstation. */
    public UnaryCallSettings.Builder<GetWorkstationRequest, Workstation> getWorkstationSettings() {
      return getWorkstationSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkstations. */
    public PagedCallSettings.Builder<
            ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>
        listWorkstationsSettings() {
      return listWorkstationsSettings;
    }

    /** Returns the builder for the settings used for calls to listUsableWorkstations. */
    public PagedCallSettings.Builder<
            ListUsableWorkstationsRequest,
            ListUsableWorkstationsResponse,
            ListUsableWorkstationsPagedResponse>
        listUsableWorkstationsSettings() {
      return listUsableWorkstationsSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkstation. */
    public UnaryCallSettings.Builder<CreateWorkstationRequest, Operation>
        createWorkstationSettings() {
      return createWorkstationSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkstation. */
    public OperationCallSettings.Builder<CreateWorkstationRequest, Workstation, OperationMetadata>
        createWorkstationOperationSettings() {
      return createWorkstationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkstation. */
    public UnaryCallSettings.Builder<UpdateWorkstationRequest, Operation>
        updateWorkstationSettings() {
      return updateWorkstationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkstation. */
    public OperationCallSettings.Builder<UpdateWorkstationRequest, Workstation, OperationMetadata>
        updateWorkstationOperationSettings() {
      return updateWorkstationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkstation. */
    public UnaryCallSettings.Builder<DeleteWorkstationRequest, Operation>
        deleteWorkstationSettings() {
      return deleteWorkstationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkstation. */
    public OperationCallSettings.Builder<DeleteWorkstationRequest, Workstation, OperationMetadata>
        deleteWorkstationOperationSettings() {
      return deleteWorkstationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startWorkstation. */
    public UnaryCallSettings.Builder<StartWorkstationRequest, Operation>
        startWorkstationSettings() {
      return startWorkstationSettings;
    }

    /** Returns the builder for the settings used for calls to startWorkstation. */
    public OperationCallSettings.Builder<StartWorkstationRequest, Workstation, OperationMetadata>
        startWorkstationOperationSettings() {
      return startWorkstationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopWorkstation. */
    public UnaryCallSettings.Builder<StopWorkstationRequest, Operation> stopWorkstationSettings() {
      return stopWorkstationSettings;
    }

    /** Returns the builder for the settings used for calls to stopWorkstation. */
    public OperationCallSettings.Builder<StopWorkstationRequest, Workstation, OperationMetadata>
        stopWorkstationOperationSettings() {
      return stopWorkstationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateAccessToken. */
    public UnaryCallSettings.Builder<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenSettings() {
      return generateAccessTokenSettings;
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
    public WorkstationsStubSettings build() throws IOException {
      return new WorkstationsStubSettings(this);
    }
  }
}
