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
package com.google.cloud.capacityplanner.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides access to historical and forecasted usage data.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class UsageServiceGrpc {

  private UsageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.capacityplanner.v1beta.UsageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest,
          com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>
      getQueryUsageHistoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryUsageHistories",
      requestType = com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest.class,
      responseType = com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest,
          com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>
      getQueryUsageHistoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest,
            com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>
        getQueryUsageHistoriesMethod;
    if ((getQueryUsageHistoriesMethod = UsageServiceGrpc.getQueryUsageHistoriesMethod) == null) {
      synchronized (UsageServiceGrpc.class) {
        if ((getQueryUsageHistoriesMethod = UsageServiceGrpc.getQueryUsageHistoriesMethod)
            == null) {
          UsageServiceGrpc.getQueryUsageHistoriesMethod =
              getQueryUsageHistoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest,
                          com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "QueryUsageHistories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UsageServiceMethodDescriptorSupplier("QueryUsageHistories"))
                      .build();
        }
      }
    }
    return getQueryUsageHistoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest,
          com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>
      getQueryForecastsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryForecasts",
      requestType = com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest.class,
      responseType = com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest,
          com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>
      getQueryForecastsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest,
            com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>
        getQueryForecastsMethod;
    if ((getQueryForecastsMethod = UsageServiceGrpc.getQueryForecastsMethod) == null) {
      synchronized (UsageServiceGrpc.class) {
        if ((getQueryForecastsMethod = UsageServiceGrpc.getQueryForecastsMethod) == null) {
          UsageServiceGrpc.getQueryForecastsMethod =
              getQueryForecastsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest,
                          com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryForecasts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UsageServiceMethodDescriptorSupplier("QueryForecasts"))
                      .build();
        }
      }
    }
    return getQueryForecastsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest,
          com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>
      getQueryReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryReservations",
      requestType = com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest.class,
      responseType = com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest,
          com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>
      getQueryReservationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest,
            com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>
        getQueryReservationsMethod;
    if ((getQueryReservationsMethod = UsageServiceGrpc.getQueryReservationsMethod) == null) {
      synchronized (UsageServiceGrpc.class) {
        if ((getQueryReservationsMethod = UsageServiceGrpc.getQueryReservationsMethod) == null) {
          UsageServiceGrpc.getQueryReservationsMethod =
              getQueryReservationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest,
                          com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryReservations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UsageServiceMethodDescriptorSupplier("QueryReservations"))
                      .build();
        }
      }
    }
    return getQueryReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest,
          com.google.longrunning.Operation>
      getExportUsageHistoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportUsageHistories",
      requestType = com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest,
          com.google.longrunning.Operation>
      getExportUsageHistoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest,
            com.google.longrunning.Operation>
        getExportUsageHistoriesMethod;
    if ((getExportUsageHistoriesMethod = UsageServiceGrpc.getExportUsageHistoriesMethod) == null) {
      synchronized (UsageServiceGrpc.class) {
        if ((getExportUsageHistoriesMethod = UsageServiceGrpc.getExportUsageHistoriesMethod)
            == null) {
          UsageServiceGrpc.getExportUsageHistoriesMethod =
              getExportUsageHistoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportUsageHistories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UsageServiceMethodDescriptorSupplier("ExportUsageHistories"))
                      .build();
        }
      }
    }
    return getExportUsageHistoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest,
          com.google.longrunning.Operation>
      getExportForecastsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportForecasts",
      requestType = com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest,
          com.google.longrunning.Operation>
      getExportForecastsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest,
            com.google.longrunning.Operation>
        getExportForecastsMethod;
    if ((getExportForecastsMethod = UsageServiceGrpc.getExportForecastsMethod) == null) {
      synchronized (UsageServiceGrpc.class) {
        if ((getExportForecastsMethod = UsageServiceGrpc.getExportForecastsMethod) == null) {
          UsageServiceGrpc.getExportForecastsMethod =
              getExportForecastsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportForecasts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UsageServiceMethodDescriptorSupplier("ExportForecasts"))
                      .build();
        }
      }
    }
    return getExportForecastsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest,
          com.google.longrunning.Operation>
      getExportReservationsUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportReservationsUsage",
      requestType = com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest,
          com.google.longrunning.Operation>
      getExportReservationsUsageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest,
            com.google.longrunning.Operation>
        getExportReservationsUsageMethod;
    if ((getExportReservationsUsageMethod = UsageServiceGrpc.getExportReservationsUsageMethod)
        == null) {
      synchronized (UsageServiceGrpc.class) {
        if ((getExportReservationsUsageMethod = UsageServiceGrpc.getExportReservationsUsageMethod)
            == null) {
          UsageServiceGrpc.getExportReservationsUsageMethod =
              getExportReservationsUsageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportReservationsUsage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UsageServiceMethodDescriptorSupplier("ExportReservationsUsage"))
                      .build();
        }
      }
    }
    return getExportReservationsUsageMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UsageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsageServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UsageServiceStub>() {
          @java.lang.Override
          public UsageServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UsageServiceStub(channel, callOptions);
          }
        };
    return UsageServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static UsageServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsageServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UsageServiceBlockingV2Stub>() {
          @java.lang.Override
          public UsageServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UsageServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return UsageServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UsageServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsageServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UsageServiceBlockingStub>() {
          @java.lang.Override
          public UsageServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UsageServiceBlockingStub(channel, callOptions);
          }
        };
    return UsageServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UsageServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsageServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UsageServiceFutureStub>() {
          @java.lang.Override
          public UsageServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UsageServiceFutureStub(channel, callOptions);
          }
        };
    return UsageServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides access to historical and forecasted usage data.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns a list of the usage histories that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    default void queryUsageHistories(
        com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryUsageHistoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the forecasts that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    default void queryForecasts(
        com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryForecastsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the reservations that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    default void queryReservations(
        com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryReservationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports historical usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    default void exportUsageHistories(
        com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportUsageHistoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports forecasted usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    default void exportForecasts(
        com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportForecastsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports reservations usage data requested by user into either an existing
     * Cloud Storage bucket or a new/existing BigQuery table.
     * </pre>
     */
    default void exportReservationsUsage(
        com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportReservationsUsageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UsageService.
   *
   * <pre>
   * Provides access to historical and forecasted usage data.
   * </pre>
   */
  public abstract static class UsageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return UsageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UsageService.
   *
   * <pre>
   * Provides access to historical and forecasted usage data.
   * </pre>
   */
  public static final class UsageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UsageServiceStub> {
    private UsageServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsageServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsageServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the usage histories that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public void queryUsageHistories(
        com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryUsageHistoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the forecasts that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public void queryForecasts(
        com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryForecastsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the reservations that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public void queryReservations(
        com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryReservationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports historical usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public void exportUsageHistories(
        com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportUsageHistoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports forecasted usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public void exportForecasts(
        com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportForecastsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports reservations usage data requested by user into either an existing
     * Cloud Storage bucket or a new/existing BigQuery table.
     * </pre>
     */
    public void exportReservationsUsage(
        com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportReservationsUsageMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UsageService.
   *
   * <pre>
   * Provides access to historical and forecasted usage data.
   * </pre>
   */
  public static final class UsageServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UsageServiceBlockingV2Stub> {
    private UsageServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsageServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsageServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the usage histories that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse queryUsageHistories(
        com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryUsageHistoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the forecasts that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse queryForecasts(
        com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryForecastsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the reservations that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse queryReservations(
        com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryReservationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports historical usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public com.google.longrunning.Operation exportUsageHistories(
        com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportUsageHistoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports forecasted usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public com.google.longrunning.Operation exportForecasts(
        com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportForecastsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports reservations usage data requested by user into either an existing
     * Cloud Storage bucket or a new/existing BigQuery table.
     * </pre>
     */
    public com.google.longrunning.Operation exportReservationsUsage(
        com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportReservationsUsageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service UsageService.
   *
   * <pre>
   * Provides access to historical and forecasted usage data.
   * </pre>
   */
  public static final class UsageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UsageServiceBlockingStub> {
    private UsageServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsageServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the usage histories that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse queryUsageHistories(
        com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryUsageHistoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the forecasts that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse queryForecasts(
        com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryForecastsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the reservations that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse queryReservations(
        com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryReservationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports historical usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public com.google.longrunning.Operation exportUsageHistories(
        com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportUsageHistoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports forecasted usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public com.google.longrunning.Operation exportForecasts(
        com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportForecastsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports reservations usage data requested by user into either an existing
     * Cloud Storage bucket or a new/existing BigQuery table.
     * </pre>
     */
    public com.google.longrunning.Operation exportReservationsUsage(
        com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportReservationsUsageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UsageService.
   *
   * <pre>
   * Provides access to historical and forecasted usage data.
   * </pre>
   */
  public static final class UsageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UsageServiceFutureStub> {
    private UsageServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsageServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the usage histories that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>
        queryUsageHistories(
            com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryUsageHistoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the forecasts that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>
        queryForecasts(com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryForecastsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the reservations that are in the parent parameter
     * and match your specified filters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>
        queryReservations(
            com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryReservationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports historical usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportUsageHistories(
            com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportUsageHistoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports forecasted usage data requested by user into either an existing
     * Cloud Storage bucket or a BigQuery table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportForecasts(com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportForecastsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports reservations usage data requested by user into either an existing
     * Cloud Storage bucket or a new/existing BigQuery table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportReservationsUsage(
            com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportReservationsUsageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_USAGE_HISTORIES = 0;
  private static final int METHODID_QUERY_FORECASTS = 1;
  private static final int METHODID_QUERY_RESERVATIONS = 2;
  private static final int METHODID_EXPORT_USAGE_HISTORIES = 3;
  private static final int METHODID_EXPORT_FORECASTS = 4;
  private static final int METHODID_EXPORT_RESERVATIONS_USAGE = 5;

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
        case METHODID_QUERY_USAGE_HISTORIES:
          serviceImpl.queryUsageHistories(
              (com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_FORECASTS:
          serviceImpl.queryForecasts(
              (com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_RESERVATIONS:
          serviceImpl.queryReservations(
              (com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_USAGE_HISTORIES:
          serviceImpl.exportUsageHistories(
              (com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_FORECASTS:
          serviceImpl.exportForecasts(
              (com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_RESERVATIONS_USAGE:
          serviceImpl.exportReservationsUsage(
              (com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getQueryUsageHistoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest,
                    com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse>(
                    service, METHODID_QUERY_USAGE_HISTORIES)))
        .addMethod(
            getQueryForecastsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest,
                    com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse>(
                    service, METHODID_QUERY_FORECASTS)))
        .addMethod(
            getQueryReservationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest,
                    com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse>(
                    service, METHODID_QUERY_RESERVATIONS)))
        .addMethod(
            getExportUsageHistoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_USAGE_HISTORIES)))
        .addMethod(
            getExportForecastsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_FORECASTS)))
        .addMethod(
            getExportReservationsUsageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_RESERVATIONS_USAGE)))
        .build();
  }

  private abstract static class UsageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UsageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.capacityplanner.v1beta.UsageServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UsageService");
    }
  }

  private static final class UsageServiceFileDescriptorSupplier
      extends UsageServiceBaseDescriptorSupplier {
    UsageServiceFileDescriptorSupplier() {}
  }

  private static final class UsageServiceMethodDescriptorSupplier
      extends UsageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UsageServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UsageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UsageServiceFileDescriptorSupplier())
                      .addMethod(getQueryUsageHistoriesMethod())
                      .addMethod(getQueryForecastsMethod())
                      .addMethod(getQueryReservationsMethod())
                      .addMethod(getExportUsageHistoriesMethod())
                      .addMethod(getExportForecastsMethod())
                      .addMethod(getExportReservationsUsageMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
