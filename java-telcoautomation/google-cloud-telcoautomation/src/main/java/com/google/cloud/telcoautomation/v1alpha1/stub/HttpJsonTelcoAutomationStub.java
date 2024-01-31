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

package com.google.cloud.telcoautomation.v1alpha1.stub;

import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListDeploymentRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListEdgeSlmsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListHydratedDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListLocationsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListOrchestrationClustersPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListPublicBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.SearchBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.SearchDeploymentRevisionsPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.Blueprint;
import com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest;
import com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse;
import com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRevisionRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteDeploymentRevisionRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1alpha1.Deployment;
import com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest;
import com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse;
import com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest;
import com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse;
import com.google.cloud.telcoautomation.v1alpha1.EdgeSlm;
import com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse;
import com.google.cloud.telcoautomation.v1alpha1.OperationMetadata;
import com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster;
import com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint;
import com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the TelcoAutomation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTelcoAutomationStub extends TelcoAutomationStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(EdgeSlm.getDescriptor())
          .add(OrchestrationCluster.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersMethodDescriptor =
          ApiMethodDescriptor
              .<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListOrchestrationClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrchestrationClustersRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/orchestrationClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrchestrationClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrchestrationClustersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOrchestrationClustersResponse>newBuilder()
                      .setDefaultInstance(ListOrchestrationClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterMethodDescriptor =
          ApiMethodDescriptor.<GetOrchestrationClusterRequest, OrchestrationCluster>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/GetOrchestrationCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrchestrationClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrchestrationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrchestrationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OrchestrationCluster>newBuilder()
                      .setDefaultInstance(OrchestrationCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateOrchestrationClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/CreateOrchestrationCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOrchestrationClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/orchestrationClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOrchestrationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOrchestrationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "orchestrationClusterId",
                                request.getOrchestrationClusterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "orchestrationCluster",
                                      request.getOrchestrationCluster(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateOrchestrationClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteOrchestrationClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DeleteOrchestrationCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOrchestrationClusterRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOrchestrationClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOrchestrationClusterRequest> serializer =
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
                  (DeleteOrchestrationClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListEdgeSlmsRequest, ListEdgeSlmsResponse>
      listEdgeSlmsMethodDescriptor =
          ApiMethodDescriptor.<ListEdgeSlmsRequest, ListEdgeSlmsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListEdgeSlms")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEdgeSlmsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/edgeSlms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEdgeSlmsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEdgeSlmsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEdgeSlmsResponse>newBuilder()
                      .setDefaultInstance(ListEdgeSlmsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmMethodDescriptor =
      ApiMethodDescriptor.<GetEdgeSlmRequest, EdgeSlm>newBuilder()
          .setFullMethodName("google.cloud.telcoautomation.v1alpha1.TelcoAutomation/GetEdgeSlm")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEdgeSlmRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{name=projects/*/locations/*/edgeSlms/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetEdgeSlmRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetEdgeSlmRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<EdgeSlm>newBuilder()
                  .setDefaultInstance(EdgeSlm.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateEdgeSlmRequest, Operation>
      createEdgeSlmMethodDescriptor =
          ApiMethodDescriptor.<CreateEdgeSlmRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/CreateEdgeSlm")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEdgeSlmRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/edgeSlms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEdgeSlmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEdgeSlmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "edgeSlmId", request.getEdgeSlmId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("edgeSlm", request.getEdgeSlm(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEdgeSlmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEdgeSlmRequest, Operation>
      deleteEdgeSlmMethodDescriptor =
          ApiMethodDescriptor.<DeleteEdgeSlmRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DeleteEdgeSlm")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEdgeSlmRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/edgeSlms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEdgeSlmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEdgeSlmRequest> serializer =
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
                  (DeleteEdgeSlmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBlueprintRequest, Blueprint>
      createBlueprintMethodDescriptor =
          ApiMethodDescriptor.<CreateBlueprintRequest, Blueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/CreateBlueprint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/orchestrationClusters/*}/blueprints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "blueprintId", request.getBlueprintId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("blueprint", request.getBlueprint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Blueprint>newBuilder()
                      .setDefaultInstance(Blueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBlueprintRequest, Blueprint>
      updateBlueprintMethodDescriptor =
          ApiMethodDescriptor.<UpdateBlueprintRequest, Blueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/UpdateBlueprint")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{blueprint.name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "blueprint.name", request.getBlueprint().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("blueprint", request.getBlueprint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Blueprint>newBuilder()
                      .setDefaultInstance(Blueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBlueprintRequest, Blueprint>
      getBlueprintMethodDescriptor =
          ApiMethodDescriptor.<GetBlueprintRequest, Blueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/GetBlueprint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Blueprint>newBuilder()
                      .setDefaultInstance(Blueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBlueprintRequest, Empty>
      deleteBlueprintMethodDescriptor =
          ApiMethodDescriptor.<DeleteBlueprintRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DeleteBlueprint")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBlueprintRequest> serializer =
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

  private static final ApiMethodDescriptor<DeleteBlueprintRevisionRequest, Blueprint>
      deleteBlueprintRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteBlueprintRevisionRequest, Blueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DeleteBlueprintRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBlueprintRevisionRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}:deleteRevision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBlueprintRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBlueprintRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Blueprint>newBuilder()
                      .setDefaultInstance(Blueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBlueprintsRequest, ListBlueprintsResponse>
      listBlueprintsMethodDescriptor =
          ApiMethodDescriptor.<ListBlueprintsRequest, ListBlueprintsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListBlueprints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBlueprintsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/orchestrationClusters/*}/blueprints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBlueprintsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBlueprintsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBlueprintsResponse>newBuilder()
                      .setDefaultInstance(ListBlueprintsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ApproveBlueprintRequest, Blueprint>
      approveBlueprintMethodDescriptor =
          ApiMethodDescriptor.<ApproveBlueprintRequest, Blueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ApproveBlueprint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApproveBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveBlueprintRequest> serializer =
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
                  ProtoMessageResponseParser.<Blueprint>newBuilder()
                      .setDefaultInstance(Blueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ProposeBlueprintRequest, Blueprint>
      proposeBlueprintMethodDescriptor =
          ApiMethodDescriptor.<ProposeBlueprintRequest, Blueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ProposeBlueprint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProposeBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}:propose",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProposeBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProposeBlueprintRequest> serializer =
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
                  ProtoMessageResponseParser.<Blueprint>newBuilder()
                      .setDefaultInstance(Blueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RejectBlueprintRequest, Blueprint>
      rejectBlueprintMethodDescriptor =
          ApiMethodDescriptor.<RejectBlueprintRequest, Blueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/RejectBlueprint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RejectBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}:reject",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RejectBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RejectBlueprintRequest> serializer =
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
                  ProtoMessageResponseParser.<Blueprint>newBuilder()
                      .setDefaultInstance(Blueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListBlueprintRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBlueprintRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}:listRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBlueprintRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBlueprintRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBlueprintRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListBlueprintRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/SearchBlueprintRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchBlueprintRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/orchestrationClusters/*}/blueprints:searchRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchBlueprintRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchBlueprintRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchBlueprintRevisionsResponse>newBuilder()
                      .setDefaultInstance(SearchBlueprintRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/SearchDeploymentRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchDeploymentRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/orchestrationClusters/*}/deployments:searchRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDeploymentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDeploymentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchDeploymentRevisionsResponse>newBuilder()
                      .setDefaultInstance(SearchDeploymentRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesMethodDescriptor =
          ApiMethodDescriptor
              .<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DiscardBlueprintChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DiscardBlueprintChangesRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/blueprints/*}:discard",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DiscardBlueprintChangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DiscardBlueprintChangesRequest> serializer =
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
                  ProtoMessageResponseParser.<DiscardBlueprintChangesResponse>newBuilder()
                      .setDefaultInstance(DiscardBlueprintChangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListPublicBlueprints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPublicBlueprintsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/publicBlueprints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublicBlueprintsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublicBlueprintsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPublicBlueprintsResponse>newBuilder()
                      .setDefaultInstance(ListPublicBlueprintsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintMethodDescriptor =
          ApiMethodDescriptor.<GetPublicBlueprintRequest, PublicBlueprint>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/GetPublicBlueprint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPublicBlueprintRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/publicBlueprints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublicBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublicBlueprintRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicBlueprint>newBuilder()
                      .setDefaultInstance(PublicBlueprint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/CreateDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/orchestrationClusters/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deploymentId", request.getDeploymentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDeploymentRequest, Deployment>
      updateDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/UpdateDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{deployment.name=projects/*/locations/*/orchestrationClusters/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "deployment.name", request.getDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/GetDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeploymentRequest, Empty>
      deleteDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeploymentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DeleteDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
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

  private static final ApiMethodDescriptor<RemoveDeploymentRequest, Empty>
      removeDeploymentMethodDescriptor =
          ApiMethodDescriptor.<RemoveDeploymentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/RemoveDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}:remove",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveDeploymentRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeploymentRevisionRequest, Deployment>
      deleteDeploymentRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeploymentRevisionRequest, Deployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DeleteDeploymentRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeploymentRevisionRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}:deleteRevision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          ApiMethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/orchestrationClusters/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListDeploymentRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeploymentRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}:listRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeploymentRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListDeploymentRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesMethodDescriptor =
          ApiMethodDescriptor
              .<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/DiscardDeploymentChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DiscardDeploymentChangesRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}:discard",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DiscardDeploymentChangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DiscardDeploymentChangesRequest> serializer =
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
                  ProtoMessageResponseParser.<DiscardDeploymentChangesResponse>newBuilder()
                      .setDefaultInstance(DiscardDeploymentChangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ApplyDeploymentRequest, Deployment>
      applyDeploymentMethodDescriptor =
          ApiMethodDescriptor.<ApplyDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ApplyDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApplyDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}:apply",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyDeploymentRequest> serializer =
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
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusMethodDescriptor =
          ApiMethodDescriptor
              .<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ComputeDeploymentStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ComputeDeploymentStatusRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}:computeDeploymentStatus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeDeploymentStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeDeploymentStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ComputeDeploymentStatusResponse>newBuilder()
                      .setDefaultInstance(ComputeDeploymentStatusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RollbackDeploymentRequest, Deployment>
      rollbackDeploymentMethodDescriptor =
          ApiMethodDescriptor.<RollbackDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/RollbackDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RollbackDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*}:rollback",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackDeploymentRequest> serializer =
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
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetHydratedDeploymentRequest, HydratedDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/GetHydratedDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHydratedDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*/hydratedDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHydratedDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHydratedDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HydratedDeployment>newBuilder()
                      .setDefaultInstance(HydratedDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ListHydratedDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHydratedDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/orchestrationClusters/*/deployments/*}/hydratedDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHydratedDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHydratedDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHydratedDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListHydratedDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateHydratedDeploymentRequest, HydratedDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/UpdateHydratedDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHydratedDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{hydratedDeployment.name=projects/*/locations/*/orchestrationClusters/*/deployments/*/hydratedDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHydratedDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "hydratedDeployment.name",
                                request.getHydratedDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHydratedDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "hydratedDeployment", request.getHydratedDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HydratedDeployment>newBuilder()
                      .setDefaultInstance(HydratedDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentMethodDescriptor =
          ApiMethodDescriptor.<ApplyHydratedDeploymentRequest, HydratedDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1alpha1.TelcoAutomation/ApplyHydratedDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApplyHydratedDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/orchestrationClusters/*/deployments/*/hydratedDeployments/*}:apply",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyHydratedDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyHydratedDeploymentRequest> serializer =
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
                  ProtoMessageResponseParser.<HydratedDeployment>newBuilder()
                      .setDefaultInstance(HydratedDeployment.getDefaultInstance())
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
                          "/v1alpha1/{name=projects/*}/locations",
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
                          "/v1alpha1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersCallable;
  private final UnaryCallable<
          ListOrchestrationClustersRequest, ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersPagedCallable;
  private final UnaryCallable<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterCallable;
  private final UnaryCallable<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterCallable;
  private final OperationCallable<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationCallable;
  private final UnaryCallable<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterCallable;
  private final OperationCallable<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationCallable;
  private final UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsCallable;
  private final UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsPagedResponse>
      listEdgeSlmsPagedCallable;
  private final UnaryCallable<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmCallable;
  private final UnaryCallable<CreateEdgeSlmRequest, Operation> createEdgeSlmCallable;
  private final OperationCallable<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationCallable;
  private final UnaryCallable<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmCallable;
  private final OperationCallable<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationCallable;
  private final UnaryCallable<CreateBlueprintRequest, Blueprint> createBlueprintCallable;
  private final UnaryCallable<UpdateBlueprintRequest, Blueprint> updateBlueprintCallable;
  private final UnaryCallable<GetBlueprintRequest, Blueprint> getBlueprintCallable;
  private final UnaryCallable<DeleteBlueprintRequest, Empty> deleteBlueprintCallable;
  private final UnaryCallable<DeleteBlueprintRevisionRequest, Blueprint>
      deleteBlueprintRevisionCallable;
  private final UnaryCallable<ListBlueprintsRequest, ListBlueprintsResponse> listBlueprintsCallable;
  private final UnaryCallable<ListBlueprintsRequest, ListBlueprintsPagedResponse>
      listBlueprintsPagedCallable;
  private final UnaryCallable<ApproveBlueprintRequest, Blueprint> approveBlueprintCallable;
  private final UnaryCallable<ProposeBlueprintRequest, Blueprint> proposeBlueprintCallable;
  private final UnaryCallable<RejectBlueprintRequest, Blueprint> rejectBlueprintCallable;
  private final UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsCallable;
  private final UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsPagedCallable;
  private final UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsCallable;
  private final UnaryCallable<
          SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsPagedCallable;
  private final UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsCallable;
  private final UnaryCallable<
          SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsPagedCallable;
  private final UnaryCallable<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesCallable;
  private final UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsCallable;
  private final UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsPagedCallable;
  private final UnaryCallable<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintCallable;
  private final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable;
  private final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable;
  private final UnaryCallable<RemoveDeploymentRequest, Empty> removeDeploymentCallable;
  private final UnaryCallable<DeleteDeploymentRevisionRequest, Deployment>
      deleteDeploymentRevisionCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsCallable;
  private final UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsPagedCallable;
  private final UnaryCallable<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesCallable;
  private final UnaryCallable<ApplyDeploymentRequest, Deployment> applyDeploymentCallable;
  private final UnaryCallable<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusCallable;
  private final UnaryCallable<RollbackDeploymentRequest, Deployment> rollbackDeploymentCallable;
  private final UnaryCallable<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentCallable;
  private final UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsCallable;
  private final UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsPagedCallable;
  private final UnaryCallable<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentCallable;
  private final UnaryCallable<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTelcoAutomationStub create(TelcoAutomationStubSettings settings)
      throws IOException {
    return new HttpJsonTelcoAutomationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTelcoAutomationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTelcoAutomationStub(
        TelcoAutomationStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTelcoAutomationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTelcoAutomationStub(
        TelcoAutomationStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTelcoAutomationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTelcoAutomationStub(
      TelcoAutomationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTelcoAutomationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTelcoAutomationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTelcoAutomationStub(
      TelcoAutomationStubSettings settings,
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
                        .setPost("/v1alpha1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1alpha1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
        listOrchestrationClustersTransportSettings =
            HttpJsonCallSettings
                .<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>newBuilder()
                .setMethodDescriptor(listOrchestrationClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOrchestrationClusterRequest, OrchestrationCluster>
        getOrchestrationClusterTransportSettings =
            HttpJsonCallSettings.<GetOrchestrationClusterRequest, OrchestrationCluster>newBuilder()
                .setMethodDescriptor(getOrchestrationClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateOrchestrationClusterRequest, Operation>
        createOrchestrationClusterTransportSettings =
            HttpJsonCallSettings.<CreateOrchestrationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createOrchestrationClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteOrchestrationClusterRequest, Operation>
        deleteOrchestrationClusterTransportSettings =
            HttpJsonCallSettings.<DeleteOrchestrationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteOrchestrationClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsTransportSettings =
        HttpJsonCallSettings.<ListEdgeSlmsRequest, ListEdgeSlmsResponse>newBuilder()
            .setMethodDescriptor(listEdgeSlmsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmTransportSettings =
        HttpJsonCallSettings.<GetEdgeSlmRequest, EdgeSlm>newBuilder()
            .setMethodDescriptor(getEdgeSlmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEdgeSlmRequest, Operation> createEdgeSlmTransportSettings =
        HttpJsonCallSettings.<CreateEdgeSlmRequest, Operation>newBuilder()
            .setMethodDescriptor(createEdgeSlmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmTransportSettings =
        HttpJsonCallSettings.<DeleteEdgeSlmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEdgeSlmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBlueprintRequest, Blueprint> createBlueprintTransportSettings =
        HttpJsonCallSettings.<CreateBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(createBlueprintMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBlueprintRequest, Blueprint> updateBlueprintTransportSettings =
        HttpJsonCallSettings.<UpdateBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(updateBlueprintMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("blueprint.name", String.valueOf(request.getBlueprint().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBlueprintRequest, Blueprint> getBlueprintTransportSettings =
        HttpJsonCallSettings.<GetBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(getBlueprintMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBlueprintRequest, Empty> deleteBlueprintTransportSettings =
        HttpJsonCallSettings.<DeleteBlueprintRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBlueprintMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBlueprintRevisionRequest, Blueprint>
        deleteBlueprintRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteBlueprintRevisionRequest, Blueprint>newBuilder()
                .setMethodDescriptor(deleteBlueprintRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBlueprintsRequest, ListBlueprintsResponse>
        listBlueprintsTransportSettings =
            HttpJsonCallSettings.<ListBlueprintsRequest, ListBlueprintsResponse>newBuilder()
                .setMethodDescriptor(listBlueprintsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ApproveBlueprintRequest, Blueprint> approveBlueprintTransportSettings =
        HttpJsonCallSettings.<ApproveBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(approveBlueprintMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ProposeBlueprintRequest, Blueprint> proposeBlueprintTransportSettings =
        HttpJsonCallSettings.<ProposeBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(proposeBlueprintMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RejectBlueprintRequest, Blueprint> rejectBlueprintTransportSettings =
        HttpJsonCallSettings.<RejectBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(rejectBlueprintMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
        listBlueprintRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>newBuilder()
                .setMethodDescriptor(listBlueprintRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
        searchBlueprintRevisionsTransportSettings =
            HttpJsonCallSettings
                .<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>newBuilder()
                .setMethodDescriptor(searchBlueprintRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
        searchDeploymentRevisionsTransportSettings =
            HttpJsonCallSettings
                .<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>newBuilder()
                .setMethodDescriptor(searchDeploymentRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
        discardBlueprintChangesTransportSettings =
            HttpJsonCallSettings
                .<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>newBuilder()
                .setMethodDescriptor(discardBlueprintChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
        listPublicBlueprintsTransportSettings =
            HttpJsonCallSettings
                .<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>newBuilder()
                .setMethodDescriptor(listPublicBlueprintsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPublicBlueprintRequest, PublicBlueprint>
        getPublicBlueprintTransportSettings =
            HttpJsonCallSettings.<GetPublicBlueprintRequest, PublicBlueprint>newBuilder()
                .setMethodDescriptor(getPublicBlueprintMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        HttpJsonCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentTransportSettings =
        HttpJsonCallSettings.<UpdateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        HttpJsonCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentTransportSettings =
        HttpJsonCallSettings.<DeleteDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RemoveDeploymentRequest, Empty> removeDeploymentTransportSettings =
        HttpJsonCallSettings.<RemoveDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(removeDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDeploymentRevisionRequest, Deployment>
        deleteDeploymentRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteDeploymentRevisionRequest, Deployment>newBuilder()
                .setMethodDescriptor(deleteDeploymentRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            HttpJsonCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
        listDeploymentRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
        discardDeploymentChangesTransportSettings =
            HttpJsonCallSettings
                .<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>newBuilder()
                .setMethodDescriptor(discardDeploymentChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ApplyDeploymentRequest, Deployment> applyDeploymentTransportSettings =
        HttpJsonCallSettings.<ApplyDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(applyDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
        computeDeploymentStatusTransportSettings =
            HttpJsonCallSettings
                .<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>newBuilder()
                .setMethodDescriptor(computeDeploymentStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RollbackDeploymentRequest, Deployment>
        rollbackDeploymentTransportSettings =
            HttpJsonCallSettings.<RollbackDeploymentRequest, Deployment>newBuilder()
                .setMethodDescriptor(rollbackDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetHydratedDeploymentRequest, HydratedDeployment>
        getHydratedDeploymentTransportSettings =
            HttpJsonCallSettings.<GetHydratedDeploymentRequest, HydratedDeployment>newBuilder()
                .setMethodDescriptor(getHydratedDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
        listHydratedDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listHydratedDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateHydratedDeploymentRequest, HydratedDeployment>
        updateHydratedDeploymentTransportSettings =
            HttpJsonCallSettings.<UpdateHydratedDeploymentRequest, HydratedDeployment>newBuilder()
                .setMethodDescriptor(updateHydratedDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "hydrated_deployment.name",
                          String.valueOf(request.getHydratedDeployment().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ApplyHydratedDeploymentRequest, HydratedDeployment>
        applyHydratedDeploymentTransportSettings =
            HttpJsonCallSettings.<ApplyHydratedDeploymentRequest, HydratedDeployment>newBuilder()
                .setMethodDescriptor(applyHydratedDeploymentMethodDescriptor)
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

    this.listOrchestrationClustersCallable =
        callableFactory.createUnaryCallable(
            listOrchestrationClustersTransportSettings,
            settings.listOrchestrationClustersSettings(),
            clientContext);
    this.listOrchestrationClustersPagedCallable =
        callableFactory.createPagedCallable(
            listOrchestrationClustersTransportSettings,
            settings.listOrchestrationClustersSettings(),
            clientContext);
    this.getOrchestrationClusterCallable =
        callableFactory.createUnaryCallable(
            getOrchestrationClusterTransportSettings,
            settings.getOrchestrationClusterSettings(),
            clientContext);
    this.createOrchestrationClusterCallable =
        callableFactory.createUnaryCallable(
            createOrchestrationClusterTransportSettings,
            settings.createOrchestrationClusterSettings(),
            clientContext);
    this.createOrchestrationClusterOperationCallable =
        callableFactory.createOperationCallable(
            createOrchestrationClusterTransportSettings,
            settings.createOrchestrationClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteOrchestrationClusterCallable =
        callableFactory.createUnaryCallable(
            deleteOrchestrationClusterTransportSettings,
            settings.deleteOrchestrationClusterSettings(),
            clientContext);
    this.deleteOrchestrationClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteOrchestrationClusterTransportSettings,
            settings.deleteOrchestrationClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEdgeSlmsCallable =
        callableFactory.createUnaryCallable(
            listEdgeSlmsTransportSettings, settings.listEdgeSlmsSettings(), clientContext);
    this.listEdgeSlmsPagedCallable =
        callableFactory.createPagedCallable(
            listEdgeSlmsTransportSettings, settings.listEdgeSlmsSettings(), clientContext);
    this.getEdgeSlmCallable =
        callableFactory.createUnaryCallable(
            getEdgeSlmTransportSettings, settings.getEdgeSlmSettings(), clientContext);
    this.createEdgeSlmCallable =
        callableFactory.createUnaryCallable(
            createEdgeSlmTransportSettings, settings.createEdgeSlmSettings(), clientContext);
    this.createEdgeSlmOperationCallable =
        callableFactory.createOperationCallable(
            createEdgeSlmTransportSettings,
            settings.createEdgeSlmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEdgeSlmCallable =
        callableFactory.createUnaryCallable(
            deleteEdgeSlmTransportSettings, settings.deleteEdgeSlmSettings(), clientContext);
    this.deleteEdgeSlmOperationCallable =
        callableFactory.createOperationCallable(
            deleteEdgeSlmTransportSettings,
            settings.deleteEdgeSlmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBlueprintCallable =
        callableFactory.createUnaryCallable(
            createBlueprintTransportSettings, settings.createBlueprintSettings(), clientContext);
    this.updateBlueprintCallable =
        callableFactory.createUnaryCallable(
            updateBlueprintTransportSettings, settings.updateBlueprintSettings(), clientContext);
    this.getBlueprintCallable =
        callableFactory.createUnaryCallable(
            getBlueprintTransportSettings, settings.getBlueprintSettings(), clientContext);
    this.deleteBlueprintCallable =
        callableFactory.createUnaryCallable(
            deleteBlueprintTransportSettings, settings.deleteBlueprintSettings(), clientContext);
    this.deleteBlueprintRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteBlueprintRevisionTransportSettings,
            settings.deleteBlueprintRevisionSettings(),
            clientContext);
    this.listBlueprintsCallable =
        callableFactory.createUnaryCallable(
            listBlueprintsTransportSettings, settings.listBlueprintsSettings(), clientContext);
    this.listBlueprintsPagedCallable =
        callableFactory.createPagedCallable(
            listBlueprintsTransportSettings, settings.listBlueprintsSettings(), clientContext);
    this.approveBlueprintCallable =
        callableFactory.createUnaryCallable(
            approveBlueprintTransportSettings, settings.approveBlueprintSettings(), clientContext);
    this.proposeBlueprintCallable =
        callableFactory.createUnaryCallable(
            proposeBlueprintTransportSettings, settings.proposeBlueprintSettings(), clientContext);
    this.rejectBlueprintCallable =
        callableFactory.createUnaryCallable(
            rejectBlueprintTransportSettings, settings.rejectBlueprintSettings(), clientContext);
    this.listBlueprintRevisionsCallable =
        callableFactory.createUnaryCallable(
            listBlueprintRevisionsTransportSettings,
            settings.listBlueprintRevisionsSettings(),
            clientContext);
    this.listBlueprintRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listBlueprintRevisionsTransportSettings,
            settings.listBlueprintRevisionsSettings(),
            clientContext);
    this.searchBlueprintRevisionsCallable =
        callableFactory.createUnaryCallable(
            searchBlueprintRevisionsTransportSettings,
            settings.searchBlueprintRevisionsSettings(),
            clientContext);
    this.searchBlueprintRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            searchBlueprintRevisionsTransportSettings,
            settings.searchBlueprintRevisionsSettings(),
            clientContext);
    this.searchDeploymentRevisionsCallable =
        callableFactory.createUnaryCallable(
            searchDeploymentRevisionsTransportSettings,
            settings.searchDeploymentRevisionsSettings(),
            clientContext);
    this.searchDeploymentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            searchDeploymentRevisionsTransportSettings,
            settings.searchDeploymentRevisionsSettings(),
            clientContext);
    this.discardBlueprintChangesCallable =
        callableFactory.createUnaryCallable(
            discardBlueprintChangesTransportSettings,
            settings.discardBlueprintChangesSettings(),
            clientContext);
    this.listPublicBlueprintsCallable =
        callableFactory.createUnaryCallable(
            listPublicBlueprintsTransportSettings,
            settings.listPublicBlueprintsSettings(),
            clientContext);
    this.listPublicBlueprintsPagedCallable =
        callableFactory.createPagedCallable(
            listPublicBlueprintsTransportSettings,
            settings.listPublicBlueprintsSettings(),
            clientContext);
    this.getPublicBlueprintCallable =
        callableFactory.createUnaryCallable(
            getPublicBlueprintTransportSettings,
            settings.getPublicBlueprintSettings(),
            clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.updateDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateDeploymentTransportSettings, settings.updateDeploymentSettings(), clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.removeDeploymentCallable =
        callableFactory.createUnaryCallable(
            removeDeploymentTransportSettings, settings.removeDeploymentSettings(), clientContext);
    this.deleteDeploymentRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentRevisionTransportSettings,
            settings.deleteDeploymentRevisionSettings(),
            clientContext);
    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentRevisionsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentRevisionsTransportSettings,
            settings.listDeploymentRevisionsSettings(),
            clientContext);
    this.listDeploymentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentRevisionsTransportSettings,
            settings.listDeploymentRevisionsSettings(),
            clientContext);
    this.discardDeploymentChangesCallable =
        callableFactory.createUnaryCallable(
            discardDeploymentChangesTransportSettings,
            settings.discardDeploymentChangesSettings(),
            clientContext);
    this.applyDeploymentCallable =
        callableFactory.createUnaryCallable(
            applyDeploymentTransportSettings, settings.applyDeploymentSettings(), clientContext);
    this.computeDeploymentStatusCallable =
        callableFactory.createUnaryCallable(
            computeDeploymentStatusTransportSettings,
            settings.computeDeploymentStatusSettings(),
            clientContext);
    this.rollbackDeploymentCallable =
        callableFactory.createUnaryCallable(
            rollbackDeploymentTransportSettings,
            settings.rollbackDeploymentSettings(),
            clientContext);
    this.getHydratedDeploymentCallable =
        callableFactory.createUnaryCallable(
            getHydratedDeploymentTransportSettings,
            settings.getHydratedDeploymentSettings(),
            clientContext);
    this.listHydratedDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listHydratedDeploymentsTransportSettings,
            settings.listHydratedDeploymentsSettings(),
            clientContext);
    this.listHydratedDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listHydratedDeploymentsTransportSettings,
            settings.listHydratedDeploymentsSettings(),
            clientContext);
    this.updateHydratedDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateHydratedDeploymentTransportSettings,
            settings.updateHydratedDeploymentSettings(),
            clientContext);
    this.applyHydratedDeploymentCallable =
        callableFactory.createUnaryCallable(
            applyHydratedDeploymentTransportSettings,
            settings.applyHydratedDeploymentSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listOrchestrationClustersMethodDescriptor);
    methodDescriptors.add(getOrchestrationClusterMethodDescriptor);
    methodDescriptors.add(createOrchestrationClusterMethodDescriptor);
    methodDescriptors.add(deleteOrchestrationClusterMethodDescriptor);
    methodDescriptors.add(listEdgeSlmsMethodDescriptor);
    methodDescriptors.add(getEdgeSlmMethodDescriptor);
    methodDescriptors.add(createEdgeSlmMethodDescriptor);
    methodDescriptors.add(deleteEdgeSlmMethodDescriptor);
    methodDescriptors.add(createBlueprintMethodDescriptor);
    methodDescriptors.add(updateBlueprintMethodDescriptor);
    methodDescriptors.add(getBlueprintMethodDescriptor);
    methodDescriptors.add(deleteBlueprintMethodDescriptor);
    methodDescriptors.add(deleteBlueprintRevisionMethodDescriptor);
    methodDescriptors.add(listBlueprintsMethodDescriptor);
    methodDescriptors.add(approveBlueprintMethodDescriptor);
    methodDescriptors.add(proposeBlueprintMethodDescriptor);
    methodDescriptors.add(rejectBlueprintMethodDescriptor);
    methodDescriptors.add(listBlueprintRevisionsMethodDescriptor);
    methodDescriptors.add(searchBlueprintRevisionsMethodDescriptor);
    methodDescriptors.add(searchDeploymentRevisionsMethodDescriptor);
    methodDescriptors.add(discardBlueprintChangesMethodDescriptor);
    methodDescriptors.add(listPublicBlueprintsMethodDescriptor);
    methodDescriptors.add(getPublicBlueprintMethodDescriptor);
    methodDescriptors.add(createDeploymentMethodDescriptor);
    methodDescriptors.add(updateDeploymentMethodDescriptor);
    methodDescriptors.add(getDeploymentMethodDescriptor);
    methodDescriptors.add(deleteDeploymentMethodDescriptor);
    methodDescriptors.add(removeDeploymentMethodDescriptor);
    methodDescriptors.add(deleteDeploymentRevisionMethodDescriptor);
    methodDescriptors.add(listDeploymentsMethodDescriptor);
    methodDescriptors.add(listDeploymentRevisionsMethodDescriptor);
    methodDescriptors.add(discardDeploymentChangesMethodDescriptor);
    methodDescriptors.add(applyDeploymentMethodDescriptor);
    methodDescriptors.add(computeDeploymentStatusMethodDescriptor);
    methodDescriptors.add(rollbackDeploymentMethodDescriptor);
    methodDescriptors.add(getHydratedDeploymentMethodDescriptor);
    methodDescriptors.add(listHydratedDeploymentsMethodDescriptor);
    methodDescriptors.add(updateHydratedDeploymentMethodDescriptor);
    methodDescriptors.add(applyHydratedDeploymentMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersCallable() {
    return listOrchestrationClustersCallable;
  }

  @Override
  public UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersPagedCallable() {
    return listOrchestrationClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterCallable() {
    return getOrchestrationClusterCallable;
  }

  @Override
  public UnaryCallable<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterCallable() {
    return createOrchestrationClusterCallable;
  }

  @Override
  public OperationCallable<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationCallable() {
    return createOrchestrationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterCallable() {
    return deleteOrchestrationClusterCallable;
  }

  @Override
  public OperationCallable<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationCallable() {
    return deleteOrchestrationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsCallable() {
    return listEdgeSlmsCallable;
  }

  @Override
  public UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsPagedResponse> listEdgeSlmsPagedCallable() {
    return listEdgeSlmsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmCallable() {
    return getEdgeSlmCallable;
  }

  @Override
  public UnaryCallable<CreateEdgeSlmRequest, Operation> createEdgeSlmCallable() {
    return createEdgeSlmCallable;
  }

  @Override
  public OperationCallable<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationCallable() {
    return createEdgeSlmOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmCallable() {
    return deleteEdgeSlmCallable;
  }

  @Override
  public OperationCallable<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationCallable() {
    return deleteEdgeSlmOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBlueprintRequest, Blueprint> createBlueprintCallable() {
    return createBlueprintCallable;
  }

  @Override
  public UnaryCallable<UpdateBlueprintRequest, Blueprint> updateBlueprintCallable() {
    return updateBlueprintCallable;
  }

  @Override
  public UnaryCallable<GetBlueprintRequest, Blueprint> getBlueprintCallable() {
    return getBlueprintCallable;
  }

  @Override
  public UnaryCallable<DeleteBlueprintRequest, Empty> deleteBlueprintCallable() {
    return deleteBlueprintCallable;
  }

  @Override
  public UnaryCallable<DeleteBlueprintRevisionRequest, Blueprint>
      deleteBlueprintRevisionCallable() {
    return deleteBlueprintRevisionCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintsRequest, ListBlueprintsResponse> listBlueprintsCallable() {
    return listBlueprintsCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintsRequest, ListBlueprintsPagedResponse>
      listBlueprintsPagedCallable() {
    return listBlueprintsPagedCallable;
  }

  @Override
  public UnaryCallable<ApproveBlueprintRequest, Blueprint> approveBlueprintCallable() {
    return approveBlueprintCallable;
  }

  @Override
  public UnaryCallable<ProposeBlueprintRequest, Blueprint> proposeBlueprintCallable() {
    return proposeBlueprintCallable;
  }

  @Override
  public UnaryCallable<RejectBlueprintRequest, Blueprint> rejectBlueprintCallable() {
    return rejectBlueprintCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsCallable() {
    return listBlueprintRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsPagedCallable() {
    return listBlueprintRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsCallable() {
    return searchBlueprintRevisionsCallable;
  }

  @Override
  public UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsPagedCallable() {
    return searchBlueprintRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsCallable() {
    return searchDeploymentRevisionsCallable;
  }

  @Override
  public UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsPagedCallable() {
    return searchDeploymentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesCallable() {
    return discardBlueprintChangesCallable;
  }

  @Override
  public UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsCallable() {
    return listPublicBlueprintsCallable;
  }

  @Override
  public UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsPagedCallable() {
    return listPublicBlueprintsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPublicBlueprintRequest, PublicBlueprint> getPublicBlueprintCallable() {
    return getPublicBlueprintCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return updateDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public UnaryCallable<RemoveDeploymentRequest, Empty> removeDeploymentCallable() {
    return removeDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRevisionRequest, Deployment>
      deleteDeploymentRevisionCallable() {
    return deleteDeploymentRevisionCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsCallable() {
    return listDeploymentRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsPagedCallable() {
    return listDeploymentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesCallable() {
    return discardDeploymentChangesCallable;
  }

  @Override
  public UnaryCallable<ApplyDeploymentRequest, Deployment> applyDeploymentCallable() {
    return applyDeploymentCallable;
  }

  @Override
  public UnaryCallable<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusCallable() {
    return computeDeploymentStatusCallable;
  }

  @Override
  public UnaryCallable<RollbackDeploymentRequest, Deployment> rollbackDeploymentCallable() {
    return rollbackDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentCallable() {
    return getHydratedDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsCallable() {
    return listHydratedDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsPagedCallable() {
    return listHydratedDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentCallable() {
    return updateHydratedDeploymentCallable;
  }

  @Override
  public UnaryCallable<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentCallable() {
    return applyHydratedDeploymentCallable;
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
