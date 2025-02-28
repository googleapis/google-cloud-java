/*
 * Copyright 2025 Google LLC
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

package com.google.maps.fleetengine.delivery.v1.stub;

import static com.google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListDeliveryVehiclesPagedResponse;
import static com.google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListTasksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest;
import com.google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse;
import com.google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest;
import com.google.maps.fleetengine.delivery.v1.CreateTaskRequest;
import com.google.maps.fleetengine.delivery.v1.DeleteDeliveryVehicleRequest;
import com.google.maps.fleetengine.delivery.v1.DeleteTaskRequest;
import com.google.maps.fleetengine.delivery.v1.DeliveryVehicle;
import com.google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest;
import com.google.maps.fleetengine.delivery.v1.GetTaskRequest;
import com.google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest;
import com.google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest;
import com.google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse;
import com.google.maps.fleetengine.delivery.v1.ListTasksRequest;
import com.google.maps.fleetengine.delivery.v1.ListTasksResponse;
import com.google.maps.fleetengine.delivery.v1.Task;
import com.google.maps.fleetengine.delivery.v1.TaskTrackingInfo;
import com.google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest;
import com.google.maps.fleetengine.delivery.v1.UpdateTaskRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DeliveryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDeliveryServiceStub extends DeliveryServiceStub {
  private static final MethodDescriptor<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleMethodDescriptor =
          MethodDescriptor.<CreateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "maps.fleetengine.delivery.v1.DeliveryService/CreateDeliveryVehicle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeliveryVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeliveryVehicle.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleMethodDescriptor =
          MethodDescriptor.<GetDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/GetDeliveryVehicle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeliveryVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeliveryVehicle.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDeliveryVehicleRequest, Empty>
      deleteDeliveryVehicleMethodDescriptor =
          MethodDescriptor.<DeleteDeliveryVehicleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "maps.fleetengine.delivery.v1.DeliveryService/DeleteDeliveryVehicle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeliveryVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleMethodDescriptor =
          MethodDescriptor.<UpdateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "maps.fleetengine.delivery.v1.DeliveryService/UpdateDeliveryVehicle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeliveryVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeliveryVehicle.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksMethodDescriptor =
          MethodDescriptor.<BatchCreateTasksRequest, BatchCreateTasksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/BatchCreateTasks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateTasksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTaskRequest, Task> createTaskMethodDescriptor =
      MethodDescriptor.<CreateTaskRequest, Task>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/CreateTask")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Task.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetTaskRequest, Task> getTaskMethodDescriptor =
      MethodDescriptor.<GetTaskRequest, Task>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/GetTask")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Task.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTaskRequest, Empty> deleteTaskMethodDescriptor =
      MethodDescriptor.<DeleteTaskRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/DeleteTask")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTaskRequest, Task> updateTaskMethodDescriptor =
      MethodDescriptor.<UpdateTaskRequest, Task>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/UpdateTask")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Task.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTasksRequest, ListTasksResponse>
      listTasksMethodDescriptor =
          MethodDescriptor.<ListTasksRequest, ListTasksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/ListTasks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTasksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTaskTrackingInfoRequest, TaskTrackingInfo>
      getTaskTrackingInfoMethodDescriptor =
          MethodDescriptor.<GetTaskTrackingInfoRequest, TaskTrackingInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.delivery.v1.DeliveryService/GetTaskTrackingInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTaskTrackingInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TaskTrackingInfo.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
      listDeliveryVehiclesMethodDescriptor =
          MethodDescriptor.<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "maps.fleetengine.delivery.v1.DeliveryService/ListDeliveryVehicles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeliveryVehiclesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeliveryVehiclesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleCallable;
  private final UnaryCallable<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleCallable;
  private final UnaryCallable<DeleteDeliveryVehicleRequest, Empty> deleteDeliveryVehicleCallable;
  private final UnaryCallable<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleCallable;
  private final UnaryCallable<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksCallable;
  private final UnaryCallable<CreateTaskRequest, Task> createTaskCallable;
  private final UnaryCallable<GetTaskRequest, Task> getTaskCallable;
  private final UnaryCallable<DeleteTaskRequest, Empty> deleteTaskCallable;
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_DELIVERY_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_DELIVERY_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate DELETE_DELIVERY_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_DELIVERY_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate BATCH_CREATE_TASKS_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate CREATE_TASK_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_TASK_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate DELETE_TASK_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_TASK_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate LIST_TASKS_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_TASK_TRACKING_INFO_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate LIST_DELIVERY_VEHICLES_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");

  public static final GrpcDeliveryServiceStub create(DeliveryServiceStubSettings settings)
      throws IOException {
    return new GrpcDeliveryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDeliveryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDeliveryServiceStub(
        DeliveryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDeliveryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDeliveryServiceStub(
        DeliveryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDeliveryServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeliveryServiceStub(
      DeliveryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDeliveryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDeliveryServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeliveryServiceStub(
      DeliveryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDeliveryVehicleRequest, DeliveryVehicle>
        createDeliveryVehicleTransportSettings =
            GrpcCallSettings.<CreateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
                .setMethodDescriptor(createDeliveryVehicleMethodDescriptor)
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
    GrpcCallSettings<GetDeliveryVehicleRequest, DeliveryVehicle>
        getDeliveryVehicleTransportSettings =
            GrpcCallSettings.<GetDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
                .setMethodDescriptor(getDeliveryVehicleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(), "provider_id", GET_DELIVERY_VEHICLE_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDeliveryVehicleRequest, Empty> deleteDeliveryVehicleTransportSettings =
        GrpcCallSettings.<DeleteDeliveryVehicleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeliveryVehicleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      request.getName(), "provider_id", DELETE_DELIVERY_VEHICLE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDeliveryVehicleRequest, DeliveryVehicle>
        updateDeliveryVehicleTransportSettings =
            GrpcCallSettings.<UpdateDeliveryVehicleRequest, DeliveryVehicle>newBuilder()
                .setMethodDescriptor(updateDeliveryVehicleMethodDescriptor)
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
    GrpcCallSettings<BatchCreateTasksRequest, BatchCreateTasksResponse>
        batchCreateTasksTransportSettings =
            GrpcCallSettings.<BatchCreateTasksRequest, BatchCreateTasksResponse>newBuilder()
                .setMethodDescriptor(batchCreateTasksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "provider_id", BATCH_CREATE_TASKS_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateTaskRequest, Task> createTaskTransportSettings =
        GrpcCallSettings.<CreateTaskRequest, Task>newBuilder()
            .setMethodDescriptor(createTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "provider_id", CREATE_TASK_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTaskRequest, Task> getTaskTransportSettings =
        GrpcCallSettings.<GetTaskRequest, Task>newBuilder()
            .setMethodDescriptor(getTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "provider_id", GET_TASK_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTaskRequest, Empty> deleteTaskTransportSettings =
        GrpcCallSettings.<DeleteTaskRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "provider_id", DELETE_TASK_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTaskRequest, Task> updateTaskTransportSettings =
        GrpcCallSettings.<UpdateTaskRequest, Task>newBuilder()
            .setMethodDescriptor(updateTaskMethodDescriptor)
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
    GrpcCallSettings<ListTasksRequest, ListTasksResponse> listTasksTransportSettings =
        GrpcCallSettings.<ListTasksRequest, ListTasksResponse>newBuilder()
            .setMethodDescriptor(listTasksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "provider_id", LIST_TASKS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTaskTrackingInfoRequest, TaskTrackingInfo>
        getTaskTrackingInfoTransportSettings =
            GrpcCallSettings.<GetTaskTrackingInfoRequest, TaskTrackingInfo>newBuilder()
                .setMethodDescriptor(getTaskTrackingInfoMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(), "provider_id", GET_TASK_TRACKING_INFO_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
        listDeliveryVehiclesTransportSettings =
            GrpcCallSettings.<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>newBuilder()
                .setMethodDescriptor(listDeliveryVehiclesMethodDescriptor)
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
    this.deleteDeliveryVehicleCallable =
        callableFactory.createUnaryCallable(
            deleteDeliveryVehicleTransportSettings,
            settings.deleteDeliveryVehicleSettings(),
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
    this.deleteTaskCallable =
        callableFactory.createUnaryCallable(
            deleteTaskTransportSettings, settings.deleteTaskSettings(), clientContext);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<DeleteDeliveryVehicleRequest, Empty> deleteDeliveryVehicleCallable() {
    return deleteDeliveryVehicleCallable;
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
  public UnaryCallable<DeleteTaskRequest, Empty> deleteTaskCallable() {
    return deleteTaskCallable;
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
