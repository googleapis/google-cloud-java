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
package com.google.cloud.talent.v4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service handles client event report.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/talent/v4/event_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EventServiceGrpc {

  private EventServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.talent.v4.EventService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.CreateClientEventRequest,
          com.google.cloud.talent.v4.ClientEvent>
      getCreateClientEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClientEvent",
      requestType = com.google.cloud.talent.v4.CreateClientEventRequest.class,
      responseType = com.google.cloud.talent.v4.ClientEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4.CreateClientEventRequest,
          com.google.cloud.talent.v4.ClientEvent>
      getCreateClientEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4.CreateClientEventRequest,
            com.google.cloud.talent.v4.ClientEvent>
        getCreateClientEventMethod;
    if ((getCreateClientEventMethod = EventServiceGrpc.getCreateClientEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getCreateClientEventMethod = EventServiceGrpc.getCreateClientEventMethod) == null) {
          EventServiceGrpc.getCreateClientEventMethod =
              getCreateClientEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4.CreateClientEventRequest,
                          com.google.cloud.talent.v4.ClientEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateClientEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.CreateClientEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4.ClientEvent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventServiceMethodDescriptorSupplier("CreateClientEvent"))
                      .build();
        }
      }
    }
    return getCreateClientEventMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EventServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventServiceStub>() {
          @java.lang.Override
          public EventServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventServiceStub(channel, callOptions);
          }
        };
    return EventServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventServiceBlockingStub>() {
          @java.lang.Override
          public EventServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventServiceBlockingStub(channel, callOptions);
          }
        };
    return EventServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EventServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventServiceFutureStub>() {
          @java.lang.Override
          public EventServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventServiceFutureStub(channel, callOptions);
          }
        };
    return EventServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Report events issued when end user interacts with customer's application
     * that uses Cloud Talent Solution. You may inspect the created events in
     * [self service
     * tools](https://console.cloud.google.com/talent-solution/overview).
     * [Learn
     * more](https://cloud.google.com/talent-solution/docs/management-tools)
     * about self service tools.
     * </pre>
     */
    default void createClientEvent(
        com.google.cloud.talent.v4.CreateClientEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.ClientEvent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClientEventMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EventService.
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public abstract static class EventServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EventServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EventService.
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public static final class EventServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EventServiceStub> {
    private EventServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report events issued when end user interacts with customer's application
     * that uses Cloud Talent Solution. You may inspect the created events in
     * [self service
     * tools](https://console.cloud.google.com/talent-solution/overview).
     * [Learn
     * more](https://cloud.google.com/talent-solution/docs/management-tools)
     * about self service tools.
     * </pre>
     */
    public void createClientEvent(
        com.google.cloud.talent.v4.CreateClientEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.ClientEvent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClientEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EventService.
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public static final class EventServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventServiceBlockingStub> {
    private EventServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report events issued when end user interacts with customer's application
     * that uses Cloud Talent Solution. You may inspect the created events in
     * [self service
     * tools](https://console.cloud.google.com/talent-solution/overview).
     * [Learn
     * more](https://cloud.google.com/talent-solution/docs/management-tools)
     * about self service tools.
     * </pre>
     */
    public com.google.cloud.talent.v4.ClientEvent createClientEvent(
        com.google.cloud.talent.v4.CreateClientEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClientEventMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EventService.
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public static final class EventServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventServiceFutureStub> {
    private EventServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report events issued when end user interacts with customer's application
     * that uses Cloud Talent Solution. You may inspect the created events in
     * [self service
     * tools](https://console.cloud.google.com/talent-solution/overview).
     * [Learn
     * more](https://cloud.google.com/talent-solution/docs/management-tools)
     * about self service tools.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4.ClientEvent>
        createClientEvent(com.google.cloud.talent.v4.CreateClientEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClientEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CLIENT_EVENT = 0;

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
        case METHODID_CREATE_CLIENT_EVENT:
          serviceImpl.createClientEvent(
              (com.google.cloud.talent.v4.CreateClientEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4.ClientEvent>)
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
            getCreateClientEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.talent.v4.CreateClientEventRequest,
                    com.google.cloud.talent.v4.ClientEvent>(service, METHODID_CREATE_CLIENT_EVENT)))
        .build();
  }

  private abstract static class EventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4.EventServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventService");
    }
  }

  private static final class EventServiceFileDescriptorSupplier
      extends EventServiceBaseDescriptorSupplier {
    EventServiceFileDescriptorSupplier() {}
  }

  private static final class EventServiceMethodDescriptorSupplier
      extends EventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EventServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EventServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EventServiceFileDescriptorSupplier())
                      .addMethod(getCreateClientEventMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
