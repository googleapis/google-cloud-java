package com.google.shopping.merchant.inventories.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service to manage local inventory for products
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/inventories/v1beta/localinventory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LocalInventoryServiceGrpc {

  private LocalInventoryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.shopping.merchant.inventories.v1beta.LocalInventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest,
      com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse> getListLocalInventoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLocalInventories",
      requestType = com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest.class,
      responseType = com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest,
      com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse> getListLocalInventoriesMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest, com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse> getListLocalInventoriesMethod;
    if ((getListLocalInventoriesMethod = LocalInventoryServiceGrpc.getListLocalInventoriesMethod) == null) {
      synchronized (LocalInventoryServiceGrpc.class) {
        if ((getListLocalInventoriesMethod = LocalInventoryServiceGrpc.getListLocalInventoriesMethod) == null) {
          LocalInventoryServiceGrpc.getListLocalInventoriesMethod = getListLocalInventoriesMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest, com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLocalInventories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LocalInventoryServiceMethodDescriptorSupplier("ListLocalInventories"))
              .build();
        }
      }
    }
    return getListLocalInventoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest,
      com.google.shopping.merchant.inventories.v1beta.LocalInventory> getInsertLocalInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertLocalInventory",
      requestType = com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest.class,
      responseType = com.google.shopping.merchant.inventories.v1beta.LocalInventory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest,
      com.google.shopping.merchant.inventories.v1beta.LocalInventory> getInsertLocalInventoryMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest, com.google.shopping.merchant.inventories.v1beta.LocalInventory> getInsertLocalInventoryMethod;
    if ((getInsertLocalInventoryMethod = LocalInventoryServiceGrpc.getInsertLocalInventoryMethod) == null) {
      synchronized (LocalInventoryServiceGrpc.class) {
        if ((getInsertLocalInventoryMethod = LocalInventoryServiceGrpc.getInsertLocalInventoryMethod) == null) {
          LocalInventoryServiceGrpc.getInsertLocalInventoryMethod = getInsertLocalInventoryMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest, com.google.shopping.merchant.inventories.v1beta.LocalInventory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertLocalInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.LocalInventory.getDefaultInstance()))
              .setSchemaDescriptor(new LocalInventoryServiceMethodDescriptorSupplier("InsertLocalInventory"))
              .build();
        }
      }
    }
    return getInsertLocalInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest,
      com.google.protobuf.Empty> getDeleteLocalInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLocalInventory",
      requestType = com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest,
      com.google.protobuf.Empty> getDeleteLocalInventoryMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest, com.google.protobuf.Empty> getDeleteLocalInventoryMethod;
    if ((getDeleteLocalInventoryMethod = LocalInventoryServiceGrpc.getDeleteLocalInventoryMethod) == null) {
      synchronized (LocalInventoryServiceGrpc.class) {
        if ((getDeleteLocalInventoryMethod = LocalInventoryServiceGrpc.getDeleteLocalInventoryMethod) == null) {
          LocalInventoryServiceGrpc.getDeleteLocalInventoryMethod = getDeleteLocalInventoryMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLocalInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new LocalInventoryServiceMethodDescriptorSupplier("DeleteLocalInventory"))
              .build();
        }
      }
    }
    return getDeleteLocalInventoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LocalInventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocalInventoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocalInventoryServiceStub>() {
        @java.lang.Override
        public LocalInventoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocalInventoryServiceStub(channel, callOptions);
        }
      };
    return LocalInventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LocalInventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocalInventoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocalInventoryServiceBlockingStub>() {
        @java.lang.Override
        public LocalInventoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocalInventoryServiceBlockingStub(channel, callOptions);
        }
      };
    return LocalInventoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LocalInventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocalInventoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocalInventoryServiceFutureStub>() {
        @java.lang.Override
        public LocalInventoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocalInventoryServiceFutureStub(channel, callOptions);
        }
      };
    return LocalInventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service to manage local inventory for products
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists the `LocalInventory` resources for the given product in your merchant
     * account. The response might contain fewer items than specified by
     * `pageSize`. If `pageToken` was returned in previous request, it can be used
     * to obtain additional results.
     * `LocalInventory` resources are listed per product for a given account.
     * </pre>
     */
    default void listLocalInventories(com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLocalInventoriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Inserts a `LocalInventory` resource to a product in your merchant
     * account.
     * Replaces the full `LocalInventory` resource if an entry with the same
     * [`storeCode`][google.shopping.merchant.inventories.v1beta.LocalInventory.store_code]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `LocalInventory`
     * resource to appear in products.
     * </pre>
     */
    default void insertLocalInventory(com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.LocalInventory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertLocalInventoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified `LocalInventory` from the given product in your
     * merchant account. It might take a up to an hour for the
     * `LocalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    default void deleteLocalInventory(com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteLocalInventoryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LocalInventoryService.
   * <pre>
   * Service to manage local inventory for products
   * </pre>
   */
  public static abstract class LocalInventoryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LocalInventoryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LocalInventoryService.
   * <pre>
   * Service to manage local inventory for products
   * </pre>
   */
  public static final class LocalInventoryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LocalInventoryServiceStub> {
    private LocalInventoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocalInventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocalInventoryServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the `LocalInventory` resources for the given product in your merchant
     * account. The response might contain fewer items than specified by
     * `pageSize`. If `pageToken` was returned in previous request, it can be used
     * to obtain additional results.
     * `LocalInventory` resources are listed per product for a given account.
     * </pre>
     */
    public void listLocalInventories(com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLocalInventoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Inserts a `LocalInventory` resource to a product in your merchant
     * account.
     * Replaces the full `LocalInventory` resource if an entry with the same
     * [`storeCode`][google.shopping.merchant.inventories.v1beta.LocalInventory.store_code]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `LocalInventory`
     * resource to appear in products.
     * </pre>
     */
    public void insertLocalInventory(com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.LocalInventory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertLocalInventoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified `LocalInventory` from the given product in your
     * merchant account. It might take a up to an hour for the
     * `LocalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    public void deleteLocalInventory(com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLocalInventoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LocalInventoryService.
   * <pre>
   * Service to manage local inventory for products
   * </pre>
   */
  public static final class LocalInventoryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LocalInventoryServiceBlockingStub> {
    private LocalInventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocalInventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocalInventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the `LocalInventory` resources for the given product in your merchant
     * account. The response might contain fewer items than specified by
     * `pageSize`. If `pageToken` was returned in previous request, it can be used
     * to obtain additional results.
     * `LocalInventory` resources are listed per product for a given account.
     * </pre>
     */
    public com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse listLocalInventories(com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLocalInventoriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Inserts a `LocalInventory` resource to a product in your merchant
     * account.
     * Replaces the full `LocalInventory` resource if an entry with the same
     * [`storeCode`][google.shopping.merchant.inventories.v1beta.LocalInventory.store_code]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `LocalInventory`
     * resource to appear in products.
     * </pre>
     */
    public com.google.shopping.merchant.inventories.v1beta.LocalInventory insertLocalInventory(com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertLocalInventoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified `LocalInventory` from the given product in your
     * merchant account. It might take a up to an hour for the
     * `LocalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    public com.google.protobuf.Empty deleteLocalInventory(com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLocalInventoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LocalInventoryService.
   * <pre>
   * Service to manage local inventory for products
   * </pre>
   */
  public static final class LocalInventoryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LocalInventoryServiceFutureStub> {
    private LocalInventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocalInventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocalInventoryServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the `LocalInventory` resources for the given product in your merchant
     * account. The response might contain fewer items than specified by
     * `pageSize`. If `pageToken` was returned in previous request, it can be used
     * to obtain additional results.
     * `LocalInventory` resources are listed per product for a given account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse> listLocalInventories(
        com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLocalInventoriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Inserts a `LocalInventory` resource to a product in your merchant
     * account.
     * Replaces the full `LocalInventory` resource if an entry with the same
     * [`storeCode`][google.shopping.merchant.inventories.v1beta.LocalInventory.store_code]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `LocalInventory`
     * resource to appear in products.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.merchant.inventories.v1beta.LocalInventory> insertLocalInventory(
        com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertLocalInventoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified `LocalInventory` from the given product in your
     * merchant account. It might take a up to an hour for the
     * `LocalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLocalInventory(
        com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLocalInventoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_LOCAL_INVENTORIES = 0;
  private static final int METHODID_INSERT_LOCAL_INVENTORY = 1;
  private static final int METHODID_DELETE_LOCAL_INVENTORY = 2;

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
        case METHODID_LIST_LOCAL_INVENTORIES:
          serviceImpl.listLocalInventories((com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse>) responseObserver);
          break;
        case METHODID_INSERT_LOCAL_INVENTORY:
          serviceImpl.insertLocalInventory((com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.LocalInventory>) responseObserver);
          break;
        case METHODID_DELETE_LOCAL_INVENTORY:
          serviceImpl.deleteLocalInventory((com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest) request,
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
          getListLocalInventoriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest,
              com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse>(
                service, METHODID_LIST_LOCAL_INVENTORIES)))
        .addMethod(
          getInsertLocalInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest,
              com.google.shopping.merchant.inventories.v1beta.LocalInventory>(
                service, METHODID_INSERT_LOCAL_INVENTORY)))
        .addMethod(
          getDeleteLocalInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_LOCAL_INVENTORY)))
        .build();
  }

  private static abstract class LocalInventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LocalInventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.inventories.v1beta.LocalInventoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LocalInventoryService");
    }
  }

  private static final class LocalInventoryServiceFileDescriptorSupplier
      extends LocalInventoryServiceBaseDescriptorSupplier {
    LocalInventoryServiceFileDescriptorSupplier() {}
  }

  private static final class LocalInventoryServiceMethodDescriptorSupplier
      extends LocalInventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LocalInventoryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LocalInventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LocalInventoryServiceFileDescriptorSupplier())
              .addMethod(getListLocalInventoriesMethod())
              .addMethod(getInsertLocalInventoryMethod())
              .addMethod(getDeleteLocalInventoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
