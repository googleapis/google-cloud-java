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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest;
import com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsResponse;
import com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest;
import com.google.cloud.securesourcemanager.v1.UpdateHookRequest;
import com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest;
import com.google.cloud.securesourcemanager.v1.UpdateIssueRequest;
import com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest;
import com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest;
import com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SecureSourceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SecureSourceManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRepositoriesPagedCallable()");
  }

  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRepositoriesCallable()");
  }

  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: getRepositoryCallable()");
  }

  public OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRepositoryOperationCallable()");
  }

  public UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: createRepositoryCallable()");
  }

  public OperationCallable<UpdateRepositoryRequest, Repository, OperationMetadata>
      updateRepositoryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRepositoryOperationCallable()");
  }

  public UnaryCallable<UpdateRepositoryRequest, Operation> updateRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRepositoryCallable()");
  }

  public OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRepositoryOperationCallable()");
  }

  public UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRepositoryCallable()");
  }

  public UnaryCallable<ListHooksRequest, ListHooksPagedResponse> listHooksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHooksPagedCallable()");
  }

  public UnaryCallable<ListHooksRequest, ListHooksResponse> listHooksCallable() {
    throw new UnsupportedOperationException("Not implemented: listHooksCallable()");
  }

  public UnaryCallable<GetHookRequest, Hook> getHookCallable() {
    throw new UnsupportedOperationException("Not implemented: getHookCallable()");
  }

  public OperationCallable<CreateHookRequest, Hook, OperationMetadata>
      createHookOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createHookOperationCallable()");
  }

  public UnaryCallable<CreateHookRequest, Operation> createHookCallable() {
    throw new UnsupportedOperationException("Not implemented: createHookCallable()");
  }

  public OperationCallable<UpdateHookRequest, Hook, OperationMetadata>
      updateHookOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHookOperationCallable()");
  }

  public UnaryCallable<UpdateHookRequest, Operation> updateHookCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHookCallable()");
  }

  public OperationCallable<DeleteHookRequest, Empty, OperationMetadata>
      deleteHookOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHookOperationCallable()");
  }

  public UnaryCallable<DeleteHookRequest, Operation> deleteHookCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHookCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyRepoCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyRepoCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyRepoCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyRepoCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsRepoCallable()");
  }

  public OperationCallable<CreateBranchRuleRequest, BranchRule, OperationMetadata>
      createBranchRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBranchRuleOperationCallable()");
  }

  public UnaryCallable<CreateBranchRuleRequest, Operation> createBranchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createBranchRuleCallable()");
  }

  public UnaryCallable<ListBranchRulesRequest, ListBranchRulesPagedResponse>
      listBranchRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBranchRulesPagedCallable()");
  }

  public UnaryCallable<ListBranchRulesRequest, ListBranchRulesResponse> listBranchRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listBranchRulesCallable()");
  }

  public UnaryCallable<GetBranchRuleRequest, BranchRule> getBranchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getBranchRuleCallable()");
  }

  public OperationCallable<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
      updateBranchRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBranchRuleOperationCallable()");
  }

  public UnaryCallable<UpdateBranchRuleRequest, Operation> updateBranchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBranchRuleCallable()");
  }

  public OperationCallable<DeleteBranchRuleRequest, Empty, OperationMetadata>
      deleteBranchRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBranchRuleOperationCallable()");
  }

  public UnaryCallable<DeleteBranchRuleRequest, Operation> deleteBranchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBranchRuleCallable()");
  }

  public OperationCallable<CreatePullRequestRequest, PullRequest, OperationMetadata>
      createPullRequestOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPullRequestOperationCallable()");
  }

  public UnaryCallable<CreatePullRequestRequest, Operation> createPullRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: createPullRequestCallable()");
  }

  public UnaryCallable<GetPullRequestRequest, PullRequest> getPullRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: getPullRequestCallable()");
  }

  public UnaryCallable<ListPullRequestsRequest, ListPullRequestsPagedResponse>
      listPullRequestsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPullRequestsPagedCallable()");
  }

  public UnaryCallable<ListPullRequestsRequest, ListPullRequestsResponse>
      listPullRequestsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPullRequestsCallable()");
  }

  public OperationCallable<UpdatePullRequestRequest, PullRequest, OperationMetadata>
      updatePullRequestOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePullRequestOperationCallable()");
  }

  public UnaryCallable<UpdatePullRequestRequest, Operation> updatePullRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePullRequestCallable()");
  }

  public OperationCallable<MergePullRequestRequest, PullRequest, OperationMetadata>
      mergePullRequestOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: mergePullRequestOperationCallable()");
  }

  public UnaryCallable<MergePullRequestRequest, Operation> mergePullRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: mergePullRequestCallable()");
  }

  public OperationCallable<OpenPullRequestRequest, PullRequest, OperationMetadata>
      openPullRequestOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: openPullRequestOperationCallable()");
  }

  public UnaryCallable<OpenPullRequestRequest, Operation> openPullRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: openPullRequestCallable()");
  }

  public OperationCallable<ClosePullRequestRequest, PullRequest, OperationMetadata>
      closePullRequestOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: closePullRequestOperationCallable()");
  }

  public UnaryCallable<ClosePullRequestRequest, Operation> closePullRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: closePullRequestCallable()");
  }

  public UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsPagedResponse>
      listPullRequestFileDiffsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPullRequestFileDiffsPagedCallable()");
  }

  public UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
      listPullRequestFileDiffsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPullRequestFileDiffsCallable()");
  }

  public UnaryCallable<FetchTreeRequest, FetchTreePagedResponse> fetchTreePagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchTreePagedCallable()");
  }

  public UnaryCallable<FetchTreeRequest, FetchTreeResponse> fetchTreeCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchTreeCallable()");
  }

  public UnaryCallable<FetchBlobRequest, FetchBlobResponse> fetchBlobCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchBlobCallable()");
  }

  public OperationCallable<CreateIssueRequest, Issue, OperationMetadata>
      createIssueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIssueOperationCallable()");
  }

  public UnaryCallable<CreateIssueRequest, Operation> createIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: createIssueCallable()");
  }

  public UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: getIssueCallable()");
  }

  public UnaryCallable<ListIssuesRequest, ListIssuesPagedResponse> listIssuesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIssuesPagedCallable()");
  }

  public UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIssuesCallable()");
  }

  public OperationCallable<UpdateIssueRequest, Issue, OperationMetadata>
      updateIssueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIssueOperationCallable()");
  }

  public UnaryCallable<UpdateIssueRequest, Operation> updateIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIssueCallable()");
  }

  public OperationCallable<DeleteIssueRequest, Empty, OperationMetadata>
      deleteIssueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIssueOperationCallable()");
  }

  public UnaryCallable<DeleteIssueRequest, Operation> deleteIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIssueCallable()");
  }

  public OperationCallable<OpenIssueRequest, Issue, OperationMetadata>
      openIssueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: openIssueOperationCallable()");
  }

  public UnaryCallable<OpenIssueRequest, Operation> openIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: openIssueCallable()");
  }

  public OperationCallable<CloseIssueRequest, Issue, OperationMetadata>
      closeIssueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: closeIssueOperationCallable()");
  }

  public UnaryCallable<CloseIssueRequest, Operation> closeIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: closeIssueCallable()");
  }

  public UnaryCallable<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: getPullRequestCommentCallable()");
  }

  public UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsPagedResponse>
      listPullRequestCommentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPullRequestCommentsPagedCallable()");
  }

  public UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
      listPullRequestCommentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPullRequestCommentsCallable()");
  }

  public OperationCallable<CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      createPullRequestCommentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPullRequestCommentOperationCallable()");
  }

  public UnaryCallable<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: createPullRequestCommentCallable()");
  }

  public OperationCallable<UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      updatePullRequestCommentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePullRequestCommentOperationCallable()");
  }

  public UnaryCallable<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePullRequestCommentCallable()");
  }

  public OperationCallable<DeletePullRequestCommentRequest, Empty, OperationMetadata>
      deletePullRequestCommentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePullRequestCommentOperationCallable()");
  }

  public UnaryCallable<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePullRequestCommentCallable()");
  }

  public OperationCallable<
          BatchCreatePullRequestCommentsRequest,
          BatchCreatePullRequestCommentsResponse,
          OperationMetadata>
      batchCreatePullRequestCommentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreatePullRequestCommentsOperationCallable()");
  }

  public UnaryCallable<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreatePullRequestCommentsCallable()");
  }

  public OperationCallable<
          ResolvePullRequestCommentsRequest, ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resolvePullRequestCommentsOperationCallable()");
  }

  public UnaryCallable<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resolvePullRequestCommentsCallable()");
  }

  public OperationCallable<
          UnresolvePullRequestCommentsRequest,
          UnresolvePullRequestCommentsResponse,
          OperationMetadata>
      unresolvePullRequestCommentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: unresolvePullRequestCommentsOperationCallable()");
  }

  public UnaryCallable<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: unresolvePullRequestCommentsCallable()");
  }

  public OperationCallable<CreateIssueCommentRequest, IssueComment, OperationMetadata>
      createIssueCommentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createIssueCommentOperationCallable()");
  }

  public UnaryCallable<CreateIssueCommentRequest, Operation> createIssueCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: createIssueCommentCallable()");
  }

  public UnaryCallable<GetIssueCommentRequest, IssueComment> getIssueCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: getIssueCommentCallable()");
  }

  public UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsPagedResponse>
      listIssueCommentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIssueCommentsPagedCallable()");
  }

  public UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsResponse>
      listIssueCommentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIssueCommentsCallable()");
  }

  public OperationCallable<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
      updateIssueCommentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateIssueCommentOperationCallable()");
  }

  public UnaryCallable<UpdateIssueCommentRequest, Operation> updateIssueCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIssueCommentCallable()");
  }

  public OperationCallable<DeleteIssueCommentRequest, Empty, OperationMetadata>
      deleteIssueCommentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIssueCommentOperationCallable()");
  }

  public UnaryCallable<DeleteIssueCommentRequest, Operation> deleteIssueCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIssueCommentCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
