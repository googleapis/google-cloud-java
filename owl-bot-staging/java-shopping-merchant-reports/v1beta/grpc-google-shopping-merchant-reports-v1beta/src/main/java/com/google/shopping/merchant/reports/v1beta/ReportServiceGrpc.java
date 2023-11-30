package com.google.shopping.merchant.reports.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for retrieving reports and insights about your products, their
 * performance, and their competitive environment on Google.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/reports/v1beta/reports.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReportServiceGrpc {

  private ReportServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.shopping.merchant.reports.v1beta.ReportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.shopping.merchant.reports.v1beta.SearchRequest,
      com.google.shopping.merchant.reports.v1beta.SearchResponse> getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Search",
      requestType = com.google.shopping.merchant.reports.v1beta.SearchRequest.class,
      responseType = com.google.shopping.merchant.reports.v1beta.SearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.merchant.reports.v1beta.SearchRequest,
      com.google.shopping.merchant.reports.v1beta.SearchResponse> getSearchMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.merchant.reports.v1beta.SearchRequest, com.google.shopping.merchant.reports.v1beta.SearchResponse> getSearchMethod;
    if ((getSearchMethod = ReportServiceGrpc.getSearchMethod) == null) {
      synchronized (ReportServiceGrpc.class) {
        if ((getSearchMethod = ReportServiceGrpc.getSearchMethod) == null) {
          ReportServiceGrpc.getSearchMethod = getSearchMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.merchant.reports.v1beta.SearchRequest, com.google.shopping.merchant.reports.v1beta.SearchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Search"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.reports.v1beta.SearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.reports.v1beta.SearchResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("Search"))
              .build();
        }
      }
    }
    return getSearchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReportServiceStub>() {
        @java.lang.Override
        public ReportServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReportServiceStub(channel, callOptions);
        }
      };
    return ReportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReportServiceBlockingStub>() {
        @java.lang.Override
        public ReportServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReportServiceBlockingStub(channel, callOptions);
        }
      };
    return ReportServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReportServiceFutureStub>() {
        @java.lang.Override
        public ReportServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReportServiceFutureStub(channel, callOptions);
        }
      };
    return ReportServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for retrieving reports and insights about your products, their
   * performance, and their competitive environment on Google.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Retrieves a report defined by a search query. The response might contain
     * fewer rows than specified by `page_size`. Rely on `next_page_token` to
     * determine if there are more rows to be requested.
     * </pre>
     */
    default void search(com.google.shopping.merchant.reports.v1beta.SearchRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reports.v1beta.SearchResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReportService.
   * <pre>
   * Service for retrieving reports and insights about your products, their
   * performance, and their competitive environment on Google.
   * </pre>
   */
  public static abstract class ReportServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReportServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReportService.
   * <pre>
   * Service for retrieving reports and insights about your products, their
   * performance, and their competitive environment on Google.
   * </pre>
   */
  public static final class ReportServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReportServiceStub> {
    private ReportServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a report defined by a search query. The response might contain
     * fewer rows than specified by `page_size`. Rely on `next_page_token` to
     * determine if there are more rows to be requested.
     * </pre>
     */
    public void search(com.google.shopping.merchant.reports.v1beta.SearchRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reports.v1beta.SearchResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReportService.
   * <pre>
   * Service for retrieving reports and insights about your products, their
   * performance, and their competitive environment on Google.
   * </pre>
   */
  public static final class ReportServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReportServiceBlockingStub> {
    private ReportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a report defined by a search query. The response might contain
     * fewer rows than specified by `page_size`. Rely on `next_page_token` to
     * determine if there are more rows to be requested.
     * </pre>
     */
    public com.google.shopping.merchant.reports.v1beta.SearchResponse search(com.google.shopping.merchant.reports.v1beta.SearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReportService.
   * <pre>
   * Service for retrieving reports and insights about your products, their
   * performance, and their competitive environment on Google.
   * </pre>
   */
  public static final class ReportServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReportServiceFutureStub> {
    private ReportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a report defined by a search query. The response might contain
     * fewer rows than specified by `page_size`. Rely on `next_page_token` to
     * determine if there are more rows to be requested.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.merchant.reports.v1beta.SearchResponse> search(
        com.google.shopping.merchant.reports.v1beta.SearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_SEARCH:
          serviceImpl.search((com.google.shopping.merchant.reports.v1beta.SearchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.reports.v1beta.SearchResponse>) responseObserver);
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
          getSearchMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.merchant.reports.v1beta.SearchRequest,
              com.google.shopping.merchant.reports.v1beta.SearchResponse>(
                service, METHODID_SEARCH)))
        .build();
  }

  private static abstract class ReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.reports.v1beta.ReportsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReportService");
    }
  }

  private static final class ReportServiceFileDescriptorSupplier
      extends ReportServiceBaseDescriptorSupplier {
    ReportServiceFileDescriptorSupplier() {}
  }

  private static final class ReportServiceMethodDescriptorSupplier
      extends ReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReportServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReportServiceFileDescriptorSupplier())
              .addMethod(getSearchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
