package com.google.cloud.talent.v4beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * A service handles client event report.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/event_service.proto")
public final class EventServiceGrpc {

  private EventServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.EventService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateClientEventMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateClientEventRequest,
          com.google.cloud.talent.v4beta1.ClientEvent>
      METHOD_CREATE_CLIENT_EVENT = getCreateClientEventMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateClientEventRequest,
          com.google.cloud.talent.v4beta1.ClientEvent>
      getCreateClientEventMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateClientEventRequest,
          com.google.cloud.talent.v4beta1.ClientEvent>
      getCreateClientEventMethod() {
    return getCreateClientEventMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateClientEventRequest,
          com.google.cloud.talent.v4beta1.ClientEvent>
      getCreateClientEventMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.CreateClientEventRequest,
            com.google.cloud.talent.v4beta1.ClientEvent>
        getCreateClientEventMethod;
    if ((getCreateClientEventMethod = EventServiceGrpc.getCreateClientEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getCreateClientEventMethod = EventServiceGrpc.getCreateClientEventMethod) == null) {
          EventServiceGrpc.getCreateClientEventMethod =
              getCreateClientEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.CreateClientEventRequest,
                          com.google.cloud.talent.v4beta1.ClientEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.EventService", "CreateClientEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CreateClientEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ClientEvent.getDefaultInstance()))
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
    return new EventServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new EventServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EventServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new EventServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public abstract static class EventServiceImplBase implements io.grpc.BindableService {

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
        com.google.cloud.talent.v4beta1.CreateClientEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ClientEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClientEventMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateClientEventMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateClientEventRequest,
                      com.google.cloud.talent.v4beta1.ClientEvent>(
                      this, METHODID_CREATE_CLIENT_EVENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public static final class EventServiceStub extends io.grpc.stub.AbstractStub<EventServiceStub> {
    private EventServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

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
        com.google.cloud.talent.v4beta1.CreateClientEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ClientEvent> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClientEventMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public static final class EventServiceBlockingStub
      extends io.grpc.stub.AbstractStub<EventServiceBlockingStub> {
    private EventServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
    public com.google.cloud.talent.v4beta1.ClientEvent createClientEvent(
        com.google.cloud.talent.v4beta1.CreateClientEventRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateClientEventMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service handles client event report.
   * </pre>
   */
  public static final class EventServiceFutureStub
      extends io.grpc.stub.AbstractStub<EventServiceFutureStub> {
    private EventServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
            com.google.cloud.talent.v4beta1.ClientEvent>
        createClientEvent(com.google.cloud.talent.v4beta1.CreateClientEventRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClientEventMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CLIENT_EVENT = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CLIENT_EVENT:
          serviceImpl.createClientEvent(
              (com.google.cloud.talent.v4beta1.CreateClientEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ClientEvent>)
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

  private abstract static class EventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.EventServiceProto.getDescriptor();
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
    private final String methodName;

    EventServiceMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getCreateClientEventMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
