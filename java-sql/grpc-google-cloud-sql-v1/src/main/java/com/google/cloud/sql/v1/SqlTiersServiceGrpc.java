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
 * Service for providing machine types (tiers) for Cloud SQL instances.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlTiersServiceGrpc {

  private SqlTiersServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlTiersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlTiersListRequest, com.google.cloud.sql.v1.TiersListResponse>
      getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.cloud.sql.v1.SqlTiersListRequest.class,
      responseType = com.google.cloud.sql.v1.TiersListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlTiersListRequest, com.google.cloud.sql.v1.TiersListResponse>
      getListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlTiersListRequest, com.google.cloud.sql.v1.TiersListResponse>
        getListMethod;
    if ((getListMethod = SqlTiersServiceGrpc.getListMethod) == null) {
      synchronized (SqlTiersServiceGrpc.class) {
        if ((getListMethod = SqlTiersServiceGrpc.getListMethod) == null) {
          SqlTiersServiceGrpc.getListMethod =
              getListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlTiersListRequest,
                          com.google.cloud.sql.v1.TiersListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlTiersListRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.TiersListResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlTiersServiceMethodDescriptorSupplier("List"))
                      .build();
        }
      }
    }
    return getListMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlTiersServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceStub>() {
          @java.lang.Override
          public SqlTiersServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlTiersServiceStub(channel, callOptions);
          }
        };
    return SqlTiersServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlTiersServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlTiersServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlTiersServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlTiersServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlTiersServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceBlockingStub>() {
          @java.lang.Override
          public SqlTiersServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlTiersServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlTiersServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlTiersServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlTiersServiceFutureStub>() {
          @java.lang.Override
          public SqlTiersServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlTiersServiceFutureStub(channel, callOptions);
          }
        };
    return SqlTiersServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for providing machine types (tiers) for Cloud SQL instances.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all available machine types (tiers) for Cloud SQL, for example,
     * `db-custom-1-3840`. For more information, see
     * https://cloud.google.com/sql/pricing.
     * </pre>
     */
    default void list(
        com.google.cloud.sql.v1.SqlTiersListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.TiersListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqlTiersService.
   *
   * <pre>
   * Service for providing machine types (tiers) for Cloud SQL instances.
   * </pre>
   */
  public abstract static class SqlTiersServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlTiersServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlTiersService.
   *
   * <pre>
   * Service for providing machine types (tiers) for Cloud SQL instances.
   * </pre>
   */
  public static final class SqlTiersServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlTiersServiceStub> {
    private SqlTiersServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlTiersServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlTiersServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all available machine types (tiers) for Cloud SQL, for example,
     * `db-custom-1-3840`. For more information, see
     * https://cloud.google.com/sql/pricing.
     * </pre>
     */
    public void list(
        com.google.cloud.sql.v1.SqlTiersListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.TiersListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlTiersService.
   *
   * <pre>
   * Service for providing machine types (tiers) for Cloud SQL instances.
   * </pre>
   */
  public static final class SqlTiersServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlTiersServiceBlockingV2Stub> {
    private SqlTiersServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlTiersServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlTiersServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all available machine types (tiers) for Cloud SQL, for example,
     * `db-custom-1-3840`. For more information, see
     * https://cloud.google.com/sql/pricing.
     * </pre>
     */
    public com.google.cloud.sql.v1.TiersListResponse list(
        com.google.cloud.sql.v1.SqlTiersListRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlTiersService.
   *
   * <pre>
   * Service for providing machine types (tiers) for Cloud SQL instances.
   * </pre>
   */
  public static final class SqlTiersServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlTiersServiceBlockingStub> {
    private SqlTiersServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlTiersServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlTiersServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all available machine types (tiers) for Cloud SQL, for example,
     * `db-custom-1-3840`. For more information, see
     * https://cloud.google.com/sql/pricing.
     * </pre>
     */
    public com.google.cloud.sql.v1.TiersListResponse list(
        com.google.cloud.sql.v1.SqlTiersListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlTiersService.
   *
   * <pre>
   * Service for providing machine types (tiers) for Cloud SQL instances.
   * </pre>
   */
  public static final class SqlTiersServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlTiersServiceFutureStub> {
    private SqlTiersServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlTiersServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlTiersServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all available machine types (tiers) for Cloud SQL, for example,
     * `db-custom-1-3840`. For more information, see
     * https://cloud.google.com/sql/pricing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1.TiersListResponse>
        list(com.google.cloud.sql.v1.SqlTiersListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST = 0;

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
        case METHODID_LIST:
          serviceImpl.list(
              (com.google.cloud.sql.v1.SqlTiersListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.TiersListResponse>)
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
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlTiersListRequest,
                    com.google.cloud.sql.v1.TiersListResponse>(service, METHODID_LIST)))
        .build();
  }

  private abstract static class SqlTiersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlTiersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlTiersProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlTiersService");
    }
  }

  private static final class SqlTiersServiceFileDescriptorSupplier
      extends SqlTiersServiceBaseDescriptorSupplier {
    SqlTiersServiceFileDescriptorSupplier() {}
  }

  private static final class SqlTiersServiceMethodDescriptorSupplier
      extends SqlTiersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlTiersServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlTiersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlTiersServiceFileDescriptorSupplier())
                      .addMethod(getListMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
