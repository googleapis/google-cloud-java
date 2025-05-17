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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service facilitates the management of a merchant's omnichannel settings.
 * ## This API defines the following resource model:
 * [OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/omnichannelsettings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OmnichannelSettingsServiceGrpc {

  private OmnichannelSettingsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.OmnichannelSettingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest,
          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
      getGetOmnichannelSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOmnichannelSetting",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest,
          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
      getGetOmnichannelSettingMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest,
            com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
        getGetOmnichannelSettingMethod;
    if ((getGetOmnichannelSettingMethod =
            OmnichannelSettingsServiceGrpc.getGetOmnichannelSettingMethod)
        == null) {
      synchronized (OmnichannelSettingsServiceGrpc.class) {
        if ((getGetOmnichannelSettingMethod =
                OmnichannelSettingsServiceGrpc.getGetOmnichannelSettingMethod)
            == null) {
          OmnichannelSettingsServiceGrpc.getGetOmnichannelSettingMethod =
              getGetOmnichannelSettingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest,
                          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOmnichannelSetting"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetOmnichannelSettingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OmnichannelSettingsServiceMethodDescriptorSupplier(
                              "GetOmnichannelSetting"))
                      .build();
        }
      }
    }
    return getGetOmnichannelSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>
      getListOmnichannelSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOmnichannelSettings",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest.class,
      responseType =
          com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>
      getListOmnichannelSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest,
            com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>
        getListOmnichannelSettingsMethod;
    if ((getListOmnichannelSettingsMethod =
            OmnichannelSettingsServiceGrpc.getListOmnichannelSettingsMethod)
        == null) {
      synchronized (OmnichannelSettingsServiceGrpc.class) {
        if ((getListOmnichannelSettingsMethod =
                OmnichannelSettingsServiceGrpc.getListOmnichannelSettingsMethod)
            == null) {
          OmnichannelSettingsServiceGrpc.getListOmnichannelSettingsMethod =
              getListOmnichannelSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest,
                          com.google.shopping.merchant.accounts.v1beta
                              .ListOmnichannelSettingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOmnichannelSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .ListOmnichannelSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .ListOmnichannelSettingsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OmnichannelSettingsServiceMethodDescriptorSupplier(
                              "ListOmnichannelSettings"))
                      .build();
        }
      }
    }
    return getListOmnichannelSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest,
          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
      getCreateOmnichannelSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOmnichannelSetting",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest,
          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
      getCreateOmnichannelSettingMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest,
            com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
        getCreateOmnichannelSettingMethod;
    if ((getCreateOmnichannelSettingMethod =
            OmnichannelSettingsServiceGrpc.getCreateOmnichannelSettingMethod)
        == null) {
      synchronized (OmnichannelSettingsServiceGrpc.class) {
        if ((getCreateOmnichannelSettingMethod =
                OmnichannelSettingsServiceGrpc.getCreateOmnichannelSettingMethod)
            == null) {
          OmnichannelSettingsServiceGrpc.getCreateOmnichannelSettingMethod =
              getCreateOmnichannelSettingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .CreateOmnichannelSettingRequest,
                          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateOmnichannelSetting"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .CreateOmnichannelSettingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OmnichannelSettingsServiceMethodDescriptorSupplier(
                              "CreateOmnichannelSetting"))
                      .build();
        }
      }
    }
    return getCreateOmnichannelSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest,
          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
      getUpdateOmnichannelSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOmnichannelSetting",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest,
          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
      getUpdateOmnichannelSettingMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest,
            com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
        getUpdateOmnichannelSettingMethod;
    if ((getUpdateOmnichannelSettingMethod =
            OmnichannelSettingsServiceGrpc.getUpdateOmnichannelSettingMethod)
        == null) {
      synchronized (OmnichannelSettingsServiceGrpc.class) {
        if ((getUpdateOmnichannelSettingMethod =
                OmnichannelSettingsServiceGrpc.getUpdateOmnichannelSettingMethod)
            == null) {
          OmnichannelSettingsServiceGrpc.getUpdateOmnichannelSettingMethod =
              getUpdateOmnichannelSettingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .UpdateOmnichannelSettingRequest,
                          com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateOmnichannelSetting"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .UpdateOmnichannelSettingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OmnichannelSettingsServiceMethodDescriptorSupplier(
                              "UpdateOmnichannelSetting"))
                      .build();
        }
      }
    }
    return getUpdateOmnichannelSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest,
          com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse>
      getRequestInventoryVerificationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestInventoryVerification",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest.class,
      responseType =
          com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest,
          com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse>
      getRequestInventoryVerificationMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest,
            com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse>
        getRequestInventoryVerificationMethod;
    if ((getRequestInventoryVerificationMethod =
            OmnichannelSettingsServiceGrpc.getRequestInventoryVerificationMethod)
        == null) {
      synchronized (OmnichannelSettingsServiceGrpc.class) {
        if ((getRequestInventoryVerificationMethod =
                OmnichannelSettingsServiceGrpc.getRequestInventoryVerificationMethod)
            == null) {
          OmnichannelSettingsServiceGrpc.getRequestInventoryVerificationMethod =
              getRequestInventoryVerificationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .RequestInventoryVerificationRequest,
                          com.google.shopping.merchant.accounts.v1beta
                              .RequestInventoryVerificationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RequestInventoryVerification"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .RequestInventoryVerificationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .RequestInventoryVerificationResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OmnichannelSettingsServiceMethodDescriptorSupplier(
                              "RequestInventoryVerification"))
                      .build();
        }
      }
    }
    return getRequestInventoryVerificationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OmnichannelSettingsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceStub>() {
          @java.lang.Override
          public OmnichannelSettingsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OmnichannelSettingsServiceStub(channel, callOptions);
          }
        };
    return OmnichannelSettingsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static OmnichannelSettingsServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceBlockingV2Stub>() {
          @java.lang.Override
          public OmnichannelSettingsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OmnichannelSettingsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return OmnichannelSettingsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OmnichannelSettingsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceBlockingStub>() {
          @java.lang.Override
          public OmnichannelSettingsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OmnichannelSettingsServiceBlockingStub(channel, callOptions);
          }
        };
    return OmnichannelSettingsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OmnichannelSettingsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OmnichannelSettingsServiceFutureStub>() {
          @java.lang.Override
          public OmnichannelSettingsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OmnichannelSettingsServiceFutureStub(channel, callOptions);
          }
        };
    return OmnichannelSettingsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service facilitates the management of a merchant's omnichannel settings.
   * ## This API defines the following resource model:
   * [OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get the omnichannel settings for a given merchant.
     * </pre>
     */
    default void getOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOmnichannelSettingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all the omnichannel settings for a given merchant.
     * </pre>
     */
    default void listOmnichannelSettings(
        com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOmnichannelSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create the omnichannel settings for a given merchant.
     * </pre>
     */
    default void createOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOmnichannelSettingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the omnichannel setting for a given merchant in a given country.
     * </pre>
     */
    default void updateOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateOmnichannelSettingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests inventory verification for a given merchant in a given country.
     * </pre>
     */
    default void requestInventoryVerification(
        com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRequestInventoryVerificationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OmnichannelSettingsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's omnichannel settings.
   * ## This API defines the following resource model:
   * [OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
   * </pre>
   */
  public abstract static class OmnichannelSettingsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OmnichannelSettingsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OmnichannelSettingsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's omnichannel settings.
   * ## This API defines the following resource model:
   * [OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
   * </pre>
   */
  public static final class OmnichannelSettingsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OmnichannelSettingsServiceStub> {
    private OmnichannelSettingsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OmnichannelSettingsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OmnichannelSettingsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the omnichannel settings for a given merchant.
     * </pre>
     */
    public void getOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOmnichannelSettingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all the omnichannel settings for a given merchant.
     * </pre>
     */
    public void listOmnichannelSettings(
        com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOmnichannelSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create the omnichannel settings for a given merchant.
     * </pre>
     */
    public void createOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOmnichannelSettingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the omnichannel setting for a given merchant in a given country.
     * </pre>
     */
    public void updateOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOmnichannelSettingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests inventory verification for a given merchant in a given country.
     * </pre>
     */
    public void requestInventoryVerification(
        com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestInventoryVerificationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OmnichannelSettingsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's omnichannel settings.
   * ## This API defines the following resource model:
   * [OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
   * </pre>
   */
  public static final class OmnichannelSettingsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OmnichannelSettingsServiceBlockingV2Stub> {
    private OmnichannelSettingsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OmnichannelSettingsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OmnichannelSettingsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting getOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOmnichannelSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse
        listOmnichannelSettings(
            com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOmnichannelSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting createOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOmnichannelSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the omnichannel setting for a given merchant in a given country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting updateOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOmnichannelSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Requests inventory verification for a given merchant in a given country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse
        requestInventoryVerification(
            com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestInventoryVerificationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * OmnichannelSettingsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's omnichannel settings.
   * ## This API defines the following resource model:
   * [OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
   * </pre>
   */
  public static final class OmnichannelSettingsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OmnichannelSettingsServiceBlockingStub> {
    private OmnichannelSettingsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OmnichannelSettingsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OmnichannelSettingsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting getOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOmnichannelSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse
        listOmnichannelSettings(
            com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOmnichannelSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting createOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOmnichannelSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the omnichannel setting for a given merchant in a given country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting updateOmnichannelSetting(
        com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOmnichannelSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Requests inventory verification for a given merchant in a given country.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse
        requestInventoryVerification(
            com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestInventoryVerificationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * OmnichannelSettingsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's omnichannel settings.
   * ## This API defines the following resource model:
   * [OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
   * </pre>
   */
  public static final class OmnichannelSettingsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OmnichannelSettingsServiceFutureStub> {
    private OmnichannelSettingsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OmnichannelSettingsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OmnichannelSettingsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
        getOmnichannelSetting(
            com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOmnichannelSettingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>
        listOmnichannelSettings(
            com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOmnichannelSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create the omnichannel settings for a given merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
        createOmnichannelSetting(
            com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOmnichannelSettingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the omnichannel setting for a given merchant in a given country.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>
        updateOmnichannelSetting(
            com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOmnichannelSettingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Requests inventory verification for a given merchant in a given country.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse>
        requestInventoryVerification(
            com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestInventoryVerificationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_OMNICHANNEL_SETTING = 0;
  private static final int METHODID_LIST_OMNICHANNEL_SETTINGS = 1;
  private static final int METHODID_CREATE_OMNICHANNEL_SETTING = 2;
  private static final int METHODID_UPDATE_OMNICHANNEL_SETTING = 3;
  private static final int METHODID_REQUEST_INVENTORY_VERIFICATION = 4;

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
        case METHODID_GET_OMNICHANNEL_SETTING:
          serviceImpl.getOmnichannelSetting(
              (com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>)
                  responseObserver);
          break;
        case METHODID_LIST_OMNICHANNEL_SETTINGS:
          serviceImpl.listOmnichannelSettings(
              (com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_OMNICHANNEL_SETTING:
          serviceImpl.createOmnichannelSetting(
              (com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>)
                  responseObserver);
          break;
        case METHODID_UPDATE_OMNICHANNEL_SETTING:
          serviceImpl.updateOmnichannelSetting(
              (com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>)
                  responseObserver);
          break;
        case METHODID_REQUEST_INVENTORY_VERIFICATION:
          serviceImpl.requestInventoryVerification(
              (com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta
                          .RequestInventoryVerificationResponse>)
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
            getGetOmnichannelSettingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest,
                    com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>(
                    service, METHODID_GET_OMNICHANNEL_SETTING)))
        .addMethod(
            getListOmnichannelSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse>(
                    service, METHODID_LIST_OMNICHANNEL_SETTINGS)))
        .addMethod(
            getCreateOmnichannelSettingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest,
                    com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>(
                    service, METHODID_CREATE_OMNICHANNEL_SETTING)))
        .addMethod(
            getUpdateOmnichannelSettingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest,
                    com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting>(
                    service, METHODID_UPDATE_OMNICHANNEL_SETTING)))
        .addMethod(
            getRequestInventoryVerificationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta
                        .RequestInventoryVerificationRequest,
                    com.google.shopping.merchant.accounts.v1beta
                        .RequestInventoryVerificationResponse>(
                    service, METHODID_REQUEST_INVENTORY_VERIFICATION)))
        .build();
  }

  private abstract static class OmnichannelSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OmnichannelSettingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.OmnichannelSettingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OmnichannelSettingsService");
    }
  }

  private static final class OmnichannelSettingsServiceFileDescriptorSupplier
      extends OmnichannelSettingsServiceBaseDescriptorSupplier {
    OmnichannelSettingsServiceFileDescriptorSupplier() {}
  }

  private static final class OmnichannelSettingsServiceMethodDescriptorSupplier
      extends OmnichannelSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OmnichannelSettingsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OmnichannelSettingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OmnichannelSettingsServiceFileDescriptorSupplier())
                      .addMethod(getGetOmnichannelSettingMethod())
                      .addMethod(getListOmnichannelSettingsMethod())
                      .addMethod(getCreateOmnichannelSettingMethod())
                      .addMethod(getUpdateOmnichannelSettingMethod())
                      .addMethod(getRequestInventoryVerificationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
