/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.maps.fleetengine.delivery.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Last Mile Delivery service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/fleetengine/delivery/v1/delivery_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeliveryServiceGrpc {

  private DeliveryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "maps.fleetengine.delivery.v1.DeliveryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest,
          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
      getCreateDeliveryVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeliveryVehicle",
      requestType = google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.DeliveryVehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest,
          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
      getCreateDeliveryVehicleMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest,
            google.maps.fleetengine.delivery.v1.DeliveryVehicle>
        getCreateDeliveryVehicleMethod;
    if ((getCreateDeliveryVehicleMethod = DeliveryServiceGrpc.getCreateDeliveryVehicleMethod)
        == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getCreateDeliveryVehicleMethod = DeliveryServiceGrpc.getCreateDeliveryVehicleMethod)
            == null) {
          DeliveryServiceGrpc.getCreateDeliveryVehicleMethod =
              getCreateDeliveryVehicleMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest,
                          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDeliveryVehicle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.DeliveryVehicle
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("CreateDeliveryVehicle"))
                      .build();
        }
      }
    }
    return getCreateDeliveryVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest,
          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
      getGetDeliveryVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeliveryVehicle",
      requestType = google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.DeliveryVehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest,
          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
      getGetDeliveryVehicleMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest,
            google.maps.fleetengine.delivery.v1.DeliveryVehicle>
        getGetDeliveryVehicleMethod;
    if ((getGetDeliveryVehicleMethod = DeliveryServiceGrpc.getGetDeliveryVehicleMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getGetDeliveryVehicleMethod = DeliveryServiceGrpc.getGetDeliveryVehicleMethod)
            == null) {
          DeliveryServiceGrpc.getGetDeliveryVehicleMethod =
              getGetDeliveryVehicleMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest,
                          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeliveryVehicle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.DeliveryVehicle
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("GetDeliveryVehicle"))
                      .build();
        }
      }
    }
    return getGetDeliveryVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest,
          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
      getUpdateDeliveryVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeliveryVehicle",
      requestType = google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.DeliveryVehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest,
          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
      getUpdateDeliveryVehicleMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest,
            google.maps.fleetengine.delivery.v1.DeliveryVehicle>
        getUpdateDeliveryVehicleMethod;
    if ((getUpdateDeliveryVehicleMethod = DeliveryServiceGrpc.getUpdateDeliveryVehicleMethod)
        == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getUpdateDeliveryVehicleMethod = DeliveryServiceGrpc.getUpdateDeliveryVehicleMethod)
            == null) {
          DeliveryServiceGrpc.getUpdateDeliveryVehicleMethod =
              getUpdateDeliveryVehicleMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest,
                          google.maps.fleetengine.delivery.v1.DeliveryVehicle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDeliveryVehicle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.DeliveryVehicle
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("UpdateDeliveryVehicle"))
                      .build();
        }
      }
    }
    return getUpdateDeliveryVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest,
          google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>
      getBatchCreateTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateTasks",
      requestType = google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest,
          google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>
      getBatchCreateTasksMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest,
            google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>
        getBatchCreateTasksMethod;
    if ((getBatchCreateTasksMethod = DeliveryServiceGrpc.getBatchCreateTasksMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getBatchCreateTasksMethod = DeliveryServiceGrpc.getBatchCreateTasksMethod) == null) {
          DeliveryServiceGrpc.getBatchCreateTasksMethod =
              getBatchCreateTasksMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest,
                          google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateTasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("BatchCreateTasks"))
                      .build();
        }
      }
    }
    return getBatchCreateTasksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.CreateTaskRequest,
          google.maps.fleetengine.delivery.v1.Task>
      getCreateTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTask",
      requestType = google.maps.fleetengine.delivery.v1.CreateTaskRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.CreateTaskRequest,
          google.maps.fleetengine.delivery.v1.Task>
      getCreateTaskMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.CreateTaskRequest,
            google.maps.fleetengine.delivery.v1.Task>
        getCreateTaskMethod;
    if ((getCreateTaskMethod = DeliveryServiceGrpc.getCreateTaskMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getCreateTaskMethod = DeliveryServiceGrpc.getCreateTaskMethod) == null) {
          DeliveryServiceGrpc.getCreateTaskMethod =
              getCreateTaskMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.CreateTaskRequest,
                          google.maps.fleetengine.delivery.v1.Task>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.CreateTaskRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.Task.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("CreateTask"))
                      .build();
        }
      }
    }
    return getCreateTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.GetTaskRequest,
          google.maps.fleetengine.delivery.v1.Task>
      getGetTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTask",
      requestType = google.maps.fleetengine.delivery.v1.GetTaskRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.GetTaskRequest,
          google.maps.fleetengine.delivery.v1.Task>
      getGetTaskMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.GetTaskRequest,
            google.maps.fleetengine.delivery.v1.Task>
        getGetTaskMethod;
    if ((getGetTaskMethod = DeliveryServiceGrpc.getGetTaskMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getGetTaskMethod = DeliveryServiceGrpc.getGetTaskMethod) == null) {
          DeliveryServiceGrpc.getGetTaskMethod =
              getGetTaskMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.GetTaskRequest,
                          google.maps.fleetengine.delivery.v1.Task>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.GetTaskRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.Task.getDefaultInstance()))
                      .setSchemaDescriptor(new DeliveryServiceMethodDescriptorSupplier("GetTask"))
                      .build();
        }
      }
    }
    return getGetTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.SearchTasksRequest,
          google.maps.fleetengine.delivery.v1.SearchTasksResponse>
      getSearchTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchTasks",
      requestType = google.maps.fleetengine.delivery.v1.SearchTasksRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.SearchTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.SearchTasksRequest,
          google.maps.fleetengine.delivery.v1.SearchTasksResponse>
      getSearchTasksMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.SearchTasksRequest,
            google.maps.fleetengine.delivery.v1.SearchTasksResponse>
        getSearchTasksMethod;
    if ((getSearchTasksMethod = DeliveryServiceGrpc.getSearchTasksMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getSearchTasksMethod = DeliveryServiceGrpc.getSearchTasksMethod) == null) {
          DeliveryServiceGrpc.getSearchTasksMethod =
              getSearchTasksMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.SearchTasksRequest,
                          google.maps.fleetengine.delivery.v1.SearchTasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchTasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.SearchTasksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.SearchTasksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("SearchTasks"))
                      .build();
        }
      }
    }
    return getSearchTasksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.UpdateTaskRequest,
          google.maps.fleetengine.delivery.v1.Task>
      getUpdateTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTask",
      requestType = google.maps.fleetengine.delivery.v1.UpdateTaskRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.UpdateTaskRequest,
          google.maps.fleetengine.delivery.v1.Task>
      getUpdateTaskMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.UpdateTaskRequest,
            google.maps.fleetengine.delivery.v1.Task>
        getUpdateTaskMethod;
    if ((getUpdateTaskMethod = DeliveryServiceGrpc.getUpdateTaskMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getUpdateTaskMethod = DeliveryServiceGrpc.getUpdateTaskMethod) == null) {
          DeliveryServiceGrpc.getUpdateTaskMethod =
              getUpdateTaskMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.UpdateTaskRequest,
                          google.maps.fleetengine.delivery.v1.Task>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.UpdateTaskRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.Task.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("UpdateTask"))
                      .build();
        }
      }
    }
    return getUpdateTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.ListTasksRequest,
          google.maps.fleetengine.delivery.v1.ListTasksResponse>
      getListTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTasks",
      requestType = google.maps.fleetengine.delivery.v1.ListTasksRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.ListTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.ListTasksRequest,
          google.maps.fleetengine.delivery.v1.ListTasksResponse>
      getListTasksMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.ListTasksRequest,
            google.maps.fleetengine.delivery.v1.ListTasksResponse>
        getListTasksMethod;
    if ((getListTasksMethod = DeliveryServiceGrpc.getListTasksMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getListTasksMethod = DeliveryServiceGrpc.getListTasksMethod) == null) {
          DeliveryServiceGrpc.getListTasksMethod =
              getListTasksMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.ListTasksRequest,
                          google.maps.fleetengine.delivery.v1.ListTasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.ListTasksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.ListTasksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DeliveryServiceMethodDescriptorSupplier("ListTasks"))
                      .build();
        }
      }
    }
    return getListTasksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest,
          google.maps.fleetengine.delivery.v1.TaskTrackingInfo>
      getGetTaskTrackingInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTaskTrackingInfo",
      requestType = google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.TaskTrackingInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest,
          google.maps.fleetengine.delivery.v1.TaskTrackingInfo>
      getGetTaskTrackingInfoMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest,
            google.maps.fleetengine.delivery.v1.TaskTrackingInfo>
        getGetTaskTrackingInfoMethod;
    if ((getGetTaskTrackingInfoMethod = DeliveryServiceGrpc.getGetTaskTrackingInfoMethod) == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getGetTaskTrackingInfoMethod = DeliveryServiceGrpc.getGetTaskTrackingInfoMethod)
            == null) {
          DeliveryServiceGrpc.getGetTaskTrackingInfoMethod =
              getGetTaskTrackingInfoMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest,
                          google.maps.fleetengine.delivery.v1.TaskTrackingInfo>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetTaskTrackingInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.TaskTrackingInfo
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("GetTaskTrackingInfo"))
                      .build();
        }
      }
    }
    return getGetTaskTrackingInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest,
          google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>
      getListDeliveryVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeliveryVehicles",
      requestType = google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest.class,
      responseType = google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest,
          google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>
      getListDeliveryVehiclesMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest,
            google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>
        getListDeliveryVehiclesMethod;
    if ((getListDeliveryVehiclesMethod = DeliveryServiceGrpc.getListDeliveryVehiclesMethod)
        == null) {
      synchronized (DeliveryServiceGrpc.class) {
        if ((getListDeliveryVehiclesMethod = DeliveryServiceGrpc.getListDeliveryVehiclesMethod)
            == null) {
          DeliveryServiceGrpc.getListDeliveryVehiclesMethod =
              getListDeliveryVehiclesMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest,
                          google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDeliveryVehicles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeliveryServiceMethodDescriptorSupplier("ListDeliveryVehicles"))
                      .build();
        }
      }
    }
    return getListDeliveryVehiclesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DeliveryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeliveryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeliveryServiceStub>() {
          @java.lang.Override
          public DeliveryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeliveryServiceStub(channel, callOptions);
          }
        };
    return DeliveryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeliveryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeliveryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeliveryServiceBlockingStub>() {
          @java.lang.Override
          public DeliveryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeliveryServiceBlockingStub(channel, callOptions);
          }
        };
    return DeliveryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DeliveryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeliveryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeliveryServiceFutureStub>() {
          @java.lang.Override
          public DeliveryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeliveryServiceFutureStub(channel, callOptions);
          }
        };
    return DeliveryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Last Mile Delivery service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates and returns a new `DeliveryVehicle`.
     * </pre>
     */
    default void createDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeliveryVehicleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `DeliveryVehicle` instance.
     * </pre>
     */
    default void getDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeliveryVehicleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes updated `DeliveryVehicle` data to Fleet Engine, and assigns
     * `Tasks` to the `DeliveryVehicle`. You cannot update the name of the
     * `DeliveryVehicle`. You *can* update `remaining_vehicle_journey_segments`
     * though, but it must contain all of the `VehicleJourneySegment`s currently
     * on the `DeliveryVehicle`. The `task_id`s are retrieved from
     * `remaining_vehicle_journey_segments`, and their corresponding `Tasks` are
     * assigned to the `DeliveryVehicle` if they have not yet been assigned.
     * </pre>
     */
    default void updateDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeliveryVehicleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a batch of new `Task` objects.
     * </pre>
     */
    default void batchCreateTasks(
        google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateTasksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new `Task` object.
     * </pre>
     */
    default void createTask(
        google.maps.fleetengine.delivery.v1.CreateTaskRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a `Task`.
     * </pre>
     */
    default void getTask(
        google.maps.fleetengine.delivery.v1.GetTaskRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `GetTaskTrackingInfo` instead.
     * </pre>
     */
    @java.lang.Deprecated
    default void searchTasks(
        google.maps.fleetengine.delivery.v1.SearchTasksRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.SearchTasksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchTasksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates `Task` data.
     * </pre>
     */
    default void updateTask(
        google.maps.fleetengine.delivery.v1.UpdateTaskRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all `Task`s that meet the specified filtering criteria.
     * </pre>
     */
    default void listTasks(
        google.maps.fleetengine.delivery.v1.ListTasksRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.ListTasksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTasksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `TaskTrackingInfo` instance.
     * </pre>
     */
    default void getTaskTrackingInfo(
        google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.TaskTrackingInfo>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTaskTrackingInfoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
     * </pre>
     */
    default void listDeliveryVehicles(
        google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest request,
        io.grpc.stub.StreamObserver<
                google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeliveryVehiclesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DeliveryService.
   *
   * <pre>
   * The Last Mile Delivery service.
   * </pre>
   */
  public abstract static class DeliveryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DeliveryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DeliveryService.
   *
   * <pre>
   * The Last Mile Delivery service.
   * </pre>
   */
  public static final class DeliveryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DeliveryServiceStub> {
    private DeliveryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeliveryServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeliveryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new `DeliveryVehicle`.
     * </pre>
     */
    public void createDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeliveryVehicleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `DeliveryVehicle` instance.
     * </pre>
     */
    public void getDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeliveryVehicleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes updated `DeliveryVehicle` data to Fleet Engine, and assigns
     * `Tasks` to the `DeliveryVehicle`. You cannot update the name of the
     * `DeliveryVehicle`. You *can* update `remaining_vehicle_journey_segments`
     * though, but it must contain all of the `VehicleJourneySegment`s currently
     * on the `DeliveryVehicle`. The `task_id`s are retrieved from
     * `remaining_vehicle_journey_segments`, and their corresponding `Tasks` are
     * assigned to the `DeliveryVehicle` if they have not yet been assigned.
     * </pre>
     */
    public void updateDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeliveryVehicleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a batch of new `Task` objects.
     * </pre>
     */
    public void batchCreateTasks(
        google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateTasksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new `Task` object.
     * </pre>
     */
    public void createTask(
        google.maps.fleetengine.delivery.v1.CreateTaskRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a `Task`.
     * </pre>
     */
    public void getTask(
        google.maps.fleetengine.delivery.v1.GetTaskRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `GetTaskTrackingInfo` instead.
     * </pre>
     */
    @java.lang.Deprecated
    public void searchTasks(
        google.maps.fleetengine.delivery.v1.SearchTasksRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.SearchTasksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchTasksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates `Task` data.
     * </pre>
     */
    public void updateTask(
        google.maps.fleetengine.delivery.v1.UpdateTaskRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all `Task`s that meet the specified filtering criteria.
     * </pre>
     */
    public void listTasks(
        google.maps.fleetengine.delivery.v1.ListTasksRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.ListTasksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `TaskTrackingInfo` instance.
     * </pre>
     */
    public void getTaskTrackingInfo(
        google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.TaskTrackingInfo>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaskTrackingInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
     * </pre>
     */
    public void listDeliveryVehicles(
        google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest request,
        io.grpc.stub.StreamObserver<
                google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeliveryVehiclesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DeliveryService.
   *
   * <pre>
   * The Last Mile Delivery service.
   * </pre>
   */
  public static final class DeliveryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeliveryServiceBlockingStub> {
    private DeliveryServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeliveryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeliveryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new `DeliveryVehicle`.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.DeliveryVehicle createDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeliveryVehicleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `DeliveryVehicle` instance.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.DeliveryVehicle getDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeliveryVehicleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Writes updated `DeliveryVehicle` data to Fleet Engine, and assigns
     * `Tasks` to the `DeliveryVehicle`. You cannot update the name of the
     * `DeliveryVehicle`. You *can* update `remaining_vehicle_journey_segments`
     * though, but it must contain all of the `VehicleJourneySegment`s currently
     * on the `DeliveryVehicle`. The `task_id`s are retrieved from
     * `remaining_vehicle_journey_segments`, and their corresponding `Tasks` are
     * assigned to the `DeliveryVehicle` if they have not yet been assigned.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.DeliveryVehicle updateDeliveryVehicle(
        google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeliveryVehicleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a batch of new `Task` objects.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse batchCreateTasks(
        google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateTasksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new `Task` object.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.Task createTask(
        google.maps.fleetengine.delivery.v1.CreateTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a `Task`.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.Task getTask(
        google.maps.fleetengine.delivery.v1.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `GetTaskTrackingInfo` instead.
     * </pre>
     */
    @java.lang.Deprecated
    public google.maps.fleetengine.delivery.v1.SearchTasksResponse searchTasks(
        google.maps.fleetengine.delivery.v1.SearchTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchTasksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates `Task` data.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.Task updateTask(
        google.maps.fleetengine.delivery.v1.UpdateTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets all `Task`s that meet the specified filtering criteria.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.ListTasksResponse listTasks(
        google.maps.fleetengine.delivery.v1.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTasksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `TaskTrackingInfo` instance.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.TaskTrackingInfo getTaskTrackingInfo(
        google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaskTrackingInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
     * </pre>
     */
    public google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse listDeliveryVehicles(
        google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeliveryVehiclesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DeliveryService.
   *
   * <pre>
   * The Last Mile Delivery service.
   * </pre>
   */
  public static final class DeliveryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeliveryServiceFutureStub> {
    private DeliveryServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeliveryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeliveryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new `DeliveryVehicle`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.DeliveryVehicle>
        createDeliveryVehicle(
            google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeliveryVehicleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `DeliveryVehicle` instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.DeliveryVehicle>
        getDeliveryVehicle(google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeliveryVehicleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Writes updated `DeliveryVehicle` data to Fleet Engine, and assigns
     * `Tasks` to the `DeliveryVehicle`. You cannot update the name of the
     * `DeliveryVehicle`. You *can* update `remaining_vehicle_journey_segments`
     * though, but it must contain all of the `VehicleJourneySegment`s currently
     * on the `DeliveryVehicle`. The `task_id`s are retrieved from
     * `remaining_vehicle_journey_segments`, and their corresponding `Tasks` are
     * assigned to the `DeliveryVehicle` if they have not yet been assigned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.DeliveryVehicle>
        updateDeliveryVehicle(
            google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeliveryVehicleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a batch of new `Task` objects.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>
        batchCreateTasks(google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateTasksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new `Task` object.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.Task>
        createTask(google.maps.fleetengine.delivery.v1.CreateTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a `Task`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.Task>
        getTask(google.maps.fleetengine.delivery.v1.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `GetTaskTrackingInfo` instead.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.SearchTasksResponse>
        searchTasks(google.maps.fleetengine.delivery.v1.SearchTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchTasksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates `Task` data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.Task>
        updateTask(google.maps.fleetengine.delivery.v1.UpdateTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets all `Task`s that meet the specified filtering criteria.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.ListTasksResponse>
        listTasks(google.maps.fleetengine.delivery.v1.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified `TaskTrackingInfo` instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.TaskTrackingInfo>
        getTaskTrackingInfo(
            google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaskTrackingInfoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>
        listDeliveryVehicles(
            google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeliveryVehiclesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DELIVERY_VEHICLE = 0;
  private static final int METHODID_GET_DELIVERY_VEHICLE = 1;
  private static final int METHODID_UPDATE_DELIVERY_VEHICLE = 2;
  private static final int METHODID_BATCH_CREATE_TASKS = 3;
  private static final int METHODID_CREATE_TASK = 4;
  private static final int METHODID_GET_TASK = 5;
  private static final int METHODID_SEARCH_TASKS = 6;
  private static final int METHODID_UPDATE_TASK = 7;
  private static final int METHODID_LIST_TASKS = 8;
  private static final int METHODID_GET_TASK_TRACKING_INFO = 9;
  private static final int METHODID_LIST_DELIVERY_VEHICLES = 10;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DELIVERY_VEHICLE:
          serviceImpl.createDeliveryVehicle(
              (google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>)
                  responseObserver);
          break;
        case METHODID_GET_DELIVERY_VEHICLE:
          serviceImpl.getDeliveryVehicle(
              (google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DELIVERY_VEHICLE:
          serviceImpl.updateDeliveryVehicle(
              (google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.DeliveryVehicle>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_TASKS:
          serviceImpl.batchCreateTasks(
              (google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest) request,
              (io.grpc.stub.StreamObserver<
                      google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TASK:
          serviceImpl.createTask(
              (google.maps.fleetengine.delivery.v1.CreateTaskRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task>)
                  responseObserver);
          break;
        case METHODID_GET_TASK:
          serviceImpl.getTask(
              (google.maps.fleetengine.delivery.v1.GetTaskRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task>)
                  responseObserver);
          break;
        case METHODID_SEARCH_TASKS:
          serviceImpl.searchTasks(
              (google.maps.fleetengine.delivery.v1.SearchTasksRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.SearchTasksResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TASK:
          serviceImpl.updateTask(
              (google.maps.fleetengine.delivery.v1.UpdateTaskRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.Task>)
                  responseObserver);
          break;
        case METHODID_LIST_TASKS:
          serviceImpl.listTasks(
              (google.maps.fleetengine.delivery.v1.ListTasksRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.ListTasksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TASK_TRACKING_INFO:
          serviceImpl.getTaskTrackingInfo(
              (google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.delivery.v1.TaskTrackingInfo>)
                  responseObserver);
          break;
        case METHODID_LIST_DELIVERY_VEHICLES:
          serviceImpl.listDeliveryVehicles(
              (google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest) request,
              (io.grpc.stub.StreamObserver<
                      google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getCreateDeliveryVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest,
                    google.maps.fleetengine.delivery.v1.DeliveryVehicle>(
                    service, METHODID_CREATE_DELIVERY_VEHICLE)))
        .addMethod(
            getGetDeliveryVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest,
                    google.maps.fleetengine.delivery.v1.DeliveryVehicle>(
                    service, METHODID_GET_DELIVERY_VEHICLE)))
        .addMethod(
            getUpdateDeliveryVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest,
                    google.maps.fleetengine.delivery.v1.DeliveryVehicle>(
                    service, METHODID_UPDATE_DELIVERY_VEHICLE)))
        .addMethod(
            getBatchCreateTasksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest,
                    google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse>(
                    service, METHODID_BATCH_CREATE_TASKS)))
        .addMethod(
            getCreateTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.CreateTaskRequest,
                    google.maps.fleetengine.delivery.v1.Task>(service, METHODID_CREATE_TASK)))
        .addMethod(
            getGetTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.GetTaskRequest,
                    google.maps.fleetengine.delivery.v1.Task>(service, METHODID_GET_TASK)))
        .addMethod(
            getSearchTasksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.SearchTasksRequest,
                    google.maps.fleetengine.delivery.v1.SearchTasksResponse>(
                    service, METHODID_SEARCH_TASKS)))
        .addMethod(
            getUpdateTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.UpdateTaskRequest,
                    google.maps.fleetengine.delivery.v1.Task>(service, METHODID_UPDATE_TASK)))
        .addMethod(
            getListTasksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.ListTasksRequest,
                    google.maps.fleetengine.delivery.v1.ListTasksResponse>(
                    service, METHODID_LIST_TASKS)))
        .addMethod(
            getGetTaskTrackingInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest,
                    google.maps.fleetengine.delivery.v1.TaskTrackingInfo>(
                    service, METHODID_GET_TASK_TRACKING_INFO)))
        .addMethod(
            getListDeliveryVehiclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest,
                    google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse>(
                    service, METHODID_LIST_DELIVERY_VEHICLES)))
        .build();
  }

  private abstract static class DeliveryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeliveryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return google.maps.fleetengine.delivery.v1.DeliveryApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeliveryService");
    }
  }

  private static final class DeliveryServiceFileDescriptorSupplier
      extends DeliveryServiceBaseDescriptorSupplier {
    DeliveryServiceFileDescriptorSupplier() {}
  }

  private static final class DeliveryServiceMethodDescriptorSupplier
      extends DeliveryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DeliveryServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DeliveryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DeliveryServiceFileDescriptorSupplier())
                      .addMethod(getCreateDeliveryVehicleMethod())
                      .addMethod(getGetDeliveryVehicleMethod())
                      .addMethod(getUpdateDeliveryVehicleMethod())
                      .addMethod(getBatchCreateTasksMethod())
                      .addMethod(getCreateTaskMethod())
                      .addMethod(getGetTaskMethod())
                      .addMethod(getSearchTasksMethod())
                      .addMethod(getUpdateTaskMethod())
                      .addMethod(getListTasksMethod())
                      .addMethod(getGetTaskTrackingInfoMethod())
                      .addMethod(getListDeliveryVehiclesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
