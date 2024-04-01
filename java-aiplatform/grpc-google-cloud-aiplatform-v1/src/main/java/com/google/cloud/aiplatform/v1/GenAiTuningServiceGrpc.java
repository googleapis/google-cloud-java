/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for creating and managing GenAI Tuning Jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/genai_tuning_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GenAiTuningServiceGrpc {

  private GenAiTuningServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1.GenAiTuningService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateTuningJobRequest,
          com.google.cloud.aiplatform.v1.TuningJob>
      getCreateTuningJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTuningJob",
      requestType = com.google.cloud.aiplatform.v1.CreateTuningJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1.TuningJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateTuningJobRequest,
          com.google.cloud.aiplatform.v1.TuningJob>
      getCreateTuningJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateTuningJobRequest,
            com.google.cloud.aiplatform.v1.TuningJob>
        getCreateTuningJobMethod;
    if ((getCreateTuningJobMethod = GenAiTuningServiceGrpc.getCreateTuningJobMethod) == null) {
      synchronized (GenAiTuningServiceGrpc.class) {
        if ((getCreateTuningJobMethod = GenAiTuningServiceGrpc.getCreateTuningJobMethod) == null) {
          GenAiTuningServiceGrpc.getCreateTuningJobMethod =
              getCreateTuningJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateTuningJobRequest,
                          com.google.cloud.aiplatform.v1.TuningJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTuningJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateTuningJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.TuningJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiTuningServiceMethodDescriptorSupplier("CreateTuningJob"))
                      .build();
        }
      }
    }
    return getCreateTuningJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetTuningJobRequest,
          com.google.cloud.aiplatform.v1.TuningJob>
      getGetTuningJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTuningJob",
      requestType = com.google.cloud.aiplatform.v1.GetTuningJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1.TuningJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetTuningJobRequest,
          com.google.cloud.aiplatform.v1.TuningJob>
      getGetTuningJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetTuningJobRequest,
            com.google.cloud.aiplatform.v1.TuningJob>
        getGetTuningJobMethod;
    if ((getGetTuningJobMethod = GenAiTuningServiceGrpc.getGetTuningJobMethod) == null) {
      synchronized (GenAiTuningServiceGrpc.class) {
        if ((getGetTuningJobMethod = GenAiTuningServiceGrpc.getGetTuningJobMethod) == null) {
          GenAiTuningServiceGrpc.getGetTuningJobMethod =
              getGetTuningJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetTuningJobRequest,
                          com.google.cloud.aiplatform.v1.TuningJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTuningJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetTuningJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.TuningJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiTuningServiceMethodDescriptorSupplier("GetTuningJob"))
                      .build();
        }
      }
    }
    return getGetTuningJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListTuningJobsRequest,
          com.google.cloud.aiplatform.v1.ListTuningJobsResponse>
      getListTuningJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTuningJobs",
      requestType = com.google.cloud.aiplatform.v1.ListTuningJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListTuningJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListTuningJobsRequest,
          com.google.cloud.aiplatform.v1.ListTuningJobsResponse>
      getListTuningJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListTuningJobsRequest,
            com.google.cloud.aiplatform.v1.ListTuningJobsResponse>
        getListTuningJobsMethod;
    if ((getListTuningJobsMethod = GenAiTuningServiceGrpc.getListTuningJobsMethod) == null) {
      synchronized (GenAiTuningServiceGrpc.class) {
        if ((getListTuningJobsMethod = GenAiTuningServiceGrpc.getListTuningJobsMethod) == null) {
          GenAiTuningServiceGrpc.getListTuningJobsMethod =
              getListTuningJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListTuningJobsRequest,
                          com.google.cloud.aiplatform.v1.ListTuningJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTuningJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListTuningJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListTuningJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiTuningServiceMethodDescriptorSupplier("ListTuningJobs"))
                      .build();
        }
      }
    }
    return getListTuningJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CancelTuningJobRequest, com.google.protobuf.Empty>
      getCancelTuningJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelTuningJob",
      requestType = com.google.cloud.aiplatform.v1.CancelTuningJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CancelTuningJobRequest, com.google.protobuf.Empty>
      getCancelTuningJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CancelTuningJobRequest, com.google.protobuf.Empty>
        getCancelTuningJobMethod;
    if ((getCancelTuningJobMethod = GenAiTuningServiceGrpc.getCancelTuningJobMethod) == null) {
      synchronized (GenAiTuningServiceGrpc.class) {
        if ((getCancelTuningJobMethod = GenAiTuningServiceGrpc.getCancelTuningJobMethod) == null) {
          GenAiTuningServiceGrpc.getCancelTuningJobMethod =
              getCancelTuningJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CancelTuningJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelTuningJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CancelTuningJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiTuningServiceMethodDescriptorSupplier("CancelTuningJob"))
                      .build();
        }
      }
    }
    return getCancelTuningJobMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GenAiTuningServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenAiTuningServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenAiTuningServiceStub>() {
          @java.lang.Override
          public GenAiTuningServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenAiTuningServiceStub(channel, callOptions);
          }
        };
    return GenAiTuningServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GenAiTuningServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenAiTuningServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenAiTuningServiceBlockingStub>() {
          @java.lang.Override
          public GenAiTuningServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenAiTuningServiceBlockingStub(channel, callOptions);
          }
        };
    return GenAiTuningServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GenAiTuningServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenAiTuningServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenAiTuningServiceFutureStub>() {
          @java.lang.Override
          public GenAiTuningServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenAiTuningServiceFutureStub(channel, callOptions);
          }
        };
    return GenAiTuningServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for creating and managing GenAI Tuning Jobs.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a TuningJob. A created TuningJob right away will be attempted to
     * be run.
     * </pre>
     */
    default void createTuningJob(
        com.google.cloud.aiplatform.v1.CreateTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TuningJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTuningJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a TuningJob.
     * </pre>
     */
    default void getTuningJob(
        com.google.cloud.aiplatform.v1.GetTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TuningJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTuningJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TuningJobs in a Location.
     * </pre>
     */
    default void listTuningJobs(
        com.google.cloud.aiplatform.v1.ListTuningJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTuningJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTuningJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a TuningJob.
     * Starts asynchronous cancellation on the TuningJob. The server makes a best
     * effort to cancel the job, but success is not guaranteed. Clients can use
     * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation, the
     * TuningJob is not deleted; instead it becomes a job with a
     * [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
     * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
     * `Code.CANCELLED`, and
     * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    default void cancelTuningJob(
        com.google.cloud.aiplatform.v1.CancelTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelTuningJobMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GenAiTuningService.
   *
   * <pre>
   * A service for creating and managing GenAI Tuning Jobs.
   * </pre>
   */
  public abstract static class GenAiTuningServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GenAiTuningServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GenAiTuningService.
   *
   * <pre>
   * A service for creating and managing GenAI Tuning Jobs.
   * </pre>
   */
  public static final class GenAiTuningServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GenAiTuningServiceStub> {
    private GenAiTuningServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenAiTuningServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenAiTuningServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a TuningJob. A created TuningJob right away will be attempted to
     * be run.
     * </pre>
     */
    public void createTuningJob(
        com.google.cloud.aiplatform.v1.CreateTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TuningJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTuningJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a TuningJob.
     * </pre>
     */
    public void getTuningJob(
        com.google.cloud.aiplatform.v1.GetTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TuningJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTuningJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TuningJobs in a Location.
     * </pre>
     */
    public void listTuningJobs(
        com.google.cloud.aiplatform.v1.ListTuningJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTuningJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTuningJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a TuningJob.
     * Starts asynchronous cancellation on the TuningJob. The server makes a best
     * effort to cancel the job, but success is not guaranteed. Clients can use
     * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation, the
     * TuningJob is not deleted; instead it becomes a job with a
     * [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
     * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
     * `Code.CANCELLED`, and
     * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    public void cancelTuningJob(
        com.google.cloud.aiplatform.v1.CancelTuningJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelTuningJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GenAiTuningService.
   *
   * <pre>
   * A service for creating and managing GenAI Tuning Jobs.
   * </pre>
   */
  public static final class GenAiTuningServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GenAiTuningServiceBlockingStub> {
    private GenAiTuningServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenAiTuningServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenAiTuningServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a TuningJob. A created TuningJob right away will be attempted to
     * be run.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.TuningJob createTuningJob(
        com.google.cloud.aiplatform.v1.CreateTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTuningJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a TuningJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.TuningJob getTuningJob(
        com.google.cloud.aiplatform.v1.GetTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTuningJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TuningJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListTuningJobsResponse listTuningJobs(
        com.google.cloud.aiplatform.v1.ListTuningJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTuningJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a TuningJob.
     * Starts asynchronous cancellation on the TuningJob. The server makes a best
     * effort to cancel the job, but success is not guaranteed. Clients can use
     * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation, the
     * TuningJob is not deleted; instead it becomes a job with a
     * [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
     * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
     * `Code.CANCELLED`, and
     * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    public com.google.protobuf.Empty cancelTuningJob(
        com.google.cloud.aiplatform.v1.CancelTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelTuningJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GenAiTuningService.
   *
   * <pre>
   * A service for creating and managing GenAI Tuning Jobs.
   * </pre>
   */
  public static final class GenAiTuningServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GenAiTuningServiceFutureStub> {
    private GenAiTuningServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenAiTuningServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenAiTuningServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a TuningJob. A created TuningJob right away will be attempted to
     * be run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.TuningJob>
        createTuningJob(com.google.cloud.aiplatform.v1.CreateTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTuningJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a TuningJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.TuningJob>
        getTuningJob(com.google.cloud.aiplatform.v1.GetTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTuningJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TuningJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListTuningJobsResponse>
        listTuningJobs(com.google.cloud.aiplatform.v1.ListTuningJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTuningJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a TuningJob.
     * Starts asynchronous cancellation on the TuningJob. The server makes a best
     * effort to cancel the job, but success is not guaranteed. Clients can use
     * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * job completed despite cancellation. On successful cancellation, the
     * TuningJob is not deleted; instead it becomes a job with a
     * [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
     * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
     * `Code.CANCELLED`, and
     * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelTuningJob(com.google.cloud.aiplatform.v1.CancelTuningJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelTuningJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TUNING_JOB = 0;
  private static final int METHODID_GET_TUNING_JOB = 1;
  private static final int METHODID_LIST_TUNING_JOBS = 2;
  private static final int METHODID_CANCEL_TUNING_JOB = 3;

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
        case METHODID_CREATE_TUNING_JOB:
          serviceImpl.createTuningJob(
              (com.google.cloud.aiplatform.v1.CreateTuningJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TuningJob>)
                  responseObserver);
          break;
        case METHODID_GET_TUNING_JOB:
          serviceImpl.getTuningJob(
              (com.google.cloud.aiplatform.v1.GetTuningJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TuningJob>)
                  responseObserver);
          break;
        case METHODID_LIST_TUNING_JOBS:
          serviceImpl.listTuningJobs(
              (com.google.cloud.aiplatform.v1.ListTuningJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTuningJobsResponse>)
                  responseObserver);
          break;
        case METHODID_CANCEL_TUNING_JOB:
          serviceImpl.cancelTuningJob(
              (com.google.cloud.aiplatform.v1.CancelTuningJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getCreateTuningJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.CreateTuningJobRequest,
                    com.google.cloud.aiplatform.v1.TuningJob>(service, METHODID_CREATE_TUNING_JOB)))
        .addMethod(
            getGetTuningJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetTuningJobRequest,
                    com.google.cloud.aiplatform.v1.TuningJob>(service, METHODID_GET_TUNING_JOB)))
        .addMethod(
            getListTuningJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ListTuningJobsRequest,
                    com.google.cloud.aiplatform.v1.ListTuningJobsResponse>(
                    service, METHODID_LIST_TUNING_JOBS)))
        .addMethod(
            getCancelTuningJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.CancelTuningJobRequest,
                    com.google.protobuf.Empty>(service, METHODID_CANCEL_TUNING_JOB)))
        .build();
  }

  private abstract static class GenAiTuningServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GenAiTuningServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.GenAiTuningServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GenAiTuningService");
    }
  }

  private static final class GenAiTuningServiceFileDescriptorSupplier
      extends GenAiTuningServiceBaseDescriptorSupplier {
    GenAiTuningServiceFileDescriptorSupplier() {}
  }

  private static final class GenAiTuningServiceMethodDescriptorSupplier
      extends GenAiTuningServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GenAiTuningServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GenAiTuningServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GenAiTuningServiceFileDescriptorSupplier())
                      .addMethod(getCreateTuningJobMethod())
                      .addMethod(getGetTuningJobMethod())
                      .addMethod(getListTuningJobsMethod())
                      .addMethod(getCancelTuningJobMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
