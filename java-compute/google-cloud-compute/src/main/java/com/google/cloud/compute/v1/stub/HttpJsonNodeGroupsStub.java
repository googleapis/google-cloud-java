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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NodeGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupsClient.ListNodesPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupsClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddNodesNodeGroupRequest;
import com.google.cloud.compute.v1.AggregatedListNodeGroupsRequest;
import com.google.cloud.compute.v1.DeleteNodeGroupRequest;
import com.google.cloud.compute.v1.DeleteNodesNodeGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeGroupRequest;
import com.google.cloud.compute.v1.GetNodeGroupRequest;
import com.google.cloud.compute.v1.InsertNodeGroupRequest;
import com.google.cloud.compute.v1.ListNodeGroupsRequest;
import com.google.cloud.compute.v1.ListNodesNodeGroupsRequest;
import com.google.cloud.compute.v1.NodeGroup;
import com.google.cloud.compute.v1.NodeGroupAggregatedList;
import com.google.cloud.compute.v1.NodeGroupList;
import com.google.cloud.compute.v1.NodeGroupsListNodes;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchNodeGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyNodeGroupRequest;
import com.google.cloud.compute.v1.SetNodeTemplateNodeGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeGroupRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
 * REST stub implementation for the NodeGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonNodeGroupsStub extends NodeGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddNodesNodeGroupRequest, Operation>
      addNodesMethodDescriptor =
          ApiMethodDescriptor.<AddNodesNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/AddNodes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddNodesNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/addNodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddNodesNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddNodesNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "nodeGroupsAddNodesRequestResource",
                                      request.getNodeGroupsAddNodesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddNodesNodeGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListNodeGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/nodeGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNodeGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNodeGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasIncludeAllScopes()) {
                              serializer.putQueryParam(
                                  fields, "includeAllScopes", request.getIncludeAllScopes());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeGroupAggregatedList>newBuilder()
                      .setDefaultInstance(NodeGroupAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNodeGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
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
                  (DeleteNodeGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteNodesNodeGroupRequest, Operation>
      deleteNodesMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodesNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/DeleteNodes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNodesNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/deleteNodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodesNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodesNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "nodeGroupsDeleteNodesRequestResource",
                                      request.getNodeGroupsDeleteNodesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteNodesNodeGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetNodeGroupRequest, NodeGroup> getMethodDescriptor =
      ApiMethodDescriptor.<GetNodeGroupRequest, NodeGroup>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.NodeGroups/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNodeGroupRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetNodeGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetNodeGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<NodeGroup>newBuilder()
                  .setDefaultInstance(NodeGroup.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetIamPolicyNodeGroupRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyNodeGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasOptionsRequestedPolicyVersion()) {
                              serializer.putQueryParam(
                                  fields,
                                  "optionsRequestedPolicyVersion",
                                  request.getOptionsRequestedPolicyVersion());
                            }
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

  private static final ApiMethodDescriptor<InsertNodeGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "initialNodeCount", request.getInitialNodeCount());
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "nodeGroupResource", request.getNodeGroupResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertNodeGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListNodeGroupsRequest, NodeGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListNodeGroupsRequest, NodeGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodeGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodeGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodeGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeGroupList>newBuilder()
                      .setDefaultInstance(NodeGroupList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNodesNodeGroupsRequest, NodeGroupsListNodes>
      listNodesMethodDescriptor =
          ApiMethodDescriptor.<ListNodesNodeGroupsRequest, NodeGroupsListNodes>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/ListNodes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodesNodeGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/listNodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodesNodeGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodesNodeGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeGroupsListNodes>newBuilder()
                      .setDefaultInstance(NodeGroupsListNodes.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchNodeGroupRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchNodeGroupRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.NodeGroups/Patch")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchNodeGroupRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PatchNodeGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PatchNodeGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("nodeGroupResource", request.getNodeGroupResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (PatchNodeGroupRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                opName.append(":").append(request.getZone());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<SetIamPolicyNodeGroupRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyNodeGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "zoneSetPolicyRequestResource",
                                      request.getZoneSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetNodeTemplateNodeGroupRequest, Operation>
      setNodeTemplateMethodDescriptor =
          ApiMethodDescriptor.<SetNodeTemplateNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/SetNodeTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNodeTemplateNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/setNodeTemplate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodeTemplateNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetNodeTemplateNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "nodeGroupsSetNodeTemplateRequestResource",
                                      request.getNodeGroupsSetNodeTemplateRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetNodeTemplateNodeGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<AddNodesNodeGroupRequest, Operation> addNodesCallable;
  private final OperationCallable<AddNodesNodeGroupRequest, Operation, Operation>
      addNodesOperationCallable;
  private final UnaryCallable<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListNodeGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteNodeGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteNodeGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DeleteNodesNodeGroupRequest, Operation> deleteNodesCallable;
  private final OperationCallable<DeleteNodesNodeGroupRequest, Operation, Operation>
      deleteNodesOperationCallable;
  private final UnaryCallable<GetNodeGroupRequest, NodeGroup> getCallable;
  private final UnaryCallable<GetIamPolicyNodeGroupRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertNodeGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertNodeGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListNodeGroupsRequest, NodeGroupList> listCallable;
  private final UnaryCallable<ListNodeGroupsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListNodesNodeGroupsRequest, NodeGroupsListNodes> listNodesCallable;
  private final UnaryCallable<ListNodesNodeGroupsRequest, ListNodesPagedResponse>
      listNodesPagedCallable;
  private final UnaryCallable<PatchNodeGroupRequest, Operation> patchCallable;
  private final OperationCallable<PatchNodeGroupRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetIamPolicyNodeGroupRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetNodeTemplateNodeGroupRequest, Operation> setNodeTemplateCallable;
  private final OperationCallable<SetNodeTemplateNodeGroupRequest, Operation, Operation>
      setNodeTemplateOperationCallable;
  private final UnaryCallable<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNodeGroupsStub create(NodeGroupsStubSettings settings)
      throws IOException {
    return new HttpJsonNodeGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNodeGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNodeGroupsStub(NodeGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNodeGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNodeGroupsStub(
        NodeGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeGroupsStub(NodeGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNodeGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeGroupsStub(
      NodeGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddNodesNodeGroupRequest, Operation> addNodesTransportSettings =
        HttpJsonCallSettings.<AddNodesNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(addNodesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteNodeGroupRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteNodesNodeGroupRequest, Operation> deleteNodesTransportSettings =
        HttpJsonCallSettings.<DeleteNodesNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetNodeGroupRequest, NodeGroup> getTransportSettings =
        HttpJsonCallSettings.<GetNodeGroupRequest, NodeGroup>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyNodeGroupRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyNodeGroupRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertNodeGroupRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNodeGroupsRequest, NodeGroupList> listTransportSettings =
        HttpJsonCallSettings.<ListNodeGroupsRequest, NodeGroupList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNodesNodeGroupsRequest, NodeGroupsListNodes>
        listNodesTransportSettings =
            HttpJsonCallSettings.<ListNodesNodeGroupsRequest, NodeGroupsListNodes>newBuilder()
                .setMethodDescriptor(listNodesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchNodeGroupRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyNodeGroupRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyNodeGroupRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetNodeTemplateNodeGroupRequest, Operation>
        setNodeTemplateTransportSettings =
            HttpJsonCallSettings.<SetNodeTemplateNodeGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodeTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.addNodesCallable =
        callableFactory.createUnaryCallable(
            addNodesTransportSettings, settings.addNodesSettings(), clientContext);
    this.addNodesOperationCallable =
        callableFactory.createOperationCallable(
            addNodesTransportSettings,
            settings.addNodesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteNodesCallable =
        callableFactory.createUnaryCallable(
            deleteNodesTransportSettings, settings.deleteNodesSettings(), clientContext);
    this.deleteNodesOperationCallable =
        callableFactory.createOperationCallable(
            deleteNodesTransportSettings,
            settings.deleteNodesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listNodesCallable =
        callableFactory.createUnaryCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.listNodesPagedCallable =
        callableFactory.createPagedCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            setNodeTemplateTransportSettings, settings.setNodeTemplateSettings(), clientContext);
    this.setNodeTemplateOperationCallable =
        callableFactory.createOperationCallable(
            setNodeTemplateTransportSettings,
            settings.setNodeTemplateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(addNodesMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteNodesMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listNodesMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setNodeTemplateMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddNodesNodeGroupRequest, Operation> addNodesCallable() {
    return addNodesCallable;
  }

  @Override
  public OperationCallable<AddNodesNodeGroupRequest, Operation, Operation>
      addNodesOperationCallable() {
    return addNodesOperationCallable;
  }

  @Override
  public UnaryCallable<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListNodeGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteNodeGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteNodeGroupRequest, Operation, Operation> deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNodesNodeGroupRequest, Operation> deleteNodesCallable() {
    return deleteNodesCallable;
  }

  @Override
  public OperationCallable<DeleteNodesNodeGroupRequest, Operation, Operation>
      deleteNodesOperationCallable() {
    return deleteNodesOperationCallable;
  }

  @Override
  public UnaryCallable<GetNodeGroupRequest, NodeGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyNodeGroupRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertNodeGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertNodeGroupRequest, Operation, Operation> insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListNodeGroupsRequest, NodeGroupList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListNodeGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<ListNodesNodeGroupsRequest, NodeGroupsListNodes> listNodesCallable() {
    return listNodesCallable;
  }

  @Override
  public UnaryCallable<ListNodesNodeGroupsRequest, ListNodesPagedResponse>
      listNodesPagedCallable() {
    return listNodesPagedCallable;
  }

  @Override
  public UnaryCallable<PatchNodeGroupRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchNodeGroupRequest, Operation, Operation> patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyNodeGroupRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetNodeTemplateNodeGroupRequest, Operation> setNodeTemplateCallable() {
    return setNodeTemplateCallable;
  }

  @Override
  public OperationCallable<SetNodeTemplateNodeGroupRequest, Operation, Operation>
      setNodeTemplateOperationCallable() {
    return setNodeTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
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
