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
package com.google.cloud.databasecenter.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * DatabaseCenter contains methods to query fleet view for database resources.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DatabaseCenterGrpc {

  private DatabaseCenterGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.databasecenter.v1beta.DatabaseCenter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.databasecenter.v1beta.QueryProductsRequest,
          com.google.cloud.databasecenter.v1beta.QueryProductsResponse>
      getQueryProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryProducts",
      requestType = com.google.cloud.databasecenter.v1beta.QueryProductsRequest.class,
      responseType = com.google.cloud.databasecenter.v1beta.QueryProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.databasecenter.v1beta.QueryProductsRequest,
          com.google.cloud.databasecenter.v1beta.QueryProductsResponse>
      getQueryProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.databasecenter.v1beta.QueryProductsRequest,
            com.google.cloud.databasecenter.v1beta.QueryProductsResponse>
        getQueryProductsMethod;
    if ((getQueryProductsMethod = DatabaseCenterGrpc.getQueryProductsMethod) == null) {
      synchronized (DatabaseCenterGrpc.class) {
        if ((getQueryProductsMethod = DatabaseCenterGrpc.getQueryProductsMethod) == null) {
          DatabaseCenterGrpc.getQueryProductsMethod =
              getQueryProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.databasecenter.v1beta.QueryProductsRequest,
                          com.google.cloud.databasecenter.v1beta.QueryProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.databasecenter.v1beta.QueryProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.databasecenter.v1beta.QueryProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseCenterMethodDescriptorSupplier("QueryProducts"))
                      .build();
        }
      }
    }
    return getQueryProductsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DatabaseCenterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterStub>() {
          @java.lang.Override
          public DatabaseCenterStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseCenterStub(channel, callOptions);
          }
        };
    return DatabaseCenterStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DatabaseCenterBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterBlockingV2Stub>() {
          @java.lang.Override
          public DatabaseCenterBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseCenterBlockingV2Stub(channel, callOptions);
          }
        };
    return DatabaseCenterBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatabaseCenterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterBlockingStub>() {
          @java.lang.Override
          public DatabaseCenterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseCenterBlockingStub(channel, callOptions);
          }
        };
    return DatabaseCenterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DatabaseCenterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseCenterFutureStub>() {
          @java.lang.Override
          public DatabaseCenterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseCenterFutureStub(channel, callOptions);
          }
        };
    return DatabaseCenterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * DatabaseCenter contains methods to query fleet view for database resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * QueryProducts provides a list of all possible products which can be used to
     * filter database resources.
     * </pre>
     */
    default void queryProducts(
        com.google.cloud.databasecenter.v1beta.QueryProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.databasecenter.v1beta.QueryProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryProductsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DatabaseCenter.
   *
   * <pre>
   * DatabaseCenter contains methods to query fleet view for database resources.
   * </pre>
   */
  public abstract static class DatabaseCenterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DatabaseCenterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DatabaseCenter.
   *
   * <pre>
   * DatabaseCenter contains methods to query fleet view for database resources.
   * </pre>
   */
  public static final class DatabaseCenterStub
      extends io.grpc.stub.AbstractAsyncStub<DatabaseCenterStub> {
    private DatabaseCenterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseCenterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseCenterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * QueryProducts provides a list of all possible products which can be used to
     * filter database resources.
     * </pre>
     */
    public void queryProducts(
        com.google.cloud.databasecenter.v1beta.QueryProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.databasecenter.v1beta.QueryProductsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DatabaseCenter.
   *
   * <pre>
   * DatabaseCenter contains methods to query fleet view for database resources.
   * </pre>
   */
  public static final class DatabaseCenterBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DatabaseCenterBlockingV2Stub> {
    private DatabaseCenterBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseCenterBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseCenterBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * QueryProducts provides a list of all possible products which can be used to
     * filter database resources.
     * </pre>
     */
    public com.google.cloud.databasecenter.v1beta.QueryProductsResponse queryProducts(
        com.google.cloud.databasecenter.v1beta.QueryProductsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DatabaseCenter.
   *
   * <pre>
   * DatabaseCenter contains methods to query fleet view for database resources.
   * </pre>
   */
  public static final class DatabaseCenterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DatabaseCenterBlockingStub> {
    private DatabaseCenterBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseCenterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseCenterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * QueryProducts provides a list of all possible products which can be used to
     * filter database resources.
     * </pre>
     */
    public com.google.cloud.databasecenter.v1beta.QueryProductsResponse queryProducts(
        com.google.cloud.databasecenter.v1beta.QueryProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DatabaseCenter.
   *
   * <pre>
   * DatabaseCenter contains methods to query fleet view for database resources.
   * </pre>
   */
  public static final class DatabaseCenterFutureStub
      extends io.grpc.stub.AbstractFutureStub<DatabaseCenterFutureStub> {
    private DatabaseCenterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseCenterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseCenterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * QueryProducts provides a list of all possible products which can be used to
     * filter database resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.databasecenter.v1beta.QueryProductsResponse>
        queryProducts(com.google.cloud.databasecenter.v1beta.QueryProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_PRODUCTS = 0;

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
        case METHODID_QUERY_PRODUCTS:
          serviceImpl.queryProducts(
              (com.google.cloud.databasecenter.v1beta.QueryProductsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.databasecenter.v1beta.QueryProductsResponse>)
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
            getQueryProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.databasecenter.v1beta.QueryProductsRequest,
                    com.google.cloud.databasecenter.v1beta.QueryProductsResponse>(
                    service, METHODID_QUERY_PRODUCTS)))
        .build();
  }

  private abstract static class DatabaseCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatabaseCenterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.databasecenter.v1beta.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DatabaseCenter");
    }
  }

  private static final class DatabaseCenterFileDescriptorSupplier
      extends DatabaseCenterBaseDescriptorSupplier {
    DatabaseCenterFileDescriptorSupplier() {}
  }

  private static final class DatabaseCenterMethodDescriptorSupplier
      extends DatabaseCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DatabaseCenterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DatabaseCenterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DatabaseCenterFileDescriptorSupplier())
                      .addMethod(getQueryProductsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
