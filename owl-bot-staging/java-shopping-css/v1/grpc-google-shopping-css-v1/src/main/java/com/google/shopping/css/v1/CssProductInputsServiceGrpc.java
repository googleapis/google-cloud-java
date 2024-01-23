package com.google.shopping.css.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service to use CssProductInput resource.
 * This service helps to insert/update/delete CSS Products.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/css/v1/css_product_inputs.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CssProductInputsServiceGrpc {

  private CssProductInputsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.shopping.css.v1.CssProductInputsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.shopping.css.v1.InsertCssProductInputRequest,
      com.google.shopping.css.v1.CssProductInput> getInsertCssProductInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertCssProductInput",
      requestType = com.google.shopping.css.v1.InsertCssProductInputRequest.class,
      responseType = com.google.shopping.css.v1.CssProductInput.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.css.v1.InsertCssProductInputRequest,
      com.google.shopping.css.v1.CssProductInput> getInsertCssProductInputMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.css.v1.InsertCssProductInputRequest, com.google.shopping.css.v1.CssProductInput> getInsertCssProductInputMethod;
    if ((getInsertCssProductInputMethod = CssProductInputsServiceGrpc.getInsertCssProductInputMethod) == null) {
      synchronized (CssProductInputsServiceGrpc.class) {
        if ((getInsertCssProductInputMethod = CssProductInputsServiceGrpc.getInsertCssProductInputMethod) == null) {
          CssProductInputsServiceGrpc.getInsertCssProductInputMethod = getInsertCssProductInputMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.css.v1.InsertCssProductInputRequest, com.google.shopping.css.v1.CssProductInput>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertCssProductInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.InsertCssProductInputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.CssProductInput.getDefaultInstance()))
              .setSchemaDescriptor(new CssProductInputsServiceMethodDescriptorSupplier("InsertCssProductInput"))
              .build();
        }
      }
    }
    return getInsertCssProductInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.css.v1.DeleteCssProductInputRequest,
      com.google.protobuf.Empty> getDeleteCssProductInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCssProductInput",
      requestType = com.google.shopping.css.v1.DeleteCssProductInputRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.css.v1.DeleteCssProductInputRequest,
      com.google.protobuf.Empty> getDeleteCssProductInputMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.css.v1.DeleteCssProductInputRequest, com.google.protobuf.Empty> getDeleteCssProductInputMethod;
    if ((getDeleteCssProductInputMethod = CssProductInputsServiceGrpc.getDeleteCssProductInputMethod) == null) {
      synchronized (CssProductInputsServiceGrpc.class) {
        if ((getDeleteCssProductInputMethod = CssProductInputsServiceGrpc.getDeleteCssProductInputMethod) == null) {
          CssProductInputsServiceGrpc.getDeleteCssProductInputMethod = getDeleteCssProductInputMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.css.v1.DeleteCssProductInputRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCssProductInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.DeleteCssProductInputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CssProductInputsServiceMethodDescriptorSupplier("DeleteCssProductInput"))
              .build();
        }
      }
    }
    return getDeleteCssProductInputMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CssProductInputsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CssProductInputsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CssProductInputsServiceStub>() {
        @java.lang.Override
        public CssProductInputsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CssProductInputsServiceStub(channel, callOptions);
        }
      };
    return CssProductInputsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CssProductInputsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CssProductInputsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CssProductInputsServiceBlockingStub>() {
        @java.lang.Override
        public CssProductInputsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CssProductInputsServiceBlockingStub(channel, callOptions);
        }
      };
    return CssProductInputsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CssProductInputsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CssProductInputsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CssProductInputsServiceFutureStub>() {
        @java.lang.Override
        public CssProductInputsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CssProductInputsServiceFutureStub(channel, callOptions);
        }
      };
    return CssProductInputsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service to use CssProductInput resource.
   * This service helps to insert/update/delete CSS Products.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Uploads a CssProductInput to your CSS Center account. If an
     * input with the same contentLanguage, identity, feedLabel and feedId already
     * exists, this method replaces that entry.
     * After inserting, updating, or deleting a CSS Product input, it may
     * take several minutes before the processed CSS Product can be retrieved.
     * </pre>
     */
    default void insertCssProductInput(com.google.shopping.css.v1.InsertCssProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.CssProductInput> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertCssProductInputMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a CSS Product input from your CSS Center account.
     * After a delete it may take several minutes until the input is no longer
     * available.
     * </pre>
     */
    default void deleteCssProductInput(com.google.shopping.css.v1.DeleteCssProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCssProductInputMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CssProductInputsService.
   * <pre>
   * Service to use CssProductInput resource.
   * This service helps to insert/update/delete CSS Products.
   * </pre>
   */
  public static abstract class CssProductInputsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CssProductInputsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CssProductInputsService.
   * <pre>
   * Service to use CssProductInput resource.
   * This service helps to insert/update/delete CSS Products.
   * </pre>
   */
  public static final class CssProductInputsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CssProductInputsServiceStub> {
    private CssProductInputsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CssProductInputsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CssProductInputsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Uploads a CssProductInput to your CSS Center account. If an
     * input with the same contentLanguage, identity, feedLabel and feedId already
     * exists, this method replaces that entry.
     * After inserting, updating, or deleting a CSS Product input, it may
     * take several minutes before the processed CSS Product can be retrieved.
     * </pre>
     */
    public void insertCssProductInput(com.google.shopping.css.v1.InsertCssProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.CssProductInput> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertCssProductInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a CSS Product input from your CSS Center account.
     * After a delete it may take several minutes until the input is no longer
     * available.
     * </pre>
     */
    public void deleteCssProductInput(com.google.shopping.css.v1.DeleteCssProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCssProductInputMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CssProductInputsService.
   * <pre>
   * Service to use CssProductInput resource.
   * This service helps to insert/update/delete CSS Products.
   * </pre>
   */
  public static final class CssProductInputsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CssProductInputsServiceBlockingStub> {
    private CssProductInputsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CssProductInputsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CssProductInputsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Uploads a CssProductInput to your CSS Center account. If an
     * input with the same contentLanguage, identity, feedLabel and feedId already
     * exists, this method replaces that entry.
     * After inserting, updating, or deleting a CSS Product input, it may
     * take several minutes before the processed CSS Product can be retrieved.
     * </pre>
     */
    public com.google.shopping.css.v1.CssProductInput insertCssProductInput(com.google.shopping.css.v1.InsertCssProductInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertCssProductInputMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a CSS Product input from your CSS Center account.
     * After a delete it may take several minutes until the input is no longer
     * available.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCssProductInput(com.google.shopping.css.v1.DeleteCssProductInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCssProductInputMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CssProductInputsService.
   * <pre>
   * Service to use CssProductInput resource.
   * This service helps to insert/update/delete CSS Products.
   * </pre>
   */
  public static final class CssProductInputsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CssProductInputsServiceFutureStub> {
    private CssProductInputsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CssProductInputsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CssProductInputsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Uploads a CssProductInput to your CSS Center account. If an
     * input with the same contentLanguage, identity, feedLabel and feedId already
     * exists, this method replaces that entry.
     * After inserting, updating, or deleting a CSS Product input, it may
     * take several minutes before the processed CSS Product can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.css.v1.CssProductInput> insertCssProductInput(
        com.google.shopping.css.v1.InsertCssProductInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertCssProductInputMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a CSS Product input from your CSS Center account.
     * After a delete it may take several minutes until the input is no longer
     * available.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteCssProductInput(
        com.google.shopping.css.v1.DeleteCssProductInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCssProductInputMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_CSS_PRODUCT_INPUT = 0;
  private static final int METHODID_DELETE_CSS_PRODUCT_INPUT = 1;

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
        case METHODID_INSERT_CSS_PRODUCT_INPUT:
          serviceImpl.insertCssProductInput((com.google.shopping.css.v1.InsertCssProductInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.CssProductInput>) responseObserver);
          break;
        case METHODID_DELETE_CSS_PRODUCT_INPUT:
          serviceImpl.deleteCssProductInput((com.google.shopping.css.v1.DeleteCssProductInputRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getInsertCssProductInputMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.css.v1.InsertCssProductInputRequest,
              com.google.shopping.css.v1.CssProductInput>(
                service, METHODID_INSERT_CSS_PRODUCT_INPUT)))
        .addMethod(
          getDeleteCssProductInputMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.css.v1.DeleteCssProductInputRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_CSS_PRODUCT_INPUT)))
        .build();
  }

  private static abstract class CssProductInputsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CssProductInputsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.css.v1.CssProductInputsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CssProductInputsService");
    }
  }

  private static final class CssProductInputsServiceFileDescriptorSupplier
      extends CssProductInputsServiceBaseDescriptorSupplier {
    CssProductInputsServiceFileDescriptorSupplier() {}
  }

  private static final class CssProductInputsServiceMethodDescriptorSupplier
      extends CssProductInputsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CssProductInputsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CssProductInputsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CssProductInputsServiceFileDescriptorSupplier())
              .addMethod(getInsertCssProductInputMethod())
              .addMethod(getDeleteCssProductInputMethod())
              .build();
        }
      }
    }
    return result;
  }
}
