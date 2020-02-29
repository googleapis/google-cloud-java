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
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Asset service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/asset/v1p2beta1/asset_service.proto")
public final class AssetServiceGrpc {

  private AssetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.asset.v1p2beta1.AssetService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateFeedMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.CreateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      METHOD_CREATE_FEED = getCreateFeedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.CreateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getCreateFeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.CreateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getCreateFeedMethod() {
    return getCreateFeedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.CreateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getCreateFeedMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.asset.v1p2beta1.AssetService", "CreateFeed"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetFeedMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.GetFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      METHOD_GET_FEED = getGetFeedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.GetFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getGetFeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.GetFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getGetFeedMethod() {
    return getGetFeedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.GetFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getGetFeedMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.asset.v1p2beta1.AssetService", "GetFeed"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListFeedsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
          com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
      METHOD_LIST_FEEDS = getListFeedsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
          com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
      getListFeedsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
          com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
      getListFeedsMethod() {
    return getListFeedsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
          com.google.cloud.asset.v1p2beta1.ListFeedsResponse>
      getListFeedsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.asset.v1p2beta1.AssetService", "ListFeeds"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateFeedMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.UpdateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      METHOD_UPDATE_FEED = getUpdateFeedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.UpdateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getUpdateFeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.UpdateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getUpdateFeedMethod() {
    return getUpdateFeedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.UpdateFeedRequest, com.google.cloud.asset.v1p2beta1.Feed>
      getUpdateFeedMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.asset.v1p2beta1.AssetService", "UpdateFeed"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteFeedMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.DeleteFeedRequest, com.google.protobuf.Empty>
      METHOD_DELETE_FEED = getDeleteFeedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethod() {
    return getDeleteFeedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.asset.v1p2beta1.DeleteFeedRequest, com.google.protobuf.Empty>
      getDeleteFeedMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.asset.v1p2beta1.AssetService", "DeleteFeed"))
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
    return new AssetServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new AssetServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AssetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new AssetServiceFutureStub(channel);
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
      asyncUnimplementedUnaryCall(getCreateFeedMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetFeedMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListFeedsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateFeedMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteFeedMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateFeedMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.CreateFeedRequest,
                      com.google.cloud.asset.v1p2beta1.Feed>(this, METHODID_CREATE_FEED)))
          .addMethod(
              getGetFeedMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.GetFeedRequest,
                      com.google.cloud.asset.v1p2beta1.Feed>(this, METHODID_GET_FEED)))
          .addMethod(
              getListFeedsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.ListFeedsRequest,
                      com.google.cloud.asset.v1p2beta1.ListFeedsResponse>(
                      this, METHODID_LIST_FEEDS)))
          .addMethod(
              getUpdateFeedMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.asset.v1p2beta1.UpdateFeedRequest,
                      com.google.cloud.asset.v1p2beta1.Feed>(this, METHODID_UPDATE_FEED)))
          .addMethod(
              getDeleteFeedMethodHelper(),
              asyncUnaryCall(
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
  public static final class AssetServiceStub extends io.grpc.stub.AbstractStub<AssetServiceStub> {
    private AssetServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      asyncUnaryCall(
          getChannel().newCall(getCreateFeedMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getGetFeedMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getListFeedsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateFeedMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteFeedMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      extends io.grpc.stub.AbstractStub<AssetServiceBlockingStub> {
    private AssetServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return blockingUnaryCall(
          getChannel(), getCreateFeedMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getGetFeedMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getListFeedsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getUpdateFeedMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteFeedMethodHelper(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractStub<AssetServiceFutureStub> {
    private AssetServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return futureUnaryCall(
          getChannel().newCall(getCreateFeedMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetFeedMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListFeedsMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateFeedMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteFeedMethodHelper(), getCallOptions()), request);
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
                      .addMethod(getCreateFeedMethodHelper())
                      .addMethod(getGetFeedMethodHelper())
                      .addMethod(getListFeedsMethodHelper())
                      .addMethod(getUpdateFeedMethodHelper())
                      .addMethod(getDeleteFeedMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
