/*
 * Copyright 2025 Google LLC
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
package com.google.dataflow.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Dataflow Metrics API lets you monitor the progress of Dataflow
 * jobs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/dataflow/v1beta3/metrics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetricsV1Beta3Grpc {

  private MetricsV1Beta3Grpc() {}

  public static final java.lang.String SERVICE_NAME = "google.dataflow.v1beta3.MetricsV1Beta3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.GetJobMetricsRequest, com.google.dataflow.v1beta3.JobMetrics>
      getGetJobMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJobMetrics",
      requestType = com.google.dataflow.v1beta3.GetJobMetricsRequest.class,
      responseType = com.google.dataflow.v1beta3.JobMetrics.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.GetJobMetricsRequest, com.google.dataflow.v1beta3.JobMetrics>
      getGetJobMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.dataflow.v1beta3.GetJobMetricsRequest,
            com.google.dataflow.v1beta3.JobMetrics>
        getGetJobMetricsMethod;
    if ((getGetJobMetricsMethod = MetricsV1Beta3Grpc.getGetJobMetricsMethod) == null) {
      synchronized (MetricsV1Beta3Grpc.class) {
        if ((getGetJobMetricsMethod = MetricsV1Beta3Grpc.getGetJobMetricsMethod) == null) {
          MetricsV1Beta3Grpc.getGetJobMetricsMethod =
              getGetJobMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.dataflow.v1beta3.GetJobMetricsRequest,
                          com.google.dataflow.v1beta3.JobMetrics>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJobMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.GetJobMetricsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.JobMetrics.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsV1Beta3MethodDescriptorSupplier("GetJobMetrics"))
                      .build();
        }
      }
    }
    return getGetJobMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest,
          com.google.dataflow.v1beta3.JobExecutionDetails>
      getGetJobExecutionDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJobExecutionDetails",
      requestType = com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest.class,
      responseType = com.google.dataflow.v1beta3.JobExecutionDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest,
          com.google.dataflow.v1beta3.JobExecutionDetails>
      getGetJobExecutionDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest,
            com.google.dataflow.v1beta3.JobExecutionDetails>
        getGetJobExecutionDetailsMethod;
    if ((getGetJobExecutionDetailsMethod = MetricsV1Beta3Grpc.getGetJobExecutionDetailsMethod)
        == null) {
      synchronized (MetricsV1Beta3Grpc.class) {
        if ((getGetJobExecutionDetailsMethod = MetricsV1Beta3Grpc.getGetJobExecutionDetailsMethod)
            == null) {
          MetricsV1Beta3Grpc.getGetJobExecutionDetailsMethod =
              getGetJobExecutionDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest,
                          com.google.dataflow.v1beta3.JobExecutionDetails>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetJobExecutionDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.JobExecutionDetails.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsV1Beta3MethodDescriptorSupplier("GetJobExecutionDetails"))
                      .build();
        }
      }
    }
    return getGetJobExecutionDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest,
          com.google.dataflow.v1beta3.StageExecutionDetails>
      getGetStageExecutionDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStageExecutionDetails",
      requestType = com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest.class,
      responseType = com.google.dataflow.v1beta3.StageExecutionDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest,
          com.google.dataflow.v1beta3.StageExecutionDetails>
      getGetStageExecutionDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest,
            com.google.dataflow.v1beta3.StageExecutionDetails>
        getGetStageExecutionDetailsMethod;
    if ((getGetStageExecutionDetailsMethod = MetricsV1Beta3Grpc.getGetStageExecutionDetailsMethod)
        == null) {
      synchronized (MetricsV1Beta3Grpc.class) {
        if ((getGetStageExecutionDetailsMethod =
                MetricsV1Beta3Grpc.getGetStageExecutionDetailsMethod)
            == null) {
          MetricsV1Beta3Grpc.getGetStageExecutionDetailsMethod =
              getGetStageExecutionDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest,
                          com.google.dataflow.v1beta3.StageExecutionDetails>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetStageExecutionDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.dataflow.v1beta3.StageExecutionDetails
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsV1Beta3MethodDescriptorSupplier("GetStageExecutionDetails"))
                      .build();
        }
      }
    }
    return getGetStageExecutionDetailsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MetricsV1Beta3Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsV1Beta3Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetricsV1Beta3Stub>() {
          @java.lang.Override
          public MetricsV1Beta3Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetricsV1Beta3Stub(channel, callOptions);
          }
        };
    return MetricsV1Beta3Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetricsV1Beta3BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsV1Beta3BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetricsV1Beta3BlockingStub>() {
          @java.lang.Override
          public MetricsV1Beta3BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetricsV1Beta3BlockingStub(channel, callOptions);
          }
        };
    return MetricsV1Beta3BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MetricsV1Beta3FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsV1Beta3FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetricsV1Beta3FutureStub>() {
          @java.lang.Override
          public MetricsV1Beta3FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetricsV1Beta3FutureStub(channel, callOptions);
          }
        };
    return MetricsV1Beta3FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Dataflow Metrics API lets you monitor the progress of Dataflow
   * jobs.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.getMetrics` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.getMetrics` is not recommended, as you can only request the
     * status of jobs that are running in `us-central1`.
     * </pre>
     */
    default void getJobMetrics(
        com.google.dataflow.v1beta3.GetJobMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.JobMetrics> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetJobMetricsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of the job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    default void getJobExecutionDetails(
        com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.JobExecutionDetails>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetJobExecutionDetailsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of a stage of the
     * job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    default void getStageExecutionDetails(
        com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.StageExecutionDetails>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStageExecutionDetailsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MetricsV1Beta3.
   *
   * <pre>
   * The Dataflow Metrics API lets you monitor the progress of Dataflow
   * jobs.
   * </pre>
   */
  public abstract static class MetricsV1Beta3ImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MetricsV1Beta3Grpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MetricsV1Beta3.
   *
   * <pre>
   * The Dataflow Metrics API lets you monitor the progress of Dataflow
   * jobs.
   * </pre>
   */
  public static final class MetricsV1Beta3Stub
      extends io.grpc.stub.AbstractAsyncStub<MetricsV1Beta3Stub> {
    private MetricsV1Beta3Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsV1Beta3Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsV1Beta3Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.getMetrics` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.getMetrics` is not recommended, as you can only request the
     * status of jobs that are running in `us-central1`.
     * </pre>
     */
    public void getJobMetrics(
        com.google.dataflow.v1beta3.GetJobMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.JobMetrics> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMetricsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of the job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    public void getJobExecutionDetails(
        com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.JobExecutionDetails>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobExecutionDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of a stage of the
     * job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    public void getStageExecutionDetails(
        com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.StageExecutionDetails>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStageExecutionDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MetricsV1Beta3.
   *
   * <pre>
   * The Dataflow Metrics API lets you monitor the progress of Dataflow
   * jobs.
   * </pre>
   */
  public static final class MetricsV1Beta3BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MetricsV1Beta3BlockingStub> {
    private MetricsV1Beta3BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsV1Beta3BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsV1Beta3BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.getMetrics` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.getMetrics` is not recommended, as you can only request the
     * status of jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.dataflow.v1beta3.JobMetrics getJobMetrics(
        com.google.dataflow.v1beta3.GetJobMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMetricsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of the job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    public com.google.dataflow.v1beta3.JobExecutionDetails getJobExecutionDetails(
        com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobExecutionDetailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of a stage of the
     * job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    public com.google.dataflow.v1beta3.StageExecutionDetails getStageExecutionDetails(
        com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStageExecutionDetailsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MetricsV1Beta3.
   *
   * <pre>
   * The Dataflow Metrics API lets you monitor the progress of Dataflow
   * jobs.
   * </pre>
   */
  public static final class MetricsV1Beta3FutureStub
      extends io.grpc.stub.AbstractFutureStub<MetricsV1Beta3FutureStub> {
    private MetricsV1Beta3FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsV1Beta3FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsV1Beta3FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Request the job status.
     * To request the status of a job, we recommend using
     * `projects.locations.jobs.getMetrics` with a [regional endpoint]
     * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
     * `projects.jobs.getMetrics` is not recommended, as you can only request the
     * status of jobs that are running in `us-central1`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.dataflow.v1beta3.JobMetrics>
        getJobMetrics(com.google.dataflow.v1beta3.GetJobMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMetricsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of the job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.dataflow.v1beta3.JobExecutionDetails>
        getJobExecutionDetails(com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobExecutionDetailsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Request detailed information about the execution status of a stage of the
     * job.
     * EXPERIMENTAL.  This API is subject to change or removal without notice.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.dataflow.v1beta3.StageExecutionDetails>
        getStageExecutionDetails(
            com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStageExecutionDetailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_JOB_METRICS = 0;
  private static final int METHODID_GET_JOB_EXECUTION_DETAILS = 1;
  private static final int METHODID_GET_STAGE_EXECUTION_DETAILS = 2;

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
        case METHODID_GET_JOB_METRICS:
          serviceImpl.getJobMetrics(
              (com.google.dataflow.v1beta3.GetJobMetricsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.JobMetrics>)
                  responseObserver);
          break;
        case METHODID_GET_JOB_EXECUTION_DETAILS:
          serviceImpl.getJobExecutionDetails(
              (com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.JobExecutionDetails>)
                  responseObserver);
          break;
        case METHODID_GET_STAGE_EXECUTION_DETAILS:
          serviceImpl.getStageExecutionDetails(
              (com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.dataflow.v1beta3.StageExecutionDetails>)
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
            getGetJobMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.dataflow.v1beta3.GetJobMetricsRequest,
                    com.google.dataflow.v1beta3.JobMetrics>(service, METHODID_GET_JOB_METRICS)))
        .addMethod(
            getGetJobExecutionDetailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest,
                    com.google.dataflow.v1beta3.JobExecutionDetails>(
                    service, METHODID_GET_JOB_EXECUTION_DETAILS)))
        .addMethod(
            getGetStageExecutionDetailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest,
                    com.google.dataflow.v1beta3.StageExecutionDetails>(
                    service, METHODID_GET_STAGE_EXECUTION_DETAILS)))
        .build();
  }

  private abstract static class MetricsV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetricsV1Beta3BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.dataflow.v1beta3.MetricsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetricsV1Beta3");
    }
  }

  private static final class MetricsV1Beta3FileDescriptorSupplier
      extends MetricsV1Beta3BaseDescriptorSupplier {
    MetricsV1Beta3FileDescriptorSupplier() {}
  }

  private static final class MetricsV1Beta3MethodDescriptorSupplier
      extends MetricsV1Beta3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MetricsV1Beta3MethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MetricsV1Beta3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MetricsV1Beta3FileDescriptorSupplier())
                      .addMethod(getGetJobMetricsMethod())
                      .addMethod(getGetJobExecutionDetailsMethod())
                      .addMethod(getGetStageExecutionDetailsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
