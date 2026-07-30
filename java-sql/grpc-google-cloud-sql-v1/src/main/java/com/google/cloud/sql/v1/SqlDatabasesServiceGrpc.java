/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.sql.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage databases.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlDatabasesServiceGrpc {

  private SqlDatabasesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlDatabasesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesDeleteRequest, com.google.cloud.sql.v1.Operation>
      getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.google.cloud.sql.v1.SqlDatabasesDeleteRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesDeleteRequest, com.google.cloud.sql.v1.Operation>
      getDeleteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlDatabasesDeleteRequest, com.google.cloud.sql.v1.Operation>
        getDeleteMethod;
    if ((getDeleteMethod = SqlDatabasesServiceGrpc.getDeleteMethod) == null) {
      synchronized (SqlDatabasesServiceGrpc.class) {
        if ((getDeleteMethod = SqlDatabasesServiceGrpc.getDeleteMethod) == null) {
          SqlDatabasesServiceGrpc.getDeleteMethod =
              getDeleteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlDatabasesDeleteRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlDatabasesDeleteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlDatabasesServiceMethodDescriptorSupplier("Delete"))
                      .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesGetRequest, com.google.cloud.sql.v1.Database>
      getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.google.cloud.sql.v1.SqlDatabasesGetRequest.class,
      responseType = com.google.cloud.sql.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesGetRequest, com.google.cloud.sql.v1.Database>
      getGetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlDatabasesGetRequest, com.google.cloud.sql.v1.Database>
        getGetMethod;
    if ((getGetMethod = SqlDatabasesServiceGrpc.getGetMethod) == null) {
      synchronized (SqlDatabasesServiceGrpc.class) {
        if ((getGetMethod = SqlDatabasesServiceGrpc.getGetMethod) == null) {
          SqlDatabasesServiceGrpc.getGetMethod =
              getGetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlDatabasesGetRequest,
                          com.google.cloud.sql.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlDatabasesGetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlDatabasesServiceMethodDescriptorSupplier("Get"))
                      .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesInsertRequest, com.google.cloud.sql.v1.Operation>
      getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.google.cloud.sql.v1.SqlDatabasesInsertRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesInsertRequest, com.google.cloud.sql.v1.Operation>
      getInsertMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlDatabasesInsertRequest, com.google.cloud.sql.v1.Operation>
        getInsertMethod;
    if ((getInsertMethod = SqlDatabasesServiceGrpc.getInsertMethod) == null) {
      synchronized (SqlDatabasesServiceGrpc.class) {
        if ((getInsertMethod = SqlDatabasesServiceGrpc.getInsertMethod) == null) {
          SqlDatabasesServiceGrpc.getInsertMethod =
              getInsertMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlDatabasesInsertRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Insert"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlDatabasesInsertRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlDatabasesServiceMethodDescriptorSupplier("Insert"))
                      .build();
        }
      }
    }
    return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesListRequest,
          com.google.cloud.sql.v1.DatabasesListResponse>
      getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.cloud.sql.v1.SqlDatabasesListRequest.class,
      responseType = com.google.cloud.sql.v1.DatabasesListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesListRequest,
          com.google.cloud.sql.v1.DatabasesListResponse>
      getListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlDatabasesListRequest,
            com.google.cloud.sql.v1.DatabasesListResponse>
        getListMethod;
    if ((getListMethod = SqlDatabasesServiceGrpc.getListMethod) == null) {
      synchronized (SqlDatabasesServiceGrpc.class) {
        if ((getListMethod = SqlDatabasesServiceGrpc.getListMethod) == null) {
          SqlDatabasesServiceGrpc.getListMethod =
              getListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlDatabasesListRequest,
                          com.google.cloud.sql.v1.DatabasesListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlDatabasesListRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.DatabasesListResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlDatabasesServiceMethodDescriptorSupplier("List"))
                      .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesUpdateRequest, com.google.cloud.sql.v1.Operation>
      getPatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Patch",
      requestType = com.google.cloud.sql.v1.SqlDatabasesUpdateRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesUpdateRequest, com.google.cloud.sql.v1.Operation>
      getPatchMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlDatabasesUpdateRequest, com.google.cloud.sql.v1.Operation>
        getPatchMethod;
    if ((getPatchMethod = SqlDatabasesServiceGrpc.getPatchMethod) == null) {
      synchronized (SqlDatabasesServiceGrpc.class) {
        if ((getPatchMethod = SqlDatabasesServiceGrpc.getPatchMethod) == null) {
          SqlDatabasesServiceGrpc.getPatchMethod =
              getPatchMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlDatabasesUpdateRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Patch"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlDatabasesUpdateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlDatabasesServiceMethodDescriptorSupplier("Patch"))
                      .build();
        }
      }
    }
    return getPatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesUpdateRequest, com.google.cloud.sql.v1.Operation>
      getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.google.cloud.sql.v1.SqlDatabasesUpdateRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlDatabasesUpdateRequest, com.google.cloud.sql.v1.Operation>
      getUpdateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlDatabasesUpdateRequest, com.google.cloud.sql.v1.Operation>
        getUpdateMethod;
    if ((getUpdateMethod = SqlDatabasesServiceGrpc.getUpdateMethod) == null) {
      synchronized (SqlDatabasesServiceGrpc.class) {
        if ((getUpdateMethod = SqlDatabasesServiceGrpc.getUpdateMethod) == null) {
          SqlDatabasesServiceGrpc.getUpdateMethod =
              getUpdateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlDatabasesUpdateRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlDatabasesUpdateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlDatabasesServiceMethodDescriptorSupplier("Update"))
                      .build();
        }
      }
    }
    return getUpdateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlDatabasesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceStub>() {
          @java.lang.Override
          public SqlDatabasesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDatabasesServiceStub(channel, callOptions);
          }
        };
    return SqlDatabasesServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlDatabasesServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlDatabasesServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDatabasesServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlDatabasesServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlDatabasesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceBlockingStub>() {
          @java.lang.Override
          public SqlDatabasesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDatabasesServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlDatabasesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlDatabasesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDatabasesServiceFutureStub>() {
          @java.lang.Override
          public SqlDatabasesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDatabasesServiceFutureStub(channel, callOptions);
          }
        };
    return SqlDatabasesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage databases.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Deletes a database from a Cloud SQL instance.
     * </pre>
     */
    default void delete(
        com.google.cloud.sql.v1.SqlDatabasesDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    default void get(
        com.google.cloud.sql.v1.SqlDatabasesGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a resource containing information about a database inside a Cloud
     * SQL instance.
     * **Note:** You can't modify the default character set and collation.
     * </pre>
     */
    default void insert(
        com.google.cloud.sql.v1.SqlDatabasesInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists databases in the specified Cloud SQL instance.
     * </pre>
     */
    default void list(
        com.google.cloud.sql.v1.SqlDatabasesListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.DatabasesListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a resource containing information about a database inside
     * a Cloud SQL instance. This method supports patch semantics.
     * </pre>
     */
    default void patch(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPatchMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    default void update(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqlDatabasesService.
   *
   * <pre>
   * Service to manage databases.
   * </pre>
   */
  public abstract static class SqlDatabasesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlDatabasesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlDatabasesService.
   *
   * <pre>
   * Service to manage databases.
   * </pre>
   */
  public static final class SqlDatabasesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlDatabasesServiceStub> {
    private SqlDatabasesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDatabasesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDatabasesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database from a Cloud SQL instance.
     * </pre>
     */
    public void delete(
        com.google.cloud.sql.v1.SqlDatabasesDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public void get(
        com.google.cloud.sql.v1.SqlDatabasesGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a resource containing information about a database inside a Cloud
     * SQL instance.
     * **Note:** You can't modify the default character set and collation.
     * </pre>
     */
    public void insert(
        com.google.cloud.sql.v1.SqlDatabasesInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists databases in the specified Cloud SQL instance.
     * </pre>
     */
    public void list(
        com.google.cloud.sql.v1.SqlDatabasesListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.DatabasesListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a resource containing information about a database inside
     * a Cloud SQL instance. This method supports patch semantics.
     * </pre>
     */
    public void patch(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public void update(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlDatabasesService.
   *
   * <pre>
   * Service to manage databases.
   * </pre>
   */
  public static final class SqlDatabasesServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlDatabasesServiceBlockingV2Stub> {
    private SqlDatabasesServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDatabasesServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDatabasesServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database from a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation delete(
        com.google.cloud.sql.v1.SqlDatabasesDeleteRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Database get(
        com.google.cloud.sql.v1.SqlDatabasesGetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a resource containing information about a database inside a Cloud
     * SQL instance.
     * **Note:** You can't modify the default character set and collation.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation insert(
        com.google.cloud.sql.v1.SqlDatabasesInsertRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists databases in the specified Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.DatabasesListResponse list(
        com.google.cloud.sql.v1.SqlDatabasesListRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a resource containing information about a database inside
     * a Cloud SQL instance. This method supports patch semantics.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation patch(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPatchMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation update(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlDatabasesService.
   *
   * <pre>
   * Service to manage databases.
   * </pre>
   */
  public static final class SqlDatabasesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlDatabasesServiceBlockingStub> {
    private SqlDatabasesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDatabasesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDatabasesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database from a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation delete(
        com.google.cloud.sql.v1.SqlDatabasesDeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Database get(
        com.google.cloud.sql.v1.SqlDatabasesGetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a resource containing information about a database inside a Cloud
     * SQL instance.
     * **Note:** You can't modify the default character set and collation.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation insert(
        com.google.cloud.sql.v1.SqlDatabasesInsertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists databases in the specified Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.DatabasesListResponse list(
        com.google.cloud.sql.v1.SqlDatabasesListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a resource containing information about a database inside
     * a Cloud SQL instance. This method supports patch semantics.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation patch(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatchMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation update(
        com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlDatabasesService.
   *
   * <pre>
   * Service to manage databases.
   * </pre>
   */
  public static final class SqlDatabasesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlDatabasesServiceFutureStub> {
    private SqlDatabasesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDatabasesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDatabasesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database from a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        delete(com.google.cloud.sql.v1.SqlDatabasesDeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Database> get(
        com.google.cloud.sql.v1.SqlDatabasesGetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a resource containing information about a database inside a Cloud
     * SQL instance.
     * **Note:** You can't modify the default character set and collation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        insert(com.google.cloud.sql.v1.SqlDatabasesInsertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists databases in the specified Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1.DatabasesListResponse>
        list(com.google.cloud.sql.v1.SqlDatabasesListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a resource containing information about a database inside
     * a Cloud SQL instance. This method supports patch semantics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        patch(com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPatchMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a resource containing information about a database inside a Cloud
     * SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        update(com.google.cloud.sql.v1.SqlDatabasesUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_INSERT = 2;
  private static final int METHODID_LIST = 3;
  private static final int METHODID_PATCH = 4;
  private static final int METHODID_UPDATE = 5;

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
        case METHODID_DELETE:
          serviceImpl.delete(
              (com.google.cloud.sql.v1.SqlDatabasesDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get(
              (com.google.cloud.sql.v1.SqlDatabasesGetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Database>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert(
              (com.google.cloud.sql.v1.SqlDatabasesInsertRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list(
              (com.google.cloud.sql.v1.SqlDatabasesListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.DatabasesListResponse>)
                  responseObserver);
          break;
        case METHODID_PATCH:
          serviceImpl.patch(
              (com.google.cloud.sql.v1.SqlDatabasesUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update(
              (com.google.cloud.sql.v1.SqlDatabasesUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
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
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlDatabasesDeleteRequest,
                    com.google.cloud.sql.v1.Operation>(service, METHODID_DELETE)))
        .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlDatabasesGetRequest,
                    com.google.cloud.sql.v1.Database>(service, METHODID_GET)))
        .addMethod(
            getInsertMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlDatabasesInsertRequest,
                    com.google.cloud.sql.v1.Operation>(service, METHODID_INSERT)))
        .addMethod(
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlDatabasesListRequest,
                    com.google.cloud.sql.v1.DatabasesListResponse>(service, METHODID_LIST)))
        .addMethod(
            getPatchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlDatabasesUpdateRequest,
                    com.google.cloud.sql.v1.Operation>(service, METHODID_PATCH)))
        .addMethod(
            getUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlDatabasesUpdateRequest,
                    com.google.cloud.sql.v1.Operation>(service, METHODID_UPDATE)))
        .build();
  }

  private abstract static class SqlDatabasesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlDatabasesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlDatabasesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlDatabasesService");
    }
  }

  private static final class SqlDatabasesServiceFileDescriptorSupplier
      extends SqlDatabasesServiceBaseDescriptorSupplier {
    SqlDatabasesServiceFileDescriptorSupplier() {}
  }

  private static final class SqlDatabasesServiceMethodDescriptorSupplier
      extends SqlDatabasesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlDatabasesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlDatabasesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlDatabasesServiceFileDescriptorSupplier())
                      .addMethod(getDeleteMethod())
                      .addMethod(getGetMethod())
                      .addMethod(getInsertMethod())
                      .addMethod(getListMethod())
                      .addMethod(getPatchMethod())
                      .addMethod(getUpdateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
