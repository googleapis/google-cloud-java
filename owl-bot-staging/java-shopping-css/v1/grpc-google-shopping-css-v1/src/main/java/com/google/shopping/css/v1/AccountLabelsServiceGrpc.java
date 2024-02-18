package com.google.shopping.css.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages Merchant Center and CSS accounts labels.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/css/v1/accounts_labels.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountLabelsServiceGrpc {

  private AccountLabelsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.shopping.css.v1.AccountLabelsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.shopping.css.v1.ListAccountLabelsRequest,
      com.google.shopping.css.v1.ListAccountLabelsResponse> getListAccountLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountLabels",
      requestType = com.google.shopping.css.v1.ListAccountLabelsRequest.class,
      responseType = com.google.shopping.css.v1.ListAccountLabelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.css.v1.ListAccountLabelsRequest,
      com.google.shopping.css.v1.ListAccountLabelsResponse> getListAccountLabelsMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.css.v1.ListAccountLabelsRequest, com.google.shopping.css.v1.ListAccountLabelsResponse> getListAccountLabelsMethod;
    if ((getListAccountLabelsMethod = AccountLabelsServiceGrpc.getListAccountLabelsMethod) == null) {
      synchronized (AccountLabelsServiceGrpc.class) {
        if ((getListAccountLabelsMethod = AccountLabelsServiceGrpc.getListAccountLabelsMethod) == null) {
          AccountLabelsServiceGrpc.getListAccountLabelsMethod = getListAccountLabelsMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.css.v1.ListAccountLabelsRequest, com.google.shopping.css.v1.ListAccountLabelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccountLabels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.ListAccountLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.ListAccountLabelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountLabelsServiceMethodDescriptorSupplier("ListAccountLabels"))
              .build();
        }
      }
    }
    return getListAccountLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.css.v1.CreateAccountLabelRequest,
      com.google.shopping.css.v1.AccountLabel> getCreateAccountLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccountLabel",
      requestType = com.google.shopping.css.v1.CreateAccountLabelRequest.class,
      responseType = com.google.shopping.css.v1.AccountLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.css.v1.CreateAccountLabelRequest,
      com.google.shopping.css.v1.AccountLabel> getCreateAccountLabelMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.css.v1.CreateAccountLabelRequest, com.google.shopping.css.v1.AccountLabel> getCreateAccountLabelMethod;
    if ((getCreateAccountLabelMethod = AccountLabelsServiceGrpc.getCreateAccountLabelMethod) == null) {
      synchronized (AccountLabelsServiceGrpc.class) {
        if ((getCreateAccountLabelMethod = AccountLabelsServiceGrpc.getCreateAccountLabelMethod) == null) {
          AccountLabelsServiceGrpc.getCreateAccountLabelMethod = getCreateAccountLabelMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.css.v1.CreateAccountLabelRequest, com.google.shopping.css.v1.AccountLabel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccountLabel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.CreateAccountLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.AccountLabel.getDefaultInstance()))
              .setSchemaDescriptor(new AccountLabelsServiceMethodDescriptorSupplier("CreateAccountLabel"))
              .build();
        }
      }
    }
    return getCreateAccountLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.css.v1.UpdateAccountLabelRequest,
      com.google.shopping.css.v1.AccountLabel> getUpdateAccountLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccountLabel",
      requestType = com.google.shopping.css.v1.UpdateAccountLabelRequest.class,
      responseType = com.google.shopping.css.v1.AccountLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.css.v1.UpdateAccountLabelRequest,
      com.google.shopping.css.v1.AccountLabel> getUpdateAccountLabelMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.css.v1.UpdateAccountLabelRequest, com.google.shopping.css.v1.AccountLabel> getUpdateAccountLabelMethod;
    if ((getUpdateAccountLabelMethod = AccountLabelsServiceGrpc.getUpdateAccountLabelMethod) == null) {
      synchronized (AccountLabelsServiceGrpc.class) {
        if ((getUpdateAccountLabelMethod = AccountLabelsServiceGrpc.getUpdateAccountLabelMethod) == null) {
          AccountLabelsServiceGrpc.getUpdateAccountLabelMethod = getUpdateAccountLabelMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.css.v1.UpdateAccountLabelRequest, com.google.shopping.css.v1.AccountLabel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccountLabel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.UpdateAccountLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.AccountLabel.getDefaultInstance()))
              .setSchemaDescriptor(new AccountLabelsServiceMethodDescriptorSupplier("UpdateAccountLabel"))
              .build();
        }
      }
    }
    return getUpdateAccountLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.css.v1.DeleteAccountLabelRequest,
      com.google.protobuf.Empty> getDeleteAccountLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccountLabel",
      requestType = com.google.shopping.css.v1.DeleteAccountLabelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.css.v1.DeleteAccountLabelRequest,
      com.google.protobuf.Empty> getDeleteAccountLabelMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.css.v1.DeleteAccountLabelRequest, com.google.protobuf.Empty> getDeleteAccountLabelMethod;
    if ((getDeleteAccountLabelMethod = AccountLabelsServiceGrpc.getDeleteAccountLabelMethod) == null) {
      synchronized (AccountLabelsServiceGrpc.class) {
        if ((getDeleteAccountLabelMethod = AccountLabelsServiceGrpc.getDeleteAccountLabelMethod) == null) {
          AccountLabelsServiceGrpc.getDeleteAccountLabelMethod = getDeleteAccountLabelMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.css.v1.DeleteAccountLabelRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccountLabel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.css.v1.DeleteAccountLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AccountLabelsServiceMethodDescriptorSupplier("DeleteAccountLabel"))
              .build();
        }
      }
    }
    return getDeleteAccountLabelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountLabelsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountLabelsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountLabelsServiceStub>() {
        @java.lang.Override
        public AccountLabelsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountLabelsServiceStub(channel, callOptions);
        }
      };
    return AccountLabelsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountLabelsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountLabelsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountLabelsServiceBlockingStub>() {
        @java.lang.Override
        public AccountLabelsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountLabelsServiceBlockingStub(channel, callOptions);
        }
      };
    return AccountLabelsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountLabelsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountLabelsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountLabelsServiceFutureStub>() {
        @java.lang.Override
        public AccountLabelsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountLabelsServiceFutureStub(channel, callOptions);
        }
      };
    return AccountLabelsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages Merchant Center and CSS accounts labels.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists the labels assigned to an account.
     * </pre>
     */
    default void listAccountLabels(com.google.shopping.css.v1.ListAccountLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListAccountLabelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAccountLabelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new label, not assigned to any account.
     * </pre>
     */
    default void createAccountLabel(com.google.shopping.css.v1.CreateAccountLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.AccountLabel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountLabelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a label.
     * </pre>
     */
    default void updateAccountLabel(com.google.shopping.css.v1.UpdateAccountLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.AccountLabel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAccountLabelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a label and removes it from all accounts to which it was assigned.
     * </pre>
     */
    default void deleteAccountLabel(com.google.shopping.css.v1.DeleteAccountLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAccountLabelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountLabelsService.
   * <pre>
   * Manages Merchant Center and CSS accounts labels.
   * </pre>
   */
  public static abstract class AccountLabelsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AccountLabelsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountLabelsService.
   * <pre>
   * Manages Merchant Center and CSS accounts labels.
   * </pre>
   */
  public static final class AccountLabelsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountLabelsServiceStub> {
    private AccountLabelsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountLabelsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountLabelsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the labels assigned to an account.
     * </pre>
     */
    public void listAccountLabels(com.google.shopping.css.v1.ListAccountLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListAccountLabelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountLabelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new label, not assigned to any account.
     * </pre>
     */
    public void createAccountLabel(com.google.shopping.css.v1.CreateAccountLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.AccountLabel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountLabelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a label.
     * </pre>
     */
    public void updateAccountLabel(com.google.shopping.css.v1.UpdateAccountLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.AccountLabel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountLabelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a label and removes it from all accounts to which it was assigned.
     * </pre>
     */
    public void deleteAccountLabel(com.google.shopping.css.v1.DeleteAccountLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccountLabelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountLabelsService.
   * <pre>
   * Manages Merchant Center and CSS accounts labels.
   * </pre>
   */
  public static final class AccountLabelsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountLabelsServiceBlockingStub> {
    private AccountLabelsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountLabelsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountLabelsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the labels assigned to an account.
     * </pre>
     */
    public com.google.shopping.css.v1.ListAccountLabelsResponse listAccountLabels(com.google.shopping.css.v1.ListAccountLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountLabelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new label, not assigned to any account.
     * </pre>
     */
    public com.google.shopping.css.v1.AccountLabel createAccountLabel(com.google.shopping.css.v1.CreateAccountLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountLabelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a label.
     * </pre>
     */
    public com.google.shopping.css.v1.AccountLabel updateAccountLabel(com.google.shopping.css.v1.UpdateAccountLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountLabelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a label and removes it from all accounts to which it was assigned.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAccountLabel(com.google.shopping.css.v1.DeleteAccountLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccountLabelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountLabelsService.
   * <pre>
   * Manages Merchant Center and CSS accounts labels.
   * </pre>
   */
  public static final class AccountLabelsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountLabelsServiceFutureStub> {
    private AccountLabelsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountLabelsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountLabelsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the labels assigned to an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.css.v1.ListAccountLabelsResponse> listAccountLabels(
        com.google.shopping.css.v1.ListAccountLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountLabelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new label, not assigned to any account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.css.v1.AccountLabel> createAccountLabel(
        com.google.shopping.css.v1.CreateAccountLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountLabelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a label.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.css.v1.AccountLabel> updateAccountLabel(
        com.google.shopping.css.v1.UpdateAccountLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountLabelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a label and removes it from all accounts to which it was assigned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAccountLabel(
        com.google.shopping.css.v1.DeleteAccountLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccountLabelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ACCOUNT_LABELS = 0;
  private static final int METHODID_CREATE_ACCOUNT_LABEL = 1;
  private static final int METHODID_UPDATE_ACCOUNT_LABEL = 2;
  private static final int METHODID_DELETE_ACCOUNT_LABEL = 3;

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
        case METHODID_LIST_ACCOUNT_LABELS:
          serviceImpl.listAccountLabels((com.google.shopping.css.v1.ListAccountLabelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListAccountLabelsResponse>) responseObserver);
          break;
        case METHODID_CREATE_ACCOUNT_LABEL:
          serviceImpl.createAccountLabel((com.google.shopping.css.v1.CreateAccountLabelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.AccountLabel>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT_LABEL:
          serviceImpl.updateAccountLabel((com.google.shopping.css.v1.UpdateAccountLabelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.AccountLabel>) responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT_LABEL:
          serviceImpl.deleteAccountLabel((com.google.shopping.css.v1.DeleteAccountLabelRequest) request,
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
          getListAccountLabelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.css.v1.ListAccountLabelsRequest,
              com.google.shopping.css.v1.ListAccountLabelsResponse>(
                service, METHODID_LIST_ACCOUNT_LABELS)))
        .addMethod(
          getCreateAccountLabelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.css.v1.CreateAccountLabelRequest,
              com.google.shopping.css.v1.AccountLabel>(
                service, METHODID_CREATE_ACCOUNT_LABEL)))
        .addMethod(
          getUpdateAccountLabelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.css.v1.UpdateAccountLabelRequest,
              com.google.shopping.css.v1.AccountLabel>(
                service, METHODID_UPDATE_ACCOUNT_LABEL)))
        .addMethod(
          getDeleteAccountLabelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.css.v1.DeleteAccountLabelRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_ACCOUNT_LABEL)))
        .build();
  }

  private static abstract class AccountLabelsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountLabelsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.css.v1.AccountsLabelsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountLabelsService");
    }
  }

  private static final class AccountLabelsServiceFileDescriptorSupplier
      extends AccountLabelsServiceBaseDescriptorSupplier {
    AccountLabelsServiceFileDescriptorSupplier() {}
  }

  private static final class AccountLabelsServiceMethodDescriptorSupplier
      extends AccountLabelsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountLabelsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountLabelsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountLabelsServiceFileDescriptorSupplier())
              .addMethod(getListAccountLabelsMethod())
              .addMethod(getCreateAccountLabelMethod())
              .addMethod(getUpdateAccountLabelMethod())
              .addMethod(getDeleteAccountLabelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
