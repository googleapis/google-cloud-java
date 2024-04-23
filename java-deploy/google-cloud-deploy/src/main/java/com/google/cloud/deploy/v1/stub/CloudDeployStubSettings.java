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

package com.google.cloud.deploy.v1.stub;

import static com.google.cloud.deploy.v1.CloudDeployClient.ListAutomationRunsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListAutomationsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListCustomTargetTypesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListDeliveryPipelinesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListJobRunsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListLocationsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListReleasesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListRolloutsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListTargetsPagedResponse;

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
import com.google.cloud.deploy.v1.AbandonReleaseRequest;
import com.google.cloud.deploy.v1.AbandonReleaseResponse;
import com.google.cloud.deploy.v1.AdvanceRolloutRequest;
import com.google.cloud.deploy.v1.AdvanceRolloutResponse;
import com.google.cloud.deploy.v1.ApproveRolloutRequest;
import com.google.cloud.deploy.v1.ApproveRolloutResponse;
import com.google.cloud.deploy.v1.Automation;
import com.google.cloud.deploy.v1.AutomationRun;
import com.google.cloud.deploy.v1.CancelAutomationRunRequest;
import com.google.cloud.deploy.v1.CancelAutomationRunResponse;
import com.google.cloud.deploy.v1.CancelRolloutRequest;
import com.google.cloud.deploy.v1.CancelRolloutResponse;
import com.google.cloud.deploy.v1.Config;
import com.google.cloud.deploy.v1.CreateAutomationRequest;
import com.google.cloud.deploy.v1.CreateCustomTargetTypeRequest;
import com.google.cloud.deploy.v1.CreateDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.CreateReleaseRequest;
import com.google.cloud.deploy.v1.CreateRolloutRequest;
import com.google.cloud.deploy.v1.CreateTargetRequest;
import com.google.cloud.deploy.v1.CustomTargetType;
import com.google.cloud.deploy.v1.DeleteAutomationRequest;
import com.google.cloud.deploy.v1.DeleteCustomTargetTypeRequest;
import com.google.cloud.deploy.v1.DeleteDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.DeleteTargetRequest;
import com.google.cloud.deploy.v1.DeliveryPipeline;
import com.google.cloud.deploy.v1.GetAutomationRequest;
import com.google.cloud.deploy.v1.GetAutomationRunRequest;
import com.google.cloud.deploy.v1.GetConfigRequest;
import com.google.cloud.deploy.v1.GetCustomTargetTypeRequest;
import com.google.cloud.deploy.v1.GetDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.GetJobRunRequest;
import com.google.cloud.deploy.v1.GetReleaseRequest;
import com.google.cloud.deploy.v1.GetRolloutRequest;
import com.google.cloud.deploy.v1.GetTargetRequest;
import com.google.cloud.deploy.v1.IgnoreJobRequest;
import com.google.cloud.deploy.v1.IgnoreJobResponse;
import com.google.cloud.deploy.v1.JobRun;
import com.google.cloud.deploy.v1.ListAutomationRunsRequest;
import com.google.cloud.deploy.v1.ListAutomationRunsResponse;
import com.google.cloud.deploy.v1.ListAutomationsRequest;
import com.google.cloud.deploy.v1.ListAutomationsResponse;
import com.google.cloud.deploy.v1.ListCustomTargetTypesRequest;
import com.google.cloud.deploy.v1.ListCustomTargetTypesResponse;
import com.google.cloud.deploy.v1.ListDeliveryPipelinesRequest;
import com.google.cloud.deploy.v1.ListDeliveryPipelinesResponse;
import com.google.cloud.deploy.v1.ListJobRunsRequest;
import com.google.cloud.deploy.v1.ListJobRunsResponse;
import com.google.cloud.deploy.v1.ListReleasesRequest;
import com.google.cloud.deploy.v1.ListReleasesResponse;
import com.google.cloud.deploy.v1.ListRolloutsRequest;
import com.google.cloud.deploy.v1.ListRolloutsResponse;
import com.google.cloud.deploy.v1.ListTargetsRequest;
import com.google.cloud.deploy.v1.ListTargetsResponse;
import com.google.cloud.deploy.v1.OperationMetadata;
import com.google.cloud.deploy.v1.Release;
import com.google.cloud.deploy.v1.RetryJobRequest;
import com.google.cloud.deploy.v1.RetryJobResponse;
import com.google.cloud.deploy.v1.RollbackTargetRequest;
import com.google.cloud.deploy.v1.RollbackTargetResponse;
import com.google.cloud.deploy.v1.Rollout;
import com.google.cloud.deploy.v1.Target;
import com.google.cloud.deploy.v1.TerminateJobRunRequest;
import com.google.cloud.deploy.v1.TerminateJobRunResponse;
import com.google.cloud.deploy.v1.UpdateAutomationRequest;
import com.google.cloud.deploy.v1.UpdateCustomTargetTypeRequest;
import com.google.cloud.deploy.v1.UpdateDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.UpdateTargetRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudDeployStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (clouddeploy.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDeliveryPipeline to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudDeployStubSettings.Builder cloudDeploySettingsBuilder =
 *     CloudDeployStubSettings.newBuilder();
 * cloudDeploySettingsBuilder
 *     .getDeliveryPipelineSettings()
 *     .setRetrySettings(
 *         cloudDeploySettingsBuilder
 *             .getDeliveryPipelineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudDeployStubSettings cloudDeploySettings = cloudDeploySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudDeployStubSettings extends StubSettings<CloudDeployStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesSettings;
  private final UnaryCallSettings<GetDeliveryPipelineRequest, DeliveryPipeline>
      getDeliveryPipelineSettings;
  private final UnaryCallSettings<CreateDeliveryPipelineRequest, Operation>
      createDeliveryPipelineSettings;
  private final OperationCallSettings<
          CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationSettings;
  private final UnaryCallSettings<UpdateDeliveryPipelineRequest, Operation>
      updateDeliveryPipelineSettings;
  private final OperationCallSettings<
          UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationSettings;
  private final UnaryCallSettings<DeleteDeliveryPipelineRequest, Operation>
      deleteDeliveryPipelineSettings;
  private final OperationCallSettings<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationSettings;
  private final PagedCallSettings<ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>
      listTargetsSettings;
  private final UnaryCallSettings<RollbackTargetRequest, RollbackTargetResponse>
      rollbackTargetSettings;
  private final UnaryCallSettings<GetTargetRequest, Target> getTargetSettings;
  private final UnaryCallSettings<CreateTargetRequest, Operation> createTargetSettings;
  private final OperationCallSettings<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationSettings;
  private final UnaryCallSettings<UpdateTargetRequest, Operation> updateTargetSettings;
  private final OperationCallSettings<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationSettings;
  private final UnaryCallSettings<DeleteTargetRequest, Operation> deleteTargetSettings;
  private final OperationCallSettings<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationSettings;
  private final PagedCallSettings<
          ListCustomTargetTypesRequest,
          ListCustomTargetTypesResponse,
          ListCustomTargetTypesPagedResponse>
      listCustomTargetTypesSettings;
  private final UnaryCallSettings<GetCustomTargetTypeRequest, CustomTargetType>
      getCustomTargetTypeSettings;
  private final UnaryCallSettings<CreateCustomTargetTypeRequest, Operation>
      createCustomTargetTypeSettings;
  private final OperationCallSettings<
          CreateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      createCustomTargetTypeOperationSettings;
  private final UnaryCallSettings<UpdateCustomTargetTypeRequest, Operation>
      updateCustomTargetTypeSettings;
  private final OperationCallSettings<
          UpdateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      updateCustomTargetTypeOperationSettings;
  private final UnaryCallSettings<DeleteCustomTargetTypeRequest, Operation>
      deleteCustomTargetTypeSettings;
  private final OperationCallSettings<DeleteCustomTargetTypeRequest, Empty, OperationMetadata>
      deleteCustomTargetTypeOperationSettings;
  private final PagedCallSettings<
          ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings;
  private final UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings;
  private final UnaryCallSettings<CreateReleaseRequest, Operation> createReleaseSettings;
  private final OperationCallSettings<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationSettings;
  private final UnaryCallSettings<AbandonReleaseRequest, AbandonReleaseResponse>
      abandonReleaseSettings;
  private final UnaryCallSettings<ApproveRolloutRequest, ApproveRolloutResponse>
      approveRolloutSettings;
  private final UnaryCallSettings<AdvanceRolloutRequest, AdvanceRolloutResponse>
      advanceRolloutSettings;
  private final UnaryCallSettings<CancelRolloutRequest, CancelRolloutResponse>
      cancelRolloutSettings;
  private final PagedCallSettings<
          ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings;
  private final UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings;
  private final UnaryCallSettings<CreateRolloutRequest, Operation> createRolloutSettings;
  private final OperationCallSettings<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationSettings;
  private final UnaryCallSettings<IgnoreJobRequest, IgnoreJobResponse> ignoreJobSettings;
  private final UnaryCallSettings<RetryJobRequest, RetryJobResponse> retryJobSettings;
  private final PagedCallSettings<ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>
      listJobRunsSettings;
  private final UnaryCallSettings<GetJobRunRequest, JobRun> getJobRunSettings;
  private final UnaryCallSettings<TerminateJobRunRequest, TerminateJobRunResponse>
      terminateJobRunSettings;
  private final UnaryCallSettings<GetConfigRequest, Config> getConfigSettings;
  private final UnaryCallSettings<CreateAutomationRequest, Operation> createAutomationSettings;
  private final OperationCallSettings<CreateAutomationRequest, Automation, OperationMetadata>
      createAutomationOperationSettings;
  private final UnaryCallSettings<UpdateAutomationRequest, Operation> updateAutomationSettings;
  private final OperationCallSettings<UpdateAutomationRequest, Automation, OperationMetadata>
      updateAutomationOperationSettings;
  private final UnaryCallSettings<DeleteAutomationRequest, Operation> deleteAutomationSettings;
  private final OperationCallSettings<DeleteAutomationRequest, Empty, OperationMetadata>
      deleteAutomationOperationSettings;
  private final UnaryCallSettings<GetAutomationRequest, Automation> getAutomationSettings;
  private final PagedCallSettings<
          ListAutomationsRequest, ListAutomationsResponse, ListAutomationsPagedResponse>
      listAutomationsSettings;
  private final UnaryCallSettings<GetAutomationRunRequest, AutomationRun> getAutomationRunSettings;
  private final PagedCallSettings<
          ListAutomationRunsRequest, ListAutomationRunsResponse, ListAutomationRunsPagedResponse>
      listAutomationRunsSettings;
  private final UnaryCallSettings<CancelAutomationRunRequest, CancelAutomationRunResponse>
      cancelAutomationRunSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
      LIST_DELIVERY_PIPELINES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeliveryPipelinesRequest injectToken(
                ListDeliveryPipelinesRequest payload, String token) {
              return ListDeliveryPipelinesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeliveryPipelinesRequest injectPageSize(
                ListDeliveryPipelinesRequest payload, int pageSize) {
              return ListDeliveryPipelinesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeliveryPipelinesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeliveryPipelinesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DeliveryPipeline> extractResources(
                ListDeliveryPipelinesResponse payload) {
              return payload.getDeliveryPipelinesList() == null
                  ? ImmutableList.<DeliveryPipeline>of()
                  : payload.getDeliveryPipelinesList();
            }
          };

  private static final PagedListDescriptor<ListTargetsRequest, ListTargetsResponse, Target>
      LIST_TARGETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTargetsRequest, ListTargetsResponse, Target>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetsRequest injectToken(ListTargetsRequest payload, String token) {
              return ListTargetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTargetsRequest injectPageSize(ListTargetsRequest payload, int pageSize) {
              return ListTargetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTargetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTargetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Target> extractResources(ListTargetsResponse payload) {
              return payload.getTargetsList() == null
                  ? ImmutableList.<Target>of()
                  : payload.getTargetsList();
            }
          };

  private static final PagedListDescriptor<
          ListCustomTargetTypesRequest, ListCustomTargetTypesResponse, CustomTargetType>
      LIST_CUSTOM_TARGET_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCustomTargetTypesRequest, ListCustomTargetTypesResponse, CustomTargetType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomTargetTypesRequest injectToken(
                ListCustomTargetTypesRequest payload, String token) {
              return ListCustomTargetTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomTargetTypesRequest injectPageSize(
                ListCustomTargetTypesRequest payload, int pageSize) {
              return ListCustomTargetTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomTargetTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomTargetTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomTargetType> extractResources(
                ListCustomTargetTypesResponse payload) {
              return payload.getCustomTargetTypesList() == null
                  ? ImmutableList.<CustomTargetType>of()
                  : payload.getCustomTargetTypesList();
            }
          };

  private static final PagedListDescriptor<ListReleasesRequest, ListReleasesResponse, Release>
      LIST_RELEASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListReleasesRequest, ListReleasesResponse, Release>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReleasesRequest injectToken(ListReleasesRequest payload, String token) {
              return ListReleasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReleasesRequest injectPageSize(ListReleasesRequest payload, int pageSize) {
              return ListReleasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReleasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReleasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Release> extractResources(ListReleasesResponse payload) {
              return payload.getReleasesList() == null
                  ? ImmutableList.<Release>of()
                  : payload.getReleasesList();
            }
          };

  private static final PagedListDescriptor<ListRolloutsRequest, ListRolloutsResponse, Rollout>
      LIST_ROLLOUTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRolloutsRequest, ListRolloutsResponse, Rollout>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRolloutsRequest injectToken(ListRolloutsRequest payload, String token) {
              return ListRolloutsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRolloutsRequest injectPageSize(ListRolloutsRequest payload, int pageSize) {
              return ListRolloutsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRolloutsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRolloutsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Rollout> extractResources(ListRolloutsResponse payload) {
              return payload.getRolloutsList() == null
                  ? ImmutableList.<Rollout>of()
                  : payload.getRolloutsList();
            }
          };

  private static final PagedListDescriptor<ListJobRunsRequest, ListJobRunsResponse, JobRun>
      LIST_JOB_RUNS_PAGE_STR_DESC =
          new PagedListDescriptor<ListJobRunsRequest, ListJobRunsResponse, JobRun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListJobRunsRequest injectToken(ListJobRunsRequest payload, String token) {
              return ListJobRunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListJobRunsRequest injectPageSize(ListJobRunsRequest payload, int pageSize) {
              return ListJobRunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListJobRunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListJobRunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<JobRun> extractResources(ListJobRunsResponse payload) {
              return payload.getJobRunsList() == null
                  ? ImmutableList.<JobRun>of()
                  : payload.getJobRunsList();
            }
          };

  private static final PagedListDescriptor<
          ListAutomationsRequest, ListAutomationsResponse, Automation>
      LIST_AUTOMATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAutomationsRequest, ListAutomationsResponse, Automation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAutomationsRequest injectToken(
                ListAutomationsRequest payload, String token) {
              return ListAutomationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAutomationsRequest injectPageSize(
                ListAutomationsRequest payload, int pageSize) {
              return ListAutomationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAutomationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAutomationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Automation> extractResources(ListAutomationsResponse payload) {
              return payload.getAutomationsList() == null
                  ? ImmutableList.<Automation>of()
                  : payload.getAutomationsList();
            }
          };

  private static final PagedListDescriptor<
          ListAutomationRunsRequest, ListAutomationRunsResponse, AutomationRun>
      LIST_AUTOMATION_RUNS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAutomationRunsRequest, ListAutomationRunsResponse, AutomationRun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAutomationRunsRequest injectToken(
                ListAutomationRunsRequest payload, String token) {
              return ListAutomationRunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAutomationRunsRequest injectPageSize(
                ListAutomationRunsRequest payload, int pageSize) {
              return ListAutomationRunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAutomationRunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAutomationRunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AutomationRun> extractResources(ListAutomationRunsResponse payload) {
              return payload.getAutomationRunsList() == null
                  ? ImmutableList.<AutomationRun>of()
                  : payload.getAutomationRunsList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          ListDeliveryPipelinesPagedResponse>
      LIST_DELIVERY_PIPELINES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeliveryPipelinesRequest,
              ListDeliveryPipelinesResponse,
              ListDeliveryPipelinesPagedResponse>() {
            @Override
            public ApiFuture<ListDeliveryPipelinesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse> callable,
                ListDeliveryPipelinesRequest request,
                ApiCallContext context,
                ApiFuture<ListDeliveryPipelinesResponse> futureResponse) {
              PageContext<
                      ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DELIVERY_PIPELINES_PAGE_STR_DESC, request, context);
              return ListDeliveryPipelinesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>
      LIST_TARGETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>() {
            @Override
            public ApiFuture<ListTargetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetsRequest, ListTargetsResponse> callable,
                ListTargetsRequest request,
                ApiCallContext context,
                ApiFuture<ListTargetsResponse> futureResponse) {
              PageContext<ListTargetsRequest, ListTargetsResponse, Target> pageContext =
                  PageContext.create(callable, LIST_TARGETS_PAGE_STR_DESC, request, context);
              return ListTargetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCustomTargetTypesRequest,
          ListCustomTargetTypesResponse,
          ListCustomTargetTypesPagedResponse>
      LIST_CUSTOM_TARGET_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomTargetTypesRequest,
              ListCustomTargetTypesResponse,
              ListCustomTargetTypesPagedResponse>() {
            @Override
            public ApiFuture<ListCustomTargetTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse> callable,
                ListCustomTargetTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomTargetTypesResponse> futureResponse) {
              PageContext<
                      ListCustomTargetTypesRequest, ListCustomTargetTypesResponse, CustomTargetType>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CUSTOM_TARGET_TYPES_PAGE_STR_DESC, request, context);
              return ListCustomTargetTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      LIST_RELEASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>() {
            @Override
            public ApiFuture<ListReleasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReleasesRequest, ListReleasesResponse> callable,
                ListReleasesRequest request,
                ApiCallContext context,
                ApiFuture<ListReleasesResponse> futureResponse) {
              PageContext<ListReleasesRequest, ListReleasesResponse, Release> pageContext =
                  PageContext.create(callable, LIST_RELEASES_PAGE_STR_DESC, request, context);
              return ListReleasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      LIST_ROLLOUTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>() {
            @Override
            public ApiFuture<ListRolloutsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> callable,
                ListRolloutsRequest request,
                ApiCallContext context,
                ApiFuture<ListRolloutsResponse> futureResponse) {
              PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> pageContext =
                  PageContext.create(callable, LIST_ROLLOUTS_PAGE_STR_DESC, request, context);
              return ListRolloutsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>
      LIST_JOB_RUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>() {
            @Override
            public ApiFuture<ListJobRunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListJobRunsRequest, ListJobRunsResponse> callable,
                ListJobRunsRequest request,
                ApiCallContext context,
                ApiFuture<ListJobRunsResponse> futureResponse) {
              PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> pageContext =
                  PageContext.create(callable, LIST_JOB_RUNS_PAGE_STR_DESC, request, context);
              return ListJobRunsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAutomationsRequest, ListAutomationsResponse, ListAutomationsPagedResponse>
      LIST_AUTOMATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAutomationsRequest, ListAutomationsResponse, ListAutomationsPagedResponse>() {
            @Override
            public ApiFuture<ListAutomationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAutomationsRequest, ListAutomationsResponse> callable,
                ListAutomationsRequest request,
                ApiCallContext context,
                ApiFuture<ListAutomationsResponse> futureResponse) {
              PageContext<ListAutomationsRequest, ListAutomationsResponse, Automation> pageContext =
                  PageContext.create(callable, LIST_AUTOMATIONS_PAGE_STR_DESC, request, context);
              return ListAutomationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAutomationRunsRequest, ListAutomationRunsResponse, ListAutomationRunsPagedResponse>
      LIST_AUTOMATION_RUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAutomationRunsRequest,
              ListAutomationRunsResponse,
              ListAutomationRunsPagedResponse>() {
            @Override
            public ApiFuture<ListAutomationRunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAutomationRunsRequest, ListAutomationRunsResponse> callable,
                ListAutomationRunsRequest request,
                ApiCallContext context,
                ApiFuture<ListAutomationRunsResponse> futureResponse) {
              PageContext<ListAutomationRunsRequest, ListAutomationRunsResponse, AutomationRun>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTOMATION_RUNS_PAGE_STR_DESC, request, context);
              return ListAutomationRunsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listDeliveryPipelines. */
  public PagedCallSettings<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesSettings() {
    return listDeliveryPipelinesSettings;
  }

  /** Returns the object with the settings used for calls to getDeliveryPipeline. */
  public UnaryCallSettings<GetDeliveryPipelineRequest, DeliveryPipeline>
      getDeliveryPipelineSettings() {
    return getDeliveryPipelineSettings;
  }

  /** Returns the object with the settings used for calls to createDeliveryPipeline. */
  public UnaryCallSettings<CreateDeliveryPipelineRequest, Operation>
      createDeliveryPipelineSettings() {
    return createDeliveryPipelineSettings;
  }

  /** Returns the object with the settings used for calls to createDeliveryPipeline. */
  public OperationCallSettings<CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationSettings() {
    return createDeliveryPipelineOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDeliveryPipeline. */
  public UnaryCallSettings<UpdateDeliveryPipelineRequest, Operation>
      updateDeliveryPipelineSettings() {
    return updateDeliveryPipelineSettings;
  }

  /** Returns the object with the settings used for calls to updateDeliveryPipeline. */
  public OperationCallSettings<UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationSettings() {
    return updateDeliveryPipelineOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeliveryPipeline. */
  public UnaryCallSettings<DeleteDeliveryPipelineRequest, Operation>
      deleteDeliveryPipelineSettings() {
    return deleteDeliveryPipelineSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeliveryPipeline. */
  public OperationCallSettings<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationSettings() {
    return deleteDeliveryPipelineOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTargets. */
  public PagedCallSettings<ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>
      listTargetsSettings() {
    return listTargetsSettings;
  }

  /** Returns the object with the settings used for calls to rollbackTarget. */
  public UnaryCallSettings<RollbackTargetRequest, RollbackTargetResponse> rollbackTargetSettings() {
    return rollbackTargetSettings;
  }

  /** Returns the object with the settings used for calls to getTarget. */
  public UnaryCallSettings<GetTargetRequest, Target> getTargetSettings() {
    return getTargetSettings;
  }

  /** Returns the object with the settings used for calls to createTarget. */
  public UnaryCallSettings<CreateTargetRequest, Operation> createTargetSettings() {
    return createTargetSettings;
  }

  /** Returns the object with the settings used for calls to createTarget. */
  public OperationCallSettings<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationSettings() {
    return createTargetOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTarget. */
  public UnaryCallSettings<UpdateTargetRequest, Operation> updateTargetSettings() {
    return updateTargetSettings;
  }

  /** Returns the object with the settings used for calls to updateTarget. */
  public OperationCallSettings<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationSettings() {
    return updateTargetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTarget. */
  public UnaryCallSettings<DeleteTargetRequest, Operation> deleteTargetSettings() {
    return deleteTargetSettings;
  }

  /** Returns the object with the settings used for calls to deleteTarget. */
  public OperationCallSettings<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationSettings() {
    return deleteTargetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCustomTargetTypes. */
  public PagedCallSettings<
          ListCustomTargetTypesRequest,
          ListCustomTargetTypesResponse,
          ListCustomTargetTypesPagedResponse>
      listCustomTargetTypesSettings() {
    return listCustomTargetTypesSettings;
  }

  /** Returns the object with the settings used for calls to getCustomTargetType. */
  public UnaryCallSettings<GetCustomTargetTypeRequest, CustomTargetType>
      getCustomTargetTypeSettings() {
    return getCustomTargetTypeSettings;
  }

  /** Returns the object with the settings used for calls to createCustomTargetType. */
  public UnaryCallSettings<CreateCustomTargetTypeRequest, Operation>
      createCustomTargetTypeSettings() {
    return createCustomTargetTypeSettings;
  }

  /** Returns the object with the settings used for calls to createCustomTargetType. */
  public OperationCallSettings<CreateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      createCustomTargetTypeOperationSettings() {
    return createCustomTargetTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomTargetType. */
  public UnaryCallSettings<UpdateCustomTargetTypeRequest, Operation>
      updateCustomTargetTypeSettings() {
    return updateCustomTargetTypeSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomTargetType. */
  public OperationCallSettings<UpdateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      updateCustomTargetTypeOperationSettings() {
    return updateCustomTargetTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomTargetType. */
  public UnaryCallSettings<DeleteCustomTargetTypeRequest, Operation>
      deleteCustomTargetTypeSettings() {
    return deleteCustomTargetTypeSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomTargetType. */
  public OperationCallSettings<DeleteCustomTargetTypeRequest, Empty, OperationMetadata>
      deleteCustomTargetTypeOperationSettings() {
    return deleteCustomTargetTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listReleases. */
  public PagedCallSettings<ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings() {
    return listReleasesSettings;
  }

  /** Returns the object with the settings used for calls to getRelease. */
  public UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings() {
    return getReleaseSettings;
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public UnaryCallSettings<CreateReleaseRequest, Operation> createReleaseSettings() {
    return createReleaseSettings;
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public OperationCallSettings<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationSettings() {
    return createReleaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to abandonRelease. */
  public UnaryCallSettings<AbandonReleaseRequest, AbandonReleaseResponse> abandonReleaseSettings() {
    return abandonReleaseSettings;
  }

  /** Returns the object with the settings used for calls to approveRollout. */
  public UnaryCallSettings<ApproveRolloutRequest, ApproveRolloutResponse> approveRolloutSettings() {
    return approveRolloutSettings;
  }

  /** Returns the object with the settings used for calls to advanceRollout. */
  public UnaryCallSettings<AdvanceRolloutRequest, AdvanceRolloutResponse> advanceRolloutSettings() {
    return advanceRolloutSettings;
  }

  /** Returns the object with the settings used for calls to cancelRollout. */
  public UnaryCallSettings<CancelRolloutRequest, CancelRolloutResponse> cancelRolloutSettings() {
    return cancelRolloutSettings;
  }

  /** Returns the object with the settings used for calls to listRollouts. */
  public PagedCallSettings<ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings() {
    return listRolloutsSettings;
  }

  /** Returns the object with the settings used for calls to getRollout. */
  public UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings() {
    return getRolloutSettings;
  }

  /** Returns the object with the settings used for calls to createRollout. */
  public UnaryCallSettings<CreateRolloutRequest, Operation> createRolloutSettings() {
    return createRolloutSettings;
  }

  /** Returns the object with the settings used for calls to createRollout. */
  public OperationCallSettings<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationSettings() {
    return createRolloutOperationSettings;
  }

  /** Returns the object with the settings used for calls to ignoreJob. */
  public UnaryCallSettings<IgnoreJobRequest, IgnoreJobResponse> ignoreJobSettings() {
    return ignoreJobSettings;
  }

  /** Returns the object with the settings used for calls to retryJob. */
  public UnaryCallSettings<RetryJobRequest, RetryJobResponse> retryJobSettings() {
    return retryJobSettings;
  }

  /** Returns the object with the settings used for calls to listJobRuns. */
  public PagedCallSettings<ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>
      listJobRunsSettings() {
    return listJobRunsSettings;
  }

  /** Returns the object with the settings used for calls to getJobRun. */
  public UnaryCallSettings<GetJobRunRequest, JobRun> getJobRunSettings() {
    return getJobRunSettings;
  }

  /** Returns the object with the settings used for calls to terminateJobRun. */
  public UnaryCallSettings<TerminateJobRunRequest, TerminateJobRunResponse>
      terminateJobRunSettings() {
    return terminateJobRunSettings;
  }

  /** Returns the object with the settings used for calls to getConfig. */
  public UnaryCallSettings<GetConfigRequest, Config> getConfigSettings() {
    return getConfigSettings;
  }

  /** Returns the object with the settings used for calls to createAutomation. */
  public UnaryCallSettings<CreateAutomationRequest, Operation> createAutomationSettings() {
    return createAutomationSettings;
  }

  /** Returns the object with the settings used for calls to createAutomation. */
  public OperationCallSettings<CreateAutomationRequest, Automation, OperationMetadata>
      createAutomationOperationSettings() {
    return createAutomationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAutomation. */
  public UnaryCallSettings<UpdateAutomationRequest, Operation> updateAutomationSettings() {
    return updateAutomationSettings;
  }

  /** Returns the object with the settings used for calls to updateAutomation. */
  public OperationCallSettings<UpdateAutomationRequest, Automation, OperationMetadata>
      updateAutomationOperationSettings() {
    return updateAutomationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAutomation. */
  public UnaryCallSettings<DeleteAutomationRequest, Operation> deleteAutomationSettings() {
    return deleteAutomationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAutomation. */
  public OperationCallSettings<DeleteAutomationRequest, Empty, OperationMetadata>
      deleteAutomationOperationSettings() {
    return deleteAutomationOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAutomation. */
  public UnaryCallSettings<GetAutomationRequest, Automation> getAutomationSettings() {
    return getAutomationSettings;
  }

  /** Returns the object with the settings used for calls to listAutomations. */
  public PagedCallSettings<
          ListAutomationsRequest, ListAutomationsResponse, ListAutomationsPagedResponse>
      listAutomationsSettings() {
    return listAutomationsSettings;
  }

  /** Returns the object with the settings used for calls to getAutomationRun. */
  public UnaryCallSettings<GetAutomationRunRequest, AutomationRun> getAutomationRunSettings() {
    return getAutomationRunSettings;
  }

  /** Returns the object with the settings used for calls to listAutomationRuns. */
  public PagedCallSettings<
          ListAutomationRunsRequest, ListAutomationRunsResponse, ListAutomationRunsPagedResponse>
      listAutomationRunsSettings() {
    return listAutomationRunsSettings;
  }

  /** Returns the object with the settings used for calls to cancelAutomationRun. */
  public UnaryCallSettings<CancelAutomationRunRequest, CancelAutomationRunResponse>
      cancelAutomationRunSettings() {
    return cancelAutomationRunSettings;
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

  public CloudDeployStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudDeployStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudDeployStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "clouddeploy";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "clouddeploy.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "clouddeploy.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CloudDeployStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudDeployStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudDeployStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CloudDeployStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDeliveryPipelinesSettings = settingsBuilder.listDeliveryPipelinesSettings().build();
    getDeliveryPipelineSettings = settingsBuilder.getDeliveryPipelineSettings().build();
    createDeliveryPipelineSettings = settingsBuilder.createDeliveryPipelineSettings().build();
    createDeliveryPipelineOperationSettings =
        settingsBuilder.createDeliveryPipelineOperationSettings().build();
    updateDeliveryPipelineSettings = settingsBuilder.updateDeliveryPipelineSettings().build();
    updateDeliveryPipelineOperationSettings =
        settingsBuilder.updateDeliveryPipelineOperationSettings().build();
    deleteDeliveryPipelineSettings = settingsBuilder.deleteDeliveryPipelineSettings().build();
    deleteDeliveryPipelineOperationSettings =
        settingsBuilder.deleteDeliveryPipelineOperationSettings().build();
    listTargetsSettings = settingsBuilder.listTargetsSettings().build();
    rollbackTargetSettings = settingsBuilder.rollbackTargetSettings().build();
    getTargetSettings = settingsBuilder.getTargetSettings().build();
    createTargetSettings = settingsBuilder.createTargetSettings().build();
    createTargetOperationSettings = settingsBuilder.createTargetOperationSettings().build();
    updateTargetSettings = settingsBuilder.updateTargetSettings().build();
    updateTargetOperationSettings = settingsBuilder.updateTargetOperationSettings().build();
    deleteTargetSettings = settingsBuilder.deleteTargetSettings().build();
    deleteTargetOperationSettings = settingsBuilder.deleteTargetOperationSettings().build();
    listCustomTargetTypesSettings = settingsBuilder.listCustomTargetTypesSettings().build();
    getCustomTargetTypeSettings = settingsBuilder.getCustomTargetTypeSettings().build();
    createCustomTargetTypeSettings = settingsBuilder.createCustomTargetTypeSettings().build();
    createCustomTargetTypeOperationSettings =
        settingsBuilder.createCustomTargetTypeOperationSettings().build();
    updateCustomTargetTypeSettings = settingsBuilder.updateCustomTargetTypeSettings().build();
    updateCustomTargetTypeOperationSettings =
        settingsBuilder.updateCustomTargetTypeOperationSettings().build();
    deleteCustomTargetTypeSettings = settingsBuilder.deleteCustomTargetTypeSettings().build();
    deleteCustomTargetTypeOperationSettings =
        settingsBuilder.deleteCustomTargetTypeOperationSettings().build();
    listReleasesSettings = settingsBuilder.listReleasesSettings().build();
    getReleaseSettings = settingsBuilder.getReleaseSettings().build();
    createReleaseSettings = settingsBuilder.createReleaseSettings().build();
    createReleaseOperationSettings = settingsBuilder.createReleaseOperationSettings().build();
    abandonReleaseSettings = settingsBuilder.abandonReleaseSettings().build();
    approveRolloutSettings = settingsBuilder.approveRolloutSettings().build();
    advanceRolloutSettings = settingsBuilder.advanceRolloutSettings().build();
    cancelRolloutSettings = settingsBuilder.cancelRolloutSettings().build();
    listRolloutsSettings = settingsBuilder.listRolloutsSettings().build();
    getRolloutSettings = settingsBuilder.getRolloutSettings().build();
    createRolloutSettings = settingsBuilder.createRolloutSettings().build();
    createRolloutOperationSettings = settingsBuilder.createRolloutOperationSettings().build();
    ignoreJobSettings = settingsBuilder.ignoreJobSettings().build();
    retryJobSettings = settingsBuilder.retryJobSettings().build();
    listJobRunsSettings = settingsBuilder.listJobRunsSettings().build();
    getJobRunSettings = settingsBuilder.getJobRunSettings().build();
    terminateJobRunSettings = settingsBuilder.terminateJobRunSettings().build();
    getConfigSettings = settingsBuilder.getConfigSettings().build();
    createAutomationSettings = settingsBuilder.createAutomationSettings().build();
    createAutomationOperationSettings = settingsBuilder.createAutomationOperationSettings().build();
    updateAutomationSettings = settingsBuilder.updateAutomationSettings().build();
    updateAutomationOperationSettings = settingsBuilder.updateAutomationOperationSettings().build();
    deleteAutomationSettings = settingsBuilder.deleteAutomationSettings().build();
    deleteAutomationOperationSettings = settingsBuilder.deleteAutomationOperationSettings().build();
    getAutomationSettings = settingsBuilder.getAutomationSettings().build();
    listAutomationsSettings = settingsBuilder.listAutomationsSettings().build();
    getAutomationRunSettings = settingsBuilder.getAutomationRunSettings().build();
    listAutomationRunsSettings = settingsBuilder.listAutomationRunsSettings().build();
    cancelAutomationRunSettings = settingsBuilder.cancelAutomationRunSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for CloudDeployStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudDeployStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDeliveryPipelinesRequest,
            ListDeliveryPipelinesResponse,
            ListDeliveryPipelinesPagedResponse>
        listDeliveryPipelinesSettings;
    private final UnaryCallSettings.Builder<GetDeliveryPipelineRequest, DeliveryPipeline>
        getDeliveryPipelineSettings;
    private final UnaryCallSettings.Builder<CreateDeliveryPipelineRequest, Operation>
        createDeliveryPipelineSettings;
    private final OperationCallSettings.Builder<
            CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
        createDeliveryPipelineOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDeliveryPipelineRequest, Operation>
        updateDeliveryPipelineSettings;
    private final OperationCallSettings.Builder<
            UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
        updateDeliveryPipelineOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDeliveryPipelineRequest, Operation>
        deleteDeliveryPipelineSettings;
    private final OperationCallSettings.Builder<
            DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
        deleteDeliveryPipelineOperationSettings;
    private final PagedCallSettings.Builder<
            ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>
        listTargetsSettings;
    private final UnaryCallSettings.Builder<RollbackTargetRequest, RollbackTargetResponse>
        rollbackTargetSettings;
    private final UnaryCallSettings.Builder<GetTargetRequest, Target> getTargetSettings;
    private final UnaryCallSettings.Builder<CreateTargetRequest, Operation> createTargetSettings;
    private final OperationCallSettings.Builder<CreateTargetRequest, Target, OperationMetadata>
        createTargetOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTargetRequest, Operation> updateTargetSettings;
    private final OperationCallSettings.Builder<UpdateTargetRequest, Target, OperationMetadata>
        updateTargetOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTargetRequest, Operation> deleteTargetSettings;
    private final OperationCallSettings.Builder<DeleteTargetRequest, Empty, OperationMetadata>
        deleteTargetOperationSettings;
    private final PagedCallSettings.Builder<
            ListCustomTargetTypesRequest,
            ListCustomTargetTypesResponse,
            ListCustomTargetTypesPagedResponse>
        listCustomTargetTypesSettings;
    private final UnaryCallSettings.Builder<GetCustomTargetTypeRequest, CustomTargetType>
        getCustomTargetTypeSettings;
    private final UnaryCallSettings.Builder<CreateCustomTargetTypeRequest, Operation>
        createCustomTargetTypeSettings;
    private final OperationCallSettings.Builder<
            CreateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
        createCustomTargetTypeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCustomTargetTypeRequest, Operation>
        updateCustomTargetTypeSettings;
    private final OperationCallSettings.Builder<
            UpdateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
        updateCustomTargetTypeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCustomTargetTypeRequest, Operation>
        deleteCustomTargetTypeSettings;
    private final OperationCallSettings.Builder<
            DeleteCustomTargetTypeRequest, Empty, OperationMetadata>
        deleteCustomTargetTypeOperationSettings;
    private final PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings;
    private final UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings;
    private final UnaryCallSettings.Builder<CreateReleaseRequest, Operation> createReleaseSettings;
    private final OperationCallSettings.Builder<CreateReleaseRequest, Release, OperationMetadata>
        createReleaseOperationSettings;
    private final UnaryCallSettings.Builder<AbandonReleaseRequest, AbandonReleaseResponse>
        abandonReleaseSettings;
    private final UnaryCallSettings.Builder<ApproveRolloutRequest, ApproveRolloutResponse>
        approveRolloutSettings;
    private final UnaryCallSettings.Builder<AdvanceRolloutRequest, AdvanceRolloutResponse>
        advanceRolloutSettings;
    private final UnaryCallSettings.Builder<CancelRolloutRequest, CancelRolloutResponse>
        cancelRolloutSettings;
    private final PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings;
    private final UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings;
    private final UnaryCallSettings.Builder<CreateRolloutRequest, Operation> createRolloutSettings;
    private final OperationCallSettings.Builder<CreateRolloutRequest, Rollout, OperationMetadata>
        createRolloutOperationSettings;
    private final UnaryCallSettings.Builder<IgnoreJobRequest, IgnoreJobResponse> ignoreJobSettings;
    private final UnaryCallSettings.Builder<RetryJobRequest, RetryJobResponse> retryJobSettings;
    private final PagedCallSettings.Builder<
            ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>
        listJobRunsSettings;
    private final UnaryCallSettings.Builder<GetJobRunRequest, JobRun> getJobRunSettings;
    private final UnaryCallSettings.Builder<TerminateJobRunRequest, TerminateJobRunResponse>
        terminateJobRunSettings;
    private final UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings;
    private final UnaryCallSettings.Builder<CreateAutomationRequest, Operation>
        createAutomationSettings;
    private final OperationCallSettings.Builder<
            CreateAutomationRequest, Automation, OperationMetadata>
        createAutomationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAutomationRequest, Operation>
        updateAutomationSettings;
    private final OperationCallSettings.Builder<
            UpdateAutomationRequest, Automation, OperationMetadata>
        updateAutomationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAutomationRequest, Operation>
        deleteAutomationSettings;
    private final OperationCallSettings.Builder<DeleteAutomationRequest, Empty, OperationMetadata>
        deleteAutomationOperationSettings;
    private final UnaryCallSettings.Builder<GetAutomationRequest, Automation> getAutomationSettings;
    private final PagedCallSettings.Builder<
            ListAutomationsRequest, ListAutomationsResponse, ListAutomationsPagedResponse>
        listAutomationsSettings;
    private final UnaryCallSettings.Builder<GetAutomationRunRequest, AutomationRun>
        getAutomationRunSettings;
    private final PagedCallSettings.Builder<
            ListAutomationRunsRequest, ListAutomationRunsResponse, ListAutomationRunsPagedResponse>
        listAutomationRunsSettings;
    private final UnaryCallSettings.Builder<CancelAutomationRunRequest, CancelAutomationRunResponse>
        cancelAutomationRunSettings;
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
              .setMaxRetryDelay(Duration.ofMillis(60000L))
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

      listDeliveryPipelinesSettings =
          PagedCallSettings.newBuilder(LIST_DELIVERY_PIPELINES_PAGE_STR_FACT);
      getDeliveryPipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeliveryPipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeliveryPipelineOperationSettings = OperationCallSettings.newBuilder();
      updateDeliveryPipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeliveryPipelineOperationSettings = OperationCallSettings.newBuilder();
      deleteDeliveryPipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDeliveryPipelineOperationSettings = OperationCallSettings.newBuilder();
      listTargetsSettings = PagedCallSettings.newBuilder(LIST_TARGETS_PAGE_STR_FACT);
      rollbackTargetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTargetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTargetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTargetOperationSettings = OperationCallSettings.newBuilder();
      updateTargetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTargetOperationSettings = OperationCallSettings.newBuilder();
      deleteTargetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTargetOperationSettings = OperationCallSettings.newBuilder();
      listCustomTargetTypesSettings =
          PagedCallSettings.newBuilder(LIST_CUSTOM_TARGET_TYPES_PAGE_STR_FACT);
      getCustomTargetTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomTargetTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomTargetTypeOperationSettings = OperationCallSettings.newBuilder();
      updateCustomTargetTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCustomTargetTypeOperationSettings = OperationCallSettings.newBuilder();
      deleteCustomTargetTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCustomTargetTypeOperationSettings = OperationCallSettings.newBuilder();
      listReleasesSettings = PagedCallSettings.newBuilder(LIST_RELEASES_PAGE_STR_FACT);
      getReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReleaseOperationSettings = OperationCallSettings.newBuilder();
      abandonReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      approveRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      advanceRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRolloutsSettings = PagedCallSettings.newBuilder(LIST_ROLLOUTS_PAGE_STR_FACT);
      getRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRolloutOperationSettings = OperationCallSettings.newBuilder();
      ignoreJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retryJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listJobRunsSettings = PagedCallSettings.newBuilder(LIST_JOB_RUNS_PAGE_STR_FACT);
      getJobRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      terminateJobRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAutomationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAutomationOperationSettings = OperationCallSettings.newBuilder();
      updateAutomationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAutomationOperationSettings = OperationCallSettings.newBuilder();
      deleteAutomationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAutomationOperationSettings = OperationCallSettings.newBuilder();
      getAutomationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAutomationsSettings = PagedCallSettings.newBuilder(LIST_AUTOMATIONS_PAGE_STR_FACT);
      getAutomationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAutomationRunsSettings = PagedCallSettings.newBuilder(LIST_AUTOMATION_RUNS_PAGE_STR_FACT);
      cancelAutomationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDeliveryPipelinesSettings,
              getDeliveryPipelineSettings,
              createDeliveryPipelineSettings,
              updateDeliveryPipelineSettings,
              deleteDeliveryPipelineSettings,
              listTargetsSettings,
              rollbackTargetSettings,
              getTargetSettings,
              createTargetSettings,
              updateTargetSettings,
              deleteTargetSettings,
              listCustomTargetTypesSettings,
              getCustomTargetTypeSettings,
              createCustomTargetTypeSettings,
              updateCustomTargetTypeSettings,
              deleteCustomTargetTypeSettings,
              listReleasesSettings,
              getReleaseSettings,
              createReleaseSettings,
              abandonReleaseSettings,
              approveRolloutSettings,
              advanceRolloutSettings,
              cancelRolloutSettings,
              listRolloutsSettings,
              getRolloutSettings,
              createRolloutSettings,
              ignoreJobSettings,
              retryJobSettings,
              listJobRunsSettings,
              getJobRunSettings,
              terminateJobRunSettings,
              getConfigSettings,
              createAutomationSettings,
              updateAutomationSettings,
              deleteAutomationSettings,
              getAutomationSettings,
              listAutomationsSettings,
              getAutomationRunSettings,
              listAutomationRunsSettings,
              cancelAutomationRunSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(CloudDeployStubSettings settings) {
      super(settings);

      listDeliveryPipelinesSettings = settings.listDeliveryPipelinesSettings.toBuilder();
      getDeliveryPipelineSettings = settings.getDeliveryPipelineSettings.toBuilder();
      createDeliveryPipelineSettings = settings.createDeliveryPipelineSettings.toBuilder();
      createDeliveryPipelineOperationSettings =
          settings.createDeliveryPipelineOperationSettings.toBuilder();
      updateDeliveryPipelineSettings = settings.updateDeliveryPipelineSettings.toBuilder();
      updateDeliveryPipelineOperationSettings =
          settings.updateDeliveryPipelineOperationSettings.toBuilder();
      deleteDeliveryPipelineSettings = settings.deleteDeliveryPipelineSettings.toBuilder();
      deleteDeliveryPipelineOperationSettings =
          settings.deleteDeliveryPipelineOperationSettings.toBuilder();
      listTargetsSettings = settings.listTargetsSettings.toBuilder();
      rollbackTargetSettings = settings.rollbackTargetSettings.toBuilder();
      getTargetSettings = settings.getTargetSettings.toBuilder();
      createTargetSettings = settings.createTargetSettings.toBuilder();
      createTargetOperationSettings = settings.createTargetOperationSettings.toBuilder();
      updateTargetSettings = settings.updateTargetSettings.toBuilder();
      updateTargetOperationSettings = settings.updateTargetOperationSettings.toBuilder();
      deleteTargetSettings = settings.deleteTargetSettings.toBuilder();
      deleteTargetOperationSettings = settings.deleteTargetOperationSettings.toBuilder();
      listCustomTargetTypesSettings = settings.listCustomTargetTypesSettings.toBuilder();
      getCustomTargetTypeSettings = settings.getCustomTargetTypeSettings.toBuilder();
      createCustomTargetTypeSettings = settings.createCustomTargetTypeSettings.toBuilder();
      createCustomTargetTypeOperationSettings =
          settings.createCustomTargetTypeOperationSettings.toBuilder();
      updateCustomTargetTypeSettings = settings.updateCustomTargetTypeSettings.toBuilder();
      updateCustomTargetTypeOperationSettings =
          settings.updateCustomTargetTypeOperationSettings.toBuilder();
      deleteCustomTargetTypeSettings = settings.deleteCustomTargetTypeSettings.toBuilder();
      deleteCustomTargetTypeOperationSettings =
          settings.deleteCustomTargetTypeOperationSettings.toBuilder();
      listReleasesSettings = settings.listReleasesSettings.toBuilder();
      getReleaseSettings = settings.getReleaseSettings.toBuilder();
      createReleaseSettings = settings.createReleaseSettings.toBuilder();
      createReleaseOperationSettings = settings.createReleaseOperationSettings.toBuilder();
      abandonReleaseSettings = settings.abandonReleaseSettings.toBuilder();
      approveRolloutSettings = settings.approveRolloutSettings.toBuilder();
      advanceRolloutSettings = settings.advanceRolloutSettings.toBuilder();
      cancelRolloutSettings = settings.cancelRolloutSettings.toBuilder();
      listRolloutsSettings = settings.listRolloutsSettings.toBuilder();
      getRolloutSettings = settings.getRolloutSettings.toBuilder();
      createRolloutSettings = settings.createRolloutSettings.toBuilder();
      createRolloutOperationSettings = settings.createRolloutOperationSettings.toBuilder();
      ignoreJobSettings = settings.ignoreJobSettings.toBuilder();
      retryJobSettings = settings.retryJobSettings.toBuilder();
      listJobRunsSettings = settings.listJobRunsSettings.toBuilder();
      getJobRunSettings = settings.getJobRunSettings.toBuilder();
      terminateJobRunSettings = settings.terminateJobRunSettings.toBuilder();
      getConfigSettings = settings.getConfigSettings.toBuilder();
      createAutomationSettings = settings.createAutomationSettings.toBuilder();
      createAutomationOperationSettings = settings.createAutomationOperationSettings.toBuilder();
      updateAutomationSettings = settings.updateAutomationSettings.toBuilder();
      updateAutomationOperationSettings = settings.updateAutomationOperationSettings.toBuilder();
      deleteAutomationSettings = settings.deleteAutomationSettings.toBuilder();
      deleteAutomationOperationSettings = settings.deleteAutomationOperationSettings.toBuilder();
      getAutomationSettings = settings.getAutomationSettings.toBuilder();
      listAutomationsSettings = settings.listAutomationsSettings.toBuilder();
      getAutomationRunSettings = settings.getAutomationRunSettings.toBuilder();
      listAutomationRunsSettings = settings.listAutomationRunsSettings.toBuilder();
      cancelAutomationRunSettings = settings.cancelAutomationRunSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDeliveryPipelinesSettings,
              getDeliveryPipelineSettings,
              createDeliveryPipelineSettings,
              updateDeliveryPipelineSettings,
              deleteDeliveryPipelineSettings,
              listTargetsSettings,
              rollbackTargetSettings,
              getTargetSettings,
              createTargetSettings,
              updateTargetSettings,
              deleteTargetSettings,
              listCustomTargetTypesSettings,
              getCustomTargetTypeSettings,
              createCustomTargetTypeSettings,
              updateCustomTargetTypeSettings,
              deleteCustomTargetTypeSettings,
              listReleasesSettings,
              getReleaseSettings,
              createReleaseSettings,
              abandonReleaseSettings,
              approveRolloutSettings,
              advanceRolloutSettings,
              cancelRolloutSettings,
              listRolloutsSettings,
              getRolloutSettings,
              createRolloutSettings,
              ignoreJobSettings,
              retryJobSettings,
              listJobRunsSettings,
              getJobRunSettings,
              terminateJobRunSettings,
              getConfigSettings,
              createAutomationSettings,
              updateAutomationSettings,
              deleteAutomationSettings,
              getAutomationSettings,
              listAutomationsSettings,
              getAutomationRunSettings,
              listAutomationRunsSettings,
              cancelAutomationRunSettings,
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
          .listDeliveryPipelinesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDeliveryPipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDeliveryPipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDeliveryPipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteDeliveryPipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listTargetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .rollbackTargetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getTargetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTargetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTargetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTargetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listCustomTargetTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCustomTargetTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCustomTargetTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateCustomTargetTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteCustomTargetTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listReleasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .abandonReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .approveRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .advanceRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .cancelRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRolloutsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .ignoreJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .retryJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listJobRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getJobRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .terminateJobRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAutomationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAutomationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteAutomationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAutomationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAutomationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAutomationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAutomationRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelAutomationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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
          .createDeliveryPipelineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDeliveryPipelineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeliveryPipeline.class))
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
          .updateDeliveryPipelineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDeliveryPipelineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeliveryPipeline.class))
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
          .deleteDeliveryPipelineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDeliveryPipelineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createTargetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTargetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Target.class))
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
          .updateTargetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTargetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Target.class))
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
          .deleteTargetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTargetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createCustomTargetTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCustomTargetTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomTargetType.class))
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
          .updateCustomTargetTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCustomTargetTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomTargetType.class))
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
          .deleteCustomTargetTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCustomTargetTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createReleaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReleaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Release.class))
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
          .createRolloutOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRolloutRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Rollout.class))
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
          .createAutomationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAutomationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Automation.class))
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
          .updateAutomationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAutomationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Automation.class))
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
          .deleteAutomationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAutomationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listDeliveryPipelines. */
    public PagedCallSettings.Builder<
            ListDeliveryPipelinesRequest,
            ListDeliveryPipelinesResponse,
            ListDeliveryPipelinesPagedResponse>
        listDeliveryPipelinesSettings() {
      return listDeliveryPipelinesSettings;
    }

    /** Returns the builder for the settings used for calls to getDeliveryPipeline. */
    public UnaryCallSettings.Builder<GetDeliveryPipelineRequest, DeliveryPipeline>
        getDeliveryPipelineSettings() {
      return getDeliveryPipelineSettings;
    }

    /** Returns the builder for the settings used for calls to createDeliveryPipeline. */
    public UnaryCallSettings.Builder<CreateDeliveryPipelineRequest, Operation>
        createDeliveryPipelineSettings() {
      return createDeliveryPipelineSettings;
    }

    /** Returns the builder for the settings used for calls to createDeliveryPipeline. */
    public OperationCallSettings.Builder<
            CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
        createDeliveryPipelineOperationSettings() {
      return createDeliveryPipelineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeliveryPipeline. */
    public UnaryCallSettings.Builder<UpdateDeliveryPipelineRequest, Operation>
        updateDeliveryPipelineSettings() {
      return updateDeliveryPipelineSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeliveryPipeline. */
    public OperationCallSettings.Builder<
            UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
        updateDeliveryPipelineOperationSettings() {
      return updateDeliveryPipelineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeliveryPipeline. */
    public UnaryCallSettings.Builder<DeleteDeliveryPipelineRequest, Operation>
        deleteDeliveryPipelineSettings() {
      return deleteDeliveryPipelineSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeliveryPipeline. */
    public OperationCallSettings.Builder<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
        deleteDeliveryPipelineOperationSettings() {
      return deleteDeliveryPipelineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTargets. */
    public PagedCallSettings.Builder<
            ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>
        listTargetsSettings() {
      return listTargetsSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackTarget. */
    public UnaryCallSettings.Builder<RollbackTargetRequest, RollbackTargetResponse>
        rollbackTargetSettings() {
      return rollbackTargetSettings;
    }

    /** Returns the builder for the settings used for calls to getTarget. */
    public UnaryCallSettings.Builder<GetTargetRequest, Target> getTargetSettings() {
      return getTargetSettings;
    }

    /** Returns the builder for the settings used for calls to createTarget. */
    public UnaryCallSettings.Builder<CreateTargetRequest, Operation> createTargetSettings() {
      return createTargetSettings;
    }

    /** Returns the builder for the settings used for calls to createTarget. */
    public OperationCallSettings.Builder<CreateTargetRequest, Target, OperationMetadata>
        createTargetOperationSettings() {
      return createTargetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTarget. */
    public UnaryCallSettings.Builder<UpdateTargetRequest, Operation> updateTargetSettings() {
      return updateTargetSettings;
    }

    /** Returns the builder for the settings used for calls to updateTarget. */
    public OperationCallSettings.Builder<UpdateTargetRequest, Target, OperationMetadata>
        updateTargetOperationSettings() {
      return updateTargetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTarget. */
    public UnaryCallSettings.Builder<DeleteTargetRequest, Operation> deleteTargetSettings() {
      return deleteTargetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTarget. */
    public OperationCallSettings.Builder<DeleteTargetRequest, Empty, OperationMetadata>
        deleteTargetOperationSettings() {
      return deleteTargetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomTargetTypes. */
    public PagedCallSettings.Builder<
            ListCustomTargetTypesRequest,
            ListCustomTargetTypesResponse,
            ListCustomTargetTypesPagedResponse>
        listCustomTargetTypesSettings() {
      return listCustomTargetTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomTargetType. */
    public UnaryCallSettings.Builder<GetCustomTargetTypeRequest, CustomTargetType>
        getCustomTargetTypeSettings() {
      return getCustomTargetTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomTargetType. */
    public UnaryCallSettings.Builder<CreateCustomTargetTypeRequest, Operation>
        createCustomTargetTypeSettings() {
      return createCustomTargetTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomTargetType. */
    public OperationCallSettings.Builder<
            CreateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
        createCustomTargetTypeOperationSettings() {
      return createCustomTargetTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomTargetType. */
    public UnaryCallSettings.Builder<UpdateCustomTargetTypeRequest, Operation>
        updateCustomTargetTypeSettings() {
      return updateCustomTargetTypeSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomTargetType. */
    public OperationCallSettings.Builder<
            UpdateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
        updateCustomTargetTypeOperationSettings() {
      return updateCustomTargetTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomTargetType. */
    public UnaryCallSettings.Builder<DeleteCustomTargetTypeRequest, Operation>
        deleteCustomTargetTypeSettings() {
      return deleteCustomTargetTypeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomTargetType. */
    public OperationCallSettings.Builder<DeleteCustomTargetTypeRequest, Empty, OperationMetadata>
        deleteCustomTargetTypeOperationSettings() {
      return deleteCustomTargetTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listReleases. */
    public PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings() {
      return listReleasesSettings;
    }

    /** Returns the builder for the settings used for calls to getRelease. */
    public UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings() {
      return getReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public UnaryCallSettings.Builder<CreateReleaseRequest, Operation> createReleaseSettings() {
      return createReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public OperationCallSettings.Builder<CreateReleaseRequest, Release, OperationMetadata>
        createReleaseOperationSettings() {
      return createReleaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to abandonRelease. */
    public UnaryCallSettings.Builder<AbandonReleaseRequest, AbandonReleaseResponse>
        abandonReleaseSettings() {
      return abandonReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to approveRollout. */
    public UnaryCallSettings.Builder<ApproveRolloutRequest, ApproveRolloutResponse>
        approveRolloutSettings() {
      return approveRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to advanceRollout. */
    public UnaryCallSettings.Builder<AdvanceRolloutRequest, AdvanceRolloutResponse>
        advanceRolloutSettings() {
      return advanceRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to cancelRollout. */
    public UnaryCallSettings.Builder<CancelRolloutRequest, CancelRolloutResponse>
        cancelRolloutSettings() {
      return cancelRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to listRollouts. */
    public PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings() {
      return listRolloutsSettings;
    }

    /** Returns the builder for the settings used for calls to getRollout. */
    public UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings() {
      return getRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to createRollout. */
    public UnaryCallSettings.Builder<CreateRolloutRequest, Operation> createRolloutSettings() {
      return createRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to createRollout. */
    public OperationCallSettings.Builder<CreateRolloutRequest, Rollout, OperationMetadata>
        createRolloutOperationSettings() {
      return createRolloutOperationSettings;
    }

    /** Returns the builder for the settings used for calls to ignoreJob. */
    public UnaryCallSettings.Builder<IgnoreJobRequest, IgnoreJobResponse> ignoreJobSettings() {
      return ignoreJobSettings;
    }

    /** Returns the builder for the settings used for calls to retryJob. */
    public UnaryCallSettings.Builder<RetryJobRequest, RetryJobResponse> retryJobSettings() {
      return retryJobSettings;
    }

    /** Returns the builder for the settings used for calls to listJobRuns. */
    public PagedCallSettings.Builder<
            ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>
        listJobRunsSettings() {
      return listJobRunsSettings;
    }

    /** Returns the builder for the settings used for calls to getJobRun. */
    public UnaryCallSettings.Builder<GetJobRunRequest, JobRun> getJobRunSettings() {
      return getJobRunSettings;
    }

    /** Returns the builder for the settings used for calls to terminateJobRun. */
    public UnaryCallSettings.Builder<TerminateJobRunRequest, TerminateJobRunResponse>
        terminateJobRunSettings() {
      return terminateJobRunSettings;
    }

    /** Returns the builder for the settings used for calls to getConfig. */
    public UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings() {
      return getConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createAutomation. */
    public UnaryCallSettings.Builder<CreateAutomationRequest, Operation>
        createAutomationSettings() {
      return createAutomationSettings;
    }

    /** Returns the builder for the settings used for calls to createAutomation. */
    public OperationCallSettings.Builder<CreateAutomationRequest, Automation, OperationMetadata>
        createAutomationOperationSettings() {
      return createAutomationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAutomation. */
    public UnaryCallSettings.Builder<UpdateAutomationRequest, Operation>
        updateAutomationSettings() {
      return updateAutomationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAutomation. */
    public OperationCallSettings.Builder<UpdateAutomationRequest, Automation, OperationMetadata>
        updateAutomationOperationSettings() {
      return updateAutomationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAutomation. */
    public UnaryCallSettings.Builder<DeleteAutomationRequest, Operation>
        deleteAutomationSettings() {
      return deleteAutomationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAutomation. */
    public OperationCallSettings.Builder<DeleteAutomationRequest, Empty, OperationMetadata>
        deleteAutomationOperationSettings() {
      return deleteAutomationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAutomation. */
    public UnaryCallSettings.Builder<GetAutomationRequest, Automation> getAutomationSettings() {
      return getAutomationSettings;
    }

    /** Returns the builder for the settings used for calls to listAutomations. */
    public PagedCallSettings.Builder<
            ListAutomationsRequest, ListAutomationsResponse, ListAutomationsPagedResponse>
        listAutomationsSettings() {
      return listAutomationsSettings;
    }

    /** Returns the builder for the settings used for calls to getAutomationRun. */
    public UnaryCallSettings.Builder<GetAutomationRunRequest, AutomationRun>
        getAutomationRunSettings() {
      return getAutomationRunSettings;
    }

    /** Returns the builder for the settings used for calls to listAutomationRuns. */
    public PagedCallSettings.Builder<
            ListAutomationRunsRequest, ListAutomationRunsResponse, ListAutomationRunsPagedResponse>
        listAutomationRunsSettings() {
      return listAutomationRunsSettings;
    }

    /** Returns the builder for the settings used for calls to cancelAutomationRun. */
    public UnaryCallSettings.Builder<CancelAutomationRunRequest, CancelAutomationRunResponse>
        cancelAutomationRunSettings() {
      return cancelAutomationRunSettings;
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
    public CloudDeployStubSettings build() throws IOException {
      return new CloudDeployStubSettings(this);
    }
  }
}
