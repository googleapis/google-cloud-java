/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1;

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
 * BigQuery Read API.
 * The Read API can be used to read data from BigQuery.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/storage/v1/storage.proto")
public final class BigQueryReadGrpc {

  private BigQueryReadGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.bigquery.storage.v1.BigQueryRead";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1.ReadSession>
      getCreateReadSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReadSession",
      requestType = com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest.class,
      responseType = com.google.cloud.bigquery.storage.v1.ReadSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest,
          com.google.cloud.bigquery.storage.v1.ReadSession>
      getCreateReadSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest,
            com.google.cloud.bigquery.storage.v1.ReadSession>
        getCreateReadSessionMethod;
    if ((getCreateReadSessionMethod = BigQueryReadGrpc.getCreateReadSessionMethod) == null) {
      synchronized (BigQueryReadGrpc.class) {
        if ((getCreateReadSessionMethod = BigQueryReadGrpc.getCreateReadSessionMethod) == null) {
          BigQueryReadGrpc.getCreateReadSessionMethod =
              getCreateReadSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest,
                          com.google.cloud.bigquery.storage.v1.ReadSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReadSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1.ReadSession
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryReadMethodDescriptorSupplier("CreateReadSession"))
                      .build();
        }
      }
    }
    return getCreateReadSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1.ReadRowsResponse>
      getReadRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadRows",
      requestType = com.google.cloud.bigquery.storage.v1.ReadRowsRequest.class,
      responseType = com.google.cloud.bigquery.storage.v1.ReadRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1.ReadRowsRequest,
          com.google.cloud.bigquery.storage.v1.ReadRowsResponse>
      getReadRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1.ReadRowsRequest,
            com.google.cloud.bigquery.storage.v1.ReadRowsResponse>
        getReadRowsMethod;
    if ((getReadRowsMethod = BigQueryReadGrpc.getReadRowsMethod) == null) {
      synchronized (BigQueryReadGrpc.class) {
        if ((getReadRowsMethod = BigQueryReadGrpc.getReadRowsMethod) == null) {
          BigQueryReadGrpc.getReadRowsMethod =
              getReadRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1.ReadRowsRequest,
                          com.google.cloud.bigquery.storage.v1.ReadRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1.ReadRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1.ReadRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BigQueryReadMethodDescriptorSupplier("ReadRows"))
                      .build();
        }
      }
    }
    return getReadRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>
      getSplitReadStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SplitReadStream",
      requestType = com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest.class,
      responseType = com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest,
          com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>
      getSplitReadStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest,
            com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>
        getSplitReadStreamMethod;
    if ((getSplitReadStreamMethod = BigQueryReadGrpc.getSplitReadStreamMethod) == null) {
      synchronized (BigQueryReadGrpc.class) {
        if ((getSplitReadStreamMethod = BigQueryReadGrpc.getSplitReadStreamMethod) == null) {
          BigQueryReadGrpc.getSplitReadStreamMethod =
              getSplitReadStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest,
                          com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SplitReadStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigQueryReadMethodDescriptorSupplier("SplitReadStream"))
                      .build();
        }
      }
    }
    return getSplitReadStreamMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BigQueryReadStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryReadStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryReadStub>() {
          @java.lang.Override
          public BigQueryReadStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryReadStub(channel, callOptions);
          }
        };
    return BigQueryReadStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BigQueryReadBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryReadBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryReadBlockingStub>() {
          @java.lang.Override
          public BigQueryReadBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryReadBlockingStub(channel, callOptions);
          }
        };
    return BigQueryReadBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BigQueryReadFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigQueryReadFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigQueryReadFutureStub>() {
          @java.lang.Override
          public BigQueryReadFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigQueryReadFutureStub(channel, callOptions);
          }
        };
    return BigQueryReadFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * BigQuery Read API.
   * The Read API can be used to read data from BigQuery.
   * </pre>
   */
  public abstract static class BigQueryReadImplBase implements io.grpc.BindableService {

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
     * Data is assigned to each stream such that roughly the same number of
     * rows can be read from each stream. Because the server-side unit for
     * assigning data is collections of rows, the API does not guarantee that
     * each stream will return the same number or rows. Additionally, the
     * limits are enforced based on the number of pre-filtered rows, so some
     * filters can lead to lopsided assignments.
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public void createReadSession(
        com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.ReadSession>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReadSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the stream in the format prescribed by the ReadSession.
     * Each response contains one or more table rows, up to a maximum of 100 MiB
     * per response; read requests which attempt to read individual rows larger
     * than 100 MiB will fail.
     * Each request also returns a set of stream statistics reflecting the current
     * state of the stream.
     * </pre>
     */
    public void readRows(
        com.google.cloud.bigquery.storage.v1.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.ReadRowsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getReadRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Splits a given `ReadStream` into two `ReadStream` objects. These
     * `ReadStream` objects are referred to as the primary and the residual
     * streams of the split. The original `ReadStream` can still be read from in
     * the same manner as before. Both of the returned `ReadStream` objects can
     * also be read from, and the rows returned by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back-to-back in the
     * original `ReadStream`. Concretely, it is guaranteed that for streams
     * original, primary, and residual, that original[0-j] = primary[0-j] and
     * original[j-n] = residual[0-m] once the streams have been read to
     * completion.
     * </pre>
     */
    public void splitReadStream(
        com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSplitReadStreamMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateReadSessionMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest,
                      com.google.cloud.bigquery.storage.v1.ReadSession>(
                      this, METHODID_CREATE_READ_SESSION)))
          .addMethod(
              getReadRowsMethod(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1.ReadRowsRequest,
                      com.google.cloud.bigquery.storage.v1.ReadRowsResponse>(
                      this, METHODID_READ_ROWS)))
          .addMethod(
              getSplitReadStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest,
                      com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>(
                      this, METHODID_SPLIT_READ_STREAM)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * BigQuery Read API.
   * The Read API can be used to read data from BigQuery.
   * </pre>
   */
  public static final class BigQueryReadStub
      extends io.grpc.stub.AbstractAsyncStub<BigQueryReadStub> {
    private BigQueryReadStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryReadStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryReadStub(channel, callOptions);
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
     * Data is assigned to each stream such that roughly the same number of
     * rows can be read from each stream. Because the server-side unit for
     * assigning data is collections of rows, the API does not guarantee that
     * each stream will return the same number or rows. Additionally, the
     * limits are enforced based on the number of pre-filtered rows, so some
     * filters can lead to lopsided assignments.
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public void createReadSession(
        com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.ReadSession>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReadSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the stream in the format prescribed by the ReadSession.
     * Each response contains one or more table rows, up to a maximum of 100 MiB
     * per response; read requests which attempt to read individual rows larger
     * than 100 MiB will fail.
     * Each request also returns a set of stream statistics reflecting the current
     * state of the stream.
     * </pre>
     */
    public void readRows(
        com.google.cloud.bigquery.storage.v1.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.ReadRowsResponse>
            responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReadRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Splits a given `ReadStream` into two `ReadStream` objects. These
     * `ReadStream` objects are referred to as the primary and the residual
     * streams of the split. The original `ReadStream` can still be read from in
     * the same manner as before. Both of the returned `ReadStream` objects can
     * also be read from, and the rows returned by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back-to-back in the
     * original `ReadStream`. Concretely, it is guaranteed that for streams
     * original, primary, and residual, that original[0-j] = primary[0-j] and
     * original[j-n] = residual[0-m] once the streams have been read to
     * completion.
     * </pre>
     */
    public void splitReadStream(
        com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSplitReadStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * BigQuery Read API.
   * The Read API can be used to read data from BigQuery.
   * </pre>
   */
  public static final class BigQueryReadBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BigQueryReadBlockingStub> {
    private BigQueryReadBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryReadBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryReadBlockingStub(channel, callOptions);
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
     * Data is assigned to each stream such that roughly the same number of
     * rows can be read from each stream. Because the server-side unit for
     * assigning data is collections of rows, the API does not guarantee that
     * each stream will return the same number or rows. Additionally, the
     * limits are enforced based on the number of pre-filtered rows, so some
     * filters can lead to lopsided assignments.
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1.ReadSession createReadSession(
        com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReadSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads rows from the stream in the format prescribed by the ReadSession.
     * Each response contains one or more table rows, up to a maximum of 100 MiB
     * per response; read requests which attempt to read individual rows larger
     * than 100 MiB will fail.
     * Each request also returns a set of stream statistics reflecting the current
     * state of the stream.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.bigquery.storage.v1.ReadRowsResponse> readRows(
        com.google.cloud.bigquery.storage.v1.ReadRowsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getReadRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Splits a given `ReadStream` into two `ReadStream` objects. These
     * `ReadStream` objects are referred to as the primary and the residual
     * streams of the split. The original `ReadStream` can still be read from in
     * the same manner as before. Both of the returned `ReadStream` objects can
     * also be read from, and the rows returned by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back-to-back in the
     * original `ReadStream`. Concretely, it is guaranteed that for streams
     * original, primary, and residual, that original[0-j] = primary[0-j] and
     * original[j-n] = residual[0-m] once the streams have been read to
     * completion.
     * </pre>
     */
    public com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse splitReadStream(
        com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest request) {
      return blockingUnaryCall(getChannel(), getSplitReadStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * BigQuery Read API.
   * The Read API can be used to read data from BigQuery.
   * </pre>
   */
  public static final class BigQueryReadFutureStub
      extends io.grpc.stub.AbstractFutureStub<BigQueryReadFutureStub> {
    private BigQueryReadFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryReadFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryReadFutureStub(channel, callOptions);
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
     * Data is assigned to each stream such that roughly the same number of
     * rows can be read from each stream. Because the server-side unit for
     * assigning data is collections of rows, the API does not guarantee that
     * each stream will return the same number or rows. Additionally, the
     * limits are enforced based on the number of pre-filtered rows, so some
     * filters can lead to lopsided assignments.
     * Read sessions automatically expire 24 hours after they are created and do
     * not require manual clean-up by the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1.ReadSession>
        createReadSession(com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReadSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Splits a given `ReadStream` into two `ReadStream` objects. These
     * `ReadStream` objects are referred to as the primary and the residual
     * streams of the split. The original `ReadStream` can still be read from in
     * the same manner as before. Both of the returned `ReadStream` objects can
     * also be read from, and the rows returned by both child streams will be
     * the same as the rows read from the original stream.
     * Moreover, the two child streams will be allocated back-to-back in the
     * original `ReadStream`. Concretely, it is guaranteed that for streams
     * original, primary, and residual, that original[0-j] = primary[0-j] and
     * original[j-n] = residual[0-m] once the streams have been read to
     * completion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>
        splitReadStream(com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSplitReadStreamMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_READ_SESSION = 0;
  private static final int METHODID_READ_ROWS = 1;
  private static final int METHODID_SPLIT_READ_STREAM = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BigQueryReadImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BigQueryReadImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_READ_SESSION:
          serviceImpl.createReadSession(
              (com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.ReadSession>)
                  responseObserver);
          break;
        case METHODID_READ_ROWS:
          serviceImpl.readRows(
              (com.google.cloud.bigquery.storage.v1.ReadRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1.ReadRowsResponse>)
                  responseObserver);
          break;
        case METHODID_SPLIT_READ_STREAM:
          serviceImpl.splitReadStream(
              (com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse>)
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

  private abstract static class BigQueryReadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BigQueryReadBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.storage.v1.StorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BigQueryRead");
    }
  }

  private static final class BigQueryReadFileDescriptorSupplier
      extends BigQueryReadBaseDescriptorSupplier {
    BigQueryReadFileDescriptorSupplier() {}
  }

  private static final class BigQueryReadMethodDescriptorSupplier
      extends BigQueryReadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BigQueryReadMethodDescriptorSupplier(String methodName) {
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
      synchronized (BigQueryReadGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BigQueryReadFileDescriptorSupplier())
                      .addMethod(getCreateReadSessionMethod())
                      .addMethod(getReadRowsMethod())
                      .addMethod(getSplitReadStreamMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
