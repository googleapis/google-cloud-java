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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for fetching feature values from the online store.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/feature_online_store_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeatureOnlineStoreServiceGrpc {

  private FeatureOnlineStoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.FeatureOnlineStoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest,
          com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>
      getFetchFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchFeatureValues",
      requestType = com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest,
          com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>
      getFetchFeatureValuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest,
            com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>
        getFetchFeatureValuesMethod;
    if ((getFetchFeatureValuesMethod = FeatureOnlineStoreServiceGrpc.getFetchFeatureValuesMethod)
        == null) {
      synchronized (FeatureOnlineStoreServiceGrpc.class) {
        if ((getFetchFeatureValuesMethod =
                FeatureOnlineStoreServiceGrpc.getFetchFeatureValuesMethod)
            == null) {
          FeatureOnlineStoreServiceGrpc.getFetchFeatureValuesMethod =
              getFetchFeatureValuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest,
                          com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchFeatureValues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureOnlineStoreServiceMethodDescriptorSupplier(
                              "FetchFeatureValues"))
                      .build();
        }
      }
    }
    return getFetchFeatureValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest,
          com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>
      getStreamingFetchFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingFetchFeatureValues",
      requestType = com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest,
          com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>
      getStreamingFetchFeatureValuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest,
            com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>
        getStreamingFetchFeatureValuesMethod;
    if ((getStreamingFetchFeatureValuesMethod =
            FeatureOnlineStoreServiceGrpc.getStreamingFetchFeatureValuesMethod)
        == null) {
      synchronized (FeatureOnlineStoreServiceGrpc.class) {
        if ((getStreamingFetchFeatureValuesMethod =
                FeatureOnlineStoreServiceGrpc.getStreamingFetchFeatureValuesMethod)
            == null) {
          FeatureOnlineStoreServiceGrpc.getStreamingFetchFeatureValuesMethod =
              getStreamingFetchFeatureValuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest,
                          com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StreamingFetchFeatureValues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .StreamingFetchFeatureValuesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureOnlineStoreServiceMethodDescriptorSupplier(
                              "StreamingFetchFeatureValues"))
                      .build();
        }
      }
    }
    return getStreamingFetchFeatureValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest,
          com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>
      getSearchNearestEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchNearestEntities",
      requestType = com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest,
          com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>
      getSearchNearestEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest,
            com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>
        getSearchNearestEntitiesMethod;
    if ((getSearchNearestEntitiesMethod =
            FeatureOnlineStoreServiceGrpc.getSearchNearestEntitiesMethod)
        == null) {
      synchronized (FeatureOnlineStoreServiceGrpc.class) {
        if ((getSearchNearestEntitiesMethod =
                FeatureOnlineStoreServiceGrpc.getSearchNearestEntitiesMethod)
            == null) {
          FeatureOnlineStoreServiceGrpc.getSearchNearestEntitiesMethod =
              getSearchNearestEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest,
                          com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchNearestEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureOnlineStoreServiceMethodDescriptorSupplier(
                              "SearchNearestEntities"))
                      .build();
        }
      }
    }
    return getSearchNearestEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest,
          com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>
      getFeatureViewDirectWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FeatureViewDirectWrite",
      requestType = com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest,
          com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>
      getFeatureViewDirectWriteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest,
            com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>
        getFeatureViewDirectWriteMethod;
    if ((getFeatureViewDirectWriteMethod =
            FeatureOnlineStoreServiceGrpc.getFeatureViewDirectWriteMethod)
        == null) {
      synchronized (FeatureOnlineStoreServiceGrpc.class) {
        if ((getFeatureViewDirectWriteMethod =
                FeatureOnlineStoreServiceGrpc.getFeatureViewDirectWriteMethod)
            == null) {
          FeatureOnlineStoreServiceGrpc.getFeatureViewDirectWriteMethod =
              getFeatureViewDirectWriteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest,
                          com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FeatureViewDirectWrite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureOnlineStoreServiceMethodDescriptorSupplier(
                              "FeatureViewDirectWrite"))
                      .build();
        }
      }
    }
    return getFeatureViewDirectWriteMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FeatureOnlineStoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceStub>() {
          @java.lang.Override
          public FeatureOnlineStoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeatureOnlineStoreServiceStub(channel, callOptions);
          }
        };
    return FeatureOnlineStoreServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FeatureOnlineStoreServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceBlockingV2Stub>() {
          @java.lang.Override
          public FeatureOnlineStoreServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeatureOnlineStoreServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return FeatureOnlineStoreServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeatureOnlineStoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceBlockingStub>() {
          @java.lang.Override
          public FeatureOnlineStoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeatureOnlineStoreServiceBlockingStub(channel, callOptions);
          }
        };
    return FeatureOnlineStoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FeatureOnlineStoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreServiceFutureStub>() {
          @java.lang.Override
          public FeatureOnlineStoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeatureOnlineStoreServiceFutureStub(channel, callOptions);
          }
        };
    return FeatureOnlineStoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for fetching feature values from the online store.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Fetch feature values under a FeatureView.
     * </pre>
     */
    default void fetchFeatureValues(
        com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchFeatureValuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bidirectional streaming RPC to fetch feature values under a FeatureView.
     * Requests may not have a one-to-one mapping to responses and responses may
     * be returned out-of-order to reduce latency.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<
            com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest>
        streamingFetchFeatureValues(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamingFetchFeatureValuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search the nearest entities under a FeatureView.
     * Search only works for indexable feature view; if a feature view isn't
     * indexable, returns Invalid argument response.
     * </pre>
     */
    default void searchNearestEntities(
        com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchNearestEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bidirectional streaming RPC to directly write to feature values in a
     * feature view. Requests may not have a one-to-one mapping to responses and
     * responses may be returned out-of-order to reduce latency.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<
            com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest>
        featureViewDirectWrite(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getFeatureViewDirectWriteMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FeatureOnlineStoreService.
   *
   * <pre>
   * A service for fetching feature values from the online store.
   * </pre>
   */
  public abstract static class FeatureOnlineStoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FeatureOnlineStoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FeatureOnlineStoreService.
   *
   * <pre>
   * A service for fetching feature values from the online store.
   * </pre>
   */
  public static final class FeatureOnlineStoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeatureOnlineStoreServiceStub> {
    private FeatureOnlineStoreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureOnlineStoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureOnlineStoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch feature values under a FeatureView.
     * </pre>
     */
    public void fetchFeatureValues(
        com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchFeatureValuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bidirectional streaming RPC to fetch feature values under a FeatureView.
     * Requests may not have a one-to-one mapping to responses and responses may
     * be returned out-of-order to reduce latency.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest>
        streamingFetchFeatureValues(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingFetchFeatureValuesMethod(), getCallOptions()),
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search the nearest entities under a FeatureView.
     * Search only works for indexable feature view; if a feature view isn't
     * indexable, returns Invalid argument response.
     * </pre>
     */
    public void searchNearestEntities(
        com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchNearestEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bidirectional streaming RPC to directly write to feature values in a
     * feature view. Requests may not have a one-to-one mapping to responses and
     * responses may be returned out-of-order to reduce latency.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest>
        featureViewDirectWrite(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getFeatureViewDirectWriteMethod(), getCallOptions()),
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FeatureOnlineStoreService.
   *
   * <pre>
   * A service for fetching feature values from the online store.
   * </pre>
   */
  public static final class FeatureOnlineStoreServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FeatureOnlineStoreServiceBlockingV2Stub> {
    private FeatureOnlineStoreServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureOnlineStoreServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureOnlineStoreServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch feature values under a FeatureView.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse fetchFeatureValues(
        com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchFeatureValuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bidirectional streaming RPC to fetch feature values under a FeatureView.
     * Requests may not have a one-to-one mapping to responses and responses may
     * be returned out-of-order to reduce latency.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest,
            com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>
        streamingFetchFeatureValues() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getStreamingFetchFeatureValuesMethod(), getCallOptions());
    }

    /**
     *
     *
     * <pre>
     * Search the nearest entities under a FeatureView.
     * Search only works for indexable feature view; if a feature view isn't
     * indexable, returns Invalid argument response.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse searchNearestEntities(
        com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchNearestEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bidirectional streaming RPC to directly write to feature values in a
     * feature view. Requests may not have a one-to-one mapping to responses and
     * responses may be returned out-of-order to reduce latency.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest,
            com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>
        featureViewDirectWrite() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getFeatureViewDirectWriteMethod(), getCallOptions());
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * FeatureOnlineStoreService.
   *
   * <pre>
   * A service for fetching feature values from the online store.
   * </pre>
   */
  public static final class FeatureOnlineStoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeatureOnlineStoreServiceBlockingStub> {
    private FeatureOnlineStoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureOnlineStoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureOnlineStoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch feature values under a FeatureView.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse fetchFeatureValues(
        com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchFeatureValuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search the nearest entities under a FeatureView.
     * Search only works for indexable feature view; if a feature view isn't
     * indexable, returns Invalid argument response.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse searchNearestEntities(
        com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchNearestEntitiesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * FeatureOnlineStoreService.
   *
   * <pre>
   * A service for fetching feature values from the online store.
   * </pre>
   */
  public static final class FeatureOnlineStoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeatureOnlineStoreServiceFutureStub> {
    private FeatureOnlineStoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureOnlineStoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureOnlineStoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetch feature values under a FeatureView.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>
        fetchFeatureValues(com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchFeatureValuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search the nearest entities under a FeatureView.
     * Search only works for indexable feature view; if a feature view isn't
     * indexable, returns Invalid argument response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>
        searchNearestEntities(
            com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchNearestEntitiesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_FEATURE_VALUES = 0;
  private static final int METHODID_SEARCH_NEAREST_ENTITIES = 1;
  private static final int METHODID_STREAMING_FETCH_FEATURE_VALUES = 2;
  private static final int METHODID_FEATURE_VIEW_DIRECT_WRITE = 3;

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
        case METHODID_FETCH_FEATURE_VALUES:
          serviceImpl.fetchFeatureValues(
              (com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_NEAREST_ENTITIES:
          serviceImpl.searchNearestEntities(
              (com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>)
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
        case METHODID_STREAMING_FETCH_FEATURE_VALUES:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamingFetchFeatureValues(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>)
                      responseObserver);
        case METHODID_FEATURE_VIEW_DIRECT_WRITE:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.featureViewDirectWrite(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getFetchFeatureValuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest,
                    com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse>(
                    service, METHODID_FETCH_FEATURE_VALUES)))
        .addMethod(
            getStreamingFetchFeatureValuesMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest,
                    com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse>(
                    service, METHODID_STREAMING_FETCH_FEATURE_VALUES)))
        .addMethod(
            getSearchNearestEntitiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest,
                    com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse>(
                    service, METHODID_SEARCH_NEAREST_ENTITIES)))
        .addMethod(
            getFeatureViewDirectWriteMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteRequest,
                    com.google.cloud.aiplatform.v1beta1.FeatureViewDirectWriteResponse>(
                    service, METHODID_FEATURE_VIEW_DIRECT_WRITE)))
        .build();
  }

  private abstract static class FeatureOnlineStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeatureOnlineStoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeatureOnlineStoreService");
    }
  }

  private static final class FeatureOnlineStoreServiceFileDescriptorSupplier
      extends FeatureOnlineStoreServiceBaseDescriptorSupplier {
    FeatureOnlineStoreServiceFileDescriptorSupplier() {}
  }

  private static final class FeatureOnlineStoreServiceMethodDescriptorSupplier
      extends FeatureOnlineStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FeatureOnlineStoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FeatureOnlineStoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FeatureOnlineStoreServiceFileDescriptorSupplier())
                      .addMethod(getFetchFeatureValuesMethod())
                      .addMethod(getStreamingFetchFeatureValuesMethod())
                      .addMethod(getSearchNearestEntitiesMethod())
                      .addMethod(getFeatureViewDirectWriteMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
