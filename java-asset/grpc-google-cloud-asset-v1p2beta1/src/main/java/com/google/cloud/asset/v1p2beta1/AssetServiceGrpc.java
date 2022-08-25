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
package com.google.cloud.asset.v1p2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Asset service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/asset/v1p2beta1/asset_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AssetServiceGrpc {

  private AssetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.asset.v1p2beta1.AssetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.CreateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getCreateFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeed",
      requestType = com.google.cloud.asset.v1p2beta1.CreateFeedRequest.class,
      responseType = com.google.cloud.asset.v1p2beta1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.CreateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getCreateFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p2beta1.CreateFeedRequest,
            com.google.cloud.asset.v1p2beta1.Feed>
        getCreateFeedMethod;
    if ((getCreateFeedMethod = AssetServiceGrpc.getCreateFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getCreateFeedMethod = AssetServiceGrpc.getCreateFeedMethod) == null) {
          AssetServiceGrpc.getCreateFeedMethod =
              getCreateFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p2beta1.CreateFeedRequest,
                          com.google.cloud.asset.v1p2beta1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.CreateFeedRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("CreateFeed"))
                      .build();
        }
      }
    }
    return getCreateFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.GetFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getGetFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeed",
      requestType = com.google.cloud.asset.v1p2beta1.GetFeedRequest.class,
      responseType = com.google.cloud.asset.v1p2beta1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.GetFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getGetFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p2beta1.GetFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
        getGetFeedMethod;
    if ((getGetFeedMethod = AssetServiceGrpc.getGetFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getGetFeedMethod = AssetServiceGrpc.getGetFeedMethod) == null) {
          AssetServiceGrpc.getGetFeedMethod =
              getGetFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p2beta1.GetFeedRequest,
                          com.google.cloud.asset.v1p2beta1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.GetFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("GetFeed"))
                      .build();
        }
      }
    }
    return getGetFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
          com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
      getListFeedsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeeds",
      requestType = com.google.cloud.asset.v1p2beta1.ListFeedsRequest.class,
      responseType = com.google.cloud.asset.v1p2beta1.ListFeedsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
          com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
      getListFeedsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
            com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
        getListFeedsMethod;
    if ((getListFeedsMethod = AssetServiceGrpc.getListFeedsMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getListFeedsMethod = AssetServiceGrpc.getListFeedsMethod) == null) {
          AssetServiceGrpc.getListFeedsMethod =
              getListFeedsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
                          com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeeds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.ListFeedsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.ListFeedsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("ListFeeds"))
                      .build();
        }
      }
    }
    return getListFeedsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.UpdateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getUpdateFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeed",
      requestType = com.google.cloud.asset.v1p2beta1.UpdateFeedRequest.class,
      responseType = com.google.cloud.asset.v1p2beta1.Feed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.UpdateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getUpdateFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p2beta1.UpdateFeedRequest,
            com.google.cloud.asset.v1p2beta1.Feed>
        getUpdateFeedMethod;
    if ((getUpdateFeedMethod = AssetServiceGrpc.getUpdateFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getUpdateFeedMethod = AssetServiceGrpc.getUpdateFeedMethod) == null) {
          AssetServiceGrpc.getUpdateFeedMethod =
              getUpdateFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p2beta1.UpdateFeedRequest,
                          com.google.cloud.asset.v1p2beta1.Feed>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.UpdateFeedRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.Feed.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("UpdateFeed"))
                      .build();
        }
      }
    }
    return getUpdateFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeed",
      requestType = com.google.cloud.asset.v1p2beta1.DeleteFeedRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.asset.v1p2beta1.DeleteFeedRequest, com.google.protobuf.Empty>
        getDeleteFeedMethod;
    if ((getDeleteFeedMethod = AssetServiceGrpc.getDeleteFeedMethod) == null) {
      synchronized (AssetServiceGrpc.class) {
        if ((getDeleteFeedMethod = AssetServiceGrpc.getDeleteFeedMethod) == null) {
          AssetServiceGrpc.getDeleteFeedMethod =
              getDeleteFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.asset.v1p2beta1.DeleteFeedRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.asset.v1p2beta1.DeleteFeedRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new AssetServiceMethodDescriptorSupplier("DeleteFeed"))
                      .build();
        }
      }
    }
    return getDeleteFeedMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AssetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceStub>() {
          @java.lang.Override
          public AssetServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceStub(channel, callOptions);
          }
        };
    return AssetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceBlockingStub>() {
          @java.lang.Override
          public AssetServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceBlockingStub(channel, callOptions);
          }
        };
    return AssetServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AssetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssetServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssetServiceFutureStub>() {
          @java.lang.Override
          public AssetServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssetServiceFutureStub(channel, callOptions);
          }
        };
    return AssetServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public abstract static class AssetServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public void createFeed(
        com.google.cloud.asset.v1p2beta1.CreateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public void getFeed(
        com.google.cloud.asset.v1p2beta1.GetFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public void listFeeds(
        com.google.cloud.asset.v1p2beta1.ListFeedsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeedsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public void updateFeed(
        com.google.cloud.asset.v1p2beta1.UpdateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFeedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public void deleteFeed(
        com.google.cloud.asset.v1p2beta1.DeleteFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFeedMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.CreateFeedRequest,
                      com.google.cloud.asset.v1p2beta1.Feed>(this, METHODID_CREATE_FEED)))
          .addMethod(
              getGetFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.GetFeedRequest,
                      com.google.cloud.asset.v1p2beta1.Feed>(this, METHODID_GET_FEED)))
          .addMethod(
              getListFeedsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
                      com.google.cloud.asset.v1p2beta1.ListFeedsResponse>(
                      this, METHODID_LIST_FEEDS)))
          .addMethod(
              getUpdateFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.UpdateFeedRequest,
                      com.google.cloud.asset.v1p2beta1.Feed>(this, METHODID_UPDATE_FEED)))
          .addMethod(
              getDeleteFeedMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.DeleteFeedRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_FEED)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AssetServiceStub> {
    private AssetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public void createFeed(
        com.google.cloud.asset.v1p2beta1.CreateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public void getFeed(
        com.google.cloud.asset.v1p2beta1.GetFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public void listFeeds(
        com.google.cloud.asset.v1p2beta1.ListFeedsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeedsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public void updateFeed(
        com.google.cloud.asset.v1p2beta1.UpdateFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public void deleteFeed(
        com.google.cloud.asset.v1p2beta1.DeleteFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AssetServiceBlockingStub> {
    private AssetServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public com.google.cloud.asset.v1p2beta1.Feed createFeed(
        com.google.cloud.asset.v1p2beta1.CreateFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public com.google.cloud.asset.v1p2beta1.Feed getFeed(
        com.google.cloud.asset.v1p2beta1.GetFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public com.google.cloud.asset.v1p2beta1.ListFeedsResponse listFeeds(
        com.google.cloud.asset.v1p2beta1.ListFeedsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeedsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public com.google.cloud.asset.v1p2beta1.Feed updateFeed(
        com.google.cloud.asset.v1p2beta1.UpdateFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFeed(
        com.google.cloud.asset.v1p2beta1.DeleteFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeedMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Asset service definition.
   * </pre>
   */
  public static final class AssetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AssetServiceFutureStub> {
    private AssetServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a feed in a parent project/folder/organization to listen to its
     * asset updates.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1p2beta1.Feed>
        createFeed(com.google.cloud.asset.v1p2beta1.CreateFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an asset feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1p2beta1.Feed>
        getFeed(com.google.cloud.asset.v1p2beta1.GetFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all asset feeds in a parent project/folder/organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
        listFeeds(com.google.cloud.asset.v1p2beta1.ListFeedsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeedsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an asset feed configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.asset.v1p2beta1.Feed>
        updateFeed(com.google.cloud.asset.v1p2beta1.UpdateFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset feed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteFeed(
        com.google.cloud.asset.v1p2beta1.DeleteFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FEED = 0;
  private static final int METHODID_GET_FEED = 1;
  private static final int METHODID_LIST_FEEDS = 2;
  private static final int METHODID_UPDATE_FEED = 3;
  private static final int METHODID_DELETE_FEED = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AssetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AssetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FEED:
          serviceImpl.createFeed(
              (com.google.cloud.asset.v1p2beta1.CreateFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed>)
                  responseObserver);
          break;
        case METHODID_GET_FEED:
          serviceImpl.getFeed(
              (com.google.cloud.asset.v1p2beta1.GetFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed>)
                  responseObserver);
          break;
        case METHODID_LIST_FEEDS:
          serviceImpl.listFeeds(
              (com.google.cloud.asset.v1p2beta1.ListFeedsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.ListFeedsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEED:
          serviceImpl.updateFeed(
              (com.google.cloud.asset.v1p2beta1.UpdateFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.asset.v1p2beta1.Feed>)
                  responseObserver);
          break;
        case METHODID_DELETE_FEED:
          serviceImpl.deleteFeed(
              (com.google.cloud.asset.v1p2beta1.DeleteFeedRequest) request,
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

  private abstract static class AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.asset.v1p2beta1.AssetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssetService");
    }
  }

  private static final class AssetServiceFileDescriptorSupplier
      extends AssetServiceBaseDescriptorSupplier {
    AssetServiceFileDescriptorSupplier() {}
  }

  private static final class AssetServiceMethodDescriptorSupplier
      extends AssetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AssetServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AssetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AssetServiceFileDescriptorSupplier())
                      .addMethod(getCreateFeedMethod())
                      .addMethod(getGetFeedMethod())
                      .addMethod(getListFeedsMethod())
                      .addMethod(getUpdateFeedMethod())
                      .addMethod(getDeleteFeedMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
