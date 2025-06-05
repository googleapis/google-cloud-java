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
package com.google.spanner.adapter.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Spanner Adapter API
 * The Cloud Spanner Adapter service allows native drivers of supported database
 * dialects to interact directly with Cloud Spanner by wrapping the underlying
 * wire protocol used by the driver in a gRPC stream.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/spanner/adapter/v1/adapter.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AdapterGrpc {

  private AdapterGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.spanner.adapter.v1.Adapter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.adapter.v1.CreateSessionRequest, com.google.spanner.adapter.v1.Session>
      getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = com.google.spanner.adapter.v1.CreateSessionRequest.class,
      responseType = com.google.spanner.adapter.v1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.adapter.v1.CreateSessionRequest, com.google.spanner.adapter.v1.Session>
      getCreateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.adapter.v1.CreateSessionRequest,
            com.google.spanner.adapter.v1.Session>
        getCreateSessionMethod;
    if ((getCreateSessionMethod = AdapterGrpc.getCreateSessionMethod) == null) {
      synchronized (AdapterGrpc.class) {
        if ((getCreateSessionMethod = AdapterGrpc.getCreateSessionMethod) == null) {
          AdapterGrpc.getCreateSessionMethod =
              getCreateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.adapter.v1.CreateSessionRequest,
                          com.google.spanner.adapter.v1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.adapter.v1.CreateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.adapter.v1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(new AdapterMethodDescriptorSupplier("CreateSession"))
                      .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.adapter.v1.AdaptMessageRequest,
          com.google.spanner.adapter.v1.AdaptMessageResponse>
      getAdaptMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AdaptMessage",
      requestType = com.google.spanner.adapter.v1.AdaptMessageRequest.class,
      responseType = com.google.spanner.adapter.v1.AdaptMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.adapter.v1.AdaptMessageRequest,
          com.google.spanner.adapter.v1.AdaptMessageResponse>
      getAdaptMessageMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.adapter.v1.AdaptMessageRequest,
            com.google.spanner.adapter.v1.AdaptMessageResponse>
        getAdaptMessageMethod;
    if ((getAdaptMessageMethod = AdapterGrpc.getAdaptMessageMethod) == null) {
      synchronized (AdapterGrpc.class) {
        if ((getAdaptMessageMethod = AdapterGrpc.getAdaptMessageMethod) == null) {
          AdapterGrpc.getAdaptMessageMethod =
              getAdaptMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.adapter.v1.AdaptMessageRequest,
                          com.google.spanner.adapter.v1.AdaptMessageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AdaptMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.adapter.v1.AdaptMessageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.adapter.v1.AdaptMessageResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AdapterMethodDescriptorSupplier("AdaptMessage"))
                      .build();
        }
      }
    }
    return getAdaptMessageMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AdapterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdapterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AdapterStub>() {
          @java.lang.Override
          public AdapterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AdapterStub(channel, callOptions);
          }
        };
    return AdapterStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AdapterBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdapterBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AdapterBlockingV2Stub>() {
          @java.lang.Override
          public AdapterBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AdapterBlockingV2Stub(channel, callOptions);
          }
        };
    return AdapterBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdapterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdapterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AdapterBlockingStub>() {
          @java.lang.Override
          public AdapterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AdapterBlockingStub(channel, callOptions);
          }
        };
    return AdapterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AdapterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdapterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AdapterFutureStub>() {
          @java.lang.Override
          public AdapterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AdapterFutureStub(channel, callOptions);
          }
        };
    return AdapterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Spanner Adapter API
   * The Cloud Spanner Adapter service allows native drivers of supported database
   * dialects to interact directly with Cloud Spanner by wrapping the underlying
   * wire protocol used by the driver in a gRPC stream.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new session to be used for requests made by the adapter.
     * A session identifies a specific incarnation of a database resource and is
     * meant to be reused across many `AdaptMessage` calls.
     * </pre>
     */
    default void createSession(
        com.google.spanner.adapter.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.adapter.v1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Handles a single message from the client and returns the result as a
     * stream. The server will interpret the message frame and respond with
     * message frames to the client.
     * </pre>
     */
    default void adaptMessage(
        com.google.spanner.adapter.v1.AdaptMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.adapter.v1.AdaptMessageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAdaptMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Adapter.
   *
   * <pre>
   * Cloud Spanner Adapter API
   * The Cloud Spanner Adapter service allows native drivers of supported database
   * dialects to interact directly with Cloud Spanner by wrapping the underlying
   * wire protocol used by the driver in a gRPC stream.
   * </pre>
   */
  public abstract static class AdapterImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AdapterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Adapter.
   *
   * <pre>
   * Cloud Spanner Adapter API
   * The Cloud Spanner Adapter service allows native drivers of supported database
   * dialects to interact directly with Cloud Spanner by wrapping the underlying
   * wire protocol used by the driver in a gRPC stream.
   * </pre>
   */
  public static final class AdapterStub extends io.grpc.stub.AbstractAsyncStub<AdapterStub> {
    private AdapterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdapterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdapterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session to be used for requests made by the adapter.
     * A session identifies a specific incarnation of a database resource and is
     * meant to be reused across many `AdaptMessage` calls.
     * </pre>
     */
    public void createSession(
        com.google.spanner.adapter.v1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.adapter.v1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Handles a single message from the client and returns the result as a
     * stream. The server will interpret the message frame and respond with
     * message frames to the client.
     * </pre>
     */
    public void adaptMessage(
        com.google.spanner.adapter.v1.AdaptMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.adapter.v1.AdaptMessageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAdaptMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Adapter.
   *
   * <pre>
   * Cloud Spanner Adapter API
   * The Cloud Spanner Adapter service allows native drivers of supported database
   * dialects to interact directly with Cloud Spanner by wrapping the underlying
   * wire protocol used by the driver in a gRPC stream.
   * </pre>
   */
  public static final class AdapterBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AdapterBlockingV2Stub> {
    private AdapterBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdapterBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdapterBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session to be used for requests made by the adapter.
     * A session identifies a specific incarnation of a database resource and is
     * meant to be reused across many `AdaptMessage` calls.
     * </pre>
     */
    public com.google.spanner.adapter.v1.Session createSession(
        com.google.spanner.adapter.v1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Handles a single message from the client and returns the result as a
     * stream. The server will interpret the message frame and respond with
     * message frames to the client.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.spanner.adapter.v1.AdaptMessageResponse>
        adaptMessage(com.google.spanner.adapter.v1.AdaptMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getAdaptMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Adapter.
   *
   * <pre>
   * Cloud Spanner Adapter API
   * The Cloud Spanner Adapter service allows native drivers of supported database
   * dialects to interact directly with Cloud Spanner by wrapping the underlying
   * wire protocol used by the driver in a gRPC stream.
   * </pre>
   */
  public static final class AdapterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdapterBlockingStub> {
    private AdapterBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdapterBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdapterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session to be used for requests made by the adapter.
     * A session identifies a specific incarnation of a database resource and is
     * meant to be reused across many `AdaptMessage` calls.
     * </pre>
     */
    public com.google.spanner.adapter.v1.Session createSession(
        com.google.spanner.adapter.v1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Handles a single message from the client and returns the result as a
     * stream. The server will interpret the message frame and respond with
     * message frames to the client.
     * </pre>
     */
    public java.util.Iterator<com.google.spanner.adapter.v1.AdaptMessageResponse> adaptMessage(
        com.google.spanner.adapter.v1.AdaptMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAdaptMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Adapter.
   *
   * <pre>
   * Cloud Spanner Adapter API
   * The Cloud Spanner Adapter service allows native drivers of supported database
   * dialects to interact directly with Cloud Spanner by wrapping the underlying
   * wire protocol used by the driver in a gRPC stream.
   * </pre>
   */
  public static final class AdapterFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdapterFutureStub> {
    private AdapterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdapterFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdapterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new session to be used for requests made by the adapter.
     * A session identifies a specific incarnation of a database resource and is
     * meant to be reused across many `AdaptMessage` calls.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.adapter.v1.Session>
        createSession(com.google.spanner.adapter.v1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_ADAPT_MESSAGE = 1;

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
        case METHODID_CREATE_SESSION:
          serviceImpl.createSession(
              (com.google.spanner.adapter.v1.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.adapter.v1.Session>)
                  responseObserver);
          break;
        case METHODID_ADAPT_MESSAGE:
          serviceImpl.adaptMessage(
              (com.google.spanner.adapter.v1.AdaptMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.adapter.v1.AdaptMessageResponse>)
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
            getCreateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.adapter.v1.CreateSessionRequest,
                    com.google.spanner.adapter.v1.Session>(service, METHODID_CREATE_SESSION)))
        .addMethod(
            getAdaptMessageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.spanner.adapter.v1.AdaptMessageRequest,
                    com.google.spanner.adapter.v1.AdaptMessageResponse>(
                    service, METHODID_ADAPT_MESSAGE)))
        .build();
  }

  private abstract static class AdapterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdapterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.spanner.adapter.v1.AdapterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Adapter");
    }
  }

  private static final class AdapterFileDescriptorSupplier extends AdapterBaseDescriptorSupplier {
    AdapterFileDescriptorSupplier() {}
  }

  private static final class AdapterMethodDescriptorSupplier extends AdapterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdapterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AdapterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AdapterFileDescriptorSupplier())
                      .addMethod(getCreateSessionMethod())
                      .addMethod(getAdaptMessageMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
