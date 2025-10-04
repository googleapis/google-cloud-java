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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SecureSourceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSecureSourceManagerStub extends SecureSourceManagerStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          MethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListRepositories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          MethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateRepositoryRequest, Operation>
      createRepositoryMethodDescriptor =
          MethodDescriptor.<CreateRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateRepositoryRequest, Operation>
      updateRepositoryMethodDescriptor =
          MethodDescriptor.<UpdateRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteRepositoryRequest, Operation>
      deleteRepositoryMethodDescriptor =
          MethodDescriptor.<DeleteRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListHooksRequest, ListHooksResponse>
      listHooksMethodDescriptor =
          MethodDescriptor.<ListHooksRequest, ListHooksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListHooks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListHooksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListHooksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHookRequest, Hook> getHookMethodDescriptor =
      MethodDescriptor.<GetHookRequest, Hook>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/GetHook")
          .setRequestMarshaller(ProtoUtils.marshaller(GetHookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Hook.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateHookRequest, Operation> createHookMethodDescriptor =
      MethodDescriptor.<CreateHookRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/CreateHook")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateHookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateHookRequest, Operation> updateHookMethodDescriptor =
      MethodDescriptor.<UpdateHookRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateHook")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateHookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteHookRequest, Operation> deleteHookMethodDescriptor =
      MethodDescriptor.<DeleteHookRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteHook")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteHookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyRepoMethodDescriptor =
          MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetIamPolicyRepo")
              .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyRepoMethodDescriptor =
          MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/SetIamPolicyRepo")
              .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/TestIamPermissionsRepo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBranchRuleRequest, Operation>
      createBranchRuleMethodDescriptor =
          MethodDescriptor.<CreateBranchRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateBranchRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBranchRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBranchRulesRequest, ListBranchRulesResponse>
      listBranchRulesMethodDescriptor =
          MethodDescriptor.<ListBranchRulesRequest, ListBranchRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListBranchRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBranchRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBranchRulesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBranchRuleRequest, BranchRule>
      getBranchRuleMethodDescriptor =
          MethodDescriptor.<GetBranchRuleRequest, BranchRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetBranchRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBranchRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BranchRule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBranchRuleRequest, Operation>
      updateBranchRuleMethodDescriptor =
          MethodDescriptor.<UpdateBranchRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateBranchRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBranchRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBranchRuleRequest, Operation>
      deleteBranchRuleMethodDescriptor =
          MethodDescriptor.<DeleteBranchRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteBranchRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBranchRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePullRequestRequest, Operation>
      createPullRequestMethodDescriptor =
          MethodDescriptor.<CreatePullRequestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreatePullRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePullRequestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPullRequestRequest, PullRequest>
      getPullRequestMethodDescriptor =
          MethodDescriptor.<GetPullRequestRequest, PullRequest>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetPullRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPullRequestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PullRequest.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPullRequestsRequest, ListPullRequestsResponse>
      listPullRequestsMethodDescriptor =
          MethodDescriptor.<ListPullRequestsRequest, ListPullRequestsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListPullRequests")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPullRequestsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPullRequestsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePullRequestRequest, Operation>
      updatePullRequestMethodDescriptor =
          MethodDescriptor.<UpdatePullRequestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdatePullRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePullRequestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MergePullRequestRequest, Operation>
      mergePullRequestMethodDescriptor =
          MethodDescriptor.<MergePullRequestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/MergePullRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MergePullRequestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<OpenPullRequestRequest, Operation>
      openPullRequestMethodDescriptor =
          MethodDescriptor.<OpenPullRequestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/OpenPullRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(OpenPullRequestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ClosePullRequestRequest, Operation>
      closePullRequestMethodDescriptor =
          MethodDescriptor.<ClosePullRequestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ClosePullRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ClosePullRequestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
      listPullRequestFileDiffsMethodDescriptor =
          MethodDescriptor
              .<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListPullRequestFileDiffs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPullRequestFileDiffsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPullRequestFileDiffsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FetchTreeRequest, FetchTreeResponse>
      fetchTreeMethodDescriptor =
          MethodDescriptor.<FetchTreeRequest, FetchTreeResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/FetchTree")
              .setRequestMarshaller(ProtoUtils.marshaller(FetchTreeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FetchTreeResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FetchBlobRequest, FetchBlobResponse>
      fetchBlobMethodDescriptor =
          MethodDescriptor.<FetchBlobRequest, FetchBlobResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/FetchBlob")
              .setRequestMarshaller(ProtoUtils.marshaller(FetchBlobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FetchBlobResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateIssueRequest, Operation> createIssueMethodDescriptor =
      MethodDescriptor.<CreateIssueRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/CreateIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIssueRequest, Issue> getIssueMethodDescriptor =
      MethodDescriptor.<GetIssueRequest, Issue>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/GetIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Issue.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListIssuesRequest, ListIssuesResponse>
      listIssuesMethodDescriptor =
          MethodDescriptor.<ListIssuesRequest, ListIssuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListIssues")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIssuesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListIssuesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateIssueRequest, Operation> updateIssueMethodDescriptor =
      MethodDescriptor.<UpdateIssueRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteIssueRequest, Operation> deleteIssueMethodDescriptor =
      MethodDescriptor.<DeleteIssueRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<OpenIssueRequest, Operation> openIssueMethodDescriptor =
      MethodDescriptor.<OpenIssueRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/OpenIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(OpenIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CloseIssueRequest, Operation> closeIssueMethodDescriptor =
      MethodDescriptor.<CloseIssueRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/CloseIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(CloseIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentMethodDescriptor =
          MethodDescriptor.<GetPullRequestCommentRequest, PullRequestComment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetPullRequestComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPullRequestCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PullRequestComment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
      listPullRequestCommentsMethodDescriptor =
          MethodDescriptor
              .<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListPullRequestComments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPullRequestCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPullRequestCommentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentMethodDescriptor =
          MethodDescriptor.<CreatePullRequestCommentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreatePullRequestComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePullRequestCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentMethodDescriptor =
          MethodDescriptor.<UpdatePullRequestCommentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdatePullRequestComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePullRequestCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentMethodDescriptor =
          MethodDescriptor.<DeletePullRequestCommentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeletePullRequestComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePullRequestCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsMethodDescriptor =
          MethodDescriptor.<BatchCreatePullRequestCommentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/BatchCreatePullRequestComments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreatePullRequestCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsMethodDescriptor =
          MethodDescriptor.<ResolvePullRequestCommentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ResolvePullRequestComments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResolvePullRequestCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsMethodDescriptor =
          MethodDescriptor.<UnresolvePullRequestCommentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UnresolvePullRequestComments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UnresolvePullRequestCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateIssueCommentRequest, Operation>
      createIssueCommentMethodDescriptor =
          MethodDescriptor.<CreateIssueCommentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateIssueComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIssueCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIssueCommentRequest, IssueComment>
      getIssueCommentMethodDescriptor =
          MethodDescriptor.<GetIssueCommentRequest, IssueComment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetIssueComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIssueCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IssueComment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListIssueCommentsRequest, ListIssueCommentsResponse>
      listIssueCommentsMethodDescriptor =
          MethodDescriptor.<ListIssueCommentsRequest, ListIssueCommentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListIssueComments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIssueCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIssueCommentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateIssueCommentRequest, Operation>
      updateIssueCommentMethodDescriptor =
          MethodDescriptor.<UpdateIssueCommentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateIssueComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIssueCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteIssueCommentRequest, Operation>
      deleteIssueCommentMethodDescriptor =
          MethodDescriptor.<DeleteIssueCommentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteIssueComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIssueCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable;
  private final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable;
  private final UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable;
  private final OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable;
  private final UnaryCallable<UpdateRepositoryRequest, Operation> updateRepositoryCallable;
  private final OperationCallable<UpdateRepositoryRequest, Repository, OperationMetadata>
      updateRepositoryOperationCallable;
  private final UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable;
  private final OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable;
  private final UnaryCallable<ListHooksRequest, ListHooksResponse> listHooksCallable;
  private final UnaryCallable<ListHooksRequest, ListHooksPagedResponse> listHooksPagedCallable;
  private final UnaryCallable<GetHookRequest, Hook> getHookCallable;
  private final UnaryCallable<CreateHookRequest, Operation> createHookCallable;
  private final OperationCallable<CreateHookRequest, Hook, OperationMetadata>
      createHookOperationCallable;
  private final UnaryCallable<UpdateHookRequest, Operation> updateHookCallable;
  private final OperationCallable<UpdateHookRequest, Hook, OperationMetadata>
      updateHookOperationCallable;
  private final UnaryCallable<DeleteHookRequest, Operation> deleteHookCallable;
  private final OperationCallable<DeleteHookRequest, Empty, OperationMetadata>
      deleteHookOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyRepoCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyRepoCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoCallable;
  private final UnaryCallable<CreateBranchRuleRequest, Operation> createBranchRuleCallable;
  private final OperationCallable<CreateBranchRuleRequest, BranchRule, OperationMetadata>
      createBranchRuleOperationCallable;
  private final UnaryCallable<ListBranchRulesRequest, ListBranchRulesResponse>
      listBranchRulesCallable;
  private final UnaryCallable<ListBranchRulesRequest, ListBranchRulesPagedResponse>
      listBranchRulesPagedCallable;
  private final UnaryCallable<GetBranchRuleRequest, BranchRule> getBranchRuleCallable;
  private final UnaryCallable<UpdateBranchRuleRequest, Operation> updateBranchRuleCallable;
  private final OperationCallable<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
      updateBranchRuleOperationCallable;
  private final UnaryCallable<DeleteBranchRuleRequest, Operation> deleteBranchRuleCallable;
  private final OperationCallable<DeleteBranchRuleRequest, Empty, OperationMetadata>
      deleteBranchRuleOperationCallable;
  private final UnaryCallable<CreatePullRequestRequest, Operation> createPullRequestCallable;
  private final OperationCallable<CreatePullRequestRequest, PullRequest, OperationMetadata>
      createPullRequestOperationCallable;
  private final UnaryCallable<GetPullRequestRequest, PullRequest> getPullRequestCallable;
  private final UnaryCallable<ListPullRequestsRequest, ListPullRequestsResponse>
      listPullRequestsCallable;
  private final UnaryCallable<ListPullRequestsRequest, ListPullRequestsPagedResponse>
      listPullRequestsPagedCallable;
  private final UnaryCallable<UpdatePullRequestRequest, Operation> updatePullRequestCallable;
  private final OperationCallable<UpdatePullRequestRequest, PullRequest, OperationMetadata>
      updatePullRequestOperationCallable;
  private final UnaryCallable<MergePullRequestRequest, Operation> mergePullRequestCallable;
  private final OperationCallable<MergePullRequestRequest, PullRequest, OperationMetadata>
      mergePullRequestOperationCallable;
  private final UnaryCallable<OpenPullRequestRequest, Operation> openPullRequestCallable;
  private final OperationCallable<OpenPullRequestRequest, PullRequest, OperationMetadata>
      openPullRequestOperationCallable;
  private final UnaryCallable<ClosePullRequestRequest, Operation> closePullRequestCallable;
  private final OperationCallable<ClosePullRequestRequest, PullRequest, OperationMetadata>
      closePullRequestOperationCallable;
  private final UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
      listPullRequestFileDiffsCallable;
  private final UnaryCallable<
          ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsPagedResponse>
      listPullRequestFileDiffsPagedCallable;
  private final UnaryCallable<FetchTreeRequest, FetchTreeResponse> fetchTreeCallable;
  private final UnaryCallable<FetchTreeRequest, FetchTreePagedResponse> fetchTreePagedCallable;
  private final UnaryCallable<FetchBlobRequest, FetchBlobResponse> fetchBlobCallable;
  private final UnaryCallable<CreateIssueRequest, Operation> createIssueCallable;
  private final OperationCallable<CreateIssueRequest, Issue, OperationMetadata>
      createIssueOperationCallable;
  private final UnaryCallable<GetIssueRequest, Issue> getIssueCallable;
  private final UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable;
  private final UnaryCallable<ListIssuesRequest, ListIssuesPagedResponse> listIssuesPagedCallable;
  private final UnaryCallable<UpdateIssueRequest, Operation> updateIssueCallable;
  private final OperationCallable<UpdateIssueRequest, Issue, OperationMetadata>
      updateIssueOperationCallable;
  private final UnaryCallable<DeleteIssueRequest, Operation> deleteIssueCallable;
  private final OperationCallable<DeleteIssueRequest, Empty, OperationMetadata>
      deleteIssueOperationCallable;
  private final UnaryCallable<OpenIssueRequest, Operation> openIssueCallable;
  private final OperationCallable<OpenIssueRequest, Issue, OperationMetadata>
      openIssueOperationCallable;
  private final UnaryCallable<CloseIssueRequest, Operation> closeIssueCallable;
  private final OperationCallable<CloseIssueRequest, Issue, OperationMetadata>
      closeIssueOperationCallable;
  private final UnaryCallable<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentCallable;
  private final UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
      listPullRequestCommentsCallable;
  private final UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsPagedResponse>
      listPullRequestCommentsPagedCallable;
  private final UnaryCallable<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentCallable;
  private final OperationCallable<
          CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      createPullRequestCommentOperationCallable;
  private final UnaryCallable<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentCallable;
  private final OperationCallable<
          UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      updatePullRequestCommentOperationCallable;
  private final UnaryCallable<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentCallable;
  private final OperationCallable<DeletePullRequestCommentRequest, Empty, OperationMetadata>
      deletePullRequestCommentOperationCallable;
  private final UnaryCallable<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsCallable;
  private final OperationCallable<
          BatchCreatePullRequestCommentsRequest,
          BatchCreatePullRequestCommentsResponse,
          OperationMetadata>
      batchCreatePullRequestCommentsOperationCallable;
  private final UnaryCallable<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsCallable;
  private final OperationCallable<
          ResolvePullRequestCommentsRequest, ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsOperationCallable;
  private final UnaryCallable<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsCallable;
  private final OperationCallable<
          UnresolvePullRequestCommentsRequest,
          UnresolvePullRequestCommentsResponse,
          OperationMetadata>
      unresolvePullRequestCommentsOperationCallable;
  private final UnaryCallable<CreateIssueCommentRequest, Operation> createIssueCommentCallable;
  private final OperationCallable<CreateIssueCommentRequest, IssueComment, OperationMetadata>
      createIssueCommentOperationCallable;
  private final UnaryCallable<GetIssueCommentRequest, IssueComment> getIssueCommentCallable;
  private final UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsResponse>
      listIssueCommentsCallable;
  private final UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsPagedResponse>
      listIssueCommentsPagedCallable;
  private final UnaryCallable<UpdateIssueCommentRequest, Operation> updateIssueCommentCallable;
  private final OperationCallable<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
      updateIssueCommentOperationCallable;
  private final UnaryCallable<DeleteIssueCommentRequest, Operation> deleteIssueCommentCallable;
  private final OperationCallable<DeleteIssueCommentRequest, Empty, OperationMetadata>
      deleteIssueCommentOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSecureSourceManagerStub create(SecureSourceManagerStubSettings settings)
      throws IOException {
    return new GrpcSecureSourceManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecureSourceManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecureSourceManagerStub(
        SecureSourceManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecureSourceManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecureSourceManagerStub(
        SecureSourceManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecureSourceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecureSourceManagerStub(
      SecureSourceManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSecureSourceManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecureSourceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecureSourceManagerStub(
      SecureSourceManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRepositoriesRequest, ListRepositoriesResponse>
        listRepositoriesTransportSettings =
            GrpcCallSettings.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
                .setMethodDescriptor(listRepositoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRepositoryRequest, Repository> getRepositoryTransportSettings =
        GrpcCallSettings.<GetRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(getRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRepositoryRequest, Operation> createRepositoryTransportSettings =
        GrpcCallSettings.<CreateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRepositoryRequest, Operation> updateRepositoryTransportSettings =
        GrpcCallSettings.<UpdateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository.name", String.valueOf(request.getRepository().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRepositoryRequest, Operation> deleteRepositoryTransportSettings =
        GrpcCallSettings.<DeleteRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListHooksRequest, ListHooksResponse> listHooksTransportSettings =
        GrpcCallSettings.<ListHooksRequest, ListHooksResponse>newBuilder()
            .setMethodDescriptor(listHooksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetHookRequest, Hook> getHookTransportSettings =
        GrpcCallSettings.<GetHookRequest, Hook>newBuilder()
            .setMethodDescriptor(getHookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateHookRequest, Operation> createHookTransportSettings =
        GrpcCallSettings.<CreateHookRequest, Operation>newBuilder()
            .setMethodDescriptor(createHookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateHookRequest, Operation> updateHookTransportSettings =
        GrpcCallSettings.<UpdateHookRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("hook.name", String.valueOf(request.getHook().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHookRequest, Operation> deleteHookTransportSettings =
        GrpcCallSettings.<DeleteHookRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyRepoTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyRepoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyRepoTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyRepoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsRepoTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsRepoMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateBranchRuleRequest, Operation> createBranchRuleTransportSettings =
        GrpcCallSettings.<CreateBranchRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(createBranchRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBranchRulesRequest, ListBranchRulesResponse>
        listBranchRulesTransportSettings =
            GrpcCallSettings.<ListBranchRulesRequest, ListBranchRulesResponse>newBuilder()
                .setMethodDescriptor(listBranchRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetBranchRuleRequest, BranchRule> getBranchRuleTransportSettings =
        GrpcCallSettings.<GetBranchRuleRequest, BranchRule>newBuilder()
            .setMethodDescriptor(getBranchRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBranchRuleRequest, Operation> updateBranchRuleTransportSettings =
        GrpcCallSettings.<UpdateBranchRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBranchRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "branch_rule.name", String.valueOf(request.getBranchRule().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBranchRuleRequest, Operation> deleteBranchRuleTransportSettings =
        GrpcCallSettings.<DeleteBranchRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBranchRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePullRequestRequest, Operation> createPullRequestTransportSettings =
        GrpcCallSettings.<CreatePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(createPullRequestMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPullRequestRequest, PullRequest> getPullRequestTransportSettings =
        GrpcCallSettings.<GetPullRequestRequest, PullRequest>newBuilder()
            .setMethodDescriptor(getPullRequestMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPullRequestsRequest, ListPullRequestsResponse>
        listPullRequestsTransportSettings =
            GrpcCallSettings.<ListPullRequestsRequest, ListPullRequestsResponse>newBuilder()
                .setMethodDescriptor(listPullRequestsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePullRequestRequest, Operation> updatePullRequestTransportSettings =
        GrpcCallSettings.<UpdatePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePullRequestMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "pull_request.name", String.valueOf(request.getPullRequest().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MergePullRequestRequest, Operation> mergePullRequestTransportSettings =
        GrpcCallSettings.<MergePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(mergePullRequestMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<OpenPullRequestRequest, Operation> openPullRequestTransportSettings =
        GrpcCallSettings.<OpenPullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(openPullRequestMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ClosePullRequestRequest, Operation> closePullRequestTransportSettings =
        GrpcCallSettings.<ClosePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(closePullRequestMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
        listPullRequestFileDiffsTransportSettings =
            GrpcCallSettings
                .<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>newBuilder()
                .setMethodDescriptor(listPullRequestFileDiffsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchTreeRequest, FetchTreeResponse> fetchTreeTransportSettings =
        GrpcCallSettings.<FetchTreeRequest, FetchTreeResponse>newBuilder()
            .setMethodDescriptor(fetchTreeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository", String.valueOf(request.getRepository()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<FetchBlobRequest, FetchBlobResponse> fetchBlobTransportSettings =
        GrpcCallSettings.<FetchBlobRequest, FetchBlobResponse>newBuilder()
            .setMethodDescriptor(fetchBlobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository", String.valueOf(request.getRepository()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateIssueRequest, Operation> createIssueTransportSettings =
        GrpcCallSettings.<CreateIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIssueRequest, Issue> getIssueTransportSettings =
        GrpcCallSettings.<GetIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(getIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesTransportSettings =
        GrpcCallSettings.<ListIssuesRequest, ListIssuesResponse>newBuilder()
            .setMethodDescriptor(listIssuesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateIssueRequest, Operation> updateIssueTransportSettings =
        GrpcCallSettings.<UpdateIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("issue.name", String.valueOf(request.getIssue().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIssueRequest, Operation> deleteIssueTransportSettings =
        GrpcCallSettings.<DeleteIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<OpenIssueRequest, Operation> openIssueTransportSettings =
        GrpcCallSettings.<OpenIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(openIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CloseIssueRequest, Operation> closeIssueTransportSettings =
        GrpcCallSettings.<CloseIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(closeIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPullRequestCommentRequest, PullRequestComment>
        getPullRequestCommentTransportSettings =
            GrpcCallSettings.<GetPullRequestCommentRequest, PullRequestComment>newBuilder()
                .setMethodDescriptor(getPullRequestCommentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
        listPullRequestCommentsTransportSettings =
            GrpcCallSettings
                .<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>newBuilder()
                .setMethodDescriptor(listPullRequestCommentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreatePullRequestCommentRequest, Operation>
        createPullRequestCommentTransportSettings =
            GrpcCallSettings.<CreatePullRequestCommentRequest, Operation>newBuilder()
                .setMethodDescriptor(createPullRequestCommentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePullRequestCommentRequest, Operation>
        updatePullRequestCommentTransportSettings =
            GrpcCallSettings.<UpdatePullRequestCommentRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePullRequestCommentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "pull_request_comment.name",
                          String.valueOf(request.getPullRequestComment().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePullRequestCommentRequest, Operation>
        deletePullRequestCommentTransportSettings =
            GrpcCallSettings.<DeletePullRequestCommentRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePullRequestCommentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchCreatePullRequestCommentsRequest, Operation>
        batchCreatePullRequestCommentsTransportSettings =
            GrpcCallSettings.<BatchCreatePullRequestCommentsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchCreatePullRequestCommentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResolvePullRequestCommentsRequest, Operation>
        resolvePullRequestCommentsTransportSettings =
            GrpcCallSettings.<ResolvePullRequestCommentsRequest, Operation>newBuilder()
                .setMethodDescriptor(resolvePullRequestCommentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UnresolvePullRequestCommentsRequest, Operation>
        unresolvePullRequestCommentsTransportSettings =
            GrpcCallSettings.<UnresolvePullRequestCommentsRequest, Operation>newBuilder()
                .setMethodDescriptor(unresolvePullRequestCommentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateIssueCommentRequest, Operation> createIssueCommentTransportSettings =
        GrpcCallSettings.<CreateIssueCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIssueCommentRequest, IssueComment> getIssueCommentTransportSettings =
        GrpcCallSettings.<GetIssueCommentRequest, IssueComment>newBuilder()
            .setMethodDescriptor(getIssueCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIssueCommentsRequest, ListIssueCommentsResponse>
        listIssueCommentsTransportSettings =
            GrpcCallSettings.<ListIssueCommentsRequest, ListIssueCommentsResponse>newBuilder()
                .setMethodDescriptor(listIssueCommentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateIssueCommentRequest, Operation> updateIssueCommentTransportSettings =
        GrpcCallSettings.<UpdateIssueCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIssueCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "issue_comment.name", String.valueOf(request.getIssueComment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIssueCommentRequest, Operation> deleteIssueCommentTransportSettings =
        GrpcCallSettings.<DeleteIssueCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.listRepositoriesCallable =
        callableFactory.createUnaryCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.listRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.getRepositoryCallable =
        callableFactory.createUnaryCallable(
            getRepositoryTransportSettings, settings.getRepositorySettings(), clientContext);
    this.createRepositoryCallable =
        callableFactory.createUnaryCallable(
            createRepositoryTransportSettings, settings.createRepositorySettings(), clientContext);
    this.createRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            createRepositoryTransportSettings,
            settings.createRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRepositoryCallable =
        callableFactory.createUnaryCallable(
            updateRepositoryTransportSettings, settings.updateRepositorySettings(), clientContext);
    this.updateRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            updateRepositoryTransportSettings,
            settings.updateRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRepositoryCallable =
        callableFactory.createUnaryCallable(
            deleteRepositoryTransportSettings, settings.deleteRepositorySettings(), clientContext);
    this.deleteRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteRepositoryTransportSettings,
            settings.deleteRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.listHooksCallable =
        callableFactory.createUnaryCallable(
            listHooksTransportSettings, settings.listHooksSettings(), clientContext);
    this.listHooksPagedCallable =
        callableFactory.createPagedCallable(
            listHooksTransportSettings, settings.listHooksSettings(), clientContext);
    this.getHookCallable =
        callableFactory.createUnaryCallable(
            getHookTransportSettings, settings.getHookSettings(), clientContext);
    this.createHookCallable =
        callableFactory.createUnaryCallable(
            createHookTransportSettings, settings.createHookSettings(), clientContext);
    this.createHookOperationCallable =
        callableFactory.createOperationCallable(
            createHookTransportSettings,
            settings.createHookOperationSettings(),
            clientContext,
            operationsStub);
    this.updateHookCallable =
        callableFactory.createUnaryCallable(
            updateHookTransportSettings, settings.updateHookSettings(), clientContext);
    this.updateHookOperationCallable =
        callableFactory.createOperationCallable(
            updateHookTransportSettings,
            settings.updateHookOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteHookCallable =
        callableFactory.createUnaryCallable(
            deleteHookTransportSettings, settings.deleteHookSettings(), clientContext);
    this.deleteHookOperationCallable =
        callableFactory.createOperationCallable(
            deleteHookTransportSettings,
            settings.deleteHookOperationSettings(),
            clientContext,
            operationsStub);
    this.getIamPolicyRepoCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyRepoTransportSettings, settings.getIamPolicyRepoSettings(), clientContext);
    this.setIamPolicyRepoCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyRepoTransportSettings, settings.setIamPolicyRepoSettings(), clientContext);
    this.testIamPermissionsRepoCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsRepoTransportSettings,
            settings.testIamPermissionsRepoSettings(),
            clientContext);
    this.createBranchRuleCallable =
        callableFactory.createUnaryCallable(
            createBranchRuleTransportSettings, settings.createBranchRuleSettings(), clientContext);
    this.createBranchRuleOperationCallable =
        callableFactory.createOperationCallable(
            createBranchRuleTransportSettings,
            settings.createBranchRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.listBranchRulesCallable =
        callableFactory.createUnaryCallable(
            listBranchRulesTransportSettings, settings.listBranchRulesSettings(), clientContext);
    this.listBranchRulesPagedCallable =
        callableFactory.createPagedCallable(
            listBranchRulesTransportSettings, settings.listBranchRulesSettings(), clientContext);
    this.getBranchRuleCallable =
        callableFactory.createUnaryCallable(
            getBranchRuleTransportSettings, settings.getBranchRuleSettings(), clientContext);
    this.updateBranchRuleCallable =
        callableFactory.createUnaryCallable(
            updateBranchRuleTransportSettings, settings.updateBranchRuleSettings(), clientContext);
    this.updateBranchRuleOperationCallable =
        callableFactory.createOperationCallable(
            updateBranchRuleTransportSettings,
            settings.updateBranchRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBranchRuleCallable =
        callableFactory.createUnaryCallable(
            deleteBranchRuleTransportSettings, settings.deleteBranchRuleSettings(), clientContext);
    this.deleteBranchRuleOperationCallable =
        callableFactory.createOperationCallable(
            deleteBranchRuleTransportSettings,
            settings.deleteBranchRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.createPullRequestCallable =
        callableFactory.createUnaryCallable(
            createPullRequestTransportSettings,
            settings.createPullRequestSettings(),
            clientContext);
    this.createPullRequestOperationCallable =
        callableFactory.createOperationCallable(
            createPullRequestTransportSettings,
            settings.createPullRequestOperationSettings(),
            clientContext,
            operationsStub);
    this.getPullRequestCallable =
        callableFactory.createUnaryCallable(
            getPullRequestTransportSettings, settings.getPullRequestSettings(), clientContext);
    this.listPullRequestsCallable =
        callableFactory.createUnaryCallable(
            listPullRequestsTransportSettings, settings.listPullRequestsSettings(), clientContext);
    this.listPullRequestsPagedCallable =
        callableFactory.createPagedCallable(
            listPullRequestsTransportSettings, settings.listPullRequestsSettings(), clientContext);
    this.updatePullRequestCallable =
        callableFactory.createUnaryCallable(
            updatePullRequestTransportSettings,
            settings.updatePullRequestSettings(),
            clientContext);
    this.updatePullRequestOperationCallable =
        callableFactory.createOperationCallable(
            updatePullRequestTransportSettings,
            settings.updatePullRequestOperationSettings(),
            clientContext,
            operationsStub);
    this.mergePullRequestCallable =
        callableFactory.createUnaryCallable(
            mergePullRequestTransportSettings, settings.mergePullRequestSettings(), clientContext);
    this.mergePullRequestOperationCallable =
        callableFactory.createOperationCallable(
            mergePullRequestTransportSettings,
            settings.mergePullRequestOperationSettings(),
            clientContext,
            operationsStub);
    this.openPullRequestCallable =
        callableFactory.createUnaryCallable(
            openPullRequestTransportSettings, settings.openPullRequestSettings(), clientContext);
    this.openPullRequestOperationCallable =
        callableFactory.createOperationCallable(
            openPullRequestTransportSettings,
            settings.openPullRequestOperationSettings(),
            clientContext,
            operationsStub);
    this.closePullRequestCallable =
        callableFactory.createUnaryCallable(
            closePullRequestTransportSettings, settings.closePullRequestSettings(), clientContext);
    this.closePullRequestOperationCallable =
        callableFactory.createOperationCallable(
            closePullRequestTransportSettings,
            settings.closePullRequestOperationSettings(),
            clientContext,
            operationsStub);
    this.listPullRequestFileDiffsCallable =
        callableFactory.createUnaryCallable(
            listPullRequestFileDiffsTransportSettings,
            settings.listPullRequestFileDiffsSettings(),
            clientContext);
    this.listPullRequestFileDiffsPagedCallable =
        callableFactory.createPagedCallable(
            listPullRequestFileDiffsTransportSettings,
            settings.listPullRequestFileDiffsSettings(),
            clientContext);
    this.fetchTreeCallable =
        callableFactory.createUnaryCallable(
            fetchTreeTransportSettings, settings.fetchTreeSettings(), clientContext);
    this.fetchTreePagedCallable =
        callableFactory.createPagedCallable(
            fetchTreeTransportSettings, settings.fetchTreeSettings(), clientContext);
    this.fetchBlobCallable =
        callableFactory.createUnaryCallable(
            fetchBlobTransportSettings, settings.fetchBlobSettings(), clientContext);
    this.createIssueCallable =
        callableFactory.createUnaryCallable(
            createIssueTransportSettings, settings.createIssueSettings(), clientContext);
    this.createIssueOperationCallable =
        callableFactory.createOperationCallable(
            createIssueTransportSettings,
            settings.createIssueOperationSettings(),
            clientContext,
            operationsStub);
    this.getIssueCallable =
        callableFactory.createUnaryCallable(
            getIssueTransportSettings, settings.getIssueSettings(), clientContext);
    this.listIssuesCallable =
        callableFactory.createUnaryCallable(
            listIssuesTransportSettings, settings.listIssuesSettings(), clientContext);
    this.listIssuesPagedCallable =
        callableFactory.createPagedCallable(
            listIssuesTransportSettings, settings.listIssuesSettings(), clientContext);
    this.updateIssueCallable =
        callableFactory.createUnaryCallable(
            updateIssueTransportSettings, settings.updateIssueSettings(), clientContext);
    this.updateIssueOperationCallable =
        callableFactory.createOperationCallable(
            updateIssueTransportSettings,
            settings.updateIssueOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteIssueCallable =
        callableFactory.createUnaryCallable(
            deleteIssueTransportSettings, settings.deleteIssueSettings(), clientContext);
    this.deleteIssueOperationCallable =
        callableFactory.createOperationCallable(
            deleteIssueTransportSettings,
            settings.deleteIssueOperationSettings(),
            clientContext,
            operationsStub);
    this.openIssueCallable =
        callableFactory.createUnaryCallable(
            openIssueTransportSettings, settings.openIssueSettings(), clientContext);
    this.openIssueOperationCallable =
        callableFactory.createOperationCallable(
            openIssueTransportSettings,
            settings.openIssueOperationSettings(),
            clientContext,
            operationsStub);
    this.closeIssueCallable =
        callableFactory.createUnaryCallable(
            closeIssueTransportSettings, settings.closeIssueSettings(), clientContext);
    this.closeIssueOperationCallable =
        callableFactory.createOperationCallable(
            closeIssueTransportSettings,
            settings.closeIssueOperationSettings(),
            clientContext,
            operationsStub);
    this.getPullRequestCommentCallable =
        callableFactory.createUnaryCallable(
            getPullRequestCommentTransportSettings,
            settings.getPullRequestCommentSettings(),
            clientContext);
    this.listPullRequestCommentsCallable =
        callableFactory.createUnaryCallable(
            listPullRequestCommentsTransportSettings,
            settings.listPullRequestCommentsSettings(),
            clientContext);
    this.listPullRequestCommentsPagedCallable =
        callableFactory.createPagedCallable(
            listPullRequestCommentsTransportSettings,
            settings.listPullRequestCommentsSettings(),
            clientContext);
    this.createPullRequestCommentCallable =
        callableFactory.createUnaryCallable(
            createPullRequestCommentTransportSettings,
            settings.createPullRequestCommentSettings(),
            clientContext);
    this.createPullRequestCommentOperationCallable =
        callableFactory.createOperationCallable(
            createPullRequestCommentTransportSettings,
            settings.createPullRequestCommentOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePullRequestCommentCallable =
        callableFactory.createUnaryCallable(
            updatePullRequestCommentTransportSettings,
            settings.updatePullRequestCommentSettings(),
            clientContext);
    this.updatePullRequestCommentOperationCallable =
        callableFactory.createOperationCallable(
            updatePullRequestCommentTransportSettings,
            settings.updatePullRequestCommentOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePullRequestCommentCallable =
        callableFactory.createUnaryCallable(
            deletePullRequestCommentTransportSettings,
            settings.deletePullRequestCommentSettings(),
            clientContext);
    this.deletePullRequestCommentOperationCallable =
        callableFactory.createOperationCallable(
            deletePullRequestCommentTransportSettings,
            settings.deletePullRequestCommentOperationSettings(),
            clientContext,
            operationsStub);
    this.batchCreatePullRequestCommentsCallable =
        callableFactory.createUnaryCallable(
            batchCreatePullRequestCommentsTransportSettings,
            settings.batchCreatePullRequestCommentsSettings(),
            clientContext);
    this.batchCreatePullRequestCommentsOperationCallable =
        callableFactory.createOperationCallable(
            batchCreatePullRequestCommentsTransportSettings,
            settings.batchCreatePullRequestCommentsOperationSettings(),
            clientContext,
            operationsStub);
    this.resolvePullRequestCommentsCallable =
        callableFactory.createUnaryCallable(
            resolvePullRequestCommentsTransportSettings,
            settings.resolvePullRequestCommentsSettings(),
            clientContext);
    this.resolvePullRequestCommentsOperationCallable =
        callableFactory.createOperationCallable(
            resolvePullRequestCommentsTransportSettings,
            settings.resolvePullRequestCommentsOperationSettings(),
            clientContext,
            operationsStub);
    this.unresolvePullRequestCommentsCallable =
        callableFactory.createUnaryCallable(
            unresolvePullRequestCommentsTransportSettings,
            settings.unresolvePullRequestCommentsSettings(),
            clientContext);
    this.unresolvePullRequestCommentsOperationCallable =
        callableFactory.createOperationCallable(
            unresolvePullRequestCommentsTransportSettings,
            settings.unresolvePullRequestCommentsOperationSettings(),
            clientContext,
            operationsStub);
    this.createIssueCommentCallable =
        callableFactory.createUnaryCallable(
            createIssueCommentTransportSettings,
            settings.createIssueCommentSettings(),
            clientContext);
    this.createIssueCommentOperationCallable =
        callableFactory.createOperationCallable(
            createIssueCommentTransportSettings,
            settings.createIssueCommentOperationSettings(),
            clientContext,
            operationsStub);
    this.getIssueCommentCallable =
        callableFactory.createUnaryCallable(
            getIssueCommentTransportSettings, settings.getIssueCommentSettings(), clientContext);
    this.listIssueCommentsCallable =
        callableFactory.createUnaryCallable(
            listIssueCommentsTransportSettings,
            settings.listIssueCommentsSettings(),
            clientContext);
    this.listIssueCommentsPagedCallable =
        callableFactory.createPagedCallable(
            listIssueCommentsTransportSettings,
            settings.listIssueCommentsSettings(),
            clientContext);
    this.updateIssueCommentCallable =
        callableFactory.createUnaryCallable(
            updateIssueCommentTransportSettings,
            settings.updateIssueCommentSettings(),
            clientContext);
    this.updateIssueCommentOperationCallable =
        callableFactory.createOperationCallable(
            updateIssueCommentTransportSettings,
            settings.updateIssueCommentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteIssueCommentCallable =
        callableFactory.createUnaryCallable(
            deleteIssueCommentTransportSettings,
            settings.deleteIssueCommentSettings(),
            clientContext);
    this.deleteIssueCommentOperationCallable =
        callableFactory.createOperationCallable(
            deleteIssueCommentTransportSettings,
            settings.deleteIssueCommentOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    return listRepositoriesCallable;
  }

  @Override
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    return listRepositoriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return getRepositoryCallable;
  }

  @Override
  public UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    return createRepositoryCallable;
  }

  @Override
  public OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    return createRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRepositoryRequest, Operation> updateRepositoryCallable() {
    return updateRepositoryCallable;
  }

  @Override
  public OperationCallable<UpdateRepositoryRequest, Repository, OperationMetadata>
      updateRepositoryOperationCallable() {
    return updateRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    return deleteRepositoryCallable;
  }

  @Override
  public OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    return deleteRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<ListHooksRequest, ListHooksResponse> listHooksCallable() {
    return listHooksCallable;
  }

  @Override
  public UnaryCallable<ListHooksRequest, ListHooksPagedResponse> listHooksPagedCallable() {
    return listHooksPagedCallable;
  }

  @Override
  public UnaryCallable<GetHookRequest, Hook> getHookCallable() {
    return getHookCallable;
  }

  @Override
  public UnaryCallable<CreateHookRequest, Operation> createHookCallable() {
    return createHookCallable;
  }

  @Override
  public OperationCallable<CreateHookRequest, Hook, OperationMetadata>
      createHookOperationCallable() {
    return createHookOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHookRequest, Operation> updateHookCallable() {
    return updateHookCallable;
  }

  @Override
  public OperationCallable<UpdateHookRequest, Hook, OperationMetadata>
      updateHookOperationCallable() {
    return updateHookOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHookRequest, Operation> deleteHookCallable() {
    return deleteHookCallable;
  }

  @Override
  public OperationCallable<DeleteHookRequest, Empty, OperationMetadata>
      deleteHookOperationCallable() {
    return deleteHookOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyRepoCallable() {
    return getIamPolicyRepoCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyRepoCallable() {
    return setIamPolicyRepoCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoCallable() {
    return testIamPermissionsRepoCallable;
  }

  @Override
  public UnaryCallable<CreateBranchRuleRequest, Operation> createBranchRuleCallable() {
    return createBranchRuleCallable;
  }

  @Override
  public OperationCallable<CreateBranchRuleRequest, BranchRule, OperationMetadata>
      createBranchRuleOperationCallable() {
    return createBranchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<ListBranchRulesRequest, ListBranchRulesResponse> listBranchRulesCallable() {
    return listBranchRulesCallable;
  }

  @Override
  public UnaryCallable<ListBranchRulesRequest, ListBranchRulesPagedResponse>
      listBranchRulesPagedCallable() {
    return listBranchRulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetBranchRuleRequest, BranchRule> getBranchRuleCallable() {
    return getBranchRuleCallable;
  }

  @Override
  public UnaryCallable<UpdateBranchRuleRequest, Operation> updateBranchRuleCallable() {
    return updateBranchRuleCallable;
  }

  @Override
  public OperationCallable<UpdateBranchRuleRequest, BranchRule, OperationMetadata>
      updateBranchRuleOperationCallable() {
    return updateBranchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBranchRuleRequest, Operation> deleteBranchRuleCallable() {
    return deleteBranchRuleCallable;
  }

  @Override
  public OperationCallable<DeleteBranchRuleRequest, Empty, OperationMetadata>
      deleteBranchRuleOperationCallable() {
    return deleteBranchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<CreatePullRequestRequest, Operation> createPullRequestCallable() {
    return createPullRequestCallable;
  }

  @Override
  public OperationCallable<CreatePullRequestRequest, PullRequest, OperationMetadata>
      createPullRequestOperationCallable() {
    return createPullRequestOperationCallable;
  }

  @Override
  public UnaryCallable<GetPullRequestRequest, PullRequest> getPullRequestCallable() {
    return getPullRequestCallable;
  }

  @Override
  public UnaryCallable<ListPullRequestsRequest, ListPullRequestsResponse>
      listPullRequestsCallable() {
    return listPullRequestsCallable;
  }

  @Override
  public UnaryCallable<ListPullRequestsRequest, ListPullRequestsPagedResponse>
      listPullRequestsPagedCallable() {
    return listPullRequestsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePullRequestRequest, Operation> updatePullRequestCallable() {
    return updatePullRequestCallable;
  }

  @Override
  public OperationCallable<UpdatePullRequestRequest, PullRequest, OperationMetadata>
      updatePullRequestOperationCallable() {
    return updatePullRequestOperationCallable;
  }

  @Override
  public UnaryCallable<MergePullRequestRequest, Operation> mergePullRequestCallable() {
    return mergePullRequestCallable;
  }

  @Override
  public OperationCallable<MergePullRequestRequest, PullRequest, OperationMetadata>
      mergePullRequestOperationCallable() {
    return mergePullRequestOperationCallable;
  }

  @Override
  public UnaryCallable<OpenPullRequestRequest, Operation> openPullRequestCallable() {
    return openPullRequestCallable;
  }

  @Override
  public OperationCallable<OpenPullRequestRequest, PullRequest, OperationMetadata>
      openPullRequestOperationCallable() {
    return openPullRequestOperationCallable;
  }

  @Override
  public UnaryCallable<ClosePullRequestRequest, Operation> closePullRequestCallable() {
    return closePullRequestCallable;
  }

  @Override
  public OperationCallable<ClosePullRequestRequest, PullRequest, OperationMetadata>
      closePullRequestOperationCallable() {
    return closePullRequestOperationCallable;
  }

  @Override
  public UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
      listPullRequestFileDiffsCallable() {
    return listPullRequestFileDiffsCallable;
  }

  @Override
  public UnaryCallable<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsPagedResponse>
      listPullRequestFileDiffsPagedCallable() {
    return listPullRequestFileDiffsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchTreeRequest, FetchTreeResponse> fetchTreeCallable() {
    return fetchTreeCallable;
  }

  @Override
  public UnaryCallable<FetchTreeRequest, FetchTreePagedResponse> fetchTreePagedCallable() {
    return fetchTreePagedCallable;
  }

  @Override
  public UnaryCallable<FetchBlobRequest, FetchBlobResponse> fetchBlobCallable() {
    return fetchBlobCallable;
  }

  @Override
  public UnaryCallable<CreateIssueRequest, Operation> createIssueCallable() {
    return createIssueCallable;
  }

  @Override
  public OperationCallable<CreateIssueRequest, Issue, OperationMetadata>
      createIssueOperationCallable() {
    return createIssueOperationCallable;
  }

  @Override
  public UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    return getIssueCallable;
  }

  @Override
  public UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    return listIssuesCallable;
  }

  @Override
  public UnaryCallable<ListIssuesRequest, ListIssuesPagedResponse> listIssuesPagedCallable() {
    return listIssuesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateIssueRequest, Operation> updateIssueCallable() {
    return updateIssueCallable;
  }

  @Override
  public OperationCallable<UpdateIssueRequest, Issue, OperationMetadata>
      updateIssueOperationCallable() {
    return updateIssueOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteIssueRequest, Operation> deleteIssueCallable() {
    return deleteIssueCallable;
  }

  @Override
  public OperationCallable<DeleteIssueRequest, Empty, OperationMetadata>
      deleteIssueOperationCallable() {
    return deleteIssueOperationCallable;
  }

  @Override
  public UnaryCallable<OpenIssueRequest, Operation> openIssueCallable() {
    return openIssueCallable;
  }

  @Override
  public OperationCallable<OpenIssueRequest, Issue, OperationMetadata>
      openIssueOperationCallable() {
    return openIssueOperationCallable;
  }

  @Override
  public UnaryCallable<CloseIssueRequest, Operation> closeIssueCallable() {
    return closeIssueCallable;
  }

  @Override
  public OperationCallable<CloseIssueRequest, Issue, OperationMetadata>
      closeIssueOperationCallable() {
    return closeIssueOperationCallable;
  }

  @Override
  public UnaryCallable<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentCallable() {
    return getPullRequestCommentCallable;
  }

  @Override
  public UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
      listPullRequestCommentsCallable() {
    return listPullRequestCommentsCallable;
  }

  @Override
  public UnaryCallable<ListPullRequestCommentsRequest, ListPullRequestCommentsPagedResponse>
      listPullRequestCommentsPagedCallable() {
    return listPullRequestCommentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentCallable() {
    return createPullRequestCommentCallable;
  }

  @Override
  public OperationCallable<CreatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      createPullRequestCommentOperationCallable() {
    return createPullRequestCommentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentCallable() {
    return updatePullRequestCommentCallable;
  }

  @Override
  public OperationCallable<UpdatePullRequestCommentRequest, PullRequestComment, OperationMetadata>
      updatePullRequestCommentOperationCallable() {
    return updatePullRequestCommentOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentCallable() {
    return deletePullRequestCommentCallable;
  }

  @Override
  public OperationCallable<DeletePullRequestCommentRequest, Empty, OperationMetadata>
      deletePullRequestCommentOperationCallable() {
    return deletePullRequestCommentOperationCallable;
  }

  @Override
  public UnaryCallable<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsCallable() {
    return batchCreatePullRequestCommentsCallable;
  }

  @Override
  public OperationCallable<
          BatchCreatePullRequestCommentsRequest,
          BatchCreatePullRequestCommentsResponse,
          OperationMetadata>
      batchCreatePullRequestCommentsOperationCallable() {
    return batchCreatePullRequestCommentsOperationCallable;
  }

  @Override
  public UnaryCallable<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsCallable() {
    return resolvePullRequestCommentsCallable;
  }

  @Override
  public OperationCallable<
          ResolvePullRequestCommentsRequest, ResolvePullRequestCommentsResponse, OperationMetadata>
      resolvePullRequestCommentsOperationCallable() {
    return resolvePullRequestCommentsOperationCallable;
  }

  @Override
  public UnaryCallable<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsCallable() {
    return unresolvePullRequestCommentsCallable;
  }

  @Override
  public OperationCallable<
          UnresolvePullRequestCommentsRequest,
          UnresolvePullRequestCommentsResponse,
          OperationMetadata>
      unresolvePullRequestCommentsOperationCallable() {
    return unresolvePullRequestCommentsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateIssueCommentRequest, Operation> createIssueCommentCallable() {
    return createIssueCommentCallable;
  }

  @Override
  public OperationCallable<CreateIssueCommentRequest, IssueComment, OperationMetadata>
      createIssueCommentOperationCallable() {
    return createIssueCommentOperationCallable;
  }

  @Override
  public UnaryCallable<GetIssueCommentRequest, IssueComment> getIssueCommentCallable() {
    return getIssueCommentCallable;
  }

  @Override
  public UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsResponse>
      listIssueCommentsCallable() {
    return listIssueCommentsCallable;
  }

  @Override
  public UnaryCallable<ListIssueCommentsRequest, ListIssueCommentsPagedResponse>
      listIssueCommentsPagedCallable() {
    return listIssueCommentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateIssueCommentRequest, Operation> updateIssueCommentCallable() {
    return updateIssueCommentCallable;
  }

  @Override
  public OperationCallable<UpdateIssueCommentRequest, IssueComment, OperationMetadata>
      updateIssueCommentOperationCallable() {
    return updateIssueCommentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteIssueCommentRequest, Operation> deleteIssueCommentCallable() {
    return deleteIssueCommentCallable;
  }

  @Override
  public OperationCallable<DeleteIssueCommentRequest, Empty, OperationMetadata>
      deleteIssueCommentOperationCallable() {
    return deleteIssueCommentOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
