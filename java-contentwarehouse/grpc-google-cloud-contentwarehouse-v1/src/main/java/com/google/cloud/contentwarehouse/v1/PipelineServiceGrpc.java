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
package com.google.cloud.contentwarehouse.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service lets you manage pipelines.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/contentwarehouse/v1/pipeline_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PipelineServiceGrpc {

  private PipelineServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.contentwarehouse.v1.PipelineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.RunPipelineRequest, com.google.longrunning.Operation>
      getRunPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunPipeline",
      requestType = com.google.cloud.contentwarehouse.v1.RunPipelineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.RunPipelineRequest, com.google.longrunning.Operation>
      getRunPipelineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.RunPipelineRequest,
            com.google.longrunning.Operation>
        getRunPipelineMethod;
    if ((getRunPipelineMethod = PipelineServiceGrpc.getRunPipelineMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getRunPipelineMethod = PipelineServiceGrpc.getRunPipelineMethod) == null) {
          PipelineServiceGrpc.getRunPipelineMethod =
              getRunPipelineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.RunPipelineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunPipeline"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.RunPipelineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PipelineServiceMethodDescriptorSupplier("RunPipeline"))
                      .build();
        }
      }
    }
    return getRunPipelineMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PipelineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PipelineServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PipelineServiceStub>() {
          @java.lang.Override
          public PipelineServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PipelineServiceStub(channel, callOptions);
          }
        };
    return PipelineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PipelineServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PipelineServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PipelineServiceBlockingStub>() {
          @java.lang.Override
          public PipelineServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PipelineServiceBlockingStub(channel, callOptions);
          }
        };
    return PipelineServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PipelineServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PipelineServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PipelineServiceFutureStub>() {
          @java.lang.Override
          public PipelineServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PipelineServiceFutureStub(channel, callOptions);
          }
        };
    return PipelineServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service lets you manage pipelines.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Run a predefined pipeline.
     * </pre>
     */
    default void runPipeline(
        com.google.cloud.contentwarehouse.v1.RunPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunPipelineMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PipelineService.
   *
   * <pre>
   * This service lets you manage pipelines.
   * </pre>
   */
  public abstract static class PipelineServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PipelineServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PipelineService.
   *
   * <pre>
   * This service lets you manage pipelines.
   * </pre>
   */
  public static final class PipelineServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PipelineServiceStub> {
    private PipelineServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipelineServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PipelineServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Run a predefined pipeline.
     * </pre>
     */
    public void runPipeline(
        com.google.cloud.contentwarehouse.v1.RunPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunPipelineMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PipelineService.
   *
   * <pre>
   * This service lets you manage pipelines.
   * </pre>
   */
  public static final class PipelineServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PipelineServiceBlockingStub> {
    private PipelineServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipelineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PipelineServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Run a predefined pipeline.
     * </pre>
     */
    public com.google.longrunning.Operation runPipeline(
        com.google.cloud.contentwarehouse.v1.RunPipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunPipelineMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PipelineService.
   *
   * <pre>
   * This service lets you manage pipelines.
   * </pre>
   */
  public static final class PipelineServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PipelineServiceFutureStub> {
    private PipelineServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipelineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PipelineServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Run a predefined pipeline.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runPipeline(com.google.cloud.contentwarehouse.v1.RunPipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunPipelineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_PIPELINE = 0;

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
        case METHODID_RUN_PIPELINE:
          serviceImpl.runPipeline(
              (com.google.cloud.contentwarehouse.v1.RunPipelineRequest) request,
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
            getRunPipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contentwarehouse.v1.RunPipelineRequest,
                    com.google.longrunning.Operation>(service, METHODID_RUN_PIPELINE)))
        .build();
  }

  private abstract static class PipelineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PipelineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.contentwarehouse.v1.PipelineServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PipelineService");
    }
  }

  private static final class PipelineServiceFileDescriptorSupplier
      extends PipelineServiceBaseDescriptorSupplier {
    PipelineServiceFileDescriptorSupplier() {}
  }

  private static final class PipelineServiceMethodDescriptorSupplier
      extends PipelineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PipelineServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PipelineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PipelineServiceFileDescriptorSupplier())
                      .addMethod(getRunPipelineMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
