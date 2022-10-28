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

package com.google.cloud.tasks.v2.stub;

import static com.google.cloud.tasks.v2.CloudTasksClient.ListQueuesPagedResponse;
import static com.google.cloud.tasks.v2.CloudTasksClient.ListTasksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.tasks.v2.CreateQueueRequest;
import com.google.cloud.tasks.v2.CreateTaskRequest;
import com.google.cloud.tasks.v2.DeleteQueueRequest;
import com.google.cloud.tasks.v2.DeleteTaskRequest;
import com.google.cloud.tasks.v2.GetQueueRequest;
import com.google.cloud.tasks.v2.GetTaskRequest;
import com.google.cloud.tasks.v2.ListQueuesRequest;
import com.google.cloud.tasks.v2.ListQueuesResponse;
import com.google.cloud.tasks.v2.ListTasksRequest;
import com.google.cloud.tasks.v2.ListTasksResponse;
import com.google.cloud.tasks.v2.PauseQueueRequest;
import com.google.cloud.tasks.v2.PurgeQueueRequest;
import com.google.cloud.tasks.v2.Queue;
import com.google.cloud.tasks.v2.ResumeQueueRequest;
import com.google.cloud.tasks.v2.RunTaskRequest;
import com.google.cloud.tasks.v2.Task;
import com.google.cloud.tasks.v2.UpdateQueueRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the CloudTasks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudTasksStub extends CloudTasksStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListQueuesRequest, ListQueuesResponse>
      listQueuesMethodDescriptor =
          ApiMethodDescriptor.<ListQueuesRequest, ListQueuesResponse>newBuilder()
              .setFullMethodName("google.cloud.tasks.v2.CloudTasks/ListQueues")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListQueuesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/queues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListQueuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListQueuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListQueuesResponse>newBuilder()
                      .setDefaultInstance(ListQueuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetQueueRequest, Queue> getQueueMethodDescriptor =
      ApiMethodDescriptor.<GetQueueRequest, Queue>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/GetQueue")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetQueueRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Queue>newBuilder()
                  .setDefaultInstance(Queue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateQueueRequest, Queue> createQueueMethodDescriptor =
      ApiMethodDescriptor.<CreateQueueRequest, Queue>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/CreateQueue")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateQueueRequest>newBuilder()
                  .setPath(
                      "/v2/{parent=projects/*/locations/*}/queues",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("queue", request.getQueue(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Queue>newBuilder()
                  .setDefaultInstance(Queue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateQueueRequest, Queue> updateQueueMethodDescriptor =
      ApiMethodDescriptor.<UpdateQueueRequest, Queue>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/UpdateQueue")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateQueueRequest>newBuilder()
                  .setPath(
                      "/v2/{queue.name=projects/*/locations/*/queues/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "queue.name", request.getQueue().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("queue", request.getQueue(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Queue>newBuilder()
                  .setDefaultInstance(Queue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteQueueRequest, Empty> deleteQueueMethodDescriptor =
      ApiMethodDescriptor.<DeleteQueueRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/DeleteQueue")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteQueueRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteQueueRequest> serializer =
                            ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<PurgeQueueRequest, Queue> purgeQueueMethodDescriptor =
      ApiMethodDescriptor.<PurgeQueueRequest, Queue>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/PurgeQueue")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PurgeQueueRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*}:purge",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PurgeQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PurgeQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Queue>newBuilder()
                  .setDefaultInstance(Queue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<PauseQueueRequest, Queue> pauseQueueMethodDescriptor =
      ApiMethodDescriptor.<PauseQueueRequest, Queue>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/PauseQueue")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PauseQueueRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*}:pause",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PauseQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PauseQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Queue>newBuilder()
                  .setDefaultInstance(Queue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ResumeQueueRequest, Queue> resumeQueueMethodDescriptor =
      ApiMethodDescriptor.<ResumeQueueRequest, Queue>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/ResumeQueue")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ResumeQueueRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*}:resume",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ResumeQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ResumeQueueRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Queue>newBuilder()
                  .setDefaultInstance(Queue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.tasks.v2.CloudTasks/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=projects/*/locations/*/queues/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.tasks.v2.CloudTasks/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=projects/*/locations/*/queues/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.tasks.v2.CloudTasks/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=projects/*/locations/*/queues/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTasksRequest, ListTasksResponse>
      listTasksMethodDescriptor =
          ApiMethodDescriptor.<ListTasksRequest, ListTasksResponse>newBuilder()
              .setFullMethodName("google.cloud.tasks.v2.CloudTasks/ListTasks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTasksRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/queues/*}/tasks",
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
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "responseView", request.getResponseViewValue());
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

  private static final ApiMethodDescriptor<GetTaskRequest, Task> getTaskMethodDescriptor =
      ApiMethodDescriptor.<GetTaskRequest, Task>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/GetTask")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTaskRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*/tasks/*}",
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
                        serializer.putQueryParam(
                            fields, "responseView", request.getResponseViewValue());
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

  private static final ApiMethodDescriptor<CreateTaskRequest, Task> createTaskMethodDescriptor =
      ApiMethodDescriptor.<CreateTaskRequest, Task>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/CreateTask")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateTaskRequest>newBuilder()
                  .setPath(
                      "/v2/{parent=projects/*/locations/*/queues/*}/tasks",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearParent().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Task>newBuilder()
                  .setDefaultInstance(Task.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteTaskRequest, Empty> deleteTaskMethodDescriptor =
      ApiMethodDescriptor.<DeleteTaskRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/DeleteTask")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteTaskRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*/tasks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteTaskRequest> serializer =
                            ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<RunTaskRequest, Task> runTaskMethodDescriptor =
      ApiMethodDescriptor.<RunTaskRequest, Task>newBuilder()
          .setFullMethodName("google.cloud.tasks.v2.CloudTasks/RunTask")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<RunTaskRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/queues/*/tasks/*}:run",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<RunTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<RunTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Task>newBuilder()
                  .setDefaultInstance(Task.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<ListQueuesRequest, ListQueuesResponse> listQueuesCallable;
  private final UnaryCallable<ListQueuesRequest, ListQueuesPagedResponse> listQueuesPagedCallable;
  private final UnaryCallable<GetQueueRequest, Queue> getQueueCallable;
  private final UnaryCallable<CreateQueueRequest, Queue> createQueueCallable;
  private final UnaryCallable<UpdateQueueRequest, Queue> updateQueueCallable;
  private final UnaryCallable<DeleteQueueRequest, Empty> deleteQueueCallable;
  private final UnaryCallable<PurgeQueueRequest, Queue> purgeQueueCallable;
  private final UnaryCallable<PauseQueueRequest, Queue> pauseQueueCallable;
  private final UnaryCallable<ResumeQueueRequest, Queue> resumeQueueCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable;
  private final UnaryCallable<GetTaskRequest, Task> getTaskCallable;
  private final UnaryCallable<CreateTaskRequest, Task> createTaskCallable;
  private final UnaryCallable<DeleteTaskRequest, Empty> deleteTaskCallable;
  private final UnaryCallable<RunTaskRequest, Task> runTaskCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudTasksStub create(CloudTasksStubSettings settings)
      throws IOException {
    return new HttpJsonCloudTasksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudTasksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudTasksStub(
        CloudTasksStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudTasksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudTasksStub(
        CloudTasksStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudTasksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudTasksStub(CloudTasksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudTasksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudTasksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudTasksStub(
      CloudTasksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListQueuesRequest, ListQueuesResponse> listQueuesTransportSettings =
        HttpJsonCallSettings.<ListQueuesRequest, ListQueuesResponse>newBuilder()
            .setMethodDescriptor(listQueuesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetQueueRequest, Queue> getQueueTransportSettings =
        HttpJsonCallSettings.<GetQueueRequest, Queue>newBuilder()
            .setMethodDescriptor(getQueueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateQueueRequest, Queue> createQueueTransportSettings =
        HttpJsonCallSettings.<CreateQueueRequest, Queue>newBuilder()
            .setMethodDescriptor(createQueueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateQueueRequest, Queue> updateQueueTransportSettings =
        HttpJsonCallSettings.<UpdateQueueRequest, Queue>newBuilder()
            .setMethodDescriptor(updateQueueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteQueueRequest, Empty> deleteQueueTransportSettings =
        HttpJsonCallSettings.<DeleteQueueRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteQueueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PurgeQueueRequest, Queue> purgeQueueTransportSettings =
        HttpJsonCallSettings.<PurgeQueueRequest, Queue>newBuilder()
            .setMethodDescriptor(purgeQueueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PauseQueueRequest, Queue> pauseQueueTransportSettings =
        HttpJsonCallSettings.<PauseQueueRequest, Queue>newBuilder()
            .setMethodDescriptor(pauseQueueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ResumeQueueRequest, Queue> resumeQueueTransportSettings =
        HttpJsonCallSettings.<ResumeQueueRequest, Queue>newBuilder()
            .setMethodDescriptor(resumeQueueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListTasksRequest, ListTasksResponse> listTasksTransportSettings =
        HttpJsonCallSettings.<ListTasksRequest, ListTasksResponse>newBuilder()
            .setMethodDescriptor(listTasksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTaskRequest, Task> getTaskTransportSettings =
        HttpJsonCallSettings.<GetTaskRequest, Task>newBuilder()
            .setMethodDescriptor(getTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTaskRequest, Task> createTaskTransportSettings =
        HttpJsonCallSettings.<CreateTaskRequest, Task>newBuilder()
            .setMethodDescriptor(createTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTaskRequest, Empty> deleteTaskTransportSettings =
        HttpJsonCallSettings.<DeleteTaskRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RunTaskRequest, Task> runTaskTransportSettings =
        HttpJsonCallSettings.<RunTaskRequest, Task>newBuilder()
            .setMethodDescriptor(runTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listQueuesCallable =
        callableFactory.createUnaryCallable(
            listQueuesTransportSettings, settings.listQueuesSettings(), clientContext);
    this.listQueuesPagedCallable =
        callableFactory.createPagedCallable(
            listQueuesTransportSettings, settings.listQueuesSettings(), clientContext);
    this.getQueueCallable =
        callableFactory.createUnaryCallable(
            getQueueTransportSettings, settings.getQueueSettings(), clientContext);
    this.createQueueCallable =
        callableFactory.createUnaryCallable(
            createQueueTransportSettings, settings.createQueueSettings(), clientContext);
    this.updateQueueCallable =
        callableFactory.createUnaryCallable(
            updateQueueTransportSettings, settings.updateQueueSettings(), clientContext);
    this.deleteQueueCallable =
        callableFactory.createUnaryCallable(
            deleteQueueTransportSettings, settings.deleteQueueSettings(), clientContext);
    this.purgeQueueCallable =
        callableFactory.createUnaryCallable(
            purgeQueueTransportSettings, settings.purgeQueueSettings(), clientContext);
    this.pauseQueueCallable =
        callableFactory.createUnaryCallable(
            pauseQueueTransportSettings, settings.pauseQueueSettings(), clientContext);
    this.resumeQueueCallable =
        callableFactory.createUnaryCallable(
            resumeQueueTransportSettings, settings.resumeQueueSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.listTasksCallable =
        callableFactory.createUnaryCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.listTasksPagedCallable =
        callableFactory.createPagedCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.getTaskCallable =
        callableFactory.createUnaryCallable(
            getTaskTransportSettings, settings.getTaskSettings(), clientContext);
    this.createTaskCallable =
        callableFactory.createUnaryCallable(
            createTaskTransportSettings, settings.createTaskSettings(), clientContext);
    this.deleteTaskCallable =
        callableFactory.createUnaryCallable(
            deleteTaskTransportSettings, settings.deleteTaskSettings(), clientContext);
    this.runTaskCallable =
        callableFactory.createUnaryCallable(
            runTaskTransportSettings, settings.runTaskSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listQueuesMethodDescriptor);
    methodDescriptors.add(getQueueMethodDescriptor);
    methodDescriptors.add(createQueueMethodDescriptor);
    methodDescriptors.add(updateQueueMethodDescriptor);
    methodDescriptors.add(deleteQueueMethodDescriptor);
    methodDescriptors.add(purgeQueueMethodDescriptor);
    methodDescriptors.add(pauseQueueMethodDescriptor);
    methodDescriptors.add(resumeQueueMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(listTasksMethodDescriptor);
    methodDescriptors.add(getTaskMethodDescriptor);
    methodDescriptors.add(createTaskMethodDescriptor);
    methodDescriptors.add(deleteTaskMethodDescriptor);
    methodDescriptors.add(runTaskMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListQueuesRequest, ListQueuesResponse> listQueuesCallable() {
    return listQueuesCallable;
  }

  @Override
  public UnaryCallable<ListQueuesRequest, ListQueuesPagedResponse> listQueuesPagedCallable() {
    return listQueuesPagedCallable;
  }

  @Override
  public UnaryCallable<GetQueueRequest, Queue> getQueueCallable() {
    return getQueueCallable;
  }

  @Override
  public UnaryCallable<CreateQueueRequest, Queue> createQueueCallable() {
    return createQueueCallable;
  }

  @Override
  public UnaryCallable<UpdateQueueRequest, Queue> updateQueueCallable() {
    return updateQueueCallable;
  }

  @Override
  public UnaryCallable<DeleteQueueRequest, Empty> deleteQueueCallable() {
    return deleteQueueCallable;
  }

  @Override
  public UnaryCallable<PurgeQueueRequest, Queue> purgeQueueCallable() {
    return purgeQueueCallable;
  }

  @Override
  public UnaryCallable<PauseQueueRequest, Queue> pauseQueueCallable() {
    return pauseQueueCallable;
  }

  @Override
  public UnaryCallable<ResumeQueueRequest, Queue> resumeQueueCallable() {
    return resumeQueueCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return getTaskCallable;
  }

  @Override
  public UnaryCallable<CreateTaskRequest, Task> createTaskCallable() {
    return createTaskCallable;
  }

  @Override
  public UnaryCallable<DeleteTaskRequest, Empty> deleteTaskCallable() {
    return deleteTaskCallable;
  }

  @Override
  public UnaryCallable<RunTaskRequest, Task> runTaskCallable() {
    return runTaskCallable;
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
