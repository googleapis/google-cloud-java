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
package com.google.cloud.bigquery.storage.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * BigQuery storage API.
 * The BigQuery storage API can be used to read data stored in BigQuery.
 * The v1beta1 API is not yet officially deprecated, and will go through a full
 * deprecation cycle (https://cloud.google.com/products#product-launch-stages)
 * before the service is turned down. However, new code should use the v1 API
 * going forward.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/storage/v1beta1/storage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BigQueryStorageGrpc {

  private BigQueryStorageGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.bigquery.storage.v1beta1.BigQueryStorage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
      getCreateReadSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReadSession",
      requestType =
          com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest.class,
      responseType = com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
      getCreateReadSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
            com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
        getCreateReadSessionMethod;
    if ((getCreateReadSessionMethod = BigQueryStorageGrpc.getCreateReadSessionMethod) == null) {
      synchronized (BigQueryStorageGrpc.class) {
        if ((getCreateReadSessionMethod = BigQueryStorageGrpc.getCreateReadSessionMethod) == null) {
          BigQueryStorageGrpc.getCreateReadSessionMethod =
              getCreateReadSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
                          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReadSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage
                                  .CreateReadSessionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryStorageMethodDescriptorSupplier("CreateReadSession"))
                      .build();
        }
      }
    }
    return getCreateReadSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
      getReadRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadRows",
      requestType = com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest.class,
      responseType = com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
      getReadRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
            com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
        getReadRowsMethod;
    if ((getReadRowsMethod = BigQueryStorageGrpc.getReadRowsMethod) == null) {
      synchronized (BigQueryStorageGrpc.class) {
        if ((getReadRowsMethod = BigQueryStorageGrpc.getReadRowsMethod) == null) {
          BigQueryStorageGrpc.getReadRowsMethod =
              getReadRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
                          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BigQueryStorageMethodDescriptorSupplier("ReadRows"))
                      .build();
        }
      }
    }
    return getReadRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
      getBatchCreateReadSessionStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateReadSessionStreams",
      requestType =
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
              .class,
      responseType =
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
      getBatchCreateReadSessionStreamsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest,
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
        getBatchCreateReadSessionStreamsMethod;
    if ((getBatchCreateReadSessionStreamsMethod =
            BigQueryStorageGrpc.getBatchCreateReadSessionStreamsMethod)
        == null) {
      synchronized (BigQueryStorageGrpc.class) {
        if ((getBatchCreateReadSessionStreamsMethod =
                BigQueryStorageGrpc.getBatchCreateReadSessionStreamsMethod)
            == null) {
          BigQueryStorageGrpc.getBatchCreateReadSessionStreamsMethod =
              getBatchCreateReadSessionStreamsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1beta1.Storage
                              .BatchCreateReadSessionStreamsRequest,
                          com.google.cloud.bigquery.storage.v1beta1.Storage
                              .BatchCreateReadSessionStreamsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateReadSessionStreams"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage
                                  .BatchCreateReadSessionStreamsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage
                                  .BatchCreateReadSessionStreamsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryStorageMethodDescriptorSupplier(
                              "BatchCreateReadSessionStreams"))
                      .build();
        }
      }
    }
    return getBatchCreateReadSessionStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
          com.google.protobuf.Empty>
      getFinalizeStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FinalizeStream",
      requestType = com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
          com.google.protobuf.Empty>
      getFinalizeStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
            com.google.protobuf.Empty>
        getFinalizeStreamMethod;
    if ((getFinalizeStreamMethod = BigQueryStorageGrpc.getFinalizeStreamMethod) == null) {
      synchronized (BigQueryStorageGrpc.class) {
        if ((getFinalizeStreamMethod = BigQueryStorageGrpc.getFinalizeStreamMethod) == null) {
          BigQueryStorageGrpc.getFinalizeStreamMethod =
              getFinalizeStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FinalizeStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage
                                  .FinalizeStreamRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryStorageMethodDescriptorSupplier("FinalizeStream"))
                      .build();
        }
      }
    }
    return getFinalizeStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
      getSplitReadStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SplitReadStream",
      requestType = com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest.class,
      responseType =
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
      getSplitReadStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
        getSplitReadStreamMethod;
    if ((getSplitReadStreamMethod = BigQueryStorageGrpc.getSplitReadStreamMethod) == null) {
      synchronized (BigQueryStorageGrpc.class) {
        if ((getSplitReadStreamMethod = BigQueryStorageGrpc.getSplitReadStreamMethod) == null) {
          BigQueryStorageGrpc.getSplitReadStreamMethod =
              getSplitReadStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
                          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SplitReadStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage
                                  .SplitReadStreamRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1beta1.Storage
                                  .SplitReadStreamResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryStorageMethodDescriptorSupplier("SplitReadStream"))
                      .build();
        }
      }
    }
    return getSplitReadStreamMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BigQueryStorageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryStorageStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryStorageStub>() {
          @java.lang.Override
          public BigQueryStorageStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryStorageStub(channel, callOptions);
          }
        };
    return BigQueryStorageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BigQueryStorageBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryStorageBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryStorageBlockingStub>() {
          @java.lang.Override
          public BigQueryStorageBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryStorageBlockingStub(channel, callOptions);
          }
        };
    return BigQueryStorageBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BigQueryStorageFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryStorageFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryStorageFutureStub>() {
          @java.lang.Override
          public BigQueryStorageFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryStorageFutureStub(channel, callOptions);
          }
        };
    return BigQueryStorageFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * The v1beta1 API is not yet officially deprecated, and will go through a full
   * deprecation cycle (https://cloud.google.com/products#product-launch-stages)
   * before the service is turned down. However, new code should use the v1 API
   * going forward.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new read session. A read session divides the contents of a
     * BigQuery table into one or more streams, which can then be used to read
     * data from the table. The read session also specifies properties of the
     * data to be read, such as a list of columns or a push-down filter describing
     * the rows to be returned.
     * A particular row can be read by at most one stream. When the caller has
     * reached the end of each stream in the session, then all the data in the
     * table has been read.
     * Read sessions automatically expire 6 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    default void createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReadSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the table in the format prescribed by the read session.
     * Each response contains one or more table rows, up to a maximum of 10 MiB
     * per response; read requests which attempt to read individual rows larger
     * than this will fail.
     * Each request also returns a set of stream statistics reflecting the
     * estimated total number of rows in the read stream. This number is computed
     * based on the total table size and the number of active streams in the read
     * session, and may change as other streams continue to read data.
     * </pre>
     */
    default void readRows(
        com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates additional streams for a ReadSession. This API can be used to
     * dynamically adjust the parallelism of a batch processing task upwards by
     * adding additional workers.
     * </pre>
     */
    default void batchCreateReadSessionStreams(
        com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage
                    .BatchCreateReadSessionStreamsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateReadSessionStreamsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Causes a single stream in a ReadSession to gracefully stop. This
     * API can be used to dynamically adjust the parallelism of a batch processing
     * task downwards without losing data.
     * This API does not delete the stream -- it remains visible in the
     * ReadSession, and any data processed by the stream is not released to other
     * streams. However, no additional data will be assigned to the stream once
     * this call completes. Callers must continue reading data on the stream until
     * the end of the stream is reached so that data which has already been
     * assigned to the stream will be processed.
     * This method will return an error if there are no other live streams
     * in the Session, or if SplitReadStream() has been called on the given
     * Stream.
     * </pre>
     */
    default void finalizeStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFinalizeStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Splits a given read stream into two Streams. These streams are referred to
     * as the primary and the residual of the split. The original stream can still
     * be read from in the same manner as before. Both of the returned streams can
     * also be read from, and the total rows return by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back to back in the
     * original Stream. Concretely, it is guaranteed that for streams Original,
     * Primary, and Residual, that Original[0-j] = Primary[0-j] and
     * Original[j-n] = Residual[0-m] once the streams have been read to
     * completion.
     * This method is guaranteed to be idempotent.
     * </pre>
     */
    default void splitReadStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSplitReadStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BigQueryStorage.
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * The v1beta1 API is not yet officially deprecated, and will go through a full
   * deprecation cycle (https://cloud.google.com/products#product-launch-stages)
   * before the service is turned down. However, new code should use the v1 API
   * going forward.
   * </pre>
   */
  public abstract static class BigQueryStorageImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BigQueryStorageGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BigQueryStorage.
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * The v1beta1 API is not yet officially deprecated, and will go through a full
   * deprecation cycle (https://cloud.google.com/products#product-launch-stages)
   * before the service is turned down. However, new code should use the v1 API
   * going forward.
   * </pre>
   */
  public static final class BigQueryStorageStub
      extends io.grpc.stub.AbstractAsyncStub<BigQueryStorageStub> {
    private BigQueryStorageStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryStorageStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryStorageStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new read session. A read session divides the contents of a
     * BigQuery table into one or more streams, which can then be used to read
     * data from the table. The read session also specifies properties of the
     * data to be read, such as a list of columns or a push-down filter describing
     * the rows to be returned.
     * A particular row can be read by at most one stream. When the caller has
     * reached the end of each stream in the session, then all the data in the
     * table has been read.
     * Read sessions automatically expire 6 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public void createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReadSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the table in the format prescribed by the read session.
     * Each response contains one or more table rows, up to a maximum of 10 MiB
     * per response; read requests which attempt to read individual rows larger
     * than this will fail.
     * Each request also returns a set of stream statistics reflecting the
     * estimated total number of rows in the read stream. This number is computed
     * based on the total table size and the number of active streams in the read
     * session, and may change as other streams continue to read data.
     * </pre>
     */
    public void readRows(
        com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReadRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates additional streams for a ReadSession. This API can be used to
     * dynamically adjust the parallelism of a batch processing task upwards by
     * adding additional workers.
     * </pre>
     */
    public void batchCreateReadSessionStreams(
        com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage
                    .BatchCreateReadSessionStreamsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateReadSessionStreamsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Causes a single stream in a ReadSession to gracefully stop. This
     * API can be used to dynamically adjust the parallelism of a batch processing
     * task downwards without losing data.
     * This API does not delete the stream -- it remains visible in the
     * ReadSession, and any data processed by the stream is not released to other
     * streams. However, no additional data will be assigned to the stream once
     * this call completes. Callers must continue reading data on the stream until
     * the end of the stream is reached so that data which has already been
     * assigned to the stream will be processed.
     * This method will return an error if there are no other live streams
     * in the Session, or if SplitReadStream() has been called on the given
     * Stream.
     * </pre>
     */
    public void finalizeStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFinalizeStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Splits a given read stream into two Streams. These streams are referred to
     * as the primary and the residual of the split. The original stream can still
     * be read from in the same manner as before. Both of the returned streams can
     * also be read from, and the total rows return by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back to back in the
     * original Stream. Concretely, it is guaranteed that for streams Original,
     * Primary, and Residual, that Original[0-j] = Primary[0-j] and
     * Original[j-n] = Residual[0-m] once the streams have been read to
     * completion.
     * This method is guaranteed to be idempotent.
     * </pre>
     */
    public void splitReadStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSplitReadStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BigQueryStorage.
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * The v1beta1 API is not yet officially deprecated, and will go through a full
   * deprecation cycle (https://cloud.google.com/products#product-launch-stages)
   * before the service is turned down. However, new code should use the v1 API
   * going forward.
   * </pre>
   */
  public static final class BigQueryStorageBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BigQueryStorageBlockingStub> {
    private BigQueryStorageBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryStorageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryStorageBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new read session. A read session divides the contents of a
     * BigQuery table into one or more streams, which can then be used to read
     * data from the table. The read session also specifies properties of the
     * data to be read, such as a list of columns or a push-down filter describing
     * the rows to be returned.
     * A particular row can be read by at most one stream. When the caller has
     * reached the end of each stream in the session, then all the data in the
     * table has been read.
     * Read sessions automatically expire 6 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReadSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the table in the format prescribed by the read session.
     * Each response contains one or more table rows, up to a maximum of 10 MiB
     * per response; read requests which attempt to read individual rows larger
     * than this will fail.
     * Each request also returns a set of stream statistics reflecting the
     * estimated total number of rows in the read stream. This number is computed
     * based on the total table size and the number of active streams in the read
     * session, and may change as other streams continue to read data.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
        readRows(com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReadRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates additional streams for a ReadSession. This API can be used to
     * dynamically adjust the parallelism of a batch processing task upwards by
     * adding additional workers.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse
        batchCreateReadSessionStreams(
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateReadSessionStreamsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Causes a single stream in a ReadSession to gracefully stop. This
     * API can be used to dynamically adjust the parallelism of a batch processing
     * task downwards without losing data.
     * This API does not delete the stream -- it remains visible in the
     * ReadSession, and any data processed by the stream is not released to other
     * streams. However, no additional data will be assigned to the stream once
     * this call completes. Callers must continue reading data on the stream until
     * the end of the stream is reached so that data which has already been
     * assigned to the stream will be processed.
     * This method will return an error if there are no other live streams
     * in the Session, or if SplitReadStream() has been called on the given
     * Stream.
     * </pre>
     */
    public com.google.protobuf.Empty finalizeStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFinalizeStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Splits a given read stream into two Streams. These streams are referred to
     * as the primary and the residual of the split. The original stream can still
     * be read from in the same manner as before. Both of the returned streams can
     * also be read from, and the total rows return by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back to back in the
     * original Stream. Concretely, it is guaranteed that for streams Original,
     * Primary, and Residual, that Original[0-j] = Primary[0-j] and
     * Original[j-n] = Residual[0-m] once the streams have been read to
     * completion.
     * This method is guaranteed to be idempotent.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse
        splitReadStream(
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSplitReadStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BigQueryStorage.
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * The v1beta1 API is not yet officially deprecated, and will go through a full
   * deprecation cycle (https://cloud.google.com/products#product-launch-stages)
   * before the service is turned down. However, new code should use the v1 API
   * going forward.
   * </pre>
   */
  public static final class BigQueryStorageFutureStub
      extends io.grpc.stub.AbstractFutureStub<BigQueryStorageFutureStub> {
    private BigQueryStorageFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryStorageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryStorageFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new read session. A read session divides the contents of a
     * BigQuery table into one or more streams, which can then be used to read
     * data from the table. The read session also specifies properties of the
     * data to be read, such as a list of columns or a push-down filter describing
     * the rows to be returned.
     * A particular row can be read by at most one stream. When the caller has
     * reached the end of each stream in the session, then all the data in the
     * table has been read.
     * Read sessions automatically expire 6 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
        createReadSession(
            com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReadSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates additional streams for a ReadSession. This API can be used to
     * dynamically adjust the parallelism of a batch processing task upwards by
     * adding additional workers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreams(
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateReadSessionStreamsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Causes a single stream in a ReadSession to gracefully stop. This
     * API can be used to dynamically adjust the parallelism of a batch processing
     * task downwards without losing data.
     * This API does not delete the stream -- it remains visible in the
     * ReadSession, and any data processed by the stream is not released to other
     * streams. However, no additional data will be assigned to the stream once
     * this call completes. Callers must continue reading data on the stream until
     * the end of the stream is reached so that data which has already been
     * assigned to the stream will be processed.
     * This method will return an error if there are no other live streams
     * in the Session, or if SplitReadStream() has been called on the given
     * Stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        finalizeStream(
            com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFinalizeStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Splits a given read stream into two Streams. These streams are referred to
     * as the primary and the residual of the split. The original stream can still
     * be read from in the same manner as before. Both of the returned streams can
     * also be read from, and the total rows return by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back to back in the
     * original Stream. Concretely, it is guaranteed that for streams Original,
     * Primary, and Residual, that Original[0-j] = Primary[0-j] and
     * Original[j-n] = Residual[0-m] once the streams have been read to
     * completion.
     * This method is guaranteed to be idempotent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
        splitReadStream(
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSplitReadStreamMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_READ_SESSION = 0;
  private static final int METHODID_READ_ROWS = 1;
  private static final int METHODID_BATCH_CREATE_READ_SESSION_STREAMS = 2;
  private static final int METHODID_FINALIZE_STREAM = 3;
  private static final int METHODID_SPLIT_READ_STREAM = 4;

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
        case METHODID_CREATE_READ_SESSION:
          serviceImpl.createReadSession(
              (com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>)
                  responseObserver);
          break;
        case METHODID_READ_ROWS:
          serviceImpl.readRows(
              (com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_READ_SESSION_STREAMS:
          serviceImpl.batchCreateReadSessionStreams(
              (com.google.cloud.bigquery.storage.v1beta1.Storage
                      .BatchCreateReadSessionStreamsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1beta1.Storage
                          .BatchCreateReadSessionStreamsResponse>)
                  responseObserver);
          break;
        case METHODID_FINALIZE_STREAM:
          serviceImpl.finalizeStream(
              (com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SPLIT_READ_STREAM:
          serviceImpl.splitReadStream(
              (com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>)
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
            getCreateReadSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
                    com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>(
                    service, METHODID_CREATE_READ_SESSION)))
        .addMethod(
            getReadRowsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
                    com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>(
                    service, METHODID_READ_ROWS)))
        .addMethod(
            getBatchCreateReadSessionStreamsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1beta1.Storage
                        .BatchCreateReadSessionStreamsRequest,
                    com.google.cloud.bigquery.storage.v1beta1.Storage
                        .BatchCreateReadSessionStreamsResponse>(
                    service, METHODID_BATCH_CREATE_READ_SESSION_STREAMS)))
        .addMethod(
            getFinalizeStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
                    com.google.protobuf.Empty>(service, METHODID_FINALIZE_STREAM)))
        .addMethod(
            getSplitReadStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
                    com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>(
                    service, METHODID_SPLIT_READ_STREAM)))
        .build();
  }

  private abstract static class BigQueryStorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BigQueryStorageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.storage.v1beta1.Storage.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BigQueryStorage");
    }
  }

  private static final class BigQueryStorageFileDescriptorSupplier
      extends BigQueryStorageBaseDescriptorSupplier {
    BigQueryStorageFileDescriptorSupplier() {}
  }

  private static final class BigQueryStorageMethodDescriptorSupplier
      extends BigQueryStorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BigQueryStorageMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BigQueryStorageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BigQueryStorageFileDescriptorSupplier())
                      .addMethod(getCreateReadSessionMethod())
                      .addMethod(getReadRowsMethod())
                      .addMethod(getBatchCreateReadSessionStreamsMethod())
                      .addMethod(getFinalizeStreamMethod())
                      .addMethod(getSplitReadStreamMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
