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

import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.AttachNetworkEndpointsNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DeleteNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupAggregatedList;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkEndpointGroupRequest;
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
 * REST stub implementation for the NetworkEndpointGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonNetworkEndpointGroupsStub extends NetworkEndpointGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEndpointGroups/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/networkEndpointGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNetworkEndpointGroupsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNetworkEndpointGroupsRequest>
                                serializer = ProtoRestSerializer.create();
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
                  ProtoMessageResponseParser.<NetworkEndpointGroupAggregatedList>newBuilder()
                      .setDefaultInstance(NetworkEndpointGroupAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkEndpointGroups/AttachNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AttachNetworkEndpointsNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AttachNetworkEndpointsNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AttachNetworkEndpointsNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "networkEndpointGroupsAttachEndpointsRequestResource",
                                      request
                                          .getNetworkEndpointGroupsAttachEndpointsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AttachNetworkEndpointsNetworkEndpointGroupRequest request,
                      Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteNetworkEndpointGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEndpointGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkEndpointGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkEndpointGroupRequest> serializer =
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
                  (DeleteNetworkEndpointGroupRequest request, Operation response) -> {
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
          DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkEndpointGroups/DetachNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DetachNetworkEndpointsNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DetachNetworkEndpointsNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DetachNetworkEndpointsNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "networkEndpointGroupsDetachEndpointsRequestResource",
                                      request
                                          .getNetworkEndpointGroupsDetachEndpointsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DetachNetworkEndpointsNetworkEndpointGroupRequest request,
                      Operation response) -> {
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

  private static final ApiMethodDescriptor<GetNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEndpointGroups/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkEndpointGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkEndpointGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkEndpointGroup>newBuilder()
                      .setDefaultInstance(NetworkEndpointGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertNetworkEndpointGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEndpointGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNetworkEndpointGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNetworkEndpointGroupRequest> serializer =
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
                                      "networkEndpointGroupResource",
                                      request.getNetworkEndpointGroupResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertNetworkEndpointGroupRequest request, Operation response) -> {
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
          ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEndpointGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkEndpointGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkEndpointGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<NetworkEndpointGroupList>newBuilder()
                      .setDefaultInstance(NetworkEndpointGroupList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointsNetworkEndpointGroupsRequest,
                  NetworkEndpointGroupsListNetworkEndpoints>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkEndpointGroups/ListNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListNetworkEndpointsNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkEndpointsNetworkEndpointGroupsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkEndpointsNetworkEndpointGroupsRequest>
                                serializer = ProtoRestSerializer.create();
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
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "networkEndpointGroupsListEndpointsRequestResource",
                                      request
                                          .getNetworkEndpointGroupsListEndpointsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkEndpointGroupsListNetworkEndpoints>newBuilder()
                      .setDefaultInstance(
                          NetworkEndpointGroupsListNetworkEndpoints.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEndpointGroups/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/networkEndpointGroups/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
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

  private final UnaryCallable<
          AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListNetworkEndpointGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable;
  private final OperationCallable<
          AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable;
  private final UnaryCallable<DeleteNetworkEndpointGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable;
  private final OperationCallable<
          DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable;
  private final UnaryCallable<GetNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable;
  private final UnaryCallable<InsertNetworkEndpointGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable;
  private final UnaryCallable<ListNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable;
  private final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable;
  private final UnaryCallable<
          TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNetworkEndpointGroupsStub create(
      NetworkEndpointGroupsStubSettings settings) throws IOException {
    return new HttpJsonNetworkEndpointGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetworkEndpointGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNetworkEndpointGroupsStub(
        NetworkEndpointGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNetworkEndpointGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetworkEndpointGroupsStub(
        NetworkEndpointGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetworkEndpointGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkEndpointGroupsStub(
      NetworkEndpointGroupsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonNetworkEndpointGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetworkEndpointGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkEndpointGroupsStub(
      NetworkEndpointGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<
            AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
        attachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(attachNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteNetworkEndpointGroupRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteNetworkEndpointGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
        detachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(detachNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetNetworkEndpointGroupRequest, NetworkEndpointGroup>
        getTransportSettings =
            HttpJsonCallSettings.<GetNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertNetworkEndpointGroupRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertNetworkEndpointGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListNetworkEndpointsNetworkEndpointGroupsRequest,
            NetworkEndpointGroupsListNetworkEndpoints>
        listNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointsNetworkEndpointGroupsRequest,
                    NetworkEndpointGroupsListNetworkEndpoints>
                    newBuilder()
                .setMethodDescriptor(listNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.attachNetworkEndpointsCallable =
        callableFactory.createUnaryCallable(
            attachNetworkEndpointsTransportSettings,
            settings.attachNetworkEndpointsSettings(),
            clientContext);
    this.attachNetworkEndpointsOperationCallable =
        callableFactory.createOperationCallable(
            attachNetworkEndpointsTransportSettings,
            settings.attachNetworkEndpointsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.detachNetworkEndpointsCallable =
        callableFactory.createUnaryCallable(
            detachNetworkEndpointsTransportSettings,
            settings.detachNetworkEndpointsSettings(),
            clientContext);
    this.detachNetworkEndpointsOperationCallable =
        callableFactory.createOperationCallable(
            detachNetworkEndpointsTransportSettings,
            settings.detachNetworkEndpointsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
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
    this.listNetworkEndpointsCallable =
        callableFactory.createUnaryCallable(
            listNetworkEndpointsTransportSettings,
            settings.listNetworkEndpointsSettings(),
            clientContext);
    this.listNetworkEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkEndpointsTransportSettings,
            settings.listNetworkEndpointsSettings(),
            clientContext);
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
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(attachNetworkEndpointsMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(detachNetworkEndpointsMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listNetworkEndpointsMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListNetworkEndpointGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return attachNetworkEndpointsCallable;
  }

  @Override
  public OperationCallable<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable() {
    return attachNetworkEndpointsOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return detachNetworkEndpointsCallable;
  }

  @Override
  public OperationCallable<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    return detachNetworkEndpointsOperationCallable;
  }

  @Override
  public UnaryCallable<GetNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertNetworkEndpointGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListNetworkEndpointGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return listNetworkEndpointsCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    return listNetworkEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
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
