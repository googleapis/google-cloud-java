package com.google.devtools.cloudtrace.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/devtools/cloudtrace/v1/trace.proto")
public final class TraceServiceGrpc {

  private TraceServiceGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.cloudtrace.v1.TraceService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTracesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest,
      com.google.devtools.cloudtrace.v1.ListTracesResponse> METHOD_LIST_TRACES = getListTracesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest,
      com.google.devtools.cloudtrace.v1.ListTracesResponse> getListTracesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest,
      com.google.devtools.cloudtrace.v1.ListTracesResponse> getListTracesMethod() {
    return getListTracesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest,
      com.google.devtools.cloudtrace.v1.ListTracesResponse> getListTracesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.ListTracesRequest, com.google.devtools.cloudtrace.v1.ListTracesResponse> getListTracesMethod;
    if ((getListTracesMethod = TraceServiceGrpc.getListTracesMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getListTracesMethod = TraceServiceGrpc.getListTracesMethod) == null) {
          TraceServiceGrpc.getListTracesMethod = getListTracesMethod = 
              io.grpc.MethodDescriptor.<com.google.devtools.cloudtrace.v1.ListTracesRequest, com.google.devtools.cloudtrace.v1.ListTracesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.cloudtrace.v1.TraceService", "ListTraces"))
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
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTraceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest,
      com.google.devtools.cloudtrace.v1.Trace> METHOD_GET_TRACE = getGetTraceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest,
      com.google.devtools.cloudtrace.v1.Trace> getGetTraceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest,
      com.google.devtools.cloudtrace.v1.Trace> getGetTraceMethod() {
    return getGetTraceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest,
      com.google.devtools.cloudtrace.v1.Trace> getGetTraceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.GetTraceRequest, com.google.devtools.cloudtrace.v1.Trace> getGetTraceMethod;
    if ((getGetTraceMethod = TraceServiceGrpc.getGetTraceMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getGetTraceMethod = TraceServiceGrpc.getGetTraceMethod) == null) {
          TraceServiceGrpc.getGetTraceMethod = getGetTraceMethod = 
              io.grpc.MethodDescriptor.<com.google.devtools.cloudtrace.v1.GetTraceRequest, com.google.devtools.cloudtrace.v1.Trace>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.cloudtrace.v1.TraceService", "GetTrace"))
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
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPatchTracesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest,
      com.google.protobuf.Empty> METHOD_PATCH_TRACES = getPatchTracesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest,
      com.google.protobuf.Empty> getPatchTracesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest,
      com.google.protobuf.Empty> getPatchTracesMethod() {
    return getPatchTracesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest,
      com.google.protobuf.Empty> getPatchTracesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.devtools.cloudtrace.v1.PatchTracesRequest, com.google.protobuf.Empty> getPatchTracesMethod;
    if ((getPatchTracesMethod = TraceServiceGrpc.getPatchTracesMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getPatchTracesMethod = TraceServiceGrpc.getPatchTracesMethod) == null) {
          TraceServiceGrpc.getPatchTracesMethod = getPatchTracesMethod = 
              io.grpc.MethodDescriptor.<com.google.devtools.cloudtrace.v1.PatchTracesRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.cloudtrace.v1.TraceService", "PatchTraces"))
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
    return new TraceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TraceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TraceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TraceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TraceServiceFutureStub(channel);
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
      asyncUnimplementedUnaryCall(getListTracesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public void getTrace(com.google.devtools.cloudtrace.v1.GetTraceRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.Trace> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTraceMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getPatchTracesMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListTracesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.cloudtrace.v1.ListTracesRequest,
                com.google.devtools.cloudtrace.v1.ListTracesResponse>(
                  this, METHODID_LIST_TRACES)))
          .addMethod(
            getGetTraceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.cloudtrace.v1.GetTraceRequest,
                com.google.devtools.cloudtrace.v1.Trace>(
                  this, METHODID_GET_TRACE)))
          .addMethod(
            getPatchTracesMethodHelper(),
            asyncUnaryCall(
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
  public static final class TraceServiceStub extends io.grpc.stub.AbstractStub<TraceServiceStub> {
    private TraceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TraceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TraceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns of a list of traces that match the specified filter conditions.
     * </pre>
     */
    public void listTraces(com.google.devtools.cloudtrace.v1.ListTracesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.ListTracesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTracesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public void getTrace(com.google.devtools.cloudtrace.v1.GetTraceRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.cloudtrace.v1.Trace> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTraceMethodHelper(), getCallOptions()), request, responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getPatchTracesMethodHelper(), getCallOptions()), request, responseObserver);
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
  public static final class TraceServiceBlockingStub extends io.grpc.stub.AbstractStub<TraceServiceBlockingStub> {
    private TraceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TraceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TraceServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns of a list of traces that match the specified filter conditions.
     * </pre>
     */
    public com.google.devtools.cloudtrace.v1.ListTracesResponse listTraces(com.google.devtools.cloudtrace.v1.ListTracesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTracesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public com.google.devtools.cloudtrace.v1.Trace getTrace(com.google.devtools.cloudtrace.v1.GetTraceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTraceMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getPatchTracesMethodHelper(), getCallOptions(), request);
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
  public static final class TraceServiceFutureStub extends io.grpc.stub.AbstractStub<TraceServiceFutureStub> {
    private TraceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TraceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TraceServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns of a list of traces that match the specified filter conditions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.cloudtrace.v1.ListTracesResponse> listTraces(
        com.google.devtools.cloudtrace.v1.ListTracesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTracesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single trace by its ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.cloudtrace.v1.Trace> getTrace(
        com.google.devtools.cloudtrace.v1.GetTraceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTraceMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getPatchTracesMethodHelper(), getCallOptions()), request);
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
              .addMethod(getListTracesMethodHelper())
              .addMethod(getGetTraceMethodHelper())
              .addMethod(getPatchTracesMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
