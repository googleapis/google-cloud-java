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

import static com.google.cloud.compute.v1.InstanceGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupsRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupRequest;
import com.google.cloud.compute.v1.GetInstanceGroupRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupList;
import com.google.cloud.compute.v1.InstanceGroupsListInstances;
import com.google.cloud.compute.v1.ListInstanceGroupsRequest;
import com.google.cloud.compute.v1.ListInstancesInstanceGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.RemoveInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.SetNamedPortsInstanceGroupRequest;
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
 * REST stub implementation for the InstanceGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonInstanceGroupsStub extends InstanceGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddInstancesInstanceGroupRequest, Operation>
      addInstancesMethodDescriptor =
          ApiMethodDescriptor.<AddInstancesInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/AddInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddInstancesInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/addInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddInstancesInstanceGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroup", request.getInstanceGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddInstancesInstanceGroupRequest> serializer =
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
                                      "instanceGroupsAddInstancesRequestResource",
                                      request.getInstanceGroupsAddInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddInstancesInstanceGroupRequest request, Operation response) -> {
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
          AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/instanceGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListInstanceGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListInstanceGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<InstanceGroupAggregatedList>newBuilder()
                      .setDefaultInstance(InstanceGroupAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroup", request.getInstanceGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceGroupRequest> serializer =
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
                  (DeleteInstanceGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetInstanceGroupRequest, InstanceGroup>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceGroupRequest, InstanceGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroup", request.getInstanceGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroup>newBuilder()
                      .setDefaultInstance(InstanceGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertInstanceGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInstanceGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInstanceGroupRequest> serializer =
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
                                      "instanceGroupResource",
                                      request.getInstanceGroupResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertInstanceGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListInstanceGroupsRequest, InstanceGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListInstanceGroupsRequest, InstanceGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstanceGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstanceGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<InstanceGroupList>newBuilder()
                      .setDefaultInstance(InstanceGroupList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/ListInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/listInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesInstanceGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroup", request.getInstanceGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesInstanceGroupsRequest> serializer =
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
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupsListInstancesRequestResource",
                                      request.getInstanceGroupsListInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupsListInstances>newBuilder()
                      .setDefaultInstance(InstanceGroupsListInstances.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesMethodDescriptor =
          ApiMethodDescriptor.<RemoveInstancesInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/RemoveInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveInstancesInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/removeInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveInstancesInstanceGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroup", request.getInstanceGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveInstancesInstanceGroupRequest> serializer =
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
                                      "instanceGroupsRemoveInstancesRequestResource",
                                      request.getInstanceGroupsRemoveInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveInstancesInstanceGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetNamedPortsInstanceGroupRequest, Operation>
      setNamedPortsMethodDescriptor =
          ApiMethodDescriptor.<SetNamedPortsInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/SetNamedPorts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNamedPortsInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/setNamedPorts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetNamedPortsInstanceGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroup", request.getInstanceGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetNamedPortsInstanceGroupRequest> serializer =
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
                                      "instanceGroupsSetNamedPortsRequestResource",
                                      request.getInstanceGroupsSetNamedPortsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetNamedPortsInstanceGroupRequest request, Operation response) -> {
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

  private final UnaryCallable<AddInstancesInstanceGroupRequest, Operation> addInstancesCallable;
  private final OperationCallable<AddInstancesInstanceGroupRequest, Operation, Operation>
      addInstancesOperationCallable;
  private final UnaryCallable<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListInstanceGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteInstanceGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteInstanceGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetInstanceGroupRequest, InstanceGroup> getCallable;
  private final UnaryCallable<InsertInstanceGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertInstanceGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListInstanceGroupsRequest, InstanceGroupList> listCallable;
  private final UnaryCallable<ListInstanceGroupsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesCallable;
  private final UnaryCallable<ListInstancesInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesCallable;
  private final OperationCallable<RemoveInstancesInstanceGroupRequest, Operation, Operation>
      removeInstancesOperationCallable;
  private final UnaryCallable<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsCallable;
  private final OperationCallable<SetNamedPortsInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceGroupsStub create(InstanceGroupsStubSettings settings)
      throws IOException {
    return new HttpJsonInstanceGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceGroupsStub(
        InstanceGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceGroupsStub(
        InstanceGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupsStub(
      InstanceGroupsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupsStub(
      InstanceGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddInstancesInstanceGroupRequest, Operation>
        addInstancesTransportSettings =
            HttpJsonCallSettings.<AddInstancesInstanceGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(addInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteInstanceGroupRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetInstanceGroupRequest, InstanceGroup> getTransportSettings =
        HttpJsonCallSettings.<GetInstanceGroupRequest, InstanceGroup>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertInstanceGroupRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInstanceGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListInstanceGroupsRequest, InstanceGroupList> listTransportSettings =
        HttpJsonCallSettings.<ListInstanceGroupsRequest, InstanceGroupList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
        listInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveInstancesInstanceGroupRequest, Operation>
        removeInstancesTransportSettings =
            HttpJsonCallSettings.<RemoveInstancesInstanceGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(removeInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetNamedPortsInstanceGroupRequest, Operation>
        setNamedPortsTransportSettings =
            HttpJsonCallSettings.<SetNamedPortsInstanceGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(setNamedPortsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.addInstancesCallable =
        callableFactory.createUnaryCallable(
            addInstancesTransportSettings, settings.addInstancesSettings(), clientContext);
    this.addInstancesOperationCallable =
        callableFactory.createOperationCallable(
            addInstancesTransportSettings,
            settings.addInstancesOperationSettings(),
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
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.removeInstancesCallable =
        callableFactory.createUnaryCallable(
            removeInstancesTransportSettings, settings.removeInstancesSettings(), clientContext);
    this.removeInstancesOperationCallable =
        callableFactory.createOperationCallable(
            removeInstancesTransportSettings,
            settings.removeInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setNamedPortsCallable =
        callableFactory.createUnaryCallable(
            setNamedPortsTransportSettings, settings.setNamedPortsSettings(), clientContext);
    this.setNamedPortsOperationCallable =
        callableFactory.createOperationCallable(
            setNamedPortsTransportSettings,
            settings.setNamedPortsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addInstancesMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(removeInstancesMethodDescriptor);
    methodDescriptors.add(setNamedPortsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddInstancesInstanceGroupRequest, Operation> addInstancesCallable() {
    return addInstancesCallable;
  }

  @Override
  public OperationCallable<AddInstancesInstanceGroupRequest, Operation, Operation>
      addInstancesOperationCallable() {
    return addInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstanceGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetInstanceGroupRequest, InstanceGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertInstanceGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertInstanceGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupsRequest, InstanceGroupList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<RemoveInstancesInstanceGroupRequest, Operation> removeInstancesCallable() {
    return removeInstancesCallable;
  }

  @Override
  public OperationCallable<RemoveInstancesInstanceGroupRequest, Operation, Operation>
      removeInstancesOperationCallable() {
    return removeInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsCallable() {
    return setNamedPortsCallable;
  }

  @Override
  public OperationCallable<SetNamedPortsInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationCallable() {
    return setNamedPortsOperationCallable;
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
