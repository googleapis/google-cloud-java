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
package com.google.datastore.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Each RPC normalizes the partition IDs of the keys in its input entities,
 * and always returns entities with keys with normalized partition IDs.
 * This applies to all keys and entities, including those in values, except keys
 * with both an empty path and an empty or unset partition ID. Normalization of
 * input keys sets the project ID (if not already set) to the project ID from
 * the request.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/datastore/v1/datastore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DatastoreGrpc {

  private DatastoreGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.datastore.v1.Datastore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>
      getLookupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Lookup",
      requestType = com.google.datastore.v1.LookupRequest.class,
      responseType = com.google.datastore.v1.LookupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>
      getLookupMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>
        getLookupMethod;
    if ((getLookupMethod = DatastoreGrpc.getLookupMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getLookupMethod = DatastoreGrpc.getLookupMethod) == null) {
          DatastoreGrpc.getLookupMethod =
              getLookupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.LookupRequest,
                          com.google.datastore.v1.LookupResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Lookup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.LookupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.LookupResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DatastoreMethodDescriptorSupplier("Lookup"))
                      .build();
        }
      }
    }
    return getLookupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunQueryRequest, com.google.datastore.v1.RunQueryResponse>
      getRunQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunQuery",
      requestType = com.google.datastore.v1.RunQueryRequest.class,
      responseType = com.google.datastore.v1.RunQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunQueryRequest, com.google.datastore.v1.RunQueryResponse>
      getRunQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.RunQueryRequest, com.google.datastore.v1.RunQueryResponse>
        getRunQueryMethod;
    if ((getRunQueryMethod = DatastoreGrpc.getRunQueryMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getRunQueryMethod = DatastoreGrpc.getRunQueryMethod) == null) {
          DatastoreGrpc.getRunQueryMethod =
              getRunQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.RunQueryRequest,
                          com.google.datastore.v1.RunQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.RunQueryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.RunQueryResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DatastoreMethodDescriptorSupplier("RunQuery"))
                      .build();
        }
      }
    }
    return getRunQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunAggregationQueryRequest,
          com.google.datastore.v1.RunAggregationQueryResponse>
      getRunAggregationQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunAggregationQuery",
      requestType = com.google.datastore.v1.RunAggregationQueryRequest.class,
      responseType = com.google.datastore.v1.RunAggregationQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunAggregationQueryRequest,
          com.google.datastore.v1.RunAggregationQueryResponse>
      getRunAggregationQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.RunAggregationQueryRequest,
            com.google.datastore.v1.RunAggregationQueryResponse>
        getRunAggregationQueryMethod;
    if ((getRunAggregationQueryMethod = DatastoreGrpc.getRunAggregationQueryMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getRunAggregationQueryMethod = DatastoreGrpc.getRunAggregationQueryMethod) == null) {
          DatastoreGrpc.getRunAggregationQueryMethod =
              getRunAggregationQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.RunAggregationQueryRequest,
                          com.google.datastore.v1.RunAggregationQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RunAggregationQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.RunAggregationQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.RunAggregationQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatastoreMethodDescriptorSupplier("RunAggregationQuery"))
                      .build();
        }
      }
    }
    return getRunAggregationQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.BeginTransactionRequest,
          com.google.datastore.v1.BeginTransactionResponse>
      getBeginTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BeginTransaction",
      requestType = com.google.datastore.v1.BeginTransactionRequest.class,
      responseType = com.google.datastore.v1.BeginTransactionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.BeginTransactionRequest,
          com.google.datastore.v1.BeginTransactionResponse>
      getBeginTransactionMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.BeginTransactionRequest,
            com.google.datastore.v1.BeginTransactionResponse>
        getBeginTransactionMethod;
    if ((getBeginTransactionMethod = DatastoreGrpc.getBeginTransactionMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getBeginTransactionMethod = DatastoreGrpc.getBeginTransactionMethod) == null) {
          DatastoreGrpc.getBeginTransactionMethod =
              getBeginTransactionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.BeginTransactionRequest,
                          com.google.datastore.v1.BeginTransactionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BeginTransaction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.BeginTransactionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.BeginTransactionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatastoreMethodDescriptorSupplier("BeginTransaction"))
                      .build();
        }
      }
    }
    return getBeginTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>
      getCommitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Commit",
      requestType = com.google.datastore.v1.CommitRequest.class,
      responseType = com.google.datastore.v1.CommitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>
      getCommitMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>
        getCommitMethod;
    if ((getCommitMethod = DatastoreGrpc.getCommitMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getCommitMethod = DatastoreGrpc.getCommitMethod) == null) {
          DatastoreGrpc.getCommitMethod =
              getCommitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.CommitRequest,
                          com.google.datastore.v1.CommitResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Commit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.CommitRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.CommitResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DatastoreMethodDescriptorSupplier("Commit"))
                      .build();
        }
      }
    }
    return getCommitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.RollbackRequest, com.google.datastore.v1.RollbackResponse>
      getRollbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rollback",
      requestType = com.google.datastore.v1.RollbackRequest.class,
      responseType = com.google.datastore.v1.RollbackResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.RollbackRequest, com.google.datastore.v1.RollbackResponse>
      getRollbackMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.RollbackRequest, com.google.datastore.v1.RollbackResponse>
        getRollbackMethod;
    if ((getRollbackMethod = DatastoreGrpc.getRollbackMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getRollbackMethod = DatastoreGrpc.getRollbackMethod) == null) {
          DatastoreGrpc.getRollbackMethod =
              getRollbackMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.RollbackRequest,
                          com.google.datastore.v1.RollbackResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Rollback"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.RollbackRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.RollbackResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DatastoreMethodDescriptorSupplier("Rollback"))
                      .build();
        }
      }
    }
    return getRollbackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.AllocateIdsRequest, com.google.datastore.v1.AllocateIdsResponse>
      getAllocateIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AllocateIds",
      requestType = com.google.datastore.v1.AllocateIdsRequest.class,
      responseType = com.google.datastore.v1.AllocateIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.AllocateIdsRequest, com.google.datastore.v1.AllocateIdsResponse>
      getAllocateIdsMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.AllocateIdsRequest, com.google.datastore.v1.AllocateIdsResponse>
        getAllocateIdsMethod;
    if ((getAllocateIdsMethod = DatastoreGrpc.getAllocateIdsMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getAllocateIdsMethod = DatastoreGrpc.getAllocateIdsMethod) == null) {
          DatastoreGrpc.getAllocateIdsMethod =
              getAllocateIdsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.AllocateIdsRequest,
                          com.google.datastore.v1.AllocateIdsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AllocateIds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.AllocateIdsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.AllocateIdsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DatastoreMethodDescriptorSupplier("AllocateIds"))
                      .build();
        }
      }
    }
    return getAllocateIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.ReserveIdsRequest, com.google.datastore.v1.ReserveIdsResponse>
      getReserveIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveIds",
      requestType = com.google.datastore.v1.ReserveIdsRequest.class,
      responseType = com.google.datastore.v1.ReserveIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.ReserveIdsRequest, com.google.datastore.v1.ReserveIdsResponse>
      getReserveIdsMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.v1.ReserveIdsRequest, com.google.datastore.v1.ReserveIdsResponse>
        getReserveIdsMethod;
    if ((getReserveIdsMethod = DatastoreGrpc.getReserveIdsMethod) == null) {
      synchronized (DatastoreGrpc.class) {
        if ((getReserveIdsMethod = DatastoreGrpc.getReserveIdsMethod) == null) {
          DatastoreGrpc.getReserveIdsMethod =
              getReserveIdsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.v1.ReserveIdsRequest,
                          com.google.datastore.v1.ReserveIdsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReserveIds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.ReserveIdsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.v1.ReserveIdsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DatastoreMethodDescriptorSupplier("ReserveIds"))
                      .build();
        }
      }
    }
    return getReserveIdsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DatastoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastoreStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatastoreStub>() {
          @java.lang.Override
          public DatastoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatastoreStub(channel, callOptions);
          }
        };
    return DatastoreStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DatastoreBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastoreBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatastoreBlockingV2Stub>() {
          @java.lang.Override
          public DatastoreBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatastoreBlockingV2Stub(channel, callOptions);
          }
        };
    return DatastoreBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatastoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastoreBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatastoreBlockingStub>() {
          @java.lang.Override
          public DatastoreBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatastoreBlockingStub(channel, callOptions);
          }
        };
    return DatastoreBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DatastoreFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastoreFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatastoreFutureStub>() {
          @java.lang.Override
          public DatastoreFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatastoreFutureStub(channel, callOptions);
          }
        };
    return DatastoreFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Each RPC normalizes the partition IDs of the keys in its input entities,
   * and always returns entities with keys with normalized partition IDs.
   * This applies to all keys and entities, including those in values, except keys
   * with both an empty path and an empty or unset partition ID. Normalization of
   * input keys sets the project ID (if not already set) to the project ID from
   * the request.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Looks up entities by key.
     * </pre>
     */
    default void lookup(
        com.google.datastore.v1.LookupRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.LookupResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries for entities.
     * </pre>
     */
    default void runQuery(
        com.google.datastore.v1.RunQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.RunQueryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * </pre>
     */
    default void runAggregationQuery(
        com.google.datastore.v1.RunAggregationQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.RunAggregationQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunAggregationQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction.
     * </pre>
     */
    default void beginTransaction(
        com.google.datastore.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.BeginTransactionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBeginTransactionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, optionally creating, deleting or modifying some
     * entities.
     * </pre>
     */
    default void commit(
        com.google.datastore.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.CommitResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCommitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    default void rollback(
        com.google.datastore.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.RollbackResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRollbackMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allocates IDs for the given keys, which is useful for referencing an entity
     * before it is inserted.
     * </pre>
     */
    default void allocateIds(
        com.google.datastore.v1.AllocateIdsRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.AllocateIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAllocateIdsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Prevents the supplied keys' IDs from being auto-allocated by Cloud
     * Datastore.
     * </pre>
     */
    default void reserveIds(
        com.google.datastore.v1.ReserveIdsRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.ReserveIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReserveIdsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Datastore.
   *
   * <pre>
   * Each RPC normalizes the partition IDs of the keys in its input entities,
   * and always returns entities with keys with normalized partition IDs.
   * This applies to all keys and entities, including those in values, except keys
   * with both an empty path and an empty or unset partition ID. Normalization of
   * input keys sets the project ID (if not already set) to the project ID from
   * the request.
   * </pre>
   */
  public abstract static class DatastoreImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DatastoreGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Datastore.
   *
   * <pre>
   * Each RPC normalizes the partition IDs of the keys in its input entities,
   * and always returns entities with keys with normalized partition IDs.
   * This applies to all keys and entities, including those in values, except keys
   * with both an empty path and an empty or unset partition ID. Normalization of
   * input keys sets the project ID (if not already set) to the project ID from
   * the request.
   * </pre>
   */
  public static final class DatastoreStub extends io.grpc.stub.AbstractAsyncStub<DatastoreStub> {
    private DatastoreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastoreStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastoreStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Looks up entities by key.
     * </pre>
     */
    public void lookup(
        com.google.datastore.v1.LookupRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.LookupResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Queries for entities.
     * </pre>
     */
    public void runQuery(
        com.google.datastore.v1.RunQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.RunQueryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunQueryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * </pre>
     */
    public void runAggregationQuery(
        com.google.datastore.v1.RunAggregationQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.RunAggregationQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunAggregationQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction.
     * </pre>
     */
    public void beginTransaction(
        com.google.datastore.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.BeginTransactionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBeginTransactionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, optionally creating, deleting or modifying some
     * entities.
     * </pre>
     */
    public void commit(
        com.google.datastore.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.CommitResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public void rollback(
        com.google.datastore.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.RollbackResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allocates IDs for the given keys, which is useful for referencing an entity
     * before it is inserted.
     * </pre>
     */
    public void allocateIds(
        com.google.datastore.v1.AllocateIdsRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.AllocateIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAllocateIdsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Prevents the supplied keys' IDs from being auto-allocated by Cloud
     * Datastore.
     * </pre>
     */
    public void reserveIds(
        com.google.datastore.v1.ReserveIdsRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.v1.ReserveIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReserveIdsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Datastore.
   *
   * <pre>
   * Each RPC normalizes the partition IDs of the keys in its input entities,
   * and always returns entities with keys with normalized partition IDs.
   * This applies to all keys and entities, including those in values, except keys
   * with both an empty path and an empty or unset partition ID. Normalization of
   * input keys sets the project ID (if not already set) to the project ID from
   * the request.
   * </pre>
   */
  public static final class DatastoreBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DatastoreBlockingV2Stub> {
    private DatastoreBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastoreBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastoreBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Looks up entities by key.
     * </pre>
     */
    public com.google.datastore.v1.LookupResponse lookup(
        com.google.datastore.v1.LookupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries for entities.
     * </pre>
     */
    public com.google.datastore.v1.RunQueryResponse runQuery(
        com.google.datastore.v1.RunQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * </pre>
     */
    public com.google.datastore.v1.RunAggregationQueryResponse runAggregationQuery(
        com.google.datastore.v1.RunAggregationQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunAggregationQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction.
     * </pre>
     */
    public com.google.datastore.v1.BeginTransactionResponse beginTransaction(
        com.google.datastore.v1.BeginTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBeginTransactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, optionally creating, deleting or modifying some
     * entities.
     * </pre>
     */
    public com.google.datastore.v1.CommitResponse commit(
        com.google.datastore.v1.CommitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public com.google.datastore.v1.RollbackResponse rollback(
        com.google.datastore.v1.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Allocates IDs for the given keys, which is useful for referencing an entity
     * before it is inserted.
     * </pre>
     */
    public com.google.datastore.v1.AllocateIdsResponse allocateIds(
        com.google.datastore.v1.AllocateIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAllocateIdsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Prevents the supplied keys' IDs from being auto-allocated by Cloud
     * Datastore.
     * </pre>
     */
    public com.google.datastore.v1.ReserveIdsResponse reserveIds(
        com.google.datastore.v1.ReserveIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReserveIdsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Datastore.
   *
   * <pre>
   * Each RPC normalizes the partition IDs of the keys in its input entities,
   * and always returns entities with keys with normalized partition IDs.
   * This applies to all keys and entities, including those in values, except keys
   * with both an empty path and an empty or unset partition ID. Normalization of
   * input keys sets the project ID (if not already set) to the project ID from
   * the request.
   * </pre>
   */
  public static final class DatastoreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DatastoreBlockingStub> {
    private DatastoreBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastoreBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Looks up entities by key.
     * </pre>
     */
    public com.google.datastore.v1.LookupResponse lookup(
        com.google.datastore.v1.LookupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Queries for entities.
     * </pre>
     */
    public com.google.datastore.v1.RunQueryResponse runQuery(
        com.google.datastore.v1.RunQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * </pre>
     */
    public com.google.datastore.v1.RunAggregationQueryResponse runAggregationQuery(
        com.google.datastore.v1.RunAggregationQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunAggregationQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction.
     * </pre>
     */
    public com.google.datastore.v1.BeginTransactionResponse beginTransaction(
        com.google.datastore.v1.BeginTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBeginTransactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, optionally creating, deleting or modifying some
     * entities.
     * </pre>
     */
    public com.google.datastore.v1.CommitResponse commit(
        com.google.datastore.v1.CommitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public com.google.datastore.v1.RollbackResponse rollback(
        com.google.datastore.v1.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Allocates IDs for the given keys, which is useful for referencing an entity
     * before it is inserted.
     * </pre>
     */
    public com.google.datastore.v1.AllocateIdsResponse allocateIds(
        com.google.datastore.v1.AllocateIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAllocateIdsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Prevents the supplied keys' IDs from being auto-allocated by Cloud
     * Datastore.
     * </pre>
     */
    public com.google.datastore.v1.ReserveIdsResponse reserveIds(
        com.google.datastore.v1.ReserveIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReserveIdsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Datastore.
   *
   * <pre>
   * Each RPC normalizes the partition IDs of the keys in its input entities,
   * and always returns entities with keys with normalized partition IDs.
   * This applies to all keys and entities, including those in values, except keys
   * with both an empty path and an empty or unset partition ID. Normalization of
   * input keys sets the project ID (if not already set) to the project ID from
   * the request.
   * </pre>
   */
  public static final class DatastoreFutureStub
      extends io.grpc.stub.AbstractFutureStub<DatastoreFutureStub> {
    private DatastoreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastoreFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastoreFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Looks up entities by key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.LookupResponse>
        lookup(com.google.datastore.v1.LookupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Queries for entities.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.RunQueryResponse>
        runQuery(com.google.datastore.v1.RunQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.RunAggregationQueryResponse>
        runAggregationQuery(com.google.datastore.v1.RunAggregationQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunAggregationQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Begins a new transaction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.BeginTransactionResponse>
        beginTransaction(com.google.datastore.v1.BeginTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBeginTransactionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, optionally creating, deleting or modifying some
     * entities.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.CommitResponse>
        commit(com.google.datastore.v1.CommitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.RollbackResponse>
        rollback(com.google.datastore.v1.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Allocates IDs for the given keys, which is useful for referencing an entity
     * before it is inserted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.AllocateIdsResponse>
        allocateIds(com.google.datastore.v1.AllocateIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAllocateIdsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Prevents the supplied keys' IDs from being auto-allocated by Cloud
     * Datastore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.v1.ReserveIdsResponse>
        reserveIds(com.google.datastore.v1.ReserveIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReserveIdsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOOKUP = 0;
  private static final int METHODID_RUN_QUERY = 1;
  private static final int METHODID_RUN_AGGREGATION_QUERY = 2;
  private static final int METHODID_BEGIN_TRANSACTION = 3;
  private static final int METHODID_COMMIT = 4;
  private static final int METHODID_ROLLBACK = 5;
  private static final int METHODID_ALLOCATE_IDS = 6;
  private static final int METHODID_RESERVE_IDS = 7;

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
        case METHODID_LOOKUP:
          serviceImpl.lookup(
              (com.google.datastore.v1.LookupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.LookupResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_QUERY:
          serviceImpl.runQuery(
              (com.google.datastore.v1.RunQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.RunQueryResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_AGGREGATION_QUERY:
          serviceImpl.runAggregationQuery(
              (com.google.datastore.v1.RunAggregationQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.RunAggregationQueryResponse>)
                  responseObserver);
          break;
        case METHODID_BEGIN_TRANSACTION:
          serviceImpl.beginTransaction(
              (com.google.datastore.v1.BeginTransactionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.BeginTransactionResponse>)
                  responseObserver);
          break;
        case METHODID_COMMIT:
          serviceImpl.commit(
              (com.google.datastore.v1.CommitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.CommitResponse>)
                  responseObserver);
          break;
        case METHODID_ROLLBACK:
          serviceImpl.rollback(
              (com.google.datastore.v1.RollbackRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.RollbackResponse>)
                  responseObserver);
          break;
        case METHODID_ALLOCATE_IDS:
          serviceImpl.allocateIds(
              (com.google.datastore.v1.AllocateIdsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.AllocateIdsResponse>)
                  responseObserver);
          break;
        case METHODID_RESERVE_IDS:
          serviceImpl.reserveIds(
              (com.google.datastore.v1.ReserveIdsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.v1.ReserveIdsResponse>)
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
            getLookupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>(
                    service, METHODID_LOOKUP)))
        .addMethod(
            getRunQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.RunQueryRequest,
                    com.google.datastore.v1.RunQueryResponse>(service, METHODID_RUN_QUERY)))
        .addMethod(
            getRunAggregationQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.RunAggregationQueryRequest,
                    com.google.datastore.v1.RunAggregationQueryResponse>(
                    service, METHODID_RUN_AGGREGATION_QUERY)))
        .addMethod(
            getBeginTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.BeginTransactionRequest,
                    com.google.datastore.v1.BeginTransactionResponse>(
                    service, METHODID_BEGIN_TRANSACTION)))
        .addMethod(
            getCommitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>(
                    service, METHODID_COMMIT)))
        .addMethod(
            getRollbackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.RollbackRequest,
                    com.google.datastore.v1.RollbackResponse>(service, METHODID_ROLLBACK)))
        .addMethod(
            getAllocateIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.AllocateIdsRequest,
                    com.google.datastore.v1.AllocateIdsResponse>(service, METHODID_ALLOCATE_IDS)))
        .addMethod(
            getReserveIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.v1.ReserveIdsRequest,
                    com.google.datastore.v1.ReserveIdsResponse>(service, METHODID_RESERVE_IDS)))
        .build();
  }

  private abstract static class DatastoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatastoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.datastore.v1.DatastoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Datastore");
    }
  }

  private static final class DatastoreFileDescriptorSupplier
      extends DatastoreBaseDescriptorSupplier {
    DatastoreFileDescriptorSupplier() {}
  }

  private static final class DatastoreMethodDescriptorSupplier
      extends DatastoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DatastoreMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DatastoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DatastoreFileDescriptorSupplier())
                      .addMethod(getLookupMethod())
                      .addMethod(getRunQueryMethod())
                      .addMethod(getRunAggregationQueryMethod())
                      .addMethod(getBeginTransactionMethod())
                      .addMethod(getCommitMethod())
                      .addMethod(getRollbackMethod())
                      .addMethod(getAllocateIdsMethod())
                      .addMethod(getReserveIdsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
