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
package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Run Build Control Plane API
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/run/v2/build.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BuildsGrpc {

  private BuildsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.run.v2.Builds";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.SubmitBuildRequest, com.google.cloud.run.v2.SubmitBuildResponse>
      getSubmitBuildMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitBuild",
      requestType = com.google.cloud.run.v2.SubmitBuildRequest.class,
      responseType = com.google.cloud.run.v2.SubmitBuildResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.SubmitBuildRequest, com.google.cloud.run.v2.SubmitBuildResponse>
      getSubmitBuildMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.SubmitBuildRequest, com.google.cloud.run.v2.SubmitBuildResponse>
        getSubmitBuildMethod;
    if ((getSubmitBuildMethod = BuildsGrpc.getSubmitBuildMethod) == null) {
      synchronized (BuildsGrpc.class) {
        if ((getSubmitBuildMethod = BuildsGrpc.getSubmitBuildMethod) == null) {
          BuildsGrpc.getSubmitBuildMethod =
              getSubmitBuildMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.SubmitBuildRequest,
                          com.google.cloud.run.v2.SubmitBuildResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitBuild"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.SubmitBuildRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.SubmitBuildResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BuildsMethodDescriptorSupplier("SubmitBuild"))
                      .build();
        }
      }
    }
    return getSubmitBuildMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BuildsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BuildsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BuildsStub>() {
          @java.lang.Override
          public BuildsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BuildsStub(channel, callOptions);
          }
        };
    return BuildsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BuildsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BuildsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BuildsBlockingStub>() {
          @java.lang.Override
          public BuildsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BuildsBlockingStub(channel, callOptions);
          }
        };
    return BuildsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BuildsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BuildsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BuildsFutureStub>() {
          @java.lang.Override
          public BuildsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BuildsFutureStub(channel, callOptions);
          }
        };
    return BuildsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Build Control Plane API
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Submits a build in a given project.
     * </pre>
     */
    default void submitBuild(
        com.google.cloud.run.v2.SubmitBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.SubmitBuildResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSubmitBuildMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Builds.
   *
   * <pre>
   * Cloud Run Build Control Plane API
   * </pre>
   */
  public abstract static class BuildsImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BuildsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Builds.
   *
   * <pre>
   * Cloud Run Build Control Plane API
   * </pre>
   */
  public static final class BuildsStub extends io.grpc.stub.AbstractAsyncStub<BuildsStub> {
    private BuildsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BuildsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BuildsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Submits a build in a given project.
     * </pre>
     */
    public void submitBuild(
        com.google.cloud.run.v2.SubmitBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.SubmitBuildResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitBuildMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Builds.
   *
   * <pre>
   * Cloud Run Build Control Plane API
   * </pre>
   */
  public static final class BuildsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BuildsBlockingStub> {
    private BuildsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BuildsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BuildsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Submits a build in a given project.
     * </pre>
     */
    public com.google.cloud.run.v2.SubmitBuildResponse submitBuild(
        com.google.cloud.run.v2.SubmitBuildRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitBuildMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Builds.
   *
   * <pre>
   * Cloud Run Build Control Plane API
   * </pre>
   */
  public static final class BuildsFutureStub
      extends io.grpc.stub.AbstractFutureStub<BuildsFutureStub> {
    private BuildsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BuildsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BuildsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Submits a build in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.SubmitBuildResponse>
        submitBuild(com.google.cloud.run.v2.SubmitBuildRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitBuildMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBMIT_BUILD = 0;

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
        case METHODID_SUBMIT_BUILD:
          serviceImpl.submitBuild(
              (com.google.cloud.run.v2.SubmitBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.SubmitBuildResponse>)
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
            getSubmitBuildMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.SubmitBuildRequest,
                    com.google.cloud.run.v2.SubmitBuildResponse>(service, METHODID_SUBMIT_BUILD)))
        .build();
  }

  private abstract static class BuildsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BuildsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.BuildProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Builds");
    }
  }

  private static final class BuildsFileDescriptorSupplier extends BuildsBaseDescriptorSupplier {
    BuildsFileDescriptorSupplier() {}
  }

  private static final class BuildsMethodDescriptorSupplier extends BuildsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BuildsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BuildsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BuildsFileDescriptorSupplier())
                      .addMethod(getSubmitBuildMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
