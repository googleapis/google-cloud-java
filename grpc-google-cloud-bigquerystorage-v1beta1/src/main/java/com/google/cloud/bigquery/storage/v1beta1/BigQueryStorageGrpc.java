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

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/storage/v1beta1/storage.proto")
public final class BigQueryStorageGrpc {

  private BigQueryStorageGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.bigquery.storage.v1beta1.BigQueryStorage";

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

  /** */
  public abstract static class BigQueryStorageImplBase implements io.grpc.BindableService {

    /** */
    public void createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReadSessionMethod(), responseObserver);
    }

    /** */
    public void readRows(
        com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getReadRowsMethod(), responseObserver);
    }

    /** */
    public void batchCreateReadSessionStreams(
        com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage
                    .BatchCreateReadSessionStreamsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateReadSessionStreamsMethod(), responseObserver);
    }

    /** */
    public void finalizeStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getFinalizeStreamMethod(), responseObserver);
    }

    /** */
    public void splitReadStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
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
                      com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>(
                      this, METHODID_CREATE_READ_SESSION)))
          .addMethod(
              getReadRowsMethod(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>(
                      this, METHODID_READ_ROWS)))
          .addMethod(
              getBatchCreateReadSessionStreamsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage
                          .BatchCreateReadSessionStreamsRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage
                          .BatchCreateReadSessionStreamsResponse>(
                      this, METHODID_BATCH_CREATE_READ_SESSION_STREAMS)))
          .addMethod(
              getFinalizeStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest,
                      com.google.protobuf.Empty>(this, METHODID_FINALIZE_STREAM)))
          .addMethod(
              getSplitReadStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest,
                      com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>(
                      this, METHODID_SPLIT_READ_STREAM)))
          .build();
    }
  }

  /** */
  public static final class BigQueryStorageStub
      extends io.grpc.stub.AbstractAsyncStub<BigQueryStorageStub> {
    private BigQueryStorageStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigQueryStorageStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigQueryStorageStub(channel, callOptions);
    }

    /** */
    public void createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReadSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void readRows(
        com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
            responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReadRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /** */
    public void batchCreateReadSessionStreams(
        com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage
                    .BatchCreateReadSessionStreamsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateReadSessionStreamsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void finalizeStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFinalizeStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void splitReadStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSplitReadStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** */
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

    /** */
    public com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession createReadSession(
        com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReadSessionMethod(), getCallOptions(), request);
    }

    /** */
    public java.util.Iterator<com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse>
        readRows(com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getReadRowsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse
        batchCreateReadSessionStreams(
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
                request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateReadSessionStreamsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.protobuf.Empty finalizeStream(
        com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request) {
      return blockingUnaryCall(getChannel(), getFinalizeStreamMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse
        splitReadStream(
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request) {
      return blockingUnaryCall(getChannel(), getSplitReadStreamMethod(), getCallOptions(), request);
    }
  }

  /** */
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

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession>
        createReadSession(
            com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReadSessionMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreams(
            com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateReadSessionStreamsMethod(), getCallOptions()),
          request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        finalizeStream(
            com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFinalizeStreamMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse>
        splitReadStream(
            com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest request) {
      return futureUnaryCall(
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
