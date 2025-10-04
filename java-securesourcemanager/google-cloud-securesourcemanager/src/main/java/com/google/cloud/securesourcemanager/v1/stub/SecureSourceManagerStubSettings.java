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

package com.google.cloud.securesourcemanager.v1.stub;

import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.FetchTreePagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListBranchRulesPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListHooksPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListIssueCommentsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListIssuesPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListPullRequestCommentsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListPullRequestFileDiffsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListPullRequestsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListRepositoriesPagedResponse;

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
import com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest;
import com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsResponse;
import com.google.cloud.securesourcemanager.v1.BranchRule;
import com.google.cloud.securesourcemanager.v1.CloseIssueRequest;
import com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest;
import com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest;
import com.google.cloud.securesourcemanager.v1.CreateHookRequest;
import com.google.cloud.securesourcemanager.v1.CreateInstanceRequest;
import com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest;
import com.google.cloud.securesourcemanager.v1.CreateIssueRequest;
import com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest;
import com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest;
import com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest;
import com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest;
import com.google.cloud.securesourcemanager.v1.DeleteHookRequest;
import com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest;
import com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest;
import com.google.cloud.securesourcemanager.v1.DeleteIssueRequest;
import com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest;
import com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest;
import com.google.cloud.securesourcemanager.v1.FetchBlobRequest;
import com.google.cloud.securesourcemanager.v1.FetchBlobResponse;
import com.google.cloud.securesourcemanager.v1.FetchTreeRequest;
import com.google.cloud.securesourcemanager.v1.FetchTreeResponse;
import com.google.cloud.securesourcemanager.v1.FileDiff;
import com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest;
import com.google.cloud.securesourcemanager.v1.GetHookRequest;
import com.google.cloud.securesourcemanager.v1.GetInstanceRequest;
import com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest;
import com.google.cloud.securesourcemanager.v1.GetIssueRequest;
import com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest;
import com.google.cloud.securesourcemanager.v1.GetPullRequestRequest;
import com.google.cloud.securesourcemanager.v1.GetRepositoryRequest;
import com.google.cloud.securesourcemanager.v1.Hook;
import com.google.cloud.securesourcemanager.v1.Instance;
import com.google.cloud.securesourcemanager.v1.Issue;
import com.google.cloud.securesourcemanager.v1.IssueComment;
import com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest;
import com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse;
import com.google.cloud.securesourcemanager.v1.ListHooksRequest;
import com.google.cloud.securesourcemanager.v1.ListHooksResponse;
import com.google.cloud.securesourcemanager.v1.ListInstancesRequest;
import com.google.cloud.securesourcemanager.v1.ListInstancesResponse;
import com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest;
import com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse;
import com.google.cloud.securesourcemanager.v1.ListIssuesRequest;
import com.google.cloud.securesourcemanager.v1.ListIssuesResponse;
import com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest;
import com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse;
import com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest;
import com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse;
import com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest;
import com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse;
import com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest;
import com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse;
import com.google.cloud.securesourcemanager.v1.MergePullRequestRequest;
import com.google.cloud.securesourcemanager.v1.OpenIssueRequest;
import com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest;
import com.google.cloud.securesourcemanager.v1.OperationMetadata;
import com.google.cloud.securesourcemanager.v1.PullRequest;
import com.google.cloud.securesourcemanager.v1.PullRequestComment;
import com.google.cloud.securesourcemanager.v1.Repository;
import com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest;
import com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsResponse;
import com.google.cloud.securesourcemanager.v1.TreeEntry;
import com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest;
import com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsResponse;
import com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest;
import com.google.cloud.securesourcemanager.v1.UpdateHookRequest;
import com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest;
import com.google.cloud.securesourcemanager.v1.UpdateIssueRequest;
import com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest;
import com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest;
import com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest;
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
 * Settings class to configure an instance of {@link SecureSourceManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securesourcemanager.googleapis.com) and default port (443) are
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
 * of getInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecureSourceManagerStubSettings.Builder secureSourceManagerSettingsBuilder =
 *     SecureSourceManagerStubSettings.newBuilder();
 * secureSourceManagerSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         secureSourceManagerSettingsBuilder
 *             .getInstanceSettings()
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
 * SecureSourceManagerStubSettings secureSourceManagerSettings =
 *     secureSourceManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecureSourceManagerStubSettings.Builder secureSourceManagerSettingsBuilder =
 *     SecureSourceManagerStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * secureSourceManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecureSourceManagerStubSettings extends StubSettings<SecureSourceManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings;
  private final OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings;
  private final OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings;
  private final PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings;
  private final UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings;
  private final UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings;
  private final OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings;
  private final UnaryCallSettings<UpdateRepositoryRequest, Operation> updateRepositorySettings;
  private final OperationCallSettings<UpdateRepositoryRequest, Repository, OperationMetadata>
      updateRepositoryOperationSettings;
  private final UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings;
  private final OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings;
  private final PagedCallSettings<ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>
      listHooksSettings;
  private final UnaryCallSettings<GetHookRequest, Hook> getHookSettings;
  private final UnaryCallSettings<CreateHookRequest, Operation> createHookSettings;
  private final OperationCallSettings<CreateHookRequest, Hook, OperationMetadata>
      createHookOperationSettings;
  private final UnaryCallSettings<UpdateHookRequest, Operation> updateHookSettings;
  private final OperationCallSettings<UpdateHookRequest, Hook, OperationMetadata>
      updateHookOperationSettings;
  private final UnaryCallSettings<DeleteHookRequest, Operation> deleteHookSettings;
  private final OperationCallSettings<DeleteHookRequest, Empty, OperationMetadata>
      deleteHookOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicyRepoSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicyRepoSettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoSettings;
  private final UnaryCallSettings<CreateBranchRuleRequest, Operation> createBranchRuleSettings;
  private final OperationCallSettings<CreateBranchRuleRequest, BranchRule, OperationMetadata>
      createBranchRuleOperationSettings;
  private final PagedCallSettings<
          ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>
      listBranchRulesSettings;
  private final UnaryCallSettings<GetBranchRuleRequest, BranchRule> getBranchRuleSettings;
  private final UnaryCallSettings<UpdateBranchRuleRequest, Operation> updateBranchRuleSettings;
  private final OperationCallSettings<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
      updateBranchRuleOperationSettings;
  private final UnaryCallSettings<DeleteBranchRuleRequest, Operation> deleteBranchRuleSettings;
  private final OperationCallSettings<DeleteBranchRuleRequest, Empty, OperationMetadata>
      deleteBranchRuleOperationSettings;
  private final UnaryCallSettings<CreatePullRequestRequest, Operation> createPullRequestSettings;
  private final OperationCallSettings<CreatePullRequestRequest, PullRequest, OperationMetadata>
      createPullRequestOperationSettings;
  private final UnaryCallSettings<GetPullRequestRequest, PullRequest> getPullRequestSettings;
  private final PagedCallSettings<
          ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>
      listPullRequestsSettings;
  private final UnaryCallSettings<UpdatePullRequestRequest, Operation> updatePullRequestSettings;
  private final OperationCallSettings<UpdatePullRequestRequest, PullRequest, OperationMetadata>
      updatePullRequestOperationSettings;
  private final UnaryCallSettings<MergePullRequestRequest, Operation> mergePullRequestSettings;
  private final OperationCallSettings<MergePullRequestRequest, PullRequest, OperationMetadata>
      mergePullRequestOperationSettings;
  private final UnaryCallSettings<OpenPullRequestRequest, Operation> openPullRequestSettings;
  private final OperationCallSettings<OpenPullRequestRequest, PullRequest, OperationMetadata>
      openPullRequestOperationSettings;
  private final UnaryCallSettings<ClosePullRequestRequest, Operation> closePullRequestSettings;
  private final OperationCallSettings<ClosePullRequestRequest, PullRequest, OperationMetadata>
      closePullRequestOperationSettings;
  private final PagedCallSettings<
          ListPullRequestFileDiffsRequest,
          ListPullRequestFileDiffsResponse,
          ListPullRequestFileDiffsPagedResponse>
      listPullRequestFileDiffsSettings;
  private final PagedCallSettings<FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>
      fetchTreeSettings;
  private final UnaryCallSettings<FetchBlobRequest, FetchBlobResponse> fetchBlobSettings;
  private final UnaryCallSettings<CreateIssueRequest, Operation> createIssueSettings;
  private final OperationCallSettings<CreateIssueRequest, Issue, OperationMetadata>
      createIssueOperationSettings;
  private final UnaryCallSettings<GetIssueRequest, Issue> getIssueSettings;
  private final PagedCallSettings<ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>
      listIssuesSettings;
  private final UnaryCallSettings<UpdateIssueRequest, Operation> updateIssueSettings;
  private final OperationCallSettings<UpdateIssueRequest, Issue, OperationMetadata>
      updateIssueOperationSettings;
  private final UnaryCallSettings<DeleteIssueRequest, Operation> deleteIssueSettings;
  private final OperationCallSettings<DeleteIssueRequest, Empty, OperationMetadata>
      deleteIssueOperationSettings;
  private final UnaryCallSettings<OpenIssueRequest, Operation> openIssueSettings;
  private final OperationCallSettings<OpenIssueRequest, Issue, OperationMetadata>
      openIssueOperationSettings;
  private final UnaryCallSettings<CloseIssueRequest, Operation> closeIssueSettings;
  private final OperationCallSettings<CloseIssueRequest, Issue, OperationMetadata>
      closeIssueOperationSettings;
  private final UnaryCallSettings<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentSettings;
  private final PagedCallSettings<
          ListPullRequestCommentsRequest,
          ListPullRequestCommentsResponse,
          ListPullRequestCommentsPagedResponse>
      listPullRequestCommentsSettings;
  private final UnaryCallSettings<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentSettings;
  private final OperationCallSettings<
          CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      createPullRequestCommentOperationSettings;
  private final UnaryCallSettings<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentSettings;
  private final OperationCallSettings<
          UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      updatePullRequestCommentOperationSettings;
  private final UnaryCallSettings<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentSettings;
  private final OperationCallSettings<DeletePullRequestCommentRequest, Empty, OperationMetadata>
      deletePullRequestCommentOperationSettings;
  private final UnaryCallSettings<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsSettings;
  private final OperationCallSettings<
          BatchCreatePullRequestCommentsRequest,
          BatchCreatePullRequestCommentsResponse,
          OperationMetadata>
      batchCreatePullRequestCommentsOperationSettings;
  private final UnaryCallSettings<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsSettings;
  private final OperationCallSettings<
          ResolvePullRequestCommentsRequest, ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsOperationSettings;
  private final UnaryCallSettings<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsSettings;
  private final OperationCallSettings<
          UnresolvePullRequestCommentsRequest,
          UnresolvePullRequestCommentsResponse,
          OperationMetadata>
      unresolvePullRequestCommentsOperationSettings;
  private final UnaryCallSettings<CreateIssueCommentRequest, Operation> createIssueCommentSettings;
  private final OperationCallSettings<CreateIssueCommentRequest, IssueComment, OperationMetadata>
      createIssueCommentOperationSettings;
  private final UnaryCallSettings<GetIssueCommentRequest, IssueComment> getIssueCommentSettings;
  private final PagedCallSettings<
          ListIssueCommentsRequest, ListIssueCommentsResponse, ListIssueCommentsPagedResponse>
      listIssueCommentsSettings;
  private final UnaryCallSettings<UpdateIssueCommentRequest, Operation> updateIssueCommentSettings;
  private final OperationCallSettings<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
      updateIssueCommentOperationSettings;
  private final UnaryCallSettings<DeleteIssueCommentRequest, Operation> deleteIssueCommentSettings;
  private final OperationCallSettings<DeleteIssueCommentRequest, Empty, OperationMetadata>
      deleteIssueCommentOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

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

  private static final PagedListDescriptor<
          ListRepositoriesRequest, ListRepositoriesResponse, Repository>
      LIST_REPOSITORIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRepositoriesRequest, ListRepositoriesResponse, Repository>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRepositoriesRequest injectToken(
                ListRepositoriesRequest payload, String token) {
              return ListRepositoriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRepositoriesRequest injectPageSize(
                ListRepositoriesRequest payload, int pageSize) {
              return ListRepositoriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRepositoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRepositoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Repository> extractResources(ListRepositoriesResponse payload) {
              return payload.getRepositoriesList();
            }
          };

  private static final PagedListDescriptor<ListHooksRequest, ListHooksResponse, Hook>
      LIST_HOOKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListHooksRequest, ListHooksResponse, Hook>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHooksRequest injectToken(ListHooksRequest payload, String token) {
              return ListHooksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHooksRequest injectPageSize(ListHooksRequest payload, int pageSize) {
              return ListHooksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHooksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHooksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Hook> extractResources(ListHooksResponse payload) {
              return payload.getHooksList();
            }
          };

  private static final PagedListDescriptor<
          ListBranchRulesRequest, ListBranchRulesResponse, BranchRule>
      LIST_BRANCH_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<ListBranchRulesRequest, ListBranchRulesResponse, BranchRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBranchRulesRequest injectToken(
                ListBranchRulesRequest payload, String token) {
              return ListBranchRulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBranchRulesRequest injectPageSize(
                ListBranchRulesRequest payload, int pageSize) {
              return ListBranchRulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBranchRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBranchRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BranchRule> extractResources(ListBranchRulesResponse payload) {
              return payload.getBranchRulesList();
            }
          };

  private static final PagedListDescriptor<
          ListPullRequestsRequest, ListPullRequestsResponse, PullRequest>
      LIST_PULL_REQUESTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPullRequestsRequest, ListPullRequestsResponse, PullRequest>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPullRequestsRequest injectToken(
                ListPullRequestsRequest payload, String token) {
              return ListPullRequestsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPullRequestsRequest injectPageSize(
                ListPullRequestsRequest payload, int pageSize) {
              return ListPullRequestsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPullRequestsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPullRequestsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PullRequest> extractResources(ListPullRequestsResponse payload) {
              return payload.getPullRequestsList();
            }
          };

  private static final PagedListDescriptor<
          ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse, FileDiff>
      LIST_PULL_REQUEST_FILE_DIFFS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse, FileDiff>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPullRequestFileDiffsRequest injectToken(
                ListPullRequestFileDiffsRequest payload, String token) {
              return ListPullRequestFileDiffsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPullRequestFileDiffsRequest injectPageSize(
                ListPullRequestFileDiffsRequest payload, int pageSize) {
              return ListPullRequestFileDiffsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPullRequestFileDiffsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPullRequestFileDiffsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FileDiff> extractResources(ListPullRequestFileDiffsResponse payload) {
              return payload.getFileDiffsList();
            }
          };

  private static final PagedListDescriptor<FetchTreeRequest, FetchTreeResponse, TreeEntry>
      FETCH_TREE_PAGE_STR_DESC =
          new PagedListDescriptor<FetchTreeRequest, FetchTreeResponse, TreeEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchTreeRequest injectToken(FetchTreeRequest payload, String token) {
              return FetchTreeRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchTreeRequest injectPageSize(FetchTreeRequest payload, int pageSize) {
              return FetchTreeRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchTreeRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchTreeResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TreeEntry> extractResources(FetchTreeResponse payload) {
              return payload.getTreeEntriesList();
            }
          };

  private static final PagedListDescriptor<ListIssuesRequest, ListIssuesResponse, Issue>
      LIST_ISSUES_PAGE_STR_DESC =
          new PagedListDescriptor<ListIssuesRequest, ListIssuesResponse, Issue>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIssuesRequest injectToken(ListIssuesRequest payload, String token) {
              return ListIssuesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIssuesRequest injectPageSize(ListIssuesRequest payload, int pageSize) {
              return ListIssuesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIssuesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIssuesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Issue> extractResources(ListIssuesResponse payload) {
              return payload.getIssuesList();
            }
          };

  private static final PagedListDescriptor<
          ListPullRequestCommentsRequest, ListPullRequestCommentsResponse, PullRequestComment>
      LIST_PULL_REQUEST_COMMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPullRequestCommentsRequest,
              ListPullRequestCommentsResponse,
              PullRequestComment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPullRequestCommentsRequest injectToken(
                ListPullRequestCommentsRequest payload, String token) {
              return ListPullRequestCommentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPullRequestCommentsRequest injectPageSize(
                ListPullRequestCommentsRequest payload, int pageSize) {
              return ListPullRequestCommentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPullRequestCommentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPullRequestCommentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PullRequestComment> extractResources(
                ListPullRequestCommentsResponse payload) {
              return payload.getPullRequestCommentsList();
            }
          };

  private static final PagedListDescriptor<
          ListIssueCommentsRequest, ListIssueCommentsResponse, IssueComment>
      LIST_ISSUE_COMMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIssueCommentsRequest, ListIssueCommentsResponse, IssueComment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIssueCommentsRequest injectToken(
                ListIssueCommentsRequest payload, String token) {
              return ListIssueCommentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIssueCommentsRequest injectPageSize(
                ListIssueCommentsRequest payload, int pageSize) {
              return ListIssueCommentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIssueCommentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIssueCommentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IssueComment> extractResources(ListIssueCommentsResponse payload) {
              return payload.getIssueCommentsList();
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
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      LIST_REPOSITORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>() {
            @Override
            public ApiFuture<ListRepositoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse> callable,
                ListRepositoriesRequest request,
                ApiCallContext context,
                ApiFuture<ListRepositoriesResponse> futureResponse) {
              PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPOSITORIES_PAGE_STR_DESC, request, context);
              return ListRepositoriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>
      LIST_HOOKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>() {
            @Override
            public ApiFuture<ListHooksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHooksRequest, ListHooksResponse> callable,
                ListHooksRequest request,
                ApiCallContext context,
                ApiFuture<ListHooksResponse> futureResponse) {
              PageContext<ListHooksRequest, ListHooksResponse, Hook> pageContext =
                  PageContext.create(callable, LIST_HOOKS_PAGE_STR_DESC, request, context);
              return ListHooksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>
      LIST_BRANCH_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>() {
            @Override
            public ApiFuture<ListBranchRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBranchRulesRequest, ListBranchRulesResponse> callable,
                ListBranchRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListBranchRulesResponse> futureResponse) {
              PageContext<ListBranchRulesRequest, ListBranchRulesResponse, BranchRule> pageContext =
                  PageContext.create(callable, LIST_BRANCH_RULES_PAGE_STR_DESC, request, context);
              return ListBranchRulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>
      LIST_PULL_REQUESTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>() {
            @Override
            public ApiFuture<ListPullRequestsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPullRequestsRequest, ListPullRequestsResponse> callable,
                ListPullRequestsRequest request,
                ApiCallContext context,
                ApiFuture<ListPullRequestsResponse> futureResponse) {
              PageContext<ListPullRequestsRequest, ListPullRequestsResponse, PullRequest>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PULL_REQUESTS_PAGE_STR_DESC, request, context);
              return ListPullRequestsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPullRequestFileDiffsRequest,
          ListPullRequestFileDiffsResponse,
          ListPullRequestFileDiffsPagedResponse>
      LIST_PULL_REQUEST_FILE_DIFFS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPullRequestFileDiffsRequest,
              ListPullRequestFileDiffsResponse,
              ListPullRequestFileDiffsPagedResponse>() {
            @Override
            public ApiFuture<ListPullRequestFileDiffsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
                    callable,
                ListPullRequestFileDiffsRequest request,
                ApiCallContext context,
                ApiFuture<ListPullRequestFileDiffsResponse> futureResponse) {
              PageContext<
                      ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse, FileDiff>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PULL_REQUEST_FILE_DIFFS_PAGE_STR_DESC, request, context);
              return ListPullRequestFileDiffsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>
      FETCH_TREE_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>() {
            @Override
            public ApiFuture<FetchTreePagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchTreeRequest, FetchTreeResponse> callable,
                FetchTreeRequest request,
                ApiCallContext context,
                ApiFuture<FetchTreeResponse> futureResponse) {
              PageContext<FetchTreeRequest, FetchTreeResponse, TreeEntry> pageContext =
                  PageContext.create(callable, FETCH_TREE_PAGE_STR_DESC, request, context);
              return FetchTreePagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>
      LIST_ISSUES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>() {
            @Override
            public ApiFuture<ListIssuesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIssuesRequest, ListIssuesResponse> callable,
                ListIssuesRequest request,
                ApiCallContext context,
                ApiFuture<ListIssuesResponse> futureResponse) {
              PageContext<ListIssuesRequest, ListIssuesResponse, Issue> pageContext =
                  PageContext.create(callable, LIST_ISSUES_PAGE_STR_DESC, request, context);
              return ListIssuesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPullRequestCommentsRequest,
          ListPullRequestCommentsResponse,
          ListPullRequestCommentsPagedResponse>
      LIST_PULL_REQUEST_COMMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPullRequestCommentsRequest,
              ListPullRequestCommentsResponse,
              ListPullRequestCommentsPagedResponse>() {
            @Override
            public ApiFuture<ListPullRequestCommentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
                    callable,
                ListPullRequestCommentsRequest request,
                ApiCallContext context,
                ApiFuture<ListPullRequestCommentsResponse> futureResponse) {
              PageContext<
                      ListPullRequestCommentsRequest,
                      ListPullRequestCommentsResponse,
                      PullRequestComment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PULL_REQUEST_COMMENTS_PAGE_STR_DESC, request, context);
              return ListPullRequestCommentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListIssueCommentsRequest, ListIssueCommentsResponse, ListIssueCommentsPagedResponse>
      LIST_ISSUE_COMMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIssueCommentsRequest,
              ListIssueCommentsResponse,
              ListIssueCommentsPagedResponse>() {
            @Override
            public ApiFuture<ListIssueCommentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsResponse> callable,
                ListIssueCommentsRequest request,
                ApiCallContext context,
                ApiFuture<ListIssueCommentsResponse> futureResponse) {
              PageContext<ListIssueCommentsRequest, ListIssueCommentsResponse, IssueComment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ISSUE_COMMENTS_PAGE_STR_DESC, request, context);
              return ListIssueCommentsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return createInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return createInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return deleteInstanceSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return deleteInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRepositories. */
  public PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings() {
    return listRepositoriesSettings;
  }

  /** Returns the object with the settings used for calls to getRepository. */
  public UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings() {
    return getRepositorySettings;
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings() {
    return createRepositorySettings;
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings() {
    return createRepositoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public UnaryCallSettings<UpdateRepositoryRequest, Operation> updateRepositorySettings() {
    return updateRepositorySettings;
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public OperationCallSettings<UpdateRepositoryRequest, Repository, OperationMetadata>
      updateRepositoryOperationSettings() {
    return updateRepositoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings() {
    return deleteRepositorySettings;
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings() {
    return deleteRepositoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to listHooks. */
  public PagedCallSettings<ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>
      listHooksSettings() {
    return listHooksSettings;
  }

  /** Returns the object with the settings used for calls to getHook. */
  public UnaryCallSettings<GetHookRequest, Hook> getHookSettings() {
    return getHookSettings;
  }

  /** Returns the object with the settings used for calls to createHook. */
  public UnaryCallSettings<CreateHookRequest, Operation> createHookSettings() {
    return createHookSettings;
  }

  /** Returns the object with the settings used for calls to createHook. */
  public OperationCallSettings<CreateHookRequest, Hook, OperationMetadata>
      createHookOperationSettings() {
    return createHookOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateHook. */
  public UnaryCallSettings<UpdateHookRequest, Operation> updateHookSettings() {
    return updateHookSettings;
  }

  /** Returns the object with the settings used for calls to updateHook. */
  public OperationCallSettings<UpdateHookRequest, Hook, OperationMetadata>
      updateHookOperationSettings() {
    return updateHookOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteHook. */
  public UnaryCallSettings<DeleteHookRequest, Operation> deleteHookSettings() {
    return deleteHookSettings;
  }

  /** Returns the object with the settings used for calls to deleteHook. */
  public OperationCallSettings<DeleteHookRequest, Empty, OperationMetadata>
      deleteHookOperationSettings() {
    return deleteHookOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicyRepo. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicyRepoSettings() {
    return getIamPolicyRepoSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicyRepo. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicyRepoSettings() {
    return setIamPolicyRepoSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsRepo. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoSettings() {
    return testIamPermissionsRepoSettings;
  }

  /** Returns the object with the settings used for calls to createBranchRule. */
  public UnaryCallSettings<CreateBranchRuleRequest, Operation> createBranchRuleSettings() {
    return createBranchRuleSettings;
  }

  /** Returns the object with the settings used for calls to createBranchRule. */
  public OperationCallSettings<CreateBranchRuleRequest, BranchRule, OperationMetadata>
      createBranchRuleOperationSettings() {
    return createBranchRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBranchRules. */
  public PagedCallSettings<
          ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>
      listBranchRulesSettings() {
    return listBranchRulesSettings;
  }

  /** Returns the object with the settings used for calls to getBranchRule. */
  public UnaryCallSettings<GetBranchRuleRequest, BranchRule> getBranchRuleSettings() {
    return getBranchRuleSettings;
  }

  /** Returns the object with the settings used for calls to updateBranchRule. */
  public UnaryCallSettings<UpdateBranchRuleRequest, Operation> updateBranchRuleSettings() {
    return updateBranchRuleSettings;
  }

  /** Returns the object with the settings used for calls to updateBranchRule. */
  public OperationCallSettings<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
      updateBranchRuleOperationSettings() {
    return updateBranchRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBranchRule. */
  public UnaryCallSettings<DeleteBranchRuleRequest, Operation> deleteBranchRuleSettings() {
    return deleteBranchRuleSettings;
  }

  /** Returns the object with the settings used for calls to deleteBranchRule. */
  public OperationCallSettings<DeleteBranchRuleRequest, Empty, OperationMetadata>
      deleteBranchRuleOperationSettings() {
    return deleteBranchRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to createPullRequest. */
  public UnaryCallSettings<CreatePullRequestRequest, Operation> createPullRequestSettings() {
    return createPullRequestSettings;
  }

  /** Returns the object with the settings used for calls to createPullRequest. */
  public OperationCallSettings<CreatePullRequestRequest, PullRequest, OperationMetadata>
      createPullRequestOperationSettings() {
    return createPullRequestOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPullRequest. */
  public UnaryCallSettings<GetPullRequestRequest, PullRequest> getPullRequestSettings() {
    return getPullRequestSettings;
  }

  /** Returns the object with the settings used for calls to listPullRequests. */
  public PagedCallSettings<
          ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>
      listPullRequestsSettings() {
    return listPullRequestsSettings;
  }

  /** Returns the object with the settings used for calls to updatePullRequest. */
  public UnaryCallSettings<UpdatePullRequestRequest, Operation> updatePullRequestSettings() {
    return updatePullRequestSettings;
  }

  /** Returns the object with the settings used for calls to updatePullRequest. */
  public OperationCallSettings<UpdatePullRequestRequest, PullRequest, OperationMetadata>
      updatePullRequestOperationSettings() {
    return updatePullRequestOperationSettings;
  }

  /** Returns the object with the settings used for calls to mergePullRequest. */
  public UnaryCallSettings<MergePullRequestRequest, Operation> mergePullRequestSettings() {
    return mergePullRequestSettings;
  }

  /** Returns the object with the settings used for calls to mergePullRequest. */
  public OperationCallSettings<MergePullRequestRequest, PullRequest, OperationMetadata>
      mergePullRequestOperationSettings() {
    return mergePullRequestOperationSettings;
  }

  /** Returns the object with the settings used for calls to openPullRequest. */
  public UnaryCallSettings<OpenPullRequestRequest, Operation> openPullRequestSettings() {
    return openPullRequestSettings;
  }

  /** Returns the object with the settings used for calls to openPullRequest. */
  public OperationCallSettings<OpenPullRequestRequest, PullRequest, OperationMetadata>
      openPullRequestOperationSettings() {
    return openPullRequestOperationSettings;
  }

  /** Returns the object with the settings used for calls to closePullRequest. */
  public UnaryCallSettings<ClosePullRequestRequest, Operation> closePullRequestSettings() {
    return closePullRequestSettings;
  }

  /** Returns the object with the settings used for calls to closePullRequest. */
  public OperationCallSettings<ClosePullRequestRequest, PullRequest, OperationMetadata>
      closePullRequestOperationSettings() {
    return closePullRequestOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPullRequestFileDiffs. */
  public PagedCallSettings<
          ListPullRequestFileDiffsRequest,
          ListPullRequestFileDiffsResponse,
          ListPullRequestFileDiffsPagedResponse>
      listPullRequestFileDiffsSettings() {
    return listPullRequestFileDiffsSettings;
  }

  /** Returns the object with the settings used for calls to fetchTree. */
  public PagedCallSettings<FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>
      fetchTreeSettings() {
    return fetchTreeSettings;
  }

  /** Returns the object with the settings used for calls to fetchBlob. */
  public UnaryCallSettings<FetchBlobRequest, FetchBlobResponse> fetchBlobSettings() {
    return fetchBlobSettings;
  }

  /** Returns the object with the settings used for calls to createIssue. */
  public UnaryCallSettings<CreateIssueRequest, Operation> createIssueSettings() {
    return createIssueSettings;
  }

  /** Returns the object with the settings used for calls to createIssue. */
  public OperationCallSettings<CreateIssueRequest, Issue, OperationMetadata>
      createIssueOperationSettings() {
    return createIssueOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIssue. */
  public UnaryCallSettings<GetIssueRequest, Issue> getIssueSettings() {
    return getIssueSettings;
  }

  /** Returns the object with the settings used for calls to listIssues. */
  public PagedCallSettings<ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>
      listIssuesSettings() {
    return listIssuesSettings;
  }

  /** Returns the object with the settings used for calls to updateIssue. */
  public UnaryCallSettings<UpdateIssueRequest, Operation> updateIssueSettings() {
    return updateIssueSettings;
  }

  /** Returns the object with the settings used for calls to updateIssue. */
  public OperationCallSettings<UpdateIssueRequest, Issue, OperationMetadata>
      updateIssueOperationSettings() {
    return updateIssueOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteIssue. */
  public UnaryCallSettings<DeleteIssueRequest, Operation> deleteIssueSettings() {
    return deleteIssueSettings;
  }

  /** Returns the object with the settings used for calls to deleteIssue. */
  public OperationCallSettings<DeleteIssueRequest, Empty, OperationMetadata>
      deleteIssueOperationSettings() {
    return deleteIssueOperationSettings;
  }

  /** Returns the object with the settings used for calls to openIssue. */
  public UnaryCallSettings<OpenIssueRequest, Operation> openIssueSettings() {
    return openIssueSettings;
  }

  /** Returns the object with the settings used for calls to openIssue. */
  public OperationCallSettings<OpenIssueRequest, Issue, OperationMetadata>
      openIssueOperationSettings() {
    return openIssueOperationSettings;
  }

  /** Returns the object with the settings used for calls to closeIssue. */
  public UnaryCallSettings<CloseIssueRequest, Operation> closeIssueSettings() {
    return closeIssueSettings;
  }

  /** Returns the object with the settings used for calls to closeIssue. */
  public OperationCallSettings<CloseIssueRequest, Issue, OperationMetadata>
      closeIssueOperationSettings() {
    return closeIssueOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPullRequestComment. */
  public UnaryCallSettings<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentSettings() {
    return getPullRequestCommentSettings;
  }

  /** Returns the object with the settings used for calls to listPullRequestComments. */
  public PagedCallSettings<
          ListPullRequestCommentsRequest,
          ListPullRequestCommentsResponse,
          ListPullRequestCommentsPagedResponse>
      listPullRequestCommentsSettings() {
    return listPullRequestCommentsSettings;
  }

  /** Returns the object with the settings used for calls to createPullRequestComment. */
  public UnaryCallSettings<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentSettings() {
    return createPullRequestCommentSettings;
  }

  /** Returns the object with the settings used for calls to createPullRequestComment. */
  public OperationCallSettings<
          CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      createPullRequestCommentOperationSettings() {
    return createPullRequestCommentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePullRequestComment. */
  public UnaryCallSettings<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentSettings() {
    return updatePullRequestCommentSettings;
  }

  /** Returns the object with the settings used for calls to updatePullRequestComment. */
  public OperationCallSettings<
          UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      updatePullRequestCommentOperationSettings() {
    return updatePullRequestCommentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePullRequestComment. */
  public UnaryCallSettings<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentSettings() {
    return deletePullRequestCommentSettings;
  }

  /** Returns the object with the settings used for calls to deletePullRequestComment. */
  public OperationCallSettings<DeletePullRequestCommentRequest, Empty, OperationMetadata>
      deletePullRequestCommentOperationSettings() {
    return deletePullRequestCommentOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchCreatePullRequestComments. */
  public UnaryCallSettings<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsSettings() {
    return batchCreatePullRequestCommentsSettings;
  }

  /** Returns the object with the settings used for calls to batchCreatePullRequestComments. */
  public OperationCallSettings<
          BatchCreatePullRequestCommentsRequest,
          BatchCreatePullRequestCommentsResponse,
          OperationMetadata>
      batchCreatePullRequestCommentsOperationSettings() {
    return batchCreatePullRequestCommentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to resolvePullRequestComments. */
  public UnaryCallSettings<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsSettings() {
    return resolvePullRequestCommentsSettings;
  }

  /** Returns the object with the settings used for calls to resolvePullRequestComments. */
  public OperationCallSettings<
          ResolvePullRequestCommentsRequest, ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsOperationSettings() {
    return resolvePullRequestCommentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to unresolvePullRequestComments. */
  public UnaryCallSettings<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsSettings() {
    return unresolvePullRequestCommentsSettings;
  }

  /** Returns the object with the settings used for calls to unresolvePullRequestComments. */
  public OperationCallSettings<
          UnresolvePullRequestCommentsRequest,
          UnresolvePullRequestCommentsResponse,
          OperationMetadata>
      unresolvePullRequestCommentsOperationSettings() {
    return unresolvePullRequestCommentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createIssueComment. */
  public UnaryCallSettings<CreateIssueCommentRequest, Operation> createIssueCommentSettings() {
    return createIssueCommentSettings;
  }

  /** Returns the object with the settings used for calls to createIssueComment. */
  public OperationCallSettings<CreateIssueCommentRequest, IssueComment, OperationMetadata>
      createIssueCommentOperationSettings() {
    return createIssueCommentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIssueComment. */
  public UnaryCallSettings<GetIssueCommentRequest, IssueComment> getIssueCommentSettings() {
    return getIssueCommentSettings;
  }

  /** Returns the object with the settings used for calls to listIssueComments. */
  public PagedCallSettings<
          ListIssueCommentsRequest, ListIssueCommentsResponse, ListIssueCommentsPagedResponse>
      listIssueCommentsSettings() {
    return listIssueCommentsSettings;
  }

  /** Returns the object with the settings used for calls to updateIssueComment. */
  public UnaryCallSettings<UpdateIssueCommentRequest, Operation> updateIssueCommentSettings() {
    return updateIssueCommentSettings;
  }

  /** Returns the object with the settings used for calls to updateIssueComment. */
  public OperationCallSettings<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
      updateIssueCommentOperationSettings() {
    return updateIssueCommentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteIssueComment. */
  public UnaryCallSettings<DeleteIssueCommentRequest, Operation> deleteIssueCommentSettings() {
    return deleteIssueCommentSettings;
  }

  /** Returns the object with the settings used for calls to deleteIssueComment. */
  public OperationCallSettings<DeleteIssueCommentRequest, Empty, OperationMetadata>
      deleteIssueCommentOperationSettings() {
    return deleteIssueCommentOperationSettings;
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

  public SecureSourceManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecureSourceManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSecureSourceManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "securesourcemanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "securesourcemanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "securesourcemanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SecureSourceManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SecureSourceManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecureSourceManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SecureSourceManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    createInstanceSettings = settingsBuilder.createInstanceSettings().build();
    createInstanceOperationSettings = settingsBuilder.createInstanceOperationSettings().build();
    deleteInstanceSettings = settingsBuilder.deleteInstanceSettings().build();
    deleteInstanceOperationSettings = settingsBuilder.deleteInstanceOperationSettings().build();
    listRepositoriesSettings = settingsBuilder.listRepositoriesSettings().build();
    getRepositorySettings = settingsBuilder.getRepositorySettings().build();
    createRepositorySettings = settingsBuilder.createRepositorySettings().build();
    createRepositoryOperationSettings = settingsBuilder.createRepositoryOperationSettings().build();
    updateRepositorySettings = settingsBuilder.updateRepositorySettings().build();
    updateRepositoryOperationSettings = settingsBuilder.updateRepositoryOperationSettings().build();
    deleteRepositorySettings = settingsBuilder.deleteRepositorySettings().build();
    deleteRepositoryOperationSettings = settingsBuilder.deleteRepositoryOperationSettings().build();
    listHooksSettings = settingsBuilder.listHooksSettings().build();
    getHookSettings = settingsBuilder.getHookSettings().build();
    createHookSettings = settingsBuilder.createHookSettings().build();
    createHookOperationSettings = settingsBuilder.createHookOperationSettings().build();
    updateHookSettings = settingsBuilder.updateHookSettings().build();
    updateHookOperationSettings = settingsBuilder.updateHookOperationSettings().build();
    deleteHookSettings = settingsBuilder.deleteHookSettings().build();
    deleteHookOperationSettings = settingsBuilder.deleteHookOperationSettings().build();
    getIamPolicyRepoSettings = settingsBuilder.getIamPolicyRepoSettings().build();
    setIamPolicyRepoSettings = settingsBuilder.setIamPolicyRepoSettings().build();
    testIamPermissionsRepoSettings = settingsBuilder.testIamPermissionsRepoSettings().build();
    createBranchRuleSettings = settingsBuilder.createBranchRuleSettings().build();
    createBranchRuleOperationSettings = settingsBuilder.createBranchRuleOperationSettings().build();
    listBranchRulesSettings = settingsBuilder.listBranchRulesSettings().build();
    getBranchRuleSettings = settingsBuilder.getBranchRuleSettings().build();
    updateBranchRuleSettings = settingsBuilder.updateBranchRuleSettings().build();
    updateBranchRuleOperationSettings = settingsBuilder.updateBranchRuleOperationSettings().build();
    deleteBranchRuleSettings = settingsBuilder.deleteBranchRuleSettings().build();
    deleteBranchRuleOperationSettings = settingsBuilder.deleteBranchRuleOperationSettings().build();
    createPullRequestSettings = settingsBuilder.createPullRequestSettings().build();
    createPullRequestOperationSettings =
        settingsBuilder.createPullRequestOperationSettings().build();
    getPullRequestSettings = settingsBuilder.getPullRequestSettings().build();
    listPullRequestsSettings = settingsBuilder.listPullRequestsSettings().build();
    updatePullRequestSettings = settingsBuilder.updatePullRequestSettings().build();
    updatePullRequestOperationSettings =
        settingsBuilder.updatePullRequestOperationSettings().build();
    mergePullRequestSettings = settingsBuilder.mergePullRequestSettings().build();
    mergePullRequestOperationSettings = settingsBuilder.mergePullRequestOperationSettings().build();
    openPullRequestSettings = settingsBuilder.openPullRequestSettings().build();
    openPullRequestOperationSettings = settingsBuilder.openPullRequestOperationSettings().build();
    closePullRequestSettings = settingsBuilder.closePullRequestSettings().build();
    closePullRequestOperationSettings = settingsBuilder.closePullRequestOperationSettings().build();
    listPullRequestFileDiffsSettings = settingsBuilder.listPullRequestFileDiffsSettings().build();
    fetchTreeSettings = settingsBuilder.fetchTreeSettings().build();
    fetchBlobSettings = settingsBuilder.fetchBlobSettings().build();
    createIssueSettings = settingsBuilder.createIssueSettings().build();
    createIssueOperationSettings = settingsBuilder.createIssueOperationSettings().build();
    getIssueSettings = settingsBuilder.getIssueSettings().build();
    listIssuesSettings = settingsBuilder.listIssuesSettings().build();
    updateIssueSettings = settingsBuilder.updateIssueSettings().build();
    updateIssueOperationSettings = settingsBuilder.updateIssueOperationSettings().build();
    deleteIssueSettings = settingsBuilder.deleteIssueSettings().build();
    deleteIssueOperationSettings = settingsBuilder.deleteIssueOperationSettings().build();
    openIssueSettings = settingsBuilder.openIssueSettings().build();
    openIssueOperationSettings = settingsBuilder.openIssueOperationSettings().build();
    closeIssueSettings = settingsBuilder.closeIssueSettings().build();
    closeIssueOperationSettings = settingsBuilder.closeIssueOperationSettings().build();
    getPullRequestCommentSettings = settingsBuilder.getPullRequestCommentSettings().build();
    listPullRequestCommentsSettings = settingsBuilder.listPullRequestCommentsSettings().build();
    createPullRequestCommentSettings = settingsBuilder.createPullRequestCommentSettings().build();
    createPullRequestCommentOperationSettings =
        settingsBuilder.createPullRequestCommentOperationSettings().build();
    updatePullRequestCommentSettings = settingsBuilder.updatePullRequestCommentSettings().build();
    updatePullRequestCommentOperationSettings =
        settingsBuilder.updatePullRequestCommentOperationSettings().build();
    deletePullRequestCommentSettings = settingsBuilder.deletePullRequestCommentSettings().build();
    deletePullRequestCommentOperationSettings =
        settingsBuilder.deletePullRequestCommentOperationSettings().build();
    batchCreatePullRequestCommentsSettings =
        settingsBuilder.batchCreatePullRequestCommentsSettings().build();
    batchCreatePullRequestCommentsOperationSettings =
        settingsBuilder.batchCreatePullRequestCommentsOperationSettings().build();
    resolvePullRequestCommentsSettings =
        settingsBuilder.resolvePullRequestCommentsSettings().build();
    resolvePullRequestCommentsOperationSettings =
        settingsBuilder.resolvePullRequestCommentsOperationSettings().build();
    unresolvePullRequestCommentsSettings =
        settingsBuilder.unresolvePullRequestCommentsSettings().build();
    unresolvePullRequestCommentsOperationSettings =
        settingsBuilder.unresolvePullRequestCommentsOperationSettings().build();
    createIssueCommentSettings = settingsBuilder.createIssueCommentSettings().build();
    createIssueCommentOperationSettings =
        settingsBuilder.createIssueCommentOperationSettings().build();
    getIssueCommentSettings = settingsBuilder.getIssueCommentSettings().build();
    listIssueCommentsSettings = settingsBuilder.listIssueCommentsSettings().build();
    updateIssueCommentSettings = settingsBuilder.updateIssueCommentSettings().build();
    updateIssueCommentOperationSettings =
        settingsBuilder.updateIssueCommentOperationSettings().build();
    deleteIssueCommentSettings = settingsBuilder.deleteIssueCommentSettings().build();
    deleteIssueCommentOperationSettings =
        settingsBuilder.deleteIssueCommentOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for SecureSourceManagerStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SecureSourceManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<CreateInstanceRequest, Operation>
        createInstanceSettings;
    private final OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Operation>
        deleteInstanceSettings;
    private final OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings;
    private final PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings;
    private final UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings;
    private final UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings;
    private final OperationCallSettings.Builder<
            CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings;
    private final UnaryCallSettings.Builder<UpdateRepositoryRequest, Operation>
        updateRepositorySettings;
    private final OperationCallSettings.Builder<
            UpdateRepositoryRequest, Repository, OperationMetadata>
        updateRepositoryOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings;
    private final OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings;
    private final PagedCallSettings.Builder<
            ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>
        listHooksSettings;
    private final UnaryCallSettings.Builder<GetHookRequest, Hook> getHookSettings;
    private final UnaryCallSettings.Builder<CreateHookRequest, Operation> createHookSettings;
    private final OperationCallSettings.Builder<CreateHookRequest, Hook, OperationMetadata>
        createHookOperationSettings;
    private final UnaryCallSettings.Builder<UpdateHookRequest, Operation> updateHookSettings;
    private final OperationCallSettings.Builder<UpdateHookRequest, Hook, OperationMetadata>
        updateHookOperationSettings;
    private final UnaryCallSettings.Builder<DeleteHookRequest, Operation> deleteHookSettings;
    private final OperationCallSettings.Builder<DeleteHookRequest, Empty, OperationMetadata>
        deleteHookOperationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicyRepoSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicyRepoSettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsRepoSettings;
    private final UnaryCallSettings.Builder<CreateBranchRuleRequest, Operation>
        createBranchRuleSettings;
    private final OperationCallSettings.Builder<
            CreateBranchRuleRequest, BranchRule, OperationMetadata>
        createBranchRuleOperationSettings;
    private final PagedCallSettings.Builder<
            ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>
        listBranchRulesSettings;
    private final UnaryCallSettings.Builder<GetBranchRuleRequest, BranchRule> getBranchRuleSettings;
    private final UnaryCallSettings.Builder<UpdateBranchRuleRequest, Operation>
        updateBranchRuleSettings;
    private final OperationCallSettings.Builder<
            UpdateBranchRuleRequest, BranchRule, OperationMetadata>
        updateBranchRuleOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBranchRuleRequest, Operation>
        deleteBranchRuleSettings;
    private final OperationCallSettings.Builder<DeleteBranchRuleRequest, Empty, OperationMetadata>
        deleteBranchRuleOperationSettings;
    private final UnaryCallSettings.Builder<CreatePullRequestRequest, Operation>
        createPullRequestSettings;
    private final OperationCallSettings.Builder<
            CreatePullRequestRequest, PullRequest, OperationMetadata>
        createPullRequestOperationSettings;
    private final UnaryCallSettings.Builder<GetPullRequestRequest, PullRequest>
        getPullRequestSettings;
    private final PagedCallSettings.Builder<
            ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>
        listPullRequestsSettings;
    private final UnaryCallSettings.Builder<UpdatePullRequestRequest, Operation>
        updatePullRequestSettings;
    private final OperationCallSettings.Builder<
            UpdatePullRequestRequest, PullRequest, OperationMetadata>
        updatePullRequestOperationSettings;
    private final UnaryCallSettings.Builder<MergePullRequestRequest, Operation>
        mergePullRequestSettings;
    private final OperationCallSettings.Builder<
            MergePullRequestRequest, PullRequest, OperationMetadata>
        mergePullRequestOperationSettings;
    private final UnaryCallSettings.Builder<OpenPullRequestRequest, Operation>
        openPullRequestSettings;
    private final OperationCallSettings.Builder<
            OpenPullRequestRequest, PullRequest, OperationMetadata>
        openPullRequestOperationSettings;
    private final UnaryCallSettings.Builder<ClosePullRequestRequest, Operation>
        closePullRequestSettings;
    private final OperationCallSettings.Builder<
            ClosePullRequestRequest, PullRequest, OperationMetadata>
        closePullRequestOperationSettings;
    private final PagedCallSettings.Builder<
            ListPullRequestFileDiffsRequest,
            ListPullRequestFileDiffsResponse,
            ListPullRequestFileDiffsPagedResponse>
        listPullRequestFileDiffsSettings;
    private final PagedCallSettings.Builder<
            FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>
        fetchTreeSettings;
    private final UnaryCallSettings.Builder<FetchBlobRequest, FetchBlobResponse> fetchBlobSettings;
    private final UnaryCallSettings.Builder<CreateIssueRequest, Operation> createIssueSettings;
    private final OperationCallSettings.Builder<CreateIssueRequest, Issue, OperationMetadata>
        createIssueOperationSettings;
    private final UnaryCallSettings.Builder<GetIssueRequest, Issue> getIssueSettings;
    private final PagedCallSettings.Builder<
            ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>
        listIssuesSettings;
    private final UnaryCallSettings.Builder<UpdateIssueRequest, Operation> updateIssueSettings;
    private final OperationCallSettings.Builder<UpdateIssueRequest, Issue, OperationMetadata>
        updateIssueOperationSettings;
    private final UnaryCallSettings.Builder<DeleteIssueRequest, Operation> deleteIssueSettings;
    private final OperationCallSettings.Builder<DeleteIssueRequest, Empty, OperationMetadata>
        deleteIssueOperationSettings;
    private final UnaryCallSettings.Builder<OpenIssueRequest, Operation> openIssueSettings;
    private final OperationCallSettings.Builder<OpenIssueRequest, Issue, OperationMetadata>
        openIssueOperationSettings;
    private final UnaryCallSettings.Builder<CloseIssueRequest, Operation> closeIssueSettings;
    private final OperationCallSettings.Builder<CloseIssueRequest, Issue, OperationMetadata>
        closeIssueOperationSettings;
    private final UnaryCallSettings.Builder<GetPullRequestCommentRequest, PullRequestComment>
        getPullRequestCommentSettings;
    private final PagedCallSettings.Builder<
            ListPullRequestCommentsRequest,
            ListPullRequestCommentsResponse,
            ListPullRequestCommentsPagedResponse>
        listPullRequestCommentsSettings;
    private final UnaryCallSettings.Builder<CreatePullRequestCommentRequest, Operation>
        createPullRequestCommentSettings;
    private final OperationCallSettings.Builder<
            CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
        createPullRequestCommentOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePullRequestCommentRequest, Operation>
        updatePullRequestCommentSettings;
    private final OperationCallSettings.Builder<
            UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
        updatePullRequestCommentOperationSettings;
    private final UnaryCallSettings.Builder<DeletePullRequestCommentRequest, Operation>
        deletePullRequestCommentSettings;
    private final OperationCallSettings.Builder<
            DeletePullRequestCommentRequest, Empty, OperationMetadata>
        deletePullRequestCommentOperationSettings;
    private final UnaryCallSettings.Builder<BatchCreatePullRequestCommentsRequest, Operation>
        batchCreatePullRequestCommentsSettings;
    private final OperationCallSettings.Builder<
            BatchCreatePullRequestCommentsRequest,
            BatchCreatePullRequestCommentsResponse,
            OperationMetadata>
        batchCreatePullRequestCommentsOperationSettings;
    private final UnaryCallSettings.Builder<ResolvePullRequestCommentsRequest, Operation>
        resolvePullRequestCommentsSettings;
    private final OperationCallSettings.Builder<
            ResolvePullRequestCommentsRequest,
            ResolvePullRequestCommentsResponse,
            OperationMetadata>
        resolvePullRequestCommentsOperationSettings;
    private final UnaryCallSettings.Builder<UnresolvePullRequestCommentsRequest, Operation>
        unresolvePullRequestCommentsSettings;
    private final OperationCallSettings.Builder<
            UnresolvePullRequestCommentsRequest,
            UnresolvePullRequestCommentsResponse,
            OperationMetadata>
        unresolvePullRequestCommentsOperationSettings;
    private final UnaryCallSettings.Builder<CreateIssueCommentRequest, Operation>
        createIssueCommentSettings;
    private final OperationCallSettings.Builder<
            CreateIssueCommentRequest, IssueComment, OperationMetadata>
        createIssueCommentOperationSettings;
    private final UnaryCallSettings.Builder<GetIssueCommentRequest, IssueComment>
        getIssueCommentSettings;
    private final PagedCallSettings.Builder<
            ListIssueCommentsRequest, ListIssueCommentsResponse, ListIssueCommentsPagedResponse>
        listIssueCommentsSettings;
    private final UnaryCallSettings.Builder<UpdateIssueCommentRequest, Operation>
        updateIssueCommentSettings;
    private final OperationCallSettings.Builder<
            UpdateIssueCommentRequest, IssueComment, OperationMetadata>
        updateIssueCommentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteIssueCommentRequest, Operation>
        deleteIssueCommentSettings;
    private final OperationCallSettings.Builder<DeleteIssueCommentRequest, Empty, OperationMetadata>
        deleteIssueCommentOperationSettings;
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
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceOperationSettings = OperationCallSettings.newBuilder();
      deleteInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInstanceOperationSettings = OperationCallSettings.newBuilder();
      listRepositoriesSettings = PagedCallSettings.newBuilder(LIST_REPOSITORIES_PAGE_STR_FACT);
      getRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRepositoryOperationSettings = OperationCallSettings.newBuilder();
      updateRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRepositoryOperationSettings = OperationCallSettings.newBuilder();
      deleteRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRepositoryOperationSettings = OperationCallSettings.newBuilder();
      listHooksSettings = PagedCallSettings.newBuilder(LIST_HOOKS_PAGE_STR_FACT);
      getHookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHookOperationSettings = OperationCallSettings.newBuilder();
      updateHookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateHookOperationSettings = OperationCallSettings.newBuilder();
      deleteHookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHookOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicyRepoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicyRepoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsRepoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBranchRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBranchRuleOperationSettings = OperationCallSettings.newBuilder();
      listBranchRulesSettings = PagedCallSettings.newBuilder(LIST_BRANCH_RULES_PAGE_STR_FACT);
      getBranchRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBranchRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBranchRuleOperationSettings = OperationCallSettings.newBuilder();
      deleteBranchRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBranchRuleOperationSettings = OperationCallSettings.newBuilder();
      createPullRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPullRequestOperationSettings = OperationCallSettings.newBuilder();
      getPullRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPullRequestsSettings = PagedCallSettings.newBuilder(LIST_PULL_REQUESTS_PAGE_STR_FACT);
      updatePullRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePullRequestOperationSettings = OperationCallSettings.newBuilder();
      mergePullRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      mergePullRequestOperationSettings = OperationCallSettings.newBuilder();
      openPullRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      openPullRequestOperationSettings = OperationCallSettings.newBuilder();
      closePullRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      closePullRequestOperationSettings = OperationCallSettings.newBuilder();
      listPullRequestFileDiffsSettings =
          PagedCallSettings.newBuilder(LIST_PULL_REQUEST_FILE_DIFFS_PAGE_STR_FACT);
      fetchTreeSettings = PagedCallSettings.newBuilder(FETCH_TREE_PAGE_STR_FACT);
      fetchBlobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIssueOperationSettings = OperationCallSettings.newBuilder();
      getIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIssuesSettings = PagedCallSettings.newBuilder(LIST_ISSUES_PAGE_STR_FACT);
      updateIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIssueOperationSettings = OperationCallSettings.newBuilder();
      deleteIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIssueOperationSettings = OperationCallSettings.newBuilder();
      openIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      openIssueOperationSettings = OperationCallSettings.newBuilder();
      closeIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      closeIssueOperationSettings = OperationCallSettings.newBuilder();
      getPullRequestCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPullRequestCommentsSettings =
          PagedCallSettings.newBuilder(LIST_PULL_REQUEST_COMMENTS_PAGE_STR_FACT);
      createPullRequestCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPullRequestCommentOperationSettings = OperationCallSettings.newBuilder();
      updatePullRequestCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePullRequestCommentOperationSettings = OperationCallSettings.newBuilder();
      deletePullRequestCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePullRequestCommentOperationSettings = OperationCallSettings.newBuilder();
      batchCreatePullRequestCommentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreatePullRequestCommentsOperationSettings = OperationCallSettings.newBuilder();
      resolvePullRequestCommentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resolvePullRequestCommentsOperationSettings = OperationCallSettings.newBuilder();
      unresolvePullRequestCommentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      unresolvePullRequestCommentsOperationSettings = OperationCallSettings.newBuilder();
      createIssueCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIssueCommentOperationSettings = OperationCallSettings.newBuilder();
      getIssueCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIssueCommentsSettings = PagedCallSettings.newBuilder(LIST_ISSUE_COMMENTS_PAGE_STR_FACT);
      updateIssueCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIssueCommentOperationSettings = OperationCallSettings.newBuilder();
      deleteIssueCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIssueCommentOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              deleteInstanceSettings,
              listRepositoriesSettings,
              getRepositorySettings,
              createRepositorySettings,
              updateRepositorySettings,
              deleteRepositorySettings,
              listHooksSettings,
              getHookSettings,
              createHookSettings,
              updateHookSettings,
              deleteHookSettings,
              getIamPolicyRepoSettings,
              setIamPolicyRepoSettings,
              testIamPermissionsRepoSettings,
              createBranchRuleSettings,
              listBranchRulesSettings,
              getBranchRuleSettings,
              updateBranchRuleSettings,
              deleteBranchRuleSettings,
              createPullRequestSettings,
              getPullRequestSettings,
              listPullRequestsSettings,
              updatePullRequestSettings,
              mergePullRequestSettings,
              openPullRequestSettings,
              closePullRequestSettings,
              listPullRequestFileDiffsSettings,
              fetchTreeSettings,
              fetchBlobSettings,
              createIssueSettings,
              getIssueSettings,
              listIssuesSettings,
              updateIssueSettings,
              deleteIssueSettings,
              openIssueSettings,
              closeIssueSettings,
              getPullRequestCommentSettings,
              listPullRequestCommentsSettings,
              createPullRequestCommentSettings,
              updatePullRequestCommentSettings,
              deletePullRequestCommentSettings,
              batchCreatePullRequestCommentsSettings,
              resolvePullRequestCommentsSettings,
              unresolvePullRequestCommentsSettings,
              createIssueCommentSettings,
              getIssueCommentSettings,
              listIssueCommentsSettings,
              updateIssueCommentSettings,
              deleteIssueCommentSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(SecureSourceManagerStubSettings settings) {
      super(settings);

      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      createInstanceSettings = settings.createInstanceSettings.toBuilder();
      createInstanceOperationSettings = settings.createInstanceOperationSettings.toBuilder();
      deleteInstanceSettings = settings.deleteInstanceSettings.toBuilder();
      deleteInstanceOperationSettings = settings.deleteInstanceOperationSettings.toBuilder();
      listRepositoriesSettings = settings.listRepositoriesSettings.toBuilder();
      getRepositorySettings = settings.getRepositorySettings.toBuilder();
      createRepositorySettings = settings.createRepositorySettings.toBuilder();
      createRepositoryOperationSettings = settings.createRepositoryOperationSettings.toBuilder();
      updateRepositorySettings = settings.updateRepositorySettings.toBuilder();
      updateRepositoryOperationSettings = settings.updateRepositoryOperationSettings.toBuilder();
      deleteRepositorySettings = settings.deleteRepositorySettings.toBuilder();
      deleteRepositoryOperationSettings = settings.deleteRepositoryOperationSettings.toBuilder();
      listHooksSettings = settings.listHooksSettings.toBuilder();
      getHookSettings = settings.getHookSettings.toBuilder();
      createHookSettings = settings.createHookSettings.toBuilder();
      createHookOperationSettings = settings.createHookOperationSettings.toBuilder();
      updateHookSettings = settings.updateHookSettings.toBuilder();
      updateHookOperationSettings = settings.updateHookOperationSettings.toBuilder();
      deleteHookSettings = settings.deleteHookSettings.toBuilder();
      deleteHookOperationSettings = settings.deleteHookOperationSettings.toBuilder();
      getIamPolicyRepoSettings = settings.getIamPolicyRepoSettings.toBuilder();
      setIamPolicyRepoSettings = settings.setIamPolicyRepoSettings.toBuilder();
      testIamPermissionsRepoSettings = settings.testIamPermissionsRepoSettings.toBuilder();
      createBranchRuleSettings = settings.createBranchRuleSettings.toBuilder();
      createBranchRuleOperationSettings = settings.createBranchRuleOperationSettings.toBuilder();
      listBranchRulesSettings = settings.listBranchRulesSettings.toBuilder();
      getBranchRuleSettings = settings.getBranchRuleSettings.toBuilder();
      updateBranchRuleSettings = settings.updateBranchRuleSettings.toBuilder();
      updateBranchRuleOperationSettings = settings.updateBranchRuleOperationSettings.toBuilder();
      deleteBranchRuleSettings = settings.deleteBranchRuleSettings.toBuilder();
      deleteBranchRuleOperationSettings = settings.deleteBranchRuleOperationSettings.toBuilder();
      createPullRequestSettings = settings.createPullRequestSettings.toBuilder();
      createPullRequestOperationSettings = settings.createPullRequestOperationSettings.toBuilder();
      getPullRequestSettings = settings.getPullRequestSettings.toBuilder();
      listPullRequestsSettings = settings.listPullRequestsSettings.toBuilder();
      updatePullRequestSettings = settings.updatePullRequestSettings.toBuilder();
      updatePullRequestOperationSettings = settings.updatePullRequestOperationSettings.toBuilder();
      mergePullRequestSettings = settings.mergePullRequestSettings.toBuilder();
      mergePullRequestOperationSettings = settings.mergePullRequestOperationSettings.toBuilder();
      openPullRequestSettings = settings.openPullRequestSettings.toBuilder();
      openPullRequestOperationSettings = settings.openPullRequestOperationSettings.toBuilder();
      closePullRequestSettings = settings.closePullRequestSettings.toBuilder();
      closePullRequestOperationSettings = settings.closePullRequestOperationSettings.toBuilder();
      listPullRequestFileDiffsSettings = settings.listPullRequestFileDiffsSettings.toBuilder();
      fetchTreeSettings = settings.fetchTreeSettings.toBuilder();
      fetchBlobSettings = settings.fetchBlobSettings.toBuilder();
      createIssueSettings = settings.createIssueSettings.toBuilder();
      createIssueOperationSettings = settings.createIssueOperationSettings.toBuilder();
      getIssueSettings = settings.getIssueSettings.toBuilder();
      listIssuesSettings = settings.listIssuesSettings.toBuilder();
      updateIssueSettings = settings.updateIssueSettings.toBuilder();
      updateIssueOperationSettings = settings.updateIssueOperationSettings.toBuilder();
      deleteIssueSettings = settings.deleteIssueSettings.toBuilder();
      deleteIssueOperationSettings = settings.deleteIssueOperationSettings.toBuilder();
      openIssueSettings = settings.openIssueSettings.toBuilder();
      openIssueOperationSettings = settings.openIssueOperationSettings.toBuilder();
      closeIssueSettings = settings.closeIssueSettings.toBuilder();
      closeIssueOperationSettings = settings.closeIssueOperationSettings.toBuilder();
      getPullRequestCommentSettings = settings.getPullRequestCommentSettings.toBuilder();
      listPullRequestCommentsSettings = settings.listPullRequestCommentsSettings.toBuilder();
      createPullRequestCommentSettings = settings.createPullRequestCommentSettings.toBuilder();
      createPullRequestCommentOperationSettings =
          settings.createPullRequestCommentOperationSettings.toBuilder();
      updatePullRequestCommentSettings = settings.updatePullRequestCommentSettings.toBuilder();
      updatePullRequestCommentOperationSettings =
          settings.updatePullRequestCommentOperationSettings.toBuilder();
      deletePullRequestCommentSettings = settings.deletePullRequestCommentSettings.toBuilder();
      deletePullRequestCommentOperationSettings =
          settings.deletePullRequestCommentOperationSettings.toBuilder();
      batchCreatePullRequestCommentsSettings =
          settings.batchCreatePullRequestCommentsSettings.toBuilder();
      batchCreatePullRequestCommentsOperationSettings =
          settings.batchCreatePullRequestCommentsOperationSettings.toBuilder();
      resolvePullRequestCommentsSettings = settings.resolvePullRequestCommentsSettings.toBuilder();
      resolvePullRequestCommentsOperationSettings =
          settings.resolvePullRequestCommentsOperationSettings.toBuilder();
      unresolvePullRequestCommentsSettings =
          settings.unresolvePullRequestCommentsSettings.toBuilder();
      unresolvePullRequestCommentsOperationSettings =
          settings.unresolvePullRequestCommentsOperationSettings.toBuilder();
      createIssueCommentSettings = settings.createIssueCommentSettings.toBuilder();
      createIssueCommentOperationSettings =
          settings.createIssueCommentOperationSettings.toBuilder();
      getIssueCommentSettings = settings.getIssueCommentSettings.toBuilder();
      listIssueCommentsSettings = settings.listIssueCommentsSettings.toBuilder();
      updateIssueCommentSettings = settings.updateIssueCommentSettings.toBuilder();
      updateIssueCommentOperationSettings =
          settings.updateIssueCommentOperationSettings.toBuilder();
      deleteIssueCommentSettings = settings.deleteIssueCommentSettings.toBuilder();
      deleteIssueCommentOperationSettings =
          settings.deleteIssueCommentOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              deleteInstanceSettings,
              listRepositoriesSettings,
              getRepositorySettings,
              createRepositorySettings,
              updateRepositorySettings,
              deleteRepositorySettings,
              listHooksSettings,
              getHookSettings,
              createHookSettings,
              updateHookSettings,
              deleteHookSettings,
              getIamPolicyRepoSettings,
              setIamPolicyRepoSettings,
              testIamPermissionsRepoSettings,
              createBranchRuleSettings,
              listBranchRulesSettings,
              getBranchRuleSettings,
              updateBranchRuleSettings,
              deleteBranchRuleSettings,
              createPullRequestSettings,
              getPullRequestSettings,
              listPullRequestsSettings,
              updatePullRequestSettings,
              mergePullRequestSettings,
              openPullRequestSettings,
              closePullRequestSettings,
              listPullRequestFileDiffsSettings,
              fetchTreeSettings,
              fetchBlobSettings,
              createIssueSettings,
              getIssueSettings,
              listIssuesSettings,
              updateIssueSettings,
              deleteIssueSettings,
              openIssueSettings,
              closeIssueSettings,
              getPullRequestCommentSettings,
              listPullRequestCommentsSettings,
              createPullRequestCommentSettings,
              updatePullRequestCommentSettings,
              deletePullRequestCommentSettings,
              batchCreatePullRequestCommentsSettings,
              resolvePullRequestCommentsSettings,
              unresolvePullRequestCommentsSettings,
              createIssueCommentSettings,
              getIssueCommentSettings,
              listIssueCommentsSettings,
              updateIssueCommentSettings,
              deleteIssueCommentSettings,
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
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listRepositoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listHooksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getHookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createHookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateHookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteHookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicyRepoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicyRepoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsRepoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBranchRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBranchRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBranchRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateBranchRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBranchRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createPullRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPullRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPullRequestsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePullRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .mergePullRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .openPullRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .closePullRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPullRequestFileDiffsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchTreeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchBlobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listIssuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .openIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .closeIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPullRequestCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPullRequestCommentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createPullRequestCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePullRequestCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePullRequestCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreatePullRequestCommentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .resolvePullRequestCommentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .unresolvePullRequestCommentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createIssueCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIssueCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listIssueCommentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateIssueCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteIssueCommentSettings()
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
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
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
          .deleteInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createRepositoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRepositoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Repository.class))
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
          .updateRepositoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRepositoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Repository.class))
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
          .deleteRepositoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRepositoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createHookOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateHookRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Hook.class))
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
          .updateHookOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateHookRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Hook.class))
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
          .deleteHookOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteHookRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createBranchRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBranchRuleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BranchRule.class))
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
          .updateBranchRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBranchRuleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BranchRule.class))
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
          .deleteBranchRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBranchRuleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createPullRequestOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePullRequestRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PullRequest.class))
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
          .updatePullRequestOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePullRequestRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PullRequest.class))
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
          .mergePullRequestOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<MergePullRequestRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PullRequest.class))
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
          .openPullRequestOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<OpenPullRequestRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PullRequest.class))
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
          .closePullRequestOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ClosePullRequestRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PullRequest.class))
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
          .createIssueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateIssueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Issue.class))
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
          .updateIssueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateIssueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Issue.class))
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
          .deleteIssueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteIssueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .openIssueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<OpenIssueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Issue.class))
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
          .closeIssueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CloseIssueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Issue.class))
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
          .createPullRequestCommentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePullRequestCommentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PullRequestComment.class))
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
          .updatePullRequestCommentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePullRequestCommentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PullRequestComment.class))
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
          .deletePullRequestCommentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePullRequestCommentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .batchCreatePullRequestCommentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchCreatePullRequestCommentsRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchCreatePullRequestCommentsResponse.class))
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
          .resolvePullRequestCommentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResolvePullRequestCommentsRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ResolvePullRequestCommentsResponse.class))
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
          .unresolvePullRequestCommentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UnresolvePullRequestCommentsRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  UnresolvePullRequestCommentsResponse.class))
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
          .createIssueCommentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateIssueCommentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IssueComment.class))
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
          .updateIssueCommentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateIssueCommentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IssueComment.class))
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
          .deleteIssueCommentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteIssueCommentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return createInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return createInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return deleteInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return deleteInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRepositories. */
    public PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings() {
      return listRepositoriesSettings;
    }

    /** Returns the builder for the settings used for calls to getRepository. */
    public UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings() {
      return getRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings() {
      return createRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public OperationCallSettings.Builder<CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings() {
      return createRepositoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public UnaryCallSettings.Builder<UpdateRepositoryRequest, Operation>
        updateRepositorySettings() {
      return updateRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public OperationCallSettings.Builder<UpdateRepositoryRequest, Repository, OperationMetadata>
        updateRepositoryOperationSettings() {
      return updateRepositoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings() {
      return deleteRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings() {
      return deleteRepositoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listHooks. */
    public PagedCallSettings.Builder<ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>
        listHooksSettings() {
      return listHooksSettings;
    }

    /** Returns the builder for the settings used for calls to getHook. */
    public UnaryCallSettings.Builder<GetHookRequest, Hook> getHookSettings() {
      return getHookSettings;
    }

    /** Returns the builder for the settings used for calls to createHook. */
    public UnaryCallSettings.Builder<CreateHookRequest, Operation> createHookSettings() {
      return createHookSettings;
    }

    /** Returns the builder for the settings used for calls to createHook. */
    public OperationCallSettings.Builder<CreateHookRequest, Hook, OperationMetadata>
        createHookOperationSettings() {
      return createHookOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateHook. */
    public UnaryCallSettings.Builder<UpdateHookRequest, Operation> updateHookSettings() {
      return updateHookSettings;
    }

    /** Returns the builder for the settings used for calls to updateHook. */
    public OperationCallSettings.Builder<UpdateHookRequest, Hook, OperationMetadata>
        updateHookOperationSettings() {
      return updateHookOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHook. */
    public UnaryCallSettings.Builder<DeleteHookRequest, Operation> deleteHookSettings() {
      return deleteHookSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHook. */
    public OperationCallSettings.Builder<DeleteHookRequest, Empty, OperationMetadata>
        deleteHookOperationSettings() {
      return deleteHookOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicyRepo. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicyRepoSettings() {
      return getIamPolicyRepoSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicyRepo. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicyRepoSettings() {
      return setIamPolicyRepoSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsRepo. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsRepoSettings() {
      return testIamPermissionsRepoSettings;
    }

    /** Returns the builder for the settings used for calls to createBranchRule. */
    public UnaryCallSettings.Builder<CreateBranchRuleRequest, Operation>
        createBranchRuleSettings() {
      return createBranchRuleSettings;
    }

    /** Returns the builder for the settings used for calls to createBranchRule. */
    public OperationCallSettings.Builder<CreateBranchRuleRequest, BranchRule, OperationMetadata>
        createBranchRuleOperationSettings() {
      return createBranchRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBranchRules. */
    public PagedCallSettings.Builder<
            ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>
        listBranchRulesSettings() {
      return listBranchRulesSettings;
    }

    /** Returns the builder for the settings used for calls to getBranchRule. */
    public UnaryCallSettings.Builder<GetBranchRuleRequest, BranchRule> getBranchRuleSettings() {
      return getBranchRuleSettings;
    }

    /** Returns the builder for the settings used for calls to updateBranchRule. */
    public UnaryCallSettings.Builder<UpdateBranchRuleRequest, Operation>
        updateBranchRuleSettings() {
      return updateBranchRuleSettings;
    }

    /** Returns the builder for the settings used for calls to updateBranchRule. */
    public OperationCallSettings.Builder<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
        updateBranchRuleOperationSettings() {
      return updateBranchRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBranchRule. */
    public UnaryCallSettings.Builder<DeleteBranchRuleRequest, Operation>
        deleteBranchRuleSettings() {
      return deleteBranchRuleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBranchRule. */
    public OperationCallSettings.Builder<DeleteBranchRuleRequest, Empty, OperationMetadata>
        deleteBranchRuleOperationSettings() {
      return deleteBranchRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createPullRequest. */
    public UnaryCallSettings.Builder<CreatePullRequestRequest, Operation>
        createPullRequestSettings() {
      return createPullRequestSettings;
    }

    /** Returns the builder for the settings used for calls to createPullRequest. */
    public OperationCallSettings.Builder<CreatePullRequestRequest, PullRequest, OperationMetadata>
        createPullRequestOperationSettings() {
      return createPullRequestOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPullRequest. */
    public UnaryCallSettings.Builder<GetPullRequestRequest, PullRequest> getPullRequestSettings() {
      return getPullRequestSettings;
    }

    /** Returns the builder for the settings used for calls to listPullRequests. */
    public PagedCallSettings.Builder<
            ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>
        listPullRequestsSettings() {
      return listPullRequestsSettings;
    }

    /** Returns the builder for the settings used for calls to updatePullRequest. */
    public UnaryCallSettings.Builder<UpdatePullRequestRequest, Operation>
        updatePullRequestSettings() {
      return updatePullRequestSettings;
    }

    /** Returns the builder for the settings used for calls to updatePullRequest. */
    public OperationCallSettings.Builder<UpdatePullRequestRequest, PullRequest, OperationMetadata>
        updatePullRequestOperationSettings() {
      return updatePullRequestOperationSettings;
    }

    /** Returns the builder for the settings used for calls to mergePullRequest. */
    public UnaryCallSettings.Builder<MergePullRequestRequest, Operation>
        mergePullRequestSettings() {
      return mergePullRequestSettings;
    }

    /** Returns the builder for the settings used for calls to mergePullRequest. */
    public OperationCallSettings.Builder<MergePullRequestRequest, PullRequest, OperationMetadata>
        mergePullRequestOperationSettings() {
      return mergePullRequestOperationSettings;
    }

    /** Returns the builder for the settings used for calls to openPullRequest. */
    public UnaryCallSettings.Builder<OpenPullRequestRequest, Operation> openPullRequestSettings() {
      return openPullRequestSettings;
    }

    /** Returns the builder for the settings used for calls to openPullRequest. */
    public OperationCallSettings.Builder<OpenPullRequestRequest, PullRequest, OperationMetadata>
        openPullRequestOperationSettings() {
      return openPullRequestOperationSettings;
    }

    /** Returns the builder for the settings used for calls to closePullRequest. */
    public UnaryCallSettings.Builder<ClosePullRequestRequest, Operation>
        closePullRequestSettings() {
      return closePullRequestSettings;
    }

    /** Returns the builder for the settings used for calls to closePullRequest. */
    public OperationCallSettings.Builder<ClosePullRequestRequest, PullRequest, OperationMetadata>
        closePullRequestOperationSettings() {
      return closePullRequestOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPullRequestFileDiffs. */
    public PagedCallSettings.Builder<
            ListPullRequestFileDiffsRequest,
            ListPullRequestFileDiffsResponse,
            ListPullRequestFileDiffsPagedResponse>
        listPullRequestFileDiffsSettings() {
      return listPullRequestFileDiffsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchTree. */
    public PagedCallSettings.Builder<FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>
        fetchTreeSettings() {
      return fetchTreeSettings;
    }

    /** Returns the builder for the settings used for calls to fetchBlob. */
    public UnaryCallSettings.Builder<FetchBlobRequest, FetchBlobResponse> fetchBlobSettings() {
      return fetchBlobSettings;
    }

    /** Returns the builder for the settings used for calls to createIssue. */
    public UnaryCallSettings.Builder<CreateIssueRequest, Operation> createIssueSettings() {
      return createIssueSettings;
    }

    /** Returns the builder for the settings used for calls to createIssue. */
    public OperationCallSettings.Builder<CreateIssueRequest, Issue, OperationMetadata>
        createIssueOperationSettings() {
      return createIssueOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIssue. */
    public UnaryCallSettings.Builder<GetIssueRequest, Issue> getIssueSettings() {
      return getIssueSettings;
    }

    /** Returns the builder for the settings used for calls to listIssues. */
    public PagedCallSettings.Builder<ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>
        listIssuesSettings() {
      return listIssuesSettings;
    }

    /** Returns the builder for the settings used for calls to updateIssue. */
    public UnaryCallSettings.Builder<UpdateIssueRequest, Operation> updateIssueSettings() {
      return updateIssueSettings;
    }

    /** Returns the builder for the settings used for calls to updateIssue. */
    public OperationCallSettings.Builder<UpdateIssueRequest, Issue, OperationMetadata>
        updateIssueOperationSettings() {
      return updateIssueOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIssue. */
    public UnaryCallSettings.Builder<DeleteIssueRequest, Operation> deleteIssueSettings() {
      return deleteIssueSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIssue. */
    public OperationCallSettings.Builder<DeleteIssueRequest, Empty, OperationMetadata>
        deleteIssueOperationSettings() {
      return deleteIssueOperationSettings;
    }

    /** Returns the builder for the settings used for calls to openIssue. */
    public UnaryCallSettings.Builder<OpenIssueRequest, Operation> openIssueSettings() {
      return openIssueSettings;
    }

    /** Returns the builder for the settings used for calls to openIssue. */
    public OperationCallSettings.Builder<OpenIssueRequest, Issue, OperationMetadata>
        openIssueOperationSettings() {
      return openIssueOperationSettings;
    }

    /** Returns the builder for the settings used for calls to closeIssue. */
    public UnaryCallSettings.Builder<CloseIssueRequest, Operation> closeIssueSettings() {
      return closeIssueSettings;
    }

    /** Returns the builder for the settings used for calls to closeIssue. */
    public OperationCallSettings.Builder<CloseIssueRequest, Issue, OperationMetadata>
        closeIssueOperationSettings() {
      return closeIssueOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPullRequestComment. */
    public UnaryCallSettings.Builder<GetPullRequestCommentRequest, PullRequestComment>
        getPullRequestCommentSettings() {
      return getPullRequestCommentSettings;
    }

    /** Returns the builder for the settings used for calls to listPullRequestComments. */
    public PagedCallSettings.Builder<
            ListPullRequestCommentsRequest,
            ListPullRequestCommentsResponse,
            ListPullRequestCommentsPagedResponse>
        listPullRequestCommentsSettings() {
      return listPullRequestCommentsSettings;
    }

    /** Returns the builder for the settings used for calls to createPullRequestComment. */
    public UnaryCallSettings.Builder<CreatePullRequestCommentRequest, Operation>
        createPullRequestCommentSettings() {
      return createPullRequestCommentSettings;
    }

    /** Returns the builder for the settings used for calls to createPullRequestComment. */
    public OperationCallSettings.Builder<
            CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
        createPullRequestCommentOperationSettings() {
      return createPullRequestCommentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePullRequestComment. */
    public UnaryCallSettings.Builder<UpdatePullRequestCommentRequest, Operation>
        updatePullRequestCommentSettings() {
      return updatePullRequestCommentSettings;
    }

    /** Returns the builder for the settings used for calls to updatePullRequestComment. */
    public OperationCallSettings.Builder<
            UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
        updatePullRequestCommentOperationSettings() {
      return updatePullRequestCommentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePullRequestComment. */
    public UnaryCallSettings.Builder<DeletePullRequestCommentRequest, Operation>
        deletePullRequestCommentSettings() {
      return deletePullRequestCommentSettings;
    }

    /** Returns the builder for the settings used for calls to deletePullRequestComment. */
    public OperationCallSettings.Builder<DeletePullRequestCommentRequest, Empty, OperationMetadata>
        deletePullRequestCommentOperationSettings() {
      return deletePullRequestCommentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreatePullRequestComments. */
    public UnaryCallSettings.Builder<BatchCreatePullRequestCommentsRequest, Operation>
        batchCreatePullRequestCommentsSettings() {
      return batchCreatePullRequestCommentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreatePullRequestComments. */
    public OperationCallSettings.Builder<
            BatchCreatePullRequestCommentsRequest,
            BatchCreatePullRequestCommentsResponse,
            OperationMetadata>
        batchCreatePullRequestCommentsOperationSettings() {
      return batchCreatePullRequestCommentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resolvePullRequestComments. */
    public UnaryCallSettings.Builder<ResolvePullRequestCommentsRequest, Operation>
        resolvePullRequestCommentsSettings() {
      return resolvePullRequestCommentsSettings;
    }

    /** Returns the builder for the settings used for calls to resolvePullRequestComments. */
    public OperationCallSettings.Builder<
            ResolvePullRequestCommentsRequest,
            ResolvePullRequestCommentsResponse,
            OperationMetadata>
        resolvePullRequestCommentsOperationSettings() {
      return resolvePullRequestCommentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to unresolvePullRequestComments. */
    public UnaryCallSettings.Builder<UnresolvePullRequestCommentsRequest, Operation>
        unresolvePullRequestCommentsSettings() {
      return unresolvePullRequestCommentsSettings;
    }

    /** Returns the builder for the settings used for calls to unresolvePullRequestComments. */
    public OperationCallSettings.Builder<
            UnresolvePullRequestCommentsRequest,
            UnresolvePullRequestCommentsResponse,
            OperationMetadata>
        unresolvePullRequestCommentsOperationSettings() {
      return unresolvePullRequestCommentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createIssueComment. */
    public UnaryCallSettings.Builder<CreateIssueCommentRequest, Operation>
        createIssueCommentSettings() {
      return createIssueCommentSettings;
    }

    /** Returns the builder for the settings used for calls to createIssueComment. */
    public OperationCallSettings.Builder<CreateIssueCommentRequest, IssueComment, OperationMetadata>
        createIssueCommentOperationSettings() {
      return createIssueCommentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIssueComment. */
    public UnaryCallSettings.Builder<GetIssueCommentRequest, IssueComment>
        getIssueCommentSettings() {
      return getIssueCommentSettings;
    }

    /** Returns the builder for the settings used for calls to listIssueComments. */
    public PagedCallSettings.Builder<
            ListIssueCommentsRequest, ListIssueCommentsResponse, ListIssueCommentsPagedResponse>
        listIssueCommentsSettings() {
      return listIssueCommentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateIssueComment. */
    public UnaryCallSettings.Builder<UpdateIssueCommentRequest, Operation>
        updateIssueCommentSettings() {
      return updateIssueCommentSettings;
    }

    /** Returns the builder for the settings used for calls to updateIssueComment. */
    public OperationCallSettings.Builder<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
        updateIssueCommentOperationSettings() {
      return updateIssueCommentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIssueComment. */
    public UnaryCallSettings.Builder<DeleteIssueCommentRequest, Operation>
        deleteIssueCommentSettings() {
      return deleteIssueCommentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIssueComment. */
    public OperationCallSettings.Builder<DeleteIssueCommentRequest, Empty, OperationMetadata>
        deleteIssueCommentOperationSettings() {
      return deleteIssueCommentOperationSettings;
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
    public SecureSourceManagerStubSettings build() throws IOException {
      return new SecureSourceManagerStubSettings(this);
    }
  }
}
