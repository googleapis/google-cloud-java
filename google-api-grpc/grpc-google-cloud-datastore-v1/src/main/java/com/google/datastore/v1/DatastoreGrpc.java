package com.google.datastore.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/datastore/v1/datastore.proto")
public final class DatastoreGrpc {

  private DatastoreGrpc() {}

  public static final String SERVICE_NAME = "google.datastore.v1.Datastore";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLookupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>
      METHOD_LOOKUP = getLookupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>
      getLookupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>
      getLookupMethod() {
    return getLookupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.datastore.v1.LookupRequest, com.google.datastore.v1.LookupResponse>
      getLookupMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.datastore.v1.Datastore", "Lookup"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRunQueryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunQueryRequest, com.google.datastore.v1.RunQueryResponse>
      METHOD_RUN_QUERY = getRunQueryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunQueryRequest, com.google.datastore.v1.RunQueryResponse>
      getRunQueryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunQueryRequest, com.google.datastore.v1.RunQueryResponse>
      getRunQueryMethod() {
    return getRunQueryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.datastore.v1.RunQueryRequest, com.google.datastore.v1.RunQueryResponse>
      getRunQueryMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.datastore.v1.Datastore", "RunQuery"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBeginTransactionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.datastore.v1.BeginTransactionRequest,
          com.google.datastore.v1.BeginTransactionResponse>
      METHOD_BEGIN_TRANSACTION = getBeginTransactionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.BeginTransactionRequest,
          com.google.datastore.v1.BeginTransactionResponse>
      getBeginTransactionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.BeginTransactionRequest,
          com.google.datastore.v1.BeginTransactionResponse>
      getBeginTransactionMethod() {
    return getBeginTransactionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.datastore.v1.BeginTransactionRequest,
          com.google.datastore.v1.BeginTransactionResponse>
      getBeginTransactionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.datastore.v1.Datastore", "BeginTransaction"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCommitMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>
      METHOD_COMMIT = getCommitMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>
      getCommitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>
      getCommitMethod() {
    return getCommitMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.datastore.v1.CommitRequest, com.google.datastore.v1.CommitResponse>
      getCommitMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.datastore.v1.Datastore", "Commit"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRollbackMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.datastore.v1.RollbackRequest, com.google.datastore.v1.RollbackResponse>
      METHOD_ROLLBACK = getRollbackMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.RollbackRequest, com.google.datastore.v1.RollbackResponse>
      getRollbackMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.RollbackRequest, com.google.datastore.v1.RollbackResponse>
      getRollbackMethod() {
    return getRollbackMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.datastore.v1.RollbackRequest, com.google.datastore.v1.RollbackResponse>
      getRollbackMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.datastore.v1.Datastore", "Rollback"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAllocateIdsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.datastore.v1.AllocateIdsRequest, com.google.datastore.v1.AllocateIdsResponse>
      METHOD_ALLOCATE_IDS = getAllocateIdsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.AllocateIdsRequest, com.google.datastore.v1.AllocateIdsResponse>
      getAllocateIdsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.AllocateIdsRequest, com.google.datastore.v1.AllocateIdsResponse>
      getAllocateIdsMethod() {
    return getAllocateIdsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.datastore.v1.AllocateIdsRequest, com.google.datastore.v1.AllocateIdsResponse>
      getAllocateIdsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.datastore.v1.Datastore", "AllocateIds"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReserveIdsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.datastore.v1.ReserveIdsRequest, com.google.datastore.v1.ReserveIdsResponse>
      METHOD_RESERVE_IDS = getReserveIdsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.v1.ReserveIdsRequest, com.google.datastore.v1.ReserveIdsResponse>
      getReserveIdsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.datastore.v1.ReserveIdsRequest, com.google.datastore.v1.ReserveIdsResponse>
      getReserveIdsMethod() {
    return getReserveIdsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.datastore.v1.ReserveIdsRequest, com.google.datastore.v1.ReserveIdsResponse>
      getReserveIdsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.datastore.v1.Datastore", "ReserveIds"))
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
    return new DatastoreStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatastoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new DatastoreBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DatastoreFutureStub newFutureStub(io.grpc.Channel channel) {
    return new DatastoreFutureStub(channel);
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
  public abstract static class DatastoreImplBase implements io.grpc.BindableService {

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
      asyncUnimplementedUnaryCall(getLookupMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getRunQueryMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getBeginTransactionMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCommitMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getRollbackMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getAllocateIdsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getReserveIdsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getLookupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.datastore.v1.LookupRequest,
                      com.google.datastore.v1.LookupResponse>(this, METHODID_LOOKUP)))
          .addMethod(
              getRunQueryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.datastore.v1.RunQueryRequest,
                      com.google.datastore.v1.RunQueryResponse>(this, METHODID_RUN_QUERY)))
          .addMethod(
              getBeginTransactionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.datastore.v1.BeginTransactionRequest,
                      com.google.datastore.v1.BeginTransactionResponse>(
                      this, METHODID_BEGIN_TRANSACTION)))
          .addMethod(
              getCommitMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.datastore.v1.CommitRequest,
                      com.google.datastore.v1.CommitResponse>(this, METHODID_COMMIT)))
          .addMethod(
              getRollbackMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.datastore.v1.RollbackRequest,
                      com.google.datastore.v1.RollbackResponse>(this, METHODID_ROLLBACK)))
          .addMethod(
              getAllocateIdsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.datastore.v1.AllocateIdsRequest,
                      com.google.datastore.v1.AllocateIdsResponse>(this, METHODID_ALLOCATE_IDS)))
          .addMethod(
              getReserveIdsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.datastore.v1.ReserveIdsRequest,
                      com.google.datastore.v1.ReserveIdsResponse>(this, METHODID_RESERVE_IDS)))
          .build();
    }
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
  public static final class DatastoreStub extends io.grpc.stub.AbstractStub<DatastoreStub> {
    private DatastoreStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      asyncUnaryCall(
          getChannel().newCall(getLookupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getRunQueryMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getBeginTransactionMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getCommitMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getRollbackMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getAllocateIdsMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getReserveIdsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
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
  public static final class DatastoreBlockingStub
      extends io.grpc.stub.AbstractStub<DatastoreBlockingStub> {
    private DatastoreBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return blockingUnaryCall(getChannel(), getLookupMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getRunQueryMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getBeginTransactionMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getCommitMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getRollbackMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getAllocateIdsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getReserveIdsMethodHelper(), getCallOptions(), request);
    }
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
  public static final class DatastoreFutureStub
      extends io.grpc.stub.AbstractStub<DatastoreFutureStub> {
    private DatastoreFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return futureUnaryCall(
          getChannel().newCall(getLookupMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getRunQueryMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getBeginTransactionMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getCommitMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getRollbackMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getAllocateIdsMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getReserveIdsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOOKUP = 0;
  private static final int METHODID_RUN_QUERY = 1;
  private static final int METHODID_BEGIN_TRANSACTION = 2;
  private static final int METHODID_COMMIT = 3;
  private static final int METHODID_ROLLBACK = 4;
  private static final int METHODID_ALLOCATE_IDS = 5;
  private static final int METHODID_RESERVE_IDS = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DatastoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DatastoreImplBase serviceImpl, int methodId) {
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
    private final String methodName;

    DatastoreMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getLookupMethodHelper())
                      .addMethod(getRunQueryMethodHelper())
                      .addMethod(getBeginTransactionMethodHelper())
                      .addMethod(getCommitMethodHelper())
                      .addMethod(getRollbackMethodHelper())
                      .addMethod(getAllocateIdsMethodHelper())
                      .addMethod(getReserveIdsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
