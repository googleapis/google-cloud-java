package com.google.devtools.clouderrorreporting.v1beta1;

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
 * An API for reporting error events.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/devtools/clouderrorreporting/v1beta1/report_errors_service.proto")
public final class ReportErrorsServiceGrpc {

  private ReportErrorsServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.devtools.clouderrorreporting.v1beta1.ReportErrorsService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReportErrorEventMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
      METHOD_REPORT_ERROR_EVENT = getReportErrorEventMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
      getReportErrorEventMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
      getReportErrorEventMethod() {
    return getReportErrorEventMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
      getReportErrorEventMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
        getReportErrorEventMethod;
    if ((getReportErrorEventMethod = ReportErrorsServiceGrpc.getReportErrorEventMethod) == null) {
      synchronized (ReportErrorsServiceGrpc.class) {
        if ((getReportErrorEventMethod = ReportErrorsServiceGrpc.getReportErrorEventMethod)
            == null) {
          ReportErrorsServiceGrpc.getReportErrorEventMethod =
              getReportErrorEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
                          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.clouderrorreporting.v1beta1.ReportErrorsService",
                              "ReportErrorEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouderrorreporting.v1beta1
                                  .ReportErrorEventRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouderrorreporting.v1beta1
                                  .ReportErrorEventResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReportErrorsServiceMethodDescriptorSupplier("ReportErrorEvent"))
                      .build();
        }
      }
    }
    return getReportErrorEventMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ReportErrorsServiceStub newStub(io.grpc.Channel channel) {
    return new ReportErrorsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReportErrorsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ReportErrorsServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ReportErrorsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ReportErrorsServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public abstract static class ReportErrorsServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Report an individual error event.
     * This endpoint accepts &lt;strong&gt;either&lt;/strong&gt; an OAuth token,
     * &lt;strong&gt;or&lt;/strong&gt; an
     * &lt;a href="https://support.google.com/cloud/answer/6158862"&gt;API key&lt;/a&gt;
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * &lt;pre&gt;POST https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456&lt;/pre&gt;
     * </pre>
     */
    public void reportErrorEvent(
        com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getReportErrorEventMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getReportErrorEventMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
                      com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>(
                      this, METHODID_REPORT_ERROR_EVENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public static final class ReportErrorsServiceStub
      extends io.grpc.stub.AbstractStub<ReportErrorsServiceStub> {
    private ReportErrorsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReportErrorsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportErrorsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportErrorsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report an individual error event.
     * This endpoint accepts &lt;strong&gt;either&lt;/strong&gt; an OAuth token,
     * &lt;strong&gt;or&lt;/strong&gt; an
     * &lt;a href="https://support.google.com/cloud/answer/6158862"&gt;API key&lt;/a&gt;
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * &lt;pre&gt;POST https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456&lt;/pre&gt;
     * </pre>
     */
    public void reportErrorEvent(
        com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportErrorEventMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public static final class ReportErrorsServiceBlockingStub
      extends io.grpc.stub.AbstractStub<ReportErrorsServiceBlockingStub> {
    private ReportErrorsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReportErrorsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportErrorsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportErrorsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report an individual error event.
     * This endpoint accepts &lt;strong&gt;either&lt;/strong&gt; an OAuth token,
     * &lt;strong&gt;or&lt;/strong&gt; an
     * &lt;a href="https://support.google.com/cloud/answer/6158862"&gt;API key&lt;/a&gt;
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * &lt;pre&gt;POST https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456&lt;/pre&gt;
     * </pre>
     */
    public com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse
        reportErrorEvent(
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request) {
      return blockingUnaryCall(
          getChannel(), getReportErrorEventMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public static final class ReportErrorsServiceFutureStub
      extends io.grpc.stub.AbstractStub<ReportErrorsServiceFutureStub> {
    private ReportErrorsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReportErrorsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportErrorsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportErrorsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report an individual error event.
     * This endpoint accepts &lt;strong&gt;either&lt;/strong&gt; an OAuth token,
     * &lt;strong&gt;or&lt;/strong&gt; an
     * &lt;a href="https://support.google.com/cloud/answer/6158862"&gt;API key&lt;/a&gt;
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * &lt;pre&gt;POST https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456&lt;/pre&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
        reportErrorEvent(
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReportErrorEventMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_ERROR_EVENT = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReportErrorsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReportErrorsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_ERROR_EVENT:
          serviceImpl.reportErrorEvent(
              (com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>)
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

  private abstract static class ReportErrorsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReportErrorsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.clouderrorreporting.v1beta1.ReportErrorsServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReportErrorsService");
    }
  }

  private static final class ReportErrorsServiceFileDescriptorSupplier
      extends ReportErrorsServiceBaseDescriptorSupplier {
    ReportErrorsServiceFileDescriptorSupplier() {}
  }

  private static final class ReportErrorsServiceMethodDescriptorSupplier
      extends ReportErrorsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReportErrorsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReportErrorsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ReportErrorsServiceFileDescriptorSupplier())
                      .addMethod(getReportErrorEventMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
