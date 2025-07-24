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

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the SecureSourceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSecureSourceManagerStub extends SecureSourceManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(BatchCreatePullRequestCommentsResponse.getDescriptor())
          .add(PullRequestComment.getDescriptor())
          .add(Hook.getDescriptor())
          .add(Instance.getDescriptor())
          .add(Repository.getDescriptor())
          .add(Issue.getDescriptor())
          .add(IssueComment.getDescriptor())
          .add(PullRequest.getDescriptor())
          .add(BranchRule.getDescriptor())
          .add(Empty.getDescriptor())
          .add(UnresolvePullRequestCommentsResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(ResolvePullRequestCommentsResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInstancesResponse>newBuilder()
                      .setDefaultInstance(ListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance>
      getInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "instanceId", request.getInstanceId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instance", request.getInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteInstance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          ApiMethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListRepositories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRepositoriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/repositories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRepositoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "instance", request.getInstance());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRepositoriesResponse>newBuilder()
                      .setDefaultInstance(ListRepositoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          ApiMethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetRepository")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Repository>newBuilder()
                      .setDefaultInstance(Repository.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateRepositoryRequest, Operation>
      createRepositoryMethodDescriptor =
          ApiMethodDescriptor.<CreateRepositoryRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateRepository")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/repositories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "repositoryId", request.getRepositoryId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("repository", request.getRepository(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRepositoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateRepositoryRequest, Operation>
      updateRepositoryMethodDescriptor =
          ApiMethodDescriptor.<UpdateRepositoryRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateRepository")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1/{repository.name=projects/*/locations/*/repositories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "repository.name", request.getRepository().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("repository", request.getRepository(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRepositoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRepositoryRequest, Operation>
      deleteRepositoryMethodDescriptor =
          ApiMethodDescriptor.<DeleteRepositoryRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteRepository")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRepositoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRepositoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteRepositoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListHooksRequest, ListHooksResponse>
      listHooksMethodDescriptor =
          ApiMethodDescriptor.<ListHooksRequest, ListHooksResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListHooks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHooksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/hooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHooksResponse>newBuilder()
                      .setDefaultInstance(ListHooksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHookRequest, Hook> getHookMethodDescriptor =
      ApiMethodDescriptor.<GetHookRequest, Hook>newBuilder()
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/GetHook")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetHookRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/repositories/*/hooks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetHookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetHookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Hook>newBuilder()
                  .setDefaultInstance(Hook.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateHookRequest, Operation>
      createHookMethodDescriptor =
          ApiMethodDescriptor.<CreateHookRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateHook")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHookRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/hooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "hookId", request.getHookId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("hook", request.getHook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateHookRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateHookRequest, Operation>
      updateHookMethodDescriptor =
          ApiMethodDescriptor.<UpdateHookRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateHook")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHookRequest>newBuilder()
                      .setPath(
                          "/v1/{hook.name=projects/*/locations/*/repositories/*/hooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "hook.name", request.getHook().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("hook", request.getHook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateHookRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteHookRequest, Operation>
      deleteHookMethodDescriptor =
          ApiMethodDescriptor.<DeleteHookRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteHook")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHookRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/hooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteHookRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyRepoMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetIamPolicyRepo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/repositories/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "options", request.getOptions());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyRepoMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/SetIamPolicyRepo")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/repositories/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/TestIamPermissionsRepo")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/repositories/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBranchRuleRequest, Operation>
      createBranchRuleMethodDescriptor =
          ApiMethodDescriptor.<CreateBranchRuleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateBranchRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBranchRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/branchRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "branchRuleId", request.getBranchRuleId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("branchRule", request.getBranchRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBranchRuleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListBranchRulesRequest, ListBranchRulesResponse>
      listBranchRulesMethodDescriptor =
          ApiMethodDescriptor.<ListBranchRulesRequest, ListBranchRulesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListBranchRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBranchRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/branchRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBranchRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBranchRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBranchRulesResponse>newBuilder()
                      .setDefaultInstance(ListBranchRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBranchRuleRequest, BranchRule>
      getBranchRuleMethodDescriptor =
          ApiMethodDescriptor.<GetBranchRuleRequest, BranchRule>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetBranchRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBranchRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/branchRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BranchRule>newBuilder()
                      .setDefaultInstance(BranchRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBranchRuleRequest, Operation>
      updateBranchRuleMethodDescriptor =
          ApiMethodDescriptor.<UpdateBranchRuleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateBranchRule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBranchRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{branchRule.name=projects/*/locations/*/repositories/*/branchRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "branchRule.name", request.getBranchRule().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("branchRule", request.getBranchRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBranchRuleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBranchRuleRequest, Operation>
      deleteBranchRuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteBranchRuleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteBranchRule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBranchRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/branchRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBranchRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteBranchRuleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreatePullRequestRequest, Operation>
      createPullRequestMethodDescriptor =
          ApiMethodDescriptor.<CreatePullRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreatePullRequest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePullRequestRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/pullRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("pullRequest", request.getPullRequest(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePullRequestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPullRequestRequest, PullRequest>
      getPullRequestMethodDescriptor =
          ApiMethodDescriptor.<GetPullRequestRequest, PullRequest>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetPullRequest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPullRequestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/pullRequests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PullRequest>newBuilder()
                      .setDefaultInstance(PullRequest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPullRequestsRequest, ListPullRequestsResponse>
      listPullRequestsMethodDescriptor =
          ApiMethodDescriptor.<ListPullRequestsRequest, ListPullRequestsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListPullRequests")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPullRequestsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/pullRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPullRequestsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPullRequestsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPullRequestsResponse>newBuilder()
                      .setDefaultInstance(ListPullRequestsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePullRequestRequest, Operation>
      updatePullRequestMethodDescriptor =
          ApiMethodDescriptor.<UpdatePullRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdatePullRequest")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePullRequestRequest>newBuilder()
                      .setPath(
                          "/v1/{pullRequest.name=projects/*/locations/*/repositories/*/pullRequests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "pullRequest.name", request.getPullRequest().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("pullRequest", request.getPullRequest(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePullRequestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<MergePullRequestRequest, Operation>
      mergePullRequestMethodDescriptor =
          ApiMethodDescriptor.<MergePullRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/MergePullRequest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MergePullRequestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/pullRequests/*}:merge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MergePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MergePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (MergePullRequestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<OpenPullRequestRequest, Operation>
      openPullRequestMethodDescriptor =
          ApiMethodDescriptor.<OpenPullRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/OpenPullRequest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<OpenPullRequestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/pullRequests/*}:open",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<OpenPullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<OpenPullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (OpenPullRequestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ClosePullRequestRequest, Operation>
      closePullRequestMethodDescriptor =
          ApiMethodDescriptor.<ClosePullRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ClosePullRequest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ClosePullRequestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/pullRequests/*}:close",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ClosePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ClosePullRequestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ClosePullRequestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
      listPullRequestFileDiffsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListPullRequestFileDiffs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPullRequestFileDiffsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/pullRequests/*}:listFileDiffs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPullRequestFileDiffsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPullRequestFileDiffsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPullRequestFileDiffsResponse>newBuilder()
                      .setDefaultInstance(ListPullRequestFileDiffsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchTreeRequest, FetchTreeResponse>
      fetchTreeMethodDescriptor =
          ApiMethodDescriptor.<FetchTreeRequest, FetchTreeResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/FetchTree")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchTreeRequest>newBuilder()
                      .setPath(
                          "/v1/{repository=projects/*/locations/*/repositories/*}:fetchTree",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchTreeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "repository", request.getRepository());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchTreeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "recursive", request.getRecursive());
                            serializer.putQueryParam(fields, "ref", request.getRef());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchTreeResponse>newBuilder()
                      .setDefaultInstance(FetchTreeResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchBlobRequest, FetchBlobResponse>
      fetchBlobMethodDescriptor =
          ApiMethodDescriptor.<FetchBlobRequest, FetchBlobResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/FetchBlob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchBlobRequest>newBuilder()
                      .setPath(
                          "/v1/{repository=projects/*/locations/*/repositories/*}:fetchBlob",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchBlobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "repository", request.getRepository());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchBlobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "sha", request.getSha());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchBlobResponse>newBuilder()
                      .setDefaultInstance(FetchBlobResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateIssueRequest, Operation>
      createIssueMethodDescriptor =
          ApiMethodDescriptor.<CreateIssueRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateIssue")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIssueRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/issues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("issue", request.getIssue(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateIssueRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIssueRequest, Issue> getIssueMethodDescriptor =
      ApiMethodDescriptor.<GetIssueRequest, Issue>newBuilder()
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/GetIssue")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetIssueRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/repositories/*/issues/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Issue>newBuilder()
                  .setDefaultInstance(Issue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListIssuesRequest, ListIssuesResponse>
      listIssuesMethodDescriptor =
          ApiMethodDescriptor.<ListIssuesRequest, ListIssuesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListIssues")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIssuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*}/issues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIssuesResponse>newBuilder()
                      .setDefaultInstance(ListIssuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateIssueRequest, Operation>
      updateIssueMethodDescriptor =
          ApiMethodDescriptor.<UpdateIssueRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateIssue")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIssueRequest>newBuilder()
                      .setPath(
                          "/v1/{issue.name=projects/*/locations/*/repositories/*/issues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "issue.name", request.getIssue().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("issue", request.getIssue(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateIssueRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteIssueRequest, Operation>
      deleteIssueMethodDescriptor =
          ApiMethodDescriptor.<DeleteIssueRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteIssue")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIssueRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/issues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteIssueRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<OpenIssueRequest, Operation> openIssueMethodDescriptor =
      ApiMethodDescriptor.<OpenIssueRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/OpenIssue")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<OpenIssueRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/repositories/*/issues/*}:open",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<OpenIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<OpenIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (OpenIssueRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<CloseIssueRequest, Operation>
      closeIssueMethodDescriptor =
          ApiMethodDescriptor.<CloseIssueRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CloseIssue")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CloseIssueRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/issues/*}:close",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CloseIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CloseIssueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CloseIssueRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPullRequestCommentRequest, PullRequestComment>
      getPullRequestCommentMethodDescriptor =
          ApiMethodDescriptor.<GetPullRequestCommentRequest, PullRequestComment>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetPullRequestComment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPullRequestCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/pullRequests/*/pullRequestComments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PullRequestComment>newBuilder()
                      .setDefaultInstance(PullRequestComment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
      listPullRequestCommentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListPullRequestComments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPullRequestCommentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*/pullRequests/*}/pullRequestComments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPullRequestCommentsResponse>newBuilder()
                      .setDefaultInstance(ListPullRequestCommentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePullRequestCommentRequest, Operation>
      createPullRequestCommentMethodDescriptor =
          ApiMethodDescriptor.<CreatePullRequestCommentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreatePullRequestComment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePullRequestCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*/pullRequests/*}/pullRequestComments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "pullRequestComment", request.getPullRequestComment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePullRequestCommentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePullRequestCommentRequest, Operation>
      updatePullRequestCommentMethodDescriptor =
          ApiMethodDescriptor.<UpdatePullRequestCommentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdatePullRequestComment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePullRequestCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{pullRequestComment.name=projects/*/locations/*/repositories/*/pullRequests/*/pullRequestComments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "pullRequestComment.name",
                                request.getPullRequestComment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "pullRequestComment", request.getPullRequestComment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePullRequestCommentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePullRequestCommentRequest, Operation>
      deletePullRequestCommentMethodDescriptor =
          ApiMethodDescriptor.<DeletePullRequestCommentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeletePullRequestComment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePullRequestCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/pullRequests/*/pullRequestComments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePullRequestCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeletePullRequestCommentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchCreatePullRequestCommentsRequest, Operation>
      batchCreatePullRequestCommentsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreatePullRequestCommentsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/BatchCreatePullRequestComments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreatePullRequestCommentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*/pullRequests/*}/pullRequestComments:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreatePullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreatePullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchCreatePullRequestCommentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResolvePullRequestCommentsRequest, Operation>
      resolvePullRequestCommentsMethodDescriptor =
          ApiMethodDescriptor.<ResolvePullRequestCommentsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ResolvePullRequestComments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResolvePullRequestCommentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*/pullRequests/*}/pullRequestComments:resolve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResolvePullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResolvePullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResolvePullRequestCommentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UnresolvePullRequestCommentsRequest, Operation>
      unresolvePullRequestCommentsMethodDescriptor =
          ApiMethodDescriptor.<UnresolvePullRequestCommentsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UnresolvePullRequestComments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnresolvePullRequestCommentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*/pullRequests/*}/pullRequestComments:unresolve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnresolvePullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnresolvePullRequestCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UnresolvePullRequestCommentsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateIssueCommentRequest, Operation>
      createIssueCommentMethodDescriptor =
          ApiMethodDescriptor.<CreateIssueCommentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateIssueComment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIssueCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*/issues/*}/issueComments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("issueComment", request.getIssueComment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateIssueCommentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIssueCommentRequest, IssueComment>
      getIssueCommentMethodDescriptor =
          ApiMethodDescriptor.<GetIssueCommentRequest, IssueComment>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetIssueComment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIssueCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/issues/*/issueComments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IssueComment>newBuilder()
                      .setDefaultInstance(IssueComment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListIssueCommentsRequest, ListIssueCommentsResponse>
      listIssueCommentsMethodDescriptor =
          ApiMethodDescriptor.<ListIssueCommentsRequest, ListIssueCommentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListIssueComments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIssueCommentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/repositories/*/issues/*}/issueComments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssueCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssueCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIssueCommentsResponse>newBuilder()
                      .setDefaultInstance(ListIssueCommentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateIssueCommentRequest, Operation>
      updateIssueCommentMethodDescriptor =
          ApiMethodDescriptor.<UpdateIssueCommentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/UpdateIssueComment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIssueCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{issueComment.name=projects/*/locations/*/repositories/*/issues/*/issueComments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "issueComment.name", request.getIssueComment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("issueComment", request.getIssueComment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateIssueCommentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteIssueCommentRequest, Operation>
      deleteIssueCommentMethodDescriptor =
          ApiMethodDescriptor.<DeleteIssueCommentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteIssueComment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIssueCommentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/repositories/*/issues/*/issueComments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIssueCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteIssueCommentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/instances/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/instances/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/instances/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSecureSourceManagerStub create(
      SecureSourceManagerStubSettings settings) throws IOException {
    return new HttpJsonSecureSourceManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecureSourceManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecureSourceManagerStub(
        SecureSourceManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSecureSourceManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecureSourceManagerStub(
        SecureSourceManagerStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecureSourceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecureSourceManagerStub(
      SecureSourceManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSecureSourceManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecureSourceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecureSourceManagerStub(
      SecureSourceManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListInstancesRequest, ListInstancesResponse>
        listInstancesTransportSettings =
            HttpJsonCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        HttpJsonCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRepositoriesRequest, ListRepositoriesResponse>
        listRepositoriesTransportSettings =
            HttpJsonCallSettings.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
                .setMethodDescriptor(listRepositoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRepositoryRequest, Repository> getRepositoryTransportSettings =
        HttpJsonCallSettings.<GetRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(getRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateRepositoryRequest, Operation> createRepositoryTransportSettings =
        HttpJsonCallSettings.<CreateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRepositoryRequest, Operation> updateRepositoryTransportSettings =
        HttpJsonCallSettings.<UpdateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository.name", String.valueOf(request.getRepository().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRepositoryRequest, Operation> deleteRepositoryTransportSettings =
        HttpJsonCallSettings.<DeleteRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListHooksRequest, ListHooksResponse> listHooksTransportSettings =
        HttpJsonCallSettings.<ListHooksRequest, ListHooksResponse>newBuilder()
            .setMethodDescriptor(listHooksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetHookRequest, Hook> getHookTransportSettings =
        HttpJsonCallSettings.<GetHookRequest, Hook>newBuilder()
            .setMethodDescriptor(getHookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateHookRequest, Operation> createHookTransportSettings =
        HttpJsonCallSettings.<CreateHookRequest, Operation>newBuilder()
            .setMethodDescriptor(createHookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateHookRequest, Operation> updateHookTransportSettings =
        HttpJsonCallSettings.<UpdateHookRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("hook.name", String.valueOf(request.getHook().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteHookRequest, Operation> deleteHookTransportSettings =
        HttpJsonCallSettings.<DeleteHookRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyRepoTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyRepoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyRepoTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyRepoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsRepoTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsRepoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateBranchRuleRequest, Operation> createBranchRuleTransportSettings =
        HttpJsonCallSettings.<CreateBranchRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(createBranchRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBranchRulesRequest, ListBranchRulesResponse>
        listBranchRulesTransportSettings =
            HttpJsonCallSettings.<ListBranchRulesRequest, ListBranchRulesResponse>newBuilder()
                .setMethodDescriptor(listBranchRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetBranchRuleRequest, BranchRule> getBranchRuleTransportSettings =
        HttpJsonCallSettings.<GetBranchRuleRequest, BranchRule>newBuilder()
            .setMethodDescriptor(getBranchRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBranchRuleRequest, Operation> updateBranchRuleTransportSettings =
        HttpJsonCallSettings.<UpdateBranchRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBranchRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "branch_rule.name", String.valueOf(request.getBranchRule().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBranchRuleRequest, Operation> deleteBranchRuleTransportSettings =
        HttpJsonCallSettings.<DeleteBranchRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBranchRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePullRequestRequest, Operation> createPullRequestTransportSettings =
        HttpJsonCallSettings.<CreatePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(createPullRequestMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetPullRequestRequest, PullRequest> getPullRequestTransportSettings =
        HttpJsonCallSettings.<GetPullRequestRequest, PullRequest>newBuilder()
            .setMethodDescriptor(getPullRequestMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPullRequestsRequest, ListPullRequestsResponse>
        listPullRequestsTransportSettings =
            HttpJsonCallSettings.<ListPullRequestsRequest, ListPullRequestsResponse>newBuilder()
                .setMethodDescriptor(listPullRequestsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePullRequestRequest, Operation> updatePullRequestTransportSettings =
        HttpJsonCallSettings.<UpdatePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePullRequestMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "pull_request.name", String.valueOf(request.getPullRequest().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<MergePullRequestRequest, Operation> mergePullRequestTransportSettings =
        HttpJsonCallSettings.<MergePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(mergePullRequestMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<OpenPullRequestRequest, Operation> openPullRequestTransportSettings =
        HttpJsonCallSettings.<OpenPullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(openPullRequestMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ClosePullRequestRequest, Operation> closePullRequestTransportSettings =
        HttpJsonCallSettings.<ClosePullRequestRequest, Operation>newBuilder()
            .setMethodDescriptor(closePullRequestMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>
        listPullRequestFileDiffsTransportSettings =
            HttpJsonCallSettings
                .<ListPullRequestFileDiffsRequest, ListPullRequestFileDiffsResponse>newBuilder()
                .setMethodDescriptor(listPullRequestFileDiffsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchTreeRequest, FetchTreeResponse> fetchTreeTransportSettings =
        HttpJsonCallSettings.<FetchTreeRequest, FetchTreeResponse>newBuilder()
            .setMethodDescriptor(fetchTreeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository", String.valueOf(request.getRepository()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FetchBlobRequest, FetchBlobResponse> fetchBlobTransportSettings =
        HttpJsonCallSettings.<FetchBlobRequest, FetchBlobResponse>newBuilder()
            .setMethodDescriptor(fetchBlobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository", String.valueOf(request.getRepository()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateIssueRequest, Operation> createIssueTransportSettings =
        HttpJsonCallSettings.<CreateIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIssueRequest, Issue> getIssueTransportSettings =
        HttpJsonCallSettings.<GetIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(getIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesTransportSettings =
        HttpJsonCallSettings.<ListIssuesRequest, ListIssuesResponse>newBuilder()
            .setMethodDescriptor(listIssuesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateIssueRequest, Operation> updateIssueTransportSettings =
        HttpJsonCallSettings.<UpdateIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("issue.name", String.valueOf(request.getIssue().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteIssueRequest, Operation> deleteIssueTransportSettings =
        HttpJsonCallSettings.<DeleteIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<OpenIssueRequest, Operation> openIssueTransportSettings =
        HttpJsonCallSettings.<OpenIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(openIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CloseIssueRequest, Operation> closeIssueTransportSettings =
        HttpJsonCallSettings.<CloseIssueRequest, Operation>newBuilder()
            .setMethodDescriptor(closeIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetPullRequestCommentRequest, PullRequestComment>
        getPullRequestCommentTransportSettings =
            HttpJsonCallSettings.<GetPullRequestCommentRequest, PullRequestComment>newBuilder()
                .setMethodDescriptor(getPullRequestCommentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>
        listPullRequestCommentsTransportSettings =
            HttpJsonCallSettings
                .<ListPullRequestCommentsRequest, ListPullRequestCommentsResponse>newBuilder()
                .setMethodDescriptor(listPullRequestCommentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePullRequestCommentRequest, Operation>
        createPullRequestCommentTransportSettings =
            HttpJsonCallSettings.<CreatePullRequestCommentRequest, Operation>newBuilder()
                .setMethodDescriptor(createPullRequestCommentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePullRequestCommentRequest, Operation>
        updatePullRequestCommentTransportSettings =
            HttpJsonCallSettings.<UpdatePullRequestCommentRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePullRequestCommentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "pull_request_comment.name",
                          String.valueOf(request.getPullRequestComment().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePullRequestCommentRequest, Operation>
        deletePullRequestCommentTransportSettings =
            HttpJsonCallSettings.<DeletePullRequestCommentRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePullRequestCommentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchCreatePullRequestCommentsRequest, Operation>
        batchCreatePullRequestCommentsTransportSettings =
            HttpJsonCallSettings.<BatchCreatePullRequestCommentsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchCreatePullRequestCommentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResolvePullRequestCommentsRequest, Operation>
        resolvePullRequestCommentsTransportSettings =
            HttpJsonCallSettings.<ResolvePullRequestCommentsRequest, Operation>newBuilder()
                .setMethodDescriptor(resolvePullRequestCommentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UnresolvePullRequestCommentsRequest, Operation>
        unresolvePullRequestCommentsTransportSettings =
            HttpJsonCallSettings.<UnresolvePullRequestCommentsRequest, Operation>newBuilder()
                .setMethodDescriptor(unresolvePullRequestCommentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateIssueCommentRequest, Operation> createIssueCommentTransportSettings =
        HttpJsonCallSettings.<CreateIssueCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueCommentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIssueCommentRequest, IssueComment> getIssueCommentTransportSettings =
        HttpJsonCallSettings.<GetIssueCommentRequest, IssueComment>newBuilder()
            .setMethodDescriptor(getIssueCommentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListIssueCommentsRequest, ListIssueCommentsResponse>
        listIssueCommentsTransportSettings =
            HttpJsonCallSettings.<ListIssueCommentsRequest, ListIssueCommentsResponse>newBuilder()
                .setMethodDescriptor(listIssueCommentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateIssueCommentRequest, Operation> updateIssueCommentTransportSettings =
        HttpJsonCallSettings.<UpdateIssueCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIssueCommentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "issue_comment.name", String.valueOf(request.getIssueComment().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteIssueCommentRequest, Operation> deleteIssueCommentTransportSettings =
        HttpJsonCallSettings.<DeleteIssueCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueCommentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.updateRepositoryCallable =
        callableFactory.createUnaryCallable(
            updateRepositoryTransportSettings, settings.updateRepositorySettings(), clientContext);
    this.updateRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            updateRepositoryTransportSettings,
            settings.updateRepositoryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteRepositoryCallable =
        callableFactory.createUnaryCallable(
            deleteRepositoryTransportSettings, settings.deleteRepositorySettings(), clientContext);
    this.deleteRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteRepositoryTransportSettings,
            settings.deleteRepositoryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.updateHookCallable =
        callableFactory.createUnaryCallable(
            updateHookTransportSettings, settings.updateHookSettings(), clientContext);
    this.updateHookOperationCallable =
        callableFactory.createOperationCallable(
            updateHookTransportSettings,
            settings.updateHookOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteHookCallable =
        callableFactory.createUnaryCallable(
            deleteHookTransportSettings, settings.deleteHookSettings(), clientContext);
    this.deleteHookOperationCallable =
        callableFactory.createOperationCallable(
            deleteHookTransportSettings,
            settings.deleteHookOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deleteBranchRuleCallable =
        callableFactory.createUnaryCallable(
            deleteBranchRuleTransportSettings, settings.deleteBranchRuleSettings(), clientContext);
    this.deleteBranchRuleOperationCallable =
        callableFactory.createOperationCallable(
            deleteBranchRuleTransportSettings,
            settings.deleteBranchRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.mergePullRequestCallable =
        callableFactory.createUnaryCallable(
            mergePullRequestTransportSettings, settings.mergePullRequestSettings(), clientContext);
    this.mergePullRequestOperationCallable =
        callableFactory.createOperationCallable(
            mergePullRequestTransportSettings,
            settings.mergePullRequestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.openPullRequestCallable =
        callableFactory.createUnaryCallable(
            openPullRequestTransportSettings, settings.openPullRequestSettings(), clientContext);
    this.openPullRequestOperationCallable =
        callableFactory.createOperationCallable(
            openPullRequestTransportSettings,
            settings.openPullRequestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.closePullRequestCallable =
        callableFactory.createUnaryCallable(
            closePullRequestTransportSettings, settings.closePullRequestSettings(), clientContext);
    this.closePullRequestOperationCallable =
        callableFactory.createOperationCallable(
            closePullRequestTransportSettings,
            settings.closePullRequestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deleteIssueCallable =
        callableFactory.createUnaryCallable(
            deleteIssueTransportSettings, settings.deleteIssueSettings(), clientContext);
    this.deleteIssueOperationCallable =
        callableFactory.createOperationCallable(
            deleteIssueTransportSettings,
            settings.deleteIssueOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.openIssueCallable =
        callableFactory.createUnaryCallable(
            openIssueTransportSettings, settings.openIssueSettings(), clientContext);
    this.openIssueOperationCallable =
        callableFactory.createOperationCallable(
            openIssueTransportSettings,
            settings.openIssueOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.closeIssueCallable =
        callableFactory.createUnaryCallable(
            closeIssueTransportSettings, settings.closeIssueSettings(), clientContext);
    this.closeIssueOperationCallable =
        callableFactory.createOperationCallable(
            closeIssueTransportSettings,
            settings.closeIssueOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(createInstanceMethodDescriptor);
    methodDescriptors.add(deleteInstanceMethodDescriptor);
    methodDescriptors.add(listRepositoriesMethodDescriptor);
    methodDescriptors.add(getRepositoryMethodDescriptor);
    methodDescriptors.add(createRepositoryMethodDescriptor);
    methodDescriptors.add(updateRepositoryMethodDescriptor);
    methodDescriptors.add(deleteRepositoryMethodDescriptor);
    methodDescriptors.add(listHooksMethodDescriptor);
    methodDescriptors.add(getHookMethodDescriptor);
    methodDescriptors.add(createHookMethodDescriptor);
    methodDescriptors.add(updateHookMethodDescriptor);
    methodDescriptors.add(deleteHookMethodDescriptor);
    methodDescriptors.add(getIamPolicyRepoMethodDescriptor);
    methodDescriptors.add(setIamPolicyRepoMethodDescriptor);
    methodDescriptors.add(testIamPermissionsRepoMethodDescriptor);
    methodDescriptors.add(createBranchRuleMethodDescriptor);
    methodDescriptors.add(listBranchRulesMethodDescriptor);
    methodDescriptors.add(getBranchRuleMethodDescriptor);
    methodDescriptors.add(updateBranchRuleMethodDescriptor);
    methodDescriptors.add(deleteBranchRuleMethodDescriptor);
    methodDescriptors.add(createPullRequestMethodDescriptor);
    methodDescriptors.add(getPullRequestMethodDescriptor);
    methodDescriptors.add(listPullRequestsMethodDescriptor);
    methodDescriptors.add(updatePullRequestMethodDescriptor);
    methodDescriptors.add(mergePullRequestMethodDescriptor);
    methodDescriptors.add(openPullRequestMethodDescriptor);
    methodDescriptors.add(closePullRequestMethodDescriptor);
    methodDescriptors.add(listPullRequestFileDiffsMethodDescriptor);
    methodDescriptors.add(fetchTreeMethodDescriptor);
    methodDescriptors.add(fetchBlobMethodDescriptor);
    methodDescriptors.add(createIssueMethodDescriptor);
    methodDescriptors.add(getIssueMethodDescriptor);
    methodDescriptors.add(listIssuesMethodDescriptor);
    methodDescriptors.add(updateIssueMethodDescriptor);
    methodDescriptors.add(deleteIssueMethodDescriptor);
    methodDescriptors.add(openIssueMethodDescriptor);
    methodDescriptors.add(closeIssueMethodDescriptor);
    methodDescriptors.add(getPullRequestCommentMethodDescriptor);
    methodDescriptors.add(listPullRequestCommentsMethodDescriptor);
    methodDescriptors.add(createPullRequestCommentMethodDescriptor);
    methodDescriptors.add(updatePullRequestCommentMethodDescriptor);
    methodDescriptors.add(deletePullRequestCommentMethodDescriptor);
    methodDescriptors.add(batchCreatePullRequestCommentsMethodDescriptor);
    methodDescriptors.add(resolvePullRequestCommentsMethodDescriptor);
    methodDescriptors.add(unresolvePullRequestCommentsMethodDescriptor);
    methodDescriptors.add(createIssueCommentMethodDescriptor);
    methodDescriptors.add(getIssueCommentMethodDescriptor);
    methodDescriptors.add(listIssueCommentsMethodDescriptor);
    methodDescriptors.add(updateIssueCommentMethodDescriptor);
    methodDescriptors.add(deleteIssueCommentMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
