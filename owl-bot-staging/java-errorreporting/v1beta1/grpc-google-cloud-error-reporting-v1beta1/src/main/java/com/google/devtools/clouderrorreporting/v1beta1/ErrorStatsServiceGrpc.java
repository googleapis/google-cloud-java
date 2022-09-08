package com.google.devtools.clouderrorreporting.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * An API for retrieving and managing error statistics as well as data for
 * individual events.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/clouderrorreporting/v1beta1/error_stats_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ErrorStatsServiceGrpc {

  private ErrorStatsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.clouderrorreporting.v1beta1.ErrorStatsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse> getListGroupStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGroupStats",
      requestType = com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest.class,
      responseType = com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse> getListGroupStatsMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest, com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse> getListGroupStatsMethod;
    if ((getListGroupStatsMethod = ErrorStatsServiceGrpc.getListGroupStatsMethod) == null) {
      synchronized (ErrorStatsServiceGrpc.class) {
        if ((getListGroupStatsMethod = ErrorStatsServiceGrpc.getListGroupStatsMethod) == null) {
          ErrorStatsServiceGrpc.getListGroupStatsMethod = getListGroupStatsMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest, com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGroupStats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ErrorStatsServiceMethodDescriptorSupplier("ListGroupStats"))
              .build();
        }
      }
    }
    return getListGroupStatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse> getListEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvents",
      requestType = com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest.class,
      responseType = com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse> getListEventsMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest, com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse> getListEventsMethod;
    if ((getListEventsMethod = ErrorStatsServiceGrpc.getListEventsMethod) == null) {
      synchronized (ErrorStatsServiceGrpc.class) {
        if ((getListEventsMethod = ErrorStatsServiceGrpc.getListEventsMethod) == null) {
          ErrorStatsServiceGrpc.getListEventsMethod = getListEventsMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest, com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ErrorStatsServiceMethodDescriptorSupplier("ListEvents"))
              .build();
        }
      }
    }
    return getListEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest,
      com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse> getDeleteEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvents",
      requestType = com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest.class,
      responseType = com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest,
      com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse> getDeleteEventsMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest, com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse> getDeleteEventsMethod;
    if ((getDeleteEventsMethod = ErrorStatsServiceGrpc.getDeleteEventsMethod) == null) {
      synchronized (ErrorStatsServiceGrpc.class) {
        if ((getDeleteEventsMethod = ErrorStatsServiceGrpc.getDeleteEventsMethod) == null) {
          ErrorStatsServiceGrpc.getDeleteEventsMethod = getDeleteEventsMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest, com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ErrorStatsServiceMethodDescriptorSupplier("DeleteEvents"))
              .build();
        }
      }
    }
    return getDeleteEventsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ErrorStatsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ErrorStatsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ErrorStatsServiceStub>() {
        @java.lang.Override
        public ErrorStatsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ErrorStatsServiceStub(channel, callOptions);
        }
      };
    return ErrorStatsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ErrorStatsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ErrorStatsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ErrorStatsServiceBlockingStub>() {
        @java.lang.Override
        public ErrorStatsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ErrorStatsServiceBlockingStub(channel, callOptions);
        }
      };
    return ErrorStatsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ErrorStatsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ErrorStatsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ErrorStatsServiceFutureStub>() {
        @java.lang.Override
        public ErrorStatsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ErrorStatsServiceFutureStub(channel, callOptions);
        }
      };
    return ErrorStatsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * An API for retrieving and managing error statistics as well as data for
   * individual events.
   * </pre>
   */
  public static abstract class ErrorStatsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the specified groups.
     * </pre>
     */
    public void listGroupStats(com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGroupStatsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists the specified events.
     * </pre>
     */
    public void listEvents(com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEventsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes all error events of a given project.
     * </pre>
     */
    public void deleteEvents(com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEventsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListGroupStatsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest,
                com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse>(
                  this, METHODID_LIST_GROUP_STATS)))
          .addMethod(
            getListEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest,
                com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse>(
                  this, METHODID_LIST_EVENTS)))
          .addMethod(
            getDeleteEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest,
                com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse>(
                  this, METHODID_DELETE_EVENTS)))
          .build();
    }
  }

  /**
   * <pre>
   * An API for retrieving and managing error statistics as well as data for
   * individual events.
   * </pre>
   */
  public static final class ErrorStatsServiceStub extends io.grpc.stub.AbstractAsyncStub<ErrorStatsServiceStub> {
    private ErrorStatsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorStatsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ErrorStatsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the specified groups.
     * </pre>
     */
    public void listGroupStats(com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGroupStatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the specified events.
     * </pre>
     */
    public void listEvents(com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes all error events of a given project.
     * </pre>
     */
    public void deleteEvents(com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEventsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * An API for retrieving and managing error statistics as well as data for
   * individual events.
   * </pre>
   */
  public static final class ErrorStatsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ErrorStatsServiceBlockingStub> {
    private ErrorStatsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorStatsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ErrorStatsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the specified groups.
     * </pre>
     */
    public com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse listGroupStats(com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGroupStatsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the specified events.
     * </pre>
     */
    public com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse listEvents(com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEventsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes all error events of a given project.
     * </pre>
     */
    public com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse deleteEvents(com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEventsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * An API for retrieving and managing error statistics as well as data for
   * individual events.
   * </pre>
   */
  public static final class ErrorStatsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ErrorStatsServiceFutureStub> {
    private ErrorStatsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorStatsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ErrorStatsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the specified groups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse> listGroupStats(
        com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGroupStatsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the specified events.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse> listEvents(
        com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes all error events of a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse> deleteEvents(
        com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEventsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GROUP_STATS = 0;
  private static final int METHODID_LIST_EVENTS = 1;
  private static final int METHODID_DELETE_EVENTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ErrorStatsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ErrorStatsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GROUP_STATS:
          serviceImpl.listGroupStats((com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse>) responseObserver);
          break;
        case METHODID_LIST_EVENTS:
          serviceImpl.listEvents((com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse>) responseObserver);
          break;
        case METHODID_DELETE_EVENTS:
          serviceImpl.deleteEvents((com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse>) responseObserver);
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

  private static abstract class ErrorStatsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ErrorStatsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ErrorStatsService");
    }
  }

  private static final class ErrorStatsServiceFileDescriptorSupplier
      extends ErrorStatsServiceBaseDescriptorSupplier {
    ErrorStatsServiceFileDescriptorSupplier() {}
  }

  private static final class ErrorStatsServiceMethodDescriptorSupplier
      extends ErrorStatsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ErrorStatsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ErrorStatsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ErrorStatsServiceFileDescriptorSupplier())
              .addMethod(getListGroupStatsMethod())
              .addMethod(getListEventsMethod())
              .addMethod(getDeleteEventsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
