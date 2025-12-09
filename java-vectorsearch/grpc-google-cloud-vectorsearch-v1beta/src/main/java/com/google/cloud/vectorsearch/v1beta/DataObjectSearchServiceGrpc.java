/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.vectorsearch.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for searching data objects.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataObjectSearchServiceGrpc {

  private DataObjectSearchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.vectorsearch.v1beta.DataObjectSearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>
      getSearchDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>
      getSearchDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest,
            com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>
        getSearchDataObjectsMethod;
    if ((getSearchDataObjectsMethod = DataObjectSearchServiceGrpc.getSearchDataObjectsMethod)
        == null) {
      synchronized (DataObjectSearchServiceGrpc.class) {
        if ((getSearchDataObjectsMethod = DataObjectSearchServiceGrpc.getSearchDataObjectsMethod)
            == null) {
          DataObjectSearchServiceGrpc.getSearchDataObjectsMethod =
              getSearchDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest,
                          com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectSearchServiceMethodDescriptorSupplier("SearchDataObjects"))
                      .build();
        }
      }
    }
    return getSearchDataObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>
      getQueryDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>
      getQueryDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest,
            com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>
        getQueryDataObjectsMethod;
    if ((getQueryDataObjectsMethod = DataObjectSearchServiceGrpc.getQueryDataObjectsMethod)
        == null) {
      synchronized (DataObjectSearchServiceGrpc.class) {
        if ((getQueryDataObjectsMethod = DataObjectSearchServiceGrpc.getQueryDataObjectsMethod)
            == null) {
          DataObjectSearchServiceGrpc.getQueryDataObjectsMethod =
              getQueryDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest,
                          com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectSearchServiceMethodDescriptorSupplier("QueryDataObjects"))
                      .build();
        }
      }
    }
    return getQueryDataObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>
      getAggregateDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AggregateDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>
      getAggregateDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest,
            com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>
        getAggregateDataObjectsMethod;
    if ((getAggregateDataObjectsMethod = DataObjectSearchServiceGrpc.getAggregateDataObjectsMethod)
        == null) {
      synchronized (DataObjectSearchServiceGrpc.class) {
        if ((getAggregateDataObjectsMethod =
                DataObjectSearchServiceGrpc.getAggregateDataObjectsMethod)
            == null) {
          DataObjectSearchServiceGrpc.getAggregateDataObjectsMethod =
              getAggregateDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest,
                          com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AggregateDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectSearchServiceMethodDescriptorSupplier(
                              "AggregateDataObjects"))
                      .build();
        }
      }
    }
    return getAggregateDataObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>
      getBatchSearchDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchSearchDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>
      getBatchSearchDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest,
            com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>
        getBatchSearchDataObjectsMethod;
    if ((getBatchSearchDataObjectsMethod =
            DataObjectSearchServiceGrpc.getBatchSearchDataObjectsMethod)
        == null) {
      synchronized (DataObjectSearchServiceGrpc.class) {
        if ((getBatchSearchDataObjectsMethod =
                DataObjectSearchServiceGrpc.getBatchSearchDataObjectsMethod)
            == null) {
          DataObjectSearchServiceGrpc.getBatchSearchDataObjectsMethod =
              getBatchSearchDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest,
                          com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchSearchDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectSearchServiceMethodDescriptorSupplier(
                              "BatchSearchDataObjects"))
                      .build();
        }
      }
    }
    return getBatchSearchDataObjectsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataObjectSearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceStub>() {
          @java.lang.Override
          public DataObjectSearchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectSearchServiceStub(channel, callOptions);
          }
        };
    return DataObjectSearchServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataObjectSearchServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataObjectSearchServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectSearchServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataObjectSearchServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataObjectSearchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceBlockingStub>() {
          @java.lang.Override
          public DataObjectSearchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectSearchServiceBlockingStub(channel, callOptions);
          }
        };
    return DataObjectSearchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataObjectSearchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectSearchServiceFutureStub>() {
          @java.lang.Override
          public DataObjectSearchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectSearchServiceFutureStub(channel, callOptions);
          }
        };
    return DataObjectSearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for searching data objects.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Searches data objects.
     * </pre>
     */
    default void searchDataObjects(
        com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchDataObjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries data objects.
     * </pre>
     */
    default void queryDataObjects(
        com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryDataObjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates data objects.
     * </pre>
     */
    default void aggregateDataObjects(
        com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAggregateDataObjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch searches data objects.
     * </pre>
     */
    default void batchSearchDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchSearchDataObjectsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataObjectSearchService.
   *
   * <pre>
   * Service for searching data objects.
   * </pre>
   */
  public abstract static class DataObjectSearchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataObjectSearchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataObjectSearchService.
   *
   * <pre>
   * Service for searching data objects.
   * </pre>
   */
  public static final class DataObjectSearchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataObjectSearchServiceStub> {
    private DataObjectSearchServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectSearchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectSearchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches data objects.
     * </pre>
     */
    public void searchDataObjects(
        com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries data objects.
     * </pre>
     */
    public void queryDataObjects(
        com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates data objects.
     * </pre>
     */
    public void aggregateDataObjects(
        com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAggregateDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch searches data objects.
     * </pre>
     */
    public void batchSearchDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchSearchDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataObjectSearchService.
   *
   * <pre>
   * Service for searching data objects.
   * </pre>
   */
  public static final class DataObjectSearchServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataObjectSearchServiceBlockingV2Stub> {
    private DataObjectSearchServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectSearchServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectSearchServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse searchDataObjects(
        com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse queryDataObjects(
        com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse aggregateDataObjects(
        com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAggregateDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch searches data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse
        batchSearchDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchSearchDataObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataObjectSearchService.
   *
   * <pre>
   * Service for searching data objects.
   * </pre>
   */
  public static final class DataObjectSearchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataObjectSearchServiceBlockingStub> {
    private DataObjectSearchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectSearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectSearchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse searchDataObjects(
        com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse queryDataObjects(
        com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse aggregateDataObjects(
        com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregateDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch searches data objects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse
        batchSearchDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchSearchDataObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * DataObjectSearchService.
   *
   * <pre>
   * Service for searching data objects.
   * </pre>
   */
  public static final class DataObjectSearchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataObjectSearchServiceFutureStub> {
    private DataObjectSearchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectSearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectSearchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches data objects.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>
        searchDataObjects(com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchDataObjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Queries data objects.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>
        queryDataObjects(com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryDataObjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates data objects.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>
        aggregateDataObjects(
            com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAggregateDataObjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch searches data objects.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>
        batchSearchDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchSearchDataObjectsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_DATA_OBJECTS = 0;
  private static final int METHODID_QUERY_DATA_OBJECTS = 1;
  private static final int METHODID_AGGREGATE_DATA_OBJECTS = 2;
  private static final int METHODID_BATCH_SEARCH_DATA_OBJECTS = 3;

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
        case METHODID_SEARCH_DATA_OBJECTS:
          serviceImpl.searchDataObjects(
              (com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_DATA_OBJECTS:
          serviceImpl.queryDataObjects(
              (com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>)
                  responseObserver);
          break;
        case METHODID_AGGREGATE_DATA_OBJECTS:
          serviceImpl.aggregateDataObjects(
              (com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_SEARCH_DATA_OBJECTS:
          serviceImpl.batchSearchDataObjects(
              (com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>)
                  responseObserver);
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
            getSearchDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest,
                    com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse>(
                    service, METHODID_SEARCH_DATA_OBJECTS)))
        .addMethod(
            getQueryDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest,
                    com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse>(
                    service, METHODID_QUERY_DATA_OBJECTS)))
        .addMethod(
            getAggregateDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest,
                    com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse>(
                    service, METHODID_AGGREGATE_DATA_OBJECTS)))
        .addMethod(
            getBatchSearchDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest,
                    com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse>(
                    service, METHODID_BATCH_SEARCH_DATA_OBJECTS)))
        .build();
  }

  private abstract static class DataObjectSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataObjectSearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataObjectSearchService");
    }
  }

  private static final class DataObjectSearchServiceFileDescriptorSupplier
      extends DataObjectSearchServiceBaseDescriptorSupplier {
    DataObjectSearchServiceFileDescriptorSupplier() {}
  }

  private static final class DataObjectSearchServiceMethodDescriptorSupplier
      extends DataObjectSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataObjectSearchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataObjectSearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataObjectSearchServiceFileDescriptorSupplier())
                      .addMethod(getSearchDataObjectsMethod())
                      .addMethod(getQueryDataObjectsMethod())
                      .addMethod(getAggregateDataObjectsMethod())
                      .addMethod(getBatchSearchDataObjectsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
