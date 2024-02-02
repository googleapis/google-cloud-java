/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.kms.inventory.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Returns information about the resources in an org that are protected by a
 * given Cloud KMS key via CMEK.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/kms/inventory/v1/key_tracking_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KeyTrackingServiceGrpc {

  private KeyTrackingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.kms.inventory.v1.KeyTrackingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest,
          com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>
      getGetProtectedResourcesSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProtectedResourcesSummary",
      requestType = com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest.class,
      responseType = com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest,
          com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>
      getGetProtectedResourcesSummaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest,
            com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>
        getGetProtectedResourcesSummaryMethod;
    if ((getGetProtectedResourcesSummaryMethod =
            KeyTrackingServiceGrpc.getGetProtectedResourcesSummaryMethod)
        == null) {
      synchronized (KeyTrackingServiceGrpc.class) {
        if ((getGetProtectedResourcesSummaryMethod =
                KeyTrackingServiceGrpc.getGetProtectedResourcesSummaryMethod)
            == null) {
          KeyTrackingServiceGrpc.getGetProtectedResourcesSummaryMethod =
              getGetProtectedResourcesSummaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest,
                          com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetProtectedResourcesSummary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyTrackingServiceMethodDescriptorSupplier(
                              "GetProtectedResourcesSummary"))
                      .build();
        }
      }
    }
    return getGetProtectedResourcesSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest,
          com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>
      getSearchProtectedResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchProtectedResources",
      requestType = com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest.class,
      responseType = com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest,
          com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>
      getSearchProtectedResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest,
            com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>
        getSearchProtectedResourcesMethod;
    if ((getSearchProtectedResourcesMethod =
            KeyTrackingServiceGrpc.getSearchProtectedResourcesMethod)
        == null) {
      synchronized (KeyTrackingServiceGrpc.class) {
        if ((getSearchProtectedResourcesMethod =
                KeyTrackingServiceGrpc.getSearchProtectedResourcesMethod)
            == null) {
          KeyTrackingServiceGrpc.getSearchProtectedResourcesMethod =
              getSearchProtectedResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest,
                          com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchProtectedResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyTrackingServiceMethodDescriptorSupplier(
                              "SearchProtectedResources"))
                      .build();
        }
      }
    }
    return getSearchProtectedResourcesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static KeyTrackingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyTrackingServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<KeyTrackingServiceStub>() {
          @java.lang.Override
          public KeyTrackingServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new KeyTrackingServiceStub(channel, callOptions);
          }
        };
    return KeyTrackingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KeyTrackingServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyTrackingServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<KeyTrackingServiceBlockingStub>() {
          @java.lang.Override
          public KeyTrackingServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new KeyTrackingServiceBlockingStub(channel, callOptions);
          }
        };
    return KeyTrackingServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static KeyTrackingServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyTrackingServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<KeyTrackingServiceFutureStub>() {
          @java.lang.Override
          public KeyTrackingServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new KeyTrackingServiceFutureStub(channel, callOptions);
          }
        };
    return KeyTrackingServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Returns information about the resources in an org that are protected by a
   * given Cloud KMS key via CMEK.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns aggregate information about the resources protected by the given
     * Cloud KMS [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within
     * the same Cloud organization as the key will be returned. The project that
     * holds the key must be part of an organization in order for this call to
     * succeed.
     * </pre>
     */
    default void getProtectedResourcesSummary(
        com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProtectedResourcesSummaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata about the resources protected by the given Cloud KMS
     * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
     * </pre>
     */
    default void searchProtectedResources(
        com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchProtectedResourcesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service KeyTrackingService.
   *
   * <pre>
   * Returns information about the resources in an org that are protected by a
   * given Cloud KMS key via CMEK.
   * </pre>
   */
  public abstract static class KeyTrackingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return KeyTrackingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service KeyTrackingService.
   *
   * <pre>
   * Returns information about the resources in an org that are protected by a
   * given Cloud KMS key via CMEK.
   * </pre>
   */
  public static final class KeyTrackingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<KeyTrackingServiceStub> {
    private KeyTrackingServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyTrackingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyTrackingServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns aggregate information about the resources protected by the given
     * Cloud KMS [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within
     * the same Cloud organization as the key will be returned. The project that
     * holds the key must be part of an organization in order for this call to
     * succeed.
     * </pre>
     */
    public void getProtectedResourcesSummary(
        com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProtectedResourcesSummaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata about the resources protected by the given Cloud KMS
     * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
     * </pre>
     */
    public void searchProtectedResources(
        com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchProtectedResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service KeyTrackingService.
   *
   * <pre>
   * Returns information about the resources in an org that are protected by a
   * given Cloud KMS key via CMEK.
   * </pre>
   */
  public static final class KeyTrackingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<KeyTrackingServiceBlockingStub> {
    private KeyTrackingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyTrackingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyTrackingServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns aggregate information about the resources protected by the given
     * Cloud KMS [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within
     * the same Cloud organization as the key will be returned. The project that
     * holds the key must be part of an organization in order for this call to
     * succeed.
     * </pre>
     */
    public com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary getProtectedResourcesSummary(
        com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProtectedResourcesSummaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata about the resources protected by the given Cloud KMS
     * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
     * </pre>
     */
    public com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse
        searchProtectedResources(
            com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchProtectedResourcesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service KeyTrackingService.
   *
   * <pre>
   * Returns information about the resources in an org that are protected by a
   * given Cloud KMS key via CMEK.
   * </pre>
   */
  public static final class KeyTrackingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<KeyTrackingServiceFutureStub> {
    private KeyTrackingServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyTrackingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyTrackingServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns aggregate information about the resources protected by the given
     * Cloud KMS [CryptoKey][google.cloud.kms.v1.CryptoKey]. Only resources within
     * the same Cloud organization as the key will be returned. The project that
     * holds the key must be part of an organization in order for this call to
     * succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>
        getProtectedResourcesSummary(
            com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProtectedResourcesSummaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata about the resources protected by the given Cloud KMS
     * [CryptoKey][google.cloud.kms.v1.CryptoKey] in the given Cloud organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>
        searchProtectedResources(
            com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchProtectedResourcesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROTECTED_RESOURCES_SUMMARY = 0;
  private static final int METHODID_SEARCH_PROTECTED_RESOURCES = 1;

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
        case METHODID_GET_PROTECTED_RESOURCES_SUMMARY:
          serviceImpl.getProtectedResourcesSummary(
              (com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>)
                  responseObserver);
          break;
        case METHODID_SEARCH_PROTECTED_RESOURCES:
          serviceImpl.searchProtectedResources(
              (com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>)
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
            getGetProtectedResourcesSummaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest,
                    com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary>(
                    service, METHODID_GET_PROTECTED_RESOURCES_SUMMARY)))
        .addMethod(
            getSearchProtectedResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest,
                    com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse>(
                    service, METHODID_SEARCH_PROTECTED_RESOURCES)))
        .build();
  }

  private abstract static class KeyTrackingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KeyTrackingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.inventory.v1.KeyTrackingServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KeyTrackingService");
    }
  }

  private static final class KeyTrackingServiceFileDescriptorSupplier
      extends KeyTrackingServiceBaseDescriptorSupplier {
    KeyTrackingServiceFileDescriptorSupplier() {}
  }

  private static final class KeyTrackingServiceMethodDescriptorSupplier
      extends KeyTrackingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    KeyTrackingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (KeyTrackingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new KeyTrackingServiceFileDescriptorSupplier())
                      .addMethod(getGetProtectedResourcesSummaryMethod())
                      .addMethod(getSearchProtectedResourcesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
