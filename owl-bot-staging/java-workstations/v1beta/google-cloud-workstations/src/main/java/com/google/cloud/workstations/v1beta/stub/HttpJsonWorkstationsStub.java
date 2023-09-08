/*
 * Copyright 2023 Google LLC
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

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the Workstations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonWorkstationsStub extends WorkstationsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(WorkstationCluster.getDescriptor())
          .add(WorkstationConfig.getDescriptor())
          .add(Workstation.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterMethodDescriptor =
          ApiMethodDescriptor.<GetWorkstationClusterRequest, WorkstationCluster>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/GetWorkstationCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkstationClusterRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkstationCluster>newBuilder()
                      .setDefaultInstance(WorkstationCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersMethodDescriptor =
          ApiMethodDescriptor
              .<ListWorkstationClustersRequest, ListWorkstationClustersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/ListWorkstationClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkstationClustersRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/workstationClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkstationClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkstationClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkstationClustersResponse>newBuilder()
                      .setDefaultInstance(ListWorkstationClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkstationClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/CreateWorkstationCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkstationClusterRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/workstationClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(
                                fields, "workstationClusterId", request.getWorkstationClusterId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "workstationCluster", request.getWorkstationCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateWorkstationClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkstationClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/UpdateWorkstationCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkstationClusterRequest>newBuilder()
                      .setPath(
                          "/v1beta/{workstationCluster.name=projects/*/locations/*/workstationClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "workstationCluster.name",
                                request.getWorkstationCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "workstationCluster", request.getWorkstationCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateWorkstationClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkstationClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/DeleteWorkstationCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkstationClusterRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkstationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteWorkstationClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigMethodDescriptor =
          ApiMethodDescriptor.<GetWorkstationConfigRequest, WorkstationConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/GetWorkstationConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkstationConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkstationConfig>newBuilder()
                      .setDefaultInstance(WorkstationConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/ListWorkstationConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkstationConfigsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/workstationClusters/*}/workstationConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkstationConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkstationConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkstationConfigsResponse>newBuilder()
                      .setDefaultInstance(ListWorkstationConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/ListUsableWorkstationConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsableWorkstationConfigsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/workstationClusters/*}/workstationConfigs:listUsable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableWorkstationConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableWorkstationConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUsableWorkstationConfigsResponse>newBuilder()
                      .setDefaultInstance(ListUsableWorkstationConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkstationConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/CreateWorkstationConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkstationConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/workstationClusters/*}/workstationConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(
                                fields, "workstationConfigId", request.getWorkstationConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "workstationConfig", request.getWorkstationConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateWorkstationConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkstationConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/UpdateWorkstationConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkstationConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{workstationConfig.name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "workstationConfig.name",
                                request.getWorkstationConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "workstationConfig", request.getWorkstationConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateWorkstationConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkstationConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/DeleteWorkstationConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkstationConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkstationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteWorkstationConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetWorkstationRequest, Workstation>
      getWorkstationMethodDescriptor =
          ApiMethodDescriptor.<GetWorkstationRequest, Workstation>newBuilder()
              .setFullMethodName("google.cloud.workstations.v1beta.Workstations/GetWorkstation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkstationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Workstation>newBuilder()
                      .setDefaultInstance(Workstation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsMethodDescriptor =
          ApiMethodDescriptor.<ListWorkstationsRequest, ListWorkstationsResponse>newBuilder()
              .setFullMethodName("google.cloud.workstations.v1beta.Workstations/ListWorkstations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkstationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}/workstations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkstationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkstationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkstationsResponse>newBuilder()
                      .setDefaultInstance(ListWorkstationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/ListUsableWorkstations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsableWorkstationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}/workstations:listUsable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableWorkstationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableWorkstationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUsableWorkstationsResponse>newBuilder()
                      .setDefaultInstance(ListUsableWorkstationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkstationRequest, Operation>
      createWorkstationMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkstationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workstations.v1beta.Workstations/CreateWorkstation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkstationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}/workstations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(
                                fields, "workstationId", request.getWorkstationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workstation", request.getWorkstation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateWorkstationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateWorkstationRequest, Operation>
      updateWorkstationMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkstationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workstations.v1beta.Workstations/UpdateWorkstation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkstationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{workstation.name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "workstation.name", request.getWorkstation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workstation", request.getWorkstation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateWorkstationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteWorkstationRequest, Operation>
      deleteWorkstationMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkstationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workstations.v1beta.Workstations/DeleteWorkstation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkstationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteWorkstationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartWorkstationRequest, Operation>
      startWorkstationMethodDescriptor =
          ApiMethodDescriptor.<StartWorkstationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workstations.v1beta.Workstations/StartWorkstation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartWorkstationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartWorkstationRequest> serializer =
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
                  (StartWorkstationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StopWorkstationRequest, Operation>
      stopWorkstationMethodDescriptor =
          ApiMethodDescriptor.<StopWorkstationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workstations.v1beta.Workstations/StopWorkstation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopWorkstationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopWorkstationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopWorkstationRequest> serializer =
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
                  (StopWorkstationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenMethodDescriptor =
          ApiMethodDescriptor.<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.workstations.v1beta.Workstations/GenerateAccessToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAccessTokenRequest>newBuilder()
                      .setPath(
                          "/v1beta/{workstation=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}:generateAccessToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "workstation", request.getWorkstation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearWorkstation().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateAccessTokenResponse>newBuilder()
                      .setDefaultInstance(GenerateAccessTokenResponse.getDefaultInstance())
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
                          "/v1beta/{resource=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{resource=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}:setIamPolicy")
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
                          "/v1beta/{resource=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{resource=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}:getIamPolicy")
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
                          "/v1beta/{resource=projects/*/locations/*/workstationClusters/*/workstationConfigs/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{resource=projects/*/locations/*/workstationClusters/*/workstationConfigs/*/workstations/*}:testIamPermissions")
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

  private final UnaryCallable<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterCallable;
  private final UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersCallable;
  private final UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersPagedResponse>
      listWorkstationClustersPagedCallable;
  private final UnaryCallable<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterCallable;
  private final OperationCallable<
          CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationCallable;
  private final UnaryCallable<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterCallable;
  private final OperationCallable<
          UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationCallable;
  private final UnaryCallable<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterCallable;
  private final OperationCallable<
          DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationCallable;
  private final UnaryCallable<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigCallable;
  private final UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsCallable;
  private final UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsPagedCallable;
  private final UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsCallable;
  private final UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsPagedCallable;
  private final UnaryCallable<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigCallable;
  private final OperationCallable<
          CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationCallable;
  private final UnaryCallable<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigCallable;
  private final OperationCallable<
          UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationCallable;
  private final UnaryCallable<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigCallable;
  private final OperationCallable<
          DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationCallable;
  private final UnaryCallable<GetWorkstationRequest, Workstation> getWorkstationCallable;
  private final UnaryCallable<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsCallable;
  private final UnaryCallable<ListWorkstationsRequest, ListWorkstationsPagedResponse>
      listWorkstationsPagedCallable;
  private final UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsCallable;
  private final UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsPagedCallable;
  private final UnaryCallable<CreateWorkstationRequest, Operation> createWorkstationCallable;
  private final OperationCallable<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationCallable;
  private final UnaryCallable<UpdateWorkstationRequest, Operation> updateWorkstationCallable;
  private final OperationCallable<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationCallable;
  private final UnaryCallable<DeleteWorkstationRequest, Operation> deleteWorkstationCallable;
  private final OperationCallable<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationCallable;
  private final UnaryCallable<StartWorkstationRequest, Operation> startWorkstationCallable;
  private final OperationCallable<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationCallable;
  private final UnaryCallable<StopWorkstationRequest, Operation> stopWorkstationCallable;
  private final OperationCallable<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationCallable;
  private final UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWorkstationsStub create(WorkstationsStubSettings settings)
      throws IOException {
    return new HttpJsonWorkstationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWorkstationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWorkstationsStub(
        WorkstationsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWorkstationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWorkstationsStub(
        WorkstationsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWorkstationsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWorkstationsStub(WorkstationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonWorkstationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWorkstationsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWorkstationsStub(
      WorkstationsStubSettings settings,
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
                        .setPost("/v1beta/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<GetWorkstationClusterRequest, WorkstationCluster>
        getWorkstationClusterTransportSettings =
            HttpJsonCallSettings.<GetWorkstationClusterRequest, WorkstationCluster>newBuilder()
                .setMethodDescriptor(getWorkstationClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
        listWorkstationClustersTransportSettings =
            HttpJsonCallSettings
                .<ListWorkstationClustersRequest, ListWorkstationClustersResponse>newBuilder()
                .setMethodDescriptor(listWorkstationClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateWorkstationClusterRequest, Operation>
        createWorkstationClusterTransportSettings =
            HttpJsonCallSettings.<CreateWorkstationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createWorkstationClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateWorkstationClusterRequest, Operation>
        updateWorkstationClusterTransportSettings =
            HttpJsonCallSettings.<UpdateWorkstationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateWorkstationClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workstation_cluster.name",
                          String.valueOf(request.getWorkstationCluster().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteWorkstationClusterRequest, Operation>
        deleteWorkstationClusterTransportSettings =
            HttpJsonCallSettings.<DeleteWorkstationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteWorkstationClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetWorkstationConfigRequest, WorkstationConfig>
        getWorkstationConfigTransportSettings =
            HttpJsonCallSettings.<GetWorkstationConfigRequest, WorkstationConfig>newBuilder()
                .setMethodDescriptor(getWorkstationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
        listWorkstationConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>newBuilder()
                .setMethodDescriptor(listWorkstationConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
        listUsableWorkstationConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listUsableWorkstationConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateWorkstationConfigRequest, Operation>
        createWorkstationConfigTransportSettings =
            HttpJsonCallSettings.<CreateWorkstationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createWorkstationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateWorkstationConfigRequest, Operation>
        updateWorkstationConfigTransportSettings =
            HttpJsonCallSettings.<UpdateWorkstationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateWorkstationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workstation_config.name",
                          String.valueOf(request.getWorkstationConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteWorkstationConfigRequest, Operation>
        deleteWorkstationConfigTransportSettings =
            HttpJsonCallSettings.<DeleteWorkstationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteWorkstationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetWorkstationRequest, Workstation> getWorkstationTransportSettings =
        HttpJsonCallSettings.<GetWorkstationRequest, Workstation>newBuilder()
            .setMethodDescriptor(getWorkstationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListWorkstationsRequest, ListWorkstationsResponse>
        listWorkstationsTransportSettings =
            HttpJsonCallSettings.<ListWorkstationsRequest, ListWorkstationsResponse>newBuilder()
                .setMethodDescriptor(listWorkstationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
        listUsableWorkstationsTransportSettings =
            HttpJsonCallSettings
                .<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>newBuilder()
                .setMethodDescriptor(listUsableWorkstationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateWorkstationRequest, Operation> createWorkstationTransportSettings =
        HttpJsonCallSettings.<CreateWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkstationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateWorkstationRequest, Operation> updateWorkstationTransportSettings =
        HttpJsonCallSettings.<UpdateWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkstationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "workstation.name", String.valueOf(request.getWorkstation().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteWorkstationRequest, Operation> deleteWorkstationTransportSettings =
        HttpJsonCallSettings.<DeleteWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkstationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StartWorkstationRequest, Operation> startWorkstationTransportSettings =
        HttpJsonCallSettings.<StartWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(startWorkstationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StopWorkstationRequest, Operation> stopWorkstationTransportSettings =
        HttpJsonCallSettings.<StopWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(stopWorkstationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenTransportSettings =
            HttpJsonCallSettings
                .<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAccessTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workstation", String.valueOf(request.getWorkstation()));
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

    this.getWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            getWorkstationClusterTransportSettings,
            settings.getWorkstationClusterSettings(),
            clientContext);
    this.listWorkstationClustersCallable =
        callableFactory.createUnaryCallable(
            listWorkstationClustersTransportSettings,
            settings.listWorkstationClustersSettings(),
            clientContext);
    this.listWorkstationClustersPagedCallable =
        callableFactory.createPagedCallable(
            listWorkstationClustersTransportSettings,
            settings.listWorkstationClustersSettings(),
            clientContext);
    this.createWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            createWorkstationClusterTransportSettings,
            settings.createWorkstationClusterSettings(),
            clientContext);
    this.createWorkstationClusterOperationCallable =
        callableFactory.createOperationCallable(
            createWorkstationClusterTransportSettings,
            settings.createWorkstationClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            updateWorkstationClusterTransportSettings,
            settings.updateWorkstationClusterSettings(),
            clientContext);
    this.updateWorkstationClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkstationClusterTransportSettings,
            settings.updateWorkstationClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            deleteWorkstationClusterTransportSettings,
            settings.deleteWorkstationClusterSettings(),
            clientContext);
    this.deleteWorkstationClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkstationClusterTransportSettings,
            settings.deleteWorkstationClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            getWorkstationConfigTransportSettings,
            settings.getWorkstationConfigSettings(),
            clientContext);
    this.listWorkstationConfigsCallable =
        callableFactory.createUnaryCallable(
            listWorkstationConfigsTransportSettings,
            settings.listWorkstationConfigsSettings(),
            clientContext);
    this.listWorkstationConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkstationConfigsTransportSettings,
            settings.listWorkstationConfigsSettings(),
            clientContext);
    this.listUsableWorkstationConfigsCallable =
        callableFactory.createUnaryCallable(
            listUsableWorkstationConfigsTransportSettings,
            settings.listUsableWorkstationConfigsSettings(),
            clientContext);
    this.listUsableWorkstationConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listUsableWorkstationConfigsTransportSettings,
            settings.listUsableWorkstationConfigsSettings(),
            clientContext);
    this.createWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            createWorkstationConfigTransportSettings,
            settings.createWorkstationConfigSettings(),
            clientContext);
    this.createWorkstationConfigOperationCallable =
        callableFactory.createOperationCallable(
            createWorkstationConfigTransportSettings,
            settings.createWorkstationConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            updateWorkstationConfigTransportSettings,
            settings.updateWorkstationConfigSettings(),
            clientContext);
    this.updateWorkstationConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkstationConfigTransportSettings,
            settings.updateWorkstationConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            deleteWorkstationConfigTransportSettings,
            settings.deleteWorkstationConfigSettings(),
            clientContext);
    this.deleteWorkstationConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkstationConfigTransportSettings,
            settings.deleteWorkstationConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getWorkstationCallable =
        callableFactory.createUnaryCallable(
            getWorkstationTransportSettings, settings.getWorkstationSettings(), clientContext);
    this.listWorkstationsCallable =
        callableFactory.createUnaryCallable(
            listWorkstationsTransportSettings, settings.listWorkstationsSettings(), clientContext);
    this.listWorkstationsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkstationsTransportSettings, settings.listWorkstationsSettings(), clientContext);
    this.listUsableWorkstationsCallable =
        callableFactory.createUnaryCallable(
            listUsableWorkstationsTransportSettings,
            settings.listUsableWorkstationsSettings(),
            clientContext);
    this.listUsableWorkstationsPagedCallable =
        callableFactory.createPagedCallable(
            listUsableWorkstationsTransportSettings,
            settings.listUsableWorkstationsSettings(),
            clientContext);
    this.createWorkstationCallable =
        callableFactory.createUnaryCallable(
            createWorkstationTransportSettings,
            settings.createWorkstationSettings(),
            clientContext);
    this.createWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            createWorkstationTransportSettings,
            settings.createWorkstationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateWorkstationCallable =
        callableFactory.createUnaryCallable(
            updateWorkstationTransportSettings,
            settings.updateWorkstationSettings(),
            clientContext);
    this.updateWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkstationTransportSettings,
            settings.updateWorkstationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteWorkstationCallable =
        callableFactory.createUnaryCallable(
            deleteWorkstationTransportSettings,
            settings.deleteWorkstationSettings(),
            clientContext);
    this.deleteWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkstationTransportSettings,
            settings.deleteWorkstationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startWorkstationCallable =
        callableFactory.createUnaryCallable(
            startWorkstationTransportSettings, settings.startWorkstationSettings(), clientContext);
    this.startWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            startWorkstationTransportSettings,
            settings.startWorkstationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopWorkstationCallable =
        callableFactory.createUnaryCallable(
            stopWorkstationTransportSettings, settings.stopWorkstationSettings(), clientContext);
    this.stopWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            stopWorkstationTransportSettings,
            settings.stopWorkstationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAccessTokenTransportSettings,
            settings.generateAccessTokenSettings(),
            clientContext);
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
    methodDescriptors.add(getWorkstationClusterMethodDescriptor);
    methodDescriptors.add(listWorkstationClustersMethodDescriptor);
    methodDescriptors.add(createWorkstationClusterMethodDescriptor);
    methodDescriptors.add(updateWorkstationClusterMethodDescriptor);
    methodDescriptors.add(deleteWorkstationClusterMethodDescriptor);
    methodDescriptors.add(getWorkstationConfigMethodDescriptor);
    methodDescriptors.add(listWorkstationConfigsMethodDescriptor);
    methodDescriptors.add(listUsableWorkstationConfigsMethodDescriptor);
    methodDescriptors.add(createWorkstationConfigMethodDescriptor);
    methodDescriptors.add(updateWorkstationConfigMethodDescriptor);
    methodDescriptors.add(deleteWorkstationConfigMethodDescriptor);
    methodDescriptors.add(getWorkstationMethodDescriptor);
    methodDescriptors.add(listWorkstationsMethodDescriptor);
    methodDescriptors.add(listUsableWorkstationsMethodDescriptor);
    methodDescriptors.add(createWorkstationMethodDescriptor);
    methodDescriptors.add(updateWorkstationMethodDescriptor);
    methodDescriptors.add(deleteWorkstationMethodDescriptor);
    methodDescriptors.add(startWorkstationMethodDescriptor);
    methodDescriptors.add(stopWorkstationMethodDescriptor);
    methodDescriptors.add(generateAccessTokenMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterCallable() {
    return getWorkstationClusterCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersCallable() {
    return listWorkstationClustersCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersPagedResponse>
      listWorkstationClustersPagedCallable() {
    return listWorkstationClustersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterCallable() {
    return createWorkstationClusterCallable;
  }

  @Override
  public OperationCallable<CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationCallable() {
    return createWorkstationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterCallable() {
    return updateWorkstationClusterCallable;
  }

  @Override
  public OperationCallable<UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationCallable() {
    return updateWorkstationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterCallable() {
    return deleteWorkstationClusterCallable;
  }

  @Override
  public OperationCallable<DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationCallable() {
    return deleteWorkstationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigCallable() {
    return getWorkstationConfigCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsCallable() {
    return listWorkstationConfigsCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsPagedCallable() {
    return listWorkstationConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsCallable() {
    return listUsableWorkstationConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsPagedCallable() {
    return listUsableWorkstationConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigCallable() {
    return createWorkstationConfigCallable;
  }

  @Override
  public OperationCallable<CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationCallable() {
    return createWorkstationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigCallable() {
    return updateWorkstationConfigCallable;
  }

  @Override
  public OperationCallable<UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationCallable() {
    return updateWorkstationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigCallable() {
    return deleteWorkstationConfigCallable;
  }

  @Override
  public OperationCallable<DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationCallable() {
    return deleteWorkstationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkstationRequest, Workstation> getWorkstationCallable() {
    return getWorkstationCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsCallable() {
    return listWorkstationsCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationsRequest, ListWorkstationsPagedResponse>
      listWorkstationsPagedCallable() {
    return listWorkstationsPagedCallable;
  }

  @Override
  public UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsCallable() {
    return listUsableWorkstationsCallable;
  }

  @Override
  public UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsPagedCallable() {
    return listUsableWorkstationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWorkstationRequest, Operation> createWorkstationCallable() {
    return createWorkstationCallable;
  }

  @Override
  public OperationCallable<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationCallable() {
    return createWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkstationRequest, Operation> updateWorkstationCallable() {
    return updateWorkstationCallable;
  }

  @Override
  public OperationCallable<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationCallable() {
    return updateWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkstationRequest, Operation> deleteWorkstationCallable() {
    return deleteWorkstationCallable;
  }

  @Override
  public OperationCallable<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationCallable() {
    return deleteWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<StartWorkstationRequest, Operation> startWorkstationCallable() {
    return startWorkstationCallable;
  }

  @Override
  public OperationCallable<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationCallable() {
    return startWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<StopWorkstationRequest, Operation> stopWorkstationCallable() {
    return stopWorkstationCallable;
  }

  @Override
  public OperationCallable<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationCallable() {
    return stopWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    return generateAccessTokenCallable;
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
