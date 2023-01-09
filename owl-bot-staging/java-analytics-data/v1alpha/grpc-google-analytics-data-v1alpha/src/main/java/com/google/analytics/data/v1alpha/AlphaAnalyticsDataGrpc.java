package com.google.analytics.data.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Google Analytics reporting data service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/analytics/data/v1alpha/analytics_data_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlphaAnalyticsDataGrpc {

  private AlphaAnalyticsDataGrpc() {}

  public static final String SERVICE_NAME = "google.analytics.data.v1alpha.AlphaAnalyticsData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.analytics.data.v1alpha.RunFunnelReportRequest,
      com.google.analytics.data.v1alpha.RunFunnelReportResponse> getRunFunnelReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunFunnelReport",
      requestType = com.google.analytics.data.v1alpha.RunFunnelReportRequest.class,
      responseType = com.google.analytics.data.v1alpha.RunFunnelReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.analytics.data.v1alpha.RunFunnelReportRequest,
      com.google.analytics.data.v1alpha.RunFunnelReportResponse> getRunFunnelReportMethod() {
    io.grpc.MethodDescriptor<com.google.analytics.data.v1alpha.RunFunnelReportRequest, com.google.analytics.data.v1alpha.RunFunnelReportResponse> getRunFunnelReportMethod;
    if ((getRunFunnelReportMethod = AlphaAnalyticsDataGrpc.getRunFunnelReportMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getRunFunnelReportMethod = AlphaAnalyticsDataGrpc.getRunFunnelReportMethod) == null) {
          AlphaAnalyticsDataGrpc.getRunFunnelReportMethod = getRunFunnelReportMethod =
              io.grpc.MethodDescriptor.<com.google.analytics.data.v1alpha.RunFunnelReportRequest, com.google.analytics.data.v1alpha.RunFunnelReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunFunnelReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.analytics.data.v1alpha.RunFunnelReportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.analytics.data.v1alpha.RunFunnelReportResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AlphaAnalyticsDataMethodDescriptorSupplier("RunFunnelReport"))
              .build();
        }
      }
    }
    return getRunFunnelReportMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlphaAnalyticsDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataStub>() {
        @java.lang.Override
        public AlphaAnalyticsDataStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlphaAnalyticsDataStub(channel, callOptions);
        }
      };
    return AlphaAnalyticsDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlphaAnalyticsDataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataBlockingStub>() {
        @java.lang.Override
        public AlphaAnalyticsDataBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlphaAnalyticsDataBlockingStub(channel, callOptions);
        }
      };
    return AlphaAnalyticsDataBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlphaAnalyticsDataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataFutureStub>() {
        @java.lang.Override
        public AlphaAnalyticsDataFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlphaAnalyticsDataFutureStub(channel, callOptions);
        }
      };
    return AlphaAnalyticsDataFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static abstract class AlphaAnalyticsDataImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * </pre>
     */
    public void runFunnelReport(com.google.analytics.data.v1alpha.RunFunnelReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunFunnelReportResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunFunnelReportMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRunFunnelReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.analytics.data.v1alpha.RunFunnelReportRequest,
                com.google.analytics.data.v1alpha.RunFunnelReportResponse>(
                  this, METHODID_RUN_FUNNEL_REPORT)))
          .build();
    }
  }

  /**
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataStub extends io.grpc.stub.AbstractAsyncStub<AlphaAnalyticsDataStub> {
    private AlphaAnalyticsDataStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * </pre>
     */
    public void runFunnelReport(com.google.analytics.data.v1alpha.RunFunnelReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunFunnelReportResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunFunnelReportMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataBlockingStub extends io.grpc.stub.AbstractBlockingStub<AlphaAnalyticsDataBlockingStub> {
    private AlphaAnalyticsDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * </pre>
     */
    public com.google.analytics.data.v1alpha.RunFunnelReportResponse runFunnelReport(com.google.analytics.data.v1alpha.RunFunnelReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunFunnelReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataFutureStub extends io.grpc.stub.AbstractFutureStub<AlphaAnalyticsDataFutureStub> {
    private AlphaAnalyticsDataFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a customized funnel report of your Google Analytics event data. The
     * data returned from the API is as a table with columns for the requested
     * dimensions and metrics.
     * Funnel exploration lets you visualize the steps your users take to complete
     * a task and quickly see how well they are succeeding or failing at each
     * step. For example, how do prospects become shoppers and then become buyers?
     * How do one time buyers become repeat buyers? With this information, you can
     * improve inefficient or abandoned customer journeys. To learn more, see [GA4
     * Funnel Explorations](https://support.google.com/analytics/answer/9327974).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.analytics.data.v1alpha.RunFunnelReportResponse> runFunnelReport(
        com.google.analytics.data.v1alpha.RunFunnelReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunFunnelReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_FUNNEL_REPORT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlphaAnalyticsDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlphaAnalyticsDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RUN_FUNNEL_REPORT:
          serviceImpl.runFunnelReport((com.google.analytics.data.v1alpha.RunFunnelReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunFunnelReportResponse>) responseObserver);
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

  private static abstract class AlphaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlphaAnalyticsDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.analytics.data.v1alpha.AnalyticsDataApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlphaAnalyticsData");
    }
  }

  private static final class AlphaAnalyticsDataFileDescriptorSupplier
      extends AlphaAnalyticsDataBaseDescriptorSupplier {
    AlphaAnalyticsDataFileDescriptorSupplier() {}
  }

  private static final class AlphaAnalyticsDataMethodDescriptorSupplier
      extends AlphaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlphaAnalyticsDataMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlphaAnalyticsDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlphaAnalyticsDataFileDescriptorSupplier())
              .addMethod(getRunFunnelReportMethod())
              .build();
        }
      }
    }
    return result;
  }
}
