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

package google.maps.fleetengine.delivery.v1.stub;

import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListDeliveryVehiclesPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListTasksPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.protobuf.TypeRegistry;
import google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest;
import google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse;
import google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.CreateTaskRequest;
import google.maps.fleetengine.delivery.v1.DeliveryVehicle;
import google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.GetTaskRequest;
import google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest;
import google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest;
import google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse;
import google.maps.fleetengine.delivery.v1.ListTasksRequest;
import google.maps.fleetengine.delivery.v1.ListTasksResponse;
import google.maps.fleetengine.delivery.v1.Task;
import google.maps.fleetengine.delivery.v1.TaskTrackingInfo;
import google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.UpdateTaskRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the DeliveryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDeliveryServiceStub extends DeliveryServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleMethodDescriptor =
          ApiMethodDescriptor.<CreateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
              .setFullMethodName(
                  "maps.fleetengine.delivery.v1.DeliveryService/CreateDeliveryVehicle")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeliveryVehicleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=providers/*}/deliveryVehicles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeliveryVehicleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeliveryVehicleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deliveryVehicleId", request.getDeliveryVehicleId());
                            serializer.putQueryParam(fields, "header", request.getHeader());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deliveryVehicle", request.getDeliveryVehicle(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeliveryVehicle>newBuilder()
                      .setDefaultInstance(DeliveryVehicle.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleMethodDescriptor =
          ApiMethodDescriptor.<GetDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/GetDeliveryVehicle")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeliveryVehicleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=providers/*/deliveryVehicles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeliveryVehicleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeliveryVehicleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "header", request.getHeader());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeliveryVehicle>newBuilder()
                      .setDefaultInstance(DeliveryVehicle.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
              .setFullMethodName(
                  "maps.fleetengine.delivery.v1.DeliveryService/UpdateDeliveryVehicle")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeliveryVehicleRequest>newBuilder()
                      .setPath(
                          "/v1/{deliveryVehicle.name=providers/*/deliveryVehicles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeliveryVehicleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "deliveryVehicle.name",
                                request.getDeliveryVehicle().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeliveryVehicleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "header", request.getHeader());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deliveryVehicle", request.getDeliveryVehicle(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeliveryVehicle>newBuilder()
                      .setDefaultInstance(DeliveryVehicle.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateTasksRequest, BatchCreateTasksResponse>newBuilder()
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/BatchCreateTasks")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateTasksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=providers/*}/tasks:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateTasksResponse>newBuilder()
                      .setDefaultInstance(BatchCreateTasksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTaskRequest, Task> createTaskMethodDescriptor =
      ApiMethodDescriptor.<CreateTaskRequest, Task>newBuilder()
          .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/CreateTask")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateTaskRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=providers/*}/tasks",
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
                        serializer.putQueryParam(fields, "header", request.getHeader());
                        serializer.putQueryParam(fields, "taskId", request.getTaskId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("task", request.getTask(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Task>newBuilder()
                  .setDefaultInstance(Task.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetTaskRequest, Task> getTaskMethodDescriptor =
      ApiMethodDescriptor.<GetTaskRequest, Task>newBuilder()
          .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/GetTask")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTaskRequest>newBuilder()
                  .setPath(
                      "/v1/{name=providers/*/tasks/*}",
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
                        serializer.putQueryParam(fields, "header", request.getHeader());
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

  private static final ApiMethodDescriptor<UpdateTaskRequest, Task> updateTaskMethodDescriptor =
      ApiMethodDescriptor.<UpdateTaskRequest, Task>newBuilder()
          .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/UpdateTask")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateTaskRequest>newBuilder()
                  .setPath(
                      "/v1/{task.name=providers/*/tasks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "task.name", request.getTask().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "header", request.getHeader());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("task", request.getTask(), true))
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
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/ListTasks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTasksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=providers/*}/tasks",
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
                            serializer.putQueryParam(fields, "header", request.getHeader());
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

  private static final ApiMethodDescriptor<GetTaskTrackingInfoRequest, TaskTrackingInfo>
      getTaskTrackingInfoMethodDescriptor =
          ApiMethodDescriptor.<GetTaskTrackingInfoRequest, TaskTrackingInfo>newBuilder()
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/GetTaskTrackingInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTaskTrackingInfoRequest>newBuilder()
                      .setPath(
                          "/v1/{name=providers/*/taskTrackingInfo/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTaskTrackingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTaskTrackingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "header", request.getHeader());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TaskTrackingInfo>newBuilder()
                      .setDefaultInstance(TaskTrackingInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
      listDeliveryVehiclesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>newBuilder()
              .setFullMethodName(
                  "maps.fleetengine.delivery.v1.DeliveryService/ListDeliveryVehicles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeliveryVehiclesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=providers/*}/deliveryVehicles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeliveryVehiclesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeliveryVehiclesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "header", request.getHeader());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "viewport", request.getViewport());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeliveryVehiclesResponse>newBuilder()
                      .setDefaultInstance(ListDeliveryVehiclesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleCallable;
  private final UnaryCallable<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleCallable;
  private final UnaryCallable<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleCallable;
  private final UnaryCallable<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksCallable;
  private final UnaryCallable<CreateTaskRequest, Task> createTaskCallable;
  private final UnaryCallable<GetTaskRequest, Task> getTaskCallable;
  private final UnaryCallable<UpdateTaskRequest, Task> updateTaskCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable;
  private final UnaryCallable<GetTaskTrackingInfoRequest, TaskTrackingInfo>
      getTaskTrackingInfoCallable;
  private final UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
      listDeliveryVehiclesCallable;
  private final UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesPagedResponse>
      listDeliveryVehiclesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_DELIVERY_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_DELIVERY_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_DELIVERY_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate BATCH_CREATE_TASKS_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate CREATE_TASK_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_TASK_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_TASK_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate LIST_TASKS_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_TASK_TRACKING_INFO_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate LIST_DELIVERY_VEHICLES_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");

  public static final HttpJsonDeliveryServiceStub create(DeliveryServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDeliveryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeliveryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeliveryServiceStub(
        DeliveryServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDeliveryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeliveryServiceStub(
        DeliveryServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeliveryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeliveryServiceStub(
      DeliveryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDeliveryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeliveryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeliveryServiceStub(
      DeliveryServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDeliveryVehicleRequest, DeliveryVehicle>
        createDeliveryVehicleTransportSettings =
            HttpJsonCallSettings.<CreateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
                .setMethodDescriptor(createDeliveryVehicleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(),
                          "provider_id",
                          CREATE_DELIVERY_VEHICLE_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDeliveryVehicleRequest, DeliveryVehicle>
        getDeliveryVehicleTransportSettings =
            HttpJsonCallSettings.<GetDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
                .setMethodDescriptor(getDeliveryVehicleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(), "provider_id", GET_DELIVERY_VEHICLE_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDeliveryVehicleRequest, DeliveryVehicle>
        updateDeliveryVehicleTransportSettings =
            HttpJsonCallSettings.<UpdateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
                .setMethodDescriptor(updateDeliveryVehicleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      if (request.getDeliveryVehicle() != null) {
                        builder.add(
                            request.getDeliveryVehicle().getName(),
                            "provider_id",
                            UPDATE_DELIVERY_VEHICLE_0_PATH_TEMPLATE);
                      }
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchCreateTasksRequest, BatchCreateTasksResponse>
        batchCreateTasksTransportSettings =
            HttpJsonCallSettings.<BatchCreateTasksRequest, BatchCreateTasksResponse>newBuilder()
                .setMethodDescriptor(batchCreateTasksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "provider_id", BATCH_CREATE_TASKS_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateTaskRequest, Task> createTaskTransportSettings =
        HttpJsonCallSettings.<CreateTaskRequest, Task>newBuilder()
            .setMethodDescriptor(createTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "provider_id", CREATE_TASK_0_PATH_TEMPLATE);
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
                  builder.add(request.getName(), "provider_id", GET_TASK_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTaskRequest, Task> updateTaskTransportSettings =
        HttpJsonCallSettings.<UpdateTaskRequest, Task>newBuilder()
            .setMethodDescriptor(updateTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getTask() != null) {
                    builder.add(
                        request.getTask().getName(), "provider_id", UPDATE_TASK_0_PATH_TEMPLATE);
                  }
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
                  builder.add(request.getParent(), "provider_id", LIST_TASKS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetTaskTrackingInfoRequest, TaskTrackingInfo>
        getTaskTrackingInfoTransportSettings =
            HttpJsonCallSettings.<GetTaskTrackingInfoRequest, TaskTrackingInfo>newBuilder()
                .setMethodDescriptor(getTaskTrackingInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(), "provider_id", GET_TASK_TRACKING_INFO_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
        listDeliveryVehiclesTransportSettings =
            HttpJsonCallSettings
                .<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>newBuilder()
                .setMethodDescriptor(listDeliveryVehiclesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(),
                          "provider_id",
                          LIST_DELIVERY_VEHICLES_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();

    this.createDeliveryVehicleCallable =
        callableFactory.createUnaryCallable(
            createDeliveryVehicleTransportSettings,
            settings.createDeliveryVehicleSettings(),
            clientContext);
    this.getDeliveryVehicleCallable =
        callableFactory.createUnaryCallable(
            getDeliveryVehicleTransportSettings,
            settings.getDeliveryVehicleSettings(),
            clientContext);
    this.updateDeliveryVehicleCallable =
        callableFactory.createUnaryCallable(
            updateDeliveryVehicleTransportSettings,
            settings.updateDeliveryVehicleSettings(),
            clientContext);
    this.batchCreateTasksCallable =
        callableFactory.createUnaryCallable(
            batchCreateTasksTransportSettings, settings.batchCreateTasksSettings(), clientContext);
    this.createTaskCallable =
        callableFactory.createUnaryCallable(
            createTaskTransportSettings, settings.createTaskSettings(), clientContext);
    this.getTaskCallable =
        callableFactory.createUnaryCallable(
            getTaskTransportSettings, settings.getTaskSettings(), clientContext);
    this.updateTaskCallable =
        callableFactory.createUnaryCallable(
            updateTaskTransportSettings, settings.updateTaskSettings(), clientContext);
    this.listTasksCallable =
        callableFactory.createUnaryCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.listTasksPagedCallable =
        callableFactory.createPagedCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.getTaskTrackingInfoCallable =
        callableFactory.createUnaryCallable(
            getTaskTrackingInfoTransportSettings,
            settings.getTaskTrackingInfoSettings(),
            clientContext);
    this.listDeliveryVehiclesCallable =
        callableFactory.createUnaryCallable(
            listDeliveryVehiclesTransportSettings,
            settings.listDeliveryVehiclesSettings(),
            clientContext);
    this.listDeliveryVehiclesPagedCallable =
        callableFactory.createPagedCallable(
            listDeliveryVehiclesTransportSettings,
            settings.listDeliveryVehiclesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDeliveryVehicleMethodDescriptor);
    methodDescriptors.add(getDeliveryVehicleMethodDescriptor);
    methodDescriptors.add(updateDeliveryVehicleMethodDescriptor);
    methodDescriptors.add(batchCreateTasksMethodDescriptor);
    methodDescriptors.add(createTaskMethodDescriptor);
    methodDescriptors.add(getTaskMethodDescriptor);
    methodDescriptors.add(updateTaskMethodDescriptor);
    methodDescriptors.add(listTasksMethodDescriptor);
    methodDescriptors.add(getTaskTrackingInfoMethodDescriptor);
    methodDescriptors.add(listDeliveryVehiclesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleCallable() {
    return createDeliveryVehicleCallable;
  }

  @Override
  public UnaryCallable<GetDeliveryVehicleRequest, DeliveryVehicle> getDeliveryVehicleCallable() {
    return getDeliveryVehicleCallable;
  }

  @Override
  public UnaryCallable<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleCallable() {
    return updateDeliveryVehicleCallable;
  }

  @Override
  public UnaryCallable<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksCallable() {
    return batchCreateTasksCallable;
  }

  @Override
  public UnaryCallable<CreateTaskRequest, Task> createTaskCallable() {
    return createTaskCallable;
  }

  @Override
  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return getTaskCallable;
  }

  @Override
  public UnaryCallable<UpdateTaskRequest, Task> updateTaskCallable() {
    return updateTaskCallable;
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
  public UnaryCallable<GetTaskTrackingInfoRequest, TaskTrackingInfo> getTaskTrackingInfoCallable() {
    return getTaskTrackingInfoCallable;
  }

  @Override
  public UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
      listDeliveryVehiclesCallable() {
    return listDeliveryVehiclesCallable;
  }

  @Override
  public UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesPagedResponse>
      listDeliveryVehiclesPagedCallable() {
    return listDeliveryVehiclesPagedCallable;
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
