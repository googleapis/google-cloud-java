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

package com.google.cloud.deploy.v1.stub;

import static com.google.cloud.deploy.v1.CloudDeployClient.ListDeliveryPipelinesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListReleasesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListRolloutsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListTargetsPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.deploy.v1.ApproveRolloutRequest;
import com.google.cloud.deploy.v1.ApproveRolloutResponse;
import com.google.cloud.deploy.v1.Config;
import com.google.cloud.deploy.v1.CreateDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.CreateReleaseRequest;
import com.google.cloud.deploy.v1.CreateRolloutRequest;
import com.google.cloud.deploy.v1.CreateTargetRequest;
import com.google.cloud.deploy.v1.DeleteDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.DeleteTargetRequest;
import com.google.cloud.deploy.v1.DeliveryPipeline;
import com.google.cloud.deploy.v1.GetConfigRequest;
import com.google.cloud.deploy.v1.GetDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.GetReleaseRequest;
import com.google.cloud.deploy.v1.GetRolloutRequest;
import com.google.cloud.deploy.v1.GetTargetRequest;
import com.google.cloud.deploy.v1.ListDeliveryPipelinesRequest;
import com.google.cloud.deploy.v1.ListDeliveryPipelinesResponse;
import com.google.cloud.deploy.v1.ListReleasesRequest;
import com.google.cloud.deploy.v1.ListReleasesResponse;
import com.google.cloud.deploy.v1.ListRolloutsRequest;
import com.google.cloud.deploy.v1.ListRolloutsResponse;
import com.google.cloud.deploy.v1.ListTargetsRequest;
import com.google.cloud.deploy.v1.ListTargetsResponse;
import com.google.cloud.deploy.v1.OperationMetadata;
import com.google.cloud.deploy.v1.Release;
import com.google.cloud.deploy.v1.Rollout;
import com.google.cloud.deploy.v1.Target;
import com.google.cloud.deploy.v1.UpdateDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.UpdateTargetRequest;
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
@BetaApi
public class HttpJsonCloudDeployStub extends CloudDeployStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Rollout.getDescriptor())
          .add(DeliveryPipeline.getDescriptor())
          .add(Target.getDescriptor())
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deliveryPipeline", request.getDeliveryPipeline(), false))
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deliveryPipeline", request.getDeliveryPipeline(), false))
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("target", request.getTarget(), false))
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("target", request.getTarget(), false))
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("release", request.getRelease(), false))
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApproveRolloutResponse>newBuilder()
                      .setDefaultInstance(ApproveRolloutResponse.getDefaultInstance())
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
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rollout", request.getRollout(), false))
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
  private final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable;
  private final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable;
  private final UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable;
  private final OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable;
  private final UnaryCallable<ApproveRolloutRequest, ApproveRolloutResponse> approveRolloutCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable;
  private final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable;
  private final UnaryCallable<CreateRolloutRequest, Operation> createRolloutCallable;
  private final OperationCallable<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationCallable;
  private final UnaryCallable<GetConfigRequest, Config> getConfigCallable;

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
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
        listDeliveryPipelinesTransportSettings =
            HttpJsonCallSettings
                .<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>newBuilder()
                .setMethodDescriptor(listDeliveryPipelinesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDeliveryPipelineRequest, DeliveryPipeline>
        getDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<GetDeliveryPipelineRequest, DeliveryPipeline>newBuilder()
                .setMethodDescriptor(getDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateDeliveryPipelineRequest, Operation>
        createDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<CreateDeliveryPipelineRequest, Operation>newBuilder()
                .setMethodDescriptor(createDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDeliveryPipelineRequest, Operation>
        updateDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<UpdateDeliveryPipelineRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDeliveryPipelineRequest, Operation>
        deleteDeliveryPipelineTransportSettings =
            HttpJsonCallSettings.<DeleteDeliveryPipelineRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDeliveryPipelineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListTargetsRequest, ListTargetsResponse> listTargetsTransportSettings =
        HttpJsonCallSettings.<ListTargetsRequest, ListTargetsResponse>newBuilder()
            .setMethodDescriptor(listTargetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTargetRequest, Target> getTargetTransportSettings =
        HttpJsonCallSettings.<GetTargetRequest, Target>newBuilder()
            .setMethodDescriptor(getTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTargetRequest, Operation> createTargetTransportSettings =
        HttpJsonCallSettings.<CreateTargetRequest, Operation>newBuilder()
            .setMethodDescriptor(createTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTargetRequest, Operation> updateTargetTransportSettings =
        HttpJsonCallSettings.<UpdateTargetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTargetRequest, Operation> deleteTargetTransportSettings =
        HttpJsonCallSettings.<DeleteTargetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListReleasesRequest, ListReleasesResponse> listReleasesTransportSettings =
        HttpJsonCallSettings.<ListReleasesRequest, ListReleasesResponse>newBuilder()
            .setMethodDescriptor(listReleasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetReleaseRequest, Release> getReleaseTransportSettings =
        HttpJsonCallSettings.<GetReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(getReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateReleaseRequest, Operation> createReleaseTransportSettings =
        HttpJsonCallSettings.<CreateReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(createReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ApproveRolloutRequest, ApproveRolloutResponse>
        approveRolloutTransportSettings =
            HttpJsonCallSettings.<ApproveRolloutRequest, ApproveRolloutResponse>newBuilder()
                .setMethodDescriptor(approveRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListRolloutsRequest, ListRolloutsResponse> listRolloutsTransportSettings =
        HttpJsonCallSettings.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
            .setMethodDescriptor(listRolloutsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRolloutRequest, Rollout> getRolloutTransportSettings =
        HttpJsonCallSettings.<GetRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateRolloutRequest, Operation> createRolloutTransportSettings =
        HttpJsonCallSettings.<CreateRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(createRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetConfigRequest, Config> getConfigTransportSettings =
        HttpJsonCallSettings.<GetConfigRequest, Config>newBuilder()
            .setMethodDescriptor(getConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
    this.approveRolloutCallable =
        callableFactory.createUnaryCallable(
            approveRolloutTransportSettings, settings.approveRolloutSettings(), clientContext);
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
    this.getConfigCallable =
        callableFactory.createUnaryCallable(
            getConfigTransportSettings, settings.getConfigSettings(), clientContext);

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
    methodDescriptors.add(getTargetMethodDescriptor);
    methodDescriptors.add(createTargetMethodDescriptor);
    methodDescriptors.add(updateTargetMethodDescriptor);
    methodDescriptors.add(deleteTargetMethodDescriptor);
    methodDescriptors.add(listReleasesMethodDescriptor);
    methodDescriptors.add(getReleaseMethodDescriptor);
    methodDescriptors.add(createReleaseMethodDescriptor);
    methodDescriptors.add(approveRolloutMethodDescriptor);
    methodDescriptors.add(listRolloutsMethodDescriptor);
    methodDescriptors.add(getRolloutMethodDescriptor);
    methodDescriptors.add(createRolloutMethodDescriptor);
    methodDescriptors.add(getConfigMethodDescriptor);
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
  public UnaryCallable<ApproveRolloutRequest, ApproveRolloutResponse> approveRolloutCallable() {
    return approveRolloutCallable;
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
  public UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return getConfigCallable;
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
