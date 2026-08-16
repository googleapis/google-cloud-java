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
package com.google.cloud.sql.v1beta4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlSslCertsServiceGrpc {

  private SqlSslCertsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1beta4.SqlSslCertsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDeleteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getDeleteMethod;
    if ((getDeleteMethod = SqlSslCertsServiceGrpc.getDeleteMethod) == null) {
      synchronized (SqlSslCertsServiceGrpc.class) {
        if ((getDeleteMethod = SqlSslCertsServiceGrpc.getDeleteMethod) == null) {
          SqlSslCertsServiceGrpc.getDeleteMethod =
              getDeleteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlSslCertsServiceMethodDescriptorSupplier("Delete"))
                      .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest, com.google.cloud.sql.v1beta4.SslCert>
      getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SslCert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest, com.google.cloud.sql.v1beta4.SslCert>
      getGetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest,
            com.google.cloud.sql.v1beta4.SslCert>
        getGetMethod;
    if ((getGetMethod = SqlSslCertsServiceGrpc.getGetMethod) == null) {
      synchronized (SqlSslCertsServiceGrpc.class) {
        if ((getGetMethod = SqlSslCertsServiceGrpc.getGetMethod) == null) {
          SqlSslCertsServiceGrpc.getGetMethod =
              getGetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest,
                          com.google.cloud.sql.v1beta4.SslCert>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SslCert.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlSslCertsServiceMethodDescriptorSupplier("Get"))
                      .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest,
          com.google.cloud.sql.v1beta4.SslCertsInsertResponse>
      getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SslCertsInsertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest,
          com.google.cloud.sql.v1beta4.SslCertsInsertResponse>
      getInsertMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest,
            com.google.cloud.sql.v1beta4.SslCertsInsertResponse>
        getInsertMethod;
    if ((getInsertMethod = SqlSslCertsServiceGrpc.getInsertMethod) == null) {
      synchronized (SqlSslCertsServiceGrpc.class) {
        if ((getInsertMethod = SqlSslCertsServiceGrpc.getInsertMethod) == null) {
          SqlSslCertsServiceGrpc.getInsertMethod =
              getInsertMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest,
                          com.google.cloud.sql.v1beta4.SslCertsInsertResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Insert"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SslCertsInsertResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SqlSslCertsServiceMethodDescriptorSupplier("Insert"))
                      .build();
        }
      }
    }
    return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsListRequest,
          com.google.cloud.sql.v1beta4.SslCertsListResponse>
      getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.cloud.sql.v1beta4.SqlSslCertsListRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SslCertsListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlSslCertsListRequest,
          com.google.cloud.sql.v1beta4.SslCertsListResponse>
      getListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlSslCertsListRequest,
            com.google.cloud.sql.v1beta4.SslCertsListResponse>
        getListMethod;
    if ((getListMethod = SqlSslCertsServiceGrpc.getListMethod) == null) {
      synchronized (SqlSslCertsServiceGrpc.class) {
        if ((getListMethod = SqlSslCertsServiceGrpc.getListMethod) == null) {
          SqlSslCertsServiceGrpc.getListMethod =
              getListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlSslCertsListRequest,
                          com.google.cloud.sql.v1beta4.SslCertsListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlSslCertsListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SslCertsListResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SqlSslCertsServiceMethodDescriptorSupplier("List"))
                      .build();
        }
      }
    }
    return getListMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlSslCertsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceStub>() {
          @java.lang.Override
          public SqlSslCertsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlSslCertsServiceStub(channel, callOptions);
          }
        };
    return SqlSslCertsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlSslCertsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlSslCertsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlSslCertsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlSslCertsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlSslCertsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceBlockingStub>() {
          @java.lang.Override
          public SqlSslCertsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlSslCertsServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlSslCertsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlSslCertsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlSslCertsServiceFutureStub>() {
          @java.lang.Override
          public SqlSslCertsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlSslCertsServiceFutureStub(channel, callOptions);
          }
        };
    return SqlSslCertsServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Deletes the SSL certificate. For First Generation instances, the
     * certificate remains valid until the instance is restarted.
     * </pre>
     */
    default void delete(
        com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a particular SSL certificate.  Does not include the private key
     * (required for usage).  The private key must be saved from the response to
     * initial creation.
     * </pre>
     */
    default void get(
        com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCert> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an SSL certificate and returns it along with the private key and
     * server certificate authority.  The new certificate will not be usable until
     * the instance is restarted.
     * </pre>
     */
    default void insert(
        com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCertsInsertResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the current SSL certificates for the instance.
     * </pre>
     */
    default void list(
        com.google.cloud.sql.v1beta4.SqlSslCertsListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCertsListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }
  }

  /** Base class for the server implementation of the service SqlSslCertsService. */
  public abstract static class SqlSslCertsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlSslCertsServiceGrpc.bindService(this);
    }
  }

  /** A stub to allow clients to do asynchronous rpc calls to service SqlSslCertsService. */
  public static final class SqlSslCertsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlSslCertsServiceStub> {
    private SqlSslCertsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlSslCertsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlSslCertsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the SSL certificate. For First Generation instances, the
     * certificate remains valid until the instance is restarted.
     * </pre>
     */
    public void delete(
        com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a particular SSL certificate.  Does not include the private key
     * (required for usage).  The private key must be saved from the response to
     * initial creation.
     * </pre>
     */
    public void get(
        com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCert> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an SSL certificate and returns it along with the private key and
     * server certificate authority.  The new certificate will not be usable until
     * the instance is restarted.
     * </pre>
     */
    public void insert(
        com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCertsInsertResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the current SSL certificates for the instance.
     * </pre>
     */
    public void list(
        com.google.cloud.sql.v1beta4.SqlSslCertsListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCertsListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /** A stub to allow clients to do synchronous rpc calls to service SqlSslCertsService. */
  public static final class SqlSslCertsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlSslCertsServiceBlockingV2Stub> {
    private SqlSslCertsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlSslCertsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlSslCertsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the SSL certificate. For First Generation instances, the
     * certificate remains valid until the instance is restarted.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation delete(
        com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a particular SSL certificate.  Does not include the private key
     * (required for usage).  The private key must be saved from the response to
     * initial creation.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCert get(
        com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an SSL certificate and returns it along with the private key and
     * server certificate authority.  The new certificate will not be usable until
     * the instance is restarted.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCertsInsertResponse insert(
        com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the current SSL certificates for the instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCertsListResponse list(
        com.google.cloud.sql.v1beta4.SqlSslCertsListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do limited synchronous rpc calls to service SqlSslCertsService. */
  public static final class SqlSslCertsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlSslCertsServiceBlockingStub> {
    private SqlSslCertsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlSslCertsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlSslCertsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the SSL certificate. For First Generation instances, the
     * certificate remains valid until the instance is restarted.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation delete(
        com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a particular SSL certificate.  Does not include the private key
     * (required for usage).  The private key must be saved from the response to
     * initial creation.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCert get(
        com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an SSL certificate and returns it along with the private key and
     * server certificate authority.  The new certificate will not be usable until
     * the instance is restarted.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCertsInsertResponse insert(
        com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the current SSL certificates for the instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCertsListResponse list(
        com.google.cloud.sql.v1beta4.SqlSslCertsListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlSslCertsService.
   */
  public static final class SqlSslCertsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlSslCertsServiceFutureStub> {
    private SqlSslCertsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlSslCertsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlSslCertsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the SSL certificate. For First Generation instances, the
     * certificate remains valid until the instance is restarted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        delete(com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a particular SSL certificate.  Does not include the private key
     * (required for usage).  The private key must be saved from the response to
     * initial creation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1beta4.SslCert>
        get(com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an SSL certificate and returns it along with the private key and
     * server certificate authority.  The new certificate will not be usable until
     * the instance is restarted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SslCertsInsertResponse>
        insert(com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the current SSL certificates for the instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SslCertsListResponse>
        list(com.google.cloud.sql.v1beta4.SqlSslCertsListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_INSERT = 2;
  private static final int METHODID_LIST = 3;

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
              (com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get(
              (com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCert>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert(
              (com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCertsInsertResponse>)
                  responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list(
              (com.google.cloud.sql.v1beta4.SqlSslCertsListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCertsListResponse>)
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
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_DELETE)))
        .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest,
                    com.google.cloud.sql.v1beta4.SslCert>(service, METHODID_GET)))
        .addMethod(
            getInsertMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest,
                    com.google.cloud.sql.v1beta4.SslCertsInsertResponse>(service, METHODID_INSERT)))
        .addMethod(
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlSslCertsListRequest,
                    com.google.cloud.sql.v1beta4.SslCertsListResponse>(service, METHODID_LIST)))
        .build();
  }

  private abstract static class SqlSslCertsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlSslCertsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1beta4.CloudSqlServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlSslCertsService");
    }
  }

  private static final class SqlSslCertsServiceFileDescriptorSupplier
      extends SqlSslCertsServiceBaseDescriptorSupplier {
    SqlSslCertsServiceFileDescriptorSupplier() {}
  }

  private static final class SqlSslCertsServiceMethodDescriptorSupplier
      extends SqlSslCertsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlSslCertsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlSslCertsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlSslCertsServiceFileDescriptorSupplier())
                      .addMethod(getDeleteMethod())
                      .addMethod(getGetMethod())
                      .addMethod(getInsertMethod())
                      .addMethod(getListMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
