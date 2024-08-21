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
package com.google.cloud.apihub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service provides all methods related to the 1p Linter.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apihub/v1/linting_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LintingServiceGrpc {

  private LintingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.apihub.v1.LintingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetStyleGuideRequest, com.google.cloud.apihub.v1.StyleGuide>
      getGetStyleGuideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStyleGuide",
      requestType = com.google.cloud.apihub.v1.GetStyleGuideRequest.class,
      responseType = com.google.cloud.apihub.v1.StyleGuide.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetStyleGuideRequest, com.google.cloud.apihub.v1.StyleGuide>
      getGetStyleGuideMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetStyleGuideRequest, com.google.cloud.apihub.v1.StyleGuide>
        getGetStyleGuideMethod;
    if ((getGetStyleGuideMethod = LintingServiceGrpc.getGetStyleGuideMethod) == null) {
      synchronized (LintingServiceGrpc.class) {
        if ((getGetStyleGuideMethod = LintingServiceGrpc.getGetStyleGuideMethod) == null) {
          LintingServiceGrpc.getGetStyleGuideMethod =
              getGetStyleGuideMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetStyleGuideRequest,
                          com.google.cloud.apihub.v1.StyleGuide>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStyleGuide"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetStyleGuideRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.StyleGuide.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LintingServiceMethodDescriptorSupplier("GetStyleGuide"))
                      .build();
        }
      }
    }
    return getGetStyleGuideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateStyleGuideRequest, com.google.cloud.apihub.v1.StyleGuide>
      getUpdateStyleGuideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStyleGuide",
      requestType = com.google.cloud.apihub.v1.UpdateStyleGuideRequest.class,
      responseType = com.google.cloud.apihub.v1.StyleGuide.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateStyleGuideRequest, com.google.cloud.apihub.v1.StyleGuide>
      getUpdateStyleGuideMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateStyleGuideRequest,
            com.google.cloud.apihub.v1.StyleGuide>
        getUpdateStyleGuideMethod;
    if ((getUpdateStyleGuideMethod = LintingServiceGrpc.getUpdateStyleGuideMethod) == null) {
      synchronized (LintingServiceGrpc.class) {
        if ((getUpdateStyleGuideMethod = LintingServiceGrpc.getUpdateStyleGuideMethod) == null) {
          LintingServiceGrpc.getUpdateStyleGuideMethod =
              getUpdateStyleGuideMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateStyleGuideRequest,
                          com.google.cloud.apihub.v1.StyleGuide>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStyleGuide"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateStyleGuideRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.StyleGuide.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LintingServiceMethodDescriptorSupplier("UpdateStyleGuide"))
                      .build();
        }
      }
    }
    return getUpdateStyleGuideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetStyleGuideContentsRequest,
          com.google.cloud.apihub.v1.StyleGuideContents>
      getGetStyleGuideContentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStyleGuideContents",
      requestType = com.google.cloud.apihub.v1.GetStyleGuideContentsRequest.class,
      responseType = com.google.cloud.apihub.v1.StyleGuideContents.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetStyleGuideContentsRequest,
          com.google.cloud.apihub.v1.StyleGuideContents>
      getGetStyleGuideContentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetStyleGuideContentsRequest,
            com.google.cloud.apihub.v1.StyleGuideContents>
        getGetStyleGuideContentsMethod;
    if ((getGetStyleGuideContentsMethod = LintingServiceGrpc.getGetStyleGuideContentsMethod)
        == null) {
      synchronized (LintingServiceGrpc.class) {
        if ((getGetStyleGuideContentsMethod = LintingServiceGrpc.getGetStyleGuideContentsMethod)
            == null) {
          LintingServiceGrpc.getGetStyleGuideContentsMethod =
              getGetStyleGuideContentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetStyleGuideContentsRequest,
                          com.google.cloud.apihub.v1.StyleGuideContents>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetStyleGuideContents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetStyleGuideContentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.StyleGuideContents.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LintingServiceMethodDescriptorSupplier("GetStyleGuideContents"))
                      .build();
        }
      }
    }
    return getGetStyleGuideContentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.LintSpecRequest, com.google.protobuf.Empty>
      getLintSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LintSpec",
      requestType = com.google.cloud.apihub.v1.LintSpecRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.LintSpecRequest, com.google.protobuf.Empty>
      getLintSpecMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apihub.v1.LintSpecRequest, com.google.protobuf.Empty>
        getLintSpecMethod;
    if ((getLintSpecMethod = LintingServiceGrpc.getLintSpecMethod) == null) {
      synchronized (LintingServiceGrpc.class) {
        if ((getLintSpecMethod = LintingServiceGrpc.getLintSpecMethod) == null) {
          LintingServiceGrpc.getLintSpecMethod =
              getLintSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.LintSpecRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LintSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.LintSpecRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new LintingServiceMethodDescriptorSupplier("LintSpec"))
                      .build();
        }
      }
    }
    return getLintSpecMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LintingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LintingServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LintingServiceStub>() {
          @java.lang.Override
          public LintingServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LintingServiceStub(channel, callOptions);
          }
        };
    return LintingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LintingServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LintingServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LintingServiceBlockingStub>() {
          @java.lang.Override
          public LintingServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LintingServiceBlockingStub(channel, callOptions);
          }
        };
    return LintingServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LintingServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LintingServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LintingServiceFutureStub>() {
          @java.lang.Override
          public LintingServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LintingServiceFutureStub(channel, callOptions);
          }
        };
    return LintingServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service provides all methods related to the 1p Linter.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get the style guide being used for linting.
     * </pre>
     */
    default void getStyleGuide(
        com.google.cloud.apihub.v1.GetStyleGuideRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuide> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStyleGuideMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the styleGuide to be used for liniting in by API hub.
     * </pre>
     */
    default void updateStyleGuide(
        com.google.cloud.apihub.v1.UpdateStyleGuideRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuide> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateStyleGuideMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the contents of the style guide.
     * </pre>
     */
    default void getStyleGuideContents(
        com.google.cloud.apihub.v1.GetStyleGuideContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuideContents>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStyleGuideContentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lints the requested spec and updates the corresponding API Spec with the
     * lint response. This lint response will be available in all subsequent
     * Get and List Spec calls to Core service.
     * </pre>
     */
    default void lintSpec(
        com.google.cloud.apihub.v1.LintSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLintSpecMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LintingService.
   *
   * <pre>
   * This service provides all methods related to the 1p Linter.
   * </pre>
   */
  public abstract static class LintingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LintingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LintingService.
   *
   * <pre>
   * This service provides all methods related to the 1p Linter.
   * </pre>
   */
  public static final class LintingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LintingServiceStub> {
    private LintingServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LintingServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LintingServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the style guide being used for linting.
     * </pre>
     */
    public void getStyleGuide(
        com.google.cloud.apihub.v1.GetStyleGuideRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuide> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStyleGuideMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the styleGuide to be used for liniting in by API hub.
     * </pre>
     */
    public void updateStyleGuide(
        com.google.cloud.apihub.v1.UpdateStyleGuideRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuide> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStyleGuideMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the contents of the style guide.
     * </pre>
     */
    public void getStyleGuideContents(
        com.google.cloud.apihub.v1.GetStyleGuideContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuideContents>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStyleGuideContentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lints the requested spec and updates the corresponding API Spec with the
     * lint response. This lint response will be available in all subsequent
     * Get and List Spec calls to Core service.
     * </pre>
     */
    public void lintSpec(
        com.google.cloud.apihub.v1.LintSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLintSpecMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LintingService.
   *
   * <pre>
   * This service provides all methods related to the 1p Linter.
   * </pre>
   */
  public static final class LintingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LintingServiceBlockingStub> {
    private LintingServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LintingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LintingServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the style guide being used for linting.
     * </pre>
     */
    public com.google.cloud.apihub.v1.StyleGuide getStyleGuide(
        com.google.cloud.apihub.v1.GetStyleGuideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStyleGuideMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the styleGuide to be used for liniting in by API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.StyleGuide updateStyleGuide(
        com.google.cloud.apihub.v1.UpdateStyleGuideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStyleGuideMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the contents of the style guide.
     * </pre>
     */
    public com.google.cloud.apihub.v1.StyleGuideContents getStyleGuideContents(
        com.google.cloud.apihub.v1.GetStyleGuideContentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStyleGuideContentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lints the requested spec and updates the corresponding API Spec with the
     * lint response. This lint response will be available in all subsequent
     * Get and List Spec calls to Core service.
     * </pre>
     */
    public com.google.protobuf.Empty lintSpec(com.google.cloud.apihub.v1.LintSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLintSpecMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LintingService.
   *
   * <pre>
   * This service provides all methods related to the 1p Linter.
   * </pre>
   */
  public static final class LintingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LintingServiceFutureStub> {
    private LintingServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LintingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LintingServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the style guide being used for linting.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.StyleGuide>
        getStyleGuide(com.google.cloud.apihub.v1.GetStyleGuideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStyleGuideMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the styleGuide to be used for liniting in by API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.StyleGuide>
        updateStyleGuide(com.google.cloud.apihub.v1.UpdateStyleGuideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStyleGuideMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the contents of the style guide.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.StyleGuideContents>
        getStyleGuideContents(com.google.cloud.apihub.v1.GetStyleGuideContentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStyleGuideContentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lints the requested spec and updates the corresponding API Spec with the
     * lint response. This lint response will be available in all subsequent
     * Get and List Spec calls to Core service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> lintSpec(
        com.google.cloud.apihub.v1.LintSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLintSpecMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STYLE_GUIDE = 0;
  private static final int METHODID_UPDATE_STYLE_GUIDE = 1;
  private static final int METHODID_GET_STYLE_GUIDE_CONTENTS = 2;
  private static final int METHODID_LINT_SPEC = 3;

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
        case METHODID_GET_STYLE_GUIDE:
          serviceImpl.getStyleGuide(
              (com.google.cloud.apihub.v1.GetStyleGuideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuide>)
                  responseObserver);
          break;
        case METHODID_UPDATE_STYLE_GUIDE:
          serviceImpl.updateStyleGuide(
              (com.google.cloud.apihub.v1.UpdateStyleGuideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuide>)
                  responseObserver);
          break;
        case METHODID_GET_STYLE_GUIDE_CONTENTS:
          serviceImpl.getStyleGuideContents(
              (com.google.cloud.apihub.v1.GetStyleGuideContentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.StyleGuideContents>)
                  responseObserver);
          break;
        case METHODID_LINT_SPEC:
          serviceImpl.lintSpec(
              (com.google.cloud.apihub.v1.LintSpecRequest) request,
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
            getGetStyleGuideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetStyleGuideRequest,
                    com.google.cloud.apihub.v1.StyleGuide>(service, METHODID_GET_STYLE_GUIDE)))
        .addMethod(
            getUpdateStyleGuideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateStyleGuideRequest,
                    com.google.cloud.apihub.v1.StyleGuide>(service, METHODID_UPDATE_STYLE_GUIDE)))
        .addMethod(
            getGetStyleGuideContentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetStyleGuideContentsRequest,
                    com.google.cloud.apihub.v1.StyleGuideContents>(
                    service, METHODID_GET_STYLE_GUIDE_CONTENTS)))
        .addMethod(
            getLintSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.LintSpecRequest, com.google.protobuf.Empty>(
                    service, METHODID_LINT_SPEC)))
        .build();
  }

  private abstract static class LintingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LintingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apihub.v1.LintingServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LintingService");
    }
  }

  private static final class LintingServiceFileDescriptorSupplier
      extends LintingServiceBaseDescriptorSupplier {
    LintingServiceFileDescriptorSupplier() {}
  }

  private static final class LintingServiceMethodDescriptorSupplier
      extends LintingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LintingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LintingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LintingServiceFileDescriptorSupplier())
                      .addMethod(getGetStyleGuideMethod())
                      .addMethod(getUpdateStyleGuideMethod())
                      .addMethod(getGetStyleGuideContentsMethod())
                      .addMethod(getLintSpecMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
