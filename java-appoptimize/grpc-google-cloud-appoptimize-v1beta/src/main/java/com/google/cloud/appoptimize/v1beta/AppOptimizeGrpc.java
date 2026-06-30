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
package com.google.cloud.appoptimize.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing and querying optimization reports.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AppOptimizeGrpc {

  private AppOptimizeGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.appoptimize.v1beta.AppOptimize";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.CreateReportRequest, com.google.longrunning.Operation>
      getCreateReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReport",
      requestType = com.google.cloud.appoptimize.v1beta.CreateReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.CreateReportRequest, com.google.longrunning.Operation>
      getCreateReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.appoptimize.v1beta.CreateReportRequest,
            com.google.longrunning.Operation>
        getCreateReportMethod;
    if ((getCreateReportMethod = AppOptimizeGrpc.getCreateReportMethod) == null) {
      synchronized (AppOptimizeGrpc.class) {
        if ((getCreateReportMethod = AppOptimizeGrpc.getCreateReportMethod) == null) {
          AppOptimizeGrpc.getCreateReportMethod =
              getCreateReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.appoptimize.v1beta.CreateReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.CreateReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AppOptimizeMethodDescriptorSupplier("CreateReport"))
                      .build();
        }
      }
    }
    return getCreateReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.GetReportRequest,
          com.google.cloud.appoptimize.v1beta.Report>
      getGetReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReport",
      requestType = com.google.cloud.appoptimize.v1beta.GetReportRequest.class,
      responseType = com.google.cloud.appoptimize.v1beta.Report.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.GetReportRequest,
          com.google.cloud.appoptimize.v1beta.Report>
      getGetReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.appoptimize.v1beta.GetReportRequest,
            com.google.cloud.appoptimize.v1beta.Report>
        getGetReportMethod;
    if ((getGetReportMethod = AppOptimizeGrpc.getGetReportMethod) == null) {
      synchronized (AppOptimizeGrpc.class) {
        if ((getGetReportMethod = AppOptimizeGrpc.getGetReportMethod) == null) {
          AppOptimizeGrpc.getGetReportMethod =
              getGetReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.appoptimize.v1beta.GetReportRequest,
                          com.google.cloud.appoptimize.v1beta.Report>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.GetReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.Report.getDefaultInstance()))
                      .setSchemaDescriptor(new AppOptimizeMethodDescriptorSupplier("GetReport"))
                      .build();
        }
      }
    }
    return getGetReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.ListReportsRequest,
          com.google.cloud.appoptimize.v1beta.ListReportsResponse>
      getListReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReports",
      requestType = com.google.cloud.appoptimize.v1beta.ListReportsRequest.class,
      responseType = com.google.cloud.appoptimize.v1beta.ListReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.ListReportsRequest,
          com.google.cloud.appoptimize.v1beta.ListReportsResponse>
      getListReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.appoptimize.v1beta.ListReportsRequest,
            com.google.cloud.appoptimize.v1beta.ListReportsResponse>
        getListReportsMethod;
    if ((getListReportsMethod = AppOptimizeGrpc.getListReportsMethod) == null) {
      synchronized (AppOptimizeGrpc.class) {
        if ((getListReportsMethod = AppOptimizeGrpc.getListReportsMethod) == null) {
          AppOptimizeGrpc.getListReportsMethod =
              getListReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.appoptimize.v1beta.ListReportsRequest,
                          com.google.cloud.appoptimize.v1beta.ListReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.ListReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.ListReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AppOptimizeMethodDescriptorSupplier("ListReports"))
                      .build();
        }
      }
    }
    return getListReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.DeleteReportRequest, com.google.protobuf.Empty>
      getDeleteReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReport",
      requestType = com.google.cloud.appoptimize.v1beta.DeleteReportRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.DeleteReportRequest, com.google.protobuf.Empty>
      getDeleteReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.appoptimize.v1beta.DeleteReportRequest, com.google.protobuf.Empty>
        getDeleteReportMethod;
    if ((getDeleteReportMethod = AppOptimizeGrpc.getDeleteReportMethod) == null) {
      synchronized (AppOptimizeGrpc.class) {
        if ((getDeleteReportMethod = AppOptimizeGrpc.getDeleteReportMethod) == null) {
          AppOptimizeGrpc.getDeleteReportMethod =
              getDeleteReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.appoptimize.v1beta.DeleteReportRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.DeleteReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new AppOptimizeMethodDescriptorSupplier("DeleteReport"))
                      .build();
        }
      }
    }
    return getDeleteReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.ReadReportRequest,
          com.google.cloud.appoptimize.v1beta.ReadReportResponse>
      getReadReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadReport",
      requestType = com.google.cloud.appoptimize.v1beta.ReadReportRequest.class,
      responseType = com.google.cloud.appoptimize.v1beta.ReadReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.appoptimize.v1beta.ReadReportRequest,
          com.google.cloud.appoptimize.v1beta.ReadReportResponse>
      getReadReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.appoptimize.v1beta.ReadReportRequest,
            com.google.cloud.appoptimize.v1beta.ReadReportResponse>
        getReadReportMethod;
    if ((getReadReportMethod = AppOptimizeGrpc.getReadReportMethod) == null) {
      synchronized (AppOptimizeGrpc.class) {
        if ((getReadReportMethod = AppOptimizeGrpc.getReadReportMethod) == null) {
          AppOptimizeGrpc.getReadReportMethod =
              getReadReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.appoptimize.v1beta.ReadReportRequest,
                          com.google.cloud.appoptimize.v1beta.ReadReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.ReadReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.appoptimize.v1beta.ReadReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AppOptimizeMethodDescriptorSupplier("ReadReport"))
                      .build();
        }
      }
    }
    return getReadReportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AppOptimizeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppOptimizeStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppOptimizeStub>() {
          @java.lang.Override
          public AppOptimizeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppOptimizeStub(channel, callOptions);
          }
        };
    return AppOptimizeStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AppOptimizeBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppOptimizeBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppOptimizeBlockingV2Stub>() {
          @java.lang.Override
          public AppOptimizeBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppOptimizeBlockingV2Stub(channel, callOptions);
          }
        };
    return AppOptimizeBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppOptimizeBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppOptimizeBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppOptimizeBlockingStub>() {
          @java.lang.Override
          public AppOptimizeBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppOptimizeBlockingStub(channel, callOptions);
          }
        };
    return AppOptimizeBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AppOptimizeFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppOptimizeFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppOptimizeFutureStub>() {
          @java.lang.Override
          public AppOptimizeFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppOptimizeFutureStub(channel, callOptions);
          }
        };
    return AppOptimizeFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing and querying optimization reports.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new report.
     * This initiates a long-running operation that, upon completion, results
     * in a report resource. Once the report is created, its results can be read
     * via `ReadReport`.
     * </pre>
     */
    default void createReport(
        com.google.cloud.appoptimize.v1beta.CreateReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a report configuration.
     * </pre>
     */
    default void getReport(
        com.google.cloud.appoptimize.v1beta.GetReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.Report> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reports within a given project.
     * </pre>
     */
    default void listReports(
        com.google.cloud.appoptimize.v1beta.ListReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.ListReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified report.
     * </pre>
     */
    default void deleteReport(
        com.google.cloud.appoptimize.v1beta.DeleteReportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads data within a specified report.
     * </pre>
     */
    default void readReport(
        com.google.cloud.appoptimize.v1beta.ReadReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.ReadReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadReportMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AppOptimize.
   *
   * <pre>
   * Service for managing and querying optimization reports.
   * </pre>
   */
  public abstract static class AppOptimizeImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AppOptimizeGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AppOptimize.
   *
   * <pre>
   * Service for managing and querying optimization reports.
   * </pre>
   */
  public static final class AppOptimizeStub
      extends io.grpc.stub.AbstractAsyncStub<AppOptimizeStub> {
    private AppOptimizeStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppOptimizeStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppOptimizeStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new report.
     * This initiates a long-running operation that, upon completion, results
     * in a report resource. Once the report is created, its results can be read
     * via `ReadReport`.
     * </pre>
     */
    public void createReport(
        com.google.cloud.appoptimize.v1beta.CreateReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a report configuration.
     * </pre>
     */
    public void getReport(
        com.google.cloud.appoptimize.v1beta.GetReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.Report> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reports within a given project.
     * </pre>
     */
    public void listReports(
        com.google.cloud.appoptimize.v1beta.ListReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.ListReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified report.
     * </pre>
     */
    public void deleteReport(
        com.google.cloud.appoptimize.v1beta.DeleteReportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads data within a specified report.
     * </pre>
     */
    public void readReport(
        com.google.cloud.appoptimize.v1beta.ReadReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.ReadReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadReportMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AppOptimize.
   *
   * <pre>
   * Service for managing and querying optimization reports.
   * </pre>
   */
  public static final class AppOptimizeBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AppOptimizeBlockingV2Stub> {
    private AppOptimizeBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppOptimizeBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppOptimizeBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new report.
     * This initiates a long-running operation that, upon completion, results
     * in a report resource. Once the report is created, its results can be read
     * via `ReadReport`.
     * </pre>
     */
    public com.google.longrunning.Operation createReport(
        com.google.cloud.appoptimize.v1beta.CreateReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a report configuration.
     * </pre>
     */
    public com.google.cloud.appoptimize.v1beta.Report getReport(
        com.google.cloud.appoptimize.v1beta.GetReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reports within a given project.
     * </pre>
     */
    public com.google.cloud.appoptimize.v1beta.ListReportsResponse listReports(
        com.google.cloud.appoptimize.v1beta.ListReportsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified report.
     * </pre>
     */
    public com.google.protobuf.Empty deleteReport(
        com.google.cloud.appoptimize.v1beta.DeleteReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads data within a specified report.
     * </pre>
     */
    public com.google.cloud.appoptimize.v1beta.ReadReportResponse readReport(
        com.google.cloud.appoptimize.v1beta.ReadReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReadReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AppOptimize.
   *
   * <pre>
   * Service for managing and querying optimization reports.
   * </pre>
   */
  public static final class AppOptimizeBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AppOptimizeBlockingStub> {
    private AppOptimizeBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppOptimizeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppOptimizeBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new report.
     * This initiates a long-running operation that, upon completion, results
     * in a report resource. Once the report is created, its results can be read
     * via `ReadReport`.
     * </pre>
     */
    public com.google.longrunning.Operation createReport(
        com.google.cloud.appoptimize.v1beta.CreateReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a report configuration.
     * </pre>
     */
    public com.google.cloud.appoptimize.v1beta.Report getReport(
        com.google.cloud.appoptimize.v1beta.GetReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reports within a given project.
     * </pre>
     */
    public com.google.cloud.appoptimize.v1beta.ListReportsResponse listReports(
        com.google.cloud.appoptimize.v1beta.ListReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified report.
     * </pre>
     */
    public com.google.protobuf.Empty deleteReport(
        com.google.cloud.appoptimize.v1beta.DeleteReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads data within a specified report.
     * </pre>
     */
    public com.google.cloud.appoptimize.v1beta.ReadReportResponse readReport(
        com.google.cloud.appoptimize.v1beta.ReadReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AppOptimize.
   *
   * <pre>
   * Service for managing and querying optimization reports.
   * </pre>
   */
  public static final class AppOptimizeFutureStub
      extends io.grpc.stub.AbstractFutureStub<AppOptimizeFutureStub> {
    private AppOptimizeFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppOptimizeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppOptimizeFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new report.
     * This initiates a long-running operation that, upon completion, results
     * in a report resource. Once the report is created, its results can be read
     * via `ReadReport`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReport(com.google.cloud.appoptimize.v1beta.CreateReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a report configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.appoptimize.v1beta.Report>
        getReport(com.google.cloud.appoptimize.v1beta.GetReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reports within a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.appoptimize.v1beta.ListReportsResponse>
        listReports(com.google.cloud.appoptimize.v1beta.ListReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteReport(com.google.cloud.appoptimize.v1beta.DeleteReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reads data within a specified report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.appoptimize.v1beta.ReadReportResponse>
        readReport(com.google.cloud.appoptimize.v1beta.ReadReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_REPORT = 0;
  private static final int METHODID_GET_REPORT = 1;
  private static final int METHODID_LIST_REPORTS = 2;
  private static final int METHODID_DELETE_REPORT = 3;
  private static final int METHODID_READ_REPORT = 4;

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
        case METHODID_CREATE_REPORT:
          serviceImpl.createReport(
              (com.google.cloud.appoptimize.v1beta.CreateReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_REPORT:
          serviceImpl.getReport(
              (com.google.cloud.appoptimize.v1beta.GetReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.Report>)
                  responseObserver);
          break;
        case METHODID_LIST_REPORTS:
          serviceImpl.listReports(
              (com.google.cloud.appoptimize.v1beta.ListReportsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.ListReportsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_REPORT:
          serviceImpl.deleteReport(
              (com.google.cloud.appoptimize.v1beta.DeleteReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_READ_REPORT:
          serviceImpl.readReport(
              (com.google.cloud.appoptimize.v1beta.ReadReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.appoptimize.v1beta.ReadReportResponse>)
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
            getCreateReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.appoptimize.v1beta.CreateReportRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPORT)))
        .addMethod(
            getGetReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.appoptimize.v1beta.GetReportRequest,
                    com.google.cloud.appoptimize.v1beta.Report>(service, METHODID_GET_REPORT)))
        .addMethod(
            getListReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.appoptimize.v1beta.ListReportsRequest,
                    com.google.cloud.appoptimize.v1beta.ListReportsResponse>(
                    service, METHODID_LIST_REPORTS)))
        .addMethod(
            getDeleteReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.appoptimize.v1beta.DeleteReportRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_REPORT)))
        .addMethod(
            getReadReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.appoptimize.v1beta.ReadReportRequest,
                    com.google.cloud.appoptimize.v1beta.ReadReportResponse>(
                    service, METHODID_READ_REPORT)))
        .build();
  }

  private abstract static class AppOptimizeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppOptimizeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.appoptimize.v1beta.AppOptimizeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppOptimize");
    }
  }

  private static final class AppOptimizeFileDescriptorSupplier
      extends AppOptimizeBaseDescriptorSupplier {
    AppOptimizeFileDescriptorSupplier() {}
  }

  private static final class AppOptimizeMethodDescriptorSupplier
      extends AppOptimizeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AppOptimizeMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AppOptimizeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AppOptimizeFileDescriptorSupplier())
                      .addMethod(getCreateReportMethod())
                      .addMethod(getGetReportMethod())
                      .addMethod(getListReportsMethod())
                      .addMethod(getDeleteReportMethod())
                      .addMethod(getReadReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
