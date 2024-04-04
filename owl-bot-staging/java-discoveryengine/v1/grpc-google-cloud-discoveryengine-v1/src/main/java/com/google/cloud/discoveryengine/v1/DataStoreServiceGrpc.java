package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [DataStore][google.cloud.discoveryengine.v1.DataStore]
 * configuration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/data_store_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataStoreServiceGrpc {

  private DataStoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.discoveryengine.v1.DataStoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.CreateDataStoreRequest,
      com.google.longrunning.Operation> getCreateDataStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataStore",
      requestType = com.google.cloud.discoveryengine.v1.CreateDataStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.CreateDataStoreRequest,
      com.google.longrunning.Operation> getCreateDataStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.CreateDataStoreRequest, com.google.longrunning.Operation> getCreateDataStoreMethod;
    if ((getCreateDataStoreMethod = DataStoreServiceGrpc.getCreateDataStoreMethod) == null) {
      synchronized (DataStoreServiceGrpc.class) {
        if ((getCreateDataStoreMethod = DataStoreServiceGrpc.getCreateDataStoreMethod) == null) {
          DataStoreServiceGrpc.getCreateDataStoreMethod = getCreateDataStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1.CreateDataStoreRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.CreateDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataStoreServiceMethodDescriptorSupplier("CreateDataStore"))
              .build();
        }
      }
    }
    return getCreateDataStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.GetDataStoreRequest,
      com.google.cloud.discoveryengine.v1.DataStore> getGetDataStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataStore",
      requestType = com.google.cloud.discoveryengine.v1.GetDataStoreRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.DataStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.GetDataStoreRequest,
      com.google.cloud.discoveryengine.v1.DataStore> getGetDataStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.GetDataStoreRequest, com.google.cloud.discoveryengine.v1.DataStore> getGetDataStoreMethod;
    if ((getGetDataStoreMethod = DataStoreServiceGrpc.getGetDataStoreMethod) == null) {
      synchronized (DataStoreServiceGrpc.class) {
        if ((getGetDataStoreMethod = DataStoreServiceGrpc.getGetDataStoreMethod) == null) {
          DataStoreServiceGrpc.getGetDataStoreMethod = getGetDataStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1.GetDataStoreRequest, com.google.cloud.discoveryengine.v1.DataStore>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.GetDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.DataStore.getDefaultInstance()))
              .setSchemaDescriptor(new DataStoreServiceMethodDescriptorSupplier("GetDataStore"))
              .build();
        }
      }
    }
    return getGetDataStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.ListDataStoresRequest,
      com.google.cloud.discoveryengine.v1.ListDataStoresResponse> getListDataStoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataStores",
      requestType = com.google.cloud.discoveryengine.v1.ListDataStoresRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.ListDataStoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.ListDataStoresRequest,
      com.google.cloud.discoveryengine.v1.ListDataStoresResponse> getListDataStoresMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.ListDataStoresRequest, com.google.cloud.discoveryengine.v1.ListDataStoresResponse> getListDataStoresMethod;
    if ((getListDataStoresMethod = DataStoreServiceGrpc.getListDataStoresMethod) == null) {
      synchronized (DataStoreServiceGrpc.class) {
        if ((getListDataStoresMethod = DataStoreServiceGrpc.getListDataStoresMethod) == null) {
          DataStoreServiceGrpc.getListDataStoresMethod = getListDataStoresMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1.ListDataStoresRequest, com.google.cloud.discoveryengine.v1.ListDataStoresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataStores"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.ListDataStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.ListDataStoresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataStoreServiceMethodDescriptorSupplier("ListDataStores"))
              .build();
        }
      }
    }
    return getListDataStoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest,
      com.google.longrunning.Operation> getDeleteDataStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataStore",
      requestType = com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest,
      com.google.longrunning.Operation> getDeleteDataStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest, com.google.longrunning.Operation> getDeleteDataStoreMethod;
    if ((getDeleteDataStoreMethod = DataStoreServiceGrpc.getDeleteDataStoreMethod) == null) {
      synchronized (DataStoreServiceGrpc.class) {
        if ((getDeleteDataStoreMethod = DataStoreServiceGrpc.getDeleteDataStoreMethod) == null) {
          DataStoreServiceGrpc.getDeleteDataStoreMethod = getDeleteDataStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataStoreServiceMethodDescriptorSupplier("DeleteDataStore"))
              .build();
        }
      }
    }
    return getDeleteDataStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest,
      com.google.cloud.discoveryengine.v1.DataStore> getUpdateDataStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataStore",
      requestType = com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.DataStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest,
      com.google.cloud.discoveryengine.v1.DataStore> getUpdateDataStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest, com.google.cloud.discoveryengine.v1.DataStore> getUpdateDataStoreMethod;
    if ((getUpdateDataStoreMethod = DataStoreServiceGrpc.getUpdateDataStoreMethod) == null) {
      synchronized (DataStoreServiceGrpc.class) {
        if ((getUpdateDataStoreMethod = DataStoreServiceGrpc.getUpdateDataStoreMethod) == null) {
          DataStoreServiceGrpc.getUpdateDataStoreMethod = getUpdateDataStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest, com.google.cloud.discoveryengine.v1.DataStore>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1.DataStore.getDefaultInstance()))
              .setSchemaDescriptor(new DataStoreServiceMethodDescriptorSupplier("UpdateDataStore"))
              .build();
        }
      }
    }
    return getUpdateDataStoreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataStoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataStoreServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataStoreServiceStub>() {
        @java.lang.Override
        public DataStoreServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataStoreServiceStub(channel, callOptions);
        }
      };
    return DataStoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataStoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataStoreServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataStoreServiceBlockingStub>() {
        @java.lang.Override
        public DataStoreServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataStoreServiceBlockingStub(channel, callOptions);
        }
      };
    return DataStoreServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataStoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataStoreServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataStoreServiceFutureStub>() {
        @java.lang.Override
        public DataStoreServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataStoreServiceFutureStub(channel, callOptions);
        }
      };
    return DataStoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [DataStore][google.cloud.discoveryengine.v1.DataStore]
   * configuration.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * DataStore is for storing
     * [Documents][google.cloud.discoveryengine.v1.Document]. To serve these
     * documents for Search, or Recommendation use case, an
     * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created
     * separately.
     * </pre>
     */
    default void createDataStore(com.google.cloud.discoveryengine.v1.CreateDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDataStoreMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    default void getDataStore(com.google.cloud.discoveryengine.v1.GetDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataStore> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDataStoreMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s
     * associated with the project.
     * </pre>
     */
    default void listDataStores(com.google.cloud.discoveryengine.v1.ListDataStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListDataStoresResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDataStoresMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    default void deleteDataStore(com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDataStoreMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]
     * </pre>
     */
    default void updateDataStore(com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataStore> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateDataStoreMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataStoreService.
   * <pre>
   * Service for managing [DataStore][google.cloud.discoveryengine.v1.DataStore]
   * configuration.
   * </pre>
   */
  public static abstract class DataStoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DataStoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataStoreService.
   * <pre>
   * Service for managing [DataStore][google.cloud.discoveryengine.v1.DataStore]
   * configuration.
   * </pre>
   */
  public static final class DataStoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataStoreServiceStub> {
    private DataStoreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataStoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataStoreServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * DataStore is for storing
     * [Documents][google.cloud.discoveryengine.v1.Document]. To serve these
     * documents for Search, or Recommendation use case, an
     * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created
     * separately.
     * </pre>
     */
    public void createDataStore(com.google.cloud.discoveryengine.v1.CreateDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public void getDataStore(com.google.cloud.discoveryengine.v1.GetDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataStore> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s
     * associated with the project.
     * </pre>
     */
    public void listDataStores(com.google.cloud.discoveryengine.v1.ListDataStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListDataStoresResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataStoresMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public void deleteDataStore(com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]
     * </pre>
     */
    public void updateDataStore(com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataStore> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataStoreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataStoreService.
   * <pre>
   * Service for managing [DataStore][google.cloud.discoveryengine.v1.DataStore]
   * configuration.
   * </pre>
   */
  public static final class DataStoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataStoreServiceBlockingStub> {
    private DataStoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataStoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataStoreServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * DataStore is for storing
     * [Documents][google.cloud.discoveryengine.v1.Document]. To serve these
     * documents for Search, or Recommendation use case, an
     * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created
     * separately.
     * </pre>
     */
    public com.google.longrunning.Operation createDataStore(com.google.cloud.discoveryengine.v1.CreateDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataStoreMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.DataStore getDataStore(com.google.cloud.discoveryengine.v1.GetDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataStoreMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s
     * associated with the project.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListDataStoresResponse listDataStores(com.google.cloud.discoveryengine.v1.ListDataStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataStoresMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataStore(com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataStoreMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.DataStore updateDataStore(com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataStoreMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataStoreService.
   * <pre>
   * Service for managing [DataStore][google.cloud.discoveryengine.v1.DataStore]
   * configuration.
   * </pre>
   */
  public static final class DataStoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataStoreServiceFutureStub> {
    private DataStoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataStoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataStoreServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * DataStore is for storing
     * [Documents][google.cloud.discoveryengine.v1.Document]. To serve these
     * documents for Search, or Recommendation use case, an
     * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created
     * separately.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createDataStore(
        com.google.cloud.discoveryengine.v1.CreateDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataStoreMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1.DataStore> getDataStore(
        com.google.cloud.discoveryengine.v1.GetDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataStoreMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s
     * associated with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1.ListDataStoresResponse> listDataStores(
        com.google.cloud.discoveryengine.v1.ListDataStoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataStoresMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteDataStore(
        com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataStoreMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1.DataStore> updateDataStore(
        com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataStoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_STORE = 0;
  private static final int METHODID_GET_DATA_STORE = 1;
  private static final int METHODID_LIST_DATA_STORES = 2;
  private static final int METHODID_DELETE_DATA_STORE = 3;
  private static final int METHODID_UPDATE_DATA_STORE = 4;

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
        case METHODID_CREATE_DATA_STORE:
          serviceImpl.createDataStore((com.google.cloud.discoveryengine.v1.CreateDataStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATA_STORE:
          serviceImpl.getDataStore((com.google.cloud.discoveryengine.v1.GetDataStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataStore>) responseObserver);
          break;
        case METHODID_LIST_DATA_STORES:
          serviceImpl.listDataStores((com.google.cloud.discoveryengine.v1.ListDataStoresRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListDataStoresResponse>) responseObserver);
          break;
        case METHODID_DELETE_DATA_STORE:
          serviceImpl.deleteDataStore((com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_STORE:
          serviceImpl.updateDataStore((com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataStore>) responseObserver);
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
          getCreateDataStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1.CreateDataStoreRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_DATA_STORE)))
        .addMethod(
          getGetDataStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1.GetDataStoreRequest,
              com.google.cloud.discoveryengine.v1.DataStore>(
                service, METHODID_GET_DATA_STORE)))
        .addMethod(
          getListDataStoresMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1.ListDataStoresRequest,
              com.google.cloud.discoveryengine.v1.ListDataStoresResponse>(
                service, METHODID_LIST_DATA_STORES)))
        .addMethod(
          getDeleteDataStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_DATA_STORE)))
        .addMethod(
          getUpdateDataStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest,
              com.google.cloud.discoveryengine.v1.DataStore>(
                service, METHODID_UPDATE_DATA_STORE)))
        .build();
  }

  private static abstract class DataStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataStoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.DataStoreServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataStoreService");
    }
  }

  private static final class DataStoreServiceFileDescriptorSupplier
      extends DataStoreServiceBaseDescriptorSupplier {
    DataStoreServiceFileDescriptorSupplier() {}
  }

  private static final class DataStoreServiceMethodDescriptorSupplier
      extends DataStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataStoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataStoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataStoreServiceFileDescriptorSupplier())
              .addMethod(getCreateDataStoreMethod())
              .addMethod(getGetDataStoreMethod())
              .addMethod(getListDataStoresMethod())
              .addMethod(getDeleteDataStoreMethod())
              .addMethod(getUpdateDataStoreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
