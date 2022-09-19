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

import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

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
import com.google.cloud.compute.v1.AbandonInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.CreateInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeletePerInstanceConfigsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.GetRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InsertRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.ListErrorsRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListManagedInstancesRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListPerInstanceConfigsRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchPerInstanceConfigsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.PatchRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RecreateInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RegionInstanceGroupManagerList;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListErrorsResponse;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListInstanceConfigsResp;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListInstancesResponse;
import com.google.cloud.compute.v1.ResizeRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetInstanceTemplateRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetTargetPoolsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest;
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
 * REST stub implementation for the RegionInstanceGroupManagers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionInstanceGroupManagersStub extends RegionInstanceGroupManagersStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/AbandonInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AbandonInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/abandonInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AbandonInstancesRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AbandonInstancesRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagersAbandonInstancesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersAbandonInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AbandonInstancesRegionInstanceGroupManagerRequest request,
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
          ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/ApplyUpdatesToInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersApplyUpdatesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersApplyUpdatesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request,
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
          CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<CreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/CreateInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/createInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstancesRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstancesRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagersCreateInstancesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersCreateInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInstancesRegionInstanceGroupManagerRequest request,
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

  private static final ApiMethodDescriptor<DeleteRegionInstanceGroupManagerRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionInstanceGroupManagerRequest>
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
                  (DeleteRegionInstanceGroupManagerRequest request, Operation response) -> {
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
          DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/DeleteInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/deleteInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstancesRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstancesRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagersDeleteInstancesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersDeleteInstancesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteInstancesRegionInstanceGroupManagerRequest request,
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
          DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/DeletePerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DeletePerInstanceConfigsRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DeletePerInstanceConfigsRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagerDeleteInstanceConfigReqResource",
                                      request
                                          .getRegionInstanceGroupManagerDeleteInstanceConfigReqResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request,
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
          GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionInstanceGroupManagerRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertRegionInstanceGroupManagerRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionInstanceGroupManagerRequest>
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
                  (InsertRegionInstanceGroupManagerRequest request, Operation response) -> {
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
          ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionInstanceGroupManagersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionInstanceGroupManagersRequest> serializer =
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
                  ProtoMessageResponseParser.<RegionInstanceGroupManagerList>newBuilder()
                      .setDefaultInstance(RegionInstanceGroupManagerList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsMethodDescriptor =
          ApiMethodDescriptor
              .<ListErrorsRegionInstanceGroupManagersRequest,
                  RegionInstanceGroupManagersListErrorsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/ListErrors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListErrorsRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listErrors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListErrorsRegionInstanceGroupManagersRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListErrorsRegionInstanceGroupManagersRequest>
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
                      .<RegionInstanceGroupManagersListErrorsResponse>newBuilder()
                      .setDefaultInstance(
                          RegionInstanceGroupManagersListErrorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListManagedInstancesRegionInstanceGroupManagersRequest,
                  RegionInstanceGroupManagersListInstancesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/ListManagedInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListManagedInstancesRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListManagedInstancesRegionInstanceGroupManagersRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListManagedInstancesRegionInstanceGroupManagersRequest>
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
                      .<RegionInstanceGroupManagersListInstancesResponse>newBuilder()
                      .setDefaultInstance(
                          RegionInstanceGroupManagersListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                  RegionInstanceGroupManagersListInstanceConfigsResp>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/ListPerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPerInstanceConfigsRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListPerInstanceConfigsRegionInstanceGroupManagersRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListPerInstanceConfigsRegionInstanceGroupManagersRequest>
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
                      .<RegionInstanceGroupManagersListInstanceConfigsResp>newBuilder()
                      .setDefaultInstance(
                          RegionInstanceGroupManagersListInstanceConfigsResp.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchRegionInstanceGroupManagerRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionInstanceGroupManagerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionInstanceGroupManagerRequest> serializer =
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
                  (PatchRegionInstanceGroupManagerRequest request, Operation response) -> {
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
          PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/PatchPerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    PatchPerInstanceConfigsRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    PatchPerInstanceConfigsRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagerPatchInstanceConfigReqResource",
                                      request
                                          .getRegionInstanceGroupManagerPatchInstanceConfigReqResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request,
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
          RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/RecreateInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RecreateInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/recreateInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecreateInstancesRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecreateInstancesRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagersRecreateRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersRecreateRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RecreateInstancesRegionInstanceGroupManagerRequest request,
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

  private static final ApiMethodDescriptor<ResizeRegionInstanceGroupManagerRequest, Operation>
      resizeMethodDescriptor =
          ApiMethodDescriptor.<ResizeRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Resize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (ResizeRegionInstanceGroupManagerRequest request, Operation response) -> {
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
          SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor
              .<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/SetInstanceTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetInstanceTemplateRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    SetInstanceTemplateRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    SetInstanceTemplateRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagersSetTemplateRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersSetTemplateRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetInstanceTemplateRegionInstanceGroupManagerRequest request,
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
          SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsMethodDescriptor =
          ApiMethodDescriptor
              .<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/SetTargetPools")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetTargetPoolsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/setTargetPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetTargetPoolsRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetTargetPoolsRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagersSetTargetPoolsRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersSetTargetPoolsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetTargetPoolsRegionInstanceGroupManagerRequest request, Operation response) -> {
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
          UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/UpdatePerInstanceConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest>
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
                                      "regionInstanceGroupManagerUpdateInstanceConfigReqResource",
                                      request
                                          .getRegionInstanceGroupManagerUpdateInstanceConfigReqResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request,
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

  private final UnaryCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable;
  private final OperationCallable<
          AbandonInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationCallable;
  private final UnaryCallable<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable;
  private final OperationCallable<
          ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationCallable;
  private final UnaryCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesCallable;
  private final OperationCallable<
          CreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationCallable;
  private final UnaryCallable<DeleteRegionInstanceGroupManagerRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable;
  private final OperationCallable<
          DeleteInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationCallable;
  private final UnaryCallable<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable;
  private final OperationCallable<
          DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationCallable;
  private final UnaryCallable<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
      getCallable;
  private final UnaryCallable<InsertRegionInstanceGroupManagerRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionInstanceGroupManagerRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<
          ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listCallable;
  private final UnaryCallable<ListRegionInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsCallable;
  private final UnaryCallable<ListErrorsRegionInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable;
  private final UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesCallable;
  private final UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable;
  private final UnaryCallable<PatchRegionInstanceGroupManagerRequest, Operation> patchCallable;
  private final OperationCallable<PatchRegionInstanceGroupManagerRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable;
  private final OperationCallable<
          PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationCallable;
  private final UnaryCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable;
  private final OperationCallable<
          RecreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationCallable;
  private final UnaryCallable<ResizeRegionInstanceGroupManagerRequest, Operation> resizeCallable;
  private final OperationCallable<ResizeRegionInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationCallable;
  private final UnaryCallable<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable;
  private final OperationCallable<
          SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationCallable;
  private final UnaryCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable;
  private final OperationCallable<
          SetTargetPoolsRegionInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationCallable;
  private final UnaryCallable<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable;
  private final OperationCallable<
          UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionInstanceGroupManagersStub create(
      RegionInstanceGroupManagersStubSettings settings) throws IOException {
    return new HttpJsonRegionInstanceGroupManagersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionInstanceGroupManagersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionInstanceGroupManagersStub(
        RegionInstanceGroupManagersStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionInstanceGroupManagersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionInstanceGroupManagersStub(
        RegionInstanceGroupManagersStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupManagersStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionInstanceGroupManagersStub(
      RegionInstanceGroupManagersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionInstanceGroupManagersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupManagersStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionInstanceGroupManagersStub(
      RegionInstanceGroupManagersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
        abandonInstancesTransportSettings =
            HttpJsonCallSettings
                .<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(abandonInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
        applyUpdatesToInstancesTransportSettings =
            HttpJsonCallSettings
                .<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(applyUpdatesToInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
        createInstancesTransportSettings =
            HttpJsonCallSettings
                .<CreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(createInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteRegionInstanceGroupManagerRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
        deleteInstancesTransportSettings =
            HttpJsonCallSettings
                .<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        deletePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePerInstanceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertRegionInstanceGroupManagerRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
                    newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListErrorsRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListErrorsResponse>
        listErrorsTransportSettings =
            HttpJsonCallSettings
                .<ListErrorsRegionInstanceGroupManagersRequest,
                    RegionInstanceGroupManagersListErrorsResponse>
                    newBuilder()
                .setMethodDescriptor(listErrorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListManagedInstancesRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListInstancesResponse>
        listManagedInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListManagedInstancesRegionInstanceGroupManagersRequest,
                    RegionInstanceGroupManagersListInstancesResponse>
                    newBuilder()
                .setMethodDescriptor(listManagedInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListInstanceConfigsResp>
        listPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                    RegionInstanceGroupManagersListInstanceConfigsResp>
                    newBuilder()
                .setMethodDescriptor(listPerInstanceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchRegionInstanceGroupManagerRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        patchPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(patchPerInstanceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
        recreateInstancesTransportSettings =
            HttpJsonCallSettings
                .<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(recreateInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ResizeRegionInstanceGroupManagerRequest, Operation>
        resizeTransportSettings =
            HttpJsonCallSettings.<ResizeRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(resizeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
        setInstanceTemplateTransportSettings =
            HttpJsonCallSettings
                .<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setInstanceTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
        setTargetPoolsTransportSettings =
            HttpJsonCallSettings
                .<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setTargetPoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        updatePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
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
  public UnaryCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    return abandonInstancesCallable;
  }

  @Override
  public OperationCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationCallable() {
    return abandonInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    return applyUpdatesToInstancesCallable;
  }

  @Override
  public OperationCallable<
          ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationCallable() {
    return applyUpdatesToInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    return createInstancesCallable;
  }

  @Override
  public OperationCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationCallable() {
    return createInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionInstanceGroupManagerRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    return deleteInstancesCallable;
  }

  @Override
  public OperationCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationCallable() {
    return deleteInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    return deletePerInstanceConfigsCallable;
  }

  @Override
  public OperationCallable<
          DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationCallable() {
    return deletePerInstanceConfigsOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionInstanceGroupManagerRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionInstanceGroupManagerRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    return listErrorsCallable;
  }

  @Override
  public UnaryCallable<ListErrorsRegionInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    return listErrorsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesCallable() {
    return listManagedInstancesCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    return listManagedInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    return listPerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    return listPerInstanceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionInstanceGroupManagerRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchRegionInstanceGroupManagerRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    return patchPerInstanceConfigsCallable;
  }

  @Override
  public OperationCallable<
          PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationCallable() {
    return patchPerInstanceConfigsOperationCallable;
  }

  @Override
  public UnaryCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    return recreateInstancesCallable;
  }

  @Override
  public OperationCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationCallable() {
    return recreateInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<ResizeRegionInstanceGroupManagerRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  @Override
  public OperationCallable<ResizeRegionInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationCallable() {
    return resizeOperationCallable;
  }

  @Override
  public UnaryCallable<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    return setInstanceTemplateCallable;
  }

  @Override
  public OperationCallable<
          SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationCallable() {
    return setInstanceTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    return setTargetPoolsCallable;
  }

  @Override
  public OperationCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationCallable() {
    return setTargetPoolsOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable() {
    return updatePerInstanceConfigsCallable;
  }

  @Override
  public OperationCallable<
          UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
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
