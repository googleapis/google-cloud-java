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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for data connector management.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataConnectorServiceGrpc {

  private DataConnectorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.DataConnectorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest,
          com.google.longrunning.Operation>
      getSetUpDataConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetUpDataConnector",
      requestType = com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest,
          com.google.longrunning.Operation>
      getSetUpDataConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest,
            com.google.longrunning.Operation>
        getSetUpDataConnectorMethod;
    if ((getSetUpDataConnectorMethod = DataConnectorServiceGrpc.getSetUpDataConnectorMethod)
        == null) {
      synchronized (DataConnectorServiceGrpc.class) {
        if ((getSetUpDataConnectorMethod = DataConnectorServiceGrpc.getSetUpDataConnectorMethod)
            == null) {
          DataConnectorServiceGrpc.getSetUpDataConnectorMethod =
              getSetUpDataConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetUpDataConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataConnectorServiceMethodDescriptorSupplier("SetUpDataConnector"))
                      .build();
        }
      }
    }
    return getSetUpDataConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetDataConnectorRequest,
          com.google.cloud.discoveryengine.v1.DataConnector>
      getGetDataConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataConnector",
      requestType = com.google.cloud.discoveryengine.v1.GetDataConnectorRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.DataConnector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetDataConnectorRequest,
          com.google.cloud.discoveryengine.v1.DataConnector>
      getGetDataConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.GetDataConnectorRequest,
            com.google.cloud.discoveryengine.v1.DataConnector>
        getGetDataConnectorMethod;
    if ((getGetDataConnectorMethod = DataConnectorServiceGrpc.getGetDataConnectorMethod) == null) {
      synchronized (DataConnectorServiceGrpc.class) {
        if ((getGetDataConnectorMethod = DataConnectorServiceGrpc.getGetDataConnectorMethod)
            == null) {
          DataConnectorServiceGrpc.getGetDataConnectorMethod =
              getGetDataConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.GetDataConnectorRequest,
                          com.google.cloud.discoveryengine.v1.DataConnector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.GetDataConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.DataConnector
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataConnectorServiceMethodDescriptorSupplier("GetDataConnector"))
                      .build();
        }
      }
    }
    return getGetDataConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest,
          com.google.cloud.discoveryengine.v1.DataConnector>
      getUpdateDataConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataConnector",
      requestType = com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.DataConnector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest,
          com.google.cloud.discoveryengine.v1.DataConnector>
      getUpdateDataConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest,
            com.google.cloud.discoveryengine.v1.DataConnector>
        getUpdateDataConnectorMethod;
    if ((getUpdateDataConnectorMethod = DataConnectorServiceGrpc.getUpdateDataConnectorMethod)
        == null) {
      synchronized (DataConnectorServiceGrpc.class) {
        if ((getUpdateDataConnectorMethod = DataConnectorServiceGrpc.getUpdateDataConnectorMethod)
            == null) {
          DataConnectorServiceGrpc.getUpdateDataConnectorMethod =
              getUpdateDataConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest,
                          com.google.cloud.discoveryengine.v1.DataConnector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.DataConnector
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataConnectorServiceMethodDescriptorSupplier("UpdateDataConnector"))
                      .build();
        }
      }
    }
    return getUpdateDataConnectorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataConnectorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceStub>() {
          @java.lang.Override
          public DataConnectorServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataConnectorServiceStub(channel, callOptions);
          }
        };
    return DataConnectorServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataConnectorServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataConnectorServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataConnectorServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataConnectorServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataConnectorServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceBlockingStub>() {
          @java.lang.Override
          public DataConnectorServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataConnectorServiceBlockingStub(channel, callOptions);
          }
        };
    return DataConnectorServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataConnectorServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataConnectorServiceFutureStub>() {
          @java.lang.Override
          public DataConnectorServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataConnectorServiceFutureStub(channel, callOptions);
          }
        };
    return DataConnectorServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for data connector management.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets
     * up the [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for
     * it. To stop a
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup,
     * use the
     * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
     * method.
     * </pre>
     */
    default void setUpDataConnector(
        com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetUpDataConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a
     * singleton resource for each
     * [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    default void getDataConnector(
        com.google.cloud.discoveryengine.v1.GetDataConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataConnector>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * </pre>
     */
    default void updateDataConnector(
        com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataConnector>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataConnectorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataConnectorService.
   *
   * <pre>
   * Service for data connector management.
   * </pre>
   */
  public abstract static class DataConnectorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataConnectorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataConnectorService.
   *
   * <pre>
   * Service for data connector management.
   * </pre>
   */
  public static final class DataConnectorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataConnectorServiceStub> {
    private DataConnectorServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataConnectorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataConnectorServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets
     * up the [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for
     * it. To stop a
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup,
     * use the
     * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
     * method.
     * </pre>
     */
    public void setUpDataConnector(
        com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetUpDataConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a
     * singleton resource for each
     * [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public void getDataConnector(
        com.google.cloud.discoveryengine.v1.GetDataConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataConnector>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * </pre>
     */
    public void updateDataConnector(
        com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataConnector>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataConnectorService.
   *
   * <pre>
   * Service for data connector management.
   * </pre>
   */
  public static final class DataConnectorServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataConnectorServiceBlockingV2Stub> {
    private DataConnectorServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataConnectorServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataConnectorServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets
     * up the [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for
     * it. To stop a
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup,
     * use the
     * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
     * method.
     * </pre>
     */
    public com.google.longrunning.Operation setUpDataConnector(
        com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetUpDataConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a
     * singleton resource for each
     * [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.DataConnector getDataConnector(
        com.google.cloud.discoveryengine.v1.GetDataConnectorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.DataConnector updateDataConnector(
        com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDataConnectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataConnectorService.
   *
   * <pre>
   * Service for data connector management.
   * </pre>
   */
  public static final class DataConnectorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataConnectorServiceBlockingStub> {
    private DataConnectorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataConnectorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataConnectorServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets
     * up the [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for
     * it. To stop a
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup,
     * use the
     * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
     * method.
     * </pre>
     */
    public com.google.longrunning.Operation setUpDataConnector(
        com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetUpDataConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a
     * singleton resource for each
     * [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.DataConnector getDataConnector(
        com.google.cloud.discoveryengine.v1.GetDataConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.DataConnector updateDataConnector(
        com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataConnectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataConnectorService.
   *
   * <pre>
   * Service for data connector management.
   * </pre>
   */
  public static final class DataConnectorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataConnectorServiceFutureStub> {
    private DataConnectorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataConnectorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataConnectorServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets
     * up the [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for
     * it. To stop a
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup,
     * use the
     * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
     * method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        setUpDataConnector(com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetUpDataConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a
     * singleton resource for each
     * [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.DataConnector>
        getDataConnector(com.google.cloud.discoveryengine.v1.GetDataConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.DataConnector>
        updateDataConnector(
            com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataConnectorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_UP_DATA_CONNECTOR = 0;
  private static final int METHODID_GET_DATA_CONNECTOR = 1;
  private static final int METHODID_UPDATE_DATA_CONNECTOR = 2;

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
        case METHODID_SET_UP_DATA_CONNECTOR:
          serviceImpl.setUpDataConnector(
              (com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATA_CONNECTOR:
          serviceImpl.getDataConnector(
              (com.google.cloud.discoveryengine.v1.GetDataConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataConnector>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_CONNECTOR:
          serviceImpl.updateDataConnector(
              (com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.DataConnector>)
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
            getSetUpDataConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest,
                    com.google.longrunning.Operation>(service, METHODID_SET_UP_DATA_CONNECTOR)))
        .addMethod(
            getGetDataConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.GetDataConnectorRequest,
                    com.google.cloud.discoveryengine.v1.DataConnector>(
                    service, METHODID_GET_DATA_CONNECTOR)))
        .addMethod(
            getUpdateDataConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest,
                    com.google.cloud.discoveryengine.v1.DataConnector>(
                    service, METHODID_UPDATE_DATA_CONNECTOR)))
        .build();
  }

  private abstract static class DataConnectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataConnectorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.DataConnectorServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataConnectorService");
    }
  }

  private static final class DataConnectorServiceFileDescriptorSupplier
      extends DataConnectorServiceBaseDescriptorSupplier {
    DataConnectorServiceFileDescriptorSupplier() {}
  }

  private static final class DataConnectorServiceMethodDescriptorSupplier
      extends DataConnectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataConnectorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataConnectorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataConnectorServiceFileDescriptorSupplier())
                      .addMethod(getSetUpDataConnectorMethod())
                      .addMethod(getGetDataConnectorMethod())
                      .addMethod(getUpdateDataConnectorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
