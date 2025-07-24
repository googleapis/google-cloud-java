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

package com.google.cloud.securesourcemanager.v1;

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
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securesourcemanager.v1.stub.SecureSourceManagerStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecureSourceManagerClient}.
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
 * SecureSourceManagerSettings.Builder secureSourceManagerSettingsBuilder =
 *     SecureSourceManagerSettings.newBuilder();
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
 * SecureSourceManagerSettings secureSourceManagerSettings =
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
 * SecureSourceManagerSettings.Builder secureSourceManagerSettingsBuilder =
 *     SecureSourceManagerSettings.newBuilder();
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
public class SecureSourceManagerSettings extends ClientSettings<SecureSourceManagerSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRepositories. */
  public PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listRepositoriesSettings();
  }

  /** Returns the object with the settings used for calls to getRepository. */
  public UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getRepositorySettings();
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createRepositorySettings();
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .createRepositoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public UnaryCallSettings<UpdateRepositoryRequest, Operation> updateRepositorySettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updateRepositorySettings();
  }

  /** Returns the object with the settings used for calls to updateRepository. */
  public OperationCallSettings<UpdateRepositoryRequest, Repository, OperationMetadata>
      updateRepositoryOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .updateRepositoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteRepositorySettings();
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .deleteRepositoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to listHooks. */
  public PagedCallSettings<ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>
      listHooksSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listHooksSettings();
  }

  /** Returns the object with the settings used for calls to getHook. */
  public UnaryCallSettings<GetHookRequest, Hook> getHookSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getHookSettings();
  }

  /** Returns the object with the settings used for calls to createHook. */
  public UnaryCallSettings<CreateHookRequest, Operation> createHookSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createHookSettings();
  }

  /** Returns the object with the settings used for calls to createHook. */
  public OperationCallSettings<CreateHookRequest, Hook, OperationMetadata>
      createHookOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createHookOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateHook. */
  public UnaryCallSettings<UpdateHookRequest, Operation> updateHookSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updateHookSettings();
  }

  /** Returns the object with the settings used for calls to updateHook. */
  public OperationCallSettings<UpdateHookRequest, Hook, OperationMetadata>
      updateHookOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updateHookOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteHook. */
  public UnaryCallSettings<DeleteHookRequest, Operation> deleteHookSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteHookSettings();
  }

  /** Returns the object with the settings used for calls to deleteHook. */
  public OperationCallSettings<DeleteHookRequest, Empty, OperationMetadata>
      deleteHookOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteHookOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicyRepo. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicyRepoSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getIamPolicyRepoSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicyRepo. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicyRepoSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).setIamPolicyRepoSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsRepo. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).testIamPermissionsRepoSettings();
  }

  /** Returns the object with the settings used for calls to createBranchRule. */
  public UnaryCallSettings<CreateBranchRuleRequest, Operation> createBranchRuleSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createBranchRuleSettings();
  }

  /** Returns the object with the settings used for calls to createBranchRule. */
  public OperationCallSettings<CreateBranchRuleRequest, BranchRule, OperationMetadata>
      createBranchRuleOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .createBranchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBranchRules. */
  public PagedCallSettings<
          ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>
      listBranchRulesSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listBranchRulesSettings();
  }

  /** Returns the object with the settings used for calls to getBranchRule. */
  public UnaryCallSettings<GetBranchRuleRequest, BranchRule> getBranchRuleSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getBranchRuleSettings();
  }

  /** Returns the object with the settings used for calls to updateBranchRule. */
  public UnaryCallSettings<UpdateBranchRuleRequest, Operation> updateBranchRuleSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updateBranchRuleSettings();
  }

  /** Returns the object with the settings used for calls to updateBranchRule. */
  public OperationCallSettings<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
      updateBranchRuleOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .updateBranchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBranchRule. */
  public UnaryCallSettings<DeleteBranchRuleRequest, Operation> deleteBranchRuleSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteBranchRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteBranchRule. */
  public OperationCallSettings<DeleteBranchRuleRequest, Empty, OperationMetadata>
      deleteBranchRuleOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .deleteBranchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to createPullRequest. */
  public UnaryCallSettings<CreatePullRequestRequest, Operation> createPullRequestSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createPullRequestSettings();
  }

  /** Returns the object with the settings used for calls to createPullRequest. */
  public OperationCallSettings<CreatePullRequestRequest, PullRequest, OperationMetadata>
      createPullRequestOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .createPullRequestOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPullRequest. */
  public UnaryCallSettings<GetPullRequestRequest, PullRequest> getPullRequestSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getPullRequestSettings();
  }

  /** Returns the object with the settings used for calls to listPullRequests. */
  public PagedCallSettings<
          ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>
      listPullRequestsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listPullRequestsSettings();
  }

  /** Returns the object with the settings used for calls to updatePullRequest. */
  public UnaryCallSettings<UpdatePullRequestRequest, Operation> updatePullRequestSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updatePullRequestSettings();
  }

  /** Returns the object with the settings used for calls to updatePullRequest. */
  public OperationCallSettings<UpdatePullRequestRequest, PullRequest, OperationMetadata>
      updatePullRequestOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .updatePullRequestOperationSettings();
  }

  /** Returns the object with the settings used for calls to mergePullRequest. */
  public UnaryCallSettings<MergePullRequestRequest, Operation> mergePullRequestSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).mergePullRequestSettings();
  }

  /** Returns the object with the settings used for calls to mergePullRequest. */
  public OperationCallSettings<MergePullRequestRequest, PullRequest, OperationMetadata>
      mergePullRequestOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .mergePullRequestOperationSettings();
  }

  /** Returns the object with the settings used for calls to openPullRequest. */
  public UnaryCallSettings<OpenPullRequestRequest, Operation> openPullRequestSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).openPullRequestSettings();
  }

  /** Returns the object with the settings used for calls to openPullRequest. */
  public OperationCallSettings<OpenPullRequestRequest, PullRequest, OperationMetadata>
      openPullRequestOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).openPullRequestOperationSettings();
  }

  /** Returns the object with the settings used for calls to closePullRequest. */
  public UnaryCallSettings<ClosePullRequestRequest, Operation> closePullRequestSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).closePullRequestSettings();
  }

  /** Returns the object with the settings used for calls to closePullRequest. */
  public OperationCallSettings<ClosePullRequestRequest, PullRequest, OperationMetadata>
      closePullRequestOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .closePullRequestOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPullRequestFileDiffs. */
  public PagedCallSettings<
          ListPullRequestFileDiffsRequest,
          ListPullRequestFileDiffsResponse,
          ListPullRequestFileDiffsPagedResponse>
      listPullRequestFileDiffsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listPullRequestFileDiffsSettings();
  }

  /** Returns the object with the settings used for calls to fetchTree. */
  public PagedCallSettings<FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>
      fetchTreeSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).fetchTreeSettings();
  }

  /** Returns the object with the settings used for calls to fetchBlob. */
  public UnaryCallSettings<FetchBlobRequest, FetchBlobResponse> fetchBlobSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).fetchBlobSettings();
  }

  /** Returns the object with the settings used for calls to createIssue. */
  public UnaryCallSettings<CreateIssueRequest, Operation> createIssueSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createIssueSettings();
  }

  /** Returns the object with the settings used for calls to createIssue. */
  public OperationCallSettings<CreateIssueRequest, Issue, OperationMetadata>
      createIssueOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createIssueOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIssue. */
  public UnaryCallSettings<GetIssueRequest, Issue> getIssueSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getIssueSettings();
  }

  /** Returns the object with the settings used for calls to listIssues. */
  public PagedCallSettings<ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>
      listIssuesSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listIssuesSettings();
  }

  /** Returns the object with the settings used for calls to updateIssue. */
  public UnaryCallSettings<UpdateIssueRequest, Operation> updateIssueSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updateIssueSettings();
  }

  /** Returns the object with the settings used for calls to updateIssue. */
  public OperationCallSettings<UpdateIssueRequest, Issue, OperationMetadata>
      updateIssueOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updateIssueOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteIssue. */
  public UnaryCallSettings<DeleteIssueRequest, Operation> deleteIssueSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteIssueSettings();
  }

  /** Returns the object with the settings used for calls to deleteIssue. */
  public OperationCallSettings<DeleteIssueRequest, Empty, OperationMetadata>
      deleteIssueOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteIssueOperationSettings();
  }

  /** Returns the object with the settings used for calls to openIssue. */
  public UnaryCallSettings<OpenIssueRequest, Operation> openIssueSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).openIssueSettings();
  }

  /** Returns the object with the settings used for calls to openIssue. */
  public OperationCallSettings<OpenIssueRequest, Issue, OperationMetadata>
      openIssueOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).openIssueOperationSettings();
  }

  /** Returns the object with the settings used for calls to closeIssue. */
  public UnaryCallSettings<CloseIssueRequest, Operation> closeIssueSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).closeIssueSettings();
  }

  /** Returns the object with the settings used for calls to closeIssue. */
  public OperationCallSettings<CloseIssueRequest, Issue, OperationMetadata>
      closeIssueOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).closeIssueOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPullRequestComment. */
  public UnaryCallSettings<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getPullRequestCommentSettings();
  }

  /** Returns the object with the settings used for calls to listPullRequestComments. */
  public PagedCallSettings<
          ListPullRequestCommentsRequest,
          ListPullRequestCommentsResponse,
          ListPullRequestCommentsPagedResponse>
      listPullRequestCommentsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listPullRequestCommentsSettings();
  }

  /** Returns the object with the settings used for calls to createPullRequestComment. */
  public UnaryCallSettings<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createPullRequestCommentSettings();
  }

  /** Returns the object with the settings used for calls to createPullRequestComment. */
  public OperationCallSettings<
          CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      createPullRequestCommentOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .createPullRequestCommentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePullRequestComment. */
  public UnaryCallSettings<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updatePullRequestCommentSettings();
  }

  /** Returns the object with the settings used for calls to updatePullRequestComment. */
  public OperationCallSettings<
          UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      updatePullRequestCommentOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .updatePullRequestCommentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePullRequestComment. */
  public UnaryCallSettings<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deletePullRequestCommentSettings();
  }

  /** Returns the object with the settings used for calls to deletePullRequestComment. */
  public OperationCallSettings<DeletePullRequestCommentRequest, Empty, OperationMetadata>
      deletePullRequestCommentOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .deletePullRequestCommentOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchCreatePullRequestComments. */
  public UnaryCallSettings<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .batchCreatePullRequestCommentsSettings();
  }

  /** Returns the object with the settings used for calls to batchCreatePullRequestComments. */
  public OperationCallSettings<
          BatchCreatePullRequestCommentsRequest,
          BatchCreatePullRequestCommentsResponse,
          OperationMetadata>
      batchCreatePullRequestCommentsOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .batchCreatePullRequestCommentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to resolvePullRequestComments. */
  public UnaryCallSettings<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .resolvePullRequestCommentsSettings();
  }

  /** Returns the object with the settings used for calls to resolvePullRequestComments. */
  public OperationCallSettings<
          ResolvePullRequestCommentsRequest, ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .resolvePullRequestCommentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to unresolvePullRequestComments. */
  public UnaryCallSettings<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .unresolvePullRequestCommentsSettings();
  }

  /** Returns the object with the settings used for calls to unresolvePullRequestComments. */
  public OperationCallSettings<
          UnresolvePullRequestCommentsRequest,
          UnresolvePullRequestCommentsResponse,
          OperationMetadata>
      unresolvePullRequestCommentsOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .unresolvePullRequestCommentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createIssueComment. */
  public UnaryCallSettings<CreateIssueCommentRequest, Operation> createIssueCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).createIssueCommentSettings();
  }

  /** Returns the object with the settings used for calls to createIssueComment. */
  public OperationCallSettings<CreateIssueCommentRequest, IssueComment, OperationMetadata>
      createIssueCommentOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .createIssueCommentOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIssueComment. */
  public UnaryCallSettings<GetIssueCommentRequest, IssueComment> getIssueCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getIssueCommentSettings();
  }

  /** Returns the object with the settings used for calls to listIssueComments. */
  public PagedCallSettings<
          ListIssueCommentsRequest, ListIssueCommentsResponse, ListIssueCommentsPagedResponse>
      listIssueCommentsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listIssueCommentsSettings();
  }

  /** Returns the object with the settings used for calls to updateIssueComment. */
  public UnaryCallSettings<UpdateIssueCommentRequest, Operation> updateIssueCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).updateIssueCommentSettings();
  }

  /** Returns the object with the settings used for calls to updateIssueComment. */
  public OperationCallSettings<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
      updateIssueCommentOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .updateIssueCommentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteIssueComment. */
  public UnaryCallSettings<DeleteIssueCommentRequest, Operation> deleteIssueCommentSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).deleteIssueCommentSettings();
  }

  /** Returns the object with the settings used for calls to deleteIssueComment. */
  public OperationCallSettings<DeleteIssueCommentRequest, Empty, OperationMetadata>
      deleteIssueCommentOperationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings())
        .deleteIssueCommentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((SecureSourceManagerStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final SecureSourceManagerSettings create(SecureSourceManagerStubSettings stub)
      throws IOException {
    return new SecureSourceManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecureSourceManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecureSourceManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecureSourceManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecureSourceManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SecureSourceManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SecureSourceManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecureSourceManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecureSourceManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SecureSourceManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecureSourceManagerSettings. */
  public static class Builder extends ClientSettings.Builder<SecureSourceManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SecureSourceManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(SecureSourceManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecureSourceManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SecureSourceManagerStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SecureSourceManagerStubSettings.newHttpJsonBuilder());
    }

    public SecureSourceManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((SecureSourceManagerStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRepositories. */
    public PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings() {
      return getStubSettingsBuilder().listRepositoriesSettings();
    }

    /** Returns the builder for the settings used for calls to getRepository. */
    public UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings() {
      return getStubSettingsBuilder().getRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings() {
      return getStubSettingsBuilder().createRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public OperationCallSettings.Builder<CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings() {
      return getStubSettingsBuilder().createRepositoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public UnaryCallSettings.Builder<UpdateRepositoryRequest, Operation>
        updateRepositorySettings() {
      return getStubSettingsBuilder().updateRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to updateRepository. */
    public OperationCallSettings.Builder<UpdateRepositoryRequest, Repository, OperationMetadata>
        updateRepositoryOperationSettings() {
      return getStubSettingsBuilder().updateRepositoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings() {
      return getStubSettingsBuilder().deleteRepositorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings() {
      return getStubSettingsBuilder().deleteRepositoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listHooks. */
    public PagedCallSettings.Builder<ListHooksRequest, ListHooksResponse, ListHooksPagedResponse>
        listHooksSettings() {
      return getStubSettingsBuilder().listHooksSettings();
    }

    /** Returns the builder for the settings used for calls to getHook. */
    public UnaryCallSettings.Builder<GetHookRequest, Hook> getHookSettings() {
      return getStubSettingsBuilder().getHookSettings();
    }

    /** Returns the builder for the settings used for calls to createHook. */
    public UnaryCallSettings.Builder<CreateHookRequest, Operation> createHookSettings() {
      return getStubSettingsBuilder().createHookSettings();
    }

    /** Returns the builder for the settings used for calls to createHook. */
    public OperationCallSettings.Builder<CreateHookRequest, Hook, OperationMetadata>
        createHookOperationSettings() {
      return getStubSettingsBuilder().createHookOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateHook. */
    public UnaryCallSettings.Builder<UpdateHookRequest, Operation> updateHookSettings() {
      return getStubSettingsBuilder().updateHookSettings();
    }

    /** Returns the builder for the settings used for calls to updateHook. */
    public OperationCallSettings.Builder<UpdateHookRequest, Hook, OperationMetadata>
        updateHookOperationSettings() {
      return getStubSettingsBuilder().updateHookOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHook. */
    public UnaryCallSettings.Builder<DeleteHookRequest, Operation> deleteHookSettings() {
      return getStubSettingsBuilder().deleteHookSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHook. */
    public OperationCallSettings.Builder<DeleteHookRequest, Empty, OperationMetadata>
        deleteHookOperationSettings() {
      return getStubSettingsBuilder().deleteHookOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicyRepo. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicyRepoSettings() {
      return getStubSettingsBuilder().getIamPolicyRepoSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicyRepo. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicyRepoSettings() {
      return getStubSettingsBuilder().setIamPolicyRepoSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsRepo. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsRepoSettings() {
      return getStubSettingsBuilder().testIamPermissionsRepoSettings();
    }

    /** Returns the builder for the settings used for calls to createBranchRule. */
    public UnaryCallSettings.Builder<CreateBranchRuleRequest, Operation>
        createBranchRuleSettings() {
      return getStubSettingsBuilder().createBranchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to createBranchRule. */
    public OperationCallSettings.Builder<CreateBranchRuleRequest, BranchRule, OperationMetadata>
        createBranchRuleOperationSettings() {
      return getStubSettingsBuilder().createBranchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBranchRules. */
    public PagedCallSettings.Builder<
            ListBranchRulesRequest, ListBranchRulesResponse, ListBranchRulesPagedResponse>
        listBranchRulesSettings() {
      return getStubSettingsBuilder().listBranchRulesSettings();
    }

    /** Returns the builder for the settings used for calls to getBranchRule. */
    public UnaryCallSettings.Builder<GetBranchRuleRequest, BranchRule> getBranchRuleSettings() {
      return getStubSettingsBuilder().getBranchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to updateBranchRule. */
    public UnaryCallSettings.Builder<UpdateBranchRuleRequest, Operation>
        updateBranchRuleSettings() {
      return getStubSettingsBuilder().updateBranchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to updateBranchRule. */
    public OperationCallSettings.Builder<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
        updateBranchRuleOperationSettings() {
      return getStubSettingsBuilder().updateBranchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBranchRule. */
    public UnaryCallSettings.Builder<DeleteBranchRuleRequest, Operation>
        deleteBranchRuleSettings() {
      return getStubSettingsBuilder().deleteBranchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBranchRule. */
    public OperationCallSettings.Builder<DeleteBranchRuleRequest, Empty, OperationMetadata>
        deleteBranchRuleOperationSettings() {
      return getStubSettingsBuilder().deleteBranchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createPullRequest. */
    public UnaryCallSettings.Builder<CreatePullRequestRequest, Operation>
        createPullRequestSettings() {
      return getStubSettingsBuilder().createPullRequestSettings();
    }

    /** Returns the builder for the settings used for calls to createPullRequest. */
    public OperationCallSettings.Builder<CreatePullRequestRequest, PullRequest, OperationMetadata>
        createPullRequestOperationSettings() {
      return getStubSettingsBuilder().createPullRequestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPullRequest. */
    public UnaryCallSettings.Builder<GetPullRequestRequest, PullRequest> getPullRequestSettings() {
      return getStubSettingsBuilder().getPullRequestSettings();
    }

    /** Returns the builder for the settings used for calls to listPullRequests. */
    public PagedCallSettings.Builder<
            ListPullRequestsRequest, ListPullRequestsResponse, ListPullRequestsPagedResponse>
        listPullRequestsSettings() {
      return getStubSettingsBuilder().listPullRequestsSettings();
    }

    /** Returns the builder for the settings used for calls to updatePullRequest. */
    public UnaryCallSettings.Builder<UpdatePullRequestRequest, Operation>
        updatePullRequestSettings() {
      return getStubSettingsBuilder().updatePullRequestSettings();
    }

    /** Returns the builder for the settings used for calls to updatePullRequest. */
    public OperationCallSettings.Builder<UpdatePullRequestRequest, PullRequest, OperationMetadata>
        updatePullRequestOperationSettings() {
      return getStubSettingsBuilder().updatePullRequestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to mergePullRequest. */
    public UnaryCallSettings.Builder<MergePullRequestRequest, Operation>
        mergePullRequestSettings() {
      return getStubSettingsBuilder().mergePullRequestSettings();
    }

    /** Returns the builder for the settings used for calls to mergePullRequest. */
    public OperationCallSettings.Builder<MergePullRequestRequest, PullRequest, OperationMetadata>
        mergePullRequestOperationSettings() {
      return getStubSettingsBuilder().mergePullRequestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to openPullRequest. */
    public UnaryCallSettings.Builder<OpenPullRequestRequest, Operation> openPullRequestSettings() {
      return getStubSettingsBuilder().openPullRequestSettings();
    }

    /** Returns the builder for the settings used for calls to openPullRequest. */
    public OperationCallSettings.Builder<OpenPullRequestRequest, PullRequest, OperationMetadata>
        openPullRequestOperationSettings() {
      return getStubSettingsBuilder().openPullRequestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to closePullRequest. */
    public UnaryCallSettings.Builder<ClosePullRequestRequest, Operation>
        closePullRequestSettings() {
      return getStubSettingsBuilder().closePullRequestSettings();
    }

    /** Returns the builder for the settings used for calls to closePullRequest. */
    public OperationCallSettings.Builder<ClosePullRequestRequest, PullRequest, OperationMetadata>
        closePullRequestOperationSettings() {
      return getStubSettingsBuilder().closePullRequestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPullRequestFileDiffs. */
    public PagedCallSettings.Builder<
            ListPullRequestFileDiffsRequest,
            ListPullRequestFileDiffsResponse,
            ListPullRequestFileDiffsPagedResponse>
        listPullRequestFileDiffsSettings() {
      return getStubSettingsBuilder().listPullRequestFileDiffsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchTree. */
    public PagedCallSettings.Builder<FetchTreeRequest, FetchTreeResponse, FetchTreePagedResponse>
        fetchTreeSettings() {
      return getStubSettingsBuilder().fetchTreeSettings();
    }

    /** Returns the builder for the settings used for calls to fetchBlob. */
    public UnaryCallSettings.Builder<FetchBlobRequest, FetchBlobResponse> fetchBlobSettings() {
      return getStubSettingsBuilder().fetchBlobSettings();
    }

    /** Returns the builder for the settings used for calls to createIssue. */
    public UnaryCallSettings.Builder<CreateIssueRequest, Operation> createIssueSettings() {
      return getStubSettingsBuilder().createIssueSettings();
    }

    /** Returns the builder for the settings used for calls to createIssue. */
    public OperationCallSettings.Builder<CreateIssueRequest, Issue, OperationMetadata>
        createIssueOperationSettings() {
      return getStubSettingsBuilder().createIssueOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIssue. */
    public UnaryCallSettings.Builder<GetIssueRequest, Issue> getIssueSettings() {
      return getStubSettingsBuilder().getIssueSettings();
    }

    /** Returns the builder for the settings used for calls to listIssues. */
    public PagedCallSettings.Builder<ListIssuesRequest, ListIssuesResponse, ListIssuesPagedResponse>
        listIssuesSettings() {
      return getStubSettingsBuilder().listIssuesSettings();
    }

    /** Returns the builder for the settings used for calls to updateIssue. */
    public UnaryCallSettings.Builder<UpdateIssueRequest, Operation> updateIssueSettings() {
      return getStubSettingsBuilder().updateIssueSettings();
    }

    /** Returns the builder for the settings used for calls to updateIssue. */
    public OperationCallSettings.Builder<UpdateIssueRequest, Issue, OperationMetadata>
        updateIssueOperationSettings() {
      return getStubSettingsBuilder().updateIssueOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIssue. */
    public UnaryCallSettings.Builder<DeleteIssueRequest, Operation> deleteIssueSettings() {
      return getStubSettingsBuilder().deleteIssueSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIssue. */
    public OperationCallSettings.Builder<DeleteIssueRequest, Empty, OperationMetadata>
        deleteIssueOperationSettings() {
      return getStubSettingsBuilder().deleteIssueOperationSettings();
    }

    /** Returns the builder for the settings used for calls to openIssue. */
    public UnaryCallSettings.Builder<OpenIssueRequest, Operation> openIssueSettings() {
      return getStubSettingsBuilder().openIssueSettings();
    }

    /** Returns the builder for the settings used for calls to openIssue. */
    public OperationCallSettings.Builder<OpenIssueRequest, Issue, OperationMetadata>
        openIssueOperationSettings() {
      return getStubSettingsBuilder().openIssueOperationSettings();
    }

    /** Returns the builder for the settings used for calls to closeIssue. */
    public UnaryCallSettings.Builder<CloseIssueRequest, Operation> closeIssueSettings() {
      return getStubSettingsBuilder().closeIssueSettings();
    }

    /** Returns the builder for the settings used for calls to closeIssue. */
    public OperationCallSettings.Builder<CloseIssueRequest, Issue, OperationMetadata>
        closeIssueOperationSettings() {
      return getStubSettingsBuilder().closeIssueOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPullRequestComment. */
    public UnaryCallSettings.Builder<GetPullRequestCommentRequest, PullRequestComment>
        getPullRequestCommentSettings() {
      return getStubSettingsBuilder().getPullRequestCommentSettings();
    }

    /** Returns the builder for the settings used for calls to listPullRequestComments. */
    public PagedCallSettings.Builder<
            ListPullRequestCommentsRequest,
            ListPullRequestCommentsResponse,
            ListPullRequestCommentsPagedResponse>
        listPullRequestCommentsSettings() {
      return getStubSettingsBuilder().listPullRequestCommentsSettings();
    }

    /** Returns the builder for the settings used for calls to createPullRequestComment. */
    public UnaryCallSettings.Builder<CreatePullRequestCommentRequest, Operation>
        createPullRequestCommentSettings() {
      return getStubSettingsBuilder().createPullRequestCommentSettings();
    }

    /** Returns the builder for the settings used for calls to createPullRequestComment. */
    public OperationCallSettings.Builder<
            CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
        createPullRequestCommentOperationSettings() {
      return getStubSettingsBuilder().createPullRequestCommentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePullRequestComment. */
    public UnaryCallSettings.Builder<UpdatePullRequestCommentRequest, Operation>
        updatePullRequestCommentSettings() {
      return getStubSettingsBuilder().updatePullRequestCommentSettings();
    }

    /** Returns the builder for the settings used for calls to updatePullRequestComment. */
    public OperationCallSettings.Builder<
            UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
        updatePullRequestCommentOperationSettings() {
      return getStubSettingsBuilder().updatePullRequestCommentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePullRequestComment. */
    public UnaryCallSettings.Builder<DeletePullRequestCommentRequest, Operation>
        deletePullRequestCommentSettings() {
      return getStubSettingsBuilder().deletePullRequestCommentSettings();
    }

    /** Returns the builder for the settings used for calls to deletePullRequestComment. */
    public OperationCallSettings.Builder<DeletePullRequestCommentRequest, Empty, OperationMetadata>
        deletePullRequestCommentOperationSettings() {
      return getStubSettingsBuilder().deletePullRequestCommentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreatePullRequestComments. */
    public UnaryCallSettings.Builder<BatchCreatePullRequestCommentsRequest, Operation>
        batchCreatePullRequestCommentsSettings() {
      return getStubSettingsBuilder().batchCreatePullRequestCommentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreatePullRequestComments. */
    public OperationCallSettings.Builder<
            BatchCreatePullRequestCommentsRequest,
            BatchCreatePullRequestCommentsResponse,
            OperationMetadata>
        batchCreatePullRequestCommentsOperationSettings() {
      return getStubSettingsBuilder().batchCreatePullRequestCommentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resolvePullRequestComments. */
    public UnaryCallSettings.Builder<ResolvePullRequestCommentsRequest, Operation>
        resolvePullRequestCommentsSettings() {
      return getStubSettingsBuilder().resolvePullRequestCommentsSettings();
    }

    /** Returns the builder for the settings used for calls to resolvePullRequestComments. */
    public OperationCallSettings.Builder<
            ResolvePullRequestCommentsRequest,
            ResolvePullRequestCommentsResponse,
            OperationMetadata>
        resolvePullRequestCommentsOperationSettings() {
      return getStubSettingsBuilder().resolvePullRequestCommentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to unresolvePullRequestComments. */
    public UnaryCallSettings.Builder<UnresolvePullRequestCommentsRequest, Operation>
        unresolvePullRequestCommentsSettings() {
      return getStubSettingsBuilder().unresolvePullRequestCommentsSettings();
    }

    /** Returns the builder for the settings used for calls to unresolvePullRequestComments. */
    public OperationCallSettings.Builder<
            UnresolvePullRequestCommentsRequest,
            UnresolvePullRequestCommentsResponse,
            OperationMetadata>
        unresolvePullRequestCommentsOperationSettings() {
      return getStubSettingsBuilder().unresolvePullRequestCommentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createIssueComment. */
    public UnaryCallSettings.Builder<CreateIssueCommentRequest, Operation>
        createIssueCommentSettings() {
      return getStubSettingsBuilder().createIssueCommentSettings();
    }

    /** Returns the builder for the settings used for calls to createIssueComment. */
    public OperationCallSettings.Builder<CreateIssueCommentRequest, IssueComment, OperationMetadata>
        createIssueCommentOperationSettings() {
      return getStubSettingsBuilder().createIssueCommentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIssueComment. */
    public UnaryCallSettings.Builder<GetIssueCommentRequest, IssueComment>
        getIssueCommentSettings() {
      return getStubSettingsBuilder().getIssueCommentSettings();
    }

    /** Returns the builder for the settings used for calls to listIssueComments. */
    public PagedCallSettings.Builder<
            ListIssueCommentsRequest, ListIssueCommentsResponse, ListIssueCommentsPagedResponse>
        listIssueCommentsSettings() {
      return getStubSettingsBuilder().listIssueCommentsSettings();
    }

    /** Returns the builder for the settings used for calls to updateIssueComment. */
    public UnaryCallSettings.Builder<UpdateIssueCommentRequest, Operation>
        updateIssueCommentSettings() {
      return getStubSettingsBuilder().updateIssueCommentSettings();
    }

    /** Returns the builder for the settings used for calls to updateIssueComment. */
    public OperationCallSettings.Builder<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
        updateIssueCommentOperationSettings() {
      return getStubSettingsBuilder().updateIssueCommentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIssueComment. */
    public UnaryCallSettings.Builder<DeleteIssueCommentRequest, Operation>
        deleteIssueCommentSettings() {
      return getStubSettingsBuilder().deleteIssueCommentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIssueComment. */
    public OperationCallSettings.Builder<DeleteIssueCommentRequest, Empty, OperationMetadata>
        deleteIssueCommentOperationSettings() {
      return getStubSettingsBuilder().deleteIssueCommentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public SecureSourceManagerSettings build() throws IOException {
      return new SecureSourceManagerSettings(this);
    }
  }
}
