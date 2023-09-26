package com.google.shopping.merchant.inventories.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service to manage regional inventory for products. There is also separate
 * `regions` resource and API to manage regions definitions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/inventories/v1beta/regionalinventory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegionalInventoryServiceGrpc {

  private RegionalInventoryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.shopping.merchant.inventories.v1beta.RegionalInventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest,
      com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse> getListRegionalInventoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRegionalInventories",
      requestType = com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest.class,
      responseType = com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest,
      com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse> getListRegionalInventoriesMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest, com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse> getListRegionalInventoriesMethod;
    if ((getListRegionalInventoriesMethod = RegionalInventoryServiceGrpc.getListRegionalInventoriesMethod) == null) {
      synchronized (RegionalInventoryServiceGrpc.class) {
        if ((getListRegionalInventoriesMethod = RegionalInventoryServiceGrpc.getListRegionalInventoriesMethod) == null) {
          RegionalInventoryServiceGrpc.getListRegionalInventoriesMethod = getListRegionalInventoriesMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest, com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRegionalInventories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegionalInventoryServiceMethodDescriptorSupplier("ListRegionalInventories"))
              .build();
        }
      }
    }
    return getListRegionalInventoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest,
      com.google.shopping.merchant.inventories.v1beta.RegionalInventory> getInsertRegionalInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertRegionalInventory",
      requestType = com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest.class,
      responseType = com.google.shopping.merchant.inventories.v1beta.RegionalInventory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest,
      com.google.shopping.merchant.inventories.v1beta.RegionalInventory> getInsertRegionalInventoryMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest, com.google.shopping.merchant.inventories.v1beta.RegionalInventory> getInsertRegionalInventoryMethod;
    if ((getInsertRegionalInventoryMethod = RegionalInventoryServiceGrpc.getInsertRegionalInventoryMethod) == null) {
      synchronized (RegionalInventoryServiceGrpc.class) {
        if ((getInsertRegionalInventoryMethod = RegionalInventoryServiceGrpc.getInsertRegionalInventoryMethod) == null) {
          RegionalInventoryServiceGrpc.getInsertRegionalInventoryMethod = getInsertRegionalInventoryMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest, com.google.shopping.merchant.inventories.v1beta.RegionalInventory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertRegionalInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.RegionalInventory.getDefaultInstance()))
              .setSchemaDescriptor(new RegionalInventoryServiceMethodDescriptorSupplier("InsertRegionalInventory"))
              .build();
        }
      }
    }
    return getInsertRegionalInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest,
      com.google.protobuf.Empty> getDeleteRegionalInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRegionalInventory",
      requestType = com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest,
      com.google.protobuf.Empty> getDeleteRegionalInventoryMethod() {
    io.grpc.MethodDescriptor<com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest, com.google.protobuf.Empty> getDeleteRegionalInventoryMethod;
    if ((getDeleteRegionalInventoryMethod = RegionalInventoryServiceGrpc.getDeleteRegionalInventoryMethod) == null) {
      synchronized (RegionalInventoryServiceGrpc.class) {
        if ((getDeleteRegionalInventoryMethod = RegionalInventoryServiceGrpc.getDeleteRegionalInventoryMethod) == null) {
          RegionalInventoryServiceGrpc.getDeleteRegionalInventoryMethod = getDeleteRegionalInventoryMethod =
              io.grpc.MethodDescriptor.<com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRegionalInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RegionalInventoryServiceMethodDescriptorSupplier("DeleteRegionalInventory"))
              .build();
        }
      }
    }
    return getDeleteRegionalInventoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegionalInventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionalInventoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegionalInventoryServiceStub>() {
        @java.lang.Override
        public RegionalInventoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegionalInventoryServiceStub(channel, callOptions);
        }
      };
    return RegionalInventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegionalInventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionalInventoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegionalInventoryServiceBlockingStub>() {
        @java.lang.Override
        public RegionalInventoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegionalInventoryServiceBlockingStub(channel, callOptions);
        }
      };
    return RegionalInventoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegionalInventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionalInventoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegionalInventoryServiceFutureStub>() {
        @java.lang.Override
        public RegionalInventoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegionalInventoryServiceFutureStub(channel, callOptions);
        }
      };
    return RegionalInventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service to manage regional inventory for products. There is also separate
   * `regions` resource and API to manage regions definitions.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists the `RegionalInventory` resources for the given product in your
     * merchant account. The response might contain fewer items than specified by
     * `pageSize`.  If `pageToken` was returned in previous request, it can be
     * used to obtain additional results.
     * `RegionalInventory` resources are listed per product for a given account.
     * </pre>
     */
    default void listRegionalInventories(com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRegionalInventoriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Inserts a `RegionalInventory` to a given product in your
     * merchant account.
     * Replaces the full `RegionalInventory` resource if an entry with the same
     * [`region`][google.shopping.merchant.inventories.v1beta.RegionalInventory.region]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `RegionalInventory`
     * resource to appear in products.
     * </pre>
     */
    default void insertRegionalInventory(com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.RegionalInventory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertRegionalInventoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified `RegionalInventory` resource from the given product
     * in your merchant account.  It might take up to an hour for the
     * `RegionalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    default void deleteRegionalInventory(com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRegionalInventoryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RegionalInventoryService.
   * <pre>
   * Service to manage regional inventory for products. There is also separate
   * `regions` resource and API to manage regions definitions.
   * </pre>
   */
  public static abstract class RegionalInventoryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RegionalInventoryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RegionalInventoryService.
   * <pre>
   * Service to manage regional inventory for products. There is also separate
   * `regions` resource and API to manage regions definitions.
   * </pre>
   */
  public static final class RegionalInventoryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RegionalInventoryServiceStub> {
    private RegionalInventoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionalInventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionalInventoryServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the `RegionalInventory` resources for the given product in your
     * merchant account. The response might contain fewer items than specified by
     * `pageSize`.  If `pageToken` was returned in previous request, it can be
     * used to obtain additional results.
     * `RegionalInventory` resources are listed per product for a given account.
     * </pre>
     */
    public void listRegionalInventories(com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRegionalInventoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Inserts a `RegionalInventory` to a given product in your
     * merchant account.
     * Replaces the full `RegionalInventory` resource if an entry with the same
     * [`region`][google.shopping.merchant.inventories.v1beta.RegionalInventory.region]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `RegionalInventory`
     * resource to appear in products.
     * </pre>
     */
    public void insertRegionalInventory(com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.RegionalInventory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertRegionalInventoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified `RegionalInventory` resource from the given product
     * in your merchant account.  It might take up to an hour for the
     * `RegionalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    public void deleteRegionalInventory(com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRegionalInventoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RegionalInventoryService.
   * <pre>
   * Service to manage regional inventory for products. There is also separate
   * `regions` resource and API to manage regions definitions.
   * </pre>
   */
  public static final class RegionalInventoryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegionalInventoryServiceBlockingStub> {
    private RegionalInventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionalInventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionalInventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the `RegionalInventory` resources for the given product in your
     * merchant account. The response might contain fewer items than specified by
     * `pageSize`.  If `pageToken` was returned in previous request, it can be
     * used to obtain additional results.
     * `RegionalInventory` resources are listed per product for a given account.
     * </pre>
     */
    public com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse listRegionalInventories(com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRegionalInventoriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Inserts a `RegionalInventory` to a given product in your
     * merchant account.
     * Replaces the full `RegionalInventory` resource if an entry with the same
     * [`region`][google.shopping.merchant.inventories.v1beta.RegionalInventory.region]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `RegionalInventory`
     * resource to appear in products.
     * </pre>
     */
    public com.google.shopping.merchant.inventories.v1beta.RegionalInventory insertRegionalInventory(com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertRegionalInventoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified `RegionalInventory` resource from the given product
     * in your merchant account.  It might take up to an hour for the
     * `RegionalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRegionalInventory(com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRegionalInventoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RegionalInventoryService.
   * <pre>
   * Service to manage regional inventory for products. There is also separate
   * `regions` resource and API to manage regions definitions.
   * </pre>
   */
  public static final class RegionalInventoryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegionalInventoryServiceFutureStub> {
    private RegionalInventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionalInventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionalInventoryServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the `RegionalInventory` resources for the given product in your
     * merchant account. The response might contain fewer items than specified by
     * `pageSize`.  If `pageToken` was returned in previous request, it can be
     * used to obtain additional results.
     * `RegionalInventory` resources are listed per product for a given account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse> listRegionalInventories(
        com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRegionalInventoriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Inserts a `RegionalInventory` to a given product in your
     * merchant account.
     * Replaces the full `RegionalInventory` resource if an entry with the same
     * [`region`][google.shopping.merchant.inventories.v1beta.RegionalInventory.region]
     * already exists for the product.
     * It might take up to 30 minutes for the new or updated `RegionalInventory`
     * resource to appear in products.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.merchant.inventories.v1beta.RegionalInventory> insertRegionalInventory(
        com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertRegionalInventoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified `RegionalInventory` resource from the given product
     * in your merchant account.  It might take up to an hour for the
     * `RegionalInventory` to be deleted from the specific product.
     * Once you have received a successful delete response, wait for that
     * period before attempting a delete again.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteRegionalInventory(
        com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRegionalInventoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_REGIONAL_INVENTORIES = 0;
  private static final int METHODID_INSERT_REGIONAL_INVENTORY = 1;
  private static final int METHODID_DELETE_REGIONAL_INVENTORY = 2;

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
        case METHODID_LIST_REGIONAL_INVENTORIES:
          serviceImpl.listRegionalInventories((com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse>) responseObserver);
          break;
        case METHODID_INSERT_REGIONAL_INVENTORY:
          serviceImpl.insertRegionalInventory((com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.inventories.v1beta.RegionalInventory>) responseObserver);
          break;
        case METHODID_DELETE_REGIONAL_INVENTORY:
          serviceImpl.deleteRegionalInventory((com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest) request,
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
          getListRegionalInventoriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesRequest,
              com.google.shopping.merchant.inventories.v1beta.ListRegionalInventoriesResponse>(
                service, METHODID_LIST_REGIONAL_INVENTORIES)))
        .addMethod(
          getInsertRegionalInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.merchant.inventories.v1beta.InsertRegionalInventoryRequest,
              com.google.shopping.merchant.inventories.v1beta.RegionalInventory>(
                service, METHODID_INSERT_REGIONAL_INVENTORY)))
        .addMethod(
          getDeleteRegionalInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.shopping.merchant.inventories.v1beta.DeleteRegionalInventoryRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_REGIONAL_INVENTORY)))
        .build();
  }

  private static abstract class RegionalInventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegionalInventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.inventories.v1beta.RegionalInventoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegionalInventoryService");
    }
  }

  private static final class RegionalInventoryServiceFileDescriptorSupplier
      extends RegionalInventoryServiceBaseDescriptorSupplier {
    RegionalInventoryServiceFileDescriptorSupplier() {}
  }

  private static final class RegionalInventoryServiceMethodDescriptorSupplier
      extends RegionalInventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RegionalInventoryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RegionalInventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegionalInventoryServiceFileDescriptorSupplier())
              .addMethod(getListRegionalInventoriesMethod())
              .addMethod(getInsertRegionalInventoryMethod())
              .addMethod(getDeleteRegionalInventoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
