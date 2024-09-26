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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to support
 * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/autofeedsettings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutofeedSettingsServiceGrpc {

  private AutofeedSettingsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.AutofeedSettingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
      getGetAutofeedSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutofeedSettings",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.AutofeedSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
      getGetAutofeedSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest,
            com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
        getGetAutofeedSettingsMethod;
    if ((getGetAutofeedSettingsMethod = AutofeedSettingsServiceGrpc.getGetAutofeedSettingsMethod)
        == null) {
      synchronized (AutofeedSettingsServiceGrpc.class) {
        if ((getGetAutofeedSettingsMethod =
                AutofeedSettingsServiceGrpc.getGetAutofeedSettingsMethod)
            == null) {
          AutofeedSettingsServiceGrpc.getGetAutofeedSettingsMethod =
              getGetAutofeedSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest,
                          com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAutofeedSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetAutofeedSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.AutofeedSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutofeedSettingsServiceMethodDescriptorSupplier(
                              "GetAutofeedSettings"))
                      .build();
        }
      }
    }
    return getGetAutofeedSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
      getUpdateAutofeedSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAutofeedSettings",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.AutofeedSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
      getUpdateAutofeedSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest,
            com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
        getUpdateAutofeedSettingsMethod;
    if ((getUpdateAutofeedSettingsMethod =
            AutofeedSettingsServiceGrpc.getUpdateAutofeedSettingsMethod)
        == null) {
      synchronized (AutofeedSettingsServiceGrpc.class) {
        if ((getUpdateAutofeedSettingsMethod =
                AutofeedSettingsServiceGrpc.getUpdateAutofeedSettingsMethod)
            == null) {
          AutofeedSettingsServiceGrpc.getUpdateAutofeedSettingsMethod =
              getUpdateAutofeedSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest,
                          com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAutofeedSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .UpdateAutofeedSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.AutofeedSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutofeedSettingsServiceMethodDescriptorSupplier(
                              "UpdateAutofeedSettings"))
                      .build();
        }
      }
    }
    return getUpdateAutofeedSettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AutofeedSettingsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutofeedSettingsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutofeedSettingsServiceStub>() {
          @java.lang.Override
          public AutofeedSettingsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutofeedSettingsServiceStub(channel, callOptions);
          }
        };
    return AutofeedSettingsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutofeedSettingsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutofeedSettingsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutofeedSettingsServiceBlockingStub>() {
          @java.lang.Override
          public AutofeedSettingsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutofeedSettingsServiceBlockingStub(channel, callOptions);
          }
        };
    return AutofeedSettingsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AutofeedSettingsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutofeedSettingsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutofeedSettingsServiceFutureStub>() {
          @java.lang.Override
          public AutofeedSettingsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutofeedSettingsServiceFutureStub(channel, callOptions);
          }
        };
    return AutofeedSettingsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support
   * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the autofeed settings of an account.
     * </pre>
     */
    default void getAutofeedSettings(
        com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAutofeedSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the autofeed settings of an account.
     * </pre>
     */
    default void updateAutofeedSettings(
        com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAutofeedSettingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AutofeedSettingsService.
   *
   * <pre>
   * Service to support
   * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
   * </pre>
   */
  public abstract static class AutofeedSettingsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AutofeedSettingsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AutofeedSettingsService.
   *
   * <pre>
   * Service to support
   * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
   * </pre>
   */
  public static final class AutofeedSettingsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AutofeedSettingsServiceStub> {
    private AutofeedSettingsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutofeedSettingsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutofeedSettingsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the autofeed settings of an account.
     * </pre>
     */
    public void getAutofeedSettings(
        com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAutofeedSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the autofeed settings of an account.
     * </pre>
     */
    public void updateAutofeedSettings(
        com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAutofeedSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AutofeedSettingsService.
   *
   * <pre>
   * Service to support
   * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
   * </pre>
   */
  public static final class AutofeedSettingsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AutofeedSettingsServiceBlockingStub> {
    private AutofeedSettingsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutofeedSettingsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutofeedSettingsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the autofeed settings of an account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.AutofeedSettings getAutofeedSettings(
        com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutofeedSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the autofeed settings of an account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.AutofeedSettings updateAutofeedSettings(
        com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAutofeedSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AutofeedSettingsService.
   *
   * <pre>
   * Service to support
   * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
   * </pre>
   */
  public static final class AutofeedSettingsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AutofeedSettingsServiceFutureStub> {
    private AutofeedSettingsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutofeedSettingsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutofeedSettingsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the autofeed settings of an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
        getAutofeedSettings(
            com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAutofeedSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the autofeed settings of an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>
        updateAutofeedSettings(
            com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAutofeedSettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AUTOFEED_SETTINGS = 0;
  private static final int METHODID_UPDATE_AUTOFEED_SETTINGS = 1;

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
        case METHODID_GET_AUTOFEED_SETTINGS:
          serviceImpl.getAutofeedSettings(
              (com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUTOFEED_SETTINGS:
          serviceImpl.updateAutofeedSettings(
              (com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>)
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
            getGetAutofeedSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetAutofeedSettingsRequest,
                    com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>(
                    service, METHODID_GET_AUTOFEED_SETTINGS)))
        .addMethod(
            getUpdateAutofeedSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateAutofeedSettingsRequest,
                    com.google.shopping.merchant.accounts.v1beta.AutofeedSettings>(
                    service, METHODID_UPDATE_AUTOFEED_SETTINGS)))
        .build();
  }

  private abstract static class AutofeedSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutofeedSettingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.AutofeedSettingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutofeedSettingsService");
    }
  }

  private static final class AutofeedSettingsServiceFileDescriptorSupplier
      extends AutofeedSettingsServiceBaseDescriptorSupplier {
    AutofeedSettingsServiceFileDescriptorSupplier() {}
  }

  private static final class AutofeedSettingsServiceMethodDescriptorSupplier
      extends AutofeedSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AutofeedSettingsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AutofeedSettingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AutofeedSettingsServiceFileDescriptorSupplier())
                      .addMethod(getGetAutofeedSettingsMethod())
                      .addMethod(getUpdateAutofeedSettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
