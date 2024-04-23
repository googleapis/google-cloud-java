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
 * REST stub implementation for the CloudDeploy service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCloudDeployStub extends CloudDeployStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Rollout.getDescriptor())
          .add(Automation.getDescriptor())
          .add(DeliveryPipeline.getDescriptor())
          .add(Target.getDescriptor())
          .add(CustomTargetType.getDescriptor())
          .add(Release.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
      listDeliveryPipelinesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListDeliveryPipelines")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeliveryPipelinesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/deliveryPipelines",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeliveryPipelinesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeliveryPipelinesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDeliveryPipelinesResponse>newBuilder()
                      .setDefaultInstance(ListDeliveryPipelinesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeliveryPipelineRequest, DeliveryPipeline>
      getDeliveryPipelineMethodDescriptor =
          ApiMethodDescriptor.<GetDeliveryPipelineRequest, DeliveryPipeline>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetDeliveryPipeline")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeliveryPipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeliveryPipeline>newBuilder()
                      .setDefaultInstance(DeliveryPipeline.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDeliveryPipelineRequest, Operation>
      createDeliveryPipelineMethodDescriptor =
          ApiMethodDescriptor.<CreateDeliveryPipelineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CreateDeliveryPipeline")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeliveryPipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/deliveryPipelines",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deliveryPipelineId", request.getDeliveryPipelineId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deliveryPipeline", request.getDeliveryPipeline(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDeliveryPipelineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDeliveryPipelineRequest, Operation>
      updateDeliveryPipelineMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeliveryPipelineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/UpdateDeliveryPipeline")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeliveryPipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{deliveryPipeline.name=projects/*/locations/*/deliveryPipelines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "deliveryPipeline.name",
                                request.getDeliveryPipeline().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deliveryPipeline", request.getDeliveryPipeline(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDeliveryPipelineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDeliveryPipelineRequest, Operation>
      deleteDeliveryPipelineMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeliveryPipelineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/DeleteDeliveryPipeline")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeliveryPipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeliveryPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteDeliveryPipelineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListTargetsRequest, ListTargetsResponse>
      listTargetsMethodDescriptor =
          ApiMethodDescriptor.<ListTargetsRequest, ListTargetsResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListTargets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/targets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListTargetsResponse>newBuilder()
                      .setDefaultInstance(ListTargetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RollbackTargetRequest, RollbackTargetResponse>
      rollbackTargetMethodDescriptor =
          ApiMethodDescriptor.<RollbackTargetRequest, RollbackTargetResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/RollbackTarget")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RollbackTargetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*}:rollbackTarget",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackTargetRequest> serializer =
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
                  ProtoMessageResponseParser.<RollbackTargetResponse>newBuilder()
                      .setDefaultInstance(RollbackTargetResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTargetRequest, Target> getTargetMethodDescriptor =
      ApiMethodDescriptor.<GetTargetRequest, Target>newBuilder()
          .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetTarget")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTargetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/targets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTargetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTargetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Target>newBuilder()
                  .setDefaultInstance(Target.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateTargetRequest, Operation>
      createTargetMethodDescriptor =
          ApiMethodDescriptor.<CreateTargetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CreateTarget")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTargetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/targets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "targetId", request.getTargetId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("target", request.getTarget(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTargetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTargetRequest, Operation>
      updateTargetMethodDescriptor =
          ApiMethodDescriptor.<UpdateTargetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/UpdateTarget")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTargetRequest>newBuilder()
                      .setPath(
                          "/v1/{target.name=projects/*/locations/*/targets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "target.name", request.getTarget().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("target", request.getTarget(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTargetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTargetRequest, Operation>
      deleteTargetMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/DeleteTarget")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/targets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteTargetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListCustomTargetTypesRequest, ListCustomTargetTypesResponse>
      listCustomTargetTypesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListCustomTargetTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomTargetTypesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/customTargetTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetTypesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCustomTargetTypesResponse>newBuilder()
                      .setDefaultInstance(ListCustomTargetTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCustomTargetTypeRequest, CustomTargetType>
      getCustomTargetTypeMethodDescriptor =
          ApiMethodDescriptor.<GetCustomTargetTypeRequest, CustomTargetType>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetCustomTargetType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomTargetTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/customTargetTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetType>newBuilder()
                      .setDefaultInstance(CustomTargetType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomTargetTypeRequest, Operation>
      createCustomTargetTypeMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomTargetTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CreateCustomTargetType")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomTargetTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/customTargetTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "customTargetTypeId", request.getCustomTargetTypeId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customTargetType", request.getCustomTargetType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCustomTargetTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateCustomTargetTypeRequest, Operation>
      updateCustomTargetTypeMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomTargetTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/UpdateCustomTargetType")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomTargetTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{customTargetType.name=projects/*/locations/*/customTargetTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "customTargetType.name",
                                request.getCustomTargetType().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customTargetType", request.getCustomTargetType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCustomTargetTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCustomTargetTypeRequest, Operation>
      deleteCustomTargetTypeMethodDescriptor =
          ApiMethodDescriptor.<DeleteCustomTargetTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/DeleteCustomTargetType")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCustomTargetTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/customTargetTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomTargetTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteCustomTargetTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListReleasesRequest, ListReleasesResponse>
      listReleasesMethodDescriptor =
          ApiMethodDescriptor.<ListReleasesRequest, ListReleasesResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListReleases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReleasesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*}/releases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleasesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReleasesResponse>newBuilder()
                      .setDefaultInstance(ListReleasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReleaseRequest, Release> getReleaseMethodDescriptor =
      ApiMethodDescriptor.<GetReleaseRequest, Release>newBuilder()
          .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetRelease")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetReleaseRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetReleaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetReleaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Release>newBuilder()
                  .setDefaultInstance(Release.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateReleaseRequest, Operation>
      createReleaseMethodDescriptor =
          ApiMethodDescriptor.<CreateReleaseRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CreateRelease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReleaseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*}/releases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "releaseId", request.getReleaseId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("release", request.getRelease(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateReleaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AbandonReleaseRequest, AbandonReleaseResponse>
      abandonReleaseMethodDescriptor =
          ApiMethodDescriptor.<AbandonReleaseRequest, AbandonReleaseResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/AbandonRelease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AbandonReleaseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*}:abandon",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AbandonReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AbandonReleaseRequest> serializer =
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
                  ProtoMessageResponseParser.<AbandonReleaseResponse>newBuilder()
                      .setDefaultInstance(AbandonReleaseResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ApproveRolloutRequest, ApproveRolloutResponse>
      approveRolloutMethodDescriptor =
          ApiMethodDescriptor.<ApproveRolloutRequest, ApproveRolloutResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ApproveRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApproveRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveRolloutRequest> serializer =
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
                  ProtoMessageResponseParser.<ApproveRolloutResponse>newBuilder()
                      .setDefaultInstance(ApproveRolloutResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AdvanceRolloutRequest, AdvanceRolloutResponse>
      advanceRolloutMethodDescriptor =
          ApiMethodDescriptor.<AdvanceRolloutRequest, AdvanceRolloutResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/AdvanceRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AdvanceRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*}:advance",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AdvanceRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AdvanceRolloutRequest> serializer =
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
                  ProtoMessageResponseParser.<AdvanceRolloutResponse>newBuilder()
                      .setDefaultInstance(AdvanceRolloutResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CancelRolloutRequest, CancelRolloutResponse>
      cancelRolloutMethodDescriptor =
          ApiMethodDescriptor.<CancelRolloutRequest, CancelRolloutResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CancelRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelRolloutRequest> serializer =
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
                  ProtoMessageResponseParser.<CancelRolloutResponse>newBuilder()
                      .setDefaultInstance(CancelRolloutResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRolloutsRequest, ListRolloutsResponse>
      listRolloutsMethodDescriptor =
          ApiMethodDescriptor.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListRollouts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRolloutsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*/releases/*}/rollouts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRolloutsResponse>newBuilder()
                      .setDefaultInstance(ListRolloutsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRolloutRequest, Rollout> getRolloutMethodDescriptor =
      ApiMethodDescriptor.<GetRolloutRequest, Rollout>newBuilder()
          .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetRollout")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRolloutRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRolloutRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRolloutRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Rollout>newBuilder()
                  .setDefaultInstance(Rollout.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateRolloutRequest, Operation>
      createRolloutMethodDescriptor =
          ApiMethodDescriptor.<CreateRolloutRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CreateRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*/releases/*}/rollouts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "rolloutId", request.getRolloutId());
                            serializer.putQueryParam(
                                fields, "startingPhaseId", request.getStartingPhaseId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rollout", request.getRollout(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRolloutRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<IgnoreJobRequest, IgnoreJobResponse>
      ignoreJobMethodDescriptor =
          ApiMethodDescriptor.<IgnoreJobRequest, IgnoreJobResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/IgnoreJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<IgnoreJobRequest>newBuilder()
                      .setPath(
                          "/v1/{rollout=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*}:ignoreJob",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<IgnoreJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "rollout", request.getRollout());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<IgnoreJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearRollout().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IgnoreJobResponse>newBuilder()
                      .setDefaultInstance(IgnoreJobResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RetryJobRequest, RetryJobResponse>
      retryJobMethodDescriptor =
          ApiMethodDescriptor.<RetryJobRequest, RetryJobResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/RetryJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetryJobRequest>newBuilder()
                      .setPath(
                          "/v1/{rollout=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*}:retryJob",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetryJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "rollout", request.getRollout());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetryJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearRollout().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RetryJobResponse>newBuilder()
                      .setDefaultInstance(RetryJobResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListJobRunsRequest, ListJobRunsResponse>
      listJobRunsMethodDescriptor =
          ApiMethodDescriptor.<ListJobRunsRequest, ListJobRunsResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListJobRuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobRunsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*}/jobRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobRunsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListJobRunsResponse>newBuilder()
                      .setDefaultInstance(ListJobRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetJobRunRequest, JobRun> getJobRunMethodDescriptor =
      ApiMethodDescriptor.<GetJobRunRequest, JobRun>newBuilder()
          .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetJobRun")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetJobRunRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*/jobRuns/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<JobRun>newBuilder()
                  .setDefaultInstance(JobRun.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<TerminateJobRunRequest, TerminateJobRunResponse>
      terminateJobRunMethodDescriptor =
          ApiMethodDescriptor.<TerminateJobRunRequest, TerminateJobRunResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/TerminateJobRun")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TerminateJobRunRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/releases/*/rollouts/*/jobRuns/*}:terminate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TerminateJobRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TerminateJobRunRequest> serializer =
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
                  ProtoMessageResponseParser.<TerminateJobRunResponse>newBuilder()
                      .setDefaultInstance(TerminateJobRunResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConfigRequest, Config> getConfigMethodDescriptor =
      ApiMethodDescriptor.<GetConfigRequest, Config>newBuilder()
          .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetConfig")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetConfigRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/config}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetConfigRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetConfigRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Config>newBuilder()
                  .setDefaultInstance(Config.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateAutomationRequest, Operation>
      createAutomationMethodDescriptor =
          ApiMethodDescriptor.<CreateAutomationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CreateAutomation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAutomationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*}/automations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "automationId", request.getAutomationId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("automation", request.getAutomation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAutomationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAutomationRequest, Operation>
      updateAutomationMethodDescriptor =
          ApiMethodDescriptor.<UpdateAutomationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/UpdateAutomation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAutomationRequest>newBuilder()
                      .setPath(
                          "/v1/{automation.name=projects/*/locations/*/deliveryPipelines/*/automations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "automation.name", request.getAutomation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("automation", request.getAutomation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAutomationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAutomationRequest, Operation>
      deleteAutomationMethodDescriptor =
          ApiMethodDescriptor.<DeleteAutomationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/DeleteAutomation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAutomationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/automations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteAutomationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAutomationRequest, Automation>
      getAutomationMethodDescriptor =
          ApiMethodDescriptor.<GetAutomationRequest, Automation>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetAutomation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAutomationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/automations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutomationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Automation>newBuilder()
                      .setDefaultInstance(Automation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAutomationsRequest, ListAutomationsResponse>
      listAutomationsMethodDescriptor =
          ApiMethodDescriptor.<ListAutomationsRequest, ListAutomationsResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListAutomations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAutomationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*}/automations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutomationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutomationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAutomationsResponse>newBuilder()
                      .setDefaultInstance(ListAutomationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAutomationRunRequest, AutomationRun>
      getAutomationRunMethodDescriptor =
          ApiMethodDescriptor.<GetAutomationRunRequest, AutomationRun>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/GetAutomationRun")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAutomationRunRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/automationRuns/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutomationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutomationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutomationRun>newBuilder()
                      .setDefaultInstance(AutomationRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAutomationRunsRequest, ListAutomationRunsResponse>
      listAutomationRunsMethodDescriptor =
          ApiMethodDescriptor.<ListAutomationRunsRequest, ListAutomationRunsResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/ListAutomationRuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAutomationRunsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deliveryPipelines/*}/automationRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutomationRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutomationRunsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAutomationRunsResponse>newBuilder()
                      .setDefaultInstance(ListAutomationRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CancelAutomationRunRequest, CancelAutomationRunResponse>
      cancelAutomationRunMethodDescriptor =
          ApiMethodDescriptor.<CancelAutomationRunRequest, CancelAutomationRunResponse>newBuilder()
              .setFullMethodName("google.cloud.deploy.v1.CloudDeploy/CancelAutomationRun")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelAutomationRunRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deliveryPipelines/*/automationRuns/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelAutomationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelAutomationRunRequest> serializer =
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
                  ProtoMessageResponseParser.<CancelAutomationRunResponse>newBuilder()
                      .setDefaultInstance(CancelAutomationRunResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
                          "/v1/{resource=projects/*/locations/*/deliveryPipelines/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/targets/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/customTargetTypes/*}:setIamPolicy")
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
                          "/v1/{resource=projects/*/locations/*/deliveryPipelines/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/targets/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/customTargetTypes/*}:getIamPolicy")
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
                          "/v1/{resource=projects/*/locations/*/deliveryPipelines/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/targets/*}:testIamPermissions")
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

  private final UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
      listDeliveryPipelinesCallable;
  private final UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesPagedCallable;
  private final UnaryCallable<GetDeliveryPipelineRequest, DeliveryPipeline>
      getDeliveryPipelineCallable;
  private final UnaryCallable<CreateDeliveryPipelineRequest, Operation>
      createDeliveryPipelineCallable;
  private final OperationCallable<
          CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationCallable;
  private final UnaryCallable<UpdateDeliveryPipelineRequest, Operation>
      updateDeliveryPipelineCallable;
  private final OperationCallable<
          UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationCallable;
  private final UnaryCallable<DeleteDeliveryPipelineRequest, Operation>
      deleteDeliveryPipelineCallable;
  private final OperationCallable<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationCallable;
  private final UnaryCallable<ListTargetsRequest, ListTargetsResponse> listTargetsCallable;
  private final UnaryCallable<ListTargetsRequest, ListTargetsPagedResponse>
      listTargetsPagedCallable;
  private final UnaryCallable<RollbackTargetRequest, RollbackTargetResponse> rollbackTargetCallable;
  private final UnaryCallable<GetTargetRequest, Target> getTargetCallable;
  private final UnaryCallable<CreateTargetRequest, Operation> createTargetCallable;
  private final OperationCallable<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationCallable;
  private final UnaryCallable<UpdateTargetRequest, Operation> updateTargetCallable;
  private final OperationCallable<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationCallable;
  private final UnaryCallable<DeleteTargetRequest, Operation> deleteTargetCallable;
  private final OperationCallable<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationCallable;
  private final UnaryCallable<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse>
      listCustomTargetTypesCallable;
  private final UnaryCallable<ListCustomTargetTypesRequest, ListCustomTargetTypesPagedResponse>
      listCustomTargetTypesPagedCallable;
  private final UnaryCallable<GetCustomTargetTypeRequest, CustomTargetType>
      getCustomTargetTypeCallable;
  private final UnaryCallable<CreateCustomTargetTypeRequest, Operation>
      createCustomTargetTypeCallable;
  private final OperationCallable<
          CreateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      createCustomTargetTypeOperationCallable;
  private final UnaryCallable<UpdateCustomTargetTypeRequest, Operation>
      updateCustomTargetTypeCallable;
  private final OperationCallable<
          UpdateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      updateCustomTargetTypeOperationCallable;
  private final UnaryCallable<DeleteCustomTargetTypeRequest, Operation>
      deleteCustomTargetTypeCallable;
  private final OperationCallable<DeleteCustomTargetTypeRequest, Empty, OperationMetadata>
      deleteCustomTargetTypeOperationCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable;
  private final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable;
  private final UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable;
  private final OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable;
  private final UnaryCallable<AbandonReleaseRequest, AbandonReleaseResponse> abandonReleaseCallable;
  private final UnaryCallable<ApproveRolloutRequest, ApproveRolloutResponse> approveRolloutCallable;
  private final UnaryCallable<AdvanceRolloutRequest, AdvanceRolloutResponse> advanceRolloutCallable;
  private final UnaryCallable<CancelRolloutRequest, CancelRolloutResponse> cancelRolloutCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable;
  private final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable;
  private final UnaryCallable<CreateRolloutRequest, Operation> createRolloutCallable;
  private final OperationCallable<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationCallable;
  private final UnaryCallable<IgnoreJobRequest, IgnoreJobResponse> ignoreJobCallable;
  private final UnaryCallable<RetryJobRequest, RetryJobResponse> retryJobCallable;
  private final UnaryCallable<ListJobRunsRequest, ListJobRunsResponse> listJobRunsCallable;
  private final UnaryCallable<ListJobRunsRequest, ListJobRunsPagedResponse>
      listJobRunsPagedCallable;
  private final UnaryCallable<GetJobRunRequest, JobRun> getJobRunCallable;
  private final UnaryCallable<TerminateJobRunRequest, TerminateJobRunResponse>
      terminateJobRunCallable;
  private final UnaryCallable<GetConfigRequest, Config> getConfigCallable;
  private final UnaryCallable<CreateAutomationRequest, Operation> createAutomationCallable;
  private final OperationCallable<CreateAutomationRequest, Automation, OperationMetadata>
      createAutomationOperationCallable;
  private final UnaryCallable<UpdateAutomationRequest, Operation> updateAutomationCallable;
  private final OperationCallable<UpdateAutomationRequest, Automation, OperationMetadata>
      updateAutomationOperationCallable;
  private final UnaryCallable<DeleteAutomationRequest, Operation> deleteAutomationCallable;
  private final OperationCallable<DeleteAutomationRequest, Empty, OperationMetadata>
      deleteAutomationOperationCallable;
  private final UnaryCallable<GetAutomationRequest, Automation> getAutomationCallable;
  private final UnaryCallable<ListAutomationsRequest, ListAutomationsResponse>
      listAutomationsCallable;
  private final UnaryCallable<ListAutomationsRequest, ListAutomationsPagedResponse>
      listAutomationsPagedCallable;
  private final UnaryCallable<GetAutomationRunRequest, AutomationRun> getAutomationRunCallable;
  private final UnaryCallable<ListAutomationRunsRequest, ListAutomationRunsResponse>
      listAutomationRunsCallable;
  private final UnaryCallable<ListAutomationRunsRequest, ListAutomationRunsPagedResponse>
      listAutomationRunsPagedCallable;
  private final UnaryCallable<CancelAutomationRunRequest, CancelAutomationRunResponse>
      cancelAutomationRunCallable;
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

  public static final HttpJsonCloudDeployStub create(CloudDeployStubSettings settings)
      throws IOException {
    return new HttpJsonCloudDeployStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudDeployStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudDeployStub(
        CloudDeployStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudDeployStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudDeployStub(
        CloudDeployStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudDeployStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudDeployStub(CloudDeployStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudDeployCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudDeployStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudDeployStub(
      CloudDeployStubSettings settings,
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

    HttpJsonCallSettings<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
        listDeliveryPipelinesTransportSettings =
            HttpJsonCallSettings
                .<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>newBuilder()
                .setMethodDescriptor(listDeliveryPipelinesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDeliveryPipelineRequest, DeliveryPipeline>
        getDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<GetDeliveryPipelineRequest, DeliveryPipeline>newBuilder()
                .setMethodDescriptor(getDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDeliveryPipelineRequest, Operation>
        createDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<CreateDeliveryPipelineRequest, Operation>newBuilder()
                .setMethodDescriptor(createDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDeliveryPipelineRequest, Operation>
        updateDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<UpdateDeliveryPipelineRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "delivery_pipeline.name",
                          String.valueOf(request.getDeliveryPipeline().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDeliveryPipelineRequest, Operation>
        deleteDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<DeleteDeliveryPipelineRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListTargetsRequest, ListTargetsResponse> listTargetsTransportSettings =
        HttpJsonCallSettings.<ListTargetsRequest, ListTargetsResponse>newBuilder()
            .setMethodDescriptor(listTargetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RollbackTargetRequest, RollbackTargetResponse>
        rollbackTargetTransportSettings =
            HttpJsonCallSettings.<RollbackTargetRequest, RollbackTargetResponse>newBuilder()
                .setMethodDescriptor(rollbackTargetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTargetRequest, Target> getTargetTransportSettings =
        HttpJsonCallSettings.<GetTargetRequest, Target>newBuilder()
            .setMethodDescriptor(getTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTargetRequest, Operation> createTargetTransportSettings =
        HttpJsonCallSettings.<CreateTargetRequest, Operation>newBuilder()
            .setMethodDescriptor(createTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTargetRequest, Operation> updateTargetTransportSettings =
        HttpJsonCallSettings.<UpdateTargetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("target.name", String.valueOf(request.getTarget().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTargetRequest, Operation> deleteTargetTransportSettings =
        HttpJsonCallSettings.<DeleteTargetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse>
        listCustomTargetTypesTransportSettings =
            HttpJsonCallSettings
                .<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse>newBuilder()
                .setMethodDescriptor(listCustomTargetTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCustomTargetTypeRequest, CustomTargetType>
        getCustomTargetTypeTransportSettings =
            HttpJsonCallSettings.<GetCustomTargetTypeRequest, CustomTargetType>newBuilder()
                .setMethodDescriptor(getCustomTargetTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCustomTargetTypeRequest, Operation>
        createCustomTargetTypeTransportSettings =
            HttpJsonCallSettings.<CreateCustomTargetTypeRequest, Operation>newBuilder()
                .setMethodDescriptor(createCustomTargetTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCustomTargetTypeRequest, Operation>
        updateCustomTargetTypeTransportSettings =
            HttpJsonCallSettings.<UpdateCustomTargetTypeRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCustomTargetTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "custom_target_type.name",
                          String.valueOf(request.getCustomTargetType().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCustomTargetTypeRequest, Operation>
        deleteCustomTargetTypeTransportSettings =
            HttpJsonCallSettings.<DeleteCustomTargetTypeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCustomTargetTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListReleasesRequest, ListReleasesResponse> listReleasesTransportSettings =
        HttpJsonCallSettings.<ListReleasesRequest, ListReleasesResponse>newBuilder()
            .setMethodDescriptor(listReleasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetReleaseRequest, Release> getReleaseTransportSettings =
        HttpJsonCallSettings.<GetReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(getReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReleaseRequest, Operation> createReleaseTransportSettings =
        HttpJsonCallSettings.<CreateReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(createReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AbandonReleaseRequest, AbandonReleaseResponse>
        abandonReleaseTransportSettings =
            HttpJsonCallSettings.<AbandonReleaseRequest, AbandonReleaseResponse>newBuilder()
                .setMethodDescriptor(abandonReleaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ApproveRolloutRequest, ApproveRolloutResponse>
        approveRolloutTransportSettings =
            HttpJsonCallSettings.<ApproveRolloutRequest, ApproveRolloutResponse>newBuilder()
                .setMethodDescriptor(approveRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AdvanceRolloutRequest, AdvanceRolloutResponse>
        advanceRolloutTransportSettings =
            HttpJsonCallSettings.<AdvanceRolloutRequest, AdvanceRolloutResponse>newBuilder()
                .setMethodDescriptor(advanceRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CancelRolloutRequest, CancelRolloutResponse>
        cancelRolloutTransportSettings =
            HttpJsonCallSettings.<CancelRolloutRequest, CancelRolloutResponse>newBuilder()
                .setMethodDescriptor(cancelRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListRolloutsRequest, ListRolloutsResponse> listRolloutsTransportSettings =
        HttpJsonCallSettings.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
            .setMethodDescriptor(listRolloutsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRolloutRequest, Rollout> getRolloutTransportSettings =
        HttpJsonCallSettings.<GetRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateRolloutRequest, Operation> createRolloutTransportSettings =
        HttpJsonCallSettings.<CreateRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(createRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<IgnoreJobRequest, IgnoreJobResponse> ignoreJobTransportSettings =
        HttpJsonCallSettings.<IgnoreJobRequest, IgnoreJobResponse>newBuilder()
            .setMethodDescriptor(ignoreJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("rollout", String.valueOf(request.getRollout()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RetryJobRequest, RetryJobResponse> retryJobTransportSettings =
        HttpJsonCallSettings.<RetryJobRequest, RetryJobResponse>newBuilder()
            .setMethodDescriptor(retryJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("rollout", String.valueOf(request.getRollout()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListJobRunsRequest, ListJobRunsResponse> listJobRunsTransportSettings =
        HttpJsonCallSettings.<ListJobRunsRequest, ListJobRunsResponse>newBuilder()
            .setMethodDescriptor(listJobRunsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetJobRunRequest, JobRun> getJobRunTransportSettings =
        HttpJsonCallSettings.<GetJobRunRequest, JobRun>newBuilder()
            .setMethodDescriptor(getJobRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TerminateJobRunRequest, TerminateJobRunResponse>
        terminateJobRunTransportSettings =
            HttpJsonCallSettings.<TerminateJobRunRequest, TerminateJobRunResponse>newBuilder()
                .setMethodDescriptor(terminateJobRunMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConfigRequest, Config> getConfigTransportSettings =
        HttpJsonCallSettings.<GetConfigRequest, Config>newBuilder()
            .setMethodDescriptor(getConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAutomationRequest, Operation> createAutomationTransportSettings =
        HttpJsonCallSettings.<CreateAutomationRequest, Operation>newBuilder()
            .setMethodDescriptor(createAutomationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAutomationRequest, Operation> updateAutomationTransportSettings =
        HttpJsonCallSettings.<UpdateAutomationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAutomationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("automation.name", String.valueOf(request.getAutomation().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAutomationRequest, Operation> deleteAutomationTransportSettings =
        HttpJsonCallSettings.<DeleteAutomationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAutomationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAutomationRequest, Automation> getAutomationTransportSettings =
        HttpJsonCallSettings.<GetAutomationRequest, Automation>newBuilder()
            .setMethodDescriptor(getAutomationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAutomationsRequest, ListAutomationsResponse>
        listAutomationsTransportSettings =
            HttpJsonCallSettings.<ListAutomationsRequest, ListAutomationsResponse>newBuilder()
                .setMethodDescriptor(listAutomationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAutomationRunRequest, AutomationRun> getAutomationRunTransportSettings =
        HttpJsonCallSettings.<GetAutomationRunRequest, AutomationRun>newBuilder()
            .setMethodDescriptor(getAutomationRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAutomationRunsRequest, ListAutomationRunsResponse>
        listAutomationRunsTransportSettings =
            HttpJsonCallSettings.<ListAutomationRunsRequest, ListAutomationRunsResponse>newBuilder()
                .setMethodDescriptor(listAutomationRunsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CancelAutomationRunRequest, CancelAutomationRunResponse>
        cancelAutomationRunTransportSettings =
            HttpJsonCallSettings
                .<CancelAutomationRunRequest, CancelAutomationRunResponse>newBuilder()
                .setMethodDescriptor(cancelAutomationRunMethodDescriptor)
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

    this.listDeliveryPipelinesCallable =
        callableFactory.createUnaryCallable(
            listDeliveryPipelinesTransportSettings,
            settings.listDeliveryPipelinesSettings(),
            clientContext);
    this.listDeliveryPipelinesPagedCallable =
        callableFactory.createPagedCallable(
            listDeliveryPipelinesTransportSettings,
            settings.listDeliveryPipelinesSettings(),
            clientContext);
    this.getDeliveryPipelineCallable =
        callableFactory.createUnaryCallable(
            getDeliveryPipelineTransportSettings,
            settings.getDeliveryPipelineSettings(),
            clientContext);
    this.createDeliveryPipelineCallable =
        callableFactory.createUnaryCallable(
            createDeliveryPipelineTransportSettings,
            settings.createDeliveryPipelineSettings(),
            clientContext);
    this.createDeliveryPipelineOperationCallable =
        callableFactory.createOperationCallable(
            createDeliveryPipelineTransportSettings,
            settings.createDeliveryPipelineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDeliveryPipelineCallable =
        callableFactory.createUnaryCallable(
            updateDeliveryPipelineTransportSettings,
            settings.updateDeliveryPipelineSettings(),
            clientContext);
    this.updateDeliveryPipelineOperationCallable =
        callableFactory.createOperationCallable(
            updateDeliveryPipelineTransportSettings,
            settings.updateDeliveryPipelineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDeliveryPipelineCallable =
        callableFactory.createUnaryCallable(
            deleteDeliveryPipelineTransportSettings,
            settings.deleteDeliveryPipelineSettings(),
            clientContext);
    this.deleteDeliveryPipelineOperationCallable =
        callableFactory.createOperationCallable(
            deleteDeliveryPipelineTransportSettings,
            settings.deleteDeliveryPipelineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listTargetsCallable =
        callableFactory.createUnaryCallable(
            listTargetsTransportSettings, settings.listTargetsSettings(), clientContext);
    this.listTargetsPagedCallable =
        callableFactory.createPagedCallable(
            listTargetsTransportSettings, settings.listTargetsSettings(), clientContext);
    this.rollbackTargetCallable =
        callableFactory.createUnaryCallable(
            rollbackTargetTransportSettings, settings.rollbackTargetSettings(), clientContext);
    this.getTargetCallable =
        callableFactory.createUnaryCallable(
            getTargetTransportSettings, settings.getTargetSettings(), clientContext);
    this.createTargetCallable =
        callableFactory.createUnaryCallable(
            createTargetTransportSettings, settings.createTargetSettings(), clientContext);
    this.createTargetOperationCallable =
        callableFactory.createOperationCallable(
            createTargetTransportSettings,
            settings.createTargetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateTargetCallable =
        callableFactory.createUnaryCallable(
            updateTargetTransportSettings, settings.updateTargetSettings(), clientContext);
    this.updateTargetOperationCallable =
        callableFactory.createOperationCallable(
            updateTargetTransportSettings,
            settings.updateTargetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTargetCallable =
        callableFactory.createUnaryCallable(
            deleteTargetTransportSettings, settings.deleteTargetSettings(), clientContext);
    this.deleteTargetOperationCallable =
        callableFactory.createOperationCallable(
            deleteTargetTransportSettings,
            settings.deleteTargetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCustomTargetTypesCallable =
        callableFactory.createUnaryCallable(
            listCustomTargetTypesTransportSettings,
            settings.listCustomTargetTypesSettings(),
            clientContext);
    this.listCustomTargetTypesPagedCallable =
        callableFactory.createPagedCallable(
            listCustomTargetTypesTransportSettings,
            settings.listCustomTargetTypesSettings(),
            clientContext);
    this.getCustomTargetTypeCallable =
        callableFactory.createUnaryCallable(
            getCustomTargetTypeTransportSettings,
            settings.getCustomTargetTypeSettings(),
            clientContext);
    this.createCustomTargetTypeCallable =
        callableFactory.createUnaryCallable(
            createCustomTargetTypeTransportSettings,
            settings.createCustomTargetTypeSettings(),
            clientContext);
    this.createCustomTargetTypeOperationCallable =
        callableFactory.createOperationCallable(
            createCustomTargetTypeTransportSettings,
            settings.createCustomTargetTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateCustomTargetTypeCallable =
        callableFactory.createUnaryCallable(
            updateCustomTargetTypeTransportSettings,
            settings.updateCustomTargetTypeSettings(),
            clientContext);
    this.updateCustomTargetTypeOperationCallable =
        callableFactory.createOperationCallable(
            updateCustomTargetTypeTransportSettings,
            settings.updateCustomTargetTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteCustomTargetTypeCallable =
        callableFactory.createUnaryCallable(
            deleteCustomTargetTypeTransportSettings,
            settings.deleteCustomTargetTypeSettings(),
            clientContext);
    this.deleteCustomTargetTypeOperationCallable =
        callableFactory.createOperationCallable(
            deleteCustomTargetTypeTransportSettings,
            settings.deleteCustomTargetTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listReleasesCallable =
        callableFactory.createUnaryCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.listReleasesPagedCallable =
        callableFactory.createPagedCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.getReleaseCallable =
        callableFactory.createUnaryCallable(
            getReleaseTransportSettings, settings.getReleaseSettings(), clientContext);
    this.createReleaseCallable =
        callableFactory.createUnaryCallable(
            createReleaseTransportSettings, settings.createReleaseSettings(), clientContext);
    this.createReleaseOperationCallable =
        callableFactory.createOperationCallable(
            createReleaseTransportSettings,
            settings.createReleaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.abandonReleaseCallable =
        callableFactory.createUnaryCallable(
            abandonReleaseTransportSettings, settings.abandonReleaseSettings(), clientContext);
    this.approveRolloutCallable =
        callableFactory.createUnaryCallable(
            approveRolloutTransportSettings, settings.approveRolloutSettings(), clientContext);
    this.advanceRolloutCallable =
        callableFactory.createUnaryCallable(
            advanceRolloutTransportSettings, settings.advanceRolloutSettings(), clientContext);
    this.cancelRolloutCallable =
        callableFactory.createUnaryCallable(
            cancelRolloutTransportSettings, settings.cancelRolloutSettings(), clientContext);
    this.listRolloutsCallable =
        callableFactory.createUnaryCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.listRolloutsPagedCallable =
        callableFactory.createPagedCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.getRolloutCallable =
        callableFactory.createUnaryCallable(
            getRolloutTransportSettings, settings.getRolloutSettings(), clientContext);
    this.createRolloutCallable =
        callableFactory.createUnaryCallable(
            createRolloutTransportSettings, settings.createRolloutSettings(), clientContext);
    this.createRolloutOperationCallable =
        callableFactory.createOperationCallable(
            createRolloutTransportSettings,
            settings.createRolloutOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.ignoreJobCallable =
        callableFactory.createUnaryCallable(
            ignoreJobTransportSettings, settings.ignoreJobSettings(), clientContext);
    this.retryJobCallable =
        callableFactory.createUnaryCallable(
            retryJobTransportSettings, settings.retryJobSettings(), clientContext);
    this.listJobRunsCallable =
        callableFactory.createUnaryCallable(
            listJobRunsTransportSettings, settings.listJobRunsSettings(), clientContext);
    this.listJobRunsPagedCallable =
        callableFactory.createPagedCallable(
            listJobRunsTransportSettings, settings.listJobRunsSettings(), clientContext);
    this.getJobRunCallable =
        callableFactory.createUnaryCallable(
            getJobRunTransportSettings, settings.getJobRunSettings(), clientContext);
    this.terminateJobRunCallable =
        callableFactory.createUnaryCallable(
            terminateJobRunTransportSettings, settings.terminateJobRunSettings(), clientContext);
    this.getConfigCallable =
        callableFactory.createUnaryCallable(
            getConfigTransportSettings, settings.getConfigSettings(), clientContext);
    this.createAutomationCallable =
        callableFactory.createUnaryCallable(
            createAutomationTransportSettings, settings.createAutomationSettings(), clientContext);
    this.createAutomationOperationCallable =
        callableFactory.createOperationCallable(
            createAutomationTransportSettings,
            settings.createAutomationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAutomationCallable =
        callableFactory.createUnaryCallable(
            updateAutomationTransportSettings, settings.updateAutomationSettings(), clientContext);
    this.updateAutomationOperationCallable =
        callableFactory.createOperationCallable(
            updateAutomationTransportSettings,
            settings.updateAutomationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAutomationCallable =
        callableFactory.createUnaryCallable(
            deleteAutomationTransportSettings, settings.deleteAutomationSettings(), clientContext);
    this.deleteAutomationOperationCallable =
        callableFactory.createOperationCallable(
            deleteAutomationTransportSettings,
            settings.deleteAutomationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAutomationCallable =
        callableFactory.createUnaryCallable(
            getAutomationTransportSettings, settings.getAutomationSettings(), clientContext);
    this.listAutomationsCallable =
        callableFactory.createUnaryCallable(
            listAutomationsTransportSettings, settings.listAutomationsSettings(), clientContext);
    this.listAutomationsPagedCallable =
        callableFactory.createPagedCallable(
            listAutomationsTransportSettings, settings.listAutomationsSettings(), clientContext);
    this.getAutomationRunCallable =
        callableFactory.createUnaryCallable(
            getAutomationRunTransportSettings, settings.getAutomationRunSettings(), clientContext);
    this.listAutomationRunsCallable =
        callableFactory.createUnaryCallable(
            listAutomationRunsTransportSettings,
            settings.listAutomationRunsSettings(),
            clientContext);
    this.listAutomationRunsPagedCallable =
        callableFactory.createPagedCallable(
            listAutomationRunsTransportSettings,
            settings.listAutomationRunsSettings(),
            clientContext);
    this.cancelAutomationRunCallable =
        callableFactory.createUnaryCallable(
            cancelAutomationRunTransportSettings,
            settings.cancelAutomationRunSettings(),
            clientContext);
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
    methodDescriptors.add(listDeliveryPipelinesMethodDescriptor);
    methodDescriptors.add(getDeliveryPipelineMethodDescriptor);
    methodDescriptors.add(createDeliveryPipelineMethodDescriptor);
    methodDescriptors.add(updateDeliveryPipelineMethodDescriptor);
    methodDescriptors.add(deleteDeliveryPipelineMethodDescriptor);
    methodDescriptors.add(listTargetsMethodDescriptor);
    methodDescriptors.add(rollbackTargetMethodDescriptor);
    methodDescriptors.add(getTargetMethodDescriptor);
    methodDescriptors.add(createTargetMethodDescriptor);
    methodDescriptors.add(updateTargetMethodDescriptor);
    methodDescriptors.add(deleteTargetMethodDescriptor);
    methodDescriptors.add(listCustomTargetTypesMethodDescriptor);
    methodDescriptors.add(getCustomTargetTypeMethodDescriptor);
    methodDescriptors.add(createCustomTargetTypeMethodDescriptor);
    methodDescriptors.add(updateCustomTargetTypeMethodDescriptor);
    methodDescriptors.add(deleteCustomTargetTypeMethodDescriptor);
    methodDescriptors.add(listReleasesMethodDescriptor);
    methodDescriptors.add(getReleaseMethodDescriptor);
    methodDescriptors.add(createReleaseMethodDescriptor);
    methodDescriptors.add(abandonReleaseMethodDescriptor);
    methodDescriptors.add(approveRolloutMethodDescriptor);
    methodDescriptors.add(advanceRolloutMethodDescriptor);
    methodDescriptors.add(cancelRolloutMethodDescriptor);
    methodDescriptors.add(listRolloutsMethodDescriptor);
    methodDescriptors.add(getRolloutMethodDescriptor);
    methodDescriptors.add(createRolloutMethodDescriptor);
    methodDescriptors.add(ignoreJobMethodDescriptor);
    methodDescriptors.add(retryJobMethodDescriptor);
    methodDescriptors.add(listJobRunsMethodDescriptor);
    methodDescriptors.add(getJobRunMethodDescriptor);
    methodDescriptors.add(terminateJobRunMethodDescriptor);
    methodDescriptors.add(getConfigMethodDescriptor);
    methodDescriptors.add(createAutomationMethodDescriptor);
    methodDescriptors.add(updateAutomationMethodDescriptor);
    methodDescriptors.add(deleteAutomationMethodDescriptor);
    methodDescriptors.add(getAutomationMethodDescriptor);
    methodDescriptors.add(listAutomationsMethodDescriptor);
    methodDescriptors.add(getAutomationRunMethodDescriptor);
    methodDescriptors.add(listAutomationRunsMethodDescriptor);
    methodDescriptors.add(cancelAutomationRunMethodDescriptor);
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
  public UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
      listDeliveryPipelinesCallable() {
    return listDeliveryPipelinesCallable;
  }

  @Override
  public UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesPagedCallable() {
    return listDeliveryPipelinesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDeliveryPipelineRequest, DeliveryPipeline> getDeliveryPipelineCallable() {
    return getDeliveryPipelineCallable;
  }

  @Override
  public UnaryCallable<CreateDeliveryPipelineRequest, Operation> createDeliveryPipelineCallable() {
    return createDeliveryPipelineCallable;
  }

  @Override
  public OperationCallable<CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationCallable() {
    return createDeliveryPipelineOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDeliveryPipelineRequest, Operation> updateDeliveryPipelineCallable() {
    return updateDeliveryPipelineCallable;
  }

  @Override
  public OperationCallable<UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationCallable() {
    return updateDeliveryPipelineOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDeliveryPipelineRequest, Operation> deleteDeliveryPipelineCallable() {
    return deleteDeliveryPipelineCallable;
  }

  @Override
  public OperationCallable<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationCallable() {
    return deleteDeliveryPipelineOperationCallable;
  }

  @Override
  public UnaryCallable<ListTargetsRequest, ListTargetsResponse> listTargetsCallable() {
    return listTargetsCallable;
  }

  @Override
  public UnaryCallable<ListTargetsRequest, ListTargetsPagedResponse> listTargetsPagedCallable() {
    return listTargetsPagedCallable;
  }

  @Override
  public UnaryCallable<RollbackTargetRequest, RollbackTargetResponse> rollbackTargetCallable() {
    return rollbackTargetCallable;
  }

  @Override
  public UnaryCallable<GetTargetRequest, Target> getTargetCallable() {
    return getTargetCallable;
  }

  @Override
  public UnaryCallable<CreateTargetRequest, Operation> createTargetCallable() {
    return createTargetCallable;
  }

  @Override
  public OperationCallable<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationCallable() {
    return createTargetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTargetRequest, Operation> updateTargetCallable() {
    return updateTargetCallable;
  }

  @Override
  public OperationCallable<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationCallable() {
    return updateTargetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetRequest, Operation> deleteTargetCallable() {
    return deleteTargetCallable;
  }

  @Override
  public OperationCallable<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationCallable() {
    return deleteTargetOperationCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetTypesRequest, ListCustomTargetTypesResponse>
      listCustomTargetTypesCallable() {
    return listCustomTargetTypesCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetTypesRequest, ListCustomTargetTypesPagedResponse>
      listCustomTargetTypesPagedCallable() {
    return listCustomTargetTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetCustomTargetTypeRequest, CustomTargetType> getCustomTargetTypeCallable() {
    return getCustomTargetTypeCallable;
  }

  @Override
  public UnaryCallable<CreateCustomTargetTypeRequest, Operation> createCustomTargetTypeCallable() {
    return createCustomTargetTypeCallable;
  }

  @Override
  public OperationCallable<CreateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      createCustomTargetTypeOperationCallable() {
    return createCustomTargetTypeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomTargetTypeRequest, Operation> updateCustomTargetTypeCallable() {
    return updateCustomTargetTypeCallable;
  }

  @Override
  public OperationCallable<UpdateCustomTargetTypeRequest, CustomTargetType, OperationMetadata>
      updateCustomTargetTypeOperationCallable() {
    return updateCustomTargetTypeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomTargetTypeRequest, Operation> deleteCustomTargetTypeCallable() {
    return deleteCustomTargetTypeCallable;
  }

  @Override
  public OperationCallable<DeleteCustomTargetTypeRequest, Empty, OperationMetadata>
      deleteCustomTargetTypeOperationCallable() {
    return deleteCustomTargetTypeOperationCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return listReleasesCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse> listReleasesPagedCallable() {
    return listReleasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return getReleaseCallable;
  }

  @Override
  public UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    return createReleaseCallable;
  }

  @Override
  public OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    return createReleaseOperationCallable;
  }

  @Override
  public UnaryCallable<AbandonReleaseRequest, AbandonReleaseResponse> abandonReleaseCallable() {
    return abandonReleaseCallable;
  }

  @Override
  public UnaryCallable<ApproveRolloutRequest, ApproveRolloutResponse> approveRolloutCallable() {
    return approveRolloutCallable;
  }

  @Override
  public UnaryCallable<AdvanceRolloutRequest, AdvanceRolloutResponse> advanceRolloutCallable() {
    return advanceRolloutCallable;
  }

  @Override
  public UnaryCallable<CancelRolloutRequest, CancelRolloutResponse> cancelRolloutCallable() {
    return cancelRolloutCallable;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return listRolloutsCallable;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse> listRolloutsPagedCallable() {
    return listRolloutsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return getRolloutCallable;
  }

  @Override
  public UnaryCallable<CreateRolloutRequest, Operation> createRolloutCallable() {
    return createRolloutCallable;
  }

  @Override
  public OperationCallable<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationCallable() {
    return createRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<IgnoreJobRequest, IgnoreJobResponse> ignoreJobCallable() {
    return ignoreJobCallable;
  }

  @Override
  public UnaryCallable<RetryJobRequest, RetryJobResponse> retryJobCallable() {
    return retryJobCallable;
  }

  @Override
  public UnaryCallable<ListJobRunsRequest, ListJobRunsResponse> listJobRunsCallable() {
    return listJobRunsCallable;
  }

  @Override
  public UnaryCallable<ListJobRunsRequest, ListJobRunsPagedResponse> listJobRunsPagedCallable() {
    return listJobRunsPagedCallable;
  }

  @Override
  public UnaryCallable<GetJobRunRequest, JobRun> getJobRunCallable() {
    return getJobRunCallable;
  }

  @Override
  public UnaryCallable<TerminateJobRunRequest, TerminateJobRunResponse> terminateJobRunCallable() {
    return terminateJobRunCallable;
  }

  @Override
  public UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return getConfigCallable;
  }

  @Override
  public UnaryCallable<CreateAutomationRequest, Operation> createAutomationCallable() {
    return createAutomationCallable;
  }

  @Override
  public OperationCallable<CreateAutomationRequest, Automation, OperationMetadata>
      createAutomationOperationCallable() {
    return createAutomationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAutomationRequest, Operation> updateAutomationCallable() {
    return updateAutomationCallable;
  }

  @Override
  public OperationCallable<UpdateAutomationRequest, Automation, OperationMetadata>
      updateAutomationOperationCallable() {
    return updateAutomationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAutomationRequest, Operation> deleteAutomationCallable() {
    return deleteAutomationCallable;
  }

  @Override
  public OperationCallable<DeleteAutomationRequest, Empty, OperationMetadata>
      deleteAutomationOperationCallable() {
    return deleteAutomationOperationCallable;
  }

  @Override
  public UnaryCallable<GetAutomationRequest, Automation> getAutomationCallable() {
    return getAutomationCallable;
  }

  @Override
  public UnaryCallable<ListAutomationsRequest, ListAutomationsResponse> listAutomationsCallable() {
    return listAutomationsCallable;
  }

  @Override
  public UnaryCallable<ListAutomationsRequest, ListAutomationsPagedResponse>
      listAutomationsPagedCallable() {
    return listAutomationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAutomationRunRequest, AutomationRun> getAutomationRunCallable() {
    return getAutomationRunCallable;
  }

  @Override
  public UnaryCallable<ListAutomationRunsRequest, ListAutomationRunsResponse>
      listAutomationRunsCallable() {
    return listAutomationRunsCallable;
  }

  @Override
  public UnaryCallable<ListAutomationRunsRequest, ListAutomationRunsPagedResponse>
      listAutomationRunsPagedCallable() {
    return listAutomationRunsPagedCallable;
  }

  @Override
  public UnaryCallable<CancelAutomationRunRequest, CancelAutomationRunResponse>
      cancelAutomationRunCallable() {
    return cancelAutomationRunCallable;
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
