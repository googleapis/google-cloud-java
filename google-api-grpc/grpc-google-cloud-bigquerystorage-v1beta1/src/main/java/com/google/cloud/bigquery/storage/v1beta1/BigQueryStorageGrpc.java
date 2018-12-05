package com.google.cloud.bigquery.storage.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * BigQuery storage API.
 * The BigQuery storage API can be used to read data stored in BigQuery.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/bigquery/storage/v1beta1/storage.proto")
public final class BigQueryStorageGrpc {

  private BigQueryStorageGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.bigquery.storage.v1beta1.BigQueryStorage";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateReadSessionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
      METHOD_CREATE_READ_SESSION = getCreateReadSessionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
      getCreateReadSessionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
      getCreateReadSessionMethod() {
    return getCreateReadSessionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
      getCreateReadSessionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.bigquery.storage.v1beta1.BigQueryStorage",
                              "CreateReadSession"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRowsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
      METHOD_READ_ROWS = getReadRowsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
      getReadRowsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
      getReadRowsMethod() {
    return getReadRowsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
      getReadRowsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.bigquery.storage.v1beta1.BigQueryStorage", "ReadRows"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchCreateReadSessionStreamsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
      METHOD_BATCH_CREATE_READ_SESSION_STREAMS = getBatchCreateReadSessionStreamsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
      getBatchCreateReadSessionStreamsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
      getBatchCreateReadSessionStreamsMethod() {
    return getBatchCreateReadSessionStreamsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
      getBatchCreateReadSessionStreamsMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.bigquery.storage.v1beta1.BigQueryStorage",
                              "BatchCreateReadSessionStreams"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getFinalizeStreamMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
          com.google.protobuf.Empty>
      METHOD_FINALIZE_STREAM = getFinalizeStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
          com.google.protobuf.Empty>
      getFinalizeStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
          com.google.protobuf.Empty>
      getFinalizeStreamMethod() {
    return getFinalizeStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
          com.google.protobuf.Empty>
      getFinalizeStreamMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.bigquery.storage.v1beta1.BigQueryStorage",
                              "FinalizeStream"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSplitReadStreamMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
      METHOD_SPLIT_READ_STREAM = getSplitReadStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
      getSplitReadStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
      getSplitReadStreamMethod() {
    return getSplitReadStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
      getSplitReadStreamMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.bigquery.storage.v1beta1.BigQueryStorage",
                              "SplitReadStream"))
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
    return new BigQueryStorageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BigQueryStorageBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new BigQueryStorageBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BigQueryStorageFutureStub newFutureStub(io.grpc.Channel channel) {
    return new BigQueryStorageFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * </pre>
   */
  public abstract static class BigQueryStorageImplBase implements io.grpc.BindableService {

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
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public void createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReadSessionMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getReadRowsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getBatchCreateReadSessionStreamsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers the graceful termination of a single stream in a ReadSession. This
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
      asyncUnimplementedUnaryCall(getFinalizeStreamMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getSplitReadStreamMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateReadSessionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>(
                      this, METHODID_CREATE_READ_SESSION)))
          .addMethod(
              getReadRowsMethodHelper(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>(
                      this, METHODID_READ_ROWS)))
          .addMethod(
              getBatchCreateReadSessionStreamsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage
                          .BatchCreateReadSessionStreamsRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage
                          .BatchCreateReadSessionStreamsResponse>(
                      this, METHODID_BATCH_CREATE_READ_SESSION_STREAMS)))
          .addMethod(
              getFinalizeStreamMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
                      com.google.protobuf.Empty>(this, METHODID_FINALIZE_STREAM)))
          .addMethod(
              getSplitReadStreamMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>(
                      this, METHODID_SPLIT_READ_STREAM)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * </pre>
   */
  public static final class BigQueryStorageStub
      extends io.grpc.stub.AbstractStub<BigQueryStorageStub> {
    private BigQueryStorageStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public void createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReadSessionMethodHelper(), getCallOptions()),
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
      asyncServerStreamingCall(
          getChannel().newCall(getReadRowsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateReadSessionStreamsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers the graceful termination of a single stream in a ReadSession. This
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
      asyncUnaryCall(
          getChannel().newCall(getFinalizeStreamMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getSplitReadStreamMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * </pre>
   */
  public static final class BigQueryStorageBlockingStub
      extends io.grpc.stub.AbstractStub<BigQueryStorageBlockingStub> {
    private BigQueryStorageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReadSessionMethodHelper(), getCallOptions(), request);
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
      return blockingServerStreamingCall(
          getChannel(), getReadRowsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getBatchCreateReadSessionStreamsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Triggers the graceful termination of a single stream in a ReadSession. This
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
      return blockingUnaryCall(
          getChannel(), getFinalizeStreamMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getSplitReadStreamMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * BigQuery storage API.
   * The BigQuery storage API can be used to read data stored in BigQuery.
   * </pre>
   */
  public static final class BigQueryStorageFutureStub
      extends io.grpc.stub.AbstractStub<BigQueryStorageFutureStub> {
    private BigQueryStorageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
        createReadSession(
            com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReadSessionMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateReadSessionStreamsMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Triggers the graceful termination of a single stream in a ReadSession. This
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
      return futureUnaryCall(
          getChannel().newCall(getFinalizeStreamMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getSplitReadStreamMethodHelper(), getCallOptions()), request);
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
    private final BigQueryStorageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BigQueryStorageImplBase serviceImpl, int methodId) {
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
    private final String methodName;

    BigQueryStorageMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getCreateReadSessionMethodHelper())
                      .addMethod(getReadRowsMethodHelper())
                      .addMethod(getBatchCreateReadSessionStreamsMethodHelper())
                      .addMethod(getFinalizeStreamMethodHelper())
                      .addMethod(getSplitReadStreamMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
