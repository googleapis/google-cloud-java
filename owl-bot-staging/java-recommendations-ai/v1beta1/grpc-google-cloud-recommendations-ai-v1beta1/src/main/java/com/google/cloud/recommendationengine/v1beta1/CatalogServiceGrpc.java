package com.google.cloud.recommendationengine.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for ingesting catalog information of the customer's website.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/recommendationengine/v1beta1/catalog_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CatalogServiceGrpc {

  private CatalogServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.recommendationengine.v1beta1.CatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest,
      com.google.cloud.recommendationengine.v1beta1.CatalogItem> getCreateCatalogItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCatalogItem",
      requestType = com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest.class,
      responseType = com.google.cloud.recommendationengine.v1beta1.CatalogItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest,
      com.google.cloud.recommendationengine.v1beta1.CatalogItem> getCreateCatalogItemMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest, com.google.cloud.recommendationengine.v1beta1.CatalogItem> getCreateCatalogItemMethod;
    if ((getCreateCatalogItemMethod = CatalogServiceGrpc.getCreateCatalogItemMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getCreateCatalogItemMethod = CatalogServiceGrpc.getCreateCatalogItemMethod) == null) {
          CatalogServiceGrpc.getCreateCatalogItemMethod = getCreateCatalogItemMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest, com.google.cloud.recommendationengine.v1beta1.CatalogItem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCatalogItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.CatalogItem.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("CreateCatalogItem"))
              .build();
        }
      }
    }
    return getCreateCatalogItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest,
      com.google.cloud.recommendationengine.v1beta1.CatalogItem> getGetCatalogItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCatalogItem",
      requestType = com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest.class,
      responseType = com.google.cloud.recommendationengine.v1beta1.CatalogItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest,
      com.google.cloud.recommendationengine.v1beta1.CatalogItem> getGetCatalogItemMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest, com.google.cloud.recommendationengine.v1beta1.CatalogItem> getGetCatalogItemMethod;
    if ((getGetCatalogItemMethod = CatalogServiceGrpc.getGetCatalogItemMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetCatalogItemMethod = CatalogServiceGrpc.getGetCatalogItemMethod) == null) {
          CatalogServiceGrpc.getGetCatalogItemMethod = getGetCatalogItemMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest, com.google.cloud.recommendationengine.v1beta1.CatalogItem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCatalogItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.CatalogItem.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetCatalogItem"))
              .build();
        }
      }
    }
    return getGetCatalogItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest,
      com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse> getListCatalogItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogItems",
      requestType = com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest.class,
      responseType = com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest,
      com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse> getListCatalogItemsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest, com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse> getListCatalogItemsMethod;
    if ((getListCatalogItemsMethod = CatalogServiceGrpc.getListCatalogItemsMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListCatalogItemsMethod = CatalogServiceGrpc.getListCatalogItemsMethod) == null) {
          CatalogServiceGrpc.getListCatalogItemsMethod = getListCatalogItemsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest, com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCatalogItems"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ListCatalogItems"))
              .build();
        }
      }
    }
    return getListCatalogItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest,
      com.google.cloud.recommendationengine.v1beta1.CatalogItem> getUpdateCatalogItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCatalogItem",
      requestType = com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest.class,
      responseType = com.google.cloud.recommendationengine.v1beta1.CatalogItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest,
      com.google.cloud.recommendationengine.v1beta1.CatalogItem> getUpdateCatalogItemMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest, com.google.cloud.recommendationengine.v1beta1.CatalogItem> getUpdateCatalogItemMethod;
    if ((getUpdateCatalogItemMethod = CatalogServiceGrpc.getUpdateCatalogItemMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateCatalogItemMethod = CatalogServiceGrpc.getUpdateCatalogItemMethod) == null) {
          CatalogServiceGrpc.getUpdateCatalogItemMethod = getUpdateCatalogItemMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest, com.google.cloud.recommendationengine.v1beta1.CatalogItem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCatalogItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.CatalogItem.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateCatalogItem"))
              .build();
        }
      }
    }
    return getUpdateCatalogItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest,
      com.google.protobuf.Empty> getDeleteCatalogItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCatalogItem",
      requestType = com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest,
      com.google.protobuf.Empty> getDeleteCatalogItemMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest, com.google.protobuf.Empty> getDeleteCatalogItemMethod;
    if ((getDeleteCatalogItemMethod = CatalogServiceGrpc.getDeleteCatalogItemMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getDeleteCatalogItemMethod = CatalogServiceGrpc.getDeleteCatalogItemMethod) == null) {
          CatalogServiceGrpc.getDeleteCatalogItemMethod = getDeleteCatalogItemMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCatalogItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("DeleteCatalogItem"))
              .build();
        }
      }
    }
    return getDeleteCatalogItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest,
      com.google.longrunning.Operation> getImportCatalogItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportCatalogItems",
      requestType = com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest,
      com.google.longrunning.Operation> getImportCatalogItemsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest, com.google.longrunning.Operation> getImportCatalogItemsMethod;
    if ((getImportCatalogItemsMethod = CatalogServiceGrpc.getImportCatalogItemsMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getImportCatalogItemsMethod = CatalogServiceGrpc.getImportCatalogItemsMethod) == null) {
          CatalogServiceGrpc.getImportCatalogItemsMethod = getImportCatalogItemsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportCatalogItems"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ImportCatalogItems"))
              .build();
        }
      }
    }
    return getImportCatalogItemsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub>() {
        @java.lang.Override
        public CatalogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceStub(channel, callOptions);
        }
      };
    return CatalogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CatalogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub>() {
        @java.lang.Override
        public CatalogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceBlockingStub(channel, callOptions);
        }
      };
    return CatalogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CatalogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub>() {
        @java.lang.Override
        public CatalogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceFutureStub(channel, callOptions);
        }
      };
    return CatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for ingesting catalog information of the customer's website.
   * </pre>
   */
  public static abstract class CatalogServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a catalog item.
     * </pre>
     */
    public void createCatalogItem(com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCatalogItemMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a specific catalog item.
     * </pre>
     */
    public void getCatalogItem(com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCatalogItemMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a list of catalog items.
     * </pre>
     */
    public void listCatalogItems(com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCatalogItemsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a catalog item. Partial updating is supported. Non-existing
     * items will be created.
     * </pre>
     */
    public void updateCatalogItem(com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCatalogItemMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a catalog item.
     * </pre>
     */
    public void deleteCatalogItem(com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCatalogItemMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bulk import of multiple catalog items. Request processing may be
     * synchronous. No partial updating supported. Non-existing items will be
     * created.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully updated.
     * </pre>
     */
    public void importCatalogItems(com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportCatalogItemsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCatalogItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest,
                com.google.cloud.recommendationengine.v1beta1.CatalogItem>(
                  this, METHODID_CREATE_CATALOG_ITEM)))
          .addMethod(
            getGetCatalogItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest,
                com.google.cloud.recommendationengine.v1beta1.CatalogItem>(
                  this, METHODID_GET_CATALOG_ITEM)))
          .addMethod(
            getListCatalogItemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest,
                com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse>(
                  this, METHODID_LIST_CATALOG_ITEMS)))
          .addMethod(
            getUpdateCatalogItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest,
                com.google.cloud.recommendationengine.v1beta1.CatalogItem>(
                  this, METHODID_UPDATE_CATALOG_ITEM)))
          .addMethod(
            getDeleteCatalogItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CATALOG_ITEM)))
          .addMethod(
            getImportCatalogItemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_IMPORT_CATALOG_ITEMS)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for ingesting catalog information of the customer's website.
   * </pre>
   */
  public static final class CatalogServiceStub extends io.grpc.stub.AbstractAsyncStub<CatalogServiceStub> {
    private CatalogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a catalog item.
     * </pre>
     */
    public void createCatalogItem(com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCatalogItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a specific catalog item.
     * </pre>
     */
    public void getCatalogItem(com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCatalogItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a list of catalog items.
     * </pre>
     */
    public void listCatalogItems(com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCatalogItemsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a catalog item. Partial updating is supported. Non-existing
     * items will be created.
     * </pre>
     */
    public void updateCatalogItem(com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCatalogItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a catalog item.
     * </pre>
     */
    public void deleteCatalogItem(com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCatalogItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Bulk import of multiple catalog items. Request processing may be
     * synchronous. No partial updating supported. Non-existing items will be
     * created.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully updated.
     * </pre>
     */
    public void importCatalogItems(com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportCatalogItemsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for ingesting catalog information of the customer's website.
   * </pre>
   */
  public static final class CatalogServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CatalogServiceBlockingStub> {
    private CatalogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a catalog item.
     * </pre>
     */
    public com.google.cloud.recommendationengine.v1beta1.CatalogItem createCatalogItem(com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCatalogItemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a specific catalog item.
     * </pre>
     */
    public com.google.cloud.recommendationengine.v1beta1.CatalogItem getCatalogItem(com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCatalogItemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a list of catalog items.
     * </pre>
     */
    public com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse listCatalogItems(com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCatalogItemsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a catalog item. Partial updating is supported. Non-existing
     * items will be created.
     * </pre>
     */
    public com.google.cloud.recommendationengine.v1beta1.CatalogItem updateCatalogItem(com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCatalogItemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a catalog item.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCatalogItem(com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCatalogItemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Bulk import of multiple catalog items. Request processing may be
     * synchronous. No partial updating supported. Non-existing items will be
     * created.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully updated.
     * </pre>
     */
    public com.google.longrunning.Operation importCatalogItems(com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportCatalogItemsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for ingesting catalog information of the customer's website.
   * </pre>
   */
  public static final class CatalogServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CatalogServiceFutureStub> {
    private CatalogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a catalog item.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommendationengine.v1beta1.CatalogItem> createCatalogItem(
        com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCatalogItemMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a specific catalog item.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommendationengine.v1beta1.CatalogItem> getCatalogItem(
        com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCatalogItemMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a list of catalog items.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse> listCatalogItems(
        com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCatalogItemsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a catalog item. Partial updating is supported. Non-existing
     * items will be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommendationengine.v1beta1.CatalogItem> updateCatalogItem(
        com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCatalogItemMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a catalog item.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteCatalogItem(
        com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCatalogItemMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Bulk import of multiple catalog items. Request processing may be
     * synchronous. No partial updating supported. Non-existing items will be
     * created.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> importCatalogItems(
        com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportCatalogItemsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CATALOG_ITEM = 0;
  private static final int METHODID_GET_CATALOG_ITEM = 1;
  private static final int METHODID_LIST_CATALOG_ITEMS = 2;
  private static final int METHODID_UPDATE_CATALOG_ITEM = 3;
  private static final int METHODID_DELETE_CATALOG_ITEM = 4;
  private static final int METHODID_IMPORT_CATALOG_ITEMS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CatalogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CatalogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CATALOG_ITEM:
          serviceImpl.createCatalogItem((com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem>) responseObserver);
          break;
        case METHODID_GET_CATALOG_ITEM:
          serviceImpl.getCatalogItem((com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem>) responseObserver);
          break;
        case METHODID_LIST_CATALOG_ITEMS:
          serviceImpl.listCatalogItems((com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CATALOG_ITEM:
          serviceImpl.updateCatalogItem((com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.CatalogItem>) responseObserver);
          break;
        case METHODID_DELETE_CATALOG_ITEM:
          serviceImpl.deleteCatalogItem((com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_IMPORT_CATALOG_ITEMS:
          serviceImpl.importCatalogItems((com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest) request,
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

  private static abstract class CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.recommendationengine.v1beta1.CatalogServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CatalogService");
    }
  }

  private static final class CatalogServiceFileDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier {
    CatalogServiceFileDescriptorSupplier() {}
  }

  private static final class CatalogServiceMethodDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CatalogServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CatalogServiceFileDescriptorSupplier())
              .addMethod(getCreateCatalogItemMethod())
              .addMethod(getGetCatalogItemMethod())
              .addMethod(getListCatalogItemsMethod())
              .addMethod(getUpdateCatalogItemMethod())
              .addMethod(getDeleteCatalogItemMethod())
              .addMethod(getImportCatalogItemsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
