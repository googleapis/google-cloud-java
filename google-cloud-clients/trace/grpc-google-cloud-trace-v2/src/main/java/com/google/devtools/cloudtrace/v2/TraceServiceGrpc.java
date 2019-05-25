package com.google.devtools.cloudtrace.v2;

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
 * This file describes an API for collecting and viewing traces and spans
 * within a trace.  A Trace is a collection of spans corresponding to a single
 * operation or set of operations for an application. A span is an individual
 * timed event which forms a node of the trace tree. A single trace may
 * contain span(s) from multiple services.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/devtools/cloudtrace/v2/tracing.proto")
public final class TraceServiceGrpc {

  private TraceServiceGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.cloudtrace.v2.TraceService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchWriteSpansMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest, com.google.protobuf.Empty>
      METHOD_BATCH_WRITE_SPANS = getBatchWriteSpansMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest, com.google.protobuf.Empty>
      getBatchWriteSpansMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest, com.google.protobuf.Empty>
      getBatchWriteSpansMethod() {
    return getBatchWriteSpansMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest, com.google.protobuf.Empty>
      getBatchWriteSpansMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest, com.google.protobuf.Empty>
        getBatchWriteSpansMethod;
    if ((getBatchWriteSpansMethod = TraceServiceGrpc.getBatchWriteSpansMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getBatchWriteSpansMethod = TraceServiceGrpc.getBatchWriteSpansMethod) == null) {
          TraceServiceGrpc.getBatchWriteSpansMethod =
              getBatchWriteSpansMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudtrace.v2.TraceService", "BatchWriteSpans"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TraceServiceMethodDescriptorSupplier("BatchWriteSpans"))
                      .build();
        }
      }
    }
    return getBatchWriteSpansMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateSpanMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.Span, com.google.devtools.cloudtrace.v2.Span>
      METHOD_CREATE_SPAN = getCreateSpanMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.Span, com.google.devtools.cloudtrace.v2.Span>
      getCreateSpanMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.Span, com.google.devtools.cloudtrace.v2.Span>
      getCreateSpanMethod() {
    return getCreateSpanMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.devtools.cloudtrace.v2.Span, com.google.devtools.cloudtrace.v2.Span>
      getCreateSpanMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.devtools.cloudtrace.v2.Span, com.google.devtools.cloudtrace.v2.Span>
        getCreateSpanMethod;
    if ((getCreateSpanMethod = TraceServiceGrpc.getCreateSpanMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getCreateSpanMethod = TraceServiceGrpc.getCreateSpanMethod) == null) {
          TraceServiceGrpc.getCreateSpanMethod =
              getCreateSpanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.cloudtrace.v2.Span,
                          com.google.devtools.cloudtrace.v2.Span>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudtrace.v2.TraceService", "CreateSpan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudtrace.v2.Span.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.cloudtrace.v2.Span.getDefaultInstance()))
                      .setSchemaDescriptor(new TraceServiceMethodDescriptorSupplier("CreateSpan"))
                      .build();
        }
      }
    }
    return getCreateSpanMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TraceServiceStub newStub(io.grpc.Channel channel) {
    return new TraceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TraceServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new TraceServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TraceServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new TraceServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. A single trace may
   * contain span(s) from multiple services.
   * </pre>
   */
  public abstract static class TraceServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Sends new spans to new or existing traces. You cannot update
     * existing spans.
     * </pre>
     */
    public void batchWriteSpans(
        com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchWriteSpansMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new span.
     * </pre>
     */
    public void createSpan(
        com.google.devtools.cloudtrace.v2.Span request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v2.Span> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSpanMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getBatchWriteSpansMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest,
                      com.google.protobuf.Empty>(this, METHODID_BATCH_WRITE_SPANS)))
          .addMethod(
              getCreateSpanMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.cloudtrace.v2.Span,
                      com.google.devtools.cloudtrace.v2.Span>(this, METHODID_CREATE_SPAN)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. A single trace may
   * contain span(s) from multiple services.
   * </pre>
   */
  public static final class TraceServiceStub extends io.grpc.stub.AbstractStub<TraceServiceStub> {
    private TraceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TraceServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sends new spans to new or existing traces. You cannot update
     * existing spans.
     * </pre>
     */
    public void batchWriteSpans(
        com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchWriteSpansMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new span.
     * </pre>
     */
    public void createSpan(
        com.google.devtools.cloudtrace.v2.Span request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v2.Span> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSpanMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. A single trace may
   * contain span(s) from multiple services.
   * </pre>
   */
  public static final class TraceServiceBlockingStub
      extends io.grpc.stub.AbstractStub<TraceServiceBlockingStub> {
    private TraceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TraceServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sends new spans to new or existing traces. You cannot update
     * existing spans.
     * </pre>
     */
    public com.google.protobuf.Empty batchWriteSpans(
        com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchWriteSpansMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new span.
     * </pre>
     */
    public com.google.devtools.cloudtrace.v2.Span createSpan(
        com.google.devtools.cloudtrace.v2.Span request) {
      return blockingUnaryCall(
          getChannel(), getCreateSpanMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * This file describes an API for collecting and viewing traces and spans
   * within a trace.  A Trace is a collection of spans corresponding to a single
   * operation or set of operations for an application. A span is an individual
   * timed event which forms a node of the trace tree. A single trace may
   * contain span(s) from multiple services.
   * </pre>
   */
  public static final class TraceServiceFutureStub
      extends io.grpc.stub.AbstractStub<TraceServiceFutureStub> {
    private TraceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TraceServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sends new spans to new or existing traces. You cannot update
     * existing spans.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchWriteSpans(com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchWriteSpansMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new span.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.cloudtrace.v2.Span>
        createSpan(com.google.devtools.cloudtrace.v2.Span request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSpanMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BATCH_WRITE_SPANS = 0;
  private static final int METHODID_CREATE_SPAN = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_BATCH_WRITE_SPANS:
          serviceImpl.batchWriteSpans(
              (com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_SPAN:
          serviceImpl.createSpan(
              (com.google.devtools.cloudtrace.v2.Span) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v2.Span>)
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

  private abstract static class TraceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TraceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.cloudtrace.v2.TracingProto.getDescriptor();
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TraceServiceFileDescriptorSupplier())
                      .addMethod(getBatchWriteSpansMethodHelper())
                      .addMethod(getCreateSpanMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
