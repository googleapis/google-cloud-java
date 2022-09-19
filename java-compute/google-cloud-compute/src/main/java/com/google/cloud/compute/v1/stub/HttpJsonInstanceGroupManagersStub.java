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

import static com.google.cloud.compute.v1.InstanceGroupManagersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

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
import com.google.cloud.compute.v1.AbandonInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ApplyUpdatesToInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.CreateInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeletePerInstanceConfigsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.GetInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.InstanceGroupManagerAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupManagerList;
import com.google.cloud.compute.v1.InstanceGroupManagersListErrorsResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListManagedInstancesResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListPerInstanceConfigsResp;
import com.google.cloud.compute.v1.ListErrorsInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListManagedInstancesInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListPerInstanceConfigsInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.PatchPerInstanceConfigsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RecreateInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.ResizeInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetInstanceTemplateInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetTargetPoolsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.UpdatePerInstanceConfigsInstanceGroupManagerRequest;
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
 * REST stub implementation for the InstanceGroupManagers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonInstanceGroupManagersStub extends InstanceGroupManagersStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesMethodDescriptor =
          ApiMethodDescriptor.<AbandonInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/AbandonInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AbandonInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/abandonInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AbandonInstancesInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AbandonInstancesInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersAbandonInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersAbandonInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AbandonInstancesInstanceGroupManagerRequest request, Operation response) -> {
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
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/instanceGroupManagers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListInstanceGroupManagersRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListInstanceGroupManagersRequest>
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
                  ProtoMessageResponseParser.<InstanceGroupManagerAggregatedList>newBuilder()
                      .setDefaultInstance(InstanceGroupManagerAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/ApplyUpdatesToInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ApplyUpdatesToInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyUpdatesToInstancesInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyUpdatesToInstancesInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersApplyUpdatesRequestResource",
                                      request.getInstanceGroupManagersApplyUpdatesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ApplyUpdatesToInstancesInstanceGroupManagerRequest request,
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

  private static final ApiMethodDescriptor<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesMethodDescriptor =
          ApiMethodDescriptor.<CreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/CreateInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/createInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstancesInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstancesInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersCreateInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersCreateInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInstancesInstanceGroupManagerRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteInstanceGroupManagerRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceGroupManagerRequest> serializer =
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
                  (DeleteInstanceGroupManagerRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/DeleteInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deleteInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstancesInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstancesInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersDeleteInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersDeleteInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteInstancesInstanceGroupManagerRequest request, Operation response) -> {
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
          DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/DeletePerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeletePerInstanceConfigsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePerInstanceConfigsInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePerInstanceConfigsInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersDeletePerInstanceConfigsReqResource",
                                      request
                                          .getInstanceGroupManagersDeletePerInstanceConfigsReqResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeletePerInstanceConfigsInstanceGroupManagerRequest request,
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

  private static final ApiMethodDescriptor<GetInstanceGroupManagerRequest, InstanceGroupManager>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupManager>newBuilder()
                      .setDefaultInstance(InstanceGroupManager.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertInstanceGroupManagerRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInstanceGroupManagerRequest> serializer =
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
                                      "instanceGroupManagerResource",
                                      request.getInstanceGroupManagerResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertInstanceGroupManagerRequest request, Operation response) -> {
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
          ListInstanceGroupManagersRequest, InstanceGroupManagerList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstanceGroupManagersRequest, InstanceGroupManagerList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstanceGroupManagersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstanceGroupManagersRequest> serializer =
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
                  ProtoMessageResponseParser.<InstanceGroupManagerList>newBuilder()
                      .setDefaultInstance(InstanceGroupManagerList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsMethodDescriptor =
          ApiMethodDescriptor
              .<ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/ListErrors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListErrorsInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listErrors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListErrorsInstanceGroupManagersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListErrorsInstanceGroupManagersRequest> serializer =
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
                  ProtoMessageResponseParser.<InstanceGroupManagersListErrorsResponse>newBuilder()
                      .setDefaultInstance(
                          InstanceGroupManagersListErrorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListManagedInstancesInstanceGroupManagersRequest,
                  InstanceGroupManagersListManagedInstancesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/ListManagedInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListManagedInstancesInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListManagedInstancesInstanceGroupManagersRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListManagedInstancesInstanceGroupManagersRequest>
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
                  ProtoMessageResponseParser
                      .<InstanceGroupManagersListManagedInstancesResponse>newBuilder()
                      .setDefaultInstance(
                          InstanceGroupManagersListManagedInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPerInstanceConfigsInstanceGroupManagersRequest,
                  InstanceGroupManagersListPerInstanceConfigsResp>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/ListPerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPerInstanceConfigsInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPerInstanceConfigsInstanceGroupManagersRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPerInstanceConfigsInstanceGroupManagersRequest>
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
                  ProtoMessageResponseParser
                      .<InstanceGroupManagersListPerInstanceConfigsResp>newBuilder()
                      .setDefaultInstance(
                          InstanceGroupManagersListPerInstanceConfigsResp.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchInstanceGroupManagerRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchInstanceGroupManagerRequest> serializer =
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
                                      "instanceGroupManagerResource",
                                      request.getInstanceGroupManagerResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchInstanceGroupManagerRequest request, Operation response) -> {
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
          PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/PatchPerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchPerInstanceConfigsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchPerInstanceConfigsInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchPerInstanceConfigsInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersPatchPerInstanceConfigsReqResource",
                                      request
                                          .getInstanceGroupManagersPatchPerInstanceConfigsReqResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchPerInstanceConfigsInstanceGroupManagerRequest request,
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

  private static final ApiMethodDescriptor<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesMethodDescriptor =
          ApiMethodDescriptor.<RecreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/RecreateInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RecreateInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/recreateInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecreateInstancesInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecreateInstancesInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersRecreateInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersRecreateInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RecreateInstancesInstanceGroupManagerRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ResizeInstanceGroupManagerRequest, Operation>
      resizeMethodDescriptor =
          ApiMethodDescriptor.<ResizeInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Resize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            serializer.putQueryParam(fields, "size", request.getSize());
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
                  (ResizeInstanceGroupManagerRequest request, Operation response) -> {
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
          SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor
              .<SetInstanceTemplateInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/SetInstanceTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetInstanceTemplateInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetInstanceTemplateInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetInstanceTemplateInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersSetInstanceTemplateRequestResource",
                                      request
                                          .getInstanceGroupManagersSetInstanceTemplateRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetInstanceTemplateInstanceGroupManagerRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsMethodDescriptor =
          ApiMethodDescriptor.<SetTargetPoolsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/SetTargetPools")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetTargetPoolsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setTargetPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetTargetPoolsInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetTargetPoolsInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersSetTargetPoolsRequestResource",
                                      request
                                          .getInstanceGroupManagersSetTargetPoolsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetTargetPoolsInstanceGroupManagerRequest request, Operation response) -> {
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
          UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/UpdatePerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdatePerInstanceConfigsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePerInstanceConfigsInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePerInstanceConfigsInstanceGroupManagerRequest>
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
                                      "instanceGroupManagersUpdatePerInstanceConfigsReqResource",
                                      request
                                          .getInstanceGroupManagersUpdatePerInstanceConfigsReqResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePerInstanceConfigsInstanceGroupManagerRequest request,
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

  private final UnaryCallable<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable;
  private final OperationCallable<AbandonInstancesInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationCallable;
  private final UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable;
  private final OperationCallable<
          ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationCallable;
  private final UnaryCallable<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesCallable;
  private final OperationCallable<CreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationCallable;
  private final UnaryCallable<DeleteInstanceGroupManagerRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable;
  private final OperationCallable<DeleteInstancesInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationCallable;
  private final UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable;
  private final OperationCallable<
          DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationCallable;
  private final UnaryCallable<GetInstanceGroupManagerRequest, InstanceGroupManager> getCallable;
  private final UnaryCallable<InsertInstanceGroupManagerRequest, Operation> insertCallable;
  private final OperationCallable<InsertInstanceGroupManagerRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListInstanceGroupManagersRequest, InstanceGroupManagerList>
      listCallable;
  private final UnaryCallable<ListInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsCallable;
  private final UnaryCallable<ListErrorsInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable;
  private final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesCallable;
  private final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest, ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable;
  private final UnaryCallable<PatchInstanceGroupManagerRequest, Operation> patchCallable;
  private final OperationCallable<PatchInstanceGroupManagerRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable;
  private final OperationCallable<
          PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationCallable;
  private final UnaryCallable<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable;
  private final OperationCallable<
          RecreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationCallable;
  private final UnaryCallable<ResizeInstanceGroupManagerRequest, Operation> resizeCallable;
  private final OperationCallable<ResizeInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationCallable;
  private final UnaryCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable;
  private final OperationCallable<
          SetInstanceTemplateInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationCallable;
  private final UnaryCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable;
  private final OperationCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationCallable;
  private final UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable;
  private final OperationCallable<
          UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceGroupManagersStub create(
      InstanceGroupManagersStubSettings settings) throws IOException {
    return new HttpJsonInstanceGroupManagersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceGroupManagersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceGroupManagersStub(
        InstanceGroupManagersStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceGroupManagersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceGroupManagersStub(
        InstanceGroupManagersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupManagersStub(
      InstanceGroupManagersStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceGroupManagersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupManagersStub(
      InstanceGroupManagersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AbandonInstancesInstanceGroupManagerRequest, Operation>
        abandonInstancesTransportSettings =
            HttpJsonCallSettings
                .<AbandonInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(abandonInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
        applyUpdatesToInstancesTransportSettings =
            HttpJsonCallSettings
                .<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(applyUpdatesToInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateInstancesInstanceGroupManagerRequest, Operation>
        createInstancesTransportSettings =
            HttpJsonCallSettings.<CreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(createInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteInstanceGroupManagerRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteInstancesInstanceGroupManagerRequest, Operation>
        deleteInstancesTransportSettings =
            HttpJsonCallSettings.<DeleteInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
        deletePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePerInstanceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetInstanceGroupManagerRequest, InstanceGroupManager>
        getTransportSettings =
            HttpJsonCallSettings.<GetInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertInstanceGroupManagerRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListInstanceGroupManagersRequest, InstanceGroupManagerList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListInstanceGroupManagersRequest, InstanceGroupManagerList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
        listErrorsTransportSettings =
            HttpJsonCallSettings
                .<ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
                    newBuilder()
                .setMethodDescriptor(listErrorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListManagedInstancesInstanceGroupManagersRequest,
            InstanceGroupManagersListManagedInstancesResponse>
        listManagedInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListManagedInstancesInstanceGroupManagersRequest,
                    InstanceGroupManagersListManagedInstancesResponse>
                    newBuilder()
                .setMethodDescriptor(listManagedInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListPerInstanceConfigsInstanceGroupManagersRequest,
            InstanceGroupManagersListPerInstanceConfigsResp>
        listPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListPerInstanceConfigsInstanceGroupManagersRequest,
                    InstanceGroupManagersListPerInstanceConfigsResp>
                    newBuilder()
                .setMethodDescriptor(listPerInstanceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchInstanceGroupManagerRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
        patchPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(patchPerInstanceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RecreateInstancesInstanceGroupManagerRequest, Operation>
        recreateInstancesTransportSettings =
            HttpJsonCallSettings
                .<RecreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(recreateInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ResizeInstanceGroupManagerRequest, Operation> resizeTransportSettings =
        HttpJsonCallSettings.<ResizeInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
        setInstanceTemplateTransportSettings =
            HttpJsonCallSettings
                .<SetInstanceTemplateInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setInstanceTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetTargetPoolsInstanceGroupManagerRequest, Operation>
        setTargetPoolsTransportSettings =
            HttpJsonCallSettings.<SetTargetPoolsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setTargetPoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
        updatePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePerInstanceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.abandonInstancesCallable =
        callableFactory.createUnaryCallable(
            abandonInstancesTransportSettings, settings.abandonInstancesSettings(), clientContext);
    this.abandonInstancesOperationCallable =
        callableFactory.createOperationCallable(
            abandonInstancesTransportSettings,
            settings.abandonInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.applyUpdatesToInstancesCallable =
        callableFactory.createUnaryCallable(
            applyUpdatesToInstancesTransportSettings,
            settings.applyUpdatesToInstancesSettings(),
            clientContext);
    this.applyUpdatesToInstancesOperationCallable =
        callableFactory.createOperationCallable(
            applyUpdatesToInstancesTransportSettings,
            settings.applyUpdatesToInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createInstancesCallable =
        callableFactory.createUnaryCallable(
            createInstancesTransportSettings, settings.createInstancesSettings(), clientContext);
    this.createInstancesOperationCallable =
        callableFactory.createOperationCallable(
            createInstancesTransportSettings,
            settings.createInstancesOperationSettings(),
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
    this.deleteInstancesCallable =
        callableFactory.createUnaryCallable(
            deleteInstancesTransportSettings, settings.deleteInstancesSettings(), clientContext);
    this.deleteInstancesOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstancesTransportSettings,
            settings.deleteInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            deletePerInstanceConfigsTransportSettings,
            settings.deletePerInstanceConfigsSettings(),
            clientContext);
    this.deletePerInstanceConfigsOperationCallable =
        callableFactory.createOperationCallable(
            deletePerInstanceConfigsTransportSettings,
            settings.deletePerInstanceConfigsOperationSettings(),
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
    this.listErrorsCallable =
        callableFactory.createUnaryCallable(
            listErrorsTransportSettings, settings.listErrorsSettings(), clientContext);
    this.listErrorsPagedCallable =
        callableFactory.createPagedCallable(
            listErrorsTransportSettings, settings.listErrorsSettings(), clientContext);
    this.listManagedInstancesCallable =
        callableFactory.createUnaryCallable(
            listManagedInstancesTransportSettings,
            settings.listManagedInstancesSettings(),
            clientContext);
    this.listManagedInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listManagedInstancesTransportSettings,
            settings.listManagedInstancesSettings(),
            clientContext);
    this.listPerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            listPerInstanceConfigsTransportSettings,
            settings.listPerInstanceConfigsSettings(),
            clientContext);
    this.listPerInstanceConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listPerInstanceConfigsTransportSettings,
            settings.listPerInstanceConfigsSettings(),
            clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.patchPerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            patchPerInstanceConfigsTransportSettings,
            settings.patchPerInstanceConfigsSettings(),
            clientContext);
    this.patchPerInstanceConfigsOperationCallable =
        callableFactory.createOperationCallable(
            patchPerInstanceConfigsTransportSettings,
            settings.patchPerInstanceConfigsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.recreateInstancesCallable =
        callableFactory.createUnaryCallable(
            recreateInstancesTransportSettings,
            settings.recreateInstancesSettings(),
            clientContext);
    this.recreateInstancesOperationCallable =
        callableFactory.createOperationCallable(
            recreateInstancesTransportSettings,
            settings.recreateInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resizeCallable =
        callableFactory.createUnaryCallable(
            resizeTransportSettings, settings.resizeSettings(), clientContext);
    this.resizeOperationCallable =
        callableFactory.createOperationCallable(
            resizeTransportSettings,
            settings.resizeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            setInstanceTemplateTransportSettings,
            settings.setInstanceTemplateSettings(),
            clientContext);
    this.setInstanceTemplateOperationCallable =
        callableFactory.createOperationCallable(
            setInstanceTemplateTransportSettings,
            settings.setInstanceTemplateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setTargetPoolsCallable =
        callableFactory.createUnaryCallable(
            setTargetPoolsTransportSettings, settings.setTargetPoolsSettings(), clientContext);
    this.setTargetPoolsOperationCallable =
        callableFactory.createOperationCallable(
            setTargetPoolsTransportSettings,
            settings.setTargetPoolsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            updatePerInstanceConfigsTransportSettings,
            settings.updatePerInstanceConfigsSettings(),
            clientContext);
    this.updatePerInstanceConfigsOperationCallable =
        callableFactory.createOperationCallable(
            updatePerInstanceConfigsTransportSettings,
            settings.updatePerInstanceConfigsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(abandonInstancesMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(applyUpdatesToInstancesMethodDescriptor);
    methodDescriptors.add(createInstancesMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteInstancesMethodDescriptor);
    methodDescriptors.add(deletePerInstanceConfigsMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listErrorsMethodDescriptor);
    methodDescriptors.add(listManagedInstancesMethodDescriptor);
    methodDescriptors.add(listPerInstanceConfigsMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(patchPerInstanceConfigsMethodDescriptor);
    methodDescriptors.add(recreateInstancesMethodDescriptor);
    methodDescriptors.add(resizeMethodDescriptor);
    methodDescriptors.add(setInstanceTemplateMethodDescriptor);
    methodDescriptors.add(setTargetPoolsMethodDescriptor);
    methodDescriptors.add(updatePerInstanceConfigsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    return abandonInstancesCallable;
  }

  @Override
  public OperationCallable<AbandonInstancesInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationCallable() {
    return abandonInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstanceGroupManagersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    return applyUpdatesToInstancesCallable;
  }

  @Override
  public OperationCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationCallable() {
    return applyUpdatesToInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    return createInstancesCallable;
  }

  @Override
  public OperationCallable<CreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationCallable() {
    return createInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceGroupManagerRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    return deleteInstancesCallable;
  }

  @Override
  public OperationCallable<DeleteInstancesInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationCallable() {
    return deleteInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    return deletePerInstanceConfigsCallable;
  }

  @Override
  public OperationCallable<
          DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationCallable() {
    return deletePerInstanceConfigsOperationCallable;
  }

  @Override
  public UnaryCallable<GetInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertInstanceGroupManagerRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertInstanceGroupManagerRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupManagersRequest, InstanceGroupManagerList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupManagersRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    return listErrorsCallable;
  }

  @Override
  public UnaryCallable<ListErrorsInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    return listErrorsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesCallable() {
    return listManagedInstancesCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    return listManagedInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    return listPerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest, ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    return listPerInstanceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<PatchInstanceGroupManagerRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchInstanceGroupManagerRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    return patchPerInstanceConfigsCallable;
  }

  @Override
  public OperationCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationCallable() {
    return patchPerInstanceConfigsOperationCallable;
  }

  @Override
  public UnaryCallable<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    return recreateInstancesCallable;
  }

  @Override
  public OperationCallable<RecreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationCallable() {
    return recreateInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<ResizeInstanceGroupManagerRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  @Override
  public OperationCallable<ResizeInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationCallable() {
    return resizeOperationCallable;
  }

  @Override
  public UnaryCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    return setInstanceTemplateCallable;
  }

  @Override
  public OperationCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationCallable() {
    return setInstanceTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    return setTargetPoolsCallable;
  }

  @Override
  public OperationCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationCallable() {
    return setTargetPoolsOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable() {
    return updatePerInstanceConfigsCallable;
  }

  @Override
  public OperationCallable<
          UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationCallable() {
    return updatePerInstanceConfigsOperationCallable;
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
