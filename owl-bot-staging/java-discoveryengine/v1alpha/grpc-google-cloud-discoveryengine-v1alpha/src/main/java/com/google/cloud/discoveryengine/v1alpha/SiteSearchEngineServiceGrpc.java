package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing site search related resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/site_search_engine_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SiteSearchEngineServiceGrpc {

  private SiteSearchEngineServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest,
      com.google.longrunning.Operation> getRecrawlUrisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecrawlUris",
      requestType = com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest,
      com.google.longrunning.Operation> getRecrawlUrisMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest, com.google.longrunning.Operation> getRecrawlUrisMethod;
    if ((getRecrawlUrisMethod = SiteSearchEngineServiceGrpc.getRecrawlUrisMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getRecrawlUrisMethod = SiteSearchEngineServiceGrpc.getRecrawlUrisMethod) == null) {
          SiteSearchEngineServiceGrpc.getRecrawlUrisMethod = getRecrawlUrisMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecrawlUris"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("RecrawlUris"))
              .build();
        }
      }
    }
    return getRecrawlUrisMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SiteSearchEngineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceStub>() {
        @java.lang.Override
        public SiteSearchEngineServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SiteSearchEngineServiceStub(channel, callOptions);
        }
      };
    return SiteSearchEngineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SiteSearchEngineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceBlockingStub>() {
        @java.lang.Override
        public SiteSearchEngineServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SiteSearchEngineServiceBlockingStub(channel, callOptions);
        }
      };
    return SiteSearchEngineServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SiteSearchEngineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceFutureStub>() {
        @java.lang.Override
        public SiteSearchEngineServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SiteSearchEngineServiceFutureStub(channel, callOptions);
        }
      };
    return SiteSearchEngineServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    default void recrawlUris(com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecrawlUrisMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static abstract class SiteSearchEngineServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SiteSearchEngineServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static final class SiteSearchEngineServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SiteSearchEngineServiceStub> {
    private SiteSearchEngineServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SiteSearchEngineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SiteSearchEngineServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    public void recrawlUris(com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecrawlUrisMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static final class SiteSearchEngineServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SiteSearchEngineServiceBlockingStub> {
    private SiteSearchEngineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SiteSearchEngineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SiteSearchEngineServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    public com.google.longrunning.Operation recrawlUris(com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecrawlUrisMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static final class SiteSearchEngineServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SiteSearchEngineServiceFutureStub> {
    private SiteSearchEngineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SiteSearchEngineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SiteSearchEngineServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> recrawlUris(
        com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecrawlUrisMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECRAWL_URIS = 0;

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
        case METHODID_RECRAWL_URIS:
          serviceImpl.recrawlUris((com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
          getRecrawlUrisMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest,
              com.google.longrunning.Operation>(
                service, METHODID_RECRAWL_URIS)))
        .build();
  }

  private static abstract class SiteSearchEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SiteSearchEngineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SiteSearchEngineService");
    }
  }

  private static final class SiteSearchEngineServiceFileDescriptorSupplier
      extends SiteSearchEngineServiceBaseDescriptorSupplier {
    SiteSearchEngineServiceFileDescriptorSupplier() {}
  }

  private static final class SiteSearchEngineServiceMethodDescriptorSupplier
      extends SiteSearchEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SiteSearchEngineServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SiteSearchEngineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SiteSearchEngineServiceFileDescriptorSupplier())
              .addMethod(getRecrawlUrisMethod())
              .build();
        }
      }
    }
    return result;
  }
}
