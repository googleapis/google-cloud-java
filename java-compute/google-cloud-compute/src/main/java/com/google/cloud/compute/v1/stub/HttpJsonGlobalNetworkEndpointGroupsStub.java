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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DeleteGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListGlobalNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest;
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
 * REST stub implementation for the GlobalNetworkEndpointGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGlobalNetworkEndpointGroupsStub extends GlobalNetworkEndpointGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.GlobalNetworkEndpointGroups/AttachNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
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
                                      "globalNetworkEndpointGroupsAttachEndpointsRequestResource",
                                      request
                                          .getGlobalNetworkEndpointGroupsAttachEndpointsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteGlobalNetworkEndpointGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalNetworkEndpointGroupRequest>
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
                  (DeleteGlobalNetworkEndpointGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
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
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.GlobalNetworkEndpointGroups/DetachNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
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
                                      "globalNetworkEndpointGroupsDetachEndpointsRequestResource",
                                      request
                                          .getGlobalNetworkEndpointGroupsDetachEndpointsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
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
          GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalNetworkEndpointGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalNetworkEndpointGroupRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertGlobalNetworkEndpointGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalNetworkEndpointGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalNetworkEndpointGroupRequest>
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
                  (InsertGlobalNetworkEndpointGroupRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
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
          ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalNetworkEndpointGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalNetworkEndpointGroupsRequest> serializer =
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
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                  NetworkEndpointGroupsListNetworkEndpoints>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.GlobalNetworkEndpointGroups/ListNetworkEndpoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "networkEndpointGroup", request.getNetworkEndpointGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest>
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

  private final UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable;
  private final OperationCallable<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable;
  private final UnaryCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable;
  private final OperationCallable<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable;
  private final UnaryCallable<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getCallable;
  private final UnaryCallable<InsertGlobalNetworkEndpointGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable;
  private final UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable;
  private final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalNetworkEndpointGroupsStub create(
      GlobalNetworkEndpointGroupsStubSettings settings) throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalNetworkEndpointGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupsStub(
        GlobalNetworkEndpointGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalNetworkEndpointGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupsStub(
        GlobalNetworkEndpointGroupsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalNetworkEndpointGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalNetworkEndpointGroupsStub(
      GlobalNetworkEndpointGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalNetworkEndpointGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalNetworkEndpointGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalNetworkEndpointGroupsStub(
      GlobalNetworkEndpointGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        attachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(attachNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteGlobalNetworkEndpointGroupRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        detachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(detachNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertGlobalNetworkEndpointGroupRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
            NetworkEndpointGroupsListNetworkEndpoints>
        listNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                    NetworkEndpointGroupsListNetworkEndpoints>
                    newBuilder()
                .setMethodDescriptor(listNetworkEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
  public UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return attachNetworkEndpointsCallable;
  }

  @Override
  public OperationCallable<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable() {
    return attachNetworkEndpointsOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return detachNetworkEndpointsCallable;
  }

  @Override
  public OperationCallable<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    return detachNetworkEndpointsOperationCallable;
  }

  @Override
  public UnaryCallable<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertGlobalNetworkEndpointGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return listNetworkEndpointsCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
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
