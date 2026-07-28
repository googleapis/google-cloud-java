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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service providing functionality for managing dashboards' queries.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DashboardQueryServiceGrpc {

  private DashboardQueryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.DashboardQueryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDashboardQueryRequest,
          com.google.cloud.chronicle.v1.DashboardQuery>
      getGetDashboardQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDashboardQuery",
      requestType = com.google.cloud.chronicle.v1.GetDashboardQueryRequest.class,
      responseType = com.google.cloud.chronicle.v1.DashboardQuery.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDashboardQueryRequest,
          com.google.cloud.chronicle.v1.DashboardQuery>
      getGetDashboardQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetDashboardQueryRequest,
            com.google.cloud.chronicle.v1.DashboardQuery>
        getGetDashboardQueryMethod;
    if ((getGetDashboardQueryMethod = DashboardQueryServiceGrpc.getGetDashboardQueryMethod)
        == null) {
      synchronized (DashboardQueryServiceGrpc.class) {
        if ((getGetDashboardQueryMethod = DashboardQueryServiceGrpc.getGetDashboardQueryMethod)
            == null) {
          DashboardQueryServiceGrpc.getGetDashboardQueryMethod =
              getGetDashboardQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetDashboardQueryRequest,
                          com.google.cloud.chronicle.v1.DashboardQuery>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDashboardQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetDashboardQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DashboardQuery.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardQueryServiceMethodDescriptorSupplier("GetDashboardQuery"))
                      .build();
        }
      }
    }
    return getGetDashboardQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest,
          com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>
      getExecuteDashboardQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteDashboardQuery",
      requestType = com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest.class,
      responseType = com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest,
          com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>
      getExecuteDashboardQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest,
            com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>
        getExecuteDashboardQueryMethod;
    if ((getExecuteDashboardQueryMethod = DashboardQueryServiceGrpc.getExecuteDashboardQueryMethod)
        == null) {
      synchronized (DashboardQueryServiceGrpc.class) {
        if ((getExecuteDashboardQueryMethod =
                DashboardQueryServiceGrpc.getExecuteDashboardQueryMethod)
            == null) {
          DashboardQueryServiceGrpc.getExecuteDashboardQueryMethod =
              getExecuteDashboardQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest,
                          com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExecuteDashboardQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardQueryServiceMethodDescriptorSupplier(
                              "ExecuteDashboardQuery"))
                      .build();
        }
      }
    }
    return getExecuteDashboardQueryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DashboardQueryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceStub>() {
          @java.lang.Override
          public DashboardQueryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardQueryServiceStub(channel, callOptions);
          }
        };
    return DashboardQueryServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DashboardQueryServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceBlockingV2Stub>() {
          @java.lang.Override
          public DashboardQueryServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardQueryServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DashboardQueryServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DashboardQueryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceBlockingStub>() {
          @java.lang.Override
          public DashboardQueryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardQueryServiceBlockingStub(channel, callOptions);
          }
        };
    return DashboardQueryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DashboardQueryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardQueryServiceFutureStub>() {
          @java.lang.Override
          public DashboardQueryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardQueryServiceFutureStub(channel, callOptions);
          }
        };
    return DashboardQueryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service providing functionality for managing dashboards' queries.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get a dashboard query.
     * </pre>
     */
    default void getDashboardQuery(
        com.google.cloud.chronicle.v1.GetDashboardQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DashboardQuery>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDashboardQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Execute a query and return the data.
     * </pre>
     */
    default void executeDashboardQuery(
        com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExecuteDashboardQueryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DashboardQueryService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' queries.
   * </pre>
   */
  public abstract static class DashboardQueryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DashboardQueryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DashboardQueryService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' queries.
   * </pre>
   */
  public static final class DashboardQueryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DashboardQueryServiceStub> {
    private DashboardQueryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardQueryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardQueryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard query.
     * </pre>
     */
    public void getDashboardQuery(
        com.google.cloud.chronicle.v1.GetDashboardQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DashboardQuery>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDashboardQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Execute a query and return the data.
     * </pre>
     */
    public void executeDashboardQuery(
        com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteDashboardQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DashboardQueryService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' queries.
   * </pre>
   */
  public static final class DashboardQueryServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DashboardQueryServiceBlockingV2Stub> {
    private DashboardQueryServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardQueryServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardQueryServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard query.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DashboardQuery getDashboardQuery(
        com.google.cloud.chronicle.v1.GetDashboardQueryRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDashboardQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Execute a query and return the data.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse executeDashboardQuery(
        com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExecuteDashboardQueryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DashboardQueryService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' queries.
   * </pre>
   */
  public static final class DashboardQueryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DashboardQueryServiceBlockingStub> {
    private DashboardQueryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardQueryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardQueryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard query.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DashboardQuery getDashboardQuery(
        com.google.cloud.chronicle.v1.GetDashboardQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDashboardQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Execute a query and return the data.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse executeDashboardQuery(
        com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteDashboardQueryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * DashboardQueryService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' queries.
   * </pre>
   */
  public static final class DashboardQueryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DashboardQueryServiceFutureStub> {
    private DashboardQueryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardQueryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardQueryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DashboardQuery>
        getDashboardQuery(com.google.cloud.chronicle.v1.GetDashboardQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDashboardQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Execute a query and return the data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>
        executeDashboardQuery(com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteDashboardQueryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DASHBOARD_QUERY = 0;
  private static final int METHODID_EXECUTE_DASHBOARD_QUERY = 1;

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
        case METHODID_GET_DASHBOARD_QUERY:
          serviceImpl.getDashboardQuery(
              (com.google.cloud.chronicle.v1.GetDashboardQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DashboardQuery>)
                  responseObserver);
          break;
        case METHODID_EXECUTE_DASHBOARD_QUERY:
          serviceImpl.executeDashboardQuery(
              (com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>)
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
            getGetDashboardQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetDashboardQueryRequest,
                    com.google.cloud.chronicle.v1.DashboardQuery>(
                    service, METHODID_GET_DASHBOARD_QUERY)))
        .addMethod(
            getExecuteDashboardQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest,
                    com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse>(
                    service, METHODID_EXECUTE_DASHBOARD_QUERY)))
        .build();
  }

  private abstract static class DashboardQueryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DashboardQueryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.DashboardQueryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DashboardQueryService");
    }
  }

  private static final class DashboardQueryServiceFileDescriptorSupplier
      extends DashboardQueryServiceBaseDescriptorSupplier {
    DashboardQueryServiceFileDescriptorSupplier() {}
  }

  private static final class DashboardQueryServiceMethodDescriptorSupplier
      extends DashboardQueryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DashboardQueryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DashboardQueryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DashboardQueryServiceFileDescriptorSupplier())
                      .addMethod(getGetDashboardQueryMethod())
                      .addMethod(getExecuteDashboardQueryMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
