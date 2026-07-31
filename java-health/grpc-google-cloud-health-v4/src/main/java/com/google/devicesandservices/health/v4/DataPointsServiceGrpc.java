/*
 * Copyright 2026 Google LLC
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
package com.google.devicesandservices.health.v4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Data Points Service exposing the user's health and fitness measured and
 * derived data.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataPointsServiceGrpc {

  private DataPointsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.devicesandservices.health.v4.DataPointsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetDataPointRequest,
          com.google.devicesandservices.health.v4.DataPoint>
      getGetDataPointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataPoint",
      requestType = com.google.devicesandservices.health.v4.GetDataPointRequest.class,
      responseType = com.google.devicesandservices.health.v4.DataPoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.GetDataPointRequest,
          com.google.devicesandservices.health.v4.DataPoint>
      getGetDataPointMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.GetDataPointRequest,
            com.google.devicesandservices.health.v4.DataPoint>
        getGetDataPointMethod;
    if ((getGetDataPointMethod = DataPointsServiceGrpc.getGetDataPointMethod) == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getGetDataPointMethod = DataPointsServiceGrpc.getGetDataPointMethod) == null) {
          DataPointsServiceGrpc.getGetDataPointMethod =
              getGetDataPointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.GetDataPointRequest,
                          com.google.devicesandservices.health.v4.DataPoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataPoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.GetDataPointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.DataPoint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("GetDataPoint"))
                      .build();
        }
      }
    }
    return getGetDataPointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ListDataPointsRequest,
          com.google.devicesandservices.health.v4.ListDataPointsResponse>
      getListDataPointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataPoints",
      requestType = com.google.devicesandservices.health.v4.ListDataPointsRequest.class,
      responseType = com.google.devicesandservices.health.v4.ListDataPointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ListDataPointsRequest,
          com.google.devicesandservices.health.v4.ListDataPointsResponse>
      getListDataPointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.ListDataPointsRequest,
            com.google.devicesandservices.health.v4.ListDataPointsResponse>
        getListDataPointsMethod;
    if ((getListDataPointsMethod = DataPointsServiceGrpc.getListDataPointsMethod) == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getListDataPointsMethod = DataPointsServiceGrpc.getListDataPointsMethod) == null) {
          DataPointsServiceGrpc.getListDataPointsMethod =
              getListDataPointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.ListDataPointsRequest,
                          com.google.devicesandservices.health.v4.ListDataPointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataPoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ListDataPointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ListDataPointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("ListDataPoints"))
                      .build();
        }
      }
    }
    return getListDataPointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.CreateDataPointRequest,
          com.google.longrunning.Operation>
      getCreateDataPointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataPoint",
      requestType = com.google.devicesandservices.health.v4.CreateDataPointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.CreateDataPointRequest,
          com.google.longrunning.Operation>
      getCreateDataPointMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.CreateDataPointRequest,
            com.google.longrunning.Operation>
        getCreateDataPointMethod;
    if ((getCreateDataPointMethod = DataPointsServiceGrpc.getCreateDataPointMethod) == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getCreateDataPointMethod = DataPointsServiceGrpc.getCreateDataPointMethod) == null) {
          DataPointsServiceGrpc.getCreateDataPointMethod =
              getCreateDataPointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.CreateDataPointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataPoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.CreateDataPointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("CreateDataPoint"))
                      .build();
        }
      }
    }
    return getCreateDataPointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateDataPointRequest,
          com.google.longrunning.Operation>
      getUpdateDataPointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataPoint",
      requestType = com.google.devicesandservices.health.v4.UpdateDataPointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateDataPointRequest,
          com.google.longrunning.Operation>
      getUpdateDataPointMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.UpdateDataPointRequest,
            com.google.longrunning.Operation>
        getUpdateDataPointMethod;
    if ((getUpdateDataPointMethod = DataPointsServiceGrpc.getUpdateDataPointMethod) == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getUpdateDataPointMethod = DataPointsServiceGrpc.getUpdateDataPointMethod) == null) {
          DataPointsServiceGrpc.getUpdateDataPointMethod =
              getUpdateDataPointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.UpdateDataPointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataPoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.UpdateDataPointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("UpdateDataPoint"))
                      .build();
        }
      }
    }
    return getUpdateDataPointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteDataPointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteDataPoints",
      requestType = com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteDataPointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest,
            com.google.longrunning.Operation>
        getBatchDeleteDataPointsMethod;
    if ((getBatchDeleteDataPointsMethod = DataPointsServiceGrpc.getBatchDeleteDataPointsMethod)
        == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getBatchDeleteDataPointsMethod = DataPointsServiceGrpc.getBatchDeleteDataPointsMethod)
            == null) {
          DataPointsServiceGrpc.getBatchDeleteDataPointsMethod =
              getBatchDeleteDataPointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteDataPoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("BatchDeleteDataPoints"))
                      .build();
        }
      }
    }
    return getBatchDeleteDataPointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ReconcileDataPointsRequest,
          com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>
      getReconcileDataPointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReconcileDataPoints",
      requestType = com.google.devicesandservices.health.v4.ReconcileDataPointsRequest.class,
      responseType = com.google.devicesandservices.health.v4.ReconcileDataPointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ReconcileDataPointsRequest,
          com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>
      getReconcileDataPointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.ReconcileDataPointsRequest,
            com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>
        getReconcileDataPointsMethod;
    if ((getReconcileDataPointsMethod = DataPointsServiceGrpc.getReconcileDataPointsMethod)
        == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getReconcileDataPointsMethod = DataPointsServiceGrpc.getReconcileDataPointsMethod)
            == null) {
          DataPointsServiceGrpc.getReconcileDataPointsMethod =
              getReconcileDataPointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.ReconcileDataPointsRequest,
                          com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReconcileDataPoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ReconcileDataPointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ReconcileDataPointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("ReconcileDataPoints"))
                      .build();
        }
      }
    }
    return getReconcileDataPointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.RollUpDataPointsRequest,
          com.google.devicesandservices.health.v4.RollUpDataPointsResponse>
      getRollUpDataPointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollUpDataPoints",
      requestType = com.google.devicesandservices.health.v4.RollUpDataPointsRequest.class,
      responseType = com.google.devicesandservices.health.v4.RollUpDataPointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.RollUpDataPointsRequest,
          com.google.devicesandservices.health.v4.RollUpDataPointsResponse>
      getRollUpDataPointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.RollUpDataPointsRequest,
            com.google.devicesandservices.health.v4.RollUpDataPointsResponse>
        getRollUpDataPointsMethod;
    if ((getRollUpDataPointsMethod = DataPointsServiceGrpc.getRollUpDataPointsMethod) == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getRollUpDataPointsMethod = DataPointsServiceGrpc.getRollUpDataPointsMethod) == null) {
          DataPointsServiceGrpc.getRollUpDataPointsMethod =
              getRollUpDataPointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.RollUpDataPointsRequest,
                          com.google.devicesandservices.health.v4.RollUpDataPointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollUpDataPoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.RollUpDataPointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.RollUpDataPointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("RollUpDataPoints"))
                      .build();
        }
      }
    }
    return getRollUpDataPointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest,
          com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>
      getDailyRollUpDataPointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DailyRollUpDataPoints",
      requestType = com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest.class,
      responseType = com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest,
          com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>
      getDailyRollUpDataPointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest,
            com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>
        getDailyRollUpDataPointsMethod;
    if ((getDailyRollUpDataPointsMethod = DataPointsServiceGrpc.getDailyRollUpDataPointsMethod)
        == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getDailyRollUpDataPointsMethod = DataPointsServiceGrpc.getDailyRollUpDataPointsMethod)
            == null) {
          DataPointsServiceGrpc.getDailyRollUpDataPointsMethod =
              getDailyRollUpDataPointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest,
                          com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DailyRollUpDataPoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("DailyRollUpDataPoints"))
                      .build();
        }
      }
    }
    return getDailyRollUpDataPointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ExportExerciseTcxRequest,
          com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>
      getExportExerciseTcxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportExerciseTcx",
      requestType = com.google.devicesandservices.health.v4.ExportExerciseTcxRequest.class,
      responseType = com.google.devicesandservices.health.v4.ExportExerciseTcxResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ExportExerciseTcxRequest,
          com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>
      getExportExerciseTcxMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.ExportExerciseTcxRequest,
            com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>
        getExportExerciseTcxMethod;
    if ((getExportExerciseTcxMethod = DataPointsServiceGrpc.getExportExerciseTcxMethod) == null) {
      synchronized (DataPointsServiceGrpc.class) {
        if ((getExportExerciseTcxMethod = DataPointsServiceGrpc.getExportExerciseTcxMethod)
            == null) {
          DataPointsServiceGrpc.getExportExerciseTcxMethod =
              getExportExerciseTcxMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.ExportExerciseTcxRequest,
                          com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportExerciseTcx"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ExportExerciseTcxRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ExportExerciseTcxResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPointsServiceMethodDescriptorSupplier("ExportExerciseTcx"))
                      .build();
        }
      }
    }
    return getExportExerciseTcxMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataPointsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceStub>() {
          @java.lang.Override
          public DataPointsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataPointsServiceStub(channel, callOptions);
          }
        };
    return DataPointsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataPointsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataPointsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataPointsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataPointsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataPointsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceBlockingStub>() {
          @java.lang.Override
          public DataPointsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataPointsServiceBlockingStub(channel, callOptions);
          }
        };
    return DataPointsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataPointsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataPointsServiceFutureStub>() {
          @java.lang.Override
          public DataPointsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataPointsServiceFutureStub(channel, callOptions);
          }
        };
    return DataPointsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Data Points Service exposing the user's health and fitness measured and
   * derived data.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get a single identifyable data point.
     * </pre>
     */
    default void getDataPoint(
        com.google.devicesandservices.health.v4.GetDataPointRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.DataPoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataPointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Query user health and fitness data points.
     * </pre>
     */
    default void listDataPoints(
        com.google.devicesandservices.health.v4.ListDataPointsRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.ListDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataPointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a single identifiable data point.
     * </pre>
     */
    default void createDataPoint(
        com.google.devicesandservices.health.v4.CreateDataPointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataPointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single identifiable data point. If a data point with the
     * specified `name` is not found, the request will fail.
     * </pre>
     */
    default void updateDataPoint(
        com.google.devicesandservices.health.v4.UpdateDataPointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataPointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a batch of identifyable data points.
     * </pre>
     */
    default void batchDeleteDataPoints(
        com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteDataPointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reconcile data points from multiple data sources into a single data stream.
     * </pre>
     */
    default void reconcileDataPoints(
        com.google.devicesandservices.health.v4.ReconcileDataPointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReconcileDataPointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over physical time intervals for supported data types.
     * </pre>
     */
    default void rollUpDataPoints(
        com.google.devicesandservices.health.v4.RollUpDataPointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.RollUpDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollUpDataPointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over civil time intervals for supported data types.
     * </pre>
     */
    default void dailyRollUpDataPoints(
        com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDailyRollUpDataPointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports exercise data in TCX format.
     * **IMPORTANT:** HTTP clients must append `?alt=media` to the
     * request URL to download the raw TCX file.
     * Example:
     * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
     * Without `alt=media`, the server returns a JSON response
     * (`ExportExerciseTcxResponse`)
     * which is intended primarily for gRPC clients.
     * **Note:** While the Authorization section below states that any one of the
     * listed scopes is accepted, this specific method requires the user to
     * provide both one of the `activity_and_fitness` scopes (`normal` or
     * `readonly`) AND one of the `location` scopes (`normal` or `readonly`) in
     * their access token to succeed.
     * </pre>
     */
    default void exportExerciseTcx(
        com.google.devicesandservices.health.v4.ExportExerciseTcxRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportExerciseTcxMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataPointsService.
   *
   * <pre>
   * Data Points Service exposing the user's health and fitness measured and
   * derived data.
   * </pre>
   */
  public abstract static class DataPointsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataPointsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataPointsService.
   *
   * <pre>
   * Data Points Service exposing the user's health and fitness measured and
   * derived data.
   * </pre>
   */
  public static final class DataPointsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataPointsServiceStub> {
    private DataPointsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataPointsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataPointsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single identifyable data point.
     * </pre>
     */
    public void getDataPoint(
        com.google.devicesandservices.health.v4.GetDataPointRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.DataPoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataPointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Query user health and fitness data points.
     * </pre>
     */
    public void listDataPoints(
        com.google.devicesandservices.health.v4.ListDataPointsRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.ListDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataPointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a single identifiable data point.
     * </pre>
     */
    public void createDataPoint(
        com.google.devicesandservices.health.v4.CreateDataPointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataPointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single identifiable data point. If a data point with the
     * specified `name` is not found, the request will fail.
     * </pre>
     */
    public void updateDataPoint(
        com.google.devicesandservices.health.v4.UpdateDataPointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataPointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a batch of identifyable data points.
     * </pre>
     */
    public void batchDeleteDataPoints(
        com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteDataPointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reconcile data points from multiple data sources into a single data stream.
     * </pre>
     */
    public void reconcileDataPoints(
        com.google.devicesandservices.health.v4.ReconcileDataPointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReconcileDataPointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over physical time intervals for supported data types.
     * </pre>
     */
    public void rollUpDataPoints(
        com.google.devicesandservices.health.v4.RollUpDataPointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.RollUpDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollUpDataPointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over civil time intervals for supported data types.
     * </pre>
     */
    public void dailyRollUpDataPoints(
        com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDailyRollUpDataPointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports exercise data in TCX format.
     * **IMPORTANT:** HTTP clients must append `?alt=media` to the
     * request URL to download the raw TCX file.
     * Example:
     * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
     * Without `alt=media`, the server returns a JSON response
     * (`ExportExerciseTcxResponse`)
     * which is intended primarily for gRPC clients.
     * **Note:** While the Authorization section below states that any one of the
     * listed scopes is accepted, this specific method requires the user to
     * provide both one of the `activity_and_fitness` scopes (`normal` or
     * `readonly`) AND one of the `location` scopes (`normal` or `readonly`) in
     * their access token to succeed.
     * </pre>
     */
    public void exportExerciseTcx(
        com.google.devicesandservices.health.v4.ExportExerciseTcxRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportExerciseTcxMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataPointsService.
   *
   * <pre>
   * Data Points Service exposing the user's health and fitness measured and
   * derived data.
   * </pre>
   */
  public static final class DataPointsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataPointsServiceBlockingV2Stub> {
    private DataPointsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataPointsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataPointsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single identifyable data point.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.DataPoint getDataPoint(
        com.google.devicesandservices.health.v4.GetDataPointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataPointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Query user health and fitness data points.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ListDataPointsResponse listDataPoints(
        com.google.devicesandservices.health.v4.ListDataPointsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single identifiable data point.
     * </pre>
     */
    public com.google.longrunning.Operation createDataPoint(
        com.google.devicesandservices.health.v4.CreateDataPointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDataPointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single identifiable data point. If a data point with the
     * specified `name` is not found, the request will fail.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataPoint(
        com.google.devicesandservices.health.v4.UpdateDataPointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDataPointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a batch of identifyable data points.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteDataPoints(
        com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchDeleteDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reconcile data points from multiple data sources into a single data stream.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ReconcileDataPointsResponse reconcileDataPoints(
        com.google.devicesandservices.health.v4.ReconcileDataPointsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReconcileDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over physical time intervals for supported data types.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.RollUpDataPointsResponse rollUpDataPoints(
        com.google.devicesandservices.health.v4.RollUpDataPointsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRollUpDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over civil time intervals for supported data types.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse
        dailyRollUpDataPoints(
            com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDailyRollUpDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports exercise data in TCX format.
     * **IMPORTANT:** HTTP clients must append `?alt=media` to the
     * request URL to download the raw TCX file.
     * Example:
     * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
     * Without `alt=media`, the server returns a JSON response
     * (`ExportExerciseTcxResponse`)
     * which is intended primarily for gRPC clients.
     * **Note:** While the Authorization section below states that any one of the
     * listed scopes is accepted, this specific method requires the user to
     * provide both one of the `activity_and_fitness` scopes (`normal` or
     * `readonly`) AND one of the `location` scopes (`normal` or `readonly`) in
     * their access token to succeed.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ExportExerciseTcxResponse exportExerciseTcx(
        com.google.devicesandservices.health.v4.ExportExerciseTcxRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportExerciseTcxMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataPointsService.
   *
   * <pre>
   * Data Points Service exposing the user's health and fitness measured and
   * derived data.
   * </pre>
   */
  public static final class DataPointsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataPointsServiceBlockingStub> {
    private DataPointsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataPointsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataPointsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single identifyable data point.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.DataPoint getDataPoint(
        com.google.devicesandservices.health.v4.GetDataPointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataPointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Query user health and fitness data points.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ListDataPointsResponse listDataPoints(
        com.google.devicesandservices.health.v4.ListDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single identifiable data point.
     * </pre>
     */
    public com.google.longrunning.Operation createDataPoint(
        com.google.devicesandservices.health.v4.CreateDataPointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataPointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single identifiable data point. If a data point with the
     * specified `name` is not found, the request will fail.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataPoint(
        com.google.devicesandservices.health.v4.UpdateDataPointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataPointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a batch of identifyable data points.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteDataPoints(
        com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reconcile data points from multiple data sources into a single data stream.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ReconcileDataPointsResponse reconcileDataPoints(
        com.google.devicesandservices.health.v4.ReconcileDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReconcileDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over physical time intervals for supported data types.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.RollUpDataPointsResponse rollUpDataPoints(
        com.google.devicesandservices.health.v4.RollUpDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollUpDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over civil time intervals for supported data types.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse
        dailyRollUpDataPoints(
            com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDailyRollUpDataPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports exercise data in TCX format.
     * **IMPORTANT:** HTTP clients must append `?alt=media` to the
     * request URL to download the raw TCX file.
     * Example:
     * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
     * Without `alt=media`, the server returns a JSON response
     * (`ExportExerciseTcxResponse`)
     * which is intended primarily for gRPC clients.
     * **Note:** While the Authorization section below states that any one of the
     * listed scopes is accepted, this specific method requires the user to
     * provide both one of the `activity_and_fitness` scopes (`normal` or
     * `readonly`) AND one of the `location` scopes (`normal` or `readonly`) in
     * their access token to succeed.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ExportExerciseTcxResponse exportExerciseTcx(
        com.google.devicesandservices.health.v4.ExportExerciseTcxRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportExerciseTcxMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataPointsService.
   *
   * <pre>
   * Data Points Service exposing the user's health and fitness measured and
   * derived data.
   * </pre>
   */
  public static final class DataPointsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataPointsServiceFutureStub> {
    private DataPointsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataPointsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataPointsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single identifyable data point.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.DataPoint>
        getDataPoint(com.google.devicesandservices.health.v4.GetDataPointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataPointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Query user health and fitness data points.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.ListDataPointsResponse>
        listDataPoints(com.google.devicesandservices.health.v4.ListDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataPointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a single identifiable data point.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataPoint(com.google.devicesandservices.health.v4.CreateDataPointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataPointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single identifiable data point. If a data point with the
     * specified `name` is not found, the request will fail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataPoint(com.google.devicesandservices.health.v4.UpdateDataPointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataPointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a batch of identifyable data points.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteDataPoints(
            com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteDataPointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reconcile data points from multiple data sources into a single data stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>
        reconcileDataPoints(
            com.google.devicesandservices.health.v4.ReconcileDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReconcileDataPointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over physical time intervals for supported data types.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.RollUpDataPointsResponse>
        rollUpDataPoints(com.google.devicesandservices.health.v4.RollUpDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollUpDataPointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Roll up data points over civil time intervals for supported data types.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>
        dailyRollUpDataPoints(
            com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDailyRollUpDataPointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports exercise data in TCX format.
     * **IMPORTANT:** HTTP clients must append `?alt=media` to the
     * request URL to download the raw TCX file.
     * Example:
     * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
     * Without `alt=media`, the server returns a JSON response
     * (`ExportExerciseTcxResponse`)
     * which is intended primarily for gRPC clients.
     * **Note:** While the Authorization section below states that any one of the
     * listed scopes is accepted, this specific method requires the user to
     * provide both one of the `activity_and_fitness` scopes (`normal` or
     * `readonly`) AND one of the `location` scopes (`normal` or `readonly`) in
     * their access token to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>
        exportExerciseTcx(
            com.google.devicesandservices.health.v4.ExportExerciseTcxRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportExerciseTcxMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA_POINT = 0;
  private static final int METHODID_LIST_DATA_POINTS = 1;
  private static final int METHODID_CREATE_DATA_POINT = 2;
  private static final int METHODID_UPDATE_DATA_POINT = 3;
  private static final int METHODID_BATCH_DELETE_DATA_POINTS = 4;
  private static final int METHODID_RECONCILE_DATA_POINTS = 5;
  private static final int METHODID_ROLL_UP_DATA_POINTS = 6;
  private static final int METHODID_DAILY_ROLL_UP_DATA_POINTS = 7;
  private static final int METHODID_EXPORT_EXERCISE_TCX = 8;

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
        case METHODID_GET_DATA_POINT:
          serviceImpl.getDataPoint(
              (com.google.devicesandservices.health.v4.GetDataPointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.DataPoint>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_POINTS:
          serviceImpl.listDataPoints(
              (com.google.devicesandservices.health.v4.ListDataPointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devicesandservices.health.v4.ListDataPointsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_POINT:
          serviceImpl.createDataPoint(
              (com.google.devicesandservices.health.v4.CreateDataPointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_POINT:
          serviceImpl.updateDataPoint(
              (com.google.devicesandservices.health.v4.UpdateDataPointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_DATA_POINTS:
          serviceImpl.batchDeleteDataPoints(
              (com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RECONCILE_DATA_POINTS:
          serviceImpl.reconcileDataPoints(
              (com.google.devicesandservices.health.v4.ReconcileDataPointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>)
                  responseObserver);
          break;
        case METHODID_ROLL_UP_DATA_POINTS:
          serviceImpl.rollUpDataPoints(
              (com.google.devicesandservices.health.v4.RollUpDataPointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devicesandservices.health.v4.RollUpDataPointsResponse>)
                  responseObserver);
          break;
        case METHODID_DAILY_ROLL_UP_DATA_POINTS:
          serviceImpl.dailyRollUpDataPoints(
              (com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_EXERCISE_TCX:
          serviceImpl.exportExerciseTcx(
              (com.google.devicesandservices.health.v4.ExportExerciseTcxRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>)
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
            getGetDataPointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.GetDataPointRequest,
                    com.google.devicesandservices.health.v4.DataPoint>(
                    service, METHODID_GET_DATA_POINT)))
        .addMethod(
            getListDataPointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.ListDataPointsRequest,
                    com.google.devicesandservices.health.v4.ListDataPointsResponse>(
                    service, METHODID_LIST_DATA_POINTS)))
        .addMethod(
            getCreateDataPointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.CreateDataPointRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATA_POINT)))
        .addMethod(
            getUpdateDataPointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.UpdateDataPointRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_POINT)))
        .addMethod(
            getBatchDeleteDataPointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_DELETE_DATA_POINTS)))
        .addMethod(
            getReconcileDataPointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.ReconcileDataPointsRequest,
                    com.google.devicesandservices.health.v4.ReconcileDataPointsResponse>(
                    service, METHODID_RECONCILE_DATA_POINTS)))
        .addMethod(
            getRollUpDataPointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.RollUpDataPointsRequest,
                    com.google.devicesandservices.health.v4.RollUpDataPointsResponse>(
                    service, METHODID_ROLL_UP_DATA_POINTS)))
        .addMethod(
            getDailyRollUpDataPointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest,
                    com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse>(
                    service, METHODID_DAILY_ROLL_UP_DATA_POINTS)))
        .addMethod(
            getExportExerciseTcxMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.ExportExerciseTcxRequest,
                    com.google.devicesandservices.health.v4.ExportExerciseTcxResponse>(
                    service, METHODID_EXPORT_EXERCISE_TCX)))
        .build();
  }

  private abstract static class DataPointsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataPointsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devicesandservices.health.v4.DataPointsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataPointsService");
    }
  }

  private static final class DataPointsServiceFileDescriptorSupplier
      extends DataPointsServiceBaseDescriptorSupplier {
    DataPointsServiceFileDescriptorSupplier() {}
  }

  private static final class DataPointsServiceMethodDescriptorSupplier
      extends DataPointsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataPointsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataPointsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataPointsServiceFileDescriptorSupplier())
                      .addMethod(getGetDataPointMethod())
                      .addMethod(getListDataPointsMethod())
                      .addMethod(getCreateDataPointMethod())
                      .addMethod(getUpdateDataPointMethod())
                      .addMethod(getBatchDeleteDataPointsMethod())
                      .addMethod(getReconcileDataPointsMethod())
                      .addMethod(getRollUpDataPointsMethod())
                      .addMethod(getDailyRollUpDataPointsMethod())
                      .addMethod(getExportExerciseTcxMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
