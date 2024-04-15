package com.google.cloud.support.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service to manage file attachment for Google Cloud support cases.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/support/v2/attachment_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CaseAttachmentServiceGrpc {

  private CaseAttachmentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.support.v2.CaseAttachmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.support.v2.ListAttachmentsRequest,
      com.google.cloud.support.v2.ListAttachmentsResponse> getListAttachmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAttachments",
      requestType = com.google.cloud.support.v2.ListAttachmentsRequest.class,
      responseType = com.google.cloud.support.v2.ListAttachmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.support.v2.ListAttachmentsRequest,
      com.google.cloud.support.v2.ListAttachmentsResponse> getListAttachmentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.support.v2.ListAttachmentsRequest, com.google.cloud.support.v2.ListAttachmentsResponse> getListAttachmentsMethod;
    if ((getListAttachmentsMethod = CaseAttachmentServiceGrpc.getListAttachmentsMethod) == null) {
      synchronized (CaseAttachmentServiceGrpc.class) {
        if ((getListAttachmentsMethod = CaseAttachmentServiceGrpc.getListAttachmentsMethod) == null) {
          CaseAttachmentServiceGrpc.getListAttachmentsMethod = getListAttachmentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.support.v2.ListAttachmentsRequest, com.google.cloud.support.v2.ListAttachmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAttachments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.support.v2.ListAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.support.v2.ListAttachmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CaseAttachmentServiceMethodDescriptorSupplier("ListAttachments"))
              .build();
        }
      }
    }
    return getListAttachmentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CaseAttachmentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaseAttachmentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CaseAttachmentServiceStub>() {
        @java.lang.Override
        public CaseAttachmentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CaseAttachmentServiceStub(channel, callOptions);
        }
      };
    return CaseAttachmentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CaseAttachmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaseAttachmentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CaseAttachmentServiceBlockingStub>() {
        @java.lang.Override
        public CaseAttachmentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CaseAttachmentServiceBlockingStub(channel, callOptions);
        }
      };
    return CaseAttachmentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CaseAttachmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaseAttachmentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CaseAttachmentServiceFutureStub>() {
        @java.lang.Override
        public CaseAttachmentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CaseAttachmentServiceFutureStub(channel, callOptions);
        }
      };
    return CaseAttachmentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service to manage file attachment for Google Cloud support cases.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Retrieve all attachments associated with a support case.
     * </pre>
     */
    default void listAttachments(com.google.cloud.support.v2.ListAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListAttachmentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAttachmentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CaseAttachmentService.
   * <pre>
   * A service to manage file attachment for Google Cloud support cases.
   * </pre>
   */
  public static abstract class CaseAttachmentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CaseAttachmentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CaseAttachmentService.
   * <pre>
   * A service to manage file attachment for Google Cloud support cases.
   * </pre>
   */
  public static final class CaseAttachmentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CaseAttachmentServiceStub> {
    private CaseAttachmentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaseAttachmentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaseAttachmentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve all attachments associated with a support case.
     * </pre>
     */
    public void listAttachments(com.google.cloud.support.v2.ListAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListAttachmentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAttachmentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CaseAttachmentService.
   * <pre>
   * A service to manage file attachment for Google Cloud support cases.
   * </pre>
   */
  public static final class CaseAttachmentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CaseAttachmentServiceBlockingStub> {
    private CaseAttachmentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaseAttachmentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaseAttachmentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve all attachments associated with a support case.
     * </pre>
     */
    public com.google.cloud.support.v2.ListAttachmentsResponse listAttachments(com.google.cloud.support.v2.ListAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAttachmentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CaseAttachmentService.
   * <pre>
   * A service to manage file attachment for Google Cloud support cases.
   * </pre>
   */
  public static final class CaseAttachmentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CaseAttachmentServiceFutureStub> {
    private CaseAttachmentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaseAttachmentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaseAttachmentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve all attachments associated with a support case.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.ListAttachmentsResponse> listAttachments(
        com.google.cloud.support.v2.ListAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAttachmentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ATTACHMENTS = 0;

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
        case METHODID_LIST_ATTACHMENTS:
          serviceImpl.listAttachments((com.google.cloud.support.v2.ListAttachmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListAttachmentsResponse>) responseObserver);
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
          getListAttachmentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.support.v2.ListAttachmentsRequest,
              com.google.cloud.support.v2.ListAttachmentsResponse>(
                service, METHODID_LIST_ATTACHMENTS)))
        .build();
  }

  private static abstract class CaseAttachmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CaseAttachmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.support.v2.AttachmentServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CaseAttachmentService");
    }
  }

  private static final class CaseAttachmentServiceFileDescriptorSupplier
      extends CaseAttachmentServiceBaseDescriptorSupplier {
    CaseAttachmentServiceFileDescriptorSupplier() {}
  }

  private static final class CaseAttachmentServiceMethodDescriptorSupplier
      extends CaseAttachmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CaseAttachmentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CaseAttachmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CaseAttachmentServiceFileDescriptorSupplier())
              .addMethod(getListAttachmentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
