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
package com.google.cloud.bigquery.storage.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * BigQuery Metastore Partition Service API.
 * This service is used for managing metastore partitions in BigQuery metastore.
 * The service supports only batch operations for write.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/storage/v1alpha/metastore_partition.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetastorePartitionServiceGrpc {

  private MetastorePartitionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.bigquery.storage.v1alpha.MetastorePartitionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse>
      getBatchCreateMetastorePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateMetastorePartitions",
      requestType =
          com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest.class,
      responseType =
          com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse>
      getBatchCreateMetastorePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest,
            com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse>
        getBatchCreateMetastorePartitionsMethod;
    if ((getBatchCreateMetastorePartitionsMethod =
            MetastorePartitionServiceGrpc.getBatchCreateMetastorePartitionsMethod)
        == null) {
      synchronized (MetastorePartitionServiceGrpc.class) {
        if ((getBatchCreateMetastorePartitionsMethod =
                MetastorePartitionServiceGrpc.getBatchCreateMetastorePartitionsMethod)
            == null) {
          MetastorePartitionServiceGrpc.getBatchCreateMetastorePartitionsMethod =
              getBatchCreateMetastorePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1alpha
                              .BatchCreateMetastorePartitionsRequest,
                          com.google.cloud.bigquery.storage.v1alpha
                              .BatchCreateMetastorePartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateMetastorePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .BatchCreateMetastorePartitionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .BatchCreateMetastorePartitionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastorePartitionServiceMethodDescriptorSupplier(
                              "BatchCreateMetastorePartitions"))
                      .build();
        }
      }
    }
    return getBatchCreateMetastorePartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteMetastorePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteMetastorePartitions",
      requestType =
          com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteMetastorePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest,
            com.google.protobuf.Empty>
        getBatchDeleteMetastorePartitionsMethod;
    if ((getBatchDeleteMetastorePartitionsMethod =
            MetastorePartitionServiceGrpc.getBatchDeleteMetastorePartitionsMethod)
        == null) {
      synchronized (MetastorePartitionServiceGrpc.class) {
        if ((getBatchDeleteMetastorePartitionsMethod =
                MetastorePartitionServiceGrpc.getBatchDeleteMetastorePartitionsMethod)
            == null) {
          MetastorePartitionServiceGrpc.getBatchDeleteMetastorePartitionsMethod =
              getBatchDeleteMetastorePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1alpha
                              .BatchDeleteMetastorePartitionsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteMetastorePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .BatchDeleteMetastorePartitionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastorePartitionServiceMethodDescriptorSupplier(
                              "BatchDeleteMetastorePartitions"))
                      .build();
        }
      }
    }
    return getBatchDeleteMetastorePartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse>
      getBatchUpdateMetastorePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateMetastorePartitions",
      requestType =
          com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest.class,
      responseType =
          com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse>
      getBatchUpdateMetastorePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest,
            com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse>
        getBatchUpdateMetastorePartitionsMethod;
    if ((getBatchUpdateMetastorePartitionsMethod =
            MetastorePartitionServiceGrpc.getBatchUpdateMetastorePartitionsMethod)
        == null) {
      synchronized (MetastorePartitionServiceGrpc.class) {
        if ((getBatchUpdateMetastorePartitionsMethod =
                MetastorePartitionServiceGrpc.getBatchUpdateMetastorePartitionsMethod)
            == null) {
          MetastorePartitionServiceGrpc.getBatchUpdateMetastorePartitionsMethod =
              getBatchUpdateMetastorePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1alpha
                              .BatchUpdateMetastorePartitionsRequest,
                          com.google.cloud.bigquery.storage.v1alpha
                              .BatchUpdateMetastorePartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateMetastorePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .BatchUpdateMetastorePartitionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .BatchUpdateMetastorePartitionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastorePartitionServiceMethodDescriptorSupplier(
                              "BatchUpdateMetastorePartitions"))
                      .build();
        }
      }
    }
    return getBatchUpdateMetastorePartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>
      getListMetastorePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMetastorePartitions",
      requestType = com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest.class,
      responseType =
          com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>
      getListMetastorePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest,
            com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>
        getListMetastorePartitionsMethod;
    if ((getListMetastorePartitionsMethod =
            MetastorePartitionServiceGrpc.getListMetastorePartitionsMethod)
        == null) {
      synchronized (MetastorePartitionServiceGrpc.class) {
        if ((getListMetastorePartitionsMethod =
                MetastorePartitionServiceGrpc.getListMetastorePartitionsMethod)
            == null) {
          MetastorePartitionServiceGrpc.getListMetastorePartitionsMethod =
              getListMetastorePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest,
                          com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMetastorePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .ListMetastorePartitionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .ListMetastorePartitionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastorePartitionServiceMethodDescriptorSupplier(
                              "ListMetastorePartitions"))
                      .build();
        }
      }
    }
    return getListMetastorePartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse>
      getStreamMetastorePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamMetastorePartitions",
      requestType =
          com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest.class,
      responseType =
          com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest,
          com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse>
      getStreamMetastorePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest,
            com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse>
        getStreamMetastorePartitionsMethod;
    if ((getStreamMetastorePartitionsMethod =
            MetastorePartitionServiceGrpc.getStreamMetastorePartitionsMethod)
        == null) {
      synchronized (MetastorePartitionServiceGrpc.class) {
        if ((getStreamMetastorePartitionsMethod =
                MetastorePartitionServiceGrpc.getStreamMetastorePartitionsMethod)
            == null) {
          MetastorePartitionServiceGrpc.getStreamMetastorePartitionsMethod =
              getStreamMetastorePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest,
                          com.google.cloud.bigquery.storage.v1alpha
                              .StreamMetastorePartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StreamMetastorePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .StreamMetastorePartitionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1alpha
                                  .StreamMetastorePartitionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastorePartitionServiceMethodDescriptorSupplier(
                              "StreamMetastorePartitions"))
                      .build();
        }
      }
    }
    return getStreamMetastorePartitionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MetastorePartitionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastorePartitionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetastorePartitionServiceStub>() {
          @java.lang.Override
          public MetastorePartitionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetastorePartitionServiceStub(channel, callOptions);
          }
        };
    return MetastorePartitionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetastorePartitionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastorePartitionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetastorePartitionServiceBlockingStub>() {
          @java.lang.Override
          public MetastorePartitionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetastorePartitionServiceBlockingStub(channel, callOptions);
          }
        };
    return MetastorePartitionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MetastorePartitionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastorePartitionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetastorePartitionServiceFutureStub>() {
          @java.lang.Override
          public MetastorePartitionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetastorePartitionServiceFutureStub(channel, callOptions);
          }
        };
    return MetastorePartitionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * BigQuery Metastore Partition Service API.
   * This service is used for managing metastore partitions in BigQuery metastore.
   * The service supports only batch operations for write.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Adds metastore partitions to a table.
     * </pre>
     */
    default void batchCreateMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateMetastorePartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes metastore partitions from a table.
     * </pre>
     */
    default void batchDeleteMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteMetastorePartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates metastore partitions in a table.
     * </pre>
     */
    default void batchUpdateMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateMetastorePartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metastore partitions from a table.
     * </pre>
     */
    default void listMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMetastorePartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is a bi-di streaming rpc method that allows the client to send
     * a stream of partitions and commit all of them atomically at the end.
     * If the commit is successful, the server will return a
     * response and close the stream. If the commit fails (due to duplicate
     * partitions or other reason), the server will close the stream with an
     * error. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    default io.grpc.stub.StreamObserver<
            com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest>
        streamMetastorePartitions(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamMetastorePartitionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MetastorePartitionService.
   *
   * <pre>
   * BigQuery Metastore Partition Service API.
   * This service is used for managing metastore partitions in BigQuery metastore.
   * The service supports only batch operations for write.
   * </pre>
   */
  public abstract static class MetastorePartitionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MetastorePartitionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MetastorePartitionService.
   *
   * <pre>
   * BigQuery Metastore Partition Service API.
   * This service is used for managing metastore partitions in BigQuery metastore.
   * The service supports only batch operations for write.
   * </pre>
   */
  public static final class MetastorePartitionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MetastorePartitionServiceStub> {
    private MetastorePartitionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastorePartitionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastorePartitionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Adds metastore partitions to a table.
     * </pre>
     */
    public void batchCreateMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateMetastorePartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes metastore partitions from a table.
     * </pre>
     */
    public void batchDeleteMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteMetastorePartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates metastore partitions in a table.
     * </pre>
     */
    public void batchUpdateMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateMetastorePartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metastore partitions from a table.
     * </pre>
     */
    public void listMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMetastorePartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is a bi-di streaming rpc method that allows the client to send
     * a stream of partitions and commit all of them atomically at the end.
     * If the commit is successful, the server will return a
     * response and close the stream. If the commit fails (due to duplicate
     * partitions or other reason), the server will close the stream with an
     * error. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest>
        streamMetastorePartitions(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamMetastorePartitionsMethod(), getCallOptions()),
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MetastorePartitionService.
   *
   * <pre>
   * BigQuery Metastore Partition Service API.
   * This service is used for managing metastore partitions in BigQuery metastore.
   * The service supports only batch operations for write.
   * </pre>
   */
  public static final class MetastorePartitionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MetastorePartitionServiceBlockingStub> {
    private MetastorePartitionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastorePartitionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastorePartitionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Adds metastore partitions to a table.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse
        batchCreateMetastorePartitions(
            com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateMetastorePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes metastore partitions from a table.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteMetastorePartitions(
        com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteMetastorePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates metastore partitions in a table.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse
        batchUpdateMetastorePartitions(
            com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateMetastorePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metastore partitions from a table.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse
        listMetastorePartitions(
            com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMetastorePartitionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * MetastorePartitionService.
   *
   * <pre>
   * BigQuery Metastore Partition Service API.
   * This service is used for managing metastore partitions in BigQuery metastore.
   * The service supports only batch operations for write.
   * </pre>
   */
  public static final class MetastorePartitionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MetastorePartitionServiceFutureStub> {
    private MetastorePartitionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastorePartitionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastorePartitionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Adds metastore partitions to a table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse>
        batchCreateMetastorePartitions(
            com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateMetastorePartitionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes metastore partitions from a table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteMetastorePartitions(
            com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteMetastorePartitionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates metastore partitions in a table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse>
        batchUpdateMetastorePartitions(
            com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateMetastorePartitionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets metastore partitions from a table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>
        listMetastorePartitions(
            com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMetastorePartitionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BATCH_CREATE_METASTORE_PARTITIONS = 0;
  private static final int METHODID_BATCH_DELETE_METASTORE_PARTITIONS = 1;
  private static final int METHODID_BATCH_UPDATE_METASTORE_PARTITIONS = 2;
  private static final int METHODID_LIST_METASTORE_PARTITIONS = 3;
  private static final int METHODID_STREAM_METASTORE_PARTITIONS = 4;

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
        case METHODID_BATCH_CREATE_METASTORE_PARTITIONS:
          serviceImpl.batchCreateMetastorePartitions(
              (com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1alpha
                          .BatchCreateMetastorePartitionsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_DELETE_METASTORE_PARTITIONS:
          serviceImpl.batchDeleteMetastorePartitions(
              (com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_UPDATE_METASTORE_PARTITIONS:
          serviceImpl.batchUpdateMetastorePartitions(
              (com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1alpha
                          .BatchUpdateMetastorePartitionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_METASTORE_PARTITIONS:
          serviceImpl.listMetastorePartitions(
              (com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>)
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
        case METHODID_STREAM_METASTORE_PARTITIONS:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamMetastorePartitions(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.bigquery.storage.v1alpha
                              .StreamMetastorePartitionsResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getBatchCreateMetastorePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest,
                    com.google.cloud.bigquery.storage.v1alpha
                        .BatchCreateMetastorePartitionsResponse>(
                    service, METHODID_BATCH_CREATE_METASTORE_PARTITIONS)))
        .addMethod(
            getBatchDeleteMetastorePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_BATCH_DELETE_METASTORE_PARTITIONS)))
        .addMethod(
            getBatchUpdateMetastorePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest,
                    com.google.cloud.bigquery.storage.v1alpha
                        .BatchUpdateMetastorePartitionsResponse>(
                    service, METHODID_BATCH_UPDATE_METASTORE_PARTITIONS)))
        .addMethod(
            getListMetastorePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest,
                    com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse>(
                    service, METHODID_LIST_METASTORE_PARTITIONS)))
        .addMethod(
            getStreamMetastorePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest,
                    com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse>(
                    service, METHODID_STREAM_METASTORE_PARTITIONS)))
        .build();
  }

  private abstract static class MetastorePartitionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetastorePartitionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.storage.v1alpha.MetastorePartitionServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetastorePartitionService");
    }
  }

  private static final class MetastorePartitionServiceFileDescriptorSupplier
      extends MetastorePartitionServiceBaseDescriptorSupplier {
    MetastorePartitionServiceFileDescriptorSupplier() {}
  }

  private static final class MetastorePartitionServiceMethodDescriptorSupplier
      extends MetastorePartitionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MetastorePartitionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MetastorePartitionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MetastorePartitionServiceFileDescriptorSupplier())
                      .addMethod(getBatchCreateMetastorePartitionsMethod())
                      .addMethod(getBatchDeleteMetastorePartitionsMethod())
                      .addMethod(getBatchUpdateMetastorePartitionsMethod())
                      .addMethod(getListMetastorePartitionsMethod())
                      .addMethod(getStreamMetastorePartitionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
