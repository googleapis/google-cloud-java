package com.google.cloud.gkehub.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The GKE Hub service handles the registration of many Kubernetes clusters to
 * Google Cloud, and the management of multi-cluster features over those
 * clusters.
 * The GKE Hub service operates on the following resources:
 * * [Membership][google.cloud.gkehub.v1alpha.Membership]
 * * [Feature][google.cloud.gkehub.v1alpha.Feature]
 * GKE Hub is currently only available in the global region.
 * **Membership management may be non-trivial:** it is recommended to use one
 * of the Google-provided client libraries or tools where possible when working
 * with Membership resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkehub/v1alpha/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GkeHubGrpc {

  private GkeHubGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gkehub.v1alpha.GkeHub";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.ListFeaturesRequest,
      com.google.cloud.gkehub.v1alpha.ListFeaturesResponse> getListFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatures",
      requestType = com.google.cloud.gkehub.v1alpha.ListFeaturesRequest.class,
      responseType = com.google.cloud.gkehub.v1alpha.ListFeaturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.ListFeaturesRequest,
      com.google.cloud.gkehub.v1alpha.ListFeaturesResponse> getListFeaturesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.ListFeaturesRequest, com.google.cloud.gkehub.v1alpha.ListFeaturesResponse> getListFeaturesMethod;
    if ((getListFeaturesMethod = GkeHubGrpc.getListFeaturesMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListFeaturesMethod = GkeHubGrpc.getListFeaturesMethod) == null) {
          GkeHubGrpc.getListFeaturesMethod = getListFeaturesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha.ListFeaturesRequest, com.google.cloud.gkehub.v1alpha.ListFeaturesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha.ListFeaturesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha.ListFeaturesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListFeatures"))
              .build();
        }
      }
    }
    return getListFeaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.GetFeatureRequest,
      com.google.cloud.gkehub.v1alpha.Feature> getGetFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeature",
      requestType = com.google.cloud.gkehub.v1alpha.GetFeatureRequest.class,
      responseType = com.google.cloud.gkehub.v1alpha.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.GetFeatureRequest,
      com.google.cloud.gkehub.v1alpha.Feature> getGetFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.GetFeatureRequest, com.google.cloud.gkehub.v1alpha.Feature> getGetFeatureMethod;
    if ((getGetFeatureMethod = GkeHubGrpc.getGetFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetFeatureMethod = GkeHubGrpc.getGetFeatureMethod) == null) {
          GkeHubGrpc.getGetFeatureMethod = getGetFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha.GetFeatureRequest, com.google.cloud.gkehub.v1alpha.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha.GetFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha.Feature.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetFeature"))
              .build();
        }
      }
    }
    return getGetFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.CreateFeatureRequest,
      com.google.longrunning.Operation> getCreateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeature",
      requestType = com.google.cloud.gkehub.v1alpha.CreateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.CreateFeatureRequest,
      com.google.longrunning.Operation> getCreateFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.CreateFeatureRequest, com.google.longrunning.Operation> getCreateFeatureMethod;
    if ((getCreateFeatureMethod = GkeHubGrpc.getCreateFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateFeatureMethod = GkeHubGrpc.getCreateFeatureMethod) == null) {
          GkeHubGrpc.getCreateFeatureMethod = getCreateFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha.CreateFeatureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha.CreateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateFeature"))
              .build();
        }
      }
    }
    return getCreateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest,
      com.google.longrunning.Operation> getDeleteFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeature",
      requestType = com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest,
      com.google.longrunning.Operation> getDeleteFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest, com.google.longrunning.Operation> getDeleteFeatureMethod;
    if ((getDeleteFeatureMethod = GkeHubGrpc.getDeleteFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteFeatureMethod = GkeHubGrpc.getDeleteFeatureMethod) == null) {
          GkeHubGrpc.getDeleteFeatureMethod = getDeleteFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteFeature"))
              .build();
        }
      }
    }
    return getDeleteFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest,
      com.google.longrunning.Operation> getUpdateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeature",
      requestType = com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest,
      com.google.longrunning.Operation> getUpdateFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest, com.google.longrunning.Operation> getUpdateFeatureMethod;
    if ((getUpdateFeatureMethod = GkeHubGrpc.getUpdateFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateFeatureMethod = GkeHubGrpc.getUpdateFeatureMethod) == null) {
          GkeHubGrpc.getUpdateFeatureMethod = getUpdateFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateFeature"))
              .build();
        }
      }
    }
    return getUpdateFeatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GkeHubStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubStub>() {
        @java.lang.Override
        public GkeHubStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubStub(channel, callOptions);
        }
      };
    return GkeHubStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GkeHubBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingStub>() {
        @java.lang.Override
        public GkeHubBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubBlockingStub(channel, callOptions);
        }
      };
    return GkeHubBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GkeHubFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubFutureStub>() {
        @java.lang.Override
        public GkeHubFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubFutureStub(channel, callOptions);
        }
      };
    return GkeHubFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1alpha.Membership]
   * * [Feature][google.cloud.gkehub.v1alpha.Feature]
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static abstract class GkeHubImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public void listFeatures(com.google.cloud.gkehub.v1alpha.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha.ListFeaturesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeaturesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(com.google.cloud.gkehub.v1alpha.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha.Feature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public void createFeature(com.google.cloud.gkehub.v1alpha.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public void deleteFeature(com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public void updateFeature(com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFeatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListFeaturesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha.ListFeaturesRequest,
                com.google.cloud.gkehub.v1alpha.ListFeaturesResponse>(
                  this, METHODID_LIST_FEATURES)))
          .addMethod(
            getGetFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha.GetFeatureRequest,
                com.google.cloud.gkehub.v1alpha.Feature>(
                  this, METHODID_GET_FEATURE)))
          .addMethod(
            getCreateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha.CreateFeatureRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_FEATURE)))
          .addMethod(
            getDeleteFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_FEATURE)))
          .addMethod(
            getUpdateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_FEATURE)))
          .build();
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1alpha.Membership]
   * * [Feature][google.cloud.gkehub.v1alpha.Feature]
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubStub extends io.grpc.stub.AbstractAsyncStub<GkeHubStub> {
    private GkeHubStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public void listFeatures(com.google.cloud.gkehub.v1alpha.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha.ListFeaturesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(com.google.cloud.gkehub.v1alpha.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha.Feature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public void createFeature(com.google.cloud.gkehub.v1alpha.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public void deleteFeature(com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public void updateFeature(com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1alpha.Membership]
   * * [Feature][google.cloud.gkehub.v1alpha.Feature]
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubBlockingStub extends io.grpc.stub.AbstractBlockingStub<GkeHubBlockingStub> {
    private GkeHubBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1alpha.ListFeaturesResponse listFeatures(com.google.cloud.gkehub.v1alpha.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.cloud.gkehub.v1alpha.Feature getFeature(com.google.cloud.gkehub.v1alpha.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public com.google.longrunning.Operation createFeature(com.google.cloud.gkehub.v1alpha.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeature(com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeature(com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1alpha.Membership]
   * * [Feature][google.cloud.gkehub.v1alpha.Feature]
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubFutureStub extends io.grpc.stub.AbstractFutureStub<GkeHubFutureStub> {
    private GkeHubFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1alpha.ListFeaturesResponse> listFeatures(
        com.google.cloud.gkehub.v1alpha.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1alpha.Feature> getFeature(
        com.google.cloud.gkehub.v1alpha.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createFeature(
        com.google.cloud.gkehub.v1alpha.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteFeature(
        com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateFeature(
        com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_FEATURES = 0;
  private static final int METHODID_GET_FEATURE = 1;
  private static final int METHODID_CREATE_FEATURE = 2;
  private static final int METHODID_DELETE_FEATURE = 3;
  private static final int METHODID_UPDATE_FEATURE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GkeHubImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GkeHubImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures((com.google.cloud.gkehub.v1alpha.ListFeaturesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha.ListFeaturesResponse>) responseObserver);
          break;
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature((com.google.cloud.gkehub.v1alpha.GetFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha.Feature>) responseObserver);
          break;
        case METHODID_CREATE_FEATURE:
          serviceImpl.createFeature((com.google.cloud.gkehub.v1alpha.CreateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURE:
          serviceImpl.deleteFeature((com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FEATURE:
          serviceImpl.updateFeature((com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private static abstract class GkeHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GkeHubBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkehub.v1alpha.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GkeHub");
    }
  }

  private static final class GkeHubFileDescriptorSupplier
      extends GkeHubBaseDescriptorSupplier {
    GkeHubFileDescriptorSupplier() {}
  }

  private static final class GkeHubMethodDescriptorSupplier
      extends GkeHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GkeHubMethodDescriptorSupplier(String methodName) {
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
      synchronized (GkeHubGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GkeHubFileDescriptorSupplier())
              .addMethod(getListFeaturesMethod())
              .addMethod(getGetFeatureMethod())
              .addMethod(getCreateFeatureMethod())
              .addMethod(getDeleteFeatureMethod())
              .addMethod(getUpdateFeatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
