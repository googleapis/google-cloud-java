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
package com.google.spanner.executor.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service that executes SpannerActions asynchronously.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SpannerExecutorProxyGrpc {

  private SpannerExecutorProxyGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.spanner.executor.v1.SpannerExecutorProxy";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.executor.v1.SpannerAsyncActionRequest,
          com.google.spanner.executor.v1.SpannerAsyncActionResponse>
      getExecuteActionAsyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteActionAsync",
      requestType = com.google.spanner.executor.v1.SpannerAsyncActionRequest.class,
      responseType = com.google.spanner.executor.v1.SpannerAsyncActionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.executor.v1.SpannerAsyncActionRequest,
          com.google.spanner.executor.v1.SpannerAsyncActionResponse>
      getExecuteActionAsyncMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.executor.v1.SpannerAsyncActionRequest,
            com.google.spanner.executor.v1.SpannerAsyncActionResponse>
        getExecuteActionAsyncMethod;
    if ((getExecuteActionAsyncMethod = SpannerExecutorProxyGrpc.getExecuteActionAsyncMethod)
        == null) {
      synchronized (SpannerExecutorProxyGrpc.class) {
        if ((getExecuteActionAsyncMethod = SpannerExecutorProxyGrpc.getExecuteActionAsyncMethod)
            == null) {
          SpannerExecutorProxyGrpc.getExecuteActionAsyncMethod =
              getExecuteActionAsyncMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.executor.v1.SpannerAsyncActionRequest,
                          com.google.spanner.executor.v1.SpannerAsyncActionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteActionAsync"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.executor.v1.SpannerAsyncActionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.executor.v1.SpannerAsyncActionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpannerExecutorProxyMethodDescriptorSupplier("ExecuteActionAsync"))
                      .build();
        }
      }
    }
    return getExecuteActionAsyncMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SpannerExecutorProxyStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyStub>() {
          @java.lang.Override
          public SpannerExecutorProxyStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerExecutorProxyStub(channel, callOptions);
          }
        };
    return SpannerExecutorProxyStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SpannerExecutorProxyBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyBlockingV2Stub>() {
          @java.lang.Override
          public SpannerExecutorProxyBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerExecutorProxyBlockingV2Stub(channel, callOptions);
          }
        };
    return SpannerExecutorProxyBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpannerExecutorProxyBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyBlockingStub>() {
          @java.lang.Override
          public SpannerExecutorProxyBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerExecutorProxyBlockingStub(channel, callOptions);
          }
        };
    return SpannerExecutorProxyBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SpannerExecutorProxyFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpannerExecutorProxyFutureStub>() {
          @java.lang.Override
          public SpannerExecutorProxyFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpannerExecutorProxyFutureStub(channel, callOptions);
          }
        };
    return SpannerExecutorProxyFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that executes SpannerActions asynchronously.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * ExecuteActionAsync is a streaming call that starts executing a new Spanner
     * action.
     * For each request, the server will reply with one or more responses, but
     * only the last response will contain status in the outcome.
     * Responses can be matched to requests by action_id. It is allowed to have
     * multiple actions in flight--in that case, actions are be executed in
     * parallel.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.spanner.executor.v1.SpannerAsyncActionRequest>
        executeActionAsync(
            io.grpc.stub.StreamObserver<com.google.spanner.executor.v1.SpannerAsyncActionResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getExecuteActionAsyncMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SpannerExecutorProxy.
   *
   * <pre>
   * Service that executes SpannerActions asynchronously.
   * </pre>
   */
  public abstract static class SpannerExecutorProxyImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SpannerExecutorProxyGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SpannerExecutorProxy.
   *
   * <pre>
   * Service that executes SpannerActions asynchronously.
   * </pre>
   */
  public static final class SpannerExecutorProxyStub
      extends io.grpc.stub.AbstractAsyncStub<SpannerExecutorProxyStub> {
    private SpannerExecutorProxyStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerExecutorProxyStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerExecutorProxyStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ExecuteActionAsync is a streaming call that starts executing a new Spanner
     * action.
     * For each request, the server will reply with one or more responses, but
     * only the last response will contain status in the outcome.
     * Responses can be matched to requests by action_id. It is allowed to have
     * multiple actions in flight--in that case, actions are be executed in
     * parallel.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.spanner.executor.v1.SpannerAsyncActionRequest>
        executeActionAsync(
            io.grpc.stub.StreamObserver<com.google.spanner.executor.v1.SpannerAsyncActionResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getExecuteActionAsyncMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SpannerExecutorProxy.
   *
   * <pre>
   * Service that executes SpannerActions asynchronously.
   * </pre>
   */
  public static final class SpannerExecutorProxyBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SpannerExecutorProxyBlockingV2Stub> {
    private SpannerExecutorProxyBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerExecutorProxyBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerExecutorProxyBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ExecuteActionAsync is a streaming call that starts executing a new Spanner
     * action.
     * For each request, the server will reply with one or more responses, but
     * only the last response will contain status in the outcome.
     * Responses can be matched to requests by action_id. It is allowed to have
     * multiple actions in flight--in that case, actions are be executed in
     * parallel.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.spanner.executor.v1.SpannerAsyncActionRequest,
            com.google.spanner.executor.v1.SpannerAsyncActionResponse>
        executeActionAsync() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getExecuteActionAsyncMethod(), getCallOptions());
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SpannerExecutorProxy.
   *
   * <pre>
   * Service that executes SpannerActions asynchronously.
   * </pre>
   */
  public static final class SpannerExecutorProxyBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SpannerExecutorProxyBlockingStub> {
    private SpannerExecutorProxyBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerExecutorProxyBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerExecutorProxyBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SpannerExecutorProxy.
   *
   * <pre>
   * Service that executes SpannerActions asynchronously.
   * </pre>
   */
  public static final class SpannerExecutorProxyFutureStub
      extends io.grpc.stub.AbstractFutureStub<SpannerExecutorProxyFutureStub> {
    private SpannerExecutorProxyFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpannerExecutorProxyFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpannerExecutorProxyFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EXECUTE_ACTION_ASYNC = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE_ACTION_ASYNC:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.executeActionAsync(
                  (io.grpc.stub.StreamObserver<
                          com.google.spanner.executor.v1.SpannerAsyncActionResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getExecuteActionAsyncMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.spanner.executor.v1.SpannerAsyncActionRequest,
                    com.google.spanner.executor.v1.SpannerAsyncActionResponse>(
                    service, METHODID_EXECUTE_ACTION_ASYNC)))
        .build();
  }

  private abstract static class SpannerExecutorProxyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpannerExecutorProxyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.spanner.executor.v1.CloudExecutorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SpannerExecutorProxy");
    }
  }

  private static final class SpannerExecutorProxyFileDescriptorSupplier
      extends SpannerExecutorProxyBaseDescriptorSupplier {
    SpannerExecutorProxyFileDescriptorSupplier() {}
  }

  private static final class SpannerExecutorProxyMethodDescriptorSupplier
      extends SpannerExecutorProxyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SpannerExecutorProxyMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SpannerExecutorProxyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SpannerExecutorProxyFileDescriptorSupplier())
                      .addMethod(getExecuteActionAsyncMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
