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

import static com.google.cloud.compute.v1.TargetPoolsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.AddInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.AggregatedListTargetPoolsRequest;
import com.google.cloud.compute.v1.DeleteTargetPoolRequest;
import com.google.cloud.compute.v1.GetHealthTargetPoolRequest;
import com.google.cloud.compute.v1.GetTargetPoolRequest;
import com.google.cloud.compute.v1.InsertTargetPoolRequest;
import com.google.cloud.compute.v1.ListTargetPoolsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.RemoveHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.RemoveInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.SetBackupTargetPoolRequest;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolAggregatedList;
import com.google.cloud.compute.v1.TargetPoolInstanceHealth;
import com.google.cloud.compute.v1.TargetPoolList;
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
 * REST stub implementation for the TargetPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTargetPoolsStub extends TargetPoolsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddHealthCheckTargetPoolRequest, Operation>
      addHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<AddHealthCheckTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/AddHealthCheck")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddHealthCheckTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/addHealthCheck",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddHealthCheckTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddHealthCheckTargetPoolRequest> serializer =
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
                                      "targetPoolsAddHealthCheckRequestResource",
                                      request.getTargetPoolsAddHealthCheckRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddHealthCheckTargetPoolRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<AddInstanceTargetPoolRequest, Operation>
      addInstanceMethodDescriptor =
          ApiMethodDescriptor.<AddInstanceTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/AddInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddInstanceTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/addInstance",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddInstanceTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddInstanceTargetPoolRequest> serializer =
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
                                      "targetPoolsAddInstanceRequestResource",
                                      request.getTargetPoolsAddInstanceRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddInstanceTargetPoolRequest request, Operation response) -> {
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
          AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListTargetPoolsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/targetPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListTargetPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListTargetPoolsRequest> serializer =
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
                  ProtoMessageResponseParser.<TargetPoolAggregatedList>newBuilder()
                      .setDefaultInstance(TargetPoolAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTargetPoolRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetPoolRequest> serializer =
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
                  (DeleteTargetPoolRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetTargetPoolRequest, TargetPool> getMethodDescriptor =
      ApiMethodDescriptor.<GetTargetPoolRequest, TargetPool>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.TargetPools/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTargetPoolRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTargetPoolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTargetPoolRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<TargetPool>newBuilder()
                  .setDefaultInstance(TargetPool.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthMethodDescriptor =
          ApiMethodDescriptor.<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/GetHealth")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHealthTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/getHealth",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHealthTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHealthTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceReferenceResource",
                                      request.getInstanceReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetPoolInstanceHealth>newBuilder()
                      .setDefaultInstance(TargetPoolInstanceHealth.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertTargetPoolRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertTargetPoolRequest> serializer =
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
                                      "targetPoolResource", request.getTargetPoolResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertTargetPoolRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListTargetPoolsRequest, TargetPoolList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetPoolsRequest, TargetPoolList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetPoolsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetPoolsRequest> serializer =
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
                  ProtoMessageResponseParser.<TargetPoolList>newBuilder()
                      .setDefaultInstance(TargetPoolList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<RemoveHealthCheckTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/RemoveHealthCheck")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveHealthCheckTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/removeHealthCheck",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveHealthCheckTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveHealthCheckTargetPoolRequest> serializer =
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
                                      "targetPoolsRemoveHealthCheckRequestResource",
                                      request.getTargetPoolsRemoveHealthCheckRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveHealthCheckTargetPoolRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<RemoveInstanceTargetPoolRequest, Operation>
      removeInstanceMethodDescriptor =
          ApiMethodDescriptor.<RemoveInstanceTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/RemoveInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveInstanceTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/removeInstance",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveInstanceTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveInstanceTargetPoolRequest> serializer =
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
                                      "targetPoolsRemoveInstanceRequestResource",
                                      request.getTargetPoolsRemoveInstanceRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveInstanceTargetPoolRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetBackupTargetPoolRequest, Operation>
      setBackupMethodDescriptor =
          ApiMethodDescriptor.<SetBackupTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/SetBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetBackupTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/setBackup",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetBackupTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetBackupTargetPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFailoverRatio()) {
                              serializer.putQueryParam(
                                  fields, "failoverRatio", request.getFailoverRatio());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "targetReferenceResource",
                                      request.getTargetReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetBackupTargetPoolRequest request, Operation response) -> {
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

  private final UnaryCallable<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckCallable;
  private final OperationCallable<AddHealthCheckTargetPoolRequest, Operation, Operation>
      addHealthCheckOperationCallable;
  private final UnaryCallable<AddInstanceTargetPoolRequest, Operation> addInstanceCallable;
  private final OperationCallable<AddInstanceTargetPoolRequest, Operation, Operation>
      addInstanceOperationCallable;
  private final UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListTargetPoolsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteTargetPoolRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteTargetPoolRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetTargetPoolRequest, TargetPool> getCallable;
  private final UnaryCallable<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthCallable;
  private final UnaryCallable<InsertTargetPoolRequest, Operation> insertCallable;
  private final OperationCallable<InsertTargetPoolRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListTargetPoolsRequest, TargetPoolList> listCallable;
  private final UnaryCallable<ListTargetPoolsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckCallable;
  private final OperationCallable<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
      removeHealthCheckOperationCallable;
  private final UnaryCallable<RemoveInstanceTargetPoolRequest, Operation> removeInstanceCallable;
  private final OperationCallable<RemoveInstanceTargetPoolRequest, Operation, Operation>
      removeInstanceOperationCallable;
  private final UnaryCallable<SetBackupTargetPoolRequest, Operation> setBackupCallable;
  private final OperationCallable<SetBackupTargetPoolRequest, Operation, Operation>
      setBackupOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetPoolsStub create(TargetPoolsStubSettings settings)
      throws IOException {
    return new HttpJsonTargetPoolsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetPoolsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetPoolsStub(TargetPoolsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetPoolsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetPoolsStub(
        TargetPoolsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetPoolsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTargetPoolsStub(TargetPoolsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTargetPoolsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetPoolsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTargetPoolsStub(
      TargetPoolsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddHealthCheckTargetPoolRequest, Operation>
        addHealthCheckTransportSettings =
            HttpJsonCallSettings.<AddHealthCheckTargetPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(addHealthCheckMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddInstanceTargetPoolRequest, Operation> addInstanceTransportSettings =
        HttpJsonCallSettings.<AddInstanceTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(addInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteTargetPoolRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTargetPoolRequest, TargetPool> getTransportSettings =
        HttpJsonCallSettings.<GetTargetPoolRequest, TargetPool>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
        getHealthTransportSettings =
            HttpJsonCallSettings.<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>newBuilder()
                .setMethodDescriptor(getHealthMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertTargetPoolRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTargetPoolsRequest, TargetPoolList> listTransportSettings =
        HttpJsonCallSettings.<ListTargetPoolsRequest, TargetPoolList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemoveHealthCheckTargetPoolRequest, Operation>
        removeHealthCheckTransportSettings =
            HttpJsonCallSettings.<RemoveHealthCheckTargetPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(removeHealthCheckMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveInstanceTargetPoolRequest, Operation>
        removeInstanceTransportSettings =
            HttpJsonCallSettings.<RemoveInstanceTargetPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(removeInstanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetBackupTargetPoolRequest, Operation> setBackupTransportSettings =
        HttpJsonCallSettings.<SetBackupTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(setBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.addHealthCheckCallable =
        callableFactory.createUnaryCallable(
            addHealthCheckTransportSettings, settings.addHealthCheckSettings(), clientContext);
    this.addHealthCheckOperationCallable =
        callableFactory.createOperationCallable(
            addHealthCheckTransportSettings,
            settings.addHealthCheckOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addInstanceCallable =
        callableFactory.createUnaryCallable(
            addInstanceTransportSettings, settings.addInstanceSettings(), clientContext);
    this.addInstanceOperationCallable =
        callableFactory.createOperationCallable(
            addInstanceTransportSettings,
            settings.addInstanceOperationSettings(),
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
    this.getHealthCallable =
        callableFactory.createUnaryCallable(
            getHealthTransportSettings, settings.getHealthSettings(), clientContext);
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
    this.removeHealthCheckCallable =
        callableFactory.createUnaryCallable(
            removeHealthCheckTransportSettings,
            settings.removeHealthCheckSettings(),
            clientContext);
    this.removeHealthCheckOperationCallable =
        callableFactory.createOperationCallable(
            removeHealthCheckTransportSettings,
            settings.removeHealthCheckOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeInstanceCallable =
        callableFactory.createUnaryCallable(
            removeInstanceTransportSettings, settings.removeInstanceSettings(), clientContext);
    this.removeInstanceOperationCallable =
        callableFactory.createOperationCallable(
            removeInstanceTransportSettings,
            settings.removeInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setBackupCallable =
        callableFactory.createUnaryCallable(
            setBackupTransportSettings, settings.setBackupSettings(), clientContext);
    this.setBackupOperationCallable =
        callableFactory.createOperationCallable(
            setBackupTransportSettings,
            settings.setBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addHealthCheckMethodDescriptor);
    methodDescriptors.add(addInstanceMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getHealthMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(removeHealthCheckMethodDescriptor);
    methodDescriptors.add(removeInstanceMethodDescriptor);
    methodDescriptors.add(setBackupMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckCallable() {
    return addHealthCheckCallable;
  }

  @Override
  public OperationCallable<AddHealthCheckTargetPoolRequest, Operation, Operation>
      addHealthCheckOperationCallable() {
    return addHealthCheckOperationCallable;
  }

  @Override
  public UnaryCallable<AddInstanceTargetPoolRequest, Operation> addInstanceCallable() {
    return addInstanceCallable;
  }

  @Override
  public OperationCallable<AddInstanceTargetPoolRequest, Operation, Operation>
      addInstanceOperationCallable() {
    return addInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListTargetPoolsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetPoolRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteTargetPoolRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetTargetPoolRequest, TargetPool> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetHealthTargetPoolRequest, TargetPoolInstanceHealth> getHealthCallable() {
    return getHealthCallable;
  }

  @Override
  public UnaryCallable<InsertTargetPoolRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertTargetPoolRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListTargetPoolsRequest, TargetPoolList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListTargetPoolsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<RemoveHealthCheckTargetPoolRequest, Operation> removeHealthCheckCallable() {
    return removeHealthCheckCallable;
  }

  @Override
  public OperationCallable<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
      removeHealthCheckOperationCallable() {
    return removeHealthCheckOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveInstanceTargetPoolRequest, Operation> removeInstanceCallable() {
    return removeInstanceCallable;
  }

  @Override
  public OperationCallable<RemoveInstanceTargetPoolRequest, Operation, Operation>
      removeInstanceOperationCallable() {
    return removeInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<SetBackupTargetPoolRequest, Operation> setBackupCallable() {
    return setBackupCallable;
  }

  @Override
  public OperationCallable<SetBackupTargetPoolRequest, Operation, Operation>
      setBackupOperationCallable() {
    return setBackupOperationCallable;
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
