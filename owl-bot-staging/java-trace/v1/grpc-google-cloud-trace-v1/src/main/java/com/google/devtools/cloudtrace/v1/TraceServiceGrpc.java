package com.google.devtools.cloudtrace.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * This file describes an API for collecting and viewing traces and spans
 * within a trace.  A Trace is a collection of spans corresponding to a single
 * operation or set of operations for an application. A span is an individual
 * timed event which forms a node of the trace tree. Spans for a single trace
 * may span multiple services.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/cloudtrace/v1/trace.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TraceServiceGrpc {

  private TraceServiceGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.cloudtrace.v1.TraceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest,
      com.google.devtools.cloudtrace.v1.ListTracesResponse> getListTracesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTraces",
      requestType = com.google.devtools.cloudtrace.v1.ListTracesRequest.class,
      responseType = com.google.devtools.cloudtrace.v1.ListTracesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest,
      com.google.devtools.cloudtrace.v1.ListTracesResponse> getListTracesMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest, com.google.devtools.cloudtrace.v1.ListTracesResponse> getListTracesMethod;
    if ((getListTracesMethod = TraceServiceGrpc.getListTracesMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getListTracesMethod = TraceServiceGrpc.getListTracesMethod) == null) {
          TraceServiceGrpc.getListTracesMethod = getListTracesMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.cloudtrace.v1.ListTracesRequest, com.google.devtools.cloudtrace.v1.ListTracesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTraces"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.cloudtrace.v1.ListTracesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.cloudtrace.v1.ListTracesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TraceServiceMethodDescriptorSupplier("ListTraces"))
              .build();
        }
      }
    }
    return getListTracesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest,
      com.google.devtools.cloudtrace.v1.Trace> getGetTraceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrace",
      requestType = com.google.devtools.cloudtrace.v1.GetTraceRequest.class,
      responseType = com.google.devtools.cloudtrace.v1.Trace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest,
      com.google.devtools.cloudtrace.v1.Trace> getGetTraceMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest, com.google.devtools.cloudtrace.v1.Trace> getGetTraceMethod;
    if ((getGetTraceMethod = TraceServiceGrpc.getGetTraceMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getGetTraceMethod = TraceServiceGrpc.getGetTraceMethod) == null) {
          TraceServiceGrpc.getGetTraceMethod = getGetTraceMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.cloudtrace.v1.GetTraceRequest, com.google.devtools.cloudtrace.v1.Trace>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrace"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.cloudtrace.v1.GetTraceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.cloudtrace.v1.Trace.getDefaultInstance()))
              .setSchemaDescriptor(new TraceServiceMethodDescriptorSupplier("GetTrace"))
              .build();
        }
      }
    }
    return getGetTraceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest,
      com.google.protobuf.Empty> getPatchTracesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PatchTraces",
      requestType = com.google.devtools.cloudtrace.v1.PatchTracesRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest,
      com.google.protobuf.Empty> getPatchTracesMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest, com.google.protobuf.Empty> getPatchTracesMethod;
    if ((getPatchTracesMethod = TraceServiceGrpc.getPatchTracesMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getPatchTracesMethod = TraceServiceGrpc.getPatchTracesMethod) == null) {
          TraceServiceGrpc.getPatchTracesMethod = getPatchTracesMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.cloudtrace.v1.PatchTracesRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PatchTraces"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.cloudtrace.v1.PatchTracesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new TraceServiceMethodDescriptorSupplier("PatchTraces"))
              .build();
        }
      }
    }
    return getPatchTracesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TraceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceServiceStub>() {
        @java.lang.Override
        public TraceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceServiceStub(channel, callOptions);
        }
      };
    return TraceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TraceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceServiceBlockingStub>() {
        @java.lang.Override
        public TraceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceServiceBlockingStub(channel, callOptions);
        }
      };
    return TraceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TraceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceServiceFutureStub>() {
        @java.lang.Override
        public TraceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceServiceFutureStub(channel, callOptions);
        }
      };
    return TraceServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. Spans for a single trace
   * may span multiple services.
   * </pre>
   */
  public static abstract class TraceServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns of a list of traces that match the specified filter conditions.
     * </pre>
     */
    public void listTraces(com.google.devtools.cloudtrace.v1.ListTracesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.ListTracesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTracesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public void getTrace(com.google.devtools.cloudtrace.v1.GetTraceRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.Trace> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTraceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sends new traces to Stackdriver Trace or updates existing traces. If the ID
     * of a trace that you send matches that of an existing trace, any fields
     * in the existing trace and its spans are overwritten by the provided values,
     * and any new fields provided are merged with the existing trace data. If the
     * ID does not match, a new trace is created.
     * </pre>
     */
    public void patchTraces(com.google.devtools.cloudtrace.v1.PatchTracesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPatchTracesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListTracesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.cloudtrace.v1.ListTracesRequest,
                com.google.devtools.cloudtrace.v1.ListTracesResponse>(
                  this, METHODID_LIST_TRACES)))
          .addMethod(
            getGetTraceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.cloudtrace.v1.GetTraceRequest,
                com.google.devtools.cloudtrace.v1.Trace>(
                  this, METHODID_GET_TRACE)))
          .addMethod(
            getPatchTracesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.cloudtrace.v1.PatchTracesRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_PATCH_TRACES)))
          .build();
    }
  }

  /**
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. Spans for a single trace
   * may span multiple services.
   * </pre>
   */
  public static final class TraceServiceStub extends io.grpc.stub.AbstractAsyncStub<TraceServiceStub> {
    private TraceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns of a list of traces that match the specified filter conditions.
     * </pre>
     */
    public void listTraces(com.google.devtools.cloudtrace.v1.ListTracesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.ListTracesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTracesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public void getTrace(com.google.devtools.cloudtrace.v1.GetTraceRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.Trace> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTraceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sends new traces to Stackdriver Trace or updates existing traces. If the ID
     * of a trace that you send matches that of an existing trace, any fields
     * in the existing trace and its spans are overwritten by the provided values,
     * and any new fields provided are merged with the existing trace data. If the
     * ID does not match, a new trace is created.
     * </pre>
     */
    public void patchTraces(com.google.devtools.cloudtrace.v1.PatchTracesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPatchTracesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. Spans for a single trace
   * may span multiple services.
   * </pre>
   */
  public static final class TraceServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TraceServiceBlockingStub> {
    private TraceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns of a list of traces that match the specified filter conditions.
     * </pre>
     */
    public com.google.devtools.cloudtrace.v1.ListTracesResponse listTraces(com.google.devtools.cloudtrace.v1.ListTracesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTracesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public com.google.devtools.cloudtrace.v1.Trace getTrace(com.google.devtools.cloudtrace.v1.GetTraceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTraceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sends new traces to Stackdriver Trace or updates existing traces. If the ID
     * of a trace that you send matches that of an existing trace, any fields
     * in the existing trace and its spans are overwritten by the provided values,
     * and any new fields provided are merged with the existing trace data. If the
     * ID does not match, a new trace is created.
     * </pre>
     */
    public com.google.protobuf.Empty patchTraces(com.google.devtools.cloudtrace.v1.PatchTracesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatchTracesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. Spans for a single trace
   * may span multiple services.
   * </pre>
   */
  public static final class TraceServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TraceServiceFutureStub> {
    private TraceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns of a list of traces that match the specified filter conditions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.cloudtrace.v1.ListTracesResponse> listTraces(
        com.google.devtools.cloudtrace.v1.ListTracesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTracesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.cloudtrace.v1.Trace> getTrace(
        com.google.devtools.cloudtrace.v1.GetTraceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTraceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sends new traces to Stackdriver Trace or updates existing traces. If the ID
     * of a trace that you send matches that of an existing trace, any fields
     * in the existing trace and its spans are overwritten by the provided values,
     * and any new fields provided are merged with the existing trace data. If the
     * ID does not match, a new trace is created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> patchTraces(
        com.google.devtools.cloudtrace.v1.PatchTracesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPatchTracesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TRACES = 0;
  private static final int METHODID_GET_TRACE = 1;
  private static final int METHODID_PATCH_TRACES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TraceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TraceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_TRACES:
          serviceImpl.listTraces((com.google.devtools.cloudtrace.v1.ListTracesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.ListTracesResponse>) responseObserver);
          break;
        case METHODID_GET_TRACE:
          serviceImpl.getTrace((com.google.devtools.cloudtrace.v1.GetTraceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.Trace>) responseObserver);
          break;
        case METHODID_PATCH_TRACES:
          serviceImpl.patchTraces((com.google.devtools.cloudtrace.v1.PatchTracesRequest) request,
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

  private static abstract class TraceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TraceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.cloudtrace.v1.TraceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TraceService");
    }
  }

  private static final class TraceServiceFileDescriptorSupplier
      extends TraceServiceBaseDescriptorSupplier {
    TraceServiceFileDescriptorSupplier() {}
  }

  private static final class TraceServiceMethodDescriptorSupplier
      extends TraceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TraceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TraceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TraceServiceFileDescriptorSupplier())
              .addMethod(getListTracesMethod())
              .addMethod(getGetTraceMethod())
              .addMethod(getPatchTracesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
