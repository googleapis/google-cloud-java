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
package google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * EntityService contains apis for finding entities.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/chronicle/v1/entity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EntityServiceGrpc {

  private EntityServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.chronicle.v1.EntityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
      getGetWatchlistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWatchlist",
      requestType = google.cloud.chronicle.v1.GetWatchlistRequest.class,
      responseType = google.cloud.chronicle.v1.Watchlist.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
      getGetWatchlistMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.GetWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
        getGetWatchlistMethod;
    if ((getGetWatchlistMethod = EntityServiceGrpc.getGetWatchlistMethod) == null) {
      synchronized (EntityServiceGrpc.class) {
        if ((getGetWatchlistMethod = EntityServiceGrpc.getGetWatchlistMethod) == null) {
          EntityServiceGrpc.getGetWatchlistMethod =
              getGetWatchlistMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.GetWatchlistRequest,
                          google.cloud.chronicle.v1.Watchlist>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWatchlist"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.GetWatchlistRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Watchlist.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityServiceMethodDescriptorSupplier("GetWatchlist"))
                      .build();
        }
      }
    }
    return getGetWatchlistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListWatchlistsRequest,
          google.cloud.chronicle.v1.ListWatchlistsResponse>
      getListWatchlistsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWatchlists",
      requestType = google.cloud.chronicle.v1.ListWatchlistsRequest.class,
      responseType = google.cloud.chronicle.v1.ListWatchlistsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListWatchlistsRequest,
          google.cloud.chronicle.v1.ListWatchlistsResponse>
      getListWatchlistsMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.ListWatchlistsRequest,
            google.cloud.chronicle.v1.ListWatchlistsResponse>
        getListWatchlistsMethod;
    if ((getListWatchlistsMethod = EntityServiceGrpc.getListWatchlistsMethod) == null) {
      synchronized (EntityServiceGrpc.class) {
        if ((getListWatchlistsMethod = EntityServiceGrpc.getListWatchlistsMethod) == null) {
          EntityServiceGrpc.getListWatchlistsMethod =
              getListWatchlistsMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.ListWatchlistsRequest,
                          google.cloud.chronicle.v1.ListWatchlistsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWatchlists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListWatchlistsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListWatchlistsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityServiceMethodDescriptorSupplier("ListWatchlists"))
                      .build();
        }
      }
    }
    return getListWatchlistsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
      getCreateWatchlistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWatchlist",
      requestType = google.cloud.chronicle.v1.CreateWatchlistRequest.class,
      responseType = google.cloud.chronicle.v1.Watchlist.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
      getCreateWatchlistMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.CreateWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
        getCreateWatchlistMethod;
    if ((getCreateWatchlistMethod = EntityServiceGrpc.getCreateWatchlistMethod) == null) {
      synchronized (EntityServiceGrpc.class) {
        if ((getCreateWatchlistMethod = EntityServiceGrpc.getCreateWatchlistMethod) == null) {
          EntityServiceGrpc.getCreateWatchlistMethod =
              getCreateWatchlistMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.CreateWatchlistRequest,
                          google.cloud.chronicle.v1.Watchlist>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWatchlist"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.CreateWatchlistRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Watchlist.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityServiceMethodDescriptorSupplier("CreateWatchlist"))
                      .build();
        }
      }
    }
    return getCreateWatchlistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
      getUpdateWatchlistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWatchlist",
      requestType = google.cloud.chronicle.v1.UpdateWatchlistRequest.class,
      responseType = google.cloud.chronicle.v1.Watchlist.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
      getUpdateWatchlistMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.UpdateWatchlistRequest, google.cloud.chronicle.v1.Watchlist>
        getUpdateWatchlistMethod;
    if ((getUpdateWatchlistMethod = EntityServiceGrpc.getUpdateWatchlistMethod) == null) {
      synchronized (EntityServiceGrpc.class) {
        if ((getUpdateWatchlistMethod = EntityServiceGrpc.getUpdateWatchlistMethod) == null) {
          EntityServiceGrpc.getUpdateWatchlistMethod =
              getUpdateWatchlistMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.UpdateWatchlistRequest,
                          google.cloud.chronicle.v1.Watchlist>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWatchlist"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.UpdateWatchlistRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Watchlist.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityServiceMethodDescriptorSupplier("UpdateWatchlist"))
                      .build();
        }
      }
    }
    return getUpdateWatchlistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteWatchlistRequest, com.google.protobuf.Empty>
      getDeleteWatchlistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWatchlist",
      requestType = google.cloud.chronicle.v1.DeleteWatchlistRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteWatchlistRequest, com.google.protobuf.Empty>
      getDeleteWatchlistMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.DeleteWatchlistRequest, com.google.protobuf.Empty>
        getDeleteWatchlistMethod;
    if ((getDeleteWatchlistMethod = EntityServiceGrpc.getDeleteWatchlistMethod) == null) {
      synchronized (EntityServiceGrpc.class) {
        if ((getDeleteWatchlistMethod = EntityServiceGrpc.getDeleteWatchlistMethod) == null) {
          EntityServiceGrpc.getDeleteWatchlistMethod =
              getDeleteWatchlistMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.DeleteWatchlistRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWatchlist"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DeleteWatchlistRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EntityServiceMethodDescriptorSupplier("DeleteWatchlist"))
                      .build();
        }
      }
    }
    return getDeleteWatchlistMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EntityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EntityServiceStub>() {
          @java.lang.Override
          public EntityServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EntityServiceStub(channel, callOptions);
          }
        };
    return EntityServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static EntityServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EntityServiceBlockingV2Stub>() {
          @java.lang.Override
          public EntityServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EntityServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return EntityServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntityServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EntityServiceBlockingStub>() {
          @java.lang.Override
          public EntityServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EntityServiceBlockingStub(channel, callOptions);
          }
        };
    return EntityServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EntityServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EntityServiceFutureStub>() {
          @java.lang.Override
          public EntityServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EntityServiceFutureStub(channel, callOptions);
          }
        };
    return EntityServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * EntityService contains apis for finding entities.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets watchlist details for the given watchlist ID.
     * </pre>
     */
    default void getWatchlist(
        google.cloud.chronicle.v1.GetWatchlistRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWatchlistMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all watchlists for the given instance.
     * </pre>
     */
    default void listWatchlists(
        google.cloud.chronicle.v1.ListWatchlistsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListWatchlistsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWatchlistsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a watchlist for the given instance.
     * Note that there can be at most 200 watchlists per instance.
     * </pre>
     */
    default void createWatchlist(
        google.cloud.chronicle.v1.CreateWatchlistRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWatchlistMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the watchlist for the given instance.
     * </pre>
     */
    default void updateWatchlist(
        google.cloud.chronicle.v1.UpdateWatchlistRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWatchlistMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the watchlist for the given instance.
     * </pre>
     */
    default void deleteWatchlist(
        google.cloud.chronicle.v1.DeleteWatchlistRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWatchlistMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EntityService.
   *
   * <pre>
   * EntityService contains apis for finding entities.
   * </pre>
   */
  public abstract static class EntityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EntityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EntityService.
   *
   * <pre>
   * EntityService contains apis for finding entities.
   * </pre>
   */
  public static final class EntityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EntityServiceStub> {
    private EntityServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets watchlist details for the given watchlist ID.
     * </pre>
     */
    public void getWatchlist(
        google.cloud.chronicle.v1.GetWatchlistRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWatchlistMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all watchlists for the given instance.
     * </pre>
     */
    public void listWatchlists(
        google.cloud.chronicle.v1.ListWatchlistsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListWatchlistsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWatchlistsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a watchlist for the given instance.
     * Note that there can be at most 200 watchlists per instance.
     * </pre>
     */
    public void createWatchlist(
        google.cloud.chronicle.v1.CreateWatchlistRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWatchlistMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the watchlist for the given instance.
     * </pre>
     */
    public void updateWatchlist(
        google.cloud.chronicle.v1.UpdateWatchlistRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWatchlistMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the watchlist for the given instance.
     * </pre>
     */
    public void deleteWatchlist(
        google.cloud.chronicle.v1.DeleteWatchlistRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWatchlistMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EntityService.
   *
   * <pre>
   * EntityService contains apis for finding entities.
   * </pre>
   */
  public static final class EntityServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<EntityServiceBlockingV2Stub> {
    private EntityServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets watchlist details for the given watchlist ID.
     * </pre>
     */
    public google.cloud.chronicle.v1.Watchlist getWatchlist(
        google.cloud.chronicle.v1.GetWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWatchlistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all watchlists for the given instance.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListWatchlistsResponse listWatchlists(
        google.cloud.chronicle.v1.ListWatchlistsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWatchlistsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a watchlist for the given instance.
     * Note that there can be at most 200 watchlists per instance.
     * </pre>
     */
    public google.cloud.chronicle.v1.Watchlist createWatchlist(
        google.cloud.chronicle.v1.CreateWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWatchlistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the watchlist for the given instance.
     * </pre>
     */
    public google.cloud.chronicle.v1.Watchlist updateWatchlist(
        google.cloud.chronicle.v1.UpdateWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWatchlistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the watchlist for the given instance.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWatchlist(
        google.cloud.chronicle.v1.DeleteWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWatchlistMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service EntityService.
   *
   * <pre>
   * EntityService contains apis for finding entities.
   * </pre>
   */
  public static final class EntityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EntityServiceBlockingStub> {
    private EntityServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets watchlist details for the given watchlist ID.
     * </pre>
     */
    public google.cloud.chronicle.v1.Watchlist getWatchlist(
        google.cloud.chronicle.v1.GetWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWatchlistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all watchlists for the given instance.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListWatchlistsResponse listWatchlists(
        google.cloud.chronicle.v1.ListWatchlistsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWatchlistsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a watchlist for the given instance.
     * Note that there can be at most 200 watchlists per instance.
     * </pre>
     */
    public google.cloud.chronicle.v1.Watchlist createWatchlist(
        google.cloud.chronicle.v1.CreateWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWatchlistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the watchlist for the given instance.
     * </pre>
     */
    public google.cloud.chronicle.v1.Watchlist updateWatchlist(
        google.cloud.chronicle.v1.UpdateWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWatchlistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the watchlist for the given instance.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWatchlist(
        google.cloud.chronicle.v1.DeleteWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWatchlistMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EntityService.
   *
   * <pre>
   * EntityService contains apis for finding entities.
   * </pre>
   */
  public static final class EntityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EntityServiceFutureStub> {
    private EntityServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets watchlist details for the given watchlist ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Watchlist>
        getWatchlist(google.cloud.chronicle.v1.GetWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWatchlistMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all watchlists for the given instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.ListWatchlistsResponse>
        listWatchlists(google.cloud.chronicle.v1.ListWatchlistsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWatchlistsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a watchlist for the given instance.
     * Note that there can be at most 200 watchlists per instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Watchlist>
        createWatchlist(google.cloud.chronicle.v1.CreateWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWatchlistMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the watchlist for the given instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Watchlist>
        updateWatchlist(google.cloud.chronicle.v1.UpdateWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWatchlistMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the watchlist for the given instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteWatchlist(google.cloud.chronicle.v1.DeleteWatchlistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWatchlistMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_WATCHLIST = 0;
  private static final int METHODID_LIST_WATCHLISTS = 1;
  private static final int METHODID_CREATE_WATCHLIST = 2;
  private static final int METHODID_UPDATE_WATCHLIST = 3;
  private static final int METHODID_DELETE_WATCHLIST = 4;

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
        case METHODID_GET_WATCHLIST:
          serviceImpl.getWatchlist(
              (google.cloud.chronicle.v1.GetWatchlistRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist>) responseObserver);
          break;
        case METHODID_LIST_WATCHLISTS:
          serviceImpl.listWatchlists(
              (google.cloud.chronicle.v1.ListWatchlistsRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListWatchlistsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_WATCHLIST:
          serviceImpl.createWatchlist(
              (google.cloud.chronicle.v1.CreateWatchlistRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist>) responseObserver);
          break;
        case METHODID_UPDATE_WATCHLIST:
          serviceImpl.updateWatchlist(
              (google.cloud.chronicle.v1.UpdateWatchlistRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Watchlist>) responseObserver);
          break;
        case METHODID_DELETE_WATCHLIST:
          serviceImpl.deleteWatchlist(
              (google.cloud.chronicle.v1.DeleteWatchlistRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getGetWatchlistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.GetWatchlistRequest,
                    google.cloud.chronicle.v1.Watchlist>(service, METHODID_GET_WATCHLIST)))
        .addMethod(
            getListWatchlistsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.ListWatchlistsRequest,
                    google.cloud.chronicle.v1.ListWatchlistsResponse>(
                    service, METHODID_LIST_WATCHLISTS)))
        .addMethod(
            getCreateWatchlistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.CreateWatchlistRequest,
                    google.cloud.chronicle.v1.Watchlist>(service, METHODID_CREATE_WATCHLIST)))
        .addMethod(
            getUpdateWatchlistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.UpdateWatchlistRequest,
                    google.cloud.chronicle.v1.Watchlist>(service, METHODID_UPDATE_WATCHLIST)))
        .addMethod(
            getDeleteWatchlistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.DeleteWatchlistRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_WATCHLIST)))
        .build();
  }

  private abstract static class EntityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EntityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return google.cloud.chronicle.v1.EntityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EntityService");
    }
  }

  private static final class EntityServiceFileDescriptorSupplier
      extends EntityServiceBaseDescriptorSupplier {
    EntityServiceFileDescriptorSupplier() {}
  }

  private static final class EntityServiceMethodDescriptorSupplier
      extends EntityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EntityServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EntityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EntityServiceFileDescriptorSupplier())
                      .addMethod(getGetWatchlistMethod())
                      .addMethod(getListWatchlistsMethod())
                      .addMethod(getCreateWatchlistMethod())
                      .addMethod(getUpdateWatchlistMethod())
                      .addMethod(getDeleteWatchlistMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
