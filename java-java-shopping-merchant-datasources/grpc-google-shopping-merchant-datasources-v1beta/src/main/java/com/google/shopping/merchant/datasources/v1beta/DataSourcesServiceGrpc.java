/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.shopping.merchant.datasources.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage primary, supplemental, inventory and other data sources.
 * See more in the [Merchant
 * Center](https://support.google.com/merchants/answer/7439058) help article.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/datasources/v1beta/datasources.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataSourcesServiceGrpc {

  private DataSourcesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.datasources.v1beta.DataSourcesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest,
          com.google.shopping.merchant.datasources.v1beta.DataSource>
      getGetDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSource",
      requestType = com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest.class,
      responseType = com.google.shopping.merchant.datasources.v1beta.DataSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest,
          com.google.shopping.merchant.datasources.v1beta.DataSource>
      getGetDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest,
            com.google.shopping.merchant.datasources.v1beta.DataSource>
        getGetDataSourceMethod;
    if ((getGetDataSourceMethod = DataSourcesServiceGrpc.getGetDataSourceMethod) == null) {
      synchronized (DataSourcesServiceGrpc.class) {
        if ((getGetDataSourceMethod = DataSourcesServiceGrpc.getGetDataSourceMethod) == null) {
          DataSourcesServiceGrpc.getGetDataSourceMethod =
              getGetDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest,
                          com.google.shopping.merchant.datasources.v1beta.DataSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.DataSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSourcesServiceMethodDescriptorSupplier("GetDataSource"))
                      .build();
        }
      }
    }
    return getGetDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest,
          com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>
      getListDataSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSources",
      requestType = com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest.class,
      responseType = com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest,
          com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>
      getListDataSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest,
            com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>
        getListDataSourcesMethod;
    if ((getListDataSourcesMethod = DataSourcesServiceGrpc.getListDataSourcesMethod) == null) {
      synchronized (DataSourcesServiceGrpc.class) {
        if ((getListDataSourcesMethod = DataSourcesServiceGrpc.getListDataSourcesMethod) == null) {
          DataSourcesServiceGrpc.getListDataSourcesMethod =
              getListDataSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest,
                          com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta
                                  .ListDataSourcesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSourcesServiceMethodDescriptorSupplier("ListDataSources"))
                      .build();
        }
      }
    }
    return getListDataSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest,
          com.google.shopping.merchant.datasources.v1beta.DataSource>
      getCreateDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataSource",
      requestType = com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest.class,
      responseType = com.google.shopping.merchant.datasources.v1beta.DataSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest,
          com.google.shopping.merchant.datasources.v1beta.DataSource>
      getCreateDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest,
            com.google.shopping.merchant.datasources.v1beta.DataSource>
        getCreateDataSourceMethod;
    if ((getCreateDataSourceMethod = DataSourcesServiceGrpc.getCreateDataSourceMethod) == null) {
      synchronized (DataSourcesServiceGrpc.class) {
        if ((getCreateDataSourceMethod = DataSourcesServiceGrpc.getCreateDataSourceMethod)
            == null) {
          DataSourcesServiceGrpc.getCreateDataSourceMethod =
              getCreateDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest,
                          com.google.shopping.merchant.datasources.v1beta.DataSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta
                                  .CreateDataSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.DataSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSourcesServiceMethodDescriptorSupplier("CreateDataSource"))
                      .build();
        }
      }
    }
    return getCreateDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest,
          com.google.shopping.merchant.datasources.v1beta.DataSource>
      getUpdateDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataSource",
      requestType = com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest.class,
      responseType = com.google.shopping.merchant.datasources.v1beta.DataSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest,
          com.google.shopping.merchant.datasources.v1beta.DataSource>
      getUpdateDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest,
            com.google.shopping.merchant.datasources.v1beta.DataSource>
        getUpdateDataSourceMethod;
    if ((getUpdateDataSourceMethod = DataSourcesServiceGrpc.getUpdateDataSourceMethod) == null) {
      synchronized (DataSourcesServiceGrpc.class) {
        if ((getUpdateDataSourceMethod = DataSourcesServiceGrpc.getUpdateDataSourceMethod)
            == null) {
          DataSourcesServiceGrpc.getUpdateDataSourceMethod =
              getUpdateDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest,
                          com.google.shopping.merchant.datasources.v1beta.DataSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta
                                  .UpdateDataSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.DataSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSourcesServiceMethodDescriptorSupplier("UpdateDataSource"))
                      .build();
        }
      }
    }
    return getUpdateDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest,
          com.google.protobuf.Empty>
      getDeleteDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataSource",
      requestType = com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest,
          com.google.protobuf.Empty>
      getDeleteDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest,
            com.google.protobuf.Empty>
        getDeleteDataSourceMethod;
    if ((getDeleteDataSourceMethod = DataSourcesServiceGrpc.getDeleteDataSourceMethod) == null) {
      synchronized (DataSourcesServiceGrpc.class) {
        if ((getDeleteDataSourceMethod = DataSourcesServiceGrpc.getDeleteDataSourceMethod)
            == null) {
          DataSourcesServiceGrpc.getDeleteDataSourceMethod =
              getDeleteDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta
                                  .DeleteDataSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSourcesServiceMethodDescriptorSupplier("DeleteDataSource"))
                      .build();
        }
      }
    }
    return getDeleteDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest,
          com.google.protobuf.Empty>
      getFetchDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchDataSource",
      requestType = com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest,
          com.google.protobuf.Empty>
      getFetchDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest,
            com.google.protobuf.Empty>
        getFetchDataSourceMethod;
    if ((getFetchDataSourceMethod = DataSourcesServiceGrpc.getFetchDataSourceMethod) == null) {
      synchronized (DataSourcesServiceGrpc.class) {
        if ((getFetchDataSourceMethod = DataSourcesServiceGrpc.getFetchDataSourceMethod) == null) {
          DataSourcesServiceGrpc.getFetchDataSourceMethod =
              getFetchDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSourcesServiceMethodDescriptorSupplier("FetchDataSource"))
                      .build();
        }
      }
    }
    return getFetchDataSourceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataSourcesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSourcesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataSourcesServiceStub>() {
          @java.lang.Override
          public DataSourcesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataSourcesServiceStub(channel, callOptions);
          }
        };
    return DataSourcesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataSourcesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSourcesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataSourcesServiceBlockingStub>() {
          @java.lang.Override
          public DataSourcesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataSourcesServiceBlockingStub(channel, callOptions);
          }
        };
    return DataSourcesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataSourcesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSourcesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataSourcesServiceFutureStub>() {
          @java.lang.Override
          public DataSourcesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataSourcesServiceFutureStub(channel, callOptions);
          }
        };
    return DataSourcesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage primary, supplemental, inventory and other data sources.
   * See more in the [Merchant
   * Center](https://support.google.com/merchants/answer/7439058) help article.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the data source configuration for the given account.
     * </pre>
     */
    default void getDataSource(
        com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.DataSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the configurations for data sources for the given account.
     * </pre>
     */
    default void listDataSources(
        com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the new data source configuration for the given account.
     * </pre>
     */
    default void createDataSource(
        com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.DataSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the existing data source configuration. The fields that are
     * set in the update mask but not provided in the resource will be deleted.
     * </pre>
     */
    default void updateDataSource(
        com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.DataSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data source from your Merchant Center account.
     * </pre>
     */
    default void deleteDataSource(
        com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs the data fetch immediately (even outside fetch schedule) on a
     * data source from your Merchant Center Account. If you need to call
     * this method more than once per day, you should use the Products service to
     * update your product data instead.
     * This method only works on data sources with a file input set.
     * </pre>
     */
    default void fetchDataSource(
        com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchDataSourceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataSourcesService.
   *
   * <pre>
   * Service to manage primary, supplemental, inventory and other data sources.
   * See more in the [Merchant
   * Center](https://support.google.com/merchants/answer/7439058) help article.
   * </pre>
   */
  public abstract static class DataSourcesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataSourcesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataSourcesService.
   *
   * <pre>
   * Service to manage primary, supplemental, inventory and other data sources.
   * See more in the [Merchant
   * Center](https://support.google.com/merchants/answer/7439058) help article.
   * </pre>
   */
  public static final class DataSourcesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataSourcesServiceStub> {
    private DataSourcesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSourcesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSourcesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the data source configuration for the given account.
     * </pre>
     */
    public void getDataSource(
        com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.DataSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the configurations for data sources for the given account.
     * </pre>
     */
    public void listDataSources(
        com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the new data source configuration for the given account.
     * </pre>
     */
    public void createDataSource(
        com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.DataSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the existing data source configuration. The fields that are
     * set in the update mask but not provided in the resource will be deleted.
     * </pre>
     */
    public void updateDataSource(
        com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.DataSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data source from your Merchant Center account.
     * </pre>
     */
    public void deleteDataSource(
        com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs the data fetch immediately (even outside fetch schedule) on a
     * data source from your Merchant Center Account. If you need to call
     * this method more than once per day, you should use the Products service to
     * update your product data instead.
     * This method only works on data sources with a file input set.
     * </pre>
     */
    public void fetchDataSource(
        com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataSourcesService.
   *
   * <pre>
   * Service to manage primary, supplemental, inventory and other data sources.
   * See more in the [Merchant
   * Center](https://support.google.com/merchants/answer/7439058) help article.
   * </pre>
   */
  public static final class DataSourcesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataSourcesServiceBlockingStub> {
    private DataSourcesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSourcesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSourcesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the data source configuration for the given account.
     * </pre>
     */
    public com.google.shopping.merchant.datasources.v1beta.DataSource getDataSource(
        com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the configurations for data sources for the given account.
     * </pre>
     */
    public com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse listDataSources(
        com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the new data source configuration for the given account.
     * </pre>
     */
    public com.google.shopping.merchant.datasources.v1beta.DataSource createDataSource(
        com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the existing data source configuration. The fields that are
     * set in the update mask but not provided in the resource will be deleted.
     * </pre>
     */
    public com.google.shopping.merchant.datasources.v1beta.DataSource updateDataSource(
        com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data source from your Merchant Center account.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataSource(
        com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Performs the data fetch immediately (even outside fetch schedule) on a
     * data source from your Merchant Center Account. If you need to call
     * this method more than once per day, you should use the Products service to
     * update your product data instead.
     * This method only works on data sources with a file input set.
     * </pre>
     */
    public com.google.protobuf.Empty fetchDataSource(
        com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchDataSourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataSourcesService.
   *
   * <pre>
   * Service to manage primary, supplemental, inventory and other data sources.
   * See more in the [Merchant
   * Center](https://support.google.com/merchants/answer/7439058) help article.
   * </pre>
   */
  public static final class DataSourcesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataSourcesServiceFutureStub> {
    private DataSourcesServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSourcesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSourcesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the data source configuration for the given account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.datasources.v1beta.DataSource>
        getDataSource(
            com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the configurations for data sources for the given account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>
        listDataSources(
            com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the new data source configuration for the given account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.datasources.v1beta.DataSource>
        createDataSource(
            com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the existing data source configuration. The fields that are
     * set in the update mask but not provided in the resource will be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.datasources.v1beta.DataSource>
        updateDataSource(
            com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data source from your Merchant Center account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataSource(
            com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Performs the data fetch immediately (even outside fetch schedule) on a
     * data source from your Merchant Center Account. If you need to call
     * this method more than once per day, you should use the Products service to
     * update your product data instead.
     * This method only works on data sources with a file input set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        fetchDataSource(
            com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchDataSourceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA_SOURCE = 0;
  private static final int METHODID_LIST_DATA_SOURCES = 1;
  private static final int METHODID_CREATE_DATA_SOURCE = 2;
  private static final int METHODID_UPDATE_DATA_SOURCE = 3;
  private static final int METHODID_DELETE_DATA_SOURCE = 4;
  private static final int METHODID_FETCH_DATA_SOURCE = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_GET_DATA_SOURCE:
          serviceImpl.getDataSource(
              (com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.datasources.v1beta.DataSource>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_SOURCES:
          serviceImpl.listDataSources(
              (com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_SOURCE:
          serviceImpl.createDataSource(
              (com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.datasources.v1beta.DataSource>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_SOURCE:
          serviceImpl.updateDataSource(
              (com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.datasources.v1beta.DataSource>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_SOURCE:
          serviceImpl.deleteDataSource(
              (com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_FETCH_DATA_SOURCE:
          serviceImpl.fetchDataSource(
              (com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest) request,
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
            getGetDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest,
                    com.google.shopping.merchant.datasources.v1beta.DataSource>(
                    service, METHODID_GET_DATA_SOURCE)))
        .addMethod(
            getListDataSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest,
                    com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse>(
                    service, METHODID_LIST_DATA_SOURCES)))
        .addMethod(
            getCreateDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest,
                    com.google.shopping.merchant.datasources.v1beta.DataSource>(
                    service, METHODID_CREATE_DATA_SOURCE)))
        .addMethod(
            getUpdateDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest,
                    com.google.shopping.merchant.datasources.v1beta.DataSource>(
                    service, METHODID_UPDATE_DATA_SOURCE)))
        .addMethod(
            getDeleteDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_SOURCE)))
        .addMethod(
            getFetchDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest,
                    com.google.protobuf.Empty>(service, METHODID_FETCH_DATA_SOURCE)))
        .build();
  }

  private abstract static class DataSourcesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataSourcesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.datasources.v1beta.DataSourcesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataSourcesService");
    }
  }

  private static final class DataSourcesServiceFileDescriptorSupplier
      extends DataSourcesServiceBaseDescriptorSupplier {
    DataSourcesServiceFileDescriptorSupplier() {}
  }

  private static final class DataSourcesServiceMethodDescriptorSupplier
      extends DataSourcesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataSourcesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataSourcesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataSourcesServiceFileDescriptorSupplier())
                      .addMethod(getGetDataSourceMethod())
                      .addMethod(getListDataSourcesMethod())
                      .addMethod(getCreateDataSourceMethod())
                      .addMethod(getUpdateDataSourceMethod())
                      .addMethod(getDeleteDataSourceMethod())
                      .addMethod(getFetchDataSourceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
