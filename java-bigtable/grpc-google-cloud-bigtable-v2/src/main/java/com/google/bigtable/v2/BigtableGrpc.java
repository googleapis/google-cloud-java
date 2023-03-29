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
package com.google.bigtable.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for reading from and writing to existing Bigtable tables.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/bigtable/v2/bigtable.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BigtableGrpc {

  private BigtableGrpc() {}

  public static final String SERVICE_NAME = "google.bigtable.v2.Bigtable";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.ReadRowsRequest, com.google.bigtable.v2.ReadRowsResponse>
      getReadRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadRows",
      requestType = com.google.bigtable.v2.ReadRowsRequest.class,
      responseType = com.google.bigtable.v2.ReadRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.ReadRowsRequest, com.google.bigtable.v2.ReadRowsResponse>
      getReadRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.ReadRowsRequest, com.google.bigtable.v2.ReadRowsResponse>
        getReadRowsMethod;
    if ((getReadRowsMethod = BigtableGrpc.getReadRowsMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getReadRowsMethod = BigtableGrpc.getReadRowsMethod) == null) {
          BigtableGrpc.getReadRowsMethod =
              getReadRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.ReadRowsRequest,
                          com.google.bigtable.v2.ReadRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.ReadRowsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.ReadRowsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BigtableMethodDescriptorSupplier("ReadRows"))
                      .build();
        }
      }
    }
    return getReadRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.SampleRowKeysRequest, com.google.bigtable.v2.SampleRowKeysResponse>
      getSampleRowKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SampleRowKeys",
      requestType = com.google.bigtable.v2.SampleRowKeysRequest.class,
      responseType = com.google.bigtable.v2.SampleRowKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.SampleRowKeysRequest, com.google.bigtable.v2.SampleRowKeysResponse>
      getSampleRowKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.SampleRowKeysRequest,
            com.google.bigtable.v2.SampleRowKeysResponse>
        getSampleRowKeysMethod;
    if ((getSampleRowKeysMethod = BigtableGrpc.getSampleRowKeysMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getSampleRowKeysMethod = BigtableGrpc.getSampleRowKeysMethod) == null) {
          BigtableGrpc.getSampleRowKeysMethod =
              getSampleRowKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.SampleRowKeysRequest,
                          com.google.bigtable.v2.SampleRowKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SampleRowKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.SampleRowKeysRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.SampleRowKeysResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BigtableMethodDescriptorSupplier("SampleRowKeys"))
                      .build();
        }
      }
    }
    return getSampleRowKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.MutateRowRequest, com.google.bigtable.v2.MutateRowResponse>
      getMutateRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MutateRow",
      requestType = com.google.bigtable.v2.MutateRowRequest.class,
      responseType = com.google.bigtable.v2.MutateRowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.MutateRowRequest, com.google.bigtable.v2.MutateRowResponse>
      getMutateRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.MutateRowRequest, com.google.bigtable.v2.MutateRowResponse>
        getMutateRowMethod;
    if ((getMutateRowMethod = BigtableGrpc.getMutateRowMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getMutateRowMethod = BigtableGrpc.getMutateRowMethod) == null) {
          BigtableGrpc.getMutateRowMethod =
              getMutateRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.MutateRowRequest,
                          com.google.bigtable.v2.MutateRowResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MutateRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.MutateRowRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.MutateRowResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BigtableMethodDescriptorSupplier("MutateRow"))
                      .build();
        }
      }
    }
    return getMutateRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.MutateRowsRequest, com.google.bigtable.v2.MutateRowsResponse>
      getMutateRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MutateRows",
      requestType = com.google.bigtable.v2.MutateRowsRequest.class,
      responseType = com.google.bigtable.v2.MutateRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.MutateRowsRequest, com.google.bigtable.v2.MutateRowsResponse>
      getMutateRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.MutateRowsRequest, com.google.bigtable.v2.MutateRowsResponse>
        getMutateRowsMethod;
    if ((getMutateRowsMethod = BigtableGrpc.getMutateRowsMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getMutateRowsMethod = BigtableGrpc.getMutateRowsMethod) == null) {
          BigtableGrpc.getMutateRowsMethod =
              getMutateRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.MutateRowsRequest,
                          com.google.bigtable.v2.MutateRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MutateRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.MutateRowsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.MutateRowsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BigtableMethodDescriptorSupplier("MutateRows"))
                      .build();
        }
      }
    }
    return getMutateRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.CheckAndMutateRowRequest,
          com.google.bigtable.v2.CheckAndMutateRowResponse>
      getCheckAndMutateRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckAndMutateRow",
      requestType = com.google.bigtable.v2.CheckAndMutateRowRequest.class,
      responseType = com.google.bigtable.v2.CheckAndMutateRowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.CheckAndMutateRowRequest,
          com.google.bigtable.v2.CheckAndMutateRowResponse>
      getCheckAndMutateRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.CheckAndMutateRowRequest,
            com.google.bigtable.v2.CheckAndMutateRowResponse>
        getCheckAndMutateRowMethod;
    if ((getCheckAndMutateRowMethod = BigtableGrpc.getCheckAndMutateRowMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getCheckAndMutateRowMethod = BigtableGrpc.getCheckAndMutateRowMethod) == null) {
          BigtableGrpc.getCheckAndMutateRowMethod =
              getCheckAndMutateRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.CheckAndMutateRowRequest,
                          com.google.bigtable.v2.CheckAndMutateRowResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckAndMutateRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.CheckAndMutateRowRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.CheckAndMutateRowResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableMethodDescriptorSupplier("CheckAndMutateRow"))
                      .build();
        }
      }
    }
    return getCheckAndMutateRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.PingAndWarmRequest, com.google.bigtable.v2.PingAndWarmResponse>
      getPingAndWarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PingAndWarm",
      requestType = com.google.bigtable.v2.PingAndWarmRequest.class,
      responseType = com.google.bigtable.v2.PingAndWarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.PingAndWarmRequest, com.google.bigtable.v2.PingAndWarmResponse>
      getPingAndWarmMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.PingAndWarmRequest, com.google.bigtable.v2.PingAndWarmResponse>
        getPingAndWarmMethod;
    if ((getPingAndWarmMethod = BigtableGrpc.getPingAndWarmMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getPingAndWarmMethod = BigtableGrpc.getPingAndWarmMethod) == null) {
          BigtableGrpc.getPingAndWarmMethod =
              getPingAndWarmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.PingAndWarmRequest,
                          com.google.bigtable.v2.PingAndWarmResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PingAndWarm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.PingAndWarmRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.PingAndWarmResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BigtableMethodDescriptorSupplier("PingAndWarm"))
                      .build();
        }
      }
    }
    return getPingAndWarmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.ReadModifyWriteRowRequest,
          com.google.bigtable.v2.ReadModifyWriteRowResponse>
      getReadModifyWriteRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadModifyWriteRow",
      requestType = com.google.bigtable.v2.ReadModifyWriteRowRequest.class,
      responseType = com.google.bigtable.v2.ReadModifyWriteRowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.ReadModifyWriteRowRequest,
          com.google.bigtable.v2.ReadModifyWriteRowResponse>
      getReadModifyWriteRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.ReadModifyWriteRowRequest,
            com.google.bigtable.v2.ReadModifyWriteRowResponse>
        getReadModifyWriteRowMethod;
    if ((getReadModifyWriteRowMethod = BigtableGrpc.getReadModifyWriteRowMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getReadModifyWriteRowMethod = BigtableGrpc.getReadModifyWriteRowMethod) == null) {
          BigtableGrpc.getReadModifyWriteRowMethod =
              getReadModifyWriteRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.ReadModifyWriteRowRequest,
                          com.google.bigtable.v2.ReadModifyWriteRowResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadModifyWriteRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.ReadModifyWriteRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.ReadModifyWriteRowResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableMethodDescriptorSupplier("ReadModifyWriteRow"))
                      .build();
        }
      }
    }
    return getReadModifyWriteRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest,
          com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>
      getGenerateInitialChangeStreamPartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateInitialChangeStreamPartitions",
      requestType = com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest.class,
      responseType = com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest,
          com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>
      getGenerateInitialChangeStreamPartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest,
            com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>
        getGenerateInitialChangeStreamPartitionsMethod;
    if ((getGenerateInitialChangeStreamPartitionsMethod =
            BigtableGrpc.getGenerateInitialChangeStreamPartitionsMethod)
        == null) {
      synchronized (BigtableGrpc.class) {
        if ((getGenerateInitialChangeStreamPartitionsMethod =
                BigtableGrpc.getGenerateInitialChangeStreamPartitionsMethod)
            == null) {
          BigtableGrpc.getGenerateInitialChangeStreamPartitionsMethod =
              getGenerateInitialChangeStreamPartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest,
                          com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateInitialChangeStreamPartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableMethodDescriptorSupplier(
                              "GenerateInitialChangeStreamPartitions"))
                      .build();
        }
      }
    }
    return getGenerateInitialChangeStreamPartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.v2.ReadChangeStreamRequest,
          com.google.bigtable.v2.ReadChangeStreamResponse>
      getReadChangeStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadChangeStream",
      requestType = com.google.bigtable.v2.ReadChangeStreamRequest.class,
      responseType = com.google.bigtable.v2.ReadChangeStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.v2.ReadChangeStreamRequest,
          com.google.bigtable.v2.ReadChangeStreamResponse>
      getReadChangeStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.v2.ReadChangeStreamRequest,
            com.google.bigtable.v2.ReadChangeStreamResponse>
        getReadChangeStreamMethod;
    if ((getReadChangeStreamMethod = BigtableGrpc.getReadChangeStreamMethod) == null) {
      synchronized (BigtableGrpc.class) {
        if ((getReadChangeStreamMethod = BigtableGrpc.getReadChangeStreamMethod) == null) {
          BigtableGrpc.getReadChangeStreamMethod =
              getReadChangeStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.v2.ReadChangeStreamRequest,
                          com.google.bigtable.v2.ReadChangeStreamResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadChangeStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.ReadChangeStreamRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.v2.ReadChangeStreamResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new BigtableMethodDescriptorSupplier("ReadChangeStream"))
                      .build();
        }
      }
    }
    return getReadChangeStreamMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BigtableStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigtableStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigtableStub>() {
          @java.lang.Override
          public BigtableStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigtableStub(channel, callOptions);
          }
        };
    return BigtableStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BigtableBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigtableBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigtableBlockingStub>() {
          @java.lang.Override
          public BigtableBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigtableBlockingStub(channel, callOptions);
          }
        };
    return BigtableBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BigtableFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigtableFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigtableFutureStub>() {
          @java.lang.Override
          public BigtableFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigtableFutureStub(channel, callOptions);
          }
        };
    return BigtableFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for reading from and writing to existing Bigtable tables.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Streams back the contents of all requested rows in key order, optionally
     * applying the same Reader filter to each. Depending on their size,
     * rows and cells may be broken up across multiple responses, but
     * atomicity of each row will still be preserved. See the
     * ReadRowsResponse documentation for details.
     * </pre>
     */
    default void readRows(
        com.google.bigtable.v2.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadRowsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a sample of row keys in the table. The returned row keys will
     * delimit contiguous sections of the table of approximately equal size,
     * which can be used to break up the data for distributed tasks like
     * mapreduces.
     * </pre>
     */
    default void sampleRowKeys(
        com.google.bigtable.v2.SampleRowKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.SampleRowKeysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSampleRowKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically. Cells already present in the row are left
     * unchanged unless explicitly changed by `mutation`.
     * </pre>
     */
    default void mutateRow(
        com.google.bigtable.v2.MutateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.MutateRowResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMutateRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Mutates multiple rows in a batch. Each individual row is mutated
     * atomically as in MutateRow, but the entire batch is not executed
     * atomically.
     * </pre>
     */
    default void mutateRows(
        com.google.bigtable.v2.MutateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.MutateRowsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMutateRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically based on the output of a predicate Reader filter.
     * </pre>
     */
    default void checkAndMutateRow(
        com.google.bigtable.v2.CheckAndMutateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.CheckAndMutateRowResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckAndMutateRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warm up associated instance metadata for this connection.
     * This call is not required but may be useful for connection keep-alive.
     * </pre>
     */
    default void pingAndWarm(
        com.google.bigtable.v2.PingAndWarmRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.PingAndWarmResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPingAndWarmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a row atomically on the server. The method reads the latest
     * existing timestamp and value from the specified columns and writes a new
     * entry based on pre-defined read/modify/write rules. The new value for the
     * timestamp is the greater of the existing timestamp or the current server
     * time. The method returns the new contents of all modified cells.
     * </pre>
     */
    default void readModifyWriteRow(
        com.google.bigtable.v2.ReadModifyWriteRowRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadModifyWriteRowResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReadModifyWriteRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * NOTE: This API is intended to be used by Apache Beam BigtableIO.
     * Returns the current list of partitions that make up the table's
     * change stream. The union of partitions will cover the entire keyspace.
     * Partitions can be read with `ReadChangeStream`.
     * </pre>
     */
    default void generateInitialChangeStreamPartitions(
        com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateInitialChangeStreamPartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * NOTE: This API is intended to be used by Apache Beam BigtableIO.
     * Reads changes from a table's change stream. Changes will
     * reflect both user-initiated mutations and mutations that are caused by
     * garbage collection.
     * </pre>
     */
    default void readChangeStream(
        com.google.bigtable.v2.ReadChangeStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadChangeStreamResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReadChangeStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Bigtable.
   *
   * <pre>
   * Service for reading from and writing to existing Bigtable tables.
   * </pre>
   */
  public abstract static class BigtableImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BigtableGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Bigtable.
   *
   * <pre>
   * Service for reading from and writing to existing Bigtable tables.
   * </pre>
   */
  public static final class BigtableStub extends io.grpc.stub.AbstractAsyncStub<BigtableStub> {
    private BigtableStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigtableStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Streams back the contents of all requested rows in key order, optionally
     * applying the same Reader filter to each. Depending on their size,
     * rows and cells may be broken up across multiple responses, but
     * atomicity of each row will still be preserved. See the
     * ReadRowsResponse documentation for details.
     * </pre>
     */
    public void readRows(
        com.google.bigtable.v2.ReadRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadRowsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReadRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a sample of row keys in the table. The returned row keys will
     * delimit contiguous sections of the table of approximately equal size,
     * which can be used to break up the data for distributed tasks like
     * mapreduces.
     * </pre>
     */
    public void sampleRowKeys(
        com.google.bigtable.v2.SampleRowKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.SampleRowKeysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSampleRowKeysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically. Cells already present in the row are left
     * unchanged unless explicitly changed by `mutation`.
     * </pre>
     */
    public void mutateRow(
        com.google.bigtable.v2.MutateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.MutateRowResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMutateRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Mutates multiple rows in a batch. Each individual row is mutated
     * atomically as in MutateRow, but the entire batch is not executed
     * atomically.
     * </pre>
     */
    public void mutateRows(
        com.google.bigtable.v2.MutateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.MutateRowsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMutateRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically based on the output of a predicate Reader filter.
     * </pre>
     */
    public void checkAndMutateRow(
        com.google.bigtable.v2.CheckAndMutateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.CheckAndMutateRowResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckAndMutateRowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warm up associated instance metadata for this connection.
     * This call is not required but may be useful for connection keep-alive.
     * </pre>
     */
    public void pingAndWarm(
        com.google.bigtable.v2.PingAndWarmRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.PingAndWarmResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingAndWarmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a row atomically on the server. The method reads the latest
     * existing timestamp and value from the specified columns and writes a new
     * entry based on pre-defined read/modify/write rules. The new value for the
     * timestamp is the greater of the existing timestamp or the current server
     * time. The method returns the new contents of all modified cells.
     * </pre>
     */
    public void readModifyWriteRow(
        com.google.bigtable.v2.ReadModifyWriteRowRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadModifyWriteRowResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadModifyWriteRowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * NOTE: This API is intended to be used by Apache Beam BigtableIO.
     * Returns the current list of partitions that make up the table's
     * change stream. The union of partitions will cover the entire keyspace.
     * Partitions can be read with `ReadChangeStream`.
     * </pre>
     */
    public void generateInitialChangeStreamPartitions(
        com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGenerateInitialChangeStreamPartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * NOTE: This API is intended to be used by Apache Beam BigtableIO.
     * Reads changes from a table's change stream. Changes will
     * reflect both user-initiated mutations and mutations that are caused by
     * garbage collection.
     * </pre>
     */
    public void readChangeStream(
        com.google.bigtable.v2.ReadChangeStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadChangeStreamResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReadChangeStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Bigtable.
   *
   * <pre>
   * Service for reading from and writing to existing Bigtable tables.
   * </pre>
   */
  public static final class BigtableBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BigtableBlockingStub> {
    private BigtableBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigtableBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Streams back the contents of all requested rows in key order, optionally
     * applying the same Reader filter to each. Depending on their size,
     * rows and cells may be broken up across multiple responses, but
     * atomicity of each row will still be preserved. See the
     * ReadRowsResponse documentation for details.
     * </pre>
     */
    public java.util.Iterator<com.google.bigtable.v2.ReadRowsResponse> readRows(
        com.google.bigtable.v2.ReadRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReadRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a sample of row keys in the table. The returned row keys will
     * delimit contiguous sections of the table of approximately equal size,
     * which can be used to break up the data for distributed tasks like
     * mapreduces.
     * </pre>
     */
    public java.util.Iterator<com.google.bigtable.v2.SampleRowKeysResponse> sampleRowKeys(
        com.google.bigtable.v2.SampleRowKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSampleRowKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically. Cells already present in the row are left
     * unchanged unless explicitly changed by `mutation`.
     * </pre>
     */
    public com.google.bigtable.v2.MutateRowResponse mutateRow(
        com.google.bigtable.v2.MutateRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMutateRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Mutates multiple rows in a batch. Each individual row is mutated
     * atomically as in MutateRow, but the entire batch is not executed
     * atomically.
     * </pre>
     */
    public java.util.Iterator<com.google.bigtable.v2.MutateRowsResponse> mutateRows(
        com.google.bigtable.v2.MutateRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMutateRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically based on the output of a predicate Reader filter.
     * </pre>
     */
    public com.google.bigtable.v2.CheckAndMutateRowResponse checkAndMutateRow(
        com.google.bigtable.v2.CheckAndMutateRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckAndMutateRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Warm up associated instance metadata for this connection.
     * This call is not required but may be useful for connection keep-alive.
     * </pre>
     */
    public com.google.bigtable.v2.PingAndWarmResponse pingAndWarm(
        com.google.bigtable.v2.PingAndWarmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingAndWarmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a row atomically on the server. The method reads the latest
     * existing timestamp and value from the specified columns and writes a new
     * entry based on pre-defined read/modify/write rules. The new value for the
     * timestamp is the greater of the existing timestamp or the current server
     * time. The method returns the new contents of all modified cells.
     * </pre>
     */
    public com.google.bigtable.v2.ReadModifyWriteRowResponse readModifyWriteRow(
        com.google.bigtable.v2.ReadModifyWriteRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadModifyWriteRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * NOTE: This API is intended to be used by Apache Beam BigtableIO.
     * Returns the current list of partitions that make up the table's
     * change stream. The union of partitions will cover the entire keyspace.
     * Partitions can be read with `ReadChangeStream`.
     * </pre>
     */
    public java.util.Iterator<com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>
        generateInitialChangeStreamPartitions(
            com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(),
          getGenerateInitialChangeStreamPartitionsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * NOTE: This API is intended to be used by Apache Beam BigtableIO.
     * Reads changes from a table's change stream. Changes will
     * reflect both user-initiated mutations and mutations that are caused by
     * garbage collection.
     * </pre>
     */
    public java.util.Iterator<com.google.bigtable.v2.ReadChangeStreamResponse> readChangeStream(
        com.google.bigtable.v2.ReadChangeStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReadChangeStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Bigtable.
   *
   * <pre>
   * Service for reading from and writing to existing Bigtable tables.
   * </pre>
   */
  public static final class BigtableFutureStub
      extends io.grpc.stub.AbstractFutureStub<BigtableFutureStub> {
    private BigtableFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigtableFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically. Cells already present in the row are left
     * unchanged unless explicitly changed by `mutation`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.v2.MutateRowResponse>
        mutateRow(com.google.bigtable.v2.MutateRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMutateRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Mutates a row atomically based on the output of a predicate Reader filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.v2.CheckAndMutateRowResponse>
        checkAndMutateRow(com.google.bigtable.v2.CheckAndMutateRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckAndMutateRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Warm up associated instance metadata for this connection.
     * This call is not required but may be useful for connection keep-alive.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.v2.PingAndWarmResponse>
        pingAndWarm(com.google.bigtable.v2.PingAndWarmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingAndWarmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a row atomically on the server. The method reads the latest
     * existing timestamp and value from the specified columns and writes a new
     * entry based on pre-defined read/modify/write rules. The new value for the
     * timestamp is the greater of the existing timestamp or the current server
     * time. The method returns the new contents of all modified cells.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.v2.ReadModifyWriteRowResponse>
        readModifyWriteRow(com.google.bigtable.v2.ReadModifyWriteRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadModifyWriteRowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ_ROWS = 0;
  private static final int METHODID_SAMPLE_ROW_KEYS = 1;
  private static final int METHODID_MUTATE_ROW = 2;
  private static final int METHODID_MUTATE_ROWS = 3;
  private static final int METHODID_CHECK_AND_MUTATE_ROW = 4;
  private static final int METHODID_PING_AND_WARM = 5;
  private static final int METHODID_READ_MODIFY_WRITE_ROW = 6;
  private static final int METHODID_GENERATE_INITIAL_CHANGE_STREAM_PARTITIONS = 7;
  private static final int METHODID_READ_CHANGE_STREAM = 8;

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
        case METHODID_READ_ROWS:
          serviceImpl.readRows(
              (com.google.bigtable.v2.ReadRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadRowsResponse>)
                  responseObserver);
          break;
        case METHODID_SAMPLE_ROW_KEYS:
          serviceImpl.sampleRowKeys(
              (com.google.bigtable.v2.SampleRowKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.SampleRowKeysResponse>)
                  responseObserver);
          break;
        case METHODID_MUTATE_ROW:
          serviceImpl.mutateRow(
              (com.google.bigtable.v2.MutateRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.MutateRowResponse>)
                  responseObserver);
          break;
        case METHODID_MUTATE_ROWS:
          serviceImpl.mutateRows(
              (com.google.bigtable.v2.MutateRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.MutateRowsResponse>)
                  responseObserver);
          break;
        case METHODID_CHECK_AND_MUTATE_ROW:
          serviceImpl.checkAndMutateRow(
              (com.google.bigtable.v2.CheckAndMutateRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.CheckAndMutateRowResponse>)
                  responseObserver);
          break;
        case METHODID_PING_AND_WARM:
          serviceImpl.pingAndWarm(
              (com.google.bigtable.v2.PingAndWarmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.PingAndWarmResponse>)
                  responseObserver);
          break;
        case METHODID_READ_MODIFY_WRITE_ROW:
          serviceImpl.readModifyWriteRow(
              (com.google.bigtable.v2.ReadModifyWriteRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadModifyWriteRowResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_INITIAL_CHANGE_STREAM_PARTITIONS:
          serviceImpl.generateInitialChangeStreamPartitions(
              (com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>)
                  responseObserver);
          break;
        case METHODID_READ_CHANGE_STREAM:
          serviceImpl.readChangeStream(
              (com.google.bigtable.v2.ReadChangeStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.v2.ReadChangeStreamResponse>)
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
            getReadRowsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.bigtable.v2.ReadRowsRequest,
                    com.google.bigtable.v2.ReadRowsResponse>(service, METHODID_READ_ROWS)))
        .addMethod(
            getSampleRowKeysMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.bigtable.v2.SampleRowKeysRequest,
                    com.google.bigtable.v2.SampleRowKeysResponse>(
                    service, METHODID_SAMPLE_ROW_KEYS)))
        .addMethod(
            getMutateRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.bigtable.v2.MutateRowRequest,
                    com.google.bigtable.v2.MutateRowResponse>(service, METHODID_MUTATE_ROW)))
        .addMethod(
            getMutateRowsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.bigtable.v2.MutateRowsRequest,
                    com.google.bigtable.v2.MutateRowsResponse>(service, METHODID_MUTATE_ROWS)))
        .addMethod(
            getCheckAndMutateRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.bigtable.v2.CheckAndMutateRowRequest,
                    com.google.bigtable.v2.CheckAndMutateRowResponse>(
                    service, METHODID_CHECK_AND_MUTATE_ROW)))
        .addMethod(
            getPingAndWarmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.bigtable.v2.PingAndWarmRequest,
                    com.google.bigtable.v2.PingAndWarmResponse>(service, METHODID_PING_AND_WARM)))
        .addMethod(
            getReadModifyWriteRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.bigtable.v2.ReadModifyWriteRowRequest,
                    com.google.bigtable.v2.ReadModifyWriteRowResponse>(
                    service, METHODID_READ_MODIFY_WRITE_ROW)))
        .addMethod(
            getGenerateInitialChangeStreamPartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest,
                    com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse>(
                    service, METHODID_GENERATE_INITIAL_CHANGE_STREAM_PARTITIONS)))
        .addMethod(
            getReadChangeStreamMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.bigtable.v2.ReadChangeStreamRequest,
                    com.google.bigtable.v2.ReadChangeStreamResponse>(
                    service, METHODID_READ_CHANGE_STREAM)))
        .build();
  }

  private abstract static class BigtableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BigtableBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.bigtable.v2.BigtableProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bigtable");
    }
  }

  private static final class BigtableFileDescriptorSupplier extends BigtableBaseDescriptorSupplier {
    BigtableFileDescriptorSupplier() {}
  }

  private static final class BigtableMethodDescriptorSupplier extends BigtableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BigtableMethodDescriptorSupplier(String methodName) {
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
      synchronized (BigtableGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BigtableFileDescriptorSupplier())
                      .addMethod(getReadRowsMethod())
                      .addMethod(getSampleRowKeysMethod())
                      .addMethod(getMutateRowMethod())
                      .addMethod(getMutateRowsMethod())
                      .addMethod(getCheckAndMutateRowMethod())
                      .addMethod(getPingAndWarmMethod())
                      .addMethod(getReadModifyWriteRowMethod())
                      .addMethod(getGenerateInitialChangeStreamPartitionsMethod())
                      .addMethod(getReadChangeStreamMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
