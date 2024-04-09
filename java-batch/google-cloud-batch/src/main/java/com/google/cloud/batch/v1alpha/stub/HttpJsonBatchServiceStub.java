/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.batch.v1alpha.stub;

import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListJobsPagedResponse;
import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListResourceAllowancesPagedResponse;
import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListTasksPagedResponse;

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
import com.google.cloud.batch.v1alpha.CreateJobRequest;
import com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest;
import com.google.cloud.batch.v1alpha.DeleteJobRequest;
import com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest;
import com.google.cloud.batch.v1alpha.GetJobRequest;
import com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest;
import com.google.cloud.batch.v1alpha.GetTaskRequest;
import com.google.cloud.batch.v1alpha.Job;
import com.google.cloud.batch.v1alpha.ListJobsRequest;
import com.google.cloud.batch.v1alpha.ListJobsResponse;
import com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest;
import com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse;
import com.google.cloud.batch.v1alpha.ListTasksRequest;
import com.google.cloud.batch.v1alpha.ListTasksResponse;
import com.google.cloud.batch.v1alpha.OperationMetadata;
import com.google.cloud.batch.v1alpha.ResourceAllowance;
import com.google.cloud.batch.v1alpha.Task;
import com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the BatchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonBatchServiceStub extends BatchServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      ApiMethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/CreateJob")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateJobRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{parent=projects/*/locations/*}/jobs",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "jobId", request.getJobId());
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("job", request.getJob(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Job>newBuilder()
                  .setDefaultInstance(Job.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      ApiMethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/GetJob")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetJobRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/jobs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Job>newBuilder()
                  .setDefaultInstance(Job.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteJobRequest, Operation> deleteJobMethodDescriptor =
      ApiMethodDescriptor.<DeleteJobRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/DeleteJob")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteJobRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/jobs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "reason", request.getReason());
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
              (DeleteJobRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          ApiMethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/ListJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/jobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListJobsResponse>newBuilder()
                      .setDefaultInstance(ListJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTaskRequest, Task> getTaskMethodDescriptor =
      ApiMethodDescriptor.<GetTaskRequest, Task>newBuilder()
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/GetTask")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTaskRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/jobs/*/taskGroups/*/tasks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Task>newBuilder()
                  .setDefaultInstance(Task.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListTasksRequest, ListTasksResponse>
      listTasksMethodDescriptor =
          ApiMethodDescriptor.<ListTasksRequest, ListTasksResponse>newBuilder()
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/ListTasks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTasksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/jobs/*/taskGroups/*}/tasks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTasksRequest> serializer =
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
                  ProtoMessageResponseParser.<ListTasksResponse>newBuilder()
                      .setDefaultInstance(ListTasksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateResourceAllowanceRequest, ResourceAllowance>
      createResourceAllowanceMethodDescriptor =
          ApiMethodDescriptor.<CreateResourceAllowanceRequest, ResourceAllowance>newBuilder()
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/CreateResourceAllowance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateResourceAllowanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/resourceAllowances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "resourceAllowanceId", request.getResourceAllowanceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "resourceAllowance", request.getResourceAllowance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceAllowance>newBuilder()
                      .setDefaultInstance(ResourceAllowance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetResourceAllowanceRequest, ResourceAllowance>
      getResourceAllowanceMethodDescriptor =
          ApiMethodDescriptor.<GetResourceAllowanceRequest, ResourceAllowance>newBuilder()
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/GetResourceAllowance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetResourceAllowanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/resourceAllowances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceAllowance>newBuilder()
                      .setDefaultInstance(ResourceAllowance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteResourceAllowanceRequest, Operation>
      deleteResourceAllowanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteResourceAllowanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/DeleteResourceAllowance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteResourceAllowanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/resourceAllowances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "reason", request.getReason());
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
                  (DeleteResourceAllowanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListResourceAllowancesRequest, ListResourceAllowancesResponse>
      listResourceAllowancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListResourceAllowancesRequest, ListResourceAllowancesResponse>newBuilder()
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/ListResourceAllowances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListResourceAllowancesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/resourceAllowances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceAllowancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceAllowancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListResourceAllowancesResponse>newBuilder()
                      .setDefaultInstance(ListResourceAllowancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateResourceAllowanceRequest, ResourceAllowance>
      updateResourceAllowanceMethodDescriptor =
          ApiMethodDescriptor.<UpdateResourceAllowanceRequest, ResourceAllowance>newBuilder()
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/UpdateResourceAllowance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateResourceAllowanceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{resourceAllowance.name=projects/*/locations/*/resourceAllowances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "resourceAllowance.name",
                                request.getResourceAllowance().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateResourceAllowanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "resourceAllowance", request.getResourceAllowance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceAllowance>newBuilder()
                      .setDefaultInstance(ResourceAllowance.getDefaultInstance())
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
                          "/v1alpha/{name=projects/*}/locations",
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
                          "/v1alpha/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<DeleteJobRequest, Operation> deleteJobCallable;
  private final OperationCallable<DeleteJobRequest, Empty, OperationMetadata>
      deleteJobOperationCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<GetTaskRequest, Task> getTaskCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable;
  private final UnaryCallable<CreateResourceAllowanceRequest, ResourceAllowance>
      createResourceAllowanceCallable;
  private final UnaryCallable<GetResourceAllowanceRequest, ResourceAllowance>
      getResourceAllowanceCallable;
  private final UnaryCallable<DeleteResourceAllowanceRequest, Operation>
      deleteResourceAllowanceCallable;
  private final OperationCallable<DeleteResourceAllowanceRequest, Empty, OperationMetadata>
      deleteResourceAllowanceOperationCallable;
  private final UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesResponse>
      listResourceAllowancesCallable;
  private final UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesPagedResponse>
      listResourceAllowancesPagedCallable;
  private final UnaryCallable<UpdateResourceAllowanceRequest, ResourceAllowance>
      updateResourceAllowanceCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBatchServiceStub create(BatchServiceStubSettings settings)
      throws IOException {
    return new HttpJsonBatchServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBatchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBatchServiceStub(
        BatchServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBatchServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBatchServiceStub(
        BatchServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBatchServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonBatchServiceStub(BatchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonBatchServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBatchServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonBatchServiceStub(
      BatchServiceStubSettings settings,
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
                        .setPost("/v1alpha/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1alpha/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        HttpJsonCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetJobRequest, Job> getJobTransportSettings =
        HttpJsonCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteJobRequest, Operation> deleteJobTransportSettings =
        HttpJsonCallSettings.<DeleteJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        HttpJsonCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetTaskRequest, Task> getTaskTransportSettings =
        HttpJsonCallSettings.<GetTaskRequest, Task>newBuilder()
            .setMethodDescriptor(getTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTasksRequest, ListTasksResponse> listTasksTransportSettings =
        HttpJsonCallSettings.<ListTasksRequest, ListTasksResponse>newBuilder()
            .setMethodDescriptor(listTasksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateResourceAllowanceRequest, ResourceAllowance>
        createResourceAllowanceTransportSettings =
            HttpJsonCallSettings.<CreateResourceAllowanceRequest, ResourceAllowance>newBuilder()
                .setMethodDescriptor(createResourceAllowanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetResourceAllowanceRequest, ResourceAllowance>
        getResourceAllowanceTransportSettings =
            HttpJsonCallSettings.<GetResourceAllowanceRequest, ResourceAllowance>newBuilder()
                .setMethodDescriptor(getResourceAllowanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteResourceAllowanceRequest, Operation>
        deleteResourceAllowanceTransportSettings =
            HttpJsonCallSettings.<DeleteResourceAllowanceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteResourceAllowanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListResourceAllowancesRequest, ListResourceAllowancesResponse>
        listResourceAllowancesTransportSettings =
            HttpJsonCallSettings
                .<ListResourceAllowancesRequest, ListResourceAllowancesResponse>newBuilder()
                .setMethodDescriptor(listResourceAllowancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateResourceAllowanceRequest, ResourceAllowance>
        updateResourceAllowanceTransportSettings =
            HttpJsonCallSettings.<UpdateResourceAllowanceRequest, ResourceAllowance>newBuilder()
                .setMethodDescriptor(updateResourceAllowanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "resource_allowance.name",
                          String.valueOf(request.getResourceAllowance().getName()));
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

    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.deleteJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteJobTransportSettings,
            settings.deleteJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.getTaskCallable =
        callableFactory.createUnaryCallable(
            getTaskTransportSettings, settings.getTaskSettings(), clientContext);
    this.listTasksCallable =
        callableFactory.createUnaryCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.listTasksPagedCallable =
        callableFactory.createPagedCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.createResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            createResourceAllowanceTransportSettings,
            settings.createResourceAllowanceSettings(),
            clientContext);
    this.getResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            getResourceAllowanceTransportSettings,
            settings.getResourceAllowanceSettings(),
            clientContext);
    this.deleteResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            deleteResourceAllowanceTransportSettings,
            settings.deleteResourceAllowanceSettings(),
            clientContext);
    this.deleteResourceAllowanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteResourceAllowanceTransportSettings,
            settings.deleteResourceAllowanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listResourceAllowancesCallable =
        callableFactory.createUnaryCallable(
            listResourceAllowancesTransportSettings,
            settings.listResourceAllowancesSettings(),
            clientContext);
    this.listResourceAllowancesPagedCallable =
        callableFactory.createPagedCallable(
            listResourceAllowancesTransportSettings,
            settings.listResourceAllowancesSettings(),
            clientContext);
    this.updateResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            updateResourceAllowanceTransportSettings,
            settings.updateResourceAllowanceSettings(),
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
    methodDescriptors.add(createJobMethodDescriptor);
    methodDescriptors.add(getJobMethodDescriptor);
    methodDescriptors.add(deleteJobMethodDescriptor);
    methodDescriptors.add(listJobsMethodDescriptor);
    methodDescriptors.add(getTaskMethodDescriptor);
    methodDescriptors.add(listTasksMethodDescriptor);
    methodDescriptors.add(createResourceAllowanceMethodDescriptor);
    methodDescriptors.add(getResourceAllowanceMethodDescriptor);
    methodDescriptors.add(deleteResourceAllowanceMethodDescriptor);
    methodDescriptors.add(listResourceAllowancesMethodDescriptor);
    methodDescriptors.add(updateResourceAllowanceMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return createJobCallable;
  }

  @Override
  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return getJobCallable;
  }

  @Override
  public UnaryCallable<DeleteJobRequest, Operation> deleteJobCallable() {
    return deleteJobCallable;
  }

  @Override
  public OperationCallable<DeleteJobRequest, Empty, OperationMetadata>
      deleteJobOperationCallable() {
    return deleteJobOperationCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return listJobsCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return listJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return getTaskCallable;
  }

  @Override
  public UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    return listTasksCallable;
  }

  @Override
  public UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    return listTasksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateResourceAllowanceRequest, ResourceAllowance>
      createResourceAllowanceCallable() {
    return createResourceAllowanceCallable;
  }

  @Override
  public UnaryCallable<GetResourceAllowanceRequest, ResourceAllowance>
      getResourceAllowanceCallable() {
    return getResourceAllowanceCallable;
  }

  @Override
  public UnaryCallable<DeleteResourceAllowanceRequest, Operation>
      deleteResourceAllowanceCallable() {
    return deleteResourceAllowanceCallable;
  }

  @Override
  public OperationCallable<DeleteResourceAllowanceRequest, Empty, OperationMetadata>
      deleteResourceAllowanceOperationCallable() {
    return deleteResourceAllowanceOperationCallable;
  }

  @Override
  public UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesResponse>
      listResourceAllowancesCallable() {
    return listResourceAllowancesCallable;
  }

  @Override
  public UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesPagedResponse>
      listResourceAllowancesPagedCallable() {
    return listResourceAllowancesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateResourceAllowanceRequest, ResourceAllowance>
      updateResourceAllowanceCallable() {
    return updateResourceAllowanceCallable;
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
