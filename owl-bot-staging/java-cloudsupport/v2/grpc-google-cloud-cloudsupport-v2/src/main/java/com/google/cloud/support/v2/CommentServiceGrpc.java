package com.google.cloud.support.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service to manage comments on cases.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/support/v2/comment_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommentServiceGrpc {

  private CommentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.support.v2.CommentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.support.v2.ListCommentsRequest,
      com.google.cloud.support.v2.ListCommentsResponse> getListCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListComments",
      requestType = com.google.cloud.support.v2.ListCommentsRequest.class,
      responseType = com.google.cloud.support.v2.ListCommentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.support.v2.ListCommentsRequest,
      com.google.cloud.support.v2.ListCommentsResponse> getListCommentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.support.v2.ListCommentsRequest, com.google.cloud.support.v2.ListCommentsResponse> getListCommentsMethod;
    if ((getListCommentsMethod = CommentServiceGrpc.getListCommentsMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getListCommentsMethod = CommentServiceGrpc.getListCommentsMethod) == null) {
          CommentServiceGrpc.getListCommentsMethod = getListCommentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.support.v2.ListCommentsRequest, com.google.cloud.support.v2.ListCommentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListComments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.support.v2.ListCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.support.v2.ListCommentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("ListComments"))
              .build();
        }
      }
    }
    return getListCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.support.v2.CreateCommentRequest,
      com.google.cloud.support.v2.Comment> getCreateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateComment",
      requestType = com.google.cloud.support.v2.CreateCommentRequest.class,
      responseType = com.google.cloud.support.v2.Comment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.support.v2.CreateCommentRequest,
      com.google.cloud.support.v2.Comment> getCreateCommentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.support.v2.CreateCommentRequest, com.google.cloud.support.v2.Comment> getCreateCommentMethod;
    if ((getCreateCommentMethod = CommentServiceGrpc.getCreateCommentMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getCreateCommentMethod = CommentServiceGrpc.getCreateCommentMethod) == null) {
          CommentServiceGrpc.getCreateCommentMethod = getCreateCommentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.support.v2.CreateCommentRequest, com.google.cloud.support.v2.Comment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.support.v2.CreateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.support.v2.Comment.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("CreateComment"))
              .build();
        }
      }
    }
    return getCreateCommentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceStub>() {
        @java.lang.Override
        public CommentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceStub(channel, callOptions);
        }
      };
    return CommentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceBlockingStub>() {
        @java.lang.Override
        public CommentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceBlockingStub(channel, callOptions);
        }
      };
    return CommentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceFutureStub>() {
        @java.lang.Override
        public CommentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceFutureStub(channel, callOptions);
        }
      };
    return CommentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service to manage comments on cases.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Retrieve all Comments associated with the Case object.
     * </pre>
     */
    default void listComments(com.google.cloud.support.v2.ListCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListCommentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCommentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Add a new comment to the specified Case.
     * The comment object must have the following fields set: body.
     * </pre>
     */
    default void createComment(com.google.cloud.support.v2.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Comment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCommentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CommentService.
   * <pre>
   * A service to manage comments on cases.
   * </pre>
   */
  public static abstract class CommentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CommentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CommentService.
   * <pre>
   * A service to manage comments on cases.
   * </pre>
   */
  public static final class CommentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CommentServiceStub> {
    private CommentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve all Comments associated with the Case object.
     * </pre>
     */
    public void listComments(com.google.cloud.support.v2.ListCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListCommentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCommentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Add a new comment to the specified Case.
     * The comment object must have the following fields set: body.
     * </pre>
     */
    public void createComment(com.google.cloud.support.v2.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Comment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CommentService.
   * <pre>
   * A service to manage comments on cases.
   * </pre>
   */
  public static final class CommentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CommentServiceBlockingStub> {
    private CommentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve all Comments associated with the Case object.
     * </pre>
     */
    public com.google.cloud.support.v2.ListCommentsResponse listComments(com.google.cloud.support.v2.ListCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCommentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Add a new comment to the specified Case.
     * The comment object must have the following fields set: body.
     * </pre>
     */
    public com.google.cloud.support.v2.Comment createComment(com.google.cloud.support.v2.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCommentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CommentService.
   * <pre>
   * A service to manage comments on cases.
   * </pre>
   */
  public static final class CommentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CommentServiceFutureStub> {
    private CommentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve all Comments associated with the Case object.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.ListCommentsResponse> listComments(
        com.google.cloud.support.v2.ListCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCommentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Add a new comment to the specified Case.
     * The comment object must have the following fields set: body.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.Comment> createComment(
        com.google.cloud.support.v2.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_COMMENTS = 0;
  private static final int METHODID_CREATE_COMMENT = 1;

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
        case METHODID_LIST_COMMENTS:
          serviceImpl.listComments((com.google.cloud.support.v2.ListCommentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListCommentsResponse>) responseObserver);
          break;
        case METHODID_CREATE_COMMENT:
          serviceImpl.createComment((com.google.cloud.support.v2.CreateCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Comment>) responseObserver);
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
          getListCommentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.support.v2.ListCommentsRequest,
              com.google.cloud.support.v2.ListCommentsResponse>(
                service, METHODID_LIST_COMMENTS)))
        .addMethod(
          getCreateCommentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.support.v2.CreateCommentRequest,
              com.google.cloud.support.v2.Comment>(
                service, METHODID_CREATE_COMMENT)))
        .build();
  }

  private static abstract class CommentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.support.v2.CommentServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommentService");
    }
  }

  private static final class CommentServiceFileDescriptorSupplier
      extends CommentServiceBaseDescriptorSupplier {
    CommentServiceFileDescriptorSupplier() {}
  }

  private static final class CommentServiceMethodDescriptorSupplier
      extends CommentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CommentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CommentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommentServiceFileDescriptorSupplier())
              .addMethod(getListCommentsMethod())
              .addMethod(getCreateCommentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
