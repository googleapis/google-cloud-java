package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for displaying processed
 * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the
 * customer's unstructured data.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/chunk_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChunkServiceGrpc {

  private ChunkServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.discoveryengine.v1alpha.ChunkService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetChunkRequest,
      com.google.cloud.discoveryengine.v1alpha.Chunk> getGetChunkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChunk",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetChunkRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.Chunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetChunkRequest,
      com.google.cloud.discoveryengine.v1alpha.Chunk> getGetChunkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetChunkRequest, com.google.cloud.discoveryengine.v1alpha.Chunk> getGetChunkMethod;
    if ((getGetChunkMethod = ChunkServiceGrpc.getGetChunkMethod) == null) {
      synchronized (ChunkServiceGrpc.class) {
        if ((getGetChunkMethod = ChunkServiceGrpc.getGetChunkMethod) == null) {
          ChunkServiceGrpc.getGetChunkMethod = getGetChunkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.GetChunkRequest, com.google.cloud.discoveryengine.v1alpha.Chunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChunk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.GetChunkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.Chunk.getDefaultInstance()))
              .setSchemaDescriptor(new ChunkServiceMethodDescriptorSupplier("GetChunk"))
              .build();
        }
      }
    }
    return getGetChunkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.ListChunksRequest,
      com.google.cloud.discoveryengine.v1alpha.ListChunksResponse> getListChunksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChunks",
      requestType = com.google.cloud.discoveryengine.v1alpha.ListChunksRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.ListChunksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.ListChunksRequest,
      com.google.cloud.discoveryengine.v1alpha.ListChunksResponse> getListChunksMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.ListChunksRequest, com.google.cloud.discoveryengine.v1alpha.ListChunksResponse> getListChunksMethod;
    if ((getListChunksMethod = ChunkServiceGrpc.getListChunksMethod) == null) {
      synchronized (ChunkServiceGrpc.class) {
        if ((getListChunksMethod = ChunkServiceGrpc.getListChunksMethod) == null) {
          ChunkServiceGrpc.getListChunksMethod = getListChunksMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.ListChunksRequest, com.google.cloud.discoveryengine.v1alpha.ListChunksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChunks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.ListChunksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.ListChunksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChunkServiceMethodDescriptorSupplier("ListChunks"))
              .build();
        }
      }
    }
    return getListChunksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChunkServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChunkServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChunkServiceStub>() {
        @java.lang.Override
        public ChunkServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChunkServiceStub(channel, callOptions);
        }
      };
    return ChunkServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChunkServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChunkServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChunkServiceBlockingStub>() {
        @java.lang.Override
        public ChunkServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChunkServiceBlockingStub(channel, callOptions);
        }
      };
    return ChunkServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChunkServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChunkServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChunkServiceFutureStub>() {
        @java.lang.Override
        public ChunkServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChunkServiceFutureStub(channel, callOptions);
        }
      };
    return ChunkServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for displaying processed
   * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the
   * customer's unstructured data.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
     * </pre>
     */
    default void getChunk(com.google.cloud.discoveryengine.v1alpha.GetChunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Chunk> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetChunkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
     * </pre>
     */
    default void listChunks(com.google.cloud.discoveryengine.v1alpha.ListChunksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListChunksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListChunksMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ChunkService.
   * <pre>
   * Service for displaying processed
   * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the
   * customer's unstructured data.
   * </pre>
   */
  public static abstract class ChunkServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ChunkServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ChunkService.
   * <pre>
   * Service for displaying processed
   * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the
   * customer's unstructured data.
   * </pre>
   */
  public static final class ChunkServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ChunkServiceStub> {
    private ChunkServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChunkServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChunkServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
     * </pre>
     */
    public void getChunk(com.google.cloud.discoveryengine.v1alpha.GetChunkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Chunk> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChunkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
     * </pre>
     */
    public void listChunks(com.google.cloud.discoveryengine.v1alpha.ListChunksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListChunksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChunksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ChunkService.
   * <pre>
   * Service for displaying processed
   * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the
   * customer's unstructured data.
   * </pre>
   */
  public static final class ChunkServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ChunkServiceBlockingStub> {
    private ChunkServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChunkServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChunkServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Chunk getChunk(com.google.cloud.discoveryengine.v1alpha.GetChunkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChunkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListChunksResponse listChunks(com.google.cloud.discoveryengine.v1alpha.ListChunksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChunksMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ChunkService.
   * <pre>
   * Service for displaying processed
   * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the
   * customer's unstructured data.
   * </pre>
   */
  public static final class ChunkServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ChunkServiceFutureStub> {
    private ChunkServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChunkServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChunkServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1alpha.Chunk> getChunk(
        com.google.cloud.discoveryengine.v1alpha.GetChunkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChunkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1alpha.ListChunksResponse> listChunks(
        com.google.cloud.discoveryengine.v1alpha.ListChunksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChunksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CHUNK = 0;
  private static final int METHODID_LIST_CHUNKS = 1;

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
        case METHODID_GET_CHUNK:
          serviceImpl.getChunk((com.google.cloud.discoveryengine.v1alpha.GetChunkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Chunk>) responseObserver);
          break;
        case METHODID_LIST_CHUNKS:
          serviceImpl.listChunks((com.google.cloud.discoveryengine.v1alpha.ListChunksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListChunksResponse>) responseObserver);
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
          getGetChunkMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.GetChunkRequest,
              com.google.cloud.discoveryengine.v1alpha.Chunk>(
                service, METHODID_GET_CHUNK)))
        .addMethod(
          getListChunksMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.ListChunksRequest,
              com.google.cloud.discoveryengine.v1alpha.ListChunksResponse>(
                service, METHODID_LIST_CHUNKS)))
        .build();
  }

  private static abstract class ChunkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChunkServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.ChunkServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChunkService");
    }
  }

  private static final class ChunkServiceFileDescriptorSupplier
      extends ChunkServiceBaseDescriptorSupplier {
    ChunkServiceFileDescriptorSupplier() {}
  }

  private static final class ChunkServiceMethodDescriptorSupplier
      extends ChunkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ChunkServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ChunkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChunkServiceFileDescriptorSupplier())
              .addMethod(getGetChunkMethod())
              .addMethod(getListChunksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
