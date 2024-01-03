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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionNetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.RegionNetworkEndpointGroupsClient.ListPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AttachNetworkEndpointsRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DeleteRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsRegionNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.ListRegionNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
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
 * REST stub implementation for the RegionNetworkEndpointGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionNetworkEndpointGroupsStub extends RegionNetworkEndpointGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkEndpointGroups/AttachNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AttachNetworkEndpointsRegionNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    AttachNetworkEndpointsRegionNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    AttachNetworkEndpointsRegionNetworkEndpointGroupRequest>
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
                                      "regionNetworkEndpointGroupsAttachEndpointsRequestResource",
                                      request
                                          .getRegionNetworkEndpointGroupsAttachEndpointsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AttachNetworkEndpointsRegionNetworkEndpointGroupRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteRegionNetworkEndpointGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkEndpointGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (DeleteRegionNetworkEndpointGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
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
          DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkEndpointGroups/DetachNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DetachNetworkEndpointsRegionNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DetachNetworkEndpointsRegionNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DetachNetworkEndpointsRegionNetworkEndpointGroupRequest>
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
                                      "regionNetworkEndpointGroupsDetachEndpointsRequestResource",
                                      request
                                          .getRegionNetworkEndpointGroupsDetachEndpointsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DetachNetworkEndpointsRegionNetworkEndpointGroupRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
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
          GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkEndpointGroups/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionNetworkEndpointGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionNetworkEndpointGroupRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertRegionNetworkEndpointGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkEndpointGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEndpointGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionNetworkEndpointGroupRequest>
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
                  (InsertRegionNetworkEndpointGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
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
          ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkEndpointGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEndpointGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionNetworkEndpointGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionNetworkEndpointGroupsRequest> serializer =
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
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
                  NetworkEndpointGroupsListNetworkEndpoints>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkEndpointGroups/ListNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListNetworkEndpointsRegionNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListNetworkEndpointsRegionNetworkEndpointGroupsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListNetworkEndpointsRegionNetworkEndpointGroupsRequest>
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
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkEndpointGroupsListNetworkEndpoints>newBuilder()
                      .setDefaultInstance(
                          NetworkEndpointGroupsListNetworkEndpoints.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable;
  private final OperationCallable<
          AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable;
  private final UnaryCallable<DeleteRegionNetworkEndpointGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable;
  private final OperationCallable<
          DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable;
  private final UnaryCallable<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getCallable;
  private final UnaryCallable<InsertRegionNetworkEndpointGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable;
  private final UnaryCallable<ListRegionNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable;
  private final UnaryCallable<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionNetworkEndpointGroupsStub create(
      RegionNetworkEndpointGroupsStubSettings settings) throws IOException {
    return new HttpJsonRegionNetworkEndpointGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionNetworkEndpointGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionNetworkEndpointGroupsStub(
        RegionNetworkEndpointGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionNetworkEndpointGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionNetworkEndpointGroupsStub(
        RegionNetworkEndpointGroupsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionNetworkEndpointGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNetworkEndpointGroupsStub(
      RegionNetworkEndpointGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionNetworkEndpointGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionNetworkEndpointGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNetworkEndpointGroupsStub(
      RegionNetworkEndpointGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
        attachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(attachNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "network_endpoint_group",
                          String.valueOf(request.getNetworkEndpointGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteRegionNetworkEndpointGroupRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "network_endpoint_group",
                          String.valueOf(request.getNetworkEndpointGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
        detachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(detachNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "network_endpoint_group",
                          String.valueOf(request.getNetworkEndpointGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "network_endpoint_group",
                          String.valueOf(request.getNetworkEndpointGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertRegionNetworkEndpointGroupRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
            NetworkEndpointGroupsListNetworkEndpoints>
        listNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
                    NetworkEndpointGroupsListNetworkEndpoints>
                    newBuilder()
                .setMethodDescriptor(listNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "network_endpoint_group",
                          String.valueOf(request.getNetworkEndpointGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();

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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(attachNetworkEndpointsMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(detachNetworkEndpointsMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listNetworkEndpointsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return attachNetworkEndpointsCallable;
  }

  @Override
  public OperationCallable<
          AttachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable() {
    return attachNetworkEndpointsOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return detachNetworkEndpointsCallable;
  }

  @Override
  public OperationCallable<
          DetachNetworkEndpointsRegionNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    return detachNetworkEndpointsOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionNetworkEndpointGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return listNetworkEndpointsCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsRegionNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    return listNetworkEndpointsPagedCallable;
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
