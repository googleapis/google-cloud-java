/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.devtools.cloudbuild.v1.stub;

import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildTriggersPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListWorkerPoolsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloudbuild.v1.ApproveBuildRequest;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildOperationMetadata;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.CancelBuildRequest;
import com.google.cloudbuild.v1.CreateBuildRequest;
import com.google.cloudbuild.v1.CreateBuildTriggerRequest;
import com.google.cloudbuild.v1.CreateWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.CreateWorkerPoolRequest;
import com.google.cloudbuild.v1.DeleteBuildTriggerRequest;
import com.google.cloudbuild.v1.DeleteWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.DeleteWorkerPoolRequest;
import com.google.cloudbuild.v1.GetBuildRequest;
import com.google.cloudbuild.v1.GetBuildTriggerRequest;
import com.google.cloudbuild.v1.GetWorkerPoolRequest;
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
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
 * REST stub implementation for the CloudBuild service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudBuildStub extends CloudBuildStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(DeleteWorkerPoolOperationMetadata.getDescriptor())
          .add(UpdateWorkerPoolOperationMetadata.getDescriptor())
          .add(Build.getDescriptor())
          .add(WorkerPool.getDescriptor())
          .add(CreateWorkerPoolOperationMetadata.getDescriptor())
          .add(BuildOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateBuildRequest, Operation>
      createBuildMethodDescriptor =
          ApiMethodDescriptor.<CreateBuildRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CreateBuild")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBuildRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/builds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBuildRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/locations/*}/builds")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBuildRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("build", request.getBuild(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBuildRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetBuildRequest, Build> getBuildMethodDescriptor =
      ApiMethodDescriptor.<GetBuildRequest, Build>newBuilder()
          .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/GetBuild")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBuildRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/builds/{id}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBuildRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "id", request.getId());
                        serializer.putPathParam(fields, "name", request.getName());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        return fields;
                      })
                  .setAdditionalPaths("/v1/{name=projects/*/locations/*/builds/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBuildRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Build>newBuilder()
                  .setDefaultInstance(Build.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBuildsRequest, ListBuildsResponse>
      listBuildsMethodDescriptor =
          ApiMethodDescriptor.<ListBuildsRequest, ListBuildsResponse>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ListBuilds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBuildsRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/builds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBuildsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/locations/*}/builds")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBuildsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBuildsResponse>newBuilder()
                      .setDefaultInstance(ListBuildsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CancelBuildRequest, Build> cancelBuildMethodDescriptor =
      ApiMethodDescriptor.<CancelBuildRequest, Build>newBuilder()
          .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CancelBuild")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CancelBuildRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/builds/{id}:cancel",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CancelBuildRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "id", request.getId());
                        serializer.putPathParam(fields, "name", request.getName());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        return fields;
                      })
                  .setAdditionalPaths("/v1/{name=projects/*/locations/*/builds/*}:cancel")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CancelBuildRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody(
                                  "*",
                                  request.toBuilder()
                                      .clearId()
                                      .clearName()
                                      .clearProjectId()
                                      .build(),
                                  true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Build>newBuilder()
                  .setDefaultInstance(Build.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RetryBuildRequest, Operation>
      retryBuildMethodDescriptor =
          ApiMethodDescriptor.<RetryBuildRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/RetryBuild")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetryBuildRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/builds/{id}:retry",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetryBuildRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "id", request.getId());
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/builds/*}:retry")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetryBuildRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder()
                                          .clearId()
                                          .clearName()
                                          .clearProjectId()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RetryBuildRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ApproveBuildRequest, Operation>
      approveBuildMethodDescriptor =
          ApiMethodDescriptor.<ApproveBuildRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ApproveBuild")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApproveBuildRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/builds/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveBuildRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/builds/*}:approve")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveBuildRequest> serializer =
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
                  (ApproveBuildRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBuildTriggerRequest, BuildTrigger>
      createBuildTriggerMethodDescriptor =
          ApiMethodDescriptor.<CreateBuildTriggerRequest, BuildTrigger>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CreateBuildTrigger")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBuildTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/triggers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/locations/*}/triggers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("trigger", request.getTrigger(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BuildTrigger>newBuilder()
                      .setDefaultInstance(BuildTrigger.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBuildTriggerRequest, BuildTrigger>
      getBuildTriggerMethodDescriptor =
          ApiMethodDescriptor.<GetBuildTriggerRequest, BuildTrigger>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/GetBuildTrigger")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBuildTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/triggers/{triggerId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "triggerId", request.getTriggerId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/triggers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BuildTrigger>newBuilder()
                      .setDefaultInstance(BuildTrigger.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersMethodDescriptor =
          ApiMethodDescriptor.<ListBuildTriggersRequest, ListBuildTriggersResponse>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ListBuildTriggers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBuildTriggersRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/triggers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBuildTriggersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/locations/*}/triggers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBuildTriggersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBuildTriggersResponse>newBuilder()
                      .setDefaultInstance(ListBuildTriggersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBuildTriggerRequest, Empty>
      deleteBuildTriggerMethodDescriptor =
          ApiMethodDescriptor.<DeleteBuildTriggerRequest, Empty>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/DeleteBuildTrigger")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBuildTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/triggers/{triggerId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "triggerId", request.getTriggerId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/triggers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBuildTriggerRequest, BuildTrigger>
      updateBuildTriggerMethodDescriptor =
          ApiMethodDescriptor.<UpdateBuildTriggerRequest, BuildTrigger>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/UpdateBuildTrigger")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBuildTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/triggers/{triggerId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(
                                fields,
                                "trigger.resourceName",
                                request.getTrigger().getResourceName());
                            serializer.putPathParam(fields, "triggerId", request.getTriggerId());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{trigger.resourceName=projects/*/locations/*/triggers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("trigger", request.getTrigger(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BuildTrigger>newBuilder()
                      .setDefaultInstance(BuildTrigger.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunBuildTriggerRequest, Operation>
      runBuildTriggerMethodDescriptor =
          ApiMethodDescriptor.<RunBuildTriggerRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/RunBuildTrigger")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunBuildTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/triggers/{triggerId}:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "triggerId", request.getTriggerId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/triggers/*}:run")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunBuildTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("source", request.getSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RunBuildTriggerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
      receiveTriggerWebhookMethodDescriptor =
          ApiMethodDescriptor
              .<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ReceiveTriggerWebhook")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReceiveTriggerWebhookRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/triggers/{trigger}:webhook",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReceiveTriggerWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "trigger", request.getTrigger());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/triggers/*}:webhook")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReceiveTriggerWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "secret", request.getSecret());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReceiveTriggerWebhookResponse>newBuilder()
                      .setDefaultInstance(ReceiveTriggerWebhookResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkerPoolRequest, Operation>
      createWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkerPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CreateWorkerPool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/workerPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(
                                fields, "workerPoolId", request.getWorkerPoolId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workerPool", request.getWorkerPool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateWorkerPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetWorkerPoolRequest, WorkerPool>
      getWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<GetWorkerPoolRequest, WorkerPool>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/GetWorkerPool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/workerPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkerPool>newBuilder()
                      .setDefaultInstance(WorkerPool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWorkerPoolRequest, Operation>
      deleteWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkerPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/DeleteWorkerPool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/workerPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteWorkerPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateWorkerPoolRequest, Operation>
      updateWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkerPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/UpdateWorkerPool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{workerPool.name=projects/*/locations/*/workerPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "workerPool.name", request.getWorkerPool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkerPoolRequest> serializer =
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
                                  .toBody("workerPool", request.getWorkerPool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateWorkerPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsMethodDescriptor =
          ApiMethodDescriptor.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ListWorkerPools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkerPoolsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/workerPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkerPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkerPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkerPoolsResponse>newBuilder()
                      .setDefaultInstance(ListWorkerPoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateBuildRequest, Operation> createBuildCallable;
  private final OperationCallable<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationCallable;
  private final UnaryCallable<GetBuildRequest, Build> getBuildCallable;
  private final UnaryCallable<ListBuildsRequest, ListBuildsResponse> listBuildsCallable;
  private final UnaryCallable<ListBuildsRequest, ListBuildsPagedResponse> listBuildsPagedCallable;
  private final UnaryCallable<CancelBuildRequest, Build> cancelBuildCallable;
  private final UnaryCallable<RetryBuildRequest, Operation> retryBuildCallable;
  private final OperationCallable<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationCallable;
  private final UnaryCallable<ApproveBuildRequest, Operation> approveBuildCallable;
  private final OperationCallable<ApproveBuildRequest, Build, BuildOperationMetadata>
      approveBuildOperationCallable;
  private final UnaryCallable<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerCallable;
  private final UnaryCallable<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerCallable;
  private final UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersCallable;
  private final UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersPagedResponse>
      listBuildTriggersPagedCallable;
  private final UnaryCallable<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerCallable;
  private final UnaryCallable<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerCallable;
  private final UnaryCallable<RunBuildTriggerRequest, Operation> runBuildTriggerCallable;
  private final OperationCallable<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationCallable;
  private final UnaryCallable<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
      receiveTriggerWebhookCallable;
  private final UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable;
  private final OperationCallable<
          CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
      createWorkerPoolOperationCallable;
  private final UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable;
  private final UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable;
  private final OperationCallable<DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
      deleteWorkerPoolOperationCallable;
  private final UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable;
  private final OperationCallable<
          UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
      updateWorkerPoolOperationCallable;
  private final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsCallable;
  private final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudBuildStub create(CloudBuildStubSettings settings)
      throws IOException {
    return new HttpJsonCloudBuildStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudBuildStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudBuildStub(
        CloudBuildStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudBuildStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudBuildStub(
        CloudBuildStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudBuildStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudBuildStub(CloudBuildStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudBuildCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudBuildStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudBuildStub(
      CloudBuildStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateBuildRequest, Operation> createBuildTransportSettings =
        HttpJsonCallSettings.<CreateBuildRequest, Operation>newBuilder()
            .setMethodDescriptor(createBuildMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetBuildRequest, Build> getBuildTransportSettings =
        HttpJsonCallSettings.<GetBuildRequest, Build>newBuilder()
            .setMethodDescriptor(getBuildMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBuildsRequest, ListBuildsResponse> listBuildsTransportSettings =
        HttpJsonCallSettings.<ListBuildsRequest, ListBuildsResponse>newBuilder()
            .setMethodDescriptor(listBuildsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CancelBuildRequest, Build> cancelBuildTransportSettings =
        HttpJsonCallSettings.<CancelBuildRequest, Build>newBuilder()
            .setMethodDescriptor(cancelBuildMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RetryBuildRequest, Operation> retryBuildTransportSettings =
        HttpJsonCallSettings.<RetryBuildRequest, Operation>newBuilder()
            .setMethodDescriptor(retryBuildMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ApproveBuildRequest, Operation> approveBuildTransportSettings =
        HttpJsonCallSettings.<ApproveBuildRequest, Operation>newBuilder()
            .setMethodDescriptor(approveBuildMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateBuildTriggerRequest, BuildTrigger>
        createBuildTriggerTransportSettings =
            HttpJsonCallSettings.<CreateBuildTriggerRequest, BuildTrigger>newBuilder()
                .setMethodDescriptor(createBuildTriggerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerTransportSettings =
        HttpJsonCallSettings.<GetBuildTriggerRequest, BuildTrigger>newBuilder()
            .setMethodDescriptor(getBuildTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBuildTriggersRequest, ListBuildTriggersResponse>
        listBuildTriggersTransportSettings =
            HttpJsonCallSettings.<ListBuildTriggersRequest, ListBuildTriggersResponse>newBuilder()
                .setMethodDescriptor(listBuildTriggersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerTransportSettings =
        HttpJsonCallSettings.<DeleteBuildTriggerRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBuildTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateBuildTriggerRequest, BuildTrigger>
        updateBuildTriggerTransportSettings =
            HttpJsonCallSettings.<UpdateBuildTriggerRequest, BuildTrigger>newBuilder()
                .setMethodDescriptor(updateBuildTriggerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RunBuildTriggerRequest, Operation> runBuildTriggerTransportSettings =
        HttpJsonCallSettings.<RunBuildTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(runBuildTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
        receiveTriggerWebhookTransportSettings =
            HttpJsonCallSettings
                .<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>newBuilder()
                .setMethodDescriptor(receiveTriggerWebhookMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolTransportSettings =
        HttpJsonCallSettings.<CreateWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolTransportSettings =
        HttpJsonCallSettings.<GetWorkerPoolRequest, WorkerPool>newBuilder()
            .setMethodDescriptor(getWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolTransportSettings =
        HttpJsonCallSettings.<DeleteWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolTransportSettings =
        HttpJsonCallSettings.<UpdateWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
        listWorkerPoolsTransportSettings =
            HttpJsonCallSettings.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
                .setMethodDescriptor(listWorkerPoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createBuildCallable =
        callableFactory.createUnaryCallable(
            createBuildTransportSettings, settings.createBuildSettings(), clientContext);
    this.createBuildOperationCallable =
        callableFactory.createOperationCallable(
            createBuildTransportSettings,
            settings.createBuildOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getBuildCallable =
        callableFactory.createUnaryCallable(
            getBuildTransportSettings, settings.getBuildSettings(), clientContext);
    this.listBuildsCallable =
        callableFactory.createUnaryCallable(
            listBuildsTransportSettings, settings.listBuildsSettings(), clientContext);
    this.listBuildsPagedCallable =
        callableFactory.createPagedCallable(
            listBuildsTransportSettings, settings.listBuildsSettings(), clientContext);
    this.cancelBuildCallable =
        callableFactory.createUnaryCallable(
            cancelBuildTransportSettings, settings.cancelBuildSettings(), clientContext);
    this.retryBuildCallable =
        callableFactory.createUnaryCallable(
            retryBuildTransportSettings, settings.retryBuildSettings(), clientContext);
    this.retryBuildOperationCallable =
        callableFactory.createOperationCallable(
            retryBuildTransportSettings,
            settings.retryBuildOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.approveBuildCallable =
        callableFactory.createUnaryCallable(
            approveBuildTransportSettings, settings.approveBuildSettings(), clientContext);
    this.approveBuildOperationCallable =
        callableFactory.createOperationCallable(
            approveBuildTransportSettings,
            settings.approveBuildOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            createBuildTriggerTransportSettings,
            settings.createBuildTriggerSettings(),
            clientContext);
    this.getBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            getBuildTriggerTransportSettings, settings.getBuildTriggerSettings(), clientContext);
    this.listBuildTriggersCallable =
        callableFactory.createUnaryCallable(
            listBuildTriggersTransportSettings,
            settings.listBuildTriggersSettings(),
            clientContext);
    this.listBuildTriggersPagedCallable =
        callableFactory.createPagedCallable(
            listBuildTriggersTransportSettings,
            settings.listBuildTriggersSettings(),
            clientContext);
    this.deleteBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteBuildTriggerTransportSettings,
            settings.deleteBuildTriggerSettings(),
            clientContext);
    this.updateBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            updateBuildTriggerTransportSettings,
            settings.updateBuildTriggerSettings(),
            clientContext);
    this.runBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            runBuildTriggerTransportSettings, settings.runBuildTriggerSettings(), clientContext);
    this.runBuildTriggerOperationCallable =
        callableFactory.createOperationCallable(
            runBuildTriggerTransportSettings,
            settings.runBuildTriggerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.receiveTriggerWebhookCallable =
        callableFactory.createUnaryCallable(
            receiveTriggerWebhookTransportSettings,
            settings.receiveTriggerWebhookSettings(),
            clientContext);
    this.createWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            createWorkerPoolTransportSettings, settings.createWorkerPoolSettings(), clientContext);
    this.createWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            createWorkerPoolTransportSettings,
            settings.createWorkerPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            getWorkerPoolTransportSettings, settings.getWorkerPoolSettings(), clientContext);
    this.deleteWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            deleteWorkerPoolTransportSettings, settings.deleteWorkerPoolSettings(), clientContext);
    this.deleteWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkerPoolTransportSettings,
            settings.deleteWorkerPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            updateWorkerPoolTransportSettings, settings.updateWorkerPoolSettings(), clientContext);
    this.updateWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkerPoolTransportSettings,
            settings.updateWorkerPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listWorkerPoolsCallable =
        callableFactory.createUnaryCallable(
            listWorkerPoolsTransportSettings, settings.listWorkerPoolsSettings(), clientContext);
    this.listWorkerPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkerPoolsTransportSettings, settings.listWorkerPoolsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createBuildMethodDescriptor);
    methodDescriptors.add(getBuildMethodDescriptor);
    methodDescriptors.add(listBuildsMethodDescriptor);
    methodDescriptors.add(cancelBuildMethodDescriptor);
    methodDescriptors.add(retryBuildMethodDescriptor);
    methodDescriptors.add(approveBuildMethodDescriptor);
    methodDescriptors.add(createBuildTriggerMethodDescriptor);
    methodDescriptors.add(getBuildTriggerMethodDescriptor);
    methodDescriptors.add(listBuildTriggersMethodDescriptor);
    methodDescriptors.add(deleteBuildTriggerMethodDescriptor);
    methodDescriptors.add(updateBuildTriggerMethodDescriptor);
    methodDescriptors.add(runBuildTriggerMethodDescriptor);
    methodDescriptors.add(receiveTriggerWebhookMethodDescriptor);
    methodDescriptors.add(createWorkerPoolMethodDescriptor);
    methodDescriptors.add(getWorkerPoolMethodDescriptor);
    methodDescriptors.add(deleteWorkerPoolMethodDescriptor);
    methodDescriptors.add(updateWorkerPoolMethodDescriptor);
    methodDescriptors.add(listWorkerPoolsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateBuildRequest, Operation> createBuildCallable() {
    return createBuildCallable;
  }

  @Override
  public OperationCallable<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationCallable() {
    return createBuildOperationCallable;
  }

  @Override
  public UnaryCallable<GetBuildRequest, Build> getBuildCallable() {
    return getBuildCallable;
  }

  @Override
  public UnaryCallable<ListBuildsRequest, ListBuildsResponse> listBuildsCallable() {
    return listBuildsCallable;
  }

  @Override
  public UnaryCallable<ListBuildsRequest, ListBuildsPagedResponse> listBuildsPagedCallable() {
    return listBuildsPagedCallable;
  }

  @Override
  public UnaryCallable<CancelBuildRequest, Build> cancelBuildCallable() {
    return cancelBuildCallable;
  }

  @Override
  public UnaryCallable<RetryBuildRequest, Operation> retryBuildCallable() {
    return retryBuildCallable;
  }

  @Override
  public OperationCallable<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationCallable() {
    return retryBuildOperationCallable;
  }

  @Override
  public UnaryCallable<ApproveBuildRequest, Operation> approveBuildCallable() {
    return approveBuildCallable;
  }

  @Override
  public OperationCallable<ApproveBuildRequest, Build, BuildOperationMetadata>
      approveBuildOperationCallable() {
    return approveBuildOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerCallable() {
    return createBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerCallable() {
    return getBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersCallable() {
    return listBuildTriggersCallable;
  }

  @Override
  public UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersPagedResponse>
      listBuildTriggersPagedCallable() {
    return listBuildTriggersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerCallable() {
    return deleteBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerCallable() {
    return updateBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<RunBuildTriggerRequest, Operation> runBuildTriggerCallable() {
    return runBuildTriggerCallable;
  }

  @Override
  public OperationCallable<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationCallable() {
    return runBuildTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
      receiveTriggerWebhookCallable() {
    return receiveTriggerWebhookCallable;
  }

  @Override
  public UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable() {
    return createWorkerPoolCallable;
  }

  @Override
  public OperationCallable<CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
      createWorkerPoolOperationCallable() {
    return createWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    return getWorkerPoolCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable() {
    return deleteWorkerPoolCallable;
  }

  @Override
  public OperationCallable<DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
      deleteWorkerPoolOperationCallable() {
    return deleteWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable() {
    return updateWorkerPoolCallable;
  }

  @Override
  public OperationCallable<UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
      updateWorkerPoolOperationCallable() {
    return updateWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> listWorkerPoolsCallable() {
    return listWorkerPoolsCallable;
  }

  @Override
  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable() {
    return listWorkerPoolsPagedCallable;
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
